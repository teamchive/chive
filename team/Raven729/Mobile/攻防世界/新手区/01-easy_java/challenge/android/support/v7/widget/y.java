package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources$NotFoundException;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.v7.a.a$j;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class y {
    final TextView a;
    private au b;
    private au c;
    private au d;
    private au e;
    private final ab f;
    private int g;
    private Typeface h;

    y(TextView arg3) {
        super();
        this.g = 0;
        this.a = arg3;
        this.f = new ab(this.a);
    }

    static y a(TextView arg2) {
        z v0;
        if(Build$VERSION.SDK_INT >= 17) {
            v0 = new z(arg2);
        }
        else {
            y v0_1 = new y(arg2);
        }

        return ((y)v0);
    }

    void a(AttributeSet arg13, int arg14) {
        ColorStateList v6;
        ColorStateList v4_1;
        int v0_1;
        boolean v3_1;
        aw v9_1;
        int v11 = 23;
        int v9 = -1;
        ColorStateList v5 = null;
        Context v7 = this.a.getContext();
        l v0 = l.a();
        aw v3 = aw.a(v7, arg13, j.AppCompatTextHelper, arg14, 0);
        int v4 = v3.g(j.AppCompatTextHelper_android_textAppearance, v9);
        if(v3.g(j.AppCompatTextHelper_android_drawableLeft)) {
            this.b = y.a(v7, v0, v3.g(j.AppCompatTextHelper_android_drawableLeft, 0));
        }

        if(v3.g(j.AppCompatTextHelper_android_drawableTop)) {
            this.c = y.a(v7, v0, v3.g(j.AppCompatTextHelper_android_drawableTop, 0));
        }

        if(v3.g(j.AppCompatTextHelper_android_drawableRight)) {
            this.d = y.a(v7, v0, v3.g(j.AppCompatTextHelper_android_drawableRight, 0));
        }

        if(v3.g(j.AppCompatTextHelper_android_drawableBottom)) {
            this.e = y.a(v7, v0, v3.g(j.AppCompatTextHelper_android_drawableBottom, 0));
        }

        v3.a();
        boolean v8 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if(v4 != v9) {
            v9_1 = aw.a(v7, v4, j.TextAppearance);
            if((v8) || !v9_1.g(j.TextAppearance_textAllCaps)) {
                v0_1 = 0;
                v3_1 = false;
            }
            else {
                v3_1 = v9_1.a(j.TextAppearance_textAllCaps, false);
                v0_1 = 1;
            }

            this.a(v7, v9_1);
            if(Build$VERSION.SDK_INT < v11) {
                v4_1 = v9_1.g(j.TextAppearance_android_textColor) ? v9_1.e(j.TextAppearance_android_textColor) : v5;
                v6 = v9_1.g(j.TextAppearance_android_textColorHint) ? v9_1.e(j.TextAppearance_android_textColorHint) : v5;
                if(!v9_1.g(j.TextAppearance_android_textColorLink)) {
                    goto label_73;
                }

                v5 = v9_1.e(j.TextAppearance_android_textColorLink);
            }
            else {
                v6 = v5;
                v4_1 = v5;
            }

        label_73:
            v9_1.a();
        }
        else {
            v6 = v5;
            v4_1 = v5;
            v0_1 = 0;
            v3_1 = false;
        }

        v9_1 = aw.a(v7, arg13, j.TextAppearance, arg14, 0);
        if(!v8 && (v9_1.g(j.TextAppearance_textAllCaps))) {
            v3_1 = v9_1.a(j.TextAppearance_textAllCaps, false);
            v0_1 = 1;
        }

        if(Build$VERSION.SDK_INT < v11) {
            if(v9_1.g(j.TextAppearance_android_textColor)) {
                v4_1 = v9_1.e(j.TextAppearance_android_textColor);
            }

            if(v9_1.g(j.TextAppearance_android_textColorHint)) {
                v6 = v9_1.e(j.TextAppearance_android_textColorHint);
            }

            if(!v9_1.g(j.TextAppearance_android_textColorLink)) {
                goto label_100;
            }

            v5 = v9_1.e(j.TextAppearance_android_textColorLink);
        }

    label_100:
        this.a(v7, v9_1);
        v9_1.a();
        if(v4_1 != null) {
            this.a.setTextColor(v4_1);
        }

        if(v6 != null) {
            this.a.setHintTextColor(v6);
        }

        if(v5 != null) {
            this.a.setLinkTextColor(v5);
        }

        if(!v8 && v0_1 != 0) {
            this.a(v3_1);
        }

        if(this.h != null) {
            this.a.setTypeface(this.h, this.g);
        }

        this.f.a(arg13, arg14);
        if(Build$VERSION.SDK_INT >= 26 && this.f.a() != 0) {
            int[] v0_2 = this.f.e();
            if(v0_2.length > 0) {
                if((((float)this.a.getAutoSizeStepGranularity())) != -1f) {
                    this.a.setAutoSizeTextTypeUniformWithConfiguration(this.f.c(), this.f.d(), this.f.b(), 0);
                }
                else {
                    this.a.setAutoSizeTextTypeUniformWithPresetSizes(v0_2, 0);
                }
            }
        }
    }

    void a() {
        if(this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] v0 = this.a.getCompoundDrawables();
            this.a(v0[0], this.b);
            this.a(v0[1], this.c);
            this.a(v0[2], this.d);
            this.a(v0[3], this.e);
        }
    }

    void a(boolean arg3, int arg4, int arg5, int arg6, int arg7) {
        if(Build$VERSION.SDK_INT < 26) {
            this.b();
        }
    }

    void a(int arg2, int arg3, int arg4, int arg5) {
        this.f.a(arg2, arg3, arg4, arg5);
    }

    void a(int[] arg2, int arg3) {
        this.f.a(arg2, arg3);
    }

    void a(int arg2) {
        this.f.a(arg2);
    }

    void a(Context arg4, int arg5) {
        aw v0 = aw.a(arg4, arg5, j.TextAppearance);
        if(v0.g(j.TextAppearance_textAllCaps)) {
            this.a(v0.a(j.TextAppearance_textAllCaps, false));
        }

        if(Build$VERSION.SDK_INT < 23 && (v0.g(j.TextAppearance_android_textColor))) {
            ColorStateList v1 = v0.e(j.TextAppearance_android_textColor);
            if(v1 != null) {
                this.a.setTextColor(v1);
            }
        }

        this.a(arg4, v0);
        v0.a();
        if(this.h != null) {
            this.a.setTypeface(this.h, this.g);
        }
    }

    void a(int arg3, float arg4) {
        if(Build$VERSION.SDK_INT < 26 && !this.c()) {
            this.b(arg3, arg4);
        }
    }

    void a(boolean arg2) {
        this.a.setAllCaps(arg2);
    }

    protected static au a(Context arg3, l arg4, int arg5) {
        au v0;
        ColorStateList v1 = arg4.b(arg3, arg5);
        if(v1 != null) {
            v0 = new au();
            v0.d = true;
            v0.a = v1;
        }
        else {
            v0 = null;
        }

        return v0;
    }

    private void a(Context arg4, aw arg5) {
        this.g = arg5.a(j.TextAppearance_android_textStyle, this.g);
        if((arg5.g(j.TextAppearance_android_fontFamily)) || (arg5.g(j.TextAppearance_fontFamily))) {
            this.h = null;
            int v0 = arg5.g(j.TextAppearance_android_fontFamily) ? j.TextAppearance_android_fontFamily : j.TextAppearance_fontFamily;
            if(!arg4.isRestricted()) {
                try {
                    this.h = arg5.a(v0, this.g, this.a);
                }
                catch(Resources$NotFoundException v1) {
                }
                catch(UnsupportedOperationException v1_1) {
                }
            }

            if(this.h == null) {
                this.h = Typeface.create(arg5.d(v0), this.g);
            }
        }
    }

    final void a(Drawable arg2, au arg3) {
        if(arg2 != null && arg3 != null) {
            l.a(arg2, arg3, this.a.getDrawableState());
        }
    }

    void b() {
        this.f.f();
    }

    private void b(int arg2, float arg3) {
        this.f.a(arg2, arg3);
    }

    boolean c() {
        return this.f.g();
    }

    int d() {
        return this.f.a();
    }

    int e() {
        return this.f.b();
    }

    int f() {
        return this.f.c();
    }

    int g() {
        return this.f.d();
    }

    int[] h() {
        return this.f.e();
    }
}

