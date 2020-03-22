package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IResultReceiver extends IInterface {
    public abstract class Stub extends Binder implements IResultReceiver {
        class Proxy implements IResultReceiver {
            private IBinder mRemote;

            Proxy(IBinder arg1) {
                super();
                this.mRemote = arg1;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.support.v4.os.IResultReceiver";
            }

            public void send(int arg6, Bundle arg7) {
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

                    this.mRemote.transact(1, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }
        }

        private static final String DESCRIPTOR = "android.support.v4.os.IResultReceiver";
        static final int TRANSACTION_send = 1;

        public Stub() {
            super();
            this.attachInterface(((IInterface)this), "android.support.v4.os.IResultReceiver");
        }

        public IBinder asBinder() {
            return this;
        }

        public static IResultReceiver asInterface(IBinder arg2) {
            IInterface v0_1;
            if(arg2 == null) {
                IResultReceiver v0 = null;
            }
            else {
                v0_1 = arg2.queryLocalInterface("android.support.v4.os.IResultReceiver");
                if(v0_1 != null && ((v0_1 instanceof IResultReceiver))) {
                    goto label_2;
                }

                Proxy v0_2 = new Proxy(arg2);
            }

        label_2:
            return ((IResultReceiver)v0_1);
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

                    this.send(v2, ((Bundle)v0_1));
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

    void send(int arg1, Bundle arg2);
}

