package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.media.session.MediaController$TransportControls;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(value=23) @RequiresApi(value=23) class MediaControllerCompatApi23 {
    public class TransportControls extends android.support.v4.media.session.MediaControllerCompatApi21$TransportControls {
        public TransportControls() {
            super();
        }

        public static void playFromUri(Object arg0, Uri arg1, Bundle arg2) {
            ((MediaController$TransportControls)arg0).playFromUri(arg1, arg2);
        }
    }

    MediaControllerCompatApi23() {
        super();
    }
}

