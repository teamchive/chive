package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import java.util.List;

@TargetApi(value=14) @RequiresApi(value=14) class AccessibilityRecordCompatIcs {
    AccessibilityRecordCompatIcs() {
        super();
    }

    public static int getAddedCount(Object arg1) {
        return ((AccessibilityRecord)arg1).getAddedCount();
    }

    public static CharSequence getBeforeText(Object arg1) {
        return ((AccessibilityRecord)arg1).getBeforeText();
    }

    public static CharSequence getClassName(Object arg1) {
        return ((AccessibilityRecord)arg1).getClassName();
    }

    public static CharSequence getContentDescription(Object arg1) {
        return ((AccessibilityRecord)arg1).getContentDescription();
    }

    public static int getCurrentItemIndex(Object arg1) {
        return ((AccessibilityRecord)arg1).getCurrentItemIndex();
    }

    public static int getFromIndex(Object arg1) {
        return ((AccessibilityRecord)arg1).getFromIndex();
    }

    public static int getItemCount(Object arg1) {
        return ((AccessibilityRecord)arg1).getItemCount();
    }

    public static Parcelable getParcelableData(Object arg1) {
        return ((AccessibilityRecord)arg1).getParcelableData();
    }

    public static int getRemovedCount(Object arg1) {
        return ((AccessibilityRecord)arg1).getRemovedCount();
    }

    public static int getScrollX(Object arg1) {
        return ((AccessibilityRecord)arg1).getScrollX();
    }

    public static int getScrollY(Object arg1) {
        return ((AccessibilityRecord)arg1).getScrollY();
    }

    public static Object getSource(Object arg1) {
        return ((AccessibilityRecord)arg1).getSource();
    }

    public static List getText(Object arg1) {
        return ((AccessibilityRecord)arg1).getText();
    }

    public static int getToIndex(Object arg1) {
        return ((AccessibilityRecord)arg1).getToIndex();
    }

    public static int getWindowId(Object arg1) {
        return ((AccessibilityRecord)arg1).getWindowId();
    }

    public static boolean isChecked(Object arg1) {
        return ((AccessibilityRecord)arg1).isChecked();
    }

    public static boolean isEnabled(Object arg1) {
        return ((AccessibilityRecord)arg1).isEnabled();
    }

    public static boolean isFullScreen(Object arg1) {
        return ((AccessibilityRecord)arg1).isFullScreen();
    }

    public static boolean isPassword(Object arg1) {
        return ((AccessibilityRecord)arg1).isPassword();
    }

    public static boolean isScrollable(Object arg1) {
        return ((AccessibilityRecord)arg1).isScrollable();
    }

    public static Object obtain() {
        return AccessibilityRecord.obtain();
    }

    public static Object obtain(Object arg1) {
        return AccessibilityRecord.obtain(((AccessibilityRecord)arg1));
    }

    public static void recycle(Object arg0) {
        ((AccessibilityRecord)arg0).recycle();
    }

    public static void setAddedCount(Object arg0, int arg1) {
        ((AccessibilityRecord)arg0).setAddedCount(arg1);
    }

    public static void setBeforeText(Object arg0, CharSequence arg1) {
        ((AccessibilityRecord)arg0).setBeforeText(arg1);
    }

    public static void setChecked(Object arg0, boolean arg1) {
        ((AccessibilityRecord)arg0).setChecked(arg1);
    }

    public static void setClassName(Object arg0, CharSequence arg1) {
        ((AccessibilityRecord)arg0).setClassName(arg1);
    }

    public static void setContentDescription(Object arg0, CharSequence arg1) {
        ((AccessibilityRecord)arg0).setContentDescription(arg1);
    }

    public static void setCurrentItemIndex(Object arg0, int arg1) {
        ((AccessibilityRecord)arg0).setCurrentItemIndex(arg1);
    }

    public static void setEnabled(Object arg0, boolean arg1) {
        ((AccessibilityRecord)arg0).setEnabled(arg1);
    }

    public static void setFromIndex(Object arg0, int arg1) {
        ((AccessibilityRecord)arg0).setFromIndex(arg1);
    }

    public static void setFullScreen(Object arg0, boolean arg1) {
        ((AccessibilityRecord)arg0).setFullScreen(arg1);
    }

    public static void setItemCount(Object arg0, int arg1) {
        ((AccessibilityRecord)arg0).setItemCount(arg1);
    }

    public static void setParcelableData(Object arg0, Parcelable arg1) {
        ((AccessibilityRecord)arg0).setParcelableData(arg1);
    }

    public static void setPassword(Object arg0, boolean arg1) {
        ((AccessibilityRecord)arg0).setPassword(arg1);
    }

    public static void setRemovedCount(Object arg0, int arg1) {
        ((AccessibilityRecord)arg0).setRemovedCount(arg1);
    }

    public static void setScrollX(Object arg0, int arg1) {
        ((AccessibilityRecord)arg0).setScrollX(arg1);
    }

    public static void setScrollY(Object arg0, int arg1) {
        ((AccessibilityRecord)arg0).setScrollY(arg1);
    }

    public static void setScrollable(Object arg0, boolean arg1) {
        ((AccessibilityRecord)arg0).setScrollable(arg1);
    }

    public static void setSource(Object arg0, View arg1) {
        ((AccessibilityRecord)arg0).setSource(arg1);
    }

    public static void setToIndex(Object arg0, int arg1) {
        ((AccessibilityRecord)arg0).setToIndex(arg1);
    }
}

