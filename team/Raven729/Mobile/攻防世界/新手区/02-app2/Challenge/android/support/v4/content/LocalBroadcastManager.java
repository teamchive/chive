package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class LocalBroadcastManager {
    class BroadcastRecord {
        final Intent intent;
        final ArrayList receivers;

        BroadcastRecord(Intent arg1, ArrayList arg2) {
            super();
            this.intent = arg1;
            this.receivers = arg2;
        }
    }

    class ReceiverRecord {
        boolean broadcasting;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter arg1, BroadcastReceiver arg2) {
            super();
            this.filter = arg1;
            this.receiver = arg2;
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder(0x80);
            v0.append("Receiver{");
            v0.append(this.receiver);
            v0.append(" filter=");
            v0.append(this.filter);
            v0.append("}");
            return v0.toString();
        }
    }

    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private final HashMap mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private static LocalBroadcastManager mInstance;
    private static final Object mLock;
    private final ArrayList mPendingBroadcasts;
    private final HashMap mReceivers;

    static {
        LocalBroadcastManager.mLock = new Object();
    }

    private LocalBroadcastManager(Context arg3) {
        super();
        this.mReceivers = new HashMap();
        this.mActions = new HashMap();
        this.mPendingBroadcasts = new ArrayList();
        this.mAppContext = arg3;
        this.mHandler = new Handler(arg3.getMainLooper()) {
            public void handleMessage(Message arg2) {
                switch(arg2.what) {
                    case 1: {
                        LocalBroadcastManager.access$000(LocalBroadcastManager.this);
                        break;
                    }
                    default: {
                        super.handleMessage(arg2);
                        break;
                    }
                }
            }
        };
    }

    static void access$000(LocalBroadcastManager arg0) {
        arg0.executePendingBroadcasts();
    }

    private void executePendingBroadcasts() {
        int v3;
        BroadcastRecord[] v4;
    label_1:
        HashMap v1 = this.mReceivers;
        __monitor_enter(v1);
        try {
            int v0_1 = this.mPendingBroadcasts.size();
            if(v0_1 <= 0) {
                __monitor_exit(v1);
                return;
            }

            v4 = new BroadcastRecord[v0_1];
            this.mPendingBroadcasts.toArray(((Object[])v4));
            this.mPendingBroadcasts.clear();
            __monitor_exit(v1);
            v3 = 0;
        }
        catch(Throwable v0) {
            try {
            label_32:
                __monitor_exit(v1);
            }
            catch(Throwable v0) {
                goto label_32;
            }

            throw v0;
        }

        while(true) {
            if(v3 >= v4.length) {
                goto label_1;
            }

            BroadcastRecord v5 = v4[v3];
            int v1_1;
            for(v1_1 = 0; v1_1 < v5.receivers.size(); ++v1_1) {
                v5.receivers.get(v1_1).receiver.onReceive(this.mAppContext, v5.intent);
            }

            ++v3;
        }
    }

    public static LocalBroadcastManager getInstance(Context arg3) {
        Object v1 = LocalBroadcastManager.mLock;
        __monitor_enter(v1);
        try {
            if(LocalBroadcastManager.mInstance == null) {
                LocalBroadcastManager.mInstance = new LocalBroadcastManager(arg3.getApplicationContext());
            }

            __monitor_exit(v1);
            return LocalBroadcastManager.mInstance;
        label_12:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_12;
        }

        throw v0;
    }

    public void registerReceiver(BroadcastReceiver arg7, IntentFilter arg8) {
        ArrayList v0_2;
        HashMap v2 = this.mReceivers;
        __monitor_enter(v2);
        try {
            ReceiverRecord v3 = new ReceiverRecord(arg8, arg7);
            Object v0_1 = this.mReceivers.get(arg7);
            if(v0_1 == null) {
                v0_2 = new ArrayList(1);
                this.mReceivers.put(arg7, v0_2);
            }

            ((ArrayList)v0_1).add(arg8);
            int v1;
            for(v1 = 0; v1 < arg8.countActions(); ++v1) {
                String v4 = arg8.getAction(v1);
                v0_1 = this.mActions.get(v4);
                if(v0_1 == null) {
                    v0_2 = new ArrayList(1);
                    this.mActions.put(v4, v0_2);
                }

                ((ArrayList)v0_1).add(v3);
            }

            __monitor_exit(v2);
            return;
        label_33:
            __monitor_exit(v2);
        }
        catch(Throwable v0) {
            goto label_33;
        }

        throw v0;
    }

    public boolean sendBroadcast(Intent arg17) {
        boolean v1_4;
        ArrayList v1_1;
        Object v9;
        int v11;
        ArrayList v10;
        HashMap v13 = this.mReceivers;
        __monitor_enter(v13);
        try {
            String v2 = arg17.getAction();
            String v3 = arg17.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri v5 = arg17.getData();
            String v4 = arg17.getScheme();
            Set v6 = arg17.getCategories();
            int v12 = (arg17.getFlags() & 8) != 0 ? 1 : 0;
            if(v12 != 0) {
                Log.v("LocalBroadcastManager", "Resolving type " + v3 + " scheme " + v4 + " of intent " + arg17);
            }

            Object v8 = this.mActions.get(arg17.getAction());
            if(v8 != null) {
                if(v12 != 0) {
                    Log.v("LocalBroadcastManager", "Action list: " + v8);
                }

                v10 = null;
                v11 = 0;
                while(true) {
                label_52:
                    if(v11 >= ((ArrayList)v8).size()) {
                        goto label_126;
                    }

                    v9 = ((ArrayList)v8).get(v11);
                    if(v12 != 0) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + ((ReceiverRecord)v9).filter);
                    }

                    if(!((ReceiverRecord)v9).broadcasting) {
                        int v1_2 = ((ReceiverRecord)v9).filter.match(v2, v3, v4, v5, v6, "LocalBroadcastManager");
                        if(v1_2 >= 0) {
                            if(v12 != 0) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(v1_2));
                            }

                            if(v10 == null) {
                                v1_1 = new ArrayList();
                            }
                            else {
                                goto label_158;
                            }

                            goto label_98;
                        }
                        else {
                            goto label_105;
                        }
                    }
                    else if(v12 != 0) {
                        Log.v("LocalBroadcastManager", "  Filter\'s target already added");
                        v1_1 = v10;
                    }
                    else {
                        goto label_116;
                    }

                    goto label_74;
                }
            }
            else {
                goto label_155;
            }

            return v1_4;
        }
        catch(Throwable v1) {
            goto label_103;
        }

    label_158:
        v1_1 = v10;
        try {
        label_98:
            v1_1.add(v9);
            ((ReceiverRecord)v9).broadcasting = true;
            goto label_74;
        }
        catch(Throwable v1) {
            goto label_103;
        }

    label_105:
        if(v12 == 0) {
            goto label_116;
        }

        switch(v1_2) {
            case -4: {
                goto label_120;
            }
            case -3: {
                goto label_118;
            }
            case -2: {
                goto label_122;
            }
            case -1: {
                goto label_124;
            }
            default: {
                try {
                    String v1_3 = "unknown reason";
                    goto label_108;
                label_118:
                    v1_3 = "action";
                    goto label_108;
                label_120:
                    v1_3 = "category";
                    goto label_108;
                label_122:
                    v1_3 = "data";
                    goto label_108;
                label_124:
                    v1_3 = "type";
                label_108:
                    Log.v("LocalBroadcastManager", "  Filter did not match: " + v1_3);
                label_116:
                    v1_1 = v10;
                label_74:
                    ++v11;
                    v10 = v1_1;
                    goto label_52;
                label_126:
                    if(v10 != null) {
                        int v2_1;
                        for(v2_1 = 0; v2_1 < v10.size(); ++v2_1) {
                            v10.get(v2_1).broadcasting = false;
                        }

                        this.mPendingBroadcasts.add(new BroadcastRecord(arg17, v10));
                        if(!this.mHandler.hasMessages(1)) {
                            this.mHandler.sendEmptyMessage(1);
                        }

                        v1_4 = true;
                        __monitor_exit(v13);
                    }
                    else {
                    label_155:
                        __monitor_exit(v13);
                        v1_4 = false;
                    }

                    return v1_4;
                label_103:
                    __monitor_exit(v13);
                    goto label_104;
                }
                catch(Throwable v1) {
                    goto label_103;
                }
            }
        }

    label_104:
        throw v1;
    }

    public void sendBroadcastSync(Intent arg2) {
        if(this.sendBroadcast(arg2)) {
            this.executePendingBroadcasts();
        }
    }

    public void unregisterReceiver(BroadcastReceiver arg11) {
        int v3;
        int v4;
        String v9;
        int v6;
        int v7;
        HashMap v8 = this.mReceivers;
        __monitor_enter(v8);
        try {
            Object v0_1 = this.mReceivers.remove(arg11);
            if(v0_1 == null) {
                __monitor_exit(v8);
            }
            else {
                v7 = 0;
                while(true) {
                label_9:
                    if(v7 < ((ArrayList)v0_1).size()) {
                        Object v1 = ((ArrayList)v0_1).get(v7);
                        v6 = 0;
                        while(true) {
                        label_13:
                            if(v6 < ((IntentFilter)v1).countActions()) {
                                v9 = ((IntentFilter)v1).getAction(v6);
                                Object v2 = this.mActions.get(v9);
                                if(v2 != null) {
                                    v4 = 0;
                                    while(true) {
                                    label_20:
                                        if(v4 < ((ArrayList)v2).size()) {
                                            if(((ArrayList)v2).get(v4).receiver == arg11) {
                                                ((ArrayList)v2).remove(v4);
                                                v3 = v4 - 1;
                                            }
                                            else {
                                                goto label_44;
                                            }

                                            goto label_27;
                                        }
                                        else {
                                            goto label_29;
                                        }
                                    }
                                }

                                goto label_33;
                            }
                            else {
                                goto label_36;
                            }
                        }
                    }
                    else {
                        goto label_39;
                    }

                    return;
                }
            }

            return;
        }
        catch(Throwable v0) {
            goto label_42;
        }

    label_44:
        v3 = v4;
        try {
        label_27:
            v4 = v3 + 1;
            goto label_20;
        label_29:
            if(((ArrayList)v2).size() <= 0) {
                this.mActions.remove(v9);
            }

        label_33:
            ++v6;
            goto label_13;
        label_36:
            ++v7;
            goto label_9;
        label_39:
            __monitor_exit(v8);
            return;
        label_42:
            __monitor_exit(v8);
        }
        catch(Throwable v0) {
            goto label_42;
        }

        throw v0;
    }
}

