package android.support.v4.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.v4.app.AppOpsManagerCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionChecker {
    @Retention(value=RetentionPolicy.SOURCE) @public interface PermissionResult {
    }

    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_DENIED_APP_OP = -2;
    public static final int PERMISSION_GRANTED;

    private PermissionChecker() {
        super();
    }

    public static int checkCallingOrSelfPermission(@NonNull Context arg3, @NonNull String arg4) {
        String v0 = Binder.getCallingPid() == Process.myPid() ? arg3.getPackageName() : null;
        return PermissionChecker.checkPermission(arg3, arg4, Binder.getCallingPid(), Binder.getCallingUid(), v0);
    }

    public static int checkCallingPermission(@NonNull Context arg2, @NonNull String arg3, String arg4) {
        int v0 = Binder.getCallingPid() == Process.myPid() ? -1 : PermissionChecker.checkPermission(arg2, arg3, Binder.getCallingPid(), Binder.getCallingUid(), arg4);
        return v0;
    }

    public static int checkPermission(@NonNull Context arg5, @NonNull String arg6, int arg7, int arg8, String arg9) {
        int v0 = -1;
        if(arg5.checkPermission(arg6, arg7, arg8) != v0) {
            String v2 = AppOpsManagerCompat.permissionToOp(arg6);
            if(v2 == null) {
                v0 = 0;
            }
            else {
                if(arg9 == null) {
                    String[] v3 = arg5.getPackageManager().getPackagesForUid(arg8);
                    if(v3 == null) {
                        return v0;
                    }
                    else if(v3.length > 0) {
                        arg9 = v3[0];
                    }
                    else {
                        return v0;
                    }
                }

                if(AppOpsManagerCompat.noteProxyOp(arg5, v2, arg9) != 0) {
                    return -2;
                }

                v0 = 0;
            }
        }

        return v0;
    }

    public static int checkSelfPermission(@NonNull Context arg3, @NonNull String arg4) {
        return PermissionChecker.checkPermission(arg3, arg4, Process.myPid(), Process.myUid(), arg3.getPackageName());
    }
}

