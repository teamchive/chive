package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v4.h.o;
import android.support.v4.widget.l;
import android.support.v7.a.a$a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class n extends ImageButton implements o, l {
    private final g a;
    private final android.support.v7.widget.o b;

    public n(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, a.imageButtonStyle);
    }

    public n(Context arg2, AttributeSet arg3, int arg4) {
        super(at.a(arg2), arg3, arg4);
        this.a = new g(((View)this));
        this.a.a(arg3, arg4);
        this.b = new android.support.v7.widget.o(((ImageView)this));
        this.b.a(arg3, arg4);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(this.a != null) {
            this.a.c();
        }

        if(this.b != null) {
            this.b.d();
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

    public ColorStateList getSupportImageTintList() {
        ColorStateList v0 = this.b != null ? this.b.b() : null;
        return v0;
    }

    public PorterDuff$Mode getSupportImageTintMode() {
        PorterDuff$Mode v0 = this.b != null ? this.b.c() : null;
        return v0;
    }

    public boolean hasOverlappingRendering() {
        boolean v0 = !this.b.a() || !super.hasOverlappingRendering() ? false : true;
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

    public void setImageBitmap(Bitmap arg2) {
        super.setImageBitmap(arg2);
        if(this.b != null) {
            this.b.d();
        }
    }

    public void setImageDrawable(Drawable arg2) {
        super.setImageDrawable(arg2);
        if(this.b != null) {
            this.b.d();
        }
    }

    public void setImageIcon(Icon arg2) {
        super.setImageIcon(arg2);
        if(this.b != null) {
            this.b.d();
        }
    }

    public void setImageResource(int arg2) {
        this.b.a(arg2);
    }

    public void setImageURI(Uri arg2) {
        super.setImageURI(arg2);
        if(this.b != null) {
            this.b.d();
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

    public void setSupportImageTintList(ColorStateList arg2) {
        if(this.b != null) {
            this.b.a(arg2);
        }
    }

    public void setSupportImageTintMode(PorterDuff$Mode arg2) {
        if(this.b != null) {
            this.b.a(arg2);
        }
    }
}

