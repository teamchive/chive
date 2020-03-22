package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface INotificationSideChannel extends IInterface {
    public abstract class Stub extends Binder implements INotificationSideChannel {
        class Proxy implements INotificationSideChannel {
            private IBinder mRemote;

            Proxy(IBinder arg1) {
                super();
                this.mRemote = arg1;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void cancel(String arg6, int arg7, String arg8) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    v1.writeString(arg6);
                    v1.writeInt(arg7);
                    v1.writeString(arg8);
                    this.mRemote.transact(2, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void cancelAll(String arg6) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    v1.writeString(arg6);
                    this.mRemote.transact(3, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public String getInterfaceDescriptor() {
                return "android.support.v4.app.INotificationSideChannel";
            }

            public void notify(String arg6, int arg7, String arg8, Notification arg9) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    v1.writeString(arg6);
                    v1.writeInt(arg7);
                    v1.writeString(arg8);
                    if(arg9 != null) {
                        v1.writeInt(1);
                        arg9.writeToParcel(v1, 0);
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

        private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_notify = 1;

        public Stub() {
            super();
            this.attachInterface(((IInterface)this), "android.support.v4.app.INotificationSideChannel");
        }

        public IBinder asBinder() {
            return this;
        }

        public static INotificationSideChannel asInterface(IBinder arg2) {
            INotificationSideChannel v0;
            if(arg2 == null) {
                v0 = null;
            }
            else {
                IInterface v0_1 = arg2.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
                if(v0_1 != null && ((v0_1 instanceof INotificationSideChannel))) {
                    return v0;
                }

                Proxy v0_2 = new Proxy(arg2);
            }

            return v0;
        }

        public boolean onTransact(int arg6, Parcel arg7, Parcel arg8, int arg9) {
            boolean v0;
            Notification v0_2;
            switch(arg6) {
                case 1: {
                    arg7.enforceInterface("android.support.v4.app.INotificationSideChannel");
                    String v2 = arg7.readString();
                    int v3 = arg7.readInt();
                    String v4 = arg7.readString();
                    if(arg7.readInt() != 0) {
                        Object v0_1 = Notification.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_2 = null;
                    }

                    this.notify(v2, v3, v4, v0_2);
                    v0 = true;
                    break;
                }
                case 2: {
                    arg7.enforceInterface("android.support.v4.app.INotificationSideChannel");
                    this.cancel(arg7.readString(), arg7.readInt(), arg7.readString());
                    v0 = true;
                    break;
                }
                case 3: {
                    arg7.enforceInterface("android.support.v4.app.INotificationSideChannel");
                    this.cancelAll(arg7.readString());
                    v0 = true;
                    break;
                }
                case 1598968902: {
                    arg8.writeString("android.support.v4.app.INotificationSideChannel");
                    v0 = true;
                    break;
                }
                default: {
                    v0 = super.onTransact(arg6, arg7, arg8, arg9);
                    break;
                }
            }

            return v0;
        }
    }

    void cancel(String arg1, int arg2, String arg3);

    void cancelAll(String arg1);

    void notify(String arg1, int arg2, String arg3, Notification arg4);
}

