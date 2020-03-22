package android.support.v4.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.os.BuildCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    public final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
        @Deprecated public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(@NonNull String arg3, @Nullable Bundle arg4) {
            super();
            if(arg3 == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
            }

            this.mRootId = arg3;
            this.mExtras = arg4;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public String getRootId() {
            return this.mRootId;
        }
    }

    class ConnectionRecord {
        ServiceCallbacks callbacks;
        String pkg;
        BrowserRoot root;
        Bundle rootHints;
        HashMap subscriptions;

        ConnectionRecord(MediaBrowserServiceCompat arg2) {
            MediaBrowserServiceCompat.this = arg2;
            super();
            this.subscriptions = new HashMap();
        }
    }

    interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        void notifyChildrenChanged(String arg1, Bundle arg2);

        IBinder onBind(Intent arg1);

        void onCreate();

        void setSessionToken(Token arg1);
    }

    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, ServiceCompatProxy {
        Messenger mMessenger;
        Object mServiceObj;

        MediaBrowserServiceImplApi21(MediaBrowserServiceCompat arg1) {
            MediaBrowserServiceCompat.this = arg1;
            super();
        }

        public Bundle getBrowserRootHints() {
            Bundle v0 = null;
            if(this.mMessenger != null) {
                if(MediaBrowserServiceCompat.this.mCurConnection == null) {
                    throw new IllegalStateException("This should be called inside of onLoadChildren or onLoadItem methods");
                }
                else if(MediaBrowserServiceCompat.this.mCurConnection.rootHints != null) {
                    v0 = new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
                }
            }

            return v0;
        }

        public void notifyChildrenChanged(String arg3, Bundle arg4) {
            if(this.mMessenger == null) {
                MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, arg3);
            }
            else {
                MediaBrowserServiceCompat.this.mHandler.post(new Runnable(arg3, arg4) {
                    public void run() {
                        Object v1;
                        Object v0;
                        Iterator v3 = this.this$1.this$0.mConnections.keySet().iterator();
                        do {
                        label_5:
                            if(!v3.hasNext()) {
                                return;
                            }

                            v0 = this.this$1.this$0.mConnections.get(v3.next());
                            v1 = ((ConnectionRecord)v0).subscriptions.get(this.val$parentId);
                        }
                        while(v1 == null);

                        Iterator v4 = ((List)v1).iterator();
                        goto label_17;
                        return;
                        while(true) {
                        label_17:
                            if(!v4.hasNext()) {
                                goto label_5;
                            }

                            v1 = v4.next();
                            if(!MediaBrowserCompatUtils.hasDuplicatedItems(this.val$options, ((Pair)v1).second)) {
                                continue;
                            }

                            this.this$1.this$0.performLoadChildren(this.val$parentId, ((ConnectionRecord)v0), ((Pair)v1).second);
                        }
                    }
                });
            }
        }

        public IBinder onBind(Intent arg2) {
            return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, arg2);
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi21.createService(MediaBrowserServiceCompat.this, ((ServiceCompatProxy)this));
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public android.support.v4.media.MediaBrowserServiceCompatApi21$BrowserRoot onGetRoot(String arg5, int arg6, Bundle arg7) {
            Bundle v0;
            android.support.v4.media.MediaBrowserServiceCompatApi21$BrowserRoot v1 = null;
            if(arg7 == null || arg7.getInt("extra_client_version", 0) == 0) {
                v0 = ((Bundle)v1);
            }
            else {
                arg7.remove("extra_client_version");
                this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
                v0 = new Bundle();
                v0.putInt("extra_service_version", 1);
                BundleCompat.putBinder(v0, "extra_messenger", this.mMessenger.getBinder());
            }

            BrowserRoot v2 = MediaBrowserServiceCompat.this.onGetRoot(arg5, arg6, arg7);
            if(v2 != null) {
                if(v0 == null) {
                    v0 = v2.getExtras();
                }
                else if(v2.getExtras() != null) {
                    v0.putAll(v2.getExtras());
                }

                v1 = new android.support.v4.media.MediaBrowserServiceCompatApi21$BrowserRoot(v2.getRootId(), v0);
            }

            return v1;
        }

        public void onLoadChildren(String arg3, ResultWrapper arg4) {
            MediaBrowserServiceCompat.this.onLoadChildren(arg3, new Result(arg3, arg4) {
                public void detach() {
                    this.val$resultWrapper.detach();
                }

                void onResultSent(Object arg1, int arg2) {
                    this.onResultSent(((List)arg1), arg2);
                }

                void onResultSent(List arg6, int arg7) {
                    ArrayList v0_1;
                    Object v0 = null;
                    if(arg6 != null) {
                        ArrayList v1 = new ArrayList();
                        Iterator v2 = arg6.iterator();
                        while(v2.hasNext()) {
                            v0 = v2.next();
                            Parcel v3 = Parcel.obtain();
                            ((MediaItem)v0).writeToParcel(v3, 0);
                            ((List)v1).add(v3);
                        }

                        v0_1 = v1;
                    }

                    this.val$resultWrapper.sendResult(v0_1);
                }
            });
        }

        public void setSessionToken(Token arg3) {
            MediaBrowserServiceCompatApi21.setSessionToken(this.mServiceObj, arg3.getToken());
        }
    }

    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements android.support.v4.media.MediaBrowserServiceCompatApi23$ServiceCompatProxy {
        MediaBrowserServiceImplApi23(MediaBrowserServiceCompat arg1) {
            MediaBrowserServiceCompat.this = arg1;
            super(arg1);
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi23.createService(MediaBrowserServiceCompat.this, ((android.support.v4.media.MediaBrowserServiceCompatApi23$ServiceCompatProxy)this));
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public void onLoadItem(String arg3, ResultWrapper arg4) {
            MediaBrowserServiceCompat.this.onLoadItem(arg3, new Result(arg3, arg4) {
                public void detach() {
                    this.val$resultWrapper.detach();
                }

                void onResultSent(MediaItem arg3, int arg4) {
                    if(arg3 == null) {
                        this.val$resultWrapper.sendResult(null);
                    }
                    else {
                        Parcel v0 = Parcel.obtain();
                        arg3.writeToParcel(v0, 0);
                        this.val$resultWrapper.sendResult(v0);
                    }
                }

                void onResultSent(Object arg1, int arg2) {
                    this.onResultSent(((MediaItem)arg1), arg2);
                }
            });
        }
    }

    class MediaBrowserServiceImplApi24 extends MediaBrowserServiceImplApi23 implements android.support.v4.media.MediaBrowserServiceCompatApi24$ServiceCompatProxy {
        MediaBrowserServiceImplApi24(MediaBrowserServiceCompat arg1) {
            MediaBrowserServiceCompat.this = arg1;
            super(arg1);
        }

        public Bundle getBrowserRootHints() {
            Bundle v0;
            if(MediaBrowserServiceCompat.this.mCurConnection == null) {
                v0 = MediaBrowserServiceCompatApi24.getBrowserRootHints(this.mServiceObj);
            }
            else if(MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
                v0 = null;
            }
            else {
                v0 = new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
            }

            return v0;
        }

        public void notifyChildrenChanged(String arg2, Bundle arg3) {
            if(arg3 == null) {
                MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, arg2);
            }
            else {
                MediaBrowserServiceCompatApi24.notifyChildrenChanged(this.mServiceObj, arg2, arg3);
            }
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi24.createService(MediaBrowserServiceCompat.this, ((android.support.v4.media.MediaBrowserServiceCompatApi24$ServiceCompatProxy)this));
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public void onLoadChildren(String arg3, android.support.v4.media.MediaBrowserServiceCompatApi24$ResultWrapper arg4, Bundle arg5) {
            MediaBrowserServiceCompat.this.onLoadChildren(arg3, new Result(arg3, arg4) {
                public void detach() {
                    this.val$resultWrapper.detach();
                }

                void onResultSent(Object arg1, int arg2) {
                    this.onResultSent(((List)arg1), arg2);
                }

                void onResultSent(List arg6, int arg7) {
                    ArrayList v0_2;
                    List v0 = null;
                    if(arg6 != null) {
                        ArrayList v1 = new ArrayList();
                        Iterator v2 = arg6.iterator();
                        while(v2.hasNext()) {
                            Object v0_1 = v2.next();
                            Parcel v3 = Parcel.obtain();
                            ((MediaItem)v0_1).writeToParcel(v3, 0);
                            ((List)v1).add(v3);
                        }

                        v0_2 = v1;
                    }

                    this.val$resultWrapper.sendResult(((List)v0_2), arg7);
                }
            }, arg5);
        }
    }

    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        private Messenger mMessenger;

        MediaBrowserServiceImplBase(MediaBrowserServiceCompat arg1) {
            MediaBrowserServiceCompat.this = arg1;
            super();
        }

        public Bundle getBrowserRootHints() {
            if(MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren or onLoadItem methods");
            }

            Bundle v0 = MediaBrowserServiceCompat.this.mCurConnection.rootHints == null ? null : new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
            return v0;
        }

        public void notifyChildrenChanged(@NonNull String arg3, Bundle arg4) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable(arg3, arg4) {
                public void run() {
                    Object v1;
                    Object v0;
                    Iterator v3 = this.this$1.this$0.mConnections.keySet().iterator();
                    do {
                    label_5:
                        if(!v3.hasNext()) {
                            return;
                        }

                        v0 = this.this$1.this$0.mConnections.get(v3.next());
                        v1 = ((ConnectionRecord)v0).subscriptions.get(this.val$parentId);
                    }
                    while(v1 == null);

                    Iterator v4 = ((List)v1).iterator();
                    goto label_17;
                    return;
                    while(true) {
                    label_17:
                        if(!v4.hasNext()) {
                            goto label_5;
                        }

                        v1 = v4.next();
                        if(!MediaBrowserCompatUtils.hasDuplicatedItems(this.val$options, ((Pair)v1).second)) {
                            continue;
                        }

                        this.this$1.this$0.performLoadChildren(this.val$parentId, ((ConnectionRecord)v0), ((Pair)v1).second);
                    }
                }
            });
        }

        public IBinder onBind(Intent arg3) {
            IBinder v0 = "android.media.browse.MediaBrowserService".equals(arg3.getAction()) ? this.mMessenger.getBinder() : null;
            return v0;
        }

        public void onCreate() {
            this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
        }

        public void setSessionToken(Token arg3) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable(arg3) {
                public void run() {
                    Iterator v1 = this.this$1.this$0.mConnections.values().iterator();
                    while(v1.hasNext()) {
                        Object v0 = v1.next();
                        try {
                            ((ConnectionRecord)v0).callbacks.onConnect(((ConnectionRecord)v0).root.getRootId(), this.val$token, ((ConnectionRecord)v0).root.getExtras());
                        }
                        catch(RemoteException v2) {
                            Log.w("MBServiceCompat", "Connection for " + ((ConnectionRecord)v0).pkg + " is no longer valid.");
                            v1.remove();
                        }
                    }
                }
            });
        }
    }

    public class Result {
        private Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendResultCalled;

        Result(Object arg1) {
            super();
            this.mDebug = arg1;
        }

        public void detach() {
            if(this.mDetachCalled) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
            }

            if(this.mSendResultCalled) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
            }

            this.mDetachCalled = true;
        }

        boolean isDone() {
            boolean v0 = (this.mDetachCalled) || (this.mSendResultCalled) ? true : false;
            return v0;
        }

        void onResultSent(Object arg1, int arg2) {
        }

        public void sendResult(Object arg4) {
            if(this.mSendResultCalled) {
                throw new IllegalStateException("sendResult() called twice for: " + this.mDebug);
            }

            this.mSendResultCalled = true;
            this.onResultSent(arg4, this.mFlags);
        }

        void setFlags(int arg1) {
            this.mFlags = arg1;
        }
    }

    class ServiceBinderImpl {
        ServiceBinderImpl(MediaBrowserServiceCompat arg1) {
            MediaBrowserServiceCompat.this = arg1;
            super();
        }

        public void addSubscription(String arg8, IBinder arg9, Bundle arg10, ServiceCallbacks arg11) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(arg11, arg8, arg9, arg10) {
                public void run() {
                    Object v0 = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
                    if(v0 == null) {
                        Log.w("MBServiceCompat", "addSubscription for callback that isn\'t registered id=" + this.val$id);
                    }
                    else {
                        this.this$1.this$0.addSubscription(this.val$id, ((ConnectionRecord)v0), this.val$token, this.val$options);
                    }
                }
            });
        }

        public void connect(String arg8, int arg9, Bundle arg10, ServiceCallbacks arg11) {
            if(!MediaBrowserServiceCompat.this.isValidPackage(arg8, arg9)) {
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + arg9 + " package=" + arg8);
            }

            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(arg11, arg8, arg10, arg9) {
                public void run() {
                    IBinder v0 = this.val$callbacks.asBinder();
                    this.this$1.this$0.mConnections.remove(v0);
                    ConnectionRecord v1 = new ConnectionRecord(this.this$1.this$0);
                    v1.pkg = this.val$pkg;
                    v1.rootHints = this.val$rootHints;
                    v1.callbacks = this.val$callbacks;
                    v1.root = this.this$1.this$0.onGetRoot(this.val$pkg, this.val$uid, this.val$rootHints);
                    if(v1.root == null) {
                        Log.i("MBServiceCompat", "No root for client " + this.val$pkg + " from service " + this.getClass().getName());
                        try {
                            this.val$callbacks.onConnectFailed();
                        }
                        catch(RemoteException v0_1) {
                            Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.val$pkg);
                        }

                        return;
                    }

                    try {
                        this.this$1.this$0.mConnections.put(v0, v1);
                        if(this.this$1.this$0.mSession == null) {
                            return;
                        }

                        this.val$callbacks.onConnect(v1.root.getRootId(), this.this$1.this$0.mSession, v1.root.getExtras());
                    }
                    catch(RemoteException v1_1) {
                        Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + this.val$pkg);
                        this.this$1.this$0.mConnections.remove(v0);
                    }
                }
            });
        }

        public void disconnect(ServiceCallbacks arg3) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(arg3) {
                public void run() {
                    this.this$1.this$0.mConnections.remove(this.val$callbacks.asBinder());
                }
            });
        }

        public void getMediaItem(String arg3, ResultReceiver arg4, ServiceCallbacks arg5) {
            if(!TextUtils.isEmpty(((CharSequence)arg3)) && arg4 != null) {
                MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(arg5, arg3, arg4) {
                    public void run() {
                        Object v0 = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
                        if(v0 == null) {
                            Log.w("MBServiceCompat", "getMediaItem for callback that isn\'t registered id=" + this.val$mediaId);
                        }
                        else {
                            this.this$1.this$0.performLoadItem(this.val$mediaId, ((ConnectionRecord)v0), this.val$receiver);
                        }
                    }
                });
            }
        }

        public void registerCallbacks(ServiceCallbacks arg3, Bundle arg4) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(arg3, arg4) {
                public void run() {
                    IBinder v0 = this.val$callbacks.asBinder();
                    this.this$1.this$0.mConnections.remove(v0);
                    ConnectionRecord v1 = new ConnectionRecord(this.this$1.this$0);
                    v1.callbacks = this.val$callbacks;
                    v1.rootHints = this.val$rootHints;
                    this.this$1.this$0.mConnections.put(v0, v1);
                }
            });
        }

        public void removeSubscription(String arg3, IBinder arg4, ServiceCallbacks arg5) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(arg5, arg3, arg4) {
                public void run() {
                    Object v0 = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
                    if(v0 == null) {
                        Log.w("MBServiceCompat", "removeSubscription for callback that isn\'t registered id=" + this.val$id);
                    }
                    else if(!this.this$1.this$0.removeSubscription(this.val$id, ((ConnectionRecord)v0), this.val$token)) {
                        Log.w("MBServiceCompat", "removeSubscription called for " + this.val$id + " which is not subscribed");
                    }
                }
            });
        }

        public void search(String arg8, Bundle arg9, ResultReceiver arg10, ServiceCallbacks arg11) {
            if(!TextUtils.isEmpty(((CharSequence)arg8)) && arg10 != null) {
                MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(arg11, arg8, arg9, arg10) {
                    public void run() {
                        Object v0 = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
                        if(v0 == null) {
                            Log.w("MBServiceCompat", "search for callback that isn\'t registered query=" + this.val$query);
                        }
                        else {
                            this.this$1.this$0.performSearch(this.val$query, this.val$extras, ((ConnectionRecord)v0), this.val$receiver);
                        }
                    }
                });
            }
        }

        public void unregisterCallbacks(ServiceCallbacks arg3) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(arg3) {
                public void run() {
                    this.this$1.this$0.mConnections.remove(this.val$callbacks.asBinder());
                }
            });
        }
    }

    interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String arg1, Token arg2, Bundle arg3);

        void onConnectFailed();

        void onLoadChildren(String arg1, List arg2, Bundle arg3);
    }

    class ServiceCallbacksCompat implements ServiceCallbacks {
        final Messenger mCallbacks;

        ServiceCallbacksCompat(MediaBrowserServiceCompat arg1, Messenger arg2) {
            MediaBrowserServiceCompat.this = arg1;
            super();
            this.mCallbacks = arg2;
        }

        public IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        public void onConnect(String arg4, Token arg5, Bundle arg6) {
            if(arg6 == null) {
                arg6 = new Bundle();
            }

            arg6.putInt("extra_service_version", 1);
            Bundle v0 = new Bundle();
            v0.putString("data_media_item_id", arg4);
            v0.putParcelable("data_media_session_token", ((Parcelable)arg5));
            v0.putBundle("data_root_hints", arg6);
            this.sendRequest(1, v0);
        }

        public void onConnectFailed() {
            this.sendRequest(2, null);
        }

        public void onLoadChildren(String arg4, List arg5, Bundle arg6) {
            ArrayList v5;
            Bundle v1 = new Bundle();
            v1.putString("data_media_item_id", arg4);
            v1.putBundle("data_options", arg6);
            if(arg5 != null) {
                String v2 = "data_media_item_list";
                if(!(arg5 instanceof ArrayList)) {
                    v5 = new ArrayList(((Collection)arg5));
                }

                v1.putParcelableArrayList(v2, v5);
            }

            this.sendRequest(3, v1);
        }

        private void sendRequest(int arg3, Bundle arg4) {
            Message v0 = Message.obtain();
            v0.what = arg3;
            v0.arg1 = 1;
            v0.setData(arg4);
            this.mCallbacks.send(v0);
        }
    }

    final class ServiceHandler extends Handler {
        private final ServiceBinderImpl mServiceBinderImpl;

        ServiceHandler(MediaBrowserServiceCompat arg3) {
            MediaBrowserServiceCompat.this = arg3;
            super();
            this.mServiceBinderImpl = new ServiceBinderImpl(MediaBrowserServiceCompat.this);
        }

        public void handleMessage(Message arg8) {
            Bundle v0 = arg8.getData();
            switch(arg8.what) {
                case 1: {
                    this.mServiceBinderImpl.connect(v0.getString("data_package_name"), v0.getInt("data_calling_uid"), v0.getBundle("data_root_hints"), new ServiceCallbacksCompat(MediaBrowserServiceCompat.this, arg8.replyTo));
                    break;
                }
                case 2: {
                    this.mServiceBinderImpl.disconnect(new ServiceCallbacksCompat(MediaBrowserServiceCompat.this, arg8.replyTo));
                    break;
                }
                case 3: {
                    this.mServiceBinderImpl.addSubscription(v0.getString("data_media_item_id"), BundleCompat.getBinder(v0, "data_callback_token"), v0.getBundle("data_options"), new ServiceCallbacksCompat(MediaBrowserServiceCompat.this, arg8.replyTo));
                    break;
                }
                case 4: {
                    this.mServiceBinderImpl.removeSubscription(v0.getString("data_media_item_id"), BundleCompat.getBinder(v0, "data_callback_token"), new ServiceCallbacksCompat(MediaBrowserServiceCompat.this, arg8.replyTo));
                    break;
                }
                case 5: {
                    this.mServiceBinderImpl.getMediaItem(v0.getString("data_media_item_id"), v0.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(MediaBrowserServiceCompat.this, arg8.replyTo));
                    break;
                }
                case 6: {
                    this.mServiceBinderImpl.registerCallbacks(new ServiceCallbacksCompat(MediaBrowserServiceCompat.this, arg8.replyTo), v0.getBundle("data_root_hints"));
                    break;
                }
                case 7: {
                    this.mServiceBinderImpl.unregisterCallbacks(new ServiceCallbacksCompat(MediaBrowserServiceCompat.this, arg8.replyTo));
                    break;
                }
                case 8: {
                    this.mServiceBinderImpl.search(v0.getString("data_search_query"), v0.getBundle("data_search_extras"), v0.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(MediaBrowserServiceCompat.this, arg8.replyTo));
                    break;
                }
                default: {
                    Log.w("MBServiceCompat", "Unhandled message: " + arg8 + "\n  Service version: " + 1 + "\n  Client version: " + arg8.arg1);
                    break;
                }
            }
        }

        public void postOrRun(Runnable arg3) {
            if(Thread.currentThread() == this.getLooper().getThread()) {
                arg3.run();
            }
            else {
                this.post(arg3);
            }
        }

        public boolean sendMessageAtTime(Message arg5, long arg6) {
            Bundle v0 = arg5.getData();
            v0.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            v0.putInt("data_calling_uid", Binder.getCallingUid());
            return super.sendMessageAtTime(arg5, arg6);
        }
    }

    static final boolean DEBUG = false;
    @RestrictTo(value={Scope.LIBRARY_GROUP}) public static final String KEY_MEDIA_ITEM = "media_item";
    @RestrictTo(value={Scope.LIBRARY_GROUP}) public static final String KEY_SEARCH_RESULTS = "search_results";
    static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    static final int RESULT_OK = 0;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    static final String TAG = "MBServiceCompat";
    final ArrayMap mConnections;
    ConnectionRecord mCurConnection;
    final ServiceHandler mHandler;
    private MediaBrowserServiceImpl mImpl;
    Token mSession;

    static {
        MediaBrowserServiceCompat.DEBUG = Log.isLoggable("MBServiceCompat", 3);
    }

    public MediaBrowserServiceCompat() {
        super();
        this.mConnections = new ArrayMap();
        this.mHandler = new ServiceHandler(this);
    }

    void addSubscription(String arg5, ConnectionRecord arg6, IBinder arg7, Bundle arg8) {
        ArrayList v1;
        Object v0 = arg6.subscriptions.get(arg5);
        if(v0 == null) {
            v1 = new ArrayList();
        }
        else {
            Object v1_1 = v0;
        }

        Iterator v2 = ((List)v1).iterator();
        do {
            if(v2.hasNext()) {
                v0 = v2.next();
                if(arg7 != ((Pair)v0).first) {
                    continue;
                }

                if(!MediaBrowserCompatUtils.areSameOptions(arg8, ((Pair)v0).second)) {
                    continue;
                }
            }
            else {
                break;
            }

            return;
        }
        while(true);

        ((List)v1).add(new Pair(arg7, arg8));
        arg6.subscriptions.put(arg5, v1);
        this.performLoadChildren(arg5, arg6, arg8);
    }

    List applyOptions(List arg5, Bundle arg6) {
        int v3 = -1;
        if(arg5 == null) {
            arg5 = null;
        }
        else {
            int v1 = arg6.getInt("android.media.browse.extra.PAGE", v3);
            int v2 = arg6.getInt("android.media.browse.extra.PAGE_SIZE", v3);
            if(v1 == v3 && v2 == v3) {
                return arg5;
            }

            v3 = v2 * v1;
            int v0 = v3 + v2;
            if(v1 >= 0 && v2 >= 1 && v3 < arg5.size()) {
                if(v0 > arg5.size()) {
                    v0 = arg5.size();
                }

                return arg5.subList(v3, v0);
            }

            arg5 = Collections.EMPTY_LIST;
        }

        return arg5;
    }

    public void dump(FileDescriptor arg1, PrintWriter arg2, String[] arg3) {
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    @Nullable public Token getSessionToken() {
        return this.mSession;
    }

    boolean isValidPackage(String arg6, int arg7) {
        boolean v0 = false;
        if(arg6 != null) {
            String[] v2 = this.getPackageManager().getPackagesForUid(arg7);
            int v3 = v2.length;
            int v1 = 0;
            while(v1 < v3) {
                if(v2[v1].equals(arg6)) {
                    v0 = true;
                }
                else {
                    ++v1;
                    continue;
                }

                return v0;
            }
        }

        return v0;
    }

    public void notifyChildrenChanged(@NonNull String arg3) {
        if(arg3 == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }

        this.mImpl.notifyChildrenChanged(arg3, null);
    }

    public void notifyChildrenChanged(@NonNull String arg3, @NonNull Bundle arg4) {
        if(arg3 == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }

        if(arg4 == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }

        this.mImpl.notifyChildrenChanged(arg3, arg4);
    }

    public IBinder onBind(Intent arg2) {
        return this.mImpl.onBind(arg2);
    }

    public void onCreate() {
        super.onCreate();
        if(Build$VERSION.SDK_INT >= 26 || (BuildCompat.isAtLeastO())) {
            this.mImpl = new MediaBrowserServiceImplApi24(this);
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaBrowserServiceImplApi23(this);
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaBrowserServiceImplApi21(this);
        }
        else {
            this.mImpl = new MediaBrowserServiceImplBase(this);
        }

        this.mImpl.onCreate();
    }

    @Nullable public abstract BrowserRoot onGetRoot(@NonNull String arg1, int arg2, @Nullable Bundle arg3);

    public abstract void onLoadChildren(@NonNull String arg1, @NonNull Result arg2);

    public void onLoadChildren(@NonNull String arg2, @NonNull Result arg3, @NonNull Bundle arg4) {
        arg3.setFlags(1);
        this.onLoadChildren(arg2, arg3);
    }

    public void onLoadItem(String arg2, @NonNull Result arg3) {
        arg3.setFlags(2);
        arg3.sendResult(null);
    }

    public void onSearch(@NonNull String arg2, Bundle arg3, @NonNull Result arg4) {
        arg4.setFlags(4);
        arg4.sendResult(null);
    }

    void performLoadChildren(String arg7, ConnectionRecord arg8, Bundle arg9) {
        android.support.v4.media.MediaBrowserServiceCompat$1 v0 = new Result(arg7, arg8, arg7, arg9) {
            void onResultSent(Object arg1, int arg2) {
                this.onResultSent(((List)arg1), arg2);
            }

            void onResultSent(List arg4, int arg5) {
                if(MediaBrowserServiceCompat.this.mConnections.get(this.val$connection.callbacks.asBinder()) != this.val$connection) {
                    if(!MediaBrowserServiceCompat.DEBUG) {
                        return;
                    }

                    Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.val$connection.pkg + " id=" + this.val$parentId);
                    return;
                }

                if((arg5 & 1) != 0) {
                    arg4 = MediaBrowserServiceCompat.this.applyOptions(arg4, this.val$options);
                }

                try {
                    this.val$connection.callbacks.onLoadChildren(this.val$parentId, arg4, this.val$options);
                }
                catch(RemoteException v0) {
                    Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.val$parentId + " package=" + this.val$connection.pkg);
                }
            }
        };
        this.mCurConnection = arg8;
        if(arg9 == null) {
            this.onLoadChildren(arg7, ((Result)v0));
        }
        else {
            this.onLoadChildren(arg7, ((Result)v0), arg9);
        }

        this.mCurConnection = null;
        if(!((Result)v0).isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + arg8.pkg + " id=" + arg7);
        }
    }

    void performLoadItem(String arg4, ConnectionRecord arg5, ResultReceiver arg6) {
        android.support.v4.media.MediaBrowserServiceCompat$2 v0 = new Result(arg4, arg6) {
            void onResultSent(MediaItem arg4, int arg5) {
                if((arg5 & 2) != 0) {
                    this.val$receiver.send(-1, null);
                }
                else {
                    Bundle v0 = new Bundle();
                    v0.putParcelable("media_item", ((Parcelable)arg4));
                    this.val$receiver.send(0, v0);
                }
            }

            void onResultSent(Object arg1, int arg2) {
                this.onResultSent(((MediaItem)arg1), arg2);
            }
        };
        this.mCurConnection = arg5;
        this.onLoadItem(arg4, ((Result)v0));
        this.mCurConnection = null;
        if(!((Result)v0).isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + arg4);
        }
    }

    void performSearch(String arg4, Bundle arg5, ConnectionRecord arg6, ResultReceiver arg7) {
        android.support.v4.media.MediaBrowserServiceCompat$3 v0 = new Result(arg4, arg7) {
            void onResultSent(Object arg1, int arg2) {
                this.onResultSent(((List)arg1), arg2);
            }

            void onResultSent(List arg5, int arg6) {
                if((arg6 & 4) != 0 || arg5 == null) {
                    this.val$receiver.send(-1, null);
                }
                else {
                    Bundle v1 = new Bundle();
                    v1.putParcelableArray("search_results", arg5.toArray(new MediaItem[0]));
                    this.val$receiver.send(0, v1);
                }
            }
        };
        this.mCurConnection = arg6;
        this.onSearch(arg4, arg5, ((Result)v0));
        this.mCurConnection = null;
        if(!((Result)v0).isDone()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + arg4);
        }
    }

    boolean removeSubscription(String arg6, ConnectionRecord arg7, IBinder arg8) {
        boolean v0;
        if(arg8 != null) {
            Object v0_1 = arg7.subscriptions.get(arg6);
            if(v0_1 != null) {
                Iterator v4 = ((List)v0_1).iterator();
                boolean v3;
                for(v3 = false; v4.hasNext(); v3 = true) {
                    if(arg8 != v4.next().first) {
                        continue;
                    }

                    v4.remove();
                }

                if(((List)v0_1).size() == 0) {
                    arg7.subscriptions.remove(arg6);
                }
            }
            else {
                v3 = false;
            }

            v0 = v3;
        }
        else if(arg7.subscriptions.remove(arg6) != null) {
            v0 = true;
        }
        else {
            v0 = false;
        }

        return v0;
    }

    public void setSessionToken(Token arg3) {
        if(arg3 == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        }

        if(this.mSession != null) {
            throw new IllegalStateException("The session token has already been set.");
        }

        this.mSession = arg3;
        this.mImpl.setSessionToken(arg3);
    }
}

