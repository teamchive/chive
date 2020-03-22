package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

@TargetApi(value=16) @RequiresApi(value=16) class TextViewCompatJb {
    TextViewCompatJb() {
        super();
    }

    static int getMaxLines(TextView arg1) {
        return arg1.getMaxLines();
    }

    static int getMinLines(TextView arg1) {
        return arg1.getMinLines();
    }
}

