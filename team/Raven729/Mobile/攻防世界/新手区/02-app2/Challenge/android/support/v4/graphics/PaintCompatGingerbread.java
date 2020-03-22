package android.support.v4.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Pair;

@RequiresApi(value=9) class PaintCompatGingerbread {
    private static final String TOFU_STRING = "\uDB3F\uDFFD";
    private static final ThreadLocal sRectThreadLocal;

    static {
        PaintCompatGingerbread.sRectThreadLocal = new ThreadLocal();
    }

    PaintCompatGingerbread() {
        super();
    }

    static boolean hasGlyph(@NonNull Paint arg9, @NonNull String arg10) {
        boolean v2 = false;
        int v4 = arg10.length();
        if(v4 != 1 || !Character.isWhitespace(arg10.charAt(0))) {
            float v5 = arg9.measureText("\uDB3F\uDFFD");
            float v6 = arg9.measureText(arg10);
            if(v6 != 0f) {
                if(arg10.codePointCount(0, arg10.length()) > 1) {
                    if(v6 <= 2f * v5) {
                        float v3 = 0f;
                        int v0;
                        for(v0 = 0; v0 < v4; v0 += v7) {
                            int v7 = Character.charCount(arg10.codePointAt(v0));
                            v3 += arg9.measureText(arg10, v0, v0 + v7);
                        }

                        if(v6 < v3) {
                            goto label_31;
                        }
                    }
                    else {
                    }

                    return v2;
                }

            label_31:
                if(v6 != v5) {
                    return true;
                }

                Pair v3_1 = PaintCompatGingerbread.obtainEmptyRects();
                arg9.getTextBounds("\uDB3F\uDFFD", 0, "\uDB3F\uDFFD".length(), v3_1.first);
                arg9.getTextBounds(arg10, 0, v4, v3_1.second);
                boolean v0_1 = !v3_1.first.equals(v3_1.second) ? true : false;
                v2 = v0_1;
            }
        }
        else {
            v2 = true;
        }

        return v2;
    }

    private static Pair obtainEmptyRects() {
        Object v0 = PaintCompatGingerbread.sRectThreadLocal.get();
        if(v0 == null) {
            Pair v0_1 = new Pair(new Rect(), new Rect());
            PaintCompatGingerbread.sRectThreadLocal.set(v0_1);
        }
        else {
            ((Pair)v0).first.setEmpty();
            ((Pair)v0).second.setEmpty();
        }

        return ((Pair)v0);
    }
}

