package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.h.o;
import android.support.v7.a.a$a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class m extends EditText implements o {
    private final g a;
    private final y b;

    public m(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, a.editTextStyle);
    }

    public m(Context arg2, AttributeSet arg3, int arg4) {
        super(at.a(arg2), arg3, arg4);
        this.a = new g(((View)this));
        this.a.a(arg3, arg4);
        this.b = y.a(((TextView)this));
        this.b.a(arg3, arg4);
        this.b.a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(this.a != null) {
            this.a.c();
        }

        if(this.b != null) {
            this.b.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        ColorStateList v0 = this.a != null ? this.a.a() : null;
        return v0;
    }

    public PorterDuff$Mode getSupportBackgroundTintMode() {
        PorterDuff$Mode v0 = this.a != null ? this.a.b() : null;
        return v0;
    }

    public void setBackgroundDrawable(Drawable arg2) {
        super.setBackgroundDrawable(arg2);
        if(this.a != null) {
            this.a.a(arg2);
        }
    }

    public void setBackgroundResource(int arg2) {
        super.setBackgroundResource(arg2);
        if(this.a != null) {
            this.a.a(arg2);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList arg2) {
        if(this.a != null) {
            this.a.a(arg2);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff$Mode arg2) {
        if(this.a != null) {
            this.a.a(arg2);
        }
    }

    public void setTextAppearance(Context arg2, int arg3) {
        super.setTextAppearance(arg2, arg3);
        if(this.b != null) {
            this.b.a(arg2, arg3);
        }
    }
}

