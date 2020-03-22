package android.support.v4.net;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import java.net.DatagramSocket;

@TargetApi(value=24) @RequiresApi(value=24) @RestrictTo(value={Scope.LIBRARY_GROUP}) public class TrafficStatsCompatApi24 {
    public TrafficStatsCompatApi24() {
        super();
    }

    public static void tagDatagramSocket(DatagramSocket arg0) {
        TrafficStats.tagDatagramSocket(arg0);
    }

    public static void untagDatagramSocket(DatagramSocket arg0) {
        TrafficStats.untagDatagramSocket(arg0);
    }
}

