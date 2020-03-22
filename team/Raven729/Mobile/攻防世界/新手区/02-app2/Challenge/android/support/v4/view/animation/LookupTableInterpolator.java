package android.support.v4.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] arg3) {
        super();
        this.mValues = arg3;
        this.mStepSize = 1f / (((float)(this.mValues.length - 1)));
    }

    public float getInterpolation(float arg6) {
        float v0 = 1f;
        if(arg6 < v0) {
            if(arg6 <= 0f) {
                v0 = 0f;
            }
            else {
                int v0_1 = Math.min(((int)((((float)(this.mValues.length - 1))) * arg6)), this.mValues.length - 2);
                v0 = (this.mValues[v0_1 + 1] - this.mValues[v0_1]) * ((arg6 - (((float)v0_1)) * this.mStepSize) / this.mStepSize) + this.mValues[v0_1];
            }
        }

        return v0;
    }
}

