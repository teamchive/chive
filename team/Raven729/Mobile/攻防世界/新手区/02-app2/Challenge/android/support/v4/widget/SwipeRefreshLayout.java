package android.support.v4.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build$VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation$AnimationListener;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    class android.support.v4.widget.SwipeRefreshLayout$1 implements Animation$AnimationListener {
        android.support.v4.widget.SwipeRefreshLayout$1(SwipeRefreshLayout arg1) {
            SwipeRefreshLayout.this = arg1;
            super();
        }

        @SuppressLint(value={"NewApi"}) public void onAnimationEnd(Animation arg3) {
            if(SwipeRefreshLayout.this.mRefreshing) {
                SwipeRefreshLayout.this.mProgress.setAlpha(0xFF);
                SwipeRefreshLayout.this.mProgress.start();
                if((SwipeRefreshLayout.this.mNotify) && SwipeRefreshLayout.this.mListener != null) {
                    SwipeRefreshLayout.this.mListener.onRefresh();
                }

                SwipeRefreshLayout.this.mCurrentTargetOffsetTop = SwipeRefreshLayout.this.mCircleView.getTop();
            }
            else {
                SwipeRefreshLayout.this.reset();
            }
        }

        public void onAnimationRepeat(Animation arg1) {
        }

        public void onAnimationStart(Animation arg1) {
        }
    }

    class android.support.v4.widget.SwipeRefreshLayout$6 extends Animation {
        android.support.v4.widget.SwipeRefreshLayout$6(SwipeRefreshLayout arg1) {
            SwipeRefreshLayout.this = arg1;
            super();
        }

        public void applyTransformation(float arg4, Transformation arg5) {
            int v0 = !SwipeRefreshLayout.this.mUsingCustomStart ? SwipeRefreshLayout.this.mSpinnerOffsetEnd - Math.abs(SwipeRefreshLayout.this.mOriginalOffsetTop) : SwipeRefreshLayout.this.mSpinnerOffsetEnd;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((((int)((((float)(v0 - SwipeRefreshLayout.this.mFrom))) * arg4))) + SwipeRefreshLayout.this.mFrom - SwipeRefreshLayout.this.mCircleView.getTop(), false);
            SwipeRefreshLayout.this.mProgress.setArrowScale(1f - arg4);
        }
    }

    class android.support.v4.widget.SwipeRefreshLayout$7 extends Animation {
        android.support.v4.widget.SwipeRefreshLayout$7(SwipeRefreshLayout arg1) {
            SwipeRefreshLayout.this = arg1;
            super();
        }

        public void applyTransformation(float arg2, Transformation arg3) {
            SwipeRefreshLayout.this.moveToStart(arg2);
        }
    }

    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(SwipeRefreshLayout arg1, @Nullable View arg2);
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = 0xFFFAFAFA;
    @VisibleForTesting static final int CIRCLE_DIAMETER = 40;
    @VisibleForTesting static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 0x40;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS = null;
    private static final String LOG_TAG = null;
    private static final int MAX_ALPHA = 0xFF;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private OnChildScrollUpCallback mChildScrollUpCallback;
    private int mCircleDiameter;
    CircleImageView mCircleView;
    private int mCircleViewIndex;
    int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final NestedScrollingChildHelper mNestedScrollingChildHelper;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    MaterialProgressDrawable mProgress;
    private Animation$AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;

    static {
        SwipeRefreshLayout.LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
        SwipeRefreshLayout.LAYOUT_ATTRS = new int[]{0x101000E};
    }

    public SwipeRefreshLayout(Context arg2) {
        this(arg2, null);
    }

    public SwipeRefreshLayout(Context arg6, AttributeSet arg7) {
        super(arg6, arg7);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new android.support.v4.widget.SwipeRefreshLayout$1(this);
        this.mAnimateToCorrectPosition = new android.support.v4.widget.SwipeRefreshLayout$6(this);
        this.mAnimateToStartPosition = new android.support.v4.widget.SwipeRefreshLayout$7(this);
        this.mTouchSlop = ViewConfiguration.get(arg6).getScaledTouchSlop();
        this.mMediumAnimationDuration = this.getResources().getInteger(0x10E0001);
        this.setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2f);
        DisplayMetrics v0 = this.getResources().getDisplayMetrics();
        this.mCircleDiameter = ((int)(40f * v0.density));
        this.createProgressView();
        ViewCompat.setChildrenDrawingOrderEnabled(((ViewGroup)this), true);
        this.mSpinnerOffsetEnd = ((int)(v0.density * 64f));
        this.mTotalDragDistance = ((float)this.mSpinnerOffsetEnd);
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(((ViewGroup)this));
        this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(((View)this));
        this.setNestedScrollingEnabled(true);
        int v0_1 = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = v0_1;
        this.mOriginalOffsetTop = v0_1;
        this.moveToStart(1f);
        TypedArray v0_2 = arg6.obtainStyledAttributes(arg7, SwipeRefreshLayout.LAYOUT_ATTRS);
        this.setEnabled(v0_2.getBoolean(0, true));
        v0_2.recycle();
    }

    private void animateOffsetToCorrectPosition(int arg5, Animation$AnimationListener arg6) {
        this.mFrom = arg5;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if(arg6 != null) {
            this.mCircleView.setAnimationListener(arg6);
        }

        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int arg5, Animation$AnimationListener arg6) {
        if(this.mScale) {
            this.startScaleDownReturnToStartAnimation(arg5, arg6);
        }
        else {
            this.mFrom = arg5;
            this.mAnimateToStartPosition.reset();
            this.mAnimateToStartPosition.setDuration(200);
            this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
            if(arg6 != null) {
                this.mCircleView.setAnimationListener(arg6);
            }

            this.mCircleView.clearAnimation();
            this.mCircleView.startAnimation(this.mAnimateToStartPosition);
        }
    }

    public boolean canChildScrollUp() {
        boolean v0;
        int v4 = -1;
        boolean v2 = false;
        if(this.mChildScrollUpCallback != null) {
            v0 = this.mChildScrollUpCallback.canChildScrollUp(this, this.mTarget);
        }
        else if(Build$VERSION.SDK_INT >= 14) {
            v0 = ViewCompat.canScrollVertically(this.mTarget, v4);
        }
        else if((this.mTarget instanceof AbsListView)) {
            View v0_1 = this.mTarget;
            if(((AbsListView)v0_1).getChildCount() > 0 && (((AbsListView)v0_1).getFirstVisiblePosition() > 0 || ((AbsListView)v0_1).getChildAt(0).getTop() < ((AbsListView)v0_1).getPaddingTop())) {
                return true;
            }

            v0 = false;
        }
        else {
            if((ViewCompat.canScrollVertically(this.mTarget, v4)) || this.mTarget.getScrollY() > 0) {
                v2 = true;
            }

            v0 = v2;
        }

        return v0;
    }

    private void createProgressView() {
        this.mCircleView = new CircleImageView(this.getContext(), 0xFFFAFAFA);
        this.mProgress = new MaterialProgressDrawable(this.getContext(), ((View)this));
        this.mProgress.setBackgroundColor(0xFFFAFAFA);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        this.addView(this.mCircleView);
    }

    public boolean dispatchNestedFling(float arg2, float arg3, boolean arg4) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(arg2, arg3, arg4);
    }

    public boolean dispatchNestedPreFling(float arg2, float arg3) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(arg2, arg3);
    }

    public boolean dispatchNestedPreScroll(int arg2, int arg3, int[] arg4, int[] arg5) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(arg2, arg3, arg4, arg5);
    }

    public boolean dispatchNestedScroll(int arg7, int arg8, int arg9, int arg10, int[] arg11) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(arg7, arg8, arg9, arg10, arg11);
    }

    private void ensureTarget() {
        if(this.mTarget == null) {
            int v0 = 0;
            while(v0 < this.getChildCount()) {
                View v1 = this.getChildAt(v0);
                if(!v1.equals(this.mCircleView)) {
                    this.mTarget = v1;
                }
                else {
                    ++v0;
                    continue;
                }

                return;
            }
        }
    }

    private void finishSpinner(float arg5) {
        if(arg5 > this.mTotalDragDistance) {
            this.setRefreshing(true, true);
        }
        else {
            this.mRefreshing = false;
            this.mProgress.setStartEndTrim(0f, 0f);
            Animation$AnimationListener v0 = null;
            if(!this.mScale) {
                android.support.v4.widget.SwipeRefreshLayout$5 v0_1 = new Animation$AnimationListener() {
                    public void onAnimationEnd(Animation arg3) {
                        if(!SwipeRefreshLayout.this.mScale) {
                            SwipeRefreshLayout.this.startScaleDownAnimation(null);
                        }
                    }

                    public void onAnimationRepeat(Animation arg1) {
                    }

                    public void onAnimationStart(Animation arg1) {
                    }
                };
            }

            this.animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, v0);
            this.mProgress.showArrow(false);
        }
    }

    protected int getChildDrawingOrder(int arg2, int arg3) {
        if(this.mCircleViewIndex >= 0) {
            if(arg3 == arg2 - 1) {
                arg3 = this.mCircleViewIndex;
            }
            else if(arg3 >= this.mCircleViewIndex) {
                ++arg3;
            }
        }

        return arg3;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    private boolean isAlphaUsedForScale() {
        boolean v0 = Build$VERSION.SDK_INT < 11 ? true : false;
        return v0;
    }

    private boolean isAnimationRunning(Animation arg2) {
        boolean v0 = arg2 == null || !arg2.hasStarted() || (arg2.hasEnded()) ? false : true;
        return v0;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    @SuppressLint(value={"NewApi"}) private void moveSpinner(float arg15) {
        float v6 = 4f;
        float v13 = 0.8f;
        float v11 = 2f;
        float v10 = 1f;
        this.mProgress.showArrow(true);
        float v1 = Math.min(v10, Math.abs(arg15 / this.mTotalDragDistance));
        float v2 = (((float)Math.max((((double)v1)) - 0.4, 0))) * 5f / 3f;
        float v3 = Math.abs(arg15) - this.mTotalDragDistance;
        float v0 = this.mUsingCustomStart ? ((float)(this.mSpinnerOffsetEnd - this.mOriginalOffsetTop)) : ((float)this.mSpinnerOffsetEnd);
        v3 = Math.max(0f, Math.min(v3, v0 * v11) / v0);
        v3 = (((float)((((double)(v3 / v6))) - Math.pow(((double)(v3 / v6)), 2)))) * v11;
        int v0_1 = (((int)(v0 * v1 + v0 * v3 * v11))) + this.mOriginalOffsetTop;
        if(this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }

        if(!this.mScale) {
            ViewCompat.setScaleX(this.mCircleView, v10);
            ViewCompat.setScaleY(this.mCircleView, v10);
        }

        if(this.mScale) {
            this.setAnimationProgress(Math.min(v10, arg15 / this.mTotalDragDistance));
        }

        if(arg15 < this.mTotalDragDistance) {
            if(this.mProgress.getAlpha() > 76 && !this.isAnimationRunning(this.mAlphaStartAnimation)) {
                this.startProgressAlphaStartAnimation();
            }
        }
        else if(this.mProgress.getAlpha() < 0xFF && !this.isAnimationRunning(this.mAlphaMaxAnimation)) {
            this.startProgressAlphaMaxAnimation();
        }

        this.mProgress.setStartEndTrim(0f, Math.min(v13, v2 * v13));
        this.mProgress.setArrowScale(Math.min(v10, v2));
        this.mProgress.setProgressRotation((-0.25f + v2 * 0.4f + v3 * v11) * 0.5f);
        this.setTargetOffsetTopAndBottom(v0_1 - this.mCurrentTargetOffsetTop, true);
    }

    void moveToStart(float arg4) {
        this.setTargetOffsetTopAndBottom(this.mFrom + (((int)((((float)(this.mOriginalOffsetTop - this.mFrom))) * arg4))) - this.mCircleView.getTop(), false);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.reset();
    }

    public boolean onInterceptTouchEvent(MotionEvent arg5) {
        int v3 = -1;
        boolean v0 = false;
        this.ensureTarget();
        int v1 = MotionEventCompat.getActionMasked(arg5);
        if((this.mReturningToStart) && v1 == 0) {
            this.mReturningToStart = false;
        }

        if((this.isEnabled()) && !this.mReturningToStart && !this.canChildScrollUp() && !this.mRefreshing && !this.mNestedScrollInProgress) {
            switch(v1) {
                case 0: {
                    this.setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop(), true);
                    this.mActivePointerId = arg5.getPointerId(0);
                    this.mIsBeingDragged = false;
                    v1 = arg5.findPointerIndex(this.mActivePointerId);
                    if(v1 >= 0) {
                        this.mInitialDownY = arg5.getY(v1);
                        goto label_20;
                    }

                    return v0;
                }
                case 2: {
                    if(this.mActivePointerId == v3) {
                        Log.e(SwipeRefreshLayout.LOG_TAG, "Got ACTION_MOVE event but don\'t have an active pointer id.");
                    }
                    else {
                        v1 = arg5.findPointerIndex(this.mActivePointerId);
                        if(v1 >= 0) {
                            this.startDragging(arg5.getY(v1));
                            goto label_20;
                        }
                    }

                    return v0;
                }
                case 1: 
                case 3: {
                    this.mIsBeingDragged = false;
                    this.mActivePointerId = v3;
                    break;
                }
                case 6: {
                    this.onSecondaryPointerUp(arg5);
                    break;
                }
            }

        label_20:
            v0 = this.mIsBeingDragged;
        }

        return v0;
    }

    protected void onLayout(boolean arg8, int arg9, int arg10, int arg11, int arg12) {
        int v0 = this.getMeasuredWidth();
        int v1 = this.getMeasuredHeight();
        if(this.getChildCount() != 0) {
            if(this.mTarget == null) {
                this.ensureTarget();
            }

            if(this.mTarget == null) {
                return;
            }

            View v2 = this.mTarget;
            int v3 = this.getPaddingLeft();
            int v4 = this.getPaddingTop();
            v2.layout(v3, v4, v0 - this.getPaddingLeft() - this.getPaddingRight() + v3, v1 - this.getPaddingTop() - this.getPaddingBottom() + v4);
            v1 = this.mCircleView.getMeasuredWidth();
            this.mCircleView.layout(v0 / 2 - v1 / 2, this.mCurrentTargetOffsetTop, v0 / 2 + v1 / 2, this.mCurrentTargetOffsetTop + this.mCircleView.getMeasuredHeight());
        }
    }

    public void onMeasure(int arg6, int arg7) {
        int v4 = 0x40000000;
        super.onMeasure(arg6, arg7);
        if(this.mTarget == null) {
            this.ensureTarget();
        }

        if(this.mTarget != null) {
            this.mTarget.measure(View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), v4), View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), v4));
            this.mCircleView.measure(View$MeasureSpec.makeMeasureSpec(this.mCircleDiameter, v4), View$MeasureSpec.makeMeasureSpec(this.mCircleDiameter, v4));
            this.mCircleViewIndex = -1;
            int v0 = 0;
            while(v0 < this.getChildCount()) {
                if(this.getChildAt(v0) == this.mCircleView) {
                    this.mCircleViewIndex = v0;
                }
                else {
                    ++v0;
                    continue;
                }

                return;
            }
        }
    }

    public boolean onNestedFling(View arg2, float arg3, float arg4, boolean arg5) {
        return this.dispatchNestedFling(arg3, arg4, arg5);
    }

    public boolean onNestedPreFling(View arg2, float arg3, float arg4) {
        return this.dispatchNestedPreFling(arg3, arg4);
    }

    public void onNestedPreScroll(View arg7, int arg8, int arg9, int[] arg10) {
        if(arg9 > 0 && this.mTotalUnconsumed > 0f) {
            if((((float)arg9)) > this.mTotalUnconsumed) {
                arg10[1] = arg9 - (((int)this.mTotalUnconsumed));
                this.mTotalUnconsumed = 0f;
            }
            else {
                this.mTotalUnconsumed -= ((float)arg9);
                arg10[1] = arg9;
            }

            this.moveSpinner(this.mTotalUnconsumed);
        }

        if((this.mUsingCustomStart) && arg9 > 0 && this.mTotalUnconsumed == 0f && Math.abs(arg9 - arg10[1]) > 0) {
            this.mCircleView.setVisibility(8);
        }

        int[] v0 = this.mParentScrollConsumed;
        if(this.dispatchNestedPreScroll(arg8 - arg10[0], arg9 - arg10[1], v0, null)) {
            arg10[0] += v0[0];
            arg10[1] = v0[1] + arg10[1];
        }
    }

    public void onNestedScroll(View arg7, int arg8, int arg9, int arg10, int arg11) {
        this.dispatchNestedScroll(arg8, arg9, arg10, arg11, this.mParentOffsetInWindow);
        int v0 = this.mParentOffsetInWindow[1] + arg11;
        if(v0 < 0 && !this.canChildScrollUp()) {
            this.mTotalUnconsumed = (((float)Math.abs(v0))) + this.mTotalUnconsumed;
            this.moveSpinner(this.mTotalUnconsumed);
        }
    }

    public void onNestedScrollAccepted(View arg2, View arg3, int arg4) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(arg2, arg3, arg4);
        this.startNestedScroll(arg4 & 2);
        this.mTotalUnconsumed = 0f;
        this.mNestedScrollInProgress = true;
    }

    private void onSecondaryPointerUp(MotionEvent arg4) {
        int v0 = MotionEventCompat.getActionIndex(arg4);
        if(arg4.getPointerId(v0) == this.mActivePointerId) {
            v0 = v0 == 0 ? 1 : 0;
            this.mActivePointerId = arg4.getPointerId(v0);
        }
    }

    public boolean onStartNestedScroll(View arg2, View arg3, int arg4) {
        boolean v0 = !this.isEnabled() || (this.mReturningToStart) || (this.mRefreshing) || (arg4 & 2) == 0 ? false : true;
        return v0;
    }

    public void onStopNestedScroll(View arg3) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(arg3);
        this.mNestedScrollInProgress = false;
        if(this.mTotalUnconsumed > 0f) {
            this.finishSpinner(this.mTotalUnconsumed);
            this.mTotalUnconsumed = 0f;
        }

        this.stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent arg5) {
        float v1_1;
        float v3 = 0.5f;
        boolean v0 = false;
        int v1 = MotionEventCompat.getActionMasked(arg5);
        if((this.mReturningToStart) && v1 == 0) {
            this.mReturningToStart = false;
        }

        if((this.isEnabled()) && !this.mReturningToStart && !this.canChildScrollUp() && !this.mRefreshing && !this.mNestedScrollInProgress) {
            switch(v1) {
                case 0: {
                    goto label_21;
                }
                case 1: {
                    goto label_54;
                }
                case 2: {
                    goto label_25;
                }
                case 3: {
                    return v0;
                }
                case 5: {
                    goto label_43;
                }
                case 6: {
                    goto label_52;
                }
            }

            goto label_19;
        label_52:
            this.onSecondaryPointerUp(arg5);
            goto label_19;
        label_21:
            this.mActivePointerId = arg5.getPointerId(0);
            this.mIsBeingDragged = false;
            goto label_19;
        label_54:
            v1 = arg5.findPointerIndex(this.mActivePointerId);
            if(v1 < 0) {
                Log.e(SwipeRefreshLayout.LOG_TAG, "Got ACTION_UP event but don\'t have an active pointer id.");
            }
            else {
                if(this.mIsBeingDragged) {
                    v1_1 = (arg5.getY(v1) - this.mInitialMotionY) * v3;
                    this.mIsBeingDragged = false;
                    this.finishSpinner(v1_1);
                }

                this.mActivePointerId = -1;
                return v0;
            label_25:
                v1 = arg5.findPointerIndex(this.mActivePointerId);
                if(v1 < 0) {
                    Log.e(SwipeRefreshLayout.LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return v0;
                }

                v1_1 = arg5.getY(v1);
                this.startDragging(v1_1);
                if(!this.mIsBeingDragged) {
                    goto label_19;
                }

                v1_1 = (v1_1 - this.mInitialMotionY) * v3;
                if(v1_1 <= 0f) {
                    return v0;
                }

                this.moveSpinner(v1_1);
                goto label_19;
            label_43:
                v1 = MotionEventCompat.getActionIndex(arg5);
                if(v1 < 0) {
                    Log.e(SwipeRefreshLayout.LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return v0;
                }

                this.mActivePointerId = arg5.getPointerId(v1);
            label_19:
                v0 = true;
            }
        }

        return v0;
    }

    public void requestDisallowInterceptTouchEvent(boolean arg3) {
        if((Build$VERSION.SDK_INT >= 21 || !(this.mTarget instanceof AbsListView)) && (this.mTarget == null || (ViewCompat.isNestedScrollingEnabled(this.mTarget)))) {
            super.requestDisallowInterceptTouchEvent(arg3);
        }
    }

    void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        this.setColorViewAlpha(0xFF);
        if(this.mScale) {
            this.setAnimationProgress(0f);
        }
        else {
            this.setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop, true);
        }

        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    void setAnimationProgress(float arg2) {
        if(this.isAlphaUsedForScale()) {
            this.setColorViewAlpha(((int)(255f * arg2)));
        }
        else {
            ViewCompat.setScaleX(this.mCircleView, arg2);
            ViewCompat.setScaleY(this.mCircleView, arg2);
        }
    }

    @Deprecated public void setColorScheme(@ColorInt int[] arg1) {
        this.setColorSchemeResources(arg1);
    }

    public void setColorSchemeColors(@ColorInt int[] arg2) {
        this.ensureTarget();
        this.mProgress.setColorSchemeColors(arg2);
    }

    public void setColorSchemeResources(@ColorRes int[] arg5) {
        Context v1 = this.getContext();
        int[] v2 = new int[arg5.length];
        int v0;
        for(v0 = 0; v0 < arg5.length; ++v0) {
            v2[v0] = ContextCompat.getColor(v1, arg5[v0]);
        }

        this.setColorSchemeColors(v2);
    }

    @SuppressLint(value={"NewApi"}) private void setColorViewAlpha(int arg2) {
        this.mCircleView.getBackground().setAlpha(arg2);
        this.mProgress.setAlpha(arg2);
    }

    public void setDistanceToTriggerSync(int arg2) {
        this.mTotalDragDistance = ((float)arg2);
    }

    public void setEnabled(boolean arg1) {
        super.setEnabled(arg1);
        if(!arg1) {
            this.reset();
        }
    }

    public void setNestedScrollingEnabled(boolean arg2) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(arg2);
    }

    public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback arg1) {
        this.mChildScrollUpCallback = arg1;
    }

    public void setOnRefreshListener(OnRefreshListener arg1) {
        this.mListener = arg1;
    }

    @Deprecated public void setProgressBackgroundColor(int arg1) {
        this.setProgressBackgroundColorSchemeResource(arg1);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int arg2) {
        this.mCircleView.setBackgroundColor(arg2);
        this.mProgress.setBackgroundColor(arg2);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int arg2) {
        this.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(this.getContext(), arg2));
    }

    public void setProgressViewEndTarget(boolean arg2, int arg3) {
        this.mSpinnerOffsetEnd = arg3;
        this.mScale = arg2;
        this.mCircleView.invalidate();
    }

    public void setProgressViewOffset(boolean arg2, int arg3, int arg4) {
        this.mScale = arg2;
        this.mOriginalOffsetTop = arg3;
        this.mSpinnerOffsetEnd = arg4;
        this.mUsingCustomStart = true;
        this.reset();
        this.mRefreshing = false;
    }

    private void setRefreshing(boolean arg3, boolean arg4) {
        if(this.mRefreshing != arg3) {
            this.mNotify = arg4;
            this.ensureTarget();
            this.mRefreshing = arg3;
            if(this.mRefreshing) {
                this.animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            }
            else {
                this.startScaleDownAnimation(this.mRefreshListener);
            }
        }
    }

    public void setRefreshing(boolean arg4) {
        if(!arg4 || this.mRefreshing == arg4) {
            this.setRefreshing(arg4, false);
        }
        else {
            this.mRefreshing = arg4;
            int v0 = !this.mUsingCustomStart ? this.mSpinnerOffsetEnd + this.mOriginalOffsetTop : this.mSpinnerOffsetEnd;
            this.setTargetOffsetTopAndBottom(v0 - this.mCurrentTargetOffsetTop, true);
            this.mNotify = false;
            this.startScaleUpAnimation(this.mRefreshListener);
        }
    }

    public void setSize(int arg3) {
        if(arg3 == 0 || arg3 == 1) {
            DisplayMetrics v0 = this.getResources().getDisplayMetrics();
            this.mCircleDiameter = arg3 == 0 ? ((int)(v0.density * 56f)) : ((int)(v0.density * 40f));
            this.mCircleView.setImageDrawable(null);
            this.mProgress.updateSizes(arg3);
            this.mCircleView.setImageDrawable(this.mProgress);
        }
    }

    void setTargetOffsetTopAndBottom(int arg3, boolean arg4) {
        this.mCircleView.bringToFront();
        ViewCompat.offsetTopAndBottom(this.mCircleView, arg3);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
        if((arg4) && Build$VERSION.SDK_INT < 11) {
            this.invalidate();
        }
    }

    @SuppressLint(value={"NewApi"}) private Animation startAlphaAnimation(int arg5, int arg6) {
        android.support.v4.widget.SwipeRefreshLayout$4 v0_1;
        Animation v0 = null;
        if(!this.mScale || !this.isAlphaUsedForScale()) {
            android.support.v4.widget.SwipeRefreshLayout$4 v1 = new Animation(arg5, arg6) {
                public void applyTransformation(float arg5, Transformation arg6) {
                    SwipeRefreshLayout.this.mProgress.setAlpha(((int)((((float)this.val$startingAlpha)) + (((float)(this.val$endingAlpha - this.val$startingAlpha))) * arg5)));
                }
            };
            ((Animation)v1).setDuration(300);
            this.mCircleView.setAnimationListener(((Animation$AnimationListener)v0));
            this.mCircleView.clearAnimation();
            this.mCircleView.startAnimation(((Animation)v1));
            v0_1 = v1;
        }

        return ((Animation)v0_1);
    }

    @SuppressLint(value={"NewApi"}) private void startDragging(float arg3) {
        if(arg3 - this.mInitialDownY > (((float)this.mTouchSlop)) && !this.mIsBeingDragged) {
            this.mInitialMotionY = this.mInitialDownY + (((float)this.mTouchSlop));
            this.mIsBeingDragged = true;
            this.mProgress.setAlpha(76);
        }
    }

    public boolean startNestedScroll(int arg2) {
        return this.mNestedScrollingChildHelper.startNestedScroll(arg2);
    }

    @SuppressLint(value={"NewApi"}) private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = this.startAlphaAnimation(this.mProgress.getAlpha(), 0xFF);
    }

    @SuppressLint(value={"NewApi"}) private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = this.startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    void startScaleDownAnimation(Animation$AnimationListener arg5) {
        this.mScaleDownAnimation = new Animation() {
            public void applyTransformation(float arg3, Transformation arg4) {
                SwipeRefreshLayout.this.setAnimationProgress(1f - arg3);
            }
        };
        this.mScaleDownAnimation.setDuration(150);
        this.mCircleView.setAnimationListener(arg5);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    @SuppressLint(value={"NewApi"}) private void startScaleDownReturnToStartAnimation(int arg5, Animation$AnimationListener arg6) {
        this.mFrom = arg5;
        this.mStartingScale = this.isAlphaUsedForScale() ? ((float)this.mProgress.getAlpha()) : ViewCompat.getScaleX(this.mCircleView);
        this.mScaleDownToStartAnimation = new Animation() {
            public void applyTransformation(float arg3, Transformation arg4) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.mStartingScale + -SwipeRefreshLayout.this.mStartingScale * arg3);
                SwipeRefreshLayout.this.moveToStart(arg3);
            }
        };
        this.mScaleDownToStartAnimation.setDuration(150);
        if(arg6 != null) {
            this.mCircleView.setAnimationListener(arg6);
        }

        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    @SuppressLint(value={"NewApi"}) private void startScaleUpAnimation(Animation$AnimationListener arg5) {
        this.mCircleView.setVisibility(0);
        if(Build$VERSION.SDK_INT >= 11) {
            this.mProgress.setAlpha(0xFF);
        }

        this.mScaleAnimation = new Animation() {
            public void applyTransformation(float arg2, Transformation arg3) {
                SwipeRefreshLayout.this.setAnimationProgress(arg2);
            }
        };
        this.mScaleAnimation.setDuration(((long)this.mMediumAnimationDuration));
        if(arg5 != null) {
            this.mCircleView.setAnimationListener(arg5);
        }

        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }
}

