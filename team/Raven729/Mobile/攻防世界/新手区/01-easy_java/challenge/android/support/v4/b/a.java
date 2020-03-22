package android.support.v4.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.util.TypedValue;

public class a {
    private static final Object a;
    private static TypedValue b;

    static {
        a.a = new Object();
    }

    public static final Drawable a(Context arg4, int arg5) {
        int v0_2;
        Drawable v0;
        if(Build$VERSION.SDK_INT >= 21) {
            v0 = arg4.getDrawable(arg5);
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            v0 = arg4.getResources().getDrawable(arg5);
        }
        else {
            Object v1 = a.a;
            __monitor_enter(v1);
            try {
                if(a.b == null) {
                    a.b = new TypedValue();
                }

                arg4.getResources().getValue(arg5, a.b, true);
                v0_2 = a.b.resourceId;
                __monitor_exit(v1);
            }
            catch(Throwable v0_1) {
                try {
                label_29:
                    __monitor_exit(v1);
                }
                catch(Throwable v0_1) {
                    goto label_29;
                }

                throw v0_1;
            }

            v0 = arg4.getResources().getDrawable(v0_2);
        }

        return v0;
    }

    public static boolean a(Context arg2, Intent[] arg3, Bundle arg4) {
        if(Build$VERSION.SDK_INT >= 16) {
            arg2.startActivities(arg3, arg4);
        }
        else {
            arg2.startActivities(arg3);
        }

        return 1;
    }

    public static final ColorStateList b(Context arg2, int arg3) {
        ColorStateList v0 = Build$VERSION.SDK_INT >= 23 ? arg2.getColorStateList(arg3) : arg2.getResources().getColorStateList(arg3);
        return v0;
    }
}

