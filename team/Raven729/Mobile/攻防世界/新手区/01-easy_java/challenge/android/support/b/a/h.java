package android.support.b.a;

import android.content.res.Resources$Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.a;
import android.support.v4.c.a.f;

abstract class h extends Drawable implements f {
    Drawable b;

    h() {
        super();
    }

    public void applyTheme(Resources$Theme arg2) {
        if(this.b != null) {
            a.a(this.b, arg2);
        }
    }

    public void clearColorFilter() {
        if(this.b != null) {
            this.b.clearColorFilter();
        }
        else {
            super.clearColorFilter();
        }
    }

    public ColorFilter getColorFilter() {
        ColorFilter v0 = this.b != null ? a.e(this.b) : null;
        return v0;
    }

    public Drawable getCurrent() {
        Drawable v0 = this.b != null ? this.b.getCurrent() : super.getCurrent();
        return v0;
    }

    public int getMinimumHeight() {
        int v0 = this.b != null ? this.b.getMinimumHeight() : super.getMinimumHeight();
        return v0;
    }

    public int getMinimumWidth() {
        int v0 = this.b != null ? this.b.getMinimumWidth() : super.getMinimumWidth();
        return v0;
    }

    public boolean getPadding(Rect arg2) {
        boolean v0 = this.b != null ? this.b.getPadding(arg2) : super.getPadding(arg2);
        return v0;
    }

    public int[] getState() {
        int[] v0 = this.b != null ? this.b.getState() : super.getState();
        return v0;
    }

    public Region getTransparentRegion() {
        Region v0 = this.b != null ? this.b.getTransparentRegion() : super.getTransparentRegion();
        return v0;
    }

    public void jumpToCurrentState() {
        if(this.b != null) {
            a.a(this.b);
        }
    }

    protected void onBoundsChange(Rect arg2) {
        if(this.b != null) {
            this.b.setBounds(arg2);
        }
        else {
            super.onBoundsChange(arg2);
        }
    }

    protected boolean onLevelChange(int arg2) {
        boolean v0 = this.b != null ? this.b.setLevel(arg2) : super.onLevelChange(arg2);
        return v0;
    }

    public void setChangingConfigurations(int arg2) {
        if(this.b != null) {
            this.b.setChangingConfigurations(arg2);
        }
        else {
            super.setChangingConfigurations(arg2);
        }
    }

    public void setColorFilter(int arg2, PorterDuff$Mode arg3) {
        if(this.b != null) {
            this.b.setColorFilter(arg2, arg3);
        }
        else {
            super.setColorFilter(arg2, arg3);
        }
    }

    public void setFilterBitmap(boolean arg2) {
        if(this.b != null) {
            this.b.setFilterBitmap(arg2);
        }
    }

    public void setHotspot(float arg2, float arg3) {
        if(this.b != null) {
            a.a(this.b, arg2, arg3);
        }
    }

    public void setHotspotBounds(int arg2, int arg3, int arg4, int arg5) {
        if(this.b != null) {
            a.a(this.b, arg2, arg3, arg4, arg5);
        }
    }

    public boolean setState(int[] arg2) {
        boolean v0 = this.b != null ? this.b.setState(arg2) : super.setState(arg2);
        return v0;
    }
}

