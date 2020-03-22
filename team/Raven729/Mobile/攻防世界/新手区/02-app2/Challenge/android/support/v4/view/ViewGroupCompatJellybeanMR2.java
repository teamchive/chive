package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;

@TargetApi(value=18) @RequiresApi(value=18) class ViewGroupCompatJellybeanMR2 {
    ViewGroupCompatJellybeanMR2() {
        super();
    }

    public static int getLayoutMode(ViewGroup arg1) {
        return arg1.getLayoutMode();
    }

    public static void setLayoutMode(ViewGroup arg0, int arg1) {
        arg0.setLayoutMode(arg1);
    }
}

