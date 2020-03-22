package android.support.v7.widget;

import android.content.Context;
import android.support.v4.h.p;
import android.support.v4.h.r;
import android.support.v7.a.a$f;
import android.support.v7.a.a$g;
import android.support.v7.a.a$j;
import android.support.v7.view.b;
import android.support.v7.view.menu.h;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends a {
    private CharSequence g;
    private CharSequence h;
    private View i;
    private View j;
    private LinearLayout k;
    private TextView l;
    private TextView m;
    private int n;
    private int o;
    private boolean p;
    private int q;

    public ActionBarContextView(Context arg2) {
        this(arg2, null);
    }

    public ActionBarContextView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, android.support.v7.a.a$a.actionModeStyle);
    }

    public ActionBarContextView(Context arg4, AttributeSet arg5, int arg6) {
        super(arg4, arg5, arg6);
        aw v0 = aw.a(arg4, arg5, j.ActionMode, arg6, 0);
        p.a(((View)this), v0.a(j.ActionMode_background));
        this.n = v0.g(j.ActionMode_titleTextStyle, 0);
        this.o = v0.g(j.ActionMode_subtitleTextStyle, 0);
        this.e = v0.f(j.ActionMode_height, 0);
        this.q = v0.g(j.ActionMode_closeItemLayout, g.abc_action_mode_close_item_material);
        v0.a();
    }

    public void a(b arg5) {
        if(this.i == null) {
            this.i = LayoutInflater.from(this.getContext()).inflate(this.q, ((ViewGroup)this), false);
            this.addView(this.i);
        }
        else if(this.i.getParent() == null) {
            this.addView(this.i);
        }

        this.i.findViewById(f.action_mode_close_button).setOnClickListener(new View$OnClickListener(arg5) {
            public void onClick(View arg2) {
                this.a.c();
            }
        });
        Menu v0 = arg5.b();
        if(this.d != null) {
            this.d.f();
        }

        this.d = new d(this.getContext());
        this.d.c(true);
        ViewGroup$LayoutParams v1 = new ViewGroup$LayoutParams(-2, -1);
        ((h)v0).a(this.d, this.b);
        this.c = this.d.a(((ViewGroup)this));
        p.a(this.c, null);
        this.addView(this.c, v1);
    }

    public r a(int arg3, long arg4) {
        return super.a(arg3, arg4);
    }

    public boolean a() {
        boolean v0 = this.d != null ? this.d.d() : false;
        return v0;
    }

    public void b() {
        if(this.i == null) {
            this.c();
        }
    }

    public void c() {
        this.removeAllViews();
        this.j = null;
        this.c = null;
    }

    public boolean d() {
        return this.p;
    }

    private void e() {
        int v4 = 8;
        int v1 = 1;
        if(this.k == null) {
            LayoutInflater.from(this.getContext()).inflate(g.abc_action_bar_title_item, ((ViewGroup)this));
            this.k = this.getChildAt(this.getChildCount() - 1);
            this.l = this.k.findViewById(f.action_bar_title);
            this.m = this.k.findViewById(f.action_bar_subtitle);
            if(this.n != 0) {
                this.l.setTextAppearance(this.getContext(), this.n);
            }

            if(this.o == 0) {
                goto label_33;
            }

            this.m.setTextAppearance(this.getContext(), this.o);
        }

    label_33:
        this.l.setText(this.g);
        this.m.setText(this.h);
        int v0 = !TextUtils.isEmpty(this.g) ? 1 : 0;
        if(TextUtils.isEmpty(this.h)) {
            v1 = 0;
        }

        TextView v5 = this.m;
        int v3 = v1 != 0 ? 0 : v4;
        v5.setVisibility(v3);
        LinearLayout v3_1 = this.k;
        if(v0 != 0 || v1 != 0) {
            v4 = 0;
        }

        v3_1.setVisibility(v4);
        if(this.k.getParent() == null) {
            this.addView(this.k);
        }
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup$MarginLayoutParams(-1, -2);
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg3) {
        return new ViewGroup$MarginLayoutParams(this.getContext(), arg3);
    }

    public int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.h;
    }

    public CharSequence getTitle() {
        return this.g;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(this.d != null) {
            this.d.e();
            this.d.g();
        }
    }

    public boolean onHoverEvent(MotionEvent arg2) {
        return super.onHoverEvent(arg2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent arg3) {
        if(arg3.getEventType() == 0x20) {
            arg3.setSource(((View)this));
            arg3.setClassName(this.getClass().getName());
            arg3.setPackageName(this.getContext().getPackageName());
            arg3.setContentDescription(this.g);
        }
        else {
            super.onInitializeAccessibilityEvent(arg3);
        }
    }

    protected void onLayout(boolean arg9, int arg10, int arg11, int arg12, int arg13) {
        int v2;
        int v7 = 8;
        boolean v5 = bc.a(((View)this));
        int v1 = v5 ? arg12 - arg10 - this.getPaddingRight() : this.getPaddingLeft();
        int v3 = this.getPaddingTop();
        int v4 = arg13 - arg11 - this.getPaddingTop() - this.getPaddingBottom();
        if(this.i == null || this.i.getVisibility() == v7) {
            v2 = v1;
        }
        else {
            ViewGroup$LayoutParams v0 = this.i.getLayoutParams();
            v2 = v5 ? ((ViewGroup$MarginLayoutParams)v0).rightMargin : ((ViewGroup$MarginLayoutParams)v0).leftMargin;
            int v6 = v5 ? ((ViewGroup$MarginLayoutParams)v0).leftMargin : ((ViewGroup$MarginLayoutParams)v0).rightMargin;
            v2 = ActionBarContextView.a(v1, v2, v5);
            v2 = ActionBarContextView.a(this.a(this.i, v2, v3, v4, v5) + v2, v6, v5);
        }

        if(this.k != null && this.j == null && this.k.getVisibility() != v7) {
            v2 += this.a(this.k, v2, v3, v4, v5);
        }

        if(this.j != null) {
            this.a(this.j, v2, v3, v4, v5);
        }

        v2 = v5 ? this.getPaddingLeft() : arg12 - arg10 - this.getPaddingRight();
        if(this.c != null) {
            ActionMenuView v1_1 = this.c;
            v5 = !v5 ? true : false;
            this.a(((View)v1_1), v2, v3, v4, v5);
        }
    }

    protected void onMeasure(int arg13, int arg14) {
        int v9;
        int v11 = -2;
        int v4 = 0x40000000;
        int v5 = 0x80000000;
        int v3 = 0;
        if(View$MeasureSpec.getMode(arg13) != v4) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        }

        if(View$MeasureSpec.getMode(arg14) == 0) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        }

        int v7 = View$MeasureSpec.getSize(arg13);
        int v1 = this.e > 0 ? this.e : View$MeasureSpec.getSize(arg14);
        int v8 = this.getPaddingTop() + this.getPaddingBottom();
        int v0 = v7 - this.getPaddingLeft() - this.getPaddingRight();
        int v6 = v1 - v8;
        int v2 = View$MeasureSpec.makeMeasureSpec(v6, v5);
        if(this.i != null) {
            v9 = this.a(this.i, v0, v2, 0);
            ViewGroup$LayoutParams v0_1 = this.i.getLayoutParams();
            v0 = v9 - (((ViewGroup$MarginLayoutParams)v0_1).rightMargin + ((ViewGroup$MarginLayoutParams)v0_1).leftMargin);
        }

        if(this.c != null && this.c.getParent() == this) {
            v0 = this.a(this.c, v0, v2, 0);
        }

        if(this.k != null && this.j == null) {
            if(this.p) {
                this.k.measure(View$MeasureSpec.makeMeasureSpec(0, 0), v2);
                v9 = this.k.getMeasuredWidth();
                v2 = v9 <= v0 ? 1 : 0;
                if(v2 != 0) {
                    v0 -= v9;
                }

                LinearLayout v9_1 = this.k;
                v2 = v2 != 0 ? 0 : 8;
                v9_1.setVisibility(v2);
            }
            else {
                v0 = this.a(this.k, v0, v2, 0);
            }
        }

        if(this.j != null) {
            ViewGroup$LayoutParams v9_2 = this.j.getLayoutParams();
            v2 = v9_2.width != v11 ? v4 : v5;
            if(v9_2.width >= 0) {
                v0 = Math.min(v9_2.width, v0);
            }

            if(v9_2.height == v11) {
                v4 = v5;
            }

            v5 = v9_2.height >= 0 ? Math.min(v9_2.height, v6) : v6;
            this.j.measure(View$MeasureSpec.makeMeasureSpec(v0, v2), View$MeasureSpec.makeMeasureSpec(v5, v4));
        }

        if(this.e <= 0) {
            v2 = this.getChildCount();
            for(v1 = 0; v3 < v2; v1 = v0) {
                v0 = this.getChildAt(v3).getMeasuredHeight() + v8;
                if(v0 <= v1) {
                    v0 = v1;
                }

                ++v3;
            }

            this.setMeasuredDimension(v7, v1);
        }
        else {
            this.setMeasuredDimension(v7, v1);
        }
    }

    public boolean onTouchEvent(MotionEvent arg2) {
        return super.onTouchEvent(arg2);
    }

    public void setContentHeight(int arg1) {
        this.e = arg1;
    }

    public void setCustomView(View arg2) {
        if(this.j != null) {
            this.removeView(this.j);
        }

        this.j = arg2;
        if(arg2 != null && this.k != null) {
            this.removeView(this.k);
            this.k = null;
        }

        if(arg2 != null) {
            this.addView(arg2);
        }

        this.requestLayout();
    }

    public void setSubtitle(CharSequence arg1) {
        this.h = arg1;
        this.e();
    }

    public void setTitle(CharSequence arg1) {
        this.g = arg1;
        this.e();
    }

    public void setTitleOptional(boolean arg2) {
        if(arg2 != this.p) {
            this.requestLayout();
        }

        this.p = arg2;
    }

    public void setVisibility(int arg1) {
        super.setVisibility(arg1);
    }

    public boolean shouldDelayChildPressedState() {
        return 0;
    }
}

