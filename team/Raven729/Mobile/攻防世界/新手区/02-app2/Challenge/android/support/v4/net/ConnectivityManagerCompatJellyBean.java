package android.support.v4.net;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.support.annotation.RequiresApi;

@TargetApi(value=16) @RequiresApi(value=16) class ConnectivityManagerCompatJellyBean {
    ConnectivityManagerCompatJellyBean() {
        super();
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager arg1) {
        return arg1.isActiveNetworkMetered();
    }
}

