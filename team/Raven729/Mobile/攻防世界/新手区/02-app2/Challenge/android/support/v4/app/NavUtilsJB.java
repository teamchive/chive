package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.RequiresApi;

@TargetApi(value=16) @RequiresApi(value=16) class NavUtilsJB {
    NavUtilsJB() {
        super();
    }

    public static Intent getParentActivityIntent(Activity arg1) {
        return arg1.getParentActivityIntent();
    }

    public static String getParentActivityName(ActivityInfo arg1) {
        return arg1.parentActivityName;
    }

    public static void navigateUpTo(Activity arg0, Intent arg1) {
        arg0.navigateUpTo(arg1);
    }

    public static boolean shouldUpRecreateTask(Activity arg1, Intent arg2) {
        return arg1.shouldUpRecreateTask(arg2);
    }
}

