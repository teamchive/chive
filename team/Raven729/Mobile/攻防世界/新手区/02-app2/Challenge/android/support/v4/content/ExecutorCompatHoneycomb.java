package android.support.v4.content;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.support.annotation.RequiresApi;
import java.util.concurrent.Executor;

@TargetApi(value=11) @RequiresApi(value=11) class ExecutorCompatHoneycomb {
    ExecutorCompatHoneycomb() {
        super();
    }

    public static Executor getParallelExecutor() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }
}

