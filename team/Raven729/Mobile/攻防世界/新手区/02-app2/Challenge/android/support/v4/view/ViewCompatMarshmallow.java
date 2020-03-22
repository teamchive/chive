package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(value=23) @RequiresApi(value=23) class ViewCompatMarshmallow {
    ViewCompatMarshmallow() {
        super();
    }

    public static int getScrollIndicators(View arg1) {
        return arg1.getScrollIndicators();
    }

    static void offsetLeftAndRight(View arg0, int arg1) {
        arg0.offsetLeftAndRight(arg1);
    }

    static void offsetTopAndBottom(View arg0, int arg1) {
        arg0.offsetTopAndBottom(arg1);
    }

    public static void setScrollIndicators(View arg0, int arg1) {
        arg0.setScrollIndicators(arg1);
    }

    public static void setScrollIndicators(View arg0, int arg1, int arg2) {
        arg0.setScrollIndicators(arg1, arg2);
    }
}

