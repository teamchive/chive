package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View$AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

@TargetApi(value=14) @RequiresApi(value=14) class AccessibilityDelegateCompatIcs {
    public interface AccessibilityDelegateBridge {
        boolean dispatchPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2);

        void onInitializeAccessibilityEvent(View arg1, AccessibilityEvent arg2);

        void onInitializeAccessibilityNodeInfo(View arg1, Object arg2);

        void onPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2);

        boolean onRequestSendAccessibilityEvent(ViewGroup arg1, View arg2, AccessibilityEvent arg3);

        void sendAccessibilityEvent(View arg1, int arg2);

        void sendAccessibilityEventUnchecked(View arg1, AccessibilityEvent arg2);
    }

    AccessibilityDelegateCompatIcs() {
        super();
    }

    public static boolean dispatchPopulateAccessibilityEvent(Object arg1, View arg2, AccessibilityEvent arg3) {
        return ((View$AccessibilityDelegate)arg1).dispatchPopulateAccessibilityEvent(arg2, arg3);
    }

    public static Object newAccessibilityDelegateBridge(AccessibilityDelegateBridge arg1) {
        return new View$AccessibilityDelegate(arg1) {
            public boolean dispatchPopulateAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                return this.val$bridge.dispatchPopulateAccessibilityEvent(arg2, arg3);
            }

            public void onInitializeAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                this.val$bridge.onInitializeAccessibilityEvent(arg2, arg3);
            }

            public void onInitializeAccessibilityNodeInfo(View arg2, AccessibilityNodeInfo arg3) {
                this.val$bridge.onInitializeAccessibilityNodeInfo(arg2, arg3);
            }

            public void onPopulateAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                this.val$bridge.onPopulateAccessibilityEvent(arg2, arg3);
            }

            public boolean onRequestSendAccessibilityEvent(ViewGroup arg2, View arg3, AccessibilityEvent arg4) {
                return this.val$bridge.onRequestSendAccessibilityEvent(arg2, arg3, arg4);
            }

            public void sendAccessibilityEvent(View arg2, int arg3) {
                this.val$bridge.sendAccessibilityEvent(arg2, arg3);
            }

            public void sendAccessibilityEventUnchecked(View arg2, AccessibilityEvent arg3) {
                this.val$bridge.sendAccessibilityEventUnchecked(arg2, arg3);
            }
        };
    }

    public static Object newAccessibilityDelegateDefaultImpl() {
        return new View$AccessibilityDelegate();
    }

    public static void onInitializeAccessibilityEvent(Object arg0, View arg1, AccessibilityEvent arg2) {
        ((View$AccessibilityDelegate)arg0).onInitializeAccessibilityEvent(arg1, arg2);
    }

    public static void onInitializeAccessibilityNodeInfo(Object arg0, View arg1, Object arg2) {
        ((View$AccessibilityDelegate)arg0).onInitializeAccessibilityNodeInfo(arg1, ((AccessibilityNodeInfo)arg2));
    }

    public static void onPopulateAccessibilityEvent(Object arg0, View arg1, AccessibilityEvent arg2) {
        ((View$AccessibilityDelegate)arg0).onPopulateAccessibilityEvent(arg1, arg2);
    }

    public static boolean onRequestSendAccessibilityEvent(Object arg1, ViewGroup arg2, View arg3, AccessibilityEvent arg4) {
        return ((View$AccessibilityDelegate)arg1).onRequestSendAccessibilityEvent(arg2, arg3, arg4);
    }

    public static void sendAccessibilityEvent(Object arg0, View arg1, int arg2) {
        ((View$AccessibilityDelegate)arg0).sendAccessibilityEvent(arg1, arg2);
    }

    public static void sendAccessibilityEventUnchecked(Object arg0, View arg1, AccessibilityEvent arg2) {
        ((View$AccessibilityDelegate)arg0).sendAccessibilityEventUnchecked(arg1, arg2);
    }
}

