package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

@TargetApi(value=14) @RequiresApi(value=14) class ShareCompatICS {
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    ShareCompatICS() {
        super();
    }

    public static void configureMenuItem(MenuItem arg3, Activity arg4, Intent arg5) {
        ActionProvider v0 = arg3.getActionProvider();
        if(!(v0 instanceof ShareActionProvider)) {
            ShareActionProvider v0_1 = new ShareActionProvider(((Context)arg4));
        }

        ((ShareActionProvider)v0).setShareHistoryFileName(".sharecompat_" + arg4.getClass().getName());
        ((ShareActionProvider)v0).setShareIntent(arg5);
        arg3.setActionProvider(v0);
    }
}

