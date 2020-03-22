package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.h.p;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ad;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window$Callback;
import java.util.ArrayList;

class o extends a {
    final class android.support.v7.app.o$a implements android.support.v7.view.menu.o$a {
        private boolean b;

        android.support.v7.app.o$a(o arg1) {
            this.a = arg1;
            super();
        }

        public void a(h arg3, boolean arg4) {
            if(!this.b) {
                this.b = true;
                this.a.a.n();
                if(this.a.b != null) {
                    this.a.b.onPanelClosed(108, ((Menu)arg3));
                }

                this.b = false;
            }
        }

        public boolean a(h arg3) {
            boolean v0;
            if(this.a.b != null) {
                this.a.b.onMenuOpened(108, ((Menu)arg3));
                v0 = true;
            }
            else {
                v0 = false;
            }

            return v0;
        }
    }

    final class b implements android.support.v7.view.menu.h$a {
        b(o arg1) {
            this.a = arg1;
            super();
        }

        public void a(h arg5) {
            int v3 = 108;
            if(this.a.b != null) {
                if(this.a.a.i()) {
                    this.a.b.onPanelClosed(v3, ((Menu)arg5));
                }
                else if(this.a.b.onPreparePanel(0, null, ((Menu)arg5))) {
                    this.a.b.onMenuOpened(v3, ((Menu)arg5));
                }
            }
        }

        public boolean a(h arg2, MenuItem arg3) {
            return 0;
        }
    }

    ad a;
    Window$Callback b;
    private boolean c;
    private boolean d;
    private ArrayList e;
    private final Runnable f;

    public int a() {
        return this.a.o();
    }

    public void a(float arg2) {
        p.a(this.a.a(), arg2);
    }

    public void a(Configuration arg1) {
        super.a(arg1);
    }

    public void a(CharSequence arg2) {
        this.a.a(arg2);
    }

    public void a(boolean arg1) {
    }

    public boolean a(int arg5, KeyEvent arg6) {
        boolean v2 = false;
        Menu v3 = this.h();
        if(v3 != null) {
            int v0 = arg6 != null ? arg6.getDeviceId() : -1;
            boolean v0_1 = KeyCharacterMap.load(v0).getKeyboardType() != 1 ? true : false;
            v3.setQwertyMode(v0_1);
            v2 = v3.performShortcut(arg5, arg6, 0);
        }

        return v2;
    }

    public boolean a(KeyEvent arg3) {
        if(arg3.getAction() == 1) {
            this.c();
        }

        return 1;
    }

    public Context b() {
        return this.a.b();
    }

    public boolean c() {
        return this.a.k();
    }

    public void c(boolean arg1) {
    }

    public void d(boolean arg1) {
    }

    public boolean d() {
        return this.a.l();
    }

    public void e(boolean arg4) {
        if(arg4 != this.d) {
            this.d = arg4;
            int v2 = this.e.size();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                this.e.get(v1).a(arg4);
            }
        }
    }

    public boolean e() {
        this.a.a().removeCallbacks(this.f);
        p.a(this.a.a(), this.f);
        return 1;
    }

    public boolean f() {
        boolean v0;
        if(this.a.c()) {
            this.a.d();
            v0 = true;
        }
        else {
            v0 = false;
        }

        return v0;
    }

    void g() {
        this.a.a().removeCallbacks(this.f);
    }

    private Menu h() {
        if(!this.c) {
            this.a.a(new android.support.v7.app.o$a(this), new b(this));
            this.c = true;
        }

        return this.a.q();
    }
}

