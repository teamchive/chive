package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.view.PointerIcon;

@TargetApi(value=24) @RequiresApi(value=24) class PointerIconCompatApi24 {
    PointerIconCompatApi24() {
        super();
    }

    public static Object create(Bitmap arg1, float arg2, float arg3) {
        return PointerIcon.create(arg1, arg2, arg3);
    }

    public static Object getSystemIcon(Context arg1, int arg2) {
        return PointerIcon.getSystemIcon(arg1, arg2);
    }

    public static Object load(Resources arg1, int arg2) {
        return PointerIcon.load(arg1, arg2);
    }
}

