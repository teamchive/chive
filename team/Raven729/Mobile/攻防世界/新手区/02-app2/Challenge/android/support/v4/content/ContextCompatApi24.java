package android.support.v4.content;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import java.io.File;

@TargetApi(value=24) @RequiresApi(value=24) class ContextCompatApi24 {
    ContextCompatApi24() {
        super();
    }

    public static Context createDeviceProtectedStorageContext(Context arg1) {
        return arg1.createDeviceProtectedStorageContext();
    }

    public static File getDataDir(Context arg1) {
        return arg1.getDataDir();
    }

    public static boolean isDeviceProtectedStorage(Context arg1) {
        return arg1.isDeviceProtectedStorage();
    }
}

