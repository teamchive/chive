package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.support.annotation.RequiresApi;

@TargetApi(value=16) @RequiresApi(value=16) class AccessibilityServiceInfoCompatJellyBean {
    AccessibilityServiceInfoCompatJellyBean() {
        super();
    }

    public static String loadDescription(AccessibilityServiceInfo arg1, PackageManager arg2) {
        return arg1.loadDescription(arg2);
    }
}

