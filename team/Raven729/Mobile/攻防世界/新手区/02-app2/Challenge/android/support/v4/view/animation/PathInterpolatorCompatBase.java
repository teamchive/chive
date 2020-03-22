package android.support.v4.view.animation;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.support.annotation.RequiresApi;
import android.view.animation.Interpolator;

@TargetApi(value=9) @RequiresApi(value=9) class PathInterpolatorCompatBase {
    private PathInterpolatorCompatBase() {
        super();
    }

    public static Interpolator create(float arg1, float arg2) {
        return new PathInterpolatorGingerbread(arg1, arg2);
    }

    public static Interpolator create(float arg1, float arg2, float arg3, float arg4) {
        return new PathInterpolatorGingerbread(arg1, arg2, arg3, arg4);
    }

    public static Interpolator create(Path arg1) {
        return new PathInterpolatorGingerbread(arg1);
    }
}

