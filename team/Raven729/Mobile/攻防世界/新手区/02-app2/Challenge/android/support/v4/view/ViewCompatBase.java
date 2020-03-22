package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

@TargetApi(value=9) @RequiresApi(value=9) class ViewCompatBase {
    private static final String TAG = "ViewCompatBase";
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;

    ViewCompatBase() {
        super();
    }

    static ColorStateList getBackgroundTintList(View arg1) {
        ColorStateList v0 = (arg1 instanceof TintableBackgroundView) ? ((TintableBackgroundView)arg1).getSupportBackgroundTintList() : null;
        return v0;
    }

    static PorterDuff$Mode getBackgroundTintMode(View arg1) {
        PorterDuff$Mode v0 = (arg1 instanceof TintableBackgroundView) ? ((TintableBackgroundView)arg1).getSupportBackgroundTintMode() : null;
        return v0;
    }

    static Display getDisplay(View arg2) {
        Display v0 = ViewCompatBase.isAttachedToWindow(arg2) ? arg2.getContext().getSystemService("window").getDefaultDisplay() : null;
        return v0;
    }

    static int getMinimumHeight(View arg3) {
        if(!ViewCompatBase.sMinHeightFieldFetched) {
            try {
                ViewCompatBase.sMinHeightField = View.class.getDeclaredField("mMinHeight");
                ViewCompatBase.sMinHeightField.setAccessible(true);
            }
            catch(NoSuchFieldException v0) {
            }

            ViewCompatBase.sMinHeightFieldFetched = true;
        }

        if(ViewCompatBase.sMinHeightField != null) {
            try {
                int v0_2 = ViewCompatBase.sMinHeightField.get(arg3).intValue();
                return v0_2;
            }
            catch(Exception v0_1) {
            }
        }

        return 0;
    }

    static int getMinimumWidth(View arg3) {
        if(!ViewCompatBase.sMinWidthFieldFetched) {
            try {
                ViewCompatBase.sMinWidthField = View.class.getDeclaredField("mMinWidth");
                ViewCompatBase.sMinWidthField.setAccessible(true);
            }
            catch(NoSuchFieldException v0) {
            }

            ViewCompatBase.sMinWidthFieldFetched = true;
        }

        if(ViewCompatBase.sMinWidthField != null) {
            try {
                int v0_2 = ViewCompatBase.sMinWidthField.get(arg3).intValue();
                return v0_2;
            }
            catch(Exception v0_1) {
            }
        }

        return 0;
    }

    static boolean isAttachedToWindow(View arg1) {
        boolean v0 = arg1.getWindowToken() != null ? true : false;
        return v0;
    }

    static boolean isLaidOut(View arg1) {
        boolean v0 = arg1.getWidth() <= 0 || arg1.getHeight() <= 0 ? false : true;
        return v0;
    }

    static void offsetLeftAndRight(View arg6, int arg7) {
        int v1 = arg6.getLeft();
        arg6.offsetLeftAndRight(arg7);
        if(arg7 != 0) {
            ViewParent v0 = arg6.getParent();
            if((v0 instanceof View)) {
                int v2 = Math.abs(arg7);
                ((View)v0).invalidate(v1 - v2, arg6.getTop(), v1 + arg6.getWidth() + v2, arg6.getBottom());
            }
            else {
                arg6.invalidate();
            }
        }
    }

    static void offsetTopAndBottom(View arg7, int arg8) {
        int v1 = arg7.getTop();
        arg7.offsetTopAndBottom(arg8);
        if(arg8 != 0) {
            ViewParent v0 = arg7.getParent();
            if((v0 instanceof View)) {
                int v2 = Math.abs(arg8);
                ((View)v0).invalidate(arg7.getLeft(), v1 - v2, arg7.getRight(), v1 + arg7.getHeight() + v2);
            }
            else {
                arg7.invalidate();
            }
        }
    }

    static void setBackgroundTintList(View arg1, ColorStateList arg2) {
        if((arg1 instanceof TintableBackgroundView)) {
            ((TintableBackgroundView)arg1).setSupportBackgroundTintList(arg2);
        }
    }

    static void setBackgroundTintMode(View arg1, PorterDuff$Mode arg2) {
        if((arg1 instanceof TintableBackgroundView)) {
            ((TintableBackgroundView)arg1).setSupportBackgroundTintMode(arg2);
        }
    }
}

