package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityWindowInfo;

@TargetApi(value=24) @RequiresApi(value=24) class AccessibilityWindowInfoCompatApi24 {
    AccessibilityWindowInfoCompatApi24() {
        super();
    }

    public static Object getAnchor(Object arg1) {
        return ((AccessibilityWindowInfo)arg1).getAnchor();
    }

    public static CharSequence getTitle(Object arg1) {
        return ((AccessibilityWindowInfo)arg1).getTitle();
    }
}

