package android.support.v4.view;

import android.content.Context;
import android.os.Handler$Callback;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.util.Pools$SynchronizedPool;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.concurrent.ArrayBlockingQueue;

public final class AsyncLayoutInflater {
    class android.support.v4.view.AsyncLayoutInflater$1 implements Handler$Callback {
        android.support.v4.view.AsyncLayoutInflater$1(AsyncLayoutInflater arg1) {
            AsyncLayoutInflater.this = arg1;
            super();
        }

        public boolean handleMessage(Message arg6) {
            Object v0 = arg6.obj;
            if(((InflateRequest)v0).view == null) {
                ((InflateRequest)v0).view = AsyncLayoutInflater.this.mInflater.inflate(((InflateRequest)v0).resid, ((InflateRequest)v0).parent, false);
            }

            ((InflateRequest)v0).callback.onInflateFinished(((InflateRequest)v0).view, ((InflateRequest)v0).resid, ((InflateRequest)v0).parent);
            AsyncLayoutInflater.this.mInflateThread.releaseRequest(((InflateRequest)v0));
            return 1;
        }
    }

    class BasicInflater extends LayoutInflater {
        private static final String[] sClassPrefixList;

        static {
            BasicInflater.sClassPrefixList = new String[]{"android.widget.", "android.webkit.", "android.app."};
        }

        BasicInflater(Context arg1) {
            super(arg1);
        }

        public LayoutInflater cloneInContext(Context arg2) {
            return new BasicInflater(arg2);
        }

        protected View onCreateView(String arg5, AttributeSet arg6) {
            String[] v2 = BasicInflater.sClassPrefixList;
            int v3 = v2.length;
            int v1;
            for(v1 = 0; v1 < v3; ++v1) {
                String v0 = v2[v1];
                try {
                    View v0_2 = this.createView(arg5, v0, arg6);
                    if(v0_2 == null) {
                        goto label_10;
                    }

                    return v0_2;
                }
                catch(ClassNotFoundException v0_1) {
                }

            label_10:
            }

            return super.onCreateView(arg5, arg6);
        }
    }

    class InflateRequest {
        OnInflateFinishedListener callback;
        AsyncLayoutInflater inflater;
        ViewGroup parent;
        int resid;
        View view;

        InflateRequest() {
            super();
        }
    }

    class InflateThread extends Thread {
        private ArrayBlockingQueue mQueue;
        private SynchronizedPool mRequestPool;
        private static final InflateThread sInstance;

        static {
            InflateThread.sInstance = new InflateThread();
            InflateThread.sInstance.start();
        }

        private InflateThread() {
            super();
            this.mQueue = new ArrayBlockingQueue(10);
            this.mRequestPool = new SynchronizedPool(10);
        }

        public void enqueue(InflateRequest arg4) {
            try {
                this.mQueue.put(arg4);
                return;
            }
            catch(InterruptedException v0) {
                throw new RuntimeException("Failed to enqueue async inflate request", ((Throwable)v0));
            }
        }

        public static InflateThread getInstance() {
            return InflateThread.sInstance;
        }

        public InflateRequest obtainRequest() {
            Object v0 = this.mRequestPool.acquire();
            if(v0 == null) {
                InflateRequest v0_1 = new InflateRequest();
            }

            return ((InflateRequest)v0);
        }

        public void releaseRequest(InflateRequest arg3) {
            arg3.callback = null;
            arg3.inflater = null;
            arg3.parent = null;
            arg3.resid = 0;
            arg3.view = null;
            this.mRequestPool.release(arg3);
        }

        public void run() {
            AsyncLayoutInflater v1_1;
            Object v0_1;
            try {
                while(true) {
                label_1:
                    v0_1 = this.mQueue.take();
                    break;
                }
            }
            catch(InterruptedException v0) {
                goto label_17;
            }

            try {
                v1_1 = ((InflateRequest)v0_1).inflater;
            }
            catch(InterruptedException v0) {
                goto label_17;
            }
            catch(RuntimeException v1) {
                goto label_22;
            }

            try {
                ((InflateRequest)v0_1).view = v1_1.mInflater.inflate(((InflateRequest)v0_1).resid, ((InflateRequest)v0_1).parent, false);
            }
            catch(RuntimeException v1) {
            label_22:
                Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", ((Throwable)v1));
            }

            Message.obtain(((InflateRequest)v0_1).inflater.mHandler, 0, v0_1).sendToTarget();
            goto label_1;
        label_17:
            Log.w("AsyncLayoutInflater", ((Throwable)v0));
            goto label_1;
        }
    }

    public interface OnInflateFinishedListener {
        void onInflateFinished(View arg1, int arg2, ViewGroup arg3);
    }

    private static final String TAG = "AsyncLayoutInflater";
    Handler mHandler;
    private Handler$Callback mHandlerCallback;
    InflateThread mInflateThread;
    LayoutInflater mInflater;

    public AsyncLayoutInflater(@NonNull Context arg3) {
        super();
        this.mHandlerCallback = new android.support.v4.view.AsyncLayoutInflater$1(this);
        this.mInflater = new BasicInflater(arg3);
        this.mHandler = new Handler(this.mHandlerCallback);
        this.mInflateThread = InflateThread.getInstance();
    }

    @UiThread public void inflate(@LayoutRes int arg3, @Nullable ViewGroup arg4, @NonNull OnInflateFinishedListener arg5) {
        if(arg5 == null) {
            throw new NullPointerException("callback argument may not be null!");
        }

        InflateRequest v0 = this.mInflateThread.obtainRequest();
        v0.inflater = this;
        v0.resid = arg3;
        v0.parent = arg4;
        v0.callback = arg5;
        this.mInflateThread.enqueue(v0);
    }
}

