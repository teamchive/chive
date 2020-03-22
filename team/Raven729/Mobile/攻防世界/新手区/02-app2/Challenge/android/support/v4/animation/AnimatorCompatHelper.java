package android.support.v4.animation;

import android.os.Build$VERSION;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.view.View;

@RestrictTo(value={Scope.LIBRARY_GROUP}) public final class AnimatorCompatHelper {
    private static final AnimatorProvider IMPL;

    static {
        AnimatorCompatHelper.IMPL = Build$VERSION.SDK_INT >= 12 ? new HoneycombMr1AnimatorCompatProvider() : new GingerbreadAnimatorCompatProvider();
    }

    private AnimatorCompatHelper() {
        super();
    }

    public static void clearInterpolator(View arg1) {
        AnimatorCompatHelper.IMPL.clearInterpolator(arg1);
    }

    public static ValueAnimatorCompat emptyValueAnimator() {
        return AnimatorCompatHelper.IMPL.emptyValueAnimator();
    }
}

