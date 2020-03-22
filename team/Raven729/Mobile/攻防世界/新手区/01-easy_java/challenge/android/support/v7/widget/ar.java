package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.c.a;
import android.util.TypedValue;

class ar {
    static final int[] a;
    static final int[] b;
    static final int[] c;
    static final int[] d;
    static final int[] e;
    static final int[] f;
    static final int[] g;
    static final int[] h;
    private static final ThreadLocal i;
    private static final int[] j;

    static {
        ar.i = new ThreadLocal();
        ar.a = new int[]{0xFEFEFF62};
        ar.b = new int[]{0x101009C};
        ar.c = new int[]{0x10102FE};
        ar.d = new int[]{0x10100A7};
        ar.e = new int[]{0x10100A0};
        ar.f = new int[]{0x10100A1};
        ar.g = new int[]{0xFEFEFF59, 0xFEFEFF64};
        ar.h = new int[0];
        ar.j = new int[1];
    }

    public static int a(Context arg3, int arg4) {
        int v1_1;
        ar.j[0] = arg4;
        aw v0 = aw.a(arg3, null, ar.j);
        try {
            v1_1 = v0.b(0, 0);
        }
        catch(Throwable v1) {
            v0.a();
            throw v1;
        }

        v0.a();
        return v1_1;
    }

    static int a(Context arg2, int arg3, float arg4) {
        int v0 = ar.a(arg2, arg3);
        return a.b(v0, Math.round((((float)Color.alpha(v0))) * arg4));
    }

    private static TypedValue a() {
        Object v0 = ar.i.get();
        if(v0 == null) {
            TypedValue v0_1 = new TypedValue();
            ar.i.set(v0_1);
        }

        return ((TypedValue)v0);
    }

    public static ColorStateList b(Context arg2, int arg3) {
        ColorStateList v1_1;
        ar.j[0] = arg3;
        aw v0 = aw.a(arg2, null, ar.j);
        try {
            v1_1 = v0.e(0);
        }
        catch(Throwable v1) {
            v0.a();
            throw v1;
        }

        v0.a();
        return v1_1;
    }

    public static int c(Context arg4, int arg5) {
        int v0_1;
        ColorStateList v0 = ar.b(arg4, arg5);
        if(v0 == null || !v0.isStateful()) {
            TypedValue v0_2 = ar.a();
            arg4.getTheme().resolveAttribute(0x1010033, v0_2, true);
            v0_1 = ar.a(arg4, arg5, v0_2.getFloat());
        }
        else {
            v0_1 = v0.getColorForState(ar.a, v0.getDefaultColor());
        }

        return v0_1;
    }
}

