package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.widget.EdgeEffect;

@TargetApi(value=21) @RequiresApi(value=21) class EdgeEffectCompatLollipop {
    EdgeEffectCompatLollipop() {
        super();
    }

    public static boolean onPull(Object arg1, float arg2, float arg3) {
        ((EdgeEffect)arg1).onPull(arg2, arg3);
        return 1;
    }
}

