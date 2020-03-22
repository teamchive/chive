package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build$VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class n {
    private static Field a;
    private static boolean b;
    private static Class c;
    private static boolean d;
    private static Field e;
    private static boolean f;
    private static Field g;
    private static boolean h;

    static boolean a(Resources arg2) {
        boolean v0;
        if(Build$VERSION.SDK_INT >= 24) {
            v0 = n.d(arg2);
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            v0 = n.c(arg2);
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            v0 = n.b(arg2);
        }
        else {
            v0 = false;
        }

        return v0;
    }

    private static boolean a(Object arg6) {
        Object v0_4;
        boolean v0_1;
        if(!n.d) {
            try {
                n.c = Class.forName("android.content.res.ThemedResourceCache");
            }
            catch(ClassNotFoundException v0) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", ((Throwable)v0));
            }

            n.d = true;
        }

        if(n.c == null) {
            v0_1 = false;
            return v0_1;
        }

        if(!n.f) {
            try {
                n.e = n.c.getDeclaredField("mUnthemedEntries");
                n.e.setAccessible(true);
            }
            catch(NoSuchFieldException v0_2) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", ((Throwable)v0_2));
            }

            n.f = true;
        }

        if(n.e == null) {
            return false;
        }

        Object v3 = null;
        try {
            v0_4 = n.e.get(arg6);
        }
        catch(IllegalAccessException v0_3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", ((Throwable)v0_3));
            v0_4 = v3;
        }

        if(v0_4 != null) {
            ((LongSparseArray)v0_4).clear();
            v0_1 = true;
        }
        else {
            v0_1 = false;
        }

        return v0_1;
    }

    private static boolean b(Resources arg5) {
        Object v0_2;
        Object v2;
        if(!n.b) {
            try {
                n.a = Resources.class.getDeclaredField("mDrawableCache");
                n.a.setAccessible(true);
            }
            catch(NoSuchFieldException v0) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", ((Throwable)v0));
            }

            n.b = true;
        }

        if(n.a != null) {
            v2 = null;
            try {
                v0_2 = n.a.get(arg5);
                goto label_16;
            }
            catch(IllegalAccessException v0_1) {
                goto label_28;
            }
        }

    label_31:
        boolean v0_3 = false;
        return v0_3;
    label_28:
        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", ((Throwable)v0_1));
        v0_2 = v2;
    label_16:
        if(v0_2 == null) {
            goto label_31;
        }

        ((Map)v0_2).clear();
        return true;
    }

    private static boolean c(Resources arg6) {
        Object v2_2;
        boolean v1 = false;
        boolean v0 = true;
        if(!n.b) {
            try {
                n.a = Resources.class.getDeclaredField("mDrawableCache");
                n.a.setAccessible(true);
            }
            catch(NoSuchFieldException v2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", ((Throwable)v2));
            }

            n.b = true;
        }

        Object v3 = null;
        if(n.a != null) {
            try {
                v2_2 = n.a.get(arg6);
                goto label_17;
            }
            catch(IllegalAccessException v2_1) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", ((Throwable)v2_1));
            }
        }

        v2_2 = v3;
    label_17:
        if(v2_2 != null) {
            if(v2_2 == null || !n.a(v2_2)) {
                v0 = false;
            }

            v1 = v0;
        }

        return v1;
    }

    private static boolean d(Resources arg7) {
        Object v2_2;
        Object v4;
        Object v3 = null;
        boolean v1 = false;
        boolean v0 = true;
        if(!n.h) {
            try {
                n.g = Resources.class.getDeclaredField("mResourcesImpl");
                n.g.setAccessible(true);
            }
            catch(NoSuchFieldException v2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", ((Throwable)v2));
            }

            n.h = true;
        }

        if(n.g != null) {
            try {
                v4 = n.g.get(arg7);
            }
            catch(IllegalAccessException v2_1) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", ((Throwable)v2_1));
                v4 = v3;
            }

            if(v4 == null) {
                return v1;
            }

            if(!n.b) {
                try {
                    n.a = v4.getClass().getDeclaredField("mDrawableCache");
                    n.a.setAccessible(true);
                }
                catch(NoSuchFieldException v2) {
                    Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", ((Throwable)v2));
                }

                n.b = true;
            }

            if(n.a != null) {
                try {
                    v2_2 = n.a.get(v4);
                    goto label_39;
                }
                catch(IllegalAccessException v2_1) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", ((Throwable)v2_1));
                }
            }

            v2_2 = v3;
        label_39:
            if(v2_2 == null || !n.a(v2_2)) {
                v0 = false;
            }

            v1 = v0;
        }

        return v1;
    }
}

