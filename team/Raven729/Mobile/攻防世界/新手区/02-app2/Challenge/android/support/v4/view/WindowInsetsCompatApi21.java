package android.support.v4.view;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.view.WindowInsets;

@TargetApi(value=21) @RequiresApi(value=21) class WindowInsetsCompatApi21 {
    WindowInsetsCompatApi21() {
        super();
    }

    public static Object consumeStableInsets(Object arg1) {
        return ((WindowInsets)arg1).consumeStableInsets();
    }

    public static int getStableInsetBottom(Object arg1) {
        return ((WindowInsets)arg1).getStableInsetBottom();
    }

    public static int getStableInsetLeft(Object arg1) {
        return ((WindowInsets)arg1).getStableInsetLeft();
    }

    public static int getStableInsetRight(Object arg1) {
        return ((WindowInsets)arg1).getStableInsetRight();
    }

    public static int getStableInsetTop(Object arg1) {
        return ((WindowInsets)arg1).getStableInsetTop();
    }

    public static boolean hasStableInsets(Object arg1) {
        return ((WindowInsets)arg1).hasStableInsets();
    }

    public static boolean isConsumed(Object arg1) {
        return ((WindowInsets)arg1).isConsumed();
    }

    public static Object replaceSystemWindowInsets(Object arg1, Rect arg2) {
        return ((WindowInsets)arg1).replaceSystemWindowInsets(arg2);
    }
}

