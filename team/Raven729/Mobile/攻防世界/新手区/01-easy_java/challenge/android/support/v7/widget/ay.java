package android.support.v7.widget;

import android.annotation.TargetApi;
import android.os.Build$VERSION;
import android.view.View;

public class ay {
    class android.support.v7.widget.ay$1 {
    }

    @TargetApi(value=26) class a implements c {
        a(android.support.v7.widget.ay$1 arg1) {
            this();
        }

        private a() {
            super();
        }

        public void a(View arg1, CharSequence arg2) {
            arg1.setTooltipText(arg2);
        }
    }

    class b implements c {
        b(android.support.v7.widget.ay$1 arg1) {
            this();
        }

        private b() {
            super();
        }

        public void a(View arg1, CharSequence arg2) {
            az.a(arg1, arg2);
        }
    }

    interface c {
        void a(View arg1, CharSequence arg2);
    }

    private static final c a;

    static {
        android.support.v7.widget.ay$1 v2 = null;
        ay.a = Build$VERSION.SDK_INT >= 26 ? new a(v2) : new b(v2);
    }

    public static void a(View arg1, CharSequence arg2) {
        ay.a.a(arg1, arg2);
    }
}

