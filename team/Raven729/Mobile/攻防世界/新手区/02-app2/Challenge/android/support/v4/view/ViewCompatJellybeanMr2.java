package android.support.v4.view;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(value=18) @RequiresApi(value=18) class ViewCompatJellybeanMr2 {
    ViewCompatJellybeanMr2() {
        super();
    }

    public static Rect getClipBounds(View arg1) {
        return arg1.getClipBounds();
    }

    public static boolean isInLayout(View arg1) {
        return arg1.isInLayout();
    }

    public static void setClipBounds(View arg0, Rect arg1) {
        arg0.setClipBounds(arg1);
    }
}

