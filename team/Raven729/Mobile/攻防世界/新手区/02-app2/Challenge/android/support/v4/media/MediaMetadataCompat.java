package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Set;

public final class MediaMetadataCompat implements Parcelable {
    final class android.support.v4.media.MediaMetadataCompat$1 implements Parcelable$Creator {
        android.support.v4.media.MediaMetadataCompat$1() {
            super();
        }

        public MediaMetadataCompat createFromParcel(Parcel arg2) {
            return new MediaMetadataCompat(arg2);
        }

        public Object createFromParcel(Parcel arg2) {
            return this.createFromParcel(arg2);
        }

        public MediaMetadataCompat[] newArray(int arg2) {
            return new MediaMetadataCompat[arg2];
        }

        public Object[] newArray(int arg2) {
            return this.newArray(arg2);
        }
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface BitmapKey {
    }

    public final class Builder {
        private final Bundle mBundle;

        public Builder() {
            super();
            this.mBundle = new Bundle();
        }

        public Builder(MediaMetadataCompat arg3) {
            super();
            this.mBundle = new Bundle(arg3.mBundle);
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) public Builder(MediaMetadataCompat arg6, int arg7) {
            this(arg6);
            Iterator v2 = this.mBundle.keySet().iterator();
            while(v2.hasNext()) {
                Object v0 = v2.next();
                Object v1 = this.mBundle.get(((String)v0));
                if(v1 == null) {
                    continue;
                }

                if(!(v1 instanceof Bitmap)) {
                    continue;
                }

                if(((Bitmap)v1).getHeight() <= arg7 && ((Bitmap)v1).getWidth() <= arg7) {
                    if(Build$VERSION.SDK_INT < 14) {
                        continue;
                    }

                    if(!((String)v0).equals("android.media.metadata.ART") && !((String)v0).equals("android.media.metadata.ALBUM_ART")) {
                        continue;
                    }

                    this.putBitmap(((String)v0), ((Bitmap)v1).copy(((Bitmap)v1).getConfig(), false));
                    continue;
                }

                this.putBitmap(((String)v0), this.scaleBitmap(((Bitmap)v1), arg7));
            }
        }

        public MediaMetadataCompat build() {
            return new MediaMetadataCompat(this.mBundle);
        }

        public Builder putBitmap(String arg4, Bitmap arg5) {
            if((MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(arg4)) && MediaMetadataCompat.METADATA_KEYS_TYPE.get(arg4).intValue() != 2) {
                throw new IllegalArgumentException("The " + arg4 + " key cannot be used to put a Bitmap");
            }

            this.mBundle.putParcelable(arg4, ((Parcelable)arg5));
            return this;
        }

        public Builder putLong(String arg5, long arg6) {
            if((MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(arg5)) && MediaMetadataCompat.METADATA_KEYS_TYPE.get(arg5).intValue() != 0) {
                throw new IllegalArgumentException("The " + arg5 + " key cannot be used to put a long");
            }

            this.mBundle.putLong(arg5, arg6);
            return this;
        }

        public Builder putRating(String arg4, RatingCompat arg5) {
            if((MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(arg4)) && MediaMetadataCompat.METADATA_KEYS_TYPE.get(arg4).intValue() != 3) {
                throw new IllegalArgumentException("The " + arg4 + " key cannot be used to put a Rating");
            }

            if(Build$VERSION.SDK_INT >= 19) {
                this.mBundle.putParcelable(arg4, arg5.getRating());
            }
            else {
                this.mBundle.putParcelable(arg4, ((Parcelable)arg5));
            }

            return this;
        }

        public Builder putString(String arg4, String arg5) {
            if((MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(arg4)) && MediaMetadataCompat.METADATA_KEYS_TYPE.get(arg4).intValue() != 1) {
                throw new IllegalArgumentException("The " + arg4 + " key cannot be used to put a String");
            }

            this.mBundle.putCharSequence(arg4, ((CharSequence)arg5));
            return this;
        }

        public Builder putText(String arg4, CharSequence arg5) {
            if((MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(arg4)) && MediaMetadataCompat.METADATA_KEYS_TYPE.get(arg4).intValue() != 1) {
                throw new IllegalArgumentException("The " + arg4 + " key cannot be used to put a CharSequence");
            }

            this.mBundle.putCharSequence(arg4, arg5);
            return this;
        }

        private Bitmap scaleBitmap(Bitmap arg4, int arg5) {
            float v0 = ((float)arg5);
            v0 = Math.min(v0 / (((float)arg4.getWidth())), v0 / (((float)arg4.getHeight())));
            return Bitmap.createScaledBitmap(arg4, ((int)(v0 * (((float)arg4.getWidth())))), ((int)((((float)arg4.getHeight())) * v0)), true);
        }
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface LongKey {
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface RatingKey {
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface TextKey {
    }

    public static final Parcelable$Creator CREATOR = null;
    static final ArrayMap METADATA_KEYS_TYPE = null;
    public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    static final int METADATA_TYPE_BITMAP = 2;
    static final int METADATA_TYPE_LONG = 0;
    static final int METADATA_TYPE_RATING = 3;
    static final int METADATA_TYPE_TEXT = 1;
    private static final String[] PREFERRED_BITMAP_ORDER = null;
    private static final String[] PREFERRED_DESCRIPTION_ORDER = null;
    private static final String[] PREFERRED_URI_ORDER = null;
    private static final String TAG = "MediaMetadata";
    final Bundle mBundle;
    private MediaDescriptionCompat mDescription;
    private Object mMetadataObj;

    static {
        MediaMetadataCompat.METADATA_KEYS_TYPE = new ArrayMap();
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.TITLE", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DURATION", Integer.valueOf(0));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.WRITER", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DATE", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.YEAR", Integer.valueOf(0));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.GENRE", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ART", Integer.valueOf(2));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.RATING", Integer.valueOf(3));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.BT_FOLDER_TYPE", Integer.valueOf(0));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_URI", Integer.valueOf(1));
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ADVERTISEMENT", Integer.valueOf(0));
        MediaMetadataCompat.PREFERRED_DESCRIPTION_ORDER = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        MediaMetadataCompat.PREFERRED_BITMAP_ORDER = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
        MediaMetadataCompat.PREFERRED_URI_ORDER = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
        MediaMetadataCompat.CREATOR = new android.support.v4.media.MediaMetadataCompat$1();
    }

    MediaMetadataCompat(Bundle arg2) {
        super();
        this.mBundle = new Bundle(arg2);
    }

    MediaMetadataCompat(Parcel arg2) {
        super();
        this.mBundle = arg2.readBundle();
    }

    public boolean containsKey(String arg2) {
        return this.mBundle.containsKey(arg2);
    }

    public int describeContents() {
        return 0;
    }

    public static MediaMetadataCompat fromMediaMetadata(Object arg3) {
        Object v0;
        if(arg3 == null || Build$VERSION.SDK_INT < 21) {
            MediaMetadataCompat v0_1 = null;
        }
        else {
            Parcel v1 = Parcel.obtain();
            MediaMetadataCompatApi21.writeToParcel(arg3, v1, 0);
            v1.setDataPosition(0);
            v0 = MediaMetadataCompat.CREATOR.createFromParcel(v1);
            v1.recycle();
            ((MediaMetadataCompat)v0).mMetadataObj = arg3;
        }

        return ((MediaMetadataCompat)v0);
    }

    public Bitmap getBitmap(String arg5) {
        Parcelable v0_1;
        Bitmap v1 = null;
        try {
            v0_1 = this.mBundle.getParcelable(arg5);
        }
        catch(Exception v0) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", ((Throwable)v0));
            Bitmap v0_2 = v1;
        }

        return ((Bitmap)v0_1);
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public MediaDescriptionCompat getDescription() {
        Uri v2_2;
        String v3_1;
        Bitmap v0_3;
        int v2;
        int v0_2;
        MediaDescriptionCompat v0;
        int v9 = 2;
        Uri v4 = null;
        if(this.mDescription != null) {
            v0 = this.mDescription;
        }
        else {
            String v5 = this.getString("android.media.metadata.MEDIA_ID");
            CharSequence[] v6 = new CharSequence[3];
            CharSequence v0_1 = this.getText("android.media.metadata.DISPLAY_TITLE");
            if(!TextUtils.isEmpty(v0_1)) {
                v6[0] = v0_1;
                v6[1] = this.getText("android.media.metadata.DISPLAY_SUBTITLE");
                v6[v9] = this.getText("android.media.metadata.DISPLAY_DESCRIPTION");
            }
            else {
                v0_2 = 0;
                int v3 = 0;
                while(v3 < v6.length) {
                    if(v0_2 >= MediaMetadataCompat.PREFERRED_DESCRIPTION_ORDER.length) {
                        break;
                    }

                    v2 = v0_2 + 1;
                    CharSequence v7 = this.getText(MediaMetadataCompat.PREFERRED_DESCRIPTION_ORDER[v0_2]);
                    if(!TextUtils.isEmpty(v7)) {
                        v0_2 = v3 + 1;
                        v6[v3] = v7;
                    }
                    else {
                        v0_2 = v3;
                    }

                    v3 = v0_2;
                    v0_2 = v2;
                }
            }

            v0_2 = 0;
            while(true) {
                if(v0_2 < MediaMetadataCompat.PREFERRED_BITMAP_ORDER.length) {
                    Bitmap v2_1 = this.getBitmap(MediaMetadataCompat.PREFERRED_BITMAP_ORDER[v0_2]);
                    if(v2_1 != null) {
                        v0_3 = v2_1;
                    }
                    else {
                        ++v0_2;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_32;
            }

            v0_3 = ((Bitmap)v4);
        label_32:
            v2 = 0;
            while(true) {
                if(v2 < MediaMetadataCompat.PREFERRED_URI_ORDER.length) {
                    v3_1 = this.getString(MediaMetadataCompat.PREFERRED_URI_ORDER[v2]);
                    if(!TextUtils.isEmpty(((CharSequence)v3_1))) {
                        v2_2 = Uri.parse(v3_1);
                    }
                    else {
                        ++v2;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_42;
            }

            v2_2 = v4;
        label_42:
            v3_1 = this.getString("android.media.metadata.MEDIA_URI");
            if(!TextUtils.isEmpty(((CharSequence)v3_1))) {
                v4 = Uri.parse(v3_1);
            }

            android.support.v4.media.MediaDescriptionCompat$Builder v3_2 = new android.support.v4.media.MediaDescriptionCompat$Builder();
            v3_2.setMediaId(v5);
            v3_2.setTitle(v6[0]);
            v3_2.setSubtitle(v6[1]);
            v3_2.setDescription(v6[v9]);
            v3_2.setIconBitmap(v0_3);
            v3_2.setIconUri(v2_2);
            v3_2.setMediaUri(v4);
            if(this.mBundle.containsKey("android.media.metadata.BT_FOLDER_TYPE")) {
                Bundle v0_4 = new Bundle();
                v0_4.putLong("android.media.extra.BT_FOLDER_TYPE", this.getLong("android.media.metadata.BT_FOLDER_TYPE"));
                v3_2.setExtras(v0_4);
            }

            this.mDescription = v3_2.build();
            v0 = this.mDescription;
        }

        return v0;
    }

    public long getLong(String arg5) {
        return this.mBundle.getLong(arg5, 0);
    }

    public Object getMediaMetadata() {
        Object v0_1;
        if(this.mMetadataObj != null || Build$VERSION.SDK_INT < 21) {
            v0_1 = this.mMetadataObj;
        }
        else {
            Parcel v0 = Parcel.obtain();
            this.writeToParcel(v0, 0);
            v0.setDataPosition(0);
            this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel(v0);
            v0.recycle();
            v0_1 = this.mMetadataObj;
        }

        return v0_1;
    }

    public RatingCompat getRating(String arg5) {
        RatingCompat v0_1;
        RatingCompat v1 = null;
        try {
            if(Build$VERSION.SDK_INT >= 19) {
                v0_1 = RatingCompat.fromRating(this.mBundle.getParcelable(arg5));
                return v0_1;
            }

            Parcelable v0_2 = this.mBundle.getParcelable(arg5);
        }
        catch(Exception v0) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", ((Throwable)v0));
            v0_1 = v1;
        }

        return v0_1;
    }

    public String getString(String arg2) {
        CharSequence v0 = this.mBundle.getCharSequence(arg2);
        String v0_1 = v0 != null ? v0.toString() : null;
        return v0_1;
    }

    public CharSequence getText(String arg2) {
        return this.mBundle.getCharSequence(arg2);
    }

    public Set keySet() {
        return this.mBundle.keySet();
    }

    public int size() {
        return this.mBundle.size();
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        arg2.writeBundle(this.mBundle);
    }
}

