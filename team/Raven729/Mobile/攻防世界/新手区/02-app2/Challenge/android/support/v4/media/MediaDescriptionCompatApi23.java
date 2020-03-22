package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.MediaDescription$Builder;
import android.media.MediaDescription;
import android.net.Uri;
import android.support.annotation.RequiresApi;

@TargetApi(value=23) @RequiresApi(value=23) class MediaDescriptionCompatApi23 extends MediaDescriptionCompatApi21 {
    class Builder extends android.support.v4.media.MediaDescriptionCompatApi21$Builder {
        Builder() {
            super();
        }

        public static void setMediaUri(Object arg0, Uri arg1) {
            ((MediaDescription$Builder)arg0).setMediaUri(arg1);
        }
    }

    MediaDescriptionCompatApi23() {
        super();
    }

    public static Uri getMediaUri(Object arg1) {
        return ((MediaDescription)arg1).getMediaUri();
    }
}

