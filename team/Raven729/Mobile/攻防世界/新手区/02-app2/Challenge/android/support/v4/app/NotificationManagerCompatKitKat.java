package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;

@TargetApi(value=19) @RequiresApi(value=19) class NotificationManagerCompatKitKat {
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";

    NotificationManagerCompatKitKat() {
        super();
    }

    public static boolean areNotificationsEnabled(Context arg10) {
        Object v0 = arg10.getSystemService("appops");
        ApplicationInfo v1 = arg10.getApplicationInfo();
        String v4 = arg10.getApplicationContext().getPackageName();
        int v5 = v1.uid;
        try {
            Class v1_1 = Class.forName(AppOpsManager.class.getName());
            if(v1_1.getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(v0, new Object[]{Integer.valueOf(v1_1.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class).intValue()), Integer.valueOf(v5), v4}).intValue() != 0) {
                return false;
            }

            return true;
        }
        catch(RuntimeException v0_1) {
        }
        catch(IllegalAccessException v0_2) {
        }
        catch(InvocationTargetException v0_3) {
        }
        catch(NoSuchFieldException v0_4) {
        }
        catch(NoSuchMethodException v0_5) {
        }
        catch(ClassNotFoundException v0_6) {
        }

        boolean v0_7 = true;
        return v0_7;
    }
}

