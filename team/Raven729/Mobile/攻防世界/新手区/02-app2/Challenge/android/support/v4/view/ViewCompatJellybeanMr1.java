package android.support.v4.view;

import android.annotation.TargetApi;
import android.graphics.Paint;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.view.View;

@TargetApi(value=17) @RequiresApi(value=17) class ViewCompatJellybeanMr1 {
    ViewCompatJellybeanMr1() {
        super();
    }

    public static Display getDisplay(View arg1) {
        return arg1.getDisplay();
    }

    public static int getLabelFor(View arg1) {
        return arg1.getLabelFor();
    }

    public static int getLayoutDirection(View arg1) {
        return arg1.getLayoutDirection();
    }

    public static int getPaddingEnd(View arg1) {
        return arg1.getPaddingEnd();
    }

    public static int getPaddingStart(View arg1) {
        return arg1.getPaddingStart();
    }

    public static int getWindowSystemUiVisibility(View arg1) {
        return arg1.getWindowSystemUiVisibility();
    }

    public static boolean isPaddingRelative(View arg1) {
        return arg1.isPaddingRelative();
    }

    public static void setLabelFor(View arg0, int arg1) {
        arg0.setLabelFor(arg1);
    }

    public static void setLayerPaint(View arg0, Paint arg1) {
        arg0.setLayerPaint(arg1);
    }

    public static void setLayoutDirection(View arg0, int arg1) {
        arg0.setLayoutDirection(arg1);
    }

    public static void setPaddingRelative(View arg0, int arg1, int arg2, int arg3, int arg4) {
        arg0.setPaddingRelative(arg1, arg2, arg3, arg4);
    }
}

