package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements DrawerLayoutImpl {
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect;

        AccessibilityDelegate(DrawerLayout arg2) {
            DrawerLayout.this = arg2;
            super();
            this.mTmpRect = new Rect();
        }

        private void addChildrenForAccessibility(AccessibilityNodeInfoCompat arg5, ViewGroup arg6) {
            int v1 = arg6.getChildCount();
            int v0;
            for(v0 = 0; v0 < v1; ++v0) {
                View v2 = arg6.getChildAt(v0);
                if(DrawerLayout.includeChildForAccessibility(v2)) {
                    arg5.addChild(v2);
                }
            }
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
        }

        public boolean dispatchPopulateAccessibilityEvent(View arg4, AccessibilityEvent arg5) {
            boolean v0_1;
            if(arg5.getEventType() == 0x20) {
                List v0 = arg5.getText();
                View v1 = DrawerLayout.this.findVisibleDrawer();
                if(v1 != null) {
                    CharSequence v1_1 = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.getDrawerViewAbsoluteGravity(v1));
                    if(v1_1 != null) {
                        v0.add(v1_1);
                    }
                }

                v0_1 = true;
            }
            else {
                v0_1 = super.dispatchPopulateAccessibilityEvent(arg4, arg5);
            }

            return v0_1;
        }

        public void onInitializeAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
            super.onInitializeAccessibilityEvent(arg2, arg3);
            arg3.setClassName(DrawerLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View arg5, AccessibilityNodeInfoCompat arg6) {
            if(DrawerLayout.CAN_HIDE_DESCENDANTS) {
                super.onInitializeAccessibilityNodeInfo(arg5, arg6);
            }
            else {
                AccessibilityNodeInfoCompat v1 = AccessibilityNodeInfoCompat.obtain(arg6);
                super.onInitializeAccessibilityNodeInfo(arg5, v1);
                arg6.setSource(arg5);
                ViewParent v0 = ViewCompat.getParentForAccessibility(arg5);
                if((v0 instanceof View)) {
                    arg6.setParent(((View)v0));
                }

                this.copyNodeInfoNoChildren(arg6, v1);
                v1.recycle();
                this.addChildrenForAccessibility(arg6, ((ViewGroup)arg5));
            }

            arg6.setClassName(DrawerLayout.class.getName());
            arg6.setFocusable(false);
            arg6.setFocused(false);
            arg6.removeAction(AccessibilityActionCompat.ACTION_FOCUS);
            arg6.removeAction(AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup arg2, View arg3, AccessibilityEvent arg4) {
            boolean v0 = (DrawerLayout.CAN_HIDE_DESCENDANTS) || (DrawerLayout.includeChildForAccessibility(arg3)) ? super.onRequestSendAccessibilityEvent(arg2, arg3, arg4) : false;
            return v0;
        }
    }

    final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        ChildAccessibilityDelegate(DrawerLayout arg1) {
            DrawerLayout.this = arg1;
            super();
        }

        public void onInitializeAccessibilityNodeInfo(View arg2, AccessibilityNodeInfoCompat arg3) {
            super.onInitializeAccessibilityNodeInfo(arg2, arg3);
            if(!DrawerLayout.includeChildForAccessibility(arg2)) {
                arg3.setParent(null);
            }
        }
    }

    interface DrawerLayoutCompatImpl {
        void applyMarginInsets(ViewGroup$MarginLayoutParams arg1, Object arg2, int arg3);

        void configureApplyInsets(View arg1);

        void dispatchChildInsets(View arg1, Object arg2, int arg3);

        Drawable getDefaultStatusBarBackground(Context arg1);

        int getTopInset(Object arg1);
    }

    class DrawerLayoutCompatImplApi21 implements DrawerLayoutCompatImpl {
        DrawerLayoutCompatImplApi21() {
            super();
        }

        public void applyMarginInsets(ViewGroup$MarginLayoutParams arg1, Object arg2, int arg3) {
            DrawerLayoutCompatApi21.applyMarginInsets(arg1, arg2, arg3);
        }

        public void configureApplyInsets(View arg1) {
            DrawerLayoutCompatApi21.configureApplyInsets(arg1);
        }

        public void dispatchChildInsets(View arg1, Object arg2, int arg3) {
            DrawerLayoutCompatApi21.dispatchChildInsets(arg1, arg2, arg3);
        }

        public Drawable getDefaultStatusBarBackground(Context arg2) {
            return DrawerLayoutCompatApi21.getDefaultStatusBarBackground(arg2);
        }

        public int getTopInset(Object arg2) {
            return DrawerLayoutCompatApi21.getTopInset(arg2);
        }
    }

    class DrawerLayoutCompatImplBase implements DrawerLayoutCompatImpl {
        DrawerLayoutCompatImplBase() {
            super();
        }

        public void applyMarginInsets(ViewGroup$MarginLayoutParams arg1, Object arg2, int arg3) {
        }

        public void configureApplyInsets(View arg1) {
        }

        public void dispatchChildInsets(View arg1, Object arg2, int arg3) {
        }

        public Drawable getDefaultStatusBarBackground(Context arg2) {
            return null;
        }

        public int getTopInset(Object arg2) {
            return 0;
        }
    }

    public interface DrawerListener {
        void onDrawerClosed(View arg1);

        void onDrawerOpened(View arg1);

        void onDrawerSlide(View arg1, float arg2);

        void onDrawerStateChanged(int arg1);
    }

    public class LayoutParams extends ViewGroup$MarginLayoutParams {
        private static final int FLAG_IS_CLOSING = 4;
        private static final int FLAG_IS_OPENED = 1;
        private static final int FLAG_IS_OPENING = 2;
        public int gravity;
        boolean isPeeking;
        float onScreen;
        int openState;

        public LayoutParams(int arg2, int arg3) {
            super(arg2, arg3);
            this.gravity = 0;
        }

        public LayoutParams(Context arg3, AttributeSet arg4) {
            super(arg3, arg4);
            this.gravity = 0;
            TypedArray v0 = arg3.obtainStyledAttributes(arg4, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = v0.getInt(0, 0);
            v0.recycle();
        }

        public LayoutParams(LayoutParams arg2) {
            super(((ViewGroup$MarginLayoutParams)arg2));
            this.gravity = 0;
            this.gravity = arg2.gravity;
        }

        public LayoutParams(ViewGroup$MarginLayoutParams arg2) {
            super(arg2);
            this.gravity = 0;
        }

        public LayoutParams(ViewGroup$LayoutParams arg2) {
            super(arg2);
            this.gravity = 0;
        }

        public LayoutParams(int arg1, int arg2, int arg3) {
            this(arg1, arg2);
            this.gravity = arg3;
        }
    }

    public class SavedState extends AbsSavedState {
        final class android.support.v4.widget.DrawerLayout$SavedState$1 implements ParcelableCompatCreatorCallbacks {
            android.support.v4.widget.DrawerLayout$SavedState$1() {
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
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity;

        static {
            SavedState.CREATOR = ParcelableCompat.newCreator(new android.support.v4.widget.DrawerLayout$SavedState$1());
        }

        public SavedState(Parcelable arg2) {
            super(arg2);
            this.openDrawerGravity = 0;
        }

        public SavedState(Parcel arg2, ClassLoader arg3) {
            super(arg2, arg3);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = arg2.readInt();
            this.lockModeLeft = arg2.readInt();
            this.lockModeRight = arg2.readInt();
            this.lockModeStart = arg2.readInt();
            this.lockModeEnd = arg2.readInt();
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            super.writeToParcel(arg2, arg3);
            arg2.writeInt(this.openDrawerGravity);
            arg2.writeInt(this.lockModeLeft);
            arg2.writeInt(this.lockModeRight);
            arg2.writeInt(this.lockModeStart);
            arg2.writeInt(this.lockModeEnd);
        }
    }

    public abstract class SimpleDrawerListener implements DrawerListener {
        public SimpleDrawerListener() {
            super();
        }

        public void onDrawerClosed(View arg1) {
        }

        public void onDrawerOpened(View arg1) {
        }

        public void onDrawerSlide(View arg1, float arg2) {
        }

        public void onDrawerStateChanged(int arg1) {
        }
    }

    class ViewDragCallback extends Callback {
        class android.support.v4.widget.DrawerLayout$ViewDragCallback$1 implements Runnable {
            android.support.v4.widget.DrawerLayout$ViewDragCallback$1(ViewDragCallback arg1) {
                this.this$1 = arg1;
                super();
            }

            public void run() {
                this.this$1.peekDrawer();
            }
        }

        private final int mAbsGravity;
        private ViewDragHelper mDragger;
        private final Runnable mPeekRunnable;

        ViewDragCallback(DrawerLayout arg2, int arg3) {
            DrawerLayout.this = arg2;
            super();
            this.mPeekRunnable = new android.support.v4.widget.DrawerLayout$ViewDragCallback$1(this);
            this.mAbsGravity = arg3;
        }

        public int clampViewPositionHorizontal(View arg3, int arg4, int arg5) {
            int v0;
            if(DrawerLayout.this.checkDrawerViewAbsoluteGravity(arg3, 3)) {
                v0 = Math.max(-arg3.getWidth(), Math.min(arg4, 0));
            }
            else {
                v0 = DrawerLayout.this.getWidth();
                v0 = Math.max(v0 - arg3.getWidth(), Math.min(arg4, v0));
            }

            return v0;
        }

        public int clampViewPositionVertical(View arg2, int arg3, int arg4) {
            return arg2.getTop();
        }

        private void closeOtherDrawer() {
            int v0 = 3;
            if(this.mAbsGravity == v0) {
                v0 = 5;
            }

            View v0_1 = DrawerLayout.this.findDrawerWithGravity(v0);
            if(v0_1 != null) {
                DrawerLayout.this.closeDrawer(v0_1);
            }
        }

        public int getViewHorizontalDragRange(View arg2) {
            int v0 = DrawerLayout.this.isDrawerView(arg2) ? arg2.getWidth() : 0;
            return v0;
        }

        public void onEdgeDragStarted(int arg3, int arg4) {
            View v0 = (arg3 & 1) == 1 ? DrawerLayout.this.findDrawerWithGravity(3) : DrawerLayout.this.findDrawerWithGravity(5);
            if(v0 != null && DrawerLayout.this.getDrawerLockMode(v0) == 0) {
                this.mDragger.captureChildView(v0, arg4);
            }
        }

        public boolean onEdgeLock(int arg2) {
            return 0;
        }

        public void onEdgeTouched(int arg5, int arg6) {
            DrawerLayout.this.postDelayed(this.mPeekRunnable, 0xA0);
        }

        public void onViewCaptured(View arg3, int arg4) {
            arg3.getLayoutParams().isPeeking = false;
            this.closeOtherDrawer();
        }

        public void onViewDragStateChanged(int arg4) {
            DrawerLayout.this.updateDrawerState(this.mAbsGravity, arg4, this.mDragger.getCapturedView());
        }

        public void onViewPositionChanged(View arg4, int arg5, int arg6, int arg7, int arg8) {
            int v0 = arg4.getWidth();
            float v0_1 = DrawerLayout.this.checkDrawerViewAbsoluteGravity(arg4, 3) ? (((float)(v0 + arg5))) / (((float)v0)) : (((float)(DrawerLayout.this.getWidth() - arg5))) / (((float)v0));
            DrawerLayout.this.setDrawerViewOffset(arg4, v0_1);
            v0 = v0_1 == 0f ? 4 : 0;
            arg4.setVisibility(v0);
            DrawerLayout.this.invalidate();
        }

        public void onViewReleased(View arg7, float arg8, float arg9) {
            int v0;
            float v5 = 0.5f;
            float v1 = DrawerLayout.this.getDrawerViewOffset(arg7);
            int v2 = arg7.getWidth();
            if(DrawerLayout.this.checkDrawerViewAbsoluteGravity(arg7, 3)) {
                if(arg8 <= 0f && (arg8 != 0f || v1 <= v5)) {
                    v0 = -v2;
                    goto label_13;
                }

                v0 = 0;
            }
            else {
                v0 = DrawerLayout.this.getWidth();
                if(arg8 >= 0f) {
                    if(arg8 != 0f) {
                    }
                    else if(v1 > v5) {
                        goto label_26;
                    }

                    goto label_13;
                }

            label_26:
                v0 -= v2;
            }

        label_13:
            this.mDragger.settleCapturedViewAt(v0, arg7.getTop());
            DrawerLayout.this.invalidate();
        }

        void peekDrawer() {
            int v1_1;
            View v2_1;
            View v1;
            int v5 = 3;
            int v0 = 0;
            int v2 = this.mDragger.getEdgeSize();
            int v3 = this.mAbsGravity == v5 ? 1 : 0;
            if(v3 != 0) {
                v1 = DrawerLayout.this.findDrawerWithGravity(v5);
                if(v1 != null) {
                    v0 = -v1.getWidth();
                }

                v0 += v2;
                v2_1 = v1;
                v1_1 = v0;
            }
            else {
                v1 = DrawerLayout.this.findDrawerWithGravity(5);
                v0 = DrawerLayout.this.getWidth() - v2;
                v2_1 = v1;
                v1_1 = v0;
            }

            if(v2_1 != null) {
                if(v3 == 0 || v2_1.getLeft() >= v1_1) {
                    if(v3 != 0) {
                    }
                    else if(v2_1.getLeft() > v1_1) {
                        goto label_24;
                    }

                    return;
                }

            label_24:
                if(DrawerLayout.this.getDrawerLockMode(v2_1) != 0) {
                    return;
                }

                ViewGroup$LayoutParams v0_1 = v2_1.getLayoutParams();
                this.mDragger.smoothSlideViewTo(v2_1, v1_1, v2_1.getTop());
                ((LayoutParams)v0_1).isPeeking = true;
                DrawerLayout.this.invalidate();
                this.closeOtherDrawer();
                DrawerLayout.this.cancelChildViewTouch();
            }
        }

        public void removeCallbacks() {
            DrawerLayout.this.removeCallbacks(this.mPeekRunnable);
        }

        public void setDragger(ViewDragHelper arg1) {
            this.mDragger = arg1;
        }

        public boolean tryCaptureView(View arg3, int arg4) {
            boolean v0 = !DrawerLayout.this.isDrawerView(arg3) || !DrawerLayout.this.checkDrawerViewAbsoluteGravity(arg3, this.mAbsGravity) || DrawerLayout.this.getDrawerLockMode(arg3) != 0 ? false : true;
            return v0;
        }
    }

    private static final boolean ALLOW_EDGE_LOCK = false;
    static final boolean CAN_HIDE_DESCENDANTS = false;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = 0x99000000;
    private static final int DRAWER_ELEVATION = 10;
    static final DrawerLayoutCompatImpl IMPL = null;
    static final int[] LAYOUT_ATTRS = null;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 0x40;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 0xA0;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION = false;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final float TOUCH_SLOP_SENSITIVITY = 1f;
    private final ChildAccessibilityDelegate mChildAccessibilityDelegate;
    private boolean mChildrenCanceledTouch;
    private boolean mDisallowInterceptRequested;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final ViewDragCallback mLeftCallback;
    private final ViewDragHelper mLeftDragger;
    @Nullable private DrawerListener mListener;
    private List mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList mNonDrawerViews;
    private final ViewDragCallback mRightCallback;
    private final ViewDragHelper mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;

    static {
        int v4 = 21;
        boolean v1 = true;
        DrawerLayout.LAYOUT_ATTRS = new int[]{0x10100B3};
        boolean v0 = Build$VERSION.SDK_INT >= 19 ? true : false;
        DrawerLayout.CAN_HIDE_DESCENDANTS = v0;
        if(Build$VERSION.SDK_INT < v4) {
            v1 = false;
        }

        DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION = v1;
        DrawerLayout.IMPL = Build$VERSION.SDK_INT >= v4 ? new DrawerLayoutCompatImplApi21() : new DrawerLayoutCompatImplBase();
    }

    public DrawerLayout(Context arg2) {
        this(arg2, null);
    }

    public DrawerLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public DrawerLayout(Context arg7, AttributeSet arg8, int arg9) {
        super(arg7, arg8, arg9);
        this.mChildAccessibilityDelegate = new ChildAccessibilityDelegate(this);
        this.mScrimColor = 0x99000000;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = true;
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeStart = 3;
        this.mLockModeEnd = 3;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        this.setDescendantFocusability(0x40000);
        float v0 = this.getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = ((int)(64f * v0 + 0.5f));
        float v1 = 400f * v0;
        this.mLeftCallback = new ViewDragCallback(this, 3);
        this.mRightCallback = new ViewDragCallback(this, 5);
        this.mLeftDragger = ViewDragHelper.create(((ViewGroup)this), 1f, this.mLeftCallback);
        this.mLeftDragger.setEdgeTrackingEnabled(1);
        this.mLeftDragger.setMinVelocity(v1);
        this.mLeftCallback.setDragger(this.mLeftDragger);
        this.mRightDragger = ViewDragHelper.create(((ViewGroup)this), 1f, this.mRightCallback);
        this.mRightDragger.setEdgeTrackingEnabled(2);
        this.mRightDragger.setMinVelocity(v1);
        this.mRightCallback.setDragger(this.mRightDragger);
        this.setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(((View)this), 1);
        ViewCompat.setAccessibilityDelegate(((View)this), new AccessibilityDelegate(this));
        ViewGroupCompat.setMotionEventSplittingEnabled(((ViewGroup)this), false);
        if(ViewCompat.getFitsSystemWindows(((View)this))) {
            DrawerLayout.IMPL.configureApplyInsets(((View)this));
            this.mStatusBarBackground = DrawerLayout.IMPL.getDefaultStatusBarBackground(arg7);
        }

        this.mDrawerElevation = v0 * 10f;
        this.mNonDrawerViews = new ArrayList();
    }

    public void addDrawerListener(@NonNull DrawerListener arg2) {
        if(arg2 != null) {
            if(this.mListeners == null) {
                this.mListeners = new ArrayList();
            }

            this.mListeners.add(arg2);
        }
    }

    public void addFocusables(ArrayList arg7, int arg8, int arg9) {
        int v1 = 0;
        if(this.getDescendantFocusability() != 0x60000) {
            int v3 = this.getChildCount();
            int v2 = 0;
            int v0 = 0;
            while(v2 < v3) {
                View v4 = this.getChildAt(v2);
                if(!this.isDrawerView(v4)) {
                    this.mNonDrawerViews.add(v4);
                }
                else if(this.isDrawerOpen(v4)) {
                    v0 = 1;
                    v4.addFocusables(arg7, arg8, arg9);
                }

                ++v2;
            }

            if(v0 == 0) {
                v2 = this.mNonDrawerViews.size();
                while(v1 < v2) {
                    Object v0_1 = this.mNonDrawerViews.get(v1);
                    if(((View)v0_1).getVisibility() == 0) {
                        ((View)v0_1).addFocusables(arg7, arg8, arg9);
                    }

                    ++v1;
                }
            }

            this.mNonDrawerViews.clear();
        }
    }

    public void addView(View arg2, int arg3, ViewGroup$LayoutParams arg4) {
        super.addView(arg2, arg3, arg4);
        if(this.findOpenDrawer() != null || (this.isDrawerView(arg2))) {
            ViewCompat.setImportantForAccessibility(arg2, 4);
        }
        else {
            ViewCompat.setImportantForAccessibility(arg2, 1);
        }

        if(!DrawerLayout.CAN_HIDE_DESCENDANTS) {
            ViewCompat.setAccessibilityDelegate(arg2, this.mChildAccessibilityDelegate);
        }
    }

    void cancelChildViewTouch() {
        int v7 = 0;
        if(!this.mChildrenCanceledTouch) {
            long v0 = SystemClock.uptimeMillis();
            MotionEvent v0_1 = MotionEvent.obtain(v0, v0, 3, 0f, 0f, 0);
            int v1 = this.getChildCount();
            while(v7 < v1) {
                this.getChildAt(v7).dispatchTouchEvent(v0_1);
                ++v7;
            }

            v0_1.recycle();
            this.mChildrenCanceledTouch = true;
        }
    }

    boolean checkDrawerViewAbsoluteGravity(View arg2, int arg3) {
        boolean v0 = (this.getDrawerViewAbsoluteGravity(arg2) & arg3) == arg3 ? true : false;
        return v0;
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg2) {
        boolean v0 = !(arg2 instanceof LayoutParams) || !super.checkLayoutParams(arg2) ? false : true;
        return v0;
    }

    public void closeDrawer(int arg2) {
        this.closeDrawer(arg2, true);
    }

    public void closeDrawer(int arg4, boolean arg5) {
        View v0 = this.findDrawerWithGravity(arg4);
        if(v0 == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + DrawerLayout.gravityToString(arg4));
        }

        this.closeDrawer(v0, arg5);
    }

    public void closeDrawer(View arg5, boolean arg6) {
        if(!this.isDrawerView(arg5)) {
            throw new IllegalArgumentException("View " + arg5 + " is not a sliding drawer");
        }

        ViewGroup$LayoutParams v0 = arg5.getLayoutParams();
        if(this.mFirstLayout) {
            ((LayoutParams)v0).onScreen = 0f;
            ((LayoutParams)v0).openState = 0;
        }
        else if(arg6) {
            ((LayoutParams)v0).openState |= 4;
            if(this.checkDrawerViewAbsoluteGravity(arg5, 3)) {
                this.mLeftDragger.smoothSlideViewTo(arg5, -arg5.getWidth(), arg5.getTop());
            }
            else {
                this.mRightDragger.smoothSlideViewTo(arg5, this.getWidth(), arg5.getTop());
            }
        }
        else {
            this.moveDrawerToOffset(arg5, 0f);
            this.updateDrawerState(((LayoutParams)v0).gravity, 0, arg5);
            arg5.setVisibility(4);
        }

        this.invalidate();
    }

    public void closeDrawer(View arg2) {
        this.closeDrawer(arg2, true);
    }

    public void closeDrawers() {
        this.closeDrawers(false);
    }

    void closeDrawers(boolean arg10) {
        int v4 = this.getChildCount();
        int v2 = 0;
        int v1 = 0;
        while(v2 < v4) {
            View v5 = this.getChildAt(v2);
            ViewGroup$LayoutParams v0 = v5.getLayoutParams();
            if((this.isDrawerView(v5)) && (!arg10 || (((LayoutParams)v0).isPeeking))) {
                int v6 = v5.getWidth();
                v1 |= this.checkDrawerViewAbsoluteGravity(v5, 3) ? this.mLeftDragger.smoothSlideViewTo(v5, -v6, v5.getTop()) : this.mRightDragger.smoothSlideViewTo(v5, this.getWidth(), v5.getTop());
                ((LayoutParams)v0).isPeeking = false;
            }

            ++v2;
        }

        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if(v1 != 0) {
            this.invalidate();
        }
    }

    public void computeScroll() {
        int v3 = this.getChildCount();
        float v2 = 0f;
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            v2 = Math.max(v2, this.getChildAt(v1).getLayoutParams().onScreen);
        }

        this.mScrimOpacity = v2;
        if((this.mLeftDragger.continueSettling(true) | this.mRightDragger.continueSettling(true)) != 0) {
            ViewCompat.postInvalidateOnAnimation(((View)this));
        }
    }

    void dispatchOnDrawerClosed(View arg5) {
        ViewGroup$LayoutParams v0 = arg5.getLayoutParams();
        if((((LayoutParams)v0).openState & 1) == 1) {
            ((LayoutParams)v0).openState = 0;
            if(this.mListeners != null) {
                int v1;
                for(v1 = this.mListeners.size() - 1; v1 >= 0; --v1) {
                    this.mListeners.get(v1).onDrawerClosed(arg5);
                }
            }

            this.updateChildrenImportantForAccessibility(arg5, false);
            if(!this.hasWindowFocus()) {
                return;
            }

            View v0_1 = this.getRootView();
            if(v0_1 == null) {
                return;
            }

            v0_1.sendAccessibilityEvent(0x20);
        }
    }

    void dispatchOnDrawerOpened(View arg4) {
        ViewGroup$LayoutParams v0 = arg4.getLayoutParams();
        if((((LayoutParams)v0).openState & 1) == 0) {
            ((LayoutParams)v0).openState = 1;
            if(this.mListeners != null) {
                int v1;
                for(v1 = this.mListeners.size() - 1; v1 >= 0; --v1) {
                    this.mListeners.get(v1).onDrawerOpened(arg4);
                }
            }

            this.updateChildrenImportantForAccessibility(arg4, true);
            if(!this.hasWindowFocus()) {
                return;
            }

            this.sendAccessibilityEvent(0x20);
        }
    }

    void dispatchOnDrawerSlide(View arg3, float arg4) {
        if(this.mListeners != null) {
            int v1;
            for(v1 = this.mListeners.size() - 1; v1 >= 0; --v1) {
                this.mListeners.get(v1).onDrawerSlide(arg3, arg4);
            }
        }
    }

    protected boolean drawChild(Canvas arg10, View arg11, long arg12) {
        float v2_1;
        int v0_1;
        int v4 = this.getHeight();
        boolean v5 = this.isContentView(arg11);
        int v1 = 0;
        int v2 = this.getWidth();
        int v6 = arg10.save();
        if(v5) {
            int v7 = this.getChildCount();
            int v3 = 0;
            while(v3 < v7) {
                View v0 = this.getChildAt(v3);
                if(v0 == arg11 || v0.getVisibility() != 0 || !DrawerLayout.hasOpaqueBackground(v0) || !this.isDrawerView(v0)) {
                label_35:
                    v0_1 = v2;
                }
                else if(v0.getHeight() < v4) {
                    v0_1 = v2;
                }
                else if(this.checkDrawerViewAbsoluteGravity(v0, 3)) {
                    v0_1 = v0.getRight();
                    if(v0_1 <= v1) {
                        v0_1 = v1;
                    }

                    v1 = v0_1;
                    v0_1 = v2;
                }
                else {
                    v0_1 = v0.getLeft();
                    if(v0_1 < v2) {
                        goto label_21;
                    }

                    goto label_35;
                }

            label_21:
                ++v3;
                v2 = v0_1;
            }

            arg10.clipRect(v1, 0, v2, this.getHeight());
        }

        v0_1 = v2;
        boolean v7_1 = super.drawChild(arg10, arg11, arg12);
        arg10.restoreToCount(v6);
        if(this.mScrimOpacity <= 0f || !v5) {
            if(this.mShadowLeftResolved != null && (this.checkDrawerViewAbsoluteGravity(arg11, 3))) {
                v0_1 = this.mShadowLeftResolved.getIntrinsicWidth();
                v1 = arg11.getRight();
                v2_1 = Math.max(0f, Math.min((((float)v1)) / (((float)this.mLeftDragger.getEdgeSize())), 1f));
                this.mShadowLeftResolved.setBounds(v1, arg11.getTop(), v0_1 + v1, arg11.getBottom());
                this.mShadowLeftResolved.setAlpha(((int)(255f * v2_1)));
                this.mShadowLeftResolved.draw(arg10);
                return v7_1;
            }

            if(this.mShadowRightResolved == null) {
                return v7_1;
            }

            if(!this.checkDrawerViewAbsoluteGravity(arg11, 5)) {
                return v7_1;
            }

            v0_1 = this.mShadowRightResolved.getIntrinsicWidth();
            v1 = arg11.getLeft();
            v2_1 = Math.max(0f, Math.min((((float)(this.getWidth() - v1))) / (((float)this.mRightDragger.getEdgeSize())), 1f));
            this.mShadowRightResolved.setBounds(v1 - v0_1, arg11.getTop(), v1, arg11.getBottom());
            this.mShadowRightResolved.setAlpha(((int)(255f * v2_1)));
            this.mShadowRightResolved.draw(arg10);
        }
        else {
            this.mScrimPaint.setColor((((int)((((float)((this.mScrimColor & 0xFF000000) >>> 24))) * this.mScrimOpacity))) << 24 | this.mScrimColor & 0xFFFFFF);
            arg10.drawRect(((float)v1), 0f, ((float)v0_1), ((float)this.getHeight()), this.mScrimPaint);
        }

        return v7_1;
    }

    View findDrawerWithGravity(int arg6) {
        View v0;
        int v2 = GravityCompat.getAbsoluteGravity(arg6, ViewCompat.getLayoutDirection(((View)this))) & 7;
        int v3 = this.getChildCount();
        int v1 = 0;
        while(true) {
            if(v1 < v3) {
                v0 = this.getChildAt(v1);
                if((this.getDrawerViewAbsoluteGravity(v0) & 7) != v2) {
                    ++v1;
                    continue;
                }
            }
            else {
                return null;
            }

            return v0;
        }

        return null;
    }

    View findOpenDrawer() {
        View v0;
        int v3 = this.getChildCount();
        int v2 = 0;
        while(true) {
            if(v2 < v3) {
                View v1 = this.getChildAt(v2);
                if((v1.getLayoutParams().openState & 1) == 1) {
                    v0 = v1;
                }
                else {
                    ++v2;
                    continue;
                }
            }
            else {
                return null;
            }

            return v0;
        }

        return null;
    }

    View findVisibleDrawer() {
        int v2 = this.getChildCount();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            View v0 = this.getChildAt(v1);
            if((this.isDrawerView(v0)) && (this.isDrawerVisible(v0))) {
                return v0;
            }
        }

        return null;
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg3) {
        return new LayoutParams(this.getContext(), arg3);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg2) {
        LayoutParams v0;
        if((arg2 instanceof LayoutParams)) {
            v0 = new LayoutParams(((LayoutParams)arg2));
        }
        else if((arg2 instanceof ViewGroup$MarginLayoutParams)) {
            v0 = new LayoutParams(((ViewGroup$MarginLayoutParams)arg2));
        }
        else {
            v0 = new LayoutParams(arg2);
        }

        return ((ViewGroup$LayoutParams)v0);
    }

    public float getDrawerElevation() {
        float v0 = DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION ? this.mDrawerElevation : 0f;
        return v0;
    }

    public int getDrawerLockMode(int arg4) {
        int v2 = 3;
        int v0 = ViewCompat.getLayoutDirection(((View)this));
        switch(arg4) {
            case 3: {
                if(this.mLockModeLeft != v2) {
                    return this.mLockModeLeft;
                }

                v0 = v0 == 0 ? this.mLockModeStart : this.mLockModeEnd;
                if(v0 == v2) {
                    goto label_3;
                }

                break;
            }
            case 5: {
                if(this.mLockModeRight != v2) {
                    return this.mLockModeRight;
                }

                v0 = v0 == 0 ? this.mLockModeEnd : this.mLockModeStart;
                if(v0 == v2) {
                    goto label_3;
                }

                break;
            }
            case 8388611: {
                if(this.mLockModeStart != v2) {
                    return this.mLockModeStart;
                }

                v0 = v0 == 0 ? this.mLockModeLeft : this.mLockModeRight;
                if(v0 == v2) {
                    goto label_3;
                }

                break;
            }
            case 8388613: {
                if(this.mLockModeEnd != v2) {
                    return this.mLockModeEnd;
                }

                v0 = v0 == 0 ? this.mLockModeRight : this.mLockModeLeft;
                if(v0 == v2) {
                    goto label_3;
                }

                break;
            }
            default: {
            label_3:
                v0 = 0;
                break;
            }
        }

        return v0;
    }

    public int getDrawerLockMode(View arg4) {
        if(!this.isDrawerView(arg4)) {
            throw new IllegalArgumentException("View " + arg4 + " is not a drawer");
        }

        return this.getDrawerLockMode(arg4.getLayoutParams().gravity);
    }

    @Nullable public CharSequence getDrawerTitle(int arg3) {
        CharSequence v0_1;
        int v0 = GravityCompat.getAbsoluteGravity(arg3, ViewCompat.getLayoutDirection(((View)this)));
        if(v0 == 3) {
            v0_1 = this.mTitleLeft;
        }
        else if(v0 == 5) {
            v0_1 = this.mTitleRight;
        }
        else {
            v0_1 = null;
        }

        return v0_1;
    }

    int getDrawerViewAbsoluteGravity(View arg3) {
        return GravityCompat.getAbsoluteGravity(arg3.getLayoutParams().gravity, ViewCompat.getLayoutDirection(((View)this)));
    }

    float getDrawerViewOffset(View arg2) {
        return arg2.getLayoutParams().onScreen;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    static String gravityToString(int arg2) {
        String v0;
        if((arg2 & 3) == 3) {
            v0 = "LEFT";
        }
        else if((arg2 & 5) == 5) {
            v0 = "RIGHT";
        }
        else {
            v0 = Integer.toHexString(arg2);
        }

        return v0;
    }

    private static boolean hasOpaqueBackground(View arg3) {
        boolean v0 = false;
        Drawable v1 = arg3.getBackground();
        if(v1 != null && v1.getOpacity() == -1) {
            v0 = true;
        }

        return v0;
    }

    private boolean hasPeekingDrawer() {
        boolean v0;
        int v3 = this.getChildCount();
        int v2 = 0;
        while(true) {
            if(v2 >= v3) {
                return false;
            }
            else if(this.getChildAt(v2).getLayoutParams().isPeeking) {
                v0 = true;
            }
            else {
                ++v2;
                continue;
            }

            return v0;
        }

        return false;
    }

    private boolean hasVisibleDrawer() {
        boolean v0 = this.findVisibleDrawer() != null ? true : false;
        return v0;
    }

    static boolean includeChildForAccessibility(View arg2) {
        boolean v0 = ViewCompat.getImportantForAccessibility(arg2) == 4 || ViewCompat.getImportantForAccessibility(arg2) == 2 ? false : true;
        return v0;
    }

    boolean isContentView(View arg2) {
        boolean v0 = arg2.getLayoutParams().gravity == 0 ? true : false;
        return v0;
    }

    public boolean isDrawerOpen(int arg2) {
        View v0 = this.findDrawerWithGravity(arg2);
        boolean v0_1 = v0 != null ? this.isDrawerOpen(v0) : false;
        return v0_1;
    }

    public boolean isDrawerOpen(View arg4) {
        if(!this.isDrawerView(arg4)) {
            throw new IllegalArgumentException("View " + arg4 + " is not a drawer");
        }

        boolean v0 = (arg4.getLayoutParams().openState & 1) == 1 ? true : false;
        return v0;
    }

    boolean isDrawerView(View arg4) {
        boolean v0_1;
        int v0 = GravityCompat.getAbsoluteGravity(arg4.getLayoutParams().gravity, ViewCompat.getLayoutDirection(arg4));
        if((v0 & 3) != 0) {
            v0_1 = true;
        }
        else if((v0 & 5) != 0) {
            v0_1 = true;
        }
        else {
            v0_1 = false;
        }

        return v0_1;
    }

    public boolean isDrawerVisible(int arg2) {
        View v0 = this.findDrawerWithGravity(arg2);
        boolean v0_1 = v0 != null ? this.isDrawerVisible(v0) : false;
        return v0_1;
    }

    public boolean isDrawerVisible(View arg4) {
        if(!this.isDrawerView(arg4)) {
            throw new IllegalArgumentException("View " + arg4 + " is not a drawer");
        }

        boolean v0 = arg4.getLayoutParams().onScreen > 0f ? true : false;
        return v0;
    }

    private boolean mirror(Drawable arg2, int arg3) {
        boolean v0;
        if(arg2 == null || !DrawableCompat.isAutoMirrored(arg2)) {
            v0 = false;
        }
        else {
            DrawableCompat.setLayoutDirection(arg2, arg3);
            v0 = true;
        }

        return v0;
    }

    void moveDrawerToOffset(View arg4, float arg5) {
        float v0 = this.getDrawerViewOffset(arg4);
        int v1 = arg4.getWidth();
        int v0_1 = (((int)((((float)v1)) * arg5))) - (((int)(v0 * (((float)v1)))));
        if(!this.checkDrawerViewAbsoluteGravity(arg4, 3)) {
            v0_1 = -v0_1;
        }

        arg4.offsetLeftAndRight(v0_1);
        this.setDrawerViewOffset(arg4, arg5);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    public void onDraw(Canvas arg5) {
        super.onDraw(arg5);
        if((this.mDrawStatusBarBackground) && this.mStatusBarBackground != null) {
            int v0 = DrawerLayout.IMPL.getTopInset(this.mLastInsets);
            if(v0 > 0) {
                this.mStatusBarBackground.setBounds(0, 0, this.getWidth(), v0);
                this.mStatusBarBackground.draw(arg5);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent arg8) {
        boolean v2 = false;
        int v0 = MotionEventCompat.getActionMasked(arg8);
        int v3 = this.mLeftDragger.shouldInterceptTouchEvent(arg8) | this.mRightDragger.shouldInterceptTouchEvent(arg8);
        switch(v0) {
            case 0: {
                goto label_18;
            }
            case 2: {
                goto label_36;
            }
            case 1: 
            case 3: {
                goto label_46;
            }
        }

        goto label_9;
    label_18:
        float v0_1 = arg8.getX();
        float v4 = arg8.getY();
        this.mInitialMotionX = v0_1;
        this.mInitialMotionY = v4;
        if(this.mScrimOpacity > 0f) {
            View v0_2 = this.mLeftDragger.findTopChildUnder(((int)v0_1), ((int)v4));
            if(v0_2 == null) {
                goto label_50;
            }
            else if(this.isContentView(v0_2)) {
                v0 = 1;
            }
            else {
                goto label_50;
            }
        }
        else {
        label_50:
            v0 = 0;
        }

        this.mDisallowInterceptRequested = false;
        this.mChildrenCanceledTouch = false;
        goto label_10;
    label_36:
        if(!this.mLeftDragger.checkTouchSlop(3)) {
        }
        else {
            this.mLeftCallback.removeCallbacks();
            this.mRightCallback.removeCallbacks();
            v0 = 0;
            goto label_10;
        label_46:
            this.closeDrawers(true);
            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
        }

    label_9:
        v0 = 0;
    label_10:
        if(v3 != 0 || v0 != 0 || (this.hasPeekingDrawer()) || (this.mChildrenCanceledTouch)) {
            v2 = true;
        }

        return v2;
    }

    public boolean onKeyDown(int arg2, KeyEvent arg3) {
        boolean v0;
        if(arg2 != 4 || !this.hasVisibleDrawer()) {
            v0 = super.onKeyDown(arg2, arg3);
        }
        else {
            arg3.startTracking();
            v0 = true;
        }

        return v0;
    }

    public boolean onKeyUp(int arg3, KeyEvent arg4) {
        boolean v0_1;
        if(arg3 == 4) {
            View v0 = this.findVisibleDrawer();
            if(v0 != null && this.getDrawerLockMode(v0) == 0) {
                this.closeDrawers();
            }

            if(v0 != null) {
                v0_1 = true;
                return v0_1;
            }

            v0_1 = false;
        }
        else {
            v0_1 = super.onKeyUp(arg3, arg4);
        }

        return v0_1;
    }

    protected void onLayout(boolean arg15, int arg16, int arg17, int arg18, int arg19) {
        int v4;
        float v1;
        int v2;
        this.mInLayout = true;
        int v6 = arg18 - arg16;
        int v7 = this.getChildCount();
        int v5;
        for(v5 = 0; v5 < v7; ++v5) {
            View v8 = this.getChildAt(v5);
            if(v8.getVisibility() != 8) {
                ViewGroup$LayoutParams v0 = v8.getLayoutParams();
                if(this.isContentView(v8)) {
                    v8.layout(((LayoutParams)v0).leftMargin, ((LayoutParams)v0).topMargin, ((LayoutParams)v0).leftMargin + v8.getMeasuredWidth(), ((LayoutParams)v0).topMargin + v8.getMeasuredHeight());
                }
                else {
                    int v9 = v8.getMeasuredWidth();
                    int v10 = v8.getMeasuredHeight();
                    if(this.checkDrawerViewAbsoluteGravity(v8, 3)) {
                        v2 = (((int)((((float)v9)) * ((LayoutParams)v0).onScreen))) + -v9;
                        v1 = (((float)(v9 + v2))) / (((float)v9));
                    }
                    else {
                        v2 = v6 - (((int)((((float)v9)) * ((LayoutParams)v0).onScreen)));
                        v1 = (((float)(v6 - v2))) / (((float)v9));
                    }

                    int v3 = v1 != ((LayoutParams)v0).onScreen ? 1 : 0;
                    switch(((LayoutParams)v0).gravity & 0x70) {
                        case 16: {
                            int v11 = arg19 - arg17;
                            v4 = (v11 - v10) / 2;
                            if(v4 < ((LayoutParams)v0).topMargin) {
                                v4 = ((LayoutParams)v0).topMargin;
                            }
                            else if(v4 + v10 > v11 - ((LayoutParams)v0).bottomMargin) {
                                v4 = v11 - ((LayoutParams)v0).bottomMargin - v10;
                            }

                            v8.layout(v2, v4, v9 + v2, v10 + v4);
                            break;
                        }
                        case 80: {
                            v4 = arg19 - arg17;
                            v8.layout(v2, v4 - ((LayoutParams)v0).bottomMargin - v8.getMeasuredHeight(), v9 + v2, v4 - ((LayoutParams)v0).bottomMargin);
                            break;
                        }
                        default: {
                            v8.layout(v2, ((LayoutParams)v0).topMargin, v9 + v2, v10 + ((LayoutParams)v0).topMargin);
                            break;
                        }
                    }

                    if(v3 != 0) {
                        this.setDrawerViewOffset(v8, v1);
                    }

                    int v0_1 = ((LayoutParams)v0).onScreen > 0f ? 0 : 4;
                    if(v8.getVisibility() == v0_1) {
                        goto label_11;
                    }

                    v8.setVisibility(v0_1);
                }
            }

        label_11:
        }

        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    protected void onMeasure(int arg14, int arg15) {
        int v6;
        View v10;
        int v2 = View$MeasureSpec.getMode(arg14);
        int v3 = View$MeasureSpec.getMode(arg15);
        int v1 = View$MeasureSpec.getSize(arg14);
        int v0 = View$MeasureSpec.getSize(arg15);
        if(v2 == 0x40000000 && v3 == 0x40000000) {
            goto label_154;
        }
        else if(this.isInEditMode()) {
            if(v2 != 0x80000000 && v2 == 0) {
                v1 = 300;
            }

            if(v3 == 0x80000000) {
                v2 = v1;
                v1 = v0;
                goto label_16;
            }

            if(v3 == 0) {
                v2 = v1;
                v1 = 300;
                goto label_16;
            }

        label_154:
            v2 = v1;
            v1 = v0;
        }
        else {
            goto label_45;
        }

    label_16:
        this.setMeasuredDimension(v2, v1);
        v3 = this.mLastInsets == null || !ViewCompat.getFitsSystemWindows(((View)this)) ? 0 : 1;
        int v8 = ViewCompat.getLayoutDirection(((View)this));
        int v5 = 0;
        int v4 = 0;
        int v9 = this.getChildCount();
        int v7;
        for(v7 = 0; true; ++v7) {
            if(v7 >= v9) {
                return;
            }

            v10 = this.getChildAt(v7);
            if(v10.getVisibility() != 8) {
                ViewGroup$LayoutParams v0_1 = v10.getLayoutParams();
                if(v3 != 0) {
                    v6 = GravityCompat.getAbsoluteGravity(((LayoutParams)v0_1).gravity, v8);
                    if(ViewCompat.getFitsSystemWindows(v10)) {
                        DrawerLayout.IMPL.dispatchChildInsets(v10, this.mLastInsets, v6);
                    }
                    else {
                        DrawerLayout.IMPL.applyMarginInsets(((ViewGroup$MarginLayoutParams)v0_1), this.mLastInsets, v6);
                    }
                }

                if(this.isContentView(v10)) {
                    v10.measure(View$MeasureSpec.makeMeasureSpec(v2 - ((LayoutParams)v0_1).leftMargin - ((LayoutParams)v0_1).rightMargin, 0x40000000), View$MeasureSpec.makeMeasureSpec(v1 - ((LayoutParams)v0_1).topMargin - ((LayoutParams)v0_1).bottomMargin, 0x40000000));
                    goto label_34;
                }

                if(!this.isDrawerView(v10)) {
                    break;
                }

                if((DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION) && ViewCompat.getElevation(v10) != this.mDrawerElevation) {
                    ViewCompat.setElevation(v10, this.mDrawerElevation);
                }

                int v11 = this.getDrawerViewAbsoluteGravity(v10) & 7;
                v6 = v11 == 3 ? 1 : 0;
                if(v6 != 0 && v5 != 0 || v6 == 0 && v4 != 0) {
                    throw new IllegalStateException("Child drawer has absolute gravity " + DrawerLayout.gravityToString(v11) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                }

                if(v6 != 0) {
                    v5 = 1;
                }
                else {
                    v4 = 1;
                }

                v10.measure(DrawerLayout.getChildMeasureSpec(arg14, this.mMinDrawerMargin + ((LayoutParams)v0_1).leftMargin + ((LayoutParams)v0_1).rightMargin, ((LayoutParams)v0_1).width), DrawerLayout.getChildMeasureSpec(arg15, ((LayoutParams)v0_1).topMargin + ((LayoutParams)v0_1).bottomMargin, ((LayoutParams)v0_1).height));
            }

        label_34:
        }

        throw new IllegalStateException("Child " + v10 + " at index " + v7 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
        return;
    label_45:
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
    }

    protected void onRestoreInstanceState(Parcelable arg4) {
        int v2 = 3;
        if(!(arg4 instanceof SavedState)) {
            super.onRestoreInstanceState(arg4);
        }
        else {
            super.onRestoreInstanceState(((SavedState)arg4).getSuperState());
            if(((SavedState)arg4).openDrawerGravity != 0) {
                View v0 = this.findDrawerWithGravity(((SavedState)arg4).openDrawerGravity);
                if(v0 != null) {
                    this.openDrawer(v0);
                }
            }

            if(((SavedState)arg4).lockModeLeft != v2) {
                this.setDrawerLockMode(((SavedState)arg4).lockModeLeft, v2);
            }

            if(((SavedState)arg4).lockModeRight != v2) {
                this.setDrawerLockMode(((SavedState)arg4).lockModeRight, 5);
            }

            if(((SavedState)arg4).lockModeStart != v2) {
                this.setDrawerLockMode(((SavedState)arg4).lockModeStart, 0x800003);
            }

            if(((SavedState)arg4).lockModeEnd == v2) {
                return;
            }

            this.setDrawerLockMode(((SavedState)arg4).lockModeEnd, 0x800005);
        }
    }

    public void onRtlPropertiesChanged(int arg1) {
        this.resolveShadowDrawables();
    }

    protected Parcelable onSaveInstanceState() {
        ViewGroup$LayoutParams v0;
        SavedState v6 = new SavedState(super.onSaveInstanceState());
        int v7 = this.getChildCount();
        int v5 = 0;
        while(true) {
            if(v5 < v7) {
                v0 = this.getChildAt(v5).getLayoutParams();
                int v1 = ((LayoutParams)v0).openState == 1 ? 1 : 0;
                int v4 = ((LayoutParams)v0).openState == 2 ? 1 : 0;
                if(v1 == 0 && v4 == 0) {
                    ++v5;
                    continue;
                }

                break;
            }

            goto label_21;
        }

        v6.openDrawerGravity = ((LayoutParams)v0).gravity;
    label_21:
        v6.lockModeLeft = this.mLockModeLeft;
        v6.lockModeRight = this.mLockModeRight;
        v6.lockModeStart = this.mLockModeStart;
        v6.lockModeEnd = this.mLockModeEnd;
        return ((Parcelable)v6);
    }

    public boolean onTouchEvent(MotionEvent arg8) {
        boolean v0_2;
        float v3;
        float v0;
        this.mLeftDragger.processTouchEvent(arg8);
        this.mRightDragger.processTouchEvent(arg8);
        switch(arg8.getAction() & 0xFF) {
            case 0: {
                v0 = arg8.getX();
                v3 = arg8.getY();
                this.mInitialMotionX = v0;
                this.mInitialMotionY = v3;
                this.mDisallowInterceptRequested = false;
                this.mChildrenCanceledTouch = false;
                break;
            }
            case 1: {
                v0 = arg8.getX();
                v3 = arg8.getY();
                View v4 = this.mLeftDragger.findTopChildUnder(((int)v0), ((int)v3));
                if(v4 == null || !this.isContentView(v4)) {
                label_53:
                    v0_2 = true;
                }
                else {
                    v0 -= this.mInitialMotionX;
                    v3 -= this.mInitialMotionY;
                    int v4_1 = this.mLeftDragger.getTouchSlop();
                    if(v0 * v0 + v3 * v3 < (((float)(v4_1 * v4_1)))) {
                        View v0_1 = this.findOpenDrawer();
                        if(v0_1 == null) {
                            goto label_53;
                        }
                        else if(this.getDrawerLockMode(v0_1) == 2) {
                            v0_2 = true;
                        }
                        else {
                            v0_2 = false;
                        }
                    }
                    else {
                        goto label_53;
                    }
                }

                this.closeDrawers(v0_2);
                this.mDisallowInterceptRequested = false;
                break;
            }
            case 3: {
                this.closeDrawers(true);
                this.mDisallowInterceptRequested = false;
                this.mChildrenCanceledTouch = false;
                break;
            }
        }

        return 1;
    }

    public void openDrawer(int arg2) {
        this.openDrawer(arg2, true);
    }

    public void openDrawer(View arg2) {
        this.openDrawer(arg2, true);
    }

    public void openDrawer(int arg4, boolean arg5) {
        View v0 = this.findDrawerWithGravity(arg4);
        if(v0 == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + DrawerLayout.gravityToString(arg4));
        }

        this.openDrawer(v0, arg5);
    }

    public void openDrawer(View arg6, boolean arg7) {
        float v3 = 1f;
        if(!this.isDrawerView(arg6)) {
            throw new IllegalArgumentException("View " + arg6 + " is not a sliding drawer");
        }

        ViewGroup$LayoutParams v0 = arg6.getLayoutParams();
        if(this.mFirstLayout) {
            ((LayoutParams)v0).onScreen = v3;
            ((LayoutParams)v0).openState = 1;
            this.updateChildrenImportantForAccessibility(arg6, true);
        }
        else if(arg7) {
            ((LayoutParams)v0).openState |= 2;
            if(this.checkDrawerViewAbsoluteGravity(arg6, 3)) {
                this.mLeftDragger.smoothSlideViewTo(arg6, 0, arg6.getTop());
            }
            else {
                this.mRightDragger.smoothSlideViewTo(arg6, this.getWidth() - arg6.getWidth(), arg6.getTop());
            }
        }
        else {
            this.moveDrawerToOffset(arg6, v3);
            this.updateDrawerState(((LayoutParams)v0).gravity, 0, arg6);
            arg6.setVisibility(0);
        }

        this.invalidate();
    }

    public void removeDrawerListener(@NonNull DrawerListener arg2) {
        if(arg2 != null && this.mListeners != null) {
            this.mListeners.remove(arg2);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean arg2) {
        super.requestDisallowInterceptTouchEvent(arg2);
        this.mDisallowInterceptRequested = arg2;
        if(arg2) {
            this.closeDrawers(true);
        }
    }

    public void requestLayout() {
        if(!this.mInLayout) {
            super.requestLayout();
        }
    }

    private Drawable resolveLeftShadow() {
        Drawable v0_1;
        int v0 = ViewCompat.getLayoutDirection(((View)this));
        if(v0 == 0) {
            if(this.mShadowStart != null) {
                this.mirror(this.mShadowStart, v0);
                v0_1 = this.mShadowStart;
            }
            else {
                goto label_14;
            }
        }
        else if(this.mShadowEnd != null) {
            this.mirror(this.mShadowEnd, v0);
            v0_1 = this.mShadowEnd;
        }
        else {
        label_14:
            v0_1 = this.mShadowLeft;
        }

        return v0_1;
    }

    private Drawable resolveRightShadow() {
        Drawable v0_1;
        int v0 = ViewCompat.getLayoutDirection(((View)this));
        if(v0 == 0) {
            if(this.mShadowEnd != null) {
                this.mirror(this.mShadowEnd, v0);
                v0_1 = this.mShadowEnd;
            }
            else {
                goto label_14;
            }
        }
        else if(this.mShadowStart != null) {
            this.mirror(this.mShadowStart, v0);
            v0_1 = this.mShadowStart;
        }
        else {
        label_14:
            v0_1 = this.mShadowRight;
        }

        return v0_1;
    }

    private void resolveShadowDrawables() {
        if(!DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION) {
            this.mShadowLeftResolved = this.resolveLeftShadow();
            this.mShadowRightResolved = this.resolveRightShadow();
        }
    }

    public void setChildInsets(Object arg2, boolean arg3) {
        this.mLastInsets = arg2;
        this.mDrawStatusBarBackground = arg3;
        boolean v0 = (arg3) || this.getBackground() != null ? false : true;
        this.setWillNotDraw(v0);
        this.requestLayout();
    }

    public void setDrawerElevation(float arg4) {
        this.mDrawerElevation = arg4;
        int v0;
        for(v0 = 0; v0 < this.getChildCount(); ++v0) {
            View v1 = this.getChildAt(v0);
            if(this.isDrawerView(v1)) {
                ViewCompat.setElevation(v1, this.mDrawerElevation);
            }
        }
    }

    @Deprecated public void setDrawerListener(DrawerListener arg2) {
        if(this.mListener != null) {
            this.removeDrawerListener(this.mListener);
        }

        if(arg2 != null) {
            this.addDrawerListener(arg2);
        }

        this.mListener = arg2;
    }

    public void setDrawerLockMode(int arg3, int arg4) {
        View v0_1;
        int v1 = GravityCompat.getAbsoluteGravity(arg4, ViewCompat.getLayoutDirection(((View)this)));
        switch(arg4) {
            case 3: {
                this.mLockModeLeft = arg3;
                break;
            }
            case 5: {
                this.mLockModeRight = arg3;
                break;
            }
            case 8388611: {
                this.mLockModeStart = arg3;
                break;
            }
            case 8388613: {
                this.mLockModeEnd = arg3;
                break;
            }
        }

        if(arg3 != 0) {
            ViewDragHelper v0 = v1 == 3 ? this.mLeftDragger : this.mRightDragger;
            v0.cancel();
        }

        switch(arg3) {
            case 1: {
                v0_1 = this.findDrawerWithGravity(v1);
                if(v0_1 == null) {
                    return;
                }

                this.closeDrawer(v0_1);
                break;
            }
            case 2: {
                v0_1 = this.findDrawerWithGravity(v1);
                if(v0_1 == null) {
                    return;
                }

                this.openDrawer(v0_1);
                break;
            }
        }
    }

    public void setDrawerLockMode(int arg2) {
        this.setDrawerLockMode(arg2, 3);
        this.setDrawerLockMode(arg2, 5);
    }

    public void setDrawerLockMode(int arg4, View arg5) {
        if(!this.isDrawerView(arg5)) {
            throw new IllegalArgumentException("View " + arg5 + " is not a " + "drawer with appropriate layout_gravity");
        }

        this.setDrawerLockMode(arg4, arg5.getLayoutParams().gravity);
    }

    public void setDrawerShadow(@DrawableRes int arg2, int arg3) {
        this.setDrawerShadow(ContextCompat.getDrawable(this.getContext(), arg2), arg3);
    }

    public void setDrawerShadow(Drawable arg4, int arg5) {
        int v2 = 0x800005;
        int v1 = 0x800003;
        if(!DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION) {
            if((arg5 & v1) == v1) {
                this.mShadowStart = arg4;
            }
            else if((arg5 & v2) == v2) {
                this.mShadowEnd = arg4;
            }
            else if((arg5 & 3) == 3) {
                this.mShadowLeft = arg4;
            }
            else if((arg5 & 5) == 5) {
                this.mShadowRight = arg4;
            }
            else {
                return;
            }

            this.resolveShadowDrawables();
            this.invalidate();
        }
    }

    public void setDrawerTitle(int arg3, CharSequence arg4) {
        int v0 = GravityCompat.getAbsoluteGravity(arg3, ViewCompat.getLayoutDirection(((View)this)));
        if(v0 == 3) {
            this.mTitleLeft = arg4;
        }
        else if(v0 == 5) {
            this.mTitleRight = arg4;
        }
    }

    void setDrawerViewOffset(View arg3, float arg4) {
        ViewGroup$LayoutParams v0 = arg3.getLayoutParams();
        if(arg4 != ((LayoutParams)v0).onScreen) {
            ((LayoutParams)v0).onScreen = arg4;
            this.dispatchOnDrawerSlide(arg3, arg4);
        }
    }

    public void setScrimColor(@ColorInt int arg1) {
        this.mScrimColor = arg1;
        this.invalidate();
    }

    public void setStatusBarBackground(int arg2) {
        Drawable v0 = arg2 != 0 ? ContextCompat.getDrawable(this.getContext(), arg2) : null;
        this.mStatusBarBackground = v0;
        this.invalidate();
    }

    public void setStatusBarBackground(Drawable arg1) {
        this.mStatusBarBackground = arg1;
        this.invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int arg2) {
        this.mStatusBarBackground = new ColorDrawable(arg2);
        this.invalidate();
    }

    private void updateChildrenImportantForAccessibility(View arg5, boolean arg6) {
        int v1 = this.getChildCount();
        int v0;
        for(v0 = 0; v0 < v1; ++v0) {
            View v2 = this.getChildAt(v0);
            if((arg6) || (this.isDrawerView(v2))) {
                if((arg6) && v2 == arg5) {
                label_9:
                    ViewCompat.setImportantForAccessibility(v2, 1);
                    goto label_11;
                }

                ViewCompat.setImportantForAccessibility(v2, 4);
            }
            else {
                goto label_9;
            }

        label_11:
        }
    }

    void updateDrawerState(int arg5, int arg6, View arg7) {
        int v0 = 2;
        int v2 = this.mLeftDragger.getViewDragState();
        int v3 = this.mRightDragger.getViewDragState();
        if(v2 == 1 || v3 == 1) {
            v2 = 1;
        }
        else {
            if(v2 != v0 && v3 != v0) {
                v2 = 0;
                goto label_9;
            }

            v2 = v0;
        }

    label_9:
        if(arg7 != null && arg6 == 0) {
            ViewGroup$LayoutParams v0_1 = arg7.getLayoutParams();
            if(((LayoutParams)v0_1).onScreen == 0f) {
                this.dispatchOnDrawerClosed(arg7);
            }
            else if(((LayoutParams)v0_1).onScreen == 1f) {
                this.dispatchOnDrawerOpened(arg7);
            }
        }

        if(v2 != this.mDrawerState) {
            this.mDrawerState = v2;
            if(this.mListeners != null) {
                int v1;
                for(v1 = this.mListeners.size() - 1; v1 >= 0; --v1) {
                    this.mListeners.get(v1).onDrawerStateChanged(v2);
                }
            }
        }
    }
}

