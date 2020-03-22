package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.support.annotation.RequiresApi;

@TargetApi(value=23) @RequiresApi(value=23) class AppOpsManagerCompat23 {
    AppOpsManagerCompat23() {
        super();
    }

    public static int noteOp(Context arg1, String arg2, int arg3, String arg4) {
        return arg1.getSystemService(AppOpsManager.class).noteOp(arg2, arg3, arg4);
    }

    public static int noteProxyOp(Context arg1, String arg2, String arg3) {
        return arg1.getSystemService(AppOpsManager.class).noteProxyOp(arg2, arg3);
    }

    public static String permissionToOp(String arg1) {
        return AppOpsManager.permissionToOp(arg1);
    }
}

