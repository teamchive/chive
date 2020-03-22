package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View$AccessibilityDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

@TargetApi(value=14) @RequiresApi(value=14) class ViewCompatICS {
    ViewCompatICS() {
        super();
    }

    public static boolean canScrollHorizontally(View arg1, int arg2) {
        return arg1.canScrollHorizontally(arg2);
    }

    public static boolean canScrollVertically(View arg1, int arg2) {
        return arg1.canScrollVertically(arg2);
    }

    public static void onInitializeAccessibilityEvent(View arg0, AccessibilityEvent arg1) {
        arg0.onInitializeAccessibilityEvent(arg1);
    }

    public static void onInitializeAccessibilityNodeInfo(View arg0, Object arg1) {
        arg0.onInitializeAccessibilityNodeInfo(((AccessibilityNodeInfo)arg1));
    }

    public static void onPopulateAccessibilityEvent(View arg0, AccessibilityEvent arg1) {
        arg0.onPopulateAccessibilityEvent(arg1);
    }

    public static void setAccessibilityDelegate(View arg0, @Nullable Object arg1) {
        arg0.setAccessibilityDelegate(((View$AccessibilityDelegate)arg1));
    }

    public static void setFitsSystemWindows(View arg0, boolean arg1) {
        arg0.setFitsSystemWindows(arg1);
    }
}

