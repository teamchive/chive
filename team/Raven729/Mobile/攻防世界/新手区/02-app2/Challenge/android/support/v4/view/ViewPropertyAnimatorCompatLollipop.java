package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(value=21) @RequiresApi(value=21) class ViewPropertyAnimatorCompatLollipop {
    ViewPropertyAnimatorCompatLollipop() {
        super();
    }

    public static void translationZ(View arg1, float arg2) {
        arg1.animate().translationZ(arg2);
    }

    public static void translationZBy(View arg1, float arg2) {
        arg1.animate().translationZBy(arg2);
    }

    public static void z(View arg1, float arg2) {
        arg1.animate().z(arg2);
    }

    public static void zBy(View arg1, float arg2) {
        arg1.animate().zBy(arg2);
    }
}

