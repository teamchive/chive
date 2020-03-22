package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.widget.aa;
import android.support.v7.widget.ah;
import android.support.v7.widget.ay;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View$OnClickListener;
import android.view.View;

public class ActionMenuItemView extends aa implements a, android.support.v7.widget.ActionMenuView$a, View$OnClickListener {
    class android.support.v7.view.menu.ActionMenuItemView$a extends ah {
        public android.support.v7.view.menu.ActionMenuItemView$a(ActionMenuItemView arg1) {
            this.a = arg1;
            super(((View)arg1));
        }

        public s a() {
            s v0 = this.a.c != null ? this.a.c.a() : null;
            return v0;
        }

        protected boolean b() {
            boolean v0 = false;
            if(this.a.b != null && (this.a.b.a(this.a.a))) {
                s v1 = this.a();
                if(v1 != null && (v1.d())) {
                    v0 = true;
                }
            }

            return v0;
        }
    }

    public abstract class b {
        public b() {
            super();
        }

        public abstract s a();
    }

    j a;
    android.support.v7.view.menu.h$b b;
    b c;
    private CharSequence d;
    private Drawable e;
    private ah f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private int k;

    public ActionMenuItemView(Context arg2) {
        this(arg2, null);
    }

    public ActionMenuItemView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public ActionMenuItemView(Context arg5, AttributeSet arg6, int arg7) {
        super(arg5, arg6, arg7);
        Resources v0 = arg5.getResources();
        this.g = this.e();
        TypedArray v1 = arg5.obtainStyledAttributes(arg6, android.support.v7.a.a$j.ActionMenuItemView, arg7, 0);
        this.i = v1.getDimensionPixelSize(android.support.v7.a.a$j.ActionMenuItemView_android_minWidth, 0);
        v1.recycle();
        this.k = ((int)(v0.getDisplayMetrics().density * 32f + 0.5f));
        this.setOnClickListener(((View$OnClickListener)this));
        this.j = -1;
        this.setSaveEnabled(false);
    }

    public void a(j arg2, int arg3) {
        this.a = arg2;
        this.setIcon(arg2.getIcon());
        this.setTitle(arg2.a(((a)this)));
        this.setId(arg2.getItemId());
        int v0 = arg2.isVisible() ? 0 : 8;
        this.setVisibility(v0);
        this.setEnabled(arg2.isEnabled());
        if((arg2.hasSubMenu()) && this.f == null) {
            this.f = new android.support.v7.view.menu.ActionMenuItemView$a(this);
        }
    }

    public boolean a() {
        return 1;
    }

    public boolean b() {
        boolean v0 = !TextUtils.isEmpty(this.getText()) ? true : false;
        return v0;
    }

    public boolean c() {
        boolean v0 = !this.b() || this.a.getIcon() != null ? false : true;
        return v0;
    }

    public boolean d() {
        return this.b();
    }

    private boolean e() {
        boolean v0_1;
        int v4 = 480;
        Configuration v0 = this.getContext().getResources().getConfiguration();
        int v1 = v0.screenWidthDp;
        int v2 = v0.screenHeightDp;
        if(v1 < v4) {
            if(v1 >= 640 && v2 >= v4) {
                goto label_13;
            }

            if(v0.orientation == 2) {
                goto label_13;
            }

            v0_1 = false;
        }
        else {
        label_13:
            v0_1 = true;
        }

        return v0_1;
    }

    private void f() {
        int v2 = 0;
        CharSequence v3 = null;
        int v0 = !TextUtils.isEmpty(this.d) ? 1 : 0;
        if(this.e == null) {
        label_16:
            v2 = 1;
        }
        else if(this.a.m()) {
            if(this.g) {
                goto label_16;
            }
            else if(this.h) {
                goto label_16;
            }
        }

        int v1 = v0 & v2;
        CharSequence v0_1 = v1 != 0 ? this.d : v3;
        this.setText(v0_1);
        v0_1 = this.a.getContentDescription();
        if(TextUtils.isEmpty(v0_1)) {
            v0_1 = v1 != 0 ? v3 : this.a.getTitle();
            this.setContentDescription(v0_1);
        }
        else {
            this.setContentDescription(v0_1);
        }

        v0_1 = this.a.getTooltipText();
        if(TextUtils.isEmpty(v0_1)) {
            if(v1 == 0) {
                v3 = this.a.getTitle();
            }

            ay.a(((View)this), v3);
        }
        else {
            ay.a(((View)this), v0_1);
        }
    }

    public j getItemData() {
        return this.a;
    }

    public void onClick(View arg3) {
        if(this.b != null) {
            this.b.a(this.a);
        }
    }

    public void onConfigurationChanged(Configuration arg2) {
        super.onConfigurationChanged(arg2);
        this.g = this.e();
        this.f();
    }

    protected void onMeasure(int arg7, int arg8) {
        int v5 = 0x40000000;
        boolean v1 = this.b();
        if((v1) && this.j >= 0) {
            super.setPadding(this.j, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }

        super.onMeasure(arg7, arg8);
        int v2 = View$MeasureSpec.getMode(arg7);
        int v0 = View$MeasureSpec.getSize(arg7);
        int v3 = this.getMeasuredWidth();
        v0 = v2 == 0x80000000 ? Math.min(v0, this.i) : this.i;
        if(v2 != v5 && this.i > 0 && v3 < v0) {
            super.onMeasure(View$MeasureSpec.makeMeasureSpec(v0, v5), arg8);
        }

        if(!v1 && this.e != null) {
            super.setPadding((this.getMeasuredWidth() - this.e.getBounds().width()) / 2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable arg2) {
        super.onRestoreInstanceState(null);
    }

    public boolean onTouchEvent(MotionEvent arg2) {
        boolean v0 = !this.a.hasSubMenu() || this.f == null || !this.f.onTouch(((View)this), arg2) ? super.onTouchEvent(arg2) : true;
        return v0;
    }

    public void setCheckable(boolean arg1) {
    }

    public void setChecked(boolean arg1) {
    }

    public void setExpandedFormat(boolean arg2) {
        if(this.h != arg2) {
            this.h = arg2;
            if(this.a != null) {
                this.a.h();
            }
        }
    }

    public void setIcon(Drawable arg6) {
        float v2;
        Drawable v3 = null;
        this.e = arg6;
        if(arg6 != null) {
            int v1 = arg6.getIntrinsicWidth();
            int v0 = arg6.getIntrinsicHeight();
            if(v1 > this.k) {
                v2 = (((float)this.k)) / (((float)v1));
                v1 = this.k;
                v0 = ((int)((((float)v0)) * v2));
            }

            if(v0 > this.k) {
                v2 = (((float)this.k)) / (((float)v0));
                v0 = this.k;
                v1 = ((int)((((float)v1)) * v2));
            }

            arg6.setBounds(0, 0, v1, v0);
        }

        this.setCompoundDrawables(arg6, v3, v3, v3);
        this.f();
    }

    public void setItemInvoker(android.support.v7.view.menu.h$b arg1) {
        this.b = arg1;
    }

    public void setPadding(int arg1, int arg2, int arg3, int arg4) {
        this.j = arg1;
        super.setPadding(arg1, arg2, arg3, arg4);
    }

    public void setPopupCallback(b arg1) {
        this.c = arg1;
    }

    public void setTitle(CharSequence arg1) {
        this.d = arg1;
        this.f();
    }
}

