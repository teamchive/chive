package android.support.v4.a;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

abstract class f extends e {
    boolean b;

    f() {
        super();
    }

    public void startActivityForResult(Intent arg2, int arg3, Bundle arg4) {
        if(!this.b && arg3 != -1) {
            f.a(arg3);
        }

        super.startActivityForResult(arg2, arg3, arg4);
    }

    public void startIntentSenderForResult(IntentSender arg2, int arg3, Intent arg4, int arg5, int arg6, int arg7, Bundle arg8) {
        if(!this.a && arg3 != -1) {
            f.a(arg3);
        }

        super.startIntentSenderForResult(arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
}

