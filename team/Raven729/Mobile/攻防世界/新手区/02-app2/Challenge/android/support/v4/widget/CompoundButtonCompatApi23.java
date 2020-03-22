package android.support.v4.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.widget.CompoundButton;

@TargetApi(value=23) @RequiresApi(value=23) class CompoundButtonCompatApi23 {
    CompoundButtonCompatApi23() {
        super();
    }

    static Drawable getButtonDrawable(CompoundButton arg1) {
        return arg1.getButtonDrawable();
    }
}

