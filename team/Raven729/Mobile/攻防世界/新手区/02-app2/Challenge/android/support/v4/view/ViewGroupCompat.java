package android.support.v4.view;

import android.os.Build$VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public final class ViewGroupCompat {
    class ViewGroupCompatHCImpl extends ViewGroupCompatStubImpl {
        ViewGroupCompatHCImpl() {
            super();
        }

        public void setMotionEventSplittingEnabled(ViewGroup arg1, boolean arg2) {
            ViewGroupCompatHC.setMotionEventSplittingEnabled(arg1, arg2);
        }
    }

    class ViewGroupCompatIcsImpl extends ViewGroupCompatHCImpl {
        ViewGroupCompatIcsImpl() {
            super();
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup arg2, View arg3, AccessibilityEvent arg4) {
            return ViewGroupCompatIcs.onRequestSendAccessibilityEvent(arg2, arg3, arg4);
        }
    }

    interface ViewGroupCompatImpl {
        int getLayoutMode(ViewGroup arg1);

        int getNestedScrollAxes(ViewGroup arg1);

        boolean isTransitionGroup(ViewGroup arg1);

        boolean onRequestSendAccessibilityEvent(ViewGroup arg1, View arg2, AccessibilityEvent arg3);

        void setLayoutMode(ViewGroup arg1, int arg2);

        void setMotionEventSplittingEnabled(ViewGroup arg1, boolean arg2);

        void setTransitionGroup(ViewGroup arg1, boolean arg2);
    }

    class ViewGroupCompatJellybeanMR2Impl extends ViewGroupCompatIcsImpl {
        ViewGroupCompatJellybeanMR2Impl() {
            super();
        }

        public int getLayoutMode(ViewGroup arg2) {
            return ViewGroupCompatJellybeanMR2.getLayoutMode(arg2);
        }

        public void setLayoutMode(ViewGroup arg1, int arg2) {
            ViewGroupCompatJellybeanMR2.setLayoutMode(arg1, arg2);
        }
    }

    class ViewGroupCompatLollipopImpl extends ViewGroupCompatJellybeanMR2Impl {
        ViewGroupCompatLollipopImpl() {
            super();
        }

        public int getNestedScrollAxes(ViewGroup arg2) {
            return ViewGroupCompatLollipop.getNestedScrollAxes(arg2);
        }

        public boolean isTransitionGroup(ViewGroup arg2) {
            return ViewGroupCompatLollipop.isTransitionGroup(arg2);
        }

        public void setTransitionGroup(ViewGroup arg1, boolean arg2) {
            ViewGroupCompatLollipop.setTransitionGroup(arg1, arg2);
        }
    }

    class ViewGroupCompatStubImpl implements ViewGroupCompatImpl {
        ViewGroupCompatStubImpl() {
            super();
        }

        public int getLayoutMode(ViewGroup arg2) {
            return 0;
        }

        public int getNestedScrollAxes(ViewGroup arg2) {
            int v0 = (arg2 instanceof NestedScrollingParent) ? ((NestedScrollingParent)arg2).getNestedScrollAxes() : 0;
            return v0;
        }

        public boolean isTransitionGroup(ViewGroup arg2) {
            return 0;
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup arg2, View arg3, AccessibilityEvent arg4) {
            return 1;
        }

        public void setLayoutMode(ViewGroup arg1, int arg2) {
        }

        public void setMotionEventSplittingEnabled(ViewGroup arg1, boolean arg2) {
        }

        public void setTransitionGroup(ViewGroup arg1, boolean arg2) {
        }
    }

    static final ViewGroupCompatImpl IMPL = null;
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 21) {
            ViewGroupCompat.IMPL = new ViewGroupCompatLollipopImpl();
        }
        else if(v0 >= 18) {
            ViewGroupCompat.IMPL = new ViewGroupCompatJellybeanMR2Impl();
        }
        else if(v0 >= 14) {
            ViewGroupCompat.IMPL = new ViewGroupCompatIcsImpl();
        }
        else if(v0 >= 11) {
            ViewGroupCompat.IMPL = new ViewGroupCompatHCImpl();
        }
        else {
            ViewGroupCompat.IMPL = new ViewGroupCompatStubImpl();
        }
    }

    private ViewGroupCompat() {
        super();
    }

    public static int getLayoutMode(ViewGroup arg1) {
        return ViewGroupCompat.IMPL.getLayoutMode(arg1);
    }

    public static int getNestedScrollAxes(ViewGroup arg1) {
        return ViewGroupCompat.IMPL.getNestedScrollAxes(arg1);
    }

    public static boolean isTransitionGroup(ViewGroup arg1) {
        return ViewGroupCompat.IMPL.isTransitionGroup(arg1);
    }

    public static boolean onRequestSendAccessibilityEvent(ViewGroup arg1, View arg2, AccessibilityEvent arg3) {
        return ViewGroupCompat.IMPL.onRequestSendAccessibilityEvent(arg1, arg2, arg3);
    }

    public static void setLayoutMode(ViewGroup arg1, int arg2) {
        ViewGroupCompat.IMPL.setLayoutMode(arg1, arg2);
    }

    public static void setMotionEventSplittingEnabled(ViewGroup arg1, boolean arg2) {
        ViewGroupCompat.IMPL.setMotionEventSplittingEnabled(arg1, arg2);
    }

    public static void setTransitionGroup(ViewGroup arg1, boolean arg2) {
        ViewGroupCompat.IMPL.setTransitionGroup(arg1, arg2);
    }
}

