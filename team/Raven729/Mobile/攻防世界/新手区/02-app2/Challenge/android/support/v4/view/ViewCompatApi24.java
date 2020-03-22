package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.PointerIcon;
import android.view.View;

@TargetApi(value=24) @RequiresApi(value=24) class ViewCompatApi24 {
    ViewCompatApi24() {
        super();
    }

    public static void setPointerIcon(View arg0, Object arg1) {
        arg0.setPointerIcon(((PointerIcon)arg1));
    }
}

