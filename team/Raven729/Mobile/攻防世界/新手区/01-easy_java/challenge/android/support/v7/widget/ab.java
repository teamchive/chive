package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build$VERSION;
import android.support.v7.a.a$j;
import android.text.Layout$Alignment;
import android.text.StaticLayout$Builder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

class ab {
    private static final RectF a;
    private static Hashtable b;
    private int c;
    private boolean d;
    private float e;
    private float f;
    private float g;
    private int[] h;
    private boolean i;
    private TextPaint j;
    private final TextView k;
    private final Context l;

    static {
        ab.a = new RectF();
        ab.b = new Hashtable();
    }

    ab(TextView arg3) {
        super();
        this.c = 0;
        this.d = false;
        this.e = -1f;
        this.f = -1f;
        this.g = -1f;
        this.h = new int[0];
        this.i = false;
        this.k = arg3;
        this.l = this.k.getContext();
    }

    private int a(RectF arg6) {
        int v0 = this.h.length;
        if(v0 == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }

        int v2 = 0;
        int v1 = 1;
        --v0;
        while(v1 <= v0) {
            v2 = (v1 + v0) / 2;
            if(this.a(this.h[v2], arg6)) {
                int v4 = v2 + 1;
                v2 = v1;
                v1 = v4;
                continue;
            }

            v0 = v2 - 1;
            v2 = v0;
        }

        return this.h[v2];
    }

    private boolean a(int arg8, RectF arg9) {
        boolean v0_2;
        int v2 = -1;
        CharSequence v4 = this.k.getText();
        int v1 = Build$VERSION.SDK_INT >= 16 ? this.k.getMaxLines() : v2;
        if(this.j == null) {
            this.j = new TextPaint();
        }
        else {
            this.j.reset();
        }

        this.j.set(this.k.getPaint());
        this.j.setTextSize(((float)arg8));
        Object v0 = this.a(this.k, "getLayoutAlignment", Layout$Alignment.ALIGN_NORMAL);
        StaticLayout v0_1 = Build$VERSION.SDK_INT >= 23 ? this.a(v4, ((Layout$Alignment)v0), Math.round(arg9.right), v1) : this.a(v4, ((Layout$Alignment)v0), Math.round(arg9.right));
        if(v1 != v2) {
            if(v0_1.getLineCount() <= v1 && v0_1.getLineEnd(v0_1.getLineCount() - 1) == v4.length()) {
                goto label_51;
            }

            v0_2 = false;
        }
        else {
        label_51:
            if((((float)v0_1.getHeight())) > arg9.bottom) {
                return false;
            }

            v0_2 = true;
        }

        return v0_2;
    }

    @TargetApi(value=14) private StaticLayout a(CharSequence arg9, Layout$Alignment arg10, int arg11) {
        boolean v7;
        float v6;
        float v5;
        float v0 = 1f;
        if(Build$VERSION.SDK_INT >= 16) {
            v5 = this.k.getLineSpacingMultiplier();
            v6 = this.k.getLineSpacingExtra();
            v7 = this.k.getIncludeFontPadding();
        }
        else {
            v5 = this.a(this.k, "getLineSpacingMultiplier", Float.valueOf(v0)).floatValue();
            v6 = this.a(this.k, "getLineSpacingExtra", Float.valueOf(0f)).floatValue();
            v7 = this.a(this.k, "getIncludeFontPadding", Boolean.valueOf(true)).booleanValue();
        }

        return new StaticLayout(arg9, this.j, arg11, arg10, v5, v6, v7);
    }

    private Object a(Object arg7, String arg8, Object arg9) {
        Object v0 = null;
        try {
            return this.a(arg8).invoke(arg7);
        }
        catch(Throwable v1) {
        }
        catch(Exception v1_1) {
            try {
                Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + arg8 + "() method", ((Throwable)v1_1));
                if(0 == 0) {
                    return arg9;
                }
            }
            catch(Throwable v1) {
                if(0 != 0) {
                }

                goto label_24;
            }
        }

        return v0;
    label_24:
        throw v1;
        return arg9;
    }

    @TargetApi(value=23) private StaticLayout a(CharSequence arg5, Layout$Alignment arg6, int arg7, int arg8) {
        Object v0 = this.a(this.k, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
        StaticLayout$Builder v1 = StaticLayout$Builder.obtain(arg5, 0, arg5.length(), this.j, arg7).setAlignment(arg6).setLineSpacing(this.k.getLineSpacingExtra(), this.k.getLineSpacingMultiplier()).setIncludePad(this.k.getIncludeFontPadding()).setBreakStrategy(this.k.getBreakStrategy()).setHyphenationFrequency(this.k.getHyphenationFrequency());
        if(arg8 == -1) {
            arg8 = 0x7FFFFFFF;
        }

        return v1.setMaxLines(arg8).setTextDirection(((TextDirectionHeuristic)v0)).build();
    }

    private Method a(String arg5) {
        Method v0_2;
        try {
            Object v0_1 = ab.b.get(arg5);
            if(v0_1 != null) {
                return v0_2;
            }

            v0_2 = TextView.class.getDeclaredMethod(arg5);
            if(v0_2 == null) {
                return v0_2;
            }

            v0_2.setAccessible(true);
            ab.b.put(arg5, v0_2);
        }
        catch(Exception v0) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + arg5 + "() method", ((Throwable)v0));
            v0_2 = null;
        }

        return v0_2;
    }

    private void a(float arg5) {
        if(arg5 != this.k.getPaint().getTextSize()) {
            this.k.getPaint().setTextSize(arg5);
            boolean v0 = Build$VERSION.SDK_INT >= 18 ? this.k.isInLayout() : false;
            if(this.k.getLayout() == null) {
                return;
            }

            this.d = false;
            try {
                Method v1_1 = this.a("nullLayouts");
                if(v1_1 == null) {
                    goto label_25;
                }

                v1_1.invoke(this.k);
            }
            catch(Exception v1) {
                Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", ((Throwable)v1));
            }

        label_25:
            if(!v0) {
                this.k.requestLayout();
            }
            else {
                this.k.forceLayout();
            }

            this.k.invalidate();
        }
    }

    private void a(float arg4, float arg5, float arg6) {
        if(arg4 <= 0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + arg4 + "px) is less or equal to (0px)");
        }

        if(arg5 <= arg4) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + arg5 + "px) is less or equal to minimum auto-size " + "text size (" + arg4 + "px)");
        }

        if(arg6 <= 0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + arg6 + "px) is less or equal to (0px)");
        }

        this.c = 1;
        this.f = arg4;
        this.g = arg5;
        this.e = arg6;
        this.i = false;
    }

    private void a(TypedArray arg5) {
        int v1 = arg5.length();
        int[] v2 = new int[v1];
        if(v1 > 0) {
            int v0;
            for(v0 = 0; v0 < v1; ++v0) {
                v2[v0] = arg5.getDimensionPixelSize(v0, -1);
            }

            this.h = this.a(v2);
            this.h();
        }
    }

    private int[] a(int[] arg7) {
        int v2 = arg7.length;
        if(v2 != 0) {
            Arrays.sort(arg7);
            ArrayList v3 = new ArrayList();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                int v4 = arg7[v1];
                if(v4 > 0 && Collections.binarySearch(((List)v3), Integer.valueOf(v4)) < 0) {
                    ((List)v3).add(Integer.valueOf(v4));
                }
            }

            if(v2 == ((List)v3).size()) {
                return arg7;
            }

            v2 = ((List)v3).size();
            arg7 = new int[v2];
            for(v1 = 0; v1 < v2; ++v1) {
                arg7[v1] = ((List)v3).get(v1).intValue();
            }
        }

        return arg7;
    }

    int a() {
        return this.c;
    }

    void a(int arg5) {
        int v3 = 2;
        if(this.k()) {
            switch(arg5) {
                case 0: {
                    goto label_13;
                }
                case 1: {
                    goto label_15;
                }
            }

            throw new IllegalArgumentException("Unknown auto-size text type: " + arg5);
        label_13:
            this.j();
            return;
        label_15:
            DisplayMetrics v0 = this.l.getResources().getDisplayMetrics();
            this.a(TypedValue.applyDimension(v3, 12f, v0), TypedValue.applyDimension(v3, 112f, v0), 1f);
            if(this.i()) {
                this.f();
            }
        }
    }

    void a(int arg2, float arg3) {
        Resources v0 = this.l == null ? Resources.getSystem() : this.l.getResources();
        this.a(TypedValue.applyDimension(arg2, arg3, v0.getDisplayMetrics()));
    }

    void a(int arg5, int arg6, int arg7, int arg8) {
        if(this.k()) {
            DisplayMetrics v0 = this.l.getResources().getDisplayMetrics();
            this.a(TypedValue.applyDimension(arg8, ((float)arg5), v0), TypedValue.applyDimension(arg8, ((float)arg6), v0), TypedValue.applyDimension(arg8, ((float)arg7), v0));
            if(this.i()) {
                this.f();
            }
        }
    }

    void a(AttributeSet arg10, int arg11) {
        int v8 = 2;
        float v1 = -1f;
        TypedArray v4 = this.l.obtainStyledAttributes(arg10, j.AppCompatTextView, arg11, 0);
        if(v4.hasValue(j.AppCompatTextView_autoSizeTextType)) {
            this.c = v4.getInt(j.AppCompatTextView_autoSizeTextType, 0);
        }

        float v0 = v4.hasValue(j.AppCompatTextView_autoSizeStepGranularity) ? v4.getDimension(j.AppCompatTextView_autoSizeStepGranularity, v1) : v1;
        float v2 = v4.hasValue(j.AppCompatTextView_autoSizeMinTextSize) ? v4.getDimension(j.AppCompatTextView_autoSizeMinTextSize, v1) : v1;
        float v3 = v4.hasValue(j.AppCompatTextView_autoSizeMaxTextSize) ? v4.getDimension(j.AppCompatTextView_autoSizeMaxTextSize, v1) : v1;
        if(v4.hasValue(j.AppCompatTextView_autoSizePresetSizes)) {
            int v5 = v4.getResourceId(j.AppCompatTextView_autoSizePresetSizes, 0);
            if(v5 > 0) {
                TypedArray v5_1 = v4.getResources().obtainTypedArray(v5);
                this.a(v5_1);
                v5_1.recycle();
            }
        }

        v4.recycle();
        if(!this.k()) {
            this.c = 0;
        }
        else if(this.c == 1) {
            if(!this.i) {
                DisplayMetrics v4_1 = this.l.getResources().getDisplayMetrics();
                if(v2 == v1) {
                    v2 = TypedValue.applyDimension(v8, 12f, v4_1);
                }

                if(v3 == v1) {
                    v3 = TypedValue.applyDimension(v8, 112f, v4_1);
                }

                if(v0 == v1) {
                    v0 = 1f;
                }

                this.a(v2, v3, v0);
            }

            this.i();
        }
    }

    void a(int[] arg6, int arg7) {
        int v1 = 0;
        if(this.k()) {
            int v2 = arg6.length;
            if(v2 > 0) {
                int[] v0 = new int[v2];
                if(arg7 == 0) {
                    v0 = Arrays.copyOf(arg6, v2);
                }
                else {
                    DisplayMetrics v3 = this.l.getResources().getDisplayMetrics();
                    while(v1 < v2) {
                        v0[v1] = Math.round(TypedValue.applyDimension(arg7, ((float)arg6[v1]), v3));
                        ++v1;
                    }
                }

                this.h = this.a(v0);
                if(this.h()) {
                    goto label_34;
                }

                throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(arg6));
            }
            else {
                this.i = false;
            }

        label_34:
            if(!this.i()) {
                return;
            }

            this.f();
        }
    }

    int b() {
        return Math.round(this.e);
    }

    int c() {
        return Math.round(this.f);
    }

    int d() {
        return Math.round(this.g);
    }

    int[] e() {
        return this.h;
    }

    void f() {
        if(this.g()) {
            if(this.d) {
                if(this.k.getMeasuredHeight() <= 0) {
                    return;
                }
                else if(this.k.getMeasuredWidth() > 0) {
                    int v0 = this.a(this.k, "getHorizontallyScrolling", Boolean.valueOf(false)).booleanValue() ? 0x100000 : this.k.getMeasuredWidth() - this.k.getTotalPaddingLeft() - this.k.getTotalPaddingRight();
                    int v1 = this.k.getHeight() - this.k.getCompoundPaddingBottom() - this.k.getCompoundPaddingTop();
                    if(v0 <= 0) {
                        return;
                    }

                    if(v1 <= 0) {
                        return;
                    }

                    RectF v2 = ab.a;
                    __monitor_enter(v2);
                    try {
                        ab.a.setEmpty();
                        ab.a.right = ((float)v0);
                        ab.a.bottom = ((float)v1);
                        float v0_2 = ((float)this.a(ab.a));
                        if(v0_2 != this.k.getTextSize()) {
                            this.a(0, v0_2);
                        }

                        __monitor_exit(v2);
                    }
                    catch(Throwable v0_1) {
                        try {
                        label_61:
                            __monitor_exit(v2);
                        }
                        catch(Throwable v0_1) {
                            goto label_61;
                        }

                        throw v0_1;
                    }
                }
                else {
                    return;
                }
            }

            this.d = true;
        }
    }

    boolean g() {
        boolean v0 = !this.k() || this.c == 0 ? false : true;
        return v0;
    }

    private boolean h() {
        int v3 = this.h.length;
        boolean v0 = v3 > 0 ? true : false;
        this.i = v0;
        if(this.i) {
            this.c = 1;
            this.f = ((float)this.h[0]);
            this.g = ((float)this.h[v3 - 1]);
            this.e = -1f;
        }

        return this.i;
    }

    private boolean i() {
        if(!this.k() || this.c != 1) {
            this.d = false;
        }
        else {
            if(!this.i || this.h.length == 0) {
                float v0 = ((float)Math.round(this.f));
                int v1 = 1;
                while(Math.round(this.e + v0) <= Math.round(this.g)) {
                    ++v1;
                    v0 += this.e;
                }

                int[] v4 = new int[v1];
                float v3 = this.f;
                int v0_1;
                for(v0_1 = 0; v0_1 < v1; ++v0_1) {
                    v4[v0_1] = Math.round(v3);
                    v3 += this.e;
                }

                this.h = this.a(v4);
            }

            this.d = true;
        }

        return this.d;
    }

    private void j() {
        this.c = 0;
        this.f = -1f;
        this.g = -1f;
        this.e = -1f;
        this.h = new int[0];
        this.d = false;
    }

    private boolean k() {
        boolean v0 = !(this.k instanceof m) ? true : false;
        return v0;
    }
}

