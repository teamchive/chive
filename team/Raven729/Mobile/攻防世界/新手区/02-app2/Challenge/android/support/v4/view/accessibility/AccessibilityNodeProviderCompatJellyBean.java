package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

@TargetApi(value=16) @RequiresApi(value=16) class AccessibilityNodeProviderCompatJellyBean {
    interface AccessibilityNodeInfoBridge {
        Object createAccessibilityNodeInfo(int arg1);

        List findAccessibilityNodeInfosByText(String arg1, int arg2);

        boolean performAction(int arg1, int arg2, Bundle arg3);
    }

    AccessibilityNodeProviderCompatJellyBean() {
        super();
    }

    public static Object newAccessibilityNodeProviderBridge(AccessibilityNodeInfoBridge arg1) {
        return new AccessibilityNodeProvider(arg1) {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int arg2) {
                return this.val$bridge.createAccessibilityNodeInfo(arg2);
            }

            public List findAccessibilityNodeInfosByText(String arg2, int arg3) {
                return this.val$bridge.findAccessibilityNodeInfosByText(arg2, arg3);
            }

            public boolean performAction(int arg2, int arg3, Bundle arg4) {
                return this.val$bridge.performAction(arg2, arg3, arg4);
            }
        };
    }
}

