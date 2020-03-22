package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ListView;

@TargetApi(value=9) @RequiresApi(value=9) class ListViewCompatGingerbread {
    ListViewCompatGingerbread() {
        super();
    }

    static void scrollListBy(ListView arg2, int arg3) {
        int v0 = arg2.getFirstVisiblePosition();
        if(v0 != -1) {
            View v1 = arg2.getChildAt(0);
            if(v1 != null) {
                arg2.setSelectionFromTop(v0, v1.getTop() - arg3);
            }
        }
    }
}

