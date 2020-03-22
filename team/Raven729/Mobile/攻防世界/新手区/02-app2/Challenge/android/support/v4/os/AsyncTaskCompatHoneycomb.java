package android.support.v4.os;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.support.annotation.RequiresApi;

@TargetApi(value=11) @RequiresApi(value=11) class AsyncTaskCompatHoneycomb {
    AsyncTaskCompatHoneycomb() {
        super();
    }

    static void executeParallel(AsyncTask arg1, Object[] arg2) {
        arg1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, arg2);
    }
}

