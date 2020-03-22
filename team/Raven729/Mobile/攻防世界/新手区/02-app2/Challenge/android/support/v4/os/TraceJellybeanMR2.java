package android.support.v4.os;

import android.annotation.TargetApi;
import android.os.Trace;
import android.support.annotation.RequiresApi;

@TargetApi(value=18) @RequiresApi(value=18) class TraceJellybeanMR2 {
    TraceJellybeanMR2() {
        super();
    }

    public static void beginSection(String arg0) {
        Trace.beginSection(arg0);
    }

    public static void endSection() {
        Trace.endSection();
    }
}

