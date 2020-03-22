package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    final class android.support.v4.view.ViewPager$1 implements Comparator {
        android.support.v4.view.ViewPager$1() {
            super();
        }

        public int compare(ItemInfo arg3, ItemInfo arg4) {
            return arg3.position - arg4.position;
        }

        public int compare(Object arg2, Object arg3) {
            return this.compare(((ItemInfo)arg2), ((ItemInfo)arg3));
        }
    }

    final class android.support.v4.view.ViewPager$2 implements Interpolator {
        android.support.v4.view.ViewPager$2() {
            super();
        }

        public float getInterpolation(float arg4) {
            float v0 = arg4 - 1f;
            return v0 * (v0 * v0 * v0 * v0) + 1f;
        }
    }

    class android.support.v4.view.ViewPager$3 implements Runnable {
        android.support.v4.view.ViewPager$3(ViewPager arg1) {
            ViewPager.this = arg1;
            super();
        }

        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.populate();
        }
    }

    @Inherited @Retention(value=RetentionPolicy.RUNTIME) @Target(value={ElementType.TYPE}) @public interface DecorView {
    }

    class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo() {
            super();
        }
    }

    public class LayoutParams extends ViewGroup$LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor;

        public LayoutParams() {
            super(-1, -1);
            this.widthFactor = 0f;
        }

        public LayoutParams(Context arg4, AttributeSet arg5) {
            super(arg4, arg5);
            this.widthFactor = 0f;
            TypedArray v0 = arg4.obtainStyledAttributes(arg5, ViewPager.LAYOUT_ATTRS);
            this.gravity = v0.getInteger(0, 0x30);
            v0.recycle();
        }
    }

    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate(ViewPager arg1) {
            ViewPager.this = arg1;
            super();
        }

        private boolean canScroll() {
            boolean v0 = true;
            if(ViewPager.this.mAdapter == null || ViewPager.this.mAdapter.getCount() <= 1) {
                v0 = false;
            }

            return v0;
        }

        public void onInitializeAccessibilityEvent(View arg4, AccessibilityEvent arg5) {
            super.onInitializeAccessibilityEvent(arg4, arg5);
            arg5.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat v0 = AccessibilityEventCompat.asRecord(arg5);
            v0.setScrollable(this.canScroll());
            if(arg5.getEventType() == 0x1000 && ViewPager.this.mAdapter != null) {
                v0.setItemCount(ViewPager.this.mAdapter.getCount());
                v0.setFromIndex(ViewPager.this.mCurItem);
                v0.setToIndex(ViewPager.this.mCurItem);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View arg3, AccessibilityNodeInfoCompat arg4) {
            super.onInitializeAccessibilityNodeInfo(arg3, arg4);
            arg4.setClassName(ViewPager.class.getName());
            arg4.setScrollable(this.canScroll());
            if(ViewPager.this.canScrollHorizontally(1)) {
                arg4.addAction(0x1000);
            }

            if(ViewPager.this.canScrollHorizontally(-1)) {
                arg4.addAction(0x2000);
            }
        }

        public boolean performAccessibilityAction(View arg5, int arg6, Bundle arg7) {
            boolean v0 = true;
            if(!super.performAccessibilityAction(arg5, arg6, arg7)) {
                switch(arg6) {
                    case 4096: {
                        goto label_8;
                    }
                    case 8192: {
                        goto label_19;
                    }
                }

                return false;
            label_19:
                if(ViewPager.this.canScrollHorizontally(-1)) {
                    ViewPager.this.setCurrentItem(ViewPager.this.mCurItem - 1);
                }
                else {
                    return false;
                label_8:
                    if(ViewPager.this.canScrollHorizontally(1)) {
                        ViewPager.this.setCurrentItem(ViewPager.this.mCurItem + 1);
                    }
                    else {
                        v0 = false;
                    }
                }
            }

            return v0;
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(@NonNull ViewPager arg1, @Nullable PagerAdapter arg2, @Nullable PagerAdapter arg3);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int arg1);

        void onPageScrolled(int arg1, float arg2, int arg3);

        void onPageSelected(int arg1);
    }

    public interface PageTransformer {
        void transformPage(View arg1, float arg2);
    }

    class PagerObserver extends DataSetObserver {
        PagerObserver(ViewPager arg1) {
            ViewPager.this = arg1;
            super();
        }

        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    public class SavedState extends AbsSavedState {
        final class android.support.v4.view.ViewPager$SavedState$1 implements ParcelableCompatCreatorCallbacks {
            android.support.v4.view.ViewPager$SavedState$1() {
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
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        static {
            SavedState.CREATOR = ParcelableCompat.newCreator(new android.support.v4.view.ViewPager$SavedState$1());
        }

        public SavedState(Parcelable arg1) {
            super(arg1);
        }

        SavedState(Parcel arg2, ClassLoader arg3) {
            super(arg2, arg3);
            if(arg3 == null) {
                arg3 = this.getClass().getClassLoader();
            }

            this.position = arg2.readInt();
            this.adapterState = arg2.readParcelable(arg3);
            this.loader = arg3;
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            super.writeToParcel(arg2, arg3);
            arg2.writeInt(this.position);
            arg2.writeParcelable(this.adapterState, arg3);
        }
    }

    public class SimpleOnPageChangeListener implements OnPageChangeListener {
        public SimpleOnPageChangeListener() {
            super();
        }

        public void onPageScrollStateChanged(int arg1) {
        }

        public void onPageScrolled(int arg1, float arg2, int arg3) {
        }

        public void onPageSelected(int arg1) {
        }
    }

    class ViewPositionComparator implements Comparator {
        ViewPositionComparator() {
            super();
        }

        public int compare(View arg5, View arg6) {
            int v0_1;
            ViewGroup$LayoutParams v0 = arg5.getLayoutParams();
            ViewGroup$LayoutParams v1 = arg6.getLayoutParams();
            if(((LayoutParams)v0).isDecor == ((LayoutParams)v1).isDecor) {
                v0_1 = ((LayoutParams)v0).position - ((LayoutParams)v1).position;
            }
            else if(((LayoutParams)v0).isDecor) {
                v0_1 = 1;
            }
            else {
                v0_1 = -1;
            }

            return v0_1;
        }

        public int compare(Object arg2, Object arg3) {
            return this.compare(((View)arg2), ((View)arg3));
        }
    }

    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator COMPARATOR = null;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS = null;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE;
    private int mActivePointerId;
    PagerAdapter mAdapter;
    private List mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffectCompat mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private List mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffectCompat mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private static final Interpolator sInterpolator;
    private static final ViewPositionComparator sPositionComparator;

    static {
        ViewPager.LAYOUT_ATTRS = new int[]{0x10100B3};
        ViewPager.COMPARATOR = new android.support.v4.view.ViewPager$1();
        ViewPager.sInterpolator = new android.support.v4.view.ViewPager$2();
        ViewPager.sPositionComparator = new ViewPositionComparator();
    }

    public ViewPager(Context arg6) {
        super(arg6);
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.402823E+38f;
        this.mLastOffset = 3.402823E+38f;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new android.support.v4.view.ViewPager$3(this);
        this.mScrollState = 0;
        this.initViewPager();
    }

    public ViewPager(Context arg6, AttributeSet arg7) {
        super(arg6, arg7);
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.402823E+38f;
        this.mLastOffset = 3.402823E+38f;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new android.support.v4.view.ViewPager$3(this);
        this.mScrollState = 0;
        this.initViewPager();
    }

    public void addFocusables(ArrayList arg7, int arg8, int arg9) {
        int v1 = arg7.size();
        int v2 = this.getDescendantFocusability();
        if(v2 != 0x60000) {
            int v0;
            for(v0 = 0; v0 < this.getChildCount(); ++v0) {
                View v3 = this.getChildAt(v0);
                if(v3.getVisibility() == 0) {
                    ItemInfo v4 = this.infoForChild(v3);
                    if(v4 != null && v4.position == this.mCurItem) {
                        v3.addFocusables(arg7, arg8, arg9);
                    }
                }
            }
        }

        if((v2 != 0x40000 || v1 == arg7.size()) && (this.isFocusable()) && ((arg9 & 1) != 1 || !this.isInTouchMode() || (this.isFocusableInTouchMode())) && arg7 != null) {
            arg7.add(this);
        }
    }

    ItemInfo addNewItem(int arg3, int arg4) {
        ItemInfo v0 = new ItemInfo();
        v0.position = arg3;
        v0.object = this.mAdapter.instantiateItem(((ViewGroup)this), arg3);
        v0.widthFactor = this.mAdapter.getPageWidth(arg3);
        if(arg4 < 0 || arg4 >= this.mItems.size()) {
            this.mItems.add(v0);
        }
        else {
            this.mItems.add(arg4, v0);
        }

        return v0;
    }

    public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener arg2) {
        if(this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }

        this.mAdapterChangeListeners.add(arg2);
    }

    public void addOnPageChangeListener(OnPageChangeListener arg2) {
        if(this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }

        this.mOnPageChangeListeners.add(arg2);
    }

    public void addTouchables(ArrayList arg5) {
        int v0;
        for(v0 = 0; v0 < this.getChildCount(); ++v0) {
            View v1 = this.getChildAt(v0);
            if(v1.getVisibility() == 0) {
                ItemInfo v2 = this.infoForChild(v1);
                if(v2 != null && v2.position == this.mCurItem) {
                    v1.addTouchables(arg5);
                }
            }
        }
    }

    public void addView(View arg5, int arg6, ViewGroup$LayoutParams arg7) {
        ViewGroup$LayoutParams v1 = !this.checkLayoutParams(arg7) ? this.generateLayoutParams(arg7) : arg7;
        ViewGroup$LayoutParams v0 = v1;
        ((LayoutParams)v0).isDecor |= ViewPager.isDecorView(arg5);
        if(this.mInLayout) {
            if(v0 != null && (((LayoutParams)v0).isDecor)) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }

            ((LayoutParams)v0).needsMeasure = true;
            this.addViewInLayout(arg5, arg6, v1);
        }
        else {
            super.addView(arg5, arg6, v1);
        }
    }

    public boolean arrowScroll(int arg10) {
        boolean v0_3;
        int v3;
        int v2_1;
        int v0_2;
        View v0;
        View v1 = null;
        int v8 = 66;
        int v7 = 17;
        View v2 = this.findFocus();
        if((((ViewPager)v2)) == this) {
            v0 = v1;
        }
        else {
            if(v2 != null) {
                ViewParent v0_1 = v2.getParent();
                while(true) {
                    if(!(v0_1 instanceof ViewGroup)) {
                        break;
                    }
                    else if((((ViewPager)v0_1)) == this) {
                        v0_2 = 1;
                    }
                    else {
                        v0_1 = v0_1.getParent();
                        continue;
                    }

                    goto label_32;
                }

                v0_2 = 0;
            label_32:
                if(v0_2 != 0) {
                    goto label_87;
                }

                StringBuilder v5 = new StringBuilder();
                v5.append(v2.getClass().getSimpleName());
                for(v0_1 = v2.getParent(); (v0_1 instanceof ViewGroup); v0_1 = v0_1.getParent()) {
                    v5.append(" => ").append(v0_1.getClass().getSimpleName());
                }

                Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + v5.toString());
                v0 = v1;
                goto label_8;
            }

        label_87:
            v0 = v2;
        }

    label_8:
        v1 = FocusFinder.getInstance().findNextFocus(((ViewGroup)this), v0, arg10);
        if(v1 == null || v1 == v0) {
            if(arg10 != v7 && arg10 != 1) {
                if(arg10 != v8 && arg10 != 2) {
                label_85:
                    v0_3 = false;
                    goto label_22;
                }

                v0_3 = this.pageRight();
                goto label_22;
            }

            v0_3 = this.pageLeft();
        }
        else if(arg10 == v7) {
            v2_1 = this.getChildRectInPagerCoordinates(this.mTempRect, v1).left;
            v3 = this.getChildRectInPagerCoordinates(this.mTempRect, v0).left;
            if(v0 != null && v2_1 >= v3) {
                v0_3 = this.pageLeft();
                goto label_22;
            }

            v0_3 = v1.requestFocus();
        }
        else {
            if(arg10 != v8) {
                goto label_85;
            }

            v2_1 = this.getChildRectInPagerCoordinates(this.mTempRect, v1).left;
            v3 = this.getChildRectInPagerCoordinates(this.mTempRect, v0).left;
            if(v0 != null && v2_1 <= v3) {
                v0_3 = this.pageRight();
                goto label_22;
            }

            v0_3 = v1.requestFocus();
        }

    label_22:
        if(v0_3) {
            this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection(arg10));
        }

        return v0_3;
    }

    public boolean beginFakeDrag() {
        boolean v4 = false;
        if(!this.mIsBeingDragged) {
            this.mFakeDragging = true;
            this.setScrollState(1);
            this.mLastMotionX = 0f;
            this.mInitialMotionX = 0f;
            if(this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            else {
                this.mVelocityTracker.clear();
            }

            long v0 = SystemClock.uptimeMillis();
            MotionEvent v2 = MotionEvent.obtain(v0, v0, 0, 0f, 0f, 0);
            this.mVelocityTracker.addMovement(v2);
            v2.recycle();
            this.mFakeDragBeginTime = v0;
            v4 = true;
        }

        return v4;
    }

    private void calculatePageOffsets(ItemInfo arg12, int arg13, ItemInfo arg14) {
        int v1;
        int v2;
        float v3;
        float v10 = 1f;
        int v7 = this.mAdapter.getCount();
        int v0 = this.getClientWidth();
        float v6 = v0 > 0 ? (((float)this.mPageMargin)) / (((float)v0)) : 0f;
        if(arg14 != null) {
            v0 = arg14.position;
            if(v0 < arg12.position) {
                v3 = arg14.offset + arg14.widthFactor + v6;
                v2 = v0 + 1;
                v1 = 0;
                while(v2 <= arg12.position) {
                    if(v1 >= this.mItems.size()) {
                        break;
                    }

                    Object v0_1;
                    for(v0_1 = this.mItems.get(v1); v2 > ((ItemInfo)v0_1).position; v0_1 = this.mItems.get(v1)) {
                        if(v1 >= this.mItems.size() - 1) {
                            break;
                        }

                        ++v1;
                    }

                    while(v2 < ((ItemInfo)v0_1).position) {
                        v3 += this.mAdapter.getPageWidth(v2) + v6;
                        ++v2;
                    }

                    ((ItemInfo)v0_1).offset = v3;
                    v3 += ((ItemInfo)v0_1).widthFactor + v6;
                    ++v2;
                }
            }
            else {
                if(v0 <= arg12.position) {
                    goto label_88;
                }

                v1 = this.mItems.size() - 1;
                v3 = arg14.offset;
                for(v2 = v0 - 1; v2 >= arg12.position; --v2) {
                    if(v1 < 0) {
                        break;
                    }

                    for(v0_1 = this.mItems.get(v1); v2 < ((ItemInfo)v0_1).position; v0_1 = this.mItems.get(v1)) {
                        if(v1 <= 0) {
                            break;
                        }

                        --v1;
                    }

                    while(v2 > ((ItemInfo)v0_1).position) {
                        v3 -= this.mAdapter.getPageWidth(v2) + v6;
                        --v2;
                    }

                    v3 -= ((ItemInfo)v0_1).widthFactor + v6;
                    ((ItemInfo)v0_1).offset = v3;
                }
            }
        }

    label_88:
        int v8 = this.mItems.size();
        float v2_1 = arg12.offset;
        v1 = arg12.position - 1;
        float v0_2 = arg12.position == 0 ? arg12.offset : -3.402823E+38f;
        this.mFirstOffset = v0_2;
        v0_2 = arg12.position == v7 - 1 ? arg12.offset + arg12.widthFactor - v10 : 3.402823E+38f;
        this.mLastOffset = v0_2;
        int v5;
        for(v5 = arg13 - 1; v5 >= 0; --v5) {
            v0_1 = this.mItems.get(v5);
            v3 = v2_1;
            while(v1 > ((ItemInfo)v0_1).position) {
                v3 -= this.mAdapter.getPageWidth(v1) + v6;
                --v1;
            }

            v2_1 = v3 - (((ItemInfo)v0_1).widthFactor + v6);
            ((ItemInfo)v0_1).offset = v2_1;
            if(((ItemInfo)v0_1).position == 0) {
                this.mFirstOffset = v2_1;
            }

            --v1;
        }

        v2_1 = arg12.offset + arg12.widthFactor + v6;
        v1 = arg12.position + 1;
        for(v5 = arg13 + 1; v5 < v8; ++v5) {
            v0_1 = this.mItems.get(v5);
            v3 = v2_1;
            while(v1 < ((ItemInfo)v0_1).position) {
                v3 = this.mAdapter.getPageWidth(v1) + v6 + v3;
                ++v1;
            }

            if(((ItemInfo)v0_1).position == v7 - 1) {
                this.mLastOffset = ((ItemInfo)v0_1).widthFactor + v3 - v10;
            }

            ((ItemInfo)v0_1).offset = v3;
            v2_1 = v3 + (((ItemInfo)v0_1).widthFactor + v6);
            ++v1;
        }

        this.mNeedCalculatePageOffsets = false;
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
            if((arg12) && (ViewCompat.canScrollHorizontally(arg11, -arg13))) {
                return v2;
            }

            v2 = false;
        }

        return v2;
    }

    public boolean canScrollHorizontally(int arg6) {
        boolean v0 = true;
        boolean v1 = false;
        if(this.mAdapter != null) {
            int v2 = this.getClientWidth();
            int v3 = this.getScrollX();
            if(arg6 < 0) {
                if(v3 <= (((int)((((float)v2)) * this.mFirstOffset)))) {
                    v0 = false;
                }

                v1 = v0;
            }
            else {
                if(arg6 <= 0) {
                    return v1;
                }

                if(v3 >= (((int)((((float)v2)) * this.mLastOffset)))) {
                    v0 = false;
                }

                v1 = v0;
            }
        }

        return v1;
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg2) {
        boolean v0 = !(arg2 instanceof LayoutParams) || !super.checkLayoutParams(arg2) ? false : true;
        return v0;
    }

    public void clearOnPageChangeListeners() {
        if(this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.clear();
        }
    }

    private void completeScroll(boolean arg8) {
        int v3;
        int v1;
        int v0 = this.mScrollState == 2 ? 1 : 0;
        if(v0 != 0) {
            this.setScrollingCacheEnabled(false);
            v1 = !this.mScroller.isFinished() ? 1 : 0;
            if(v1 == 0) {
                goto label_26;
            }

            this.mScroller.abortAnimation();
            v1 = this.getScrollX();
            v3 = this.getScrollY();
            int v5 = this.mScroller.getCurrX();
            int v6 = this.mScroller.getCurrY();
            if(v1 == v5 && v3 == v6) {
                goto label_26;
            }

            this.scrollTo(v5, v6);
            if(v5 == v1) {
                goto label_26;
            }

            this.pageScrolled(v5);
        }

    label_26:
        this.mPopulatePending = false;
        v1 = 0;
        v3 = v0;
        while(v1 < this.mItems.size()) {
            Object v0_1 = this.mItems.get(v1);
            if(((ItemInfo)v0_1).scrolling) {
                ((ItemInfo)v0_1).scrolling = false;
                v3 = 1;
            }

            ++v1;
        }

        if(v3 != 0) {
            if(arg8) {
                ViewCompat.postOnAnimation(((View)this), this.mEndScrollRunnable);
            }
            else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if((this.mScroller.isFinished()) || !this.mScroller.computeScrollOffset()) {
            this.completeScroll(true);
        }
        else {
            int v0 = this.getScrollX();
            int v1 = this.getScrollY();
            int v2 = this.mScroller.getCurrX();
            int v3 = this.mScroller.getCurrY();
            if(v0 != v2 || v1 != v3) {
                this.scrollTo(v2, v3);
                if(!this.pageScrolled(v2)) {
                    this.mScroller.abortAnimation();
                    this.scrollTo(0, v3);
                }
            }

            ViewCompat.postInvalidateOnAnimation(((View)this));
        }
    }

    void dataSetChanged() {
        int v8 = this.mAdapter.getCount();
        this.mExpectedAdapterCount = v8;
        int v0 = this.mItems.size() >= this.mOffscreenPageLimit * 2 + 1 || this.mItems.size() >= v8 ? 0 : 1;
        int v4 = 0;
        int v5 = this.mCurItem;
        int v6 = v0;
        int v3;
        for(v3 = 0; v3 < this.mItems.size(); v3 = v0 + 1) {
            Object v0_1 = this.mItems.get(v3);
            int v7 = this.mAdapter.getItemPosition(((ItemInfo)v0_1).object);
            if(v7 == -1) {
                v0 = v3;
                v3 = v4;
                v4 = v5;
                v5 = v6;
            }
            else if(v7 == -2) {
                this.mItems.remove(v3);
                --v3;
                if(v4 == 0) {
                    this.mAdapter.startUpdate(((ViewGroup)this));
                    v4 = 1;
                }

                this.mAdapter.destroyItem(((ViewGroup)this), ((ItemInfo)v0_1).position, ((ItemInfo)v0_1).object);
                if(this.mCurItem == ((ItemInfo)v0_1).position) {
                    v0 = v3;
                    v3 = v4;
                    v4 = Math.max(0, Math.min(this.mCurItem, v8 - 1));
                    v5 = 1;
                    goto label_34;
                }

                v0 = v3;
                v3 = v4;
                v4 = v5;
                v5 = 1;
            }
            else {
                if(((ItemInfo)v0_1).position != v7) {
                    if(((ItemInfo)v0_1).position == this.mCurItem) {
                        v5 = v7;
                    }

                    ((ItemInfo)v0_1).position = v7;
                    v0 = v3;
                    v3 = v4;
                    v4 = v5;
                    v5 = 1;
                    goto label_34;
                }

                v0 = v3;
                v3 = v4;
                v4 = v5;
                v5 = v6;
            }

        label_34:
            v6 = v5;
            v5 = v4;
            v4 = v3;
        }

        if(v4 != 0) {
            this.mAdapter.finishUpdate(((ViewGroup)this));
        }

        Collections.sort(this.mItems, ViewPager.COMPARATOR);
        if(v6 != 0) {
            v4 = this.getChildCount();
            for(v3 = 0; v3 < v4; ++v3) {
                ViewGroup$LayoutParams v0_2 = this.getChildAt(v3).getLayoutParams();
                if(!((LayoutParams)v0_2).isDecor) {
                    ((LayoutParams)v0_2).widthFactor = 0f;
                }
            }

            this.setCurrentItemInternal(v5, false, true);
            this.requestLayout();
        }
    }

    private int determineTargetPage(int arg4, float arg5, int arg6, int arg7) {
        if(Math.abs(arg7) <= this.mFlingDistance || Math.abs(arg6) <= this.mMinimumVelocity) {
            float v0 = arg4 >= this.mCurItem ? 0.4f : 0.6f;
            arg4 += ((int)(v0 + arg5));
        }
        else if(arg6 <= 0) {
            ++arg4;
        }

        if(this.mItems.size() > 0) {
            arg4 = Math.max(this.mItems.get(0).position, Math.min(arg4, this.mItems.get(this.mItems.size() - 1).position));
        }

        return arg4;
    }

    public boolean dispatchKeyEvent(KeyEvent arg2) {
        boolean v0 = (super.dispatchKeyEvent(arg2)) || (this.executeKeyEvent(arg2)) ? true : false;
        return v0;
    }

    private void dispatchOnPageScrolled(int arg4, float arg5, int arg6) {
        if(this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(arg4, arg5, arg6);
        }

        if(this.mOnPageChangeListeners != null) {
            int v2 = this.mOnPageChangeListeners.size();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                Object v0 = this.mOnPageChangeListeners.get(v1);
                if(v0 != null) {
                    ((OnPageChangeListener)v0).onPageScrolled(arg4, arg5, arg6);
                }
            }
        }

        if(this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(arg4, arg5, arg6);
        }
    }

    private void dispatchOnPageSelected(int arg4) {
        if(this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(arg4);
        }

        if(this.mOnPageChangeListeners != null) {
            int v2 = this.mOnPageChangeListeners.size();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                Object v0 = this.mOnPageChangeListeners.get(v1);
                if(v0 != null) {
                    ((OnPageChangeListener)v0).onPageSelected(arg4);
                }
            }
        }

        if(this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageSelected(arg4);
        }
    }

    private void dispatchOnScrollStateChanged(int arg4) {
        if(this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(arg4);
        }

        if(this.mOnPageChangeListeners != null) {
            int v2 = this.mOnPageChangeListeners.size();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                Object v0 = this.mOnPageChangeListeners.get(v1);
                if(v0 != null) {
                    ((OnPageChangeListener)v0).onPageScrollStateChanged(arg4);
                }
            }
        }

        if(this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrollStateChanged(arg4);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent arg7) {
        boolean v0 = false;
        if(arg7.getEventType() == 0x1000) {
            v0 = super.dispatchPopulateAccessibilityEvent(arg7);
        }
        else {
            int v2 = this.getChildCount();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                View v3 = this.getChildAt(v1);
                if(v3.getVisibility() == 0) {
                    ItemInfo v4 = this.infoForChild(v3);
                    if(v4 != null && v4.position == this.mCurItem && (v3.dispatchPopulateAccessibilityEvent(arg7))) {
                        return true;
                    }
                }
            }
        }

        return v0;
    }

    float distanceInfluenceForSnapDuration(float arg5) {
        return ((float)Math.sin(((double)(((float)((((double)(arg5 - 0.5f))) * 0.471239))))));
    }

    public void draw(Canvas arg8) {
        int v3;
        int v2;
        super.draw(arg8);
        int v0 = 0;
        int v1 = this.getOverScrollMode();
        if(v1 != 0) {
            if(v1 == 1 && this.mAdapter != null && this.mAdapter.getCount() > 1) {
                goto label_11;
            }

            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        else {
        label_11:
            if(!this.mLeftEdge.isFinished()) {
                v1 = arg8.save();
                v2 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                v3 = this.getWidth();
                arg8.rotate(270f);
                arg8.translate(((float)(-v2 + this.getPaddingTop())), this.mFirstOffset * (((float)v3)));
                this.mLeftEdge.setSize(v2, v3);
                v0 = 0 | this.mLeftEdge.draw(arg8);
                arg8.restoreToCount(v1);
            }

            if(this.mRightEdge.isFinished()) {
                goto label_65;
            }

            v1 = arg8.save();
            v2 = this.getWidth();
            v3 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
            arg8.rotate(90f);
            arg8.translate(((float)(-this.getPaddingTop())), -(this.mLastOffset + 1f) * (((float)v2)));
            this.mRightEdge.setSize(v3, v2);
            v0 |= this.mRightEdge.draw(arg8);
            arg8.restoreToCount(v1);
        }

    label_65:
        if(v0 != 0) {
            ViewCompat.postInvalidateOnAnimation(((View)this));
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable v0 = this.mMarginDrawable;
        if(v0 != null && (v0.isStateful())) {
            v0.setState(this.getDrawableState());
        }
    }

    private void enableLayers(boolean arg7) {
        int v3 = this.getChildCount();
        int v2;
        for(v2 = 0; v2 < v3; ++v2) {
            int v0 = arg7 ? this.mPageTransformerLayerType : 0;
            ViewCompat.setLayerType(this.getChildAt(v2), v0, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        if(this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void endFakeDrag() {
        if(!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }

        if(this.mAdapter != null) {
            VelocityTracker v0 = this.mVelocityTracker;
            v0.computeCurrentVelocity(1000, ((float)this.mMaximumVelocity));
            int v0_1 = ((int)VelocityTrackerCompat.getXVelocity(v0, this.mActivePointerId));
            this.mPopulatePending = true;
            int v1 = this.getClientWidth();
            int v2 = this.getScrollX();
            ItemInfo v3 = this.infoForCurrentScrollPosition();
            this.setCurrentItemInternal(this.determineTargetPage(v3.position, ((((float)v2)) / (((float)v1)) - v3.offset) / v3.widthFactor, v0_1, ((int)(this.mLastMotionX - this.mInitialMotionX))), true, true, v0_1);
        }

        this.endDrag();
        this.mFakeDragging = false;
    }

    public boolean executeKeyEvent(KeyEvent arg5) {
        boolean v0 = false;
        if(arg5.getAction() == 0) {
            switch(arg5.getKeyCode()) {
                case 21: {
                    goto label_7;
                }
                case 22: {
                    goto label_10;
                }
                case 61: {
                    goto label_13;
                }
            }

            return v0;
        label_7:
            return this.arrowScroll(17);
        label_10:
            return this.arrowScroll(66);
        label_13:
            if(Build$VERSION.SDK_INT >= 11) {
                if(KeyEventCompat.hasNoModifiers(arg5)) {
                    v0 = this.arrowScroll(2);
                }
                else if(KeyEventCompat.hasModifiers(arg5, 1)) {
                    v0 = this.arrowScroll(1);
                }
            }
        }

        return v0;
    }

    public void fakeDragBy(float arg9) {
        if(!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }

        if(this.mAdapter != null) {
            this.mLastMotionX += arg9;
            float v3 = (((float)this.getScrollX())) - arg9;
            int v5 = this.getClientWidth();
            float v2 = (((float)v5)) * this.mFirstOffset;
            float v4 = (((float)v5)) * this.mLastOffset;
            Object v0 = this.mItems.get(0);
            Object v1 = this.mItems.get(this.mItems.size() - 1);
            float v0_1 = ((ItemInfo)v0).position != 0 ? ((ItemInfo)v0).offset * (((float)v5)) : v2;
            float v1_1 = ((ItemInfo)v1).position != this.mAdapter.getCount() - 1 ? ((ItemInfo)v1).offset * (((float)v5)) : v4;
            if(v3 >= v0_1) {
                v0_1 = v3 > v1_1 ? v1_1 : v3;
            }

            this.mLastMotionX += v0_1 - (((float)(((int)v0_1))));
            this.scrollTo(((int)v0_1), this.getScrollY());
            this.pageScrolled(((int)v0_1));
            MotionEvent v0_2 = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0f, 0);
            this.mVelocityTracker.addMovement(v0_2);
            v0_2.recycle();
        }
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg2) {
        return this.generateDefaultLayoutParams();
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg3) {
        return new LayoutParams(this.getContext(), arg3);
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    protected int getChildDrawingOrder(int arg3, int arg4) {
        if(this.mDrawingOrder == 2) {
            arg4 = arg3 - 1 - arg4;
        }

        return this.mDrawingOrderedChildren.get(arg4).getLayoutParams().childIndex;
    }

    private Rect getChildRectInPagerCoordinates(Rect arg5, View arg6) {
        Rect v0;
        Rect v1 = arg5 == null ? new Rect() : arg5;
        if(arg6 == null) {
            v1.set(0, 0, 0, 0);
            v0 = v1;
        }
        else {
            v1.left = arg6.getLeft();
            v1.right = arg6.getRight();
            v1.top = arg6.getTop();
            v1.bottom = arg6.getBottom();
            ViewParent v0_1;
            for(v0_1 = arg6.getParent(); (v0_1 instanceof ViewGroup); v0_1 = ((ViewGroup)v0_1).getParent()) {
                if((((ViewPager)v0_1)) == this) {
                    break;
                }

                v1.left += ((ViewGroup)v0_1).getLeft();
                v1.right += ((ViewGroup)v0_1).getRight();
                v1.top += ((ViewGroup)v0_1).getTop();
                v1.bottom += ((ViewGroup)v0_1).getBottom();
            }

            v0 = v1;
        }

        return v0;
    }

    private int getClientWidth() {
        return this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    ItemInfo infoForAnyChild(View arg3) {
        ViewParent v3;
        while(true) {
            ViewParent v0 = arg3.getParent();
            if((((ViewPager)v0)) != this) {
                if(v0 != null && ((v0 instanceof View))) {
                    v3 = v0;
                    continue;
                }

                break;
            }
            else {
                goto label_9;
            }
        }

        ItemInfo v0_1 = null;
        return v0_1;
    label_9:
        return this.infoForChild(((View)v3));
    }

    ItemInfo infoForChild(View arg5) {
        ItemInfo v0_1;
        int v1 = 0;
        while(true) {
            if(v1 < this.mItems.size()) {
                Object v0 = this.mItems.get(v1);
                if(!this.mAdapter.isViewFromObject(arg5, ((ItemInfo)v0).object)) {
                    ++v1;
                    continue;
                }
            }
            else {
                break;
            }

            return v0_1;
        }

        v0_1 = null;
        return v0_1;
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int v0_2;
        Object v2_2;
        int v1 = this.getClientWidth();
        float v9 = v1 > 0 ? (((float)this.getScrollX())) / (((float)v1)) : 0f;
        float v1_1 = v1 > 0 ? (((float)this.mPageMargin)) / (((float)v1)) : 0f;
        float v6 = 0f;
        float v7 = 0f;
        int v8 = -1;
        int v2 = 0;
        int v5 = 1;
        ItemInfo v4 = null;
        while(true) {
            if(v2 < this.mItems.size()) {
                Object v0 = this.mItems.get(v2);
                if(v5 != 0 || ((ItemInfo)v0).position == v8 + 1) {
                    Object v12_1 = v0;
                    v0_2 = v2;
                    v2_2 = v12_1;
                }
                else {
                    ItemInfo v0_1 = this.mTempItem;
                    v0_1.offset = v6 + v7 + v1_1;
                    v0_1.position = v8 + 1;
                    ((ItemInfo)v0).widthFactor = this.mAdapter.getPageWidth(((ItemInfo)v0).position);
                    ItemInfo v12 = v0_1;
                    v0_2 = v2 - 1;
                    ItemInfo v2_1 = v12;
                }

                v6 = ((ItemInfo)v2_2).offset;
                v7 = ((ItemInfo)v2_2).widthFactor + v6 + v1_1;
                if(v5 == 0 && v9 < v6) {
                    return v4;
                }

                if(v9 >= v7 && v0_2 != this.mItems.size() - 1) {
                    v7 = v6;
                    v8 = ((ItemInfo)v2_2).position;
                    v5 = 0;
                    v6 = ((ItemInfo)v2_2).widthFactor;
                    v4 = ((ItemInfo)v2_2);
                    v2 = v0_2 + 1;
                    continue;
                }

                break;
            }

            return v4;
        }

        return ((ItemInfo)v2_2);
    }

    ItemInfo infoForPosition(int arg4) {
        Object v0;
        int v1 = 0;
        while(true) {
            if(v1 < this.mItems.size()) {
                v0 = this.mItems.get(v1);
                if(((ItemInfo)v0).position != arg4) {
                    ++v1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_9;
        }

        ItemInfo v0_1 = null;
    label_9:
        return ((ItemInfo)v0);
    }

    void initViewPager() {
        this.setWillNotDraw(false);
        this.setDescendantFocusability(0x40000);
        this.setFocusable(true);
        Context v0 = this.getContext();
        this.mScroller = new Scroller(v0, ViewPager.sInterpolator);
        ViewConfiguration v1 = ViewConfiguration.get(v0);
        float v2 = v0.getResources().getDisplayMetrics().density;
        this.mTouchSlop = v1.getScaledPagingTouchSlop();
        this.mMinimumVelocity = ((int)(400f * v2));
        this.mMaximumVelocity = v1.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffectCompat(v0);
        this.mRightEdge = new EdgeEffectCompat(v0);
        this.mFlingDistance = ((int)(25f * v2));
        this.mCloseEnough = ((int)(2f * v2));
        this.mDefaultGutterSize = ((int)(16f * v2));
        ViewCompat.setAccessibilityDelegate(((View)this), new MyAccessibilityDelegate(this));
        if(ViewCompat.getImportantForAccessibility(((View)this)) == 0) {
            ViewCompat.setImportantForAccessibility(((View)this), 1);
        }

        ViewCompat.setOnApplyWindowInsetsListener(((View)this), new OnApplyWindowInsetsListener() {
            private final Rect mTempRect;

            public WindowInsetsCompat onApplyWindowInsets(View arg8, WindowInsetsCompat arg9) {
                WindowInsetsCompat v0 = ViewCompat.onApplyWindowInsets(arg8, arg9);
                if(!v0.isConsumed()) {
                    Rect v2 = this.mTempRect;
                    v2.left = v0.getSystemWindowInsetLeft();
                    v2.top = v0.getSystemWindowInsetTop();
                    v2.right = v0.getSystemWindowInsetRight();
                    v2.bottom = v0.getSystemWindowInsetBottom();
                    int v1 = 0;
                    int v3 = ViewPager.this.getChildCount();
                    while(v1 < v3) {
                        WindowInsetsCompat v4 = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(v1), v0);
                        v2.left = Math.min(v4.getSystemWindowInsetLeft(), v2.left);
                        v2.top = Math.min(v4.getSystemWindowInsetTop(), v2.top);
                        v2.right = Math.min(v4.getSystemWindowInsetRight(), v2.right);
                        v2.bottom = Math.min(v4.getSystemWindowInsetBottom(), v2.bottom);
                        ++v1;
                    }

                    v0 = v0.replaceSystemWindowInsets(v2.left, v2.top, v2.right, v2.bottom);
                }

                return v0;
            }
        });
    }

    private static boolean isDecorView(@NonNull View arg2) {
        boolean v0 = arg2.getClass().getAnnotation(DecorView.class) != null ? true : false;
        return v0;
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private boolean isGutterDrag(float arg4, float arg5) {
        boolean v0;
        if(arg4 >= (((float)this.mGutterSize)) || arg5 <= 0f) {
            if(arg4 > (((float)(this.getWidth() - this.mGutterSize))) && arg5 < 0f) {
            label_11:
                v0 = true;
                return v0;
            }

            v0 = false;
        }
        else {
            goto label_11;
        }

        return v0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.mEndScrollRunnable);
        if(this.mScroller != null && !this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }

        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas arg17) {
        float v3_1;
        super.onDraw(arg17);
        if(this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int v6 = this.getScrollX();
            int v7 = this.getWidth();
            float v8 = (((float)this.mPageMargin)) / (((float)v7));
            Object v1 = this.mItems.get(0);
            float v4 = ((ItemInfo)v1).offset;
            int v9 = this.mItems.size();
            int v3 = ((ItemInfo)v1).position;
            int v10 = this.mItems.get(v9 - 1).position;
            int v2 = 0;
            int v5;
            for(v5 = v3; v5 < v10; ++v5) {
                while(v5 > ((ItemInfo)v1).position) {
                    if(v2 >= v9) {
                        break;
                    }

                    ++v2;
                    v1 = this.mItems.get(v2);
                }

                if(v5 == ((ItemInfo)v1).position) {
                    v3_1 = (((ItemInfo)v1).offset + ((ItemInfo)v1).widthFactor) * (((float)v7));
                    v4 = ((ItemInfo)v1).offset + ((ItemInfo)v1).widthFactor + v8;
                }
                else {
                    float v11 = this.mAdapter.getPageWidth(v5);
                    v3_1 = (v4 + v11) * (((float)v7));
                    v4 += v11 + v8;
                }

                if((((float)this.mPageMargin)) + v3_1 > (((float)v6))) {
                    this.mMarginDrawable.setBounds(Math.round(v3_1), this.mTopPageBounds, Math.round((((float)this.mPageMargin)) + v3_1), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(arg17);
                }

                if(v3_1 > (((float)(v6 + v7)))) {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent arg14) {
        float v0_1;
        boolean v2 = false;
        int v0 = arg14.getAction() & 0xFF;
        if(v0 == 3 || v0 == 1) {
            this.resetTouch();
        }
        else {
            if(v0 != 0) {
                if(this.mIsBeingDragged) {
                    v2 = true;
                }
                else if(!this.mIsUnableToDrag) {
                    goto label_17;
                }

                return v2;
            }

        label_17:
            switch(v0) {
                case 0: {
                    v0_1 = arg14.getX();
                    this.mInitialMotionX = v0_1;
                    this.mLastMotionX = v0_1;
                    v0_1 = arg14.getY();
                    this.mInitialMotionY = v0_1;
                    this.mLastMotionY = v0_1;
                    this.mActivePointerId = arg14.getPointerId(0);
                    this.mIsUnableToDrag = false;
                    this.mIsScrollStarted = true;
                    this.mScroller.computeScrollOffset();
                    if(this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                        this.mScroller.abortAnimation();
                        this.mPopulatePending = false;
                        this.populate();
                        this.mIsBeingDragged = true;
                        this.requestParentDisallowInterceptTouchEvent(true);
                        this.setScrollState(1);
                        goto label_18;
                    }

                    this.completeScroll(false);
                    this.mIsBeingDragged = false;
                    break;
                }
                case 2: {
                    v0 = this.mActivePointerId;
                    if(v0 == -1) {
                        goto label_18;
                    }

                    v0 = arg14.findPointerIndex(v0);
                    float v7 = arg14.getX(v0);
                    float v8 = v7 - this.mLastMotionX;
                    float v9 = Math.abs(v8);
                    float v10 = arg14.getY(v0);
                    float v11 = Math.abs(v10 - this.mInitialMotionY);
                    if(v8 != 0f && !this.isGutterDrag(this.mLastMotionX, v8) && (this.canScroll(this, false, ((int)v8), ((int)v7), ((int)v10)))) {
                        this.mLastMotionX = v7;
                        this.mLastMotionY = v10;
                        this.mIsUnableToDrag = true;
                        return v2;
                    }

                    if(v9 <= (((float)this.mTouchSlop)) || 0.5f * v9 <= v11) {
                        if(v11 <= (((float)this.mTouchSlop))) {
                            goto label_70;
                        }

                        this.mIsUnableToDrag = true;
                    }
                    else {
                        this.mIsBeingDragged = true;
                        this.requestParentDisallowInterceptTouchEvent(true);
                        this.setScrollState(1);
                        v0_1 = v8 > 0f ? this.mInitialMotionX + (((float)this.mTouchSlop)) : this.mInitialMotionX - (((float)this.mTouchSlop));
                        this.mLastMotionX = v0_1;
                        this.mLastMotionY = v10;
                        this.setScrollingCacheEnabled(true);
                    }

                label_70:
                    if(!this.mIsBeingDragged) {
                        goto label_18;
                    }

                    if(!this.performDrag(v7)) {
                        goto label_18;
                    }

                    ViewCompat.postInvalidateOnAnimation(((View)this));
                    break;
                }
                case 6: {
                    this.onSecondaryPointerUp(arg14);
                    break;
                }
            }

        label_18:
            if(this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }

            this.mVelocityTracker.addMovement(arg14);
            v2 = this.mIsBeingDragged;
        }

        return v2;
    }

    protected void onLayout(boolean arg18, int arg19, int arg20, int arg21, int arg22) {
        int v16;
        int v1_1;
        int v7;
        ViewGroup$LayoutParams v1;
        int v9 = this.getChildCount();
        int v10 = arg21 - arg19;
        int v11 = arg22 - arg20;
        int v6 = this.getPaddingLeft();
        int v2 = this.getPaddingTop();
        int v5 = this.getPaddingRight();
        int v3 = this.getPaddingBottom();
        int v12 = this.getScrollX();
        int v4 = 0;
        int v8 = 0;
        while(v8 < v9) {
            View v13 = this.getChildAt(v8);
            if(v13.getVisibility() != 8) {
                v1 = v13.getLayoutParams();
                if(((LayoutParams)v1).isDecor) {
                    v7 = ((LayoutParams)v1).gravity & 7;
                    int v14 = ((LayoutParams)v1).gravity & 0x70;
                    switch(v7) {
                        case 1: {
                            v7 = Math.max((v10 - v13.getMeasuredWidth()) / 2, v6);
                            break;
                        }
                        case 3: {
                            v7 = v6;
                            v6 = v13.getMeasuredWidth() + v6;
                            break;
                        }
                        case 5: {
                            v1_1 = v10 - v5 - v13.getMeasuredWidth();
                            v5 += v13.getMeasuredWidth();
                            v7 = v1_1;
                            break;
                        }
                        default: {
                            v7 = v6;
                            break;
                        }
                    }

                    switch(v14) {
                        case 16: {
                            v1_1 = Math.max((v11 - v13.getMeasuredHeight()) / 2, v2);
                            v16 = v3;
                            v3 = v2;
                            v2 = v16;
                            break;
                        }
                        case 48: {
                            v1_1 = v13.getMeasuredHeight() + v2;
                            v16 = v2;
                            v2 = v3;
                            v3 = v1_1;
                            v1_1 = v16;
                            break;
                        }
                        case 80: {
                            v1_1 = v11 - v3 - v13.getMeasuredHeight();
                            v16 = v3 + v13.getMeasuredHeight();
                            v3 = v2;
                            v2 = v16;
                            break;
                        }
                        default: {
                            v1_1 = v2;
                            v16 = v3;
                            v3 = v2;
                            v2 = v16;
                            break;
                        }
                    }

                    v7 += v12;
                    v13.layout(v7, v1_1, v13.getMeasuredWidth() + v7, v13.getMeasuredHeight() + v1_1);
                    v1_1 = v4 + 1;
                    v4 = v3;
                    v3 = v2;
                    v2 = v5;
                    v5 = v6;
                }
                else {
                    goto label_156;
                }
            }
            else {
            label_156:
                v1_1 = v4;
                v4 = v2;
                v2 = v5;
                v5 = v6;
            }

            ++v8;
            v6 = v5;
            v5 = v2;
            v2 = v4;
            v4 = v1_1;
        }

        v7 = v10 - v6 - v5;
        for(v5 = 0; v5 < v9; ++v5) {
            View v8_1 = this.getChildAt(v5);
            if(v8_1.getVisibility() != 8) {
                v1 = v8_1.getLayoutParams();
                if(!((LayoutParams)v1).isDecor) {
                    ItemInfo v10_1 = this.infoForChild(v8_1);
                    if(v10_1 != null) {
                        v10 = (((int)(v10_1.offset * (((float)v7))))) + v6;
                        if(((LayoutParams)v1).needsMeasure) {
                            ((LayoutParams)v1).needsMeasure = false;
                            v8_1.measure(View$MeasureSpec.makeMeasureSpec(((int)(((LayoutParams)v1).widthFactor * (((float)v7)))), 0x40000000), View$MeasureSpec.makeMeasureSpec(v11 - v2 - v3, 0x40000000));
                        }

                        v8_1.layout(v10, v2, v8_1.getMeasuredWidth() + v10, v8_1.getMeasuredHeight() + v2);
                    }
                }
            }
        }

        this.mTopPageBounds = v2;
        this.mBottomPageBounds = v11 - v3;
        this.mDecorChildCount = v4;
        if(this.mFirstLayout) {
            this.scrollToItem(this.mCurItem, false, 0, false);
        }

        this.mFirstLayout = false;
    }

    protected void onMeasure(int arg14, int arg15) {
        int v1;
        int v2;
        ViewGroup$LayoutParams v0_1;
        this.setMeasuredDimension(ViewPager.getDefaultSize(0, arg14), ViewPager.getDefaultSize(0, arg15));
        int v0 = this.getMeasuredWidth();
        this.mGutterSize = Math.min(v0 / 10, this.mDefaultGutterSize);
        int v3 = v0 - this.getPaddingLeft() - this.getPaddingRight();
        int v5 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
        int v9 = this.getChildCount();
        int v8;
        for(v8 = 0; v8 < v9; ++v8) {
            View v10 = this.getChildAt(v8);
            if(v10.getVisibility() != 8) {
                v0_1 = v10.getLayoutParams();
                if(v0_1 != null && (((LayoutParams)v0_1).isDecor)) {
                    int v6 = ((LayoutParams)v0_1).gravity & 7;
                    int v4 = ((LayoutParams)v0_1).gravity & 0x70;
                    v2 = 0x80000000;
                    v1 = 0x80000000;
                    int v7 = v4 == 0x30 || v4 == 80 ? 1 : 0;
                    v6 = v6 == 3 || v6 == 5 ? 1 : 0;
                    if(v7 != 0) {
                        v2 = 0x40000000;
                    }
                    else if(v6 != 0) {
                        v1 = 0x40000000;
                    }

                    if(((LayoutParams)v0_1).width != -2) {
                        v4 = 0x40000000;
                        v2 = ((LayoutParams)v0_1).width != -1 ? ((LayoutParams)v0_1).width : v3;
                    }
                    else {
                        v4 = v2;
                        v2 = v3;
                    }

                    if(((LayoutParams)v0_1).height != -2) {
                        v1 = 0x40000000;
                        if(((LayoutParams)v0_1).height != -1) {
                            v0 = ((LayoutParams)v0_1).height;
                        }
                        else {
                            goto label_124;
                        }
                    }
                    else {
                    label_124:
                        v0 = v5;
                    }

                    v10.measure(View$MeasureSpec.makeMeasureSpec(v2, v4), View$MeasureSpec.makeMeasureSpec(v0, v1));
                    if(v7 != 0) {
                        v5 -= v10.getMeasuredHeight();
                        goto label_73;
                    }

                    if(v6 == 0) {
                        goto label_73;
                    }

                    v3 -= v10.getMeasuredWidth();
                }
            }

        label_73:
        }

        this.mChildWidthMeasureSpec = View$MeasureSpec.makeMeasureSpec(v3, 0x40000000);
        this.mChildHeightMeasureSpec = View$MeasureSpec.makeMeasureSpec(v5, 0x40000000);
        this.mInLayout = true;
        this.populate();
        this.mInLayout = false;
        v2 = this.getChildCount();
        for(v1 = 0; v1 < v2; ++v1) {
            View v4_1 = this.getChildAt(v1);
            if(v4_1.getVisibility() != 8) {
                v0_1 = v4_1.getLayoutParams();
                if(v0_1 != null && (((LayoutParams)v0_1).isDecor)) {
                    goto label_120;
                }

                v4_1.measure(View$MeasureSpec.makeMeasureSpec(((int)(((LayoutParams)v0_1).widthFactor * (((float)v3)))), 0x40000000), this.mChildHeightMeasureSpec);
            }

        label_120:
        }
    }

    @CallSuper protected void onPageScrolled(int arg12, float arg13, int arg14) {
        int v0_1;
        int v10;
        int v4;
        int v2;
        int v1;
        if(this.mDecorChildCount > 0) {
            int v5 = this.getScrollX();
            v1 = this.getPaddingLeft();
            v2 = this.getPaddingRight();
            int v6 = this.getWidth();
            int v7 = this.getChildCount();
            v4 = 0;
            while(v4 < v7) {
                View v8 = this.getChildAt(v4);
                ViewGroup$LayoutParams v0 = v8.getLayoutParams();
                if(!((LayoutParams)v0).isDecor) {
                    v10 = v2;
                    v2 = v1;
                    v1 = v10;
                }
                else {
                    switch(((LayoutParams)v0).gravity & 7) {
                        case 1: {
                            v0_1 = Math.max((v6 - v8.getMeasuredWidth()) / 2, v1);
                            v10 = v2;
                            v2 = v1;
                            v1 = v10;
                            break;
                        }
                        case 3: {
                            v0_1 = v8.getWidth() + v1;
                            v10 = v1;
                            v1 = v2;
                            v2 = v0_1;
                            v0_1 = v10;
                            break;
                        }
                        case 5: {
                            v0_1 = v6 - v2 - v8.getMeasuredWidth();
                            v10 = v2 + v8.getMeasuredWidth();
                            v2 = v1;
                            v1 = v10;
                            break;
                        }
                        default: {
                            v0_1 = v1;
                            v10 = v2;
                            v2 = v1;
                            v1 = v10;
                            break;
                        }
                    }

                    v0_1 = v0_1 + v5 - v8.getLeft();
                    if(v0_1 != 0) {
                        v8.offsetLeftAndRight(v0_1);
                    }
                }

                ++v4;
                v10 = v1;
                v1 = v2;
                v2 = v10;
            }
        }

        this.dispatchOnPageScrolled(arg12, arg13, arg14);
        if(this.mPageTransformer != null) {
            v2 = this.getScrollX();
            v4 = this.getChildCount();
            for(v1 = 0; v1 < v4; ++v1) {
                View v3 = this.getChildAt(v1);
                if(!v3.getLayoutParams().isDecor) {
                    this.mPageTransformer.transformPage(v3, (((float)(v3.getLeft() - v2))) / (((float)this.getClientWidth())));
                }
            }
        }

        this.mCalledSuper = true;
    }

    protected boolean onRequestFocusInDescendants(int arg9, Rect arg10) {
        int v3;
        boolean v2 = true;
        int v1 = -1;
        int v0 = this.getChildCount();
        if((arg9 & 2) != 0) {
            v1 = 1;
            v3 = 0;
        }
        else {
            v3 = v0 - 1;
            v0 = v1;
        }

        while(v3 != v0) {
            View v5 = this.getChildAt(v3);
            if(v5.getVisibility() == 0) {
                ItemInfo v6 = this.infoForChild(v5);
                if(v6 != null && v6.position == this.mCurItem) {
                    if(!v5.requestFocus(arg9, arg10)) {
                        goto label_24;
                    }

                    return v2;
                }
            }

        label_24:
            v3 += v1;
        }

        return false;
    }

    public void onRestoreInstanceState(Parcelable arg4) {
        if(!(arg4 instanceof SavedState)) {
            super.onRestoreInstanceState(arg4);
        }
        else {
            super.onRestoreInstanceState(((SavedState)arg4).getSuperState());
            if(this.mAdapter != null) {
                this.mAdapter.restoreState(((SavedState)arg4).adapterState, ((SavedState)arg4).loader);
                this.setCurrentItemInternal(((SavedState)arg4).position, false, true);
            }
            else {
                this.mRestoredCurItem = ((SavedState)arg4).position;
                this.mRestoredAdapterState = ((SavedState)arg4).adapterState;
                this.mRestoredClassLoader = ((SavedState)arg4).loader;
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        v1.position = this.mCurItem;
        if(this.mAdapter != null) {
            v1.adapterState = this.mAdapter.saveState();
        }

        return ((Parcelable)v1);
    }

    private void onSecondaryPointerUp(MotionEvent arg4) {
        int v0 = MotionEventCompat.getActionIndex(arg4);
        if(arg4.getPointerId(v0) == this.mActivePointerId) {
            v0 = v0 == 0 ? 1 : 0;
            this.mLastMotionX = arg4.getX(v0);
            this.mActivePointerId = arg4.getPointerId(v0);
            if(this.mVelocityTracker == null) {
                return;
            }

            this.mVelocityTracker.clear();
        }
    }

    protected void onSizeChanged(int arg3, int arg4, int arg5, int arg6) {
        super.onSizeChanged(arg3, arg4, arg5, arg6);
        if(arg3 != arg5) {
            this.recomputeScrollPosition(arg3, arg5, this.mPageMargin, this.mPageMargin);
        }
    }

    public boolean onTouchEvent(MotionEvent arg8) {
        int v2_1;
        float v0_2;
        int v0_1;
        boolean v0;
        boolean v2 = false;
        if(this.mFakeDragging) {
            v0 = true;
        }
        else {
            if(arg8.getAction() == 0 && arg8.getEdgeFlags() != 0) {
                return false;
            }

            if(this.mAdapter != null && this.mAdapter.getCount() != 0) {
                if(this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }

                this.mVelocityTracker.addMovement(arg8);
                switch(arg8.getAction() & 0xFF) {
                    case 0: {
                        this.mScroller.abortAnimation();
                        this.mPopulatePending = false;
                        this.populate();
                        v0_2 = arg8.getX();
                        this.mInitialMotionX = v0_2;
                        this.mLastMotionX = v0_2;
                        v0_2 = arg8.getY();
                        this.mInitialMotionY = v0_2;
                        this.mLastMotionY = v0_2;
                        this.mActivePointerId = arg8.getPointerId(0);
                        break;
                    }
                    case 1: {
                        if(!this.mIsBeingDragged) {
                            goto label_28;
                        }

                        VelocityTracker v0_4 = this.mVelocityTracker;
                        v0_4.computeCurrentVelocity(1000, ((float)this.mMaximumVelocity));
                        v0_1 = ((int)VelocityTrackerCompat.getXVelocity(v0_4, this.mActivePointerId));
                        this.mPopulatePending = true;
                        v2_1 = this.getClientWidth();
                        int v3_1 = this.getScrollX();
                        ItemInfo v4_1 = this.infoForCurrentScrollPosition();
                        this.setCurrentItemInternal(this.determineTargetPage(v4_1.position, ((((float)v3_1)) / (((float)v2_1)) - v4_1.offset) / (v4_1.widthFactor + (((float)this.mPageMargin)) / (((float)v2_1))), v0_1, ((int)(arg8.getX(arg8.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX))), true, true, v0_1);
                        v2 = this.resetTouch();
                        break;
                    }
                    case 2: {
                        if(!this.mIsBeingDragged) {
                            v0_1 = arg8.findPointerIndex(this.mActivePointerId);
                            if(v0_1 == -1) {
                                v2 = this.resetTouch();
                                goto label_28;
                            }
                            else {
                                float v3 = arg8.getX(v0_1);
                                float v4 = Math.abs(v3 - this.mLastMotionX);
                                float v5 = arg8.getY(v0_1);
                                v0_2 = Math.abs(v5 - this.mLastMotionY);
                                if(v4 > (((float)this.mTouchSlop)) && v4 > v0_2) {
                                    this.mIsBeingDragged = true;
                                    this.requestParentDisallowInterceptTouchEvent(true);
                                    v0_2 = v3 - this.mInitialMotionX > 0f ? this.mInitialMotionX + (((float)this.mTouchSlop)) : this.mInitialMotionX - (((float)this.mTouchSlop));
                                    this.mLastMotionX = v0_2;
                                    this.mLastMotionY = v5;
                                    this.setScrollState(1);
                                    this.setScrollingCacheEnabled(true);
                                    ViewParent v0_3 = this.getParent();
                                    if(v0_3 == null) {
                                        goto label_82;
                                    }

                                    v0_3.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }

                    label_82:
                        if(!this.mIsBeingDragged) {
                            goto label_28;
                        }

                        v2_1 = 0 | this.performDrag(arg8.getX(arg8.findPointerIndex(this.mActivePointerId)));
                        break;
                    }
                    case 3: {
                        if(!this.mIsBeingDragged) {
                            goto label_28;
                        }

                        this.scrollToItem(this.mCurItem, true, 0, false);
                        v2 = this.resetTouch();
                        break;
                    }
                    case 5: {
                        v0_1 = MotionEventCompat.getActionIndex(arg8);
                        this.mLastMotionX = arg8.getX(v0_1);
                        this.mActivePointerId = arg8.getPointerId(v0_1);
                        break;
                    }
                    case 6: {
                        this.onSecondaryPointerUp(arg8);
                        this.mLastMotionX = arg8.getX(arg8.findPointerIndex(this.mActivePointerId));
                        break;
                    }
                }

            label_28:
                if((((boolean)v2_1))) {
                    ViewCompat.postInvalidateOnAnimation(((View)this));
                }

                return true;
            }

            v0 = false;
        }

        return v0;
    }

    boolean pageLeft() {
        boolean v0 = true;
        if(this.mCurItem > 0) {
            this.setCurrentItem(this.mCurItem - 1, true);
        }
        else {
            v0 = false;
        }

        return v0;
    }

    boolean pageRight() {
        boolean v0 = true;
        if(this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() - 1) {
            v0 = false;
        }
        else {
            this.setCurrentItem(this.mCurItem + 1, true);
        }

        return v0;
    }

    private boolean pageScrolled(int arg8) {
        boolean v0 = false;
        if(this.mItems.size() != 0) {
            ItemInfo v1 = this.infoForCurrentScrollPosition();
            int v2 = this.getClientWidth();
            int v3 = this.mPageMargin + v2;
            float v4 = (((float)this.mPageMargin)) / (((float)v2));
            int v5 = v1.position;
            float v1_1 = ((((float)arg8)) / (((float)v2)) - v1.offset) / (v1.widthFactor + v4);
            this.mCalledSuper = false;
            this.onPageScrolled(v5, v1_1, ((int)((((float)v3)) * v1_1)));
            if(!this.mCalledSuper) {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            else {
                v0 = true;
            }
        }
        else if(!this.mFirstLayout) {
            this.mCalledSuper = false;
            this.onPageScrolled(0, 0f, 0);
            if(!this.mCalledSuper) {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
        }

        return v0;
    }

    private boolean performDrag(float arg11) {
        float v1_1;
        int v0_2;
        int v3 = 1;
        boolean v2 = false;
        float v0 = this.mLastMotionX - arg11;
        this.mLastMotionX = arg11;
        float v5 = (((float)this.getScrollX())) + v0;
        int v7 = this.getClientWidth();
        float v4 = (((float)v7)) * this.mFirstOffset;
        float v6 = (((float)v7)) * this.mLastOffset;
        Object v0_1 = this.mItems.get(0);
        Object v1 = this.mItems.get(this.mItems.size() - 1);
        if(((ItemInfo)v0_1).position != 0) {
            v4 = ((ItemInfo)v0_1).offset * (((float)v7));
            v0_2 = 0;
        }
        else {
            v0_2 = 1;
        }

        if(((ItemInfo)v1).position != this.mAdapter.getCount() - 1) {
            v1_1 = ((ItemInfo)v1).offset * (((float)v7));
            v3 = 0;
        }
        else {
            v1_1 = v6;
        }

        if(v5 < v4) {
            if(v0_2 != 0) {
                v2 = this.mLeftEdge.onPull(Math.abs(v4 - v5) / (((float)v7)));
            }
        }
        else if(v5 > v1_1) {
            if(v3 != 0) {
                v2 = this.mRightEdge.onPull(Math.abs(v5 - v1_1) / (((float)v7)));
            }

            v4 = v1_1;
        }
        else {
            v4 = v5;
        }

        this.mLastMotionX += v4 - (((float)(((int)v4))));
        this.scrollTo(((int)v4), this.getScrollY());
        this.pageScrolled(((int)v4));
        return v2;
    }

    void populate() {
        this.populate(this.mCurItem);
    }

    void populate(int arg18) {
        float v2_5;
        float v15;
        Object v9_1;
        Object v2_4;
        String v2_3;
        ItemInfo v3;
        ItemInfo v2 = null;
        if(this.mCurItem != arg18) {
            v2 = this.infoForPosition(this.mCurItem);
            this.mCurItem = arg18;
            v3 = v2;
        }
        else {
            v3 = v2;
        }

        if(this.mAdapter == null) {
            this.sortChildDrawingOrder();
        }
        else if(this.mPopulatePending) {
            this.sortChildDrawingOrder();
        }
        else if(this.getWindowToken() != null) {
            this.mAdapter.startUpdate(this);
            int v2_1 = this.mOffscreenPageLimit;
            int v10 = Math.max(0, this.mCurItem - v2_1);
            int v11 = this.mAdapter.getCount();
            int v12 = Math.min(v11 - 1, v2_1 + this.mCurItem);
            if(v11 != this.mExpectedAdapterCount) {
                try {
                    v2_3 = this.getResources().getResourceName(this.getId());
                }
                catch(Resources$NotFoundException v2_2) {
                    v2_3 = Integer.toHexString(this.getId());
                }

                throw new IllegalStateException("The application\'s PagerAdapter changed the adapter\'s contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + v11 + " Pager id: " + v2_3 + " Pager class: " + this.getClass() + " Problematic adapter: " + this.mAdapter.getClass());
            }
            else {
                Object v5 = null;
                int v4 = 0;
                while(true) {
                    if(v4 < this.mItems.size()) {
                        v2_4 = this.mItems.get(v4);
                        if(((ItemInfo)v2_4).position < this.mCurItem) {
                            ++v4;
                            continue;
                        }
                        else if(((ItemInfo)v2_4).position != this.mCurItem) {
                            break;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_99;
                }

                v2_4 = v5;
            label_99:
                if(v2_4 != null || v11 <= 0) {
                    v9_1 = v2_4;
                }
                else {
                    ItemInfo v9 = this.addNewItem(this.mCurItem, v4);
                }

                if((((ItemInfo)v9_1)) != null) {
                    int v7 = v4 - 1;
                    v2_4 = v7 >= 0 ? this.mItems.get(v7) : null;
                    int v13 = this.getClientWidth();
                    float v5_1 = v13 <= 0 ? 0f : 2f - ((ItemInfo)v9_1).widthFactor + (((float)this.getPaddingLeft())) / (((float)v13));
                    float v6 = 0f;
                    int v8 = this.mCurItem - 1;
                    int v16 = v7;
                    v7 = v4;
                    v4 = v16;
                    while(v8 >= 0) {
                        if(v6 < v5_1 || v8 >= v10) {
                            if(v2_4 != null && v8 == ((ItemInfo)v2_4).position) {
                                v6 += ((ItemInfo)v2_4).widthFactor;
                                --v4;
                                v2_4 = v4 >= 0 ? this.mItems.get(v4) : null;
                                goto label_224;
                            }

                            v6 += this.addNewItem(v8, v4 + 1).widthFactor;
                            ++v7;
                            if(v4 >= 0) {
                                v2_4 = this.mItems.get(v4);
                                goto label_224;
                            }

                            v2_4 = null;
                        }
                        else if(v2_4 == null) {
                            break;
                        }
                        else if(v8 == ((ItemInfo)v2_4).position && !((ItemInfo)v2_4).scrolling) {
                            this.mItems.remove(v4);
                            this.mAdapter.destroyItem(this, v8, ((ItemInfo)v2_4).object);
                            --v4;
                            --v7;
                            v2_4 = v4 >= 0 ? this.mItems.get(v4) : null;
                        }

                    label_224:
                        --v8;
                    }

                    v5_1 = ((ItemInfo)v9_1).widthFactor;
                    v8 = v7 + 1;
                    if(v5_1 < 2f) {
                        Object v6_1 = v8 < this.mItems.size() ? this.mItems.get(v8) : null;
                        float v4_1 = v13 <= 0 ? 0f : (((float)this.getPaddingRight())) / (((float)v13)) + 2f;
                        v2_4 = v6_1;
                        int v6_2 = v8;
                        v8 = this.mCurItem + 1;
                        while(v8 < v11) {
                            if(v5_1 < v4_1 || v8 <= v12) {
                                if(v2_4 != null && v8 == ((ItemInfo)v2_4).position) {
                                    v5_1 += ((ItemInfo)v2_4).widthFactor;
                                    ++v6_2;
                                    v2_4 = v6_2 < this.mItems.size() ? this.mItems.get(v6_2) : null;
                                    v15 = v5_1;
                                    v5 = v2_4;
                                    v2_5 = v15;
                                    goto label_286;
                                }

                                v2 = this.addNewItem(v8, v6_2);
                                ++v6_2;
                                v5_1 += v2.widthFactor;
                                v2_4 = v6_2 < this.mItems.size() ? this.mItems.get(v6_2) : null;
                                v15 = v5_1;
                                v5 = v2_4;
                                v2_5 = v15;
                            }
                            else if(v2_4 != null) {
                                if(v8 == ((ItemInfo)v2_4).position && !((ItemInfo)v2_4).scrolling) {
                                    this.mItems.remove(v6_2);
                                    this.mAdapter.destroyItem(this, v8, ((ItemInfo)v2_4).object);
                                    v2_4 = v6_2 < this.mItems.size() ? this.mItems.get(v6_2) : null;
                                    v15 = v5_1;
                                    v5 = v2_4;
                                    v2_5 = v15;
                                    goto label_286;
                                }

                                v15 = v5_1;
                                v5 = v2_4;
                                v2_5 = v15;
                            }
                            else {
                                break;
                            }

                        label_286:
                            ++v8;
                            v15 = v2_5;
                            v2_4 = v5;
                            v5_1 = v15;
                        }
                    }

                    this.calculatePageOffsets(((ItemInfo)v9_1), v7, v3);
                }

                PagerAdapter v3_1 = this.mAdapter;
                v4 = this.mCurItem;
                v2_4 = (((ItemInfo)v9_1)) != null ? ((ItemInfo)v9_1).object : null;
                v3_1.setPrimaryItem(this, v4, v2_4);
                this.mAdapter.finishUpdate(this);
                v4 = this.getChildCount();
                int v3_2;
                for(v3_2 = 0; v3_2 < v4; ++v3_2) {
                    View v5_2 = this.getChildAt(v3_2);
                    ViewGroup$LayoutParams v2_6 = v5_2.getLayoutParams();
                    ((LayoutParams)v2_6).childIndex = v3_2;
                    if(!((LayoutParams)v2_6).isDecor && ((LayoutParams)v2_6).widthFactor == 0f) {
                        ItemInfo v5_3 = this.infoForChild(v5_2);
                        if(v5_3 != null) {
                            ((LayoutParams)v2_6).widthFactor = v5_3.widthFactor;
                            ((LayoutParams)v2_6).position = v5_3.position;
                        }
                    }
                }

                this.sortChildDrawingOrder();
                if(!this.hasFocus()) {
                    return;
                }

                View v2_7 = this.findFocus();
                v2 = v2_7 != null ? this.infoForAnyChild(v2_7) : null;
                if(v2 != null && v2.position == this.mCurItem) {
                    return;
                }

                for(v2_1 = 0; v2_1 < this.getChildCount(); ++v2_1) {
                    View v3_3 = this.getChildAt(v2_1);
                    ItemInfo v4_2 = this.infoForChild(v3_3);
                    if(v4_2 != null && v4_2.position == this.mCurItem && (v3_3.requestFocus(2))) {
                        return;
                    }
                }
            }
        }
    }

    private void recomputeScrollPosition(int arg4, int arg5, int arg6, int arg7) {
        if(arg5 <= 0 || (this.mItems.isEmpty())) {
            ItemInfo v0 = this.infoForPosition(this.mCurItem);
            float v0_1 = v0 != null ? Math.min(v0.offset, this.mLastOffset) : 0f;
            int v0_2 = ((int)(v0_1 * (((float)(arg4 - this.getPaddingLeft() - this.getPaddingRight())))));
            if(v0_2 == this.getScrollX()) {
                return;
            }

            this.completeScroll(false);
            this.scrollTo(v0_2, this.getScrollY());
        }
        else if(!this.mScroller.isFinished()) {
            this.mScroller.setFinalX(this.getCurrentItem() * this.getClientWidth());
        }
        else {
            this.scrollTo(((int)((((float)(arg4 - this.getPaddingLeft() - this.getPaddingRight() + arg6))) * ((((float)this.getScrollX())) / (((float)(arg5 - this.getPaddingLeft() - this.getPaddingRight() + arg7)))))), this.getScrollY());
        }
    }

    private void removeNonDecorViews() {
        int v1;
        for(v1 = 0; v1 < this.getChildCount(); ++v1) {
            if(!this.getChildAt(v1).getLayoutParams().isDecor) {
                this.removeViewAt(v1);
                --v1;
            }
        }
    }

    public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener arg2) {
        if(this.mAdapterChangeListeners != null) {
            this.mAdapterChangeListeners.remove(arg2);
        }
    }

    public void removeOnPageChangeListener(OnPageChangeListener arg2) {
        if(this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.remove(arg2);
        }
    }

    public void removeView(View arg2) {
        if(this.mInLayout) {
            this.removeViewInLayout(arg2);
        }
        else {
            super.removeView(arg2);
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean arg2) {
        ViewParent v0 = this.getParent();
        if(v0 != null) {
            v0.requestDisallowInterceptTouchEvent(arg2);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        this.endDrag();
        return this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
    }

    private void scrollToItem(int arg6, boolean arg7, int arg8, boolean arg9) {
        ItemInfo v0 = this.infoForPosition(arg6);
        int v0_1 = v0 != null ? ((int)(Math.max(this.mFirstOffset, Math.min(v0.offset, this.mLastOffset)) * (((float)this.getClientWidth())))) : 0;
        if(arg7) {
            this.smoothScrollTo(v0_1, 0, arg8);
            if(arg9) {
                this.dispatchOnPageSelected(arg6);
            }
        }
        else {
            if(arg9) {
                this.dispatchOnPageSelected(arg6);
            }

            this.completeScroll(false);
            this.scrollTo(v0_1, 0);
            this.pageScrolled(v0_1);
        }
    }

    public void setAdapter(PagerAdapter arg8) {
        DataSetObserver v5 = null;
        int v2 = 0;
        if(this.mAdapter != null) {
            this.mAdapter.setViewPagerObserver(v5);
            this.mAdapter.startUpdate(((ViewGroup)this));
            int v1;
            for(v1 = 0; v1 < this.mItems.size(); ++v1) {
                Object v0 = this.mItems.get(v1);
                this.mAdapter.destroyItem(((ViewGroup)this), ((ItemInfo)v0).position, ((ItemInfo)v0).object);
            }

            this.mAdapter.finishUpdate(((ViewGroup)this));
            this.mItems.clear();
            this.removeNonDecorViews();
            this.mCurItem = 0;
            this.scrollTo(0, 0);
        }

        PagerAdapter v1_1 = this.mAdapter;
        this.mAdapter = arg8;
        this.mExpectedAdapterCount = 0;
        if(this.mAdapter != null) {
            if(this.mObserver == null) {
                this.mObserver = new PagerObserver(this);
            }

            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean v0_1 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if(this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                this.setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = ((Parcelable)v5);
                this.mRestoredClassLoader = ((ClassLoader)v5);
                goto label_60;
            }

            if(!v0_1) {
                this.populate();
                goto label_60;
            }

            this.requestLayout();
        }

    label_60:
        if(this.mAdapterChangeListeners != null && !this.mAdapterChangeListeners.isEmpty()) {
            int v3 = this.mAdapterChangeListeners.size();
            while(v2 < v3) {
                this.mAdapterChangeListeners.get(v2).onAdapterChanged(this, v1_1, arg8);
                ++v2;
            }
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean arg6) {
        if(Build$VERSION.SDK_INT >= 7) {
            if(this.mSetChildrenDrawingOrderEnabled != null) {
                goto label_14;
            }

            try {
                this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            }
            catch(NoSuchMethodException v0) {
                Log.e("ViewPager", "Can\'t find setChildrenDrawingOrderEnabled", ((Throwable)v0));
            }

            try {
            label_14:
                this.mSetChildrenDrawingOrderEnabled.invoke(this, Boolean.valueOf(arg6));
            }
            catch(Exception v0_1) {
                Log.e("ViewPager", "Error changing children drawing order", ((Throwable)v0_1));
            }
        }
    }

    public void setCurrentItem(int arg3) {
        this.mPopulatePending = false;
        boolean v0 = !this.mFirstLayout ? true : false;
        this.setCurrentItemInternal(arg3, v0, false);
    }

    public void setCurrentItem(int arg2, boolean arg3) {
        this.mPopulatePending = false;
        this.setCurrentItemInternal(arg2, arg3, false);
    }

    void setCurrentItemInternal(int arg2, boolean arg3, boolean arg4) {
        this.setCurrentItemInternal(arg2, arg3, arg4, 0);
    }

    void setCurrentItemInternal(int arg5, boolean arg6, boolean arg7, int arg8) {
        boolean v1 = false;
        if(this.mAdapter == null || this.mAdapter.getCount() <= 0) {
            this.setScrollingCacheEnabled(false);
        }
        else {
            if(!arg7 && this.mCurItem == arg5 && this.mItems.size() != 0) {
                this.setScrollingCacheEnabled(false);
                return;
            }

            if(arg5 < 0) {
                arg5 = 0;
            }
            else if(arg5 >= this.mAdapter.getCount()) {
                arg5 = this.mAdapter.getCount() - 1;
            }

            int v0 = this.mOffscreenPageLimit;
            if(arg5 > this.mCurItem + v0 || arg5 < this.mCurItem - v0) {
                int v2;
                for(v2 = 0; v2 < this.mItems.size(); ++v2) {
                    this.mItems.get(v2).scrolling = true;
                }
            }

            if(this.mCurItem != arg5) {
                v1 = true;
            }

            if(this.mFirstLayout) {
                this.mCurItem = arg5;
                if(v1) {
                    this.dispatchOnPageSelected(arg5);
                }

                this.requestLayout();
                return;
            }

            this.populate(arg5);
            this.scrollToItem(arg5, arg6, arg8, v1);
        }
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener arg2) {
        OnPageChangeListener v0 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = arg2;
        return v0;
    }

    public void setOffscreenPageLimit(int arg5) {
        if(arg5 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + arg5 + " too small; defaulting to " + 1);
        }

        if(1 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = 1;
            this.populate();
        }
    }

    @Deprecated public void setOnPageChangeListener(OnPageChangeListener arg1) {
        this.mOnPageChangeListener = arg1;
    }

    public void setPageMargin(int arg3) {
        int v0 = this.mPageMargin;
        this.mPageMargin = arg3;
        int v1 = this.getWidth();
        this.recomputeScrollPosition(v1, v1, arg3, v0);
        this.requestLayout();
    }

    public void setPageMarginDrawable(@DrawableRes int arg2) {
        this.setPageMarginDrawable(ContextCompat.getDrawable(this.getContext(), arg2));
    }

    public void setPageMarginDrawable(Drawable arg2) {
        this.mMarginDrawable = arg2;
        if(arg2 != null) {
            this.refreshDrawableState();
        }

        boolean v0 = arg2 == null ? true : false;
        this.setWillNotDraw(v0);
        this.invalidate();
    }

    public void setPageTransformer(boolean arg2, PageTransformer arg3) {
        this.setPageTransformer(arg2, arg3, 2);
    }

    public void setPageTransformer(boolean arg5, PageTransformer arg6, int arg7) {
        int v1 = 1;
        if(Build$VERSION.SDK_INT >= 11) {
            boolean v0 = arg6 != null ? true : false;
            int v3 = this.mPageTransformer != null ? 1 : 0;
            v3 = v0 != (((boolean)v3)) ? 1 : 0;
            this.mPageTransformer = arg6;
            this.setChildrenDrawingOrderEnabledCompat(v0);
            if(v0) {
                if(arg5) {
                    v1 = 2;
                }

                this.mDrawingOrder = v1;
                this.mPageTransformerLayerType = arg7;
            }
            else {
                this.mDrawingOrder = 0;
            }

            if(v3 == 0) {
                return;
            }

            this.populate();
        }
    }

    void setScrollState(int arg2) {
        if(this.mScrollState != arg2) {
            this.mScrollState = arg2;
            if(this.mPageTransformer != null) {
                boolean v0 = arg2 != 0 ? true : false;
                this.enableLayers(v0);
            }

            this.dispatchOnScrollStateChanged(arg2);
        }
    }

    private void setScrollingCacheEnabled(boolean arg2) {
        if(this.mScrollingCacheEnabled != arg2) {
            this.mScrollingCacheEnabled = arg2;
        }
    }

    void smoothScrollTo(int arg11, int arg12, int arg13) {
        int v1;
        float v9 = 1f;
        if(this.getChildCount() == 0) {
            this.setScrollingCacheEnabled(false);
        }
        else {
            int v0 = this.mScroller == null || (this.mScroller.isFinished()) ? 0 : 1;
            if(v0 != 0) {
                v0 = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
                this.mScroller.abortAnimation();
                this.setScrollingCacheEnabled(false);
                v1 = v0;
            }
            else {
                v1 = this.getScrollX();
            }

            int v2 = this.getScrollY();
            int v3 = arg11 - v1;
            int v4 = arg12 - v2;
            if(v3 == 0 && v4 == 0) {
                this.completeScroll(false);
                this.populate();
                this.setScrollState(0);
                return;
            }

            this.setScrollingCacheEnabled(true);
            this.setScrollState(2);
            v0 = this.getClientWidth();
            int v5 = v0 / 2;
            float v5_1 = (((float)v5)) * this.distanceInfluenceForSnapDuration(Math.min(v9, (((float)Math.abs(v3))) * v9 / (((float)v0)))) + (((float)v5));
            int v7 = Math.abs(arg13);
            v0 = v7 > 0 ? Math.round(1000f * Math.abs(v5_1 / (((float)v7)))) * 4 : ((int)(((((float)Math.abs(v3))) / ((((float)v0)) * this.mAdapter.getPageWidth(this.mCurItem) + (((float)this.mPageMargin))) + v9) * 100f));
            v5 = Math.min(v0, 600);
            this.mIsScrollStarted = false;
            this.mScroller.startScroll(v1, v2, v3, v4, v5);
            ViewCompat.postInvalidateOnAnimation(((View)this));
        }
    }

    void smoothScrollTo(int arg2, int arg3) {
        this.smoothScrollTo(arg2, arg3, 0);
    }

    private void sortChildDrawingOrder() {
        if(this.mDrawingOrder != 0) {
            if(this.mDrawingOrderedChildren == null) {
                this.mDrawingOrderedChildren = new ArrayList();
            }
            else {
                this.mDrawingOrderedChildren.clear();
            }

            int v1 = this.getChildCount();
            int v0;
            for(v0 = 0; v0 < v1; ++v0) {
                this.mDrawingOrderedChildren.add(this.getChildAt(v0));
            }

            Collections.sort(this.mDrawingOrderedChildren, ViewPager.sPositionComparator);
        }
    }

    protected boolean verifyDrawable(Drawable arg2) {
        boolean v0 = (super.verifyDrawable(arg2)) || arg2 == this.mMarginDrawable ? true : false;
        return v0;
    }
}

