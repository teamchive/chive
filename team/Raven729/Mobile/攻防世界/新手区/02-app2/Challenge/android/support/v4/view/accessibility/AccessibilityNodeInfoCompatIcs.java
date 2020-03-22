package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

@TargetApi(value=14) @RequiresApi(value=14) class AccessibilityNodeInfoCompatIcs {
    AccessibilityNodeInfoCompatIcs() {
        super();
    }

    public static void addAction(Object arg0, int arg1) {
        ((AccessibilityNodeInfo)arg0).addAction(arg1);
    }

    public static void addChild(Object arg0, View arg1) {
        ((AccessibilityNodeInfo)arg0).addChild(arg1);
    }

    public static List findAccessibilityNodeInfosByText(Object arg1, String arg2) {
        return ((AccessibilityNodeInfo)arg1).findAccessibilityNodeInfosByText(arg2);
    }

    public static int getActions(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getActions();
    }

    public static void getBoundsInParent(Object arg0, Rect arg1) {
        ((AccessibilityNodeInfo)arg0).getBoundsInParent(arg1);
    }

    public static void getBoundsInScreen(Object arg0, Rect arg1) {
        ((AccessibilityNodeInfo)arg0).getBoundsInScreen(arg1);
    }

    public static Object getChild(Object arg1, int arg2) {
        return ((AccessibilityNodeInfo)arg1).getChild(arg2);
    }

    public static int getChildCount(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getChildCount();
    }

    public static CharSequence getClassName(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getClassName();
    }

    public static CharSequence getContentDescription(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getContentDescription();
    }

    public static CharSequence getPackageName(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getPackageName();
    }

    public static Object getParent(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getParent();
    }

    public static CharSequence getText(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getText();
    }

    public static int getWindowId(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getWindowId();
    }

    public static boolean isCheckable(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isCheckable();
    }

    public static boolean isChecked(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isChecked();
    }

    public static boolean isClickable(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isClickable();
    }

    public static boolean isEnabled(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isEnabled();
    }

    public static boolean isFocusable(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isFocusable();
    }

    public static boolean isFocused(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isFocused();
    }

    public static boolean isLongClickable(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isLongClickable();
    }

    public static boolean isPassword(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isPassword();
    }

    public static boolean isScrollable(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isScrollable();
    }

    public static boolean isSelected(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isSelected();
    }

    public static Object obtain() {
        return AccessibilityNodeInfo.obtain();
    }

    public static Object obtain(View arg1) {
        return AccessibilityNodeInfo.obtain(arg1);
    }

    public static Object obtain(Object arg1) {
        return AccessibilityNodeInfo.obtain(((AccessibilityNodeInfo)arg1));
    }

    public static boolean performAction(Object arg1, int arg2) {
        return ((AccessibilityNodeInfo)arg1).performAction(arg2);
    }

    public static void recycle(Object arg0) {
        ((AccessibilityNodeInfo)arg0).recycle();
    }

    public static void setBoundsInParent(Object arg0, Rect arg1) {
        ((AccessibilityNodeInfo)arg0).setBoundsInParent(arg1);
    }

    public static void setBoundsInScreen(Object arg0, Rect arg1) {
        ((AccessibilityNodeInfo)arg0).setBoundsInScreen(arg1);
    }

    public static void setCheckable(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setCheckable(arg1);
    }

    public static void setChecked(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setChecked(arg1);
    }

    public static void setClassName(Object arg0, CharSequence arg1) {
        ((AccessibilityNodeInfo)arg0).setClassName(arg1);
    }

    public static void setClickable(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setClickable(arg1);
    }

    public static void setContentDescription(Object arg0, CharSequence arg1) {
        ((AccessibilityNodeInfo)arg0).setContentDescription(arg1);
    }

    public static void setEnabled(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setEnabled(arg1);
    }

    public static void setFocusable(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setFocusable(arg1);
    }

    public static void setFocused(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setFocused(arg1);
    }

    public static void setLongClickable(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setLongClickable(arg1);
    }

    public static void setPackageName(Object arg0, CharSequence arg1) {
        ((AccessibilityNodeInfo)arg0).setPackageName(arg1);
    }

    public static void setParent(Object arg0, View arg1) {
        ((AccessibilityNodeInfo)arg0).setParent(arg1);
    }

    public static void setPassword(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setPassword(arg1);
    }

    public static void setScrollable(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setScrollable(arg1);
    }

    public static void setSelected(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setSelected(arg1);
    }

    public static void setSource(Object arg0, View arg1) {
        ((AccessibilityNodeInfo)arg0).setSource(arg1);
    }

    public static void setText(Object arg0, CharSequence arg1) {
        ((AccessibilityNodeInfo)arg0).setText(arg1);
    }
}

