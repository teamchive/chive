package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.v4.h.p;
import android.support.v7.a.a$j;
import android.util.AttributeSet;
import android.view.View;

class g {
    private final View a;
    private final l b;
    private int c;
    private au d;
    private au e;
    private au f;

    g(View arg2) {
        super();
        this.c = -1;
        this.a = arg2;
        this.b = l.a();
    }

    void a(AttributeSet arg5, int arg6) {
        aw v1 = aw.a(this.a.getContext(), arg5, j.ViewBackgroundHelper, arg6, 0);
        try {
            if(v1.g(j.ViewBackgroundHelper_android_background)) {
                this.c = v1.g(j.ViewBackgroundHelper_android_background, -1);
                ColorStateList v0_1 = this.b.b(this.a.getContext(), this.c);
                if(v0_1 != null) {
                    this.b(v0_1);
                }
            }

            if(v1.g(j.ViewBackgroundHelper_backgroundTint)) {
                p.a(this.a, v1.e(j.ViewBackgroundHelper_backgroundTint));
            }

            if(v1.g(j.ViewBackgroundHelper_backgroundTintMode)) {
                p.a(this.a, ae.a(v1.a(j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        }
        catch(Throwable v0) {
            v1.a();
            throw v0;
        }

        v1.a();
    }

    ColorStateList a() {
        ColorStateList v0 = this.e != null ? this.e.a : null;
        return v0;
    }

    void a(Drawable arg2) {
        this.c = -1;
        this.b(null);
        this.c();
    }

    void a(int arg3) {
        this.c = arg3;
        ColorStateList v0 = this.b != null ? this.b.b(this.a.getContext(), arg3) : null;
        this.b(v0);
        this.c();
    }

    void a(ColorStateList arg3) {
        if(this.e == null) {
            this.e = new au();
        }

        this.e.a = arg3;
        this.e.d = true;
        this.c();
    }

    void a(PorterDuff$Mode arg3) {
        if(this.e == null) {
            this.e = new au();
        }

        this.e.b = arg3;
        this.e.c = true;
        this.c();
    }

    PorterDuff$Mode b() {
        PorterDuff$Mode v0 = this.e != null ? this.e.b : null;
        return v0;
    }

    private boolean b(Drawable arg4) {
        boolean v0 = true;
        if(this.f == null) {
            this.f = new au();
        }

        au v1 = this.f;
        v1.a();
        ColorStateList v2 = p.i(this.a);
        if(v2 != null) {
            v1.d = true;
            v1.a = v2;
        }

        PorterDuff$Mode v2_1 = p.j(this.a);
        if(v2_1 != null) {
            v1.c = true;
            v1.b = v2_1;
        }

        if((v1.d) || (v1.c)) {
            l.a(arg4, v1, this.a.getDrawableState());
        }
        else {
            v0 = false;
        }

        return v0;
    }

    void b(ColorStateList arg3) {
        if(arg3 != null) {
            if(this.d == null) {
                this.d = new au();
            }

            this.d.a = arg3;
            this.d.d = true;
        }
        else {
            this.d = null;
        }

        this.c();
    }

    void c() {
        Drawable v0 = this.a.getBackground();
        if(v0 != null && (!this.d() || !this.b(v0))) {
            if(this.e != null) {
                l.a(v0, this.e, this.a.getDrawableState());
                return;
            }

            if(this.d == null) {
                return;
            }

            l.a(v0, this.d, this.a.getDrawableState());
        }
    }

    private boolean d() {
        int v3 = 21;
        boolean v0 = true;
        int v2 = Build$VERSION.SDK_INT;
        if(v2 > v3) {
            if(this.d == null) {
                v0 = false;
            }
        }
        else if(v2 != v3) {
            v0 = false;
        }

        return v0;
    }
}

