package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.BuildCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;

public final class MediaBrowserCompat {
    class CallbackHandler extends Handler {
        private final WeakReference mCallbackImplRef;
        private WeakReference mCallbacksMessengerRef;

        CallbackHandler(MediaBrowserServiceCallbackImpl arg2) {
            super();
            this.mCallbackImplRef = new WeakReference(arg2);
        }

        public void handleMessage(Message arg7) {
            if(this.mCallbacksMessengerRef != null && this.mCallbacksMessengerRef.get() != null && this.mCallbackImplRef.get() != null) {
                Bundle v3 = arg7.getData();
                v3.setClassLoader(MediaSessionCompat.class.getClassLoader());
                switch(arg7.what) {
                    case 1: {
                        goto label_32;
                    }
                    case 2: {
                        goto label_44;
                    }
                    case 3: {
                        goto label_50;
                    }
                }

                Log.w("MediaBrowserCompat", "Unhandled message: " + arg7 + "\n  Client version: " + 1 + "\n  Service version: " + arg7.arg1);
                return;
            label_50:
                this.mCallbackImplRef.get().onLoadChildren(this.mCallbacksMessengerRef.get(), v3.getString("data_media_item_id"), v3.getParcelableArrayList("data_media_item_list"), v3.getBundle("data_options"));
                return;
            label_44:
                this.mCallbackImplRef.get().onConnectionFailed(this.mCallbacksMessengerRef.get());
                return;
            label_32:
                this.mCallbackImplRef.get().onServiceConnected(this.mCallbacksMessengerRef.get(), v3.getString("data_media_item_id"), v3.getParcelable("data_media_session_token"), v3.getBundle("data_root_hints"));
            }
        }

        void setCallbacksMessenger(Messenger arg2) {
            this.mCallbacksMessengerRef = new WeakReference(arg2);
        }
    }

    public class ConnectionCallback {
        interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        class StubApi21 implements android.support.v4.media.MediaBrowserCompatApi21$ConnectionCallback {
            StubApi21(ConnectionCallback arg1) {
                ConnectionCallback.this = arg1;
                super();
            }

            public void onConnected() {
                if(ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnected();
                }

                ConnectionCallback.this.onConnected();
            }

            public void onConnectionFailed() {
                if(ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnectionFailed();
                }

                ConnectionCallback.this.onConnectionFailed();
            }

            public void onConnectionSuspended() {
                if(ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnectionSuspended();
                }

                ConnectionCallback.this.onConnectionSuspended();
            }
        }

        ConnectionCallbackInternal mConnectionCallbackInternal;
        final Object mConnectionCallbackObj;

        public ConnectionCallback() {
            super();
            this.mConnectionCallbackObj = Build$VERSION.SDK_INT >= 21 ? MediaBrowserCompatApi21.createConnectionCallback(new StubApi21(this)) : null;
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        void setInternalConnectionCallback(ConnectionCallbackInternal arg1) {
            this.mConnectionCallbackInternal = arg1;
        }
    }

    public abstract class ItemCallback {
        class StubApi23 implements android.support.v4.media.MediaBrowserCompatApi23$ItemCallback {
            StubApi23(ItemCallback arg1) {
                ItemCallback.this = arg1;
                super();
            }

            public void onError(@NonNull String arg2) {
                ItemCallback.this.onError(arg2);
            }

            public void onItemLoaded(Parcel arg3) {
                if(arg3 == null) {
                    ItemCallback.this.onItemLoaded(null);
                }
                else {
                    arg3.setDataPosition(0);
                    Object v0 = MediaItem.CREATOR.createFromParcel(arg3);
                    arg3.recycle();
                    ItemCallback.this.onItemLoaded(((MediaItem)v0));
                }
            }
        }

        final Object mItemCallbackObj;

        public ItemCallback() {
            super();
            this.mItemCallbackObj = Build$VERSION.SDK_INT >= 23 ? MediaBrowserCompatApi23.createItemCallback(new StubApi23(this)) : null;
        }

        public void onError(@NonNull String arg1) {
        }

        public void onItemLoaded(MediaItem arg1) {
        }
    }

    class ItemReceiver extends ResultReceiver {
        private final ItemCallback mCallback;
        private final String mMediaId;

        ItemReceiver(String arg1, ItemCallback arg2, Handler arg3) {
            super(arg3);
            this.mMediaId = arg1;
            this.mCallback = arg2;
        }

        protected void onReceiveResult(int arg3, Bundle arg4) {
            if(arg4 != null) {
                arg4.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }

            if(arg3 != 0 || arg4 == null || !arg4.containsKey("media_item")) {
                this.mCallback.onError(this.mMediaId);
            }
            else {
                Parcelable v0 = arg4.getParcelable("media_item");
                if(v0 != null && !(v0 instanceof MediaItem)) {
                    this.mCallback.onError(this.mMediaId);
                    return;
                }

                this.mCallback.onItemLoaded(((MediaItem)v0));
            }
        }
    }

    interface MediaBrowserImpl {
        void connect();

        void disconnect();

        @Nullable Bundle getExtras();

        void getItem(@NonNull String arg1, @NonNull ItemCallback arg2);

        @NonNull String getRoot();

        ComponentName getServiceComponent();

        @NonNull Token getSessionToken();

        boolean isConnected();

        void search(@NonNull String arg1, Bundle arg2, @NonNull SearchCallback arg3);

        void subscribe(@NonNull String arg1, Bundle arg2, @NonNull SubscriptionCallback arg3);

        void unsubscribe(@NonNull String arg1, SubscriptionCallback arg2);
    }

    class MediaBrowserImplApi21 implements ConnectionCallbackInternal, MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        protected final Object mBrowserObj;
        protected Messenger mCallbacksMessenger;
        protected final CallbackHandler mHandler;
        protected final Bundle mRootHints;
        protected ServiceBinderWrapper mServiceBinderWrapper;
        private final ArrayMap mSubscriptions;

        public MediaBrowserImplApi21(Context arg3, ComponentName arg4, ConnectionCallback arg5, Bundle arg6) {
            super();
            this.mHandler = new CallbackHandler(((MediaBrowserServiceCallbackImpl)this));
            this.mSubscriptions = new ArrayMap();
            if(Build$VERSION.SDK_INT <= 25) {
                if(arg6 == null) {
                    arg6 = new Bundle();
                }

                arg6.putInt("extra_client_version", 1);
                this.mRootHints = new Bundle(arg6);
            }
            else {
                Bundle v0 = arg6 == null ? null : new Bundle(arg6);
                this.mRootHints = v0;
            }

            arg5.setInternalConnectionCallback(((ConnectionCallbackInternal)this));
            this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(arg3, arg4, arg5.mConnectionCallbackObj, this.mRootHints);
        }

        public void connect() {
            MediaBrowserCompatApi21.connect(this.mBrowserObj);
        }

        public void disconnect() {
            if(this.mServiceBinderWrapper != null && this.mCallbacksMessenger != null) {
                try {
                    this.mServiceBinderWrapper.unregisterCallbackMessenger(this.mCallbacksMessenger);
                }
                catch(RemoteException v0) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }

            MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
        }

        @Nullable public Bundle getExtras() {
            return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
        }

        public void getItem(@NonNull String arg4, @NonNull ItemCallback arg5) {
            if(TextUtils.isEmpty(((CharSequence)arg4))) {
                throw new IllegalArgumentException("mediaId is empty");
            }

            if(arg5 == null) {
                throw new IllegalArgumentException("cb is null");
            }

            if(!MediaBrowserCompatApi21.isConnected(this.mBrowserObj)) {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new Runnable(arg5, arg4) {
                    public void run() {
                        this.val$cb.onError(this.val$mediaId);
                    }
                });
                return;
            }

            if(this.mServiceBinderWrapper == null) {
                this.mHandler.post(new Runnable(arg5, arg4) {
                    public void run() {
                        this.val$cb.onError(this.val$mediaId);
                    }
                });
                return;
            }

            ItemReceiver v0 = new ItemReceiver(arg4, arg5, this.mHandler);
            try {
                this.mServiceBinderWrapper.getMediaItem(arg4, ((ResultReceiver)v0), this.mCallbacksMessenger);
            }
            catch(RemoteException v0_1) {
                Log.i("MediaBrowserCompat", "Remote error getting media item: " + arg4);
                this.mHandler.post(new Runnable(arg5, arg4) {
                    public void run() {
                        this.val$cb.onError(this.val$mediaId);
                    }
                });
            }
        }

        @NonNull public String getRoot() {
            return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
        }

        public ComponentName getServiceComponent() {
            return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
        }

        @NonNull public Token getSessionToken() {
            return Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
        }

        public boolean isConnected() {
            return MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
        }

        public void onConnected() {
            Bundle v0 = MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
            if(v0 != null) {
                IBinder v0_1 = BundleCompat.getBinder(v0, "extra_messenger");
                if(v0_1 == null) {
                    return;
                }

                this.mServiceBinderWrapper = new ServiceBinderWrapper(v0_1, this.mRootHints);
                this.mCallbacksMessenger = new Messenger(this.mHandler);
                this.mHandler.setCallbacksMessenger(this.mCallbacksMessenger);
                try {
                    this.mServiceBinderWrapper.registerCallbackMessenger(this.mCallbacksMessenger);
                }
                catch(RemoteException v0_2) {
                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                }
            }
        }

        public void onConnectionFailed() {
        }

        public void onConnectionFailed(Messenger arg1) {
        }

        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        public void onLoadChildren(Messenger arg4, String arg5, List arg6, Bundle arg7) {
            if(this.mCallbacksMessenger == arg4) {
                Object v0 = this.mSubscriptions.get(arg5);
                if(v0 != null) {
                    SubscriptionCallback v0_1 = ((Subscription)v0).getCallback(arg7);
                    if(v0_1 != null) {
                        if(arg7 == null) {
                            if(arg6 == null) {
                                v0_1.onError(arg5);
                            }
                            else {
                                v0_1.onChildrenLoaded(arg5, arg6);
                            }
                        }
                        else if(arg6 == null) {
                            v0_1.onError(arg5, arg7);
                        }
                        else {
                            v0_1.onChildrenLoaded(arg5, arg6, arg7);
                        }
                    }
                }
                else if(MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn\'t subscribed id=" + arg5);
                }
            }
        }

        public void onServiceConnected(Messenger arg1, String arg2, Token arg3, Bundle arg4) {
        }

        public void search(@NonNull String arg5, Bundle arg6, @NonNull SearchCallback arg7) {
            if(!this.isConnected()) {
                Log.i("MediaBrowserCompat", "Not connected, unable to search.");
                this.mHandler.post(new Runnable(arg7, arg5, arg6) {
                    public void run() {
                        this.val$callback.onError(this.val$query, this.val$extras);
                    }
                });
                return;
            }

            if(this.mServiceBinderWrapper == null) {
                Log.i("MediaBrowserCompat", "The connected service doesn\'t support search.");
                this.mHandler.post(new Runnable(arg7, arg5, arg6) {
                    public void run() {
                        this.val$callback.onError(this.val$query, this.val$extras);
                    }
                });
                return;
            }

            SearchResultReceiver v0 = new SearchResultReceiver(arg5, arg6, arg7, this.mHandler);
            try {
                this.mServiceBinderWrapper.search(arg5, arg6, ((ResultReceiver)v0), this.mCallbacksMessenger);
            }
            catch(RemoteException v0_1) {
                Log.i("MediaBrowserCompat", "Remote error searching items with query: " + arg5, ((Throwable)v0_1));
                this.mHandler.post(new Runnable(arg7, arg5, arg6) {
                    public void run() {
                        this.val$callback.onError(this.val$query, this.val$extras);
                    }
                });
            }
        }

        public void subscribe(@NonNull String arg5, Bundle arg6, @NonNull SubscriptionCallback arg7) {
            Subscription v0_1;
            Object v0 = this.mSubscriptions.get(arg5);
            if(v0 == null) {
                v0_1 = new Subscription();
                this.mSubscriptions.put(arg5, v0_1);
            }

            SubscriptionCallback.access$100(arg7, v0_1);
            Bundle v1 = arg6 == null ? null : new Bundle(arg6);
            v0_1.putCallback(v1, arg7);
            if(this.mServiceBinderWrapper == null) {
                MediaBrowserCompatApi21.subscribe(this.mBrowserObj, arg5, SubscriptionCallback.access$200(arg7));
                return;
            }

            try {
                this.mServiceBinderWrapper.addSubscription(arg5, SubscriptionCallback.access$000(arg7), v1, this.mCallbacksMessenger);
            }
            catch(RemoteException v0_2) {
                Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + arg5);
            }
        }

        public void unsubscribe(@NonNull String arg8, SubscriptionCallback arg9) {
            List v3;
            List v2;
            Object v0 = this.mSubscriptions.get(arg8);
            if(v0 == null) {
                return;
            }

            if(this.mServiceBinderWrapper == null) {
                if(arg9 == null) {
                    MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, arg8);
                    goto label_9;
                }

                v2 = ((Subscription)v0).getCallbacks();
                v3 = ((Subscription)v0).getOptionsList();
                int v1;
                for(v1 = v2.size() - 1; v1 >= 0; --v1) {
                    if(v2.get(v1) == arg9) {
                        v2.remove(v1);
                        v3.remove(v1);
                    }
                }

                if(v2.size() != 0) {
                    goto label_9;
                }

                MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, arg8);
                goto label_9;
            }

            if(arg9 != null) {
                goto label_47;
            }

            try {
                this.mServiceBinderWrapper.removeSubscription(arg8, null, this.mCallbacksMessenger);
                goto label_9;
            label_47:
                v2 = ((Subscription)v0).getCallbacks();
                v3 = ((Subscription)v0).getOptionsList();
                v1 = v2.size() - 1;
                while(true) {
                label_51:
                    if(v1 < 0) {
                        goto label_9;
                    }

                    if(v2.get(v1) == arg9) {
                        this.mServiceBinderWrapper.removeSubscription(arg8, SubscriptionCallback.access$000(arg9), this.mCallbacksMessenger);
                        v2.remove(v1);
                        v3.remove(v1);
                    }

                    break;
                }
            }
            catch(RemoteException v1_1) {
                goto label_45;
            }

            --v1;
            goto label_51;
        label_45:
            Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + arg8);
        label_9:
            if((((Subscription)v0).isEmpty()) || arg9 == null) {
                this.mSubscriptions.remove(arg8);
            }
        }
    }

    class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        public MediaBrowserImplApi23(Context arg1, ComponentName arg2, ConnectionCallback arg3, Bundle arg4) {
            super(arg1, arg2, arg3, arg4);
        }

        public void getItem(@NonNull String arg3, @NonNull ItemCallback arg4) {
            if(this.mServiceBinderWrapper == null) {
                MediaBrowserCompatApi23.getItem(this.mBrowserObj, arg3, arg4.mItemCallbackObj);
            }
            else {
                super.getItem(arg3, arg4);
            }
        }
    }

    class MediaBrowserImplApi24 extends MediaBrowserImplApi23 {
        public MediaBrowserImplApi24(Context arg1, ComponentName arg2, ConnectionCallback arg3, Bundle arg4) {
            super(arg1, arg2, arg3, arg4);
        }

        public void subscribe(@NonNull String arg3, @NonNull Bundle arg4, @NonNull SubscriptionCallback arg5) {
            if(arg4 == null) {
                MediaBrowserCompatApi21.subscribe(this.mBrowserObj, arg3, SubscriptionCallback.access$200(arg5));
            }
            else {
                MediaBrowserCompatApi24.subscribe(this.mBrowserObj, arg3, arg4, SubscriptionCallback.access$200(arg5));
            }
        }

        public void unsubscribe(@NonNull String arg3, SubscriptionCallback arg4) {
            if(arg4 == null) {
                MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, arg3);
            }
            else {
                MediaBrowserCompatApi24.unsubscribe(this.mBrowserObj, arg3, SubscriptionCallback.access$200(arg4));
            }
        }
    }

    class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        class MediaServiceConnection implements ServiceConnection {
            MediaServiceConnection(MediaBrowserImplBase arg1) {
                MediaBrowserImplBase.this = arg1;
                super();
            }

            boolean isCurrent(String arg4) {
                boolean v0;
                if(MediaBrowserImplBase.this.mServiceConnection != this) {
                    if(MediaBrowserImplBase.this.mState != 0) {
                        Log.i("MediaBrowserCompat", arg4 + " for " + MediaBrowserImplBase.this.mServiceComponent + " with mServiceConnection=" + MediaBrowserImplBase.this.mServiceConnection + " this=" + this);
                    }

                    v0 = false;
                }
                else {
                    v0 = true;
                }

                return v0;
            }

            public void onServiceConnected(ComponentName arg2, IBinder arg3) {
                this.postOrRun(new Runnable(arg2, arg3) {
                    public void run() {
                        if(MediaBrowserCompat.DEBUG) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + this.val$name + " binder=" + this.val$binder);
                            this.this$1.this$0.dump();
                        }

                        if(this.this$1.isCurrent("onServiceConnected")) {
                            this.this$1.this$0.mServiceBinderWrapper = new ServiceBinderWrapper(this.val$binder, this.this$1.this$0.mRootHints);
                            this.this$1.this$0.mCallbacksMessenger = new Messenger(this.this$1.this$0.mHandler);
                            this.this$1.this$0.mHandler.setCallbacksMessenger(this.this$1.this$0.mCallbacksMessenger);
                            this.this$1.this$0.mState = 1;
                            try {
                                if(MediaBrowserCompat.DEBUG) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    this.this$1.this$0.dump();
                                }

                                this.this$1.this$0.mServiceBinderWrapper.connect(this.this$1.this$0.mContext, this.this$1.this$0.mCallbacksMessenger);
                            }
                            catch(RemoteException v0) {
                                Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.this$1.this$0.mServiceComponent);
                                if(!MediaBrowserCompat.DEBUG) {
                                    return;
                                }

                                Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                this.this$1.this$0.dump();
                            }
                        }
                    }
                });
            }

            public void onServiceDisconnected(ComponentName arg2) {
                this.postOrRun(new Runnable(arg2) {
                    public void run() {
                        ServiceBinderWrapper v3 = null;
                        if(MediaBrowserCompat.DEBUG) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + this.val$name + " this=" + this + " mServiceConnection=" + this.this$1.this$0.mServiceConnection);
                            this.this$1.this$0.dump();
                        }

                        if(this.this$1.isCurrent("onServiceDisconnected")) {
                            this.this$1.this$0.mServiceBinderWrapper = v3;
                            this.this$1.this$0.mCallbacksMessenger = ((Messenger)v3);
                            this.this$1.this$0.mHandler.setCallbacksMessenger(((Messenger)v3));
                            this.this$1.this$0.mState = 3;
                            this.this$1.this$0.mCallback.onConnectionSuspended();
                        }
                    }
                });
            }

            private void postOrRun(Runnable arg3) {
                if(Thread.currentThread() == MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
                    arg3.run();
                }
                else {
                    MediaBrowserImplBase.this.mHandler.post(arg3);
                }
            }
        }

        private static final int CONNECT_STATE_CONNECTED = 2;
        static final int CONNECT_STATE_CONNECTING = 1;
        static final int CONNECT_STATE_DISCONNECTED = 0;
        static final int CONNECT_STATE_SUSPENDED = 3;
        final ConnectionCallback mCallback;
        Messenger mCallbacksMessenger;
        final Context mContext;
        private Bundle mExtras;
        final CallbackHandler mHandler;
        private Token mMediaSessionToken;
        final Bundle mRootHints;
        private String mRootId;
        ServiceBinderWrapper mServiceBinderWrapper;
        final ComponentName mServiceComponent;
        MediaServiceConnection mServiceConnection;
        int mState;
        private final ArrayMap mSubscriptions;

        public MediaBrowserImplBase(Context arg3, ComponentName arg4, ConnectionCallback arg5, Bundle arg6) {
            super();
            this.mHandler = new CallbackHandler(((MediaBrowserServiceCallbackImpl)this));
            this.mSubscriptions = new ArrayMap();
            this.mState = 0;
            if(arg3 == null) {
                throw new IllegalArgumentException("context must not be null");
            }

            if(arg4 == null) {
                throw new IllegalArgumentException("service component must not be null");
            }

            if(arg5 == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            }

            this.mContext = arg3;
            this.mServiceComponent = arg4;
            this.mCallback = arg5;
            Bundle v0 = arg6 == null ? null : new Bundle(arg6);
            this.mRootHints = v0;
        }

        public void connect() {
            if(this.mState != 0) {
                throw new IllegalStateException("connect() called while not disconnected (state=" + MediaBrowserImplBase.getStateLabel(this.mState) + ")");
            }

            if((MediaBrowserCompat.DEBUG) && this.mServiceConnection != null) {
                throw new RuntimeException("mServiceConnection should be null. Instead it is " + this.mServiceConnection);
            }

            if(this.mServiceBinderWrapper != null) {
                throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + this.mServiceBinderWrapper);
            }

            if(this.mCallbacksMessenger != null) {
                throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + this.mCallbacksMessenger);
            }

            this.mState = 1;
            Intent v1 = new Intent("android.media.browse.MediaBrowserService");
            v1.setComponent(this.mServiceComponent);
            MediaServiceConnection v2 = new MediaServiceConnection(this);
            this.mServiceConnection = v2;
            try {
                boolean v0 = this.mContext.bindService(v1, this.mServiceConnection, 1);
            }
            catch(Exception v1_1) {
                Log.e("MediaBrowserCompat", "Failed binding to service " + this.mServiceComponent);
            }

            if(!v0) {
                this.mHandler.post(new Runnable(((ServiceConnection)v2)) {
                    public void run() {
                        if(this.val$thisConnection == MediaBrowserImplBase.this.mServiceConnection) {
                            MediaBrowserImplBase.this.forceCloseConnection();
                            MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                        }
                    }
                });
            }

            if(MediaBrowserCompat.DEBUG) {
                Log.d("MediaBrowserCompat", "connect...");
                this.dump();
            }
        }

        public void disconnect() {
            if(this.mCallbacksMessenger != null) {
                try {
                    this.mServiceBinderWrapper.disconnect(this.mCallbacksMessenger);
                }
                catch(RemoteException v0) {
                    Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.mServiceComponent);
                }
            }

            this.forceCloseConnection();
            if(MediaBrowserCompat.DEBUG) {
                Log.d("MediaBrowserCompat", "disconnect...");
                this.dump();
            }
        }

        void dump() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.mServiceComponent);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.mCallback);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.mRootHints);
            Log.d("MediaBrowserCompat", "  mState=" + MediaBrowserImplBase.getStateLabel(this.mState));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.mServiceConnection);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.mCallbacksMessenger);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.mRootId);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.mMediaSessionToken);
        }

        void forceCloseConnection() {
            MediaServiceConnection v2 = null;
            if(this.mServiceConnection != null) {
                this.mContext.unbindService(this.mServiceConnection);
            }

            this.mState = 0;
            this.mServiceConnection = v2;
            this.mServiceBinderWrapper = ((ServiceBinderWrapper)v2);
            this.mCallbacksMessenger = ((Messenger)v2);
            this.mHandler.setCallbacksMessenger(((Messenger)v2));
            this.mRootId = ((String)v2);
            this.mMediaSessionToken = ((Token)v2);
        }

        @Nullable public Bundle getExtras() {
            if(!this.isConnected()) {
                throw new IllegalStateException("getExtras() called while not connected (state=" + MediaBrowserImplBase.getStateLabel(this.mState) + ")");
            }

            return this.mExtras;
        }

        public void getItem(@NonNull String arg4, @NonNull ItemCallback arg5) {
            if(TextUtils.isEmpty(((CharSequence)arg4))) {
                throw new IllegalArgumentException("mediaId is empty");
            }

            if(arg5 == null) {
                throw new IllegalArgumentException("cb is null");
            }

            if(this.mState != 2) {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new Runnable(arg5, arg4) {
                    public void run() {
                        this.val$cb.onError(this.val$mediaId);
                    }
                });
                return;
            }

            ItemReceiver v0 = new ItemReceiver(arg4, arg5, this.mHandler);
            try {
                this.mServiceBinderWrapper.getMediaItem(arg4, ((ResultReceiver)v0), this.mCallbacksMessenger);
            }
            catch(RemoteException v0_1) {
                Log.i("MediaBrowserCompat", "Remote error getting media item.");
                this.mHandler.post(new Runnable(arg5, arg4) {
                    public void run() {
                        this.val$cb.onError(this.val$mediaId);
                    }
                });
            }
        }

        @NonNull public String getRoot() {
            if(!this.isConnected()) {
                throw new IllegalStateException("getRoot() called while not connected(state=" + MediaBrowserImplBase.getStateLabel(this.mState) + ")");
            }

            return this.mRootId;
        }

        @NonNull public ComponentName getServiceComponent() {
            if(!this.isConnected()) {
                throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
            }

            return this.mServiceComponent;
        }

        @NonNull public Token getSessionToken() {
            if(!this.isConnected()) {
                throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
            }

            return this.mMediaSessionToken;
        }

        private static String getStateLabel(int arg2) {
            String v0;
            switch(arg2) {
                case 0: {
                    v0 = "CONNECT_STATE_DISCONNECTED";
                    break;
                }
                case 1: {
                    v0 = "CONNECT_STATE_CONNECTING";
                    break;
                }
                case 2: {
                    v0 = "CONNECT_STATE_CONNECTED";
                    break;
                }
                case 3: {
                    v0 = "CONNECT_STATE_SUSPENDED";
                    break;
                }
                default: {
                    v0 = "UNKNOWN/" + arg2;
                    break;
                }
            }

            return v0;
        }

        public boolean isConnected() {
            boolean v0 = this.mState == 2 ? true : false;
            return v0;
        }

        private boolean isCurrent(Messenger arg4, String arg5) {
            boolean v0;
            if(this.mCallbacksMessenger != arg4) {
                if(this.mState != 0) {
                    Log.i("MediaBrowserCompat", arg5 + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
                }

                v0 = false;
            }
            else {
                v0 = true;
            }

            return v0;
        }

        public void onConnectionFailed(Messenger arg4) {
            Log.e("MediaBrowserCompat", "onConnectFailed for " + this.mServiceComponent);
            if(this.isCurrent(arg4, "onConnectFailed")) {
                if(this.mState != 1) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + MediaBrowserImplBase.getStateLabel(this.mState) + "... ignoring");
                }
                else {
                    this.forceCloseConnection();
                    this.mCallback.onConnectionFailed();
                }
            }
        }

        public void onLoadChildren(Messenger arg4, String arg5, List arg6, Bundle arg7) {
            if(this.isCurrent(arg4, "onLoadChildren")) {
                if(MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for " + this.mServiceComponent + " id=" + arg5);
                }

                Object v0 = this.mSubscriptions.get(arg5);
                if(v0 == null) {
                    if(!MediaBrowserCompat.DEBUG) {
                        return;
                    }

                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn\'t subscribed id=" + arg5);
                    return;
                }

                SubscriptionCallback v0_1 = ((Subscription)v0).getCallback(arg7);
                if(v0_1 == null) {
                    return;
                }

                if(arg7 == null) {
                    if(arg6 == null) {
                        v0_1.onError(arg5);
                        return;
                    }

                    v0_1.onChildrenLoaded(arg5, arg6);
                    return;
                }

                if(arg6 == null) {
                    v0_1.onError(arg5, arg7);
                    return;
                }

                v0_1.onChildrenLoaded(arg5, arg6, arg7);
            }
        }

        public void onServiceConnected(Messenger arg10, String arg11, Token arg12, Bundle arg13) {
            if(this.isCurrent(arg10, "onConnect")) {
                if(this.mState != 1) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + MediaBrowserImplBase.getStateLabel(this.mState) + "... ignoring");
                    return;
                }

                this.mRootId = arg11;
                this.mMediaSessionToken = arg12;
                this.mExtras = arg13;
                this.mState = 2;
                if(MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    this.dump();
                }

                this.mCallback.onConnected();
                try {
                    Iterator v3 = this.mSubscriptions.entrySet().iterator();
                label_36:
                    if(!v3.hasNext()) {
                        return;
                    }

                    Object v0_1 = v3.next();
                    Object v1 = ((Map$Entry)v0_1).getKey();
                    v0_1 = ((Map$Entry)v0_1).getValue();
                    List v4 = ((Subscription)v0_1).getCallbacks();
                    List v5 = ((Subscription)v0_1).getOptionsList();
                    int v2;
                    for(v2 = 0; true; ++v2) {
                        if(v2 >= v4.size()) {
                            goto label_36;
                        }

                        this.mServiceBinderWrapper.addSubscription(((String)v1), SubscriptionCallback.access$000(v4.get(v2)), v5.get(v2), this.mCallbacksMessenger);
                    }
                }
                catch(RemoteException v0) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                }
            }
        }

        public void search(@NonNull String arg5, Bundle arg6, @NonNull SearchCallback arg7) {
            if(!this.isConnected()) {
                Log.i("MediaBrowserCompat", "Not connected, unable to search.");
                this.mHandler.post(new Runnable(arg7, arg5, arg6) {
                    public void run() {
                        this.val$callback.onError(this.val$query, this.val$extras);
                    }
                });
                return;
            }

            SearchResultReceiver v0 = new SearchResultReceiver(arg5, arg6, arg7, this.mHandler);
            try {
                this.mServiceBinderWrapper.search(arg5, arg6, ((ResultReceiver)v0), this.mCallbacksMessenger);
            }
            catch(RemoteException v0_1) {
                Log.i("MediaBrowserCompat", "Remote error searching items with query: " + arg5, ((Throwable)v0_1));
                this.mHandler.post(new Runnable(arg7, arg5, arg6) {
                    public void run() {
                        this.val$callback.onError(this.val$query, this.val$extras);
                    }
                });
            }
        }

        public void subscribe(@NonNull String arg5, Bundle arg6, @NonNull SubscriptionCallback arg7) {
            Object v1_1;
            Object v0 = this.mSubscriptions.get(arg5);
            if(v0 == null) {
                Subscription v0_1 = new Subscription();
                this.mSubscriptions.put(arg5, v0_1);
                Subscription v1 = v0_1;
            }
            else {
                v1_1 = v0;
            }

            Bundle v0_2 = arg6 == null ? null : new Bundle(arg6);
            ((Subscription)v1_1).putCallback(v0_2, arg7);
            if(this.mState == 2) {
                try {
                    this.mServiceBinderWrapper.addSubscription(arg5, SubscriptionCallback.access$000(arg7), v0_2, this.mCallbacksMessenger);
                }
                catch(RemoteException v0_3) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + arg5);
                }
            }
        }

        public void unsubscribe(@NonNull String arg9, SubscriptionCallback arg10) {
            int v1_1;
            int v7 = 2;
            Object v0 = this.mSubscriptions.get(arg9);
            if(v0 == null) {
                return;
            }

            if(arg10 != null) {
                goto label_18;
            }

            try {
                if(this.mState != v7) {
                    goto label_12;
                }

                this.mServiceBinderWrapper.removeSubscription(arg9, null, this.mCallbacksMessenger);
                goto label_12;
            label_18:
                List v2 = ((Subscription)v0).getCallbacks();
                List v3 = ((Subscription)v0).getOptionsList();
                v1_1 = v2.size() - 1;
                while(true) {
                label_22:
                    if(v1_1 < 0) {
                        goto label_12;
                    }

                    if(v2.get(v1_1) == arg10) {
                        if(this.mState == v7) {
                            this.mServiceBinderWrapper.removeSubscription(arg9, SubscriptionCallback.access$000(arg10), this.mCallbacksMessenger);
                        }

                        v2.remove(v1_1);
                        v3.remove(v1_1);
                    }

                    break;
                }
            }
            catch(RemoteException v1) {
                goto label_43;
            }

            --v1_1;
            goto label_22;
        label_43:
            Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + arg9);
        label_12:
            if((((Subscription)v0).isEmpty()) || arg10 == null) {
                this.mSubscriptions.remove(arg9);
            }
        }
    }

    interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger arg1);

        void onLoadChildren(Messenger arg1, String arg2, List arg3, Bundle arg4);

        void onServiceConnected(Messenger arg1, String arg2, Token arg3, Bundle arg4);
    }

    public class MediaItem implements Parcelable {
        final class android.support.v4.media.MediaBrowserCompat$MediaItem$1 implements Parcelable$Creator {
            android.support.v4.media.MediaBrowserCompat$MediaItem$1() {
                super();
            }

            public MediaItem createFromParcel(Parcel arg2) {
                return new MediaItem(arg2);
            }

            public Object createFromParcel(Parcel arg2) {
                return this.createFromParcel(arg2);
            }

            public MediaItem[] newArray(int arg2) {
                return new MediaItem[arg2];
            }

            public Object[] newArray(int arg2) {
                return this.newArray(arg2);
            }
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface Flags {
        }

        public static final Parcelable$Creator CREATOR = null;
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        static {
            MediaItem.CREATOR = new android.support.v4.media.MediaBrowserCompat$MediaItem$1();
        }

        MediaItem(Parcel arg2) {
            super();
            this.mFlags = arg2.readInt();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(arg2);
        }

        public MediaItem(@NonNull MediaDescriptionCompat arg3, int arg4) {
            super();
            if(arg3 == null) {
                throw new IllegalArgumentException("description cannot be null");
            }

            if(TextUtils.isEmpty(arg3.getMediaId())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }

            this.mFlags = arg4;
            this.mDescription = arg3;
        }

        public int describeContents() {
            return 0;
        }

        public static MediaItem fromMediaItem(Object arg3) {
            MediaItem v0 = arg3 == null || Build$VERSION.SDK_INT < 21 ? null : new MediaItem(MediaDescriptionCompat.fromMediaDescription(android.support.v4.media.MediaBrowserCompatApi21$MediaItem.getDescription(arg3)), android.support.v4.media.MediaBrowserCompatApi21$MediaItem.getFlags(arg3));
            return v0;
        }

        public static List fromMediaItemList(List arg3) {
            List v0_1;
            if(arg3 == null || Build$VERSION.SDK_INT < 21) {
                v0_1 = null;
            }
            else {
                ArrayList v0 = new ArrayList(arg3.size());
                Iterator v1 = arg3.iterator();
                while(v1.hasNext()) {
                    ((List)v0).add(MediaItem.fromMediaItem(v1.next()));
                }
            }

            return v0_1;
        }

        @NonNull public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        @Nullable public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            boolean v0 = (this.mFlags & 1) != 0 ? true : false;
            return v0;
        }

        public boolean isPlayable() {
            boolean v0 = (this.mFlags & 2) != 0 ? true : false;
            return v0;
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder("MediaItem{");
            v0.append("mFlags=").append(this.mFlags);
            v0.append(", mDescription=").append(this.mDescription);
            v0.append('}');
            return v0.toString();
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            arg2.writeInt(this.mFlags);
            this.mDescription.writeToParcel(arg2, arg3);
        }
    }

    public abstract class SearchCallback {
        public SearchCallback() {
            super();
        }

        public void onError(@NonNull String arg1, Bundle arg2) {
        }

        public void onSearchResult(@NonNull String arg1, Bundle arg2, @NonNull List arg3) {
        }
    }

    class SearchResultReceiver extends ResultReceiver {
        private final SearchCallback mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        SearchResultReceiver(String arg1, Bundle arg2, SearchCallback arg3, Handler arg4) {
            super(arg4);
            this.mQuery = arg1;
            this.mExtras = arg2;
            this.mCallback = arg3;
        }

        protected void onReceiveResult(int arg6, Bundle arg7) {
            if(arg6 != 0 || arg7 == null || !arg7.containsKey("search_results")) {
                this.mCallback.onError(this.mQuery, this.mExtras);
            }
            else {
                Parcelable[] v3 = arg7.getParcelableArray("search_results");
                List v0 = null;
                if(v3 != null) {
                    ArrayList v1 = new ArrayList();
                    int v4 = v3.length;
                    int v2;
                    for(v2 = 0; v2 < v4; ++v2) {
                        ((List)v1).add(v3[v2]);
                    }

                    ArrayList v0_1 = v1;
                }

                this.mCallback.onSearchResult(this.mQuery, this.mExtras, v0);
            }
        }
    }

    class ServiceBinderWrapper {
        private Messenger mMessenger;
        private Bundle mRootHints;

        public ServiceBinderWrapper(IBinder arg2, Bundle arg3) {
            super();
            this.mMessenger = new Messenger(arg2);
            this.mRootHints = arg3;
        }

        void addSubscription(String arg3, IBinder arg4, Bundle arg5, Messenger arg6) {
            Bundle v0 = new Bundle();
            v0.putString("data_media_item_id", arg3);
            BundleCompat.putBinder(v0, "data_callback_token", arg4);
            v0.putBundle("data_options", arg5);
            this.sendRequest(3, v0, arg6);
        }

        void connect(Context arg4, Messenger arg5) {
            Bundle v0 = new Bundle();
            v0.putString("data_package_name", arg4.getPackageName());
            v0.putBundle("data_root_hints", this.mRootHints);
            this.sendRequest(1, v0, arg5);
        }

        void disconnect(Messenger arg3) {
            this.sendRequest(2, null, arg3);
        }

        void getMediaItem(String arg3, ResultReceiver arg4, Messenger arg5) {
            Bundle v0 = new Bundle();
            v0.putString("data_media_item_id", arg3);
            v0.putParcelable("data_result_receiver", ((Parcelable)arg4));
            this.sendRequest(5, v0, arg5);
        }

        void registerCallbackMessenger(Messenger arg4) {
            Bundle v0 = new Bundle();
            v0.putBundle("data_root_hints", this.mRootHints);
            this.sendRequest(6, v0, arg4);
        }

        void removeSubscription(String arg3, IBinder arg4, Messenger arg5) {
            Bundle v0 = new Bundle();
            v0.putString("data_media_item_id", arg3);
            BundleCompat.putBinder(v0, "data_callback_token", arg4);
            this.sendRequest(4, v0, arg5);
        }

        void search(String arg3, Bundle arg4, ResultReceiver arg5, Messenger arg6) {
            Bundle v0 = new Bundle();
            v0.putString("data_search_query", arg3);
            v0.putBundle("data_search_extras", arg4);
            v0.putParcelable("data_result_receiver", ((Parcelable)arg5));
            this.sendRequest(8, v0, arg6);
        }

        private void sendRequest(int arg3, Bundle arg4, Messenger arg5) {
            Message v0 = Message.obtain();
            v0.what = arg3;
            v0.arg1 = 1;
            v0.setData(arg4);
            v0.replyTo = arg5;
            this.mMessenger.send(v0);
        }

        void unregisterCallbackMessenger(Messenger arg3) {
            this.sendRequest(7, null, arg3);
        }
    }

    class Subscription {
        private final List mCallbacks;
        private final List mOptionsList;

        public Subscription() {
            super();
            this.mCallbacks = new ArrayList();
            this.mOptionsList = new ArrayList();
        }

        public SubscriptionCallback getCallback(Bundle arg3) {
            SubscriptionCallback v0_1;
            int v1 = 0;
            while(true) {
                if(v1 >= this.mOptionsList.size()) {
                    break;
                }
                else if(MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(v1), arg3)) {
                    Object v0 = this.mCallbacks.get(v1);
                }
                else {
                    ++v1;
                    continue;
                }

                return v0_1;
            }

            v0_1 = null;
            return v0_1;
        }

        public List getCallbacks() {
            return this.mCallbacks;
        }

        public List getOptionsList() {
            return this.mOptionsList;
        }

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public void putCallback(Bundle arg3, SubscriptionCallback arg4) {
            int v1 = 0;
            while(true) {
                if(v1 >= this.mOptionsList.size()) {
                    break;
                }
                else if(MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(v1), arg3)) {
                    this.mCallbacks.set(v1, arg4);
                }
                else {
                    ++v1;
                    continue;
                }

                return;
            }

            this.mCallbacks.add(arg4);
            this.mOptionsList.add(arg3);
        }
    }

    public abstract class SubscriptionCallback {
        class android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$StubApi21 implements android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallback {
            android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$StubApi21(SubscriptionCallback arg1) {
                SubscriptionCallback.this = arg1;
                super();
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

            public void onChildrenLoaded(@NonNull String arg8, List arg9) {
                Object v0 = SubscriptionCallback.this.mSubscriptionRef == null ? null : SubscriptionCallback.this.mSubscriptionRef.get();
                if(v0 == null) {
                    SubscriptionCallback.this.onChildrenLoaded(arg8, MediaItem.fromMediaItemList(arg9));
                }
                else {
                    List v2 = MediaItem.fromMediaItemList(arg9);
                    List v3 = ((Subscription)v0).getCallbacks();
                    List v4 = ((Subscription)v0).getOptionsList();
                    int v1;
                    for(v1 = 0; v1 < v3.size(); ++v1) {
                        v0 = v4.get(v1);
                        if(v0 == null) {
                            SubscriptionCallback.this.onChildrenLoaded(arg8, v2);
                        }
                        else {
                            SubscriptionCallback.this.onChildrenLoaded(arg8, this.applyOptions(v2, ((Bundle)v0)), ((Bundle)v0));
                        }
                    }
                }
            }

            public void onError(@NonNull String arg2) {
                SubscriptionCallback.this.onError(arg2);
            }
        }

        class StubApi24 extends android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$StubApi21 implements android.support.v4.media.MediaBrowserCompatApi24$SubscriptionCallback {
            StubApi24(SubscriptionCallback arg1) {
                SubscriptionCallback.this = arg1;
                super(arg1);
            }

            public void onChildrenLoaded(@NonNull String arg3, List arg4, @NonNull Bundle arg5) {
                SubscriptionCallback.this.onChildrenLoaded(arg3, MediaItem.fromMediaItemList(arg4), arg5);
            }

            public void onError(@NonNull String arg2, @NonNull Bundle arg3) {
                SubscriptionCallback.this.onError(arg2, arg3);
            }
        }

        private final Object mSubscriptionCallbackObj;
        WeakReference mSubscriptionRef;
        private final IBinder mToken;

        public SubscriptionCallback() {
            IBinder v2 = null;
            super();
            if(Build$VERSION.SDK_INT >= 26 || (BuildCompat.isAtLeastO())) {
                this.mSubscriptionCallbackObj = MediaBrowserCompatApi24.createSubscriptionCallback(new StubApi24(this));
                this.mToken = v2;
            }
            else if(Build$VERSION.SDK_INT >= 21) {
                this.mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback(new android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$StubApi21(this));
                this.mToken = new Binder();
            }
            else {
                this.mSubscriptionCallbackObj = v2;
                this.mToken = new Binder();
            }
        }

        static IBinder access$000(SubscriptionCallback arg1) {
            return arg1.mToken;
        }

        static void access$100(SubscriptionCallback arg0, Subscription arg1) {
            arg0.setSubscription(arg1);
        }

        static Object access$200(SubscriptionCallback arg1) {
            return arg1.mSubscriptionCallbackObj;
        }

        public void onChildrenLoaded(@NonNull String arg1, @NonNull List arg2) {
        }

        public void onChildrenLoaded(@NonNull String arg1, @NonNull List arg2, @NonNull Bundle arg3) {
        }

        public void onError(@NonNull String arg1) {
        }

        public void onError(@NonNull String arg1, @NonNull Bundle arg2) {
        }

        private void setSubscription(Subscription arg2) {
            this.mSubscriptionRef = new WeakReference(arg2);
        }
    }

    static final boolean DEBUG = false;
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    static final String TAG = "MediaBrowserCompat";
    private final MediaBrowserImpl mImpl;

    static {
        MediaBrowserCompat.DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
    }

    public MediaBrowserCompat(Context arg3, ComponentName arg4, ConnectionCallback arg5, Bundle arg6) {
        super();
        if(Build$VERSION.SDK_INT >= 26 || (BuildCompat.isAtLeastO())) {
            this.mImpl = new MediaBrowserImplApi24(arg3, arg4, arg5, arg6);
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaBrowserImplApi23(arg3, arg4, arg5, arg6);
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaBrowserImplApi21(arg3, arg4, arg5, arg6);
        }
        else {
            this.mImpl = new MediaBrowserImplBase(arg3, arg4, arg5, arg6);
        }
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    @Nullable public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(@NonNull String arg2, @NonNull ItemCallback arg3) {
        this.mImpl.getItem(arg2, arg3);
    }

    @NonNull public String getRoot() {
        return this.mImpl.getRoot();
    }

    @NonNull public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    @NonNull public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void search(@NonNull String arg3, Bundle arg4, @NonNull SearchCallback arg5) {
        if(TextUtils.isEmpty(((CharSequence)arg3))) {
            throw new IllegalArgumentException("query cannot be empty");
        }

        if(arg5 == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }

        this.mImpl.search(arg3, arg4, arg5);
    }

    public void subscribe(@NonNull String arg3, @NonNull Bundle arg4, @NonNull SubscriptionCallback arg5) {
        if(TextUtils.isEmpty(((CharSequence)arg3))) {
            throw new IllegalArgumentException("parentId is empty");
        }

        if(arg5 == null) {
            throw new IllegalArgumentException("callback is null");
        }

        if(arg4 == null) {
            throw new IllegalArgumentException("options are null");
        }

        this.mImpl.subscribe(arg3, arg4, arg5);
    }

    public void subscribe(@NonNull String arg3, @NonNull SubscriptionCallback arg4) {
        if(TextUtils.isEmpty(((CharSequence)arg3))) {
            throw new IllegalArgumentException("parentId is empty");
        }

        if(arg4 == null) {
            throw new IllegalArgumentException("callback is null");
        }

        this.mImpl.subscribe(arg3, null, arg4);
    }

    public void unsubscribe(@NonNull String arg3) {
        if(TextUtils.isEmpty(((CharSequence)arg3))) {
            throw new IllegalArgumentException("parentId is empty");
        }

        this.mImpl.unsubscribe(arg3, null);
    }

    public void unsubscribe(@NonNull String arg3, @NonNull SubscriptionCallback arg4) {
        if(TextUtils.isEmpty(((CharSequence)arg3))) {
            throw new IllegalArgumentException("parentId is empty");
        }

        if(arg4 == null) {
            throw new IllegalArgumentException("callback is null");
        }

        this.mImpl.unsubscribe(arg3, arg4);
    }
}

