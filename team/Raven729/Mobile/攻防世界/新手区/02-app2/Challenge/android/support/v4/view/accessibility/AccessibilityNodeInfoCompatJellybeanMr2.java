package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

@TargetApi(value=18) @RequiresApi(value=18) class AccessibilityNodeInfoCompatJellybeanMr2 {
    AccessibilityNodeInfoCompatJellybeanMr2() {
        super();
    }

    public static List findAccessibilityNodeInfosByViewId(Object arg1, String arg2) {
        return ((AccessibilityNodeInfo)arg1).findAccessibilityNodeInfosByViewId(arg2);
    }

    public static int getTextSelectionEnd(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getTextSelectionEnd();
    }

    public static int getTextSelectionStart(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getTextSelectionStart();
    }

    public static String getViewIdResourceName(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getViewIdResourceName();
    }

    public static boolean isEditable(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isEditable();
    }

    public static boolean refresh(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).refresh();
    }

    public static void setEditable(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setEditable(arg1);
    }

    public static void setTextSelection(Object arg0, int arg1, int arg2) {
        ((AccessibilityNodeInfo)arg0).setTextSelection(arg1, arg2);
    }

    public static void setViewIdResourceName(Object arg0, String arg1) {
        ((AccessibilityNodeInfo)arg0).setViewIdResourceName(arg1);
    }
}

