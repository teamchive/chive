package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.h.p;
import android.support.v4.widget.i;
import android.support.v7.a.a$j;
import android.support.v7.view.menu.s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView$OnScrollListener;
import android.widget.AbsListView;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class aj implements s {
    class a implements Runnable {
        a(aj arg1) {
            this.a = arg1;
            super();
        }

        public void run() {
            this.a.m();
        }
    }

    class b extends DataSetObserver {
        b(aj arg1) {
            this.a = arg1;
            super();
        }

        public void onChanged() {
            if(this.a.d()) {
                this.a.a();
            }
        }

        public void onInvalidated() {
            this.a.c();
        }
    }

    class c implements AbsListView$OnScrollListener {
        c(aj arg1) {
            this.a = arg1;
            super();
        }

        public void onScroll(AbsListView arg1, int arg2, int arg3, int arg4) {
        }

        public void onScrollStateChanged(AbsListView arg3, int arg4) {
            if(arg4 == 1 && !this.a.n() && this.a.g.getContentView() != null) {
                this.a.f.removeCallbacks(this.a.e);
                this.a.e.run();
            }
        }
    }

    class d implements View$OnTouchListener {
        d(aj arg1) {
            this.a = arg1;
            super();
        }

        public boolean onTouch(View arg5, MotionEvent arg6) {
            int v0 = arg6.getAction();
            int v1 = ((int)arg6.getX());
            int v2 = ((int)arg6.getY());
            if(v0 == 0 && this.a.g != null && (this.a.g.isShowing()) && v1 >= 0 && v1 < this.a.g.getWidth() && v2 >= 0 && v2 < this.a.g.getHeight()) {
                this.a.f.postDelayed(this.a.e, 0xFA);
            }
            else if(v0 == 1) {
                this.a.f.removeCallbacks(this.a.e);
            }

            return 0;
        }
    }

    class e implements Runnable {
        e(aj arg1) {
            this.a = arg1;
            super();
        }

        public void run() {
            if(this.a.c != null && (p.m(this.a.c)) && this.a.c.getCount() > this.a.c.getChildCount() && this.a.c.getChildCount() <= this.a.d) {
                this.a.g.setInputMethodMode(2);
                this.a.a();
            }
        }
    }

    private Drawable A;
    private AdapterView$OnItemClickListener B;
    private AdapterView$OnItemSelectedListener C;
    private final d D;
    private final c E;
    private final a F;
    private Runnable G;
    private final Rect H;
    private Rect I;
    private boolean J;
    private static Method a;
    private static Method b;
    af c;
    int d;
    final e e;
    final Handler f;
    PopupWindow g;
    private static Method h;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private View w;
    private int x;
    private DataSetObserver y;
    private View z;

    static {
        try {
            aj.a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        }
        catch(NoSuchMethodException v0) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }

        try {
            aj.b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        }
        catch(NoSuchMethodException v0) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }

        try {
            aj.h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        }
        catch(NoSuchMethodException v0) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public aj(Context arg3) {
        this(arg3, null, android.support.v7.a.a$a.listPopupWindowStyle);
    }

    public aj(Context arg2, AttributeSet arg3, int arg4) {
        this(arg2, arg3, arg4, 0);
    }

    public aj(Context arg5, AttributeSet arg6, int arg7, int arg8) {
        super();
        this.k = -2;
        this.l = -2;
        this.o = 1002;
        this.q = true;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.d = 0x7FFFFFFF;
        this.x = 0;
        this.e = new e(this);
        this.D = new d(this);
        this.E = new c(this);
        this.F = new a(this);
        this.H = new Rect();
        this.i = arg5;
        this.f = new Handler(arg5.getMainLooper());
        TypedArray v0 = arg5.obtainStyledAttributes(arg6, j.ListPopupWindow, arg7, arg8);
        this.m = v0.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.n = v0.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if(this.n != 0) {
            this.p = true;
        }

        v0.recycle();
        this.g = new r(arg5, arg6, arg7, arg8);
        this.g.setInputMethodMode(1);
    }

    public void a() {
        PopupWindow v0_1;
        int v6_2;
        int v0;
        PopupWindow v6_1;
        int v4;
        boolean v3 = true;
        int v7 = -2;
        boolean v1 = false;
        int v5 = -1;
        int v2 = this.f();
        boolean v6 = this.n();
        i.a(this.g, this.o);
        if(this.g.isShowing()) {
            if(!p.m(this.i())) {
                return;
            }

            if(this.l == v5) {
                v4 = v5;
            }
            else if(this.l == v7) {
                v4 = this.i().getWidth();
            }
            else {
                v4 = this.l;
            }

            if(this.k == v5) {
                if(!v6) {
                    v2 = v5;
                }

                if(v6) {
                    v6_1 = this.g;
                    v0 = this.l == v5 ? v5 : 0;
                    v6_1.setWidth(v0);
                    this.g.setHeight(0);
                    v6_2 = v2;
                    goto label_31;
                }

                v6_1 = this.g;
                v0 = this.l == v5 ? v5 : 0;
                v6_1.setWidth(v0);
                this.g.setHeight(v5);
                v6_2 = v2;
            }
            else {
                if(this.k == v7) {
                    v6_2 = v2;
                    goto label_31;
                }

                v6_2 = this.k;
            }

        label_31:
            v0_1 = this.g;
            if(!this.v && !this.u) {
                v1 = true;
            }

            v0_1.setOutsideTouchable(v1);
            v0_1 = this.g;
            View v1_1 = this.i();
            v2 = this.m;
            int v3_1 = this.n;
            if(v4 < 0) {
                v4 = v5;
            }

            if(v6_2 >= 0) {
                v5 = v6_2;
            }

            v0_1.update(v1_1, v2, v3_1, v4, v5);
            return;
        }

        if(this.l == v5) {
            v0 = v5;
        }
        else if(this.l == v7) {
            v0 = this.i().getWidth();
        }
        else {
            v0 = this.l;
        }

        if(this.k == v5) {
            v2 = v5;
        }
        else if(this.k != v7) {
            v2 = this.k;
        }

        this.g.setWidth(v0);
        this.g.setHeight(v2);
        this.c(true);
        v0_1 = this.g;
        if((this.v) || (this.u)) {
            v3 = false;
        }

        v0_1.setOutsideTouchable(v3);
        this.g.setTouchInterceptor(this.D);
        if(this.s) {
            i.a(this.g, this.r);
        }

        if(aj.h != null) {
            try {
                aj.h.invoke(this.g, this.I);
            }
            catch(Exception v0_2) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", ((Throwable)v0_2));
            }
        }

        i.a(this.g, this.i(), this.m, this.n, this.t);
        this.c.setSelection(v5);
        if(!this.J || (this.c.isInTouchMode())) {
            this.m();
        }

        if(!this.J) {
            this.f.post(this.F);
        }
    }

    public void a(ListAdapter arg3) {
        if(this.y == null) {
            this.y = new b(this);
        }
        else if(this.j != null) {
            this.j.unregisterDataSetObserver(this.y);
        }

        this.j = arg3;
        if(this.j != null) {
            arg3.registerDataSetObserver(this.y);
        }

        if(this.c != null) {
            this.c.setAdapter(this.j);
        }
    }

    public void a(boolean arg2) {
        this.J = arg2;
        this.g.setFocusable(arg2);
    }

    public void a(AdapterView$OnItemClickListener arg1) {
        this.B = arg1;
    }

    public void a(PopupWindow$OnDismissListener arg2) {
        this.g.setOnDismissListener(arg2);
    }

    private int a(View arg6, int arg7, boolean arg8) {
        if(aj.b != null) {
            try {
                int v0_1 = aj.b.invoke(this.g, arg6, Integer.valueOf(arg7), Boolean.valueOf(arg8)).intValue();
                return v0_1;
            }
            catch(Exception v0) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }

        return this.g.getMaxAvailableHeight(arg6, arg7);
    }

    af a(Context arg2, boolean arg3) {
        return new af(arg2, arg3);
    }

    public void a(int arg1) {
        this.x = arg1;
    }

    public void a(Rect arg1) {
        this.I = arg1;
    }

    public void a(Drawable arg2) {
        this.g.setBackgroundDrawable(arg2);
    }

    public void b(View arg1) {
        this.z = arg1;
    }

    private void b() {
        if(this.w != null) {
            ViewParent v0 = this.w.getParent();
            if((v0 instanceof ViewGroup)) {
                ((ViewGroup)v0).removeView(this.w);
            }
        }
    }

    public void b(int arg2) {
        this.g.setAnimationStyle(arg2);
    }

    public void b(boolean arg2) {
        this.s = true;
        this.r = arg2;
    }

    public void c() {
        this.g.dismiss();
        this.b();
        this.g.setContentView(null);
        this.c = null;
        this.f.removeCallbacks(this.e);
    }

    private void c(boolean arg6) {
        if(aj.a != null) {
            try {
                aj.a.invoke(this.g, Boolean.valueOf(arg6));
            }
            catch(Exception v0) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void c(int arg1) {
        this.m = arg1;
    }

    public boolean d() {
        return this.g.isShowing();
    }

    public void d(int arg2) {
        this.n = arg2;
        this.p = true;
    }

    public ListView e() {
        return this.c;
    }

    public void e(int arg1) {
        this.t = arg1;
    }

    private int f() {
        int v1_1;
        int v7_1;
        int v6_1;
        LinearLayout v5_3;
        ViewGroup$LayoutParams v0_3;
        int v0_2;
        int v5_2;
        int v9 = 0x40000000;
        int v4 = 0x80000000;
        int v3 = -1;
        boolean v1 = true;
        if(this.c == null) {
            Context v5 = this.i;
            this.G = new Runnable() {
                public void run() {
                    View v0 = this.a.i();
                    if(v0 != null && v0.getWindowToken() != null) {
                        this.a.a();
                    }
                }
            };
            boolean v0 = !this.J ? true : false;
            this.c = this.a(v5, v0);
            if(this.A != null) {
                this.c.setSelector(this.A);
            }

            this.c.setAdapter(this.j);
            this.c.setOnItemClickListener(this.B);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new AdapterView$OnItemSelectedListener() {
                public void onItemSelected(AdapterView arg3, View arg4, int arg5, long arg6) {
                    if(arg5 != -1) {
                        af v0 = this.a.c;
                        if(v0 != null) {
                            v0.setListSelectionHidden(false);
                        }
                    }
                }

                public void onNothingSelected(AdapterView arg1) {
                }
            });
            this.c.setOnScrollListener(this.E);
            if(this.C != null) {
                this.c.setOnItemSelectedListener(this.C);
            }

            af v0_1 = this.c;
            View v7 = this.w;
            if(v7 != null) {
                LinearLayout v6 = new LinearLayout(v5);
                v6.setOrientation(1);
                LinearLayout$LayoutParams v5_1 = new LinearLayout$LayoutParams(v3, 0, 1f);
                switch(this.x) {
                    case 0: {
                        v6.addView(v7);
                        v6.addView(((View)v0_1), ((ViewGroup$LayoutParams)v5_1));
                        break;
                    }
                    case 1: {
                        v6.addView(((View)v0_1), ((ViewGroup$LayoutParams)v5_1));
                        v6.addView(v7);
                        break;
                    }
                    default: {
                        Log.e("ListPopupWindow", "Invalid hint position " + this.x);
                        break;
                    }
                }

                if(this.l >= 0) {
                    v5_2 = this.l;
                    v0_2 = v4;
                }
                else {
                    v0_2 = 0;
                    v5_2 = 0;
                }

                v7.measure(View$MeasureSpec.makeMeasureSpec(v5_2, v0_2), 0);
                v0_3 = v7.getLayoutParams();
                v0_2 = ((LinearLayout$LayoutParams)v0_3).bottomMargin + (v7.getMeasuredHeight() + ((LinearLayout$LayoutParams)v0_3).topMargin);
                v5_3 = v6;
            }
            else {
                af v5_4 = v0_1;
                v0_2 = 0;
            }

            this.g.setContentView(((View)v5_3));
            v6_1 = v0_2;
        }
        else {
            this.g.getContentView();
            View v5_5 = this.w;
            if(v5_5 != null) {
                v0_3 = v5_5.getLayoutParams();
                v6_1 = ((LinearLayout$LayoutParams)v0_3).bottomMargin + (v5_5.getMeasuredHeight() + ((LinearLayout$LayoutParams)v0_3).topMargin);
                goto label_80;
            }

            v6_1 = 0;
        }

    label_80:
        Drawable v0_4 = this.g.getBackground();
        if(v0_4 != null) {
            v0_4.getPadding(this.H);
            v0_2 = this.H.top + this.H.bottom;
            if(!this.p) {
                this.n = -this.H.top;
                v7_1 = v0_2;
            }
            else {
                v7_1 = v0_2;
            }
        }
        else {
            this.H.setEmpty();
            v7_1 = 0;
        }

        if(this.g.getInputMethodMode() != 2) {
            v1 = false;
        }

        v5_2 = this.a(this.i(), this.n, v1);
        if((this.u) || this.k == v3) {
            v0_2 = v5_2 + v7_1;
        }
        else {
            switch(this.l) {
                case -2: {
                    v1_1 = View$MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), v4);
                    break;
                }
                case -1: {
                    v1_1 = View$MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), v9);
                    break;
                }
                default: {
                    v1_1 = View$MeasureSpec.makeMeasureSpec(this.l, v9);
                    break;
                }
            }

            v0_2 = this.c.a(v1_1, 0, v3, v5_2 - v6_1, v3);
            if(v0_2 > 0) {
                v6_1 += this.c.getPaddingTop() + this.c.getPaddingBottom() + v7_1;
            }

            v0_2 += v6_1;
        }

        return v0_2;
    }

    public void f(int arg1) {
        this.l = arg1;
    }

    public void g(int arg3) {
        Drawable v0 = this.g.getBackground();
        if(v0 != null) {
            v0.getPadding(this.H);
            this.l = this.H.left + this.H.right + arg3;
        }
        else {
            this.f(arg3);
        }
    }

    public boolean g() {
        return this.J;
    }

    public Drawable h() {
        return this.g.getBackground();
    }

    public void h(int arg2) {
        this.g.setInputMethodMode(arg2);
    }

    public View i() {
        return this.z;
    }

    public void i(int arg3) {
        af v0 = this.c;
        if((this.d()) && v0 != null) {
            v0.setListSelectionHidden(false);
            v0.setSelection(arg3);
            if(v0.getChoiceMode() != 0) {
                v0.setItemChecked(arg3, true);
            }
        }
    }

    public int j() {
        return this.m;
    }

    public int k() {
        int v0 = !this.p ? 0 : this.n;
        return v0;
    }

    public int l() {
        return this.l;
    }

    public void m() {
        af v0 = this.c;
        if(v0 != null) {
            v0.setListSelectionHidden(true);
            v0.requestLayout();
        }
    }

    public boolean n() {
        boolean v0 = this.g.getInputMethodMode() == 2 ? true : false;
        return v0;
    }
}

