package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.media.session.MediaController$TransportControls;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(value=24) @RequiresApi(value=24) class MediaControllerCompatApi24 {
    public class TransportControls extends android.support.v4.media.session.MediaControllerCompatApi23$TransportControls {
        public TransportControls() {
            super();
        }

        public static void prepare(Object arg0) {
            ((MediaController$TransportControls)arg0).prepare();
        }

        public static void prepareFromMediaId(Object arg0, String arg1, Bundle arg2) {
            ((MediaController$TransportControls)arg0).prepareFromMediaId(arg1, arg2);
        }

        public static void prepareFromSearch(Object arg0, String arg1, Bundle arg2) {
            ((MediaController$TransportControls)arg0).prepareFromSearch(arg1, arg2);
        }

        public static void prepareFromUri(Object arg0, Uri arg1, Bundle arg2) {
            ((MediaController$TransportControls)arg0).prepareFromUri(arg1, arg2);
        }
    }

    MediaControllerCompatApi24() {
        super();
    }
}

