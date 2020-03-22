package android.support.v4.text;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(value=23) @RequiresApi(value=23) class ICUCompatApi23 {
    private static final String TAG = "ICUCompatIcs";
    private static Method sAddLikelySubtagsMethod;

    static {
        try {
            ICUCompatApi23.sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            return;
        }
        catch(Exception v0) {
            throw new IllegalStateException(((Throwable)v0));
        }
    }

    ICUCompatApi23() {
        super();
    }

    public static String maximizeAndGetScript(Locale arg3) {
        try {
            String v0_2 = ICUCompatApi23.sAddLikelySubtagsMethod.invoke(null, arg3).getScript();
            return v0_2;
        }
        catch(IllegalAccessException v0) {
            Log.w("ICUCompatIcs", ((Throwable)v0));
        }
        catch(InvocationTargetException v0_1) {
            Log.w("ICUCompatIcs", ((Throwable)v0_1));
        }

        return arg3.getScript();
    }
}

