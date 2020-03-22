package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;

@RestrictTo(value={Scope.LIBRARY_GROUP}) public interface TintAwareDrawable {
    void setTint(@ColorInt int arg1);

    void setTintList(ColorStateList arg1);

    void setTintMode(PorterDuff$Mode arg1);
}

