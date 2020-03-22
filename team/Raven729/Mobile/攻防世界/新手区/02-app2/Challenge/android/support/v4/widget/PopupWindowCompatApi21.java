package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

@TargetApi(value=21) @RequiresApi(value=21) class PopupWindowCompatApi21 {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Field sOverlapAnchorField;

    static {
        try {
            PopupWindowCompatApi21.sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            PopupWindowCompatApi21.sOverlapAnchorField.setAccessible(true);
        }
        catch(NoSuchFieldException v0) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", ((Throwable)v0));
        }
    }

    PopupWindowCompatApi21() {
        super();
    }

    static boolean getOverlapAnchor(PopupWindow arg3) {
        if(PopupWindowCompatApi21.sOverlapAnchorField != null) {
            try {
                boolean v0_1 = PopupWindowCompatApi21.sOverlapAnchorField.get(arg3).booleanValue();
                return v0_1;
            }
            catch(IllegalAccessException v0) {
                Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", ((Throwable)v0));
            }
        }

        return false;
    }

    static void setOverlapAnchor(PopupWindow arg3, boolean arg4) {
        if(PopupWindowCompatApi21.sOverlapAnchorField != null) {
            try {
                PopupWindowCompatApi21.sOverlapAnchorField.set(arg3, Boolean.valueOf(arg4));
            }
            catch(IllegalAccessException v0) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", ((Throwable)v0));
            }
        }
    }
}

