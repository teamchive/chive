package android.support.v4.text;

import android.os.Build$VERSION;
import java.util.Locale;

public final class ICUCompat {
    interface ICUCompatImpl {
        String maximizeAndGetScript(Locale arg1);
    }

    class ICUCompatImplBase implements ICUCompatImpl {
        ICUCompatImplBase() {
            super();
        }

        public String maximizeAndGetScript(Locale arg2) {
            return null;
        }
    }

    class ICUCompatImplIcs implements ICUCompatImpl {
        ICUCompatImplIcs() {
            super();
        }

        public String maximizeAndGetScript(Locale arg2) {
            return ICUCompatIcs.maximizeAndGetScript(arg2);
        }
    }

    class ICUCompatImplLollipop implements ICUCompatImpl {
        ICUCompatImplLollipop() {
            super();
        }

        public String maximizeAndGetScript(Locale arg2) {
            return ICUCompatApi23.maximizeAndGetScript(arg2);
        }
    }

    private static final ICUCompatImpl IMPL;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 21) {
            ICUCompat.IMPL = new ICUCompatImplLollipop();
        }
        else if(v0 >= 14) {
            ICUCompat.IMPL = new ICUCompatImplIcs();
        }
        else {
            ICUCompat.IMPL = new ICUCompatImplBase();
        }
    }

    private ICUCompat() {
        super();
    }

    public static String maximizeAndGetScript(Locale arg1) {
        return ICUCompat.IMPL.maximizeAndGetScript(arg1);
    }
}

