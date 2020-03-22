package android.support.v4.media;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.v4.g.a;

public final class MediaMetadataCompat implements Parcelable {
    final class android.support.v4.media.MediaMetadataCompat$1 implements Parcelable$Creator {
        android.support.v4.media.MediaMetadataCompat$1() {
            super();
        }

        public MediaMetadataCompat a(Parcel arg2) {
            return new MediaMetadataCompat(arg2);
        }

        public MediaMetadataCompat[] a(int arg2) {
            return new MediaMetadataCompat[arg2];
        }

        public Object createFromParcel(Parcel arg2) {
            return this.a(arg2);
        }

        public Object[] newArray(int arg2) {
            return this.a(arg2);
        }
    }

    public static final Parcelable$Creator CREATOR;
    static final a a;
    final Bundle b;
    private static final String[] c;
    private static final String[] d;
    private static final String[] e;
    private Object f;

    static {
        MediaMetadataCompat.a = new a();
        MediaMetadataCompat.a.put("android.media.metadata.TITLE", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.DURATION", Integer.valueOf(0));
        MediaMetadataCompat.a.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.WRITER", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.DATE", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.YEAR", Integer.valueOf(0));
        MediaMetadataCompat.a.put("android.media.metadata.GENRE", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        MediaMetadataCompat.a.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        MediaMetadataCompat.a.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        MediaMetadataCompat.a.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.ART", Integer.valueOf(2));
        MediaMetadataCompat.a.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        MediaMetadataCompat.a.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        MediaMetadataCompat.a.put("android.media.metadata.RATING", Integer.valueOf(3));
        MediaMetadataCompat.a.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        MediaMetadataCompat.a.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.BT_FOLDER_TYPE", Integer.valueOf(0));
        MediaMetadataCompat.a.put("android.media.metadata.MEDIA_URI", Integer.valueOf(1));
        MediaMetadataCompat.a.put("android.media.metadata.ADVERTISEMENT", Integer.valueOf(0));
        MediaMetadataCompat.a.put("android.media.metadata.DOWNLOAD_STATUS", Integer.valueOf(0));
        MediaMetadataCompat.c = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        MediaMetadataCompat.d = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
        MediaMetadataCompat.e = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
        MediaMetadataCompat.CREATOR = new android.support.v4.media.MediaMetadataCompat$1();
    }

    MediaMetadataCompat(Parcel arg2) {
        super();
        this.b = arg2.readBundle();
    }

    public static MediaMetadataCompat a(Object arg3) {
        Object v0;
        if(arg3 == null || Build$VERSION.SDK_INT < 21) {
            MediaMetadataCompat v0_1 = null;
        }
        else {
            Parcel v1 = Parcel.obtain();
            c.a(arg3, v1, 0);
            v1.setDataPosition(0);
            v0 = MediaMetadataCompat.CREATOR.createFromParcel(v1);
            v1.recycle();
            ((MediaMetadataCompat)v0).f = arg3;
        }

        return ((MediaMetadataCompat)v0);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        arg2.writeBundle(this.b);
    }
}

