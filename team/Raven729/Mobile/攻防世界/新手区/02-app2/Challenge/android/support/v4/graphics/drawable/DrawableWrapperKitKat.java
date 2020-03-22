package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@TargetApi(value=19) @RequiresApi(value=19) class DrawableWrapperKitKat extends DrawableWrapperHoneycomb {
    class DrawableWrapperStateKitKat extends DrawableWrapperState {
        DrawableWrapperStateKitKat(@Nullable DrawableWrapperState arg1, @Nullable Resources arg2) {
            super(arg1, arg2);
        }

        public Drawable newDrawable(@Nullable Resources arg2) {
            return new DrawableWrapperKitKat(((DrawableWrapperState)this), arg2);
        }
    }

    DrawableWrapperKitKat(Drawable arg1) {
        super(arg1);
    }

    DrawableWrapperKitKat(DrawableWrapperState arg1, Resources arg2) {
        super(arg1, arg2);
    }

    public boolean isAutoMirrored() {
        return this.mDrawable.isAutoMirrored();
    }

    @NonNull DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateKitKat(this.mState, null);
    }

    public void setAutoMirrored(boolean arg2) {
        this.mDrawable.setAutoMirrored(arg2);
    }
}

