package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;

@TargetApi(value=24) @RequiresApi(value=24) class AccessibilityNodeInfoCompatApi24 {
    AccessibilityNodeInfoCompatApi24() {
        super();
    }

    public static Object getActionSetProgress() {
        return AccessibilityNodeInfo$AccessibilityAction.ACTION_SET_PROGRESS;
    }

    public static int getDrawingOrder(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getDrawingOrder();
    }

    public static boolean isImportantForAccessibility(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isImportantForAccessibility();
    }

    public static void setDrawingOrder(Object arg0, int arg1) {
        ((AccessibilityNodeInfo)arg0).setDrawingOrder(arg1);
    }

    public static void setImportantForAccessibility(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setImportantForAccessibility(arg1);
    }
}

