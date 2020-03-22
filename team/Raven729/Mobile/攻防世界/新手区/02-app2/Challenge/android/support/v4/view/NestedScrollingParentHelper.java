package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

public class NestedScrollingParentHelper {
    private int mNestedScrollAxes;
    private final ViewGroup mViewGroup;

    public NestedScrollingParentHelper(ViewGroup arg1) {
        super();
        this.mViewGroup = arg1;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollAxes;
    }

    public void onNestedScrollAccepted(View arg1, View arg2, int arg3) {
        this.mNestedScrollAxes = arg3;
    }

    public void onStopNestedScroll(View arg2) {
        this.mNestedScrollAxes = 0;
    }
}

