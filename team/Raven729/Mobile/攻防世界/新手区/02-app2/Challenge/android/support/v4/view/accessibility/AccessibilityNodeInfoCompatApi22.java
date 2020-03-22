package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

@TargetApi(value=22) @RequiresApi(value=22) class AccessibilityNodeInfoCompatApi22 {
    AccessibilityNodeInfoCompatApi22() {
        super();
    }

    public static Object getTraversalAfter(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getTraversalAfter();
    }

    public static Object getTraversalBefore(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getTraversalBefore();
    }

    public static void setTraversalAfter(Object arg0, View arg1) {
        ((AccessibilityNodeInfo)arg0).setTraversalAfter(arg1);
    }

    public static void setTraversalAfter(Object arg0, View arg1, int arg2) {
        ((AccessibilityNodeInfo)arg0).setTraversalAfter(arg1, arg2);
    }

    public static void setTraversalBefore(Object arg0, View arg1) {
        ((AccessibilityNodeInfo)arg0).setTraversalBefore(arg1);
    }

    public static void setTraversalBefore(Object arg0, View arg1, int arg2) {
        ((AccessibilityNodeInfo)arg0).setTraversalBefore(arg1, arg2);
    }
}

