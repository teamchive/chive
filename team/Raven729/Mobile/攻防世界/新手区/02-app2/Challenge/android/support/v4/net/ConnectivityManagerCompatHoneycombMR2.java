package android.support.v4.net;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.RequiresApi;

@TargetApi(value=13) @RequiresApi(value=13) class ConnectivityManagerCompatHoneycombMR2 {
    ConnectivityManagerCompatHoneycombMR2() {
        super();
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager arg2) {
        boolean v0 = true;
        NetworkInfo v1 = arg2.getActiveNetworkInfo();
        if(v1 != null) {
            switch(v1.getType()) {
                case 1: 
                case 7: 
                case 9: {
                    return false;
                }
                default: {
                    return v0;
                }
            }
        }

        return v0;
    }
}

