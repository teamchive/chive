package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import java.lang.reflect.Method;

@TargetApi(value=11) @RequiresApi(value=11) class ActionBarDrawerToggleHoneycomb {
    class SetIndicatorInfo {
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        SetIndicatorInfo(Activity arg9) {
            int v7 = 0x102002C;
            super();
            try {
                this.setHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            }
            catch(NoSuchMethodException v0) {
                View v0_1 = arg9.findViewById(v7);
                if(v0_1 == null) {
                    return;
                }

                ViewParent v0_2 = v0_1.getParent();
                if(((ViewGroup)v0_2).getChildCount() != 2) {
                    return;
                }

                View v1 = ((ViewGroup)v0_2).getChildAt(0);
                v0_1 = ((ViewGroup)v0_2).getChildAt(1);
                if(v1.getId() != v7) {
                    v0_1 = v1;
                }

                if(!(v0_1 instanceof ImageView)) {
                    return;
                }

                this.upIndicatorView = ((ImageView)v0_1);
            }
        }
    }

    private static final String TAG = "ActionBarDrawerToggleHoneycomb";
    private static final int[] THEME_ATTRS;

    static {
        ActionBarDrawerToggleHoneycomb.THEME_ATTRS = new int[]{0x101030B};
    }

    ActionBarDrawerToggleHoneycomb() {
        super();
    }

    public static Drawable getThemeUpIndicator(Activity arg2) {
        TypedArray v0 = arg2.obtainStyledAttributes(ActionBarDrawerToggleHoneycomb.THEME_ATTRS);
        Drawable v1 = v0.getDrawable(0);
        v0.recycle();
        return v1;
    }

    public static Object setActionBarDescription(Object arg6, Activity arg7, int arg8) {
        Object v1_1;
        if(arg6 == null) {
            SetIndicatorInfo v1 = new SetIndicatorInfo(arg7);
        }
        else {
            v1_1 = arg6;
        }

        SetIndicatorInfo v0 = ((SetIndicatorInfo)v1_1);
        if(v0.setHomeAsUpIndicator != null) {
            try {
                ActionBar v2 = arg7.getActionBar();
                v0.setHomeActionContentDescription.invoke(v2, Integer.valueOf(arg8));
                if(Build$VERSION.SDK_INT > 19) {
                    return v1_1;
                }

                v2.setSubtitle(v2.getSubtitle());
            }
            catch(Exception v0_1) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set content description via JB-MR2 API", ((Throwable)v0_1));
            }
        }

        return v1_1;
    }

    public static Object setActionBarUpIndicator(Object arg6, Activity arg7, Drawable arg8, int arg9) {
        Object v1_1;
        if(arg6 == null) {
            SetIndicatorInfo v1 = new SetIndicatorInfo(arg7);
        }
        else {
            v1_1 = arg6;
        }

        SetIndicatorInfo v0 = ((SetIndicatorInfo)v1_1);
        if(v0.setHomeAsUpIndicator != null) {
            try {
                ActionBar v2 = arg7.getActionBar();
                v0.setHomeAsUpIndicator.invoke(v2, arg8);
                v0.setHomeActionContentDescription.invoke(v2, Integer.valueOf(arg9));
            }
            catch(Exception v0_1) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set home-as-up indicator via JB-MR2 API", ((Throwable)v0_1));
            }

            return v1_1;
        }

        if(v0.upIndicatorView != null) {
            v0.upIndicatorView.setImageDrawable(arg8);
        }
        else {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set home-as-up indicator");
        }

        return v1_1;
    }
}

