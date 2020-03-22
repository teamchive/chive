package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityNodeInfo$CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo$RangeInfo;
import android.view.accessibility.AccessibilityNodeInfo;

@TargetApi(value=19) @RequiresApi(value=19) class AccessibilityNodeInfoCompatKitKat {
    class CollectionInfo {
        CollectionInfo() {
            super();
        }

        static int getColumnCount(Object arg1) {
            return ((AccessibilityNodeInfo$CollectionInfo)arg1).getColumnCount();
        }

        static int getRowCount(Object arg1) {
            return ((AccessibilityNodeInfo$CollectionInfo)arg1).getRowCount();
        }

        static boolean isHierarchical(Object arg1) {
            return ((AccessibilityNodeInfo$CollectionInfo)arg1).isHierarchical();
        }
    }

    class CollectionItemInfo {
        CollectionItemInfo() {
            super();
        }

        static int getColumnIndex(Object arg1) {
            return ((AccessibilityNodeInfo$CollectionItemInfo)arg1).getColumnIndex();
        }

        static int getColumnSpan(Object arg1) {
            return ((AccessibilityNodeInfo$CollectionItemInfo)arg1).getColumnSpan();
        }

        static int getRowIndex(Object arg1) {
            return ((AccessibilityNodeInfo$CollectionItemInfo)arg1).getRowIndex();
        }

        static int getRowSpan(Object arg1) {
            return ((AccessibilityNodeInfo$CollectionItemInfo)arg1).getRowSpan();
        }

        static boolean isHeading(Object arg1) {
            return ((AccessibilityNodeInfo$CollectionItemInfo)arg1).isHeading();
        }
    }

    class RangeInfo {
        RangeInfo() {
            super();
        }

        static float getCurrent(Object arg1) {
            return ((AccessibilityNodeInfo$RangeInfo)arg1).getCurrent();
        }

        static float getMax(Object arg1) {
            return ((AccessibilityNodeInfo$RangeInfo)arg1).getMax();
        }

        static float getMin(Object arg1) {
            return ((AccessibilityNodeInfo$RangeInfo)arg1).getMin();
        }

        static int getType(Object arg1) {
            return ((AccessibilityNodeInfo$RangeInfo)arg1).getType();
        }
    }

    private static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
    private static final String TRAITS_KEY = "android.view.accessibility.AccessibilityNodeInfo.traits";
    private static final long TRAIT_HAS_IMAGE = 1;
    private static final byte TRAIT_UNSET = -1;

    AccessibilityNodeInfoCompatKitKat() {
        super();
    }

    public static boolean canOpenPopup(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).canOpenPopup();
    }

    static Object getCollectionInfo(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getCollectionInfo();
    }

    static Object getCollectionItemInfo(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getCollectionItemInfo();
    }

    public static Bundle getExtras(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getExtras();
    }

    public static int getInputType(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getInputType();
    }

    static int getLiveRegion(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getLiveRegion();
    }

    static Object getRangeInfo(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).getRangeInfo();
    }

    public static CharSequence getRoleDescription(Object arg2) {
        return AccessibilityNodeInfoCompatKitKat.getExtras(arg2).getCharSequence("AccessibilityNodeInfo.roleDescription");
    }

    private static long getTraits(Object arg4) {
        return AccessibilityNodeInfoCompatKitKat.getExtras(arg4).getLong("android.view.accessibility.AccessibilityNodeInfo.traits", -1);
    }

    public static boolean isContentInvalid(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isContentInvalid();
    }

    public static boolean isDismissable(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isDismissable();
    }

    public static boolean isMultiLine(Object arg1) {
        return ((AccessibilityNodeInfo)arg1).isMultiLine();
    }

    public static Object obtainCollectionInfo(int arg1, int arg2, boolean arg3) {
        return AccessibilityNodeInfo$CollectionInfo.obtain(arg1, arg2, arg3);
    }

    public static Object obtainCollectionInfo(int arg1, int arg2, boolean arg3, int arg4) {
        return AccessibilityNodeInfo$CollectionInfo.obtain(arg1, arg2, arg3);
    }

    public static Object obtainCollectionItemInfo(int arg1, int arg2, int arg3, int arg4, boolean arg5) {
        return AccessibilityNodeInfo$CollectionItemInfo.obtain(arg1, arg2, arg3, arg4, arg5);
    }

    public static Object obtainRangeInfo(int arg1, float arg2, float arg3, float arg4) {
        return AccessibilityNodeInfo$RangeInfo.obtain(arg1, arg2, arg3, arg4);
    }

    public static void setCanOpenPopup(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setCanOpenPopup(arg1);
    }

    public static void setCollectionInfo(Object arg0, Object arg1) {
        ((AccessibilityNodeInfo)arg0).setCollectionInfo(((AccessibilityNodeInfo$CollectionInfo)arg1));
    }

    public static void setCollectionItemInfo(Object arg0, Object arg1) {
        ((AccessibilityNodeInfo)arg0).setCollectionItemInfo(((AccessibilityNodeInfo$CollectionItemInfo)arg1));
    }

    public static void setContentInvalid(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setContentInvalid(arg1);
    }

    public static void setDismissable(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setDismissable(arg1);
    }

    public static void setInputType(Object arg0, int arg1) {
        ((AccessibilityNodeInfo)arg0).setInputType(arg1);
    }

    static void setLiveRegion(Object arg0, int arg1) {
        ((AccessibilityNodeInfo)arg0).setLiveRegion(arg1);
    }

    public static void setMultiLine(Object arg0, boolean arg1) {
        ((AccessibilityNodeInfo)arg0).setMultiLine(arg1);
    }

    public static void setRangeInfo(Object arg0, Object arg1) {
        ((AccessibilityNodeInfo)arg0).setRangeInfo(((AccessibilityNodeInfo$RangeInfo)arg1));
    }

    public static void setRoleDescription(Object arg2, CharSequence arg3) {
        AccessibilityNodeInfoCompatKitKat.getExtras(arg2).putCharSequence("AccessibilityNodeInfo.roleDescription", arg3);
    }

    private static void setTrait(Object arg5, long arg6) {
        Bundle v0 = AccessibilityNodeInfoCompatKitKat.getExtras(arg5);
        v0.putLong("android.view.accessibility.AccessibilityNodeInfo.traits", v0.getLong("android.view.accessibility.AccessibilityNodeInfo.traits", 0) | arg6);
    }
}

