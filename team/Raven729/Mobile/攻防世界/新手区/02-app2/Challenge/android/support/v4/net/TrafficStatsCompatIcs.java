package android.support.v4.net;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.ParcelFileDescriptor;
import android.support.annotation.RequiresApi;
import java.net.DatagramSocket;
import java.net.Socket;

@TargetApi(value=14) @RequiresApi(value=14) class TrafficStatsCompatIcs {
    TrafficStatsCompatIcs() {
        super();
    }

    public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    public static void incrementOperationCount(int arg0) {
        TrafficStats.incrementOperationCount(arg0);
    }

    public static void incrementOperationCount(int arg0, int arg1) {
        TrafficStats.incrementOperationCount(arg0, arg1);
    }

    public static void setThreadStatsTag(int arg0) {
        TrafficStats.setThreadStatsTag(arg0);
    }

    public static void tagDatagramSocket(DatagramSocket arg3) {
        ParcelFileDescriptor v0 = ParcelFileDescriptor.fromDatagramSocket(arg3);
        TrafficStats.tagSocket(new DatagramSocketWrapper(arg3, v0.getFileDescriptor()));
        v0.detachFd();
    }

    public static void tagSocket(Socket arg0) {
        TrafficStats.tagSocket(arg0);
    }

    public static void untagDatagramSocket(DatagramSocket arg3) {
        ParcelFileDescriptor v0 = ParcelFileDescriptor.fromDatagramSocket(arg3);
        TrafficStats.untagSocket(new DatagramSocketWrapper(arg3, v0.getFileDescriptor()));
        v0.detachFd();
    }

    public static void untagSocket(Socket arg0) {
        TrafficStats.untagSocket(arg0);
    }
}

