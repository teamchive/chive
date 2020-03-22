package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.Window;

public abstract class e {
    private static int a;
    private static boolean b;

    static {
        e.a = -1;
        e.b = false;
    }

    e() {
        super();
    }

    public abstract void a(Bundle arg1);

    public static e a(Dialog arg2, d arg3) {
        return e.a(arg2.getContext(), arg2.getWindow(), arg3);
    }

    public abstract View a(int arg1);

    public abstract void a(View arg1);

    public abstract void a(View arg1, ViewGroup$LayoutParams arg2);

    public abstract void a(CharSequence arg1);

    public abstract a a();

    public static e a(Activity arg1, d arg2) {
        return e.a(((Context)arg1), arg1.getWindow(), arg2);
    }

    public abstract void a(Configuration arg1);

    private static e a(Context arg2, Window arg3, d arg4) {
        j v0_1;
        if(Build$VERSION.SDK_INT >= 24) {
            g v0 = new g(arg2, arg3, arg4);
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            v0_1 = new j(arg2, arg3, arg4);
        }
        else if(Build$VERSION.SDK_INT >= 14) {
            i v0_2 = new i(arg2, arg3, arg4);
        }
        else if(Build$VERSION.SDK_INT >= 11) {
            h v0_3 = new h(arg2, arg3, arg4);
        }
        else {
            k v0_4 = new k(arg2, arg3, arg4);
        }

        return ((e)v0_1);
    }

    public abstract void b(View arg1, ViewGroup$LayoutParams arg2);

    public abstract void b(int arg1);

    public abstract MenuInflater b();

    public abstract void b(Bundle arg1);

    public abstract boolean c(int arg1);

    public abstract void c(Bundle arg1);

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract boolean i();

    public static int j() {
        return e.a;
    }

    public static boolean k() {
        return e.b;
    }
}

