package android.support.v4.h.b;

import android.view.animation.Interpolator;

abstract class d implements Interpolator {
    private final float[] a;
    private final float b;

    public d(float[] arg3) {
        super();
        this.a = arg3;
        this.b = 1f / (((float)(this.a.length - 1)));
    }

    public float getInterpolation(float arg6) {
        float v0 = 1f;
        if(arg6 < v0) {
            if(arg6 <= 0f) {
                v0 = 0f;
            }
            else {
                int v0_1 = Math.min(((int)((((float)(this.a.length - 1))) * arg6)), this.a.length - 2);
                v0 = (this.a[v0_1 + 1] - this.a[v0_1]) * ((arg6 - (((float)v0_1)) * this.b) / this.b) + this.a[v0_1];
            }
        }

        return v0;
    }
}

