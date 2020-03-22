package android.support.v4.h;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.view.View$AccessibilityDelegate;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

public class p {
    class a extends j {
        a() {
            super();
        }

        public boolean a(View arg2) {
            return arg2.hasOnClickListeners();
        }
    }

    class b extends a {
        b() {
            super();
        }

        public void a(View arg1, Drawable arg2) {
            arg1.setBackground(arg2);
        }

        public void a(View arg1, Runnable arg2) {
            arg1.postOnAnimation(arg2);
        }

        public void a(View arg2, Runnable arg3, long arg4) {
            arg2.postOnAnimationDelayed(arg3, arg4);
        }

        public void b(View arg1) {
            arg1.postInvalidateOnAnimation();
        }

        public int c(View arg2) {
            return arg2.getMinimumHeight();
        }

        public void d(View arg1) {
            arg1.requestFitSystemWindows();
        }

        public boolean e(View arg2) {
            return arg2.hasOverlappingRendering();
        }
    }

    class c extends b {
        c() {
            super();
        }

        public int f(View arg2) {
            return arg2.getLayoutDirection();
        }

        public int g(View arg2) {
            return arg2.getWindowSystemUiVisibility();
        }
    }

    class d extends c {
        d() {
            super();
        }
    }

    class e extends d {
        e() {
            super();
        }

        public boolean h(View arg2) {
            return arg2.isLaidOut();
        }

        public boolean i(View arg2) {
            return arg2.isAttachedToWindow();
        }
    }

    class f extends e {
        f() {
            super();
        }

        public v a(View arg3, v arg4) {
            Object v0 = v.a(arg4);
            WindowInsets v1 = arg3.onApplyWindowInsets(((WindowInsets)v0));
            if(v1 != v0) {
                WindowInsets v0_1 = new WindowInsets(v1);
            }

            return v.a(v0);
        }

        public void a(View arg1, float arg2) {
            arg1.setElevation(arg2);
        }

        public void a(View arg3, ColorStateList arg4) {
            arg3.setBackgroundTintList(arg4);
            if(Build$VERSION.SDK_INT == 21) {
                Drawable v1 = arg3.getBackground();
                int v0 = arg3.getBackgroundTintList() == null || arg3.getBackgroundTintMode() == null ? 0 : 1;
                if(v1 == null) {
                    return;
                }

                if(v0 == 0) {
                    return;
                }

                if(v1.isStateful()) {
                    v1.setState(arg3.getDrawableState());
                }

                arg3.setBackground(v1);
            }
        }

        public void a(View arg3, PorterDuff$Mode arg4) {
            arg3.setBackgroundTintMode(arg4);
            if(Build$VERSION.SDK_INT == 21) {
                Drawable v1 = arg3.getBackground();
                int v0 = arg3.getBackgroundTintList() == null || arg3.getBackgroundTintMode() == null ? 0 : 1;
                if(v1 == null) {
                    return;
                }

                if(v0 == 0) {
                    return;
                }

                if(v1.isStateful()) {
                    v1.setState(arg3.getDrawableState());
                }

                arg3.setBackground(v1);
            }
        }

        public void a(View arg2, n arg3) {
            if(arg3 == null) {
                arg2.setOnApplyWindowInsetsListener(null);
            }
            else {
                arg2.setOnApplyWindowInsetsListener(new View$OnApplyWindowInsetsListener(arg3) {
                    public WindowInsets onApplyWindowInsets(View arg3, WindowInsets arg4) {
                        return v.a(this.a.a(arg3, v.a(arg4)));
                    }
                });
            }
        }

        public void d(View arg1) {
            arg1.requestApplyInsets();
        }

        public String j(View arg2) {
            return arg2.getTransitionName();
        }

        public void k(View arg1) {
            arg1.stopNestedScroll();
        }

        public ColorStateList l(View arg2) {
            return arg2.getBackgroundTintList();
        }

        public PorterDuff$Mode m(View arg2) {
            return arg2.getBackgroundTintMode();
        }
    }

    class g extends f {
        g() {
            super();
        }

        public void a(View arg1, int arg2, int arg3) {
            arg1.setScrollIndicators(arg2, arg3);
        }
    }

    class h extends g {
        h() {
            super();
        }
    }

    class i extends h {
        i() {
            super();
        }
    }

    class j {
        WeakHashMap a;
        static boolean b;
        private static Field c;
        private static boolean d;
        private static WeakHashMap e;

        static {
            j.b = false;
        }

        j() {
            super();
            this.a = null;
        }

        public v a(View arg1, v arg2) {
            return arg2;
        }

        public void a(View arg1, float arg2) {
        }

        public void a(View arg1, int arg2, int arg3) {
        }

        public void a(View arg2, ColorStateList arg3) {
            if((arg2 instanceof o)) {
                ((o)arg2).setSupportBackgroundTintList(arg3);
            }
        }

        public void a(View arg2, PorterDuff$Mode arg3) {
            if((arg2 instanceof o)) {
                ((o)arg2).setSupportBackgroundTintMode(arg3);
            }
        }

        public void a(View arg1, Drawable arg2) {
            arg1.setBackgroundDrawable(arg2);
        }

        public void a(View arg2, android.support.v4.h.b arg3) {
            View$AccessibilityDelegate v0 = arg3 == null ? null : arg3.a();
            arg2.setAccessibilityDelegate(v0);
        }

        public void a(View arg1, n arg2) {
        }

        public void a(View arg3, Runnable arg4) {
            arg3.postDelayed(arg4, this.a());
        }

        public void a(View arg4, Runnable arg5, long arg6) {
            arg4.postDelayed(arg5, this.a() + arg6);
        }

        public boolean a(View arg2) {
            return 0;
        }

        long a() {
            return ValueAnimator.getFrameDelay();
        }

        public void b(View arg1) {
            arg1.postInvalidate();
        }

        public int c(View arg4) {
            if(!j.d) {
                try {
                    j.c = View.class.getDeclaredField("mMinHeight");
                    j.c.setAccessible(true);
                }
                catch(NoSuchFieldException v0) {
                }

                j.d = true;
            }

            if(j.c != null) {
                try {
                    int v0_2 = j.c.get(arg4).intValue();
                    return v0_2;
                }
                catch(Exception v0_1) {
                }
            }

            return 0;
        }

        public void d(View arg1) {
        }

        public boolean e(View arg2) {
            return 1;
        }

        public int f(View arg2) {
            return 0;
        }

        public int g(View arg2) {
            return 0;
        }

        public boolean h(View arg2) {
            boolean v0 = arg2.getWidth() <= 0 || arg2.getHeight() <= 0 ? false : true;
            return v0;
        }

        public boolean i(View arg2) {
            boolean v0 = arg2.getWindowToken() != null ? true : false;
            return v0;
        }

        public String j(View arg2) {
            String v0;
            if(j.e == null) {
                v0 = null;
            }
            else {
                Object v0_1 = j.e.get(arg2);
            }

            return v0;
        }

        public void k(View arg2) {
            if((arg2 instanceof android.support.v4.h.h)) {
                ((android.support.v4.h.h)arg2).stopNestedScroll();
            }
        }

        public ColorStateList l(View arg2) {
            ColorStateList v0 = (arg2 instanceof o) ? ((o)arg2).getSupportBackgroundTintList() : null;
            return v0;
        }

        public PorterDuff$Mode m(View arg2) {
            PorterDuff$Mode v0 = (arg2 instanceof o) ? ((o)arg2).getSupportBackgroundTintMode() : null;
            return v0;
        }

        public r n(View arg3) {
            if(this.a == null) {
                this.a = new WeakHashMap();
            }

            Object v0 = this.a.get(arg3);
            if(v0 == null) {
                r v0_1 = new r(arg3);
                this.a.put(arg3, v0_1);
            }

            return ((r)v0);
        }
    }

    static final j a;

    static {
        if(Build$VERSION.SDK_INT >= 26) {
            p.a = new i();
        }
        else if(Build$VERSION.SDK_INT >= 24) {
            p.a = new h();
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            p.a = new g();
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            p.a = new f();
        }
        else if(Build$VERSION.SDK_INT >= 19) {
            p.a = new e();
        }
        else if(Build$VERSION.SDK_INT >= 18) {
            p.a = new d();
        }
        else if(Build$VERSION.SDK_INT >= 17) {
            p.a = new c();
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            p.a = new b();
        }
        else if(Build$VERSION.SDK_INT >= 15) {
            p.a = new a();
        }
        else {
            p.a = new j();
        }
    }

    public static v a(View arg1, v arg2) {
        return p.a.a(arg1, arg2);
    }

    public static void a(View arg1) {
        p.a.b(arg1);
    }

    public static void a(View arg1, float arg2) {
        p.a.a(arg1, arg2);
    }

    public static void a(View arg1, int arg2, int arg3) {
        p.a.a(arg1, arg2, arg3);
    }

    public static void a(View arg1, ColorStateList arg2) {
        p.a.a(arg1, arg2);
    }

    public static void a(View arg1, PorterDuff$Mode arg2) {
        p.a.a(arg1, arg2);
    }

    public static void a(View arg1, Drawable arg2) {
        p.a.a(arg1, arg2);
    }

    public static void a(View arg1, android.support.v4.h.b arg2) {
        p.a.a(arg1, arg2);
    }

    public static void a(View arg1, n arg2) {
        p.a.a(arg1, arg2);
    }

    public static void a(View arg1, Runnable arg2) {
        p.a.a(arg1, arg2);
    }

    public static void a(View arg2, Runnable arg3, long arg4) {
        p.a.a(arg2, arg3, arg4);
    }

    public static int b(View arg1) {
        return p.a.f(arg1);
    }

    public static int c(View arg1) {
        return p.a.c(arg1);
    }

    public static r d(View arg1) {
        return p.a.n(arg1);
    }

    public static String e(View arg1) {
        return p.a.j(arg1);
    }

    public static int f(View arg1) {
        return p.a.g(arg1);
    }

    public static void g(View arg1) {
        p.a.d(arg1);
    }

    public static boolean h(View arg1) {
        return p.a.e(arg1);
    }

    public static ColorStateList i(View arg1) {
        return p.a.l(arg1);
    }

    public static PorterDuff$Mode j(View arg1) {
        return p.a.m(arg1);
    }

    public static void k(View arg1) {
        p.a.k(arg1);
    }

    public static boolean l(View arg1) {
        return p.a.h(arg1);
    }

    public static boolean m(View arg1) {
        return p.a.i(arg1);
    }

    public static boolean n(View arg1) {
        return p.a.a(arg1);
    }
}

