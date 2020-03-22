package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@TargetApi(value=9) @RequiresApi(value=9) class DrawableWrapperGingerbread extends Drawable implements Drawable$Callback, DrawableWrapper, TintAwareDrawable {
    public abstract class DrawableWrapperState extends Drawable$ConstantState {
        int mChangingConfigurations;
        Drawable$ConstantState mDrawableState;
        ColorStateList mTint;
        PorterDuff$Mode mTintMode;

        DrawableWrapperState(@Nullable DrawableWrapperState arg2, @Nullable Resources arg3) {
            super();
            this.mTint = null;
            this.mTintMode = DrawableWrapperGingerbread.DEFAULT_TINT_MODE;
            if(arg2 != null) {
                this.mChangingConfigurations = arg2.mChangingConfigurations;
                this.mDrawableState = arg2.mDrawableState;
                this.mTint = arg2.mTint;
                this.mTintMode = arg2.mTintMode;
            }
        }

        boolean canConstantState() {
            boolean v0 = this.mDrawableState != null ? true : false;
            return v0;
        }

        public int getChangingConfigurations() {
            int v1 = this.mChangingConfigurations;
            int v0 = this.mDrawableState != null ? this.mDrawableState.getChangingConfigurations() : 0;
            return v0 | v1;
        }

        public Drawable newDrawable() {
            return this.newDrawable(null);
        }

        public abstract Drawable newDrawable(@Nullable Resources arg1);
    }

    class DrawableWrapperStateBase extends DrawableWrapperState {
        DrawableWrapperStateBase(@Nullable DrawableWrapperState arg1, @Nullable Resources arg2) {
            super(arg1, arg2);
        }

        public Drawable newDrawable(@Nullable Resources arg2) {
            return new DrawableWrapperGingerbread(((DrawableWrapperState)this), arg2);
        }
    }

    static final PorterDuff$Mode DEFAULT_TINT_MODE;
    private boolean mColorFilterSet;
    private int mCurrentColor;
    private PorterDuff$Mode mCurrentMode;
    Drawable mDrawable;
    private boolean mMutated;
    DrawableWrapperState mState;

    static {
        DrawableWrapperGingerbread.DEFAULT_TINT_MODE = PorterDuff$Mode.SRC_IN;
    }

    DrawableWrapperGingerbread(@Nullable Drawable arg2) {
        super();
        this.mState = this.mutateConstantState();
        this.setWrappedDrawable(arg2);
    }

    DrawableWrapperGingerbread(@NonNull DrawableWrapperState arg1, @Nullable Resources arg2) {
        super();
        this.mState = arg1;
        this.updateLocalState(arg2);
    }

    public void draw(Canvas arg2) {
        this.mDrawable.draw(arg2);
    }

    public int getChangingConfigurations() {
        int v1 = super.getChangingConfigurations();
        int v0 = this.mState != null ? this.mState.getChangingConfigurations() : 0;
        return v0 | v1 | this.mDrawable.getChangingConfigurations();
    }

    @Nullable public Drawable$ConstantState getConstantState() {
        Drawable$ConstantState v0_1;
        if(this.mState == null || !this.mState.canConstantState()) {
            v0_1 = null;
        }
        else {
            this.mState.mChangingConfigurations = this.getChangingConfigurations();
            DrawableWrapperState v0 = this.mState;
        }

        return v0_1;
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect arg2) {
        return this.mDrawable.getPadding(arg2);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public final Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public void invalidateDrawable(Drawable arg1) {
        this.invalidateSelf();
    }

    protected boolean isCompatTintEnabled() {
        return 1;
    }

    public boolean isStateful() {
        ColorStateList v0 = !this.isCompatTintEnabled() || this.mState == null ? null : this.mState.mTint;
        boolean v0_1 = v0 != null && (v0.isStateful()) || (this.mDrawable.isStateful()) ? true : false;
        return v0_1;
    }

    public Drawable mutate() {
        if(!this.mMutated && super.mutate() == this) {
            this.mState = this.mutateConstantState();
            if(this.mDrawable != null) {
                this.mDrawable.mutate();
            }

            if(this.mState != null) {
                DrawableWrapperState v1 = this.mState;
                Drawable$ConstantState v0 = this.mDrawable != null ? this.mDrawable.getConstantState() : null;
                v1.mDrawableState = v0;
            }

            this.mMutated = true;
        }

        return this;
    }

    @NonNull DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateBase(this.mState, null);
    }

    protected Drawable newDrawableFromState(@NonNull Drawable$ConstantState arg2, @Nullable Resources arg3) {
        return arg2.newDrawable(arg3);
    }

    protected void onBoundsChange(Rect arg2) {
        if(this.mDrawable != null) {
            this.mDrawable.setBounds(arg2);
        }
    }

    protected boolean onLevelChange(int arg2) {
        return this.mDrawable.setLevel(arg2);
    }

    public void scheduleDrawable(Drawable arg2, Runnable arg3, long arg4) {
        this.scheduleSelf(arg3, arg4);
    }

    public void setAlpha(int arg2) {
        this.mDrawable.setAlpha(arg2);
    }

    public void setChangingConfigurations(int arg2) {
        this.mDrawable.setChangingConfigurations(arg2);
    }

    public void setColorFilter(ColorFilter arg2) {
        this.mDrawable.setColorFilter(arg2);
    }

    public void setDither(boolean arg2) {
        this.mDrawable.setDither(arg2);
    }

    public void setFilterBitmap(boolean arg2) {
        this.mDrawable.setFilterBitmap(arg2);
    }

    public boolean setState(int[] arg3) {
        boolean v0 = this.mDrawable.setState(arg3);
        return (this.updateTint(arg3)) || (v0) ? true : false;
    }

    public void setTint(int arg2) {
        this.setTintList(ColorStateList.valueOf(arg2));
    }

    public void setTintList(ColorStateList arg2) {
        this.mState.mTint = arg2;
        this.updateTint(this.getState());
    }

    public void setTintMode(PorterDuff$Mode arg2) {
        this.mState.mTintMode = arg2;
        this.updateTint(this.getState());
    }

    public boolean setVisible(boolean arg2, boolean arg3) {
        boolean v0 = (super.setVisible(arg2, arg3)) || (this.mDrawable.setVisible(arg2, arg3)) ? true : false;
        return v0;
    }

    public final void setWrappedDrawable(Drawable arg3) {
        if(this.mDrawable != null) {
            this.mDrawable.setCallback(null);
        }

        this.mDrawable = arg3;
        if(arg3 != null) {
            arg3.setCallback(((Drawable$Callback)this));
            this.setVisible(arg3.isVisible(), true);
            this.setState(arg3.getState());
            this.setLevel(arg3.getLevel());
            this.setBounds(arg3.getBounds());
            if(this.mState != null) {
                this.mState.mDrawableState = arg3.getConstantState();
            }
        }

        this.invalidateSelf();
    }

    public void unscheduleDrawable(Drawable arg1, Runnable arg2) {
        this.unscheduleSelf(arg2);
    }

    private void updateLocalState(@Nullable Resources arg2) {
        if(this.mState != null && this.mState.mDrawableState != null) {
            this.setWrappedDrawable(this.newDrawableFromState(this.mState.mDrawableState, arg2));
        }
    }

    private boolean updateTint(int[] arg6) {
        boolean v0 = false;
        if(this.isCompatTintEnabled()) {
            ColorStateList v2 = this.mState.mTint;
            PorterDuff$Mode v3 = this.mState.mTintMode;
            if(v2 != null && v3 != null) {
                int v2_1 = v2.getColorForState(arg6, v2.getDefaultColor());
                if((this.mColorFilterSet) && v2_1 == this.mCurrentColor && v3 == this.mCurrentMode) {
                    return v0;
                }

                this.setColorFilter(v2_1, v3);
                this.mCurrentColor = v2_1;
                this.mCurrentMode = v3;
                this.mColorFilterSet = true;
                return true;
            }

            this.mColorFilterSet = false;
            this.clearColorFilter();
        }

        return v0;
    }
}

