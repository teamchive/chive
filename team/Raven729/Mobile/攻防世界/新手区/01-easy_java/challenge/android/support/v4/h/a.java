package android.support.v4.h;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public abstract class a implements Parcelable {
    final class android.support.v4.h.a$1 extends a {
        android.support.v4.h.a$1() {
            super(null);
        }
    }

    final class android.support.v4.h.a$2 implements Parcelable$ClassLoaderCreator {
        android.support.v4.h.a$2() {
            super();
        }

        public a a(Parcel arg2) {
            return this.a(arg2, null);
        }

        public a a(Parcel arg3, ClassLoader arg4) {
            if(arg3.readParcelable(arg4) != null) {
                throw new IllegalStateException("superState must be null");
            }

            return a.a;
        }

        public a[] a(int arg2) {
            return new a[arg2];
        }

        public Object createFromParcel(Parcel arg2) {
            return this.a(arg2);
        }

        public Object createFromParcel(Parcel arg2, ClassLoader arg3) {
            return this.a(arg2, arg3);
        }

        public Object[] newArray(int arg2) {
            return this.a(arg2);
        }
    }

    public static final Parcelable$Creator CREATOR;
    public static final a a;
    private final Parcelable b;

    static {
        a.a = new android.support.v4.h.a$1();
        a.CREATOR = new android.support.v4.h.a$2();
    }

    private a() {
        super();
        this.b = null;
    }

    protected a(Parcel arg2, ClassLoader arg3) {
        super();
        Parcelable v0 = arg2.readParcelable(arg3);
        if(v0 == null) {
            a v0_1 = a.a;
        }

        this.b = v0;
    }

    protected a(Parcelable arg3) {
        super();
        if(arg3 == null) {
            throw new IllegalArgumentException("superState must not be null");
        }

        if(arg3 == a.a) {
            arg3 = null;
        }

        this.b = arg3;
    }

    a(android.support.v4.h.a$1 arg1) {
        this();
    }

    public final Parcelable a() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        arg2.writeParcelable(this.b, arg3);
    }
}

