package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.net.Uri;
import android.support.annotation.RequiresApi;

@TargetApi(value=22) @RequiresApi(value=22) class ActivityCompatApi22 {
    ActivityCompatApi22() {
        super();
    }

    public static Uri getReferrer(Activity arg1) {
        return arg1.getReferrer();
    }
}

