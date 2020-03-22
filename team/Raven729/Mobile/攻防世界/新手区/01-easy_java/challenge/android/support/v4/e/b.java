package android.support.v4.e;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class b implements Parcelable {
    final class android.support.v4.e.b$1 implements Parcelable$Creator {
        android.support.v4.e.b$1() {
            super();
        }

        public b a(Parcel arg2) {
            return new b(arg2);
        }

        public b[] a(int arg2) {
            return new b[arg2];
        }

        public Object createFromParcel(Parcel arg2) {
            return this.a(arg2);
        }

        public Object[] newArray(int arg2) {
            return this.a(arg2);
        }
    }

    class a extends android.support.v4.e.a$a {
        a(b arg1) {
            this.a = arg1;
            super();
        }

        public void a(int arg4, Bundle arg5) {
            if(this.a.b != null) {
                this.a.b.post(new android.support.v4.e.b$b(this.a, arg4, arg5));
            }
            else {
                this.a.a(arg4, arg5);
            }
        }
    }

    class android.support.v4.e.b$b implements Runnable {
        final int a;
        final Bundle b;

        android.support.v4.e.b$b(b arg1, int arg2, Bundle arg3) {
            this.c = arg1;
            super();
            this.a = arg2;
            this.b = arg3;
        }

        public void run() {
            this.c.a(this.a, this.b);
        }
    }

    public static final Parcelable$Creator CREATOR;
    final boolean a;
    final Handler b;
    android.support.v4.e.a c;

    static {
        b.CREATOR = new android.support.v4.e.b$1();
    }

    b(Parcel arg2) {
        super();
        this.a = false;
        this.b = null;
        this.c = android.support.v4.e.a$a.a(arg2.readStrongBinder());
    }

    protected void a(int arg1, Bundle arg2) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        __monitor_enter(this);
        try {
            if(this.c == null) {
                this.c = new a(this);
            }

            arg2.writeStrongBinder(this.c.asBinder());
            __monitor_exit(this);
            return;
        label_12:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_12;
        }

        throw v0;
    }
}

