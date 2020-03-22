package android.support.v4.os;

import android.os.Build$VERSION;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    private EnvironmentCompat() {
        super();
    }

    public static String getStorageState(File arg4) {
        if(Build$VERSION.SDK_INT >= 19) {
            String v0 = EnvironmentCompatKitKat.getStorageState(arg4);
            return v0;
        }

        try {
            if(!arg4.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath())) {
                return "unknown";
            }

            return Environment.getExternalStorageState();
        }
        catch(IOException v0_1) {
            Log.w("EnvironmentCompat", "Failed to resolve canonical path: " + v0_1);
        }

        return "unknown";
    }
}

