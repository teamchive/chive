package android.support.v4.content;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.support.annotation.RequiresApi;

@TargetApi(value=11) @RequiresApi(value=11) class IntentCompatHoneycomb {
    IntentCompatHoneycomb() {
        super();
    }

    public static Intent makeMainActivity(ComponentName arg1) {
        return Intent.makeMainActivity(arg1);
    }

    public static Intent makeRestartActivityTask(ComponentName arg1) {
        return Intent.makeRestartActivityTask(arg1);
    }
}

