package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View$OnTouchListener;
import android.widget.PopupMenu;

@TargetApi(value=19) @RequiresApi(value=19) class PopupMenuCompatKitKat {
    PopupMenuCompatKitKat() {
        super();
    }

    public static View$OnTouchListener getDragToOpenListener(Object arg1) {
        return ((PopupMenu)arg1).getDragToOpenListener();
    }
}

