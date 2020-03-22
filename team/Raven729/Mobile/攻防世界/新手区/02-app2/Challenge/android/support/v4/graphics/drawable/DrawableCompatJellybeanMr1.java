package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.reflect.Method;

@TargetApi(value=17) @RequiresApi(value=17) class DrawableCompatJellybeanMr1 {
    private static final String TAG = "DrawableCompatJellybeanMr1";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    DrawableCompatJellybeanMr1() {
        super();
    }

    public static int getLayoutDirection(Drawable arg4) {
        if(!DrawableCompatJellybeanMr1.sGetLayoutDirectionMethodFetched) {
            try {
                DrawableCompatJellybeanMr1.sGetLayoutDirectionMethod = Drawable.class.getDeclaredMethod("getLayoutDirection");
                DrawableCompatJellybeanMr1.sGetLayoutDirectionMethod.setAccessible(true);
            }
            catch(NoSuchMethodException v0) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", ((Throwable)v0));
            }

            DrawableCompatJellybeanMr1.sGetLayoutDirectionMethodFetched = true;
        }

        if(DrawableCompatJellybeanMr1.sGetLayoutDirectionMethod != null) {
            try {
                int v0_2 = DrawableCompatJellybeanMr1.sGetLayoutDirectionMethod.invoke(arg4).intValue();
                return v0_2;
            }
            catch(Exception v0_1) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", ((Throwable)v0_1));
                DrawableCompatJellybeanMr1.sGetLayoutDirectionMethod = null;
            }
        }

        return -1;
    }

    public static boolean setLayoutDirection(Drawable arg7, int arg8) {
        boolean v0 = true;
        if(!DrawableCompatJellybeanMr1.sSetLayoutDirectionMethodFetched) {
            try {
                DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod.setAccessible(true);
            }
            catch(NoSuchMethodException v2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", ((Throwable)v2));
            }

            DrawableCompatJellybeanMr1.sSetLayoutDirectionMethodFetched = true;
        }

        if(DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod != null) {
            try {
                DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod.invoke(arg7, Integer.valueOf(arg8));
                return v0;
            }
            catch(Exception v0_1) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", ((Throwable)v0_1));
                DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod = null;
            }
        }

        return false;
    }
}

