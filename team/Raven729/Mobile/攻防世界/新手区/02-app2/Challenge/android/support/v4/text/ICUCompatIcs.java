package android.support.v4.text;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(value=14) @RequiresApi(value=14) class ICUCompatIcs {
    private static final String TAG = "ICUCompatIcs";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    static {
        Method v5 = null;
        try {
            Class v0_1 = Class.forName("libcore.icu.ICU");
            if(v0_1 == null) {
                return;
            }

            ICUCompatIcs.sGetScriptMethod = v0_1.getMethod("getScript", String.class);
            ICUCompatIcs.sAddLikelySubtagsMethod = v0_1.getMethod("addLikelySubtags", String.class);
        }
        catch(Exception v0) {
            ICUCompatIcs.sGetScriptMethod = v5;
            ICUCompatIcs.sAddLikelySubtagsMethod = v5;
            Log.w("ICUCompatIcs", ((Throwable)v0));
        }
    }

    ICUCompatIcs() {
        super();
    }

    private static String addLikelySubtags(Locale arg4) {
        String v0_3;
        String v1 = arg4.toString();
        try {
            if(ICUCompatIcs.sAddLikelySubtagsMethod == null) {
                goto label_14;
            }

            Object v0_2 = ICUCompatIcs.sAddLikelySubtagsMethod.invoke(null, v1);
        }
        catch(IllegalAccessException v0) {
            Log.w("ICUCompatIcs", ((Throwable)v0));
            goto label_14;
        }
        catch(InvocationTargetException v0_1) {
            Log.w("ICUCompatIcs", ((Throwable)v0_1));
        label_14:
            v0_3 = v1;
        }

        return v0_3;
    }

    private static String getScript(String arg4) {
        Object v0_2;
        String v1 = null;
        try {
            if(ICUCompatIcs.sGetScriptMethod == null) {
                goto label_14;
            }

            v0_2 = ICUCompatIcs.sGetScriptMethod.invoke(null, arg4);
        }
        catch(IllegalAccessException v0) {
            Log.w("ICUCompatIcs", ((Throwable)v0));
            goto label_14;
        }
        catch(InvocationTargetException v0_1) {
            Log.w("ICUCompatIcs", ((Throwable)v0_1));
        label_14:
            String v0_3 = v1;
        }

        return ((String)v0_2);
    }

    public static String maximizeAndGetScript(Locale arg1) {
        String v0 = ICUCompatIcs.addLikelySubtags(arg1);
        return v0 != null ? ICUCompatIcs.getScript(v0) : null;
    }
}

