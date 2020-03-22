package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@TargetApi(value=11) @RequiresApi(value=11) class ActivityCompatHoneycomb {
    ActivityCompatHoneycomb() {
        super();
    }

    static void dump(Activity arg0, String arg1, FileDescriptor arg2, PrintWriter arg3, String[] arg4) {
        arg0.dump(arg1, arg2, arg3, arg4);
    }

    static void invalidateOptionsMenu(Activity arg0) {
        arg0.invalidateOptionsMenu();
    }
}

