package android.support.v4.view;

import android.content.Context;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector$OnDoubleTapListener;
import android.view.GestureDetector$OnGestureListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class GestureDetectorCompat {
    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent arg1);

        void setIsLongpressEnabled(boolean arg1);

        void setOnDoubleTapListener(GestureDetector$OnDoubleTapListener arg1);
    }

    class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        class GestureHandler extends Handler {
            GestureHandler(GestureDetectorCompatImplBase arg2, Handler arg3) {
                GestureDetectorCompatImplBase.this = arg2;
                super(arg3.getLooper());
            }

            GestureHandler(GestureDetectorCompatImplBase arg1) {
                GestureDetectorCompatImplBase.this = arg1;
                super();
            }

            public void handleMessage(Message arg4) {
                switch(arg4.what) {
                    case 1: {
                        GestureDetectorCompatImplBase.this.mListener.onShowPress(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                        break;
                    }
                    case 2: {
                        GestureDetectorCompatImplBase.this.dispatchLongPress();
                        break;
                    }
                    case 3: {
                        if(GestureDetectorCompatImplBase.this.mDoubleTapListener == null) {
                            return;
                        }

                        if(!GestureDetectorCompatImplBase.this.mStillDown) {
                            GestureDetectorCompatImplBase.this.mDoubleTapListener.onSingleTapConfirmed(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                            return;
                        }

                        GestureDetectorCompatImplBase.this.mDeferConfirmSingleTap = true;
                        break;
                    }
                    default: {
                        throw new RuntimeException("Unknown message " + arg4);
                    }
                }
            }
        }

        private static final int DOUBLE_TAP_TIMEOUT = 0;
        private static final int LONGPRESS_TIMEOUT = 0;
        private static final int LONG_PRESS = 2;
        private static final int SHOW_PRESS = 1;
        private static final int TAP = 3;
        private static final int TAP_TIMEOUT;
        private boolean mAlwaysInBiggerTapRegion;
        private boolean mAlwaysInTapRegion;
        MotionEvent mCurrentDownEvent;
        boolean mDeferConfirmSingleTap;
        GestureDetector$OnDoubleTapListener mDoubleTapListener;
        private int mDoubleTapSlopSquare;
        private float mDownFocusX;
        private float mDownFocusY;
        private final Handler mHandler;
        private boolean mInLongPress;
        private boolean mIsDoubleTapping;
        private boolean mIsLongpressEnabled;
        private float mLastFocusX;
        private float mLastFocusY;
        final GestureDetector$OnGestureListener mListener;
        private int mMaximumFlingVelocity;
        private int mMinimumFlingVelocity;
        private MotionEvent mPreviousUpEvent;
        boolean mStillDown;
        private int mTouchSlopSquare;
        private VelocityTracker mVelocityTracker;

        static {
            GestureDetectorCompatImplBase.LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
            GestureDetectorCompatImplBase.TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
            GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        }

        public GestureDetectorCompatImplBase(Context arg2, GestureDetector$OnGestureListener arg3, Handler arg4) {
            super();
            this.mHandler = arg4 != null ? new GestureHandler(this, arg4) : new GestureHandler(this);
            this.mListener = arg3;
            if((arg3 instanceof GestureDetector$OnDoubleTapListener)) {
                this.setOnDoubleTapListener(((GestureDetector$OnDoubleTapListener)arg3));
            }

            this.init(arg2);
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if(this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void cancelTaps() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if(this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        void dispatchLongPress() {
            this.mHandler.removeMessages(3);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }

        private void init(Context arg5) {
            if(arg5 == null) {
                throw new IllegalArgumentException("Context must not be null");
            }

            if(this.mListener == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }

            this.mIsLongpressEnabled = true;
            ViewConfiguration v0 = ViewConfiguration.get(arg5);
            int v1 = v0.getScaledTouchSlop();
            int v2 = v0.getScaledDoubleTapSlop();
            this.mMinimumFlingVelocity = v0.getScaledMinimumFlingVelocity();
            this.mMaximumFlingVelocity = v0.getScaledMaximumFlingVelocity();
            this.mTouchSlopSquare = v1 * v1;
            this.mDoubleTapSlopSquare = v2 * v2;
        }

        private boolean isConsideredDoubleTap(MotionEvent arg7, MotionEvent arg8, MotionEvent arg9) {
            boolean v0 = false;
            if((this.mAlwaysInBiggerTapRegion) && arg9.getEventTime() - arg8.getEventTime() <= (((long)GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT))) {
                int v1 = (((int)arg7.getX())) - (((int)arg9.getX()));
                int v2 = (((int)arg7.getY())) - (((int)arg9.getY()));
                if(v1 * v1 + v2 * v2 < this.mDoubleTapSlopSquare) {
                    v0 = true;
                }
            }

            return v0;
        }

        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        public boolean onTouchEvent(MotionEvent arg14) {
            float v4_1;
            float v0_2;
            int v3_1;
            boolean v0_1;
            int v12 = 2;
            int v11 = 3;
            boolean v3 = false;
            int v9 = arg14.getAction();
            if(this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }

            this.mVelocityTracker.addMovement(arg14);
            int v7 = (v9 & 0xFF) == 6 ? 1 : 0;
            int v0 = v7 != 0 ? MotionEventCompat.getActionIndex(arg14) : -1;
            int v4 = arg14.getPointerCount();
            int v5 = 0;
            float v1 = 0f;
            float v2 = 0f;
            while(v5 < v4) {
                if(v0 != v5) {
                    v2 += arg14.getX(v5);
                    v1 += arg14.getY(v5);
                }

                ++v5;
            }

            v0 = v7 != 0 ? v4 - 1 : v4;
            v2 /= ((float)v0);
            v1 /= ((float)v0);
            switch(v9 & 0xFF) {
                case 0: {
                    if(this.mDoubleTapListener != null) {
                        v0_1 = this.mHandler.hasMessages(v11);
                        if(v0_1) {
                            this.mHandler.removeMessages(v11);
                        }

                        if(this.mCurrentDownEvent != null && this.mPreviousUpEvent != null && (v0_1) && (this.isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, arg14))) {
                            this.mIsDoubleTapping = true;
                            v0 = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | 0 | this.mDoubleTapListener.onDoubleTapEvent(arg14);
                            goto label_108;
                        }

                        this.mHandler.sendEmptyMessageDelayed(v11, ((long)GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT));
                        goto label_152;
                    }
                    else {
                    label_152:
                        v0 = 0;
                    }

                label_108:
                    this.mLastFocusX = v2;
                    this.mDownFocusX = v2;
                    this.mLastFocusY = v1;
                    this.mDownFocusY = v1;
                    if(this.mCurrentDownEvent != null) {
                        this.mCurrentDownEvent.recycle();
                    }

                    this.mCurrentDownEvent = MotionEvent.obtain(arg14);
                    this.mAlwaysInTapRegion = true;
                    this.mAlwaysInBiggerTapRegion = true;
                    this.mStillDown = true;
                    this.mInLongPress = false;
                    this.mDeferConfirmSingleTap = false;
                    if(this.mIsLongpressEnabled) {
                        this.mHandler.removeMessages(v12);
                        this.mHandler.sendEmptyMessageAtTime(v12, this.mCurrentDownEvent.getDownTime() + (((long)GestureDetectorCompatImplBase.TAP_TIMEOUT)) + (((long)GestureDetectorCompatImplBase.LONGPRESS_TIMEOUT)));
                    }

                    this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + (((long)GestureDetectorCompatImplBase.TAP_TIMEOUT)));
                    v3_1 = v0 | this.mListener.onDown(arg14);
                    break;
                }
                case 1: {
                    this.mStillDown = false;
                    MotionEvent v1_2 = MotionEvent.obtain(arg14);
                    if(this.mIsDoubleTapping) {
                        v0 = this.mDoubleTapListener.onDoubleTapEvent(arg14) | 0;
                    }
                    else if(this.mInLongPress) {
                        this.mHandler.removeMessages(v11);
                        this.mInLongPress = false;
                        v0 = 0;
                    }
                    else if(this.mAlwaysInTapRegion) {
                        v0_1 = this.mListener.onSingleTapUp(arg14);
                        if((this.mDeferConfirmSingleTap) && this.mDoubleTapListener != null) {
                            this.mDoubleTapListener.onSingleTapConfirmed(arg14);
                        }
                    }
                    else {
                        VelocityTracker v0_3 = this.mVelocityTracker;
                        int v2_1 = arg14.getPointerId(0);
                        v0_3.computeCurrentVelocity(1000, ((float)this.mMaximumFlingVelocity));
                        v4_1 = VelocityTrackerCompat.getYVelocity(v0_3, v2_1);
                        v0_2 = VelocityTrackerCompat.getXVelocity(v0_3, v2_1);
                        if(Math.abs(v4_1) <= (((float)this.mMinimumFlingVelocity)) && Math.abs(v0_2) <= (((float)this.mMinimumFlingVelocity))) {
                            v0 = 0;
                            goto label_215;
                        }

                        v0_1 = this.mListener.onFling(this.mCurrentDownEvent, arg14, v0_2, v4_1);
                    }

                label_215:
                    if(this.mPreviousUpEvent != null) {
                        this.mPreviousUpEvent.recycle();
                    }

                    this.mPreviousUpEvent = v1_2;
                    if(this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }

                    this.mIsDoubleTapping = false;
                    this.mDeferConfirmSingleTap = false;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(v12);
                    v3_1 = ((int)v0_1);
                    break;
                }
                case 2: {
                    if(this.mInLongPress) {
                        goto label_43;
                    }

                    v0_2 = this.mLastFocusX - v2;
                    v4_1 = this.mLastFocusY - v1;
                    if(this.mIsDoubleTapping) {
                        v3_1 = 0 | this.mDoubleTapListener.onDoubleTapEvent(arg14);
                        goto label_43;
                    }

                    if(this.mAlwaysInTapRegion) {
                        v5 = ((int)(v2 - this.mDownFocusX));
                        int v6 = ((int)(v1 - this.mDownFocusY));
                        v5 = v5 * v5 + v6 * v6;
                        if(v5 > this.mTouchSlopSquare) {
                            v0_1 = this.mListener.onScroll(this.mCurrentDownEvent, arg14, v0_2, v4_1);
                            this.mLastFocusX = v2;
                            this.mLastFocusY = v1;
                            this.mAlwaysInTapRegion = false;
                            this.mHandler.removeMessages(v11);
                            this.mHandler.removeMessages(1);
                            this.mHandler.removeMessages(v12);
                        }
                        else {
                            v0_1 = false;
                        }

                        if(v5 > this.mTouchSlopSquare) {
                            this.mAlwaysInBiggerTapRegion = false;
                        }

                        v3 = v0_1;
                        goto label_43;
                    }

                    if(Math.abs(v0_2) < 1f && Math.abs(v4_1) < 1f) {
                        goto label_43;
                    }

                    v3 = this.mListener.onScroll(this.mCurrentDownEvent, arg14, v0_2, v4_1);
                    this.mLastFocusX = v2;
                    this.mLastFocusY = v1;
                    break;
                }
                case 3: {
                    this.cancel();
                    goto label_43;
                label_68:
                    while(v0 < v4) {
                        if(v0 != v1_1) {
                            v7 = arg14.getPointerId(v0);
                            if(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, v7) * v5_1 + VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, v7) * v2 < 0f) {
                                this.mVelocityTracker.clear();
                                break;
                            }
                        }

                        ++v0;
                    }
                }
                case 5: {
                    this.mLastFocusX = v2;
                    this.mDownFocusX = v2;
                    this.mLastFocusY = v1;
                    this.mDownFocusY = v1;
                    this.cancelTaps();
                    break;
                }
                case 6: {
                    this.mLastFocusX = v2;
                    this.mDownFocusX = v2;
                    this.mLastFocusY = v1;
                    this.mDownFocusY = v1;
                    this.mVelocityTracker.computeCurrentVelocity(1000, ((float)this.mMaximumFlingVelocity));
                    int v1_1 = MotionEventCompat.getActionIndex(arg14);
                    v0 = arg14.getPointerId(v1_1);
                    v2 = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, v0);
                    float v5_1 = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, v0);
                    v0 = 0;
                    goto label_68;
                }
            }

        label_43:
            return ((boolean)v3_1);
        }

        public void setIsLongpressEnabled(boolean arg1) {
            this.mIsLongpressEnabled = arg1;
        }

        public void setOnDoubleTapListener(GestureDetector$OnDoubleTapListener arg1) {
            this.mDoubleTapListener = arg1;
        }
    }

    class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector mDetector;

        public GestureDetectorCompatImplJellybeanMr2(Context arg2, GestureDetector$OnGestureListener arg3, Handler arg4) {
            super();
            this.mDetector = new GestureDetector(arg2, arg3, arg4);
        }

        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        public boolean onTouchEvent(MotionEvent arg2) {
            return this.mDetector.onTouchEvent(arg2);
        }

        public void setIsLongpressEnabled(boolean arg2) {
            this.mDetector.setIsLongpressEnabled(arg2);
        }

        public void setOnDoubleTapListener(GestureDetector$OnDoubleTapListener arg2) {
            this.mDetector.setOnDoubleTapListener(arg2);
        }
    }

    private final GestureDetectorCompatImpl mImpl;

    public GestureDetectorCompat(Context arg2, GestureDetector$OnGestureListener arg3) {
        this(arg2, arg3, null);
    }

    public GestureDetectorCompat(Context arg3, GestureDetector$OnGestureListener arg4, Handler arg5) {
        super();
        this.mImpl = Build$VERSION.SDK_INT > 17 ? new GestureDetectorCompatImplJellybeanMr2(arg3, arg4, arg5) : new GestureDetectorCompatImplBase(arg3, arg4, arg5);
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent arg2) {
        return this.mImpl.onTouchEvent(arg2);
    }

    public void setIsLongpressEnabled(boolean arg2) {
        this.mImpl.setIsLongpressEnabled(arg2);
    }

    public void setOnDoubleTapListener(GestureDetector$OnDoubleTapListener arg2) {
        this.mImpl.setOnDoubleTapListener(arg2);
    }
}

