package android.support.v4.view.accessibility;

import android.os.Build$VERSION;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.List;

public final class AccessibilityManagerCompat {
    class AccessibilityManagerIcsImpl extends AccessibilityManagerStubImpl {
        AccessibilityManagerIcsImpl() {
            super();
        }

        public boolean addAccessibilityStateChangeListener(AccessibilityManager arg2, AccessibilityStateChangeListener arg3) {
            return AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(arg2, this.newAccessibilityStateChangeListener(arg3));
        }

        public List getEnabledAccessibilityServiceList(AccessibilityManager arg2, int arg3) {
            return AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(arg2, arg3);
        }

        public List getInstalledAccessibilityServiceList(AccessibilityManager arg2) {
            return AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(arg2);
        }

        public boolean isTouchExplorationEnabled(AccessibilityManager arg2) {
            return AccessibilityManagerCompatIcs.isTouchExplorationEnabled(arg2);
        }

        public AccessibilityStateChangeListenerWrapper newAccessibilityStateChangeListener(AccessibilityStateChangeListener arg3) {
            return new AccessibilityStateChangeListenerWrapper(arg3, new AccessibilityStateChangeListenerBridge(arg3) {
                public void onAccessibilityStateChanged(boolean arg2) {
                    this.val$listener.onAccessibilityStateChanged(arg2);
                }
            });
        }

        public boolean removeAccessibilityStateChangeListener(AccessibilityManager arg2, AccessibilityStateChangeListener arg3) {
            return AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(arg2, this.newAccessibilityStateChangeListener(arg3));
        }
    }

    class AccessibilityManagerKitKatImpl extends AccessibilityManagerIcsImpl {
        AccessibilityManagerKitKatImpl() {
            super();
        }

        public boolean addTouchExplorationStateChangeListener(AccessibilityManager arg2, TouchExplorationStateChangeListener arg3) {
            return AccessibilityManagerCompatKitKat.addTouchExplorationStateChangeListener(arg2, this.newTouchExplorationStateChangeListener(arg3));
        }

        public TouchExplorationStateChangeListenerWrapper newTouchExplorationStateChangeListener(TouchExplorationStateChangeListener arg3) {
            return new TouchExplorationStateChangeListenerWrapper(arg3, new TouchExplorationStateChangeListenerBridge(arg3) {
                public void onTouchExplorationStateChanged(boolean arg2) {
                    this.val$listener.onTouchExplorationStateChanged(arg2);
                }
            });
        }

        public boolean removeTouchExplorationStateChangeListener(AccessibilityManager arg2, TouchExplorationStateChangeListener arg3) {
            return AccessibilityManagerCompatKitKat.removeTouchExplorationStateChangeListener(arg2, this.newTouchExplorationStateChangeListener(arg3));
        }
    }

    class AccessibilityManagerStubImpl implements AccessibilityManagerVersionImpl {
        AccessibilityManagerStubImpl() {
            super();
        }

        public boolean addAccessibilityStateChangeListener(AccessibilityManager arg2, AccessibilityStateChangeListener arg3) {
            return 0;
        }

        public boolean addTouchExplorationStateChangeListener(AccessibilityManager arg2, TouchExplorationStateChangeListener arg3) {
            return 0;
        }

        public List getEnabledAccessibilityServiceList(AccessibilityManager arg2, int arg3) {
            return Collections.emptyList();
        }

        public List getInstalledAccessibilityServiceList(AccessibilityManager arg2) {
            return Collections.emptyList();
        }

        public boolean isTouchExplorationEnabled(AccessibilityManager arg2) {
            return 0;
        }

        public AccessibilityStateChangeListenerWrapper newAccessibilityStateChangeListener(AccessibilityStateChangeListener arg2) {
            return null;
        }

        public TouchExplorationStateChangeListenerWrapper newTouchExplorationStateChangeListener(TouchExplorationStateChangeListener arg2) {
            return null;
        }

        public boolean removeAccessibilityStateChangeListener(AccessibilityManager arg2, AccessibilityStateChangeListener arg3) {
            return 0;
        }

        public boolean removeTouchExplorationStateChangeListener(AccessibilityManager arg2, TouchExplorationStateChangeListener arg3) {
            return 0;
        }
    }

    interface AccessibilityManagerVersionImpl {
        boolean addAccessibilityStateChangeListener(AccessibilityManager arg1, AccessibilityStateChangeListener arg2);

        boolean addTouchExplorationStateChangeListener(AccessibilityManager arg1, TouchExplorationStateChangeListener arg2);

        List getEnabledAccessibilityServiceList(AccessibilityManager arg1, int arg2);

        List getInstalledAccessibilityServiceList(AccessibilityManager arg1);

        boolean isTouchExplorationEnabled(AccessibilityManager arg1);

        AccessibilityStateChangeListenerWrapper newAccessibilityStateChangeListener(AccessibilityStateChangeListener arg1);

        TouchExplorationStateChangeListenerWrapper newTouchExplorationStateChangeListener(TouchExplorationStateChangeListener arg1);

        boolean removeAccessibilityStateChangeListener(AccessibilityManager arg1, AccessibilityStateChangeListener arg2);

        boolean removeTouchExplorationStateChangeListener(AccessibilityManager arg1, TouchExplorationStateChangeListener arg2);
    }

    public interface AccessibilityStateChangeListener {
        void onAccessibilityStateChanged(boolean arg1);
    }

    @Deprecated public abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
        public AccessibilityStateChangeListenerCompat() {
            super();
        }
    }

    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean arg1);
    }

    private static final AccessibilityManagerVersionImpl IMPL;

    static {
        if(Build$VERSION.SDK_INT >= 19) {
            AccessibilityManagerCompat.IMPL = new AccessibilityManagerKitKatImpl();
        }
        else if(Build$VERSION.SDK_INT >= 14) {
            AccessibilityManagerCompat.IMPL = new AccessibilityManagerIcsImpl();
        }
        else {
            AccessibilityManagerCompat.IMPL = new AccessibilityManagerStubImpl();
        }
    }

    private AccessibilityManagerCompat() {
        super();
    }

    public static boolean addAccessibilityStateChangeListener(AccessibilityManager arg1, AccessibilityStateChangeListener arg2) {
        return AccessibilityManagerCompat.IMPL.addAccessibilityStateChangeListener(arg1, arg2);
    }

    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager arg1, TouchExplorationStateChangeListener arg2) {
        return AccessibilityManagerCompat.IMPL.addTouchExplorationStateChangeListener(arg1, arg2);
    }

    public static List getEnabledAccessibilityServiceList(AccessibilityManager arg1, int arg2) {
        return AccessibilityManagerCompat.IMPL.getEnabledAccessibilityServiceList(arg1, arg2);
    }

    public static List getInstalledAccessibilityServiceList(AccessibilityManager arg1) {
        return AccessibilityManagerCompat.IMPL.getInstalledAccessibilityServiceList(arg1);
    }

    public static boolean isTouchExplorationEnabled(AccessibilityManager arg1) {
        return AccessibilityManagerCompat.IMPL.isTouchExplorationEnabled(arg1);
    }

    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager arg1, AccessibilityStateChangeListener arg2) {
        return AccessibilityManagerCompat.IMPL.removeAccessibilityStateChangeListener(arg1, arg2);
    }

    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager arg1, TouchExplorationStateChangeListener arg2) {
        return AccessibilityManagerCompat.IMPL.removeTouchExplorationStateChangeListener(arg1, arg2);
    }
}

