package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener;
import android.view.accessibility.AccessibilityManager;

@TargetApi(value=19) @RequiresApi(value=19) class AccessibilityManagerCompatKitKat {
    interface TouchExplorationStateChangeListenerBridge {
        void onTouchExplorationStateChanged(boolean arg1);
    }

    public class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager$TouchExplorationStateChangeListener {
        final Object mListener;
        final TouchExplorationStateChangeListenerBridge mListenerBridge;

        public TouchExplorationStateChangeListenerWrapper(Object arg1, TouchExplorationStateChangeListenerBridge arg2) {
            super();
            this.mListener = arg1;
            this.mListenerBridge = arg2;
        }

        public boolean equals(Object arg5) {
            boolean v0 = true;
            if(this != (((TouchExplorationStateChangeListenerWrapper)arg5))) {
                if(arg5 != null && this.getClass() == arg5.getClass()) {
                    if(this.mListener != null) {
                        v0 = this.mListener.equals(((TouchExplorationStateChangeListenerWrapper)arg5).mListener);
                    }
                    else if(((TouchExplorationStateChangeListenerWrapper)arg5).mListener != null) {
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

        public void onTouchExplorationStateChanged(boolean arg2) {
            this.mListenerBridge.onTouchExplorationStateChanged(arg2);
        }
    }

    AccessibilityManagerCompatKitKat() {
        super();
    }

    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager arg1, Object arg2) {
        return arg1.addTouchExplorationStateChangeListener(((AccessibilityManager$TouchExplorationStateChangeListener)arg2));
    }

    public static Object newTouchExplorationStateChangeListener(TouchExplorationStateChangeListenerBridge arg1) {
        return new AccessibilityManager$TouchExplorationStateChangeListener(arg1) {
            public void onTouchExplorationStateChanged(boolean arg2) {
                this.val$bridge.onTouchExplorationStateChanged(arg2);
            }
        };
    }

    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager arg1, Object arg2) {
        return arg1.removeTouchExplorationStateChangeListener(((AccessibilityManager$TouchExplorationStateChangeListener)arg2));
    }
}

