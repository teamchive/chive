package android.support.v4.app;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.RequiresApi;

@TargetApi(value=18) @RequiresApi(value=18) class BundleCompatJellybeanMR2 {
    BundleCompatJellybeanMR2() {
        super();
    }

    public static IBinder getBinder(Bundle arg1, String arg2) {
        return arg1.getBinder(arg2);
    }

    public static void putBinder(Bundle arg0, String arg1, IBinder arg2) {
        arg0.putBinder(arg1, arg2);
    }
}

