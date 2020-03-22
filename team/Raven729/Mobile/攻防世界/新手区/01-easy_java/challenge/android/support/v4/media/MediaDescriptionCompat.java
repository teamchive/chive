package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    final class android.support.v4.media.MediaDescriptionCompat$1 implements Parcelable$Creator {
        android.support.v4.media.MediaDescriptionCompat$1() {
            super();
        }

        public MediaDescriptionCompat a(Parcel arg3) {
            MediaDescriptionCompat v0 = Build$VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(arg3) : MediaDescriptionCompat.a(a.a(arg3));
            return v0;
        }

        public MediaDescriptionCompat[] a(int arg2) {
            return new MediaDescriptionCompat[arg2];
        }

        public Object createFromParcel(Parcel arg2) {
            return this.a(arg2);
        }

        public Object[] newArray(int arg2) {
            return this.a(arg2);
        }
    }

    public final class android.support.v4.media.MediaDescriptionCompat$a {
        private String a;
        private CharSequence b;
        private CharSequence c;
        private CharSequence d;
        private Bitmap e;
        private Uri f;
        private Bundle g;
        private Uri h;

        public android.support.v4.media.MediaDescriptionCompat$a() {
            super();
        }

        public android.support.v4.media.MediaDescriptionCompat$a a(String arg1) {
            this.a = arg1;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat$a a(CharSequence arg1) {
            this.b = arg1;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat$a a(Bitmap arg1) {
            this.e = arg1;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat$a a(Uri arg1) {
            this.f = arg1;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat$a a(Bundle arg1) {
            this.g = arg1;
            return this;
        }

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public android.support.v4.media.MediaDescriptionCompat$a b(CharSequence arg1) {
            this.c = arg1;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat$a b(Uri arg1) {
            this.h = arg1;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat$a c(CharSequence arg1) {
            this.d = arg1;
            return this;
        }
    }

    public static final Parcelable$Creator CREATOR;
    private final String a;
    private final CharSequence b;
    private final CharSequence c;
    private final CharSequence d;
    private final Bitmap e;
    private final Uri f;
    private final Bundle g;
    private final Uri h;
    private Object i;

    static {
        MediaDescriptionCompat.CREATOR = new android.support.v4.media.MediaDescriptionCompat$1();
    }

    MediaDescriptionCompat(Parcel arg3) {
        super();
        this.a = arg3.readString();
        this.b = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg3);
        this.c = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg3);
        this.d = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg3);
        this.e = arg3.readParcelable(null);
        this.f = arg3.readParcelable(null);
        this.g = arg3.readBundle();
        this.h = arg3.readParcelable(null);
    }

    MediaDescriptionCompat(String arg1, CharSequence arg2, CharSequence arg3, CharSequence arg4, Bitmap arg5, Uri arg6, Bundle arg7, Uri arg8) {
        super();
        this.a = arg1;
        this.b = arg2;
        this.c = arg3;
        this.d = arg4;
        this.e = arg5;
        this.f = arg6;
        this.g = arg7;
        this.h = arg8;
    }

    public static MediaDescriptionCompat a(Object arg6) {
        Bundle v0;
        MediaDescriptionCompat v1 = null;
        if(arg6 != null && Build$VERSION.SDK_INT >= 21) {
            android.support.v4.media.MediaDescriptionCompat$a v4 = new android.support.v4.media.MediaDescriptionCompat$a();
            v4.a(a.a(arg6));
            v4.a(a.b(arg6));
            v4.b(a.c(arg6));
            v4.c(a.d(arg6));
            v4.a(a.e(arg6));
            v4.a(a.f(arg6));
            Bundle v2 = a.g(arg6);
            Parcelable v3 = v2 == null ? ((Parcelable)v1) : v2.getParcelable("android.support.v4.media.description.MEDIA_URI");
            if(v3 != null) {
                if((v2.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG")) && v2.size() == 2) {
                    v0 = ((Bundle)v1);
                    goto label_30;
                }

                v2.remove("android.support.v4.media.description.MEDIA_URI");
                v2.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                goto label_44;
            }
            else {
            label_44:
                v0 = v2;
            }

        label_30:
            v4.a(v0);
            if(v3 != null) {
                v4.b(((Uri)v3));
            }
            else if(Build$VERSION.SDK_INT >= 23) {
                v4.b(b.h(arg6));
            }

            v1 = v4.a();
            v1.i = arg6;
        }

        return v1;
    }

    public Object a() {
        Object v0_1;
        int v4 = 23;
        if(this.i != null || Build$VERSION.SDK_INT < 21) {
            v0_1 = this.i;
        }
        else {
            Object v1 = android.support.v4.media.a$a.a();
            android.support.v4.media.a$a.a(v1, this.a);
            android.support.v4.media.a$a.a(v1, this.b);
            android.support.v4.media.a$a.b(v1, this.c);
            android.support.v4.media.a$a.c(v1, this.d);
            android.support.v4.media.a$a.a(v1, this.e);
            android.support.v4.media.a$a.a(v1, this.f);
            Bundle v0 = this.g;
            if(Build$VERSION.SDK_INT < v4 && this.h != null) {
                if(v0 == null) {
                    v0 = new Bundle();
                    v0.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }

                v0.putParcelable("android.support.v4.media.description.MEDIA_URI", this.h);
            }

            android.support.v4.media.a$a.a(v1, v0);
            if(Build$VERSION.SDK_INT >= v4) {
                android.support.v4.media.b$a.b(v1, this.h);
            }

            this.i = android.support.v4.media.a$a.a(v1);
            v0_1 = this.i;
        }

        return v0_1;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.b + ", " + this.c + ", " + this.d;
    }

    public void writeToParcel(Parcel arg3, int arg4) {
        if(Build$VERSION.SDK_INT < 21) {
            arg3.writeString(this.a);
            TextUtils.writeToParcel(this.b, arg3, arg4);
            TextUtils.writeToParcel(this.c, arg3, arg4);
            TextUtils.writeToParcel(this.d, arg3, arg4);
            arg3.writeParcelable(this.e, arg4);
            arg3.writeParcelable(this.f, arg4);
            arg3.writeBundle(this.g);
            arg3.writeParcelable(this.h, arg4);
        }
        else {
            a.a(this.a(), arg3, arg4);
        }
    }
}

