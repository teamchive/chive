package android.support.v4.animation;

import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;

@RestrictTo(value={Scope.LIBRARY_GROUP}) public interface AnimatorListenerCompat {
    void onAnimationCancel(ValueAnimatorCompat arg1);

    void onAnimationEnd(ValueAnimatorCompat arg1);

    void onAnimationRepeat(ValueAnimatorCompat arg1);

    void onAnimationStart(ValueAnimatorCompat arg1);
}

