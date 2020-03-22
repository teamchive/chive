package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View$OnTouchListener;
import android.view.View;
import android.widget.ListPopupWindow;

@TargetApi(value=19) @RequiresApi(value=19) class ListPopupWindowCompatKitKat {
    ListPopupWindowCompatKitKat() {
        super();
    }

    public static View$OnTouchListener createDragToOpenListener(Object arg1, View arg2) {
        return ((ListPopupWindow)arg1).createDragToOpenListener(arg2);
    }
}

