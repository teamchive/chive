package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewParent;

@TargetApi(value=19) @RequiresApi(value=19) class ViewParentCompatKitKat {
    ViewParentCompatKitKat() {
        super();
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent arg0, View arg1, View arg2, int arg3) {
        arg0.notifySubtreeAccessibilityStateChanged(arg1, arg2, arg3);
    }
}

