package android.support.v4.content.res;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

@TargetApi(value=13) @RequiresApi(value=13) class ConfigurationHelperHoneycombMr2 {
    ConfigurationHelperHoneycombMr2() {
        super();
    }

    static int getScreenHeightDp(@NonNull Resources arg1) {
        return arg1.getConfiguration().screenHeightDp;
    }

    static int getScreenWidthDp(@NonNull Resources arg1) {
        return arg1.getConfiguration().screenWidthDp;
    }

    static int getSmallestScreenWidthDp(@NonNull Resources arg1) {
        return arg1.getConfiguration().smallestScreenWidthDp;
    }
}

