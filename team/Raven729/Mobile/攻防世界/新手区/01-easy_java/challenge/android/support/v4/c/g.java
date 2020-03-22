package android.support.v4.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.v4.b.a.a$b;
import android.support.v4.b.a.a$c;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class g implements a {
    interface android.support.v4.c.g$a {
        boolean a(Object arg1);

        int b(Object arg1);
    }

    g() {
        super();
    }

    private c a(b arg3, int arg4) {
        return g.a(arg3.a(), arg4, new android.support.v4.c.g$a() {
            public int a(c arg2) {
                return arg2.b();
            }

            public boolean a(Object arg2) {
                return this.b(((c)arg2));
            }

            public boolean b(c arg2) {
                return arg2.c();
            }

            public int b(Object arg2) {
                return this.a(((c)arg2));
            }
        });
    }

    private static Object a(Object[] arg11, int arg12, android.support.v4.c.g$a arg13) {
        Object v4_1;
        int v8 = (arg12 & 1) == 0 ? 400 : 700;
        boolean v0 = (arg12 & 2) != 0 ? true : false;
        Object v5 = null;
        int v3 = 0x7FFFFFFF;
        int v9 = arg11.length;
        int v7 = 0;
        while(v7 < v9) {
            Object v6 = arg11[v7];
            int v10 = Math.abs(arg13.b(v6) - v8) * 2;
            int v4 = arg13.a(v6) == v0 ? 0 : 1;
            v4 += v10;
            if(v5 == null || v3 > v4) {
                v3 = v4;
                v4_1 = v6;
            }
            else {
                v4_1 = v5;
            }

            ++v7;
            v5 = v4_1;
        }

        return v5;
    }

    public Typeface a(Context arg4, Resources arg5, int arg6, String arg7, int arg8) {
        Typeface v0 = null;
        File v1 = h.a(arg4);
        if(v1 == null) {
            return v0;
        }

        try {
            if(h.a(v1, arg5, arg6)) {
                goto label_8;
            }
        }
        catch(RuntimeException v2) {
            goto label_13;
        }
        catch(Throwable v0_1) {
            goto label_16;
        }

        v1.delete();
        return v0;
        try {
        label_8:
            v0 = Typeface.createFromFile(v1.getPath());
        }
        catch(Throwable v0_1) {
        label_16:
            v1.delete();
            throw v0_1;
        }
        catch(RuntimeException v2) {
        label_13:
            v1.delete();
            return v0;
        }

        v1.delete();
        return v0;
    }

    public Typeface a(Context arg5, CancellationSignal arg6, android.support.v4.f.b$b[] arg7, int arg8) {
        Closeable v1_4;
        Throwable v0_1;
        InputStream v1_3;
        Typeface v0 = null;
        if(arg7.length < 1) {
            return v0;
        }

        android.support.v4.f.b$b v1 = this.a(arg7, arg8);
        try {
            v1_3 = arg5.getContentResolver().openInputStream(v1.a());
        }
        catch(Throwable v1_1) {
            Throwable v3 = v1_1;
            v1_4 = ((Closeable)v0);
            v0_1 = v3;
            goto label_20;
        }
        catch(IOException v1_2) {
            v1_4 = ((Closeable)v0);
            goto label_14;
        }

        try {
            v0 = this.a(arg5, v1_3);
            goto label_10;
        }
        catch(Throwable v0_1) {
        }
        catch(IOException v2) {
        label_14:
            h.a(v1_4);
            return v0;
        }

    label_20:
        h.a(v1_4);
        throw v0_1;
    label_10:
        h.a(((Closeable)v1_3));
        return v0;
    }

    protected android.support.v4.f.b$b a(android.support.v4.f.b$b[] arg2, int arg3) {
        return g.a(((Object[])arg2), arg3, new android.support.v4.c.g$a() {
            public int a(android.support.v4.f.b$b arg2) {
                return arg2.c();
            }

            public boolean a(Object arg2) {
                return this.b(((android.support.v4.f.b$b)arg2));
            }

            public boolean b(android.support.v4.f.b$b arg2) {
                return arg2.d();
            }

            public int b(Object arg2) {
                return this.a(((android.support.v4.f.b$b)arg2));
            }
        });
    }

    protected Typeface a(Context arg4, InputStream arg5) {
        Typeface v0 = null;
        File v1 = h.a(arg4);
        if(v1 == null) {
            return v0;
        }

        try {
            if(h.a(v1, arg5)) {
                goto label_8;
            }
        }
        catch(RuntimeException v2) {
            goto label_13;
        }
        catch(Throwable v0_1) {
            goto label_16;
        }

        v1.delete();
        return v0;
        try {
        label_8:
            v0 = Typeface.createFromFile(v1.getPath());
        }
        catch(Throwable v0_1) {
        label_16:
            v1.delete();
            throw v0_1;
        }
        catch(RuntimeException v2) {
        label_13:
            v1.delete();
            return v0;
        }

        v1.delete();
        return v0;
    }

    public Typeface a(Context arg3, b arg4, Resources arg5, int arg6) {
        c v0 = this.a(arg4, arg6);
        Typeface v0_1 = v0 == null ? null : android.support.v4.c.c.a(arg3, arg5, v0.d(), v0.a(), arg6);
        return v0_1;
    }
}

