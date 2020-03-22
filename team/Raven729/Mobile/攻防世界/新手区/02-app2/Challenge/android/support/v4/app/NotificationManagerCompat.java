package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler$Callback;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings$Secure;
import android.support.v4.os.BuildCompat;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;

public final class NotificationManagerCompat {
    class CancelTask implements Task {
        final boolean all;
        final int id;
        final String packageName;
        final String tag;

        public CancelTask(String arg2, int arg3, String arg4) {
            super();
            this.packageName = arg2;
            this.id = arg3;
            this.tag = arg4;
            this.all = false;
        }

        public CancelTask(String arg2) {
            super();
            this.packageName = arg2;
            this.id = 0;
            this.tag = null;
            this.all = true;
        }

        public void send(INotificationSideChannel arg4) {
            if(this.all) {
                arg4.cancelAll(this.packageName);
            }
            else {
                arg4.cancel(this.packageName, this.id, this.tag);
            }
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder("CancelTask[");
            v0.append("packageName:").append(this.packageName);
            v0.append(", id:").append(this.id);
            v0.append(", tag:").append(this.tag);
            v0.append(", all:").append(this.all);
            v0.append("]");
            return v0.toString();
        }
    }

    interface Impl {
        boolean areNotificationsEnabled(Context arg1, NotificationManager arg2);

        void cancelNotification(NotificationManager arg1, String arg2, int arg3);

        int getImportance(NotificationManager arg1);

        int getSideChannelBindFlags();

        void postNotification(NotificationManager arg1, String arg2, int arg3, Notification arg4);
    }

    class ImplApi24 extends ImplKitKat {
        ImplApi24() {
            super();
        }

        public boolean areNotificationsEnabled(Context arg2, NotificationManager arg3) {
            return NotificationManagerCompatApi24.areNotificationsEnabled(arg3);
        }

        public int getImportance(NotificationManager arg2) {
            return NotificationManagerCompatApi24.getImportance(arg2);
        }
    }

    class ImplBase implements Impl {
        ImplBase() {
            super();
        }

        public boolean areNotificationsEnabled(Context arg2, NotificationManager arg3) {
            return 1;
        }

        public void cancelNotification(NotificationManager arg1, String arg2, int arg3) {
            arg1.cancel(arg2, arg3);
        }

        public int getImportance(NotificationManager arg2) {
            return -1000;
        }

        public int getSideChannelBindFlags() {
            return 1;
        }

        public void postNotification(NotificationManager arg1, String arg2, int arg3, Notification arg4) {
            arg1.notify(arg2, arg3, arg4);
        }
    }

    class ImplIceCreamSandwich extends ImplBase {
        ImplIceCreamSandwich() {
            super();
        }

        public int getSideChannelBindFlags() {
            return 33;
        }
    }

    class ImplKitKat extends ImplIceCreamSandwich {
        ImplKitKat() {
            super();
        }

        public boolean areNotificationsEnabled(Context arg2, NotificationManager arg3) {
            return NotificationManagerCompatKitKat.areNotificationsEnabled(arg2);
        }
    }

    class NotifyTask implements Task {
        final int id;
        final Notification notif;
        final String packageName;
        final String tag;

        public NotifyTask(String arg1, int arg2, String arg3, Notification arg4) {
            super();
            this.packageName = arg1;
            this.id = arg2;
            this.tag = arg3;
            this.notif = arg4;
        }

        public void send(INotificationSideChannel arg5) {
            arg5.notify(this.packageName, this.id, this.tag, this.notif);
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder("NotifyTask[");
            v0.append("packageName:").append(this.packageName);
            v0.append(", id:").append(this.id);
            v0.append(", tag:").append(this.tag);
            v0.append("]");
            return v0.toString();
        }
    }

    class ServiceConnectedEvent {
        final ComponentName componentName;
        final IBinder iBinder;

        public ServiceConnectedEvent(ComponentName arg1, IBinder arg2) {
            super();
            this.componentName = arg1;
            this.iBinder = arg2;
        }
    }

    class SideChannelManager implements ServiceConnection, Handler$Callback {
        class ListenerRecord {
            public boolean bound;
            public final ComponentName componentName;
            public int retryCount;
            public INotificationSideChannel service;
            public LinkedList taskQueue;

            public ListenerRecord(ComponentName arg3) {
                super();
                this.bound = false;
                this.taskQueue = new LinkedList();
                this.retryCount = 0;
                this.componentName = arg3;
            }
        }

        private static final String KEY_BINDER = "binder";
        private static final int MSG_QUEUE_TASK = 0;
        private static final int MSG_RETRY_LISTENER_QUEUE = 3;
        private static final int MSG_SERVICE_CONNECTED = 1;
        private static final int MSG_SERVICE_DISCONNECTED = 2;
        private Set mCachedEnabledPackages;
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;
        private final Map mRecordMap;

        public SideChannelManager(Context arg3) {
            super();
            this.mRecordMap = new HashMap();
            this.mCachedEnabledPackages = new HashSet();
            this.mContext = arg3;
            this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper(), ((Handler$Callback)this));
        }

        private boolean ensureServiceBound(ListenerRecord arg4) {
            boolean v0;
            if(arg4.bound) {
                v0 = true;
            }
            else {
                arg4.bound = this.mContext.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(arg4.componentName), ((ServiceConnection)this), NotificationManagerCompat.SIDE_CHANNEL_BIND_FLAGS);
                if(arg4.bound) {
                    arg4.retryCount = 0;
                }
                else {
                    Log.w("NotifManCompat", "Unable to bind to listener " + arg4.componentName);
                    this.mContext.unbindService(((ServiceConnection)this));
                }

                v0 = arg4.bound;
            }

            return v0;
        }

        private void ensureServiceUnbound(ListenerRecord arg2) {
            if(arg2.bound) {
                this.mContext.unbindService(((ServiceConnection)this));
                arg2.bound = false;
            }

            arg2.service = null;
        }

        public boolean handleMessage(Message arg4) {
            boolean v0;
            switch(arg4.what) {
                case 0: {
                    this.handleQueueTask(arg4.obj);
                    v0 = true;
                    break;
                }
                case 1: {
                    this.handleServiceConnected(arg4.obj.componentName, arg4.obj.iBinder);
                    v0 = true;
                    break;
                }
                case 2: {
                    this.handleServiceDisconnected(arg4.obj);
                    v0 = true;
                    break;
                }
                case 3: {
                    this.handleRetryListenerQueue(arg4.obj);
                    v0 = true;
                    break;
                }
                default: {
                    v0 = false;
                    break;
                }
            }

            return v0;
        }

        private void handleQueueTask(Task arg4) {
            this.updateListenerMap();
            Iterator v1 = this.mRecordMap.values().iterator();
            while(v1.hasNext()) {
                Object v0 = v1.next();
                ((ListenerRecord)v0).taskQueue.add(arg4);
                this.processListenerQueue(((ListenerRecord)v0));
            }
        }

        private void handleRetryListenerQueue(ComponentName arg2) {
            Object v0 = this.mRecordMap.get(arg2);
            if(v0 != null) {
                this.processListenerQueue(((ListenerRecord)v0));
            }
        }

        private void handleServiceConnected(ComponentName arg3, IBinder arg4) {
            Object v0 = this.mRecordMap.get(arg3);
            if(v0 != null) {
                ((ListenerRecord)v0).service = Stub.asInterface(arg4);
                ((ListenerRecord)v0).retryCount = 0;
                this.processListenerQueue(((ListenerRecord)v0));
            }
        }

        private void handleServiceDisconnected(ComponentName arg2) {
            Object v0 = this.mRecordMap.get(arg2);
            if(v0 != null) {
                this.ensureServiceUnbound(((ListenerRecord)v0));
            }
        }

        public void onServiceConnected(ComponentName arg4, IBinder arg5) {
            if(Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + arg4);
            }

            this.mHandler.obtainMessage(1, new ServiceConnectedEvent(arg4, arg5)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName arg4) {
            if(Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + arg4);
            }

            this.mHandler.obtainMessage(2, arg4).sendToTarget();
        }

        private void processListenerQueue(ListenerRecord arg6) {
            int v4 = 3;
            if(Log.isLoggable("NotifManCompat", v4)) {
                Log.d("NotifManCompat", "Processing component " + arg6.componentName + ", " + arg6.taskQueue.size() + " queued tasks");
            }

            if(!arg6.taskQueue.isEmpty()) {
                if((this.ensureServiceBound(arg6)) && arg6.service != null) {
                    while(true) {
                        Object v0 = arg6.taskQueue.peek();
                        if(v0 == null) {
                            break;
                        }

                        try {
                            if(Log.isLoggable("NotifManCompat", 3)) {
                                Log.d("NotifManCompat", "Sending task " + v0);
                            }

                            ((Task)v0).send(arg6.service);
                            arg6.taskQueue.remove();
                            continue;
                        }
                        catch(RemoteException v0_1) {
                            Log.w("NotifManCompat", "RemoteException communicating with " + arg6.componentName, ((Throwable)v0_1));
                            break;
                        }
                        catch(DeadObjectException v0_2) {
                            if(!Log.isLoggable("NotifManCompat", v4)) {
                                break;
                            }

                            Log.d("NotifManCompat", "Remote service has died: " + arg6.componentName);
                            break;
                        }
                    }

                    if(arg6.taskQueue.isEmpty()) {
                        return;
                    }

                    this.scheduleListenerRetry(arg6);
                    return;
                }

                this.scheduleListenerRetry(arg6);
            }
        }

        public void queueTask(Task arg3) {
            this.mHandler.obtainMessage(0, arg3).sendToTarget();
        }

        private void scheduleListenerRetry(ListenerRecord arg7) {
            int v4 = 3;
            if(!this.mHandler.hasMessages(v4, arg7.componentName)) {
                ++arg7.retryCount;
                if(arg7.retryCount > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + arg7.taskQueue.size() + " tasks to " + arg7.componentName + " after " + arg7.retryCount + " retries");
                    arg7.taskQueue.clear();
                }
                else {
                    int v0 = (1 << arg7.retryCount - 1) * 1000;
                    if(Log.isLoggable("NotifManCompat", v4)) {
                        Log.d("NotifManCompat", "Scheduling retry for " + v0 + " ms");
                    }

                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(v4, arg7.componentName), ((long)v0));
                }
            }
        }

        private void updateListenerMap() {
            Object v0_1;
            int v7 = 3;
            Set v1 = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if(!v1.equals(this.mCachedEnabledPackages)) {
                this.mCachedEnabledPackages = v1;
                List v0 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
                HashSet v2 = new HashSet();
                Iterator v3 = v0.iterator();
                while(v3.hasNext()) {
                    v0_1 = v3.next();
                    if(!v1.contains(((ResolveInfo)v0_1).serviceInfo.packageName)) {
                        continue;
                    }

                    ComponentName v4 = new ComponentName(((ResolveInfo)v0_1).serviceInfo.packageName, ((ResolveInfo)v0_1).serviceInfo.name);
                    if(((ResolveInfo)v0_1).serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + v4 + ", not adding listener record.");
                    }
                    else {
                        ((Set)v2).add(v4);
                    }
                }

                Iterator v1_1 = ((Set)v2).iterator();
                while(v1_1.hasNext()) {
                    v0_1 = v1_1.next();
                    if(this.mRecordMap.containsKey(v0_1)) {
                        continue;
                    }

                    if(Log.isLoggable("NotifManCompat", v7)) {
                        Log.d("NotifManCompat", "Adding listener record for " + v0_1);
                    }

                    this.mRecordMap.put(v0_1, new ListenerRecord(((ComponentName)v0_1)));
                }

                v1_1 = this.mRecordMap.entrySet().iterator();
                while(v1_1.hasNext()) {
                    v0_1 = v1_1.next();
                    if(((Set)v2).contains(((Map$Entry)v0_1).getKey())) {
                        continue;
                    }

                    if(Log.isLoggable("NotifManCompat", v7)) {
                        Log.d("NotifManCompat", "Removing listener record for " + ((Map$Entry)v0_1).getKey());
                    }

                    this.ensureServiceUnbound(((Map$Entry)v0_1).getValue());
                    v1_1.remove();
                }
            }
        }
    }

    interface Task {
        void send(INotificationSideChannel arg1);
    }

    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    private static final Impl IMPL = null;
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    static final int SIDE_CHANNEL_BIND_FLAGS = 0;
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";
    private final Context mContext;
    private final NotificationManager mNotificationManager;
    private static Set sEnabledNotificationListenerPackages;
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock;
    private static final Object sLock;
    private static SideChannelManager sSideChannelManager;

    static {
        NotificationManagerCompat.sEnabledNotificationListenersLock = new Object();
        NotificationManagerCompat.sEnabledNotificationListenerPackages = new HashSet();
        NotificationManagerCompat.sLock = new Object();
        if(BuildCompat.isAtLeastN()) {
            NotificationManagerCompat.IMPL = new ImplApi24();
        }
        else if(Build$VERSION.SDK_INT >= 19) {
            NotificationManagerCompat.IMPL = new ImplKitKat();
        }
        else if(Build$VERSION.SDK_INT >= 14) {
            NotificationManagerCompat.IMPL = new ImplIceCreamSandwich();
        }
        else {
            NotificationManagerCompat.IMPL = new ImplBase();
        }

        NotificationManagerCompat.SIDE_CHANNEL_BIND_FLAGS = NotificationManagerCompat.IMPL.getSideChannelBindFlags();
    }

    private NotificationManagerCompat(Context arg3) {
        super();
        this.mContext = arg3;
        this.mNotificationManager = this.mContext.getSystemService("notification");
    }

    public boolean areNotificationsEnabled() {
        return NotificationManagerCompat.IMPL.areNotificationsEnabled(this.mContext, this.mNotificationManager);
    }

    public void cancel(int arg2) {
        this.cancel(null, arg2);
    }

    public void cancel(String arg3, int arg4) {
        NotificationManagerCompat.IMPL.cancelNotification(this.mNotificationManager, arg3, arg4);
        if(Build$VERSION.SDK_INT <= 19) {
            this.pushSideChannelQueue(new CancelTask(this.mContext.getPackageName(), arg4, arg3));
        }
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
        if(Build$VERSION.SDK_INT <= 19) {
            this.pushSideChannelQueue(new CancelTask(this.mContext.getPackageName()));
        }
    }

    public static NotificationManagerCompat from(Context arg1) {
        return new NotificationManagerCompat(arg1);
    }

    public static Set getEnabledListenerPackages(Context arg7) {
        String v1 = Settings$Secure.getString(arg7.getContentResolver(), "enabled_notification_listeners");
        Object v2 = NotificationManagerCompat.sEnabledNotificationListenersLock;
        __monitor_enter(v2);
        if(v1 != null) {
            try {
                if(!v1.equals(NotificationManagerCompat.sEnabledNotificationListeners)) {
                    String[] v3 = v1.split(":");
                    HashSet v4 = new HashSet(v3.length);
                    int v5 = v3.length;
                    int v0_1;
                    for(v0_1 = 0; v0_1 < v5; ++v0_1) {
                        ComponentName v6 = ComponentName.unflattenFromString(v3[v0_1]);
                        if(v6 != null) {
                            ((Set)v4).add(v6.getPackageName());
                        }
                    }

                    NotificationManagerCompat.sEnabledNotificationListenerPackages = ((Set)v4);
                    NotificationManagerCompat.sEnabledNotificationListeners = v1;
                }

            label_26:
                __monitor_exit(v2);
                return NotificationManagerCompat.sEnabledNotificationListenerPackages;
            label_30:
                __monitor_exit(v2);
                goto label_31;
            }
            catch(Throwable v0) {
                goto label_30;
            }
        }

        goto label_26;
    label_31:
        throw v0;
    }

    public int getImportance() {
        return NotificationManagerCompat.IMPL.getImportance(this.mNotificationManager);
    }

    public void notify(int arg2, Notification arg3) {
        this.notify(null, arg2, arg3);
    }

    public void notify(String arg3, int arg4, Notification arg5) {
        if(NotificationManagerCompat.useSideChannelForNotification(arg5)) {
            this.pushSideChannelQueue(new NotifyTask(this.mContext.getPackageName(), arg4, arg3, arg5));
            NotificationManagerCompat.IMPL.cancelNotification(this.mNotificationManager, arg3, arg4);
        }
        else {
            NotificationManagerCompat.IMPL.postNotification(this.mNotificationManager, arg3, arg4, arg5);
        }
    }

    private void pushSideChannelQueue(Task arg4) {
        Object v1 = NotificationManagerCompat.sLock;
        __monitor_enter(v1);
        try {
            if(NotificationManagerCompat.sSideChannelManager == null) {
                NotificationManagerCompat.sSideChannelManager = new SideChannelManager(this.mContext.getApplicationContext());
            }

            NotificationManagerCompat.sSideChannelManager.queueTask(arg4);
            __monitor_exit(v1);
            return;
        label_14:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_14;
        }

        throw v0;
    }

    private static boolean useSideChannelForNotification(Notification arg2) {
        Bundle v0 = NotificationCompat.getExtras(arg2);
        boolean v0_1 = v0 == null || !v0.getBoolean("android.support.useSideChannel") ? false : true;
        return v0_1;
    }
}

