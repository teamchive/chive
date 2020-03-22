package android.support.v4.content.res;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

@TargetApi(value=17) @RequiresApi(value=17) class ConfigurationHelperJellybeanMr1 {
    ConfigurationHelperJellybeanMr1() {
        super();
    }

    static int getDensityDpi(@NonNull Resources arg1) {
        return arg1.getConfiguration().densityDpi;
    }
}

