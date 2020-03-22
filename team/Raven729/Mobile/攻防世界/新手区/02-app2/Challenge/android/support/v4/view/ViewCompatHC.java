package android.support.v4.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewParent;

@TargetApi(value=11) @RequiresApi(value=11) class ViewCompatHC {
    ViewCompatHC() {
        super();
    }

    public static int combineMeasuredStates(int arg1, int arg2) {
        return View.combineMeasuredStates(arg1, arg2);
    }

    public static float getAlpha(View arg1) {
        return arg1.getAlpha();
    }

    static long getFrameTime() {
        return ValueAnimator.getFrameDelay();
    }

    public static int getLayerType(View arg1) {
        return arg1.getLayerType();
    }

    public static Matrix getMatrix(View arg1) {
        return arg1.getMatrix();
    }

    public static int getMeasuredHeightAndState(View arg1) {
        return arg1.getMeasuredHeightAndState();
    }

    public static int getMeasuredState(View arg1) {
        return arg1.getMeasuredState();
    }

    public static int getMeasuredWidthAndState(View arg1) {
        return arg1.getMeasuredWidthAndState();
    }

    public static float getPivotX(View arg1) {
        return arg1.getPivotX();
    }

    public static float getPivotY(View arg1) {
        return arg1.getPivotY();
    }

    public static float getRotation(View arg1) {
        return arg1.getRotation();
    }

    public static float getRotationX(View arg1) {
        return arg1.getRotationX();
    }

    public static float getRotationY(View arg1) {
        return arg1.getRotationY();
    }

    public static float getScaleX(View arg1) {
        return arg1.getScaleX();
    }

    public static float getScaleY(View arg1) {
        return arg1.getScaleY();
    }

    public static float getTranslationX(View arg1) {
        return arg1.getTranslationX();
    }

    public static float getTranslationY(View arg1) {
        return arg1.getTranslationY();
    }

    public static float getX(View arg1) {
        return arg1.getX();
    }

    public static float getY(View arg1) {
        return arg1.getY();
    }

    public static void jumpDrawablesToCurrentState(View arg0) {
        arg0.jumpDrawablesToCurrentState();
    }

    static void offsetLeftAndRight(View arg2, int arg3) {
        arg2.offsetLeftAndRight(arg3);
        if(arg2.getVisibility() == 0) {
            ViewCompatHC.tickleInvalidationFlag(arg2);
            ViewParent v0 = arg2.getParent();
            if((v0 instanceof View)) {
                ViewCompatHC.tickleInvalidationFlag(((View)v0));
            }
        }
    }

    static void offsetTopAndBottom(View arg2, int arg3) {
        arg2.offsetTopAndBottom(arg3);
        if(arg2.getVisibility() == 0) {
            ViewCompatHC.tickleInvalidationFlag(arg2);
            ViewParent v0 = arg2.getParent();
            if((v0 instanceof View)) {
                ViewCompatHC.tickleInvalidationFlag(((View)v0));
            }
        }
    }

    public static int resolveSizeAndState(int arg1, int arg2, int arg3) {
        return View.resolveSizeAndState(arg1, arg2, arg3);
    }

    public static void setActivated(View arg0, boolean arg1) {
        arg0.setActivated(arg1);
    }

    public static void setAlpha(View arg0, float arg1) {
        arg0.setAlpha(arg1);
    }

    public static void setLayerType(View arg0, int arg1, Paint arg2) {
        arg0.setLayerType(arg1, arg2);
    }

    public static void setPivotX(View arg0, float arg1) {
        arg0.setPivotX(arg1);
    }

    public static void setPivotY(View arg0, float arg1) {
        arg0.setPivotY(arg1);
    }

    public static void setRotation(View arg0, float arg1) {
        arg0.setRotation(arg1);
    }

    public static void setRotationX(View arg0, float arg1) {
        arg0.setRotationX(arg1);
    }

    public static void setRotationY(View arg0, float arg1) {
        arg0.setRotationY(arg1);
    }

    public static void setSaveFromParentEnabled(View arg0, boolean arg1) {
        arg0.setSaveFromParentEnabled(arg1);
    }

    public static void setScaleX(View arg0, float arg1) {
        arg0.setScaleX(arg1);
    }

    public static void setScaleY(View arg0, float arg1) {
        arg0.setScaleY(arg1);
    }

    public static void setTranslationX(View arg0, float arg1) {
        arg0.setTranslationX(arg1);
    }

    public static void setTranslationY(View arg0, float arg1) {
        arg0.setTranslationY(arg1);
    }

    public static void setX(View arg0, float arg1) {
        arg0.setX(arg1);
    }

    public static void setY(View arg0, float arg1) {
        arg0.setY(arg1);
    }

    private static void tickleInvalidationFlag(View arg2) {
        float v0 = arg2.getTranslationY();
        arg2.setTranslationY(1f + v0);
        arg2.setTranslationY(v0);
    }
}

