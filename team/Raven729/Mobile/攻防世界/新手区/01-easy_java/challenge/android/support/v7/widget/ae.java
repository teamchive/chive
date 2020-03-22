package android.support.v7.widget;

import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer$DrawableContainerState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build$VERSION;
import android.support.v4.c.a.b;
import android.support.v7.c.a.a;

public class ae {
    public static final Rect a;
    private static Class b;

    static {
        ae.a = new Rect();
        if(Build$VERSION.SDK_INT >= 18) {
            try {
                ae.b = Class.forName("android.graphics.Insets");
            }
            catch(ClassNotFoundException v0) {
            }
        }
    }

    public static PorterDuff$Mode a(int arg2, PorterDuff$Mode arg3) {
        switch(arg2) {
            case 3: {
                arg3 = PorterDuff$Mode.SRC_OVER;
                break;
            }
            case 5: {
                arg3 = PorterDuff$Mode.SRC_IN;
                break;
            }
            case 9: {
                arg3 = PorterDuff$Mode.SRC_ATOP;
                break;
            }
            case 14: {
                arg3 = PorterDuff$Mode.MULTIPLY;
                break;
            }
            case 15: {
                arg3 = PorterDuff$Mode.SCREEN;
                break;
            }
            case 16: {
                if(Build$VERSION.SDK_INT < 11) {
                    return arg3;
                }

                arg3 = PorterDuff$Mode.valueOf("ADD");
                break;
            }
        }

        return arg3;
    }

    static void a(Drawable arg2) {
        if(Build$VERSION.SDK_INT == 21 && ("android.graphics.drawable.VectorDrawable".equals(arg2.getClass().getName()))) {
            ae.c(arg2);
        }
    }

    public static boolean b(Drawable arg5) {
        boolean v0;
        int v2 = 15;
        if(Build$VERSION.SDK_INT >= v2 || !(arg5 instanceof InsetDrawable)) {
            if(Build$VERSION.SDK_INT < v2 && ((arg5 instanceof GradientDrawable))) {
                return false;
            }

            if(Build$VERSION.SDK_INT < 17 && ((arg5 instanceof LayerDrawable))) {
                return false;
            }

            if((arg5 instanceof DrawableContainer)) {
                Drawable$ConstantState v0_1 = arg5.getConstantState();
                if((v0_1 instanceof DrawableContainer$DrawableContainerState)) {
                    Drawable[] v2_1 = ((DrawableContainer$DrawableContainerState)v0_1).getChildren();
                    int v3 = v2_1.length;
                    int v0_2 = 0;
                    while(v0_2 < v3) {
                        if(!ae.b(v2_1[v0_2])) {
                            return false;
                        }
                        else {
                            ++v0_2;
                            continue;
                        }
                    }
                }
            }
            else if((arg5 instanceof b)) {
                return ae.b(((b)arg5).a());
            }
            else if((arg5 instanceof a)) {
                return ae.b(((a)arg5).a());
            }
            else if((arg5 instanceof ScaleDrawable)) {
                return ae.b(((ScaleDrawable)arg5).getDrawable());
            }

            v0 = true;
        }
        else {
            v0 = false;
        }

        return v0;
    }

    private static void c(Drawable arg2) {
        int[] v0 = arg2.getState();
        if(v0 == null || v0.length == 0) {
            arg2.setState(ar.e);
        }
        else {
            arg2.setState(ar.h);
        }

        arg2.setState(v0);
    }
}

