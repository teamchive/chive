package android.support.v4.content;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(value=16) @RequiresApi(value=16) class ContextCompatJellybean {
    ContextCompatJellybean() {
        super();
    }

    public static void startActivities(Context arg0, Intent[] arg1, Bundle arg2) {
        arg0.startActivities(arg1, arg2);
    }

    public static void startActivity(Context arg0, Intent arg1, Bundle arg2) {
        arg0.startActivity(arg1, arg2);
    }
}

