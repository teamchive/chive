package android.support.v4.c;

import android.graphics.Color;

public final class a {
    private static final ThreadLocal a;

    static {
        a.a = new ThreadLocal();
    }

    public static int a(int arg7, int arg8) {
        int v0 = Color.alpha(arg8);
        int v1 = Color.alpha(arg7);
        int v2 = a.c(v1, v0);
        return Color.argb(v2, a.a(Color.red(arg7), v1, Color.red(arg8), v0, v2), a.a(Color.green(arg7), v1, Color.green(arg8), v0, v2), a.a(Color.blue(arg7), v1, Color.blue(arg8), v0, v2));
    }

    private static int a(int arg3, int arg4, int arg5, int arg6, int arg7) {
        int v0 = arg7 == 0 ? 0 : (arg3 * 0xFF * arg4 + arg5 * arg6 * (0xFF - arg4)) / (arg7 * 0xFF);
        return v0;
    }

    public static int b(int arg2, int arg3) {
        if(arg3 >= 0 && arg3 <= 0xFF) {
            return 0xFFFFFF & arg2 | arg3 << 24;
        }

        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static int c(int arg2, int arg3) {
        return 0xFF - (0xFF - arg3) * (0xFF - arg2) / 0xFF;
    }
}

