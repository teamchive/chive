package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.widget.ListView;

@TargetApi(value=19) @RequiresApi(value=19) class ListViewCompatKitKat {
    ListViewCompatKitKat() {
        super();
    }

    static void scrollListBy(ListView arg0, int arg1) {
        arg0.scrollListBy(arg1);
    }
}

