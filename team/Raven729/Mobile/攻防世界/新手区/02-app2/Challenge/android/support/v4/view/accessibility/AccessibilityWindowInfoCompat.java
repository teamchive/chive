package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build$VERSION;

public class AccessibilityWindowInfoCompat {
    class AccessibilityWindowInfoApi21Impl extends AccessibilityWindowInfoStubImpl {
        AccessibilityWindowInfoApi21Impl() {
            super();
        }

        public void getBoundsInScreen(Object arg1, Rect arg2) {
            AccessibilityWindowInfoCompatApi21.getBoundsInScreen(arg1, arg2);
        }

        public Object getChild(Object arg2, int arg3) {
            return AccessibilityWindowInfoCompatApi21.getChild(arg2, arg3);
        }

        public int getChildCount(Object arg2) {
            return AccessibilityWindowInfoCompatApi21.getChildCount(arg2);
        }

        public int getId(Object arg2) {
            return AccessibilityWindowInfoCompatApi21.getId(arg2);
        }

        public int getLayer(Object arg2) {
            return AccessibilityWindowInfoCompatApi21.getLayer(arg2);
        }

        public Object getParent(Object arg2) {
            return AccessibilityWindowInfoCompatApi21.getParent(arg2);
        }

        public Object getRoot(Object arg2) {
            return AccessibilityWindowInfoCompatApi21.getRoot(arg2);
        }

        public int getType(Object arg2) {
            return AccessibilityWindowInfoCompatApi21.getType(arg2);
        }

        public boolean isAccessibilityFocused(Object arg2) {
            return AccessibilityWindowInfoCompatApi21.isAccessibilityFocused(arg2);
        }

        public boolean isActive(Object arg2) {
            return AccessibilityWindowInfoCompatApi21.isActive(arg2);
        }

        public boolean isFocused(Object arg2) {
            return AccessibilityWindowInfoCompatApi21.isFocused(arg2);
        }

        public Object obtain() {
            return AccessibilityWindowInfoCompatApi21.obtain();
        }

        public Object obtain(Object arg2) {
            return AccessibilityWindowInfoCompatApi21.obtain(arg2);
        }

        public void recycle(Object arg1) {
            AccessibilityWindowInfoCompatApi21.recycle(arg1);
        }
    }

    class AccessibilityWindowInfoApi24Impl extends AccessibilityWindowInfoApi21Impl {
        AccessibilityWindowInfoApi24Impl() {
            super();
        }

        public Object getAnchor(Object arg2) {
            return AccessibilityWindowInfoCompatApi24.getAnchor(arg2);
        }

        public CharSequence getTitle(Object arg2) {
            return AccessibilityWindowInfoCompatApi24.getTitle(arg2);
        }
    }

    interface AccessibilityWindowInfoImpl {
        Object getAnchor(Object arg1);

        void getBoundsInScreen(Object arg1, Rect arg2);

        Object getChild(Object arg1, int arg2);

        int getChildCount(Object arg1);

        int getId(Object arg1);

        int getLayer(Object arg1);

        Object getParent(Object arg1);

        Object getRoot(Object arg1);

        CharSequence getTitle(Object arg1);

        int getType(Object arg1);

        boolean isAccessibilityFocused(Object arg1);

        boolean isActive(Object arg1);

        boolean isFocused(Object arg1);

        Object obtain();

        Object obtain(Object arg1);

        void recycle(Object arg1);
    }

    class AccessibilityWindowInfoStubImpl implements AccessibilityWindowInfoImpl {
        AccessibilityWindowInfoStubImpl() {
            super();
        }

        public Object getAnchor(Object arg2) {
            return null;
        }

        public void getBoundsInScreen(Object arg1, Rect arg2) {
        }

        public Object getChild(Object arg2, int arg3) {
            return null;
        }

        public int getChildCount(Object arg2) {
            return 0;
        }

        public int getId(Object arg2) {
            return -1;
        }

        public int getLayer(Object arg2) {
            return -1;
        }

        public Object getParent(Object arg2) {
            return null;
        }

        public Object getRoot(Object arg2) {
            return null;
        }

        public CharSequence getTitle(Object arg2) {
            return null;
        }

        public int getType(Object arg2) {
            return -1;
        }

        public boolean isAccessibilityFocused(Object arg2) {
            return 1;
        }

        public boolean isActive(Object arg2) {
            return 1;
        }

        public boolean isFocused(Object arg2) {
            return 1;
        }

        public Object obtain() {
            return null;
        }

        public Object obtain(Object arg2) {
            return null;
        }

        public void recycle(Object arg1) {
        }
    }

    private static final AccessibilityWindowInfoImpl IMPL = null;
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private Object mInfo;

    static {
        if(Build$VERSION.SDK_INT >= 24) {
            AccessibilityWindowInfoCompat.IMPL = new AccessibilityWindowInfoApi24Impl();
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            AccessibilityWindowInfoCompat.IMPL = new AccessibilityWindowInfoApi21Impl();
        }
        else {
            AccessibilityWindowInfoCompat.IMPL = new AccessibilityWindowInfoStubImpl();
        }
    }

    private AccessibilityWindowInfoCompat(Object arg1) {
        super();
        this.mInfo = arg1;
    }

    public boolean equals(Object arg5) {
        boolean v0 = true;
        if(this != (((AccessibilityWindowInfoCompat)arg5))) {
            if(arg5 == null) {
                v0 = false;
            }
            else if(this.getClass() != arg5.getClass()) {
                v0 = false;
            }
            else if(this.mInfo == null) {
                if(((AccessibilityWindowInfoCompat)arg5).mInfo != null) {
                    v0 = false;
                }
            }
            else if(!this.mInfo.equals(((AccessibilityWindowInfoCompat)arg5).mInfo)) {
                v0 = false;
            }
        }

        return v0;
    }

    public AccessibilityNodeInfoCompat getAnchor() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityWindowInfoCompat.IMPL.getAnchor(this.mInfo));
    }

    public void getBoundsInScreen(Rect arg3) {
        AccessibilityWindowInfoCompat.IMPL.getBoundsInScreen(this.mInfo, arg3);
    }

    public AccessibilityWindowInfoCompat getChild(int arg3) {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(AccessibilityWindowInfoCompat.IMPL.getChild(this.mInfo, arg3));
    }

    public int getChildCount() {
        return AccessibilityWindowInfoCompat.IMPL.getChildCount(this.mInfo);
    }

    public int getId() {
        return AccessibilityWindowInfoCompat.IMPL.getId(this.mInfo);
    }

    public int getLayer() {
        return AccessibilityWindowInfoCompat.IMPL.getLayer(this.mInfo);
    }

    public AccessibilityWindowInfoCompat getParent() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(AccessibilityWindowInfoCompat.IMPL.getParent(this.mInfo));
    }

    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityWindowInfoCompat.IMPL.getRoot(this.mInfo));
    }

    public CharSequence getTitle() {
        return AccessibilityWindowInfoCompat.IMPL.getTitle(this.mInfo);
    }

    public int getType() {
        return AccessibilityWindowInfoCompat.IMPL.getType(this.mInfo);
    }

    public int hashCode() {
        int v0 = this.mInfo == null ? 0 : this.mInfo.hashCode();
        return v0;
    }

    public boolean isAccessibilityFocused() {
        return AccessibilityWindowInfoCompat.IMPL.isAccessibilityFocused(this.mInfo);
    }

    public boolean isActive() {
        return AccessibilityWindowInfoCompat.IMPL.isActive(this.mInfo);
    }

    public boolean isFocused() {
        return AccessibilityWindowInfoCompat.IMPL.isFocused(this.mInfo);
    }

    public static AccessibilityWindowInfoCompat obtain() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(AccessibilityWindowInfoCompat.IMPL.obtain());
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat arg2) {
        AccessibilityWindowInfoCompat v0 = arg2 == null ? null : AccessibilityWindowInfoCompat.wrapNonNullInstance(AccessibilityWindowInfoCompat.IMPL.obtain(arg2.mInfo));
        return v0;
    }

    public void recycle() {
        AccessibilityWindowInfoCompat.IMPL.recycle(this.mInfo);
    }

    public String toString() {
        boolean v1 = true;
        StringBuilder v3 = new StringBuilder();
        Rect v0 = new Rect();
        this.getBoundsInScreen(v0);
        v3.append("AccessibilityWindowInfo[");
        v3.append("id=").append(this.getId());
        v3.append(", type=").append(AccessibilityWindowInfoCompat.typeToString(this.getType()));
        v3.append(", layer=").append(this.getLayer());
        v3.append(", bounds=").append(v0);
        v3.append(", focused=").append(this.isFocused());
        v3.append(", active=").append(this.isActive());
        StringBuilder v4 = v3.append(", hasParent=");
        boolean v0_1 = this.getParent() != null ? true : false;
        v4.append(v0_1);
        StringBuilder v0_2 = v3.append(", hasChildren=");
        if(this.getChildCount() <= 0) {
            v1 = false;
        }

        v0_2.append(v1);
        v3.append(']');
        return v3.toString();
    }

    private static String typeToString(int arg1) {
        String v0;
        switch(arg1) {
            case 1: {
                v0 = "TYPE_APPLICATION";
                break;
            }
            case 2: {
                v0 = "TYPE_INPUT_METHOD";
                break;
            }
            case 3: {
                v0 = "TYPE_SYSTEM";
                break;
            }
            case 4: {
                v0 = "TYPE_ACCESSIBILITY_OVERLAY";
                break;
            }
            default: {
                v0 = "<UNKNOWN>";
                break;
            }
        }

        return v0;
    }

    static AccessibilityWindowInfoCompat wrapNonNullInstance(Object arg1) {
        AccessibilityWindowInfoCompat v0 = arg1 != null ? new AccessibilityWindowInfoCompat(arg1) : null;
        return v0;
    }
}

