package android.support.v4.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

@TargetApi(value=18) @RequiresApi(value=18) class TextViewCompatJbMr2 {
    TextViewCompatJbMr2() {
        super();
    }

    public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView arg1) {
        return arg1.getCompoundDrawablesRelative();
    }

    public static void setCompoundDrawablesRelative(@NonNull TextView arg0, @Nullable Drawable arg1, @Nullable Drawable arg2, @Nullable Drawable arg3, @Nullable Drawable arg4) {
        arg0.setCompoundDrawablesRelative(arg1, arg2, arg3, arg4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView arg0, @DrawableRes int arg1, @DrawableRes int arg2, @DrawableRes int arg3, @DrawableRes int arg4) {
        arg0.setCompoundDrawablesRelativeWithIntrinsicBounds(arg1, arg2, arg3, arg4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView arg0, @Nullable Drawable arg1, @Nullable Drawable arg2, @Nullable Drawable arg3, @Nullable Drawable arg4) {
        arg0.setCompoundDrawablesRelativeWithIntrinsicBounds(arg1, arg2, arg3, arg4);
    }
}

