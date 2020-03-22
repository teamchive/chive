package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.v4.h.k;
import android.support.v4.h.m;
import android.support.v4.h.p;
import android.support.v7.a.a$f;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window$Callback;
import android.widget.OverScroller;

public class ActionBarOverlayLayout extends ViewGroup implements k, ac {
    class android.support.v7.widget.ActionBarOverlayLayout$1 extends AnimatorListenerAdapter {
        android.support.v7.widget.ActionBarOverlayLayout$1(ActionBarOverlayLayout arg1) {
            this.a = arg1;
            super();
        }

        public void onAnimationCancel(Animator arg3) {
            this.a.c = null;
            this.a.b = false;
        }

        public void onAnimationEnd(Animator arg3) {
            this.a.c = null;
            this.a.b = false;
        }
    }

    class android.support.v7.widget.ActionBarOverlayLayout$2 implements Runnable {
        android.support.v7.widget.ActionBarOverlayLayout$2(ActionBarOverlayLayout arg1) {
            this.a = arg1;
            super();
        }

        public void run() {
            this.a.d();
            this.a.c = this.a.a.animate().translationY(0f).setListener(this.a.d);
        }
    }

    class android.support.v7.widget.ActionBarOverlayLayout$3 implements Runnable {
        android.support.v7.widget.ActionBarOverlayLayout$3(ActionBarOverlayLayout arg1) {
            this.a = arg1;
            super();
        }

        public void run() {
            this.a.d();
            this.a.c = this.a.a.animate().translationY(((float)(-this.a.a.getHeight()))).setListener(this.a.d);
        }
    }

    public interface a {
        void a(int arg1);

        void g(boolean arg1);

        void j();

        void k();

        void l();

        void m();
    }

    public class b extends ViewGroup$MarginLayoutParams {
        public b(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
        }

        public b(int arg1, int arg2) {
            super(arg1, arg2);
        }

        public b(ViewGroup$LayoutParams arg1) {
            super(arg1);
        }
    }

    private final Runnable A;
    private final Runnable B;
    private final m C;
    ActionBarContainer a;
    boolean b;
    ViewPropertyAnimator c;
    final AnimatorListenerAdapter d;
    static final int[] e;
    private int f;
    private int g;
    private ContentFrameLayout h;
    private ad i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private final Rect v;
    private final Rect w;
    private a x;
    private final int y;
    private OverScroller z;

    static {
        ActionBarOverlayLayout.e = new int[]{android.support.v7.a.a$a.actionBarSize, 0x1010059};
    }

    public ActionBarOverlayLayout(Context arg2) {
        this(arg2, null);
    }

    public ActionBarOverlayLayout(Context arg2, AttributeSet arg3) {
        super(arg2, arg3);
        this.g = 0;
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        this.w = new Rect();
        this.y = 600;
        this.d = new android.support.v7.widget.ActionBarOverlayLayout$1(this);
        this.A = new android.support.v7.widget.ActionBarOverlayLayout$2(this);
        this.B = new android.support.v7.widget.ActionBarOverlayLayout$3(this);
        this.a(arg2);
        this.C = new m(((ViewGroup)this));
    }

    public boolean a() {
        return this.l;
    }

    private void a(Context arg5) {
        boolean v1 = true;
        TypedArray v3 = this.getContext().getTheme().obtainStyledAttributes(ActionBarOverlayLayout.e);
        this.f = v3.getDimensionPixelSize(0, 0);
        this.j = v3.getDrawable(1);
        boolean v0 = this.j == null ? true : false;
        this.setWillNotDraw(v0);
        v3.recycle();
        if(arg5.getApplicationInfo().targetSdkVersion >= 19) {
            v1 = false;
        }

        this.k = v1;
        this.z = new OverScroller(arg5);
    }

    private ad a(View arg4) {
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
        throw new IllegalStateException("Can\'t make a decor toolbar out of " + arg4.getClass().getSimpleName());
    }

    private boolean a(float arg10, float arg11) {
        boolean v1 = false;
        this.z.fling(0, 0, 0, ((int)arg11), 0, 0, 0x80000000, 0x7FFFFFFF);
        if(this.z.getFinalY() > this.a.getHeight()) {
            v1 = true;
        }

        return v1;
    }

    private boolean a(View arg6, Rect arg7, boolean arg8, boolean arg9, boolean arg10, boolean arg11) {
        boolean v0_1;
        boolean v2 = false;
        ViewGroup$LayoutParams v0 = arg6.getLayoutParams();
        if((arg8) && ((b)v0).leftMargin != arg7.left) {
            ((b)v0).leftMargin = arg7.left;
            v2 = true;
        }

        if((arg9) && ((b)v0).topMargin != arg7.top) {
            ((b)v0).topMargin = arg7.top;
            v2 = true;
        }

        if((arg11) && ((b)v0).rightMargin != arg7.right) {
            ((b)v0).rightMargin = arg7.right;
            v2 = true;
        }

        if(!arg10 || ((b)v0).bottomMargin == arg7.bottom) {
            v0_1 = v2;
        }
        else {
            ((b)v0).bottomMargin = arg7.bottom;
            v0_1 = true;
        }

        return v0_1;
    }

    public b a(AttributeSet arg3) {
        return new b(this.getContext(), arg3);
    }

    public void a(int arg2) {
        this.c();
        switch(arg2) {
            case 2: {
                this.i.f();
                break;
            }
            case 5: {
                this.i.g();
                break;
            }
            case 109: {
                this.setOverlayMode(true);
                break;
            }
        }
    }

    public void a(Menu arg2, android.support.v7.view.menu.o$a arg3) {
        this.c();
        this.i.a(arg2, arg3);
    }

    protected b b() {
        return new b(-1, -1);
    }

    void c() {
        if(this.h == null) {
            this.h = this.findViewById(f.action_bar_activity_content);
            this.a = this.findViewById(f.action_bar_container);
            this.i = this.a(this.findViewById(f.action_bar));
        }
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg2) {
        return arg2 instanceof b;
    }

    void d() {
        this.removeCallbacks(this.A);
        this.removeCallbacks(this.B);
        if(this.c != null) {
            this.c.cancel();
        }
    }

    public void draw(Canvas arg6) {
        super.draw(arg6);
        if(this.j != null && !this.k) {
            int v0 = this.a.getVisibility() == 0 ? ((int)((((float)this.a.getBottom())) + this.a.getTranslationY() + 0.5f)) : 0;
            this.j.setBounds(0, v0, this.getWidth(), this.j.getIntrinsicHeight() + v0);
            this.j.draw(arg6);
        }
    }

    public boolean e() {
        this.c();
        return this.i.h();
    }

    public boolean f() {
        this.c();
        return this.i.i();
    }

    protected boolean fitSystemWindows(Rect arg8) {
        this.c();
        p.f(((View)this));
        boolean v0 = this.a(this.a, arg8, true, true, false, true);
        this.t.set(arg8);
        bc.a(((View)this), this.t, this.q);
        if(!this.u.equals(this.t)) {
            this.u.set(this.t);
            v0 = true;
        }

        if(!this.r.equals(this.q)) {
            this.r.set(this.q);
            v0 = true;
        }

        if(v0) {
            this.requestLayout();
        }

        return 1;
    }

    public boolean g() {
        this.c();
        return this.i.j();
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.b();
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg2) {
        return this.a(arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg2) {
        return new b(arg2);
    }

    public int getActionBarHideOffset() {
        int v0 = this.a != null ? -(((int)this.a.getTranslationY())) : 0;
        return v0;
    }

    public int getNestedScrollAxes() {
        return this.C.a();
    }

    public CharSequence getTitle() {
        this.c();
        return this.i.e();
    }

    public boolean h() {
        this.c();
        return this.i.k();
    }

    public boolean i() {
        this.c();
        return this.i.l();
    }

    public void j() {
        this.c();
        this.i.m();
    }

    public void k() {
        this.c();
        this.i.n();
    }

    private void l() {
        this.d();
        this.postDelayed(this.A, 600);
    }

    private void m() {
        this.d();
        this.postDelayed(this.B, 600);
    }

    private void n() {
        this.d();
        this.A.run();
    }

    private void o() {
        this.d();
        this.B.run();
    }

    protected void onConfigurationChanged(Configuration arg2) {
        super.onConfigurationChanged(arg2);
        this.a(this.getContext());
        p.g(((View)this));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d();
    }

    protected void onLayout(boolean arg10, int arg11, int arg12, int arg13, int arg14) {
        int v2 = this.getChildCount();
        int v3 = this.getPaddingLeft();
        this.getPaddingRight();
        int v4 = this.getPaddingTop();
        this.getPaddingBottom();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            View v5 = this.getChildAt(v1);
            if(v5.getVisibility() != 8) {
                ViewGroup$LayoutParams v0 = v5.getLayoutParams();
                int v6 = v5.getMeasuredWidth();
                int v7 = v5.getMeasuredHeight();
                int v8 = ((b)v0).leftMargin + v3;
                int v0_1 = ((b)v0).topMargin + v4;
                v5.layout(v8, v0_1, v6 + v8, v7 + v0_1);
            }
        }
    }

    protected void onMeasure(int arg12, int arg13) {
        int v0_1;
        this.c();
        this.measureChildWithMargins(this.a, arg12, 0, arg13, 0);
        ViewGroup$LayoutParams v0 = this.a.getLayoutParams();
        int v8 = Math.max(0, this.a.getMeasuredWidth() + ((b)v0).leftMargin + ((b)v0).rightMargin);
        int v7 = Math.max(0, ((b)v0).bottomMargin + (this.a.getMeasuredHeight() + ((b)v0).topMargin));
        int v9 = View.combineMeasuredStates(0, this.a.getMeasuredState());
        int v1 = (p.f(((View)this)) & 0x100) != 0 ? 1 : 0;
        if(v1 != 0) {
            v0_1 = this.f;
            if((this.m) && this.a.getTabContainer() != null) {
                v0_1 += this.f;
            }
        }
        else if(this.a.getVisibility() != 8) {
            v0_1 = this.a.getMeasuredHeight();
        }
        else {
            v0_1 = 0;
        }

        this.s.set(this.q);
        this.v.set(this.t);
        if((this.l) || v1 != 0) {
            this.v.top = v0_1 + this.v.top;
            this.v.bottom = this.v.bottom;
        }
        else {
            this.s.top = v0_1 + this.s.top;
            this.s.bottom = this.s.bottom;
        }

        this.a(this.h, this.s, true, true, true, true);
        if(!this.w.equals(this.v)) {
            this.w.set(this.v);
            this.h.a(this.v);
        }

        this.measureChildWithMargins(this.h, arg12, 0, arg13, 0);
        v0 = this.h.getLayoutParams();
        v1 = Math.max(v8, this.h.getMeasuredWidth() + ((b)v0).leftMargin + ((b)v0).rightMargin);
        v0_1 = Math.max(v7, ((b)v0).bottomMargin + (this.h.getMeasuredHeight() + ((b)v0).topMargin));
        int v2 = View.combineMeasuredStates(v9, this.h.getMeasuredState());
        this.setMeasuredDimension(View.resolveSizeAndState(Math.max(v1 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), arg12, v2), View.resolveSizeAndState(Math.max(v0_1 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), arg13, v2 << 16));
    }

    public boolean onNestedFling(View arg3, float arg4, float arg5, boolean arg6) {
        boolean v0 = true;
        if(!this.n || !arg6) {
            v0 = false;
        }
        else {
            if(this.a(arg4, arg5)) {
                this.o();
            }
            else {
                this.n();
            }

            this.b = true;
        }

        return v0;
    }

    public boolean onNestedPreFling(View arg2, float arg3, float arg4) {
        return 0;
    }

    public void onNestedPreScroll(View arg1, int arg2, int arg3, int[] arg4) {
    }

    public void onNestedScroll(View arg2, int arg3, int arg4, int arg5, int arg6) {
        this.o += arg4;
        this.setActionBarHideOffset(this.o);
    }

    public void onNestedScrollAccepted(View arg2, View arg3, int arg4) {
        this.C.a(arg2, arg3, arg4);
        this.o = this.getActionBarHideOffset();
        this.d();
        if(this.x != null) {
            this.x.l();
        }
    }

    public boolean onStartNestedScroll(View arg2, View arg3, int arg4) {
        boolean v0 = (arg4 & 2) == 0 || this.a.getVisibility() != 0 ? false : this.n;
        return v0;
    }

    public void onStopNestedScroll(View arg3) {
        if((this.n) && !this.b) {
            if(this.o <= this.a.getHeight()) {
                this.l();
            }
            else {
                this.m();
            }
        }

        if(this.x != null) {
            this.x.m();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int arg7) {
        boolean v1 = true;
        if(Build$VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(arg7);
        }

        this.c();
        int v4 = this.p ^ arg7;
        this.p = arg7;
        int v3 = (arg7 & 4) == 0 ? 1 : 0;
        int v0 = (arg7 & 0x100) != 0 ? 1 : 0;
        if(this.x != null) {
            a v5 = this.x;
            if(v0 != 0) {
                v1 = false;
            }

            v5.g(v1);
            if(v3 == 0 && v0 != 0) {
                this.x.k();
                goto label_25;
            }

            this.x.j();
        }

    label_25:
        if((v4 & 0x100) != 0 && this.x != null) {
            p.g(((View)this));
        }
    }

    protected void onWindowVisibilityChanged(int arg2) {
        super.onWindowVisibilityChanged(arg2);
        this.g = arg2;
        if(this.x != null) {
            this.x.a(arg2);
        }
    }

    public void setActionBarHideOffset(int arg3) {
        this.d();
        this.a.setTranslationY(((float)(-Math.max(0, Math.min(arg3, this.a.getHeight())))));
    }

    public void setActionBarVisibilityCallback(a arg3) {
        this.x = arg3;
        if(this.getWindowToken() != null) {
            this.x.a(this.g);
            if(this.p != 0) {
                this.onWindowSystemUiVisibilityChanged(this.p);
                p.g(((View)this));
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean arg1) {
        this.m = arg1;
    }

    public void setHideOnContentScrollEnabled(boolean arg2) {
        if(arg2 != this.n) {
            this.n = arg2;
            if(!arg2) {
                this.d();
                this.setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int arg2) {
        this.c();
        this.i.a(arg2);
    }

    public void setIcon(Drawable arg2) {
        this.c();
        this.i.a(arg2);
    }

    public void setLogo(int arg2) {
        this.c();
        this.i.b(arg2);
    }

    public void setOverlayMode(boolean arg3) {
        this.l = arg3;
        boolean v0 = !arg3 || this.getContext().getApplicationInfo().targetSdkVersion >= 19 ? false : true;
        this.k = v0;
    }

    public void setShowingForActionMode(boolean arg1) {
    }

    public void setUiOptions(int arg1) {
    }

    public void setWindowCallback(Window$Callback arg2) {
        this.c();
        this.i.a(arg2);
    }

    public void setWindowTitle(CharSequence arg2) {
        this.c();
        this.i.a(arg2);
    }

    public boolean shouldDelayChildPressedState() {
        return 0;
    }
}

