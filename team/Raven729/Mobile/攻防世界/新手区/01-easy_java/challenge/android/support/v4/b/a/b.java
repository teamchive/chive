package android.support.v4.b.a;

import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.v4.c.c;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class b {
    public static Drawable a(Resources arg2, int arg3, Resources$Theme arg4) {
        Drawable v0 = Build$VERSION.SDK_INT >= 21 ? arg2.getDrawable(arg3, arg4) : arg2.getDrawable(arg3);
        return v0;
    }

    public static Typeface a(Context arg1, int arg2, TypedValue arg3, int arg4, TextView arg5) {
        Typeface v0 = arg1.isRestricted() ? null : b.b(arg1, arg2, arg3, arg4, arg5);
        return v0;
    }

    private static Typeface a(Context arg8, Resources arg9, TypedValue arg10, int arg11, int arg12, TextView arg13) {
        Typeface v0;
        Typeface v6 = null;
        if(arg10.string == null) {
            throw new Resources$NotFoundException("Resource \"" + arg9.getResourceName(arg11) + "\" (" + Integer.toHexString(arg11) + ") is not a Font: " + arg10);
        }

        String v7 = arg10.string.toString();
        if(!v7.startsWith("res/")) {
            v0 = v6;
            return v0;
        }

        v0 = c.a(arg9, arg11, arg12);
        if(v0 == null) {
            try {
                if(v7.toLowerCase().endsWith(".xml")) {
                    a v1 = android.support.v4.b.a.a.a(arg9.getXml(arg11), arg9);
                    if(v1 == null) {
                        Log.e("ResourcesCompat", "Failed to find font-family tag");
                        return v6;
                    }

                    return c.a(arg8, v1, arg9, arg11, arg12, arg13);
                }

                return c.a(arg8, arg9, arg11, v7, arg12);
            }
            catch(IOException v0_1) {
                Log.e("ResourcesCompat", "Failed to read xml resource " + v7, ((Throwable)v0_1));
            }
            catch(XmlPullParserException v0_2) {
                Log.e("ResourcesCompat", "Failed to parse xml resource " + v7, ((Throwable)v0_2));
            }

            v0 = v6;
        }

        return v0;
    }

    private static Typeface b(Context arg6, int arg7, TypedValue arg8, int arg9, TextView arg10) {
        Resources v1 = arg6.getResources();
        v1.getValue(arg7, arg8, true);
        Typeface v0 = b.a(arg6, v1, arg8, arg7, arg9, arg10);
        if(v0 != null) {
            return v0;
        }

        throw new Resources$NotFoundException("Font resource ID #0x" + Integer.toHexString(arg7));
    }
}

