package android.support.v4.animation;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(value=12) @RequiresApi(value=12) class HoneycombMr1AnimatorCompatProvider implements AnimatorProvider {
    class AnimatorListenerCompatWrapper implements Animator$AnimatorListener {
        final ValueAnimatorCompat mValueAnimatorCompat;
        final AnimatorListenerCompat mWrapped;

        public AnimatorListenerCompatWrapper(AnimatorListenerCompat arg1, ValueAnimatorCompat arg2) {
            super();
            this.mWrapped = arg1;
            this.mValueAnimatorCompat = arg2;
        }

        public void onAnimationCancel(Animator arg3) {
            this.mWrapped.onAnimationCancel(this.mValueAnimatorCompat);
        }

        public void onAnimationEnd(Animator arg3) {
            this.mWrapped.onAnimationEnd(this.mValueAnimatorCompat);
        }

        public void onAnimationRepeat(Animator arg3) {
            this.mWrapped.onAnimationRepeat(this.mValueAnimatorCompat);
        }

        public void onAnimationStart(Animator arg3) {
            this.mWrapped.onAnimationStart(this.mValueAnimatorCompat);
        }
    }

    class HoneycombValueAnimatorCompat implements ValueAnimatorCompat {
        final Animator mWrapped;

        public HoneycombValueAnimatorCompat(Animator arg1) {
            super();
            this.mWrapped = arg1;
        }

        public void addListener(AnimatorListenerCompat arg3) {
            this.mWrapped.addListener(new AnimatorListenerCompatWrapper(arg3, ((ValueAnimatorCompat)this)));
        }

        public void addUpdateListener(AnimatorUpdateListenerCompat arg3) {
            if((this.mWrapped instanceof ValueAnimator)) {
                this.mWrapped.addUpdateListener(new ValueAnimator$AnimatorUpdateListener(arg3) {
                    public void onAnimationUpdate(ValueAnimator arg3) {
                        this.val$animatorUpdateListener.onAnimationUpdate(HoneycombValueAnimatorCompat.this);
                    }
                });
            }
        }

        public void cancel() {
            this.mWrapped.cancel();
        }

        public float getAnimatedFraction() {
            return this.mWrapped.getAnimatedFraction();
        }

        public void setDuration(long arg2) {
            this.mWrapped.setDuration(arg2);
        }

        public void setTarget(View arg2) {
            this.mWrapped.setTarget(arg2);
        }

        public void start() {
            this.mWrapped.start();
        }
    }

    private TimeInterpolator mDefaultInterpolator;

    HoneycombMr1AnimatorCompatProvider() {
        super();
    }

    public void clearInterpolator(View arg3) {
        if(this.mDefaultInterpolator == null) {
            this.mDefaultInterpolator = new ValueAnimator().getInterpolator();
        }

        arg3.animate().setInterpolator(this.mDefaultInterpolator);
    }

    public ValueAnimatorCompat emptyValueAnimator() {
        return new HoneycombValueAnimatorCompat(ValueAnimator.ofFloat(new float[]{0f, 1f}));
    }
}

