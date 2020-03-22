package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.h.p;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a implements View$OnTouchListener {
    class android.support.v4.widget.a$a {
        private int a;
        private int b;
        private float c;
        private float d;
        private long e;
        private long f;
        private int g;
        private int h;
        private long i;
        private float j;
        private int k;

        android.support.v4.widget.a$a() {
            super();
            this.e = -9223372036854775808L;
            this.i = -1;
            this.f = 0;
            this.g = 0;
            this.h = 0;
        }

        public void a(int arg1) {
            this.a = arg1;
        }

        public void a(float arg1, float arg2) {
            this.c = arg1;
            this.d = arg2;
        }

        private float a(float arg3) {
            return -4f * arg3 * arg3 + 4f * arg3;
        }

        private float a(long arg8) {
            float v6 = 1f;
            float v0 = 0f;
            if(arg8 >= this.e) {
                if(this.i >= 0 && arg8 >= this.i) {
                    return a.a((((float)(arg8 - this.i))) / (((float)this.k)), 0f, v6) * this.j + (v6 - this.j);
                }

                v0 = a.a((((float)(arg8 - this.e))) / (((float)this.a)), 0f, v6) * 0.5f;
            }

            return v0;
        }

        public void a() {
            this.e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1;
            this.f = this.e;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        public void b() {
            long v0 = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.a(((int)(v0 - this.e)), 0, this.b);
            this.j = this.a(v0);
            this.i = v0;
        }

        public void b(int arg1) {
            this.b = arg1;
        }

        public boolean c() {
            boolean v0 = this.i <= 0 || AnimationUtils.currentAnimationTimeMillis() <= this.i + (((long)this.k)) ? false : true;
            return v0;
        }

        public void d() {
            if(this.f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }

            long v0 = AnimationUtils.currentAnimationTimeMillis();
            float v2 = this.a(this.a(v0));
            long v4 = v0 - this.f;
            this.f = v0;
            this.g = ((int)((((float)v4)) * v2 * this.c));
            this.h = ((int)((((float)v4)) * v2 * this.d));
        }

        public int e() {
            return ((int)(this.c / Math.abs(this.c)));
        }

        public int f() {
            return ((int)(this.d / Math.abs(this.d)));
        }

        public int g() {
            return this.g;
        }

        public int h() {
            return this.h;
        }
    }

    class b implements Runnable {
        b(a arg1) {
            this.a = arg1;
            super();
        }

        public void run() {
            if(this.a.e) {
                if(this.a.c) {
                    this.a.c = false;
                    this.a.a.a();
                }

                android.support.v4.widget.a$a v0 = this.a.a;
                if(!v0.c() && (this.a.a())) {
                    if(this.a.d) {
                        this.a.d = false;
                        this.a.b();
                    }

                    v0.d();
                    this.a.a(v0.g(), v0.h());
                    p.a(this.a.b, ((Runnable)this));
                    return;
                }

                this.a.e = false;
            }
        }
    }

    final android.support.v4.widget.a$a a;
    final View b;
    boolean c;
    boolean d;
    boolean e;
    private final Interpolator f;
    private Runnable g;
    private float[] h;
    private float[] i;
    private int j;
    private int k;
    private float[] l;
    private float[] m;
    private float[] n;
    private boolean o;
    private boolean p;
    private boolean q;
    private static final int r;

    static {
        a.r = ViewConfiguration.getTapTimeout();
    }

    public a(View arg8) {
        super();
        this.a = new android.support.v4.widget.a$a();
        this.f = new AccelerateInterpolator();
        this.h = new float[]{0f, 0f};
        this.i = new float[]{3.402823E+38f, 3.402823E+38f};
        this.l = new float[]{0f, 0f};
        this.m = new float[]{0f, 0f};
        this.n = new float[]{3.402823E+38f, 3.402823E+38f};
        this.b = arg8;
        DisplayMetrics v0 = Resources.getSystem().getDisplayMetrics();
        int v1 = ((int)(1575f * v0.density + 0.5f));
        int v0_1 = ((int)(v0.density * 315f + 0.5f));
        this.a(((float)v1), ((float)v1));
        this.b(((float)v0_1), ((float)v0_1));
        this.a(1);
        this.e(3.402823E+38f, 3.402823E+38f);
        this.d(0.2f, 0.2f);
        this.c(1f, 1f);
        this.b(a.r);
        this.c(500);
        this.d(500);
    }

    public a a(float arg5, float arg6) {
        this.n[0] = arg5 / 1000f;
        this.n[1] = arg6 / 1000f;
        return this;
    }

    public a a(int arg1) {
        this.j = arg1;
        return this;
    }

    static float a(float arg1, float arg2, float arg3) {
        if(arg1 <= arg3) {
            arg3 = arg1 < arg2 ? arg2 : arg1;
        }

        return arg3;
    }

    private float a(float arg5, float arg6, float arg7, float arg8) {
        float v0 = 0f;
        float v1 = a.a(arg5 * arg6, 0f, arg7);
        v1 = this.f(arg6 - arg8, v1) - this.f(arg8, v1);
        if(v1 < 0f) {
            v0 = -this.f.getInterpolation(-v1);
            goto label_12;
        }
        else if(v1 > 0f) {
            v0 = this.f.getInterpolation(v1);
        label_12:
            v0 = a.a(v0, -1f, 1f);
        }

        return v0;
    }

    private float a(int arg6, float arg7, float arg8, float arg9) {
        float v0 = 0f;
        float v1 = this.a(this.h[arg6], arg8, this.i[arg6], arg7);
        if(v1 != 0f) {
            float v2 = this.l[arg6];
            float v3 = this.m[arg6];
            float v4 = this.n[arg6];
            v2 *= arg9;
            v0 = v1 > 0f ? a.a(v1 * v2, v3, v4) : -a.a(-v1 * v2, v3, v4);
        }

        return v0;
    }

    static int a(int arg0, int arg1, int arg2) {
        if(arg0 <= arg2) {
            arg2 = arg0 < arg1 ? arg1 : arg0;
        }

        return arg2;
    }

    public a a(boolean arg2) {
        if((this.p) && !arg2) {
            this.d();
        }

        this.p = arg2;
        return this;
    }

    public abstract void a(int arg1, int arg2);

    boolean a() {
        boolean v0_2;
        android.support.v4.widget.a$a v0 = this.a;
        int v1 = v0.f();
        int v0_1 = v0.e();
        if(v1 == 0 || !this.f(v1)) {
            if(v0_1 != 0 && (this.e(v0_1))) {
            label_9:
                v0_2 = true;
                return v0_2;
            }

            v0_2 = false;
        }
        else {
            goto label_9;
        }

        return v0_2;
    }

    public a b(float arg5, float arg6) {
        this.m[0] = arg5 / 1000f;
        this.m[1] = arg6 / 1000f;
        return this;
    }

    public a b(int arg1) {
        this.k = arg1;
        return this;
    }

    void b() {
        long v0 = SystemClock.uptimeMillis();
        MotionEvent v0_1 = MotionEvent.obtain(v0, v0, 3, 0f, 0f, 0);
        this.b.onTouchEvent(v0_1);
        v0_1.recycle();
    }

    public a c(float arg5, float arg6) {
        this.l[0] = arg5 / 1000f;
        this.l[1] = arg6 / 1000f;
        return this;
    }

    public a c(int arg2) {
        this.a.a(arg2);
        return this;
    }

    private void c() {
        if(this.g == null) {
            this.g = new b(this);
        }

        this.e = true;
        this.c = true;
        if((this.o) || this.k <= 0) {
            this.g.run();
        }
        else {
            p.a(this.b, this.g, ((long)this.k));
        }

        this.o = true;
    }

    public a d(float arg3, float arg4) {
        this.h[0] = arg3;
        this.h[1] = arg4;
        return this;
    }

    public a d(int arg2) {
        this.a.b(arg2);
        return this;
    }

    private void d() {
        if(this.c) {
            this.e = false;
        }
        else {
            this.a.b();
        }
    }

    public a e(float arg3, float arg4) {
        this.i[0] = arg3;
        this.i[1] = arg4;
        return this;
    }

    public abstract boolean e(int arg1);

    private float f(float arg5, float arg6) {
        float v1 = 1f;
        float v0 = 0f;
        if(arg6 != 0f) {
            switch(this.j) {
                case 0: 
                case 1: {
                    goto label_7;
                }
                case 2: {
                    goto label_19;
                }
            }

            return v0;
        label_19:
            if(arg5 < 0f) {
                return arg5 / -arg6;
            label_7:
                if(arg5 < arg6) {
                    if(arg5 >= 0f) {
                        v0 = v1 - arg5 / arg6;
                    }
                    else if((this.e) && this.j == 1) {
                        v0 = v1;
                    }
                }
            }
        }

        return v0;
    }

    public abstract boolean f(int arg1);

    public boolean onTouch(View arg7, MotionEvent arg8) {
        boolean v0 = true;
        boolean v1 = false;
        if(this.p) {
            switch(arg8.getActionMasked()) {
                case 0: {
                    this.d = true;
                    this.o = false;
                    goto label_15;
                }
                case 2: {
                label_15:
                    this.a.a(this.a(0, arg8.getX(), ((float)arg7.getWidth()), ((float)this.b.getWidth())), this.a(1, arg8.getY(), ((float)arg7.getHeight()), ((float)this.b.getHeight())));
                    if(this.e) {
                    }
                    else if(this.a()) {
                        this.c();
                    }
                    else {
                    }

                    break;
                }
                case 1: 
                case 3: {
                    this.d();
                    break;
                }
            }

            if(!this.q || !this.e) {
                v0 = false;
            }

            v1 = v0;
        }

        return v1;
    }
}

