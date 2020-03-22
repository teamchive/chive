package android.support.v4.net;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.support.annotation.RequiresApi;

@TargetApi(value=24) @RequiresApi(value=24) class ConnectivityManagerCompatApi24 {
    ConnectivityManagerCompatApi24() {
        super();
    }

    public static int getRestrictBackgroundStatus(ConnectivityManager arg1) {
        return arg1.getRestrictBackgroundStatus();
    }
}

