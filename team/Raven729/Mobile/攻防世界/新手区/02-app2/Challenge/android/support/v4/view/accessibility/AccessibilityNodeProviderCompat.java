package android.support.v4.view.accessibility;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat {
    interface AccessibilityNodeProviderImpl {
        Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat arg1);
    }

    class AccessibilityNodeProviderJellyBeanImpl extends AccessibilityNodeProviderStubImpl {
        AccessibilityNodeProviderJellyBeanImpl() {
            super();
        }

        public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat arg2) {
            return AccessibilityNodeProviderCompatJellyBean.newAccessibilityNodeProviderBridge(new AccessibilityNodeInfoBridge(arg2) {
                public Object createAccessibilityNodeInfo(int arg2) {
                    AccessibilityNodeInfoCompat v0 = this.val$compat.createAccessibilityNodeInfo(arg2);
                    Object v0_1 = v0 == null ? null : v0.getInfo();
                    return v0_1;
                }

                public List findAccessibilityNodeInfosByText(String arg6, int arg7) {
                    List v0;
                    List v3 = this.val$compat.findAccessibilityNodeInfosByText(arg6, arg7);
                    if(v3 == null) {
                        v0 = null;
                    }
                    else {
                        ArrayList v1 = new ArrayList();
                        int v4 = v3.size();
                        int v2;
                        for(v2 = 0; v2 < v4; ++v2) {
                            ((List)v1).add(v3.get(v2).getInfo());
                        }

                        ArrayList v0_1 = v1;
                    }

                    return v0;
                }

                public boolean performAction(int arg2, int arg3, Bundle arg4) {
                    return this.val$compat.performAction(arg2, arg3, arg4);
                }
            });
        }
    }

    class AccessibilityNodeProviderKitKatImpl extends AccessibilityNodeProviderStubImpl {
        AccessibilityNodeProviderKitKatImpl() {
            super();
        }

        public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat arg2) {
            return AccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge(new android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat$AccessibilityNodeInfoBridge(arg2) {
                public Object createAccessibilityNodeInfo(int arg2) {
                    AccessibilityNodeInfoCompat v0 = this.val$compat.createAccessibilityNodeInfo(arg2);
                    Object v0_1 = v0 == null ? null : v0.getInfo();
                    return v0_1;
                }

                public List findAccessibilityNodeInfosByText(String arg6, int arg7) {
                    ArrayList v0_1;
                    List v3 = this.val$compat.findAccessibilityNodeInfosByText(arg6, arg7);
                    if(v3 == null) {
                        List v0 = null;
                    }
                    else {
                        ArrayList v1 = new ArrayList();
                        int v4 = v3.size();
                        int v2;
                        for(v2 = 0; v2 < v4; ++v2) {
                            ((List)v1).add(v3.get(v2).getInfo());
                        }

                        v0_1 = v1;
                    }

                    return ((List)v0_1);
                }

                public Object findFocus(int arg2) {
                    AccessibilityNodeInfoCompat v0 = this.val$compat.findFocus(arg2);
                    Object v0_1 = v0 == null ? null : v0.getInfo();
                    return v0_1;
                }

                public boolean performAction(int arg2, int arg3, Bundle arg4) {
                    return this.val$compat.performAction(arg2, arg3, arg4);
                }
            });
        }
    }

    class AccessibilityNodeProviderStubImpl implements AccessibilityNodeProviderImpl {
        AccessibilityNodeProviderStubImpl() {
            super();
        }

        public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat arg2) {
            return null;
        }
    }

    public static final int HOST_VIEW_ID = -1;
    private static final AccessibilityNodeProviderImpl IMPL;
    private final Object mProvider;

    static {
        if(Build$VERSION.SDK_INT >= 19) {
            AccessibilityNodeProviderCompat.IMPL = new AccessibilityNodeProviderKitKatImpl();
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            AccessibilityNodeProviderCompat.IMPL = new AccessibilityNodeProviderJellyBeanImpl();
        }
        else {
            AccessibilityNodeProviderCompat.IMPL = new AccessibilityNodeProviderStubImpl();
        }
    }

    public AccessibilityNodeProviderCompat(Object arg1) {
        super();
        this.mProvider = arg1;
    }

    public AccessibilityNodeProviderCompat() {
        super();
        this.mProvider = AccessibilityNodeProviderCompat.IMPL.newAccessibilityNodeProviderBridge(this);
    }

    @Nullable public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int arg2) {
        return null;
    }

    @Nullable public List findAccessibilityNodeInfosByText(String arg2, int arg3) {
        return null;
    }

    @Nullable public AccessibilityNodeInfoCompat findFocus(int arg2) {
        return null;
    }

    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int arg2, int arg3, Bundle arg4) {
        return 0;
    }
}

