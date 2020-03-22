package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.support.annotation.RequiresApi;

@TargetApi(value=24) @RequiresApi(value=24) class NotificationManagerCompatApi24 {
    NotificationManagerCompatApi24() {
        super();
    }

    public static boolean areNotificationsEnabled(NotificationManager arg1) {
        return arg1.areNotificationsEnabled();
    }

    public static int getImportance(NotificationManager arg1) {
        return arg1.getImportance();
    }
}

