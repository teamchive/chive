package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ViewDragHelper {
    final class android.support.v4.widget.ViewDragHelper$1 implements Interpolator {
        android.support.v4.widget.ViewDragHelper$1() {
            super();
        }

        public float getInterpolation(float arg4) {
            float v0 = arg4 - 1f;
            return v0 * (v0 * v0 * v0 * v0) + 1f;
        }
    }

    class android.support.v4.widget.ViewDragHelper$2 implements Runnable {
        android.support.v4.widget.ViewDragHelper$2(ViewDragHelper arg1) {
            ViewDragHelper.this = arg1;
            super();
        }

        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    }

    public abstract class Callback {
        public Callback() {
            super();
        }

        public int clampViewPositionHorizontal(View arg2, int arg3, int arg4) {
            return 0;
        }

        public int clampViewPositionVertical(View arg2, int arg3, int arg4) {
            return 0;
        }

        public int getOrderedChildIndex(int arg1) {
            return arg1;
        }

        public int getViewHorizontalDragRange(View arg2) {
            return 0;
        }

        public int getViewVerticalDragRange(View arg2) {
            return 0;
        }

        public void onEdgeDragStarted(int arg1, int arg2) {
        }

        public boolean onEdgeLock(int arg2) {
            return 0;
        }

        public void onEdgeTouched(int arg1, int arg2) {
        }

        public void onViewCaptured(View arg1, int arg2) {
        }

        public void onViewDragStateChanged(int arg1) {
        }

        public void onViewPositionChanged(View arg1, int arg2, int arg3, int arg4, int arg5) {
        }

        public void onViewReleased(View arg1, float arg2, float arg3) {
        }

        public abstract boolean tryCaptureView(View arg1, int arg2);
    }

    private static final int BASE_SETTLE_DURATION = 0x100;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private int mActivePointerId;
    private final Callback mCallback;
    private View mCapturedView;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private ScrollerCompat mScroller;
    private final Runnable mSetIdleRunnable;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;
    private static final Interpolator sInterpolator;

    static {
        ViewDragHelper.sInterpolator = new android.support.v4.widget.ViewDragHelper$1();
    }

    private ViewDragHelper(Context arg4, ViewGroup arg5, Callback arg6) {
        super();
        this.mActivePointerId = -1;
        this.mSetIdleRunnable = new android.support.v4.widget.ViewDragHelper$2(this);
        if(arg5 == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }

        if(arg6 == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }

        this.mParentView = arg5;
        this.mCallback = arg6;
        ViewConfiguration v0 = ViewConfiguration.get(arg4);
        this.mEdgeSize = ((int)(arg4.getResources().getDisplayMetrics().density * 20f + 0.5f));
        this.mTouchSlop = v0.getScaledTouchSlop();
        this.mMaxVelocity = ((float)v0.getScaledMaximumFlingVelocity());
        this.mMinVelocity = ((float)v0.getScaledMinimumFlingVelocity());
        this.mScroller = ScrollerCompat.create(arg4, ViewDragHelper.sInterpolator);
    }

    public void abort() {
        this.cancel();
        if(this.mDragState == 2) {
            int v4 = this.mScroller.getCurrX();
            int v5 = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int v2 = this.mScroller.getCurrX();
            int v3 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, v2, v3, v2 - v4, v3 - v5);
        }

        this.setDragState(0);
    }

    protected boolean canScroll(View arg12, boolean arg13, int arg14, int arg15, int arg16, int arg17) {
        boolean v0;
        if((arg12 instanceof ViewGroup)) {
            View v7 = arg12;
            int v9 = arg12.getScrollX();
            int v10 = arg12.getScrollY();
            int v8 = ((ViewGroup)v7).getChildCount() - 1;
            while(true) {
                if(v8 >= 0) {
                    View v1 = ((ViewGroup)v7).getChildAt(v8);
                    if(arg16 + v9 >= v1.getLeft() && arg16 + v9 < v1.getRight() && arg17 + v10 >= v1.getTop() && arg17 + v10 < v1.getBottom() && (this.canScroll(v1, true, arg14, arg15, arg16 + v9 - v1.getLeft(), arg17 + v10 - v1.getTop()))) {
                        v0 = true;
                        return v0;
                    }

                    --v8;
                    continue;
                }
                else {
                    goto label_39;
                }
            }
        }
        else {
        label_39:
            if((arg13) && ((ViewCompat.canScrollHorizontally(arg12, -arg14)) || (ViewCompat.canScrollVertically(arg12, -arg15)))) {
                return true;
            }

            v0 = false;
        }

        return v0;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        this.clearMotionHistory();
        if(this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(View arg4, int arg5) {
        if(arg4.getParent() != this.mParentView) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper\'s tracked parent view (" + this.mParentView + ")");
        }

        this.mCapturedView = arg4;
        this.mActivePointerId = arg5;
        this.mCallback.onViewCaptured(arg4, arg5);
        this.setDragState(1);
    }

    private boolean checkNewEdgeDrag(float arg5, float arg6, int arg7, int arg8) {
        boolean v0 = false;
        float v1 = Math.abs(arg5);
        float v2 = Math.abs(arg6);
        if((this.mInitialEdgesTouched[arg7] & arg8) == arg8 && (this.mTrackingEdges & arg8) != 0 && (this.mEdgeDragsLocked[arg7] & arg8) != arg8 && (this.mEdgeDragsInProgress[arg7] & arg8) != arg8 && (v1 > (((float)this.mTouchSlop)) || v2 > (((float)this.mTouchSlop)))) {
            if(v1 < v2 * 0.5f && (this.mCallback.onEdgeLock(arg8))) {
                this.mEdgeDragsLocked[arg7] |= arg8;
                return v0;
            }

            if((this.mEdgeDragsInProgress[arg7] & arg8) != 0) {
                return v0;
            }

            if(v1 <= (((float)this.mTouchSlop))) {
                return v0;
            }

            v0 = true;
        }

        return v0;
    }

    public boolean checkTouchSlop(int arg5) {
        boolean v0 = false;
        int v2 = this.mInitialMotionX.length;
        int v1 = 0;
        while(v1 < v2) {
            if(this.checkTouchSlop(arg5, v1)) {
                v0 = true;
            }
            else {
                ++v1;
                continue;
            }

            return v0;
        }

        return v0;
    }

    private boolean checkTouchSlop(View arg6, float arg7, float arg8) {
        boolean v1 = true;
        if(arg6 == null) {
            v1 = false;
        }
        else {
            int v0 = this.mCallback.getViewHorizontalDragRange(arg6) > 0 ? 1 : 0;
            int v3 = this.mCallback.getViewVerticalDragRange(arg6) > 0 ? 1 : 0;
            if(v0 != 0 && v3 != 0) {
                if(arg7 * arg7 + arg8 * arg8 <= (((float)(this.mTouchSlop * this.mTouchSlop)))) {
                    v1 = false;
                }
                else {
                }

                return v1;
            }

            if(v0 != 0) {
                if(Math.abs(arg7) > (((float)this.mTouchSlop))) {
                    return v1;
                }

                return false;
            }

            if(v3 != 0) {
                if(Math.abs(arg8) > (((float)this.mTouchSlop))) {
                    return v1;
                }

                return false;
            }

            v1 = false;
        }

        return v1;
    }

    public boolean checkTouchSlop(int arg8, int arg9) {
        boolean v1 = true;
        if(!this.isPointerDown(arg9)) {
            v1 = false;
        }
        else {
            int v3 = (arg8 & 1) == 1 ? 1 : 0;
            int v0 = (arg8 & 2) == 2 ? 1 : 0;
            float v4 = this.mLastMotionX[arg9] - this.mInitialMotionX[arg9];
            float v5 = this.mLastMotionY[arg9] - this.mInitialMotionY[arg9];
            if(v3 != 0 && v0 != 0) {
                if(v4 * v4 + v5 * v5 <= (((float)(this.mTouchSlop * this.mTouchSlop)))) {
                    v1 = false;
                }
                else {
                }

                return v1;
            }

            if(v3 != 0) {
                if(Math.abs(v4) > (((float)this.mTouchSlop))) {
                    return v1;
                }

                return false;
            }

            if(v0 != 0) {
                if(Math.abs(v5) > (((float)this.mTouchSlop))) {
                    return v1;
                }

                return false;
            }

            v1 = false;
        }

        return v1;
    }

    private float clampMag(float arg4, float arg5, float arg6) {
        float v1 = Math.abs(arg4);
        if(v1 < arg5) {
            arg6 = 0f;
        }
        else if(v1 <= arg6) {
            arg6 = arg4;
        }
        else if(arg4 <= 0f) {
            arg6 = -arg6;
        }

        return arg6;
    }

    private int clampMag(int arg2, int arg3, int arg4) {
        int v0 = Math.abs(arg2);
        if(v0 < arg3) {
            arg4 = 0;
        }
        else if(v0 <= arg4) {
            arg4 = arg2;
        }
        else if(arg2 <= 0) {
            arg4 = -arg4;
        }

        return arg4;
    }

    private void clearMotionHistory() {
        if(this.mInitialMotionX != null) {
            Arrays.fill(this.mInitialMotionX, 0f);
            Arrays.fill(this.mInitialMotionY, 0f);
            Arrays.fill(this.mLastMotionX, 0f);
            Arrays.fill(this.mLastMotionY, 0f);
            Arrays.fill(this.mInitialEdgesTouched, 0);
            Arrays.fill(this.mEdgeDragsInProgress, 0);
            Arrays.fill(this.mEdgeDragsLocked, 0);
            this.mPointersDown = 0;
        }
    }

    private void clearMotionHistory(int arg4) {
        if(this.mInitialMotionX != null && (this.isPointerDown(arg4))) {
            this.mInitialMotionX[arg4] = 0f;
            this.mInitialMotionY[arg4] = 0f;
            this.mLastMotionX[arg4] = 0f;
            this.mLastMotionY[arg4] = 0f;
            this.mInitialEdgesTouched[arg4] = 0;
            this.mEdgeDragsInProgress[arg4] = 0;
            this.mEdgeDragsLocked[arg4] = 0;
            this.mPointersDown &= 1 << arg4 ^ -1;
        }
    }

    private int computeAxisDuration(int arg5, int arg6, int arg7) {
        int v0;
        float v3 = 1f;
        if(arg5 == 0) {
            v0 = 0;
        }
        else {
            v0 = this.mParentView.getWidth();
            int v1 = v0 / 2;
            float v0_1 = this.distanceInfluenceForSnapDuration(Math.min(v3, (((float)Math.abs(arg5))) / (((float)v0)))) * (((float)v1)) + (((float)v1));
            v1 = Math.abs(arg6);
            v0 = v1 > 0 ? Math.round(Math.abs(v0_1 / (((float)v1))) * 1000f) * 4 : ((int)(((((float)Math.abs(arg5))) / (((float)arg7)) + v3) * 256f));
            v0 = Math.min(v0, 600);
        }

        return v0;
    }

    private int computeSettleDuration(View arg9, int arg10, int arg11, int arg12, int arg13) {
        int v2 = this.clampMag(arg12, ((int)this.mMinVelocity), ((int)this.mMaxVelocity));
        int v3 = this.clampMag(arg13, ((int)this.mMinVelocity), ((int)this.mMaxVelocity));
        int v0 = Math.abs(arg10);
        int v4 = Math.abs(arg11);
        int v1 = Math.abs(v2);
        int v5 = Math.abs(v3);
        int v6 = v1 + v5;
        int v7 = v0 + v4;
        float v1_1 = v2 != 0 ? (((float)v1)) / (((float)v6)) : (((float)v0)) / (((float)v7));
        float v0_1 = v3 != 0 ? (((float)v5)) / (((float)v6)) : (((float)v4)) / (((float)v7));
        return ((int)(v0_1 * (((float)this.computeAxisDuration(arg11, v3, this.mCallback.getViewVerticalDragRange(arg9)))) + v1_1 * (((float)this.computeAxisDuration(arg10, v2, this.mCallback.getViewHorizontalDragRange(arg9))))));
    }

    public boolean continueSettling(boolean arg10) {
        boolean v0;
        int v8 = 2;
        if(this.mDragState == v8) {
            boolean v7 = this.mScroller.computeScrollOffset();
            int v2 = this.mScroller.getCurrX();
            int v3 = this.mScroller.getCurrY();
            int v4 = v2 - this.mCapturedView.getLeft();
            int v5 = v3 - this.mCapturedView.getTop();
            if(v4 != 0) {
                ViewCompat.offsetLeftAndRight(this.mCapturedView, v4);
            }

            if(v5 != 0) {
                ViewCompat.offsetTopAndBottom(this.mCapturedView, v5);
            }

            if(v4 != 0 || v5 != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, v2, v3, v4, v5);
            }

            if(!v7 || v2 != this.mScroller.getFinalX() || v3 != this.mScroller.getFinalY()) {
                v0 = v7;
            }
            else {
                this.mScroller.abortAnimation();
                v0 = false;
            }

            if(v0) {
                goto label_42;
            }

            if(arg10) {
                this.mParentView.post(this.mSetIdleRunnable);
                goto label_42;
            }

            this.setDragState(0);
        }

    label_42:
        return this.mDragState == v8 ? true : false;
    }

    public static ViewDragHelper create(ViewGroup arg3, float arg4, Callback arg5) {
        ViewDragHelper v0 = ViewDragHelper.create(arg3, arg5);
        v0.mTouchSlop = ((int)((((float)v0.mTouchSlop)) * (1f / arg4)));
        return v0;
    }

    public static ViewDragHelper create(ViewGroup arg2, Callback arg3) {
        return new ViewDragHelper(arg2.getContext(), arg2, arg3);
    }

    private void dispatchViewReleased(float arg5, float arg6) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, arg5, arg6);
        this.mReleaseInProgress = false;
        if(this.mDragState == 1) {
            this.setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float arg5) {
        return ((float)Math.sin(((double)(((float)((((double)(arg5 - 0.5f))) * 0.471239))))));
    }

    private void dragTo(int arg7, int arg8, int arg9, int arg10) {
        int v3;
        int v2;
        int v0 = this.mCapturedView.getLeft();
        int v1 = this.mCapturedView.getTop();
        if(arg9 != 0) {
            v2 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, arg7, arg9);
            ViewCompat.offsetLeftAndRight(this.mCapturedView, v2 - v0);
        }
        else {
            v2 = arg7;
        }

        if(arg10 != 0) {
            v3 = this.mCallback.clampViewPositionVertical(this.mCapturedView, arg8, arg10);
            ViewCompat.offsetTopAndBottom(this.mCapturedView, v3 - v1);
        }
        else {
            v3 = arg8;
        }

        if(arg9 != 0 || arg10 != 0) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, v2, v3, v2 - v0, v3 - v1);
        }
    }

    private void ensureMotionHistorySizeForId(int arg11) {
        if(this.mInitialMotionX == null || this.mInitialMotionX.length <= arg11) {
            float[] v0 = new float[arg11 + 1];
            float[] v1 = new float[arg11 + 1];
            float[] v2 = new float[arg11 + 1];
            float[] v3 = new float[arg11 + 1];
            int[] v4 = new int[arg11 + 1];
            int[] v5 = new int[arg11 + 1];
            int[] v6 = new int[arg11 + 1];
            if(this.mInitialMotionX != null) {
                System.arraycopy(this.mInitialMotionX, 0, v0, 0, this.mInitialMotionX.length);
                System.arraycopy(this.mInitialMotionY, 0, v1, 0, this.mInitialMotionY.length);
                System.arraycopy(this.mLastMotionX, 0, v2, 0, this.mLastMotionX.length);
                System.arraycopy(this.mLastMotionY, 0, v3, 0, this.mLastMotionY.length);
                System.arraycopy(this.mInitialEdgesTouched, 0, v4, 0, this.mInitialEdgesTouched.length);
                System.arraycopy(this.mEdgeDragsInProgress, 0, v5, 0, this.mEdgeDragsInProgress.length);
                System.arraycopy(this.mEdgeDragsLocked, 0, v6, 0, this.mEdgeDragsLocked.length);
            }

            this.mInitialMotionX = v0;
            this.mInitialMotionY = v1;
            this.mLastMotionX = v2;
            this.mLastMotionY = v3;
            this.mInitialEdgesTouched = v4;
            this.mEdgeDragsInProgress = v5;
            this.mEdgeDragsLocked = v6;
        }
    }

    public View findTopChildUnder(int arg4, int arg5) {
        int v1;
        for(v1 = this.mParentView.getChildCount() - 1; v1 >= 0; --v1) {
            View v0 = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(v1));
            if(arg4 >= v0.getLeft() && arg4 < v0.getRight() && arg5 >= v0.getTop() && arg5 < v0.getBottom()) {
                return v0;
            }
        }

        return null;
    }

    public void flingCapturedView(int arg10, int arg11, int arg12, int arg13) {
        if(!this.mReleaseInProgress) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }

        this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), ((int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId)), ((int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId)), arg10, arg12, arg11, arg13);
        this.setDragState(2);
    }

    private boolean forceSettleCapturedViewAt(int arg11, int arg12, int arg13, int arg14) {
        boolean v0 = false;
        int v7 = this.mCapturedView.getLeft();
        int v6 = this.mCapturedView.getTop();
        int v2 = arg11 - v7;
        int v3 = arg12 - v6;
        if(v2 != 0 || v3 != 0) {
            this.mScroller.startScroll(v7, v6, v2, v3, this.computeSettleDuration(this.mCapturedView, v2, v3, arg13, arg14));
            this.setDragState(2);
            v0 = true;
        }
        else {
            this.mScroller.abortAnimation();
            this.setDragState(0);
        }

        return v0;
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    public View getCapturedView() {
        return this.mCapturedView;
    }

    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    private int getEdgesTouched(int arg4, int arg5) {
        int v0 = 0;
        if(arg4 < this.mParentView.getLeft() + this.mEdgeSize) {
            v0 = 1;
        }

        if(arg5 < this.mParentView.getTop() + this.mEdgeSize) {
            v0 |= 4;
        }

        if(arg4 > this.mParentView.getRight() - this.mEdgeSize) {
            v0 |= 2;
        }

        if(arg5 > this.mParentView.getBottom() - this.mEdgeSize) {
            v0 |= 8;
        }

        return v0;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int arg2, int arg3) {
        return this.isViewUnder(this.mCapturedView, arg2, arg3);
    }

    public boolean isEdgeTouched(int arg5) {
        boolean v0 = false;
        int v2 = this.mInitialEdgesTouched.length;
        int v1 = 0;
        while(v1 < v2) {
            if(this.isEdgeTouched(arg5, v1)) {
                v0 = true;
            }
            else {
                ++v1;
                continue;
            }

            return v0;
        }

        return v0;
    }

    public boolean isEdgeTouched(int arg2, int arg3) {
        boolean v0 = !this.isPointerDown(arg3) || (this.mInitialEdgesTouched[arg3] & arg2) == 0 ? false : true;
        return v0;
    }

    public boolean isPointerDown(int arg4) {
        boolean v0 = true;
        if((this.mPointersDown & 1 << arg4) == 0) {
            v0 = false;
        }

        return v0;
    }

    private boolean isValidPointerForActionMove(int arg4) {
        boolean v0;
        if(!this.isPointerDown(arg4)) {
            Log.e("ViewDragHelper", "Ignoring pointerId=" + arg4 + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
            v0 = false;
        }
        else {
            v0 = true;
        }

        return v0;
    }

    public boolean isViewUnder(View arg3, int arg4, int arg5) {
        boolean v0 = false;
        if(arg3 != null && arg4 >= arg3.getLeft() && arg4 < arg3.getRight() && arg5 >= arg3.getTop() && arg5 < arg3.getBottom()) {
            v0 = true;
        }

        return v0;
    }

    public void processTouchEvent(MotionEvent arg10) {
        View v3_2;
        float v2_1;
        float v1_1;
        int v1 = -1;
        int v0 = 0;
        int v2 = MotionEventCompat.getActionMasked(arg10);
        int v3 = MotionEventCompat.getActionIndex(arg10);
        if(v2 == 0) {
            this.cancel();
        }

        if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }

        this.mVelocityTracker.addMovement(arg10);
        switch(v2) {
            case 0: {
                v1_1 = arg10.getX();
                v2_1 = arg10.getY();
                v0 = arg10.getPointerId(0);
                v3_2 = this.findTopChildUnder(((int)v1_1), ((int)v2_1));
                this.saveInitialMotion(v1_1, v2_1, v0);
                this.tryCaptureViewForDrag(v3_2, v0);
                v1 = this.mInitialEdgesTouched[v0];
                if((this.mTrackingEdges & v1) == 0) {
                    return;
                }

                this.mCallback.onEdgeTouched(v1 & this.mTrackingEdges, v0);
                break;
            }
            case 1: {
                if(this.mDragState == 1) {
                    this.releaseViewForPointerUp();
                }

                this.cancel();
                break;
            }
            case 2: {
                if(this.mDragState == 1) {
                    if(!this.isValidPointerForActionMove(this.mActivePointerId)) {
                        return;
                    }

                    v0 = arg10.findPointerIndex(this.mActivePointerId);
                    v1_1 = arg10.getX(v0);
                    float v0_1 = arg10.getY(v0);
                    v1 = ((int)(v1_1 - this.mLastMotionX[this.mActivePointerId]));
                    v0 = ((int)(v0_1 - this.mLastMotionY[this.mActivePointerId]));
                    this.dragTo(this.mCapturedView.getLeft() + v1, this.mCapturedView.getTop() + v0, v1, v0);
                    this.saveLastMotion(arg10);
                    return;
                }

                v1 = arg10.getPointerCount();
                while(v0 < v1) {
                    v2 = arg10.getPointerId(v0);
                    if(this.isValidPointerForActionMove(v2)) {
                        float v3_1 = arg10.getX(v0);
                        float v4_1 = arg10.getY(v0);
                        float v5 = v3_1 - this.mInitialMotionX[v2];
                        float v6 = v4_1 - this.mInitialMotionY[v2];
                        this.reportNewEdgeDrags(v5, v6, v2);
                        if(this.mDragState != 1) {
                            v3_2 = this.findTopChildUnder(((int)v3_1), ((int)v4_1));
                            if((this.checkTouchSlop(v3_2, v5, v6)) && (this.tryCaptureViewForDrag(v3_2, v2))) {
                                break;
                            }
                        }
                        else {
                            break;
                        }
                    }

                    ++v0;
                }

                this.saveLastMotion(arg10);
                break;
            }
            case 3: {
                if(this.mDragState == 1) {
                    this.dispatchViewReleased(0f, 0f);
                }

                this.cancel();
                break;
            }
            case 5: {
                v0 = arg10.getPointerId(v3);
                v1_1 = arg10.getX(v3);
                v2_1 = arg10.getY(v3);
                this.saveInitialMotion(v1_1, v2_1, v0);
                if(this.mDragState == 0) {
                    this.tryCaptureViewForDrag(this.findTopChildUnder(((int)v1_1), ((int)v2_1)), v0);
                    v1 = this.mInitialEdgesTouched[v0];
                    if((this.mTrackingEdges & v1) == 0) {
                        return;
                    }

                    this.mCallback.onEdgeTouched(v1 & this.mTrackingEdges, v0);
                    return;
                }

                if(!this.isCapturedViewUnder(((int)v1_1), ((int)v2_1))) {
                    return;
                }

                this.tryCaptureViewForDrag(this.mCapturedView, v0);
                break;
            }
            case 6: {
                v2 = arg10.getPointerId(v3);
                if(this.mDragState == 1 && v2 == this.mActivePointerId) {
                    v3 = arg10.getPointerCount();
                    while(v0 < v3) {
                        int v4 = arg10.getPointerId(v0);
                        if(v4 != this.mActivePointerId && this.findTopChildUnder(((int)arg10.getX(v0)), ((int)arg10.getY(v0))) == this.mCapturedView && (this.tryCaptureViewForDrag(this.mCapturedView, v4))) {
                            v0 = this.mActivePointerId;
                            goto label_140;
                        }

                        ++v0;
                    }

                    v0 = v1;
                label_140:
                    if(v0 != v1) {
                        goto label_142;
                    }

                    this.releaseViewForPointerUp();
                }

            label_142:
                this.clearMotionHistory(v2);
                break;
            }
        }
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        this.dispatchViewReleased(this.clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), this.clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    private void reportNewEdgeDrags(float arg4, float arg5, int arg6) {
        int v0 = 1;
        if(!this.checkNewEdgeDrag(arg4, arg5, arg6, 1)) {
            v0 = 0;
        }

        if(this.checkNewEdgeDrag(arg5, arg4, arg6, 4)) {
            v0 |= 4;
        }

        if(this.checkNewEdgeDrag(arg4, arg5, arg6, 2)) {
            v0 |= 2;
        }

        if(this.checkNewEdgeDrag(arg5, arg4, arg6, 8)) {
            v0 |= 8;
        }

        if(v0 != 0) {
            this.mEdgeDragsInProgress[arg6] |= v0;
            this.mCallback.onEdgeDragStarted(v0, arg6);
        }
    }

    private void saveInitialMotion(float arg4, float arg5, int arg6) {
        this.ensureMotionHistorySizeForId(arg6);
        float[] v0 = this.mInitialMotionX;
        this.mLastMotionX[arg6] = arg4;
        v0[arg6] = arg4;
        v0 = this.mInitialMotionY;
        this.mLastMotionY[arg6] = arg5;
        v0[arg6] = arg5;
        this.mInitialEdgesTouched[arg6] = this.getEdgesTouched(((int)arg4), ((int)arg5));
        this.mPointersDown |= 1 << arg6;
    }

    private void saveLastMotion(MotionEvent arg7) {
        int v1 = arg7.getPointerCount();
        int v0;
        for(v0 = 0; v0 < v1; ++v0) {
            int v2 = arg7.getPointerId(v0);
            if(this.isValidPointerForActionMove(v2)) {
                float v3 = arg7.getX(v0);
                float v4 = arg7.getY(v0);
                this.mLastMotionX[v2] = v3;
                this.mLastMotionY[v2] = v4;
            }
        }
    }

    void setDragState(int arg3) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if(this.mDragState != arg3) {
            this.mDragState = arg3;
            this.mCallback.onViewDragStateChanged(arg3);
            if(this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeTrackingEnabled(int arg1) {
        this.mTrackingEdges = arg1;
    }

    public void setMinVelocity(float arg1) {
        this.mMinVelocity = arg1;
    }

    public boolean settleCapturedViewAt(int arg4, int arg5) {
        if(!this.mReleaseInProgress) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }

        return this.forceSettleCapturedViewAt(arg4, arg5, ((int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId)), ((int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId)));
    }

    public boolean shouldInterceptTouchEvent(MotionEvent arg14) {
        float v1_1;
        float v0_1;
        int v2;
        int v0 = MotionEventCompat.getActionMasked(arg14);
        int v1 = MotionEventCompat.getActionIndex(arg14);
        if(v0 == 0) {
            this.cancel();
        }

        if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }

        this.mVelocityTracker.addMovement(arg14);
        switch(v0) {
            case 0: {
                v0_1 = arg14.getX();
                v1_1 = arg14.getY();
                v2 = arg14.getPointerId(0);
                this.saveInitialMotion(v0_1, v1_1, v2);
                View v0_2 = this.findTopChildUnder(((int)v0_1), ((int)v1_1));
                if(v0_2 == this.mCapturedView && this.mDragState == 2) {
                    this.tryCaptureViewForDrag(v0_2, v2);
                }

                v0 = this.mInitialEdgesTouched[v2];
                if((this.mTrackingEdges & v0) == 0) {
                    goto label_11;
                }

                this.mCallback.onEdgeTouched(v0 & this.mTrackingEdges, v2);
                break;
            }
            case 2: {
                if(this.mInitialMotionX == null) {
                    goto label_11;
                }

                if(this.mInitialMotionY == null) {
                    goto label_11;
                }

                v2 = arg14.getPointerCount();
                for(v1 = 0; v1 < v2; ++v1) {
                    int v3 = arg14.getPointerId(v1);
                    if(this.isValidPointerForActionMove(v3)) {
                        v0_1 = arg14.getX(v1);
                        float v4 = arg14.getY(v1);
                        float v5 = v0_1 - this.mInitialMotionX[v3];
                        float v6 = v4 - this.mInitialMotionY[v3];
                        View v4_1 = this.findTopChildUnder(((int)v0_1), ((int)v4));
                        v0 = v4_1 == null || !this.checkTouchSlop(v4_1, v5, v6) ? 0 : 1;
                        if(v0 != 0) {
                            int v7 = v4_1.getLeft();
                            int v8 = this.mCallback.clampViewPositionHorizontal(v4_1, (((int)v5)) + v7, ((int)v5));
                            int v9 = v4_1.getTop();
                            int v10 = this.mCallback.clampViewPositionVertical(v4_1, (((int)v6)) + v9, ((int)v6));
                            int v11 = this.mCallback.getViewHorizontalDragRange(v4_1);
                            int v12 = this.mCallback.getViewVerticalDragRange(v4_1);
                            if(v11 != 0) {
                                if(v11 <= 0) {
                                }
                                else if(v8 == v7) {
                                    goto label_115;
                                }

                                goto label_122;
                            }

                        label_115:
                            if(v12 == 0) {
                                break;
                            }

                            if(v12 <= 0) {
                                goto label_122;
                            }

                            if(v10 != v9) {
                                goto label_122;
                            }

                            break;
                        }

                    label_122:
                        this.reportNewEdgeDrags(v5, v6, v3);
                        if(this.mDragState == 1) {
                            break;
                        }

                        if(v0 == 0) {
                            goto label_77;
                        }

                        if(!this.tryCaptureViewForDrag(v4_1, v3)) {
                            goto label_77;
                        }

                        break;
                    }

                label_77:
                }

                this.saveLastMotion(arg14);
                break;
            }
            case 1: 
            case 3: {
                this.cancel();
                break;
            }
            case 5: {
                v0 = arg14.getPointerId(v1);
                float v2_1 = arg14.getX(v1);
                v1_1 = arg14.getY(v1);
                this.saveInitialMotion(v2_1, v1_1, v0);
                if(this.mDragState == 0) {
                    v1 = this.mInitialEdgesTouched[v0];
                    if((this.mTrackingEdges & v1) == 0) {
                        goto label_11;
                    }

                    this.mCallback.onEdgeTouched(v1 & this.mTrackingEdges, v0);
                    goto label_11;
                }

                if(this.mDragState != 2) {
                    goto label_11;
                }

                View v1_2 = this.findTopChildUnder(((int)v2_1), ((int)v1_1));
                if(v1_2 != this.mCapturedView) {
                    goto label_11;
                }

                this.tryCaptureViewForDrag(v1_2, v0);
                break;
            }
            case 6: {
                this.clearMotionHistory(arg14.getPointerId(v1));
                break;
            }
        }

    label_11:
        boolean v0_3 = this.mDragState == 1 ? true : false;
        return v0_3;
    }

    public boolean smoothSlideViewTo(View arg3, int arg4, int arg5) {
        this.mCapturedView = arg3;
        this.mActivePointerId = -1;
        boolean v0 = this.forceSettleCapturedViewAt(arg4, arg5, 0, 0);
        if(!v0 && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }

        return v0;
    }

    boolean tryCaptureViewForDrag(View arg3, int arg4) {
        boolean v0 = true;
        if(arg3 != this.mCapturedView || this.mActivePointerId != arg4) {
            if(arg3 != null && (this.mCallback.tryCaptureView(arg3, arg4))) {
                this.mActivePointerId = arg4;
                this.captureChildView(arg3, arg4);
                return v0;
            }

            v0 = false;
        }

        return v0;
    }
}

