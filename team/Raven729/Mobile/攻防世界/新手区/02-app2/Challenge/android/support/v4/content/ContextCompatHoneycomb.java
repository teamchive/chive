package android.support.v4.content;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import java.io.File;

@TargetApi(value=11) @RequiresApi(value=11) class ContextCompatHoneycomb {
    ContextCompatHoneycomb() {
        super();
    }

    public static File getObbDir(Context arg1) {
        return arg1.getObbDir();
    }

    static void startActivities(Context arg0, Intent[] arg1) {
        arg0.startActivities(arg1);
    }
}

