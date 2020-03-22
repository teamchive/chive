package android.support.v4.os;

import android.annotation.TargetApi;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import java.io.File;

@TargetApi(value=19) @RequiresApi(value=19) class EnvironmentCompatKitKat {
    EnvironmentCompatKitKat() {
        super();
    }

    public static String getStorageState(File arg1) {
        return Environment.getStorageState(arg1);
    }
}

