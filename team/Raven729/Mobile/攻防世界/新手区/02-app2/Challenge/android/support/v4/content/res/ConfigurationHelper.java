package android.support.v4.content.res;

import android.content.res.Resources;
import android.os.Build$VERSION;
import android.support.annotation.NonNull;

public final class ConfigurationHelper {
    interface ConfigurationHelperImpl {
        int getDensityDpi(@NonNull Resources arg1);

        int getScreenHeightDp(@NonNull Resources arg1);

        int getScreenWidthDp(@NonNull Resources arg1);

        int getSmallestScreenWidthDp(@NonNull Resources arg1);
    }

    class GingerbreadImpl implements ConfigurationHelperImpl {
        GingerbreadImpl() {
            super();
        }

        public int getDensityDpi(@NonNull Resources arg2) {
            return ConfigurationHelperGingerbread.getDensityDpi(arg2);
        }

        public int getScreenHeightDp(@NonNull Resources arg2) {
            return ConfigurationHelperGingerbread.getScreenHeightDp(arg2);
        }

        public int getScreenWidthDp(@NonNull Resources arg2) {
            return ConfigurationHelperGingerbread.getScreenWidthDp(arg2);
        }

        public int getSmallestScreenWidthDp(@NonNull Resources arg2) {
            return ConfigurationHelperGingerbread.getSmallestScreenWidthDp(arg2);
        }
    }

    class HoneycombMr2Impl extends GingerbreadImpl {
        HoneycombMr2Impl() {
            super();
        }

        public int getScreenHeightDp(@NonNull Resources arg2) {
            return ConfigurationHelperHoneycombMr2.getScreenHeightDp(arg2);
        }

        public int getScreenWidthDp(@NonNull Resources arg2) {
            return ConfigurationHelperHoneycombMr2.getScreenWidthDp(arg2);
        }

        public int getSmallestScreenWidthDp(@NonNull Resources arg2) {
            return ConfigurationHelperHoneycombMr2.getSmallestScreenWidthDp(arg2);
        }
    }

    class JellybeanMr1Impl extends HoneycombMr2Impl {
        JellybeanMr1Impl() {
            super();
        }

        public int getDensityDpi(@NonNull Resources arg2) {
            return ConfigurationHelperJellybeanMr1.getDensityDpi(arg2);
        }
    }

    private static final ConfigurationHelperImpl IMPL;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 17) {
            ConfigurationHelper.IMPL = new JellybeanMr1Impl();
        }
        else if(v0 >= 13) {
            ConfigurationHelper.IMPL = new HoneycombMr2Impl();
        }
        else {
            ConfigurationHelper.IMPL = new GingerbreadImpl();
        }
    }

    private ConfigurationHelper() {
        super();
    }

    public static int getDensityDpi(@NonNull Resources arg1) {
        return ConfigurationHelper.IMPL.getDensityDpi(arg1);
    }

    public static int getScreenHeightDp(@NonNull Resources arg1) {
        return ConfigurationHelper.IMPL.getScreenHeightDp(arg1);
    }

    public static int getScreenWidthDp(@NonNull Resources arg1) {
        return ConfigurationHelper.IMPL.getScreenWidthDp(arg1);
    }

    public static int getSmallestScreenWidthDp(@NonNull Resources arg1) {
        return ConfigurationHelper.IMPL.getSmallestScreenWidthDp(arg1);
    }
}

