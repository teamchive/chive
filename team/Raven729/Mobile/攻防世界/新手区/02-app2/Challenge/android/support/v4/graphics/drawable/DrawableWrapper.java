package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;

@RestrictTo(value={Scope.LIBRARY_GROUP}) public interface DrawableWrapper {
    Drawable getWrappedDrawable();

    void setWrappedDrawable(Drawable arg1);
}

