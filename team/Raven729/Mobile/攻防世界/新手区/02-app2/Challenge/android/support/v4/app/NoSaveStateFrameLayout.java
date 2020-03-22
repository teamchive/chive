package android.support.v4.app;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;

class NoSaveStateFrameLayout extends FrameLayout {
    public NoSaveStateFrameLayout(Context arg1) {
        super(arg1);
    }

    protected void dispatchRestoreInstanceState(SparseArray arg1) {
        this.dispatchThawSelfOnly(arg1);
    }

    protected void dispatchSaveInstanceState(SparseArray arg1) {
        this.dispatchFreezeSelfOnly(arg1);
    }

    static ViewGroup wrap(View arg3) {
        int v2 = -1;
        NoSaveStateFrameLayout v0 = new NoSaveStateFrameLayout(arg3.getContext());
        ViewGroup$LayoutParams v1 = arg3.getLayoutParams();
        if(v1 != null) {
            v0.setLayoutParams(v1);
        }

        arg3.setLayoutParams(new FrameLayout$LayoutParams(v2, v2));
        v0.addView(arg3);
        return ((ViewGroup)v0);
    }
}

