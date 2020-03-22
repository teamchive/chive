package android.support.v4.h.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class c {
    interface a {
        Object a(int arg1);

        List a(String arg1, int arg2);

        boolean a(int arg1, int arg2, Bundle arg3);
    }

    public static Object a(a arg1) {
        return new AccessibilityNodeProvider(arg1) {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int arg2) {
                return this.a.a(arg2);
            }

            public List findAccessibilityNodeInfosByText(String arg2, int arg3) {
                return this.a.a(arg2, arg3);
            }

            public boolean performAction(int arg2, int arg3, Bundle arg4) {
                return this.a.a(arg2, arg3, arg4);
            }
        };
    }
}

