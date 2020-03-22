package android.support.v4.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.b.a.a$c;
import android.support.v4.f.b$b;
import android.support.v4.g.k;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

class e extends g {
    private static final Class a;
    private static final Constructor b;
    private static final Method c;
    private static final Method d;

    static {
        Constructor v2_1;
        Method v1;
        Method v0_2;
        Method v2;
        try {
            Class v4 = Class.forName("android.graphics.FontFamily");
            Constructor v3 = v4.getConstructor();
            v2 = v4.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            v0_2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(v4, 1).getClass());
            v1 = v2;
            v2_1 = v3;
            Class v3_1 = v4;
            goto label_38;
        }
        catch(NoSuchMethodException v0) {
        }
        catch(ClassNotFoundException v0_1) {
        }

        Log.e("TypefaceCompatApi24Impl", v0.getClass().getName(), ((Throwable)v0));
        v0_2 = v1;
        v2 = v1;
        Method v3_2 = v1;
    label_38:
        e.b = v2_1;
        e.a = ((Class)v3_2);
        e.c = v1;
        e.d = v0_2;
    }

    e() {
        super();
    }

    public static boolean a() {
        if(e.c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }

        boolean v0 = e.c != null ? true : false;
        return v0;
    }

    private static Typeface a(Object arg5) {
        try {
            Object v0_2 = Array.newInstance(e.a, 1);
            Array.set(v0_2, 0, arg5);
            return e.d.invoke(null, v0_2);
        }
        catch(InvocationTargetException v0) {
        }
        catch(IllegalAccessException v0_1) {
        }

        throw new RuntimeException(((Throwable)v0));
    }

    private static boolean a(Object arg4, ByteBuffer arg5, int arg6, int arg7, boolean arg8) {
        try {
            return e.c.invoke(arg4, arg5, Integer.valueOf(arg6), null, Integer.valueOf(arg7), Boolean.valueOf(arg8)).booleanValue();
        }
        catch(InvocationTargetException v0) {
        }
        catch(IllegalAccessException v0_1) {
        }

        throw new RuntimeException(((Throwable)v0));
    }

    public Typeface a(Context arg9, CancellationSignal arg10, b[] arg11, int arg12) {
        Object v2 = e.b();
        k v3 = new k();
        int v4 = arg11.length;
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            b v5 = arg11[v1];
            Uri v6 = v5.a();
            Object v0 = v3.get(v6);
            if(v0 == null) {
                ByteBuffer v0_1 = h.a(arg9, arg10, v6);
                v3.put(v6, v0_1);
            }

            if(!e.a(v2, v0_1, v5.b(), v5.c(), v5.d())) {
                Typeface v0_2 = null;
                return v0_2;
            }
        }

        return e.a(v2);
    }

    public Typeface a(Context arg9, android.support.v4.b.a.a$b arg10, Resources arg11, int arg12) {
        Typeface v0_1;
        Object v2 = e.b();
        c[] v3 = arg10.a();
        int v4 = v3.length;
        int v0 = 0;
        while(true) {
            if(v0 >= v4) {
                break;
            }
            else if(!e.a(v2, h.a(arg9, arg11, v3[v0].d()), 0, v3[v0].b(), v3[v0].c())) {
                v0_1 = null;
            }
            else {
                ++v0;
                continue;
            }

            return v0_1;
        }

        return e.a(v2);
    }

    private static Object b() {
        try {
            return e.b.newInstance();
        }
        catch(InvocationTargetException v0) {
        }
        catch(InstantiationException v0_1) {
        }
        catch(IllegalAccessException v0_2) {
        }

        throw new RuntimeException(((Throwable)v0));
    }
}

