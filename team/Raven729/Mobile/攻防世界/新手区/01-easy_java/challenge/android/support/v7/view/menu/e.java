package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.h.p;
import android.support.v7.a.a$d;
import android.support.v7.widget.al;
import android.support.v7.widget.am;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View$OnAttachStateChangeListener;
import android.view.View$OnKeyListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class e extends m implements o, View$OnKeyListener, PopupWindow$OnDismissListener {
    class android.support.v7.view.menu.e$1 implements ViewTreeObserver$OnGlobalLayoutListener {
        android.support.v7.view.menu.e$1(e arg1) {
            this.a = arg1;
            super();
        }

        public void onGlobalLayout() {
            if((this.a.d()) && this.a.b.size() > 0 && !this.a.b.get(0).a.g()) {
                View v0 = this.a.c;
                if(v0 != null && (v0.isShown())) {
                    Iterator v1 = this.a.b.iterator();
                    while(true) {
                        if(v1.hasNext()) {
                            v1.next().a.a();
                            continue;
                        }
                        else {
                            return;
                        }
                    }
                }

                this.a.c();
            }
        }
    }

    class android.support.v7.view.menu.e$2 implements View$OnAttachStateChangeListener {
        android.support.v7.view.menu.e$2(e arg1) {
            this.a = arg1;
            super();
        }

        public void onViewAttachedToWindow(View arg1) {
        }

        public void onViewDetachedFromWindow(View arg3) {
            if(e.a(this.a) != null) {
                if(!e.a(this.a).isAlive()) {
                    e.a(this.a, arg3.getViewTreeObserver());
                }

                e.a(this.a).removeGlobalOnLayoutListener(e.b(this.a));
            }

            arg3.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
        }
    }

    class android.support.v7.view.menu.e$3 implements al {
        android.support.v7.view.menu.e$3(e arg1) {
            this.a = arg1;
            super();
        }

        public void a(h arg2, MenuItem arg3) {
            this.a.a.removeCallbacksAndMessages(arg2);
        }

        public void b(h arg7, MenuItem arg8) {
            Object v0_1;
            int v0;
            Object v1 = null;
            int v3 = -1;
            this.a.a.removeCallbacksAndMessages(v1);
            int v2 = 0;
            int v4 = this.a.b.size();
            while(true) {
                if(v2 >= v4) {
                    break;
                }
                else if(arg7 == this.a.b.get(v2).b) {
                    v0 = v2;
                }
                else {
                    ++v2;
                    continue;
                }

                goto label_16;
            }

            v0 = v3;
        label_16:
            if(v0 != v3) {
                ++v0;
                if(v0 < this.a.b.size()) {
                    v0_1 = this.a.b.get(v0);
                }
                else {
                    a v0_2 = ((a)v1);
                }

                this.a.a.postAtTime(new Runnable(((a)v0_1), arg8, arg7) {
                    public void run() {
                        if(this.a != null) {
                            this.d.a.d = true;
                            this.a.b.a(false);
                            this.d.a.d = false;
                        }

                        if((this.b.isEnabled()) && (this.b.hasSubMenu())) {
                            this.c.a(this.b, 4);
                        }
                    }
                }, arg7, SystemClock.uptimeMillis() + 200);
            }
        }
    }

    class a {
        public final am a;
        public final h b;
        public final int c;

        public a(am arg1, h arg2, int arg3) {
            super();
            this.a = arg1;
            this.b = arg2;
            this.c = arg3;
        }

        public ListView a() {
            return this.a.e();
        }
    }

    final Handler a;
    final List b;
    View c;
    boolean d;
    private final Context e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;
    private final List j;
    private final ViewTreeObserver$OnGlobalLayoutListener k;
    private final View$OnAttachStateChangeListener l;
    private final al m;
    private int n;
    private int o;
    private View p;
    private int q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private android.support.v7.view.menu.o$a x;
    private ViewTreeObserver y;
    private PopupWindow$OnDismissListener z;

    public e(Context arg4, View arg5, int arg6, int arg7, boolean arg8) {
        super();
        this.j = new LinkedList();
        this.b = new ArrayList();
        this.k = new android.support.v7.view.menu.e$1(this);
        this.l = new android.support.v7.view.menu.e$2(this);
        this.m = new android.support.v7.view.menu.e$3(this);
        this.n = 0;
        this.o = 0;
        this.e = arg4;
        this.p = arg5;
        this.g = arg6;
        this.h = arg7;
        this.i = arg8;
        this.v = false;
        this.q = this.i();
        Resources v0 = arg4.getResources();
        this.f = Math.max(v0.getDisplayMetrics().widthPixels / 2, v0.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.a = new Handler();
    }

    private MenuItem a(h arg5, h arg6) {
        int v2 = arg5.size();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            MenuItem v0 = arg5.getItem(v1);
            if((v0.hasSubMenu()) && arg6 == v0.getSubMenu()) {
                return v0;
            }
        }

        return null;
    }

    private View a(a arg10, h arg11) {
        int v0_2;
        int v1;
        View v0;
        int v2 = 0;
        int v4 = -1;
        View v3 = null;
        MenuItem v5 = this.a(arg10.b, arg11);
        if(v5 == null) {
            v0 = v3;
        }
        else {
            ListView v6 = arg10.a();
            ListAdapter v0_1 = v6.getAdapter();
            if((v0_1 instanceof HeaderViewListAdapter)) {
                v1 = ((HeaderViewListAdapter)v0_1).getHeadersCount();
                v0_1 = ((HeaderViewListAdapter)v0_1).getWrappedAdapter();
            }
            else {
                v1 = 0;
            }

            int v7 = ((g)v0_1).getCount();
            while(true) {
                if(v2 >= v7) {
                    break;
                }
                else if(v5 == ((g)v0_1).a(v2)) {
                    v0_2 = v2;
                }
                else {
                    ++v2;
                    continue;
                }

                goto label_19;
            }

            v0_2 = v4;
        label_19:
            if(v0_2 == v4) {
                return v3;
            }

            v0_2 = v0_2 + v1 - v6.getFirstVisiblePosition();
            if(v0_2 >= 0 && v0_2 < v6.getChildCount()) {
                return v6.getChildAt(v0_2);
            }

            v0 = v3;
        }

        return v0;
    }

    static ViewTreeObserver a(e arg1) {
        return arg1.y;
    }

    static ViewTreeObserver a(e arg0, ViewTreeObserver arg1) {
        arg0.y = arg1;
        return arg1;
    }

    public void a() {
        if(!this.d()) {
            Iterator v1 = this.j.iterator();
            while(v1.hasNext()) {
                this.c(v1.next());
            }

            this.j.clear();
            this.c = this.p;
            if(this.c != null) {
                int v0 = this.y == null ? 1 : 0;
                this.y = this.c.getViewTreeObserver();
                if(v0 != 0) {
                    this.y.addOnGlobalLayoutListener(this.k);
                }

                this.c.addOnAttachStateChangeListener(this.l);
            }
        }
    }

    public void a(int arg2) {
        if(this.n != arg2) {
            this.n = arg2;
            this.o = android.support.v4.h.d.a(arg2, p.b(this.p));
        }
    }

    public void a(h arg2) {
        arg2.a(((o)this), this.e);
        if(this.d()) {
            this.c(arg2);
        }
        else {
            this.j.add(arg2);
        }
    }

    public void a(h arg6, boolean arg7) {
        Object v4 = null;
        int v1 = this.d(arg6);
        if(v1 >= 0) {
            int v0 = v1 + 1;
            if(v0 < this.b.size()) {
                this.b.get(v0).b.a(false);
            }

            Object v0_1 = this.b.remove(v1);
            ((a)v0_1).b.b(((o)this));
            if(this.d) {
                ((a)v0_1).a.b(v4);
                ((a)v0_1).a.b(0);
            }

            ((a)v0_1).a.c();
            v1 = this.b.size();
            this.q = v1 > 0 ? this.b.get(v1 - 1).c : this.i();
            if(v1 == 0) {
                this.c();
                if(this.x != null) {
                    this.x.a(arg6, true);
                }

                if(this.y != null) {
                    if(this.y.isAlive()) {
                        this.y.removeGlobalOnLayoutListener(this.k);
                    }

                    this.y = ((ViewTreeObserver)v4);
                }

                this.c.removeOnAttachStateChangeListener(this.l);
                this.z.onDismiss();
                return;
            }

            if(!arg7) {
                return;
            }

            this.b.get(0).b.a(false);
        }
    }

    public void a(android.support.v7.view.menu.o$a arg1) {
        this.x = arg1;
    }

    public void a(View arg3) {
        if(this.p != arg3) {
            this.p = arg3;
            this.o = android.support.v4.h.d.a(this.n, p.b(this.p));
        }
    }

    public void a(PopupWindow$OnDismissListener arg1) {
        this.z = arg1;
    }

    public void a(boolean arg1) {
        this.v = arg1;
    }

    public boolean a(u arg5) {
        Object v0;
        Iterator v2 = this.b.iterator();
        do {
            if(v2.hasNext()) {
                v0 = v2.next();
                if(arg5 != ((a)v0).b) {
                    continue;
                }

                break;
            }
            else {
                goto label_12;
            }
        }
        while(true);

        ((a)v0).a().requestFocus();
        boolean v0_1 = true;
        return v0_1;
    label_12:
        if(arg5.hasVisibleItems()) {
            this.a(((h)arg5));
            if(this.x != null) {
                this.x.a(((h)arg5));
            }

            v0_1 = true;
        }
        else {
            v0_1 = false;
        }

        return v0_1;
    }

    static ViewTreeObserver$OnGlobalLayoutListener b(e arg1) {
        return arg1.k;
    }

    public void b(int arg2) {
        this.r = true;
        this.t = arg2;
    }

    public void b(boolean arg3) {
        Iterator v1 = this.b.iterator();
        while(v1.hasNext()) {
            e.a(v1.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    public boolean b() {
        return 0;
    }

    private void c(h arg14) {
        int v4;
        Object v7;
        View v5;
        int v11 = 2;
        ViewGroup v6 = null;
        LayoutInflater v8 = LayoutInflater.from(this.e);
        g v0 = new g(arg14, v8, this.i);
        if(!this.d() && (this.v)) {
            v0.a(true);
        }
        else if(this.d()) {
            v0.a(m.b(arg14));
        }

        int v9 = e.a(((ListAdapter)v0), v6, this.e, this.f);
        am v10 = this.h();
        v10.a(((ListAdapter)v0));
        v10.g(v9);
        v10.e(this.o);
        if(this.b.size() > 0) {
            Object v0_1 = this.b.get(this.b.size() - 1);
            v5 = this.a(((a)v0_1), arg14);
            v7 = v0_1;
        }
        else {
            v5 = ((View)v6);
            v7 = v6;
        }

        if(v5 != null) {
            v10.c(false);
            v10.a(v6);
            int v3 = this.d(v9);
            int v0_2 = v3 == 1 ? 1 : 0;
            this.q = v3;
            if(Build$VERSION.SDK_INT >= 26) {
                v10.b(v5);
                v3 = 0;
                v4 = 0;
            }
            else {
                int[] v3_1 = new int[v11];
                this.p.getLocationOnScreen(v3_1);
                int[] v11_1 = new int[v11];
                v5.getLocationOnScreen(v11_1);
                v4 = v11_1[0] - v3_1[0];
                v3 = v11_1[1] - v3_1[1];
            }

            if((this.o & 5) == 5) {
                v0_2 = v0_2 != 0 ? v4 + v9 : v4 - v5.getWidth();
            }
            else if(v0_2 != 0) {
                v0_2 = v5.getWidth() + v4;
            }
            else {
                v0_2 = v4 - v9;
            }

            v10.c(v0_2);
            v10.b(true);
            v10.d(v3);
        }
        else {
            if(this.r) {
                v10.c(this.t);
            }

            if(this.s) {
                v10.d(this.u);
            }

            v10.a(this.g());
        }

        this.b.add(new a(v10, arg14, this.q));
        v10.a();
        ListView v3_2 = v10.e();
        v3_2.setOnKeyListener(((View$OnKeyListener)this));
        if(v7 == null && (this.w) && arg14.m() != null) {
            View v0_3 = v8.inflate(android.support.v7.a.a$g.abc_popup_menu_header_item_layout, ((ViewGroup)v3_2), false);
            View v1 = ((FrameLayout)v0_3).findViewById(0x1020016);
            ((FrameLayout)v0_3).setEnabled(false);
            ((TextView)v1).setText(arg14.m());
            v3_2.addHeaderView(v0_3, v6, false);
            v10.a();
        }
    }

    public void c() {
        int v1 = this.b.size();
        if(v1 > 0) {
            Object[] v0 = this.b.toArray(new a[v1]);
            --v1;
            while(v1 >= 0) {
                Object v2 = v0[v1];
                if(((a)v2).a.d()) {
                    ((a)v2).a.c();
                }

                --v1;
            }
        }
    }

    public void c(int arg2) {
        this.s = true;
        this.u = arg2;
    }

    public void c(boolean arg1) {
        this.w = arg1;
    }

    public boolean d() {
        boolean v0 = this.b.size() <= 0 || !this.b.get(0).a.d() ? false : true;
        return v0;
    }

    private int d(int arg7) {
        int v0_1;
        ListView v0 = this.b.get(this.b.size() - 1).a();
        int[] v3 = new int[2];
        v0.getLocationOnScreen(v3);
        Rect v4 = new Rect();
        this.c.getWindowVisibleDisplayFrame(v4);
        if(this.q == 1) {
            v0_1 = v0.getWidth() + v3[0] + arg7 > v4.right ? 0 : 1;
        }
        else if(v3[0] - arg7 < 0) {
            v0_1 = 1;
        }
        else {
            v0_1 = 0;
        }

        return v0_1;
    }

    private int d(h arg4) {
        int v0;
        int v1 = 0;
        int v2 = this.b.size();
        while(true) {
            if(v1 >= v2) {
                return -1;
            }
            else if(arg4 == this.b.get(v1).b) {
                v0 = v1;
            }
            else {
                ++v1;
                continue;
            }

            return v0;
        }

        return -1;
    }

    public ListView e() {
        ListView v0 = this.b.isEmpty() ? null : this.b.get(this.b.size() - 1).a();
        return v0;
    }

    protected boolean f() {
        return 0;
    }

    private am h() {
        am v0 = new am(this.e, null, this.g, this.h);
        v0.a(this.m);
        v0.a(((AdapterView$OnItemClickListener)this));
        v0.a(((PopupWindow$OnDismissListener)this));
        v0.b(this.p);
        v0.e(this.o);
        v0.a(true);
        v0.h(2);
        return v0;
    }

    private int i() {
        int v0 = 1;
        if(p.b(this.p) == 1) {
            v0 = 0;
        }

        return v0;
    }

    public void onDismiss() {
        Object v0;
        Object v1 = null;
        int v4 = this.b.size();
        int v2 = 0;
        while(true) {
            if(v2 < v4) {
                v0 = this.b.get(v2);
                if(((a)v0).a.d()) {
                    ++v2;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_11;
        }

        v0 = v1;
    label_11:
        if(v0 != null) {
            ((a)v0).b.a(false);
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

