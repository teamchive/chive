package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.WindowInsets;

@TargetApi(value=20) @RequiresApi(value=20) class WindowInsetsCompatApi20 {
    WindowInsetsCompatApi20() {
        super();
    }

    public static Object consumeSystemWindowInsets(Object arg1) {
        return ((WindowInsets)arg1).consumeSystemWindowInsets();
    }

    public static Object getSourceWindowInsets(Object arg1) {
        return new WindowInsets(((WindowInsets)arg1));
    }

    public static int getSystemWindowInsetBottom(Object arg1) {
        return ((WindowInsets)arg1).getSystemWindowInsetBottom();
    }

    public static int getSystemWindowInsetLeft(Object arg1) {
        return ((WindowInsets)arg1).getSystemWindowInsetLeft();
    }

    public static int getSystemWindowInsetRight(Object arg1) {
        return ((WindowInsets)arg1).getSystemWindowInsetRight();
    }

    public static int getSystemWindowInsetTop(Object arg1) {
        return ((WindowInsets)arg1).getSystemWindowInsetTop();
    }

    public static boolean hasInsets(Object arg1) {
        return ((WindowInsets)arg1).hasInsets();
    }

    public static boolean hasSystemWindowInsets(Object arg1) {
        return ((WindowInsets)arg1).hasSystemWindowInsets();
    }

    public static boolean isRound(Object arg1) {
        return ((WindowInsets)arg1).isRound();
    }

    public static Object replaceSystemWindowInsets(Object arg1, int arg2, int arg3, int arg4, int arg5) {
        return ((WindowInsets)arg1).replaceSystemWindowInsets(arg2, arg3, arg4, arg5);
    }
}

