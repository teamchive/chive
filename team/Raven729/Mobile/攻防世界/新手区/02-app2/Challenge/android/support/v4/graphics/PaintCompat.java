package android.support.v4.graphics;

import android.graphics.Paint;
import android.os.Build$VERSION;
import android.support.annotation.NonNull;

public final class PaintCompat {
    private PaintCompat() {
        super();
    }

    public static boolean hasGlyph(@NonNull Paint arg2, @NonNull String arg3) {
        boolean v0 = Build$VERSION.SDK_INT >= 23 ? PaintCompatApi23.hasGlyph(arg2, arg3) : PaintCompatGingerbread.hasGlyph(arg2, arg3);
        return v0;
    }
}

