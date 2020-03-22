package android.support.v4.widget;

import android.os.Build$VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public final class PopupWindowCompat {
    class Api21PopupWindowImpl extends KitKatPopupWindowImpl {
        Api21PopupWindowImpl() {
            super();
        }

        public boolean getOverlapAnchor(PopupWindow arg2) {
            return PopupWindowCompatApi21.getOverlapAnchor(arg2);
        }

        public void setOverlapAnchor(PopupWindow arg1, boolean arg2) {
            PopupWindowCompatApi21.setOverlapAnchor(arg1, arg2);
        }
    }

    class Api23PopupWindowImpl extends Api21PopupWindowImpl {
        Api23PopupWindowImpl() {
            super();
        }

        public boolean getOverlapAnchor(PopupWindow arg2) {
            return PopupWindowCompatApi23.getOverlapAnchor(arg2);
        }

        public int getWindowLayoutType(PopupWindow arg2) {
            return PopupWindowCompatApi23.getWindowLayoutType(arg2);
        }

        public void setOverlapAnchor(PopupWindow arg1, boolean arg2) {
            PopupWindowCompatApi23.setOverlapAnchor(arg1, arg2);
        }

        public void setWindowLayoutType(PopupWindow arg1, int arg2) {
            PopupWindowCompatApi23.setWindowLayoutType(arg1, arg2);
        }
    }

    class BasePopupWindowImpl implements PopupWindowImpl {
        private static Method sGetWindowLayoutTypeMethod;
        private static boolean sGetWindowLayoutTypeMethodAttempted;
        private static Method sSetWindowLayoutTypeMethod;
        private static boolean sSetWindowLayoutTypeMethodAttempted;

        BasePopupWindowImpl() {
            super();
        }

        public boolean getOverlapAnchor(PopupWindow arg2) {
            return 0;
        }

        public int getWindowLayoutType(PopupWindow arg6) {
            if(!BasePopupWindowImpl.sGetWindowLayoutTypeMethodAttempted) {
                try {
                    BasePopupWindowImpl.sGetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType");
                    BasePopupWindowImpl.sGetWindowLayoutTypeMethod.setAccessible(true);
                }
                catch(Exception v0) {
                }

                BasePopupWindowImpl.sGetWindowLayoutTypeMethodAttempted = true;
            }

            if(BasePopupWindowImpl.sGetWindowLayoutTypeMethod != null) {
                try {
                    int v0_1 = BasePopupWindowImpl.sGetWindowLayoutTypeMethod.invoke(arg6).intValue();
                    return v0_1;
                }
                catch(Exception v0) {
                }
            }

            return 0;
        }

        public void setOverlapAnchor(PopupWindow arg1, boolean arg2) {
        }

        public void setWindowLayoutType(PopupWindow arg7, int arg8) {
            if(!BasePopupWindowImpl.sSetWindowLayoutTypeMethodAttempted) {
                try {
                    BasePopupWindowImpl.sSetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                    BasePopupWindowImpl.sSetWindowLayoutTypeMethod.setAccessible(true);
                }
                catch(Exception v0) {
                }

                BasePopupWindowImpl.sSetWindowLayoutTypeMethodAttempted = true;
            }

            if(BasePopupWindowImpl.sSetWindowLayoutTypeMethod != null) {
                try {
                    BasePopupWindowImpl.sSetWindowLayoutTypeMethod.invoke(arg7, Integer.valueOf(arg8));
                }
                catch(Exception v0) {
                }
            }
        }

        public void showAsDropDown(PopupWindow arg3, View arg4, int arg5, int arg6, int arg7) {
            if((GravityCompat.getAbsoluteGravity(arg7, ViewCompat.getLayoutDirection(arg4)) & 7) == 5) {
                arg5 -= arg3.getWidth() - arg4.getWidth();
            }

            arg3.showAsDropDown(arg4, arg5, arg6);
        }
    }

    class KitKatPopupWindowImpl extends BasePopupWindowImpl {
        KitKatPopupWindowImpl() {
            super();
        }

        public void showAsDropDown(PopupWindow arg1, View arg2, int arg3, int arg4, int arg5) {
            PopupWindowCompatKitKat.showAsDropDown(arg1, arg2, arg3, arg4, arg5);
        }
    }

    interface PopupWindowImpl {
        boolean getOverlapAnchor(PopupWindow arg1);

        int getWindowLayoutType(PopupWindow arg1);

        void setOverlapAnchor(PopupWindow arg1, boolean arg2);

        void setWindowLayoutType(PopupWindow arg1, int arg2);

        void showAsDropDown(PopupWindow arg1, View arg2, int arg3, int arg4, int arg5);
    }

    static final PopupWindowImpl IMPL;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 23) {
            PopupWindowCompat.IMPL = new Api23PopupWindowImpl();
        }
        else if(v0 >= 21) {
            PopupWindowCompat.IMPL = new Api21PopupWindowImpl();
        }
        else if(v0 >= 19) {
            PopupWindowCompat.IMPL = new KitKatPopupWindowImpl();
        }
        else {
            PopupWindowCompat.IMPL = new BasePopupWindowImpl();
        }
    }

    private PopupWindowCompat() {
        super();
    }

    public static boolean getOverlapAnchor(PopupWindow arg1) {
        return PopupWindowCompat.IMPL.getOverlapAnchor(arg1);
    }

    public static int getWindowLayoutType(PopupWindow arg1) {
        return PopupWindowCompat.IMPL.getWindowLayoutType(arg1);
    }

    public static void setOverlapAnchor(PopupWindow arg1, boolean arg2) {
        PopupWindowCompat.IMPL.setOverlapAnchor(arg1, arg2);
    }

    public static void setWindowLayoutType(PopupWindow arg1, int arg2) {
        PopupWindowCompat.IMPL.setWindowLayoutType(arg1, arg2);
    }

    public static void showAsDropDown(PopupWindow arg6, View arg7, int arg8, int arg9, int arg10) {
        PopupWindowCompat.IMPL.showAsDropDown(arg6, arg7, arg8, arg9, arg10);
    }
}

