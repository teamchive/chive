package android.support.v4.os;

import android.os.Build$VERSION;

public final class CancellationSignal {
    public interface OnCancelListener {
        void onCancel();
    }

    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    public CancellationSignal() {
        super();
    }

    public void cancel() {
        Object v1;
        OnCancelListener v0_1;
        __monitor_enter(this);
        try {
            if(this.mIsCanceled) {
                __monitor_exit(this);
            }
            else {
                this.mIsCanceled = true;
                this.mCancelInProgress = true;
                v0_1 = this.mOnCancelListener;
                v1 = this.mCancellationSignalObj;
                __monitor_exit(this);
                if(v0_1 != null) {
                    goto label_13;
                }

                goto label_14;
            }

            return;
        }
        catch(Throwable v0) {
            goto label_26;
        }

        try {
        label_13:
            v0_1.onCancel();
        label_14:
            if(v1 != null) {
                CancellationSignalCompatJellybean.cancel(v1);
            }
        }
        catch(Throwable v0) {
            __monitor_enter(this);
            try {
                this.mCancelInProgress = false;
                this.notifyAll();
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                try {
                label_36:
                    __monitor_exit(this);
                }
                catch(Throwable v0) {
                    goto label_36;
                }

                throw v0;
            }

            throw v0;
        }

        __monitor_enter(this);
        try {
            this.mCancelInProgress = false;
            this.notifyAll();
            __monitor_exit(this);
            return;
        label_23:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_23;
        }

        throw v0;
        return;
        try {
        label_26:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_26;
        }

        throw v0;
    }

    public Object getCancellationSignalObject() {
        Object v0;
        if(Build$VERSION.SDK_INT < 16) {
            v0 = null;
        }
        else {
            __monitor_enter(this);
            try {
                if(this.mCancellationSignalObj == null) {
                    this.mCancellationSignalObj = CancellationSignalCompatJellybean.create();
                    if(this.mIsCanceled) {
                        CancellationSignalCompatJellybean.cancel(this.mCancellationSignalObj);
                    }
                }

                v0 = this.mCancellationSignalObj;
                __monitor_exit(this);
                return v0;
            label_18:
                __monitor_exit(this);
            }
            catch(Throwable v0_1) {
                goto label_18;
            }

            throw v0_1;
        }

        return v0;
    }

    public boolean isCanceled() {
        __monitor_enter(this);
        try {
            __monitor_exit(this);
            return this.mIsCanceled;
        label_5:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_5;
        }

        throw v0;
    }

    public void setOnCancelListener(OnCancelListener arg2) {
        __monitor_enter(this);
        try {
            this.waitForCancelFinishedLocked();
            if(this.mOnCancelListener == arg2) {
                __monitor_exit(this);
            }
            else {
                this.mOnCancelListener = arg2;
                if((this.mIsCanceled) && arg2 != null) {
                    __monitor_exit(this);
                    goto label_16;
                }

                goto label_10;
            }

            return;
        }
        catch(Throwable v0) {
            goto label_13;
        }

    label_16:
        arg2.onCancel();
        return;
        try {
        label_10:
            __monitor_exit(this);
            return;
        label_13:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_13;
        }

        throw v0;
    }

    public void throwIfCanceled() {
        if(this.isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    private void waitForCancelFinishedLocked() {
        while(this.mCancelInProgress) {
            try {
                this.wait();
            }
            catch(InterruptedException v0) {
            }
        }
    }
}

