package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresApi;

@TargetApi(value=11) @RequiresApi(value=11) class TaskStackBuilderHoneycomb {
    TaskStackBuilderHoneycomb() {
        super();
    }

    public static PendingIntent getActivitiesPendingIntent(Context arg1, int arg2, Intent[] arg3, int arg4) {
        return PendingIntent.getActivities(arg1, arg2, arg3, arg4);
    }
}

