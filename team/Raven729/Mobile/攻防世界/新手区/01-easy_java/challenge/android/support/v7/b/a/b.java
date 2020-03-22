package android.support.v7.b.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.v7.widget.l;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class b {
    class a {
        final ColorStateList a;
        final Configuration b;

        a(ColorStateList arg1, Configuration arg2) {
            super();
            this.a = arg1;
            this.b = arg2;
        }
    }

    private static final ThreadLocal a;
    private static final WeakHashMap b;
    private static final Object c;

    static {
        b.a = new ThreadLocal();
        b.b = new WeakHashMap(0);
        b.c = new Object();
    }

    public static ColorStateList a(Context arg2, int arg3) {
        ColorStateList v0;
        if(Build$VERSION.SDK_INT >= 23) {
            v0 = arg2.getColorStateList(arg3);
        }
        else {
            v0 = b.d(arg2, arg3);
            if(v0 == null) {
                v0 = b.c(arg2, arg3);
                if(v0 != null) {
                    b.a(arg2, arg3, v0);
                }
                else {
                    v0 = android.support.v4.b.a.b(arg2, arg3);
                }
            }
        }

        return v0;
    }

    private static void a(Context arg4, int arg5, ColorStateList arg6) {
        Object v1 = b.c;
        __monitor_enter(v1);
        try {
            Object v0_1 = b.b.get(arg4);
            if(v0_1 == null) {
                SparseArray v0_2 = new SparseArray();
                b.b.put(arg4, v0_2);
            }

            ((SparseArray)v0_1).append(arg5, new a(arg6, arg4.getResources().getConfiguration()));
            __monitor_exit(v1);
            return;
        label_17:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_17;
        }

        throw v0;
    }

    private static TypedValue a() {
        Object v0 = b.a.get();
        if(v0 == null) {
            TypedValue v0_1 = new TypedValue();
            b.a.set(v0_1);
        }

        return ((TypedValue)v0);
    }

    public static Drawable b(Context arg1, int arg2) {
        return l.a().a(arg1, arg2);
    }

    private static ColorStateList c(Context arg4, int arg5) {
        ColorStateList v0 = null;
        if(!b.e(arg4, arg5)) {
            Resources v1 = arg4.getResources();
            XmlResourceParser v2 = v1.getXml(arg5);
            try {
                v0 = android.support.v7.b.a.a.a(v1, ((XmlPullParser)v2), arg4.getTheme());
            }
            catch(Exception v1_1) {
                Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", ((Throwable)v1_1));
            }
        }

        return v0;
    }

    private static ColorStateList d(Context arg5, int arg6) {
        ColorStateList v0_2;
        Object v2 = b.c;
        __monitor_enter(v2);
        try {
            Object v0_1 = b.b.get(arg5);
            if(v0_1 == null || ((SparseArray)v0_1).size() <= 0) {
            label_18:
                __monitor_exit(v2);
                v0_2 = null;
            }
            else {
                Object v1 = ((SparseArray)v0_1).get(arg6);
                if(v1 == null) {
                    goto label_18;
                }
                else if(((a)v1).b.equals(arg5.getResources().getConfiguration())) {
                    v0_2 = ((a)v1).a;
                    __monitor_exit(v2);
                }
                else {
                    ((SparseArray)v0_1).remove(arg6);
                    goto label_18;
                }
            }

            return v0_2;
        label_22:
            __monitor_exit(v2);
        }
        catch(Throwable v0) {
            goto label_22;
        }

        throw v0;
    }

    private static boolean e(Context arg4, int arg5) {
        boolean v0 = true;
        Resources v1 = arg4.getResources();
        TypedValue v2 = b.a();
        v1.getValue(arg5, v2, true);
        if(v2.type < 28 || v2.type > 0x1F) {
            v0 = false;
        }

        return v0;
    }
}

