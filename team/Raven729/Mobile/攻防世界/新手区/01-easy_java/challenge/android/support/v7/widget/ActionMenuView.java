package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h$b;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewDebug$ExportedProperty;
import android.view.ViewGroup$LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends ai implements b, p {
    public interface a {
        boolean c();

        boolean d();
    }

    class android.support.v7.widget.ActionMenuView$b implements android.support.v7.view.menu.o$a {
        android.support.v7.widget.ActionMenuView$b() {
            super();
        }

        public void a(h arg1, boolean arg2) {
        }

        public boolean a(h arg2) {
            return 0;
        }
    }

    public class c extends android.support.v7.widget.ai$a {
        @ViewDebug$ExportedProperty public boolean a;
        @ViewDebug$ExportedProperty public int b;
        @ViewDebug$ExportedProperty public int c;
        @ViewDebug$ExportedProperty public boolean d;
        @ViewDebug$ExportedProperty public boolean e;
        boolean f;

        public c(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
        }

        public c(c arg2) {
            super(((ViewGroup$LayoutParams)arg2));
            this.a = arg2.a;
        }

        public c(ViewGroup$LayoutParams arg1) {
            super(arg1);
        }

        public c(int arg2, int arg3) {
            super(arg2, arg3);
            this.a = false;
        }
    }

    class d implements android.support.v7.view.menu.h$a {
        d(ActionMenuView arg1) {
            this.a = arg1;
            super();
        }

        public void a(h arg2) {
            if(this.a.a != null) {
                this.a.a.a(arg2);
            }
        }

        public boolean a(h arg2, MenuItem arg3) {
            boolean v0 = this.a.b == null || !this.a.b.a(arg3) ? false : true;
            return v0;
        }
    }

    public interface e {
        boolean a(MenuItem arg1);
    }

    android.support.v7.view.menu.h$a a;
    e b;
    private h c;
    private Context d;
    private int e;
    private boolean f;
    private android.support.v7.widget.d g;
    private android.support.v7.view.menu.o$a h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    public ActionMenuView(Context arg2) {
        this(arg2, null);
    }

    public ActionMenuView(Context arg4, AttributeSet arg5) {
        super(arg4, arg5);
        this.setBaselineAligned(false);
        float v0 = arg4.getResources().getDisplayMetrics().density;
        this.k = ((int)(56f * v0));
        this.l = ((int)(v0 * 4f));
        this.d = arg4;
        this.e = 0;
    }

    static int a(View arg8, int arg9, int arg10, int arg11, int arg12) {
        int v1_1;
        int v3 = 2;
        boolean v2 = false;
        ViewGroup$LayoutParams v0 = arg8.getLayoutParams();
        int v6 = View$MeasureSpec.makeMeasureSpec(View$MeasureSpec.getSize(arg11) - arg12, View$MeasureSpec.getMode(arg11));
        View v1 = (arg8 instanceof ActionMenuItemView) ? arg8 : null;
        int v5 = v1 == null || !((ActionMenuItemView)v1).b() ? 0 : 1;
        if(arg10 > 0) {
            if(v5 != 0 && arg10 < v3) {
                goto label_45;
            }

            arg8.measure(View$MeasureSpec.makeMeasureSpec(arg9 * arg10, 0x80000000), v6);
            int v7 = arg8.getMeasuredWidth();
            v1_1 = v7 / arg9;
            if(v7 % arg9 != 0) {
                ++v1_1;
            }

            if(v5 == 0) {
                goto label_30;
            }

            if(v1_1 >= v3) {
                goto label_30;
            }

            v1_1 = v3;
        }
        else {
        label_45:
            v1_1 = 0;
        }

    label_30:
        if(!((c)v0).a && v5 != 0) {
            v2 = true;
        }

        ((c)v0).d = v2;
        ((c)v0).b = v1_1;
        arg8.measure(View$MeasureSpec.makeMeasureSpec(v1_1 * arg9, 0x40000000), v6);
        return v1_1;
    }

    public c a(AttributeSet arg3) {
        return new c(this.getContext(), arg3);
    }

    protected c a(ViewGroup$LayoutParams arg3) {
        c v0;
        if(arg3 != null) {
            v0 = (arg3 instanceof c) ? new c(((c)arg3)) : new c(arg3);
            if(v0.h > 0) {
                return v0;
            }

            v0.h = 16;
        }
        else {
            v0 = this.b();
        }

        return v0;
    }

    public void a(h arg1) {
        this.c = arg1;
    }

    public void a(android.support.v7.view.menu.o$a arg1, android.support.v7.view.menu.h$a arg2) {
        this.h = arg1;
        this.a = arg2;
    }

    public boolean a() {
        return this.f;
    }

    protected boolean a(int arg5) {
        int v0_2;
        int v2 = 0;
        if(arg5 == 0) {
            boolean v0 = false;
        }
        else {
            View v0_1 = this.getChildAt(arg5 - 1);
            View v1 = this.getChildAt(arg5);
            if(arg5 < this.getChildCount() && ((v0_1 instanceof a))) {
                v2 = 0 | ((a)v0_1).d();
            }

            if(arg5 > 0 && ((v1 instanceof a))) {
                v0_2 = v1.c() | v2;
                goto label_3;
            }

            v0_2 = v2;
        }

    label_3:
        return ((boolean)v0_2);
    }

    public boolean a(j arg3) {
        return this.c.a(((MenuItem)arg3), 0);
    }

    protected c b() {
        c v0 = new c(-2, -2);
        v0.h = 16;
        return v0;
    }

    public android.support.v7.widget.ai$a b(AttributeSet arg2) {
        return this.a(arg2);
    }

    protected android.support.v7.widget.ai$a b(ViewGroup$LayoutParams arg2) {
        return this.a(arg2);
    }

    private void c(int arg35, int arg36) {
        float v6_3;
        ViewGroup$LayoutParams v6_2;
        int v14;
        int v13;
        int v12_1;
        long v6_1;
        int v8_1;
        View v8;
        int v23 = View$MeasureSpec.getMode(arg36);
        int v6 = View$MeasureSpec.getSize(arg35);
        int v17 = View$MeasureSpec.getSize(arg36);
        int v7 = this.getPaddingLeft() + this.getPaddingRight();
        int v19 = this.getPaddingTop() + this.getPaddingBottom();
        int v24 = ActionMenuView.getChildMeasureSpec(arg36, v19, -2);
        int v25 = v6 - v7;
        int v9 = v25 / this.k;
        v6 = v25 % this.k;
        if(v9 == 0) {
            this.setMeasuredDimension(v25, 0);
        }
        else {
            int v26 = this.k + v6 / v9;
            int v16 = 0;
            int v15 = 0;
            int v10 = 0;
            v7 = 0;
            int v11 = 0;
            long v12 = 0;
            int v27 = this.getChildCount();
            int v18 = 0;
            while(v18 < v27) {
                v8 = this.getChildAt(v18);
                if(v8.getVisibility() == 8) {
                    v8_1 = v7;
                    v6_1 = v12;
                    v12_1 = v16;
                    v13 = v9;
                    v9 = v15;
                }
                else {
                    boolean v20 = v8 instanceof ActionMenuItemView;
                    v14 = v7 + 1;
                    if(v20) {
                        v8.setPadding(this.l, 0, this.l, 0);
                    }

                    v6_2 = v8.getLayoutParams();
                    ((c)v6_2).f = false;
                    ((c)v6_2).c = 0;
                    ((c)v6_2).b = 0;
                    ((c)v6_2).d = false;
                    ((c)v6_2).leftMargin = 0;
                    ((c)v6_2).rightMargin = 0;
                    boolean v7_1 = !v20 || !v8.b() ? false : true;
                    ((c)v6_2).e = v7_1;
                    v7 = ((c)v6_2).a ? 1 : v9;
                    int v20_1 = ActionMenuView.a(v8, v26, v7, v24, v19);
                    v15 = Math.max(v15, v20_1);
                    v7 = ((c)v6_2).d ? v10 + 1 : v10;
                    v6 = ((c)v6_2).a ? 1 : v11;
                    v11 = v9 - v20_1;
                    v10 = Math.max(v16, v8.getMeasuredHeight());
                    if(v20_1 == 1) {
                        long v8_2 = (((long)(1 << v18))) | v12;
                        v12_1 = v10;
                        v13 = v11;
                        v10 = v7;
                        v11 = v6;
                        v6_1 = v8_2;
                        v9 = v15;
                        v8_1 = v14;
                        goto label_53;
                    }

                    v8_1 = v14;
                    v9 = v15;
                    long v32 = v12;
                    v12_1 = v10;
                    v13 = v11;
                    v11 = v6;
                    v10 = v7;
                    v6_1 = v32;
                }

            label_53:
                ++v18;
                v15 = v9;
                v16 = v12_1;
                v9 = v13;
                v12 = v6_1;
                v7 = v8_1;
            }

            v8_1 = v11 == 0 || v7 != 2 ? 0 : 1;
            v18 = 0;
            long v20_2 = v12;
            v19 = v9;
            while(true) {
                if(v10 <= 0) {
                    break;
                }
                else if(v19 > 0) {
                    v14 = 0x7FFFFFFF;
                    v12 = 0;
                    v9 = 0;
                    int v22 = 0;
                    while(v22 < v27) {
                        v6_2 = this.getChildAt(v22).getLayoutParams();
                        if(!((c)v6_2).d) {
                            v6 = v9;
                            v9 = v14;
                        }
                        else if(((c)v6_2).b < v14) {
                            v9 = ((c)v6_2).b;
                            v12 = ((long)(1 << v22));
                            v6 = 1;
                        }
                        else if(((c)v6_2).b == v14) {
                            v12 |= ((long)(1 << v22));
                            v6 = v9 + 1;
                            v9 = v14;
                        }
                        else {
                            v6 = v9;
                            v9 = v14;
                        }

                        ++v22;
                        v14 = v9;
                        v9 = v6;
                    }

                    v20_2 |= v12;
                    if(v9 > v19) {
                        v12 = v20_2;
                        goto label_191;
                    }

                    v22 = v14 + 1;
                    v14 = 0;
                    v9 = v19;
                    long v18_1 = v20_2;
                    while(v14 < v27) {
                        View v20_3 = this.getChildAt(v14);
                        v6_2 = v20_3.getLayoutParams();
                        if(((((long)(1 << v14))) & v12) != 0) {
                            if(v8_1 != 0 && (((c)v6_2).e) && v9 == 1) {
                                v20_3.setPadding(this.l + v26, 0, this.l, 0);
                            }

                            ++((c)v6_2).b;
                            ((c)v6_2).f = true;
                            v6 = v9 - 1;
                        }
                        else if(((c)v6_2).b == v22) {
                            v18_1 |= ((long)(1 << v14));
                            v6 = v9;
                        }
                        else {
                            v6 = v9;
                        }

                        ++v14;
                        v9 = v6;
                    }

                    v20_2 = v18_1;
                    v18 = 1;
                    v19 = v9;
                    continue;
                }
                else {
                    break;
                }
            }

            v12 = v20_2;
        label_191:
            v6 = v11 != 0 || v7 != 1 ? 0 : 1;
            if(v19 <= 0 || v12 == 0) {
            label_365:
                v8_1 = v18;
            }
            else {
                if(v19 >= v7 - 1 && v6 == 0 && v15 <= 1) {
                    goto label_365;
                }

                float v7_2 = ((float)Long.bitCount(v12));
                if(v6 == 0) {
                    if((1 & v12) != 0 && !this.getChildAt(0).getLayoutParams().e) {
                        v7_2 -= 0.5f;
                    }

                    if(((((long)(1 << v27 - 1))) & v12) == 0) {
                        goto label_398;
                    }

                    if(this.getChildAt(v27 - 1).getLayoutParams().e) {
                        goto label_398;
                    }

                    v6_3 = v7_2 - 0.5f;
                }
                else {
                label_398:
                    v6_3 = v7_2;
                }

                v7 = v6_3 > 0f ? ((int)((((float)(v19 * v26))) / v6_3)) : 0;
                v9 = 0;
                for(v8_1 = v18; v9 < v27; v8_1 = v6) {
                    if(((((long)(1 << v9))) & v12) == 0) {
                        v6 = v8_1;
                    }
                    else {
                        View v10_1 = this.getChildAt(v9);
                        v6_2 = v10_1.getLayoutParams();
                        if((v10_1 instanceof ActionMenuItemView)) {
                            ((c)v6_2).c = v7;
                            ((c)v6_2).f = true;
                            if(v9 == 0 && !((c)v6_2).e) {
                                ((c)v6_2).leftMargin = -v7 / 2;
                            }

                            v6 = 1;
                        }
                        else {
                            if(((c)v6_2).a) {
                                ((c)v6_2).c = v7;
                                ((c)v6_2).f = true;
                                ((c)v6_2).rightMargin = -v7 / 2;
                                v6 = 1;
                                goto label_253;
                            }

                            if(v9 != 0) {
                                ((c)v6_2).leftMargin = v7 / 2;
                            }

                            if(v9 != v27 - 1) {
                                ((c)v6_2).rightMargin = v7 / 2;
                            }

                            v6 = v8_1;
                        }
                    }

                label_253:
                    ++v9;
                }
            }

            if(v8_1 != 0) {
                for(v7 = 0; v7 < v27; ++v7) {
                    v8 = this.getChildAt(v7);
                    v6_2 = v8.getLayoutParams();
                    if(((c)v6_2).f) {
                        v8.measure(View$MeasureSpec.makeMeasureSpec(((c)v6_2).c + ((c)v6_2).b * v26, 0x40000000), v24);
                    }
                }
            }

            if(v23 == 0x40000000) {
                v16 = v17;
            }

            this.setMeasuredDimension(v25, v16);
        }
    }

    public c c() {
        c v0 = this.b();
        v0.a = true;
        return v0;
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg2) {
        boolean v0 = arg2 == null || !(arg2 instanceof c) ? false : true;
        return v0;
    }

    public h d() {
        return this.c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent arg2) {
        return 0;
    }

    public boolean e() {
        boolean v0 = this.g == null || !this.g.d() ? false : true;
        return v0;
    }

    public boolean f() {
        boolean v0 = this.g == null || !this.g.e() ? false : true;
        return v0;
    }

    public boolean g() {
        boolean v0 = this.g == null || !this.g.h() ? false : true;
        return v0;
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.b();
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg2) {
        return this.a(arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg2) {
        return this.a(arg2);
    }

    public Menu getMenu() {
        android.support.v7.widget.ActionMenuView$b v0_2;
        if(this.c == null) {
            Context v0 = this.getContext();
            this.c = new h(v0);
            this.c.a(new d(this));
            this.g = new android.support.v7.widget.d(v0);
            this.g.c(true);
            android.support.v7.widget.d v1 = this.g;
            if(this.h != null) {
                android.support.v7.view.menu.o$a v0_1 = this.h;
            }
            else {
                v0_2 = new android.support.v7.widget.ActionMenuView$b();
            }

            v1.a(((android.support.v7.view.menu.o$a)v0_2));
            this.c.a(this.g, this.d);
            this.g.a(this);
        }

        return this.c;
    }

    public Drawable getOverflowIcon() {
        this.getMenu();
        return this.g.c();
    }

    public int getPopupTheme() {
        return this.e;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean h() {
        boolean v0 = this.g == null || !this.g.i() ? false : true;
        return v0;
    }

    public void i() {
        if(this.g != null) {
            this.g.f();
        }
    }

    protected android.support.v7.widget.ai$a j() {
        return this.b();
    }

    public void onConfigurationChanged(Configuration arg3) {
        super.onConfigurationChanged(arg3);
        if(this.g != null) {
            this.g.b(false);
            if(this.g.h()) {
                this.g.e();
                this.g.d();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i();
    }

    protected void onLayout(boolean arg16, int arg17, int arg18, int arg19, int arg20) {
        View v4_1;
        ViewGroup$LayoutParams v0_1;
        int v2;
        int v0;
        if(!this.i) {
            super.onLayout(arg16, arg17, arg18, arg19, arg20);
        }
        else {
            int v7 = this.getChildCount();
            int v8 = (arg20 - arg18) / 2;
            int v9 = this.getDividerWidth();
            int v5 = 0;
            int v4 = 0;
            int v3 = arg19 - arg17 - this.getPaddingRight() - this.getPaddingLeft();
            int v1 = 0;
            boolean v10 = bc.a(((View)this));
            int v6 = 0;
            while(v6 < v7) {
                View v11 = this.getChildAt(v6);
                if(v11.getVisibility() == 8) {
                    v0 = v1;
                    v2 = v4;
                    v1 = v3;
                    v3 = v5;
                }
                else {
                    v0_1 = v11.getLayoutParams();
                    if(((c)v0_1).a) {
                        v1 = v11.getMeasuredWidth();
                        if(this.a(v6)) {
                            v1 += v9;
                        }

                        int v12 = v11.getMeasuredHeight();
                        if(v10) {
                            v0 = ((c)v0_1).leftMargin + this.getPaddingLeft();
                            v2 = v0 + v1;
                        }
                        else {
                            v2 = this.getWidth() - this.getPaddingRight() - ((c)v0_1).rightMargin;
                            v0 = v2 - v1;
                        }

                        int v13 = v8 - v12 / 2;
                        v11.layout(v0, v13, v2, v12 + v13);
                        v1 = v3 - v1;
                        v0 = 1;
                        v2 = v4;
                        v3 = v5;
                    }
                    else {
                        v2 = v11.getMeasuredWidth() + ((c)v0_1).leftMargin + ((c)v0_1).rightMargin;
                        v0 = v5 + v2;
                        v2 = v3 - v2;
                        if(this.a(v6)) {
                            v0 += v9;
                        }

                        int v14 = v1;
                        v1 = v2;
                        v2 = v4 + 1;
                        v3 = v0;
                        v0 = v14;
                    }
                }

                ++v6;
                v5 = v3;
                v3 = v1;
                v4 = v2;
                v1 = v0;
            }

            if(v7 == 1 && v1 == 0) {
                View v0_2 = this.getChildAt(0);
                v1 = v0_2.getMeasuredWidth();
                v2 = v0_2.getMeasuredHeight();
                v3 = (arg19 - arg17) / 2 - v1 / 2;
                v4 = v8 - v2 / 2;
                v0_2.layout(v3, v4, v1 + v3, v2 + v4);
                return;
            }

            v0 = v1 != 0 ? 0 : 1;
            v0 = v4 - v0;
            v0 = v0 > 0 ? v3 / v0 : 0;
            v3 = Math.max(0, v0);
            if(v10) {
                v1 = this.getWidth() - this.getPaddingRight();
                v2 = 0;
                goto label_111;
            }

            v1 = this.getPaddingLeft();
            v2 = 0;
            while(true) {
                if(v2 >= v7) {
                    return;
                }

                v4_1 = this.getChildAt(v2);
                v0_1 = v4_1.getLayoutParams();
                if(v4_1.getVisibility() == 8) {
                    v0 = v1;
                }
                else if(((c)v0_1).a) {
                    v0 = v1;
                }
                else {
                    v1 += ((c)v0_1).leftMargin;
                    v5 = v4_1.getMeasuredWidth();
                    v6 = v4_1.getMeasuredHeight();
                    v9 = v8 - v6 / 2;
                    v4_1.layout(v1, v9, v1 + v5, v6 + v9);
                    v0 = ((c)v0_1).rightMargin + v5 + v3 + v1;
                }

                ++v2;
                v1 = v0;
            }

        label_111:
            while(v2 < v7) {
                v4_1 = this.getChildAt(v2);
                v0_1 = v4_1.getLayoutParams();
                if(v4_1.getVisibility() == 8) {
                    v0 = v1;
                }
                else if(((c)v0_1).a) {
                    v0 = v1;
                }
                else {
                    v1 -= ((c)v0_1).rightMargin;
                    v5 = v4_1.getMeasuredWidth();
                    v6 = v4_1.getMeasuredHeight();
                    v9 = v8 - v6 / 2;
                    v4_1.layout(v1 - v5, v9, v1, v6 + v9);
                    v0 = v1 - (((c)v0_1).leftMargin + v5 + v3);
                }

                ++v2;
                v1 = v0;
            }
        }
    }

    protected void onMeasure(int arg6, int arg7) {
        boolean v3 = this.i;
        boolean v0 = View$MeasureSpec.getMode(arg6) == 0x40000000 ? true : false;
        this.i = v0;
        if(v3 != this.i) {
            this.j = 0;
        }

        int v0_1 = View$MeasureSpec.getSize(arg6);
        if((this.i) && this.c != null && v0_1 != this.j) {
            this.j = v0_1;
            this.c.b(true);
        }

        int v3_1 = this.getChildCount();
        if(!this.i || v3_1 <= 0) {
            int v1;
            for(v1 = 0; v1 < v3_1; ++v1) {
                ViewGroup$LayoutParams v0_2 = this.getChildAt(v1).getLayoutParams();
                ((c)v0_2).rightMargin = 0;
                ((c)v0_2).leftMargin = 0;
            }

            super.onMeasure(arg6, arg7);
        }
        else {
            this.c(arg6, arg7);
        }
    }

    public void setExpandedActionViewsExclusive(boolean arg2) {
        this.g.d(arg2);
    }

    public void setOnMenuItemClickListener(e arg1) {
        this.b = arg1;
    }

    public void setOverflowIcon(Drawable arg2) {
        this.getMenu();
        this.g.a(arg2);
    }

    public void setOverflowReserved(boolean arg1) {
        this.f = arg1;
    }

    public void setPopupTheme(int arg3) {
        if(this.e != arg3) {
            this.e = arg3;
            this.d = arg3 == 0 ? this.getContext() : new ContextThemeWrapper(this.getContext(), arg3);
        }
    }

    public void setPresenter(android.support.v7.widget.d arg2) {
        this.g = arg2;
        this.g.a(this);
    }
}

