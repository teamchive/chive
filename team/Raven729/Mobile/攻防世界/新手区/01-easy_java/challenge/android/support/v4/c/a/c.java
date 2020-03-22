package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;

class c extends Drawable implements Drawable$Callback, b, f {
    public abstract class a extends Drawable$ConstantState {
        int a;
        Drawable$ConstantState b;
        ColorStateList c;
        PorterDuff$Mode d;

        a(a arg2, Resources arg3) {
            super();
            this.c = null;
            this.d = c.a;
            if(arg2 != null) {
                this.a = arg2.a;
                this.b = arg2.b;
                this.c = arg2.c;
                this.d = arg2.d;
            }
        }

        boolean a() {
            boolean v0 = this.b != null ? true : false;
            return v0;
        }

        public int getChangingConfigurations() {
            int v1 = this.a;
            int v0 = this.b != null ? this.b.getChangingConfigurations() : 0;
            return v0 | v1;
        }

        public Drawable newDrawable() {
            return this.newDrawable(null);
        }

        public abstract Drawable newDrawable(Resources arg1);
    }

    class android.support.v4.c.a.c$b extends a {
        android.support.v4.c.a.c$b(a arg1, Resources arg2) {
            super(arg1, arg2);
        }

        public Drawable newDrawable(Resources arg2) {
            return new c(((a)this), arg2);
        }
    }

    static final PorterDuff$Mode a;
    a b;
    Drawable c;
    private int d;
    private PorterDuff$Mode e;
    private boolean f;
    private boolean g;

    static {
        c.a = PorterDuff$Mode.SRC_IN;
    }

    c(Drawable arg2) {
        super();
        this.b = this.b();
        this.a(arg2);
    }

    c(a arg1, Resources arg2) {
        super();
        this.b = arg1;
        this.a(arg2);
    }

    public final void a(Drawable arg3) {
        if(this.c != null) {
            this.c.setCallback(null);
        }

        this.c = arg3;
        if(arg3 != null) {
            arg3.setCallback(((Drawable$Callback)this));
            this.setVisible(arg3.isVisible(), true);
            this.setState(arg3.getState());
            this.setLevel(arg3.getLevel());
            this.setBounds(arg3.getBounds());
            if(this.b != null) {
                this.b.b = arg3.getConstantState();
            }
        }

        this.invalidateSelf();
    }

    private void a(Resources arg2) {
        if(this.b != null && this.b.b != null) {
            this.a(this.a(this.b.b, arg2));
        }
    }

    protected Drawable a(Drawable$ConstantState arg2, Resources arg3) {
        return arg2.newDrawable(arg3);
    }

    private boolean a(int[] arg6) {
        boolean v0 = false;
        if(this.c()) {
            ColorStateList v2 = this.b.c;
            PorterDuff$Mode v3 = this.b.d;
            if(v2 != null && v3 != null) {
                int v2_1 = v2.getColorForState(arg6, v2.getDefaultColor());
                if((this.f) && v2_1 == this.d && v3 == this.e) {
                    return v0;
                }

                this.setColorFilter(v2_1, v3);
                this.d = v2_1;
                this.e = v3;
                this.f = true;
                return true;
            }

            this.f = false;
            this.clearColorFilter();
        }

        return v0;
    }

    public final Drawable a() {
        return this.c;
    }

    a b() {
        return new android.support.v4.c.a.c$b(this.b, null);
    }

    protected boolean c() {
        return 1;
    }

    public void draw(Canvas arg2) {
        this.c.draw(arg2);
    }

    public int getChangingConfigurations() {
        int v1 = super.getChangingConfigurations();
        int v0 = this.b != null ? this.b.getChangingConfigurations() : 0;
        return v0 | v1 | this.c.getChangingConfigurations();
    }

    public Drawable$ConstantState getConstantState() {
        a v0;
        if(this.b == null || !this.b.a()) {
            Drawable$ConstantState v0_1 = null;
        }
        else {
            this.b.a = this.getChangingConfigurations();
            v0 = this.b;
        }

        return ((Drawable$ConstantState)v0);
    }

    public Drawable getCurrent() {
        return this.c.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.c.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.c.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.c.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.c.getMinimumWidth();
    }

    public int getOpacity() {
        return this.c.getOpacity();
    }

    public boolean getPadding(Rect arg2) {
        return this.c.getPadding(arg2);
    }

    public int[] getState() {
        return this.c.getState();
    }

    public Region getTransparentRegion() {
        return this.c.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable arg1) {
        this.invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList v0 = !this.c() || this.b == null ? null : this.b.c;
        boolean v0_1 = v0 != null && (v0.isStateful()) || (this.c.isStateful()) ? true : false;
        return v0_1;
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }

    public Drawable mutate() {
        if(!this.g && super.mutate() == this) {
            this.b = this.b();
            if(this.c != null) {
                this.c.mutate();
            }

            if(this.b != null) {
                a v1 = this.b;
                Drawable$ConstantState v0 = this.c != null ? this.c.getConstantState() : null;
                v1.b = v0;
            }

            this.g = true;
        }

        return this;
    }

    protected void onBoundsChange(Rect arg2) {
        if(this.c != null) {
            this.c.setBounds(arg2);
        }
    }

    protected boolean onLevelChange(int arg2) {
        return this.c.setLevel(arg2);
    }

    public void scheduleDrawable(Drawable arg2, Runnable arg3, long arg4) {
        this.scheduleSelf(arg3, arg4);
    }

    public void setAlpha(int arg2) {
        this.c.setAlpha(arg2);
    }

    public void setChangingConfigurations(int arg2) {
        this.c.setChangingConfigurations(arg2);
    }

    public void setColorFilter(ColorFilter arg2) {
        this.c.setColorFilter(arg2);
    }

    public void setDither(boolean arg2) {
        this.c.setDither(arg2);
    }

    public void setFilterBitmap(boolean arg2) {
        this.c.setFilterBitmap(arg2);
    }

    public boolean setState(int[] arg3) {
        boolean v0 = this.c.setState(arg3);
        return (this.a(arg3)) || (v0) ? true : false;
    }

    public void setTint(int arg2) {
        this.setTintList(ColorStateList.valueOf(arg2));
    }

    public void setTintList(ColorStateList arg2) {
        this.b.c = arg2;
        this.a(this.getState());
    }

    public void setTintMode(PorterDuff$Mode arg2) {
        this.b.d = arg2;
        this.a(this.getState());
    }

    public boolean setVisible(boolean arg2, boolean arg3) {
        boolean v0 = (super.setVisible(arg2, arg3)) || (this.c.setVisible(arg2, arg3)) ? true : false;
        return v0;
    }

    public void unscheduleDrawable(Drawable arg1, Runnable arg2) {
        this.unscheduleSelf(arg2);
    }
}

