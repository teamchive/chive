package android.support.v4.b.a;

import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

public class c {
    public static TypedArray a(Resources arg1, Resources$Theme arg2, AttributeSet arg3, int[] arg4) {
        TypedArray v0 = arg2 == null ? arg1.obtainAttributes(arg3, arg4) : arg2.obtainStyledAttributes(arg3, arg4, 0, 0);
        return v0;
    }

    public static int a(TypedArray arg1, XmlPullParser arg2, String arg3, int arg4, int arg5) {
        if(c.a(arg2, arg3)) {
            arg5 = arg1.getInt(arg4, arg5);
        }

        return arg5;
    }

    public static float a(TypedArray arg1, XmlPullParser arg2, String arg3, int arg4, float arg5) {
        if(c.a(arg2, arg3)) {
            arg5 = arg1.getFloat(arg4, arg5);
        }

        return arg5;
    }

    public static String a(TypedArray arg1, XmlPullParser arg2, String arg3, int arg4) {
        String v0 = !c.a(arg2, arg3) ? null : arg1.getString(arg4);
        return v0;
    }

    public static boolean a(XmlPullParser arg1, String arg2) {
        boolean v0 = arg1.getAttributeValue("http://schemas.android.com/apk/res/android", arg2) != null ? true : false;
        return v0;
    }

    public static boolean a(TypedArray arg1, XmlPullParser arg2, String arg3, int arg4, boolean arg5) {
        if(c.a(arg2, arg3)) {
            arg5 = arg1.getBoolean(arg4, arg5);
        }

        return arg5;
    }

    public static TypedValue b(TypedArray arg1, XmlPullParser arg2, String arg3, int arg4) {
        TypedValue v0 = !c.a(arg2, arg3) ? null : arg1.peekValue(arg4);
        return v0;
    }

    public static int b(TypedArray arg1, XmlPullParser arg2, String arg3, int arg4, int arg5) {
        if(c.a(arg2, arg3)) {
            arg5 = arg1.getColor(arg4, arg5);
        }

        return arg5;
    }

    public static int c(TypedArray arg1, XmlPullParser arg2, String arg3, int arg4, int arg5) {
        if(c.a(arg2, arg3)) {
            arg5 = arg1.getResourceId(arg4, arg5);
        }

        return arg5;
    }
}

