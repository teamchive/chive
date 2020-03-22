package android.support.v4.widget;

import android.os.Build$VERSION;
import android.widget.EdgeEffect;

public final class e {
    class a extends b {
        a() {
            super();
        }

        public void a(EdgeEffect arg1, float arg2, float arg3) {
            arg1.onPull(arg2, arg3);
        }
    }

    class b {
        b() {
            super();
        }

        public void a(EdgeEffect arg1, float arg2, float arg3) {
            arg1.onPull(arg2);
        }
    }

    private static final b a;

    static {
        e.a = Build$VERSION.SDK_INT >= 21 ? new a() : new b();
    }

    public static void a(EdgeEffect arg1, float arg2, float arg3) {
        e.a.a(arg1, arg2, arg3);
    }
}

