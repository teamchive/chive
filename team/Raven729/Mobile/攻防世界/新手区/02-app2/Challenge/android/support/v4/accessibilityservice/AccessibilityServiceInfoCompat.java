package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build$VERSION;

public final class AccessibilityServiceInfoCompat {
    class AccessibilityServiceInfoIcsImpl extends AccessibilityServiceInfoStubImpl {
        AccessibilityServiceInfoIcsImpl() {
            super();
        }

        public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo arg2) {
            return AccessibilityServiceInfoCompatIcs.getCanRetrieveWindowContent(arg2);
        }

        public int getCapabilities(AccessibilityServiceInfo arg2) {
            int v0 = this.getCanRetrieveWindowContent(arg2) ? 1 : 0;
            return v0;
        }

        public String getDescription(AccessibilityServiceInfo arg2) {
            return AccessibilityServiceInfoCompatIcs.getDescription(arg2);
        }

        public String getId(AccessibilityServiceInfo arg2) {
            return AccessibilityServiceInfoCompatIcs.getId(arg2);
        }

        public ResolveInfo getResolveInfo(AccessibilityServiceInfo arg2) {
            return AccessibilityServiceInfoCompatIcs.getResolveInfo(arg2);
        }

        public String getSettingsActivityName(AccessibilityServiceInfo arg2) {
            return AccessibilityServiceInfoCompatIcs.getSettingsActivityName(arg2);
        }
    }

    class AccessibilityServiceInfoJellyBeanImpl extends AccessibilityServiceInfoIcsImpl {
        AccessibilityServiceInfoJellyBeanImpl() {
            super();
        }

        public String loadDescription(AccessibilityServiceInfo arg2, PackageManager arg3) {
            return AccessibilityServiceInfoCompatJellyBean.loadDescription(arg2, arg3);
        }
    }

    class AccessibilityServiceInfoJellyBeanMr2Impl extends AccessibilityServiceInfoJellyBeanImpl {
        AccessibilityServiceInfoJellyBeanMr2Impl() {
            super();
        }

        public int getCapabilities(AccessibilityServiceInfo arg2) {
            return AccessibilityServiceInfoCompatJellyBeanMr2.getCapabilities(arg2);
        }
    }

    class AccessibilityServiceInfoStubImpl implements AccessibilityServiceInfoVersionImpl {
        AccessibilityServiceInfoStubImpl() {
            super();
        }

        public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo arg2) {
            return 0;
        }

        public int getCapabilities(AccessibilityServiceInfo arg2) {
            return 0;
        }

        public String getDescription(AccessibilityServiceInfo arg2) {
            return null;
        }

        public String getId(AccessibilityServiceInfo arg2) {
            return null;
        }

        public ResolveInfo getResolveInfo(AccessibilityServiceInfo arg2) {
            return null;
        }

        public String getSettingsActivityName(AccessibilityServiceInfo arg2) {
            return null;
        }

        public String loadDescription(AccessibilityServiceInfo arg2, PackageManager arg3) {
            return null;
        }
    }

    interface AccessibilityServiceInfoVersionImpl {
        boolean getCanRetrieveWindowContent(AccessibilityServiceInfo arg1);

        int getCapabilities(AccessibilityServiceInfo arg1);

        String getDescription(AccessibilityServiceInfo arg1);

        String getId(AccessibilityServiceInfo arg1);

        ResolveInfo getResolveInfo(AccessibilityServiceInfo arg1);

        String getSettingsActivityName(AccessibilityServiceInfo arg1);

        String loadDescription(AccessibilityServiceInfo arg1, PackageManager arg2);
    }

    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int DEFAULT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_BRAILLE = 0x20;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 0x20;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
    private static final AccessibilityServiceInfoVersionImpl IMPL;

    static {
        if(Build$VERSION.SDK_INT >= 18) {
            AccessibilityServiceInfoCompat.IMPL = new AccessibilityServiceInfoJellyBeanMr2Impl();
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            AccessibilityServiceInfoCompat.IMPL = new AccessibilityServiceInfoJellyBeanImpl();
        }
        else if(Build$VERSION.SDK_INT >= 14) {
            AccessibilityServiceInfoCompat.IMPL = new AccessibilityServiceInfoIcsImpl();
        }
        else {
            AccessibilityServiceInfoCompat.IMPL = new AccessibilityServiceInfoStubImpl();
        }
    }

    private AccessibilityServiceInfoCompat() {
        super();
    }

    public static String capabilityToString(int arg1) {
        String v0;
        switch(arg1) {
            case 1: {
                v0 = "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
                break;
            }
            case 2: {
                v0 = "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
                break;
            }
            case 4: {
                v0 = "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
                break;
            }
            case 8: {
                v0 = "CAPABILITY_CAN_FILTER_KEY_EVENTS";
                break;
            }
            default: {
                v0 = "UNKNOWN";
                break;
            }
        }

        return v0;
    }

    public static String feedbackTypeToString(int arg4) {
        StringBuilder v0 = new StringBuilder();
        v0.append("[");
        while(arg4 > 0) {
            int v1 = 1 << Integer.numberOfTrailingZeros(arg4);
            arg4 &= v1 ^ -1;
            if(v0.length() > 1) {
                v0.append(", ");
            }

            switch(v1) {
                case 1: {
                    goto label_16;
                }
                case 2: {
                    goto label_22;
                }
                case 4: {
                    goto label_19;
                }
                case 8: {
                    goto label_28;
                }
                case 16: {
                    goto label_25;
                }
            }

            continue;
        label_19:
            v0.append("FEEDBACK_AUDIBLE");
            continue;
        label_22:
            v0.append("FEEDBACK_HAPTIC");
            continue;
        label_25:
            v0.append("FEEDBACK_GENERIC");
            continue;
        label_28:
            v0.append("FEEDBACK_VISUAL");
            continue;
        label_16:
            v0.append("FEEDBACK_SPOKEN");
        }

        v0.append("]");
        return v0.toString();
    }

    public static String flagToString(int arg1) {
        String v0;
        switch(arg1) {
            case 1: {
                v0 = "DEFAULT";
                break;
            }
            case 2: {
                v0 = "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
                break;
            }
            case 4: {
                v0 = "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
                break;
            }
            case 8: {
                v0 = "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
                break;
            }
            case 16: {
                v0 = "FLAG_REPORT_VIEW_IDS";
                break;
            }
            case 32: {
                v0 = "FLAG_REQUEST_FILTER_KEY_EVENTS";
                break;
            }
            default: {
                v0 = null;
                break;
            }
        }

        return v0;
    }

    public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo arg1) {
        return AccessibilityServiceInfoCompat.IMPL.getCanRetrieveWindowContent(arg1);
    }

    public static int getCapabilities(AccessibilityServiceInfo arg1) {
        return AccessibilityServiceInfoCompat.IMPL.getCapabilities(arg1);
    }

    public static String getDescription(AccessibilityServiceInfo arg1) {
        return AccessibilityServiceInfoCompat.IMPL.getDescription(arg1);
    }

    public static String getId(AccessibilityServiceInfo arg1) {
        return AccessibilityServiceInfoCompat.IMPL.getId(arg1);
    }

    public static ResolveInfo getResolveInfo(AccessibilityServiceInfo arg1) {
        return AccessibilityServiceInfoCompat.IMPL.getResolveInfo(arg1);
    }

    public static String getSettingsActivityName(AccessibilityServiceInfo arg1) {
        return AccessibilityServiceInfoCompat.IMPL.getSettingsActivityName(arg1);
    }

    public static String loadDescription(AccessibilityServiceInfo arg1, PackageManager arg2) {
        return AccessibilityServiceInfoCompat.IMPL.loadDescription(arg1, arg2);
    }
}

