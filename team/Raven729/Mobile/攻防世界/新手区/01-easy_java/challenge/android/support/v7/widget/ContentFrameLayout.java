package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.h.p;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View$MeasureSpec;
import android.view.View;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {
    public interface a {
        void a();

        void b();
    }

    private TypedValue a;
    private TypedValue b;
    private TypedValue c;
    private TypedValue d;
    private TypedValue e;
    private TypedValue f;
    private final Rect g;
    private a h;

    public ContentFrameLayout(Context arg2) {
        this(arg2, null);
    }

    public ContentFrameLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public ContentFrameLayout(Context arg2, AttributeSet arg3, int arg4) {
        super(arg2, arg3, arg4);
        this.g = new Rect();
    }

    public void a(int arg2, int arg3, int arg4, int arg5) {
        this.g.set(arg2, arg3, arg4, arg5);
        if(p.l(((View)this))) {
            this.requestLayout();
        }
    }

    public void a(Rect arg1) {
        this.fitSystemWindows(arg1);
    }

    public TypedValue getFixedHeightMajor() {
        if(this.e == null) {
            this.e = new TypedValue();
        }

        return this.e;
    }

    public TypedValue getFixedHeightMinor() {
        if(this.f == null) {
            this.f = new TypedValue();
        }

        return this.f;
    }

    public TypedValue getFixedWidthMajor() {
        if(this.c == null) {
            this.c = new TypedValue();
        }

        return this.c;
    }

    public TypedValue getFixedWidthMinor() {
        if(this.d == null) {
            this.d = new TypedValue();
        }

        return this.d;
    }

    public TypedValue getMinWidthMajor() {
        if(this.a == null) {
            this.a = new TypedValue();
        }

        return this.a;
    }

    public TypedValue getMinWidthMinor() {
        if(this.b == null) {
            this.b = new TypedValue();
        }

        return this.b;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.h != null) {
            this.h.a();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(this.h != null) {
            this.h.b();
        }
    }

    protected void onMeasure(int arg13, int arg14) {
        int v4;
        int v3_1;
        TypedValue v3;
        int v11 = 5;
        int v10 = 0x80000000;
        int v9 = 0x40000000;
        int v2 = 0;
        DisplayMetrics v5 = this.getContext().getResources().getDisplayMetrics();
        int v0 = v5.widthPixels < v5.heightPixels ? 1 : 0;
        int v6 = View$MeasureSpec.getMode(arg13);
        int v7 = View$MeasureSpec.getMode(arg14);
        if(v6 == v10) {
            v3 = v0 != 0 ? this.d : this.c;
            if(v3 == null) {
                goto label_126;
            }

            if(v3.type == 0) {
                goto label_126;
            }

            if(v3.type == v11) {
                v3_1 = ((int)v3.getDimension(v5));
            }
            else if(v3.type == 6) {
                v3_1 = ((int)v3.getFraction(((float)v5.widthPixels), ((float)v5.widthPixels)));
            }
            else {
                v3_1 = 0;
            }

            if(v3_1 <= 0) {
                goto label_126;
            }

            arg13 = View$MeasureSpec.makeMeasureSpec(Math.min(v3_1 - (this.g.left + this.g.right), View$MeasureSpec.getSize(arg13)), v9);
            v4 = 1;
        }
        else {
        label_126:
            v4 = 0;
        }

        if(v7 == v10) {
            v3 = v0 != 0 ? this.e : this.f;
            if(v3 == null) {
                goto label_55;
            }

            if(v3.type == 0) {
                goto label_55;
            }

            if(v3.type == v11) {
                v3_1 = ((int)v3.getDimension(v5));
            }
            else if(v3.type == 6) {
                v3_1 = ((int)v3.getFraction(((float)v5.heightPixels), ((float)v5.heightPixels)));
            }
            else {
                v3_1 = 0;
            }

            if(v3_1 <= 0) {
                goto label_55;
            }

            arg14 = View$MeasureSpec.makeMeasureSpec(Math.min(v3_1 - (this.g.top + this.g.bottom), View$MeasureSpec.getSize(arg14)), v9);
        }

    label_55:
        super.onMeasure(arg13, arg14);
        v7 = this.getMeasuredWidth();
        v3_1 = View$MeasureSpec.makeMeasureSpec(v7, v9);
        if(v4 != 0 || v6 != v10) {
        label_120:
            v0 = v3_1;
        }
        else {
            TypedValue v0_1 = v0 != 0 ? this.b : this.a;
            if(v0_1 == null) {
                goto label_120;
            }

            if(v0_1.type == 0) {
                goto label_120;
            }

            if(v0_1.type == v11) {
                v0 = ((int)v0_1.getDimension(v5));
            }
            else if(v0_1.type == 6) {
                v0 = ((int)v0_1.getFraction(((float)v5.widthPixels), ((float)v5.widthPixels)));
            }
            else {
                v0 = 0;
            }

            if(v0 > 0) {
                v0 -= this.g.left + this.g.right;
            }

            if(v7 >= v0) {
                goto label_120;
            }

            v0 = View$MeasureSpec.makeMeasureSpec(v0, v9);
            v2 = 1;
        }

        if(v2 != 0) {
            super.onMeasure(v0, arg14);
        }
    }

    public void setAttachListener(a arg1) {
        this.h = arg1;
    }
}

