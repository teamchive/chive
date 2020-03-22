package android.support.v4.content.res;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

@TargetApi(value=15) @RequiresApi(value=15) class ResourcesCompatIcsMr1 {
    ResourcesCompatIcsMr1() {
        super();
    }

    public static Drawable getDrawableForDensity(Resources arg1, int arg2, int arg3) {
        return arg1.getDrawableForDensity(arg2, arg3);
    }
}

