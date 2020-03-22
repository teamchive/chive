package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class d implements Parcelable {
    final class android.support.v4.a.d$1 implements Parcelable$Creator {
        android.support.v4.a.d$1() {
            super();
        }

        public d a(Parcel arg2) {
            return new d(arg2);
        }

        public d[] a(int arg2) {
            return new d[arg2];
        }

        public Object createFromParcel(Parcel arg2) {
            return this.a(arg2);
        }

        public Object[] newArray(int arg2) {
            return this.a(arg2);
        }
    }

    public static final Parcelable$Creator CREATOR;
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList j;
    final ArrayList k;
    final boolean l;

    static {
        d.CREATOR = new android.support.v4.a.d$1();
    }

    public d(Parcel arg2) {
        super();
        this.a = arg2.createIntArray();
        this.b = arg2.readInt();
        this.c = arg2.readInt();
        this.d = arg2.readString();
        this.e = arg2.readInt();
        this.f = arg2.readInt();
        this.g = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg2);
        this.h = arg2.readInt();
        this.i = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg2);
        this.j = arg2.createStringArrayList();
        this.k = arg2.createStringArrayList();
        boolean v0 = arg2.readInt() != 0 ? true : false;
        this.l = v0;
    }

    public d(c arg8) {
        super();
        int v3 = arg8.c.size();
        this.a = new int[v3 * 6];
        if(!arg8.j) {
            throw new IllegalStateException("Not on back stack");
        }

        int v2 = 0;
        int v1 = 0;
        while(v2 < v3) {
            Object v0 = arg8.c.get(v2);
            int v5 = v1 + 1;
            this.a[v1] = ((a)v0).a;
            int[] v4 = this.a;
            int v6 = v5 + 1;
            v1 = ((a)v0).b != null ? ((a)v0).b.e : -1;
            v4[v5] = v1;
            int v4_1 = v6 + 1;
            this.a[v6] = ((a)v0).c;
            v5 = v4_1 + 1;
            this.a[v4_1] = ((a)v0).d;
            v4_1 = v5 + 1;
            this.a[v5] = ((a)v0).e;
            v1 = v4_1 + 1;
            this.a[v4_1] = ((a)v0).f;
            ++v2;
        }

        this.b = arg8.h;
        this.c = arg8.i;
        this.d = arg8.l;
        this.e = arg8.n;
        this.f = arg8.o;
        this.g = arg8.p;
        this.h = arg8.q;
        this.i = arg8.r;
        this.j = arg8.s;
        this.k = arg8.t;
        this.l = arg8.u;
    }

    public c a(n arg9) {
        int v0 = 0;
        c v3 = new c(arg9);
        int v1 = 0;
        while(v0 < this.a.length) {
            a v4 = new a();
            int v5 = v0 + 1;
            v4.a = this.a[v0];
            if(n.a) {
                Log.v("FragmentManager", "Instantiate " + v3 + " op #" + v1 + " base fragment #" + this.a[v5]);
            }

            int v2 = v5 + 1;
            v0 = this.a[v5];
            v4.b = v0 >= 0 ? arg9.f.get(v0) : null;
            v5 = v2 + 1;
            v4.c = this.a[v2];
            v2 = v5 + 1;
            v4.d = this.a[v5];
            v5 = v2 + 1;
            v4.e = this.a[v2];
            v4.f = this.a[v5];
            v3.d = v4.c;
            v3.e = v4.d;
            v3.f = v4.e;
            v3.g = v4.f;
            v3.a(v4);
            ++v1;
            v0 = v5 + 1;
        }

        v3.h = this.b;
        v3.i = this.c;
        v3.l = this.d;
        v3.n = this.e;
        v3.j = true;
        v3.o = this.f;
        v3.p = this.g;
        v3.q = this.h;
        v3.r = this.i;
        v3.s = this.j;
        v3.t = this.k;
        v3.u = this.l;
        v3.a(1);
        return v3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg3, int arg4) {
        int v0 = 0;
        arg3.writeIntArray(this.a);
        arg3.writeInt(this.b);
        arg3.writeInt(this.c);
        arg3.writeString(this.d);
        arg3.writeInt(this.e);
        arg3.writeInt(this.f);
        TextUtils.writeToParcel(this.g, arg3, 0);
        arg3.writeInt(this.h);
        TextUtils.writeToParcel(this.i, arg3, 0);
        arg3.writeStringList(this.j);
        arg3.writeStringList(this.k);
        if(this.l) {
            v0 = 1;
        }

        arg3.writeInt(v0);
    }
}

