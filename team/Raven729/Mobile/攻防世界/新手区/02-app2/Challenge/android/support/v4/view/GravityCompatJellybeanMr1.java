package android.support.v4.view;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.view.Gravity;

@TargetApi(value=17) @RequiresApi(value=17) class GravityCompatJellybeanMr1 {
    GravityCompatJellybeanMr1() {
        super();
    }

    public static void apply(int arg0, int arg1, int arg2, Rect arg3, int arg4, int arg5, Rect arg6, int arg7) {
        Gravity.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static void apply(int arg0, int arg1, int arg2, Rect arg3, Rect arg4, int arg5) {
        Gravity.apply(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void applyDisplay(int arg0, Rect arg1, Rect arg2, int arg3) {
        Gravity.applyDisplay(arg0, arg1, arg2, arg3);
    }

    public static int getAbsoluteGravity(int arg1, int arg2) {
        return Gravity.getAbsoluteGravity(arg1, arg2);
    }
}

