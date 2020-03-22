package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat$EditorCompat;

public class AppLaunchChecker {
    private static final String KEY_STARTED_FROM_LAUNCHER = "startedFromLauncher";
    private static final String SHARED_PREFS_NAME = "android.support.AppLaunchChecker";

    public AppLaunchChecker() {
        super();
    }

    public static boolean hasStartedFromLauncher(Context arg3) {
        return arg3.getSharedPreferences("android.support.AppLaunchChecker", 0).getBoolean("startedFromLauncher", false);
    }

    public static void onActivityCreate(Activity arg4) {
        SharedPreferences v0 = arg4.getSharedPreferences("android.support.AppLaunchChecker", 0);
        if(!v0.getBoolean("startedFromLauncher", false)) {
            Intent v1 = arg4.getIntent();
            if(v1 != null && ("android.intent.action.MAIN".equals(v1.getAction()))) {
                if(!v1.hasCategory("android.intent.category.LAUNCHER") && !v1.hasCategory("android.intent.category.LEANBACK_LAUNCHER")) {
                    return;
                }

                EditorCompat.getInstance().apply(v0.edit().putBoolean("startedFromLauncher", true));
            }
        }
    }
}

