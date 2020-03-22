package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.support.annotation.RequiresApi;

@TargetApi(value=19) @RequiresApi(value=19) class ActivityManagerCompatKitKat {
    ActivityManagerCompatKitKat() {
        super();
    }

    public static boolean isLowRamDevice(ActivityManager arg1) {
        return arg1.isLowRamDevice();
    }
}

