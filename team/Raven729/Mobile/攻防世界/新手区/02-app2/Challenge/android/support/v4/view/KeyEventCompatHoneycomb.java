package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;

@TargetApi(value=11) @RequiresApi(value=11) class KeyEventCompatHoneycomb {
    KeyEventCompatHoneycomb() {
        super();
    }

    public static boolean isCtrlPressed(KeyEvent arg1) {
        return arg1.isCtrlPressed();
    }

    public static boolean metaStateHasModifiers(int arg1, int arg2) {
        return KeyEvent.metaStateHasModifiers(arg1, arg2);
    }

    public static boolean metaStateHasNoModifiers(int arg1) {
        return KeyEvent.metaStateHasNoModifiers(arg1);
    }

    public static int normalizeMetaState(int arg1) {
        return KeyEvent.normalizeMetaState(arg1);
    }
}

