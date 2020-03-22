package android.support.v4.animation;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

@TargetApi(value=9) @RequiresApi(value=9) class GingerbreadAnimatorCompatProvider implements AnimatorProvider {
    class GingerbreadFloatValueAnimator implements ValueAnimatorCompat {
        class android.support.v4.animation.GingerbreadAnimatorCompatProvider$GingerbreadFloatValueAnimator$1 implements Runnable {
            android.support.v4.animation.GingerbreadAnimatorCompatProvider$GingerbreadFloatValueAnimator$1(GingerbreadFloatValueAnimator arg1) {
                GingerbreadFloatValueAnimator.this = arg1;
                super();
            }

            public void run() {
                float v1 = 1f;
                float v0 = (((float)(GingerbreadFloatValueAnimator.this.getTime() - GingerbreadFloatValueAnimator.this.mStartTime))) * v1 / (((float)GingerbreadFloatValueAnimator.this.mDuration));
                if(v0 > v1 || GingerbreadFloatValueAnimator.this.mTarget.getParent() == null) {
                    v0 = v1;
                }

                GingerbreadFloatValueAnimator.this.mFraction = v0;
                GingerbreadFloatValueAnimator.this.notifyUpdateListeners();
                if(GingerbreadFloatValueAnimator.this.mFraction >= v1) {
                    GingerbreadFloatValueAnimator.this.dispatchEnd();
                }
                else {
                    GingerbreadFloatValueAnimator.this.mTarget.postDelayed(GingerbreadFloatValueAnimator.this.mLoopRunnable, 16);
                }
            }
        }

        private long mDuration;
        private boolean mEnded;
        private float mFraction;
        List mListeners;
        private Runnable mLoopRunnable;
        private long mStartTime;
        private boolean mStarted;
        View mTarget;
        List mUpdateListeners;

        public GingerbreadFloatValueAnimator() {
            super();
            this.mListeners = new ArrayList();
            this.mUpdateListeners = new ArrayList();
            this.mDuration = 200;
            this.mFraction = 0f;
            this.mStarted = false;
            this.mEnded = false;
            this.mLoopRunnable = new android.support.v4.animation.GingerbreadAnimatorCompatProvider$GingerbreadFloatValueAnimator$1(this);
        }

        static long access$000(GingerbreadFloatValueAnimator arg2) {
            return arg2.getTime();
        }

        static long access$100(GingerbreadFloatValueAnimator arg2) {
            return arg2.mStartTime;
        }

        static long access$200(GingerbreadFloatValueAnimator arg2) {
            return arg2.mDuration;
        }

        static float access$300(GingerbreadFloatValueAnimator arg1) {
            return arg1.mFraction;
        }

        static float access$302(GingerbreadFloatValueAnimator arg0, float arg1) {
            arg0.mFraction = arg1;
            return arg1;
        }

        static void access$400(GingerbreadFloatValueAnimator arg0) {
            arg0.notifyUpdateListeners();
        }

        static void access$500(GingerbreadFloatValueAnimator arg0) {
            arg0.dispatchEnd();
        }

        static Runnable access$600(GingerbreadFloatValueAnimator arg1) {
            return arg1.mLoopRunnable;
        }

        public void addListener(AnimatorListenerCompat arg2) {
            this.mListeners.add(arg2);
        }

        public void addUpdateListener(AnimatorUpdateListenerCompat arg2) {
            this.mUpdateListeners.add(arg2);
        }

        public void cancel() {
            if(!this.mEnded) {
                this.mEnded = true;
                if(this.mStarted) {
                    this.dispatchCancel();
                }

                this.dispatchEnd();
            }
        }

        private void dispatchCancel() {
            int v1;
            for(v1 = this.mListeners.size() - 1; v1 >= 0; --v1) {
                this.mListeners.get(v1).onAnimationCancel(((ValueAnimatorCompat)this));
            }
        }

        private void dispatchEnd() {
            int v1;
            for(v1 = this.mListeners.size() - 1; v1 >= 0; --v1) {
                this.mListeners.get(v1).onAnimationEnd(((ValueAnimatorCompat)this));
            }
        }

        private void dispatchStart() {
            int v1;
            for(v1 = this.mListeners.size() - 1; v1 >= 0; --v1) {
                this.mListeners.get(v1).onAnimationStart(((ValueAnimatorCompat)this));
            }
        }

        public float getAnimatedFraction() {
            return this.mFraction;
        }

        private long getTime() {
            return this.mTarget.getDrawingTime();
        }

        private void notifyUpdateListeners() {
            int v1;
            for(v1 = this.mUpdateListeners.size() - 1; v1 >= 0; --v1) {
                this.mUpdateListeners.get(v1).onAnimationUpdate(((ValueAnimatorCompat)this));
            }
        }

        public void setDuration(long arg2) {
            if(!this.mStarted) {
                this.mDuration = arg2;
            }
        }

        public void setTarget(View arg1) {
            this.mTarget = arg1;
        }

        public void start() {
            if(!this.mStarted) {
                this.mStarted = true;
                this.dispatchStart();
                this.mFraction = 0f;
                this.mStartTime = this.getTime();
                this.mTarget.postDelayed(this.mLoopRunnable, 16);
            }
        }
    }

    GingerbreadAnimatorCompatProvider() {
        super();
    }

    public void clearInterpolator(View arg1) {
    }

    public ValueAnimatorCompat emptyValueAnimator() {
        return new GingerbreadFloatValueAnimator();
    }
}

