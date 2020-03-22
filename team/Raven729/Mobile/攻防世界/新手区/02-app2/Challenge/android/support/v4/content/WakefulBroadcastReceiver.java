package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager$WakeLock;
import android.util.Log;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final String EXTRA_WAKE_LOCK_ID = "android.support.content.wakelockid";
    private static final SparseArray mActiveWakeLocks;
    private static int mNextId;

    static {
        WakefulBroadcastReceiver.mActiveWakeLocks = new SparseArray();
        WakefulBroadcastReceiver.mNextId = 1;
    }

    public WakefulBroadcastReceiver() {
        super();
    }

    public static boolean completeWakefulIntent(Intent arg6) {
        boolean v0 = false;
        int v2 = arg6.getIntExtra("android.support.content.wakelockid", 0);
        if(v2 != 0) {
            SparseArray v3 = WakefulBroadcastReceiver.mActiveWakeLocks;
            __monitor_enter(v3);
            try {
                Object v0_2 = WakefulBroadcastReceiver.mActiveWakeLocks.get(v2);
                if(v0_2 != null) {
                    ((PowerManager$WakeLock)v0_2).release();
                    WakefulBroadcastReceiver.mActiveWakeLocks.remove(v2);
                    __monitor_exit(v3);
                    v0 = true;
                }
                else {
                    Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + v2);
                    __monitor_exit(v3);
                    return true;
                label_29:
                    __monitor_exit(v3);
                    goto label_30;
                }

                return v0;
            }
            catch(Throwable v0_1) {
                goto label_29;
            }

        label_30:
            throw v0_1;
        }

        return v0;
    }

    public static ComponentName startWakefulService(Context arg7, Intent arg8) {
        ComponentName v0_1;
        SparseArray v2 = WakefulBroadcastReceiver.mActiveWakeLocks;
        __monitor_enter(v2);
        try {
            int v3 = WakefulBroadcastReceiver.mNextId;
            ++WakefulBroadcastReceiver.mNextId;
            if(WakefulBroadcastReceiver.mNextId <= 0) {
                WakefulBroadcastReceiver.mNextId = 1;
            }

            arg8.putExtra("android.support.content.wakelockid", v3);
            ComponentName v1 = arg7.startService(arg8);
            if(v1 == null) {
                v0_1 = null;
                __monitor_exit(v2);
            }
            else {
                PowerManager$WakeLock v0_2 = arg7.getSystemService("power").newWakeLock(1, "wake:" + v1.flattenToShortString());
                v0_2.setReferenceCounted(false);
                v0_2.acquire(60000);
                WakefulBroadcastReceiver.mActiveWakeLocks.put(v3, v0_2);
                __monitor_exit(v2);
                v0_1 = v1;
            }

            return v0_1;
        label_38:
            __monitor_exit(v2);
        }
        catch(Throwable v0) {
            goto label_38;
        }

        throw v0;
    }
}

