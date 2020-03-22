package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.PopupWindow;

@TargetApi(value=19) @RequiresApi(value=19) class PopupWindowCompatKitKat {
    PopupWindowCompatKitKat() {
        super();
    }

    public static void showAsDropDown(PopupWindow arg0, View arg1, int arg2, int arg3, int arg4) {
        arg0.showAsDropDown(arg1, arg2, arg3, arg4);
    }
}

