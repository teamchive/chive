package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.v4.os.OperationCanceledException;
import android.support.v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader extends Loader {
    final class LoadTask extends ModernAsyncTask implements Runnable {
        private final CountDownLatch mDone;
        boolean waiting;

        LoadTask(AsyncTaskLoader arg3) {
            AsyncTaskLoader.this = arg3;
            super();
            this.mDone = new CountDownLatch(1);
        }

        protected Object doInBackground(Object[] arg2) {
            return this.doInBackground(((Void[])arg2));
        }

        protected Object doInBackground(Void[] arg3) {
            Object v0_1;
            try {
                v0_1 = AsyncTaskLoader.this.onLoadInBackground();
            }
            catch(OperationCanceledException v0) {
                if(!this.isCancelled()) {
                    throw v0;
                }

                v0_1 = null;
            }

            return v0_1;
        }

        protected void onCancelled(Object arg3) {
            try {
                AsyncTaskLoader.this.dispatchOnCancelled(this, arg3);
            }
            catch(Throwable v0) {
                this.mDone.countDown();
                throw v0;
            }

            this.mDone.countDown();
        }

        protected void onPostExecute(Object arg3) {
            try {
                AsyncTaskLoader.this.dispatchOnLoadComplete(this, arg3);
            }
            catch(Throwable v0) {
                this.mDone.countDown();
                throw v0;
            }

            this.mDone.countDown();
        }

        public void run() {
            this.waiting = false;
            AsyncTaskLoader.this.executePendingTask();
        }

        public void waitForLoader() {
            try {
                this.mDone.await();
            }
            catch(InterruptedException v0) {
            }
        }
    }

    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile LoadTask mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile LoadTask mTask;
    long mUpdateThrottle;

    public AsyncTaskLoader(Context arg2) {
        this(arg2, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    private AsyncTaskLoader(Context arg3, Executor arg4) {
        super(arg3);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = arg4;
    }

    public void cancelLoadInBackground() {
    }

    void dispatchOnCancelled(LoadTask arg3, Object arg4) {
        this.onCanceled(arg4);
        if(this.mCancellingTask == arg3) {
            this.rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            this.deliverCancellation();
            this.executePendingTask();
        }
    }

    void dispatchOnLoadComplete(LoadTask arg3, Object arg4) {
        if(this.mTask != arg3) {
            this.dispatchOnCancelled(arg3, arg4);
        }
        else if(this.isAbandoned()) {
            this.onCanceled(arg4);
        }
        else {
            this.commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            this.deliverResult(arg4);
        }
    }

    public void dump(String arg5, FileDescriptor arg6, PrintWriter arg7, String[] arg8) {
        super.dump(arg5, arg6, arg7, arg8);
        if(this.mTask != null) {
            arg7.print(arg5);
            arg7.print("mTask=");
            arg7.print(this.mTask);
            arg7.print(" waiting=");
            arg7.println(this.mTask.waiting);
        }

        if(this.mCancellingTask != null) {
            arg7.print(arg5);
            arg7.print("mCancellingTask=");
            arg7.print(this.mCancellingTask);
            arg7.print(" waiting=");
            arg7.println(this.mCancellingTask.waiting);
        }

        if(this.mUpdateThrottle != 0) {
            arg7.print(arg5);
            arg7.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.mUpdateThrottle, arg7);
            arg7.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), arg7);
            arg7.println();
        }
    }

    void executePendingTask() {
        if(this.mCancellingTask == null && this.mTask != null) {
            if(this.mTask.waiting) {
                this.mTask.waiting = false;
                this.mHandler.removeCallbacks(this.mTask);
            }

            if(this.mUpdateThrottle > 0 && SystemClock.uptimeMillis() < this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                this.mTask.waiting = true;
                this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
                return;
            }

            this.mTask.executeOnExecutor(this.mExecutor, null);
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        boolean v0 = this.mCancellingTask != null ? true : false;
        return v0;
    }

    public abstract Object loadInBackground();

    protected boolean onCancelLoad() {
        LoadTask v3 = null;
        boolean v0 = false;
        if(this.mTask != null) {
            if(this.mCancellingTask != null) {
                if(this.mTask.waiting) {
                    this.mTask.waiting = false;
                    this.mHandler.removeCallbacks(this.mTask);
                }

                this.mTask = v3;
            }
            else {
                if(this.mTask.waiting) {
                    this.mTask.waiting = false;
                    this.mHandler.removeCallbacks(this.mTask);
                    this.mTask = v3;
                    return v0;
                }

                v0 = this.mTask.cancel(false);
                if(v0) {
                    this.mCancellingTask = this.mTask;
                    this.cancelLoadInBackground();
                }

                this.mTask = v3;
            }
        }

        return v0;
    }

    public void onCanceled(Object arg1) {
    }

    protected void onForceLoad() {
        super.onForceLoad();
        this.cancelLoad();
        this.mTask = new LoadTask(this);
        this.executePendingTask();
    }

    protected Object onLoadInBackground() {
        return this.loadInBackground();
    }

    public void setUpdateThrottle(long arg4) {
        this.mUpdateThrottle = arg4;
        if(arg4 != 0) {
            this.mHandler = new Handler();
        }
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public void waitForLoader() {
        LoadTask v0 = this.mTask;
        if(v0 != null) {
            v0.waitForLoader();
        }
    }
}

