package android.support.v7.app;

class p {
    public long a;
    public long b;
    public int c;
    private static p d;

    p() {
        super();
    }

    static p a() {
        if(p.d == null) {
            p.d = new p();
        }

        return p.d;
    }

    public void a(long arg16, double arg18, double arg20) {
        float v2 = (((float)(arg16 - 946728000000L))) / 86400000f;
        float v3 = 6.24006f + 0.017202f * v2;
        double v4 = (((double)v3)) + 0.03342 * Math.sin(((double)v3)) + 0.000349 * Math.sin(((double)(2f * v3))) + 0.000005 * Math.sin(((double)(3f * v3))) + 1.796593 + 3.141593;
        double v6 = -arg20 / 360;
        double v2_1 = Math.sin(((double)v3)) * 0.0053 + (v6 + (((double)((((float)Math.round((((double)(v2 - 0.0009f))) - v6))) + 0.0009f)))) + -0.0069 * Math.sin(2 * v4);
        v4 = Math.asin(Math.sin(v4) * Math.sin(0.40928));
        v6 = 0.017453 * arg18;
        v4 = (Math.sin(-0.10472) - Math.sin(v6) * Math.sin(v4)) / (Math.cos(v4) * Math.cos(v6));
        if(v4 >= 1) {
            this.c = 1;
            this.a = -1;
            this.b = -1;
        }
        else if(v4 <= -1) {
            this.c = 0;
            this.a = -1;
            this.b = -1;
        }
        else {
            float v4_1 = ((float)(Math.acos(v4) / 6.283185));
            this.a = Math.round(((((double)v4_1)) + v2_1) * 86400000) + 946728000000L;
            this.b = Math.round((v2_1 - (((double)v4_1))) * 86400000) + 946728000000L;
            if(this.b < arg16 && this.a > arg16) {
                this.c = 0;
                return;
            }

            this.c = 1;
        }
    }
}

