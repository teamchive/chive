package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.h.p;
import android.support.v4.h.r;
import android.support.v4.h.s;
import android.support.v7.a.a$j;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup;

abstract class a extends ViewGroup {
    public class android.support.v7.widget.a$a implements s {
        int a;
        private boolean c;

        protected android.support.v7.widget.a$a(a arg2) {
            this.b = arg2;
            super();
            this.c = false;
        }

        public android.support.v7.widget.a$a a(r arg2, int arg3) {
            this.b.f = arg2;
            this.a = arg3;
            return this;
        }

        public void a(View arg3) {
            a.a(this.b, 0);
            this.c = false;
        }

        public void b(View arg3) {
            if(!this.c) {
                this.b.f = null;
                a.b(this.b, this.a);
            }
        }

        public void c(View arg2) {
            this.c = true;
        }
    }

    protected final android.support.v7.widget.a$a a;
    protected final Context b;
    protected ActionMenuView c;
    protected d d;
    protected int e;
    protected r f;
    private boolean g;
    private boolean h;

    a(Context arg2) {
        this(arg2, null);
    }

    a(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    a(Context arg5, AttributeSet arg6, int arg7) {
        super(arg5, arg6, arg7);
        this.a = new android.support.v7.widget.a$a(this);
        TypedValue v0 = new TypedValue();
        this.b = !arg5.getTheme().resolveAttribute(android.support.v7.a.a$a.actionBarPopupTheme, v0, true) || v0.resourceId == 0 ? arg5 : new ContextThemeWrapper(arg5, v0.resourceId);
    }

    protected static int a(int arg1, int arg2, boolean arg3) {
        int v0 = arg3 ? arg1 - arg2 : arg1 + arg2;
        return v0;
    }

    static void a(a arg0, int arg1) {
        super.setVisibility(arg1);
    }

    protected int a(View arg3, int arg4, int arg5, int arg6) {
        arg3.measure(View$MeasureSpec.makeMeasureSpec(arg4, 0x80000000), arg5);
        return Math.max(0, arg4 - arg3.getMeasuredWidth() - arg6);
    }

    protected int a(View arg5, int arg6, int arg7, int arg8, boolean arg9) {
        int v0 = arg5.getMeasuredWidth();
        int v1 = arg5.getMeasuredHeight();
        int v2 = (arg8 - v1) / 2 + arg7;
        if(arg9) {
            arg5.layout(arg6 - v0, v2, arg6, v1 + v2);
        }
        else {
            arg5.layout(arg6, v2, arg6 + v0, v1 + v2);
        }

        if(arg9) {
            v0 = -v0;
        }

        return v0;
    }

    public r a(int arg3, long arg4) {
        r v0;
        if(this.f != null) {
            this.f.b();
        }

        if(arg3 == 0) {
            if(this.getVisibility() != 0) {
                this.setAlpha(0f);
            }

            v0 = p.d(((View)this)).a(1f);
            v0.a(arg4);
            v0.a(this.a.a(v0, arg3));
        }
        else {
            v0 = p.d(((View)this)).a(0f);
            v0.a(arg4);
            v0.a(this.a.a(v0, arg3));
        }

        return v0;
    }

    public boolean a() {
        boolean v0 = this.d != null ? this.d.d() : false;
        return v0;
    }

    static void b(a arg0, int arg1) {
        super.setVisibility(arg1);
    }

    public int getAnimatedVisibility() {
        int v0 = this.f != null ? this.a.a : this.getVisibility();
        return v0;
    }

    public int getContentHeight() {
        return this.e;
    }

    protected void onConfigurationChanged(Configuration arg6) {
        super.onConfigurationChanged(arg6);
        TypedArray v0 = this.getContext().obtainStyledAttributes(null, j.ActionBar, android.support.v7.a.a$a.actionBarStyle, 0);
        this.setContentHeight(v0.getLayoutDimension(j.ActionBar_height, 0));
        v0.recycle();
        if(this.d != null) {
            this.d.a(arg6);
        }
    }

    public boolean onHoverEvent(MotionEvent arg6) {
        int v4 = 9;
        int v0 = arg6.getActionMasked();
        if(v0 == v4) {
            this.h = false;
        }

        if(!this.h) {
            boolean v1 = super.onHoverEvent(arg6);
            if(v0 == v4 && !v1) {
                this.h = true;
            }
        }

        if(v0 == 10 || v0 == 3) {
            this.h = false;
        }

        return 1;
    }

    public boolean onTouchEvent(MotionEvent arg5) {
        int v0 = arg5.getActionMasked();
        if(v0 == 0) {
            this.g = false;
        }

        if(!this.g) {
            boolean v1 = super.onTouchEvent(arg5);
            if(v0 == 0 && !v1) {
                this.g = true;
            }
        }

        if(v0 == 1 || v0 == 3) {
            this.g = false;
        }

        return 1;
    }

    public void setContentHeight(int arg1) {
        this.e = arg1;
        this.requestLayout();
    }

    public void setVisibility(int arg2) {
        if(arg2 != this.getVisibility()) {
            if(this.f != null) {
                this.f.b();
            }

            super.setVisibility(arg2);
        }
    }
}

