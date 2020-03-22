package android.support.v4.net;

import android.os.Build$VERSION;
import java.net.DatagramSocket;
import java.net.Socket;

public final class TrafficStatsCompat {
    class Api24TrafficStatsCompatImpl extends IcsTrafficStatsCompatImpl {
        Api24TrafficStatsCompatImpl() {
            super();
        }

        public void tagDatagramSocket(DatagramSocket arg1) {
            TrafficStatsCompatApi24.tagDatagramSocket(arg1);
        }

        public void untagDatagramSocket(DatagramSocket arg1) {
            TrafficStatsCompatApi24.untagDatagramSocket(arg1);
        }
    }

    class BaseTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        class android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl$1 extends ThreadLocal {
            android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl$1(BaseTrafficStatsCompatImpl arg1) {
                BaseTrafficStatsCompatImpl.this = arg1;
                super();
            }

            protected SocketTags initialValue() {
                return new SocketTags();
            }

            protected Object initialValue() {
                return this.initialValue();
            }
        }

        class SocketTags {
            public int statsTag;

            SocketTags() {
                super();
                this.statsTag = -1;
            }
        }

        private ThreadLocal mThreadSocketTags;

        BaseTrafficStatsCompatImpl() {
            super();
            this.mThreadSocketTags = new android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl$1(this);
        }

        public void clearThreadStatsTag() {
            this.mThreadSocketTags.get().statsTag = -1;
        }

        public int getThreadStatsTag() {
            return this.mThreadSocketTags.get().statsTag;
        }

        public void incrementOperationCount(int arg1) {
        }

        public void incrementOperationCount(int arg1, int arg2) {
        }

        public void setThreadStatsTag(int arg2) {
            this.mThreadSocketTags.get().statsTag = arg2;
        }

        public void tagDatagramSocket(DatagramSocket arg1) {
        }

        public void tagSocket(Socket arg1) {
        }

        public void untagDatagramSocket(DatagramSocket arg1) {
        }

        public void untagSocket(Socket arg1) {
        }
    }

    class IcsTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        IcsTrafficStatsCompatImpl() {
            super();
        }

        public void clearThreadStatsTag() {
            TrafficStatsCompatIcs.clearThreadStatsTag();
        }

        public int getThreadStatsTag() {
            return TrafficStatsCompatIcs.getThreadStatsTag();
        }

        public void incrementOperationCount(int arg1) {
            TrafficStatsCompatIcs.incrementOperationCount(arg1);
        }

        public void incrementOperationCount(int arg1, int arg2) {
            TrafficStatsCompatIcs.incrementOperationCount(arg1, arg2);
        }

        public void setThreadStatsTag(int arg1) {
            TrafficStatsCompatIcs.setThreadStatsTag(arg1);
        }

        public void tagDatagramSocket(DatagramSocket arg1) {
            TrafficStatsCompatIcs.tagDatagramSocket(arg1);
        }

        public void tagSocket(Socket arg1) {
            TrafficStatsCompatIcs.tagSocket(arg1);
        }

        public void untagDatagramSocket(DatagramSocket arg1) {
            TrafficStatsCompatIcs.untagDatagramSocket(arg1);
        }

        public void untagSocket(Socket arg1) {
            TrafficStatsCompatIcs.untagSocket(arg1);
        }
    }

    interface TrafficStatsCompatImpl {
        void clearThreadStatsTag();

        int getThreadStatsTag();

        void incrementOperationCount(int arg1);

        void incrementOperationCount(int arg1, int arg2);

        void setThreadStatsTag(int arg1);

        void tagDatagramSocket(DatagramSocket arg1);

        void tagSocket(Socket arg1);

        void untagDatagramSocket(DatagramSocket arg1);

        void untagSocket(Socket arg1);
    }

    private static final TrafficStatsCompatImpl IMPL;

    static {
        if("N".equals(Build$VERSION.CODENAME)) {
            TrafficStatsCompat.IMPL = new Api24TrafficStatsCompatImpl();
        }
        else if(Build$VERSION.SDK_INT >= 14) {
            TrafficStatsCompat.IMPL = new IcsTrafficStatsCompatImpl();
        }
        else {
            TrafficStatsCompat.IMPL = new BaseTrafficStatsCompatImpl();
        }
    }

    private TrafficStatsCompat() {
        super();
    }

    public static void clearThreadStatsTag() {
        TrafficStatsCompat.IMPL.clearThreadStatsTag();
    }

    public static int getThreadStatsTag() {
        return TrafficStatsCompat.IMPL.getThreadStatsTag();
    }

    public static void incrementOperationCount(int arg1) {
        TrafficStatsCompat.IMPL.incrementOperationCount(arg1);
    }

    public static void incrementOperationCount(int arg1, int arg2) {
        TrafficStatsCompat.IMPL.incrementOperationCount(arg1, arg2);
    }

    public static void setThreadStatsTag(int arg1) {
        TrafficStatsCompat.IMPL.setThreadStatsTag(arg1);
    }

    public static void tagDatagramSocket(DatagramSocket arg1) {
        TrafficStatsCompat.IMPL.tagDatagramSocket(arg1);
    }

    public static void tagSocket(Socket arg1) {
        TrafficStatsCompat.IMPL.tagSocket(arg1);
    }

    public static void untagDatagramSocket(DatagramSocket arg1) {
        TrafficStatsCompat.IMPL.untagDatagramSocket(arg1);
    }

    public static void untagSocket(Socket arg1) {
        TrafficStatsCompat.IMPL.untagSocket(arg1);
    }
}

