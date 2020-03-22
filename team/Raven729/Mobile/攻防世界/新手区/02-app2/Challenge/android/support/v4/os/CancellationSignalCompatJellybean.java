package android.support.v4.os;

import android.annotation.TargetApi;
import android.os.CancellationSignal;
import android.support.annotation.RequiresApi;

@TargetApi(value=16) @RequiresApi(value=16) class CancellationSignalCompatJellybean {
    CancellationSignalCompatJellybean() {
        super();
    }

    public static void cancel(Object arg0) {
        ((CancellationSignal)arg0).cancel();
    }

    public static Object create() {
        return new CancellationSignal();
    }
}

