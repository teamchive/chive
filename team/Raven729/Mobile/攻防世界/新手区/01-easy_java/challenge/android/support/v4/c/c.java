package android.support.v4.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build$VERSION;
import android.os.CancellationSignal;
import android.support.v4.f.b$b;
import android.support.v4.g.g;
import android.widget.TextView;

public class c {
    interface a {
        Typeface a(Context arg1, Resources arg2, int arg3, String arg4, int arg5);

        Typeface a(Context arg1, CancellationSignal arg2, b[] arg3, int arg4);

        Typeface a(Context arg1, android.support.v4.b.a.a$b arg2, Resources arg3, int arg4);
    }

    private static final a a;
    private static final g b;

    static {
        if(Build$VERSION.SDK_INT >= 26) {
            c.a = new f();
        }
        else {
            if(Build$VERSION.SDK_INT >= 24 && (e.a())) {
                c.a = new e();
                goto label_6;
            }

            if(Build$VERSION.SDK_INT >= 21) {
                c.a = new d();
                goto label_6;
            }

            c.a = new android.support.v4.c.g();
        }

    label_6:
        c.b = new g(16);
    }

    public static Typeface a(Resources arg2, int arg3, int arg4) {
        return c.b.a(c.b(arg2, arg3, arg4));
    }

    public static Typeface a(Context arg6, android.support.v4.b.a.a$a arg7, Resources arg8, int arg9, int arg10, TextView arg11) {
        Typeface v0 = (arg7 instanceof android.support.v4.b.a.a$d) ? android.support.v4.f.b.a(arg6, ((android.support.v4.b.a.a$d)arg7).a(), arg11, ((android.support.v4.b.a.a$d)arg7).b(), ((android.support.v4.b.a.a$d)arg7).c(), arg10) : c.a.a(arg6, ((android.support.v4.b.a.a$b)arg7), arg8, arg10);
        if(v0 != null) {
            c.b.a(c.b(arg8, arg9, arg10), v0);
        }

        return v0;
    }

    public static Typeface a(Context arg6, Resources arg7, int arg8, String arg9, int arg10) {
        Typeface v0 = c.a.a(arg6, arg7, arg8, arg9, arg10);
        if(v0 != null) {
            c.b.a(c.b(arg7, arg8, arg10), v0);
        }

        return v0;
    }

    public static Typeface a(Context arg1, CancellationSignal arg2, b[] arg3, int arg4) {
        return c.a.a(arg1, arg2, arg3, arg4);
    }

    private static String b(Resources arg2, int arg3, int arg4) {
        return arg2.getResourcePackageName(arg3) + "-" + arg3 + "-" + arg4;
    }
}

