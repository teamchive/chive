package android.support.v4.graphics;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;

@TargetApi(value=18) @RequiresApi(value=18) class BitmapCompatJellybeanMR2 {
    BitmapCompatJellybeanMR2() {
        super();
    }

    public static boolean hasMipMap(Bitmap arg1) {
        return arg1.hasMipMap();
    }

    public static void setHasMipMap(Bitmap arg0, boolean arg1) {
        arg0.setHasMipMap(arg1);
    }
}

