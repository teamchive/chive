package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;

@TargetApi(value=11) @RequiresApi(value=11) class ViewGroupCompatHC {
    private ViewGroupCompatHC() {
        super();
    }

    public static void setMotionEventSplittingEnabled(ViewGroup arg0, boolean arg1) {
        arg0.setMotionEventSplittingEnabled(arg1);
    }
}

