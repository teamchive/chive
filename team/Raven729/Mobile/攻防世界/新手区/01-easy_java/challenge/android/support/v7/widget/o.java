package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build$VERSION;
import android.support.v4.widget.f;
import android.support.v7.a.a$j;
import android.support.v7.b.a.b;
import android.util.AttributeSet;
import android.widget.ImageView;

public class o {
    private final ImageView a;
    private au b;
    private au c;
    private au d;

    public o(ImageView arg1) {
        super();
        this.a = arg1;
    }

    public void a(AttributeSet arg6, int arg7) {
        int v4 = -1;
        aw v1 = aw.a(this.a.getContext(), arg6, j.AppCompatImageView, arg7, 0);
        try {
            Drawable v0_1 = this.a.getDrawable();
            if(v0_1 == null) {
                int v2 = v1.g(j.AppCompatImageView_srcCompat, -1);
                if(v2 != v4) {
                    v0_1 = b.b(this.a.getContext(), v2);
                    if(v0_1 != null) {
                        this.a.setImageDrawable(v0_1);
                    }
                }
            }

            if(v0_1 != null) {
                ae.a(v0_1);
            }

            if(v1.g(j.AppCompatImageView_tint)) {
                f.a(this.a, v1.e(j.AppCompatImageView_tint));
            }

            if(v1.g(j.AppCompatImageView_tintMode)) {
                f.a(this.a, ae.a(v1.a(j.AppCompatImageView_tintMode, -1), null));
            }
        }
        catch(Throwable v0) {
            v1.a();
            throw v0;
        }

        v1.a();
    }

    boolean a() {
        Drawable v0 = this.a.getBackground();
        boolean v0_1 = Build$VERSION.SDK_INT < 21 || !(v0 instanceof RippleDrawable) ? true : false;
        return v0_1;
    }

    public void a(int arg3) {
        if(arg3 != 0) {
            Drawable v0 = b.b(this.a.getContext(), arg3);
            if(v0 != null) {
                ae.a(v0);
            }

            this.a.setImageDrawable(v0);
        }
        else {
            this.a.setImageDrawable(null);
        }

        this.d();
    }

    void a(ColorStateList arg3) {
        if(this.c == null) {
            this.c = new au();
        }

        this.c.a = arg3;
        this.c.d = true;
        this.d();
    }

    void a(PorterDuff$Mode arg3) {
        if(this.c == null) {
            this.c = new au();
        }

        this.c.b = arg3;
        this.c.c = true;
        this.d();
    }

    private boolean a(Drawable arg4) {
        boolean v0 = true;
        if(this.d == null) {
            this.d = new au();
        }

        au v1 = this.d;
        v1.a();
        ColorStateList v2 = f.a(this.a);
        if(v2 != null) {
            v1.d = true;
            v1.a = v2;
        }

        PorterDuff$Mode v2_1 = f.b(this.a);
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

    ColorStateList b() {
        ColorStateList v0 = this.c != null ? this.c.a : null;
        return v0;
    }

    PorterDuff$Mode c() {
        PorterDuff$Mode v0 = this.c != null ? this.c.b : null;
        return v0;
    }

    void d() {
        Drawable v0 = this.a.getDrawable();
        if(v0 != null) {
            ae.a(v0);
        }

        if(v0 != null && (!this.e() || !this.a(v0))) {
            if(this.c != null) {
                l.a(v0, this.c, this.a.getDrawableState());
                return;
            }

            if(this.b == null) {
                return;
            }

            l.a(v0, this.b, this.a.getDrawableState());
        }
    }

    private boolean e() {
        int v3 = 21;
        boolean v0 = true;
        int v2 = Build$VERSION.SDK_INT;
        if(v2 > v3) {
            if(this.b == null) {
                v0 = false;
            }
        }
        else if(v2 != v3) {
            v0 = false;
        }

        return v0;
    }
}

