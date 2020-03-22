package android.support.v4.text;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import java.util.Locale;

@TargetApi(value=17) @RequiresApi(value=17) class TextUtilsCompatJellybeanMr1 {
    TextUtilsCompatJellybeanMr1() {
        super();
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale arg1) {
        return TextUtils.getLayoutDirectionFromLocale(arg1);
    }

    @NonNull public static String htmlEncode(@NonNull String arg1) {
        return TextUtils.htmlEncode(arg1);
    }
}

