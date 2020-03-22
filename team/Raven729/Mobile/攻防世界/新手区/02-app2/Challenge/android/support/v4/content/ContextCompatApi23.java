package android.support.v4.content;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.RequiresApi;

@TargetApi(value=23) @RequiresApi(value=23) class ContextCompatApi23 {
    ContextCompatApi23() {
        super();
    }

    public static int getColor(Context arg1, int arg2) {
        return arg1.getColor(arg2);
    }

    public static ColorStateList getColorStateList(Context arg1, int arg2) {
        return arg1.getColorStateList(arg2);
    }
}

