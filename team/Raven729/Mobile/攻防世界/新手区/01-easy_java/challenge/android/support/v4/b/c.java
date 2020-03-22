package android.support.v4.b;

import android.content.Context;
import android.os.Process;
import android.support.v4.a.b;

public final class c {
    public static int a(Context arg3, String arg4) {
        return c.a(arg3, arg4, Process.myPid(), Process.myUid(), arg3.getPackageName());
    }

    public static int a(Context arg5, String arg6, int arg7, int arg8, String arg9) {
        int v0 = -1;
        if(arg5.checkPermission(arg6, arg7, arg8) != v0) {
            String v2 = b.a(arg6);
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

                if(b.a(arg5, v2, arg9) != 0) {
                    return -2;
                }

                v0 = 0;
            }
        }

        return v0;
    }
}

