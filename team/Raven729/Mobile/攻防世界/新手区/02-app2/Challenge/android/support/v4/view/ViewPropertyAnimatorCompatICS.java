package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.animation.Interpolator;

@TargetApi(value=14) @RequiresApi(value=14) class ViewPropertyAnimatorCompatICS {
    ViewPropertyAnimatorCompatICS() {
        super();
    }

    public static void alpha(View arg1, float arg2) {
        arg1.animate().alpha(arg2);
    }

    public static void alphaBy(View arg1, float arg2) {
        arg1.animate().alphaBy(arg2);
    }

    public static void cancel(View arg1) {
        arg1.animate().cancel();
    }

    public static long getDuration(View arg2) {
        return arg2.animate().getDuration();
    }

    public static long getStartDelay(View arg2) {
        return arg2.animate().getStartDelay();
    }

    public static void rotation(View arg1, float arg2) {
        arg1.animate().rotation(arg2);
    }

    public static void rotationBy(View arg1, float arg2) {
        arg1.animate().rotationBy(arg2);
    }

    public static void rotationX(View arg1, float arg2) {
        arg1.animate().rotationX(arg2);
    }

    public static void rotationXBy(View arg1, float arg2) {
        arg1.animate().rotationXBy(arg2);
    }

    public static void rotationY(View arg1, float arg2) {
        arg1.animate().rotationY(arg2);
    }

    public static void rotationYBy(View arg1, float arg2) {
        arg1.animate().rotationYBy(arg2);
    }

    public static void scaleX(View arg1, float arg2) {
        arg1.animate().scaleX(arg2);
    }

    public static void scaleXBy(View arg1, float arg2) {
        arg1.animate().scaleXBy(arg2);
    }

    public static void scaleY(View arg1, float arg2) {
        arg1.animate().scaleY(arg2);
    }

    public static void scaleYBy(View arg1, float arg2) {
        arg1.animate().scaleYBy(arg2);
    }

    public static void setDuration(View arg1, long arg2) {
        arg1.animate().setDuration(arg2);
    }

    public static void setInterpolator(View arg1, Interpolator arg2) {
        arg1.animate().setInterpolator(((TimeInterpolator)arg2));
    }

    public static void setListener(View arg2, ViewPropertyAnimatorListener arg3) {
        if(arg3 != null) {
            arg2.animate().setListener(new AnimatorListenerAdapter(arg3, arg2) {
                public void onAnimationCancel(Animator arg3) {
                    this.val$listener.onAnimationCancel(this.val$view);
                }

                public void onAnimationEnd(Animator arg3) {
                    this.val$listener.onAnimationEnd(this.val$view);
                }

                public void onAnimationStart(Animator arg3) {
                    this.val$listener.onAnimationStart(this.val$view);
                }
            });
        }
        else {
            arg2.animate().setListener(null);
        }
    }

    public static void setStartDelay(View arg1, long arg2) {
        arg1.animate().setStartDelay(arg2);
    }

    public static void start(View arg1) {
        arg1.animate().start();
    }

    public static void translationX(View arg1, float arg2) {
        arg1.animate().translationX(arg2);
    }

    public static void translationXBy(View arg1, float arg2) {
        arg1.animate().translationXBy(arg2);
    }

    public static void translationY(View arg1, float arg2) {
        arg1.animate().translationY(arg2);
    }

    public static void translationYBy(View arg1, float arg2) {
        arg1.animate().translationYBy(arg2);
    }

    public static void x(View arg1, float arg2) {
        arg1.animate().x(arg2);
    }

    public static void xBy(View arg1, float arg2) {
        arg1.animate().xBy(arg2);
    }

    public static void y(View arg1, float arg2) {
        arg1.animate().y(arg2);
    }

    public static void yBy(View arg1, float arg2) {
        arg1.animate().yBy(arg2);
    }
}

