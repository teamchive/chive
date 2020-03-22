package android.support.v4.print;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;

@TargetApi(value=24) @RequiresApi(value=24) class PrintHelperApi24 extends PrintHelperApi23 {
    PrintHelperApi24(Context arg2) {
        super(arg2);
        this.mIsMinMarginsHandlingCorrect = true;
        this.mPrintActivityRespectsOrientation = true;
    }
}

