package android.support.v4.e;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface a extends IInterface {
    public abstract class android.support.v4.e.a$a extends Binder implements a {
        class android.support.v4.e.a$a$a implements a {
            private IBinder a;

            android.support.v4.e.a$a$a(IBinder arg1) {
                super();
                this.a = arg1;
            }

            public void a(int arg6, Bundle arg7) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.os.IResultReceiver");
                    v1.writeInt(arg6);
                    if(arg7 != null) {
                        v1.writeInt(1);
                        arg7.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.a.transact(1, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public IBinder asBinder() {
                return this.a;
            }
        }

        public android.support.v4.e.a$a() {
            super();
            this.attachInterface(((IInterface)this), "android.support.v4.os.IResultReceiver");
        }

        public static a a(IBinder arg2) {
            android.support.v4.e.a$a$a v0_2;
            if(arg2 == null) {
                a v0 = null;
            }
            else {
                IInterface v0_1 = arg2.queryLocalInterface("android.support.v4.os.IResultReceiver");
                if(v0_1 != null && ((v0_1 instanceof a))) {
                    goto label_2;
                }

                v0_2 = new android.support.v4.e.a$a$a(arg2);
            }

        label_2:
            return ((a)v0_2);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int arg4, Parcel arg5, Parcel arg6, int arg7) {
            boolean v0;
            Object v0_1;
            switch(arg4) {
                case 1: {
                    arg5.enforceInterface("android.support.v4.os.IResultReceiver");
                    int v2 = arg5.readInt();
                    if(arg5.readInt() != 0) {
                        v0_1 = Bundle.CREATOR.createFromParcel(arg5);
                    }
                    else {
                        Bundle v0_2 = null;
                    }

                    this.a(v2, ((Bundle)v0_1));
                    v0 = true;
                    break;
                }
                case 1598968902: {
                    arg6.writeString("android.support.v4.os.IResultReceiver");
                    v0 = true;
                    break;
                }
                default: {
                    v0 = super.onTransact(arg4, arg5, arg6, arg7);
                    break;
                }
            }

            return v0;
        }
    }

    void a(int arg1, Bundle arg2);
}

