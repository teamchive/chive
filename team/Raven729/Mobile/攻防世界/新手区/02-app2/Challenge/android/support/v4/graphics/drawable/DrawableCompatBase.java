package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(value=9) @RequiresApi(value=9) class DrawableCompatBase {
    DrawableCompatBase() {
        super();
    }

    public static void inflate(Drawable arg0, Resources arg1, XmlPullParser arg2, AttributeSet arg3, Resources$Theme arg4) {
        arg0.inflate(arg1, arg2, arg3);
    }

    public static void setTint(Drawable arg1, int arg2) {
        if((arg1 instanceof TintAwareDrawable)) {
            ((TintAwareDrawable)arg1).setTint(arg2);
        }
    }

    public static void setTintList(Drawable arg1, ColorStateList arg2) {
        if((arg1 instanceof TintAwareDrawable)) {
            ((TintAwareDrawable)arg1).setTintList(arg2);
        }
    }

    public static void setTintMode(Drawable arg1, PorterDuff$Mode arg2) {
        if((arg1 instanceof TintAwareDrawable)) {
            ((TintAwareDrawable)arg1).setTintMode(arg2);
        }
    }

    public static Drawable wrapForTinting(Drawable arg1) {
        DrawableWrapperGingerbread v1;
        if(!(arg1 instanceof TintAwareDrawable)) {
            v1 = new DrawableWrapperGingerbread(arg1);
        }

        return ((Drawable)v1);
    }
}

