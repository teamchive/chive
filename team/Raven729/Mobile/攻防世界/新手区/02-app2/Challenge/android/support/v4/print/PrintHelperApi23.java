package android.support.v4.print;

import android.annotation.TargetApi;
import android.content.Context;
import android.print.PrintAttributes$Builder;
import android.print.PrintAttributes;
import android.support.annotation.RequiresApi;

@TargetApi(value=23) @RequiresApi(value=23) class PrintHelperApi23 extends PrintHelperApi20 {
    PrintHelperApi23(Context arg2) {
        super(arg2);
        this.mIsMinMarginsHandlingCorrect = false;
    }

    protected PrintAttributes$Builder copyAttributes(PrintAttributes arg3) {
        PrintAttributes$Builder v0 = super.copyAttributes(arg3);
        if(arg3.getDuplexMode() != 0) {
            v0.setDuplexMode(arg3.getDuplexMode());
        }

        return v0;
    }
}

