package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer$DrawableContainerState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(value=21) @RequiresApi(value=21) class DrawableCompatLollipop {
    DrawableCompatLollipop() {
        super();
    }

    public static void applyTheme(Drawable arg0, Resources$Theme arg1) {
        arg0.applyTheme(arg1);
    }

    public static boolean canApplyTheme(Drawable arg1) {
        return arg1.canApplyTheme();
    }

    public static void clearColorFilter(Drawable arg4) {
        arg4.clearColorFilter();
        if((arg4 instanceof InsetDrawable)) {
            DrawableCompatLollipop.clearColorFilter(((InsetDrawable)arg4).getDrawable());
        }
        else if((arg4 instanceof DrawableWrapper)) {
            DrawableCompatLollipop.clearColorFilter(((DrawableWrapper)arg4).getWrappedDrawable());
        }
        else if((arg4 instanceof DrawableContainer)) {
            Drawable$ConstantState v0 = ((DrawableContainer)arg4).getConstantState();
            if(v0 != null) {
                int v1 = 0;
                int v2 = ((DrawableContainer$DrawableContainerState)v0).getChildCount();
                while(v1 < v2) {
                    Drawable v3 = ((DrawableContainer$DrawableContainerState)v0).getChild(v1);
                    if(v3 != null) {
                        DrawableCompatLollipop.clearColorFilter(v3);
                    }

                    ++v1;
                }
            }
        }
    }

    public static ColorFilter getColorFilter(Drawable arg1) {
        return arg1.getColorFilter();
    }

    public static void inflate(Drawable arg0, Resources arg1, XmlPullParser arg2, AttributeSet arg3, Resources$Theme arg4) {
        arg0.inflate(arg1, arg2, arg3, arg4);
    }

    public static void setHotspot(Drawable arg0, float arg1, float arg2) {
        arg0.setHotspot(arg1, arg2);
    }

    public static void setHotspotBounds(Drawable arg0, int arg1, int arg2, int arg3, int arg4) {
        arg0.setHotspotBounds(arg1, arg2, arg3, arg4);
    }

    public static void setTint(Drawable arg0, int arg1) {
        arg0.setTint(arg1);
    }

    public static void setTintList(Drawable arg0, ColorStateList arg1) {
        arg0.setTintList(arg1);
    }

    public static void setTintMode(Drawable arg0, PorterDuff$Mode arg1) {
        arg0.setTintMode(arg1);
    }

    public static Drawable wrapForTinting(Drawable arg1) {
        DrawableWrapperLollipop v1;
        if(!(arg1 instanceof TintAwareDrawable)) {
            v1 = new DrawableWrapperLollipop(arg1);
        }

        return ((Drawable)v1);
    }
}

