package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.View;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.WindowInsets;

@TargetApi(value=21) @RequiresApi(value=21) class DrawerLayoutCompatApi21 {
    class InsetsListener implements View$OnApplyWindowInsetsListener {
        InsetsListener() {
            super();
        }

        public WindowInsets onApplyWindowInsets(View arg2, WindowInsets arg3) {
            boolean v0 = arg3.getSystemWindowInsetTop() > 0 ? true : false;
            ((DrawerLayoutImpl)arg2).setChildInsets(arg3, v0);
            return arg3.consumeSystemWindowInsets();
        }
    }

    private static final int[] THEME_ATTRS;

    static {
        DrawerLayoutCompatApi21.THEME_ATTRS = new int[]{0x1010434};
    }

    DrawerLayoutCompatApi21() {
        super();
    }

    public static void applyMarginInsets(ViewGroup$MarginLayoutParams arg4, Object arg5, int arg6) {
        WindowInsets v5;
        if(arg6 == 3) {
            v5 = ((WindowInsets)arg5).replaceSystemWindowInsets(((WindowInsets)arg5).getSystemWindowInsetLeft(), ((WindowInsets)arg5).getSystemWindowInsetTop(), 0, ((WindowInsets)arg5).getSystemWindowInsetBottom());
        }
        else if(arg6 == 5) {
            v5 = ((WindowInsets)arg5).replaceSystemWindowInsets(0, ((WindowInsets)arg5).getSystemWindowInsetTop(), ((WindowInsets)arg5).getSystemWindowInsetRight(), ((WindowInsets)arg5).getSystemWindowInsetBottom());
        }

        arg4.leftMargin = v5.getSystemWindowInsetLeft();
        arg4.topMargin = v5.getSystemWindowInsetTop();
        arg4.rightMargin = v5.getSystemWindowInsetRight();
        arg4.bottomMargin = v5.getSystemWindowInsetBottom();
    }

    public static void configureApplyInsets(View arg1) {
        if((arg1 instanceof DrawerLayoutImpl)) {
            arg1.setOnApplyWindowInsetsListener(new InsetsListener());
            arg1.setSystemUiVisibility(0x500);
        }
    }

    public static void dispatchChildInsets(View arg4, Object arg5, int arg6) {
        WindowInsets v5;
        if(arg6 == 3) {
            v5 = ((WindowInsets)arg5).replaceSystemWindowInsets(((WindowInsets)arg5).getSystemWindowInsetLeft(), ((WindowInsets)arg5).getSystemWindowInsetTop(), 0, ((WindowInsets)arg5).getSystemWindowInsetBottom());
        }
        else if(arg6 == 5) {
            v5 = ((WindowInsets)arg5).replaceSystemWindowInsets(0, ((WindowInsets)arg5).getSystemWindowInsetTop(), ((WindowInsets)arg5).getSystemWindowInsetRight(), ((WindowInsets)arg5).getSystemWindowInsetBottom());
        }

        arg4.dispatchApplyWindowInsets(v5);
    }

    public static Drawable getDefaultStatusBarBackground(Context arg2) {
        Drawable v1_1;
        TypedArray v0 = arg2.obtainStyledAttributes(DrawerLayoutCompatApi21.THEME_ATTRS);
        try {
            v1_1 = v0.getDrawable(0);
        }
        catch(Throwable v1) {
            v0.recycle();
            throw v1;
        }

        v0.recycle();
        return v1_1;
    }

    public static int getTopInset(Object arg1) {
        int v0 = arg1 != null ? ((WindowInsets)arg1).getSystemWindowInsetTop() : 0;
        return v0;
    }
}

