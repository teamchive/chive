package android.support.v4.view;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(value=19) @RequiresApi(value=19) class ViewPropertyAnimatorCompatKK {
    ViewPropertyAnimatorCompatKK() {
        super();
    }

    public static void setUpdateListener(View arg2, ViewPropertyAnimatorUpdateListener arg3) {
        android.support.v4.view.ViewPropertyAnimatorCompatKK$1 v0_1;
        ValueAnimator$AnimatorUpdateListener v0 = null;
        if(arg3 != null) {
            v0_1 = new ValueAnimator$AnimatorUpdateListener(arg3, arg2) {
                public void onAnimationUpdate(ValueAnimator arg3) {
                    this.val$listener.onAnimationUpdate(this.val$view);
                }
            };
        }

        arg2.animate().setUpdateListener(((ValueAnimator$AnimatorUpdateListener)v0_1));
    }
}

