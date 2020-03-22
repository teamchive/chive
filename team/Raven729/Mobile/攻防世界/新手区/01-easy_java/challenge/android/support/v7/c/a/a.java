package android.support.v7.c.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;

public class a extends Drawable implements Drawable$Callback {
    private Drawable a;

    public a(Drawable arg1) {
        super();
        this.a(arg1);
    }

    public void a(Drawable arg3) {
        if(this.a != null) {
            this.a.setCallback(null);
        }

        this.a = arg3;
        if(arg3 != null) {
            arg3.setCallback(((Drawable$Callback)this));
        }
    }

    public Drawable a() {
        return this.a;
    }

    public void draw(Canvas arg2) {
        this.a.draw(arg2);
    }

    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.a.getOpacity();
    }

    public boolean getPadding(Rect arg2) {
        return this.a.getPadding(arg2);
    }

    public int[] getState() {
        return this.a.getState();
    }

    public Region getTransparentRegion() {
        return this.a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable arg1) {
        this.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return android.support.v4.c.a.a.b(this.a);
    }

    public boolean isStateful() {
        return this.a.isStateful();
    }

    public void jumpToCurrentState() {
        android.support.v4.c.a.a.a(this.a);
    }

    protected void onBoundsChange(Rect arg2) {
        this.a.setBounds(arg2);
    }

    protected boolean onLevelChange(int arg2) {
        return this.a.setLevel(arg2);
    }

    public void scheduleDrawable(Drawable arg2, Runnable arg3, long arg4) {
        this.scheduleSelf(arg3, arg4);
    }

    public void setAlpha(int arg2) {
        this.a.setAlpha(arg2);
    }

    public void setAutoMirrored(boolean arg2) {
        android.support.v4.c.a.a.a(this.a, arg2);
    }

    public void setChangingConfigurations(int arg2) {
        this.a.setChangingConfigurations(arg2);
    }

    public void setColorFilter(ColorFilter arg2) {
        this.a.setColorFilter(arg2);
    }

    public void setDither(boolean arg2) {
        this.a.setDither(arg2);
    }

    public void setFilterBitmap(boolean arg2) {
        this.a.setFilterBitmap(arg2);
    }

    public void setHotspot(float arg2, float arg3) {
        android.support.v4.c.a.a.a(this.a, arg2, arg3);
    }

    public void setHotspotBounds(int arg2, int arg3, int arg4, int arg5) {
        android.support.v4.c.a.a.a(this.a, arg2, arg3, arg4, arg5);
    }

    public boolean setState(int[] arg2) {
        return this.a.setState(arg2);
    }

    public void setTint(int arg2) {
        android.support.v4.c.a.a.a(this.a, arg2);
    }

    public void setTintList(ColorStateList arg2) {
        android.support.v4.c.a.a.a(this.a, arg2);
    }

    public void setTintMode(PorterDuff$Mode arg2) {
        android.support.v4.c.a.a.a(this.a, arg2);
    }

    public boolean setVisible(boolean arg2, boolean arg3) {
        boolean v0 = (super.setVisible(arg2, arg3)) || (this.a.setVisible(arg2, arg3)) ? true : false;
        return v0;
    }

    public void unscheduleDrawable(Drawable arg1, Runnable arg2) {
        this.unscheduleSelf(arg2);
    }
}

