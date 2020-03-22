package android.support.v4.view;

import android.os.Build$VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public final class ViewParentCompat {
    class ViewParentCompatICSImpl extends ViewParentCompatStubImpl {
        ViewParentCompatICSImpl() {
            super();
        }

        public boolean requestSendAccessibilityEvent(ViewParent arg2, View arg3, AccessibilityEvent arg4) {
            return ViewParentCompatICS.requestSendAccessibilityEvent(arg2, arg3, arg4);
        }
    }

    interface ViewParentCompatImpl {
        void notifySubtreeAccessibilityStateChanged(ViewParent arg1, View arg2, View arg3, int arg4);

        boolean onNestedFling(ViewParent arg1, View arg2, float arg3, float arg4, boolean arg5);

        boolean onNestedPreFling(ViewParent arg1, View arg2, float arg3, float arg4);

        void onNestedPreScroll(ViewParent arg1, View arg2, int arg3, int arg4, int[] arg5);

        void onNestedScroll(ViewParent arg1, View arg2, int arg3, int arg4, int arg5, int arg6);

        void onNestedScrollAccepted(ViewParent arg1, View arg2, View arg3, int arg4);

        boolean onStartNestedScroll(ViewParent arg1, View arg2, View arg3, int arg4);

        void onStopNestedScroll(ViewParent arg1, View arg2);

        boolean requestSendAccessibilityEvent(ViewParent arg1, View arg2, AccessibilityEvent arg3);
    }

    class ViewParentCompatKitKatImpl extends ViewParentCompatICSImpl {
        ViewParentCompatKitKatImpl() {
            super();
        }

        public void notifySubtreeAccessibilityStateChanged(ViewParent arg1, View arg2, View arg3, int arg4) {
            ViewParentCompatKitKat.notifySubtreeAccessibilityStateChanged(arg1, arg2, arg3, arg4);
        }
    }

    class ViewParentCompatLollipopImpl extends ViewParentCompatKitKatImpl {
        ViewParentCompatLollipopImpl() {
            super();
        }

        public boolean onNestedFling(ViewParent arg2, View arg3, float arg4, float arg5, boolean arg6) {
            return ViewParentCompatLollipop.onNestedFling(arg2, arg3, arg4, arg5, arg6);
        }

        public boolean onNestedPreFling(ViewParent arg2, View arg3, float arg4, float arg5) {
            return ViewParentCompatLollipop.onNestedPreFling(arg2, arg3, arg4, arg5);
        }

        public void onNestedPreScroll(ViewParent arg1, View arg2, int arg3, int arg4, int[] arg5) {
            ViewParentCompatLollipop.onNestedPreScroll(arg1, arg2, arg3, arg4, arg5);
        }

        public void onNestedScroll(ViewParent arg1, View arg2, int arg3, int arg4, int arg5, int arg6) {
            ViewParentCompatLollipop.onNestedScroll(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        public void onNestedScrollAccepted(ViewParent arg1, View arg2, View arg3, int arg4) {
            ViewParentCompatLollipop.onNestedScrollAccepted(arg1, arg2, arg3, arg4);
        }

        public boolean onStartNestedScroll(ViewParent arg2, View arg3, View arg4, int arg5) {
            return ViewParentCompatLollipop.onStartNestedScroll(arg2, arg3, arg4, arg5);
        }

        public void onStopNestedScroll(ViewParent arg1, View arg2) {
            ViewParentCompatLollipop.onStopNestedScroll(arg1, arg2);
        }
    }

    class ViewParentCompatStubImpl implements ViewParentCompatImpl {
        ViewParentCompatStubImpl() {
            super();
        }

        public void notifySubtreeAccessibilityStateChanged(ViewParent arg1, View arg2, View arg3, int arg4) {
        }

        public boolean onNestedFling(ViewParent arg2, View arg3, float arg4, float arg5, boolean arg6) {
            boolean v0 = (arg2 instanceof NestedScrollingParent) ? ((NestedScrollingParent)arg2).onNestedFling(arg3, arg4, arg5, arg6) : false;
            return v0;
        }

        public boolean onNestedPreFling(ViewParent arg2, View arg3, float arg4, float arg5) {
            boolean v0 = (arg2 instanceof NestedScrollingParent) ? ((NestedScrollingParent)arg2).onNestedPreFling(arg3, arg4, arg5) : false;
            return v0;
        }

        public void onNestedPreScroll(ViewParent arg2, View arg3, int arg4, int arg5, int[] arg6) {
            if((arg2 instanceof NestedScrollingParent)) {
                ((NestedScrollingParent)arg2).onNestedPreScroll(arg3, arg4, arg5, arg6);
            }
        }

        public void onNestedScroll(ViewParent arg7, View arg8, int arg9, int arg10, int arg11, int arg12) {
            if((arg7 instanceof NestedScrollingParent)) {
                arg7.onNestedScroll(arg8, arg9, arg10, arg11, arg12);
            }
        }

        public void onNestedScrollAccepted(ViewParent arg2, View arg3, View arg4, int arg5) {
            if((arg2 instanceof NestedScrollingParent)) {
                ((NestedScrollingParent)arg2).onNestedScrollAccepted(arg3, arg4, arg5);
            }
        }

        public boolean onStartNestedScroll(ViewParent arg2, View arg3, View arg4, int arg5) {
            boolean v0 = (arg2 instanceof NestedScrollingParent) ? ((NestedScrollingParent)arg2).onStartNestedScroll(arg3, arg4, arg5) : false;
            return v0;
        }

        public void onStopNestedScroll(ViewParent arg2, View arg3) {
            if((arg2 instanceof NestedScrollingParent)) {
                ((NestedScrollingParent)arg2).onStopNestedScroll(arg3);
            }
        }

        public boolean requestSendAccessibilityEvent(ViewParent arg3, View arg4, AccessibilityEvent arg5) {
            boolean v0;
            if(arg4 == null) {
                v0 = false;
            }
            else {
                arg4.getContext().getSystemService("accessibility").sendAccessibilityEvent(arg5);
                v0 = true;
            }

            return v0;
        }
    }

    static final ViewParentCompatImpl IMPL;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 21) {
            ViewParentCompat.IMPL = new ViewParentCompatLollipopImpl();
        }
        else if(v0 >= 19) {
            ViewParentCompat.IMPL = new ViewParentCompatKitKatImpl();
        }
        else if(v0 >= 14) {
            ViewParentCompat.IMPL = new ViewParentCompatICSImpl();
        }
        else {
            ViewParentCompat.IMPL = new ViewParentCompatStubImpl();
        }
    }

    private ViewParentCompat() {
        super();
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent arg1, View arg2, View arg3, int arg4) {
        ViewParentCompat.IMPL.notifySubtreeAccessibilityStateChanged(arg1, arg2, arg3, arg4);
    }

    public static boolean onNestedFling(ViewParent arg6, View arg7, float arg8, float arg9, boolean arg10) {
        return ViewParentCompat.IMPL.onNestedFling(arg6, arg7, arg8, arg9, arg10);
    }

    public static boolean onNestedPreFling(ViewParent arg1, View arg2, float arg3, float arg4) {
        return ViewParentCompat.IMPL.onNestedPreFling(arg1, arg2, arg3, arg4);
    }

    public static void onNestedPreScroll(ViewParent arg6, View arg7, int arg8, int arg9, int[] arg10) {
        ViewParentCompat.IMPL.onNestedPreScroll(arg6, arg7, arg8, arg9, arg10);
    }

    public static void onNestedScroll(ViewParent arg7, View arg8, int arg9, int arg10, int arg11, int arg12) {
        ViewParentCompat.IMPL.onNestedScroll(arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public static void onNestedScrollAccepted(ViewParent arg1, View arg2, View arg3, int arg4) {
        ViewParentCompat.IMPL.onNestedScrollAccepted(arg1, arg2, arg3, arg4);
    }

    public static boolean onStartNestedScroll(ViewParent arg1, View arg2, View arg3, int arg4) {
        return ViewParentCompat.IMPL.onStartNestedScroll(arg1, arg2, arg3, arg4);
    }

    public static void onStopNestedScroll(ViewParent arg1, View arg2) {
        ViewParentCompat.IMPL.onStopNestedScroll(arg1, arg2);
    }

    public static boolean requestSendAccessibilityEvent(ViewParent arg1, View arg2, AccessibilityEvent arg3) {
        return ViewParentCompat.IMPL.requestSendAccessibilityEvent(arg1, arg2, arg3);
    }
}

