package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

@TargetApi(value=18) @RequiresApi(value=18) class ActionBarDrawerToggleJellybeanMR2 {
    private static final String TAG = "ActionBarDrawerToggleImplJellybeanMR2";
    private static final int[] THEME_ATTRS;

    static {
        ActionBarDrawerToggleJellybeanMR2.THEME_ATTRS = new int[]{0x101030B};
    }

    ActionBarDrawerToggleJellybeanMR2() {
        super();
    }

    public static Drawable getThemeUpIndicator(Activity arg4) {
        Context v4;
        ActionBar v0 = arg4.getActionBar();
        if(v0 != null) {
            v4 = v0.getThemedContext();
        }

        TypedArray v0_1 = v4.obtainStyledAttributes(null, ActionBarDrawerToggleJellybeanMR2.THEME_ATTRS, 0x10102CE, 0);
        Drawable v1 = v0_1.getDrawable(0);
        v0_1.recycle();
        return v1;
    }

    public static Object setActionBarDescription(Object arg1, Activity arg2, int arg3) {
        ActionBar v0 = arg2.getActionBar();
        if(v0 != null) {
            v0.setHomeActionContentDescription(arg3);
        }

        return arg1;
    }

    public static Object setActionBarUpIndicator(Object arg1, Activity arg2, Drawable arg3, int arg4) {
        ActionBar v0 = arg2.getActionBar();
        if(v0 != null) {
            v0.setHomeAsUpIndicator(arg3);
            v0.setHomeActionContentDescription(arg4);
        }

        return arg1;
    }
}

