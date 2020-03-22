package android.support.v4.media;

import android.media.MediaDescription$Builder;
import android.media.MediaDescription;
import android.net.Uri;

class b extends a {
    class android.support.v4.media.b$a extends android.support.v4.media.a$a {
        public static void b(Object arg0, Uri arg1) {
            ((MediaDescription$Builder)arg0).setMediaUri(arg1);
        }
    }

    public static Uri h(Object arg1) {
        return ((MediaDescription)arg1).getMediaUri();
    }
}

