package android.support.v4.content;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import java.io.File;

@TargetApi(value=19) @RequiresApi(value=19) class ContextCompatKitKat {
    ContextCompatKitKat() {
        super();
    }

    public static File[] getExternalCacheDirs(Context arg1) {
        return arg1.getExternalCacheDirs();
    }

    public static File[] getExternalFilesDirs(Context arg1, String arg2) {
        return arg1.getExternalFilesDirs(arg2);
    }

    public static File[] getObbDirs(Context arg1) {
        return arg1.getObbDirs();
    }
}

