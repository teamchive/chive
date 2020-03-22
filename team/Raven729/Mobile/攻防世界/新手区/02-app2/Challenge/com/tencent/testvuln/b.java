package com.tencent.testvuln;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface b extends IInterface {
    public abstract class a extends Binder implements b {
        public a() {
            super();
            this.attachInterface(((IInterface)this), "com.tencent.testvuln.IRemoteService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int arg4, Parcel arg5, Parcel arg6, int arg7) {
            boolean v0 = true;
            switch(arg4) {
                case 1: {
                    arg5.enforceInterface("com.tencent.testvuln.IRemoteService");
                    String v1 = this.a(arg5.readString(), arg5.readInt());
                    arg6.writeNoException();
                    arg6.writeString(v1);
                    break;
                }
                case 1598968902: {
                    arg6.writeString("com.tencent.testvuln.IRemoteService");
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

    String a(String arg1, int arg2);
}

