package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.widget.OverScroller;

@TargetApi(value=14) @RequiresApi(value=14) class ScrollerCompatIcs {
    ScrollerCompatIcs() {
        super();
    }

    public static float getCurrVelocity(Object arg1) {
        return ((OverScroller)arg1).getCurrVelocity();
    }
}

