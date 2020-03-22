package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.MenuItem;
import android.view.View;

@TargetApi(value=11) @RequiresApi(value=11) class MenuItemCompatHoneycomb {
    MenuItemCompatHoneycomb() {
        super();
    }

    public static View getActionView(MenuItem arg1) {
        return arg1.getActionView();
    }

    public static MenuItem setActionView(MenuItem arg1, int arg2) {
        return arg1.setActionView(arg2);
    }

    public static MenuItem setActionView(MenuItem arg1, View arg2) {
        return arg1.setActionView(arg2);
    }

    public static void setShowAsAction(MenuItem arg0, int arg1) {
        arg0.setShowAsAction(arg1);
    }
}

