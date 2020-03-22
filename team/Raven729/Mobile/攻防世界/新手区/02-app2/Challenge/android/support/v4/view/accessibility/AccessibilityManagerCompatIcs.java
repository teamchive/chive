package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

@TargetApi(value=14) @RequiresApi(value=14) class AccessibilityManagerCompatIcs {
    interface AccessibilityStateChangeListenerBridge {
        void onAccessibilityStateChanged(boolean arg1);
    }

    public class AccessibilityStateChangeListenerWrapper implements AccessibilityManager$AccessibilityStateChangeListener {
        Object mListener;
        AccessibilityStateChangeListenerBridge mListenerBridge;

        public AccessibilityStateChangeListenerWrapper(Object arg1, AccessibilityStateChangeListenerBridge arg2) {
            super();
            this.mListener = arg1;
            this.mListenerBridge = arg2;
        }

        public boolean equals(Object arg5) {
            boolean v0 = true;
            if(this != (((AccessibilityStateChangeListenerWrapper)arg5))) {
                if(arg5 != null && this.getClass() == arg5.getClass()) {
                    if(this.mListener != null) {
                        v0 = this.mListener.equals(((AccessibilityStateChangeListenerWrapper)arg5).mListener);
                    }
                    else if(((AccessibilityStateChangeListenerWrapper)arg5).mListener != null) {
                        v0 = false;
                    }
                    else {
                    }

                    return v0;
                }

                v0 = false;
            }

            return v0;
        }

        public int hashCode() {
            int v0 = this.mListener == null ? 0 : this.mListener.hashCode();
            return v0;
        }

        public void onAccessibilityStateChanged(boolean arg2) {
            this.mListenerBridge.onAccessibilityStateChanged(arg2);
        }
    }

    AccessibilityManagerCompatIcs() {
        super();
    }

    public static boolean addAccessibilityStateChangeListener(AccessibilityManager arg1, AccessibilityStateChangeListenerWrapper arg2) {
        return arg1.addAccessibilityStateChangeListener(((AccessibilityManager$AccessibilityStateChangeListener)arg2));
    }

    public static List getEnabledAccessibilityServiceList(AccessibilityManager arg1, int arg2) {
        return arg1.getEnabledAccessibilityServiceList(arg2);
    }

    public static List getInstalledAccessibilityServiceList(AccessibilityManager arg1) {
        return arg1.getInstalledAccessibilityServiceList();
    }

    public static boolean isTouchExplorationEnabled(AccessibilityManager arg1) {
        return arg1.isTouchExplorationEnabled();
    }

    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager arg1, AccessibilityStateChangeListenerWrapper arg2) {
        return arg1.removeAccessibilityStateChangeListener(((AccessibilityManager$AccessibilityStateChangeListener)arg2));
    }
}

