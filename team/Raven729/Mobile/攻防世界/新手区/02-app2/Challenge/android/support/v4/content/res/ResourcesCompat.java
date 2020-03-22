package android.support.v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class ResourcesCompat {
    private ResourcesCompat() {
        super();
    }

    @ColorInt public static int getColor(@NonNull Resources arg2, @ColorRes int arg3, @Nullable Resources$Theme arg4) {
        int v0 = Build$VERSION.SDK_INT >= 23 ? ResourcesCompatApi23.getColor(arg2, arg3, arg4) : arg2.getColor(arg3);
        return v0;
    }

    @Nullable public static ColorStateList getColorStateList(@NonNull Resources arg2, @ColorRes int arg3, @Nullable Resources$Theme arg4) {
        ColorStateList v0 = Build$VERSION.SDK_INT >= 23 ? ResourcesCompatApi23.getColorStateList(arg2, arg3, arg4) : arg2.getColorStateList(arg3);
        return v0;
    }

    @Nullable public static Drawable getDrawable(@NonNull Resources arg2, @DrawableRes int arg3, @Nullable Resources$Theme arg4) {
        Drawable v0 = Build$VERSION.SDK_INT >= 21 ? ResourcesCompatApi21.getDrawable(arg2, arg3, arg4) : arg2.getDrawable(arg3);
        return v0;
    }

    @Nullable public static Drawable getDrawableForDensity(@NonNull Resources arg2, @DrawableRes int arg3, int arg4, @Nullable Resources$Theme arg5) {
        Drawable v0;
        if(Build$VERSION.SDK_INT >= 21) {
            v0 = ResourcesCompatApi21.getDrawableForDensity(arg2, arg3, arg4, arg5);
        }
        else if(Build$VERSION.SDK_INT >= 15) {
            v0 = ResourcesCompatIcsMr1.getDrawableForDensity(arg2, arg3, arg4);
        }
        else {
            v0 = arg2.getDrawable(arg3);
        }

        return v0;
    }
}

