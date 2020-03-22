package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@TargetApi(value=11) @RequiresApi(value=11) class DrawableWrapperHoneycomb extends DrawableWrapperGingerbread {
    class DrawableWrapperStateHoneycomb extends DrawableWrapperState {
        DrawableWrapperStateHoneycomb(@Nullable DrawableWrapperState arg1, @Nullable Resources arg2) {
            super(arg1, arg2);
        }

        public Drawable newDrawable(@Nullable Resources arg2) {
            return new DrawableWrapperHoneycomb(((DrawableWrapperState)this), arg2);
        }
    }

    DrawableWrapperHoneycomb(Drawable arg1) {
        super(arg1);
    }

    DrawableWrapperHoneycomb(DrawableWrapperState arg1, Resources arg2) {
        super(arg1, arg2);
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    @NonNull DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateHoneycomb(this.mState, null);
    }
}

