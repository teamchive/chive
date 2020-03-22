package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.widget.TextView;

@TargetApi(value=23) @RequiresApi(value=23) class TextViewCompatApi23 {
    TextViewCompatApi23() {
        super();
    }

    public static void setTextAppearance(@NonNull TextView arg0, @StyleRes int arg1) {
        arg0.setTextAppearance(arg1);
    }
}

