package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

@TargetApi(value=23) @RequiresApi(value=23) class DrawableCompatApi23 {
    DrawableCompatApi23() {
        super();
    }

    public static int getLayoutDirection(Drawable arg1) {
        return arg1.getLayoutDirection();
    }

    public static boolean setLayoutDirection(Drawable arg1, int arg2) {
        return arg1.setLayoutDirection(arg2);
    }
}

