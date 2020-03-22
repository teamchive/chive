package android.support.v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.support.v7.view.b;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode$Callback;
import android.view.ActionMode;
import android.view.Window$Callback;
import android.view.Window;

class i extends h {
    class a extends android.support.v7.app.f$a {
        a(i arg1, Window$Callback arg2) {
            this.c = arg1;
            super(((f)arg1), arg2);
        }

        final ActionMode a(ActionMode$Callback arg3) {
            android.support.v7.view.f$a v0 = new android.support.v7.view.f$a(this.c.a, arg3);
            b v1 = this.c.b(((android.support.v7.view.b$a)v0));
            ActionMode v0_1 = v1 != null ? v0.b(v1) : null;
            return v0_1;
        }

        public ActionMode onWindowStartingActionMode(ActionMode$Callback arg2) {
            ActionMode v0 = this.c.o() ? this.a(arg2) : super.onWindowStartingActionMode(arg2);
            return v0;
        }
    }

    final class android.support.v7.app.i$b {
        private q b;
        private boolean c;
        private BroadcastReceiver d;
        private IntentFilter e;

        android.support.v7.app.i$b(i arg2, q arg3) {
            this.a = arg2;
            super();
            this.b = arg3;
            this.c = arg3.a();
        }

        final int a() {
            this.c = this.b.a();
            int v0 = this.c ? 2 : 1;
            return v0;
        }

        final void b() {
            boolean v0 = this.b.a();
            if(v0 != this.c) {
                this.c = v0;
                this.a.i();
            }
        }

        final void c() {
            this.d();
            if(this.d == null) {
                this.d = new BroadcastReceiver() {
                    public void onReceive(Context arg2, Intent arg3) {
                        this.a.b();
                    }
                };
            }

            if(this.e == null) {
                this.e = new IntentFilter();
                this.e.addAction("android.intent.action.TIME_SET");
                this.e.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.e.addAction("android.intent.action.TIME_TICK");
            }

            this.a.a.registerReceiver(this.d, this.e);
        }

        final void d() {
            if(this.d != null) {
                this.a.a.unregisterReceiver(this.d);
                this.d = null;
            }
        }
    }

    private int t;
    private boolean u;
    private boolean v;
    private android.support.v7.app.i$b w;

    i(Context arg2, Window arg3, d arg4) {
        super(arg2, arg3, arg4);
        this.t = -100;
        this.v = true;
    }

    Window$Callback a(Window$Callback arg2) {
        return new a(this, arg2);
    }

    public void a(Bundle arg3) {
        int v1 = -100;
        super.a(arg3);
        if(arg3 != null && this.t == v1) {
            this.t = arg3.getInt("appcompat:local_night_mode", v1);
        }
    }

    public void c() {
        super.c();
        this.i();
    }

    public void c(Bundle arg3) {
        super.c(arg3);
        if(this.t != -100) {
            arg3.putInt("appcompat:local_night_mode", this.t);
        }
    }

    int d(int arg2) {
        switch(arg2) {
            case -100: {
                arg2 = -1;
                break;
            }
            case 0: {
                this.x();
                arg2 = this.w.a();
                break;
            }
        }

        return arg2;
    }

    public void d() {
        super.d();
        if(this.w != null) {
            this.w.d();
        }
    }

    public void g() {
        super.g();
        if(this.w != null) {
            this.w.d();
        }
    }

    private boolean h(int arg6) {
        boolean v0_1;
        Resources v1 = this.a.getResources();
        Configuration v2 = v1.getConfiguration();
        int v3 = v2.uiMode & 0x30;
        int v0 = arg6 == 2 ? 0x20 : 16;
        if(v3 != v0) {
            if(this.y()) {
                this.a.recreate();
            }
            else {
                Configuration v3_1 = new Configuration(v2);
                DisplayMetrics v2_1 = v1.getDisplayMetrics();
                v3_1.uiMode = v0 | v3_1.uiMode & -49;
                v1.updateConfiguration(v3_1, v2_1);
                if(Build$VERSION.SDK_INT < 26) {
                    n.a(v1);
                }
            }

            v0_1 = true;
        }
        else {
            v0_1 = false;
        }

        return v0_1;
    }

    public boolean i() {
        boolean v0 = false;
        int v1 = this.w();
        int v2 = this.d(v1);
        if(v2 != -1) {
            v0 = this.h(v2);
        }

        if(v1 == 0) {
            this.x();
            this.w.c();
        }

        this.u = true;
        return v0;
    }

    public boolean o() {
        return this.v;
    }

    private int w() {
        int v0 = this.t != -100 ? this.t : i.j();
        return v0;
    }

    private void x() {
        if(this.w == null) {
            this.w = new android.support.v7.app.i$b(this, q.a(this.a));
        }
    }

    private boolean y() {
        boolean v0 = true;
        if((this.u) && ((this.a instanceof Activity))) {
            PackageManager v2 = this.a.getPackageManager();
            try {
                if((v2.getActivityInfo(new ComponentName(this.a, this.a.getClass()), 0).configChanges & 0x200) != 0) {
                    goto label_20;
                }
            }
            catch(PackageManager$NameNotFoundException v1) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", ((Throwable)v1));
            }

            return v0;
        label_20:
            v0 = false;
        }
        else {
            v0 = false;
        }

        return v0;
    }
}

