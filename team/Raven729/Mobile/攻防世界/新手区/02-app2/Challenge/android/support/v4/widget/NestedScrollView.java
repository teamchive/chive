package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View$BaseSavedState;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;

public class NestedScrollView extends FrameLayout implements NestedScrollingChild, NestedScrollingParent, ScrollingView {
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
            super();
        }

        public void onInitializeAccessibilityEvent(View arg3, AccessibilityEvent arg4) {
            super.onInitializeAccessibilityEvent(arg3, arg4);
            arg4.setClassName(ScrollView.class.getName());
            AccessibilityRecordCompat v1 = AccessibilityEventCompat.asRecord(arg4);
            boolean v0 = ((NestedScrollView)arg3).getScrollRange() > 0 ? true : false;
            v1.setScrollable(v0);
            v1.setScrollX(((NestedScrollView)arg3).getScrollX());
            v1.setScrollY(((NestedScrollView)arg3).getScrollY());
            v1.setMaxScrollX(((NestedScrollView)arg3).getScrollX());
            v1.setMaxScrollY(((NestedScrollView)arg3).getScrollRange());
        }

        public void onInitializeAccessibilityNodeInfo(View arg3, AccessibilityNodeInfoCompat arg4) {
            super.onInitializeAccessibilityNodeInfo(arg3, arg4);
            arg4.setClassName(ScrollView.class.getName());
            if(((NestedScrollView)arg3).isEnabled()) {
                int v0 = ((NestedScrollView)arg3).getScrollRange();
                if(v0 > 0) {
                    arg4.setScrollable(true);
                    if(((NestedScrollView)arg3).getScrollY() > 0) {
                        arg4.addAction(0x2000);
                    }

                    if(((NestedScrollView)arg3).getScrollY() >= v0) {
                        return;
                    }

                    arg4.addAction(0x1000);
                }
            }
        }

        public boolean performAccessibilityAction(View arg5, int arg6, Bundle arg7) {
            boolean v0 = true;
            if(!super.performAccessibilityAction(arg5, arg6, arg7)) {
                if(!((NestedScrollView)arg5).isEnabled()) {
                    v0 = false;
                }
                else {
                    switch(arg6) {
                        case 4096: {
                            goto label_12;
                        }
                        case 8192: {
                            goto label_27;
                        }
                    }

                    return false;
                label_27:
                    int v2 = Math.max(((NestedScrollView)arg5).getScrollY() - (((NestedScrollView)arg5).getHeight() - ((NestedScrollView)arg5).getPaddingBottom() - ((NestedScrollView)arg5).getPaddingTop()), 0);
                    if(v2 != ((NestedScrollView)arg5).getScrollY()) {
                        ((NestedScrollView)arg5).smoothScrollTo(0, v2);
                    }
                    else {
                        return false;
                    label_12:
                        v2 = Math.min(((NestedScrollView)arg5).getHeight() - ((NestedScrollView)arg5).getPaddingBottom() - ((NestedScrollView)arg5).getPaddingTop() + ((NestedScrollView)arg5).getScrollY(), ((NestedScrollView)arg5).getScrollRange());
                        if(v2 != ((NestedScrollView)arg5).getScrollY()) {
                            ((NestedScrollView)arg5).smoothScrollTo(0, v2);
                        }
                        else {
                            v0 = false;
                        }
                    }
                }
            }

            return v0;
        }
    }

    public interface OnScrollChangeListener {
        void onScrollChange(NestedScrollView arg1, int arg2, int arg3, int arg4, int arg5);
    }

    class SavedState extends View$BaseSavedState {
        final class android.support.v4.widget.NestedScrollView$SavedState$1 implements Parcelable$Creator {
            android.support.v4.widget.NestedScrollView$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg2) {
                return new SavedState(arg2);
            }

            public Object createFromParcel(Parcel arg2) {
                return this.createFromParcel(arg2);
            }

            public SavedState[] newArray(int arg2) {
                return new SavedState[arg2];
            }

            public Object[] newArray(int arg2) {
                return this.newArray(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR;
        public int scrollPosition;

        static {
            SavedState.CREATOR = new android.support.v4.widget.NestedScrollView$SavedState$1();
        }

        SavedState(Parcelable arg1) {
            super(arg1);
        }

        SavedState(Parcel arg2) {
            super(arg2);
            this.scrollPosition = arg2.readInt();
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            super.writeToParcel(arg2, arg3);
            arg2.writeInt(this.scrollPosition);
        }
    }

    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = null;
    static final int ANIMATED_SCROLL_GAP = 0xFA;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE = null;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    private EdgeEffectCompat mEdgeGlowBottom;
    private EdgeEffectCompat mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private ScrollerCompat mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;

    static {
        NestedScrollView.ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
        NestedScrollView.SCROLLVIEW_STYLEABLE = new int[]{0x101017A};
    }

    public NestedScrollView(Context arg2) {
        this(arg2, null);
    }

    public NestedScrollView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public NestedScrollView(Context arg5, AttributeSet arg6, int arg7) {
        super(arg5, arg6, arg7);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.initScrollView();
        TypedArray v0 = arg5.obtainStyledAttributes(arg6, NestedScrollView.SCROLLVIEW_STYLEABLE, arg7, 0);
        this.setFillViewport(v0.getBoolean(0, false));
        v0.recycle();
        this.mParentHelper = new NestedScrollingParentHelper(((ViewGroup)this));
        this.mChildHelper = new NestedScrollingChildHelper(((View)this));
        this.setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(((View)this), NestedScrollView.ACCESSIBILITY_DELEGATE);
    }

    public void addView(View arg3) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }

        super.addView(arg3);
    }

    public void addView(View arg3, int arg4) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }

        super.addView(arg3, arg4);
    }

    public void addView(View arg3, int arg4, ViewGroup$LayoutParams arg5) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }

        super.addView(arg3, arg4, arg5);
    }

    public void addView(View arg3, ViewGroup$LayoutParams arg4) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }

        super.addView(arg3, arg4);
    }

    public boolean arrowScroll(int arg8) {
        boolean v0_1;
        int v6 = 130;
        View v0 = this.findFocus();
        if((((NestedScrollView)v0)) == this) {
            v0 = null;
        }

        View v3 = FocusFinder.getInstance().findNextFocus(((ViewGroup)this), v0, arg8);
        int v1 = this.getMaxScrollAmount();
        if(v3 == null || !this.isWithinDeltaOfScreen(v3, v1, this.getHeight())) {
            if(arg8 == 33 && this.getScrollY() < v1) {
                v1 = this.getScrollY();
            }
            else if(arg8 == v6 && this.getChildCount() > 0) {
                int v3_1 = this.getChildAt(0).getBottom();
                int v4 = this.getScrollY() + this.getHeight() - this.getPaddingBottom();
                if(v3_1 - v4 < v1) {
                    v1 = v3_1 - v4;
                }
            }

            if(v1 == 0) {
                v0_1 = false;
                return v0_1;
            }

            if(arg8 != v6) {
                v1 = -v1;
            }

            this.doScrollY(v1);
        label_20:
            if(v0 != null && (v0.isFocused()) && (this.isOffScreen(v0))) {
                int v0_2 = this.getDescendantFocusability();
                this.setDescendantFocusability(0x20000);
                this.requestFocus();
                this.setDescendantFocusability(v0_2);
            }

            v0_1 = true;
        }
        else {
            v3.getDrawingRect(this.mTempRect);
            this.offsetDescendantRectToMyCoords(v3, this.mTempRect);
            this.doScrollY(this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            v3.requestFocus(arg8);
            goto label_20;
        }

        return v0_1;
    }

    private boolean canScroll() {
        boolean v0 = false;
        View v1 = this.getChildAt(0);
        if(v1 != null && this.getHeight() < v1.getHeight() + this.getPaddingTop() + this.getPaddingBottom()) {
            v0 = true;
        }

        return v0;
    }

    private static int clamp(int arg1, int arg2, int arg3) {
        if(arg2 >= arg3 || arg1 < 0) {
            arg1 = 0;
        }
        else if(arg2 + arg1 > arg3) {
            arg1 = arg3 - arg2;
        }

        return arg1;
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        int v10;
        if(this.mScroller.computeScrollOffset()) {
            int v3 = this.getScrollX();
            int v4 = this.getScrollY();
            int v1 = this.mScroller.getCurrX();
            int v11 = this.mScroller.getCurrY();
            if(v3 == v1 && v4 == v11) {
                return;
            }

            int v6 = this.getScrollRange();
            int v2 = this.getOverScrollMode();
            if(v2 != 0) {
                if(v2 == 1 && v6 > 0) {
                    goto label_18;
                }

                v10 = 0;
            }
            else {
            label_18:
                v10 = 1;
            }

            this.overScrollByCompat(v1 - v3, v11 - v4, v3, v4, 0, v6, 0, 0, false);
            if(v10 == 0) {
                return;
            }

            this.ensureGlows();
            if(v11 <= 0 && v4 > 0) {
                this.mEdgeGlowTop.onAbsorb(((int)this.mScroller.getCurrVelocity()));
                return;
            }

            if(v11 < v6) {
                return;
            }

            if(v4 >= v6) {
                return;
            }

            this.mEdgeGlowBottom.onAbsorb(((int)this.mScroller.getCurrVelocity()));
        }
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect arg8) {
        int v2 = 0;
        if(this.getChildCount() != 0) {
            int v3 = this.getHeight();
            int v0 = this.getScrollY();
            int v1 = v0 + v3;
            int v4 = this.getVerticalFadingEdgeLength();
            if(arg8.top > 0) {
                v0 += v4;
            }

            if(arg8.bottom < this.getChildAt(0).getHeight()) {
                v1 -= v4;
            }

            if(arg8.bottom <= v1 || arg8.top <= v0) {
                if(arg8.top < v0 && arg8.bottom < v1) {
                    v0 = arg8.height() > v3 ? -(v1 - arg8.bottom) : -(v0 - arg8.top);
                    v0 = Math.max(v0, -this.getScrollY());
                    goto label_29;
                }

                v0 = 0;
            }
            else {
                v0 = arg8.height() > v3 ? arg8.top - v0 : arg8.bottom - v1;
                v0 = Math.min(v0, this.getChildAt(0).getBottom() - v1);
            }

        label_29:
            v2 = v0;
        }

        return v2;
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public int computeVerticalScrollRange() {
        int v0 = this.getChildCount();
        int v1 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
        if(v0 == 0) {
            v0 = v1;
        }
        else {
            v0 = this.getChildAt(0).getBottom();
            int v2 = this.getScrollY();
            v1 = Math.max(0, v0 - v1);
            if(v2 < 0) {
                v0 -= v2;
            }
            else if(v2 > v1) {
                v0 += v2 - v1;
            }
        }

        return v0;
    }

    public boolean dispatchKeyEvent(KeyEvent arg2) {
        boolean v0 = (super.dispatchKeyEvent(arg2)) || (this.executeKeyEvent(arg2)) ? true : false;
        return v0;
    }

    public boolean dispatchNestedFling(float arg2, float arg3, boolean arg4) {
        return this.mChildHelper.dispatchNestedFling(arg2, arg3, arg4);
    }

    public boolean dispatchNestedPreFling(float arg2, float arg3) {
        return this.mChildHelper.dispatchNestedPreFling(arg2, arg3);
    }

    public boolean dispatchNestedPreScroll(int arg2, int arg3, int[] arg4, int[] arg5) {
        return this.mChildHelper.dispatchNestedPreScroll(arg2, arg3, arg4, arg5);
    }

    public boolean dispatchNestedScroll(int arg7, int arg8, int arg9, int arg10, int[] arg11) {
        return this.mChildHelper.dispatchNestedScroll(arg7, arg8, arg9, arg10, arg11);
    }

    private void doScrollY(int arg3) {
        if(arg3 != 0) {
            if(this.mSmoothScrollingEnabled) {
                this.smoothScrollBy(0, arg3);
            }
            else {
                this.scrollBy(0, arg3);
            }
        }
    }

    public void draw(Canvas arg7) {
        int v2;
        int v1;
        super.draw(arg7);
        if(this.mEdgeGlowTop != null) {
            int v0 = this.getScrollY();
            if(!this.mEdgeGlowTop.isFinished()) {
                v1 = arg7.save();
                v2 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
                arg7.translate(((float)this.getPaddingLeft()), ((float)Math.min(0, v0)));
                this.mEdgeGlowTop.setSize(v2, this.getHeight());
                if(this.mEdgeGlowTop.draw(arg7)) {
                    ViewCompat.postInvalidateOnAnimation(((View)this));
                }

                arg7.restoreToCount(v1);
            }

            if(this.mEdgeGlowBottom.isFinished()) {
                return;
            }

            v1 = arg7.save();
            v2 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
            int v3 = this.getHeight();
            arg7.translate(((float)(-v2 + this.getPaddingLeft())), ((float)(Math.max(this.getScrollRange(), v0) + v3)));
            arg7.rotate(180f, ((float)v2), 0f);
            this.mEdgeGlowBottom.setSize(v2, v3);
            if(this.mEdgeGlowBottom.draw(arg7)) {
                ViewCompat.postInvalidateOnAnimation(((View)this));
            }

            arg7.restoreToCount(v1);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.recycleVelocityTracker();
        this.stopNestedScroll();
        if(this.mEdgeGlowTop != null) {
            this.mEdgeGlowTop.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
    }

    private void ensureGlows() {
        EdgeEffectCompat v2 = null;
        if(this.getOverScrollMode() == 2) {
            this.mEdgeGlowTop = v2;
            this.mEdgeGlowBottom = v2;
        }
        else if(this.mEdgeGlowTop == null) {
            Context v0 = this.getContext();
            this.mEdgeGlowTop = new EdgeEffectCompat(v0);
            this.mEdgeGlowBottom = new EdgeEffectCompat(v0);
        }
    }

    public boolean executeKeyEvent(KeyEvent arg5) {
        int v0 = 33;
        boolean v1 = false;
        int v2 = 130;
        this.mTempRect.setEmpty();
        if(this.canScroll()) {
            if(arg5.getAction() != 0) {
                return v1;
            }

            switch(arg5.getKeyCode()) {
                case 19: {
                    goto label_31;
                }
                case 20: {
                    goto label_37;
                }
                case 62: {
                    goto label_43;
                }
            }

            return v1;
        label_37:
            if(!arg5.isAltPressed()) {
                return this.arrowScroll(v2);
            }

            return this.fullScroll(v2);
        label_43:
            if(!arg5.isShiftPressed()) {
                v0 = v2;
            }

            this.pageScroll(v0);
            return v1;
        label_31:
            if(!arg5.isAltPressed()) {
                return this.arrowScroll(v0);
            }

            v1 = this.fullScroll(v0);
        }
        else if((this.isFocused()) && arg5.getKeyCode() != 4) {
            View v0_1 = this.findFocus();
            if((((NestedScrollView)v0_1)) == this) {
                v0_1 = null;
            }

            v0_1 = FocusFinder.getInstance().findNextFocus(((ViewGroup)this), v0_1, v2);
            boolean v0_2 = v0_1 == null || (((NestedScrollView)v0_1)) == this || !v0_1.requestFocus(v2) ? false : true;
            v1 = v0_2;
        }

        return v1;
    }

    private View findFocusableViewInBounds(boolean arg12, int arg13, int arg14) {
        int v0_1;
        Object v1_1;
        ArrayList v6 = this.getFocusables(2);
        Object v3 = null;
        int v2 = 0;
        int v7 = ((List)v6).size();
        int v5 = 0;
        while(v5 < v7) {
            Object v0 = ((List)v6).get(v5);
            int v4 = ((View)v0).getTop();
            int v8 = ((View)v0).getBottom();
            if(arg13 >= v8 || v4 >= arg14) {
            label_53:
                v0_1 = v2;
                v1_1 = v3;
            }
            else {
                int v1 = arg13 >= v4 || v8 >= arg14 ? 0 : 1;
                if(v3 == null) {
                    int v10 = v1;
                    v1_1 = v0;
                    v0_1 = v10;
                    goto label_20;
                }

                if(!arg12 || v4 >= ((View)v3).getTop()) {
                    if(!arg12 && v8 > ((View)v3).getBottom()) {
                    label_33:
                        v4 = 1;
                        goto label_34;
                    }

                    v4 = 0;
                }
                else {
                    goto label_33;
                }

            label_34:
                if(v2 != 0) {
                    if(v1 == 0) {
                        goto label_53;
                    }

                    if(v4 == 0) {
                        goto label_53;
                    }

                    v1_1 = v0;
                    v0_1 = v2;
                    goto label_20;
                }

                if(v1 != 0) {
                    v1_1 = v0;
                    v0_1 = 1;
                    goto label_20;
                }

                if(v4 == 0) {
                    goto label_53;
                }

                v1_1 = v0;
                v0_1 = v2;
            }

        label_20:
            ++v5;
            v3 = v1_1;
            v2 = v0_1;
        }

        return ((View)v3);
    }

    public void fling(int arg12) {
        if(this.getChildCount() > 0) {
            int v4 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
            this.mScroller.fling(this.getScrollX(), this.getScrollY(), 0, arg12, 0, 0, 0, Math.max(0, this.getChildAt(0).getHeight() - v4), 0, v4 / 2);
            ViewCompat.postInvalidateOnAnimation(((View)this));
        }
    }

    private void flingWithNestedDispatch(int arg4) {
        boolean v0_1;
        int v0 = this.getScrollY();
        if(v0 > 0 || arg4 > 0) {
            if(v0 >= this.getScrollRange() && arg4 >= 0) {
            label_16:
                v0_1 = false;
                goto label_8;
            }

            v0_1 = true;
        }
        else {
            goto label_16;
        }

    label_8:
        if(!this.dispatchNestedPreFling(0f, ((float)arg4))) {
            this.dispatchNestedFling(0f, ((float)arg4), v0_1);
            if(v0_1) {
                this.fling(arg4);
            }
        }
    }

    public boolean fullScroll(int arg5) {
        int v0 = arg5 == 130 ? 1 : 0;
        int v2 = this.getHeight();
        this.mTempRect.top = 0;
        this.mTempRect.bottom = v2;
        if(v0 != 0) {
            v0 = this.getChildCount();
            if(v0 > 0) {
                this.mTempRect.bottom = this.getChildAt(v0 - 1).getBottom() + this.getPaddingBottom();
                this.mTempRect.top = this.mTempRect.bottom - v2;
            }
        }

        return this.scrollAndFocus(arg5, this.mTempRect.top, this.mTempRect.bottom);
    }

    protected float getBottomFadingEdgeStrength() {
        float v0;
        if(this.getChildCount() == 0) {
            v0 = 0f;
        }
        else {
            int v0_1 = this.getVerticalFadingEdgeLength();
            int v1 = this.getChildAt(0).getBottom() - this.getScrollY() - (this.getHeight() - this.getPaddingBottom());
            v0 = v1 < v0_1 ? (((float)v1)) / (((float)v0_1)) : 1f;
        }

        return v0;
    }

    public int getMaxScrollAmount() {
        return ((int)(0.5f * (((float)this.getHeight()))));
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    int getScrollRange() {
        int v0 = 0;
        if(this.getChildCount() > 0) {
            v0 = Math.max(0, this.getChildAt(0).getHeight() - (this.getHeight() - this.getPaddingBottom() - this.getPaddingTop()));
        }

        return v0;
    }

    protected float getTopFadingEdgeStrength() {
        float v0;
        if(this.getChildCount() == 0) {
            v0 = 0f;
        }
        else {
            int v0_1 = this.getVerticalFadingEdgeLength();
            int v1 = this.getScrollY();
            v0 = v1 < v0_1 ? (((float)v1)) / (((float)v0_1)) : 1f;
        }

        return v0;
    }

    private float getVerticalScrollFactorCompat() {
        if(this.mVerticalScrollFactor == 0f) {
            TypedValue v0 = new TypedValue();
            Context v1 = this.getContext();
            if(!v1.getTheme().resolveAttribute(0x101004D, v0, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            else {
                this.mVerticalScrollFactor = v0.getDimension(v1.getResources().getDisplayMetrics());
            }
        }

        return this.mVerticalScrollFactor;
    }

    public boolean hasNestedScrollingParent() {
        return this.mChildHelper.hasNestedScrollingParent();
    }

    private boolean inChild(int arg5, int arg6) {
        boolean v0 = false;
        if(this.getChildCount() > 0) {
            int v1 = this.getScrollY();
            View v2 = this.getChildAt(0);
            if(arg6 >= v2.getTop() - v1 && arg6 < v2.getBottom() - v1 && arg5 >= v2.getLeft() && arg5 < v2.getRight()) {
                v0 = true;
            }
        }

        return v0;
    }

    private void initOrResetVelocityTracker() {
        if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        else {
            this.mVelocityTracker.clear();
        }
    }

    private void initScrollView() {
        this.mScroller = ScrollerCompat.create(this.getContext(), null);
        this.setFocusable(true);
        this.setDescendantFocusability(0x40000);
        this.setWillNotDraw(false);
        ViewConfiguration v0 = ViewConfiguration.get(this.getContext());
        this.mTouchSlop = v0.getScaledTouchSlop();
        this.mMinimumVelocity = v0.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = v0.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    private boolean isOffScreen(View arg3) {
        boolean v0 = false;
        if(!this.isWithinDeltaOfScreen(arg3, 0, this.getHeight())) {
            v0 = true;
        }

        return v0;
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    private static boolean isViewDescendantOf(View arg3, View arg4) {
        boolean v1 = true;
        if(arg3 != arg4) {
            ViewParent v0 = arg3.getParent();
            boolean v0_1 = !(v0 instanceof ViewGroup) || !NestedScrollView.isViewDescendantOf(((View)v0), arg4) ? false : true;
            v1 = v0_1;
        }

        return v1;
    }

    private boolean isWithinDeltaOfScreen(View arg3, int arg4, int arg5) {
        arg3.getDrawingRect(this.mTempRect);
        this.offsetDescendantRectToMyCoords(arg3, this.mTempRect);
        boolean v0 = this.mTempRect.bottom + arg4 < this.getScrollY() || this.mTempRect.top - arg4 > this.getScrollY() + arg5 ? false : true;
        return v0;
    }

    protected void measureChild(View arg5, int arg6, int arg7) {
        arg5.measure(NestedScrollView.getChildMeasureSpec(arg6, this.getPaddingLeft() + this.getPaddingRight(), arg5.getLayoutParams().width), View$MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View arg4, int arg5, int arg6, int arg7, int arg8) {
        ViewGroup$LayoutParams v0 = arg4.getLayoutParams();
        arg4.measure(NestedScrollView.getChildMeasureSpec(arg5, this.getPaddingLeft() + this.getPaddingRight() + ((ViewGroup$MarginLayoutParams)v0).leftMargin + ((ViewGroup$MarginLayoutParams)v0).rightMargin + arg6, ((ViewGroup$MarginLayoutParams)v0).width), View$MeasureSpec.makeMeasureSpec(((ViewGroup$MarginLayoutParams)v0).bottomMargin + ((ViewGroup$MarginLayoutParams)v0).topMargin, 0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    public boolean onGenericMotionEvent(MotionEvent arg5) {
        boolean v0 = false;
        if((arg5.getSource() & 2) != 0) {
            switch(arg5.getAction()) {
                case 8: {
                    if(!this.mIsBeingDragged) {
                        float v1 = MotionEventCompat.getAxisValue(arg5, 9);
                        if(v1 != 0f) {
                            int v2 = ((int)(v1 * this.getVerticalScrollFactorCompat()));
                            int v1_1 = this.getScrollRange();
                            int v3 = this.getScrollY();
                            v2 = v3 - v2;
                            if(v2 < 0) {
                                v1_1 = 0;
                            }
                            else if(v2 <= v1_1) {
                                v1_1 = v2;
                            }

                            if(v1_1 == v3) {
                                return v0;
                            }

                            super.scrollTo(this.getScrollX(), v1_1);
                            v0 = true;
                        }
                    }

                    return v0;
                }
            }
        }

        return v0;
    }

    public boolean onInterceptTouchEvent(MotionEvent arg8) {
        int v5 = 2;
        int v4 = -1;
        boolean v0 = true;
        boolean v3 = false;
        int v1 = arg8.getAction();
        if(v1 != v5 || !this.mIsBeingDragged) {
            switch(v1 & 0xFF) {
                case 0: {
                    v1 = ((int)arg8.getY());
                    if(!this.inChild(((int)arg8.getX()), v1)) {
                        this.mIsBeingDragged = false;
                        this.recycleVelocityTracker();
                        goto label_11;
                    }

                    this.mLastMotionY = v1;
                    this.mActivePointerId = arg8.getPointerId(0);
                    this.initOrResetVelocityTracker();
                    this.mVelocityTracker.addMovement(arg8);
                    this.mScroller.computeScrollOffset();
                    if(!this.mScroller.isFinished()) {
                        v3 = true;
                    }

                    this.mIsBeingDragged = v3;
                    this.startNestedScroll(v5);
                    break;
                }
                case 2: {
                    v1 = this.mActivePointerId;
                    if(v1 == v4) {
                        goto label_11;
                    }

                    int v2 = arg8.findPointerIndex(v1);
                    if(v2 == v4) {
                        Log.e("NestedScrollView", "Invalid pointerId=" + v1 + " in onInterceptTouchEvent");
                        goto label_11;
                    }

                    v1 = ((int)arg8.getY(v2));
                    if(Math.abs(v1 - this.mLastMotionY) <= this.mTouchSlop) {
                        goto label_11;
                    }

                    if((this.getNestedScrollAxes() & 2) != 0) {
                        goto label_11;
                    }

                    this.mIsBeingDragged = true;
                    this.mLastMotionY = v1;
                    this.initVelocityTrackerIfNotExists();
                    this.mVelocityTracker.addMovement(arg8);
                    this.mNestedYOffset = 0;
                    ViewParent v1_1 = this.getParent();
                    if(v1_1 == null) {
                        goto label_11;
                    }

                    v1_1.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                case 1: 
                case 3: {
                    this.mIsBeingDragged = false;
                    this.mActivePointerId = v4;
                    this.recycleVelocityTracker();
                    if(this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                        ViewCompat.postInvalidateOnAnimation(((View)this));
                    }

                    this.stopNestedScroll();
                    break;
                }
                case 6: {
                    this.onSecondaryPointerUp(arg8);
                    break;
                }
            }

        label_11:
            v0 = this.mIsBeingDragged;
        }

        return v0;
    }

    protected void onLayout(boolean arg5, int arg6, int arg7, int arg8, int arg9) {
        View v3 = null;
        super.onLayout(arg5, arg6, arg7, arg8, arg9);
        this.mIsLayoutDirty = false;
        if(this.mChildToScrollTo != null && (NestedScrollView.isViewDescendantOf(this.mChildToScrollTo, ((View)this)))) {
            this.scrollToChild(this.mChildToScrollTo);
        }

        this.mChildToScrollTo = v3;
        if(!this.mIsLaidOut) {
            if(this.mSavedState != null) {
                this.scrollTo(this.getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = ((SavedState)v3);
            }

            int v0 = this.getChildCount() > 0 ? this.getChildAt(0).getMeasuredHeight() : 0;
            v0 = Math.max(0, v0 - (arg9 - arg7 - this.getPaddingBottom() - this.getPaddingTop()));
            if(this.getScrollY() > v0) {
                this.scrollTo(this.getScrollX(), v0);
                goto label_36;
            }

            if(this.getScrollY() >= 0) {
                goto label_36;
            }

            this.scrollTo(this.getScrollX(), 0);
        }

    label_36:
        this.scrollTo(this.getScrollX(), this.getScrollY());
        this.mIsLaidOut = true;
    }

    protected void onMeasure(int arg6, int arg7) {
        super.onMeasure(arg6, arg7);
        if((this.mFillViewport) && View$MeasureSpec.getMode(arg7) != 0 && this.getChildCount() > 0) {
            View v1 = this.getChildAt(0);
            int v2 = this.getMeasuredHeight();
            if(v1.getMeasuredHeight() < v2) {
                v1.measure(NestedScrollView.getChildMeasureSpec(arg6, this.getPaddingLeft() + this.getPaddingRight(), v1.getLayoutParams().width), View$MeasureSpec.makeMeasureSpec(v2 - this.getPaddingTop() - this.getPaddingBottom(), 0x40000000));
            }
        }
    }

    public boolean onNestedFling(View arg2, float arg3, float arg4, boolean arg5) {
        boolean v0;
        if(!arg5) {
            this.flingWithNestedDispatch(((int)arg4));
            v0 = true;
        }
        else {
            v0 = false;
        }

        return v0;
    }

    public boolean onNestedPreFling(View arg2, float arg3, float arg4) {
        return this.dispatchNestedPreFling(arg3, arg4);
    }

    public void onNestedPreScroll(View arg2, int arg3, int arg4, int[] arg5) {
        this.dispatchNestedPreScroll(arg3, arg4, arg5, null);
    }

    public void onNestedScroll(View arg7, int arg8, int arg9, int arg10, int arg11) {
        int v0 = this.getScrollY();
        this.scrollBy(0, arg11);
        int v2 = this.getScrollY() - v0;
        this.dispatchNestedScroll(0, v2, 0, arg11 - v2, null);
    }

    public void onNestedScrollAccepted(View arg2, View arg3, int arg4) {
        this.mParentHelper.onNestedScrollAccepted(arg2, arg3, arg4);
        this.startNestedScroll(2);
    }

    protected void onOverScrolled(int arg1, int arg2, boolean arg3, boolean arg4) {
        super.scrollTo(arg1, arg2);
    }

    protected boolean onRequestFocusInDescendants(int arg4, Rect arg5) {
        boolean v0 = false;
        if(arg4 == 2) {
            arg4 = 130;
        }
        else if(arg4 == 1) {
            arg4 = 33;
        }

        View v1 = arg5 == null ? FocusFinder.getInstance().findNextFocus(((ViewGroup)this), null, arg4) : FocusFinder.getInstance().findNextFocusFromRect(((ViewGroup)this), arg5, arg4);
        if(v1 != null && !this.isOffScreen(v1)) {
            v0 = v1.requestFocus(arg4, arg5);
        }

        return v0;
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
        }
        else {
            super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
            this.mSavedState = ((SavedState)arg2);
            this.requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        v1.scrollPosition = this.getScrollY();
        return ((Parcelable)v1);
    }

    protected void onScrollChanged(int arg7, int arg8, int arg9, int arg10) {
        super.onScrollChanged(arg7, arg8, arg9, arg10);
        if(this.mOnScrollChangeListener != null) {
            this.mOnScrollChangeListener.onScrollChange(this, arg7, arg8, arg9, arg10);
        }
    }

    private void onSecondaryPointerUp(MotionEvent arg4) {
        int v0 = (arg4.getAction() & 0xFF00) >> 8;
        if(arg4.getPointerId(v0) == this.mActivePointerId) {
            v0 = v0 == 0 ? 1 : 0;
            this.mLastMotionY = ((int)arg4.getY(v0));
            this.mActivePointerId = arg4.getPointerId(v0);
            if(this.mVelocityTracker == null) {
                return;
            }

            this.mVelocityTracker.clear();
        }
    }

    protected void onSizeChanged(int arg3, int arg4, int arg5, int arg6) {
        super.onSizeChanged(arg3, arg4, arg5, arg6);
        View v0 = this.findFocus();
        if(v0 != null && this != (((NestedScrollView)v0)) && (this.isWithinDeltaOfScreen(v0, 0, arg6))) {
            v0.getDrawingRect(this.mTempRect);
            this.offsetDescendantRectToMyCoords(v0, this.mTempRect);
            this.doScrollY(this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        }
    }

    public boolean onStartNestedScroll(View arg2, View arg3, int arg4) {
        boolean v0 = (arg4 & 2) != 0 ? true : false;
        return v0;
    }

    public void onStopNestedScroll(View arg2) {
        this.mParentHelper.onStopNestedScroll(arg2);
        this.stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent arg20) {
        int v15;
        int v4_1;
        boolean v2_2;
        this.initVelocityTrackerIfNotExists();
        MotionEvent v16 = MotionEvent.obtain(arg20);
        int v2 = MotionEventCompat.getActionMasked(arg20);
        if(v2 == 0) {
            this.mNestedYOffset = 0;
        }

        v16.offsetLocation(0f, ((float)this.mNestedYOffset));
        switch(v2) {
            case 0: {
                if(this.getChildCount() == 0) {
                    v2_2 = false;
                    return v2_2;
                }

                v2_2 = !this.mScroller.isFinished() ? true : false;
                this.mIsBeingDragged = v2_2;
                if(v2_2) {
                    ViewParent v2_3 = this.getParent();
                    if(v2_3 != null) {
                        v2_3.requestDisallowInterceptTouchEvent(true);
                    }
                }

                if(!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }

                this.mLastMotionY = ((int)arg20.getY());
                this.mActivePointerId = arg20.getPointerId(0);
                this.startNestedScroll(2);
                break;
            }
            case 1: {
                if(this.mIsBeingDragged) {
                    VelocityTracker v2_1 = this.mVelocityTracker;
                    v2_1.computeCurrentVelocity(1000, ((float)this.mMaximumVelocity));
                    v2 = ((int)VelocityTrackerCompat.getYVelocity(v2_1, this.mActivePointerId));
                    if(Math.abs(v2) > this.mMinimumVelocity) {
                        this.flingWithNestedDispatch(-v2);
                    }
                    else if(this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                        ViewCompat.postInvalidateOnAnimation(((View)this));
                    }
                }

                this.mActivePointerId = -1;
                this.endDrag();
                break;
            }
            case 2: {
                int v17 = arg20.findPointerIndex(this.mActivePointerId);
                if(v17 == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                    goto label_14;
                }

                int v3 = ((int)arg20.getY(v17));
                v2 = this.mLastMotionY - v3;
                if(this.dispatchNestedPreScroll(0, v2, this.mScrollConsumed, this.mScrollOffset)) {
                    v2 -= this.mScrollConsumed[1];
                    v16.offsetLocation(0f, ((float)this.mScrollOffset[1]));
                    this.mNestedYOffset += this.mScrollOffset[1];
                }

                if((this.mIsBeingDragged) || Math.abs(v2) <= this.mTouchSlop) {
                    v4_1 = v2;
                }
                else {
                    ViewParent v4 = this.getParent();
                    if(v4 != null) {
                        v4.requestDisallowInterceptTouchEvent(true);
                    }

                    this.mIsBeingDragged = true;
                    if(v2 > 0) {
                        v4_1 = v2 - this.mTouchSlop;
                        goto label_138;
                    }

                    v4_1 = v2 + this.mTouchSlop;
                }

            label_138:
                if(!this.mIsBeingDragged) {
                    goto label_14;
                }

                this.mLastMotionY = v3 - this.mScrollOffset[1];
                int v18 = this.getScrollY();
                int v8 = this.getScrollRange();
                v2 = this.getOverScrollMode();
                if(v2 != 0) {
                    if(v2 == 1 && v8 > 0) {
                        goto label_155;
                    }

                    v15 = 0;
                }
                else {
                label_155:
                    v15 = 1;
                }

                if((this.overScrollByCompat(0, v4_1, 0, this.getScrollY(), 0, v8, 0, 0, true)) && !this.hasNestedScrollingParent()) {
                    this.mVelocityTracker.clear();
                }

                int v11 = this.getScrollY() - v18;
                if(this.dispatchNestedScroll(0, v11, 0, v4_1 - v11, this.mScrollOffset)) {
                    this.mLastMotionY -= this.mScrollOffset[1];
                    v16.offsetLocation(0f, ((float)this.mScrollOffset[1]));
                    this.mNestedYOffset += this.mScrollOffset[1];
                    goto label_14;
                }

                if(v15 == 0) {
                    goto label_14;
                }

                this.ensureGlows();
                v2 = v18 + v4_1;
                if(v2 < 0) {
                    this.mEdgeGlowTop.onPull((((float)v4_1)) / (((float)this.getHeight())), arg20.getX(v17) / (((float)this.getWidth())));
                    if(!this.mEdgeGlowBottom.isFinished()) {
                        this.mEdgeGlowBottom.onRelease();
                    }
                }
                else if(v2 > v8) {
                    this.mEdgeGlowBottom.onPull((((float)v4_1)) / (((float)this.getHeight())), 1f - arg20.getX(v17) / (((float)this.getWidth())));
                    if(!this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onRelease();
                    }
                }

                if(this.mEdgeGlowTop == null) {
                    goto label_14;
                }

                if((this.mEdgeGlowTop.isFinished()) && (this.mEdgeGlowBottom.isFinished())) {
                    goto label_14;
                }

                ViewCompat.postInvalidateOnAnimation(((View)this));
                break;
            }
            case 3: {
                if((this.mIsBeingDragged) && this.getChildCount() > 0 && (this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange()))) {
                    ViewCompat.postInvalidateOnAnimation(((View)this));
                }

                this.mActivePointerId = -1;
                this.endDrag();
                break;
            }
            case 5: {
                v2 = MotionEventCompat.getActionIndex(arg20);
                this.mLastMotionY = ((int)arg20.getY(v2));
                this.mActivePointerId = arg20.getPointerId(v2);
                break;
            }
            case 6: {
                this.onSecondaryPointerUp(arg20);
                this.mLastMotionY = ((int)arg20.getY(arg20.findPointerIndex(this.mActivePointerId)));
                break;
            }
        }

    label_14:
        if(this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(v16);
        }

        v16.recycle();
        return true;
    }

    boolean overScrollByCompat(int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18, boolean arg19) {
        boolean v8;
        boolean v9;
        this.getOverScrollMode();
        int v7 = arg13 + arg11;
        int v5 = arg14 + arg12;
        int v6 = -0;
        int v2 = arg15;
        int v4 = -0;
        int v3 = arg16;
        if(v7 > v2) {
            v9 = true;
        }
        else if(v7 < v6) {
            v9 = true;
            v2 = v6;
        }
        else {
            v9 = false;
            v2 = v7;
        }

        if(v5 > v3) {
            v8 = true;
        }
        else if(v5 < v4) {
            v8 = true;
            v3 = v4;
        }
        else {
            v8 = false;
            v3 = v5;
        }

        if(v8) {
            this.mScroller.springBack(v2, v3, 0, 0, 0, this.getScrollRange());
        }

        this.onOverScrolled(v2, v3, v9, v8);
        boolean v1 = (v9) || (v8) ? true : false;
        return v1;
    }

    public boolean pageScroll(int arg5) {
        int v0 = arg5 == 130 ? 1 : 0;
        int v2 = this.getHeight();
        if(v0 != 0) {
            this.mTempRect.top = this.getScrollY() + v2;
            v0 = this.getChildCount();
            if(v0 > 0) {
                View v0_1 = this.getChildAt(v0 - 1);
                if(this.mTempRect.top + v2 > v0_1.getBottom()) {
                    this.mTempRect.top = v0_1.getBottom() - v2;
                }
            }
        }
        else {
            this.mTempRect.top = this.getScrollY() - v2;
            if(this.mTempRect.top < 0) {
                this.mTempRect.top = 0;
            }
        }

        this.mTempRect.bottom = this.mTempRect.top + v2;
        return this.scrollAndFocus(arg5, this.mTempRect.top, this.mTempRect.bottom);
    }

    private void recycleVelocityTracker() {
        if(this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void requestChildFocus(View arg2, View arg3) {
        if(!this.mIsLayoutDirty) {
            this.scrollToChild(arg3);
        }
        else {
            this.mChildToScrollTo = arg3;
        }

        super.requestChildFocus(arg2, arg3);
    }

    public boolean requestChildRectangleOnScreen(View arg4, Rect arg5, boolean arg6) {
        arg5.offset(arg4.getLeft() - arg4.getScrollX(), arg4.getTop() - arg4.getScrollY());
        return this.scrollToChildRect(arg5, arg6);
    }

    public void requestDisallowInterceptTouchEvent(boolean arg1) {
        if(arg1) {
            this.recycleVelocityTracker();
        }

        super.requestDisallowInterceptTouchEvent(arg1);
    }

    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    private boolean scrollAndFocus(int arg7, int arg8, int arg9) {
        NestedScrollView v3_1;
        boolean v2 = false;
        int v0 = this.getHeight();
        int v4 = this.getScrollY();
        int v5 = v4 + v0;
        boolean v0_1 = arg7 == 33 ? true : false;
        View v3 = this.findFocusableViewInBounds(v0_1, arg8, arg9);
        if(v3 == null) {
            v3_1 = this;
        }

        if(arg8 < v4 || arg9 > v5) {
            v0 = v0_1 ? arg8 - v4 : arg9 - v5;
            this.doScrollY(v0);
            v2 = true;
        }

        if((((View)v3_1)) != this.findFocus()) {
            ((View)v3_1).requestFocus(arg7);
        }

        return v2;
    }

    public void scrollTo(int arg5, int arg6) {
        if(this.getChildCount() > 0) {
            View v0 = this.getChildAt(0);
            int v1 = NestedScrollView.clamp(arg5, this.getWidth() - this.getPaddingRight() - this.getPaddingLeft(), v0.getWidth());
            int v0_1 = NestedScrollView.clamp(arg6, this.getHeight() - this.getPaddingBottom() - this.getPaddingTop(), v0.getHeight());
            if(v1 == this.getScrollX() && v0_1 == this.getScrollY()) {
                return;
            }

            super.scrollTo(v1, v0_1);
        }
    }

    private void scrollToChild(View arg3) {
        arg3.getDrawingRect(this.mTempRect);
        this.offsetDescendantRectToMyCoords(arg3, this.mTempRect);
        int v0 = this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if(v0 != 0) {
            this.scrollBy(0, v0);
        }
    }

    private boolean scrollToChildRect(Rect arg4, boolean arg5) {
        int v2 = this.computeScrollDeltaToGetChildRectOnScreen(arg4);
        boolean v0 = v2 != 0 ? true : false;
        if(v0) {
            if(arg5) {
                this.scrollBy(0, v2);
            }
            else {
                this.smoothScrollBy(0, v2);
            }
        }

        return v0;
    }

    public void setFillViewport(boolean arg2) {
        if(arg2 != this.mFillViewport) {
            this.mFillViewport = arg2;
            this.requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean arg2) {
        this.mChildHelper.setNestedScrollingEnabled(arg2);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener arg1) {
        this.mOnScrollChangeListener = arg1;
    }

    public void setSmoothScrollingEnabled(boolean arg1) {
        this.mSmoothScrollingEnabled = arg1;
    }

    public boolean shouldDelayChildPressedState() {
        return 1;
    }

    public final void smoothScrollBy(int arg6, int arg7) {
        if(this.getChildCount() != 0) {
            if(AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 0xFA) {
                int v0 = Math.max(0, this.getChildAt(0).getHeight() - (this.getHeight() - this.getPaddingBottom() - this.getPaddingTop()));
                int v1 = this.getScrollY();
                this.mScroller.startScroll(this.getScrollX(), v1, 0, Math.max(0, Math.min(v1 + arg7, v0)) - v1);
                ViewCompat.postInvalidateOnAnimation(((View)this));
            }
            else {
                if(!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }

                this.scrollBy(arg6, arg7);
            }

            this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void smoothScrollTo(int arg3, int arg4) {
        this.smoothScrollBy(arg3 - this.getScrollX(), arg4 - this.getScrollY());
    }

    public boolean startNestedScroll(int arg2) {
        return this.mChildHelper.startNestedScroll(arg2);
    }

    public void stopNestedScroll() {
        this.mChildHelper.stopNestedScroll();
    }
}

