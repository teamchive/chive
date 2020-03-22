package android.support.v4.print;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;

@TargetApi(value=20) @RequiresApi(value=20) class PrintHelperApi20 extends PrintHelperKitkat {
    PrintHelperApi20(Context arg2) {
        super(arg2);
        this.mPrintActivityRespectsOrientation = false;
    }
}

