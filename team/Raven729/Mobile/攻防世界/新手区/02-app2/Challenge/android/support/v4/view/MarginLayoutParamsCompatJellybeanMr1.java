package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup$MarginLayoutParams;

@TargetApi(value=17) @RequiresApi(value=17) class MarginLayoutParamsCompatJellybeanMr1 {
    MarginLayoutParamsCompatJellybeanMr1() {
        super();
    }

    public static int getLayoutDirection(ViewGroup$MarginLayoutParams arg1) {
        return arg1.getLayoutDirection();
    }

    public static int getMarginEnd(ViewGroup$MarginLayoutParams arg1) {
        return arg1.getMarginEnd();
    }

    public static int getMarginStart(ViewGroup$MarginLayoutParams arg1) {
        return arg1.getMarginStart();
    }

    public static boolean isMarginRelative(ViewGroup$MarginLayoutParams arg1) {
        return arg1.isMarginRelative();
    }

    public static void resolveLayoutDirection(ViewGroup$MarginLayoutParams arg0, int arg1) {
        arg0.resolveLayoutDirection(arg1);
    }

    public static void setLayoutDirection(ViewGroup$MarginLayoutParams arg0, int arg1) {
        arg0.setLayoutDirection(arg1);
    }

    public static void setMarginEnd(ViewGroup$MarginLayoutParams arg0, int arg1) {
        arg0.setMarginEnd(arg1);
    }

    public static void setMarginStart(ViewGroup$MarginLayoutParams arg0, int arg1) {
        arg0.setMarginStart(arg1);
    }
}

