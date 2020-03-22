package android.support.v4.content.res;

import android.annotation.TargetApi;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

@TargetApi(value=21) @RequiresApi(value=21) class ResourcesCompatApi21 {
    ResourcesCompatApi21() {
        super();
    }

    public static Drawable getDrawable(Resources arg1, int arg2, Resources$Theme arg3) {
        return arg1.getDrawable(arg2, arg3);
    }

    public static Drawable getDrawableForDensity(Resources arg1, int arg2, int arg3, Resources$Theme arg4) {
        return arg1.getDrawableForDensity(arg2, arg3, arg4);
    }
}

