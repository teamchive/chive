package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.v4.c.a.a;
import android.support.v7.a.a$j;
import android.support.v7.b.a.b;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class k {
    private final CompoundButton a;
    private ColorStateList b;
    private PorterDuff$Mode c;
    private boolean d;
    private boolean e;
    private boolean f;

    k(CompoundButton arg3) {
        super();
        this.b = null;
        this.c = null;
        this.d = false;
        this.e = false;
        this.a = arg3;
    }

    void a(AttributeSet arg5, int arg6) {
        TypedArray v1 = this.a.getContext().obtainStyledAttributes(arg5, j.CompoundButton, arg6, 0);
        try {
            if(v1.hasValue(j.CompoundButton_android_button)) {
                int v0_1 = v1.getResourceId(j.CompoundButton_android_button, 0);
                if(v0_1 != 0) {
                    this.a.setButtonDrawable(b.b(this.a.getContext(), v0_1));
                }
            }

            if(v1.hasValue(j.CompoundButton_buttonTint)) {
                android.support.v4.widget.b.a(this.a, v1.getColorStateList(j.CompoundButton_buttonTint));
            }

            if(v1.hasValue(j.CompoundButton_buttonTintMode)) {
                android.support.v4.widget.b.a(this.a, ae.a(v1.getInt(j.CompoundButton_buttonTintMode, -1), null));
            }
        }
        catch(Throwable v0) {
            v1.recycle();
            throw v0;
        }

        v1.recycle();
    }

    int a(int arg3) {
        if(Build$VERSION.SDK_INT < 17) {
            Drawable v0 = android.support.v4.widget.b.a(this.a);
            if(v0 != null) {
                arg3 += v0.getIntrinsicWidth();
            }
        }

        return arg3;
    }

    ColorStateList a() {
        return this.b;
    }

    void a(ColorStateList arg2) {
        this.b = arg2;
        this.d = true;
        this.d();
    }

    void a(PorterDuff$Mode arg2) {
        this.c = arg2;
        this.e = true;
        this.d();
    }

    PorterDuff$Mode b() {
        return this.c;
    }

    void c() {
        if(this.f) {
            this.f = false;
        }
        else {
            this.f = true;
            this.d();
        }
    }

    void d() {
        Drawable v0 = android.support.v4.widget.b.a(this.a);
        if(v0 != null && ((this.d) || (this.e))) {
            v0 = a.f(v0).mutate();
            if(this.d) {
                a.a(v0, this.b);
            }

            if(this.e) {
                a.a(v0, this.c);
            }

            if(v0.isStateful()) {
                v0.setState(this.a.getDrawableState());
            }

            this.a.setButtonDrawable(v0);
        }
    }
}

