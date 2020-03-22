package android.support.v4.view.animation;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.RequiresApi;
import android.view.animation.Interpolator;

@TargetApi(value=9) @RequiresApi(value=9) class PathInterpolatorGingerbread implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    public PathInterpolatorGingerbread(float arg2, float arg3) {
        this(PathInterpolatorGingerbread.createQuad(arg2, arg3));
    }

    public PathInterpolatorGingerbread(float arg2, float arg3, float arg4, float arg5) {
        this(PathInterpolatorGingerbread.createCubic(arg2, arg3, arg4, arg5));
    }

    public PathInterpolatorGingerbread(Path arg9) {
        super();
        PathMeasure v2 = new PathMeasure(arg9, false);
        float v3 = v2.getLength();
        int v4 = (((int)(v3 / 0.002f))) + 1;
        this.mX = new float[v4];
        this.mY = new float[v4];
        float[] v5 = new float[2];
        int v0;
        for(v0 = 0; v0 < v4; ++v0) {
            v2.getPosTan((((float)v0)) * v3 / (((float)(v4 - 1))), v5, null);
            this.mX[v0] = v5[0];
            this.mY[v0] = v5[1];
        }
    }

    private static Path createCubic(float arg7, float arg8, float arg9, float arg10) {
        Path v0 = new Path();
        v0.moveTo(0f, 0f);
        v0.cubicTo(arg7, arg8, arg9, arg10, 1f, 1f);
        return v0;
    }

    private static Path createQuad(float arg3, float arg4) {
        Path v0 = new Path();
        v0.moveTo(0f, 0f);
        v0.quadTo(arg3, arg4, 1f, 1f);
        return v0;
    }

    public float getInterpolation(float arg7) {
        float v0 = 1f;
        if(arg7 <= 0f) {
            v0 = 0f;
        }
        else if(arg7 < v0) {
            int v2 = 0;
            int v1;
            for(v1 = this.mX.length - 1; v1 - v2 > 1; v1 = v0_1) {
                int v0_1 = (v2 + v1) / 2;
                if(arg7 < this.mX[v0_1]) {
                    v1 = v2;
                }
                else {
                    int v5 = v1;
                    v1 = v0_1;
                    v0_1 = v5;
                }

                v2 = v1;
            }

            v0 = this.mX[v1] - this.mX[v2];
            if(v0 == 0f) {
                return this.mY[v2];
            }

            v0 = (arg7 - this.mX[v2]) / v0 * (this.mY[v1] - this.mY[v2]) + this.mY[v2];
        }

        return v0;
    }
}

