package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.browse.MediaBrowser$SubscriptionCallback;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import java.util.List;

@TargetApi(value=24) @RequiresApi(value=24) class MediaBrowserCompatApi24 {
    interface SubscriptionCallback extends android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallback {
        void onChildrenLoaded(@NonNull String arg1, List arg2, @NonNull Bundle arg3);

        void onError(@NonNull String arg1, @NonNull Bundle arg2);
    }

    class SubscriptionCallbackProxy extends android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallbackProxy {
        public SubscriptionCallbackProxy(SubscriptionCallback arg1) {
            super(((android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallback)arg1));
        }

        public void onChildrenLoaded(@NonNull String arg2, List arg3, @NonNull Bundle arg4) {
            this.mSubscriptionCallback.onChildrenLoaded(arg2, arg3, arg4);
        }

        public void onError(@NonNull String arg2, @NonNull Bundle arg3) {
            this.mSubscriptionCallback.onError(arg2, arg3);
        }
    }

    MediaBrowserCompatApi24() {
        super();
    }

    public static Object createSubscriptionCallback(SubscriptionCallback arg1) {
        return new SubscriptionCallbackProxy(arg1);
    }

    public static void subscribe(Object arg0, String arg1, Bundle arg2, Object arg3) {
        ((MediaBrowser)arg0).subscribe(arg1, arg2, ((MediaBrowser$SubscriptionCallback)arg3));
    }

    public static void unsubscribe(Object arg0, String arg1, Object arg2) {
        ((MediaBrowser)arg0).unsubscribe(arg1, ((MediaBrowser$SubscriptionCallback)arg2));
    }
}

