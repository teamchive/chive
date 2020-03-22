package android.support.v4.os;

import android.os.Build$VERSION;

public class BuildCompat {
    private BuildCompat() {
        super();
    }

    public static boolean isAtLeastN() {
        boolean v0 = Build$VERSION.SDK_INT >= 24 ? true : false;
        return v0;
    }

    public static boolean isAtLeastNMR1() {
        boolean v0 = Build$VERSION.SDK_INT >= 25 ? true : false;
        return v0;
    }

    public static boolean isAtLeastO() {
        boolean v0;
        if(!"REL".equals(Build$VERSION.CODENAME)) {
            if(!"O".equals(Build$VERSION.CODENAME) && !Build$VERSION.CODENAME.startsWith("OMR")) {
                goto label_14;
            }

            v0 = true;
        }
        else {
        label_14:
            v0 = false;
        }

        return v0;
    }
}

