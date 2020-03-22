package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.h.d;
import android.support.v4.h.p;
import android.support.v7.a.a$f;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;

public class AlertDialogLayout extends ai {
    public AlertDialogLayout(Context arg1) {
        super(arg1);
    }

    public AlertDialogLayout(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
    }

    private void a(View arg3, int arg4, int arg5, int arg6, int arg7) {
        arg3.layout(arg4, arg5, arg4 + arg6, arg5 + arg7);
    }

    private static int c(View arg3) {
        int v0 = p.c(arg3);
        if(v0 <= 0) {
            if(((arg3 instanceof ViewGroup)) && ((ViewGroup)arg3).getChildCount() == 1) {
                return AlertDialogLayout.c(((ViewGroup)arg3).getChildAt(0));
            }

            v0 = 0;
        }

        return v0;
    }

    private boolean c(int arg14, int arg15) {
        int v0_2;
        int v12_1;
        int v2_1;
        int v6;
        int v7;
        int v1_1;
        int v5;
        View v3 = null;
        View v2 = null;
        int v8 = this.getChildCount();
        int v4 = 0;
        View v0 = null;
        while(v4 < v8) {
            View v1 = this.getChildAt(v4);
            if(v1.getVisibility() == 8) {
                v1 = v2;
                v2 = v3;
            }
            else {
                v5 = v1.getId();
                if(v5 == f.topPanel) {
                    View v12 = v2;
                    v2 = v1;
                    v1 = v12;
                }
                else if(v5 == f.buttonPanel) {
                    v2 = v3;
                }
                else {
                    if(v5 != f.contentPanel && v5 != f.customPanel) {
                        boolean v0_1 = false;
                        return v0_1;
                    }

                    if(v0 != null) {
                        return false;
                    }

                    v0 = v1;
                    v1 = v2;
                    v2 = v3;
                }
            }

            ++v4;
            v3 = v2;
            v2 = v1;
        }

        int v9 = View$MeasureSpec.getMode(arg15);
        int v10 = View$MeasureSpec.getSize(arg15);
        int v11 = View$MeasureSpec.getMode(arg14);
        v5 = 0;
        v4 = this.getPaddingBottom() + this.getPaddingTop();
        if(v3 != null) {
            v3.measure(arg14, 0);
            v4 += v3.getMeasuredHeight();
            v5 = View.combineMeasuredStates(0, v3.getMeasuredState());
        }

        int v3_1 = 0;
        if(v2 != null) {
            v2.measure(arg14, 0);
            v3_1 = AlertDialogLayout.c(v2);
            v1_1 = v2.getMeasuredHeight() - v3_1;
            v4 += v3_1;
            v5 = View.combineMeasuredStates(v5, v2.getMeasuredState());
            v7 = v1_1;
        }
        else {
            v7 = 0;
        }

        if(v0 != null) {
            v1_1 = v9 == 0 ? 0 : View$MeasureSpec.makeMeasureSpec(Math.max(0, v10 - v4), v9);
            v0.measure(arg14, v1_1);
            v1_1 = v0.getMeasuredHeight();
            v4 += v1_1;
            v5 = View.combineMeasuredStates(v5, v0.getMeasuredState());
            v6 = v1_1;
        }
        else {
            v6 = 0;
        }

        v1_1 = v10 - v4;
        if(v2 != null) {
            v4 -= v3_1;
            v7 = Math.min(v1_1, v7);
            if(v7 > 0) {
                v1_1 -= v7;
                v3_1 += v7;
            }

            v2.measure(arg14, View$MeasureSpec.makeMeasureSpec(v3_1, 0x40000000));
            v3_1 = v2.getMeasuredHeight() + v4;
            v2_1 = View.combineMeasuredStates(v5, v2.getMeasuredState());
            v12_1 = v1_1;
            v1_1 = v3_1;
            v3_1 = v12_1;
        }
        else {
            v3_1 = v1_1;
            v2_1 = v5;
            v1_1 = v4;
        }

        if(v0 == null || v3_1 <= 0) {
            v0_2 = v1_1;
            v1_1 = v2_1;
        }
        else {
            v0.measure(arg14, View$MeasureSpec.makeMeasureSpec(v3_1 + v6, v9));
            v12_1 = v1_1 - v6 + v0.getMeasuredHeight();
            v1_1 = View.combineMeasuredStates(v2_1, v0.getMeasuredState());
            v0_2 = v12_1;
        }

        v2_1 = 0;
        for(v3_1 = 0; v3_1 < v8; ++v3_1) {
            View v4_1 = this.getChildAt(v3_1);
            if(v4_1.getVisibility() != 8) {
                v2_1 = Math.max(v2_1, v4_1.getMeasuredWidth());
            }
        }

        this.setMeasuredDimension(View.resolveSizeAndState(v2_1 + (this.getPaddingLeft() + this.getPaddingRight()), arg14, v1_1), View.resolveSizeAndState(v0_2, arg15, 0));
        if(v11 != 0x40000000) {
            this.d(v8, arg15);
        }

        return true;
    }

    private void d(int arg10, int arg11) {
        int v2 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0x40000000);
        int v7;
        for(v7 = 0; v7 < arg10; ++v7) {
            View v1 = this.getChildAt(v7);
            if(v1.getVisibility() != 8) {
                ViewGroup$LayoutParams v6 = v1.getLayoutParams();
                if(((a)v6).width == -1) {
                    int v8 = ((a)v6).height;
                    ((a)v6).height = v1.getMeasuredHeight();
                    this.measureChildWithMargins(v1, v2, 0, arg11, 0);
                    ((a)v6).height = v8;
                }
            }
        }
    }

    protected void onLayout(boolean arg15, int arg16, int arg17, int arg18, int arg19) {
        int v2;
        int v10 = this.getPaddingLeft();
        int v0 = arg18 - arg16;
        int v11 = v0 - this.getPaddingRight();
        int v12 = v0 - v10 - this.getPaddingRight();
        v0 = this.getMeasuredHeight();
        int v13 = this.getChildCount();
        int v1 = this.getGravity();
        int v8 = v1 & 0x800007;
        switch(v1 & 0x70) {
            case 16: {
                v0 = (arg19 - arg17 - v0) / 2 + this.getPaddingTop();
                break;
            }
            case 80: {
                v0 = this.getPaddingTop() + arg19 - arg17 - v0;
                break;
            }
            default: {
                v0 = this.getPaddingTop();
                break;
            }
        }

        Drawable v1_1 = this.getDividerDrawable();
        int v7 = v1_1 == null ? 0 : v1_1.getIntrinsicHeight();
        int v9 = 0;
        int v3 = v0;
        while(v9 < v13) {
            View v1_2 = this.getChildAt(v9);
            if(v1_2 != null && v1_2.getVisibility() != 8) {
                int v4 = v1_2.getMeasuredWidth();
                int v5 = v1_2.getMeasuredHeight();
                ViewGroup$LayoutParams v6 = v1_2.getLayoutParams();
                v0 = ((a)v6).h;
                if(v0 < 0) {
                    v0 = v8;
                }

                switch(d.a(v0, p.b(((View)this))) & 7) {
                    case 1: {
                        v2 = (v12 - v4) / 2 + v10 + ((a)v6).leftMargin - ((a)v6).rightMargin;
                        break;
                    }
                    case 5: {
                        v2 = v11 - v4 - ((a)v6).rightMargin;
                        break;
                    }
                    default: {
                        v2 = v10 + ((a)v6).leftMargin;
                        break;
                    }
                }

                v0 = this.c(v9) ? v3 + v7 : v3;
                v3 = ((a)v6).topMargin + v0;
                this.a(v1_2, v2, v3, v4, v5);
                v3 += ((a)v6).bottomMargin + v5;
            }

            ++v9;
        }
    }

    protected void onMeasure(int arg2, int arg3) {
        if(!this.c(arg2, arg3)) {
            super.onMeasure(arg2, arg3);
        }
    }
}

