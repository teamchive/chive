package android.support.v4.content.res;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;

@TargetApi(value=9) @RequiresApi(value=9) class ConfigurationHelperGingerbread {
    ConfigurationHelperGingerbread() {
        super();
    }

    static int getDensityDpi(@NonNull Resources arg1) {
        return arg1.getDisplayMetrics().densityDpi;
    }

    static int getScreenHeightDp(@NonNull Resources arg2) {
        DisplayMetrics v0 = arg2.getDisplayMetrics();
        return ((int)((((float)v0.heightPixels)) / v0.density));
    }

    static int getScreenWidthDp(@NonNull Resources arg2) {
        DisplayMetrics v0 = arg2.getDisplayMetrics();
        return ((int)((((float)v0.widthPixels)) / v0.density));
    }

    static int getSmallestScreenWidthDp(@NonNull Resources arg2) {
        return Math.min(ConfigurationHelperGingerbread.getScreenWidthDp(arg2), ConfigurationHelperGingerbread.getScreenHeightDp(arg2));
    }
}

