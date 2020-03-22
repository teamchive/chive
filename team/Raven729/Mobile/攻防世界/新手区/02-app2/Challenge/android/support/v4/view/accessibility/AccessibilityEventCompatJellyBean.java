package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityEvent;

@TargetApi(value=16) @RequiresApi(value=16) class AccessibilityEventCompatJellyBean {
    AccessibilityEventCompatJellyBean() {
        super();
    }

    public static int getAction(AccessibilityEvent arg1) {
        return arg1.getAction();
    }

    public static int getMovementGranularity(AccessibilityEvent arg1) {
        return arg1.getMovementGranularity();
    }

    public static void setAction(AccessibilityEvent arg0, int arg1) {
        arg0.setAction(arg1);
    }

    public static void setMovementGranularity(AccessibilityEvent arg0, int arg1) {
        arg0.setMovementGranularity(arg1);
    }
}

