package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityWindowInfo;

@TargetApi(value=21) @RequiresApi(value=21) class AccessibilityWindowInfoCompatApi21 {
    AccessibilityWindowInfoCompatApi21() {
        super();
    }

    public static void getBoundsInScreen(Object arg0, Rect arg1) {
        ((AccessibilityWindowInfo)arg0).getBoundsInScreen(arg1);
    }

    public static Object getChild(Object arg1, int arg2) {
        return ((AccessibilityWindowInfo)arg1).getChild(arg2);
    }

    public static int getChildCount(Object arg1) {
        return ((AccessibilityWindowInfo)arg1).getChildCount();
    }

    public static int getId(Object arg1) {
        return ((AccessibilityWindowInfo)arg1).getId();
    }

    public static int getLayer(Object arg1) {
        return ((AccessibilityWindowInfo)arg1).getLayer();
    }

    public static Object getParent(Object arg1) {
        return ((AccessibilityWindowInfo)arg1).getParent();
    }

    public static Object getRoot(Object arg1) {
        return ((AccessibilityWindowInfo)arg1).getRoot();
    }

    public static int getType(Object arg1) {
        return ((AccessibilityWindowInfo)arg1).getType();
    }

    public static boolean isAccessibilityFocused(Object arg1) {
        return ((AccessibilityWindowInfo)arg1).isAccessibilityFocused();
    }

    public static boolean isActive(Object arg1) {
        return ((AccessibilityWindowInfo)arg1).isActive();
    }

    public static boolean isFocused(Object arg1) {
        return ((AccessibilityWindowInfo)arg1).isFocused();
    }

    public static Object obtain() {
        return AccessibilityWindowInfo.obtain();
    }

    public static Object obtain(Object arg1) {
        return AccessibilityWindowInfo.obtain(((AccessibilityWindowInfo)arg1));
    }

    public static void recycle(Object arg0) {
        ((AccessibilityWindowInfo)arg0).recycle();
    }
}

