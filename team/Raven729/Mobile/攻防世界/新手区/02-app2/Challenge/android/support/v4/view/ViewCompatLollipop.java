package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.annotation.RequiresApi;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;

@TargetApi(value=21) @RequiresApi(value=21) class ViewCompatLollipop {
    public interface OnApplyWindowInsetsListenerBridge {
        Object onApplyWindowInsets(View arg1, Object arg2);
    }

    private static ThreadLocal sThreadLocalRect;

    ViewCompatLollipop() {
        super();
    }

    public static Object dispatchApplyWindowInsets(View arg2, Object arg3) {
        WindowInsets v3;
        WindowInsets v1 = arg2.dispatchApplyWindowInsets(arg3);
        if(v1 != arg3) {
            v3 = new WindowInsets(v1);
        }

        return v3;
    }

    public static boolean dispatchNestedFling(View arg1, float arg2, float arg3, boolean arg4) {
        return arg1.dispatchNestedFling(arg2, arg3, arg4);
    }

    public static boolean dispatchNestedPreFling(View arg1, float arg2, float arg3) {
        return arg1.dispatchNestedPreFling(arg2, arg3);
    }

    public static boolean dispatchNestedPreScroll(View arg1, int arg2, int arg3, int[] arg4, int[] arg5) {
        return arg1.dispatchNestedPreScroll(arg2, arg3, arg4, arg5);
    }

    public static boolean dispatchNestedScroll(View arg1, int arg2, int arg3, int arg4, int arg5, int[] arg6) {
        return arg1.dispatchNestedScroll(arg2, arg3, arg4, arg5, arg6);
    }

    static ColorStateList getBackgroundTintList(View arg1) {
        return arg1.getBackgroundTintList();
    }

    static PorterDuff$Mode getBackgroundTintMode(View arg1) {
        return arg1.getBackgroundTintMode();
    }

    public static float getElevation(View arg1) {
        return arg1.getElevation();
    }

    private static Rect getEmptyTempRect() {
        if(ViewCompatLollipop.sThreadLocalRect == null) {
            ViewCompatLollipop.sThreadLocalRect = new ThreadLocal();
        }

        Object v0 = ViewCompatLollipop.sThreadLocalRect.get();
        if(v0 == null) {
            Rect v0_1 = new Rect();
            ViewCompatLollipop.sThreadLocalRect.set(v0_1);
        }

        ((Rect)v0).setEmpty();
        return ((Rect)v0);
    }

    public static String getTransitionName(View arg1) {
        return arg1.getTransitionName();
    }

    public static float getTranslationZ(View arg1) {
        return arg1.getTranslationZ();
    }

    public static float getZ(View arg1) {
        return arg1.getZ();
    }

    public static boolean hasNestedScrollingParent(View arg1) {
        return arg1.hasNestedScrollingParent();
    }

    public static boolean isImportantForAccessibility(View arg1) {
        return arg1.isImportantForAccessibility();
    }

    public static boolean isNestedScrollingEnabled(View arg1) {
        return arg1.isNestedScrollingEnabled();
    }

    static void offsetLeftAndRight(View arg7, int arg8) {
        int v0;
        Rect v3 = ViewCompatLollipop.getEmptyTempRect();
        ViewParent v1 = arg7.getParent();
        if((v1 instanceof View)) {
            v3.set(v1.getLeft(), v1.getTop(), v1.getRight(), v1.getBottom());
            v0 = !v3.intersects(arg7.getLeft(), arg7.getTop(), arg7.getRight(), arg7.getBottom()) ? 1 : 0;
        }
        else {
            v0 = 0;
        }

        ViewCompatHC.offsetLeftAndRight(arg7, arg8);
        if(v0 != 0 && (v3.intersect(arg7.getLeft(), arg7.getTop(), arg7.getRight(), arg7.getBottom()))) {
            ((View)v1).invalidate(v3);
        }
    }

    static void offsetTopAndBottom(View arg7, int arg8) {
        int v0;
        Rect v3 = ViewCompatLollipop.getEmptyTempRect();
        ViewParent v1 = arg7.getParent();
        if((v1 instanceof View)) {
            v3.set(v1.getLeft(), v1.getTop(), v1.getRight(), v1.getBottom());
            v0 = !v3.intersects(arg7.getLeft(), arg7.getTop(), arg7.getRight(), arg7.getBottom()) ? 1 : 0;
        }
        else {
            v0 = 0;
        }

        ViewCompatHC.offsetTopAndBottom(arg7, arg8);
        if(v0 != 0 && (v3.intersect(arg7.getLeft(), arg7.getTop(), arg7.getRight(), arg7.getBottom()))) {
            ((View)v1).invalidate(v3);
        }
    }

    public static Object onApplyWindowInsets(View arg2, Object arg3) {
        WindowInsets v3;
        WindowInsets v1 = arg2.onApplyWindowInsets(arg3);
        if(v1 != arg3) {
            v3 = new WindowInsets(v1);
        }

        return v3;
    }

    public static void requestApplyInsets(View arg0) {
        arg0.requestApplyInsets();
    }

    static void setBackgroundTintList(View arg2, ColorStateList arg3) {
        arg2.setBackgroundTintList(arg3);
        if(Build$VERSION.SDK_INT == 21) {
            Drawable v1 = arg2.getBackground();
            int v0 = arg2.getBackgroundTintList() == null || arg2.getBackgroundTintMode() == null ? 0 : 1;
            if(v1 == null) {
                return;
            }

            if(v0 == 0) {
                return;
            }

            if(v1.isStateful()) {
                v1.setState(arg2.getDrawableState());
            }

            arg2.setBackground(v1);
        }
    }

    static void setBackgroundTintMode(View arg2, PorterDuff$Mode arg3) {
        arg2.setBackgroundTintMode(arg3);
        if(Build$VERSION.SDK_INT == 21) {
            Drawable v1 = arg2.getBackground();
            int v0 = arg2.getBackgroundTintList() == null || arg2.getBackgroundTintMode() == null ? 0 : 1;
            if(v1 == null) {
                return;
            }

            if(v0 == 0) {
                return;
            }

            if(v1.isStateful()) {
                v1.setState(arg2.getDrawableState());
            }

            arg2.setBackground(v1);
        }
    }

    public static void setElevation(View arg0, float arg1) {
        arg0.setElevation(arg1);
    }

    public static void setNestedScrollingEnabled(View arg0, boolean arg1) {
        arg0.setNestedScrollingEnabled(arg1);
    }

    public static void setOnApplyWindowInsetsListener(View arg1, OnApplyWindowInsetsListenerBridge arg2) {
        if(arg2 == null) {
            arg1.setOnApplyWindowInsetsListener(null);
        }
        else {
            arg1.setOnApplyWindowInsetsListener(new View$OnApplyWindowInsetsListener(arg2) {
                public WindowInsets onApplyWindowInsets(View arg2, WindowInsets arg3) {
                    return this.val$bridge.onApplyWindowInsets(arg2, arg3);
                }
            });
        }
    }

    public static void setTransitionName(View arg0, String arg1) {
        arg0.setTransitionName(arg1);
    }

    public static void setTranslationZ(View arg0, float arg1) {
        arg0.setTranslationZ(arg1);
    }

    public static void setZ(View arg0, float arg1) {
        arg0.setZ(arg1);
    }

    public static boolean startNestedScroll(View arg1, int arg2) {
        return arg1.startNestedScroll(arg2);
    }

    public static void stopNestedScroll(View arg0) {
        arg0.stopNestedScroll();
    }
}

