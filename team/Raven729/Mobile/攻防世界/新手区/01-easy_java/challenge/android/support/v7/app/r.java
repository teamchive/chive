package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.h.p;
import android.support.v4.h.s;
import android.support.v4.h.t;
import android.support.v4.h.u;
import android.support.v7.a.a$f;
import android.support.v7.a.a$j;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ad;
import android.support.v7.widget.ap;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class r extends a implements android.support.v7.widget.ActionBarOverlayLayout$a {
    class android.support.v7.app.r$1 extends t {
        android.support.v7.app.r$1(r arg1) {
            this.a = arg1;
            super();
        }

        public void b(View arg3) {
            if((this.a.k) && this.a.f != null) {
                this.a.f.setTranslationY(0f);
                this.a.c.setTranslationY(0f);
            }

            this.a.c.setVisibility(8);
            this.a.c.setTransitioning(false);
            this.a.n = null;
            this.a.h();
            if(this.a.b != null) {
                p.g(this.a.b);
            }
        }
    }

    class android.support.v7.app.r$2 extends t {
        android.support.v7.app.r$2(r arg1) {
            this.a = arg1;
            super();
        }

        public void b(View arg3) {
            this.a.n = null;
            this.a.c.requestLayout();
        }
    }

    class android.support.v7.app.r$3 implements u {
        android.support.v7.app.r$3(r arg1) {
            this.a = arg1;
            super();
        }

        public void a(View arg2) {
            this.a.c.getParent().invalidate();
        }
    }

    public class android.support.v7.app.r$a extends b implements android.support.v7.view.menu.h$a {
        private final Context b;
        private final h c;
        private android.support.v7.view.b$a d;
        private WeakReference e;

        public android.support.v7.app.r$a(r arg3, Context arg4, android.support.v7.view.b$a arg5) {
            this.a = arg3;
            super();
            this.b = arg4;
            this.d = arg5;
            this.c = new h(arg4).a(1);
            this.c.a(((android.support.v7.view.menu.h$a)this));
        }

        public MenuInflater a() {
            return new g(this.b);
        }

        public void a(int arg2) {
            this.b(this.a.a.getResources().getString(arg2));
        }

        public void a(h arg2) {
            if(this.d != null) {
                this.d();
                this.a.e.a();
            }
        }

        public void a(View arg2) {
            this.a.e.setCustomView(arg2);
            this.e = new WeakReference(arg2);
        }

        public void a(CharSequence arg2) {
            this.a.e.setSubtitle(arg2);
        }

        public void a(boolean arg2) {
            super.a(arg2);
            this.a.e.setTitleOptional(arg2);
        }

        public boolean a(h arg2, MenuItem arg3) {
            boolean v0 = this.d != null ? this.d.a(((b)this), arg3) : false;
            return v0;
        }

        public Menu b() {
            return this.c;
        }

        public void b(CharSequence arg2) {
            this.a.e.setTitle(arg2);
        }

        public void b(int arg2) {
            this.a(this.a.a.getResources().getString(arg2));
        }

        public void c() {
            android.support.v7.view.b$a v3 = null;
            if(this.a.h == this) {
                if(!r.a(this.a.l, this.a.m, false)) {
                    this.a.i = ((b)this);
                    this.a.j = this.d;
                }
                else {
                    this.d.a(((b)this));
                }

                this.d = v3;
                this.a.j(false);
                this.a.e.b();
                this.a.d.a().sendAccessibilityEvent(0x20);
                this.a.b.setHideOnContentScrollEnabled(this.a.o);
                this.a.h = ((android.support.v7.app.r$a)v3);
            }
        }

        public void d() {
            if(this.a.h == this) {
                this.c.g();
                try {
                    this.d.b(((b)this), this.c);
                }
                catch(Throwable v0) {
                    this.c.h();
                    throw v0;
                }

                this.c.h();
            }
        }

        public boolean e() {
            boolean v0_1;
            this.c.g();
            try {
                v0_1 = this.d.a(((b)this), this.c);
            }
            catch(Throwable v0) {
                this.c.h();
                throw v0;
            }

            this.c.h();
            return v0_1;
        }

        public CharSequence f() {
            return this.a.e.getTitle();
        }

        public CharSequence g() {
            return this.a.e.getSubtitle();
        }

        public boolean h() {
            return this.a.e.d();
        }

        public View i() {
            View v0_1;
            if(this.e != null) {
                Object v0 = this.e.get();
            }
            else {
                v0_1 = null;
            }

            return v0_1;
        }
    }

    private boolean A;
    private boolean B;
    private ArrayList C;
    private boolean D;
    private int E;
    private boolean F;
    private boolean G;
    private boolean H;
    Context a;
    ActionBarOverlayLayout b;
    ActionBarContainer c;
    ad d;
    ActionBarContextView e;
    View f;
    ap g;
    android.support.v7.app.r$a h;
    b i;
    android.support.v7.view.b$a j;
    boolean k;
    boolean l;
    boolean m;
    android.support.v7.view.h n;
    boolean o;
    final s p;
    final s q;
    final u r;
    private static final Interpolator t;
    private static final Interpolator u;
    private Context v;
    private Activity w;
    private Dialog x;
    private ArrayList y;
    private int z;

    static {
        boolean v0 = !r.class.desiredAssertionStatus() ? true : false;
        r.s = v0;
        r.t = new AccelerateInterpolator();
        r.u = new DecelerateInterpolator();
    }

    public r(Activity arg3, boolean arg4) {
        super();
        this.y = new ArrayList();
        this.z = -1;
        this.C = new ArrayList();
        this.E = 0;
        this.k = true;
        this.G = true;
        this.p = new android.support.v7.app.r$1(this);
        this.q = new android.support.v7.app.r$2(this);
        this.r = new android.support.v7.app.r$3(this);
        this.w = arg3;
        View v0 = arg3.getWindow().getDecorView();
        this.a(v0);
        if(!arg4) {
            this.f = v0.findViewById(0x1020002);
        }
    }

    public r(Dialog arg3) {
        super();
        this.y = new ArrayList();
        this.z = -1;
        this.C = new ArrayList();
        this.E = 0;
        this.k = true;
        this.G = true;
        this.p = new android.support.v7.app.r$1(this);
        this.q = new android.support.v7.app.r$2(this);
        this.r = new android.support.v7.app.r$3(this);
        this.x = arg3;
        this.a(arg3.getWindow().getDecorView());
    }

    private void a(View arg7) {
        this.b = arg7.findViewById(f.decor_content_parent);
        if(this.b != null) {
            this.b.setActionBarVisibilityCallback(((android.support.v7.widget.ActionBarOverlayLayout$a)this));
        }

        this.d = this.b(arg7.findViewById(f.action_bar));
        this.e = arg7.findViewById(f.action_context_bar);
        this.c = arg7.findViewById(f.action_bar_container);
        if(this.d != null && this.e != null && this.c != null) {
            this.a = this.d.b();
            int v0 = (this.d.o() & 4) != 0 ? 1 : 0;
            if(v0 != 0) {
                this.A = true;
            }

            android.support.v7.view.a v3 = android.support.v7.view.a.a(this.a);
            boolean v0_1 = (v3.f()) || v0 != 0 ? true : false;
            this.a(v0_1);
            this.k(v3.d());
            TypedArray v0_2 = this.a.obtainStyledAttributes(null, j.ActionBar, android.support.v7.a.a$a.actionBarStyle, 0);
            if(v0_2.getBoolean(j.ActionBar_hideOnContentScroll, false)) {
                this.b(true);
            }

            int v1 = v0_2.getDimensionPixelSize(j.ActionBar_elevation, 0);
            if(v1 != 0) {
                this.a(((float)v1));
            }

            v0_2.recycle();
            return;
        }

        throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
    }

    public void a(boolean arg2) {
        this.d.b(arg2);
    }

    public void a(float arg2) {
        p.a(this.c, arg2);
    }

    static boolean a(boolean arg1, boolean arg2, boolean arg3) {
        boolean v0 = true;
        if(!arg3 && ((arg1) || (arg2))) {
            v0 = false;
        }

        return v0;
    }

    public int a() {
        return this.d.o();
    }

    public b a(android.support.v7.view.b$a arg4) {
        b v0_1;
        if(this.h != null) {
            this.h.c();
        }

        this.b.setHideOnContentScrollEnabled(false);
        this.e.c();
        android.support.v7.app.r$a v0 = new android.support.v7.app.r$a(this, this.e.getContext(), arg4);
        if(v0.e()) {
            this.h = v0;
            v0.d();
            this.e.a(((b)v0));
            this.j(true);
            this.e.sendAccessibilityEvent(0x20);
        }
        else {
            v0_1 = null;
        }

        return v0_1;
    }

    public void a(int arg1) {
        this.E = arg1;
    }

    public void a(int arg5, int arg6) {
        int v0 = this.d.o();
        if((arg6 & 4) != 0) {
            this.A = true;
        }

        this.d.c(v0 & (arg6 ^ -1) | arg5 & arg6);
    }

    public void a(Configuration arg2) {
        this.k(android.support.v7.view.a.a(this.a).d());
    }

    public void a(CharSequence arg2) {
        this.d.a(arg2);
    }

    public boolean a(int arg5, KeyEvent arg6) {
        boolean v2 = false;
        if(this.h != null) {
            Menu v3 = this.h.b();
            if(v3 != null) {
                int v0 = arg6 != null ? arg6.getDeviceId() : -1;
                boolean v0_1 = KeyCharacterMap.load(v0).getKeyboardType() != 1 ? true : false;
                v3.setQwertyMode(v0_1);
                v2 = v3.performShortcut(arg5, arg6, 0);
            }
        }

        return v2;
    }

    private ad b(View arg4) {
        ad v4;
        if(!(arg4 instanceof ad)) {
            if((arg4 instanceof Toolbar)) {
                v4 = ((Toolbar)arg4).getWrapper();
            }
            else {
                goto label_7;
            }
        }

        return ((View)v4);
    label_7:
        String v0 = "Can\'t make a decor toolbar out of " + arg4 != null ? arg4.getClass().getSimpleName() : "null";
        throw new IllegalStateException(v0);
    }

    public void b(boolean arg3) {
        if((arg3) && !this.b.a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }

        this.o = arg3;
        this.b.setHideOnContentScrollEnabled(arg3);
    }

    public Context b() {
        if(this.v == null) {
            TypedValue v0 = new TypedValue();
            this.a.getTheme().resolveAttribute(android.support.v7.a.a$a.actionBarWidgetTheme, v0, true);
            int v0_1 = v0.resourceId;
            this.v = v0_1 != 0 ? new ContextThemeWrapper(this.a, v0_1) : this.a;
        }

        return this.v;
    }

    public void c(boolean arg2) {
        if(!this.A) {
            this.f(arg2);
        }
    }

    public void d(boolean arg2) {
        this.H = arg2;
        if(!arg2 && this.n != null) {
            this.n.c();
        }
    }

    public void e(boolean arg4) {
        if(arg4 != this.B) {
            this.B = arg4;
            int v2 = this.C.size();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                this.C.get(v1).a(arg4);
            }
        }
    }

    public void f(boolean arg3) {
        int v1 = 4;
        int v0 = arg3 ? v1 : 0;
        this.a(v0, v1);
    }

    public boolean f() {
        boolean v0;
        if(this.d == null || !this.d.c()) {
            v0 = false;
        }
        else {
            this.d.d();
            v0 = true;
        }

        return v0;
    }

    public void g(boolean arg1) {
        this.k = arg1;
    }

    public void h(boolean arg6) {
        if(this.n != null) {
            this.n.c();
        }

        this.c.setVisibility(0);
        if(this.E == 0) {
            if(!this.H && !arg6) {
                goto label_61;
            }

            this.c.setTranslationY(0f);
            float v0 = ((float)(-this.c.getHeight()));
            if(arg6) {
                int[] v1 = new int[]{0, 0};
                this.c.getLocationInWindow(v1);
                v0 -= ((float)v1[1]);
            }

            this.c.setTranslationY(v0);
            android.support.v7.view.h v1_1 = new android.support.v7.view.h();
            android.support.v4.h.r v2 = p.d(this.c).b(0f);
            v2.a(this.r);
            v1_1.a(v2);
            if((this.k) && this.f != null) {
                this.f.setTranslationY(v0);
                v1_1.a(p.d(this.f).b(0f));
            }

            v1_1.a(r.u);
            v1_1.a(0xFA);
            v1_1.a(this.q);
            this.n = v1_1;
            v1_1.a();
        }
        else {
        label_61:
            this.c.setAlpha(1f);
            this.c.setTranslationY(0f);
            if((this.k) && this.f != null) {
                this.f.setTranslationY(0f);
            }

            this.q.b(null);
        }

        if(this.b != null) {
            p.g(this.b);
        }
    }

    void h() {
        b v2 = null;
        if(this.j != null) {
            this.j.a(this.i);
            this.i = v2;
            this.j = ((android.support.v7.view.b$a)v2);
        }
    }

    public int i() {
        return this.d.p();
    }

    public void i(boolean arg6) {
        if(this.n != null) {
            this.n.c();
        }

        if(this.E == 0) {
            if(!this.H && !arg6) {
                goto label_52;
            }

            this.c.setAlpha(1f);
            this.c.setTransitioning(true);
            android.support.v7.view.h v1 = new android.support.v7.view.h();
            float v0 = ((float)(-this.c.getHeight()));
            if(arg6) {
                int[] v2 = new int[]{0, 0};
                this.c.getLocationInWindow(v2);
                v0 -= ((float)v2[1]);
            }

            android.support.v4.h.r v2_1 = p.d(this.c).b(v0);
            v2_1.a(this.r);
            v1.a(v2_1);
            if((this.k) && this.f != null) {
                v1.a(p.d(this.f).b(v0));
            }

            v1.a(r.t);
            v1.a(0xFA);
            v1.a(this.p);
            this.n = v1;
            v1.a();
        }
        else {
        label_52:
            this.p.b(null);
        }
    }

    public void j(boolean arg9) {
        android.support.v4.h.r v1_1;
        android.support.v4.h.r v0;
        long v6 = 200;
        long v4 = 100;
        int v3 = 8;
        int v1 = 4;
        if(arg9) {
            this.n();
        }
        else {
            this.o();
        }

        if(this.p()) {
            if(arg9) {
                v0 = this.d.a(v1, v4);
                v1_1 = this.e.a(0, v6);
            }
            else {
                v1_1 = this.d.a(0, v6);
                v0 = this.e.a(v3, v4);
            }

            android.support.v7.view.h v2 = new android.support.v7.view.h();
            v2.a(v0, v1_1);
            v2.a();
        }
        else {
            if(arg9) {
                this.d.d(v1);
                this.e.setVisibility(0);
                return;
            }

            this.d.d(0);
            this.e.setVisibility(v3);
        }
    }

    public void j() {
        if(this.m) {
            this.m = false;
            this.l(true);
        }
    }

    private void k(boolean arg6) {
        ap v3 = null;
        boolean v1 = true;
        this.D = arg6;
        if(!this.D) {
            this.d.a(v3);
            this.c.setTabContainer(this.g);
        }
        else {
            this.c.setTabContainer(v3);
            this.d.a(this.g);
        }

        int v0 = this.i() == 2 ? 1 : 0;
        if(this.g != null) {
            if(v0 != 0) {
                this.g.setVisibility(0);
                if(this.b != null) {
                    p.g(this.b);
                }
            }
            else {
                this.g.setVisibility(8);
            }
        }

        ad v4 = this.d;
        boolean v3_1 = (this.D) || v0 == 0 ? false : true;
        v4.a(v3_1);
        ActionBarOverlayLayout v3_2 = this.b;
        if((this.D) || v0 == 0) {
            v1 = false;
        }

        v3_2.setHasNonEmbeddedTabs(v1);
    }

    public void k() {
        if(!this.m) {
            this.m = true;
            this.l(true);
        }
    }

    private void l(boolean arg4) {
        if(r.a(this.l, this.m, this.F)) {
            if(!this.G) {
                this.G = true;
                this.h(arg4);
            }
        }
        else if(this.G) {
            this.G = false;
            this.i(arg4);
        }
    }

    public void l() {
        if(this.n != null) {
            this.n.c();
            this.n = null;
        }
    }

    public void m() {
    }

    private void n() {
        if(!this.F) {
            this.F = true;
            if(this.b != null) {
                this.b.setShowingForActionMode(true);
            }

            this.l(false);
        }
    }

    private void o() {
        if(this.F) {
            this.F = false;
            if(this.b != null) {
                this.b.setShowingForActionMode(false);
            }

            this.l(false);
        }
    }

    private boolean p() {
        return p.l(this.c);
    }
}

