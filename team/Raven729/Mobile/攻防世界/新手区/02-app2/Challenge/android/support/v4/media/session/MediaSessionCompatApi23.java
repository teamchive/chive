package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(value=23) @RequiresApi(value=23) class MediaSessionCompatApi23 {
    public interface Callback extends android.support.v4.media.session.MediaSessionCompatApi21$Callback {
        void onPlayFromUri(Uri arg1, Bundle arg2);
    }

    class CallbackProxy extends android.support.v4.media.session.MediaSessionCompatApi21$CallbackProxy {
        public CallbackProxy(Callback arg1) {
            super(((android.support.v4.media.session.MediaSessionCompatApi21$Callback)arg1));
        }

        public void onPlayFromUri(Uri arg2, Bundle arg3) {
            this.mCallback.onPlayFromUri(arg2, arg3);
        }
    }

    MediaSessionCompatApi23() {
        super();
    }

    public static Object createCallback(Callback arg1) {
        return new CallbackProxy(arg1);
    }
}

