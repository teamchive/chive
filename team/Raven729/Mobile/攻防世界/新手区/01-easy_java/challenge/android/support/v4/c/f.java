package android.support.v4.c;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface$Builder;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.b.a.a$c;
import android.support.v4.f.b$b;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

public class f extends d {
    private static final Class a;
    private static final Constructor b;
    private static final Method c;
    private static final Method d;
    private static final Method e;
    private static final Method f;
    private static final Method g;

    static {
        Method v1;
        Method v0_2;
        Method v2;
        Method v3;
        Method v4;
        Method v5;
        try {
            Class v7 = Class.forName("android.graphics.FontFamily");
            Constructor v6 = v7.getConstructor();
            v5 = v7.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
            v4 = v7.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
            v3 = v7.getMethod("freeze");
            v2 = v7.getMethod("abortCreation");
            v0_2 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(v7, 1).getClass(), Integer.TYPE, Integer.TYPE);
            v0_2.setAccessible(true);
            v1 = v2;
            v2 = v3;
            v3 = v4;
            v4 = v5;
            Constructor v5_1 = v6;
            Class v6_1 = v7;
            goto label_85;
        }
        catch(NoSuchMethodException v0) {
        }
        catch(ClassNotFoundException v0_1) {
        }

        Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + v0.getClass().getName(), ((Throwable)v0));
        v0_2 = v1;
        v2 = v1;
        v3 = v1;
        v4 = v1;
        v5 = v1;
        Method v6_2 = v1;
    label_85:
        f.b = ((Constructor)v5);
        f.a = ((Class)v6_2);
        f.c = v4;
        f.d = v3;
        f.e = v2;
        f.f = v1;
        f.g = v0_2;
    }

    public f() {
        super();
    }

    private static Typeface a(Object arg5) {
        try {
            Object v0_2 = Array.newInstance(f.a, 1);
            Array.set(v0_2, 0, arg5);
            return f.g.invoke(null, v0_2, Integer.valueOf(-1), Integer.valueOf(-1));
        }
        catch(InvocationTargetException v0) {
        }
        catch(IllegalAccessException v0_1) {
        }

        throw new RuntimeException(((Throwable)v0_1));
    }

    private static boolean a() {
        if(f.c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }

        boolean v0 = f.c != null ? true : false;
        return v0;
    }

    private static boolean a(Context arg4, Object arg5, String arg6, int arg7, int arg8, int arg9) {
        try {
            return f.c.invoke(arg5, arg4.getAssets(), arg6, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(arg7), Integer.valueOf(arg8), Integer.valueOf(arg9), null).booleanValue();
        }
        catch(InvocationTargetException v0) {
        }
        catch(IllegalAccessException v0_1) {
        }

        throw new RuntimeException(((Throwable)v0_1));
    }

    private static boolean a(Object arg4, ByteBuffer arg5, int arg6, int arg7, int arg8) {
        try {
            return f.d.invoke(arg4, arg5, Integer.valueOf(arg6), null, Integer.valueOf(arg7), Integer.valueOf(arg8)).booleanValue();
        }
        catch(InvocationTargetException v0) {
        }
        catch(IllegalAccessException v0_1) {
        }

        throw new RuntimeException(((Throwable)v0_1));
    }

    public Typeface a(Context arg8, Resources arg9, int arg10, String arg11, int arg12) {
        Typeface v0;
        Typeface v6 = null;
        int v4 = -1;
        if(!f.a()) {
            v0 = super.a(arg8, arg9, arg10, arg11, arg12);
        }
        else {
            Object v1 = f.b();
            if(!f.a(arg8, v1, arg11, 0, v4, v4)) {
                f.c(v1);
                v0 = v6;
            }
            else if(!f.b(v1)) {
                v0 = v6;
            }
            else {
                v0 = f.a(v1);
            }
        }

        return v0;
    }

    public Typeface a(Context arg11, CancellationSignal arg12, b[] arg13, int arg14) {
        int v0_5;
        Throwable v1_1;
        ParcelFileDescriptor v2;
        Typeface v0;
        if(arg13.length < 1) {
            v0 = null;
            return v0;
        }

        if(!f.a()) {
            b v0_1 = this.a(arg13, arg14);
            ContentResolver v1 = arg11.getContentResolver();
            try {
                v2 = v1.openFileDescriptor(v0_1.a(), "r", arg12);
                v1_1 = null;
            }
            catch(IOException v0_2) {
                return null;
            }

            try {
                v0 = new Typeface$Builder(v2.getFileDescriptor()).setWeight(v0_1.c()).setItalic(v0_1.d()).build();
                if(v2 == null) {
                    return v0;
                }

                goto label_22;
            }
            catch(Throwable v0_3) {
            }
            catch(Throwable v0_3) {
                try {
                    throw v0_3;
                }
                catch(Throwable v1_1) {
                    Throwable v9 = v1_1;
                    v1_1 = v0_3;
                    v0_3 = v9;
                }
            }

            if(v2 == null) {
                goto label_42;
            }

            if(v1_1 == null) {
                goto label_46;
            }

            try {
                v2.close();
                goto label_42;
            }
            catch(IOException v0_2) {
            }
            catch(Throwable v2_1) {
                try {
                    v1_1.addSuppressed(v2_1);
                    goto label_42;
                label_46:
                    v2.close();
                label_42:
                    throw v0_3;
                }
                catch(IOException v0_2) {
                    return null;
                }

            label_22:
                if(0 == 0) {
                    goto label_31;
                }

                try {
                    v2.close();
                    return v0;
                }
                catch(IOException v0_2) {
                }
                catch(Throwable v2_1) {
                    try {
                        v1_1.addSuppressed(v2_1);
                        return v0;
                    label_31:
                        v2.close();
                        return v0;
                    }
                    catch(IOException v0_2) {
                        return null;
                    }
                }
            }
        }

        Map v3 = android.support.v4.f.b.a(arg11, arg13, arg12);
        Object v4 = f.b();
        int v1_2 = 0;
        int v5 = arg13.length;
        int v2_2 = 0;
        while(v2_2 < v5) {
            b v6 = arg13[v2_2];
            Object v0_4 = v3.get(v6.a());
            if(v0_4 == null) {
                v0_5 = v1_2;
            }
            else {
                int v7 = v6.b();
                int v8 = v6.c();
                v1_2 = v6.d() ? 1 : 0;
                if(!f.a(v4, ((ByteBuffer)v0_4), v7, v8, v1_2)) {
                    f.c(v4);
                    return null;
                }

                v0_5 = 1;
            }

            ++v2_2;
            v1_2 = v0_5;
        }

        if(v1_2 == 0) {
            f.c(v4);
            return null;
        }

        return !f.b(v4) ? null : f.a(v4);
    }

    public Typeface a(Context arg11, android.support.v4.b.a.a$b arg12, Resources arg13, int arg14) {
        Typeface v0;
        Typeface v6 = null;
        if(!f.a()) {
            v0 = super.a(arg11, arg12, arg13, arg14);
        }
        else {
            Object v1 = f.b();
            c[] v8 = arg12.a();
            int v9 = v8.length;
            int v7;
            for(v7 = 0; v7 < v9; ++v7) {
                c v0_1 = v8[v7];
                String v2 = v0_1.a();
                int v4 = v0_1.b();
                int v5 = v0_1.c() ? 1 : 0;
                if(!f.a(arg11, v1, v2, 0, v4, v5)) {
                    f.c(v1);
                    return v6;
                }
            }

            if(!f.b(v1)) {
                return v6;
            }

            v0 = f.a(v1);
        }

        return v0;
    }

    private static Object b() {
        try {
            return f.b.newInstance();
        }
        catch(InvocationTargetException v0) {
        }
        catch(InstantiationException v0_1) {
        }
        catch(IllegalAccessException v0_2) {
        }

        throw new RuntimeException(((Throwable)v0_2));
    }

    private static boolean b(Object arg2) {
        try {
            return f.e.invoke(arg2).booleanValue();
        }
        catch(InvocationTargetException v0) {
        }
        catch(IllegalAccessException v0_1) {
        }

        throw new RuntimeException(((Throwable)v0_1));
    }

    private static boolean c(Object arg2) {
        try {
            return f.f.invoke(arg2).booleanValue();
        }
        catch(InvocationTargetException v0) {
        }
        catch(IllegalAccessException v0_1) {
        }

        throw new RuntimeException(((Throwable)v0_1));
    }
}

