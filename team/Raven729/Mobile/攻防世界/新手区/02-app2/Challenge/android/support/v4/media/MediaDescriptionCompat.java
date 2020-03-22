package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    final class android.support.v4.media.MediaDescriptionCompat$1 implements Parcelable$Creator {
        android.support.v4.media.MediaDescriptionCompat$1() {
            super();
        }

        public MediaDescriptionCompat createFromParcel(Parcel arg3) {
            MediaDescriptionCompat v0 = Build$VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(arg3) : MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(arg3));
            return v0;
        }

        public Object createFromParcel(Parcel arg2) {
            return this.createFromParcel(arg2);
        }

        public MediaDescriptionCompat[] newArray(int arg2) {
            return new MediaDescriptionCompat[arg2];
        }

        public Object[] newArray(int arg2) {
            return this.newArray(arg2);
        }
    }

    public final class Builder {
        private CharSequence mDescription;
        private Bundle mExtras;
        private Bitmap mIcon;
        private Uri mIconUri;
        private String mMediaId;
        private Uri mMediaUri;
        private CharSequence mSubtitle;
        private CharSequence mTitle;

        public Builder() {
            super();
        }

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
        }

        public Builder setDescription(@Nullable CharSequence arg1) {
            this.mDescription = arg1;
            return this;
        }

        public Builder setExtras(@Nullable Bundle arg1) {
            this.mExtras = arg1;
            return this;
        }

        public Builder setIconBitmap(@Nullable Bitmap arg1) {
            this.mIcon = arg1;
            return this;
        }

        public Builder setIconUri(@Nullable Uri arg1) {
            this.mIconUri = arg1;
            return this;
        }

        public Builder setMediaId(@Nullable String arg1) {
            this.mMediaId = arg1;
            return this;
        }

        public Builder setMediaUri(@Nullable Uri arg1) {
            this.mMediaUri = arg1;
            return this;
        }

        public Builder setSubtitle(@Nullable CharSequence arg1) {
            this.mSubtitle = arg1;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence arg1) {
            this.mTitle = arg1;
            return this;
        }
    }

    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable$Creator CREATOR = null;
    @RestrictTo(value={Scope.LIBRARY_GROUP}) public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    @RestrictTo(value={Scope.LIBRARY_GROUP}) public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    private final CharSequence mDescription;
    private Object mDescriptionObj;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    static {
        MediaDescriptionCompat.CREATOR = new android.support.v4.media.MediaDescriptionCompat$1();
    }

    MediaDescriptionCompat(Parcel arg3) {
        super();
        this.mMediaId = arg3.readString();
        this.mTitle = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg3);
        this.mSubtitle = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg3);
        this.mDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg3);
        this.mIcon = arg3.readParcelable(null);
        this.mIconUri = arg3.readParcelable(null);
        this.mExtras = arg3.readBundle();
        this.mMediaUri = arg3.readParcelable(null);
    }

    MediaDescriptionCompat(String arg1, CharSequence arg2, CharSequence arg3, CharSequence arg4, Bitmap arg5, Uri arg6, Bundle arg7, Uri arg8) {
        super();
        this.mMediaId = arg1;
        this.mTitle = arg2;
        this.mSubtitle = arg3;
        this.mDescription = arg4;
        this.mIcon = arg5;
        this.mIconUri = arg6;
        this.mExtras = arg7;
        this.mMediaUri = arg8;
    }

    public int describeContents() {
        return 0;
    }

    public static MediaDescriptionCompat fromMediaDescription(Object arg6) {
        Bundle v0;
        MediaDescriptionCompat v1 = null;
        if(arg6 != null && Build$VERSION.SDK_INT >= 21) {
            Builder v4 = new Builder();
            v4.setMediaId(MediaDescriptionCompatApi21.getMediaId(arg6));
            v4.setTitle(MediaDescriptionCompatApi21.getTitle(arg6));
            v4.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(arg6));
            v4.setDescription(MediaDescriptionCompatApi21.getDescription(arg6));
            v4.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(arg6));
            v4.setIconUri(MediaDescriptionCompatApi21.getIconUri(arg6));
            Bundle v2 = MediaDescriptionCompatApi21.getExtras(arg6);
            Parcelable v3 = v2 == null ? ((Parcelable)v1) : v2.getParcelable("android.support.v4.media.description.MEDIA_URI");
            if(v3 != null) {
                if((v2.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG")) && v2.size() == 2) {
                    v0 = ((Bundle)v1);
                    goto label_31;
                }

                v2.remove("android.support.v4.media.description.MEDIA_URI");
                v2.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                goto label_45;
            }
            else {
            label_45:
                v0 = v2;
            }

        label_31:
            v4.setExtras(v0);
            if(v3 != null) {
                v4.setMediaUri(((Uri)v3));
            }
            else if(Build$VERSION.SDK_INT >= 23) {
                v4.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(arg6));
            }

            v1 = v4.build();
            v1.mDescriptionObj = arg6;
        }

        return v1;
    }

    @Nullable public CharSequence getDescription() {
        return this.mDescription;
    }

    @Nullable public Bundle getExtras() {
        return this.mExtras;
    }

    @Nullable public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    @Nullable public Uri getIconUri() {
        return this.mIconUri;
    }

    public Object getMediaDescription() {
        Object v0_1;
        int v4 = 23;
        if(this.mDescriptionObj != null || Build$VERSION.SDK_INT < 21) {
            v0_1 = this.mDescriptionObj;
        }
        else {
            Object v1 = android.support.v4.media.MediaDescriptionCompatApi21$Builder.newInstance();
            android.support.v4.media.MediaDescriptionCompatApi21$Builder.setMediaId(v1, this.mMediaId);
            android.support.v4.media.MediaDescriptionCompatApi21$Builder.setTitle(v1, this.mTitle);
            android.support.v4.media.MediaDescriptionCompatApi21$Builder.setSubtitle(v1, this.mSubtitle);
            android.support.v4.media.MediaDescriptionCompatApi21$Builder.setDescription(v1, this.mDescription);
            android.support.v4.media.MediaDescriptionCompatApi21$Builder.setIconBitmap(v1, this.mIcon);
            android.support.v4.media.MediaDescriptionCompatApi21$Builder.setIconUri(v1, this.mIconUri);
            Bundle v0 = this.mExtras;
            if(Build$VERSION.SDK_INT < v4 && this.mMediaUri != null) {
                if(v0 == null) {
                    v0 = new Bundle();
                    v0.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }

                v0.putParcelable("android.support.v4.media.description.MEDIA_URI", this.mMediaUri);
            }

            android.support.v4.media.MediaDescriptionCompatApi21$Builder.setExtras(v1, v0);
            if(Build$VERSION.SDK_INT >= v4) {
                android.support.v4.media.MediaDescriptionCompatApi23$Builder.setMediaUri(v1, this.mMediaUri);
            }

            this.mDescriptionObj = android.support.v4.media.MediaDescriptionCompatApi21$Builder.build(v1);
            v0_1 = this.mDescriptionObj;
        }

        return v0_1;
    }

    @Nullable public String getMediaId() {
        return this.mMediaId;
    }

    @Nullable public Uri getMediaUri() {
        return this.mMediaUri;
    }

    @Nullable public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    @Nullable public CharSequence getTitle() {
        return this.mTitle;
    }

    public String toString() {
        return this.mTitle + ", " + this.mSubtitle + ", " + this.mDescription;
    }

    public void writeToParcel(Parcel arg3, int arg4) {
        if(Build$VERSION.SDK_INT < 21) {
            arg3.writeString(this.mMediaId);
            TextUtils.writeToParcel(this.mTitle, arg3, arg4);
            TextUtils.writeToParcel(this.mSubtitle, arg3, arg4);
            TextUtils.writeToParcel(this.mDescription, arg3, arg4);
            arg3.writeParcelable(this.mIcon, arg4);
            arg3.writeParcelable(this.mIconUri, arg4);
            arg3.writeBundle(this.mExtras);
            arg3.writeParcelable(this.mMediaUri, arg4);
        }
        else {
            MediaDescriptionCompatApi21.writeToParcel(this.getMediaDescription(), arg3, arg4);
        }
    }
}

