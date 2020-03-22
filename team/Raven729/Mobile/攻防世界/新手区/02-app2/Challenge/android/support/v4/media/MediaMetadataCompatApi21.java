package android.support.v4.media;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaMetadata$Builder;
import android.media.MediaMetadata;
import android.media.Rating;
import android.os.Parcel;
import android.support.annotation.RequiresApi;
import java.util.Set;

@TargetApi(value=21) @RequiresApi(value=21) class MediaMetadataCompatApi21 {
    public class Builder {
        public Builder() {
            super();
        }

        public static Object build(Object arg1) {
            return ((MediaMetadata$Builder)arg1).build();
        }

        public static Object newInstance() {
            return new MediaMetadata$Builder();
        }

        public static void putBitmap(Object arg0, String arg1, Bitmap arg2) {
            ((MediaMetadata$Builder)arg0).putBitmap(arg1, arg2);
        }

        public static void putLong(Object arg0, String arg1, long arg2) {
            ((MediaMetadata$Builder)arg0).putLong(arg1, arg2);
        }

        public static void putRating(Object arg0, String arg1, Object arg2) {
            ((MediaMetadata$Builder)arg0).putRating(arg1, ((Rating)arg2));
        }

        public static void putString(Object arg0, String arg1, String arg2) {
            ((MediaMetadata$Builder)arg0).putString(arg1, arg2);
        }

        public static void putText(Object arg0, String arg1, CharSequence arg2) {
            ((MediaMetadata$Builder)arg0).putText(arg1, arg2);
        }
    }

    MediaMetadataCompatApi21() {
        super();
    }

    public static Object createFromParcel(Parcel arg1) {
        return MediaMetadata.CREATOR.createFromParcel(arg1);
    }

    public static Bitmap getBitmap(Object arg1, String arg2) {
        return ((MediaMetadata)arg1).getBitmap(arg2);
    }

    public static long getLong(Object arg2, String arg3) {
        return ((MediaMetadata)arg2).getLong(arg3);
    }

    public static Object getRating(Object arg1, String arg2) {
        return ((MediaMetadata)arg1).getRating(arg2);
    }

    public static CharSequence getText(Object arg1, String arg2) {
        return ((MediaMetadata)arg1).getText(arg2);
    }

    public static Set keySet(Object arg1) {
        return ((MediaMetadata)arg1).keySet();
    }

    public static void writeToParcel(Object arg0, Parcel arg1, int arg2) {
        ((MediaMetadata)arg0).writeToParcel(arg1, arg2);
    }
}

