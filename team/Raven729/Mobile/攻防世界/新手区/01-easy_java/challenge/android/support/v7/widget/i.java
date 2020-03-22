package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.k;
import android.support.v7.a.a$a;
import android.support.v7.b.a.b;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class i extends CheckBox implements k {
    private final android.support.v7.widget.k a;

    public i(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, a.checkboxStyle);
    }

    public i(Context arg2, AttributeSet arg3, int arg4) {
        super(at.a(arg2), arg3, arg4);
        this.a = new android.support.v7.widget.k(((CompoundButton)this));
        this.a.a(arg3, arg4);
    }

    public int getCompoundPaddingLeft() {
        int v0 = super.getCompoundPaddingLeft();
        if(this.a != null) {
            v0 = this.a.a(v0);
        }

        return v0;
    }

    public ColorStateList getSupportButtonTintList() {
        ColorStateList v0 = this.a != null ? this.a.a() : null;
        return v0;
    }

    public PorterDuff$Mode getSupportButtonTintMode() {
        PorterDuff$Mode v0 = this.a != null ? this.a.b() : null;
        return v0;
    }

    public void setButtonDrawable(int arg2) {
        this.setButtonDrawable(b.b(this.getContext(), arg2));
    }

    public void setButtonDrawable(Drawable arg2) {
        super.setButtonDrawable(arg2);
        if(this.a != null) {
            this.a.c();
        }
    }

    public void setSupportButtonTintList(ColorStateList arg2) {
        if(this.a != null) {
            this.a.a(arg2);
        }
    }

    public void setSupportButtonTintMode(PorterDuff$Mode arg2) {
        if(this.a != null) {
            this.a.a(arg2);
        }
    }
}

