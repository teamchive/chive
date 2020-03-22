package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.h.p;
import android.support.v7.a.a$f;
import android.support.v7.a.a$j;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;

public class ButtonBarLayout extends LinearLayout {
    private boolean a;
    private int b;
    private int c;

    public ButtonBarLayout(Context arg4, AttributeSet arg5) {
        boolean v0 = false;
        super(arg4, arg5);
        this.b = -1;
        this.c = 0;
        if(this.getResources().getConfiguration().screenHeightDp >= 320) {
            v0 = true;
        }

        TypedArray v1 = arg4.obtainStyledAttributes(arg5, j.ButtonBarLayout);
        this.a = v1.getBoolean(j.ButtonBarLayout_allowStacking, v0);
        v1.recycle();
    }

    private int a(int arg4) {
        int v1 = this.getChildCount();
        int v0 = arg4;
        while(true) {
            if(v0 >= v1) {
                return -1;
            }
            else if(this.getChildAt(v0).getVisibility() != 0) {
                ++v0;
                continue;
            }

            return v0;
        }

        return -1;
    }

    private boolean a() {
        boolean v0 = true;
        if(this.getOrientation() != 1) {
            v0 = false;
        }

        return v0;
    }

    public int getMinimumHeight() {
        return Math.max(this.c, super.getMinimumHeight());
    }

    protected void onMeasure(int arg6, int arg7) {
        int v1;
        int v0 = View$MeasureSpec.getSize(arg6);
        if(this.a) {
            if(v0 > this.b && (this.a())) {
                this.setStacked(false);
            }

            this.b = v0;
        }

        if((this.a()) || View$MeasureSpec.getMode(arg6) != 0x40000000) {
            v0 = arg6;
            v1 = 0;
        }
        else {
            v0 = View$MeasureSpec.makeMeasureSpec(v0, 0x80000000);
            v1 = 1;
        }

        super.onMeasure(v0, arg7);
        if((this.a) && !this.a()) {
            v0 = (this.getMeasuredWidthAndState() & 0xFF000000) == 0x1000000 ? 1 : 0;
            if(v0 == 0) {
                goto label_33;
            }

            this.setStacked(true);
            v1 = 1;
        }

    label_33:
        if(v1 != 0) {
            super.onMeasure(arg6, arg7);
        }

        v1 = this.a(0);
        if(v1 >= 0) {
            View v2 = this.getChildAt(v1);
            ViewGroup$LayoutParams v0_1 = v2.getLayoutParams();
            v0 = ((LinearLayout$LayoutParams)v0_1).bottomMargin + (v2.getMeasuredHeight() + this.getPaddingTop() + ((LinearLayout$LayoutParams)v0_1).topMargin);
            if(this.a()) {
                v1 = this.a(v1 + 1);
                if(v1 >= 0) {
                    v0 += this.getChildAt(v1).getPaddingTop() + (((int)(16f * this.getResources().getDisplayMetrics().density)));
                }
            }
            else {
                v0 += this.getPaddingBottom();
            }
        }
        else {
            v0 = 0;
        }

        if(p.c(((View)this)) != v0) {
            this.setMinimumHeight(v0);
        }
    }

    public void setAllowStacking(boolean arg3) {
        if(this.a != arg3) {
            this.a = arg3;
            if(!this.a && this.getOrientation() == 1) {
                this.setStacked(false);
            }

            this.requestLayout();
        }
    }

    private void setStacked(boolean arg3) {
        int v0 = arg3 ? 1 : 0;
        this.setOrientation(v0);
        v0 = arg3 ? 5 : 80;
        this.setGravity(v0);
        View v1 = this.findViewById(f.spacer);
        if(v1 != null) {
            v0 = arg3 ? 8 : 4;
            v1.setVisibility(v0);
        }

        for(v0 = this.getChildCount() - 2; v0 >= 0; --v0) {
            this.bringChildToFront(this.getChildAt(v0));
        }
    }
}

