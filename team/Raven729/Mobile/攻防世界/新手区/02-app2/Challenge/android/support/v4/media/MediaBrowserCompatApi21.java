package android.support.v4.media;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser$ConnectionCallback;
import android.media.browse.MediaBrowser$MediaItem;
import android.media.browse.MediaBrowser$SubscriptionCallback;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import java.util.List;

@TargetApi(value=21) @RequiresApi(value=21) class MediaBrowserCompatApi21 {
    interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    class ConnectionCallbackProxy extends MediaBrowser$ConnectionCallback {
        protected final ConnectionCallback mConnectionCallback;

        public ConnectionCallbackProxy(ConnectionCallback arg1) {
            super();
            this.mConnectionCallback = arg1;
        }

        public void onConnected() {
            this.mConnectionCallback.onConnected();
        }

        public void onConnectionFailed() {
            this.mConnectionCallback.onConnectionFailed();
        }

        public void onConnectionSuspended() {
            this.mConnectionCallback.onConnectionSuspended();
        }
    }

    class MediaItem {
        MediaItem() {
            super();
        }

        public static Object getDescription(Object arg1) {
            return ((MediaBrowser$MediaItem)arg1).getDescription();
        }

        public static int getFlags(Object arg1) {
            return ((MediaBrowser$MediaItem)arg1).getFlags();
        }
    }

    interface SubscriptionCallback {
        void onChildrenLoaded(@NonNull String arg1, List arg2);

        void onError(@NonNull String arg1);
    }

    class SubscriptionCallbackProxy extends MediaBrowser$SubscriptionCallback {
        protected final SubscriptionCallback mSubscriptionCallback;

        public SubscriptionCallbackProxy(SubscriptionCallback arg1) {
            super();
            this.mSubscriptionCallback = arg1;
        }

        public void onChildrenLoaded(@NonNull String arg2, List arg3) {
            this.mSubscriptionCallback.onChildrenLoaded(arg2, arg3);
        }

        public void onError(@NonNull String arg2) {
            this.mSubscriptionCallback.onError(arg2);
        }
    }

    static final String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";

    MediaBrowserCompatApi21() {
        super();
    }

    public static void connect(Object arg0) {
        ((MediaBrowser)arg0).connect();
    }

    public static Object createBrowser(Context arg1, ComponentName arg2, Object arg3, Bundle arg4) {
        return new MediaBrowser(arg1, arg2, ((MediaBrowser$ConnectionCallback)arg3), arg4);
    }

    public static Object createConnectionCallback(ConnectionCallback arg1) {
        return new ConnectionCallbackProxy(arg1);
    }

    public static Object createSubscriptionCallback(SubscriptionCallback arg1) {
        return new SubscriptionCallbackProxy(arg1);
    }

    public static void disconnect(Object arg0) {
        ((MediaBrowser)arg0).disconnect();
    }

    public static Bundle getExtras(Object arg1) {
        return ((MediaBrowser)arg1).getExtras();
    }

    public static String getRoot(Object arg1) {
        return ((MediaBrowser)arg1).getRoot();
    }

    public static ComponentName getServiceComponent(Object arg1) {
        return ((MediaBrowser)arg1).getServiceComponent();
    }

    public static Object getSessionToken(Object arg1) {
        return ((MediaBrowser)arg1).getSessionToken();
    }

    public static boolean isConnected(Object arg1) {
        return ((MediaBrowser)arg1).isConnected();
    }

    public static void subscribe(Object arg0, String arg1, Object arg2) {
        ((MediaBrowser)arg0).subscribe(arg1, ((MediaBrowser$SubscriptionCallback)arg2));
    }

    public static void unsubscribe(Object arg0, String arg1) {
        ((MediaBrowser)arg0).unsubscribe(arg1);
    }
}

