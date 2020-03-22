package android.support.v4.h;

import android.os.Build$VERSION;
import android.util.Log;
import android.view.LayoutInflater$Factory2;
import android.view.LayoutInflater$Factory;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

public final class e {
    class a extends b {
        a() {
            super();
        }

        public void a(LayoutInflater arg1, LayoutInflater$Factory2 arg2) {
            arg1.setFactory2(arg2);
        }
    }

    class b {
        b() {
            super();
        }

        public void a(LayoutInflater arg3, LayoutInflater$Factory2 arg4) {
            arg3.setFactory2(arg4);
            LayoutInflater$Factory v0 = arg3.getFactory();
            if((v0 instanceof LayoutInflater$Factory2)) {
                e.a(arg3, ((LayoutInflater$Factory2)v0));
            }
            else {
                e.a(arg3, arg4);
            }
        }
    }

    static final b a;
    private static Field b;
    private static boolean c;

    static {
        e.a = Build$VERSION.SDK_INT >= 21 ? new a() : new b();
    }

    static void a(LayoutInflater arg5, LayoutInflater$Factory2 arg6) {
        if(!e.c) {
            try {
                e.b = LayoutInflater.class.getDeclaredField("mFactory2");
                e.b.setAccessible(true);
            }
            catch(NoSuchFieldException v0) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field \'mFactory2\' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", ((Throwable)v0));
            }

            e.c = true;
        }

        if(e.b != null) {
            try {
                e.b.set(arg5, arg6);
            }
            catch(IllegalAccessException v0_1) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + arg5 + "; inflation may have unexpected results.", ((Throwable)v0_1));
            }
        }
    }

    public static void b(LayoutInflater arg1, LayoutInflater$Factory2 arg2) {
        e.a.a(arg1, arg2);
    }
}

