package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class a {
    class android.support.v4.c.a.a$a extends e {
        private static Method a;
        private static boolean b;
        private static Method c;
        private static boolean d;

        android.support.v4.c.a.a$a() {
            super();
        }

        public int a(Drawable arg6) {
            if(!android.support.v4.c.a.a$a.d) {
                try {
                    android.support.v4.c.a.a$a.c = Drawable.class.getDeclaredMethod("getLayoutDirection");
                    android.support.v4.c.a.a$a.c.setAccessible(true);
                }
                catch(NoSuchMethodException v0) {
                    Log.i("DrawableCompatApi17", "Failed to retrieve getLayoutDirection() method", ((Throwable)v0));
                }

                android.support.v4.c.a.a$a.d = true;
            }

            if(android.support.v4.c.a.a$a.c != null) {
                try {
                    int v0_2 = android.support.v4.c.a.a$a.c.invoke(arg6).intValue();
                    return v0_2;
                }
                catch(Exception v0_1) {
                    Log.i("DrawableCompatApi17", "Failed to invoke getLayoutDirection() via reflection", ((Throwable)v0_1));
                    android.support.v4.c.a.a$a.c = null;
                }
            }

            return 0;
        }

        public boolean a(Drawable arg8, int arg9) {
            boolean v0 = true;
            if(!android.support.v4.c.a.a$a.b) {
                try {
                    android.support.v4.c.a.a$a.a = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    android.support.v4.c.a.a$a.a.setAccessible(true);
                }
                catch(NoSuchMethodException v2) {
                    Log.i("DrawableCompatApi17", "Failed to retrieve setLayoutDirection(int) method", ((Throwable)v2));
                }

                android.support.v4.c.a.a$a.b = true;
            }

            if(android.support.v4.c.a.a$a.a != null) {
                try {
                    android.support.v4.c.a.a$a.a.invoke(arg8, Integer.valueOf(arg9));
                    return v0;
                }
                catch(Exception v0_1) {
                    Log.i("DrawableCompatApi17", "Failed to invoke setLayoutDirection(int) via reflection", ((Throwable)v0_1));
                    android.support.v4.c.a.a$a.a = null;
                }
            }

            return false;
        }
    }

    class b extends android.support.v4.c.a.a$a {
        b() {
            super();
        }

        public void a(Drawable arg1, boolean arg2) {
            arg1.setAutoMirrored(arg2);
        }

        public boolean b(Drawable arg2) {
            return arg2.isAutoMirrored();
        }

        public Drawable c(Drawable arg2) {
            d v2;
            if(!(arg2 instanceof f)) {
                v2 = new d(arg2);
            }

            return ((Drawable)v2);
        }

        public int d(Drawable arg2) {
            return arg2.getAlpha();
        }
    }

    class c extends b {
        c() {
            super();
        }

        public void a(Drawable arg1, float arg2, float arg3) {
            arg1.setHotspot(arg2, arg3);
        }

        public void a(Drawable arg1, int arg2, int arg3, int arg4, int arg5) {
            arg1.setHotspotBounds(arg2, arg3, arg4, arg5);
        }

        public void a(Drawable arg1, ColorStateList arg2) {
            arg1.setTintList(arg2);
        }

        public void a(Drawable arg1, Resources$Theme arg2) {
            arg1.applyTheme(arg2);
        }

        public void a(Drawable arg1, Resources arg2, XmlPullParser arg3, AttributeSet arg4, Resources$Theme arg5) {
            arg1.inflate(arg2, arg3, arg4, arg5);
        }

        public void a(Drawable arg1, PorterDuff$Mode arg2) {
            arg1.setTintMode(arg2);
        }

        public void b(Drawable arg1, int arg2) {
            arg1.setTint(arg2);
        }

        public Drawable c(Drawable arg2) {
            android.support.v4.c.a.e v2;
            if(!(arg2 instanceof f)) {
                v2 = new android.support.v4.c.a.e(arg2);
            }

            return ((Drawable)v2);
        }

        public boolean e(Drawable arg2) {
            return arg2.canApplyTheme();
        }

        public ColorFilter f(Drawable arg2) {
            return arg2.getColorFilter();
        }
    }

    class android.support.v4.c.a.a$d extends c {
        android.support.v4.c.a.a$d() {
            super();
        }

        public int a(Drawable arg2) {
            return arg2.getLayoutDirection();
        }

        public boolean a(Drawable arg2, int arg3) {
            return arg2.setLayoutDirection(arg3);
        }

        public Drawable c(Drawable arg1) {
            return arg1;
        }
    }

    class e {
        e() {
            super();
        }

        public void a(Drawable arg1, float arg2, float arg3) {
        }

        public void a(Drawable arg1, int arg2, int arg3, int arg4, int arg5) {
        }

        public void a(Drawable arg2, ColorStateList arg3) {
            if((arg2 instanceof f)) {
                ((f)arg2).setTintList(arg3);
            }
        }

        public void a(Drawable arg1, Resources$Theme arg2) {
        }

        public void a(Drawable arg1, Resources arg2, XmlPullParser arg3, AttributeSet arg4, Resources$Theme arg5) {
            arg1.inflate(arg2, arg3, arg4);
        }

        public void a(Drawable arg2, PorterDuff$Mode arg3) {
            if((arg2 instanceof f)) {
                ((f)arg2).setTintMode(arg3);
            }
        }

        public void a(Drawable arg1, boolean arg2) {
        }

        public boolean a(Drawable arg2, int arg3) {
            return 0;
        }

        public int a(Drawable arg2) {
            return 0;
        }

        public void b(Drawable arg2, int arg3) {
            if((arg2 instanceof f)) {
                ((f)arg2).setTint(arg3);
            }
        }

        public boolean b(Drawable arg2) {
            return 0;
        }

        public Drawable c(Drawable arg2) {
            android.support.v4.c.a.c v2;
            if(!(arg2 instanceof f)) {
                v2 = new android.support.v4.c.a.c(arg2);
            }

            return ((Drawable)v2);
        }

        public int d(Drawable arg2) {
            return 0;
        }

        public boolean e(Drawable arg2) {
            return 0;
        }

        public ColorFilter f(Drawable arg2) {
            return null;
        }

        public void g(Drawable arg1) {
            arg1.jumpToCurrentState();
        }
    }

    static final e a;

    static {
        if(Build$VERSION.SDK_INT >= 23) {
            a.a = new android.support.v4.c.a.a$d();
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            a.a = new c();
        }
        else if(Build$VERSION.SDK_INT >= 19) {
            a.a = new b();
        }
        else if(Build$VERSION.SDK_INT >= 17) {
            a.a = new android.support.v4.c.a.a$a();
        }
        else {
            a.a = new e();
        }
    }

    public static void a(Drawable arg1, Resources$Theme arg2) {
        a.a.a(arg1, arg2);
    }

    public static void a(Drawable arg1) {
        a.a.g(arg1);
    }

    public static void a(Drawable arg1, float arg2, float arg3) {
        a.a.a(arg1, arg2, arg3);
    }

    public static void a(Drawable arg6, int arg7, int arg8, int arg9, int arg10) {
        a.a.a(arg6, arg7, arg8, arg9, arg10);
    }

    public static void a(Drawable arg6, Resources arg7, XmlPullParser arg8, AttributeSet arg9, Resources$Theme arg10) {
        a.a.a(arg6, arg7, arg8, arg9, arg10);
    }

    public static void a(Drawable arg1, boolean arg2) {
        a.a.a(arg1, arg2);
    }

    public static void a(Drawable arg1, int arg2) {
        a.a.b(arg1, arg2);
    }

    public static void a(Drawable arg1, ColorStateList arg2) {
        a.a.a(arg1, arg2);
    }

    public static void a(Drawable arg1, PorterDuff$Mode arg2) {
        a.a.a(arg1, arg2);
    }

    public static boolean b(Drawable arg1) {
        return a.a.b(arg1);
    }

    public static boolean b(Drawable arg1, int arg2) {
        return a.a.a(arg1, arg2);
    }

    public static int c(Drawable arg1) {
        return a.a.d(arg1);
    }

    public static boolean d(Drawable arg1) {
        return a.a.e(arg1);
    }

    public static ColorFilter e(Drawable arg1) {
        return a.a.f(arg1);
    }

    public static Drawable f(Drawable arg1) {
        return a.a.c(arg1);
    }

    public static int g(Drawable arg1) {
        return a.a.a(arg1);
    }
}

