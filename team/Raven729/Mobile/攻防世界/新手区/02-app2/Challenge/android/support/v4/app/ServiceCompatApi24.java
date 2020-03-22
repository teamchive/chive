package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Service;
import android.support.annotation.RequiresApi;

@TargetApi(value=24) @RequiresApi(value=24) class ServiceCompatApi24 {
    ServiceCompatApi24() {
        super();
    }

    public static void stopForeground(Service arg0, int arg1) {
        arg0.stopForeground(arg1);
    }
}

