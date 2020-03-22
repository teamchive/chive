package android.support.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build$VERSION;
import android.os.Parcelable;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ConnectivityManagerCompat {
    class Api24ConnectivityManagerCompatImpl extends JellyBeanConnectivityManagerCompatImpl {
        Api24ConnectivityManagerCompatImpl() {
            super();
        }

        public int getRestrictBackgroundStatus(ConnectivityManager arg2) {
            return ConnectivityManagerCompatApi24.getRestrictBackgroundStatus(arg2);
        }
    }

    class BaseConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        BaseConnectivityManagerCompatImpl() {
            super();
        }

        public int getRestrictBackgroundStatus(ConnectivityManager arg2) {
            return 3;
        }

        public boolean isActiveNetworkMetered(ConnectivityManager arg3) {
            boolean v0 = true;
            NetworkInfo v1 = arg3.getActiveNetworkInfo();
            if(v1 != null) {
                if(v1.getType() != 1) {
                }
                else {
                    v0 = false;
                }
            }

            return v0;
        }
    }

    interface ConnectivityManagerCompatImpl {
        int getRestrictBackgroundStatus(ConnectivityManager arg1);

        boolean isActiveNetworkMetered(ConnectivityManager arg1);
    }

    class HoneycombMR2ConnectivityManagerCompatImpl extends BaseConnectivityManagerCompatImpl {
        HoneycombMR2ConnectivityManagerCompatImpl() {
            super();
        }

        public boolean isActiveNetworkMetered(ConnectivityManager arg2) {
            return ConnectivityManagerCompatHoneycombMR2.isActiveNetworkMetered(arg2);
        }
    }

    class JellyBeanConnectivityManagerCompatImpl extends HoneycombMR2ConnectivityManagerCompatImpl {
        JellyBeanConnectivityManagerCompatImpl() {
            super();
        }

        public boolean isActiveNetworkMetered(ConnectivityManager arg2) {
            return ConnectivityManagerCompatJellyBean.isActiveNetworkMetered(arg2);
        }
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface RestrictBackgroundStatus {
    }

    private static final ConnectivityManagerCompatImpl IMPL = null;
    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;

    static {
        if(Build$VERSION.SDK_INT >= 24) {
            ConnectivityManagerCompat.IMPL = new Api24ConnectivityManagerCompatImpl();
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            ConnectivityManagerCompat.IMPL = new JellyBeanConnectivityManagerCompatImpl();
        }
        else if(Build$VERSION.SDK_INT >= 13) {
            ConnectivityManagerCompat.IMPL = new HoneycombMR2ConnectivityManagerCompatImpl();
        }
        else {
            ConnectivityManagerCompat.IMPL = new BaseConnectivityManagerCompatImpl();
        }
    }

    private ConnectivityManagerCompat() {
        super();
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager arg1, Intent arg2) {
        Parcelable v0 = arg2.getParcelableExtra("networkInfo");
        NetworkInfo v0_1 = v0 != null ? arg1.getNetworkInfo(((NetworkInfo)v0).getType()) : null;
        return v0_1;
    }

    public static int getRestrictBackgroundStatus(ConnectivityManager arg1) {
        return ConnectivityManagerCompat.IMPL.getRestrictBackgroundStatus(arg1);
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager arg1) {
        return ConnectivityManagerCompat.IMPL.isActiveNetworkMetered(arg1);
    }
}

