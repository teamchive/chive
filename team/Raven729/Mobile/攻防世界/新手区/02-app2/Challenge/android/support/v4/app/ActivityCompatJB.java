package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(value=16) @RequiresApi(value=16) class ActivityCompatJB {
    ActivityCompatJB() {
        super();
    }

    public static void finishAffinity(Activity arg0) {
        arg0.finishAffinity();
    }

    public static void startActivityForResult(Activity arg0, Intent arg1, int arg2, Bundle arg3) {
        arg0.startActivityForResult(arg1, arg2, arg3);
    }

    public static void startIntentSenderForResult(Activity arg0, IntentSender arg1, int arg2, Intent arg3, int arg4, int arg5, int arg6, Bundle arg7) {
        arg0.startIntentSenderForResult(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
}

