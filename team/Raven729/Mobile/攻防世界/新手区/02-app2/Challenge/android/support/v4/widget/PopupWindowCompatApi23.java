package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.widget.PopupWindow;

@TargetApi(value=23) @RequiresApi(value=23) class PopupWindowCompatApi23 {
    PopupWindowCompatApi23() {
        super();
    }

    static boolean getOverlapAnchor(PopupWindow arg1) {
        return arg1.getOverlapAnchor();
    }

    static int getWindowLayoutType(PopupWindow arg1) {
        return arg1.getWindowLayoutType();
    }

    static void setOverlapAnchor(PopupWindow arg0, boolean arg1) {
        arg0.setOverlapAnchor(arg1);
    }

    static void setWindowLayoutType(PopupWindow arg0, int arg1) {
        arg0.setWindowLayoutType(arg1);
    }
}

