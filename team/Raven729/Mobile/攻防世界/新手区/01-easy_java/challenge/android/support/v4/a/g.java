package android.support.v4.a;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class g {
    class a {
        private static Method a;
        private static boolean b;

        public static IBinder a(Bundle arg7, String arg8) {
            Object v0_4;
            Method v1 = null;
            if(!a.b) {
                try {
                    a.a = Bundle.class.getMethod("getIBinder", String.class);
                    a.a.setAccessible(true);
                }
                catch(NoSuchMethodException v0) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", ((Throwable)v0));
                }

                a.b = true;
            }

            if(a.a == null) {
                goto label_36;
            }

            try {
                v0_4 = a.a.invoke(arg7, arg8);
            }
            catch(IllegalAccessException v0_1) {
                goto label_32;
            }
            catch(IllegalArgumentException v0_2) {
                goto label_32;
            label_36:
                IBinder v0_5 = ((IBinder)v1);
            }
            catch(InvocationTargetException v0_3) {
            label_32:
                Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", ((Throwable)v0_1));
                a.a = v1;
                goto label_36;
            }

            return ((IBinder)v0_4);
        }
    }

    public static IBinder a(Bundle arg2, String arg3) {
        IBinder v0 = Build$VERSION.SDK_INT >= 18 ? arg2.getBinder(arg3) : a.a(arg2, arg3);
        return v0;
    }
}

