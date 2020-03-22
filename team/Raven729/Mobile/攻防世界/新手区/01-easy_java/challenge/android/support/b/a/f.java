package android.support.b.a;

import android.animation.TypeEvaluator;

public class f implements TypeEvaluator {
    private static final f a;

    static {
        f.a = new f();
    }

    public f() {
        super();
    }

    public static f a() {
        return f.a;
    }

    public Object evaluate(float arg13, Object arg14, Object arg15) {
        int v0 = ((Integer)arg14).intValue();
        float v1 = (((float)(v0 >> 24 & 0xFF))) / 255f;
        int v4 = ((Integer)arg15).intValue();
        float v2 = ((float)Math.pow(((double)((((float)(v0 >> 16 & 0xFF))) / 255f)), 2.2));
        float v3 = ((float)Math.pow(((double)((((float)(v0 >> 8 & 0xFF))) / 255f)), 2.2));
        float v0_1 = ((float)Math.pow(((double)((((float)(v0 & 0xFF))) / 255f)), 2.2));
        return Integer.valueOf(Math.round((((float)Math.pow(((double)(v0_1 + ((((float)Math.pow(((double)((((float)(v4 & 0xFF))) / 255f)), 2.2))) - v0_1) * arg13)), 0.454545))) * 255f) | (Math.round((v1 + ((((float)(v4 >> 24 & 0xFF))) / 255f - v1) * arg13) * 255f) << 24 | Math.round((((float)Math.pow(((double)(v2 + ((((float)Math.pow(((double)((((float)(v4 >> 16 & 0xFF))) / 255f)), 2.2))) - v2) * arg13)), 0.454545))) * 255f) << 16 | Math.round((((float)Math.pow(((double)(v3 + ((((float)Math.pow(((double)((((float)(v4 >> 8 & 0xFF))) / 255f)), 2.2))) - v3) * arg13)), 0.454545))) * 255f) << 8));
    }
}

