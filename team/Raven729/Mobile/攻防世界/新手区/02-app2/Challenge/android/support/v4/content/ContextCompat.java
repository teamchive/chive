package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.BuildCompat;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;

public class ContextCompat {
    private static final String DIR_ANDROID = "Android";
    private static final String DIR_OBB = "obb";
    private static final String TAG = "ContextCompat";
    private static final Object sLock;
    private static TypedValue sTempValue;

    static {
        ContextCompat.sLock = new Object();
    }

    protected ContextCompat() {
        super();
    }

    private static File buildPath(File arg5, String[] arg6) {
        File v0;
        int v3 = arg6.length;
        int v2 = 0;
        File v1;
        for(v1 = arg5; v2 < v3; v1 = v0) {
            String v4 = arg6[v2];
            if(v1 == null) {
                v0 = new File(v4);
            }
            else if(v4 != null) {
                v0 = new File(v1, v4);
            }
            else {
                v0 = v1;
            }

            ++v2;
        }

        return v1;
    }

    public static int checkSelfPermission(@NonNull Context arg2, @NonNull String arg3) {
        if(arg3 == null) {
            throw new IllegalArgumentException("permission is null");
        }

        return arg2.checkPermission(arg3, Process.myPid(), Process.myUid());
    }

    public static Context createDeviceProtectedStorageContext(Context arg1) {
        Context v0 = BuildCompat.isAtLeastN() ? ContextCompatApi24.createDeviceProtectedStorageContext(arg1) : null;
        return v0;
    }

    private static File createFilesDir(File arg4) {
        Class v1 = ContextCompat.class;
        __monitor_enter(v1);
        try {
            if(!arg4.exists() && !arg4.mkdirs() && !arg4.exists()) {
                Log.w("ContextCompat", "Unable to create files subdir " + arg4.getPath());
                arg4 = null;
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return arg4;
    }

    public static File getCodeCacheDir(Context arg3) {
        File v0 = Build$VERSION.SDK_INT >= 21 ? ContextCompatApi21.getCodeCacheDir(arg3) : ContextCompat.createFilesDir(new File(arg3.getApplicationInfo().dataDir, "code_cache"));
        return v0;
    }

    @ColorInt public static final int getColor(Context arg2, @ColorRes int arg3) {
        int v0 = Build$VERSION.SDK_INT >= 23 ? ContextCompatApi23.getColor(arg2, arg3) : arg2.getResources().getColor(arg3);
        return v0;
    }

    public static final ColorStateList getColorStateList(Context arg2, @ColorRes int arg3) {
        ColorStateList v0 = Build$VERSION.SDK_INT >= 23 ? ContextCompatApi23.getColorStateList(arg2, arg3) : arg2.getResources().getColorStateList(arg3);
        return v0;
    }

    public static File getDataDir(Context arg2) {
        File v0;
        if(BuildCompat.isAtLeastN()) {
            v0 = ContextCompatApi24.getDataDir(arg2);
        }
        else {
            String v1 = arg2.getApplicationInfo().dataDir;
            v0 = v1 != null ? new File(v1) : null;
        }

        return v0;
    }

    public static final Drawable getDrawable(Context arg4, @DrawableRes int arg5) {
        Drawable v0_1;
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 21) {
            v0_1 = ContextCompatApi21.getDrawable(arg4, arg5);
        }
        else if(v0 >= 16) {
            v0_1 = arg4.getResources().getDrawable(arg5);
        }
        else {
            Object v1 = ContextCompat.sLock;
            __monitor_enter(v1);
            try {
                if(ContextCompat.sTempValue == null) {
                    ContextCompat.sTempValue = new TypedValue();
                }

                arg4.getResources().getValue(arg5, ContextCompat.sTempValue, true);
                v0 = ContextCompat.sTempValue.resourceId;
                __monitor_exit(v1);
            }
            catch(Throwable v0_2) {
                try {
                label_28:
                    __monitor_exit(v1);
                }
                catch(Throwable v0_2) {
                    goto label_28;
                }

                throw v0_2;
            }

            v0_1 = arg4.getResources().getDrawable(v0);
        }

        return v0_1;
    }

    public static File[] getExternalCacheDirs(Context arg3) {
        File[] v0 = Build$VERSION.SDK_INT >= 19 ? ContextCompatKitKat.getExternalCacheDirs(arg3) : new File[]{arg3.getExternalCacheDir()};
        return v0;
    }

    public static File[] getExternalFilesDirs(Context arg3, String arg4) {
        File[] v0 = Build$VERSION.SDK_INT >= 19 ? ContextCompatKitKat.getExternalFilesDirs(arg3, arg4) : new File[]{arg3.getExternalFilesDir(arg4)};
        return v0;
    }

    public static final File getNoBackupFilesDir(Context arg3) {
        File v0 = Build$VERSION.SDK_INT >= 21 ? ContextCompatApi21.getNoBackupFilesDir(arg3) : ContextCompat.createFilesDir(new File(arg3.getApplicationInfo().dataDir, "no_backup"));
        return v0;
    }

    public static File[] getObbDirs(Context arg6) {
        File[] v0_1;
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 19) {
            v0_1 = ContextCompatKitKat.getObbDirs(arg6);
        }
        else {
            File v0_2 = v0 >= 11 ? ContextCompatHoneycomb.getObbDir(arg6) : ContextCompat.buildPath(Environment.getExternalStorageDirectory(), new String[]{"Android", "obb", arg6.getPackageName()});
            v0_1 = new File[]{v0_2};
        }

        return v0_1;
    }

    public static boolean isDeviceProtectedStorage(Context arg1) {
        boolean v0 = BuildCompat.isAtLeastN() ? ContextCompatApi24.isDeviceProtectedStorage(arg1) : false;
        return v0;
    }

    public static boolean startActivities(Context arg1, Intent[] arg2) {
        return ContextCompat.startActivities(arg1, arg2, null);
    }

    public static boolean startActivities(Context arg3, Intent[] arg4, Bundle arg5) {
        boolean v0 = true;
        int v1 = Build$VERSION.SDK_INT;
        if(v1 >= 16) {
            ContextCompatJellybean.startActivities(arg3, arg4, arg5);
        }
        else if(v1 >= 11) {
            ContextCompatHoneycomb.startActivities(arg3, arg4);
        }
        else {
            v0 = false;
        }

        return v0;
    }

    public static void startActivity(Context arg2, Intent arg3, @Nullable Bundle arg4) {
        if(Build$VERSION.SDK_INT >= 16) {
            ContextCompatJellybean.startActivity(arg2, arg3, arg4);
        }
        else {
            arg2.startActivity(arg3);
        }
    }
}

