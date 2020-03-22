package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

@TargetApi(value=17) @RequiresApi(value=17) class AccessibilityNodeInfoCompatJellybeanMr1 {
    AccessibilityNodeInfoCompatJellybeanMr1() {
        super();
    }

    public static Object getLabelFor(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getLabelFor();
    }

    public static Object getLabeledBy(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getLabeledBy();
    }

    public static void setLabelFor(Object arg0, View arg1) {
        ((AccessibilityNodeInfo)arg0).setLabelFor(arg1);
    }

    public static void setLabelFor(Object arg0, View arg1, int arg2) {
        ((AccessibilityNodeInfo)arg0).setLabelFor(arg1, arg2);
    }

    public static void setLabeledBy(Object arg0, View arg1) {
        ((AccessibilityNodeInfo)arg0).setLabeledBy(arg1);
    }

    public static void setLabeledBy(Object arg0, View arg1, int arg2) {
        ((AccessibilityNodeInfo)arg0).setLabeledBy(arg1, arg2);
    }
}

