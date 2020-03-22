package android.support.v4.h;

import android.os.Build$VERSION;
import android.view.ViewGroup$MarginLayoutParams;

public final class f {
    public static int a(ViewGroup$MarginLayoutParams arg2) {
        int v0 = Build$VERSION.SDK_INT >= 17 ? arg2.getMarginStart() : arg2.leftMargin;
        return v0;
    }

    public static int b(ViewGroup$MarginLayoutParams arg2) {
        int v0 = Build$VERSION.SDK_INT >= 17 ? arg2.getMarginEnd() : arg2.rightMargin;
        return v0;
    }
}

