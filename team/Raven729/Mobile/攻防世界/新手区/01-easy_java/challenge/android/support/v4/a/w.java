package android.support.v4.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Build$VERSION;
import android.util.Log;

public final class w {
    public static Intent a(Activity arg5) {
        Intent v0;
        Intent v1 = null;
        if(Build$VERSION.SDK_INT >= 16) {
            v0 = arg5.getParentActivityIntent();
            if(v0 == null) {
                goto label_7;
            }

            return v0;
        }

    label_7:
        String v0_1 = w.b(arg5);
        if(v0_1 == null) {
            return v1;
        }

        ComponentName v2 = new ComponentName(((Context)arg5), v0_1);
        try {
            if(w.b(((Context)arg5), v2) == null) {
                return Intent.makeMainActivity(v2);
            }

            v0 = new Intent().setComponent(v2);
        }
        catch(PackageManager$NameNotFoundException v2_1) {
            Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName \'" + v0_1 + "\' in manifest");
            v0 = v1;
        }

        return v0;
    }

    public static Intent a(Context arg3, ComponentName arg4) {
        Intent v0_1;
        String v0 = w.b(arg3, arg4);
        if(v0 == null) {
            v0_1 = null;
        }
        else {
            ComponentName v1 = new ComponentName(arg4.getPackageName(), v0);
            v0_1 = w.b(arg3, v1) == null ? Intent.makeMainActivity(v1) : new Intent().setComponent(v1);
        }

        return v0_1;
    }

    public static boolean a(Activity arg2, Intent arg3) {
        boolean v0;
        if(Build$VERSION.SDK_INT >= 16) {
            v0 = arg2.shouldUpRecreateTask(arg3);
        }
        else {
            String v0_1 = arg2.getIntent().getAction();
            if(v0_1 != null && !v0_1.equals("android.intent.action.MAIN")) {
                return true;
            }

            v0 = false;
        }

        return v0;
    }

    public static String b(Activity arg2) {
        try {
            return w.b(((Context)arg2), arg2.getComponentName());
        }
        catch(PackageManager$NameNotFoundException v0) {
            throw new IllegalArgumentException(((Throwable)v0));
        }
    }

    public static String b(Context arg4, ComponentName arg5) {
        String v0;
        String v1 = null;
        ActivityInfo v2 = arg4.getPackageManager().getActivityInfo(arg5, 0x80);
        if(Build$VERSION.SDK_INT >= 16) {
            v0 = v2.parentActivityName;
            if(v0 == null) {
                goto label_10;
            }
        }
        else {
        label_10:
            if(v2.metaData == null) {
                v0 = v1;
            }
            else {
                v0 = v2.metaData.getString("android.support.PARENT_ACTIVITY");
                if(v0 == null) {
                    v0 = v1;
                }
                else if(v0.charAt(0) == 46) {
                    v0 = arg4.getPackageName() + v0;
                }
            }
        }

        return v0;
    }

    public static void b(Activity arg2, Intent arg3) {
        if(Build$VERSION.SDK_INT >= 16) {
            arg2.navigateUpTo(arg3);
        }
        else {
            arg3.addFlags(0x4000000);
            arg2.startActivity(arg3);
            arg2.finish();
        }
    }
}

