package android.support.v4.view.animation;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.support.annotation.RequiresApi;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

@TargetApi(value=21) @RequiresApi(value=21) class PathInterpolatorCompatApi21 {
    private PathInterpolatorCompatApi21() {
        super();
    }

    public static Interpolator create(float arg1, float arg2) {
        return new PathInterpolator(arg1, arg2);
    }

    public static Interpolator create(float arg1, float arg2, float arg3, float arg4) {
        return new PathInterpolator(arg1, arg2, arg3, arg4);
    }

    public static Interpolator create(Path arg1) {
        return new PathInterpolator(arg1);
    }
}

