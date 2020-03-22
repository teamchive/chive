package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.MotionEvent;

@TargetApi(value=12) @RequiresApi(value=12) class MotionEventCompatHoneycombMr1 {
    MotionEventCompatHoneycombMr1() {
        super();
    }

    static float getAxisValue(MotionEvent arg1, int arg2) {
        return arg1.getAxisValue(arg2);
    }

    static float getAxisValue(MotionEvent arg1, int arg2, int arg3) {
        return arg1.getAxisValue(arg2, arg3);
    }
}

