package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.widget.aw;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window$Callback;
import android.view.Window;

abstract class f extends e {
    final class android.support.v7.app.f$1 implements Thread$UncaughtExceptionHandler {
        android.support.v7.app.f$1(Thread$UncaughtExceptionHandler arg1) {
            this.a = arg1;
            super();
        }

        private boolean a(Throwable arg4) {
            boolean v0 = false;
            if((arg4 instanceof Resources$NotFoundException)) {
                String v1 = arg4.getMessage();
                if(v1 != null) {
                    if(!v1.contains("drawable") && !v1.contains("Drawable")) {
                        return v0;
                    }

                    v0 = true;
                }
            }

            return v0;
        }

        public void uncaughtException(Thread arg4, Throwable arg5) {
            if(this.a(arg5)) {
                Resources$NotFoundException v0 = new Resources$NotFoundException(arg5.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                ((Throwable)v0).initCause(arg5.getCause());
                ((Throwable)v0).setStackTrace(arg5.getStackTrace());
                this.a.uncaughtException(arg4, ((Throwable)v0));
            }
            else {
                this.a.uncaughtException(arg4, arg5);
            }
        }
    }

    class a extends i {
        a(f arg1, Window$Callback arg2) {
            this.a = arg1;
            super(arg2);
        }

        public boolean dispatchKeyEvent(KeyEvent arg2) {
            boolean v0 = (this.a.a(arg2)) || (super.dispatchKeyEvent(arg2)) ? true : false;
            return v0;
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent arg3) {
            boolean v0 = (super.dispatchKeyShortcutEvent(arg3)) || (this.a.a(arg3.getKeyCode(), arg3)) ? true : false;
            return v0;
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int arg2, Menu arg3) {
            boolean v0 = arg2 != 0 || ((arg3 instanceof h)) ? super.onCreatePanelMenu(arg2, arg3) : false;
            return v0;
        }

        public boolean onMenuOpened(int arg2, Menu arg3) {
            super.onMenuOpened(arg2, arg3);
            this.a.b(arg2, arg3);
            return 1;
        }

        public void onPanelClosed(int arg2, Menu arg3) {
            super.onPanelClosed(arg2, arg3);
            this.a.a(arg2, arg3);
        }

        public boolean onPreparePanel(int arg4, View arg5, Menu arg6) {
            boolean v0;
            Menu v2 = (arg6 instanceof h) ? arg6 : null;
            if(arg4 != 0 || v2 != null) {
                if(v2 != null) {
                    ((h)v2).c(true);
                }

                v0 = super.onPreparePanel(arg4, arg5, arg6);
                if(v2 == null) {
                    return v0;
                }

                ((h)v2).c(false);
            }
            else {
                v0 = false;
            }

            return v0;
        }
    }

    final Context a;
    final Window b;
    final Window$Callback c;
    final Window$Callback d;
    final d e;
    android.support.v7.app.a f;
    MenuInflater g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    private static boolean m;
    private static final boolean n;
    private static final int[] o;
    private CharSequence p;
    private boolean q;
    private boolean r;

    static {
        boolean v0 = Build$VERSION.SDK_INT < 21 ? true : false;
        f.n = v0;
        if((f.n) && !f.m) {
            Thread.setDefaultUncaughtExceptionHandler(new android.support.v7.app.f$1(Thread.getDefaultUncaughtExceptionHandler()));
            f.m = true;
        }

        f.o = new int[]{0x1010054};
    }

    f(Context arg4, Window arg5, d arg6) {
        super();
        this.a = arg4;
        this.b = arg5;
        this.e = arg6;
        this.c = this.b.getCallback();
        if((this.c instanceof a)) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }

        this.d = this.a(this.c);
        this.b.setCallback(this.d);
        aw v0 = aw.a(arg4, null, f.o);
        Drawable v1 = v0.b(0);
        if(v1 != null) {
            this.b.setBackgroundDrawable(v1);
        }

        v0.a();
    }

    Window$Callback a(Window$Callback arg2) {
        return new a(this, arg2);
    }

    public android.support.v7.app.a a() {
        this.l();
        return this.f;
    }

    abstract b a(android.support.v7.view.b$a arg1);

    abstract void a(int arg1, Menu arg2);

    public final void a(CharSequence arg1) {
        this.p = arg1;
        this.b(arg1);
    }

    abstract boolean a(int arg1, KeyEvent arg2);

    abstract boolean a(KeyEvent arg1);

    abstract void b(CharSequence arg1);

    public MenuInflater b() {
        if(this.g == null) {
            this.l();
            Context v0 = this.f != null ? this.f.b() : this.a;
            this.g = new g(v0);
        }

        return this.g;
    }

    abstract boolean b(int arg1, Menu arg2);

    public void c() {
        this.q = true;
    }

    public void c(Bundle arg1) {
    }

    public void d() {
        this.q = false;
    }

    public void g() {
        this.r = true;
    }

    public boolean i() {
        return 0;
    }

    abstract void l();

    final android.support.v7.app.a m() {
        return this.f;
    }

    final Context n() {
        Context v0 = null;
        android.support.v7.app.a v1 = this.a();
        if(v1 != null) {
            v0 = v1.b();
        }

        if(v0 == null) {
            v0 = this.a;
        }

        return v0;
    }

    public boolean o() {
        return 0;
    }

    final boolean p() {
        return this.r;
    }

    final Window$Callback q() {
        return this.b.getCallback();
    }

    final CharSequence r() {
        CharSequence v0 = (this.c instanceof Activity) ? this.c.getTitle() : this.p;
        return v0;
    }
}

