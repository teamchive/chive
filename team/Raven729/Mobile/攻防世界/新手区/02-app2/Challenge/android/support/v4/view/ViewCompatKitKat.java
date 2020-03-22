package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(value=19) @RequiresApi(value=19) class ViewCompatKitKat {
    ViewCompatKitKat() {
        super();
    }

    public static int getAccessibilityLiveRegion(View arg1) {
        return arg1.getAccessibilityLiveRegion();
    }

    public static boolean isAttachedToWindow(View arg1) {
        return arg1.isAttachedToWindow();
    }

    public static boolean isLaidOut(View arg1) {
        return arg1.isLaidOut();
    }

    public static boolean isLayoutDirectionResolved(View arg1) {
        return arg1.isLayoutDirectionResolved();
    }

    public static void setAccessibilityLiveRegion(View arg0, int arg1) {
        arg0.setAccessibilityLiveRegion(arg1);
    }
}

