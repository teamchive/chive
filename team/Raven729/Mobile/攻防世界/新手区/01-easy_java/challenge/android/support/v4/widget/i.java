package android.support.v4.widget;

import android.os.Build$VERSION;
import android.support.v4.h.p;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class i {
    class a extends d {
        a() {
            super();
        }

        public void a(PopupWindow arg1, View arg2, int arg3, int arg4, int arg5) {
            arg1.showAsDropDown(arg2, arg3, arg4, arg5);
        }
    }

    class b extends a {
        private static Field a;

        static {
            try {
                b.a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                b.a.setAccessible(true);
            }
            catch(NoSuchFieldException v0) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", ((Throwable)v0));
            }
        }

        b() {
            super();
        }

        public void a(PopupWindow arg4, boolean arg5) {
            if(b.a != null) {
                try {
                    b.a.set(arg4, Boolean.valueOf(arg5));
                }
                catch(IllegalAccessException v0) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", ((Throwable)v0));
                }
            }
        }
    }

    class c extends b {
        c() {
            super();
        }

        public void a(PopupWindow arg1, int arg2) {
            arg1.setWindowLayoutType(arg2);
        }

        public void a(PopupWindow arg1, boolean arg2) {
            arg1.setOverlapAnchor(arg2);
        }
    }

    class d {
        private static Method a;
        private static boolean b;

        d() {
            super();
        }

        public void a(PopupWindow arg7, int arg8) {
            if(!d.b) {
                try {
                    d.a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                    d.a.setAccessible(true);
                }
                catch(Exception v0) {
                }

                d.b = true;
            }

            if(d.a != null) {
                try {
                    d.a.invoke(arg7, Integer.valueOf(arg8));
                }
                catch(Exception v0) {
                }
            }
        }

        public void a(PopupWindow arg3, View arg4, int arg5, int arg6, int arg7) {
            if((android.support.v4.h.d.a(arg7, p.b(arg4)) & 7) == 5) {
                arg5 -= arg3.getWidth() - arg4.getWidth();
            }

            arg3.showAsDropDown(arg4, arg5, arg6);
        }

        public void a(PopupWindow arg1, boolean arg2) {
        }
    }

    static final d a;

    static {
        if(Build$VERSION.SDK_INT >= 23) {
            i.a = new c();
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            i.a = new b();
        }
        else if(Build$VERSION.SDK_INT >= 19) {
            i.a = new a();
        }
        else {
            i.a = new d();
        }
    }

    public static void a(PopupWindow arg1, int arg2) {
        i.a.a(arg1, arg2);
    }

    public static void a(PopupWindow arg6, View arg7, int arg8, int arg9, int arg10) {
        i.a.a(arg6, arg7, arg8, arg9, arg10);
    }

    public static void a(PopupWindow arg1, boolean arg2) {
        i.a.a(arg1, arg2);
    }
}

