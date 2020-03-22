package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.support.annotation.RequiresApi;
import android.widget.CompoundButton;

@TargetApi(value=21) @RequiresApi(value=21) class CompoundButtonCompatLollipop {
    CompoundButtonCompatLollipop() {
        super();
    }

    static ColorStateList getButtonTintList(CompoundButton arg1) {
        return arg1.getButtonTintList();
    }

    static PorterDuff$Mode getButtonTintMode(CompoundButton arg1) {
        return arg1.getButtonTintMode();
    }

    static void setButtonTintList(CompoundButton arg0, ColorStateList arg1) {
        arg0.setButtonTintList(arg1);
    }

    static void setButtonTintMode(CompoundButton arg0, PorterDuff$Mode arg1) {
        arg0.setButtonTintMode(arg1);
    }
}

