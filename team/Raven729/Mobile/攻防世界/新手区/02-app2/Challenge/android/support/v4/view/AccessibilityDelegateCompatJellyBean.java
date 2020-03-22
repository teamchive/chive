package android.support.v4.view;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View$AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

@TargetApi(value=16) @RequiresApi(value=16) class AccessibilityDelegateCompatJellyBean {
    public interface AccessibilityDelegateBridgeJellyBean {
        boolean dispatchPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2);

        Object getAccessibilityNodeProvider(View arg1);

        void onInitializeAccessibilityEvent(View arg1, AccessibilityEvent arg2);

        void onInitializeAccessibilityNodeInfo(View arg1, Object arg2);

        void onPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2);

        boolean onRequestSendAccessibilityEvent(ViewGroup arg1, View arg2, AccessibilityEvent arg3);

        boolean performAccessibilityAction(View arg1, int arg2, Bundle arg3);

        void sendAccessibilityEvent(View arg1, int arg2);

        void sendAccessibilityEventUnchecked(View arg1, AccessibilityEvent arg2);
    }

    AccessibilityDelegateCompatJellyBean() {
        super();
    }

    public static Object getAccessibilityNodeProvider(Object arg1, View arg2) {
        return ((View$AccessibilityDelegate)arg1).getAccessibilityNodeProvider(arg2);
    }

    public static Object newAccessibilityDelegateBridge(AccessibilityDelegateBridgeJellyBean arg1) {
        return new View$AccessibilityDelegate(arg1) {
            public boolean dispatchPopulateAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                return this.val$bridge.dispatchPopulateAccessibilityEvent(arg2, arg3);
            }

            public AccessibilityNodeProvider getAccessibilityNodeProvider(View arg2) {
                return this.val$bridge.getAccessibilityNodeProvider(arg2);
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

            public boolean performAccessibilityAction(View arg2, int arg3, Bundle arg4) {
                return this.val$bridge.performAccessibilityAction(arg2, arg3, arg4);
            }

            public void sendAccessibilityEvent(View arg2, int arg3) {
                this.val$bridge.sendAccessibilityEvent(arg2, arg3);
            }

            public void sendAccessibilityEventUnchecked(View arg2, AccessibilityEvent arg3) {
                this.val$bridge.sendAccessibilityEventUnchecked(arg2, arg3);
            }
        };
    }

    public static boolean performAccessibilityAction(Object arg1, View arg2, int arg3, Bundle arg4) {
        return ((View$AccessibilityDelegate)arg1).performAccessibilityAction(arg2, arg3, arg4);
    }
}

