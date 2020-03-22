package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.VelocityTracker;

@TargetApi(value=11) @RequiresApi(value=11) class VelocityTrackerCompatHoneycomb {
    VelocityTrackerCompatHoneycomb() {
        super();
    }

    public static float getXVelocity(VelocityTracker arg1, int arg2) {
        return arg1.getXVelocity(arg2);
    }

    public static float getYVelocity(VelocityTracker arg1, int arg2) {
        return arg1.getYVelocity(arg2);
    }
}

