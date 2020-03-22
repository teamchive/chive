package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

@TargetApi(value=14) @RequiresApi(value=14) class ViewGroupCompatIcs {
    ViewGroupCompatIcs() {
        super();
    }

    public static boolean onRequestSendAccessibilityEvent(ViewGroup arg1, View arg2, AccessibilityEvent arg3) {
        return arg1.onRequestSendAccessibilityEvent(arg2, arg3);
    }
}

