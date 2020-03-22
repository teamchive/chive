package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;

@TargetApi(value=18) @RequiresApi(value=18) class AccessibilityServiceInfoCompatJellyBeanMr2 {
    AccessibilityServiceInfoCompatJellyBeanMr2() {
        super();
    }

    public static int getCapabilities(AccessibilityServiceInfo arg1) {
        return arg1.getCapabilities();
    }
}

