package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

@TargetApi(value=16) @RequiresApi(value=16) class AccessibilityNodeInfoCompatJellyBean {
    AccessibilityNodeInfoCompatJellyBean() {
        super();
    }

    public static void addChild(Object arg0, View arg1, int arg2) {
        ((AccessibilityNodeInfo)arg0).addChild(arg1, arg2);
    }

    public static Object findFocus(Object arg1, int arg2) {
        return ((AccessibilityNodeInfo)arg1).findFocus(arg2);
    }

    public static Object focusSearch(Object arg1, int arg2) {
        return ((AccessibilityNodeInfo)arg1).focusSearch(arg2);
    }

    public static int getMovementGranularities(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getMovementGranularities();
    }

    public static boolean isAccessibilityFocused(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isAccessibilityFocused();
    }

    public static boolean isVisibleToUser(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isVisibleToUser();
    }

    public static Object obtain(View arg1, int arg2) {
        return AccessibilityNodeInfo.obtain(arg1, arg2);
    }

    public static boolean performAction(Object arg1, int arg2, Bundle arg3) {
        return ((AccessibilityNodeInfo)arg1).performAction(arg2, arg3);
    }

    public static void setAccesibilityFocused(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setAccessibilityFocused(arg1);
    }

    public static void setMovementGranularities(Object arg0, int arg1) {
        ((AccessibilityNodeInfo)arg0).setMovementGranularities(arg1);
    }

    public static void setParent(Object arg0, View arg1, int arg2) {
        ((AccessibilityNodeInfo)arg0).setParent(arg1, arg2);
    }

    public static void setSource(Object arg0, View arg1, int arg2) {
        ((AccessibilityNodeInfo)arg0).setSource(arg1, arg2);
    }

    public static void setVisibleToUser(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setVisibleToUser(arg1);
    }
}

