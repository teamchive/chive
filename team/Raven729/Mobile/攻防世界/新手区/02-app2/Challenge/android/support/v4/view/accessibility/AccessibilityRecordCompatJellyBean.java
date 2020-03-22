package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

@TargetApi(value=16) @RequiresApi(value=16) class AccessibilityRecordCompatJellyBean {
    AccessibilityRecordCompatJellyBean() {
        super();
    }

    public static void setSource(Object arg0, View arg1, int arg2) {
        ((AccessibilityRecord)arg0).setSource(arg1, arg2);
    }
}

