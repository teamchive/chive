package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

@TargetApi(value=21) @RequiresApi(value=21) class ViewParentCompatLollipop {
    private static final String TAG = "ViewParentCompat";

    ViewParentCompatLollipop() {
        super();
    }

    public static boolean onNestedFling(ViewParent arg4, View arg5, float arg6, float arg7, boolean arg8) {
        boolean v0_1;
        try {
            v0_1 = arg4.onNestedFling(arg5, arg6, arg7, arg8);
        }
        catch(AbstractMethodError v0) {
            Log.e("ViewParentCompat", "ViewParent " + arg4 + " does not implement interface " + "method onNestedFling", ((Throwable)v0));
            v0_1 = false;
        }

        return v0_1;
    }

    public static boolean onNestedPreFling(ViewParent arg4, View arg5, float arg6, float arg7) {
        boolean v0_1;
        try {
            v0_1 = arg4.onNestedPreFling(arg5, arg6, arg7);
        }
        catch(AbstractMethodError v0) {
            Log.e("ViewParentCompat", "ViewParent " + arg4 + " does not implement interface " + "method onNestedPreFling", ((Throwable)v0));
            v0_1 = false;
        }

        return v0_1;
    }

    public static void onNestedPreScroll(ViewParent arg4, View arg5, int arg6, int arg7, int[] arg8) {
        try {
            arg4.onNestedPreScroll(arg5, arg6, arg7, arg8);
        }
        catch(AbstractMethodError v0) {
            Log.e("ViewParentCompat", "ViewParent " + arg4 + " does not implement interface " + "method onNestedPreScroll", ((Throwable)v0));
        }
    }

    public static void onNestedScroll(ViewParent arg4, View arg5, int arg6, int arg7, int arg8, int arg9) {
        try {
            arg4.onNestedScroll(arg5, arg6, arg7, arg8, arg9);
        }
        catch(AbstractMethodError v0) {
            Log.e("ViewParentCompat", "ViewParent " + arg4 + " does not implement interface " + "method onNestedScroll", ((Throwable)v0));
        }
    }

    public static void onNestedScrollAccepted(ViewParent arg4, View arg5, View arg6, int arg7) {
        try {
            arg4.onNestedScrollAccepted(arg5, arg6, arg7);
        }
        catch(AbstractMethodError v0) {
            Log.e("ViewParentCompat", "ViewParent " + arg4 + " does not implement interface " + "method onNestedScrollAccepted", ((Throwable)v0));
        }
    }

    public static boolean onStartNestedScroll(ViewParent arg4, View arg5, View arg6, int arg7) {
        boolean v0_1;
        try {
            v0_1 = arg4.onStartNestedScroll(arg5, arg6, arg7);
        }
        catch(AbstractMethodError v0) {
            Log.e("ViewParentCompat", "ViewParent " + arg4 + " does not implement interface " + "method onStartNestedScroll", ((Throwable)v0));
            v0_1 = false;
        }

        return v0_1;
    }

    public static void onStopNestedScroll(ViewParent arg4, View arg5) {
        try {
            arg4.onStopNestedScroll(arg5);
        }
        catch(AbstractMethodError v0) {
            Log.e("ViewParentCompat", "ViewParent " + arg4 + " does not implement interface " + "method onStopNestedScroll", ((Throwable)v0));
        }
    }
}

