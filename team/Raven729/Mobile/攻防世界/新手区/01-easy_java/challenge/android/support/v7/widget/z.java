package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a$j;
import android.util.AttributeSet;
import android.widget.TextView;

class z extends y {
    private au b;
    private au c;

    z(TextView arg1) {
        super(arg1);
    }

    void a() {
        super.a();
        if(this.b != null || this.c != null) {
            Drawable[] v0 = this.a.getCompoundDrawablesRelative();
            this.a(v0[0], this.b);
            this.a(v0[2], this.c);
        }
    }

    void a(AttributeSet arg6, int arg7) {
        super.a(arg6, arg7);
        Context v0 = this.a.getContext();
        l v1 = l.a();
        TypedArray v2 = v0.obtainStyledAttributes(arg6, j.AppCompatTextHelper, arg7, 0);
        if(v2.hasValue(j.AppCompatTextHelper_android_drawableStart)) {
            this.b = z.a(v0, v1, v2.getResourceId(j.AppCompatTextHelper_android_drawableStart, 0));
        }

        if(v2.hasValue(j.AppCompatTextHelper_android_drawableEnd)) {
            this.c = z.a(v0, v1, v2.getResourceId(j.AppCompatTextHelper_android_drawableEnd, 0));
        }

        v2.recycle();
    }
}

