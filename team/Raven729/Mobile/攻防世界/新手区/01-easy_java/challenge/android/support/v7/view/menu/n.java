package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.support.v4.h.d;
import android.support.v4.h.p;
import android.view.Display;
import android.view.View;
import android.widget.PopupWindow$OnDismissListener;

public class n {
    class android.support.v7.view.menu.n$1 implements PopupWindow$OnDismissListener {
        android.support.v7.view.menu.n$1(n arg1) {
            this.a = arg1;
            super();
        }

        public void onDismiss() {
            this.a.e();
        }
    }

    private final Context a;
    private final h b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private a i;
    private m j;
    private PopupWindow$OnDismissListener k;
    private final PopupWindow$OnDismissListener l;

    public n(Context arg8, h arg9, View arg10, boolean arg11, int arg12) {
        this(arg8, arg9, arg10, arg11, arg12, 0);
    }

    public n(Context arg2, h arg3, View arg4, boolean arg5, int arg6, int arg7) {
        super();
        this.g = 0x800003;
        this.l = new android.support.v7.view.menu.n$1(this);
        this.a = arg2;
        this.b = arg3;
        this.f = arg4;
        this.c = arg5;
        this.d = arg6;
        this.e = arg7;
    }

    private void a(int arg7, int arg8, boolean arg9, boolean arg10) {
        m v0 = this.b();
        v0.c(arg10);
        if(arg9) {
            if((d.a(this.g, p.b(this.f)) & 7) == 5) {
                arg7 += this.f.getWidth();
            }

            v0.b(arg7);
            v0.c(arg8);
            int v1 = ((int)(this.a.getResources().getDisplayMetrics().density * 48f / 2f));
            v0.a(new Rect(arg7 - v1, arg8 - v1, arg7 + v1, v1 + arg8));
        }

        v0.a();
    }

    public void a() {
        if(!this.c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void a(int arg1) {
        this.g = arg1;
    }

    public void a(a arg2) {
        this.i = arg2;
        if(this.j != null) {
            this.j.a(arg2);
        }
    }

    public void a(View arg1) {
        this.f = arg1;
    }

    public void a(PopupWindow$OnDismissListener arg1) {
        this.k = arg1;
    }

    public void a(boolean arg2) {
        this.h = arg2;
        if(this.j != null) {
            this.j.a(arg2);
        }
    }

    public boolean a(int arg3, int arg4) {
        boolean v0 = true;
        if(!this.f()) {
            if(this.f == null) {
                v0 = false;
            }
            else {
                this.a(arg3, arg4, true, true);
            }
        }

        return v0;
    }

    public m b() {
        if(this.j == null) {
            this.j = this.g();
        }

        return this.j;
    }

    public boolean c() {
        boolean v0 = true;
        if(!this.f()) {
            if(this.f == null) {
                v0 = false;
            }
            else {
                this.a(0, 0, false, false);
            }
        }

        return v0;
    }

    public void d() {
        if(this.f()) {
            this.j.c();
        }
    }

    protected void e() {
        this.j = null;
        if(this.k != null) {
            this.k.onDismiss();
        }
    }

    public boolean f() {
        boolean v0 = this.j == null || !this.j.d() ? false : true;
        return v0;
    }

    private m g() {
        e v0_2;
        Display v0 = this.a.getSystemService("window").getDefaultDisplay();
        Point v1 = new Point();
        if(Build$VERSION.SDK_INT >= 17) {
            v0.getRealSize(v1);
        }
        else {
            v0.getSize(v1);
        }

        int v0_1 = Math.min(v1.x, v1.y) >= this.a.getResources().getDimensionPixelSize(android.support.v7.a.a$d.abc_cascading_menus_min_smallest_width) ? 1 : 0;
        if(v0_1 != 0) {
            v0_2 = new e(this.a, this.f, this.d, this.e, this.c);
        }
        else {
            t v0_3 = new t(this.a, this.b, this.f, this.d, this.e, this.c);
        }

        ((m)v0_2).a(this.b);
        ((m)v0_2).a(this.l);
        ((m)v0_2).a(this.f);
        ((m)v0_2).a(this.i);
        ((m)v0_2).a(this.h);
        ((m)v0_2).a(this.g);
        return ((m)v0_2);
    }
}

