package android.support.v4.app;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(value=9) @RequiresApi(value=9) class BundleCompatGingerbread {
    private static final String TAG = "BundleCompatGingerbread";
    private static Method sGetIBinderMethod;
    private static boolean sGetIBinderMethodFetched;
    private static Method sPutIBinderMethod;
    private static boolean sPutIBinderMethodFetched;

    BundleCompatGingerbread() {
        super();
    }

    public static IBinder getBinder(Bundle arg7, String arg8) {
        IBinder v0_5;
        Method v1 = null;
        if(!BundleCompatGingerbread.sGetIBinderMethodFetched) {
            try {
                BundleCompatGingerbread.sGetIBinderMethod = Bundle.class.getMethod("getIBinder", String.class);
                BundleCompatGingerbread.sGetIBinderMethod.setAccessible(true);
            }
            catch(NoSuchMethodException v0) {
                Log.i("BundleCompatGingerbread", "Failed to retrieve getIBinder method", ((Throwable)v0));
            }

            BundleCompatGingerbread.sGetIBinderMethodFetched = true;
        }

        if(BundleCompatGingerbread.sGetIBinderMethod == null) {
            goto label_36;
        }

        try {
            Object v0_4 = BundleCompatGingerbread.sGetIBinderMethod.invoke(arg7, arg8);
        }
        catch(IllegalAccessException v0_1) {
            goto label_32;
        }
        catch(IllegalArgumentException v0_2) {
            goto label_32;
        label_36:
            v0_5 = ((IBinder)v1);
        }
        catch(InvocationTargetException v0_3) {
        label_32:
            Log.i("BundleCompatGingerbread", "Failed to invoke getIBinder via reflection", ((Throwable)v0_3));
            BundleCompatGingerbread.sGetIBinderMethod = v1;
            goto label_36;
        }

        return v0_5;
    }

    public static void putBinder(Bundle arg6, String arg7, IBinder arg8) {
        if(!BundleCompatGingerbread.sPutIBinderMethodFetched) {
            try {
                BundleCompatGingerbread.sPutIBinderMethod = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                BundleCompatGingerbread.sPutIBinderMethod.setAccessible(true);
            }
            catch(NoSuchMethodException v0) {
                Log.i("BundleCompatGingerbread", "Failed to retrieve putIBinder method", ((Throwable)v0));
            }

            BundleCompatGingerbread.sPutIBinderMethodFetched = true;
        }

        if(BundleCompatGingerbread.sPutIBinderMethod != null) {
            try {
                BundleCompatGingerbread.sPutIBinderMethod.invoke(arg6, arg7, arg8);
                return;
            }
            catch(IllegalArgumentException v0_1) {
            }
            catch(IllegalAccessException v0_2) {
            }
            catch(InvocationTargetException v0_3) {
            }

            Log.i("BundleCompatGingerbread", "Failed to invoke putIBinder via reflection", ((Throwable)v0_3));
            BundleCompatGingerbread.sPutIBinderMethod = null;
        }
    }
}

