package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

@TargetApi(value=14) @RequiresApi(value=14) class ViewParentCompatICS {
    ViewParentCompatICS() {
        super();
    }

    public static boolean requestSendAccessibilityEvent(ViewParent arg1, View arg2, AccessibilityEvent arg3) {
        return arg1.requestSendAccessibilityEvent(arg2, arg3);
    }
}

