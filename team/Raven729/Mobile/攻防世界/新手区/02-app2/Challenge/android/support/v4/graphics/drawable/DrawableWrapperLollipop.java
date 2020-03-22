package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build$VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@TargetApi(value=21) @RequiresApi(value=21) class DrawableWrapperLollipop extends DrawableWrapperKitKat {
    class DrawableWrapperStateLollipop extends DrawableWrapperState {
        DrawableWrapperStateLollipop(@Nullable DrawableWrapperState arg1, @Nullable Resources arg2) {
            super(arg1, arg2);
        }

        public Drawable newDrawable(@Nullable Resources arg2) {
            return new DrawableWrapperLollipop(((DrawableWrapperState)this), arg2);
        }
    }

    DrawableWrapperLollipop(Drawable arg1) {
        super(arg1);
    }

    DrawableWrapperLollipop(DrawableWrapperState arg1, Resources arg2) {
        super(arg1, arg2);
    }

    public Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    public void getOutline(Outline arg2) {
        this.mDrawable.getOutline(arg2);
    }

    protected boolean isCompatTintEnabled() {
        boolean v0 = false;
        if(Build$VERSION.SDK_INT == 21) {
            Drawable v1 = this.mDrawable;
            if(!(v1 instanceof GradientDrawable) && !(v1 instanceof DrawableContainer) && !(v1 instanceof InsetDrawable)) {
                return v0;
            }

            v0 = true;
        }

        return v0;
    }

    @NonNull DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateLollipop(this.mState, null);
    }

    public void setHotspot(float arg2, float arg3) {
        this.mDrawable.setHotspot(arg2, arg3);
    }

    public void setHotspotBounds(int arg2, int arg3, int arg4, int arg5) {
        this.mDrawable.setHotspotBounds(arg2, arg3, arg4, arg5);
    }

    public boolean setState(int[] arg2) {
        boolean v0;
        if(super.setState(arg2)) {
            this.invalidateSelf();
            v0 = true;
        }
        else {
            v0 = false;
        }

        return v0;
    }

    public void setTint(int arg2) {
        if(this.isCompatTintEnabled()) {
            super.setTint(arg2);
        }
        else {
            this.mDrawable.setTint(arg2);
        }
    }

    public void setTintList(ColorStateList arg2) {
        if(this.isCompatTintEnabled()) {
            super.setTintList(arg2);
        }
        else {
            this.mDrawable.setTintList(arg2);
        }
    }

    public void setTintMode(PorterDuff$Mode arg2) {
        if(this.isCompatTintEnabled()) {
            super.setTintMode(arg2);
        }
        else {
            this.mDrawable.setTintMode(arg2);
        }
    }
}

