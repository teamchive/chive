package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

@TargetApi(value=19) @RequiresApi(value=19) class DrawableCompatKitKat {
    DrawableCompatKitKat() {
        super();
    }

    public static int getAlpha(Drawable arg1) {
        return arg1.getAlpha();
    }

    public static boolean isAutoMirrored(Drawable arg1) {
        return arg1.isAutoMirrored();
    }

    public static void setAutoMirrored(Drawable arg0, boolean arg1) {
        arg0.setAutoMirrored(arg1);
    }

    public static Drawable wrapForTinting(Drawable arg1) {
        DrawableWrapperKitKat v1;
        if(!(arg1 instanceof TintAwareDrawable)) {
            v1 = new DrawableWrapperKitKat(arg1);
        }

        return ((Drawable)v1);
    }
}

