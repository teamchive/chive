package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.a.a$d;
import android.support.v7.widget.am;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View$OnAttachStateChangeListener;
import android.view.View$OnKeyListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.TextView;

final class t extends m implements o, View$OnKeyListener, AdapterView$OnItemClickListener, PopupWindow$OnDismissListener {
    class android.support.v7.view.menu.t$1 implements ViewTreeObserver$OnGlobalLayoutListener {
        android.support.v7.view.menu.t$1(t arg1) {
            this.a = arg1;
            super();
        }

        public void onGlobalLayout() {
            if((this.a.d()) && !this.a.a.g()) {
                View v0 = this.a.b;
                if(v0 != null && (v0.isShown())) {
                    this.a.a.a();
                    return;
                }

                this.a.c();
            }
        }
    }

    class android.support.v7.view.menu.t$2 implements View$OnAttachStateChangeListener {
        android.support.v7.view.menu.t$2(t arg1) {
            this.a = arg1;
            super();
        }

        public void onViewAttachedToWindow(View arg1) {
        }

        public void onViewDetachedFromWindow(View arg3) {
            if(t.a(this.a) != null) {
                if(!t.a(this.a).isAlive()) {
                    t.a(this.a, arg3.getViewTreeObserver());
                }

                t.a(this.a).removeGlobalOnLayoutListener(t.b(this.a));
            }

            arg3.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
        }
    }

    final am a;
    View b;
    private final Context c;
    private final h d;
    private final g e;
    private final boolean f;
    private final int g;
    private final int h;
    private final int i;
    private final ViewTreeObserver$OnGlobalLayoutListener j;
    private final View$OnAttachStateChangeListener k;
    private PopupWindow$OnDismissListener l;
    private View m;
    private a n;
    private ViewTreeObserver o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private boolean t;

    public t(Context arg6, h arg7, View arg8, int arg9, int arg10, boolean arg11) {
        super();
        this.j = new android.support.v7.view.menu.t$1(this);
        this.k = new android.support.v7.view.menu.t$2(this);
        this.s = 0;
        this.c = arg6;
        this.d = arg7;
        this.f = arg11;
        this.e = new g(arg7, LayoutInflater.from(arg6), this.f);
        this.h = arg9;
        this.i = arg10;
        Resources v0 = arg6.getResources();
        this.g = Math.max(v0.getDisplayMetrics().widthPixels / 2, v0.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.m = arg8;
        this.a = new am(this.c, null, this.h, this.i);
        arg7.a(((o)this), arg6);
    }

    static ViewTreeObserver a(t arg1) {
        return arg1.o;
    }

    static ViewTreeObserver a(t arg0, ViewTreeObserver arg1) {
        arg0.o = arg1;
        return arg1;
    }

    public void a() {
        if(!this.h()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void a(int arg1) {
        this.s = arg1;
    }

    public void a(h arg1) {
    }

    public void a(h arg2, boolean arg3) {
        if(arg2 == this.d) {
            this.c();
            if(this.n != null) {
                this.n.a(arg2, arg3);
            }
        }
    }

    public void a(a arg1) {
        this.n = arg1;
    }

    public void a(View arg1) {
        this.m = arg1;
    }

    public void a(PopupWindow$OnDismissListener arg1) {
        this.l = arg1;
    }

    public void a(boolean arg2) {
        this.e.a(arg2);
    }

    public boolean a(u arg9) {
        boolean v0_1;
        if(arg9.hasVisibleItems()) {
            n v0 = new n(this.c, arg9, this.b, this.f, this.h, this.i);
            v0.a(this.n);
            v0.a(m.b(((h)arg9)));
            v0.a(this.s);
            v0.a(this.l);
            this.l = null;
            this.d.a(false);
            if(v0.a(this.a.j(), this.a.k())) {
                if(this.n != null) {
                    this.n.a(((h)arg9));
                }

                v0_1 = true;
            }
            else {
                goto label_35;
            }
        }
        else {
        label_35:
            v0_1 = false;
        }

        return v0_1;
    }

    static ViewTreeObserver$OnGlobalLayoutListener b(t arg1) {
        return arg1.j;
    }

    public void b(int arg2) {
        this.a.c(arg2);
    }

    public void b(boolean arg2) {
        this.q = false;
        if(this.e != null) {
            this.e.notifyDataSetChanged();
        }
    }

    public boolean b() {
        return 0;
    }

    public void c() {
        if(this.d()) {
            this.a.c();
        }
    }

    public void c(int arg2) {
        this.a.d(arg2);
    }

    public void c(boolean arg1) {
        this.t = arg1;
    }

    public boolean d() {
        boolean v0 = (this.p) || !this.a.d() ? false : true;
        return v0;
    }

    public ListView e() {
        return this.a.e();
    }

    private boolean h() {
        ViewGroup v6 = null;
        boolean v2 = true;
        if(!this.d()) {
            if(!this.p && this.m != null) {
                this.b = this.m;
                this.a.a(((PopupWindow$OnDismissListener)this));
                this.a.a(((AdapterView$OnItemClickListener)this));
                this.a.a(true);
                View v1 = this.b;
                int v0 = this.o == null ? 1 : 0;
                this.o = v1.getViewTreeObserver();
                if(v0 != 0) {
                    this.o.addOnGlobalLayoutListener(this.j);
                }

                v1.addOnAttachStateChangeListener(this.k);
                this.a.b(v1);
                this.a.e(this.s);
                if(!this.q) {
                    this.r = t.a(this.e, v6, this.c, this.g);
                    this.q = true;
                }

                this.a.g(this.r);
                this.a.h(2);
                this.a.a(this.g());
                this.a.a();
                ListView v4 = this.a.e();
                v4.setOnKeyListener(((View$OnKeyListener)this));
                if((this.t) && this.d.m() != null) {
                    View v0_1 = LayoutInflater.from(this.c).inflate(android.support.v7.a.a$g.abc_popup_menu_header_item_layout, ((ViewGroup)v4), false);
                    v1 = ((FrameLayout)v0_1).findViewById(0x1020016);
                    if(v1 != null) {
                        ((TextView)v1).setText(this.d.m());
                    }

                    ((FrameLayout)v0_1).setEnabled(false);
                    v4.addHeaderView(v0_1, v6, false);
                }

                this.a.a(this.e);
                this.a.a();
                return v2;
            }

            v2 = false;
        }

        return v2;
    }

    public void onDismiss() {
        this.p = true;
        this.d.close();
        if(this.o != null) {
            if(!this.o.isAlive()) {
                this.o = this.b.getViewTreeObserver();
            }

            this.o.removeGlobalOnLayoutListener(this.j);
            this.o = null;
        }

        this.b.removeOnAttachStateChangeListener(this.k);
        if(this.l != null) {
            this.l.onDismiss();
        }
    }

    public boolean onKey(View arg3, int arg4, KeyEvent arg5) {
        boolean v0 = true;
        if(arg5.getAction() != 1 || arg4 != 82) {
            v0 = false;
        }
        else {
            this.c();
        }

        return v0;
    }
}

