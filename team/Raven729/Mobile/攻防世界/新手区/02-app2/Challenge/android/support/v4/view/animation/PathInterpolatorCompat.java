package android.support.v4.view.animation;

import android.graphics.Path;
import android.os.Build$VERSION;
import android.view.animation.Interpolator;

public final class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
        super();
    }

    public static Interpolator create(float arg2, float arg3) {
        Interpolator v0 = Build$VERSION.SDK_INT >= 21 ? PathInterpolatorCompatApi21.create(arg2, arg3) : PathInterpolatorCompatBase.create(arg2, arg3);
        return v0;
    }

    public static Interpolator create(float arg2, float arg3, float arg4, float arg5) {
        Interpolator v0 = Build$VERSION.SDK_INT >= 21 ? PathInterpolatorCompatApi21.create(arg2, arg3, arg4, arg5) : PathInterpolatorCompatBase.create(arg2, arg3, arg4, arg5);
        return v0;
    }

    public static Interpolator create(Path arg2) {
        Interpolator v0 = Build$VERSION.SDK_INT >= 21 ? PathInterpolatorCompatApi21.create(arg2) : PathInterpolatorCompatBase.create(arg2);
        return v0;
    }
}

