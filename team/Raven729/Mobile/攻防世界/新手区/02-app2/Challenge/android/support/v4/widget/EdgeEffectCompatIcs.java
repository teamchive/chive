package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.RequiresApi;
import android.widget.EdgeEffect;

@TargetApi(value=14) @RequiresApi(value=14) class EdgeEffectCompatIcs {
    EdgeEffectCompatIcs() {
        super();
    }

    public static boolean draw(Object arg1, Canvas arg2) {
        return ((EdgeEffect)arg1).draw(arg2);
    }

    public static void finish(Object arg0) {
        ((EdgeEffect)arg0).finish();
    }

    public static boolean isFinished(Object arg1) {
        return ((EdgeEffect)arg1).isFinished();
    }

    public static Object newEdgeEffect(Context arg1) {
        return new EdgeEffect(arg1);
    }

    public static boolean onAbsorb(Object arg1, int arg2) {
        ((EdgeEffect)arg1).onAbsorb(arg2);
        return 1;
    }

    public static boolean onPull(Object arg1, float arg2) {
        ((EdgeEffect)arg1).onPull(arg2);
        return 1;
    }

    public static boolean onRelease(Object arg1) {
        ((EdgeEffect)arg1).onRelease();
        return ((EdgeEffect)arg1).isFinished();
    }

    public static void setSize(Object arg0, int arg1, int arg2) {
        ((EdgeEffect)arg0).setSize(arg1, arg2);
    }
}

