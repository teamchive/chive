package android.support.v4.app;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.IBinder;

public final class BundleCompat {
    private BundleCompat() {
        super();
    }

    public static IBinder getBinder(Bundle arg2, String arg3) {
        IBinder v0 = Build$VERSION.SDK_INT >= 18 ? BundleCompatJellybeanMR2.getBinder(arg2, arg3) : BundleCompatGingerbread.getBinder(arg2, arg3);
        return v0;
    }

    public static void putBinder(Bundle arg2, String arg3, IBinder arg4) {
        if(Build$VERSION.SDK_INT >= 18) {
            BundleCompatJellybeanMR2.putBinder(arg2, arg3, arg4);
        }
        else {
            BundleCompatGingerbread.putBinder(arg2, arg3, arg4);
        }
    }
}

