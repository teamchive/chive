package android.support.v4.graphics;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

@RequiresApi(value=23) class PaintCompatApi23 {
    PaintCompatApi23() {
        super();
    }

    static boolean hasGlyph(@NonNull Paint arg1, @NonNull String arg2) {
        return arg1.hasGlyph(arg2);
    }
}

