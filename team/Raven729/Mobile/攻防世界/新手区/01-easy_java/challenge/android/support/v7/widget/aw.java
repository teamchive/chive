package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a.b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class aw {
    private final Context a;
    private final TypedArray b;
    private TypedValue c;

    private aw(Context arg1, TypedArray arg2) {
        super();
        this.a = arg1;
        this.b = arg2;
    }

    public static aw a(Context arg2, AttributeSet arg3, int[] arg4) {
        return new aw(arg2, arg2.obtainStyledAttributes(arg3, arg4));
    }

    public void a() {
        this.b.recycle();
    }

    public static aw a(Context arg2, AttributeSet arg3, int[] arg4, int arg5, int arg6) {
        return new aw(arg2, arg2.obtainStyledAttributes(arg3, arg4, arg5, arg6));
    }

    public Drawable a(int arg3) {
        Drawable v0_1;
        if(this.b.hasValue(arg3)) {
            int v0 = this.b.getResourceId(arg3, 0);
            if(v0 != 0) {
                v0_1 = b.b(this.a, v0);
            }
            else {
                goto label_10;
            }
        }
        else {
        label_10:
            v0_1 = this.b.getDrawable(arg3);
        }

        return v0_1;
    }

    public boolean a(int arg2, boolean arg3) {
        return this.b.getBoolean(arg2, arg3);
    }

    public int a(int arg2, int arg3) {
        return this.b.getInt(arg2, arg3);
    }

    public float a(int arg2, float arg3) {
        return this.b.getFloat(arg2, arg3);
    }

    public static aw a(Context arg2, int arg3, int[] arg4) {
        return new aw(arg2, arg2.obtainStyledAttributes(arg3, arg4));
    }

    public Typeface a(int arg4, int arg5, TextView arg6) {
        Typeface v0_1;
        int v0 = this.b.getResourceId(arg4, 0);
        if(v0 == 0) {
            v0_1 = null;
        }
        else {
            if(this.c == null) {
                this.c = new TypedValue();
            }

            v0_1 = android.support.v4.b.a.b.a(this.a, v0, this.c, arg5, arg6);
        }

        return v0_1;
    }

    public Drawable b(int arg5) {
        Drawable v0_1;
        if(this.b.hasValue(arg5)) {
            int v0 = this.b.getResourceId(arg5, 0);
            if(v0 != 0) {
                v0_1 = l.a().a(this.a, v0, true);
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            v0_1 = null;
        }

        return v0_1;
    }

    public int b(int arg2, int arg3) {
        return this.b.getColor(arg2, arg3);
    }

    public int c(int arg2, int arg3) {
        return this.b.getInteger(arg2, arg3);
    }

    public CharSequence c(int arg2) {
        return this.b.getText(arg2);
    }

    public int d(int arg2, int arg3) {
        return this.b.getDimensionPixelOffset(arg2, arg3);
    }

    public String d(int arg2) {
        return this.b.getString(arg2);
    }

    public int e(int arg2, int arg3) {
        return this.b.getDimensionPixelSize(arg2, arg3);
    }

    public ColorStateList e(int arg3) {
        ColorStateList v0_1;
        if(this.b.hasValue(arg3)) {
            int v0 = this.b.getResourceId(arg3, 0);
            if(v0 != 0) {
                v0_1 = b.a(this.a, v0);
                if(v0_1 == null) {
                    goto label_11;
                }
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = this.b.getColorStateList(arg3);
        }

        return v0_1;
    }

    public int f(int arg2, int arg3) {
        return this.b.getLayoutDimension(arg2, arg3);
    }

    public CharSequence[] f(int arg2) {
        return this.b.getTextArray(arg2);
    }

    public boolean g(int arg2) {
        return this.b.hasValue(arg2);
    }

    public int g(int arg2, int arg3) {
        return this.b.getResourceId(arg2, arg3);
    }
}

