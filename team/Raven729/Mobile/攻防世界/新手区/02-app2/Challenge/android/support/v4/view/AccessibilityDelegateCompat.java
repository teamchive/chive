package android.support.v4.view;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityDelegateCompat {
    class AccessibilityDelegateIcsImpl extends AccessibilityDelegateStubImpl {
        AccessibilityDelegateIcsImpl() {
            super();
        }

        public boolean dispatchPopulateAccessibilityEvent(Object arg2, View arg3, AccessibilityEvent arg4) {
            return AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(arg2, arg3, arg4);
        }

        public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat arg2) {
            return AccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(new AccessibilityDelegateBridge(arg2) {
                public boolean dispatchPopulateAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                    return this.val$compat.dispatchPopulateAccessibilityEvent(arg2, arg3);
                }

                public void onInitializeAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                    this.val$compat.onInitializeAccessibilityEvent(arg2, arg3);
                }

                public void onInitializeAccessibilityNodeInfo(View arg3, Object arg4) {
                    this.val$compat.onInitializeAccessibilityNodeInfo(arg3, new AccessibilityNodeInfoCompat(arg4));
                }

                public void onPopulateAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                    this.val$compat.onPopulateAccessibilityEvent(arg2, arg3);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup arg2, View arg3, AccessibilityEvent arg4) {
                    return this.val$compat.onRequestSendAccessibilityEvent(arg2, arg3, arg4);
                }

                public void sendAccessibilityEvent(View arg2, int arg3) {
                    this.val$compat.sendAccessibilityEvent(arg2, arg3);
                }

                public void sendAccessibilityEventUnchecked(View arg2, AccessibilityEvent arg3) {
                    this.val$compat.sendAccessibilityEventUnchecked(arg2, arg3);
                }
            });
        }

        public Object newAccessiblityDelegateDefaultImpl() {
            return AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
        }

        public void onInitializeAccessibilityEvent(Object arg1, View arg2, AccessibilityEvent arg3) {
            AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(arg1, arg2, arg3);
        }

        public void onInitializeAccessibilityNodeInfo(Object arg2, View arg3, AccessibilityNodeInfoCompat arg4) {
            AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(arg2, arg3, arg4.getInfo());
        }

        public void onPopulateAccessibilityEvent(Object arg1, View arg2, AccessibilityEvent arg3) {
            AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(arg1, arg2, arg3);
        }

        public boolean onRequestSendAccessibilityEvent(Object arg2, ViewGroup arg3, View arg4, AccessibilityEvent arg5) {
            return AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(arg2, arg3, arg4, arg5);
        }

        public void sendAccessibilityEvent(Object arg1, View arg2, int arg3) {
            AccessibilityDelegateCompatIcs.sendAccessibilityEvent(arg1, arg2, arg3);
        }

        public void sendAccessibilityEventUnchecked(Object arg1, View arg2, AccessibilityEvent arg3) {
            AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(arg1, arg2, arg3);
        }
    }

    interface AccessibilityDelegateImpl {
        boolean dispatchPopulateAccessibilityEvent(Object arg1, View arg2, AccessibilityEvent arg3);

        AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object arg1, View arg2);

        Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat arg1);

        Object newAccessiblityDelegateDefaultImpl();

        void onInitializeAccessibilityEvent(Object arg1, View arg2, AccessibilityEvent arg3);

        void onInitializeAccessibilityNodeInfo(Object arg1, View arg2, AccessibilityNodeInfoCompat arg3);

        void onPopulateAccessibilityEvent(Object arg1, View arg2, AccessibilityEvent arg3);

        boolean onRequestSendAccessibilityEvent(Object arg1, ViewGroup arg2, View arg3, AccessibilityEvent arg4);

        boolean performAccessibilityAction(Object arg1, View arg2, int arg3, Bundle arg4);

        void sendAccessibilityEvent(Object arg1, View arg2, int arg3);

        void sendAccessibilityEventUnchecked(Object arg1, View arg2, AccessibilityEvent arg3);
    }

    class AccessibilityDelegateJellyBeanImpl extends AccessibilityDelegateIcsImpl {
        AccessibilityDelegateJellyBeanImpl() {
            super();
        }

        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object arg3, View arg4) {
            Object v1 = AccessibilityDelegateCompatJellyBean.getAccessibilityNodeProvider(arg3, arg4);
            AccessibilityNodeProviderCompat v0 = v1 != null ? new AccessibilityNodeProviderCompat(v1) : null;
            return v0;
        }

        public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat arg2) {
            return AccessibilityDelegateCompatJellyBean.newAccessibilityDelegateBridge(new AccessibilityDelegateBridgeJellyBean(arg2) {
                public boolean dispatchPopulateAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                    return this.val$compat.dispatchPopulateAccessibilityEvent(arg2, arg3);
                }

                public Object getAccessibilityNodeProvider(View arg2) {
                    AccessibilityNodeProviderCompat v0 = this.val$compat.getAccessibilityNodeProvider(arg2);
                    Object v0_1 = v0 != null ? v0.getProvider() : null;
                    return v0_1;
                }

                public void onInitializeAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                    this.val$compat.onInitializeAccessibilityEvent(arg2, arg3);
                }

                public void onInitializeAccessibilityNodeInfo(View arg3, Object arg4) {
                    this.val$compat.onInitializeAccessibilityNodeInfo(arg3, new AccessibilityNodeInfoCompat(arg4));
                }

                public void onPopulateAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                    this.val$compat.onPopulateAccessibilityEvent(arg2, arg3);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup arg2, View arg3, AccessibilityEvent arg4) {
                    return this.val$compat.onRequestSendAccessibilityEvent(arg2, arg3, arg4);
                }

                public boolean performAccessibilityAction(View arg2, int arg3, Bundle arg4) {
                    return this.val$compat.performAccessibilityAction(arg2, arg3, arg4);
                }

                public void sendAccessibilityEvent(View arg2, int arg3) {
                    this.val$compat.sendAccessibilityEvent(arg2, arg3);
                }

                public void sendAccessibilityEventUnchecked(View arg2, AccessibilityEvent arg3) {
                    this.val$compat.sendAccessibilityEventUnchecked(arg2, arg3);
                }
            });
        }

        public boolean performAccessibilityAction(Object arg2, View arg3, int arg4, Bundle arg5) {
            return AccessibilityDelegateCompatJellyBean.performAccessibilityAction(arg2, arg3, arg4, arg5);
        }
    }

    class AccessibilityDelegateStubImpl implements AccessibilityDelegateImpl {
        AccessibilityDelegateStubImpl() {
            super();
        }

        public boolean dispatchPopulateAccessibilityEvent(Object arg2, View arg3, AccessibilityEvent arg4) {
            return 0;
        }

        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object arg2, View arg3) {
            return null;
        }

        public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat arg2) {
            return null;
        }

        public Object newAccessiblityDelegateDefaultImpl() {
            return null;
        }

        public void onInitializeAccessibilityEvent(Object arg1, View arg2, AccessibilityEvent arg3) {
        }

        public void onInitializeAccessibilityNodeInfo(Object arg1, View arg2, AccessibilityNodeInfoCompat arg3) {
        }

        public void onPopulateAccessibilityEvent(Object arg1, View arg2, AccessibilityEvent arg3) {
        }

        public boolean onRequestSendAccessibilityEvent(Object arg2, ViewGroup arg3, View arg4, AccessibilityEvent arg5) {
            return 1;
        }

        public boolean performAccessibilityAction(Object arg2, View arg3, int arg4, Bundle arg5) {
            return 0;
        }

        public void sendAccessibilityEvent(Object arg1, View arg2, int arg3) {
        }

        public void sendAccessibilityEventUnchecked(Object arg1, View arg2, AccessibilityEvent arg3) {
        }
    }

    private static final Object DEFAULT_DELEGATE;
    private static final AccessibilityDelegateImpl IMPL;
    final Object mBridge;

    static {
        if(Build$VERSION.SDK_INT >= 16) {
            AccessibilityDelegateCompat.IMPL = new AccessibilityDelegateJellyBeanImpl();
        }
        else if(Build$VERSION.SDK_INT >= 14) {
            AccessibilityDelegateCompat.IMPL = new AccessibilityDelegateIcsImpl();
        }
        else {
            AccessibilityDelegateCompat.IMPL = new AccessibilityDelegateStubImpl();
        }

        AccessibilityDelegateCompat.DEFAULT_DELEGATE = AccessibilityDelegateCompat.IMPL.newAccessiblityDelegateDefaultImpl();
    }

    public AccessibilityDelegateCompat() {
        super();
        this.mBridge = AccessibilityDelegateCompat.IMPL.newAccessiblityDelegateBridge(this);
    }

    public boolean dispatchPopulateAccessibilityEvent(View arg3, AccessibilityEvent arg4) {
        return AccessibilityDelegateCompat.IMPL.dispatchPopulateAccessibilityEvent(AccessibilityDelegateCompat.DEFAULT_DELEGATE, arg3, arg4);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View arg3) {
        return AccessibilityDelegateCompat.IMPL.getAccessibilityNodeProvider(AccessibilityDelegateCompat.DEFAULT_DELEGATE, arg3);
    }

    Object getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View arg3, AccessibilityEvent arg4) {
        AccessibilityDelegateCompat.IMPL.onInitializeAccessibilityEvent(AccessibilityDelegateCompat.DEFAULT_DELEGATE, arg3, arg4);
    }

    public void onInitializeAccessibilityNodeInfo(View arg3, AccessibilityNodeInfoCompat arg4) {
        AccessibilityDelegateCompat.IMPL.onInitializeAccessibilityNodeInfo(AccessibilityDelegateCompat.DEFAULT_DELEGATE, arg3, arg4);
    }

    public void onPopulateAccessibilityEvent(View arg3, AccessibilityEvent arg4) {
        AccessibilityDelegateCompat.IMPL.onPopulateAccessibilityEvent(AccessibilityDelegateCompat.DEFAULT_DELEGATE, arg3, arg4);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup arg3, View arg4, AccessibilityEvent arg5) {
        return AccessibilityDelegateCompat.IMPL.onRequestSendAccessibilityEvent(AccessibilityDelegateCompat.DEFAULT_DELEGATE, arg3, arg4, arg5);
    }

    public boolean performAccessibilityAction(View arg3, int arg4, Bundle arg5) {
        return AccessibilityDelegateCompat.IMPL.performAccessibilityAction(AccessibilityDelegateCompat.DEFAULT_DELEGATE, arg3, arg4, arg5);
    }

    public void sendAccessibilityEvent(View arg3, int arg4) {
        AccessibilityDelegateCompat.IMPL.sendAccessibilityEvent(AccessibilityDelegateCompat.DEFAULT_DELEGATE, arg3, arg4);
    }

    public void sendAccessibilityEventUnchecked(View arg3, AccessibilityEvent arg4) {
        AccessibilityDelegateCompat.IMPL.sendAccessibilityEventUnchecked(AccessibilityDelegateCompat.DEFAULT_DELEGATE, arg3, arg4);
    }
}

