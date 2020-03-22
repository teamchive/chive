package android.support.v4.content.res;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.support.annotation.RequiresApi;

@TargetApi(value=23) @RequiresApi(value=23) class ResourcesCompatApi23 {
    ResourcesCompatApi23() {
        super();
    }

    public static int getColor(Resources arg1, int arg2, Resources$Theme arg3) {
        return arg1.getColor(arg2, arg3);
    }

    public static ColorStateList getColorStateList(Resources arg1, int arg2, Resources$Theme arg3) {
        return arg1.getColorStateList(arg2, arg3);
    }
}

