package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.MotionEvent;

@TargetApi(value=14) @RequiresApi(value=14) class MotionEventCompatICS {
    MotionEventCompatICS() {
        super();
    }

    public static int getButtonState(MotionEvent arg1) {
        return arg1.getButtonState();
    }
}

