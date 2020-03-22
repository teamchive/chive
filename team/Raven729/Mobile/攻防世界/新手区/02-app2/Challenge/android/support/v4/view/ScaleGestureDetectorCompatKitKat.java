package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.ScaleGestureDetector;

@TargetApi(value=19) @RequiresApi(value=19) class ScaleGestureDetectorCompatKitKat {
    private ScaleGestureDetectorCompatKitKat() {
        super();
    }

    public static boolean isQuickScaleEnabled(Object arg1) {
        return ((ScaleGestureDetector)arg1).isQuickScaleEnabled();
    }

    public static void setQuickScaleEnabled(Object arg0, boolean arg1) {
        ((ScaleGestureDetector)arg0).setQuickScaleEnabled(arg1);
    }
}

