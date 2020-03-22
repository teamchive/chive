package android.support.v4.app;

import android.app.ActivityManager;
import android.os.Build$VERSION;
import android.support.annotation.NonNull;

public final class ActivityManagerCompat {
    private ActivityManagerCompat() {
        super();
    }

    public static boolean isLowRamDevice(@NonNull ActivityManager arg2) {
        boolean v0 = Build$VERSION.SDK_INT >= 19 ? ActivityManagerCompatKitKat.isLowRamDevice(arg2) : false;
        return v0;
    }
}

