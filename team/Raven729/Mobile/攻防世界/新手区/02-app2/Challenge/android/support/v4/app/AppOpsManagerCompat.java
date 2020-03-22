package android.support.v4.app;

import android.content.Context;
import android.os.Build$VERSION;
import android.support.annotation.NonNull;

public final class AppOpsManagerCompat {
    class AppOpsManager23 extends AppOpsManagerImpl {
        AppOpsManager23() {
            super();
        }

        public int noteOp(Context arg2, String arg3, int arg4, String arg5) {
            return AppOpsManagerCompat23.noteOp(arg2, arg3, arg4, arg5);
        }

        public int noteProxyOp(Context arg2, String arg3, String arg4) {
            return AppOpsManagerCompat23.noteProxyOp(arg2, arg3, arg4);
        }

        public String permissionToOp(String arg2) {
            return AppOpsManagerCompat23.permissionToOp(arg2);
        }
    }

    class AppOpsManagerImpl {
        AppOpsManagerImpl() {
            super();
        }

        public int noteOp(Context arg2, String arg3, int arg4, String arg5) {
            return 1;
        }

        public int noteProxyOp(Context arg2, String arg3, String arg4) {
            return 1;
        }

        public String permissionToOp(String arg2) {
            return null;
        }
    }

    private static final AppOpsManagerImpl IMPL = null;
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_IGNORED = 1;

    static {
        AppOpsManagerCompat.IMPL = Build$VERSION.SDK_INT >= 23 ? new AppOpsManager23() : new AppOpsManagerImpl();
    }

    private AppOpsManagerCompat() {
        super();
    }

    public static int noteOp(@NonNull Context arg1, @NonNull String arg2, int arg3, @NonNull String arg4) {
        return AppOpsManagerCompat.IMPL.noteOp(arg1, arg2, arg3, arg4);
    }

    public static int noteProxyOp(@NonNull Context arg1, @NonNull String arg2, @NonNull String arg3) {
        return AppOpsManagerCompat.IMPL.noteProxyOp(arg1, arg2, arg3);
    }

    public static String permissionToOp(@NonNull String arg1) {
        return AppOpsManagerCompat.IMPL.permissionToOp(arg1);
    }
}

