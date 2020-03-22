package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.v4.h.p;
import android.support.v7.a.a$f;
import android.support.v7.a.a$j;
import android.util.AttributeSet;
import android.view.ActionMode$Callback;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
    Drawable a;
    Drawable b;
    Drawable c;
    boolean d;
    boolean e;
    private boolean f;
    private View g;
    private View h;
    private View i;
    private int j;

    public ActionBarContainer(Context arg2) {
        this(arg2, null);
    }

    public ActionBarContainer(Context arg6, AttributeSet arg7) {
        boolean v0_3;
        b v0_1;
        super(arg6, arg7);
        if(Build$VERSION.SDK_INT >= 21) {
            c v0 = new c(this);
        }
        else {
            v0_1 = new b(this);
        }

        p.a(((View)this), ((Drawable)v0_1));
        TypedArray v0_2 = arg6.obtainStyledAttributes(arg7, j.ActionBar);
        this.a = v0_2.getDrawable(j.ActionBar_background);
        this.b = v0_2.getDrawable(j.ActionBar_backgroundStacked);
        this.j = v0_2.getDimensionPixelSize(j.ActionBar_height, -1);
        if(this.getId() == f.split_action_bar) {
            this.d = true;
            this.c = v0_2.getDrawable(j.ActionBar_backgroundSplit);
        }

        v0_2.recycle();
        if(!this.d) {
            if(this.a == null && this.b == null) {
                v0_3 = true;
                goto label_34;
            }

            v0_3 = false;
        }
        else if(this.c == null) {
            v0_3 = true;
        }
        else {
            v0_3 = false;
        }

    label_34:
        this.setWillNotDraw(v0_3);
    }

    private boolean a(View arg3) {
        boolean v0 = arg3 == null || arg3.getVisibility() == 8 || arg3.getMeasuredHeight() == 0 ? true : false;
        return v0;
    }

    private int b(View arg4) {
        ViewGroup$LayoutParams v0 = arg4.getLayoutParams();
        return ((FrameLayout$LayoutParams)v0).bottomMargin + (arg4.getMeasuredHeight() + ((FrameLayout$LayoutParams)v0).topMargin);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(this.a != null && (this.a.isStateful())) {
            this.a.setState(this.getDrawableState());
        }

        if(this.b != null && (this.b.isStateful())) {
            this.b.setState(this.getDrawableState());
        }

        if(this.c != null && (this.c.isStateful())) {
            this.c.setState(this.getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.g;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if(this.a != null) {
            this.a.jumpToCurrentState();
        }

        if(this.b != null) {
            this.b.jumpToCurrentState();
        }

        if(this.c != null) {
            this.c.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.h = this.findViewById(f.action_bar);
        this.i = this.findViewById(f.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent arg2) {
        super.onHoverEvent(arg2);
        return 1;
    }

    public boolean onInterceptTouchEvent(MotionEvent arg2) {
        boolean v0 = (this.f) || (super.onInterceptTouchEvent(arg2)) ? true : false;
        return v0;
    }

    public void onLayout(boolean arg9, int arg10, int arg11, int arg12, int arg13) {
        int v0_1;
        int v5 = 8;
        int v1 = 1;
        super.onLayout(arg9, arg10, arg11, arg12, arg13);
        View v4 = this.g;
        boolean v3 = v4 == null || v4.getVisibility() == v5 ? false : true;
        if(v4 != null && v4.getVisibility() != v5) {
            v5 = this.getMeasuredHeight();
            ViewGroup$LayoutParams v0 = v4.getLayoutParams();
            v4.layout(arg10, v5 - v4.getMeasuredHeight() - ((FrameLayout$LayoutParams)v0).bottomMargin, arg12, v5 - ((FrameLayout$LayoutParams)v0).bottomMargin);
        }

        if(!this.d) {
            if(this.a != null) {
                if(this.h.getVisibility() == 0) {
                    this.a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
                }
                else {
                    if(this.i != null && this.i.getVisibility() == 0) {
                        this.a.setBounds(this.i.getLeft(), this.i.getTop(), this.i.getRight(), this.i.getBottom());
                        goto label_49;
                    }

                    this.a.setBounds(0, 0, 0, 0);
                }

            label_49:
                v0_1 = 1;
            }
            else {
                v0_1 = 0;
            }

            this.e = v3;
            if((v3) && this.b != null) {
                this.b.setBounds(v4.getLeft(), v4.getTop(), v4.getRight(), v4.getBottom());
                goto label_29;
            }

            v1 = v0_1;
        }
        else if(this.c != null) {
            this.c.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
        }
        else {
            v1 = 0;
        }

    label_29:
        if(v1 != 0) {
            this.invalidate();
        }
    }

    public void onMeasure(int arg5, int arg6) {
        int v1;
        int v3 = 0x80000000;
        if(this.h == null && View$MeasureSpec.getMode(arg6) == v3 && this.j >= 0) {
            arg6 = View$MeasureSpec.makeMeasureSpec(Math.min(this.j, View$MeasureSpec.getSize(arg6)), v3);
        }

        super.onMeasure(arg5, arg6);
        if(this.h != null) {
            int v2 = View$MeasureSpec.getMode(arg6);
            if(this.g != null && this.g.getVisibility() != 8 && v2 != 0x40000000) {
                if(!this.a(this.h)) {
                    v1 = this.b(this.h);
                }
                else if(!this.a(this.i)) {
                    v1 = this.b(this.i);
                }
                else {
                    v1 = 0;
                }

                int v0 = v2 == v3 ? View$MeasureSpec.getSize(arg6) : 0x7FFFFFFF;
                this.setMeasuredDimension(this.getMeasuredWidth(), Math.min(v1 + this.b(this.g), v0));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent arg2) {
        super.onTouchEvent(arg2);
        return 1;
    }

    public void setPrimaryBackground(Drawable arg8) {
        boolean v0 = true;
        if(this.a != null) {
            this.a.setCallback(null);
            this.unscheduleDrawable(this.a);
        }

        this.a = arg8;
        if(arg8 != null) {
            arg8.setCallback(((Drawable$Callback)this));
            if(this.h != null) {
                this.a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
            }
        }

        if(!this.d) {
            if(this.a == null && this.b == null) {
                goto label_28;
            }

            v0 = false;
        }
        else if(this.c != null) {
            v0 = false;
        }

    label_28:
        this.setWillNotDraw(v0);
        this.invalidate();
    }

    public void setSplitBackground(Drawable arg6) {
        boolean v0 = true;
        if(this.c != null) {
            this.c.setCallback(null);
            this.unscheduleDrawable(this.c);
        }

        this.c = arg6;
        if(arg6 != null) {
            arg6.setCallback(((Drawable$Callback)this));
            if((this.d) && this.c != null) {
                this.c.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
            }
        }

        if(!this.d) {
            if(this.a == null && this.b == null) {
                goto label_24;
            }

            v0 = false;
        }
        else if(this.c != null) {
            v0 = false;
        }

    label_24:
        this.setWillNotDraw(v0);
        this.invalidate();
    }

    public void setStackedBackground(Drawable arg8) {
        boolean v0 = true;
        if(this.b != null) {
            this.b.setCallback(null);
            this.unscheduleDrawable(this.b);
        }

        this.b = arg8;
        if(arg8 != null) {
            arg8.setCallback(((Drawable$Callback)this));
            if((this.e) && this.b != null) {
                this.b.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom());
            }
        }

        if(!this.d) {
            if(this.a == null && this.b == null) {
                goto label_30;
            }

            v0 = false;
        }
        else if(this.c != null) {
            v0 = false;
        }

    label_30:
        this.setWillNotDraw(v0);
        this.invalidate();
    }

    public void setTabContainer(ap arg3) {
        if(this.g != null) {
            this.removeView(this.g);
        }

        this.g = ((View)arg3);
        if(arg3 != null) {
            this.addView(((View)arg3));
            ViewGroup$LayoutParams v0 = arg3.getLayoutParams();
            v0.width = -1;
            v0.height = -2;
            arg3.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean arg2) {
        this.f = arg2;
        int v0 = arg2 ? 0x60000 : 0x40000;
        this.setDescendantFocusability(v0);
    }

    public void setVisibility(int arg4) {
        super.setVisibility(arg4);
        boolean v0 = arg4 == 0 ? true : false;
        if(this.a != null) {
            this.a.setVisible(v0, false);
        }

        if(this.b != null) {
            this.b.setVisible(v0, false);
        }

        if(this.c != null) {
            this.c.setVisible(v0, false);
        }
    }

    public ActionMode startActionModeForChild(View arg2, ActionMode$Callback arg3) {
        return null;
    }

    public ActionMode startActionModeForChild(View arg2, ActionMode$Callback arg3, int arg4) {
        ActionMode v0 = arg4 != 0 ? super.startActionModeForChild(arg2, arg3, arg4) : null;
        return v0;
    }

    protected boolean verifyDrawable(Drawable arg2) {
        boolean v0;
        if(arg2 != this.a || (this.d)) {
            if(arg2 == this.b && (this.e)) {
                goto label_14;
            }

            if(arg2 == this.c && (this.d)) {
                goto label_14;
            }

            if(super.verifyDrawable(arg2)) {
            label_14:
                v0 = true;
                return v0;
            }

            v0 = false;
        }
        else {
            goto label_14;
        }

        return v0;
    }
}

