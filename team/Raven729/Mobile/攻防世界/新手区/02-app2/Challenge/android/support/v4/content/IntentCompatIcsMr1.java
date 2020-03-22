package android.support.v4.content;

import android.annotation.TargetApi;
import android.content.Intent;
import android.support.annotation.RequiresApi;

@TargetApi(value=15) @RequiresApi(value=15) class IntentCompatIcsMr1 {
    IntentCompatIcsMr1() {
        super();
    }

    public static Intent makeMainSelectorActivity(String arg1, String arg2) {
        return Intent.makeMainSelectorActivity(arg1, arg2);
    }
}

