package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable {
    final class android.support.v4.media.session.ParcelableVolumeInfo$1 implements Parcelable$Creator {
        android.support.v4.media.session.ParcelableVolumeInfo$1() {
            super();
        }

        public ParcelableVolumeInfo a(Parcel arg2) {
            return new ParcelableVolumeInfo(arg2);
        }

        public ParcelableVolumeInfo[] a(int arg2) {
            return new ParcelableVolumeInfo[arg2];
        }

        public Object createFromParcel(Parcel arg2) {
            return this.a(arg2);
        }

        public Object[] newArray(int arg2) {
            return this.a(arg2);
        }
    }

    public static final Parcelable$Creator CREATOR;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    static {
        ParcelableVolumeInfo.CREATOR = new android.support.v4.media.session.ParcelableVolumeInfo$1();
    }

    public ParcelableVolumeInfo(Parcel arg2) {
        super();
        this.a = arg2.readInt();
        this.c = arg2.readInt();
        this.d = arg2.readInt();
        this.e = arg2.readInt();
        this.b = arg2.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        arg2.writeInt(this.a);
        arg2.writeInt(this.c);
        arg2.writeInt(this.d);
        arg2.writeInt(this.e);
        arg2.writeInt(this.b);
    }
}

