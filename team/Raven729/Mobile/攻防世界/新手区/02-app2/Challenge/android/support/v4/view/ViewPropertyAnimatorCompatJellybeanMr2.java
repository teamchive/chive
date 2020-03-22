package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.animation.Interpolator;

@TargetApi(value=18) @RequiresApi(value=18) class ViewPropertyAnimatorCompatJellybeanMr2 {
    ViewPropertyAnimatorCompatJellybeanMr2() {
        super();
    }

    public static Interpolator getInterpolator(View arg1) {
        return arg1.animate().getInterpolator();
    }
}

