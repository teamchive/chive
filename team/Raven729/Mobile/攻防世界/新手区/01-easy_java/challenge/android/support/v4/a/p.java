package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class p implements Parcelable {
    final class android.support.v4.a.p$1 implements Parcelable$Creator {
        android.support.v4.a.p$1() {
            super();
        }

        public p a(Parcel arg2) {
            return new p(arg2);
        }

        public p[] a(int arg2) {
            return new p[arg2];
        }

        public Object createFromParcel(Parcel arg2) {
            return this.a(arg2);
        }

        public Object[] newArray(int arg2) {
            return this.a(arg2);
        }
    }

    public static final Parcelable$Creator CREATOR;
    q[] a;
    int[] b;
    d[] c;
    int d;
    int e;

    static {
        p.CREATOR = new android.support.v4.a.p$1();
    }

    public p() {
        super();
        this.d = -1;
    }

    public p(Parcel arg2) {
        super();
        this.d = -1;
        this.a = arg2.createTypedArray(q.CREATOR);
        this.b = arg2.createIntArray();
        this.c = arg2.createTypedArray(d.CREATOR);
        this.d = arg2.readInt();
        this.e = arg2.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        arg2.writeTypedArray(this.a, arg3);
        arg2.writeIntArray(this.b);
        arg2.writeTypedArray(this.c, arg3);
        arg2.writeInt(this.d);
        arg2.writeInt(this.e);
    }
}

