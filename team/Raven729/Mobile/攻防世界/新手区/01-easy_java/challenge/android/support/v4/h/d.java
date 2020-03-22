package android.support.v4.h;

import android.os.Build$VERSION;
import android.view.Gravity;

public final class d {
    public static int a(int arg2, int arg3) {
        int v0 = Build$VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(arg2, arg3) : 0xFF7FFFFF & arg2;
        return v0;
    }
}

