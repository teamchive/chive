package android.support.v4.graphics;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;

@TargetApi(value=19) @RequiresApi(value=19) class BitmapCompatKitKat {
    BitmapCompatKitKat() {
        super();
    }

    static int getAllocationByteCount(Bitmap arg1) {
        return arg1.getAllocationByteCount();
    }
}

