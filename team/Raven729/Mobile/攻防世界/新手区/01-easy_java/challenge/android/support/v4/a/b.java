package android.support.v4.a;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build$VERSION;

public final class b {
    public static int a(Context arg2, String arg3, String arg4) {
        int v0 = Build$VERSION.SDK_INT >= 23 ? arg2.getSystemService(AppOpsManager.class).noteProxyOp(arg3, arg4) : 1;
        return v0;
    }

    public static String a(String arg2) {
        String v0 = Build$VERSION.SDK_INT >= 23 ? AppOpsManager.permissionToOp(arg2) : null;
        return v0;
    }
}

