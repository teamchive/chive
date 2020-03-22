package android.support.b.a;

import android.content.Context;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.b.a.c;
import android.support.v4.c.b;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public class g implements Interpolator {
    private float[] a;
    private float[] b;

    public g(Context arg3, AttributeSet arg4, XmlPullParser arg5) {
        this(arg3.getResources(), arg3.getTheme(), arg4, arg5);
    }

    public g(Resources arg2, Resources$Theme arg3, AttributeSet arg4, XmlPullParser arg5) {
        super();
        TypedArray v0 = c.a(arg2, arg3, arg4, a.l);
        this.a(v0, arg5);
        v0.recycle();
    }

    private void a(TypedArray arg7, XmlPullParser arg8) {
        if(c.a(arg8, "pathData")) {
            String v0 = c.a(arg7, arg8, "pathData", 4);
            Path v1 = b.a(v0);
            if(v1 == null) {
                throw new InflateException("The path is null, which is created from " + v0);
            }
            else {
                this.a(v1);
            }
        }
        else if(!c.a(arg8, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        else if(!c.a(arg8, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        else {
            float v0_1 = c.a(arg7, arg8, "controlX1", 0, 0f);
            float v1_1 = c.a(arg7, arg8, "controlY1", 1, 0f);
            boolean v2 = c.a(arg8, "controlX2");
            if(v2 != c.a(arg8, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            }
            else if(!v2) {
                this.a(v0_1, v1_1);
            }
            else {
                this.a(v0_1, v1_1, c.a(arg7, arg8, "controlX2", 2, 0f), c.a(arg7, arg8, "controlY2", 3, 0f));
            }
        }
    }

    private void a(float arg4, float arg5) {
        Path v0 = new Path();
        v0.moveTo(0f, 0f);
        v0.quadTo(arg4, arg5, 1f, 1f);
        this.a(v0);
    }

    private void a(Path arg12) {
        float v3_1;
        float v10 = 1f;
        double v8 = 0.00001;
        int v0 = 0;
        PathMeasure v4 = new PathMeasure(arg12, false);
        float v2 = v4.getLength();
        int v5 = Math.min(3000, (((int)(v2 / 0.002f))) + 1);
        if(v5 <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + v2);
        }

        this.a = new float[v5];
        this.b = new float[v5];
        float[] v3 = new float[2];
        int v1;
        for(v1 = 0; v1 < v5; ++v1) {
            v4.getPosTan((((float)v1)) * v2 / (((float)(v5 - 1))), v3, null);
            this.a[v1] = v3[0];
            this.b[v1] = v3[1];
        }

        if((((double)Math.abs(this.a[0]))) <= v8 && (((double)Math.abs(this.b[0]))) <= v8 && (((double)Math.abs(this.a[v5 - 1] - v10))) <= v8 && (((double)Math.abs(this.b[v5 - 1] - v10))) <= v8) {
            v3_1 = 0f;
            v1 = 0;
        }
        else {
            throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.a[0] + "," + this.b[0] + " end:" + this.a[v5 - 1] + "," + this.b[v5 - 1]);
        }

        while(v0 < v5) {
            int v2_1 = v1 + 1;
            float v1_1 = this.a[v1];
            if(v1_1 < v3_1) {
                throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + v1_1);
            }

            this.a[v0] = v1_1;
            ++v0;
            v3_1 = v1_1;
            v1 = v2_1;
        }

        if(v4.nextContour()) {
            throw new IllegalArgumentException("The Path should be continuous, can\'t have 2+ contours");
        }
    }

    private void a(float arg8, float arg9, float arg10, float arg11) {
        Path v0 = new Path();
        v0.moveTo(0f, 0f);
        v0.cubicTo(arg8, arg9, arg10, arg11, 1f, 1f);
        this.a(v0);
    }

    public float getInterpolation(float arg7) {
        float v0 = 1f;
        if(arg7 <= 0f) {
            v0 = 0f;
        }
        else if(arg7 < v0) {
            int v2 = 0;
            int v1;
            for(v1 = this.a.length - 1; v1 - v2 > 1; v1 = v0_1) {
                int v0_1 = (v2 + v1) / 2;
                if(arg7 < this.a[v0_1]) {
                    v1 = v2;
                }
                else {
                    int v5 = v1;
                    v1 = v0_1;
                    v0_1 = v5;
                }

                v2 = v1;
            }

            v0 = this.a[v1] - this.a[v2];
            if(v0 == 0f) {
                return this.b[v2];
            }

            v0 = (arg7 - this.a[v2]) / v0 * (this.b[v1] - this.b[v2]) + this.b[v2];
        }

        return v0;
    }
}

