package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build$VERSION;
import android.support.v4.h.p;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class bc {
    private static Method a;

    static {
        if(Build$VERSION.SDK_INT >= 18) {
            try {
                bc.a = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                if(bc.a.isAccessible()) {
                    return;
                }

                bc.a.setAccessible(true);
            }
            catch(NoSuchMethodException v0) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    public static void a(View arg3, Rect arg4, Rect arg5) {
        if(bc.a != null) {
            try {
                bc.a.invoke(arg3, arg4, arg5);
            }
            catch(Exception v0) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", ((Throwable)v0));
            }
        }
    }

    public static boolean a(View arg2) {
        boolean v0 = true;
        if(p.b(arg2) != 1) {
            v0 = false;
        }

        return v0;
    }

    public static void b(View arg3) {
        if(Build$VERSION.SDK_INT >= 16) {
            try {
                Method v0_3 = arg3.getClass().getMethod("makeOptionalFitsSystemWindows");
                if(!v0_3.isAccessible()) {
                    v0_3.setAccessible(true);
                }

                v0_3.invoke(arg3);
            }
            catch(IllegalAccessException v0) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", ((Throwable)v0));
            }
            catch(InvocationTargetException v0_1) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", ((Throwable)v0_1));
            }
            catch(NoSuchMethodException v0_2) {
                Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            }
        }
    }
}

