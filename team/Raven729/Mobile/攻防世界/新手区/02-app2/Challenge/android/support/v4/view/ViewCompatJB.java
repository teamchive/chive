package android.support.v4.view;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewParent;

@TargetApi(value=16) @RequiresApi(value=16) class ViewCompatJB {
    ViewCompatJB() {
        super();
    }

    public static Object getAccessibilityNodeProvider(View arg1) {
        return arg1.getAccessibilityNodeProvider();
    }

    public static boolean getFitsSystemWindows(View arg1) {
        return arg1.getFitsSystemWindows();
    }

    public static int getImportantForAccessibility(View arg1) {
        return arg1.getImportantForAccessibility();
    }

    public static int getMinimumHeight(View arg1) {
        return arg1.getMinimumHeight();
    }

    public static int getMinimumWidth(View arg1) {
        return arg1.getMinimumWidth();
    }

    public static ViewParent getParentForAccessibility(View arg1) {
        return arg1.getParentForAccessibility();
    }

    public static boolean hasOverlappingRendering(View arg1) {
        return arg1.hasOverlappingRendering();
    }

    public static boolean hasTransientState(View arg1) {
        return arg1.hasTransientState();
    }

    public static boolean performAccessibilityAction(View arg1, int arg2, Bundle arg3) {
        return arg1.performAccessibilityAction(arg2, arg3);
    }

    public static void postInvalidateOnAnimation(View arg0) {
        arg0.postInvalidateOnAnimation();
    }

    public static void postInvalidateOnAnimation(View arg0, int arg1, int arg2, int arg3, int arg4) {
        arg0.postInvalidate(arg1, arg2, arg3, arg4);
    }

    public static void postOnAnimation(View arg0, Runnable arg1) {
        arg0.postOnAnimation(arg1);
    }

    public static void postOnAnimationDelayed(View arg0, Runnable arg1, long arg2) {
        arg0.postOnAnimationDelayed(arg1, arg2);
    }

    public static void requestApplyInsets(View arg0) {
        arg0.requestFitSystemWindows();
    }

    public static void setBackground(View arg0, Drawable arg1) {
        arg0.setBackground(arg1);
    }

    public static void setHasTransientState(View arg0, boolean arg1) {
        arg0.setHasTransientState(arg1);
    }

    public static void setImportantForAccessibility(View arg0, int arg1) {
        arg0.setImportantForAccessibility(arg1);
    }
}

