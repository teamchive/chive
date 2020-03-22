package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(value=16) @RequiresApi(value=16) class ViewPropertyAnimatorCompatJB {
    ViewPropertyAnimatorCompatJB() {
        super();
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

    public static void withEndAction(View arg1, Runnable arg2) {
        arg1.animate().withEndAction(arg2);
    }

    public static void withLayer(View arg1) {
        arg1.animate().withLayer();
    }

    public static void withStartAction(View arg1, Runnable arg2) {
        arg1.animate().withStartAction(arg2);
    }
}

