package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources$Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.support.v4.a.w;
import android.support.v4.h.n;
import android.support.v4.h.p;
import android.support.v4.h.r;
import android.support.v4.h.s;
import android.support.v4.h.t;
import android.support.v4.h.v;
import android.support.v7.a.a$g;
import android.support.v7.a.a$i;
import android.support.v7.a.a$j;
import android.support.v7.view.menu.h$a;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ac;
import android.support.v7.widget.bb;
import android.support.v7.widget.bc;
import android.support.v7.widget.l;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater$Factory2;
import android.view.LayoutInflater$Factory;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window$Callback;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;

class k extends f implements a, LayoutInflater$Factory2 {
    class android.support.v7.app.k$1 implements Runnable {
        android.support.v7.app.k$1(k arg1) {
            this.a = arg1;
            super();
        }

        public void run() {
            if((this.a.s & 1) != 0) {
                this.a.f(0);
            }

            if((this.a.s & 0x1000) != 0) {
                this.a.f(108);
            }

            this.a.r = false;
            this.a.s = 0;
        }
    }

    final class android.support.v7.app.k$a implements android.support.v7.view.menu.o$a {
        android.support.v7.app.k$a(k arg1) {
            this.a = arg1;
            super();
        }

        public void a(h arg2, boolean arg3) {
            this.a.b(arg2);
        }

        public boolean a(h arg3) {
            Window$Callback v0 = this.a.q();
            if(v0 != null) {
                v0.onMenuOpened(108, ((Menu)arg3));
            }

            return 1;
        }
    }

    class b implements android.support.v7.view.b$a {
        private android.support.v7.view.b$a b;

        public b(k arg1, android.support.v7.view.b$a arg2) {
            this.a = arg1;
            super();
            this.b = arg2;
        }

        public void a(android.support.v7.view.b arg4) {
            this.b.a(arg4);
            if(this.a.o != null) {
                this.a.b.getDecorView().removeCallbacks(this.a.p);
            }

            if(this.a.n != null) {
                this.a.t();
                this.a.q = p.d(this.a.n).a(0f);
                this.a.q.a(new t() {
                    public void b(View arg4) {
                        s v2 = null;
                        this.a.a.n.setVisibility(8);
                        if(this.a.a.o != null) {
                            this.a.a.o.dismiss();
                        }
                        else if((this.a.a.n.getParent() instanceof View)) {
                            p.g(this.a.a.n.getParent());
                        }

                        this.a.a.n.removeAllViews();
                        this.a.a.q.a(v2);
                        this.a.a.q = ((r)v2);
                    }
                });
            }

            if(this.a.e != null) {
                this.a.e.b(this.a.m);
            }

            this.a.m = null;
        }

        public boolean a(android.support.v7.view.b arg2, Menu arg3) {
            return this.b.a(arg2, arg3);
        }

        public boolean a(android.support.v7.view.b arg2, MenuItem arg3) {
            return this.b.a(arg2, arg3);
        }

        public boolean b(android.support.v7.view.b arg2, Menu arg3) {
            return this.b.b(arg2, arg3);
        }
    }

    class c extends ContentFrameLayout {
        public c(k arg1, Context arg2) {
            this.a = arg1;
            super(arg2);
        }

        private boolean a(int arg2, int arg3) {
            int v0 = -5;
            boolean v0_1 = arg2 < v0 || arg3 < v0 || arg2 > this.getWidth() + 5 || arg3 > this.getHeight() + 5 ? true : false;
            return v0_1;
        }

        public boolean dispatchKeyEvent(KeyEvent arg2) {
            boolean v0 = (this.a.a(arg2)) || (super.dispatchKeyEvent(arg2)) ? true : false;
            return v0;
        }

        public boolean onInterceptTouchEvent(MotionEvent arg3) {
            boolean v0;
            if(arg3.getAction() != 0 || !this.a(((int)arg3.getX()), ((int)arg3.getY()))) {
                v0 = super.onInterceptTouchEvent(arg3);
            }
            else {
                this.a.e(0);
                v0 = true;
            }

            return v0;
        }

        public void setBackgroundResource(int arg2) {
            this.setBackgroundDrawable(android.support.v7.b.a.b.b(this.getContext(), arg2));
        }
    }

    public final class d {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        h j;
        android.support.v7.view.menu.f k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q;
        boolean r;
        Bundle s;

        d(int arg2) {
            super();
            this.a = arg2;
            this.q = false;
        }

        public boolean a() {
            boolean v0 = true;
            if(this.h == null) {
                v0 = false;
            }
            else if(this.i == null && this.k.a().getCount() <= 0) {
                v0 = false;
            }

            return v0;
        }

        void a(Context arg6) {
            TypedValue v0 = new TypedValue();
            Resources$Theme v1 = arg6.getResources().newTheme();
            v1.setTo(arg6.getTheme());
            v1.resolveAttribute(android.support.v7.a.a$a.actionBarPopupTheme, v0, true);
            if(v0.resourceId != 0) {
                v1.applyStyle(v0.resourceId, true);
            }

            v1.resolveAttribute(android.support.v7.a.a$a.panelMenuListTheme, v0, true);
            if(v0.resourceId != 0) {
                v1.applyStyle(v0.resourceId, true);
            }
            else {
                v1.applyStyle(i.Theme_AppCompat_CompactMenu, true);
            }

            android.support.v7.view.d v0_1 = new android.support.v7.view.d(arg6, 0);
            ((Context)v0_1).getTheme().setTo(v1);
            this.l = ((Context)v0_1);
            TypedArray v0_2 = ((Context)v0_1).obtainStyledAttributes(j.AppCompatTheme);
            this.b = v0_2.getResourceId(j.AppCompatTheme_panelBackground, 0);
            this.f = v0_2.getResourceId(j.AppCompatTheme_android_windowAnimationStyle, 0);
            v0_2.recycle();
        }

        void a(h arg3) {
            if(arg3 != this.j) {
                if(this.j != null) {
                    this.j.b(this.k);
                }

                this.j = arg3;
                if(arg3 == null) {
                    return;
                }

                if(this.k == null) {
                    return;
                }

                arg3.a(this.k);
            }
        }

        android.support.v7.view.menu.p a(android.support.v7.view.menu.o$a arg4) {
            android.support.v7.view.menu.p v0;
            if(this.j == null) {
                v0 = null;
            }
            else {
                if(this.k == null) {
                    this.k = new android.support.v7.view.menu.f(this.l, g.abc_list_menu_item_layout);
                    this.k.a(arg4);
                    this.j.a(this.k);
                }

                v0 = this.k.a(this.g);
            }

            return v0;
        }
    }

    final class e implements android.support.v7.view.menu.o$a {
        e(k arg1) {
            this.a = arg1;
            super();
        }

        public void a(h arg6, boolean arg7) {
            h v2 = arg6.p();
            int v0 = v2 != arg6 ? 1 : 0;
            k v3 = this.a;
            if(v0 != 0) {
                arg6 = v2;
            }

            d v3_1 = v3.a(((Menu)arg6));
            if(v3_1 != null) {
                if(v0 != 0) {
                    this.a.a(v3_1.a, v3_1, ((Menu)v2));
                    this.a.a(v3_1, true);
                }
                else {
                    this.a.a(v3_1, arg7);
                }
            }
        }

        public boolean a(h arg3) {
            if(arg3 == null && (this.a.h)) {
                Window$Callback v0 = this.a.q();
                if(v0 != null && !this.a.p()) {
                    v0.onMenuOpened(108, ((Menu)arg3));
                }
            }

            return 1;
        }
    }

    private View A;
    private boolean B;
    private boolean C;
    private boolean D;
    private d[] E;
    private d F;
    private boolean G;
    private final Runnable H;
    private boolean I;
    private Rect J;
    private Rect K;
    private m L;
    android.support.v7.view.b m;
    ActionBarContextView n;
    PopupWindow o;
    Runnable p;
    r q;
    boolean r;
    int s;
    private static final boolean t;
    private ac u;
    private android.support.v7.app.k$a v;
    private e w;
    private boolean x;
    private ViewGroup y;
    private TextView z;

    static {
        boolean v0 = Build$VERSION.SDK_INT < 21 ? true : false;
        k.t = v0;
    }

    k(Context arg2, Window arg3, android.support.v7.app.d arg4) {
        super(arg2, arg3, arg4);
        this.q = null;
        this.H = new android.support.v7.app.k$1(this);
    }

    private void a(d arg11, KeyEvent arg12) {
        ViewGroup$LayoutParams v0_2;
        int v1 = -1;
        int v2 = -2;
        if(!arg11.o && !this.p()) {
            if(arg11.a == 0) {
                Context v4 = this.a;
                int v0 = (v4.getResources().getConfiguration().screenLayout & 15) == 4 ? 1 : 0;
                int v4_1 = v4.getApplicationInfo().targetSdkVersion >= 11 ? 1 : 0;
                if(v0 == 0) {
                    goto label_26;
                }

                if(v4_1 != 0) {
                    return;
                }
            }

        label_26:
            Window$Callback v0_1 = this.q();
            if(v0_1 != null && !v0_1.onMenuOpened(arg11.a, arg11.j)) {
                this.a(arg11, true);
                return;
            }

            Object v8 = this.a.getSystemService("window");
            if(v8 == null) {
                return;
            }

            if(!this.b(arg11, arg12)) {
                return;
            }

            if(arg11.g == null || (arg11.q)) {
                if(arg11.g == null) {
                    if(!this.a(arg11)) {
                        return;
                    }
                    else if(arg11.g == null) {
                        return;
                    }
                }
                else if((arg11.q) && arg11.g.getChildCount() > 0) {
                    arg11.g.removeAllViews();
                }

                if(!this.c(arg11)) {
                    return;
                }

                if(!arg11.a()) {
                    return;
                }

                v0_2 = arg11.h.getLayoutParams();
                ViewGroup$LayoutParams v1_1 = v0_2 == null ? new ViewGroup$LayoutParams(v2, v2) : v0_2;
                arg11.g.setBackgroundResource(arg11.b);
                ViewParent v0_3 = arg11.h.getParent();
                if(v0_3 != null && ((v0_3 instanceof ViewGroup))) {
                    ((ViewGroup)v0_3).removeView(arg11.h);
                }

                arg11.g.addView(arg11.h, v1_1);
                if(!arg11.h.hasFocus()) {
                    arg11.h.requestFocus();
                }

                v1 = v2;
            }
            else {
                if(arg11.i != null) {
                    v0_2 = arg11.i.getLayoutParams();
                    if(v0_2 != null) {
                        if(v0_2.width != v1) {
                            goto label_115;
                        }

                        goto label_84;
                    }
                }

            label_115:
                v1 = v2;
            }

        label_84:
            arg11.n = false;
            WindowManager$LayoutParams v0_4 = new WindowManager$LayoutParams(v1, v2, arg11.d, arg11.e, 1002, 0x820000, -3);
            v0_4.gravity = arg11.c;
            v0_4.windowAnimations = arg11.f;
            ((WindowManager)v8).addView(arg11.g, ((ViewGroup$LayoutParams)v0_4));
            arg11.o = true;
        }
    }

    void a(d arg5, boolean arg6) {
        Menu v3 = null;
        if(!arg6 || arg5.a != 0 || this.u == null || !this.u.f()) {
            Object v0 = this.a.getSystemService("window");
            if(v0 != null && (arg5.o) && arg5.g != null) {
                ((WindowManager)v0).removeView(arg5.g);
                if(arg6) {
                    this.a(arg5.a, arg5, v3);
                }
            }

            arg5.m = false;
            arg5.n = false;
            arg5.o = false;
            arg5.h = ((View)v3);
            arg5.q = true;
            if(this.F != arg5) {
                return;
            }

            this.F = ((d)v3);
        }
        else {
            this.b(arg5.j);
        }
    }

    private boolean a(d arg3) {
        arg3.a(this.n());
        arg3.g = new c(this, arg3.l);
        arg3.c = 81;
        return 1;
    }

    private void a(h arg7, boolean arg8) {
        int v5 = 108;
        if(this.u == null || !this.u.e()) {
        label_56:
            d v0_1 = this.a(0, true);
            v0_1.q = true;
            this.a(v0_1, false);
            this.a(v0_1, null);
        }
        else {
            if((ViewConfiguration.get(this.a).hasPermanentMenuKey()) && !this.u.g()) {
                goto label_56;
            }

            Window$Callback v0 = this.q();
            if((this.u.f()) && (arg8)) {
                this.u.i();
                if(!this.p()) {
                    v0.onPanelClosed(v5, this.a(0, true).j);
                }
                else {
                }

                return;
            }

            if(v0 == null) {
                return;
            }

            if(this.p()) {
                return;
            }

            if((this.r) && (this.s & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.H);
                this.H.run();
            }

            d v1 = this.a(0, true);
            if(v1.j == null) {
                return;
            }

            if(v1.r) {
                return;
            }

            if(!v0.onPreparePanel(0, v1.i, v1.j)) {
                return;
            }

            v0.onMenuOpened(v5, v1.j);
            this.u.h();
        }
    }

    protected d a(int arg5, boolean arg6) {
        d v0_1;
        d[] v0 = this.E;
        if(v0 == null || v0.length <= arg5) {
            d[] v1 = new d[arg5 + 1];
            if(v0 != null) {
                System.arraycopy(v0, 0, v1, 0, v0.length);
            }

            this.E = v1;
            v0 = v1;
        }

        d v1_1 = v0[arg5];
        if(v1_1 == null) {
            v1_1 = new d(arg5);
            v0[arg5] = v1_1;
            v0_1 = v1_1;
        }
        else {
            v0_1 = v1_1;
        }

        return v0_1;
    }

    private boolean a(d arg3, int arg4, KeyEvent arg5, int arg6) {
        boolean v0 = false;
        if(!arg5.isSystem()) {
            if(((arg3.m) || (this.b(arg3, arg5))) && arg3.j != null) {
                v0 = arg3.j.performShortcut(arg4, arg5, arg6);
            }

            if(!v0) {
                return v0;
            }

            if((arg6 & 1) != 0) {
                return v0;
            }

            if(this.u != null) {
                return v0;
            }

            this.a(arg3, true);
        }

        return v0;
    }

    private boolean a(ViewParent arg5) {
        boolean v0;
        if(arg5 == null) {
            v0 = false;
        }
        else {
            View v3 = this.b.getDecorView();
            ViewParent v1 = arg5;
            while(true) {
                if(v1 != null) {
                    if((((View)v1)) != v3 && ((v1 instanceof View)) && !p.m(v1)) {
                        v1 = v1.getParent();
                        continue;
                    }

                    return false;
                }
                else {
                    goto label_8;
                }
            }

            return false;
        label_8:
            v0 = true;
        }

        return v0;
    }

    void a(ViewGroup arg1) {
    }

    d a(Menu arg6) {
        d[] v3 = this.E;
        int v0 = v3 != null ? v3.length : 0;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            d v1 = v3[v2];
            if(v1 != null && v1.j == arg6) {
                d v0_1 = v1;
                return v0_1;
            }
        }

        return null;
    }

    android.support.v7.view.b a(android.support.v7.view.b$a arg9) {
        Context v0_4;
        android.support.v7.view.b v0_1;
        b v9;
        float v7 = 1f;
        android.support.v7.view.b v3 = null;
        this.t();
        if(this.m != null) {
            this.m.c();
        }

        if(!(arg9 instanceof b)) {
            v9 = new b(this, arg9);
        }

        if(this.e != null && !this.p()) {
            try {
                v0_1 = this.e.a(((android.support.v7.view.b$a)v9));
            }
            catch(AbstractMethodError v0) {
                v0_1 = v3;
            }
        }
        else {
            v0_1 = v3;
        }

        if(v0_1 != null) {
            this.m = v0_1;
        }
        else {
            if(this.n == null) {
                if(this.k) {
                    TypedValue v4 = new TypedValue();
                    Resources$Theme v0_2 = this.a.getTheme();
                    v0_2.resolveAttribute(android.support.v7.a.a$a.actionBarTheme, v4, true);
                    if(v4.resourceId != 0) {
                        Resources$Theme v5 = this.a.getResources().newTheme();
                        v5.setTo(v0_2);
                        v5.applyStyle(v4.resourceId, true);
                        android.support.v7.view.d v0_3 = new android.support.v7.view.d(this.a, 0);
                        ((Context)v0_3).getTheme().setTo(v5);
                    }
                    else {
                        v0_4 = this.a;
                    }

                    this.n = new ActionBarContextView(v0_4);
                    this.o = new PopupWindow(v0_4, ((AttributeSet)v3), android.support.v7.a.a$a.actionModePopupWindowStyle);
                    android.support.v4.widget.i.a(this.o, 2);
                    this.o.setContentView(this.n);
                    this.o.setWidth(-1);
                    v0_4.getTheme().resolveAttribute(android.support.v7.a.a$a.actionBarSize, v4, true);
                    this.n.setContentHeight(TypedValue.complexToDimensionPixelSize(v4.data, v0_4.getResources().getDisplayMetrics()));
                    this.o.setHeight(-2);
                    this.p = new Runnable() {
                        public void run() {
                            float v4 = 1f;
                            this.a.o.showAtLocation(this.a.n, 55, 0, 0);
                            this.a.t();
                            if(this.a.s()) {
                                this.a.n.setAlpha(0f);
                                this.a.q = p.d(this.a.n).a(v4);
                                this.a.q.a(new t() {
                                    public void a(View arg3) {
                                        this.a.a.n.setVisibility(0);
                                    }

                                    public void b(View arg4) {
                                        this.a.a.n.setAlpha(1f);
                                        this.a.a.q.a(null);
                                        this.a.a.q = null;
                                    }
                                });
                            }
                            else {
                                this.a.n.setAlpha(v4);
                                this.a.n.setVisibility(0);
                            }
                        }
                    };
                }
                else {
                    View v0_5 = this.y.findViewById(android.support.v7.a.a$f.action_mode_bar_stub);
                    if(v0_5 == null) {
                        goto label_88;
                    }

                    ((ViewStubCompat)v0_5).setLayoutInflater(LayoutInflater.from(this.n()));
                    this.n = ((ViewStubCompat)v0_5).a();
                }
            }

        label_88:
            if(this.n == null) {
                goto label_22;
            }

            this.t();
            this.n.c();
            Context v5_1 = this.n.getContext();
            ActionBarContextView v6 = this.n;
            boolean v0_6 = this.o == null ? true : false;
            android.support.v7.view.e v4_1 = new android.support.v7.view.e(v5_1, v6, ((android.support.v7.view.b$a)v9), v0_6);
            if(((android.support.v7.view.b$a)v9).a(((android.support.v7.view.b)v4_1), ((android.support.v7.view.b)v4_1).b())) {
                ((android.support.v7.view.b)v4_1).d();
                this.n.a(((android.support.v7.view.b)v4_1));
                this.m = ((android.support.v7.view.b)v4_1);
                if(this.s()) {
                    this.n.setAlpha(0f);
                    this.q = p.d(this.n).a(v7);
                    this.q.a(new t() {
                        public void a(View arg3) {
                            this.a.n.setVisibility(0);
                            this.a.n.sendAccessibilityEvent(0x20);
                            if((this.a.n.getParent() instanceof View)) {
                                p.g(this.a.n.getParent());
                            }
                        }

                        public void b(View arg4) {
                            this.a.n.setAlpha(1f);
                            this.a.q.a(null);
                            this.a.q = null;
                        }
                    });
                }
                else {
                    this.n.setAlpha(v7);
                    this.n.setVisibility(0);
                    this.n.sendAccessibilityEvent(0x20);
                    if((this.n.getParent() instanceof View)) {
                        p.g(this.n.getParent());
                    }
                }

                if(this.o == null) {
                    goto label_22;
                }

                this.b.getDecorView().post(this.p);
                goto label_22;
            }

            this.m = v3;
        }

    label_22:
        if(this.m != null && this.e != null) {
            this.e.a(this.m);
        }

        return this.m;
    }

    public View a(int arg2) {
        this.w();
        return this.b.findViewById(arg2);
    }

    View a(View arg2, String arg3, Context arg4, AttributeSet arg5) {
        View v0;
        if((this.c instanceof LayoutInflater$Factory)) {
            v0 = this.c.onCreateView(arg3, arg4, arg5);
            if(v0 == null) {
                goto label_7;
            }
        }
        else {
        label_7:
            v0 = null;
        }

        return v0;
    }

    void a(int arg2, d arg3, Menu arg4) {
        h v4;
        if(arg4 == null) {
            if(arg3 == null && arg2 >= 0 && arg2 < this.E.length) {
                arg3 = this.E[arg2];
            }

            if(arg3 == null) {
                goto label_10;
            }

            v4 = arg3.j;
        }

    label_10:
        if((arg3 == null || (arg3.o)) && !this.p()) {
            this.c.onPanelClosed(arg2, ((Menu)v4));
        }
    }

    void a(int arg4, Menu arg5) {
        if(arg4 == 108) {
            android.support.v7.app.a v0 = this.a();
            if(v0 != null) {
                v0.e(false);
            }
        }
        else if(arg4 == 0) {
            d v0_1 = this.a(arg4, true);
            if(v0_1.o) {
                this.a(v0_1, false);
            }
        }
    }

    public void a(Configuration arg3) {
        if((this.h) && (this.x)) {
            android.support.v7.app.a v0 = this.a();
            if(v0 != null) {
                v0.a(arg3);
            }
        }

        l.a().a(this.a);
        this.i();
    }

    public void a(Bundle arg3) {
        if(((this.c instanceof Activity)) && w.b(this.c) != null) {
            android.support.v7.app.a v0 = this.m();
            if(v0 == null) {
                this.I = true;
            }
            else {
                v0.c(true);
            }
        }
    }

    public void a(h arg2) {
        this.a(arg2, true);
    }

    public void a(View arg3) {
        this.w();
        View v0 = this.y.findViewById(0x1020002);
        ((ViewGroup)v0).removeAllViews();
        ((ViewGroup)v0).addView(arg3);
        this.c.onContentChanged();
    }

    public void a(View arg3, ViewGroup$LayoutParams arg4) {
        this.w();
        View v0 = this.y.findViewById(0x1020002);
        ((ViewGroup)v0).removeAllViews();
        ((ViewGroup)v0).addView(arg3, arg4);
        this.c.onContentChanged();
    }

    boolean a(int arg5, KeyEvent arg6) {
        boolean v0 = true;
        android.support.v7.app.a v2 = this.a();
        if(v2 == null || !v2.a(arg5, arg6)) {
            if(this.F != null && (this.a(this.F, arg6.getKeyCode(), arg6, 1))) {
                if(this.F != null) {
                    this.F.n = true;
                }
                else {
                }

                return v0;
            }

            if(this.F == null) {
                d v2_1 = this.a(0, true);
                this.b(v2_1, arg6);
                boolean v3 = this.a(v2_1, arg6.getKeyCode(), arg6, 1);
                v2_1.m = false;
                if(!v3) {
                    goto label_26;
                }

                return v0;
            }

        label_26:
            v0 = false;
        }

        return v0;
    }

    public boolean a(h arg3, MenuItem arg4) {
        boolean v0_1;
        Window$Callback v0 = this.q();
        if(v0 == null || (this.p())) {
        label_10:
            v0_1 = false;
        }
        else {
            d v1 = this.a(arg3.p());
            if(v1 != null) {
                v0_1 = v0.onMenuItemSelected(v1.a, arg4);
            }
            else {
                goto label_10;
            }
        }

        return v0_1;
    }

    boolean a(KeyEvent arg4) {
        boolean v0 = true;
        if(arg4.getKeyCode() != 82 || !this.c.dispatchKeyEvent(arg4)) {
            int v1 = arg4.getKeyCode();
            if(arg4.getAction() != 0) {
                int v0_1 = 0;
            }

            if((((boolean)v0_1))) {
                return this.c(v1, arg4);
            }

            v0 = this.b(v1, arg4);
        }

        return v0;
    }

    private boolean b(d arg9, KeyEvent arg10) {
        h v7 = null;
        boolean v2 = false;
        if(!this.p()) {
            if(arg9.m) {
                v2 = true;
            }
            else {
                if(this.F != null && this.F != arg9) {
                    this.a(this.F, false);
                }

                Window$Callback v3 = this.q();
                if(v3 != null) {
                    arg9.i = v3.onCreatePanelView(arg9.a);
                }

                int v0 = arg9.a == 0 || arg9.a == 108 ? 1 : 0;
                if(v0 != 0 && this.u != null) {
                    this.u.j();
                }

                if(arg9.i == null && (v0 == 0 || !(this.m() instanceof o))) {
                    if(arg9.j == null || (arg9.r)) {
                        if(arg9.j == null) {
                            if(!this.b(arg9)) {
                            }
                            else if(arg9.j != null) {
                                goto label_48;
                            }

                            return v2;
                        }

                    label_48:
                        if(v0 != 0 && this.u != null) {
                            if(this.v == null) {
                                this.v = new android.support.v7.app.k$a(this);
                            }

                            this.u.a(arg9.j, this.v);
                        }

                        arg9.j.g();
                        if(!v3.onCreatePanelMenu(arg9.a, arg9.j)) {
                            arg9.a(v7);
                            if(v0 == 0) {
                                return v2;
                            }

                            if(this.u == null) {
                                return v2;
                            }

                            this.u.a(((Menu)v7), this.v);
                            return v2;
                        }

                        arg9.r = false;
                    }

                    arg9.j.g();
                    if(arg9.s != null) {
                        arg9.j.b(arg9.s);
                        arg9.s = ((Bundle)v7);
                    }

                    if(!v3.onPreparePanel(0, arg9.i, arg9.j)) {
                        if(v0 != 0 && this.u != null) {
                            this.u.a(((Menu)v7), this.v);
                        }

                        arg9.j.h();
                        return v2;
                    }

                    v0 = arg10 != null ? arg10.getDeviceId() : -1;
                    boolean v0_1 = KeyCharacterMap.load(v0).getKeyboardType() != 1 ? true : false;
                    arg9.p = v0_1;
                    arg9.j.setQwertyMode(arg9.p);
                    arg9.j.h();
                }

                arg9.m = true;
                arg9.n = false;
                this.F = arg9;
                v2 = true;
            }
        }

        return v2;
    }

    private boolean b(d arg7) {
        Context v0_2;
        Context v1 = this.a;
        if(arg7.a != 0 && arg7.a != 108) {
            goto label_47;
        }
        else if(this.u != null) {
            TypedValue v2 = new TypedValue();
            Resources$Theme v3 = v1.getTheme();
            v3.resolveAttribute(android.support.v7.a.a$a.actionBarTheme, v2, true);
            Resources$Theme v0 = null;
            if(v2.resourceId != 0) {
                v0 = v1.getResources().newTheme();
                v0.setTo(v3);
                v0.applyStyle(v2.resourceId, true);
                v0.resolveAttribute(android.support.v7.a.a$a.actionBarWidgetTheme, v2, true);
            }
            else {
                v3.resolveAttribute(android.support.v7.a.a$a.actionBarWidgetTheme, v2, true);
            }

            if(v2.resourceId != 0) {
                if(v0 == null) {
                    v0 = v1.getResources().newTheme();
                    v0.setTo(v3);
                }

                v0.applyStyle(v2.resourceId, true);
            }

            Resources$Theme v2_1 = v0;
            if(v2_1 == null) {
                goto label_47;
            }

            android.support.v7.view.d v0_1 = new android.support.v7.view.d(v1, 0);
            ((Context)v0_1).getTheme().setTo(v2_1);
        }
        else {
        label_47:
            v0_2 = v1;
        }

        h v1_1 = new h(v0_2);
        v1_1.a(((a)this));
        arg7.a(v1_1);
        return 1;
    }

    void b(CharSequence arg2) {
        if(this.u != null) {
            this.u.setWindowTitle(arg2);
        }
        else if(this.m() != null) {
            this.m().a(arg2);
        }
        else if(this.z != null) {
            this.z.setText(arg2);
        }
    }

    void b(h arg3) {
        if(!this.D) {
            this.D = true;
            this.u.k();
            Window$Callback v0 = this.q();
            if(v0 != null && !this.p()) {
                v0.onPanelClosed(108, ((Menu)arg3));
            }

            this.D = false;
        }
    }

    boolean b(int arg6, KeyEvent arg7) {
        boolean v0 = true;
        switch(arg6) {
            case 4: {
                boolean v2 = this.G;
                this.G = false;
                d v3 = this.a(0, false);
                if(v3 != null && (v3.o)) {
                    if(!v2) {
                        this.a(v3, true);
                    }
                    else {
                    }

                    return v0;
                }

                if(!this.u()) {
                    goto label_3;
                }

                break;
            }
            case 82: {
                this.e(0, arg7);
                break;
            }
            default: {
            label_3:
                v0 = false;
                break;
            }
        }

        return v0;
    }

    public android.support.v7.view.b b(android.support.v7.view.b$a arg4) {
        if(arg4 == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }

        if(this.m != null) {
            this.m.c();
        }

        b v0 = new b(this, arg4);
        android.support.v7.app.a v1 = this.a();
        if(v1 != null) {
            this.m = v1.a(((android.support.v7.view.b$a)v0));
            if(this.m != null && this.e != null) {
                this.e.a(this.m);
            }
        }

        if(this.m == null) {
            this.m = this.a(((android.support.v7.view.b$a)v0));
        }

        return this.m;
    }

    public View b(View arg10, String arg11, Context arg12, AttributeSet arg13) {
        boolean v5;
        boolean v0;
        if(this.L == null) {
            this.L = new m();
        }

        if(k.t) {
            if(!(arg13 instanceof XmlPullParser)) {
                v0 = this.a(arg10);
            }
            else if(arg13.getDepth() > 1) {
                v0 = true;
            }
            else {
                v0 = false;
            }

            v5 = v0;
        }
        else {
            v5 = false;
        }

        return this.L.a(arg10, arg11, arg12, arg13, v5, k.t, true, bb.a());
    }

    public void b(int arg3) {
        this.w();
        View v0 = this.y.findViewById(0x1020002);
        ((ViewGroup)v0).removeAllViews();
        LayoutInflater.from(this.a).inflate(arg3, ((ViewGroup)v0));
        this.c.onContentChanged();
    }

    public void b(Bundle arg1) {
        this.w();
    }

    public void b(View arg3, ViewGroup$LayoutParams arg4) {
        this.w();
        this.y.findViewById(0x1020002).addView(arg3, arg4);
        this.c.onContentChanged();
    }

    boolean b(int arg3, Menu arg4) {
        boolean v0 = true;
        if(arg3 == 108) {
            android.support.v7.app.a v1 = this.a();
            if(v1 != null) {
                v1.e(true);
            }
        }
        else {
            v0 = false;
        }

        return v0;
    }

    private boolean c(d arg4) {
        boolean v1 = true;
        if(arg4.i != null) {
            arg4.h = arg4.i;
        }
        else if(arg4.j == null) {
            v1 = false;
        }
        else {
            if(this.w == null) {
                this.w = new e(this);
            }

            arg4.h = arg4.a(this.w);
            boolean v0 = arg4.h != null ? true : false;
            v1 = v0;
        }

        return v1;
    }

    public boolean c(int arg5) {
        boolean v0 = false;
        int v2 = this.h(arg5);
        if(!this.l || v2 != 108) {
            if((this.h) && v2 == 1) {
                this.h = false;
            }

            switch(v2) {
                case 1: {
                    goto label_36;
                }
                case 2: {
                    goto label_28;
                }
                case 5: {
                    goto label_32;
                }
                case 10: {
                    goto label_24;
                }
                case 108: {
                    goto label_16;
                }
                case 109: {
                    goto label_20;
                }
            }

            return this.b.requestFeature(v2);
        label_36:
            this.z();
            this.l = true;
            return true;
        label_20:
            this.z();
            this.i = true;
            return true;
        label_24:
            this.z();
            this.j = true;
            return true;
        label_28:
            this.z();
            this.B = true;
            return true;
        label_32:
            this.z();
            this.C = true;
            return true;
        label_16:
            this.z();
            this.h = true;
            v0 = true;
        }

        return v0;
    }

    boolean c(int arg4, KeyEvent arg5) {
        boolean v0 = true;
        switch(arg4) {
            case 4: {
                goto label_11;
            }
            case 82: {
                goto label_9;
            }
        }

        goto label_3;
    label_9:
        this.d(0, arg5);
        return v0;
    label_11:
        if((arg5.getFlags() & 0x80) == 0) {
            v0 = false;
        }

        this.G = v0;
    label_3:
        if(Build$VERSION.SDK_INT < 11) {
            this.a(arg4, arg5);
        }

        return false;
    }

    private void d(int arg4) {
        this.s |= 1 << arg4;
        if(!this.r) {
            p.a(this.b.getDecorView(), this.H);
            this.r = true;
        }
    }

    private boolean d(int arg3, KeyEvent arg4) {
        boolean v0_1;
        if(arg4.getRepeatCount() == 0) {
            d v0 = this.a(arg3, true);
            if(!v0.o) {
                v0_1 = this.b(v0, arg4);
            }
            else {
                goto label_8;
            }
        }
        else {
        label_8:
            v0_1 = false;
        }

        return v0_1;
    }

    public void d() {
        android.support.v7.app.a v0 = this.a();
        if(v0 != null) {
            v0.d(false);
        }
    }

    private boolean e(int arg5, KeyEvent arg6) {
        boolean v0;
        boolean v2 = true;
        if(this.m != null) {
            v0 = false;
        }
        else {
            d v3 = this.a(arg5, true);
            if(arg5 != 0 || this.u == null || !this.u.e() || (ViewConfiguration.get(this.a).hasPermanentMenuKey())) {
                if(!v3.o && !v3.n) {
                    if(v3.m) {
                        if(v3.r) {
                            v3.m = false;
                            v0 = this.b(v3, arg6);
                        }
                        else {
                            v0 = true;
                        }

                        if(!v0) {
                            goto label_58;
                        }

                        this.a(v3, arg6);
                    }
                    else {
                    label_58:
                        v2 = false;
                    }

                    goto label_26;
                }

                v0 = v3.o;
                this.a(v3, true);
                v2 = v0;
            }
            else if(this.u.f()) {
                v2 = this.u.i();
            }
            else if(this.p()) {
                goto label_58;
            }
            else if(this.b(v3, arg6)) {
                v2 = this.u.h();
            }
            else {
                goto label_58;
            }

        label_26:
            if(v2) {
                Object v0_1 = this.a.getSystemService("audio");
                if(v0_1 != null) {
                    ((AudioManager)v0_1).playSoundEffect(0);
                }
                else {
                    Log.w("AppCompatDelegate", "Couldn\'t get audio manager");
                }
            }

            v0 = v2;
        }

        return v0;
    }

    public void e() {
        android.support.v7.app.a v0 = this.a();
        if(v0 != null) {
            v0.d(true);
        }
    }

    void e(int arg3) {
        this.a(this.a(arg3, true), true);
    }

    public void f() {
        android.support.v7.app.a v0 = this.a();
        if(v0 == null || !v0.e()) {
            this.d(0);
        }
    }

    void f(int arg6) {
        d v0 = this.a(arg6, true);
        if(v0.j != null) {
            Bundle v1 = new Bundle();
            v0.j.a(v1);
            if(v1.size() > 0) {
                v0.s = v1;
            }

            v0.j.g();
            v0.j.clear();
        }

        v0.r = true;
        v0.q = true;
        if((arg6 == 108 || arg6 == 0) && this.u != null) {
            v0 = this.a(0, false);
            if(v0 != null) {
                v0.m = false;
                this.b(v0, null);
            }
        }
    }

    int g(int arg9) {
        int v0_1;
        int v1_1;
        int v6 = -1;
        int v3 = 1;
        int v2 = 0;
        if(this.n == null || !(this.n.getLayoutParams() instanceof ViewGroup$MarginLayoutParams)) {
            v0_1 = 0;
        }
        else {
            ViewGroup$LayoutParams v0 = this.n.getLayoutParams();
            if(this.n.isShown()) {
                if(this.J == null) {
                    this.J = new Rect();
                    this.K = new Rect();
                }

                Rect v1 = this.J;
                Rect v4 = this.K;
                v1.set(0, arg9, 0, 0);
                bc.a(this.y, v1, v4);
                v1_1 = v4.top == 0 ? arg9 : 0;
                if(((ViewGroup$MarginLayoutParams)v0).topMargin != v1_1) {
                    ((ViewGroup$MarginLayoutParams)v0).topMargin = arg9;
                    if(this.A == null) {
                        this.A = new View(this.a);
                        this.A.setBackgroundColor(this.a.getResources().getColor(android.support.v7.a.a$c.abc_input_method_navigation_guard));
                        this.y.addView(this.A, v6, new ViewGroup$LayoutParams(v6, arg9));
                        v1_1 = 1;
                    }
                    else {
                        ViewGroup$LayoutParams v1_2 = this.A.getLayoutParams();
                        if(v1_2.height != arg9) {
                            v1_2.height = arg9;
                            this.A.setLayoutParams(v1_2);
                        }

                        v1_1 = 1;
                    }
                }
                else {
                    v1_1 = 0;
                }

                if(this.A != null) {
                }
                else {
                    v3 = 0;
                }

                int v7 = v1_1;
                v1_1 = v3;
                v3 = v7;
            }
            else {
                if(((ViewGroup$MarginLayoutParams)v0).topMargin != 0) {
                    ((ViewGroup$MarginLayoutParams)v0).topMargin = 0;
                    v1_1 = 0;
                    goto label_60;
                }

                v3 = 0;
                v1_1 = 0;
            }

        label_60:
            if(v3 != 0) {
                this.n.setLayoutParams(v0);
            }

            v0_1 = v1_1;
        }

        if(this.A != null) {
            View v1_3 = this.A;
            if(v0_1 == 0) {
                v2 = 8;
            }

            v1_3.setVisibility(v2);
        }

        return 0;
    }

    public void g() {
        if(this.r) {
            this.b.getDecorView().removeCallbacks(this.H);
        }

        super.g();
        if(this.f != null) {
            this.f.g();
        }
    }

    private int h(int arg3) {
        if(arg3 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            arg3 = 108;
        }
        else if(arg3 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            arg3 = 109;
        }

        return arg3;
    }

    public void h() {
        LayoutInflater v0 = LayoutInflater.from(this.a);
        if(v0.getFactory() == null) {
            android.support.v4.h.e.b(v0, ((LayoutInflater$Factory2)this));
        }
        else if(!(v0.getFactory2() instanceof k)) {
            Log.i("AppCompatDelegate", "The Activity\'s LayoutInflater already has a Factory installed so we can not install AppCompat\'s");
        }
    }

    public void l() {
        this.w();
        if((this.h) && this.f == null) {
            if((this.c instanceof Activity)) {
                this.f = new android.support.v7.app.r(this.c, this.i);
            }
            else if((this.c instanceof Dialog)) {
                this.f = new android.support.v7.app.r(this.c);
            }

            if(this.f == null) {
                return;
            }

            this.f.c(this.I);
        }
    }

    public final View onCreateView(View arg2, String arg3, Context arg4, AttributeSet arg5) {
        View v0 = this.a(arg2, arg3, arg4, arg5);
        if(v0 == null) {
            v0 = this.b(arg2, arg3, arg4, arg5);
        }

        return v0;
    }

    public View onCreateView(String arg2, Context arg3, AttributeSet arg4) {
        return this.onCreateView(null, arg2, arg3, arg4);
    }

    final boolean s() {
        boolean v0 = !this.x || this.y == null || !p.l(this.y) ? false : true;
        return v0;
    }

    void t() {
        if(this.q != null) {
            this.q.b();
        }
    }

    boolean u() {
        boolean v0 = true;
        if(this.m != null) {
            this.m.c();
        }
        else {
            android.support.v7.app.a v1 = this.a();
            if(v1 != null && (v1.f())) {
                return v0;
            }

            v0 = false;
        }

        return v0;
    }

    void v() {
        if(this.u != null) {
            this.u.k();
        }

        if(this.o != null) {
            this.b.getDecorView().removeCallbacks(this.p);
            if(this.o.isShowing()) {
                try {
                    this.o.dismiss();
                }
                catch(IllegalArgumentException v0) {
                }
            }

            this.o = null;
        }

        this.t();
        d v0_1 = this.a(0, false);
        if(v0_1 != null && v0_1.j != null) {
            v0_1.j.close();
        }
    }

    private void w() {
        if(!this.x) {
            this.y = this.x();
            CharSequence v0 = this.r();
            if(!TextUtils.isEmpty(v0)) {
                this.b(v0);
            }

            this.y();
            this.a(this.y);
            this.x = true;
            d v0_1 = this.a(0, false);
            if(this.p()) {
                return;
            }

            if(v0_1 != null && v0_1.j != null) {
                return;
            }

            this.d(108);
        }
    }

    private ViewGroup x() {
        android.support.v7.view.d v0_3;
        View v2;
        View v0_2;
        View v1_1;
        int v7 = 0x1020002;
        int v6 = 109;
        ViewGroup v3 = null;
        TypedArray v0 = this.a.obtainStyledAttributes(j.AppCompatTheme);
        if(!v0.hasValue(j.AppCompatTheme_windowActionBar)) {
            v0.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }

        if(v0.getBoolean(j.AppCompatTheme_windowNoTitle, false)) {
            this.c(1);
        }
        else if(v0.getBoolean(j.AppCompatTheme_windowActionBar, false)) {
            this.c(108);
        }

        if(v0.getBoolean(j.AppCompatTheme_windowActionBarOverlay, false)) {
            this.c(v6);
        }

        if(v0.getBoolean(j.AppCompatTheme_windowActionModeOverlay, false)) {
            this.c(10);
        }

        this.k = v0.getBoolean(j.AppCompatTheme_android_windowIsFloating, false);
        v0.recycle();
        this.b.getDecorView();
        LayoutInflater v0_1 = LayoutInflater.from(this.a);
        if(this.l) {
            v1_1 = this.j ? v0_1.inflate(g.abc_screen_simple_overlay_action_mode, v3) : v0_1.inflate(g.abc_screen_simple, v3);
            if(Build$VERSION.SDK_INT >= 21) {
                p.a(v1_1, new n() {
                    public v a(View arg5, v arg6) {
                        int v0 = arg6.b();
                        int v1 = this.a.g(v0);
                        if(v0 != v1) {
                            arg6 = arg6.a(arg6.a(), v1, arg6.c(), arg6.d());
                        }

                        return p.a(arg5, arg6);
                    }
                });
                v2 = v1_1;
                goto label_46;
            }

            v1_1.setOnFitSystemWindowsListener(new android.support.v7.widget.ag$a() {
                public void a(Rect arg3) {
                    arg3.top = this.a.g(arg3.top);
                }
            });
            v2 = v1_1;
        }
        else if(this.k) {
            v0_2 = v0_1.inflate(g.abc_dialog_title_material, v3);
            this.i = false;
            this.h = false;
            v2 = v0_2;
        }
        else if(this.h) {
            TypedValue v1 = new TypedValue();
            this.a.getTheme().resolveAttribute(android.support.v7.a.a$a.actionBarTheme, v1, true);
            if(v1.resourceId != 0) {
                v0_3 = new android.support.v7.view.d(this.a, v1.resourceId);
            }
            else {
                Context v0_4 = this.a;
            }

            v0_2 = LayoutInflater.from(((Context)v0_3)).inflate(g.abc_screen_toolbar, v3);
            this.u = ((ViewGroup)v0_2).findViewById(android.support.v7.a.a$f.decor_content_parent);
            this.u.setWindowCallback(this.q());
            if(this.i) {
                this.u.a(v6);
            }

            if(this.B) {
                this.u.a(2);
            }

            if(this.C) {
                this.u.a(5);
            }

            v2 = v0_2;
        }
        else {
            v2 = ((View)v3);
        }

    label_46:
        if(v2 == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
        }

        if(this.u == null) {
            this.z = ((ViewGroup)v2).findViewById(android.support.v7.a.a$f.title);
        }

        bc.b(v2);
        v0_2 = ((ViewGroup)v2).findViewById(android.support.v7.a.a$f.action_bar_activity_content);
        v1_1 = this.b.findViewById(v7);
        if(v1_1 != null) {
            while(((ViewGroup)v1_1).getChildCount() > 0) {
                View v4 = ((ViewGroup)v1_1).getChildAt(0);
                ((ViewGroup)v1_1).removeViewAt(0);
                ((ContentFrameLayout)v0_2).addView(v4);
            }

            ((ViewGroup)v1_1).setId(-1);
            ((ContentFrameLayout)v0_2).setId(v7);
            if((v1_1 instanceof FrameLayout)) {
                ((FrameLayout)v1_1).setForeground(((Drawable)v3));
            }
        }

        this.b.setContentView(v2);
        ((ContentFrameLayout)v0_2).setAttachListener(new android.support.v7.widget.ContentFrameLayout$a() {
            public void a() {
            }

            public void b() {
                this.a.v();
            }
        });
        return ((ViewGroup)v2);
    }

    private void y() {
        View v0 = this.y.findViewById(0x1020002);
        View v1 = this.b.getDecorView();
        ((ContentFrameLayout)v0).a(v1.getPaddingLeft(), v1.getPaddingTop(), v1.getPaddingRight(), v1.getPaddingBottom());
        TypedArray v1_1 = this.a.obtainStyledAttributes(j.AppCompatTheme);
        v1_1.getValue(j.AppCompatTheme_windowMinWidthMajor, ((ContentFrameLayout)v0).getMinWidthMajor());
        v1_1.getValue(j.AppCompatTheme_windowMinWidthMinor, ((ContentFrameLayout)v0).getMinWidthMinor());
        if(v1_1.hasValue(j.AppCompatTheme_windowFixedWidthMajor)) {
            v1_1.getValue(j.AppCompatTheme_windowFixedWidthMajor, ((ContentFrameLayout)v0).getFixedWidthMajor());
        }

        if(v1_1.hasValue(j.AppCompatTheme_windowFixedWidthMinor)) {
            v1_1.getValue(j.AppCompatTheme_windowFixedWidthMinor, ((ContentFrameLayout)v0).getFixedWidthMinor());
        }

        if(v1_1.hasValue(j.AppCompatTheme_windowFixedHeightMajor)) {
            v1_1.getValue(j.AppCompatTheme_windowFixedHeightMajor, ((ContentFrameLayout)v0).getFixedHeightMajor());
        }

        if(v1_1.hasValue(j.AppCompatTheme_windowFixedHeightMinor)) {
            v1_1.getValue(j.AppCompatTheme_windowFixedHeightMinor, ((ContentFrameLayout)v0).getFixedHeightMinor());
        }

        v1_1.recycle();
        ((ContentFrameLayout)v0).requestLayout();
    }

    private void z() {
        if(this.x) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }
}

