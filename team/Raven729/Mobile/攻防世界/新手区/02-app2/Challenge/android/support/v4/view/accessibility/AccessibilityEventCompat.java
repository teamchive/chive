package android.support.v4.view.accessibility;

import android.os.Build$VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class AccessibilityEventCompat {
    class AccessibilityEventIcsImpl extends AccessibilityEventStubImpl {
        AccessibilityEventIcsImpl() {
            super();
        }

        public void appendRecord(AccessibilityEvent arg1, Object arg2) {
            AccessibilityEventCompatIcs.appendRecord(arg1, arg2);
        }

        public Object getRecord(AccessibilityEvent arg2, int arg3) {
            return AccessibilityEventCompatIcs.getRecord(arg2, arg3);
        }

        public int getRecordCount(AccessibilityEvent arg2) {
            return AccessibilityEventCompatIcs.getRecordCount(arg2);
        }
    }

    class AccessibilityEventJellyBeanImpl extends AccessibilityEventIcsImpl {
        AccessibilityEventJellyBeanImpl() {
            super();
        }

        public int getAction(AccessibilityEvent arg2) {
            return AccessibilityEventCompatJellyBean.getAction(arg2);
        }

        public int getMovementGranularity(AccessibilityEvent arg2) {
            return AccessibilityEventCompatJellyBean.getMovementGranularity(arg2);
        }

        public void setAction(AccessibilityEvent arg1, int arg2) {
            AccessibilityEventCompatJellyBean.setAction(arg1, arg2);
        }

        public void setMovementGranularity(AccessibilityEvent arg1, int arg2) {
            AccessibilityEventCompatJellyBean.setMovementGranularity(arg1, arg2);
        }
    }

    class AccessibilityEventKitKatImpl extends AccessibilityEventJellyBeanImpl {
        AccessibilityEventKitKatImpl() {
            super();
        }

        public int getContentChangeTypes(AccessibilityEvent arg2) {
            return AccessibilityEventCompatKitKat.getContentChangeTypes(arg2);
        }

        public void setContentChangeTypes(AccessibilityEvent arg1, int arg2) {
            AccessibilityEventCompatKitKat.setContentChangeTypes(arg1, arg2);
        }
    }

    class AccessibilityEventStubImpl implements AccessibilityEventVersionImpl {
        AccessibilityEventStubImpl() {
            super();
        }

        public void appendRecord(AccessibilityEvent arg1, Object arg2) {
        }

        public int getAction(AccessibilityEvent arg2) {
            return 0;
        }

        public int getContentChangeTypes(AccessibilityEvent arg2) {
            return 0;
        }

        public int getMovementGranularity(AccessibilityEvent arg2) {
            return 0;
        }

        public Object getRecord(AccessibilityEvent arg2, int arg3) {
            return null;
        }

        public int getRecordCount(AccessibilityEvent arg2) {
            return 0;
        }

        public void setAction(AccessibilityEvent arg1, int arg2) {
        }

        public void setContentChangeTypes(AccessibilityEvent arg1, int arg2) {
        }

        public void setMovementGranularity(AccessibilityEvent arg1, int arg2) {
        }
    }

    interface AccessibilityEventVersionImpl {
        void appendRecord(AccessibilityEvent arg1, Object arg2);

        int getAction(AccessibilityEvent arg1);

        int getContentChangeTypes(AccessibilityEvent arg1);

        int getMovementGranularity(AccessibilityEvent arg1);

        Object getRecord(AccessibilityEvent arg1, int arg2);

        int getRecordCount(AccessibilityEvent arg1);

        void setAction(AccessibilityEvent arg1, int arg2);

        void setContentChangeTypes(AccessibilityEvent arg1, int arg2);

        void setMovementGranularity(AccessibilityEvent arg1, int arg2);
    }

    public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
    public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
    public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
    public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
    private static final AccessibilityEventVersionImpl IMPL = null;
    public static final int TYPES_ALL_MASK = -1;
    public static final int TYPE_ANNOUNCEMENT = 0x4000;
    public static final int TYPE_ASSIST_READING_CONTEXT = 0x1000000;
    public static final int TYPE_GESTURE_DETECTION_END = 0x80000;
    public static final int TYPE_GESTURE_DETECTION_START = 0x40000;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 0x400;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 0x200;
    public static final int TYPE_TOUCH_INTERACTION_END = 0x200000;
    public static final int TYPE_TOUCH_INTERACTION_START = 0x100000;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 0x8000;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 0x10000;
    public static final int TYPE_VIEW_CONTEXT_CLICKED = 0x800000;
    public static final int TYPE_VIEW_HOVER_ENTER = 0x80;
    public static final int TYPE_VIEW_HOVER_EXIT = 0x100;
    public static final int TYPE_VIEW_SCROLLED = 0x1000;
    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 0x2000;
    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 0x20000;
    public static final int TYPE_WINDOWS_CHANGED = 0x400000;
    public static final int TYPE_WINDOW_CONTENT_CHANGED = 0x800;

    static {
        if(Build$VERSION.SDK_INT >= 19) {
            AccessibilityEventCompat.IMPL = new AccessibilityEventKitKatImpl();
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            AccessibilityEventCompat.IMPL = new AccessibilityEventJellyBeanImpl();
        }
        else if(Build$VERSION.SDK_INT >= 14) {
            AccessibilityEventCompat.IMPL = new AccessibilityEventIcsImpl();
        }
        else {
            AccessibilityEventCompat.IMPL = new AccessibilityEventStubImpl();
        }
    }

    private AccessibilityEventCompat() {
        super();
    }

    public static void appendRecord(AccessibilityEvent arg2, AccessibilityRecordCompat arg3) {
        AccessibilityEventCompat.IMPL.appendRecord(arg2, arg3.getImpl());
    }

    public static AccessibilityRecordCompat asRecord(AccessibilityEvent arg1) {
        return new AccessibilityRecordCompat(arg1);
    }

    public int getAction(AccessibilityEvent arg2) {
        return AccessibilityEventCompat.IMPL.getAction(arg2);
    }

    public static int getContentChangeTypes(AccessibilityEvent arg1) {
        return AccessibilityEventCompat.IMPL.getContentChangeTypes(arg1);
    }

    public int getMovementGranularity(AccessibilityEvent arg2) {
        return AccessibilityEventCompat.IMPL.getMovementGranularity(arg2);
    }

    public static AccessibilityRecordCompat getRecord(AccessibilityEvent arg2, int arg3) {
        return new AccessibilityRecordCompat(AccessibilityEventCompat.IMPL.getRecord(arg2, arg3));
    }

    public static int getRecordCount(AccessibilityEvent arg1) {
        return AccessibilityEventCompat.IMPL.getRecordCount(arg1);
    }

    public void setAction(AccessibilityEvent arg2, int arg3) {
        AccessibilityEventCompat.IMPL.setAction(arg2, arg3);
    }

    public static void setContentChangeTypes(AccessibilityEvent arg1, int arg2) {
        AccessibilityEventCompat.IMPL.setContentChangeTypes(arg1, arg2);
    }

    public void setMovementGranularity(AccessibilityEvent arg2, int arg3) {
        AccessibilityEventCompat.IMPL.setMovementGranularity(arg2, arg3);
    }
}

