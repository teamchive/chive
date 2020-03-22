package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.h.c$a;
import android.support.v7.a.a$g;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.b;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.n;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.s;
import android.support.v7.view.menu.u;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

class d extends b implements a {
    class android.support.v7.widget.d$a extends n {
        public android.support.v7.widget.d$a(d arg7, Context arg8, u arg9, View arg10) {
            p v0;
            this.a = arg7;
            super(arg8, arg9, arg10, false, android.support.v7.a.a$a.actionOverflowMenuStyle);
            if(!arg9.getItem().j()) {
                if(arg7.g == null) {
                    v0 = d.c(arg7);
                }
                else {
                    android.support.v7.widget.d$d v0_1 = arg7.g;
                }

                this.a(((View)v0));
            }

            this.a(arg7.k);
        }

        protected void e() {
            this.a.i = null;
            this.a.l = 0;
            super.e();
        }
    }

    class android.support.v7.widget.d$b extends android.support.v7.view.menu.ActionMenuItemView$b {
        android.support.v7.widget.d$b(d arg1) {
            this.a = arg1;
            super();
        }

        public s a() {
            s v0_1;
            if(this.a.i != null) {
                m v0 = this.a.i.b();
            }
            else {
                v0_1 = null;
            }

            return v0_1;
        }
    }

    class c implements Runnable {
        private e b;

        public c(d arg1, e arg2) {
            this.a = arg1;
            super();
            this.b = arg2;
        }

        public void run() {
            if(d.d(this.a) != null) {
                d.e(this.a).f();
            }

            p v0 = d.f(this.a);
            if(v0 != null && ((View)v0).getWindowToken() != null && (this.b.c())) {
                this.a.h = this.b;
            }

            this.a.j = null;
        }
    }

    class android.support.v7.widget.d$d extends android.support.v7.widget.p implements android.support.v7.widget.ActionMenuView$a {
        private final float[] b;

        public android.support.v7.widget.d$d(d arg4, Context arg5) {
            this.a = arg4;
            super(arg5, null, android.support.v7.a.a$a.actionOverflowButtonStyle);
            this.b = new float[2];
            this.setClickable(true);
            this.setFocusable(true);
            this.setVisibility(0);
            this.setEnabled(true);
            ay.a(((View)this), this.getContentDescription());
            this.setOnTouchListener(new ah(((View)this), arg4) {
                public s a() {
                    m v0_1;
                    if(this.b.a.h == null) {
                        s v0 = null;
                    }
                    else {
                        v0_1 = this.b.a.h.b();
                    }

                    return ((s)v0_1);
                }

                public boolean b() {
                    this.b.a.d();
                    return 1;
                }

                public boolean c() {
                    boolean v0;
                    if(this.b.a.j != null) {
                        v0 = false;
                    }
                    else {
                        this.b.a.e();
                        v0 = true;
                    }

                    return v0;
                }
            });
        }

        public boolean c() {
            return 0;
        }

        public boolean d() {
            return 0;
        }

        public boolean performClick() {
            if(!super.performClick()) {
                this.playSoundEffect(0);
                this.a.d();
            }

            return 1;
        }

        protected boolean setFrame(int arg9, int arg10, int arg11, int arg12) {
            boolean v0 = super.setFrame(arg9, arg10, arg11, arg12);
            Drawable v1 = this.getDrawable();
            Drawable v2 = this.getBackground();
            if(v1 != null && v2 != null) {
                int v1_1 = this.getWidth();
                int v3 = this.getHeight();
                int v4 = Math.max(v1_1, v3) / 2;
                v1_1 = (v1_1 + (this.getPaddingLeft() - this.getPaddingRight())) / 2;
                v3 = (v3 + (this.getPaddingTop() - this.getPaddingBottom())) / 2;
                android.support.v4.c.a.a.a(v2, v1_1 - v4, v3 - v4, v1_1 + v4, v3 + v4);
            }

            return v0;
        }
    }

    class e extends n {
        public e(d arg7, Context arg8, h arg9, View arg10, boolean arg11) {
            this.a = arg7;
            super(arg8, arg9, arg10, arg11, android.support.v7.a.a$a.actionOverflowMenuStyle);
            this.a(0x800005);
            this.a(arg7.k);
        }

        protected void e() {
            if(d.a(this.a) != null) {
                d.b(this.a).close();
            }

            this.a.h = null;
            super.e();
        }
    }

    class f implements android.support.v7.view.menu.o$a {
        f(d arg1) {
            this.a = arg1;
            super();
        }

        public void a(h arg3, boolean arg4) {
            if((arg3 instanceof u)) {
                arg3.p().a(false);
            }

            android.support.v7.view.menu.o$a v0 = this.a.a();
            if(v0 != null) {
                v0.a(arg3, arg4);
            }
        }

        public boolean a(h arg4) {
            boolean v1 = false;
            if(arg4 != null) {
                this.a.l = arg4.getItem().getItemId();
                android.support.v7.view.menu.o$a v0 = this.a.a();
                boolean v0_1 = v0 != null ? v0.a(arg4) : false;
                v1 = v0_1;
            }

            return v1;
        }
    }

    private android.support.v7.widget.d$b A;
    android.support.v7.widget.d$d g;
    e h;
    android.support.v7.widget.d$a i;
    c j;
    final f k;
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y;
    private View z;

    public d(Context arg3) {
        super(arg3, g.abc_action_menu_layout, g.abc_action_menu_item_layout);
        this.y = new SparseBooleanArray();
        this.k = new f(this);
    }

    public void a(Configuration arg3) {
        if(!this.t) {
            this.s = android.support.v7.view.a.a(this.b).a();
        }

        if(this.c != null) {
            this.c.b(true);
        }
    }

    public p a(ViewGroup arg3) {
        p v0 = this.f;
        p v1 = super.a(arg3);
        if(v0 != v1) {
            v1.setPresenter(this);
        }

        return v1;
    }

    public void a(ActionMenuView arg2) {
        this.f = ((p)arg2);
        arg2.a(this.c);
    }

    public void a(Drawable arg2) {
        if(this.g != null) {
            this.g.setImageDrawable(arg2);
        }
        else {
            this.n = true;
            this.m = arg2;
        }
    }

    public void a(Context arg7, h arg8) {
        Drawable v5 = null;
        super.a(arg7, arg8);
        Resources v1 = arg7.getResources();
        android.support.v7.view.a v0 = android.support.v7.view.a.a(arg7);
        if(!this.p) {
            this.o = v0.b();
        }

        if(!this.v) {
            this.q = v0.c();
        }

        if(!this.t) {
            this.s = v0.a();
        }

        int v0_1 = this.q;
        if(this.o) {
            if(this.g == null) {
                this.g = new android.support.v7.widget.d$d(this, this.a);
                if(this.n) {
                    this.g.setImageDrawable(this.m);
                    this.m = v5;
                    this.n = false;
                }

                int v2 = View$MeasureSpec.makeMeasureSpec(0, 0);
                this.g.measure(v2, v2);
            }

            v0_1 -= this.g.getMeasuredWidth();
        }
        else {
            this.g = ((android.support.v7.widget.d$d)v5);
        }

        this.r = v0_1;
        this.x = ((int)(56f * v1.getDisplayMetrics().density));
        this.z = ((View)v5);
    }

    static h a(d arg1) {
        return arg1.c;
    }

    private View a(MenuItem arg7) {
        View v2;
        View v3 = null;
        p v0 = this.f;
        if(v0 == null) {
            v2 = v3;
        }
        else {
            int v5 = ((ViewGroup)v0).getChildCount();
            int v4;
            for(v4 = 0; v4 < v5; ++v4) {
                v2 = ((ViewGroup)v0).getChildAt(v4);
                if(((v2 instanceof android.support.v7.view.menu.p$a)) && v2.getItemData() == arg7) {
                    return v2;
                }
            }

            v2 = v3;
        }

        return v2;
    }

    public View a(j arg4, View arg5, ViewGroup arg6) {
        View v0 = arg4.getActionView();
        if(v0 == null || (arg4.n())) {
            v0 = super.a(arg4, arg5, arg6);
        }

        int v1 = arg4.isActionViewExpanded() ? 8 : 0;
        v0.setVisibility(v1);
        ViewGroup$LayoutParams v1_1 = v0.getLayoutParams();
        if(!((ActionMenuView)arg6).checkLayoutParams(v1_1)) {
            v0.setLayoutParams(((ActionMenuView)arg6).a(v1_1));
        }

        return v0;
    }

    public void a(h arg1, boolean arg2) {
        this.f();
        super.a(arg1, arg2);
    }

    public void a(j arg2, android.support.v7.view.menu.p$a arg3) {
        arg3.a(arg2, 0);
        ((ActionMenuItemView)arg3).setItemInvoker(this.f);
        if(this.A == null) {
            this.A = new android.support.v7.widget.d$b(this);
        }

        ((ActionMenuItemView)arg3).setPopupCallback(this.A);
    }

    public void a(boolean arg3) {
        if(arg3) {
            super.a(null);
        }
        else if(this.c != null) {
            this.c.a(false);
        }
    }

    public boolean a(int arg2, j arg3) {
        return arg3.j();
    }

    public boolean a(u arg8) {
        boolean v0_3;
        boolean v2 = false;
        if(arg8.hasVisibleItems()) {
            u v0 = arg8;
            while(v0.s() != this.c) {
                Menu v0_1 = v0.s();
            }

            View v3 = this.a(v0.getItem());
            if(v3 != null) {
                this.l = arg8.getItem().getItemId();
                int v4 = arg8.size();
                int v0_2;
                for(v0_2 = 0; v0_2 < v4; ++v0_2) {
                    MenuItem v5 = arg8.getItem(v0_2);
                    if((v5.isVisible()) && v5.getIcon() != null) {
                        v0_3 = true;
                        goto label_26;
                    }
                }

                v0_3 = false;
            label_26:
                this.i = new android.support.v7.widget.d$a(this, this.b, arg8, v3);
                this.i.a(v0_3);
                this.i.a();
                super.a(arg8);
                v2 = true;
            }
        }

        return v2;
    }

    public boolean a(ViewGroup arg3, int arg4) {
        boolean v0 = arg3.getChildAt(arg4) == this.g ? false : super.a(arg3, arg4);
        return v0;
    }

    public void b(boolean arg7) {
        int v1 = 1;
        int v2 = 0;
        super.b(arg7);
        this.f.requestLayout();
        if(this.c != null) {
            ArrayList v4 = this.c.k();
            int v5 = v4.size();
            int v3;
            for(v3 = 0; v3 < v5; ++v3) {
                android.support.v4.h.c v0 = v4.get(v3).a();
                if(v0 != null) {
                    v0.a(((a)this));
                }
            }
        }

        ArrayList v0_1 = this.c != null ? this.c.l() : null;
        if((this.o) && v0_1 != null) {
            v3 = v0_1.size();
            if(v3 == 1) {
                int v0_2 = !v0_1.get(0).isActionViewExpanded() ? 1 : 0;
                v2 = v0_2;
            }
            else {
                if(v3 <= 0) {
                    v1 = 0;
                }

                v2 = v1;
            }
        }

        if(v2 != 0) {
            if(this.g == null) {
                this.g = new android.support.v7.widget.d$d(this, this.a);
            }

            ViewParent v0_3 = this.g.getParent();
            if(v0_3 == this.f) {
                goto label_51;
            }

            if(v0_3 != null) {
                ((ViewGroup)v0_3).removeView(this.g);
            }

            this.f.addView(this.g, this.f.c());
        }
        else {
            if(this.g == null) {
                goto label_51;
            }

            if(this.g.getParent() != this.f) {
                goto label_51;
            }

            this.f.removeView(this.g);
        }

    label_51:
        this.f.setOverflowReserved(this.o);
    }

    static h b(d arg1) {
        return arg1.c;
    }

    public boolean b() {
        int v13_1;
        int v20;
        int v10;
        int v3_2;
        Object v3_1;
        ArrayList v6;
        int v5;
        if(this.c != null) {
            ArrayList v3 = this.c.i();
            v5 = v3.size();
            v6 = v3;
        }
        else {
            v5 = 0;
            v6 = null;
        }

        int v9 = this.s;
        int v11 = this.r;
        int v15 = View$MeasureSpec.makeMeasureSpec(0, 0);
        p v2 = this.f;
        int v8 = 0;
        int v7 = 0;
        int v4 = 0;
        int v12 = 0;
        while(v12 < v5) {
            v3_1 = v6.get(v12);
            if(((j)v3_1).l()) {
                ++v8;
            }
            else if(((j)v3_1).k()) {
                ++v7;
            }
            else {
                v4 = 1;
            }

            v3_2 = !this.w || !((j)v3_1).isActionViewExpanded() ? v9 : 0;
            ++v12;
            v9 = v3_2;
        }

        if((this.o) && (v4 != 0 || v8 + v7 > v9)) {
            --v9;
        }

        v12 = v9 - v8;
        SparseBooleanArray v16 = this.y;
        v16.clear();
        v3_2 = 0;
        if(this.u) {
            v3_2 = v11 / this.x;
            v7 = v11 % this.x / v3_2 + this.x;
        }
        else {
            v7 = 0;
        }

        int v14 = 0;
        v9 = 0;
        v4 = v3_2;
        while(v14 < v5) {
            v3_1 = v6.get(v14);
            if(((j)v3_1).l()) {
                View v8_1 = this.a(((j)v3_1), this.z, ((ViewGroup)v2));
                if(this.z == null) {
                    this.z = v8_1;
                }

                if(this.u) {
                    v4 -= ActionMenuView.a(v8_1, v7, v4, v15, 0);
                }
                else {
                    v8_1.measure(v15, v15);
                }

                v8 = v8_1.getMeasuredWidth();
                v10 = v11 - v8;
                if(v9 != 0) {
                    v8 = v9;
                }

                v9 = ((j)v3_1).getGroupId();
                if(v9 != 0) {
                    v16.put(v9, true);
                }

                ((j)v3_1).d(true);
                v3_2 = v10;
                v9 = v12;
            }
            else {
                if(((j)v3_1).k()) {
                    int v17 = ((j)v3_1).getGroupId();
                    boolean v18 = v16.get(v17);
                    if(v12 <= 0 && !v18) {
                        goto label_181;
                    }
                    else if(v11 > 0) {
                        if((this.u) && v4 <= 0) {
                            goto label_181;
                        }

                        v8 = 1;
                    }
                    else {
                    label_181:
                        v8 = 0;
                    }

                    if(v8 != 0) {
                        View v13 = this.a(((j)v3_1), this.z, ((ViewGroup)v2));
                        if(this.z == null) {
                            this.z = v13;
                        }

                        if(this.u) {
                            int v19 = ActionMenuView.a(v13, v7, v4, v15, 0);
                            v10 = v4 - v19;
                            v4 = v19 == 0 ? 0 : v8;
                            v8 = v10;
                        }
                        else {
                            v13.measure(v15, v15);
                            v20 = v8;
                            v8 = v4;
                            v4 = v20;
                        }

                        v10 = v13.getMeasuredWidth();
                        v11 -= v10;
                        if(v9 == 0) {
                            v9 = v10;
                        }

                        if(this.u) {
                            v10 = v11 >= 0 ? 1 : 0;
                            v13_1 = v4 & v10;
                            v10 = v9;
                            v9 = v8;
                            goto label_165;
                        }

                        v10 = v11 + v9 > 0 ? 1 : 0;
                        v13_1 = v4 & v10;
                        v10 = v9;
                        v9 = v8;
                    }
                    else {
                        v13_1 = v8;
                        v10 = v9;
                        v9 = v4;
                    }

                label_165:
                    if(v13_1 != 0 && v17 != 0) {
                        v16.put(v17, true);
                        v4 = v12;
                    }
                    else if(v18) {
                        v16.put(v17, false);
                        v8 = v12;
                        for(v12 = 0; v12 < v14; ++v12) {
                            Object v4_1 = v6.get(v12);
                            if(((j)v4_1).getGroupId() == v17) {
                                if(((j)v4_1).j()) {
                                    ++v8;
                                }

                                ((j)v4_1).d(false);
                            }
                        }

                        v4 = v8;
                    }
                    else {
                        v4 = v12;
                    }

                    if(v13_1 != 0) {
                        --v4;
                    }

                    ((j)v3_1).d(((boolean)v13_1));
                    v8 = v10;
                    v3_2 = v11;
                    v20 = v9;
                    v9 = v4;
                    v4 = v20;
                    goto label_113;
                }

                ((j)v3_1).d(false);
                v8 = v9;
                v3_2 = v11;
                v9 = v12;
            }

        label_113:
            ++v14;
            v11 = v3_2;
            v12 = v9;
            v9 = v8;
        }

        return 1;
    }

    public void c(boolean arg2) {
        this.o = arg2;
        this.p = true;
    }

    public Drawable c() {
        Drawable v0;
        if(this.g != null) {
            v0 = this.g.getDrawable();
        }
        else if(this.n) {
            v0 = this.m;
        }
        else {
            v0 = null;
        }

        return v0;
    }

    static p c(d arg1) {
        return arg1.f;
    }

    public boolean d() {
        boolean v5 = true;
        if(!this.o || (this.h()) || this.c == null || this.f == null || this.j != null || (this.c.l().isEmpty())) {
            v5 = false;
        }
        else {
            this.j = new c(this, new e(this, this.b, this.c, this.g, true));
            this.f.post(this.j);
            super.a(null);
        }

        return v5;
    }

    public void d(boolean arg1) {
        this.w = arg1;
    }

    static h d(d arg1) {
        return arg1.c;
    }

    public boolean e() {
        boolean v0;
        if(this.j == null || this.f == null) {
            e v0_1 = this.h;
            if(v0_1 != null) {
                ((n)v0_1).d();
                v0 = true;
            }
            else {
                v0 = false;
            }
        }
        else {
            this.f.removeCallbacks(this.j);
            this.j = null;
            v0 = true;
        }

        return v0;
    }

    static h e(d arg1) {
        return arg1.c;
    }

    public boolean f() {
        return this.e() | this.g();
    }

    static p f(d arg1) {
        return arg1.f;
    }

    public boolean g() {
        boolean v0;
        if(this.i != null) {
            this.i.d();
            v0 = true;
        }
        else {
            v0 = false;
        }

        return v0;
    }

    public boolean h() {
        boolean v0 = this.h == null || !this.h.f() ? false : true;
        return v0;
    }

    public boolean i() {
        boolean v0 = this.j != null || (this.h()) ? true : false;
        return v0;
    }
}

