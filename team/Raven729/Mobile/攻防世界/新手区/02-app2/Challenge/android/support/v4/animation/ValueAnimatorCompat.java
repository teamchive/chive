package android.support.v4.animation;

import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.view.View;

@RestrictTo(value={Scope.LIBRARY_GROUP}) public interface ValueAnimatorCompat {
    void addListener(AnimatorListenerCompat arg1);

    void addUpdateListener(AnimatorUpdateListenerCompat arg1);

    void cancel();

    float getAnimatedFraction();

    void setDuration(long arg1);

    void setTarget(View arg1);

    void start();
}

