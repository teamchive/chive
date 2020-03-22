package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.v4.h.d;
import android.support.v4.h.p;
import android.support.v7.a.a$j;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class ai extends ViewGroup {
    public class a extends ViewGroup$MarginLayoutParams {
        public float g;
        public int h;

        public a(Context arg5, AttributeSet arg6) {
            super(arg5, arg6);
            this.h = -1;
            TypedArray v0 = arg5.obtainStyledAttributes(arg6, j.LinearLayoutCompat_Layout);
            this.g = v0.getFloat(j.LinearLayoutCompat_Layout_android_layout_weight, 0f);
            this.h = v0.getInt(j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            v0.recycle();
        }

        public a(ViewGroup$LayoutParams arg2) {
            super(arg2);
            this.h = -1;
        }

        public a(int arg2, int arg3) {
            super(arg2, arg3);
            this.h = -1;
            this.g = 0f;
        }
    }

    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    public ai(Context arg2) {
        this(arg2, null);
    }

    public ai(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public ai(Context arg6, AttributeSet arg7, int arg8) {
        int v4 = -1;
        super(arg6, arg7, arg8);
        this.a = true;
        this.b = v4;
        this.c = 0;
        this.e = 0x800033;
        aw v0 = aw.a(arg6, arg7, j.LinearLayoutCompat, arg8, 0);
        int v1 = v0.a(j.LinearLayoutCompat_android_orientation, v4);
        if(v1 >= 0) {
            this.setOrientation(v1);
        }

        v1 = v0.a(j.LinearLayoutCompat_android_gravity, v4);
        if(v1 >= 0) {
            this.setGravity(v1);
        }

        boolean v1_1 = v0.a(j.LinearLayoutCompat_android_baselineAligned, true);
        if(!v1_1) {
            this.setBaselineAligned(v1_1);
        }

        this.g = v0.a(j.LinearLayoutCompat_android_weightSum, -1f);
        this.b = v0.a(j.LinearLayoutCompat_android_baselineAlignedChildIndex, v4);
        this.h = v0.a(j.LinearLayoutCompat_measureWithLargestChild, false);
        this.setDividerDrawable(v0.a(j.LinearLayoutCompat_divider));
        this.n = v0.a(j.LinearLayoutCompat_showDividers, 0);
        this.o = v0.e(j.LinearLayoutCompat_dividerPadding, 0);
        v0.a();
    }

    private void a(View arg3, int arg4, int arg5, int arg6, int arg7) {
        arg3.layout(arg4, arg5, arg4 + arg6, arg5 + arg7);
    }

    int a(View arg2) {
        return 0;
    }

    int a(View arg2, int arg3) {
        return 0;
    }

    void a(int arg28, int arg29) {
        float v4_2;
        float v26;
        int v10_1;
        ViewGroup$LayoutParams v3_1;
        View v5_1;
        int v6_1;
        int v9;
        int v8;
        int v7;
        int v4_1;
        int v3;
        this.f = 0;
        int v19 = 0;
        int v18 = 0;
        int v13 = 0;
        int v12 = 0;
        int v17 = 1;
        float v6 = 0f;
        int v21 = this.getVirtualChildCount();
        int v22 = View$MeasureSpec.getMode(arg28);
        int v23 = View$MeasureSpec.getMode(arg29);
        int v11 = 0;
        int v15 = 0;
        int v24 = this.b;
        boolean v25 = this.h;
        int v14 = 0x80000000;
        int v5 = 0;
        while(v5 < v21) {
            View v4 = this.b(v5);
            if(v4 == null) {
                this.f += this.d(v5);
                v3 = v14;
                v4_1 = v15;
                v7 = v17;
                v8 = v18;
                v9 = v19;
            }
            else if(v4.getVisibility() == 8) {
                v5 += this.a(v4, v5);
                v3 = v14;
                v4_1 = v15;
                v7 = v17;
                v8 = v18;
                v9 = v19;
            }
            else {
                if(this.c(v5)) {
                    this.f += this.m;
                }

                ViewGroup$LayoutParams v10 = v4.getLayoutParams();
                float v16 = v6 + ((a)v10).g;
                if(v23 != 0x40000000 || ((a)v10).height != 0 || ((a)v10).g <= 0f) {
                    v3 = 0x80000000;
                    if(((a)v10).height == 0 && ((a)v10).g > 0f) {
                        v3 = 0;
                        ((a)v10).height = -2;
                    }

                    int v20 = v3;
                    v9 = v16 == 0f ? this.f : 0;
                    this.a(v4, v5, arg28, 0, arg29, v9);
                    if(v20 != 0x80000000) {
                        ((a)v10).height = v20;
                    }

                    v3 = v4.getMeasuredHeight();
                    this.f = Math.max(this.f, this.f + v3 + ((a)v10).topMargin + ((a)v10).bottomMargin + this.b(v4));
                    if(!v25) {
                        goto label_90;
                    }

                    v14 = Math.max(v3, v14);
                }
                else {
                    this.f = Math.max(this.f, ((a)v10).topMargin + this.f + ((a)v10).bottomMargin);
                    v15 = 1;
                }

            label_90:
                if(v24 >= 0 && v24 == v5 + 1) {
                    this.c = this.f;
                }

                if(v5 < v24 && ((a)v10).g > 0f) {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won\'t work.  Either remove the weight, or don\'t set mBaselineAlignedChildIndex.");
                }

                v3 = 0;
                if(v22 == 0x40000000 || ((a)v10).width != -1) {
                    v6_1 = v11;
                }
                else {
                    v6_1 = 1;
                    v3 = 1;
                }

                v8 = ((a)v10).rightMargin + ((a)v10).leftMargin;
                v9 = v4.getMeasuredWidth() + v8;
                v19 = Math.max(v19, v9);
                v11 = View.combineMeasuredStates(v18, v4.getMeasuredState());
                v7 = v17 == 0 || ((a)v10).width != -1 ? 0 : 1;
                if(((a)v10).g > 0f) {
                    v3 = v3 != 0 ? v8 : v9;
                    v3 = Math.max(v12, v3);
                    v8 = v13;
                }
                else {
                    if(v3 == 0) {
                        v8 = v9;
                    }

                    v8 = Math.max(v13, v8);
                    v3 = v12;
                }

                v5 += this.a(v4, v5);
                v4_1 = v15;
                v12 = v3;
                v13 = v8;
                v9 = v19;
                v3 = v14;
                v8 = v11;
                v11 = v6_1;
                v6 = v16;
            }

            ++v5;
            v14 = v3;
            v15 = v4_1;
            v17 = v7;
            v18 = v8;
            v19 = v9;
        }

        if(this.f > 0 && (this.c(v21))) {
            this.f += this.m;
        }

        if((v25) && (v23 == 0x80000000 || v23 == 0)) {
            this.f = 0;
            for(v4_1 = 0; v4_1 < v21; v4_1 = v3 + 1) {
                v5_1 = this.b(v4_1);
                if(v5_1 == null) {
                    this.f += this.d(v4_1);
                    v3 = v4_1;
                }
                else if(v5_1.getVisibility() == 8) {
                    v3 = this.a(v5_1, v4_1) + v4_1;
                }
                else {
                    v3_1 = v5_1.getLayoutParams();
                    this.f = Math.max(this.f, ((a)v3_1).bottomMargin + (this.f + v14 + ((a)v3_1).topMargin) + this.b(v5_1));
                    v3 = v4_1;
                }
            }
        }

        this.f += this.getPaddingTop() + this.getPaddingBottom();
        int v16_1 = View.resolveSizeAndState(Math.max(this.f, this.getSuggestedMinimumHeight()), arg29, 0);
        v4_1 = (0xFFFFFF & v16_1) - this.f;
        if(v15 == 0) {
            if(v4_1 != 0 && v6 > 0f) {
                goto label_290;
            }

            v10_1 = Math.max(v13, v12);
            if((v25) && v23 != 0x40000000) {
                for(v4_1 = 0; v4_1 < v21; ++v4_1) {
                    v5_1 = this.b(v4_1);
                    if(v5_1 != null && v5_1.getVisibility() != 8 && v5_1.getLayoutParams().g > 0f) {
                        v5_1.measure(View$MeasureSpec.makeMeasureSpec(v5_1.getMeasuredWidth(), 0x40000000), View$MeasureSpec.makeMeasureSpec(v14, 0x40000000));
                    }
                }
            }

            v3 = v10_1;
            v4_1 = v19;
        }
        else {
        label_290:
            if(this.g > 0f) {
                v6 = this.g;
            }

            this.f = 0;
            v14 = 0;
            float v5_2 = v6;
            v9 = v17;
            v10_1 = v13;
            v7 = v18;
            v12 = v19;
            v6_1 = v4_1;
            while(v14 < v21) {
                View v15_1 = this.b(v14);
                if(v15_1.getVisibility() == 8) {
                    v3 = v10_1;
                    v4_1 = v7;
                    v8 = v12;
                    v7 = v9;
                }
                else {
                    v3_1 = v15_1.getLayoutParams();
                    float v8_1 = ((a)v3_1).g;
                    if(v8_1 > 0f) {
                        v4_1 = ((int)((((float)v6_1)) * v8_1 / v5_2));
                        v5_2 -= v8_1;
                        v6_1 -= v4_1;
                        v8 = ai.getChildMeasureSpec(arg28, this.getPaddingLeft() + this.getPaddingRight() + ((a)v3_1).leftMargin + ((a)v3_1).rightMargin, ((a)v3_1).width);
                        if(((a)v3_1).height != 0 || v23 != 0x40000000) {
                            v4_1 += v15_1.getMeasuredHeight();
                            if(v4_1 < 0) {
                                v4_1 = 0;
                            }

                            v15_1.measure(v8, View$MeasureSpec.makeMeasureSpec(v4_1, 0x40000000));
                        }
                        else {
                            if(v4_1 <= 0) {
                                v4_1 = 0;
                            }

                            v15_1.measure(v8, View$MeasureSpec.makeMeasureSpec(v4_1, 0x40000000));
                        }

                        v26 = v5_2;
                        v5 = v6_1;
                        v6_1 = View.combineMeasuredStates(v7, v15_1.getMeasuredState() & 0xFFFFFF00);
                        v4_2 = v26;
                    }
                    else {
                        v4_2 = v5_2;
                        v5 = v6_1;
                        v6_1 = v7;
                    }

                    v7 = ((a)v3_1).leftMargin + ((a)v3_1).rightMargin;
                    v8 = v15_1.getMeasuredWidth() + v7;
                    v12 = Math.max(v12, v8);
                    v13 = v22 == 0x40000000 || ((a)v3_1).width != -1 ? 0 : 1;
                    if(v13 == 0) {
                        v7 = v8;
                    }

                    v8 = Math.max(v10_1, v7);
                    v7 = v9 == 0 || ((a)v3_1).width != -1 ? 0 : 1;
                    this.f = Math.max(this.f, ((a)v3_1).bottomMargin + (v15_1.getMeasuredHeight() + this.f + ((a)v3_1).topMargin) + this.b(v15_1));
                    v3 = v8;
                    v8 = v12;
                    v26 = v4_2;
                    v4_1 = v6_1;
                    v6_1 = v5;
                    v5_2 = v26;
                }

                ++v14;
                v10_1 = v3;
                v12 = v8;
                v9 = v7;
                v7 = v4_1;
            }

            this.f += this.getPaddingTop() + this.getPaddingBottom();
            v17 = v9;
            v3 = v10_1;
            v18 = v7;
            v4_1 = v12;
        }

        if(v17 != 0 || v22 == 0x40000000) {
            v3 = v4_1;
        }

        this.setMeasuredDimension(View.resolveSizeAndState(Math.max(v3 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), arg28, v18), v16_1);
        if(v11 != 0) {
            this.c(v21, arg29);
        }
    }

    void a(View arg7, int arg8, int arg9, int arg10, int arg11, int arg12) {
        this.measureChildWithMargins(arg7, arg9, arg10, arg11, arg12);
    }

    void a(int arg15, int arg16, int arg17, int arg18) {
        int v2;
        int v9 = this.getPaddingLeft();
        int v0 = arg17 - arg15;
        int v10 = v0 - this.getPaddingRight();
        int v11 = v0 - v9 - this.getPaddingRight();
        int v12 = this.getVirtualChildCount();
        v0 = this.e & 0x70;
        int v7 = this.e & 0x800007;
        switch(v0) {
            case 16: {
                v0 = this.getPaddingTop() + (arg18 - arg16 - this.f) / 2;
                break;
            }
            case 80: {
                v0 = this.getPaddingTop() + arg18 - arg16 - this.f;
                break;
            }
            default: {
                v0 = this.getPaddingTop();
                break;
            }
        }

        int v8 = 0;
        int v3 = v0;
        while(v8 < v12) {
            View v1 = this.b(v8);
            if(v1 == null) {
                v3 += this.d(v8);
                v0 = v8;
            }
            else if(v1.getVisibility() != 8) {
                int v4 = v1.getMeasuredWidth();
                int v5 = v1.getMeasuredHeight();
                ViewGroup$LayoutParams v6 = v1.getLayoutParams();
                v0 = ((a)v6).h;
                if(v0 < 0) {
                    v0 = v7;
                }

                switch(d.a(v0, p.b(((View)this))) & 7) {
                    case 1: {
                        v2 = (v11 - v4) / 2 + v9 + ((a)v6).leftMargin - ((a)v6).rightMargin;
                        break;
                    }
                    case 5: {
                        v2 = v10 - v4 - ((a)v6).rightMargin;
                        break;
                    }
                    default: {
                        v2 = v9 + ((a)v6).leftMargin;
                        break;
                    }
                }

                v0 = this.c(v8) ? this.m + v3 : v3;
                int v13 = v0 + ((a)v6).topMargin;
                this.a(v1, v2, v13 + this.a(v1), v4, v5);
                v3 = v13 + (((a)v6).bottomMargin + v5 + this.b(v1));
                v0 = this.a(v1, v8) + v8;
            }
            else {
                v0 = v8;
            }

            v8 = v0 + 1;
        }
    }

    void a(Canvas arg6) {
        int v2 = this.getVirtualChildCount();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            View v3 = this.b(v1);
            if(v3 != null && v3.getVisibility() != 8 && (this.c(v1))) {
                this.a(arg6, v3.getTop() - v3.getLayoutParams().topMargin - this.m);
            }
        }

        if(this.c(v2)) {
            View v1_1 = this.b(v2 - 1);
            int v0 = v1_1 == null ? this.getHeight() - this.getPaddingBottom() - this.m : v1_1.getLayoutParams().bottomMargin + v1_1.getBottom();
            this.a(arg6, v0);
        }
    }

    void a(Canvas arg5, int arg6) {
        this.k.setBounds(this.getPaddingLeft() + this.o, arg6, this.getWidth() - this.getPaddingRight() - this.o, this.m + arg6);
        this.k.draw(arg5);
    }

    View b(int arg2) {
        return this.getChildAt(arg2);
    }

    int b(View arg2) {
        return 0;
    }

    public a b(AttributeSet arg3) {
        return new a(this.getContext(), arg3);
    }

    protected a b(ViewGroup$LayoutParams arg2) {
        return new a(arg2);
    }

    void b(int arg30, int arg31) {
        float v7_2;
        float v3_2;
        int v10_1;
        ViewGroup$LayoutParams v3_1;
        int v6_1;
        int v9;
        int v8;
        int v7;
        int v4_1;
        int v3;
        this.f = 0;
        int v20 = 0;
        int v19 = 0;
        int v14 = 0;
        int v13 = 0;
        int v18 = 1;
        float v6 = 0f;
        int v22 = this.getVirtualChildCount();
        int v23 = View$MeasureSpec.getMode(arg30);
        int v24 = View$MeasureSpec.getMode(arg31);
        int v12 = 0;
        int v16 = 0;
        if(this.i == null || this.j == null) {
            this.i = new int[4];
            this.j = new int[4];
        }

        int[] v25 = this.i;
        int[] v26 = this.j;
        v25[3] = -1;
        v25[2] = -1;
        v25[1] = -1;
        v25[0] = -1;
        v26[3] = -1;
        v26[2] = -1;
        v26[1] = -1;
        v26[0] = -1;
        boolean v27 = this.a;
        boolean v28 = this.h;
        int v11 = v23 == 0x40000000 ? 1 : 0;
        int v15 = 0x80000000;
        int v5 = 0;
        while(v5 < v22) {
            View v4 = this.b(v5);
            if(v4 == null) {
                this.f += this.d(v5);
                v3 = v15;
                v4_1 = v16;
                v7 = v18;
                v8 = v19;
                v9 = v20;
            }
            else if(v4.getVisibility() == 8) {
                v5 += this.a(v4, v5);
                v3 = v15;
                v4_1 = v16;
                v7 = v18;
                v8 = v19;
                v9 = v20;
            }
            else {
                if(this.c(v5)) {
                    this.f += this.l;
                }

                ViewGroup$LayoutParams v10 = v4.getLayoutParams();
                float v17 = v6 + ((a)v10).g;
                if(v23 != 0x40000000 || ((a)v10).width != 0 || ((a)v10).g <= 0f) {
                    v3 = 0x80000000;
                    if(((a)v10).width == 0 && ((a)v10).g > 0f) {
                        v3 = 0;
                        ((a)v10).width = -2;
                    }

                    int v21 = v3;
                    v7 = v17 == 0f ? this.f : 0;
                    this.a(v4, v5, arg30, v7, arg31, 0);
                    if(v21 != 0x80000000) {
                        ((a)v10).width = v21;
                    }

                    v3 = v4.getMeasuredWidth();
                    if(v11 != 0) {
                        this.f += ((a)v10).leftMargin + v3 + ((a)v10).rightMargin + this.b(v4);
                    }
                    else {
                        this.f = Math.max(this.f, this.f + v3 + ((a)v10).leftMargin + ((a)v10).rightMargin + this.b(v4));
                    }

                    if(!v28) {
                        goto label_140;
                    }

                    v15 = Math.max(v3, v15);
                }
                else {
                    if(v11 != 0) {
                        this.f += ((a)v10).leftMargin + ((a)v10).rightMargin;
                    }
                    else {
                        this.f = Math.max(this.f, ((a)v10).leftMargin + this.f + ((a)v10).rightMargin);
                    }

                    if(v27) {
                        v3 = View$MeasureSpec.makeMeasureSpec(0, 0);
                        v4.measure(v3, v3);
                        goto label_140;
                    }

                    v16 = 1;
                }

            label_140:
                v3 = 0;
                if(v24 == 0x40000000 || ((a)v10).height != -1) {
                    v6_1 = v12;
                }
                else {
                    v6_1 = 1;
                    v3 = 1;
                }

                v8 = ((a)v10).bottomMargin + ((a)v10).topMargin;
                v9 = v4.getMeasuredHeight() + v8;
                v12 = View.combineMeasuredStates(v19, v4.getMeasuredState());
                if(v27) {
                    v19 = v4.getBaseline();
                    if(v19 != -1) {
                        v7 = ((a)v10).h < 0 ? this.e : ((a)v10).h;
                        v7 = ((v7 & 0x70) >> 4 & -2) >> 1;
                        v25[v7] = Math.max(v25[v7], v19);
                        v26[v7] = Math.max(v26[v7], v9 - v19);
                    }
                }

                v19 = Math.max(v20, v9);
                v7 = v18 == 0 || ((a)v10).height != -1 ? 0 : 1;
                if(((a)v10).g > 0f) {
                    v3 = v3 != 0 ? v8 : v9;
                    v3 = Math.max(v13, v3);
                    v8 = v14;
                }
                else {
                    if(v3 == 0) {
                        v8 = v9;
                    }

                    v8 = Math.max(v14, v8);
                    v3 = v13;
                }

                v5 += this.a(v4, v5);
                v4_1 = v16;
                v13 = v3;
                v14 = v8;
                v9 = v19;
                v3 = v15;
                v8 = v12;
                v12 = v6_1;
                v6 = v17;
            }

            ++v5;
            v15 = v3;
            v16 = v4_1;
            v18 = v7;
            v19 = v8;
            v20 = v9;
        }

        if(this.f > 0 && (this.c(v22))) {
            this.f += this.l;
        }

        v5 = v25[1] != -1 || v25[0] != -1 || v25[2] != -1 || v25[3] != -1 ? Math.max(v20, Math.max(v25[3], Math.max(v25[0], Math.max(v25[1], v25[2]))) + Math.max(v26[3], Math.max(v26[0], Math.max(v26[1], v26[2])))) : v20;
        if((v28) && (v23 == 0x80000000 || v23 == 0)) {
            this.f = 0;
            for(v4_1 = 0; v4_1 < v22; v4_1 = v3 + 1) {
                View v7_1 = this.b(v4_1);
                if(v7_1 == null) {
                    this.f += this.d(v4_1);
                    v3 = v4_1;
                }
                else if(v7_1.getVisibility() == 8) {
                    v3 = this.a(v7_1, v4_1) + v4_1;
                }
                else {
                    v3_1 = v7_1.getLayoutParams();
                    if(v11 != 0) {
                        this.f = ((a)v3_1).rightMargin + (((a)v3_1).leftMargin + v15) + this.b(v7_1) + this.f;
                        v3 = v4_1;
                    }
                    else {
                        this.f = Math.max(this.f, ((a)v3_1).rightMargin + (this.f + v15 + ((a)v3_1).leftMargin) + this.b(v7_1));
                        v3 = v4_1;
                    }
                }
            }
        }

        this.f += this.getPaddingLeft() + this.getPaddingRight();
        int v17_1 = View.resolveSizeAndState(Math.max(this.f, this.getSuggestedMinimumWidth()), arg30, 0);
        v4_1 = (0xFFFFFF & v17_1) - this.f;
        if(v16 == 0) {
            if(v4_1 != 0 && v6 > 0f) {
                goto label_431;
            }

            v10_1 = Math.max(v14, v13);
            if((v28) && v23 != 0x40000000) {
                for(v4_1 = 0; v4_1 < v22; ++v4_1) {
                    View v6_2 = this.b(v4_1);
                    if(v6_2 != null && v6_2.getVisibility() != 8 && v6_2.getLayoutParams().g > 0f) {
                        v6_2.measure(View$MeasureSpec.makeMeasureSpec(v15, 0x40000000), View$MeasureSpec.makeMeasureSpec(v6_2.getMeasuredHeight(), 0x40000000));
                    }
                }
            }

            v3 = v10_1;
            v4_1 = v5;
        }
        else {
        label_431:
            if(this.g > 0f) {
                v6 = this.g;
            }

            v25[3] = -1;
            v25[2] = -1;
            v25[1] = -1;
            v25[0] = -1;
            v26[3] = -1;
            v26[2] = -1;
            v26[1] = -1;
            v26[0] = -1;
            this.f = 0;
            v15 = 0;
            float v5_1 = v6;
            v9 = v18;
            v10_1 = v14;
            v7 = v19;
            v6_1 = v4_1;
            v14 = -1;
            while(v15 < v22) {
                View v16_1 = this.b(v15);
                if(v16_1 == null) {
                    v3_2 = v5_1;
                    v4_1 = v6_1;
                    v8 = v14;
                    v6_1 = v10_1;
                    v5 = v9;
                }
                else if(v16_1.getVisibility() == 8) {
                    v3_2 = v5_1;
                    v4_1 = v6_1;
                    v8 = v14;
                    v6_1 = v10_1;
                    v5 = v9;
                }
                else {
                    v3_1 = v16_1.getLayoutParams();
                    float v8_1 = ((a)v3_1).g;
                    if(v8_1 > 0f) {
                        v4_1 = ((int)((((float)v6_1)) * v8_1 / v5_1));
                        v5_1 -= v8_1;
                        v8 = v6_1 - v4_1;
                        v6_1 = ai.getChildMeasureSpec(arg31, this.getPaddingTop() + this.getPaddingBottom() + ((a)v3_1).topMargin + ((a)v3_1).bottomMargin, ((a)v3_1).height);
                        if(((a)v3_1).width != 0 || v23 != 0x40000000) {
                            v4_1 += v16_1.getMeasuredWidth();
                            if(v4_1 < 0) {
                                v4_1 = 0;
                            }

                            v16_1.measure(View$MeasureSpec.makeMeasureSpec(v4_1, 0x40000000), v6_1);
                        }
                        else {
                            if(v4_1 <= 0) {
                                v4_1 = 0;
                            }

                            v16_1.measure(View$MeasureSpec.makeMeasureSpec(v4_1, 0x40000000), v6_1);
                        }

                        v13 = View.combineMeasuredStates(v7, v16_1.getMeasuredState() & 0xFF000000);
                        v7_2 = v5_1;
                    }
                    else {
                        v8 = v6_1;
                        v13 = v7;
                        v7_2 = v5_1;
                    }

                    if(v11 != 0) {
                        this.f += v16_1.getMeasuredWidth() + ((a)v3_1).leftMargin + ((a)v3_1).rightMargin + this.b(v16_1);
                    }
                    else {
                        this.f = Math.max(this.f, v16_1.getMeasuredWidth() + this.f + ((a)v3_1).leftMargin + ((a)v3_1).rightMargin + this.b(v16_1));
                    }

                    v4_1 = v24 == 0x40000000 || ((a)v3_1).height != -1 ? 0 : 1;
                    v5 = ((a)v3_1).topMargin + ((a)v3_1).bottomMargin;
                    v6_1 = v16_1.getMeasuredHeight() + v5;
                    v14 = Math.max(v14, v6_1);
                    v4_1 = v4_1 != 0 ? v5 : v6_1;
                    v5 = Math.max(v10_1, v4_1);
                    v4_1 = v9 == 0 || ((a)v3_1).height != -1 ? 0 : 1;
                    if(v27) {
                        v9 = v16_1.getBaseline();
                        if(v9 != -1) {
                            v3 = ((a)v3_1).h < 0 ? this.e : ((a)v3_1).h;
                            v3 = ((v3 & 0x70) >> 4 & -2) >> 1;
                            v25[v3] = Math.max(v25[v3], v9);
                            v26[v3] = Math.max(v26[v3], v6_1 - v9);
                        }
                    }

                    v3_2 = v7_2;
                    v6_1 = v5;
                    v5 = v4_1;
                    v7 = v13;
                    v4_1 = v8;
                    v8 = v14;
                }

                ++v15;
                v10_1 = v6_1;
                v14 = v8;
                v9 = v5;
                v6_1 = v4_1;
                v5_1 = v3_2;
            }

            this.f += this.getPaddingLeft() + this.getPaddingRight();
            if(v25[1] != -1 || v25[0] != -1 || v25[2] != -1 || v25[3] != -1) {
                v14 = Math.max(v14, Math.max(v25[3], Math.max(v25[0], Math.max(v25[1], v25[2]))) + Math.max(v26[3], Math.max(v26[0], Math.max(v26[1], v26[2]))));
            }

            v18 = v9;
            v3 = v10_1;
            v19 = v7;
            v4_1 = v14;
        }

        if(v18 != 0 || v24 == 0x40000000) {
            v3 = v4_1;
        }

        this.setMeasuredDimension(0xFF000000 & v19 | v17_1, View.resolveSizeAndState(Math.max(v3 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), arg31, v19 << 16));
        if(v12 != 0) {
            this.d(v22, arg30);
        }
    }

    void b(int arg23, int arg24, int arg25, int arg26) {
        int v5;
        int v10;
        int v9;
        int v12;
        boolean v4 = bc.a(((View)this));
        int v11 = this.getPaddingTop();
        int v2 = arg26 - arg24;
        int v15 = v2 - this.getPaddingBottom();
        int v16 = v2 - v11 - this.getPaddingBottom();
        int v17 = this.getVirtualChildCount();
        v2 = this.e & 0x800007;
        int v14 = this.e & 0x70;
        boolean v18 = this.a;
        int[] v19 = this.i;
        int[] v20 = this.j;
        switch(d.a(v2, p.b(((View)this)))) {
            case 1: {
                v12 = this.getPaddingLeft() + (arg25 - arg23 - this.f) / 2;
                break;
            }
            case 5: {
                v12 = this.getPaddingLeft() + arg25 - arg23 - this.f;
                break;
            }
            default: {
                v12 = this.getPaddingLeft();
                break;
            }
        }

        if(v4) {
            v9 = -1;
            v10 = v17 - 1;
        }
        else {
            v9 = 1;
            v10 = 0;
        }

        int v13;
        for(v13 = 0; v13 < v17; v13 = v2 + 1) {
            int v21 = v10 + v9 * v13;
            View v3 = this.b(v21);
            if(v3 == null) {
                v12 += this.d(v21);
                v2 = v13;
            }
            else if(v3.getVisibility() != 8) {
                int v6 = v3.getMeasuredWidth();
                int v7 = v3.getMeasuredHeight();
                int v4_1 = -1;
                ViewGroup$LayoutParams v8 = v3.getLayoutParams();
                v2 = !v18 || ((a)v8).height == -1 ? v4_1 : v3.getBaseline();
                v4_1 = ((a)v8).h;
                if(v4_1 < 0) {
                    v4_1 = v14;
                }

                switch(v4_1 & 0x70) {
                    case 16: {
                        v5 = (v16 - v7) / 2 + v11 + ((a)v8).topMargin - ((a)v8).bottomMargin;
                        break;
                    }
                    case 48: {
                        v5 = v11 + ((a)v8).topMargin;
                        if(v2 == -1) {
                            goto label_86;
                        }

                        v5 += v19[1] - v2;
                        break;
                    }
                    case 80: {
                        v5 = v15 - v7 - ((a)v8).bottomMargin;
                        if(v2 == -1) {
                            goto label_86;
                        }

                        v5 -= v20[2] - (v3.getMeasuredHeight() - v2);
                        break;
                    }
                    default: {
                        v5 = v11;
                        break;
                    }
                }

            label_86:
                v2 = this.c(v21) ? this.l + v12 : v12;
                v12 = v2 + ((a)v8).leftMargin;
                this.a(v3, v12 + this.a(v3), v5, v6, v7);
                v12 += ((a)v8).rightMargin + v6 + this.b(v3);
                v2 = this.a(v3, v21) + v13;
            }
            else {
                v2 = v13;
            }
        }
    }

    void b(Canvas arg7) {
        int v0_1;
        ViewGroup$LayoutParams v0;
        int v2 = this.getVirtualChildCount();
        boolean v3 = bc.a(((View)this));
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            View v4 = this.b(v1);
            if(v4 != null && v4.getVisibility() != 8 && (this.c(v1))) {
                v0 = v4.getLayoutParams();
                v0_1 = v3 ? ((a)v0).rightMargin + v4.getRight() : v4.getLeft() - ((a)v0).leftMargin - this.l;
                this.b(arg7, v0_1);
            }
        }

        if(this.c(v2)) {
            View v1_1 = this.b(v2 - 1);
            if(v1_1 != null) {
                v0 = v1_1.getLayoutParams();
                v0_1 = v3 ? v1_1.getLeft() - ((a)v0).leftMargin - this.l : ((a)v0).rightMargin + v1_1.getRight();
            }
            else if(v3) {
                v0_1 = this.getPaddingLeft();
            }
            else {
                v0_1 = this.getWidth() - this.getPaddingRight() - this.l;
            }

            this.b(arg7, v0_1);
        }
    }

    void b(Canvas arg6, int arg7) {
        this.k.setBounds(arg7, this.getPaddingTop() + this.o, this.l + arg7, this.getHeight() - this.getPaddingBottom() - this.o);
        this.k.draw(arg6);
    }

    private void c(int arg10, int arg11) {
        int v2 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0x40000000);
        int v7;
        for(v7 = 0; v7 < arg10; ++v7) {
            View v1 = this.b(v7);
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

    protected boolean c(int arg6) {
        boolean v0 = true;
        if(arg6 == 0) {
            if((this.n & 1) == 0) {
                v0 = false;
            }
        }
        else if(arg6 == this.getChildCount()) {
            if((this.n & 4) == 0) {
                v0 = false;
            }
        }
        else if((this.n & 2) != 0) {
            int v2 = arg6 - 1;
            while(true) {
                if(v2 < 0) {
                    break;
                }
                else if(this.getChildAt(v2).getVisibility() == 8) {
                    --v2;
                    continue;
                }

                return v0;
            }

            v0 = false;
        }
        else {
            v0 = false;
        }

        return v0;
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg2) {
        return arg2 instanceof a;
    }

    private void d(int arg10, int arg11) {
        int v4 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0x40000000);
        int v7;
        for(v7 = 0; v7 < arg10; ++v7) {
            View v1 = this.b(v7);
            if(v1.getVisibility() != 8) {
                ViewGroup$LayoutParams v6 = v1.getLayoutParams();
                if(((a)v6).height == -1) {
                    int v8 = ((a)v6).width;
                    ((a)v6).width = v1.getMeasuredWidth();
                    this.measureChildWithMargins(v1, arg11, 0, v4, 0);
                    ((a)v6).width = v8;
                }
            }
        }
    }

    int d(int arg2) {
        return 0;
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.j();
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg2) {
        return this.b(arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg2) {
        return this.b(arg2);
    }

    public int getBaseline() {
        int v1;
        int v0 = -1;
        if(this.b < 0) {
            v0 = super.getBaseline();
        }
        else if(this.getChildCount() <= this.b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        else {
            View v2 = this.getChildAt(this.b);
            int v3 = v2.getBaseline();
            if(v3 != v0) {
                v0 = this.c;
                if(this.d == 1) {
                    v1 = this.e & 0x70;
                    if(v1 != 0x30) {
                        switch(v1) {
                            case 16: {
                                goto label_46;
                            }
                            case 80: {
                                goto label_37;
                            }
                        }

                        goto label_31;
                    label_37:
                        v1 = this.getBottom() - this.getTop() - this.getPaddingBottom() - this.f;
                        goto label_32;
                    label_46:
                        v1 = v0 + (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - this.f) / 2;
                    }
                    else {
                        goto label_31;
                    }
                }
                else {
                label_31:
                    v1 = v0;
                }

            label_32:
                v0 = v2.getLayoutParams().topMargin + v1 + v3;
            }
            else if(this.b != 0) {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn\'t know how to get its baseline.");
            }
        }

        return v0;
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    public int getGravity() {
        return this.e;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.n;
    }

    int getVirtualChildCount() {
        return this.getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    protected a j() {
        a v0;
        int v2 = -2;
        if(this.d == 0) {
            v0 = new a(v2, v2);
        }
        else if(this.d == 1) {
            v0 = new a(-1, v2);
        }
        else {
            v0 = null;
        }

        return v0;
    }

    protected void onDraw(Canvas arg3) {
        if(this.k != null) {
            if(this.d == 1) {
                this.a(arg3);
            }
            else {
                this.b(arg3);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent arg3) {
        if(Build$VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(arg3);
            arg3.setClassName(ai.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg3) {
        if(Build$VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(arg3);
            arg3.setClassName(ai.class.getName());
        }
    }

    protected void onLayout(boolean arg3, int arg4, int arg5, int arg6, int arg7) {
        if(this.d == 1) {
            this.a(arg4, arg5, arg6, arg7);
        }
        else {
            this.b(arg4, arg5, arg6, arg7);
        }
    }

    protected void onMeasure(int arg3, int arg4) {
        if(this.d == 1) {
            this.a(arg3, arg4);
        }
        else {
            this.b(arg3, arg4);
        }
    }

    public void setBaselineAligned(boolean arg1) {
        this.a = arg1;
    }

    public void setBaselineAlignedChildIndex(int arg4) {
        if(arg4 >= 0 && arg4 < this.getChildCount()) {
            this.b = arg4;
            return;
        }

        throw new IllegalArgumentException("base aligned child index out of range (0, " + this.getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable arg3) {
        boolean v0 = false;
        if(arg3 != this.k) {
            this.k = arg3;
            if(arg3 != null) {
                this.l = arg3.getIntrinsicWidth();
                this.m = arg3.getIntrinsicHeight();
            }
            else {
                this.l = 0;
                this.m = 0;
            }

            if(arg3 == null) {
                v0 = true;
            }

            this.setWillNotDraw(v0);
            this.requestLayout();
        }
    }

    public void setDividerPadding(int arg1) {
        this.o = arg1;
    }

    public void setGravity(int arg3) {
        if(this.e != arg3) {
            int v0 = (0x800007 & arg3) == 0 ? 0x800003 | arg3 : arg3;
            if((v0 & 0x70) == 0) {
                v0 |= 0x30;
            }

            this.e = v0;
            this.requestLayout();
        }
    }

    public void setHorizontalGravity(int arg4) {
        int v0 = arg4 & 0x800007;
        if((this.e & 0x800007) != v0) {
            this.e = v0 | this.e & 0xFF7FFFF8;
            this.requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean arg1) {
        this.h = arg1;
    }

    public void setOrientation(int arg2) {
        if(this.d != arg2) {
            this.d = arg2;
            this.requestLayout();
        }
    }

    public void setShowDividers(int arg2) {
        if(arg2 != this.n) {
            this.requestLayout();
        }

        this.n = arg2;
    }

    public void setVerticalGravity(int arg3) {
        int v0 = arg3 & 0x70;
        if((this.e & 0x70) != v0) {
            this.e = v0 | this.e & 0xFFFFFF8F;
            this.requestLayout();
        }
    }

    public void setWeightSum(float arg2) {
        this.g = Math.max(0f, arg2);
    }

    public boolean shouldDelayChildPressedState() {
        return 0;
    }
}

