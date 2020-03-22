package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;

@TargetApi(value=14) @RequiresApi(value=14) class AccessibilityEventCompatIcs {
    AccessibilityEventCompatIcs() {
        super();
    }

    public static void appendRecord(AccessibilityEvent arg0, Object arg1) {
        arg0.appendRecord(((AccessibilityRecord)arg1));
    }

    public static Object getRecord(AccessibilityEvent arg1, int arg2) {
        return arg1.getRecord(arg2);
    }

    public static int getRecordCount(AccessibilityEvent arg1) {
        return arg1.getRecordCount();
    }

    public static void setScrollable(AccessibilityEvent arg0, boolean arg1) {
        arg0.setScrollable(arg1);
    }
}

