package android.support.v4.h;

import android.os.Build$VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class q {
    class a extends c {
        a() {
            super();
        }
    }

    class b extends a {
        b() {
            super();
        }

        public void a(ViewParent arg5, View arg6) {
            try {
                arg5.onStopNestedScroll(arg6);
            }
            catch(AbstractMethodError v0) {
                Log.e("ViewParentCompat", "ViewParent " + arg5 + " does not implement interface " + "method onStopNestedScroll", ((Throwable)v0));
            }
        }

        public void a(ViewParent arg5, View arg6, int arg7, int arg8, int arg9, int arg10) {
            try {
                arg5.onNestedScroll(arg6, arg7, arg8, arg9, arg10);
            }
            catch(AbstractMethodError v0) {
                Log.e("ViewParentCompat", "ViewParent " + arg5 + " does not implement interface " + "method onNestedScroll", ((Throwable)v0));
            }
        }

        public void a(ViewParent arg5, View arg6, int arg7, int arg8, int[] arg9) {
            try {
                arg5.onNestedPreScroll(arg6, arg7, arg8, arg9);
            }
            catch(AbstractMethodError v0) {
                Log.e("ViewParentCompat", "ViewParent " + arg5 + " does not implement interface " + "method onNestedPreScroll", ((Throwable)v0));
            }
        }

        public boolean a(ViewParent arg5, View arg6, float arg7, float arg8) {
            boolean v0_1;
            try {
                v0_1 = arg5.onNestedPreFling(arg6, arg7, arg8);
            }
            catch(AbstractMethodError v0) {
                Log.e("ViewParentCompat", "ViewParent " + arg5 + " does not implement interface " + "method onNestedPreFling", ((Throwable)v0));
                v0_1 = false;
            }

            return v0_1;
        }

        public boolean a(ViewParent arg5, View arg6, float arg7, float arg8, boolean arg9) {
            boolean v0_1;
            try {
                v0_1 = arg5.onNestedFling(arg6, arg7, arg8, arg9);
            }
            catch(AbstractMethodError v0) {
                Log.e("ViewParentCompat", "ViewParent " + arg5 + " does not implement interface " + "method onNestedFling", ((Throwable)v0));
                v0_1 = false;
            }

            return v0_1;
        }

        public boolean a(ViewParent arg5, View arg6, View arg7, int arg8) {
            boolean v0_1;
            try {
                v0_1 = arg5.onStartNestedScroll(arg6, arg7, arg8);
            }
            catch(AbstractMethodError v0) {
                Log.e("ViewParentCompat", "ViewParent " + arg5 + " does not implement interface " + "method onStartNestedScroll", ((Throwable)v0));
                v0_1 = false;
            }

            return v0_1;
        }

        public void b(ViewParent arg5, View arg6, View arg7, int arg8) {
            try {
                arg5.onNestedScrollAccepted(arg6, arg7, arg8);
            }
            catch(AbstractMethodError v0) {
                Log.e("ViewParentCompat", "ViewParent " + arg5 + " does not implement interface " + "method onNestedScrollAccepted", ((Throwable)v0));
            }
        }
    }

    class c {
        c() {
            super();
        }

        public void a(ViewParent arg2, View arg3) {
            if((arg2 instanceof k)) {
                ((k)arg2).onStopNestedScroll(arg3);
            }
        }

        public void a(ViewParent arg7, View arg8, int arg9, int arg10, int arg11, int arg12) {
            if((arg7 instanceof k)) {
                arg7.onNestedScroll(arg8, arg9, arg10, arg11, arg12);
            }
        }

        public void a(ViewParent arg2, View arg3, int arg4, int arg5, int[] arg6) {
            if((arg2 instanceof k)) {
                ((k)arg2).onNestedPreScroll(arg3, arg4, arg5, arg6);
            }
        }

        public boolean a(ViewParent arg2, View arg3, float arg4, float arg5) {
            boolean v0 = (arg2 instanceof k) ? ((k)arg2).onNestedPreFling(arg3, arg4, arg5) : false;
            return v0;
        }

        public boolean a(ViewParent arg2, View arg3, float arg4, float arg5, boolean arg6) {
            boolean v0 = (arg2 instanceof k) ? ((k)arg2).onNestedFling(arg3, arg4, arg5, arg6) : false;
            return v0;
        }

        public boolean a(ViewParent arg2, View arg3, View arg4, int arg5) {
            boolean v0 = (arg2 instanceof k) ? ((k)arg2).onStartNestedScroll(arg3, arg4, arg5) : false;
            return v0;
        }

        public void b(ViewParent arg2, View arg3, View arg4, int arg5) {
            if((arg2 instanceof k)) {
                ((k)arg2).onNestedScrollAccepted(arg3, arg4, arg5);
            }
        }
    }

    static final c a;

    static {
        if(Build$VERSION.SDK_INT >= 21) {
            q.a = new b();
        }
        else if(Build$VERSION.SDK_INT >= 19) {
            q.a = new a();
        }
        else {
            q.a = new c();
        }
    }

    public static boolean a(ViewParent arg1, View arg2, float arg3, float arg4) {
        return q.a.a(arg1, arg2, arg3, arg4);
    }

    public static boolean a(ViewParent arg6, View arg7, float arg8, float arg9, boolean arg10) {
        return q.a.a(arg6, arg7, arg8, arg9, arg10);
    }

    public static boolean a(ViewParent arg1, View arg2, View arg3, int arg4, int arg5) {
        boolean v0;
        if((arg1 instanceof l)) {
            v0 = ((l)arg1).a(arg2, arg3, arg4, arg5);
        }
        else if(arg5 == 0) {
            v0 = q.a.a(arg1, arg2, arg3, arg4);
        }
        else {
            v0 = false;
        }

        return v0;
    }

    public static void a(ViewParent arg7, View arg8, int arg9, int arg10, int arg11, int arg12, int arg13) {
        if((arg7 instanceof l)) {
            arg7.a(arg8, arg9, arg10, arg11, arg12, arg13);
        }
        else if(arg13 == 0) {
            q.a.a(arg7, arg8, arg9, arg10, arg11, arg12);
        }
    }

    public static void a(ViewParent arg6, View arg7, int arg8, int arg9, int[] arg10, int arg11) {
        if((arg6 instanceof l)) {
            arg6.a(arg7, arg8, arg9, arg10, arg11);
        }
        else if(arg11 == 0) {
            q.a.a(arg6, arg7, arg8, arg9, arg10);
        }
    }

    public static void a(ViewParent arg1, View arg2, int arg3) {
        if((arg1 instanceof l)) {
            ((l)arg1).a(arg2, arg3);
        }
        else if(arg3 == 0) {
            q.a.a(arg1, arg2);
        }
    }

    public static void b(ViewParent arg1, View arg2, View arg3, int arg4, int arg5) {
        if((arg1 instanceof l)) {
            ((l)arg1).b(arg2, arg3, arg4, arg5);
        }
        else if(arg5 == 0) {
            q.a.b(arg1, arg2, arg3, arg4);
        }
    }
}

