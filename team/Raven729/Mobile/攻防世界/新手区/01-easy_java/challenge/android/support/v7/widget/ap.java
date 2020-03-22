package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils$TruncateAt;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView$LayoutParams;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class ap extends HorizontalScrollView implements AdapterView$OnItemSelectedListener {
    class a extends BaseAdapter {
        a(ap arg1) {
            this.a = arg1;
            super();
        }

        public int getCount() {
            return this.a.b.getChildCount();
        }

        public Object getItem(int arg2) {
            return this.a.b.getChildAt(arg2).b();
        }

        public long getItemId(int arg3) {
            return ((long)arg3);
        }

        public View getView(int arg4, View arg5, ViewGroup arg6) {
            c v5;
            if(arg5 == null) {
                v5 = this.a.a(this.getItem(arg4), true);
            }
            else {
                arg5.a(this.getItem(arg4));
            }

            return ((View)v5);
        }
    }

    class b implements View$OnClickListener {
        b(ap arg1) {
            this.a = arg1;
            super();
        }

        public void onClick(View arg6) {
            arg6.b().d();
            int v3 = this.a.b.getChildCount();
            int v2;
            for(v2 = 0; v2 < v3; ++v2) {
                View v4 = this.a.b.getChildAt(v2);
                boolean v0 = v4 == arg6 ? true : false;
                v4.setSelected(v0);
            }
        }
    }

    class c extends ai {
        private final int[] b;
        private android.support.v7.app.a$c c;
        private TextView d;
        private ImageView e;
        private View f;

        public c(ap arg5, Context arg6, android.support.v7.app.a$c arg7, boolean arg8) {
            this.a = arg5;
            super(arg6, null, android.support.v7.a.a$a.actionBarTabStyle);
            this.b = new int[]{0x10100D4};
            this.c = arg7;
            aw v0 = aw.a(arg6, null, this.b, android.support.v7.a.a$a.actionBarTabStyle, 0);
            if(v0.g(0)) {
                this.setBackgroundDrawable(v0.a(0));
            }

            v0.a();
            if(arg8) {
                this.setGravity(0x800013);
            }

            this.a();
        }

        public void a(android.support.v7.app.a$c arg1) {
            this.c = arg1;
            this.a();
        }

        public void a() {
            android.support.v7.widget.ai$a v6;
            int v9 = 16;
            int v7 = 8;
            int v8 = -2;
            Drawable v1 = null;
            android.support.v7.app.a$c v3 = this.c;
            View v4 = v3.c();
            if(v4 != null) {
                ViewParent v0 = v4.getParent();
                if((((c)v0)) != this) {
                    if(v0 != null) {
                        ((ViewGroup)v0).removeView(v4);
                    }

                    this.addView(v4);
                }

                this.f = v4;
                if(this.d != null) {
                    this.d.setVisibility(v7);
                }

                if(this.e == null) {
                    return;
                }

                this.e.setVisibility(v7);
                this.e.setImageDrawable(v1);
            }
            else {
                if(this.f != null) {
                    this.removeView(this.f);
                    this.f = ((View)v1);
                }

                Drawable v0_1 = v3.a();
                CharSequence v4_1 = v3.b();
                if(v0_1 != null) {
                    if(this.e == null) {
                        p v5 = new p(this.getContext());
                        v6 = new android.support.v7.widget.ai$a(v8, v8);
                        v6.h = v9;
                        ((ImageView)v5).setLayoutParams(((ViewGroup$LayoutParams)v6));
                        this.addView(((View)v5), 0);
                        this.e = ((ImageView)v5);
                    }

                    this.e.setImageDrawable(v0_1);
                    this.e.setVisibility(0);
                }
                else {
                    if(this.e == null) {
                        goto label_48;
                    }

                    this.e.setVisibility(v7);
                    this.e.setImageDrawable(v1);
                }

            label_48:
                int v0_2 = !TextUtils.isEmpty(v4_1) ? 1 : 0;
                if(v0_2 != 0) {
                    if(this.d == null) {
                        aa v5_1 = new aa(this.getContext(), ((AttributeSet)v1), android.support.v7.a.a$a.actionBarTabTextStyle);
                        ((TextView)v5_1).setEllipsize(TextUtils$TruncateAt.END);
                        v6 = new android.support.v7.widget.ai$a(v8, v8);
                        v6.h = v9;
                        ((TextView)v5_1).setLayoutParams(((ViewGroup$LayoutParams)v6));
                        this.addView(((View)v5_1));
                        this.d = ((TextView)v5_1);
                    }

                    this.d.setText(v4_1);
                    this.d.setVisibility(0);
                }
                else {
                    if(this.d == null) {
                        goto label_70;
                    }

                    this.d.setVisibility(v7);
                    this.d.setText(((CharSequence)v1));
                }

            label_70:
                if(this.e != null) {
                    this.e.setContentDescription(v3.e());
                }

                CharSequence v0_3 = v0_2 != 0 ? ((CharSequence)v1) : v3.e();
                ay.a(((View)this), v0_3);
            }
        }

        public android.support.v7.app.a$c b() {
            return this.c;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent arg2) {
            super.onInitializeAccessibilityEvent(arg2);
            arg2.setClassName(android.support.v7.app.a$c.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg2) {
            super.onInitializeAccessibilityNodeInfo(arg2);
            arg2.setClassName(android.support.v7.app.a$c.class.getName());
        }

        public void onMeasure(int arg3, int arg4) {
            super.onMeasure(arg3, arg4);
            if(this.a.c > 0 && this.getMeasuredWidth() > this.a.c) {
                super.onMeasure(View$MeasureSpec.makeMeasureSpec(this.a.c, 0x40000000), arg4);
            }
        }

        public void setSelected(boolean arg2) {
            int v0 = this.isSelected() != arg2 ? 1 : 0;
            super.setSelected(arg2);
            if(v0 != 0 && (arg2)) {
                this.sendAccessibilityEvent(4);
            }
        }
    }

    Runnable a;
    ai b;
    int c;
    int d;
    private b e;
    private Spinner f;
    private boolean g;
    private int h;
    private int i;
    private static final Interpolator j;

    static {
        ap.j = new DecelerateInterpolator();
    }

    private boolean a() {
        boolean v0 = this.f == null || this.f.getParent() != this ? false : true;
        return v0;
    }

    c a(android.support.v7.app.a$c arg5, boolean arg6) {
        c v0 = new c(this, this.getContext(), arg5, arg6);
        if(arg6) {
            v0.setBackgroundDrawable(null);
            v0.setLayoutParams(new AbsListView$LayoutParams(-1, this.h));
        }
        else {
            v0.setFocusable(true);
            if(this.e == null) {
                this.e = new b(this);
            }

            v0.setOnClickListener(this.e);
        }

        return v0;
    }

    public void a(int arg3) {
        View v0 = this.b.getChildAt(arg3);
        if(this.a != null) {
            this.removeCallbacks(this.a);
        }

        this.a = new Runnable(v0) {
            public void run() {
                this.b.smoothScrollTo(this.a.getLeft() - (this.b.getWidth() - this.a.getWidth()) / 2, 0);
                this.b.a = null;
            }
        };
        this.post(this.a);
    }

    private void b() {
        if(!this.a()) {
            if(this.f == null) {
                this.f = this.d();
            }

            this.removeView(this.b);
            this.addView(this.f, new ViewGroup$LayoutParams(-2, -1));
            if(this.f.getAdapter() == null) {
                this.f.setAdapter(new a(this));
            }

            if(this.a != null) {
                this.removeCallbacks(this.a);
                this.a = null;
            }

            this.f.setSelection(this.i);
        }
    }

    private boolean c() {
        if(this.a()) {
            this.removeView(this.f);
            this.addView(this.b, new ViewGroup$LayoutParams(-2, -1));
            this.setTabSelected(this.f.getSelectedItemPosition());
        }

        return 0;
    }

    private Spinner d() {
        x v0 = new x(this.getContext(), null, android.support.v7.a.a$a.actionDropDownStyle);
        ((Spinner)v0).setLayoutParams(new android.support.v7.widget.ai$a(-2, -1));
        ((Spinner)v0).setOnItemSelectedListener(((AdapterView$OnItemSelectedListener)this));
        return ((Spinner)v0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.a != null) {
            this.post(this.a);
        }
    }

    protected void onConfigurationChanged(Configuration arg3) {
        super.onConfigurationChanged(arg3);
        android.support.v7.view.a v0 = android.support.v7.view.a.a(this.getContext());
        this.setContentHeight(v0.e());
        this.d = v0.g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(this.a != null) {
            this.removeCallbacks(this.a);
        }
    }

    public void onItemSelected(AdapterView arg2, View arg3, int arg4, long arg5) {
        ((c)arg3).b().d();
    }

    public void onMeasure(int arg8, int arg9) {
        int v6 = 0x40000000;
        int v1 = 1;
        int v3 = View$MeasureSpec.getMode(arg8);
        boolean v0 = v3 == v6 ? true : false;
        this.setFillViewport(v0);
        int v4 = this.b.getChildCount();
        if(v4 > 1) {
            if(v3 != v6 && v3 != 0x80000000) {
                goto label_52;
            }

            this.c = v4 > 2 ? ((int)((((float)View$MeasureSpec.getSize(arg8))) * 0.4f)) : View$MeasureSpec.getSize(arg8) / 2;
            this.c = Math.min(this.c, this.d);
        }
        else {
        label_52:
            this.c = -1;
        }

        v3 = View$MeasureSpec.makeMeasureSpec(this.h, v6);
        if((v0) || !this.g) {
            v1 = 0;
        }

        if(v1 != 0) {
            this.b.measure(0, v3);
            if(this.b.getMeasuredWidth() > View$MeasureSpec.getSize(arg8)) {
                this.b();
            }
            else {
                this.c();
            }
        }
        else {
            this.c();
        }

        v1 = this.getMeasuredWidth();
        super.onMeasure(arg8, v3);
        int v2 = this.getMeasuredWidth();
        if((v0) && v1 != v2) {
            this.setTabSelected(this.i);
        }
    }

    public void onNothingSelected(AdapterView arg1) {
    }

    public void setAllowCollapse(boolean arg1) {
        this.g = arg1;
    }

    public void setContentHeight(int arg1) {
        this.h = arg1;
        this.requestLayout();
    }

    public void setTabSelected(int arg6) {
        this.i = arg6;
        int v3 = this.b.getChildCount();
        int v2;
        for(v2 = 0; v2 < v3; ++v2) {
            View v4 = this.b.getChildAt(v2);
            boolean v0 = v2 == arg6 ? true : false;
            v4.setSelected(v0);
            if(v0) {
                this.a(arg6);
            }
        }

        if(this.f != null && arg6 >= 0) {
            this.f.setSelection(arg6);
        }
    }
}

