package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.h.p;
import android.support.v4.h.r;
import android.support.v4.h.t;
import android.support.v7.a.a$a;
import android.support.v7.a.a$e;
import android.support.v7.a.a$f;
import android.support.v7.a.a$h;
import android.support.v7.a.a$j;
import android.support.v7.b.a.b;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.Window$Callback;

public class ax implements ad {
    Toolbar a;
    CharSequence b;
    Window$Callback c;
    boolean d;
    private int e;
    private View f;
    private View g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private d n;
    private int o;
    private int p;
    private Drawable q;

    public ax(Toolbar arg3, boolean arg4) {
        this(arg3, arg4, h.abc_action_bar_up_description, e.abc_ic_ab_back_material);
    }

    public ax(Toolbar arg7, boolean arg8, int arg9, int arg10) {
        int v5 = -1;
        super();
        this.o = 0;
        this.p = 0;
        this.a = arg7;
        this.b = arg7.getTitle();
        this.l = arg7.getSubtitle();
        boolean v0 = this.b != null ? true : false;
        this.k = v0;
        this.j = arg7.getNavigationIcon();
        aw v0_1 = aw.a(arg7.getContext(), null, j.ActionBar, a.actionBarStyle, 0);
        this.q = v0_1.a(j.ActionBar_homeAsUpIndicator);
        if(arg8) {
            CharSequence v2 = v0_1.c(j.ActionBar_title);
            if(!TextUtils.isEmpty(v2)) {
                this.b(v2);
            }

            v2 = v0_1.c(j.ActionBar_subtitle);
            if(!TextUtils.isEmpty(v2)) {
                this.c(v2);
            }

            Drawable v2_1 = v0_1.a(j.ActionBar_logo);
            if(v2_1 != null) {
                this.b(v2_1);
            }

            v2_1 = v0_1.a(j.ActionBar_icon);
            if(v2_1 != null) {
                this.a(v2_1);
            }

            if(this.j == null && this.q != null) {
                this.c(this.q);
            }

            this.c(v0_1.a(j.ActionBar_displayOptions, 0));
            int v2_2 = v0_1.g(j.ActionBar_customNavigationLayout, 0);
            if(v2_2 != 0) {
                this.a(LayoutInflater.from(this.a.getContext()).inflate(v2_2, this.a, false));
                this.c(this.e | 16);
            }

            v2_2 = v0_1.f(j.ActionBar_height, 0);
            if(v2_2 > 0) {
                ViewGroup$LayoutParams v3 = this.a.getLayoutParams();
                v3.height = v2_2;
                this.a.setLayoutParams(v3);
            }

            v2_2 = v0_1.d(j.ActionBar_contentInsetStart, v5);
            int v3_1 = v0_1.d(j.ActionBar_contentInsetEnd, v5);
            if(v2_2 >= 0 || v3_1 >= 0) {
                this.a.a(Math.max(v2_2, 0), Math.max(v3_1, 0));
            }

            v2_2 = v0_1.g(j.ActionBar_titleTextStyle, 0);
            if(v2_2 != 0) {
                this.a.a(this.a.getContext(), v2_2);
            }

            v2_2 = v0_1.g(j.ActionBar_subtitleTextStyle, 0);
            if(v2_2 != 0) {
                this.a.b(this.a.getContext(), v2_2);
            }

            int v1 = v0_1.g(j.ActionBar_popupTheme, 0);
            if(v1 == 0) {
                goto label_101;
            }

            this.a.setPopupTheme(v1);
        }
        else {
            this.e = this.r();
        }

    label_101:
        v0_1.a();
        this.e(arg9);
        this.m = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new View$OnClickListener() {
            final android.support.v7.view.menu.a a;

            public void onClick(View arg4) {
                if(this.b.c != null && (this.b.d)) {
                    this.b.c.onMenuItemSelected(0, this.a);
                }
            }
        });
    }

    public void a(Drawable arg1) {
        this.h = arg1;
        this.s();
    }

    public void a(View arg3) {
        if(this.g != null && (this.e & 16) != 0) {
            this.a.removeView(this.g);
        }

        this.g = arg3;
        if(arg3 != null && (this.e & 16) != 0) {
            this.a.addView(this.g);
        }
    }

    public r a(int arg3, long arg4) {
        r v1 = p.d(this.a);
        float v0 = arg3 == 0 ? 1f : 0f;
        return v1.a(v0).a(arg4).a(new t(arg3) {
            private boolean c;

            public void a(View arg3) {
                this.b.a.setVisibility(0);
            }

            public void b(View arg3) {
                if(!this.c) {
                    this.b.a.setVisibility(this.a);
                }
            }

            public void c(View arg2) {
                this.c = true;
            }
        });
    }

    public ViewGroup a() {
        return this.a;
    }

    public void a(int arg2) {
        Drawable v0 = arg2 != 0 ? b.b(this.b(), arg2) : null;
        this.a(v0);
    }

    public void a(android.support.v7.view.menu.o$a arg2, android.support.v7.view.menu.h$a arg3) {
        this.a.a(arg2, arg3);
    }

    public void a(ap arg5) {
        int v3 = -2;
        if(this.f != null && this.f.getParent() == this.a) {
            this.a.removeView(this.f);
        }

        this.f = ((View)arg5);
        if(arg5 != null && this.o == 2) {
            this.a.addView(this.f, 0);
            ViewGroup$LayoutParams v0 = this.f.getLayoutParams();
            ((android.support.v7.widget.Toolbar$b)v0).width = v3;
            ((android.support.v7.widget.Toolbar$b)v0).height = v3;
            ((android.support.v7.widget.Toolbar$b)v0).a = 0x800053;
            arg5.setAllowCollapse(true);
        }
    }

    public void a(Menu arg3, android.support.v7.view.menu.o$a arg4) {
        if(this.n == null) {
            this.n = new d(this.a.getContext());
            this.n.a(f.action_menu_presenter);
        }

        this.n.a(arg4);
        this.a.a(((android.support.v7.view.menu.h)arg3), this.n);
    }

    public void a(Window$Callback arg1) {
        this.c = arg1;
    }

    public void a(CharSequence arg2) {
        if(!this.k) {
            this.e(arg2);
        }
    }

    public void a(boolean arg2) {
        this.a.setCollapsible(arg2);
    }

    public void b(CharSequence arg2) {
        this.k = true;
        this.e(arg2);
    }

    public void b(Drawable arg1) {
        this.i = arg1;
        this.s();
    }

    public Context b() {
        return this.a.getContext();
    }

    public void b(int arg2) {
        Drawable v0 = arg2 != 0 ? b.b(this.b(), arg2) : null;
        this.b(v0);
    }

    public void b(boolean arg1) {
    }

    public void c(CharSequence arg2) {
        this.l = arg2;
        if((this.e & 8) != 0) {
            this.a.setSubtitle(arg2);
        }
    }

    public void c(Drawable arg1) {
        this.j = arg1;
        this.t();
    }

    public void c(int arg4) {
        CharSequence v2 = null;
        int v0 = this.e ^ arg4;
        this.e = arg4;
        if(v0 != 0) {
            if((v0 & 4) != 0) {
                if((arg4 & 4) != 0) {
                    this.u();
                }

                this.t();
            }

            if((v0 & 3) != 0) {
                this.s();
            }

            if((v0 & 8) != 0) {
                if((arg4 & 8) != 0) {
                    this.a.setTitle(this.b);
                    this.a.setSubtitle(this.l);
                }
                else {
                    this.a.setTitle(v2);
                    this.a.setSubtitle(v2);
                }
            }

            if((v0 & 16) == 0) {
                return;
            }

            if(this.g == null) {
                return;
            }

            if((arg4 & 16) != 0) {
                this.a.addView(this.g);
                return;
            }

            this.a.removeView(this.g);
        }
    }

    public boolean c() {
        return this.a.g();
    }

    public void d() {
        this.a.h();
    }

    public void d(int arg2) {
        this.a.setVisibility(arg2);
    }

    public void d(CharSequence arg1) {
        this.m = arg1;
        this.u();
    }

    public void e(int arg2) {
        if(arg2 != this.p) {
            this.p = arg2;
            if(TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
                this.f(this.p);
            }
        }
    }

    private void e(CharSequence arg2) {
        this.b = arg2;
        if((this.e & 8) != 0) {
            this.a.setTitle(arg2);
        }
    }

    public CharSequence e() {
        return this.a.getTitle();
    }

    public void f(int arg2) {
        CharSequence v0;
        if(arg2 == 0) {
            v0 = null;
        }
        else {
            String v0_1 = this.b().getString(arg2);
        }

        this.d(v0);
    }

    public void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean h() {
        return this.a.a();
    }

    public boolean i() {
        return this.a.b();
    }

    public boolean j() {
        return this.a.c();
    }

    public boolean k() {
        return this.a.d();
    }

    public boolean l() {
        return this.a.e();
    }

    public void m() {
        this.d = true;
    }

    public void n() {
        this.a.f();
    }

    public int o() {
        return this.e;
    }

    public int p() {
        return this.o;
    }

    public Menu q() {
        return this.a.getMenu();
    }

    private int r() {
        int v0 = 11;
        if(this.a.getNavigationIcon() != null) {
            v0 = 15;
            this.q = this.a.getNavigationIcon();
        }

        return v0;
    }

    private void s() {
        Drawable v0 = null;
        if((this.e & 2) != 0) {
            if((this.e & 1) == 0) {
                v0 = this.h;
            }
            else if(this.i != null) {
                v0 = this.i;
            }
            else {
                v0 = this.h;
            }
        }

        this.a.setLogo(v0);
    }

    private void t() {
        if((this.e & 4) != 0) {
            Toolbar v1 = this.a;
            Drawable v0 = this.j != null ? this.j : this.q;
            v1.setNavigationIcon(v0);
        }
        else {
            this.a.setNavigationIcon(null);
        }
    }

    private void u() {
        if((this.e & 4) != 0) {
            if(TextUtils.isEmpty(this.m)) {
                this.a.setNavigationContentDescription(this.p);
            }
            else {
                this.a.setNavigationContentDescription(this.m);
            }
        }
    }
}

