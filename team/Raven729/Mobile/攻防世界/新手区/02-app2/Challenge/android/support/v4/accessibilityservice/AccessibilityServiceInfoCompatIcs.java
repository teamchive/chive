package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.content.pm.ResolveInfo;
import android.support.annotation.RequiresApi;

@TargetApi(value=14) @RequiresApi(value=14) class AccessibilityServiceInfoCompatIcs {
    AccessibilityServiceInfoCompatIcs() {
        super();
    }

    public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo arg1) {
        return arg1.getCanRetrieveWindowContent();
    }

    public static String getDescription(AccessibilityServiceInfo arg1) {
        return arg1.getDescription();
    }

    public static String getId(AccessibilityServiceInfo arg1) {
        return arg1.getId();
    }

    public static ResolveInfo getResolveInfo(AccessibilityServiceInfo arg1) {
        return arg1.getResolveInfo();
    }

    public static String getSettingsActivityName(AccessibilityServiceInfo arg1) {
        return arg1.getSettingsActivityName();
    }
}

