package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;

@RestrictTo(value={Scope.LIBRARY_GROUP}) public class ResultReceiver implements Parcelable {
    final class android.support.v4.os.ResultReceiver$1 implements Parcelable$Creator {
        android.support.v4.os.ResultReceiver$1() {
            super();
        }

        public ResultReceiver createFromParcel(Parcel arg2) {
            return new ResultReceiver(arg2);
        }

        public Object createFromParcel(Parcel arg2) {
            return this.createFromParcel(arg2);
        }

        public ResultReceiver[] newArray(int arg2) {
            return new ResultReceiver[arg2];
        }

        public Object[] newArray(int arg2) {
            return this.newArray(arg2);
        }
    }

    class MyResultReceiver extends Stub {
        MyResultReceiver(ResultReceiver arg1) {
            ResultReceiver.this = arg1;
            super();
        }

        public void send(int arg4, Bundle arg5) {
            if(ResultReceiver.this.mHandler != null) {
                ResultReceiver.this.mHandler.post(new MyRunnable(ResultReceiver.this, arg4, arg5));
            }
            else {
                ResultReceiver.this.onReceiveResult(arg4, arg5);
            }
        }
    }

    class MyRunnable implements Runnable {
        final int mResultCode;
        final Bundle mResultData;

        MyRunnable(ResultReceiver arg1, int arg2, Bundle arg3) {
            ResultReceiver.this = arg1;
            super();
            this.mResultCode = arg2;
            this.mResultData = arg3;
        }

        public void run() {
            ResultReceiver.this.onReceiveResult(this.mResultCode, this.mResultData);
        }
    }

    public static final Parcelable$Creator CREATOR;
    final Handler mHandler;
    final boolean mLocal;
    IResultReceiver mReceiver;

    static {
        ResultReceiver.CREATOR = new android.support.v4.os.ResultReceiver$1();
    }

    public ResultReceiver(Handler arg2) {
        super();
        this.mLocal = true;
        this.mHandler = arg2;
    }

    ResultReceiver(Parcel arg2) {
        super();
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = Stub.asInterface(arg2.readStrongBinder());
    }

    public int describeContents() {
        return 0;
    }

    protected void onReceiveResult(int arg1, Bundle arg2) {
    }

    public void send(int arg3, Bundle arg4) {
        if(this.mLocal) {
            if(this.mHandler != null) {
                this.mHandler.post(new MyRunnable(this, arg3, arg4));
                return;
            }

            this.onReceiveResult(arg3, arg4);
            return;
        }

        if(this.mReceiver != null) {
            try {
                this.mReceiver.send(arg3, arg4);
            }
            catch(RemoteException v0) {
            }
        }
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        __monitor_enter(this);
        try {
            if(this.mReceiver == null) {
                this.mReceiver = new MyResultReceiver(this);
            }

            arg2.writeStrongBinder(this.mReceiver.asBinder());
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

