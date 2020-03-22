package android.support.v4.content;

import android.os.Build$VERSION;
import java.util.concurrent.Executor;

public final class ParallelExecutorCompat {
    private ParallelExecutorCompat() {
        super();
    }

    public static Executor getParallelExecutor() {
        Executor v0 = Build$VERSION.SDK_INT >= 11 ? ExecutorCompatHoneycomb.getParallelExecutor() : ModernAsyncTask.THREAD_POOL_EXECUTOR;
        return v0;
    }
}

