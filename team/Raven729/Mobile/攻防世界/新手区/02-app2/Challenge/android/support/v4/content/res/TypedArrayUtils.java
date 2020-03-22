package android.support.v4.content.res;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.AnyRes;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleableRes;
import android.util.TypedValue;

@RestrictTo(value={Scope.LIBRARY_GROUP}) public class TypedArrayUtils {
    public TypedArrayUtils() {
        super();
    }

    public static int getAttr(Context arg3, int arg4, int arg5) {
        TypedValue v0 = new TypedValue();
        arg3.getTheme().resolveAttribute(arg4, v0, true);
        if(v0.resourceId == 0) {
            arg4 = arg5;
        }

        return arg4;
    }

    public static boolean getBoolean(TypedArray arg1, @StyleableRes int arg2, @StyleableRes int arg3, boolean arg4) {
        return arg1.getBoolean(arg2, arg1.getBoolean(arg3, arg4));
    }

    public static Drawable getDrawable(TypedArray arg1, @StyleableRes int arg2, @StyleableRes int arg3) {
        Drawable v0 = arg1.getDrawable(arg2);
        if(v0 == null) {
            v0 = arg1.getDrawable(arg3);
        }

        return v0;
    }

    public static int getInt(TypedArray arg1, @StyleableRes int arg2, @StyleableRes int arg3, int arg4) {
        return arg1.getInt(arg2, arg1.getInt(arg3, arg4));
    }

    @AnyRes public static int getResourceId(TypedArray arg1, @StyleableRes int arg2, @StyleableRes int arg3, @AnyRes int arg4) {
        return arg1.getResourceId(arg2, arg1.getResourceId(arg3, arg4));
    }

    public static String getString(TypedArray arg1, @StyleableRes int arg2, @StyleableRes int arg3) {
        String v0 = arg1.getString(arg2);
        if(v0 == null) {
            v0 = arg1.getString(arg3);
        }

        return v0;
    }

    public static CharSequence getText(TypedArray arg1, @StyleableRes int arg2, @StyleableRes int arg3) {
        CharSequence v0 = arg1.getText(arg2);
        if(v0 == null) {
            v0 = arg1.getText(arg3);
        }

        return v0;
    }

    public static CharSequence[] getTextArray(TypedArray arg1, @StyleableRes int arg2, @StyleableRes int arg3) {
        CharSequence[] v0 = arg1.getTextArray(arg2);
        if(v0 == null) {
            v0 = arg1.getTextArray(arg3);
        }

        return v0;
    }
}

