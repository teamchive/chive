package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

@TargetApi(value=11) @RequiresApi(value=11) class DrawableCompatHoneycomb {
    DrawableCompatHoneycomb() {
        super();
    }

    public static void jumpToCurrentState(Drawable arg0) {
        arg0.jumpToCurrentState();
    }

    public static Drawable wrapForTinting(Drawable arg1) {
        DrawableWrapperHoneycomb v1;
        if(!(arg1 instanceof TintAwareDrawable)) {
            v1 = new DrawableWrapperHoneycomb(arg1);
        }

        return ((Drawable)v1);
    }
}

