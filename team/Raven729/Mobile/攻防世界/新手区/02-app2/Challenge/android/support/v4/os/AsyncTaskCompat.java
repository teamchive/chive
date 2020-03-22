package android.support.v4.os;

import android.os.AsyncTask;
import android.os.Build$VERSION;

public final class AsyncTaskCompat {
    private AsyncTaskCompat() {
        super();
    }

    public static AsyncTask executeParallel(AsyncTask arg2, Object[] arg3) {
        if(arg2 == null) {
            throw new IllegalArgumentException("task can not be null");
        }

        if(Build$VERSION.SDK_INT >= 11) {
            AsyncTaskCompatHoneycomb.executeParallel(arg2, arg3);
        }
        else {
            arg2.execute(arg3);
        }

        return arg2;
    }
}

