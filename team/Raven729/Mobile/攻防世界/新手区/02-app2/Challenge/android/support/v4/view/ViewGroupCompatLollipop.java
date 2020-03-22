package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;

@TargetApi(value=21) @RequiresApi(value=21) class ViewGroupCompatLollipop {
    ViewGroupCompatLollipop() {
        super();
    }

    public static int getNestedScrollAxes(ViewGroup arg1) {
        return arg1.getNestedScrollAxes();
    }

    public static boolean isTransitionGroup(ViewGroup arg1) {
        return arg1.isTransitionGroup();
    }

    public static void setTransitionGroup(ViewGroup arg0, boolean arg1) {
        arg0.setTransitionGroup(arg1);
    }
}

