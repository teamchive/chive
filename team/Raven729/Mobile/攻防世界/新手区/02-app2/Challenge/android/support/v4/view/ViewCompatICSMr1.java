package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(value=15) @RequiresApi(value=15) class ViewCompatICSMr1 {
    ViewCompatICSMr1() {
        super();
    }

    public static boolean hasOnClickListeners(View arg1) {
        return arg1.hasOnClickListeners();
    }
}

