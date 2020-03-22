package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityEvent;

@TargetApi(value=19) @RequiresApi(value=19) class AccessibilityEventCompatKitKat {
    AccessibilityEventCompatKitKat() {
        super();
    }

    public static int getContentChangeTypes(AccessibilityEvent arg1) {
        return arg1.getContentChangeTypes();
    }

    public static void setContentChangeTypes(AccessibilityEvent arg0, int arg1) {
        arg0.setContentChangeTypes(arg1);
    }
}

