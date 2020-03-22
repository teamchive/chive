package android.support.v4.h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.os.Build$VERSION;
import android.util.Log;
import android.view.MenuItem;

public final class g {
    class a extends b {
        a() {
            super();
        }

        public void a(MenuItem arg1, char arg2, int arg3) {
            arg1.setAlphabeticShortcut(arg2, arg3);
        }

        public void a(MenuItem arg1, ColorStateList arg2) {
            arg1.setIconTintList(arg2);
        }

        public void a(MenuItem arg1, PorterDuff$Mode arg2) {
            arg1.setIconTintMode(arg2);
        }

        public void a(MenuItem arg1, CharSequence arg2) {
            arg1.setContentDescription(arg2);
        }

        public void b(MenuItem arg1, char arg2, int arg3) {
            arg1.setNumericShortcut(arg2, arg3);
        }

        public void b(MenuItem arg1, CharSequence arg2) {
            arg1.setTooltipText(arg2);
        }
    }

    class b implements c {
        b() {
            super();
        }

        public void a(MenuItem arg1, char arg2, int arg3) {
        }

        public void a(MenuItem arg1, ColorStateList arg2) {
        }

        public void a(MenuItem arg1, PorterDuff$Mode arg2) {
        }

        public void a(MenuItem arg1, CharSequence arg2) {
        }

        public void b(MenuItem arg1, char arg2, int arg3) {
        }

        public void b(MenuItem arg1, CharSequence arg2) {
        }
    }

    interface c {
        void a(MenuItem arg1, ColorStateList arg2);

        void a(MenuItem arg1, PorterDuff$Mode arg2);

        void a(MenuItem arg1, CharSequence arg2);

        void a(MenuItem arg1, char arg2, int arg3);

        void b(MenuItem arg1, char arg2, int arg3);

        void b(MenuItem arg1, CharSequence arg2);
    }

    static final c a;

    static {
        g.a = Build$VERSION.SDK_INT >= 26 ? new a() : new b();
    }

    public static MenuItem a(MenuItem arg2, android.support.v4.h.c arg3) {
        android.support.v4.d.a.b v2;
        if((arg2 instanceof android.support.v4.d.a.b)) {
            v2 = ((android.support.v4.d.a.b)arg2).a(arg3);
        }
        else {
            Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        }

        return ((MenuItem)v2);
    }

    public static void a(MenuItem arg1, char arg2, int arg3) {
        if((arg1 instanceof android.support.v4.d.a.b)) {
            ((android.support.v4.d.a.b)arg1).setNumericShortcut(arg2, arg3);
        }
        else {
            g.a.b(arg1, arg2, arg3);
        }
    }

    public static void a(MenuItem arg1, ColorStateList arg2) {
        if((arg1 instanceof android.support.v4.d.a.b)) {
            ((android.support.v4.d.a.b)arg1).setIconTintList(arg2);
        }
        else {
            g.a.a(arg1, arg2);
        }
    }

    public static void a(MenuItem arg1, PorterDuff$Mode arg2) {
        if((arg1 instanceof android.support.v4.d.a.b)) {
            ((android.support.v4.d.a.b)arg1).setIconTintMode(arg2);
        }
        else {
            g.a.a(arg1, arg2);
        }
    }

    public static void a(MenuItem arg1, CharSequence arg2) {
        if((arg1 instanceof android.support.v4.d.a.b)) {
            ((android.support.v4.d.a.b)arg1).a(arg2);
        }
        else {
            g.a.a(arg1, arg2);
        }
    }

    public static void b(MenuItem arg1, char arg2, int arg3) {
        if((arg1 instanceof android.support.v4.d.a.b)) {
            ((android.support.v4.d.a.b)arg1).setAlphabeticShortcut(arg2, arg3);
        }
        else {
            g.a.a(arg1, arg2, arg3);
        }
    }

    public static void b(MenuItem arg1, CharSequence arg2) {
        if((arg1 instanceof android.support.v4.d.a.b)) {
            ((android.support.v4.d.a.b)arg1).b(arg2);
        }
        else {
            g.a.b(arg1, arg2);
        }
    }
}

