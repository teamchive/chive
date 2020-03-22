package android.support.v4.graphics;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;

@TargetApi(value=12) @RequiresApi(value=12) class BitmapCompatHoneycombMr1 {
    BitmapCompatHoneycombMr1() {
        super();
    }

    static int getAllocationByteCount(Bitmap arg1) {
        return arg1.getByteCount();
    }
}

