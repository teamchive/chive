package android.support.v4.hardware.display;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.support.annotation.RequiresApi;
import android.view.Display;

@TargetApi(value=17) @RequiresApi(value=17) final class DisplayManagerJellybeanMr1 {
    DisplayManagerJellybeanMr1() {
        super();
    }

    public static Display getDisplay(Object arg1, int arg2) {
        return ((DisplayManager)arg1).getDisplay(arg2);
    }

    public static Object getDisplayManager(Context arg1) {
        return arg1.getSystemService("display");
    }

    public static Display[] getDisplays(Object arg1) {
        return ((DisplayManager)arg1).getDisplays();
    }

    public static Display[] getDisplays(Object arg1, String arg2) {
        return ((DisplayManager)arg1).getDisplays(arg2);
    }
}

