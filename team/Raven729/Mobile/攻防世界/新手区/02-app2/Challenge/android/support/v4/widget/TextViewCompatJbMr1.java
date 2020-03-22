package android.support.v4.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

@TargetApi(value=17) @RequiresApi(value=17) class TextViewCompatJbMr1 {
    TextViewCompatJbMr1() {
        super();
    }

    public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView arg5) {
        int v4 = 2;
        int v0 = 1;
        if(arg5.getLayoutDirection() != 1) {
            v0 = 0;
        }

        Drawable[] v2 = arg5.getCompoundDrawables();
        if(v0 != 0) {
            Drawable v0_1 = v2[v4];
            Drawable v3 = v2[0];
            v2[0] = v0_1;
            v2[v4] = v3;
        }

        return v2;
    }

    public static void setCompoundDrawablesRelative(@NonNull TextView arg2, @Nullable Drawable arg3, @Nullable Drawable arg4, @Nullable Drawable arg5, @Nullable Drawable arg6) {
        int v1 = arg2.getLayoutDirection() == 1 ? 1 : 0;
        Drawable v0 = v1 != 0 ? arg5 : arg3;
        if(v1 == 0) {
            arg3 = arg5;
        }

        arg2.setCompoundDrawables(v0, arg4, arg3, arg6);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView arg2, int arg3, int arg4, int arg5, int arg6) {
        int v1 = arg2.getLayoutDirection() == 1 ? 1 : 0;
        int v0 = v1 != 0 ? arg5 : arg3;
        if(v1 == 0) {
            arg3 = arg5;
        }

        arg2.setCompoundDrawablesWithIntrinsicBounds(v0, arg4, arg3, arg6);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView arg2, @Nullable Drawable arg3, @Nullable Drawable arg4, @Nullable Drawable arg5, @Nullable Drawable arg6) {
        int v1 = arg2.getLayoutDirection() == 1 ? 1 : 0;
        Drawable v0 = v1 != 0 ? arg5 : arg3;
        if(v1 == 0) {
            arg3 = arg5;
        }

        arg2.setCompoundDrawablesWithIntrinsicBounds(v0, arg4, arg3, arg6);
    }
}

