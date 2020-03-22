package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo$CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

@TargetApi(value=21) @RequiresApi(value=21) class AccessibilityNodeInfoCompatApi21 {
    class CollectionInfo {
        CollectionInfo() {
            super();
        }

        public static int getSelectionMode(Object arg1) {
            return ((AccessibilityNodeInfo$CollectionInfo)arg1).getSelectionMode();
        }
    }

    class CollectionItemInfo {
        CollectionItemInfo() {
            super();
        }

        public static boolean isSelected(Object arg1) {
            return ((AccessibilityNodeInfo$CollectionItemInfo)arg1).isSelected();
        }
    }

    AccessibilityNodeInfoCompatApi21() {
        super();
    }

    static void addAction(Object arg0, Object arg1) {
        ((AccessibilityNodeInfo)arg0).addAction(((AccessibilityNodeInfo$AccessibilityAction)arg1));
    }

    static int getAccessibilityActionId(Object arg1) {
        return ((AccessibilityNodeInfo$AccessibilityAction)arg1).getId();
    }

    static CharSequence getAccessibilityActionLabel(Object arg1) {
        return ((AccessibilityNodeInfo$AccessibilityAction)arg1).getLabel();
    }

    static List getActionList(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getActionList();
    }

    public static CharSequence getError(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getError();
    }

    public static int getMaxTextLength(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getMaxTextLength();
    }

    public static Object getWindow(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getWindow();
    }

    static Object newAccessibilityAction(int arg1, CharSequence arg2) {
        return new AccessibilityNodeInfo$AccessibilityAction(arg1, arg2);
    }

    public static Object obtainCollectionInfo(int arg1, int arg2, boolean arg3, int arg4) {
        return AccessibilityNodeInfo$CollectionInfo.obtain(arg1, arg2, arg3, arg4);
    }

    public static Object obtainCollectionItemInfo(int arg1, int arg2, int arg3, int arg4, boolean arg5, boolean arg6) {
        return AccessibilityNodeInfo$CollectionItemInfo.obtain(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static boolean removeAction(Object arg1, Object arg2) {
        return ((AccessibilityNodeInfo)arg1).removeAction(((AccessibilityNodeInfo$AccessibilityAction)arg2));
    }

    public static boolean removeChild(Object arg1, View arg2) {
        return ((AccessibilityNodeInfo)arg1).removeChild(arg2);
    }

    public static boolean removeChild(Object arg1, View arg2, int arg3) {
        return ((AccessibilityNodeInfo)arg1).removeChild(arg2, arg3);
    }

    public static void setError(Object arg0, CharSequence arg1) {
        ((AccessibilityNodeInfo)arg0).setError(arg1);
    }

    public static void setMaxTextLength(Object arg0, int arg1) {
        ((AccessibilityNodeInfo)arg0).setMaxTextLength(arg1);
    }
}

