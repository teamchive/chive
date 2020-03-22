package android.support.v4.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.Log;

final class q implements Parcelable {
    final class android.support.v4.a.q$1 implements Parcelable$Creator {
        android.support.v4.a.q$1() {
            super();
        }

        public q a(Parcel arg2) {
            return new q(arg2);
        }

        public q[] a(int arg2) {
            return new q[arg2];
        }

        public Object createFromParcel(Parcel arg2) {
            return this.a(arg2);
        }

        public Object[] newArray(int arg2) {
            return this.a(arg2);
        }
    }

    public static final Parcelable$Creator CREATOR;
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    h l;

    static {
        q.CREATOR = new android.support.v4.a.q$1();
    }

    public q(h arg2) {
        super();
        this.a = arg2.getClass().getName();
        this.b = arg2.e;
        this.c = arg2.m;
        this.d = arg2.w;
        this.e = arg2.x;
        this.f = arg2.y;
        this.g = arg2.B;
        this.h = arg2.A;
        this.i = arg2.g;
        this.j = arg2.z;
    }

    public q(Parcel arg4) {
        boolean v1 = true;
        super();
        this.a = arg4.readString();
        this.b = arg4.readInt();
        boolean v0 = arg4.readInt() != 0 ? true : false;
        this.c = v0;
        this.d = arg4.readInt();
        this.e = arg4.readInt();
        this.f = arg4.readString();
        v0 = arg4.readInt() != 0 ? true : false;
        this.g = v0;
        v0 = arg4.readInt() != 0 ? true : false;
        this.h = v0;
        this.i = arg4.readBundle();
        if(arg4.readInt() == 0) {
            v1 = false;
        }

        this.j = v1;
        this.k = arg4.readBundle();
    }

    public h a(l arg4, j arg5, h arg6, o arg7) {
        if(this.l == null) {
            Context v0 = arg4.g();
            if(this.i != null) {
                this.i.setClassLoader(v0.getClassLoader());
            }

            this.l = arg5 != null ? arg5.a(v0, this.a, this.i) : h.a(v0, this.a, this.i);
            if(this.k != null) {
                this.k.setClassLoader(v0.getClassLoader());
                this.l.c = this.k;
            }

            this.l.a(this.b, arg6);
            this.l.m = this.c;
            this.l.o = true;
            this.l.w = this.d;
            this.l.x = this.e;
            this.l.y = this.f;
            this.l.B = this.g;
            this.l.A = this.h;
            this.l.z = this.j;
            this.l.r = arg4.d;
            if(!n.a) {
                goto label_62;
            }

            Log.v("FragmentManager", "Instantiated fragment " + this.l);
        }

    label_62:
        this.l.u = arg7;
        return this.l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg4, int arg5) {
        int v1 = 1;
        arg4.writeString(this.a);
        arg4.writeInt(this.b);
        int v0 = this.c ? 1 : 0;
        arg4.writeInt(v0);
        arg4.writeInt(this.d);
        arg4.writeInt(this.e);
        arg4.writeString(this.f);
        v0 = this.g ? 1 : 0;
        arg4.writeInt(v0);
        v0 = this.h ? 1 : 0;
        arg4.writeInt(v0);
        arg4.writeBundle(this.i);
        if(!this.j) {
            v1 = 0;
        }

        arg4.writeInt(v1);
        arg4.writeBundle(this.k);
    }
}

