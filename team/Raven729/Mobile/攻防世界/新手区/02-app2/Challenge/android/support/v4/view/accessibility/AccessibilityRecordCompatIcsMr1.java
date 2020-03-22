package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityRecord;

@TargetApi(value=15) @RequiresApi(value=15) class AccessibilityRecordCompatIcsMr1 {
    AccessibilityRecordCompatIcsMr1() {
        super();
    }

    public static int getMaxScrollX(Object arg1) {
        return ((AccessibilityRecord)arg1).getMaxScrollX();
    }

    public static int getMaxScrollY(Object arg1) {
        return ((AccessibilityRecord)arg1).getMaxScrollY();
    }

    public static void setMaxScrollX(Object arg0, int arg1) {
        ((AccessibilityRecord)arg0).setMaxScrollX(arg1);
    }

    public static void setMaxScrollY(Object arg0, int arg1) {
        ((AccessibilityRecord)arg0).setMaxScrollY(arg1);
    }
}

