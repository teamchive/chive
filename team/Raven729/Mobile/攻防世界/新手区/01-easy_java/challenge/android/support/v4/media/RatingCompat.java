package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class RatingCompat implements Parcelable {
    final class android.support.v4.media.RatingCompat$1 implements Parcelable$Creator {
        android.support.v4.media.RatingCompat$1() {
            super();
        }

        public RatingCompat a(Parcel arg4) {
            return new RatingCompat(arg4.readInt(), arg4.readFloat());
        }

        public RatingCompat[] a(int arg2) {
            return new RatingCompat[arg2];
        }

        public Object createFromParcel(Parcel arg2) {
            return this.a(arg2);
        }

        public Object[] newArray(int arg2) {
            return this.a(arg2);
        }
    }

    public static final Parcelable$Creator CREATOR;
    private final int a;
    private final float b;

    static {
        RatingCompat.CREATOR = new android.support.v4.media.RatingCompat$1();
    }

    RatingCompat(int arg1, float arg2) {
        super();
        this.a = arg1;
        this.b = arg2;
    }

    public int describeContents() {
        return this.a;
    }

    public String toString() {
        StringBuilder v1 = new StringBuilder().append("Rating:style=").append(this.a).append(" rating=");
        String v0 = this.b < 0f ? "unrated" : String.valueOf(this.b);
        return v1.append(v0).toString();
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        arg2.writeInt(this.a);
        arg2.writeFloat(this.b);
    }
}

