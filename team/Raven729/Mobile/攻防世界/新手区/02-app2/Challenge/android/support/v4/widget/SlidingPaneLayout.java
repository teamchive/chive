package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect;

        AccessibilityDelegate(SlidingPaneLayout arg2) {
            SlidingPaneLayout.this = arg2;
            super();
            this.mTmpRect = new Rect();
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat arg2, AccessibilityNodeInfoCompat arg3) {
            Rect v0 = this.mTmpRect;
            arg3.getBoundsInParent(v0);
            arg2.setBoundsInParent(v0);
            arg3.getBoundsInScreen(v0);
            arg2.setBoundsInScreen(v0);
            arg2.setVisibleToUser(arg3.isVisibleToUser());
            arg2.setPackageName(arg3.getPackageName());
            arg2.setClassName(arg3.getClassName());
            arg2.setContentDescription(arg3.getContentDescription());
            arg2.setEnabled(arg3.isEnabled());
            arg2.setClickable(arg3.isClickable());
            arg2.setFocusable(arg3.isFocusable());
            arg2.setFocused(arg3.isFocused());
            arg2.setAccessibilityFocused(arg3.isAccessibilityFocused());
            arg2.setSelected(arg3.isSelected());
            arg2.setLongClickable(arg3.isLongClickable());
            arg2.addAction(arg3.getActions());
            arg2.setMovementGranularities(arg3.getMovementGranularities());
        }

        public boolean filter(View arg2) {
            return SlidingPaneLayout.this.isDimmed(arg2);
        }

        public void onInitializeAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
            super.onInitializeAccessibilityEvent(arg2, arg3);
            arg3.setClassName(SlidingPaneLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View arg5, AccessibilityNodeInfoCompat arg6) {
            AccessibilityNodeInfoCompat v0 = AccessibilityNodeInfoCompat.obtain(arg6);
            super.onInitializeAccessibilityNodeInfo(arg5, v0);
            this.copyNodeInfoNoChildren(arg6, v0);
            v0.recycle();
            arg6.setClassName(SlidingPaneLayout.class.getName());
            arg6.setSource(arg5);
            ViewParent v0_1 = ViewCompat.getParentForAccessibility(arg5);
            if((v0_1 instanceof View)) {
                arg6.setParent(((View)v0_1));
            }

            int v1 = SlidingPaneLayout.this.getChildCount();
            int v0_2;
            for(v0_2 = 0; v0_2 < v1; ++v0_2) {
                View v2 = SlidingPaneLayout.this.getChildAt(v0_2);
                if(!this.filter(v2) && v2.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(v2, 1);
                    arg6.addChild(v2);
                }
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup arg2, View arg3, AccessibilityEvent arg4) {
            boolean v0 = !this.filter(arg3) ? super.onRequestSendAccessibilityEvent(arg2, arg3, arg4) : false;
            return v0;
        }
    }

    class DisableLayerRunnable implements Runnable {
        final View mChildView;

        DisableLayerRunnable(SlidingPaneLayout arg1, View arg2) {
            SlidingPaneLayout.this = arg1;
            super();
            this.mChildView = arg2;
        }

        public void run() {
            if(this.mChildView.getParent() == SlidingPaneLayout.this) {
                ViewCompat.setLayerType(this.mChildView, 0, null);
                SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
            }

            SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    class DragHelperCallback extends Callback {
        DragHelperCallback(SlidingPaneLayout arg1) {
            SlidingPaneLayout.this = arg1;
            super();
        }

        public int clampViewPositionHorizontal(View arg4, int arg5, int arg6) {
            int v0_1;
            ViewGroup$LayoutParams v0 = SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            if(SlidingPaneLayout.this.isLayoutRtlSupport()) {
                v0_1 = SlidingPaneLayout.this.getWidth() - (((LayoutParams)v0).rightMargin + SlidingPaneLayout.this.getPaddingRight() + SlidingPaneLayout.this.mSlideableView.getWidth());
                v0_1 = Math.max(Math.min(arg5, v0_1), v0_1 - SlidingPaneLayout.this.mSlideRange);
            }
            else {
                v0_1 = ((LayoutParams)v0).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                v0_1 = Math.min(Math.max(arg5, v0_1), SlidingPaneLayout.this.mSlideRange + v0_1);
            }

            return v0_1;
        }

        public int clampViewPositionVertical(View arg2, int arg3, int arg4) {
            return arg2.getTop();
        }

        public int getViewHorizontalDragRange(View arg2) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        public void onEdgeDragStarted(int arg3, int arg4) {
            SlidingPaneLayout.this.mDragHelper.captureChildView(SlidingPaneLayout.this.mSlideableView, arg4);
        }

        public void onViewCaptured(View arg2, int arg3) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        public void onViewDragStateChanged(int arg3) {
            if(SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
                if(SlidingPaneLayout.this.mSlideOffset == 0f) {
                    SlidingPaneLayout.this.updateObscuredViewsVisibility(SlidingPaneLayout.this.mSlideableView);
                    SlidingPaneLayout.this.dispatchOnPanelClosed(SlidingPaneLayout.this.mSlideableView);
                    SlidingPaneLayout.this.mPreservedOpenState = false;
                }
                else {
                    SlidingPaneLayout.this.dispatchOnPanelOpened(SlidingPaneLayout.this.mSlideableView);
                    SlidingPaneLayout.this.mPreservedOpenState = true;
                }
            }
        }

        public void onViewPositionChanged(View arg2, int arg3, int arg4, int arg5, int arg6) {
            SlidingPaneLayout.this.onPanelDragged(arg3);
            SlidingPaneLayout.this.invalidate();
        }

        public void onViewReleased(View arg5, float arg6, float arg7) {
            int v0_1;
            float v3 = 0.5f;
            ViewGroup$LayoutParams v0 = arg5.getLayoutParams();
            if(SlidingPaneLayout.this.isLayoutRtlSupport()) {
                v0_1 = ((LayoutParams)v0).rightMargin + SlidingPaneLayout.this.getPaddingRight();
                if(arg6 < 0f || arg6 == 0f && SlidingPaneLayout.this.mSlideOffset > v3) {
                    v0_1 += SlidingPaneLayout.this.mSlideRange;
                }

                v0_1 = SlidingPaneLayout.this.getWidth() - v0_1 - SlidingPaneLayout.this.mSlideableView.getWidth();
            }
            else {
                v0_1 = ((LayoutParams)v0).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if(arg6 <= 0f) {
                    if(arg6 != 0f) {
                    }
                    else if(SlidingPaneLayout.this.mSlideOffset > v3) {
                        goto label_41;
                    }

                    goto label_25;
                }

            label_41:
                v0_1 += SlidingPaneLayout.this.mSlideRange;
            }

        label_25:
            SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(v0_1, arg5.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean tryCaptureView(View arg2, int arg3) {
            boolean v0 = SlidingPaneLayout.this.mIsUnableToDrag ? false : arg2.getLayoutParams().slideable;
            return v0;
        }
    }

    public class LayoutParams extends ViewGroup$MarginLayoutParams {
        private static final int[] ATTRS;
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight;

        static {
            LayoutParams.ATTRS = new int[]{0x1010181};
        }

        public LayoutParams() {
            super(-1, -1);
            this.weight = 0f;
        }

        public LayoutParams(Context arg4, AttributeSet arg5) {
            super(arg4, arg5);
            this.weight = 0f;
            TypedArray v0 = arg4.obtainStyledAttributes(arg5, LayoutParams.ATTRS);
            this.weight = v0.getFloat(0, 0f);
            v0.recycle();
        }

        public LayoutParams(ViewGroup$MarginLayoutParams arg2) {
            super(arg2);
            this.weight = 0f;
        }

        public LayoutParams(ViewGroup$LayoutParams arg2) {
            super(arg2);
            this.weight = 0f;
        }

        public LayoutParams(int arg2, int arg3) {
            super(arg2, arg3);
            this.weight = 0f;
        }

        public LayoutParams(LayoutParams arg2) {
            super(((ViewGroup$MarginLayoutParams)arg2));
            this.weight = 0f;
            this.weight = arg2.weight;
        }
    }

    public interface PanelSlideListener {
        void onPanelClosed(View arg1);

        void onPanelOpened(View arg1);

        void onPanelSlide(View arg1, float arg2);
    }

    class SavedState extends AbsSavedState {
        final class android.support.v4.widget.SlidingPaneLayout$SavedState$1 implements ParcelableCompatCreatorCallbacks {
            android.support.v4.widget.SlidingPaneLayout$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg2, ClassLoader arg3) {
                return new SavedState(arg2, arg3);
            }

            public Object createFromParcel(Parcel arg2, ClassLoader arg3) {
                return this.createFromParcel(arg2, arg3);
            }

            public SavedState[] newArray(int arg2) {
                return new SavedState[arg2];
            }

            public Object[] newArray(int arg2) {
                return this.newArray(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR;
        boolean isOpen;

        static {
            SavedState.CREATOR = ParcelableCompat.newCreator(new android.support.v4.widget.SlidingPaneLayout$SavedState$1());
        }

        SavedState(Parcelable arg1) {
            super(arg1);
        }

        SavedState(Parcel arg2, ClassLoader arg3) {
            super(arg2, arg3);
            boolean v0 = arg2.readInt() != 0 ? true : false;
            this.isOpen = v0;
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            super.writeToParcel(arg2, arg3);
            int v0 = this.isOpen ? 1 : 0;
            arg2.writeInt(v0);
        }
    }

    public class SimplePanelSlideListener implements PanelSlideListener {
        public SimplePanelSlideListener() {
            super();
        }

        public void onPanelClosed(View arg1) {
        }

        public void onPanelOpened(View arg1) {
        }

        public void onPanelSlide(View arg1, float arg2) {
        }
    }

    interface SlidingPanelLayoutImpl {
        void invalidateChildRegion(SlidingPaneLayout arg1, View arg2);
    }

    class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl {
        SlidingPanelLayoutImplBase() {
            super();
        }

        public void invalidateChildRegion(SlidingPaneLayout arg5, View arg6) {
            ViewCompat.postInvalidateOnAnimation(((View)arg5), arg6.getLeft(), arg6.getTop(), arg6.getRight(), arg6.getBottom());
        }
    }

    class SlidingPanelLayoutImplJB extends SlidingPanelLayoutImplBase {
        private Method mGetDisplayList;
        private Field mRecreateDisplayList;

        SlidingPanelLayoutImplJB() {
            super();
            try {
                this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", null);
            }
            catch(NoSuchMethodException v0) {
                Log.e("SlidingPaneLayout", "Couldn\'t fetch getDisplayList method; dimming won\'t work right.", ((Throwable)v0));
            }

            try {
                this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                this.mRecreateDisplayList.setAccessible(true);
            }
            catch(NoSuchFieldException v0_1) {
                Log.e("SlidingPaneLayout", "Couldn\'t fetch mRecreateDisplayList field; dimming will be slow.", ((Throwable)v0_1));
            }
        }

        public void invalidateChildRegion(SlidingPaneLayout arg4, View arg5) {
            if(this.mGetDisplayList != null && this.mRecreateDisplayList != null) {
                try {
                    this.mRecreateDisplayList.setBoolean(arg5, true);
                    this.mGetDisplayList.invoke(arg5, null);
                }
                catch(Exception v0) {
                    Log.e("SlidingPaneLayout", "Error refreshing display list state", ((Throwable)v0));
                }

                super.invalidateChildRegion(arg4, arg5);
            }
            else {
                arg5.invalidate();
            }
        }
    }

    class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase {
        SlidingPanelLayoutImplJBMR1() {
            super();
        }

        public void invalidateChildRegion(SlidingPaneLayout arg2, View arg3) {
            ViewCompat.setLayerPaint(arg3, arg3.getLayoutParams().dimPaint);
        }
    }

    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 0x20;
    static final SlidingPanelLayoutImpl IMPL = null;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    final ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    final ArrayList mPostedRunnables;
    boolean mPreservedOpenState;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    float mSlideOffset;
    int mSlideRange;
    View mSlideableView;
    private int mSliderFadeColor;
    private final Rect mTmpRect;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 17) {
            SlidingPaneLayout.IMPL = new SlidingPanelLayoutImplJBMR1();
        }
        else if(v0 >= 16) {
            SlidingPaneLayout.IMPL = new SlidingPanelLayoutImplJB();
        }
        else {
            SlidingPaneLayout.IMPL = new SlidingPanelLayoutImplBase();
        }
    }

    public SlidingPaneLayout(Context arg2) {
        this(arg2, null);
    }

    public SlidingPaneLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public SlidingPaneLayout(Context arg5, AttributeSet arg6, int arg7) {
        super(arg5, arg6, arg7);
        this.mSliderFadeColor = -858993460;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList();
        float v0 = arg5.getResources().getDisplayMetrics().density;
        this.mOverhangSize = ((int)(32f * v0 + 0.5f));
        ViewConfiguration.get(arg5);
        this.setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(((View)this), new AccessibilityDelegate(this));
        ViewCompat.setImportantForAccessibility(((View)this), 1);
        this.mDragHelper = ViewDragHelper.create(((ViewGroup)this), 0.5f, new DragHelperCallback(this));
        this.mDragHelper.setMinVelocity(v0 * 400f);
    }

    protected boolean canScroll(View arg11, boolean arg12, int arg13, int arg14, int arg15) {
        boolean v2 = true;
        if((arg11 instanceof ViewGroup)) {
            View v6 = arg11;
            int v8 = arg11.getScrollX();
            int v9 = arg11.getScrollY();
            int v7 = ((ViewGroup)v6).getChildCount() - 1;
            while(true) {
                if(v7 >= 0) {
                    View v1 = ((ViewGroup)v6).getChildAt(v7);
                    if(arg14 + v8 >= v1.getLeft() && arg14 + v8 < v1.getRight() && arg15 + v9 >= v1.getTop() && arg15 + v9 < v1.getBottom() && (this.canScroll(v1, true, arg13, arg14 + v8 - v1.getLeft(), arg15 + v9 - v1.getTop()))) {
                        return v2;
                    }

                    --v7;
                    continue;
                }
                else {
                    goto label_37;
                }
            }
        }
        else {
        label_37:
            if(arg12) {
                if(!this.isLayoutRtlSupport()) {
                    arg13 = -arg13;
                }

                if(ViewCompat.canScrollHorizontally(arg11, arg13)) {
                    return v2;
                }
            }

            v2 = false;
        }

        return v2;
    }

    @Deprecated public boolean canSlide() {
        return this.mCanSlide;
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg2) {
        boolean v0 = !(arg2 instanceof LayoutParams) || !super.checkLayoutParams(arg2) ? false : true;
        return v0;
    }

    private boolean closePane(View arg3, int arg4) {
        boolean v0 = false;
        if((this.mFirstLayout) || (this.smoothSlideTo(0f, arg4))) {
            this.mPreservedOpenState = false;
            v0 = true;
        }

        return v0;
    }

    public boolean closePane() {
        return this.closePane(this.mSlideableView, 0);
    }

    public void computeScroll() {
        if(this.mDragHelper.continueSettling(true)) {
            if(!this.mCanSlide) {
                this.mDragHelper.abort();
            }
            else {
                ViewCompat.postInvalidateOnAnimation(((View)this));
            }
        }
    }

    private void dimChildView(View arg7, float arg8, int arg9) {
        int v5 = 2;
        ViewGroup$LayoutParams v0 = arg7.getLayoutParams();
        if(arg8 <= 0f || arg9 == 0) {
            if(ViewCompat.getLayerType(arg7) == 0) {
                return;
            }

            if(((LayoutParams)v0).dimPaint != null) {
                ((LayoutParams)v0).dimPaint.setColorFilter(null);
            }

            DisableLayerRunnable v0_1 = new DisableLayerRunnable(this, arg7);
            this.mPostedRunnables.add(v0_1);
            ViewCompat.postOnAnimation(((View)this), ((Runnable)v0_1));
        }
        else {
            int v1 = (((int)((((float)((0xFF000000 & arg9) >>> 24))) * arg8))) << 24 | 0xFFFFFF & arg9;
            if(((LayoutParams)v0).dimPaint == null) {
                ((LayoutParams)v0).dimPaint = new Paint();
            }

            ((LayoutParams)v0).dimPaint.setColorFilter(new PorterDuffColorFilter(v1, PorterDuff$Mode.SRC_OVER));
            if(ViewCompat.getLayerType(arg7) != v5) {
                ViewCompat.setLayerType(arg7, v5, ((LayoutParams)v0).dimPaint);
            }

            this.invalidateChildRegion(arg7);
        }
    }

    void dispatchOnPanelClosed(View arg2) {
        if(this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelClosed(arg2);
        }

        this.sendAccessibilityEvent(0x20);
    }

    void dispatchOnPanelOpened(View arg2) {
        if(this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelOpened(arg2);
        }

        this.sendAccessibilityEvent(0x20);
    }

    void dispatchOnPanelSlide(View arg3) {
        if(this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelSlide(arg3, this.mSlideOffset);
        }
    }

    public void draw(Canvas arg7) {
        int v1_1;
        int v2;
        super.draw(arg7);
        Drawable v0 = this.isLayoutRtlSupport() ? this.mShadowDrawableRight : this.mShadowDrawableLeft;
        View v1 = this.getChildCount() > 1 ? this.getChildAt(1) : null;
        if(v1 != null && v0 != null) {
            int v3 = v1.getTop();
            int v4 = v1.getBottom();
            int v5 = v0.getIntrinsicWidth();
            if(this.isLayoutRtlSupport()) {
                v2 = v1.getRight();
                v1_1 = v2 + v5;
            }
            else {
                v1_1 = v1.getLeft();
                v2 = v1_1 - v5;
            }

            v0.setBounds(v2, v3, v1_1, v4);
            v0.draw(arg7);
        }
    }

    protected boolean drawChild(Canvas arg8, View arg9, long arg10) {
        boolean v0_1;
        ViewGroup$LayoutParams v0 = arg9.getLayoutParams();
        int v2 = arg8.save(2);
        if((this.mCanSlide) && !((LayoutParams)v0).slideable && this.mSlideableView != null) {
            arg8.getClipBounds(this.mTmpRect);
            if(this.isLayoutRtlSupport()) {
                this.mTmpRect.left = Math.max(this.mTmpRect.left, this.mSlideableView.getRight());
            }
            else {
                this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
            }

            arg8.clipRect(this.mTmpRect);
        }

        if(Build$VERSION.SDK_INT >= 11) {
            v0_1 = super.drawChild(arg8, arg9, arg10);
        }
        else {
            if((((LayoutParams)v0).dimWhenOffset) && this.mSlideOffset > 0f) {
                if(!arg9.isDrawingCacheEnabled()) {
                    arg9.setDrawingCacheEnabled(true);
                }

                Bitmap v3 = arg9.getDrawingCache();
                if(v3 != null) {
                    arg8.drawBitmap(v3, ((float)arg9.getLeft()), ((float)arg9.getTop()), ((LayoutParams)v0).dimPaint);
                    v0_1 = false;
                    goto label_27;
                }

                Log.e("SlidingPaneLayout", "drawChild: child view " + arg9 + " returned null drawing cache");
                v0_1 = super.drawChild(arg8, arg9, arg10);
                goto label_27;
            }

            if(arg9.isDrawingCacheEnabled()) {
                arg9.setDrawingCacheEnabled(false);
            }

            v0_1 = super.drawChild(arg8, arg9, arg10);
        }

    label_27:
        arg8.restoreToCount(v2);
        return v0_1;
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg3) {
        return new LayoutParams(this.getContext(), arg3);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg2) {
        LayoutParams v0 = (arg2 instanceof ViewGroup$MarginLayoutParams) ? new LayoutParams(((ViewGroup$MarginLayoutParams)arg2)) : new LayoutParams(arg2);
        return ((ViewGroup$LayoutParams)v0);
    }

    @ColorInt public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @ColorInt public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    void invalidateChildRegion(View arg2) {
        SlidingPaneLayout.IMPL.invalidateChildRegion(this, arg2);
    }

    boolean isDimmed(View arg4) {
        boolean v1 = false;
        if(arg4 != null) {
            ViewGroup$LayoutParams v0 = arg4.getLayoutParams();
            boolean v0_1 = !this.mCanSlide || !((LayoutParams)v0).dimWhenOffset || this.mSlideOffset <= 0f ? false : true;
            v1 = v0_1;
        }

        return v1;
    }

    boolean isLayoutRtlSupport() {
        boolean v0 = true;
        if(ViewCompat.getLayoutDirection(((View)this)) != 1) {
            v0 = false;
        }

        return v0;
    }

    public boolean isOpen() {
        boolean v0 = !this.mCanSlide || this.mSlideOffset == 1f ? true : false;
        return v0;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int v2 = this.mPostedRunnables.size();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            this.mPostedRunnables.get(v1).run();
        }

        this.mPostedRunnables.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent arg8) {
        int v0_3;
        float v3_1;
        float v0_2;
        boolean v2 = false;
        int v3 = MotionEventCompat.getActionMasked(arg8);
        if(!this.mCanSlide && v3 == 0 && this.getChildCount() > 1) {
            View v0 = this.getChildAt(1);
            if(v0 != null) {
                boolean v0_1 = !this.mDragHelper.isViewUnder(v0, ((int)arg8.getX()), ((int)arg8.getY())) ? true : false;
                this.mPreservedOpenState = v0_1;
            }
        }

        if(this.mCanSlide) {
            if((this.mIsUnableToDrag) && v3 != 0) {
                goto label_24;
            }

            if(v3 != 3 && v3 != 1) {
                switch(v3) {
                    case 0: {
                        this.mIsUnableToDrag = false;
                        v0_2 = arg8.getX();
                        v3_1 = arg8.getY();
                        this.mInitialMotionX = v0_2;
                        this.mInitialMotionY = v3_1;
                        if(!this.mDragHelper.isViewUnder(this.mSlideableView, ((int)v0_2), ((int)v3_1))) {
                            goto label_37;
                        }
                        else if(this.isDimmed(this.mSlideableView)) {
                            v0_3 = 1;
                            goto label_38;
                        }
                        else {
                            goto label_37;
                        }
                    }
                    case 2: {
                        v0_2 = arg8.getX();
                        v3_1 = arg8.getY();
                        v0_2 = Math.abs(v0_2 - this.mInitialMotionX);
                        v3_1 = Math.abs(v3_1 - this.mInitialMotionY);
                        if(v0_2 <= (((float)this.mDragHelper.getTouchSlop()))) {
                            goto label_37;
                        }
                        else if(v3_1 > v0_2) {
                            this.mDragHelper.cancel();
                            this.mIsUnableToDrag = true;
                            return v2;
                        }
                        else {
                            goto label_37;
                        }
                    }
                }

            label_37:
                v0_3 = 0;
            label_38:
                if(!this.mDragHelper.shouldInterceptTouchEvent(arg8) && v0_3 == 0) {
                    return v2;
                }

                return true;
            }

            this.mDragHelper.cancel();
        }
        else {
        label_24:
            this.mDragHelper.cancel();
            v2 = super.onInterceptTouchEvent(arg8);
        }

        return v2;
    }

    protected void onLayout(boolean arg18, int arg19, int arg20, int arg21, int arg22) {
        int v4_1;
        int v3;
        int v1_1;
        boolean v9 = this.isLayoutRtlSupport();
        if(v9) {
            this.mDragHelper.setEdgeTrackingEnabled(2);
        }
        else {
            this.mDragHelper.setEdgeTrackingEnabled(1);
        }

        int v10 = arg21 - arg19;
        int v5 = v9 ? this.getPaddingRight() : this.getPaddingLeft();
        int v2 = v9 ? this.getPaddingLeft() : this.getPaddingRight();
        int v11 = this.getPaddingTop();
        int v12 = this.getChildCount();
        if(this.mFirstLayout) {
            float v1 = !this.mCanSlide || !this.mPreservedOpenState ? 0f : 1f;
            this.mSlideOffset = v1;
        }

        int v8 = 0;
        int v6;
        for(v6 = v5; v8 < v12; v6 = v3) {
            View v13 = this.getChildAt(v8);
            if(v13.getVisibility() == 8) {
                v1_1 = v5;
                v3 = v6;
            }
            else {
                ViewGroup$LayoutParams v1_2 = v13.getLayoutParams();
                int v14 = v13.getMeasuredWidth();
                if(((LayoutParams)v1_2).slideable) {
                    int v15 = Math.min(v5, v10 - v2 - this.mOverhangSize) - v6 - (((LayoutParams)v1_2).leftMargin + ((LayoutParams)v1_2).rightMargin);
                    this.mSlideRange = v15;
                    v3 = v9 ? ((LayoutParams)v1_2).rightMargin : ((LayoutParams)v1_2).leftMargin;
                    boolean v4 = v6 + v3 + v15 + v14 / 2 > v10 - v2 ? true : false;
                    ((LayoutParams)v1_2).dimWhenOffset = v4;
                    v1_1 = ((int)((((float)v15)) * this.mSlideOffset));
                    v4_1 = v6 + (v3 + v1_1);
                    this.mSlideOffset = (((float)v1_1)) / (((float)this.mSlideRange));
                    v1_1 = 0;
                }
                else {
                    if((this.mCanSlide) && this.mParallaxBy != 0) {
                        v1_1 = ((int)((1f - this.mSlideOffset) * (((float)this.mParallaxBy))));
                        v4_1 = v5;
                        goto label_97;
                    }

                    v1_1 = 0;
                    v4_1 = v5;
                }

            label_97:
                if(v9) {
                    v3 = v10 - v4_1 + v1_1;
                    v1_1 = v3 - v14;
                }
                else {
                    v1_1 = v4_1 - v1_1;
                    v3 = v1_1 + v14;
                }

                v13.layout(v1_1, v11, v3, v13.getMeasuredHeight() + v11);
                v1_1 = v13.getWidth() + v5;
                v3 = v4_1;
            }

            ++v8;
            v5 = v1_1;
        }

        if(this.mFirstLayout) {
            if(this.mCanSlide) {
                if(this.mParallaxBy != 0) {
                    this.parallaxOtherViews(this.mSlideOffset);
                }

                if(!this.mSlideableView.getLayoutParams().dimWhenOffset) {
                    goto label_161;
                }

                this.dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
            }
            else {
                for(v1_1 = 0; v1_1 < v12; ++v1_1) {
                    this.dimChildView(this.getChildAt(v1_1), 0f, this.mSliderFadeColor);
                }
            }

        label_161:
            this.updateObscuredViewsVisibility(this.mSlideableView);
        }

        this.mFirstLayout = false;
    }

    protected void onMeasure(int arg18, int arg19) {
        int v5;
        float v4_1;
        ViewGroup$LayoutParams v1_1;
        int v12;
        int v10;
        int v4 = View$MeasureSpec.getMode(arg18);
        int v3 = View$MeasureSpec.getSize(arg18);
        int v2 = View$MeasureSpec.getMode(arg19);
        int v1 = View$MeasureSpec.getSize(arg19);
        if(v4 != 0x40000000) {
            if(!this.isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            else if(v4 == 0x80000000) {
                v10 = v2;
                v12 = v3;
                v3 = v1;
            }
            else if(v4 == 0) {
                v10 = v2;
                v12 = 300;
                v3 = v1;
            }
            else {
                goto label_302;
            }
        }
        else if(v2 != 0) {
        label_302:
            v10 = v2;
            v12 = v3;
            v3 = v1;
        }
        else if(!this.isInEditMode()) {
            throw new IllegalStateException("Height must not be UNSPECIFIED");
        }
        else if(v2 == 0) {
            v10 = 0x80000000;
            v12 = v3;
            v3 = 300;
        }
        else {
            goto label_302;
        }

        v1 = -1;
        switch(v10) {
            case 1073741824: {
                v1 = v3 - this.getPaddingTop() - this.getPaddingBottom();
                v2 = v1;
                break;
            }
            case -2147483648: {
                v1 = 0;
                v2 = v3 - this.getPaddingTop() - this.getPaddingBottom();
                break;
            }
            default: {
                int v16 = v1;
                v1 = 0;
                v2 = v16;
                break;
            }
        }

        int v7 = 0;
        int v11 = v12 - this.getPaddingLeft() - this.getPaddingRight();
        int v13 = this.getChildCount();
        if(v13 > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }

        this.mSlideableView = null;
        int v9 = 0;
        int v6 = v11;
        int v8 = v1;
        float v3_1 = 0f;
        while(v9 < v13) {
            View v14 = this.getChildAt(v9);
            v1_1 = v14.getLayoutParams();
            if(v14.getVisibility() == 8) {
                ((LayoutParams)v1_1).dimWhenOffset = false;
                v1 = v6;
                v4_1 = v3_1;
                v5 = v8;
                v3 = v7;
            }
            else {
                if(((LayoutParams)v1_1).weight > 0f) {
                    v3_1 += ((LayoutParams)v1_1).weight;
                    if(((LayoutParams)v1_1).width == 0) {
                        v1 = v6;
                        v4_1 = v3_1;
                        v5 = v8;
                        v3 = v7;
                        goto label_52;
                    }
                }

                v4 = ((LayoutParams)v1_1).leftMargin + ((LayoutParams)v1_1).rightMargin;
                if(((LayoutParams)v1_1).width == -2) {
                    v4 = View$MeasureSpec.makeMeasureSpec(v11 - v4, 0x80000000);
                }
                else if(((LayoutParams)v1_1).width == -1) {
                    v4 = View$MeasureSpec.makeMeasureSpec(v11 - v4, 0x40000000);
                }
                else {
                    v4 = View$MeasureSpec.makeMeasureSpec(((LayoutParams)v1_1).width, 0x40000000);
                }

                if(((LayoutParams)v1_1).height == -2) {
                    v5 = View$MeasureSpec.makeMeasureSpec(v2, 0x80000000);
                }
                else if(((LayoutParams)v1_1).height == -1) {
                    v5 = View$MeasureSpec.makeMeasureSpec(v2, 0x40000000);
                }
                else {
                    v5 = View$MeasureSpec.makeMeasureSpec(((LayoutParams)v1_1).height, 0x40000000);
                }

                v14.measure(v4, v5);
                v4 = v14.getMeasuredWidth();
                v5 = v14.getMeasuredHeight();
                if(v10 == 0x80000000 && v5 > v8) {
                    v8 = Math.min(v5, v2);
                }

                v5 = v6 - v4;
                boolean v4_2 = v5 < 0 ? true : false;
                ((LayoutParams)v1_1).slideable = v4_2;
                v4 = (((int)v4_2)) | v7;
                if(((LayoutParams)v1_1).slideable) {
                    this.mSlideableView = v14;
                }

                v1 = v5;
                v5 = v8;
                float v16_1 = v3_1;
                v3 = v4;
                v4_1 = v16_1;
            }

        label_52:
            ++v9;
            v7 = v3;
            v8 = v5;
            v3_1 = v4_1;
            v6 = v1;
        }

        if(v7 != 0 || v3_1 > 0f) {
            int v14_1 = v11 - this.mOverhangSize;
            for(v10 = 0; v10 < v13; ++v10) {
                View v15 = this.getChildAt(v10);
                if(v15.getVisibility() != 8) {
                    v1_1 = v15.getLayoutParams();
                    if(v15.getVisibility() != 8) {
                        v9 = ((LayoutParams)v1_1).width != 0 || ((LayoutParams)v1_1).weight <= 0f ? 0 : 1;
                        v5 = v9 != 0 ? 0 : v15.getMeasuredWidth();
                        if(v7 != 0 && v15 != this.mSlideableView) {
                            if(((LayoutParams)v1_1).width < 0) {
                                if(v5 <= v14_1 && ((LayoutParams)v1_1).weight <= 0f) {
                                    goto label_182;
                                }

                                if(v9 == 0) {
                                    v1 = View$MeasureSpec.makeMeasureSpec(v15.getMeasuredHeight(), 0x40000000);
                                }
                                else if(((LayoutParams)v1_1).height == -2) {
                                    v1 = View$MeasureSpec.makeMeasureSpec(v2, 0x80000000);
                                }
                                else if(((LayoutParams)v1_1).height == -1) {
                                    v1 = View$MeasureSpec.makeMeasureSpec(v2, 0x40000000);
                                }
                                else {
                                    v1 = View$MeasureSpec.makeMeasureSpec(((LayoutParams)v1_1).height, 0x40000000);
                                }

                                v15.measure(View$MeasureSpec.makeMeasureSpec(v14_1, 0x40000000), v1);
                            }
                            else {
                            }

                            goto label_182;
                        }

                        if(((LayoutParams)v1_1).weight <= 0f) {
                            goto label_182;
                        }

                        if(((LayoutParams)v1_1).width != 0) {
                            v4 = View$MeasureSpec.makeMeasureSpec(v15.getMeasuredHeight(), 0x40000000);
                        }
                        else if(((LayoutParams)v1_1).height == -2) {
                            v4 = View$MeasureSpec.makeMeasureSpec(v2, 0x80000000);
                        }
                        else if(((LayoutParams)v1_1).height == -1) {
                            v4 = View$MeasureSpec.makeMeasureSpec(v2, 0x40000000);
                        }
                        else {
                            v4 = View$MeasureSpec.makeMeasureSpec(((LayoutParams)v1_1).height, 0x40000000);
                        }

                        if(v7 != 0) {
                            v1 = v11 - (((LayoutParams)v1_1).rightMargin + ((LayoutParams)v1_1).leftMargin);
                            v9 = View$MeasureSpec.makeMeasureSpec(v1, 0x40000000);
                            if(v5 == v1) {
                                goto label_182;
                            }

                            v15.measure(v9, v4);
                            goto label_182;
                        }

                        v15.measure(View$MeasureSpec.makeMeasureSpec((((int)(((LayoutParams)v1_1).weight * (((float)Math.max(0, v6))) / v3_1))) + v5, 0x40000000), v4);
                    }
                }

            label_182:
            }
        }

        this.setMeasuredDimension(v12, this.getPaddingTop() + v8 + this.getPaddingBottom());
        this.mCanSlide = ((boolean)v7);
        if(this.mDragHelper.getViewDragState() != 0 && v7 == 0) {
            this.mDragHelper.abort();
        }
    }

    void onPanelDragged(int arg5) {
        if(this.mSlideableView == null) {
            this.mSlideOffset = 0f;
        }
        else {
            boolean v3 = this.isLayoutRtlSupport();
            ViewGroup$LayoutParams v0 = this.mSlideableView.getLayoutParams();
            int v1 = this.mSlideableView.getWidth();
            if(v3) {
                arg5 = this.getWidth() - arg5 - v1;
            }

            int v2 = v3 ? this.getPaddingRight() : this.getPaddingLeft();
            v1 = v3 ? ((LayoutParams)v0).rightMargin : ((LayoutParams)v0).leftMargin;
            this.mSlideOffset = (((float)(arg5 - (v1 + v2)))) / (((float)this.mSlideRange));
            if(this.mParallaxBy != 0) {
                this.parallaxOtherViews(this.mSlideOffset);
            }

            if(((LayoutParams)v0).dimWhenOffset) {
                this.dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
            }

            this.dispatchOnPanelSlide(this.mSlideableView);
        }
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
        }
        else {
            super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
            if(((SavedState)arg2).isOpen) {
                this.openPane();
            }
            else {
                this.closePane();
            }

            this.mPreservedOpenState = ((SavedState)arg2).isOpen;
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        boolean v0 = this.isSlideable() ? this.isOpen() : this.mPreservedOpenState;
        v1.isOpen = v0;
        return ((Parcelable)v1);
    }

    protected void onSizeChanged(int arg2, int arg3, int arg4, int arg5) {
        super.onSizeChanged(arg2, arg3, arg4, arg5);
        if(arg2 != arg4) {
            this.mFirstLayout = true;
        }
    }

    public boolean onTouchEvent(MotionEvent arg7) {
        boolean v0;
        if(!this.mCanSlide) {
            v0 = super.onTouchEvent(arg7);
        }
        else {
            this.mDragHelper.processTouchEvent(arg7);
            v0 = true;
            switch(arg7.getAction() & 0xFF) {
                case 0: {
                    goto label_11;
                }
                case 1: {
                    goto label_16;
                }
            }

            return v0;
        label_11:
            float v1 = arg7.getX();
            float v2 = arg7.getY();
            this.mInitialMotionX = v1;
            this.mInitialMotionY = v2;
            return v0;
        label_16:
            if(this.isDimmed(this.mSlideableView)) {
                v1 = arg7.getX();
                v2 = arg7.getY();
                float v3 = v1 - this.mInitialMotionX;
                float v4 = v2 - this.mInitialMotionY;
                int v5 = this.mDragHelper.getTouchSlop();
                if(v3 * v3 + v4 * v4 < (((float)(v5 * v5))) && (this.mDragHelper.isViewUnder(this.mSlideableView, ((int)v1), ((int)v2)))) {
                    this.closePane(this.mSlideableView, 0);
                }
            }
        }

        return v0;
    }

    private boolean openPane(View arg3, int arg4) {
        boolean v0 = true;
        if((this.mFirstLayout) || (this.smoothSlideTo(1f, arg4))) {
            this.mPreservedOpenState = true;
        }
        else {
            v0 = false;
        }

        return v0;
    }

    public boolean openPane() {
        return this.openPane(this.mSlideableView, 0);
    }

    private void parallaxOtherViews(float arg10) {
        int v0_1;
        float v8 = 1f;
        boolean v3 = this.isLayoutRtlSupport();
        ViewGroup$LayoutParams v0 = this.mSlideableView.getLayoutParams();
        if(((LayoutParams)v0).dimWhenOffset) {
            v0_1 = v3 ? ((LayoutParams)v0).rightMargin : ((LayoutParams)v0).leftMargin;
            if(v0_1 > 0) {
                goto label_22;
            }

            v0_1 = 1;
        }
        else {
        label_22:
            v0_1 = 0;
        }

        int v4 = this.getChildCount();
        int v2;
        for(v2 = 0; v2 < v4; ++v2) {
            View v5 = this.getChildAt(v2);
            if(v5 != this.mSlideableView) {
                int v1 = ((int)((v8 - this.mParallaxOffset) * (((float)this.mParallaxBy))));
                this.mParallaxOffset = arg10;
                v1 -= ((int)((v8 - arg10) * (((float)this.mParallaxBy))));
                if(v3) {
                    v1 = -v1;
                }

                v5.offsetLeftAndRight(v1);
                if(v0_1 == 0) {
                    goto label_17;
                }

                float v1_1 = v3 ? this.mParallaxOffset - v8 : v8 - this.mParallaxOffset;
                this.dimChildView(v5, v1_1, this.mCoveredFadeColor);
            }

        label_17:
        }
    }

    public void requestChildFocus(View arg2, View arg3) {
        super.requestChildFocus(arg2, arg3);
        if(!this.isInTouchMode() && !this.mCanSlide) {
            boolean v0 = arg2 == this.mSlideableView ? true : false;
            this.mPreservedOpenState = v0;
        }
    }

    void setAllChildrenVisible() {
        int v2 = this.getChildCount();
        int v0;
        for(v0 = 0; v0 < v2; ++v0) {
            View v3 = this.getChildAt(v0);
            if(v3.getVisibility() == 4) {
                v3.setVisibility(0);
            }
        }
    }

    public void setCoveredFadeColor(@ColorInt int arg1) {
        this.mCoveredFadeColor = arg1;
    }

    public void setPanelSlideListener(PanelSlideListener arg1) {
        this.mPanelSlideListener = arg1;
    }

    public void setParallaxDistance(int arg1) {
        this.mParallaxBy = arg1;
        this.requestLayout();
    }

    @Deprecated public void setShadowDrawable(Drawable arg1) {
        this.setShadowDrawableLeft(arg1);
    }

    public void setShadowDrawableLeft(Drawable arg1) {
        this.mShadowDrawableLeft = arg1;
    }

    public void setShadowDrawableRight(Drawable arg1) {
        this.mShadowDrawableRight = arg1;
    }

    @Deprecated public void setShadowResource(@DrawableRes int arg2) {
        this.setShadowDrawable(this.getResources().getDrawable(arg2));
    }

    public void setShadowResourceLeft(int arg2) {
        this.setShadowDrawableLeft(ContextCompat.getDrawable(this.getContext(), arg2));
    }

    public void setShadowResourceRight(int arg2) {
        this.setShadowDrawableRight(ContextCompat.getDrawable(this.getContext(), arg2));
    }

    public void setSliderFadeColor(@ColorInt int arg1) {
        this.mSliderFadeColor = arg1;
    }

    @Deprecated public void smoothSlideClosed() {
        this.closePane();
    }

    @Deprecated public void smoothSlideOpen() {
        this.openPane();
    }

    boolean smoothSlideTo(float arg6, int arg7) {
        boolean v0;
        if(!this.mCanSlide) {
            v0 = false;
        }
        else {
            boolean v2 = this.isLayoutRtlSupport();
            ViewGroup$LayoutParams v0_1 = this.mSlideableView.getLayoutParams();
            int v0_2 = v2 ? ((int)((((float)this.getWidth())) - ((((float)(((LayoutParams)v0_1).rightMargin + this.getPaddingRight()))) + (((float)this.mSlideRange)) * arg6 + (((float)this.mSlideableView.getWidth()))))) : ((int)((((float)(((LayoutParams)v0_1).leftMargin + this.getPaddingLeft()))) + (((float)this.mSlideRange)) * arg6));
            if(this.mDragHelper.smoothSlideViewTo(this.mSlideableView, v0_2, this.mSlideableView.getTop())) {
                this.setAllChildrenVisible();
                ViewCompat.postInvalidateOnAnimation(((View)this));
                return true;
            }

            v0 = false;
        }

        return v0;
    }

    void updateObscuredViewsVisibility(View arg18) {
        int v2;
        int v3;
        int v4;
        int v5;
        boolean v9 = this.isLayoutRtlSupport();
        int v7 = v9 ? this.getWidth() - this.getPaddingRight() : this.getPaddingLeft();
        int v1 = v9 ? this.getPaddingLeft() : this.getWidth() - this.getPaddingRight();
        int v10 = this.getPaddingTop();
        int v11 = this.getHeight() - this.getPaddingBottom();
        if(arg18 == null || !SlidingPaneLayout.viewIsOpaque(arg18)) {
            v2 = 0;
            v3 = 0;
            v4 = 0;
            v5 = 0;
        }
        else {
            v5 = arg18.getLeft();
            v4 = arg18.getRight();
            v3 = arg18.getTop();
            v2 = arg18.getBottom();
        }

        int v12 = this.getChildCount();
        int v8;
        for(v8 = 0; v8 < v12; ++v8) {
            View v13 = this.getChildAt(v8);
            if(v13 == arg18) {
                return;
            }

            if(v13.getVisibility() != 8) {
                int v6 = v9 ? v1 : v7;
                int v14 = Math.max(v6, v13.getLeft());
                int v15 = Math.max(v10, v13.getTop());
                v6 = v9 ? v7 : v1;
                v6 = Math.min(v6, v13.getRight());
                int v16 = Math.min(v11, v13.getBottom());
                v6 = v14 < v5 || v15 < v3 || v6 > v4 || v16 > v2 ? 0 : 4;
                v13.setVisibility(v6);
            }
        }
    }

    private static boolean viewIsOpaque(View arg4) {
        boolean v0 = true;
        if(!arg4.isOpaque()) {
            if(Build$VERSION.SDK_INT >= 18) {
                v0 = false;
            }
            else {
                Drawable v2 = arg4.getBackground();
                if(v2 == null) {
                    v0 = false;
                }
                else if(v2.getOpacity() != -1) {
                    v0 = false;
                }
            }
        }

        return v0;
    }
}

