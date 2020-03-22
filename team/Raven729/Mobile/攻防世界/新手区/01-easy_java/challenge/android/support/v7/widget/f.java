package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.h.o;
import android.support.v7.a.a$a;
import android.support.v7.b.a.b;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class f extends AutoCompleteTextView implements o {
    private static final int[] a;
    private final g b;
    private final y c;

    static {
        f.a = new int[]{0x1010176};
    }

    public f(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, a.autoCompleteTextViewStyle);
    }

    public f(Context arg2) {
        this(arg2, null);
    }

    public f(Context arg4, AttributeSet arg5, int arg6) {
        super(at.a(arg4), arg5, arg6);
        aw v0 = aw.a(this.getContext(), arg5, f.a, arg6, 0);
        if(v0.g(0)) {
            this.setDropDownBackgroundDrawable(v0.a(0));
        }

        v0.a();
        this.b = new g(((View)this));
        this.b.a(arg5, arg6);
        this.c = y.a(((TextView)this));
        this.c.a(arg5, arg6);
        this.c.a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(this.b != null) {
            this.b.c();
        }

        if(this.c != null) {
            this.c.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        ColorStateList v0 = this.b != null ? this.b.a() : null;
        return v0;
    }

    public PorterDuff$Mode getSupportBackgroundTintMode() {
        PorterDuff$Mode v0 = this.b != null ? this.b.b() : null;
        return v0;
    }

    public void setBackgroundDrawable(Drawable arg2) {
        super.setBackgroundDrawable(arg2);
        if(this.b != null) {
            this.b.a(arg2);
        }
    }

    public void setBackgroundResource(int arg2) {
        super.setBackgroundResource(arg2);
        if(this.b != null) {
            this.b.a(arg2);
        }
    }

    public void setDropDownBackgroundResource(int arg2) {
        this.setDropDownBackgroundDrawable(b.b(this.getContext(), arg2));
    }

    public void setSupportBackgroundTintList(ColorStateList arg2) {
        if(this.b != null) {
            this.b.a(arg2);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff$Mode arg2) {
        if(this.b != null) {
            this.b.a(arg2);
        }
    }

    public void setTextAppearance(Context arg2, int arg3) {
        super.setTextAppearance(arg2, arg3);
        if(this.c != null) {
            this.c.a(arg2, arg3);
        }
    }
}

