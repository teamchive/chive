package android.support.constraint.a.a;

import android.support.constraint.a.e;
import android.support.constraint.a.h;
import java.util.ArrayList;

public class f extends d {
    class android.support.constraint.a.a.f$1 {
        static {
            android.support.constraint.a.a.f$1.a = new int[c.values().length];
            try {
                android.support.constraint.a.a.f$1.a[c.b.ordinal()] = 1;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.f$1.a[c.d.ordinal()] = 2;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.f$1.a[c.c.ordinal()] = 3;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.f$1.a[c.e.ordinal()] = 4;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.f$1.a[c.f.ordinal()] = 5;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.f$1.a[c.g.ordinal()] = 6;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.f$1.a[c.h.ordinal()] = 7;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.f$1.a[c.i.ordinal()] = 8;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.f$1.a[c.a.ordinal()] = 9;
            }
            catch(NoSuchFieldError v0) {
            }
        }
    }

    protected float ab;
    protected int ac;
    protected int ad;
    private android.support.constraint.a.a.c ae;
    private int af;
    private boolean ag;
    private int ah;
    private i ai;
    private int aj;

    public f() {
        int v0 = 0;
        super();
        this.ab = -1f;
        this.ac = -1;
        this.ad = -1;
        this.ae = this.r;
        this.af = 0;
        this.ag = false;
        this.ah = 0;
        this.ai = new i();
        this.aj = 8;
        this.z.clear();
        this.z.add(this.ae);
        int v1 = this.y.length;
        while(v0 < v1) {
            this.y[v0] = this.ae;
            ++v0;
        }
    }

    public ArrayList C() {
        return this.z;
    }

    public int H() {
        return this.af;
    }

    public void a(int arg5) {
        if(this.af != arg5) {
            this.af = arg5;
            this.z.clear();
            this.ae = this.af == 1 ? this.q : this.r;
            this.z.add(this.ae);
            int v1 = this.y.length;
            int v0;
            for(v0 = 0; v0 < v1; ++v0) {
                this.y[v0] = this.ae;
            }
        }
    }

    public android.support.constraint.a.a.c a(c arg3) {
        switch(android.support.constraint.a.a.f$1.a[arg3.ordinal()]) {
            case 1: 
            case 2: {
                goto label_8;
            }
            case 3: 
            case 4: {
                goto label_13;
            }
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                goto label_17;
            }
        }

        goto label_4;
    label_17:
        android.support.constraint.a.a.c v0 = null;
        return v0;
    label_8:
        if(this.af != 1) {
            goto label_4;
        }

        return this.ae;
    label_13:
        if(this.af == 0) {
            return this.ae;
        }

    label_4:
        throw new AssertionError(arg3.name());
    }

    public void a(e arg11) {
        h v1_2;
        android.support.constraint.a.a.c v0_1;
        int v1;
        int v9 = 6;
        int v8 = -1;
        int v7 = 5;
        int v2 = 1;
        d v0 = this.j();
        if(v0 != null) {
            android.support.constraint.a.a.c v5 = ((android.support.constraint.a.a.e)v0).a(c.b);
            android.support.constraint.a.a.c v4 = ((android.support.constraint.a.a.e)v0).a(c.d);
            if(this.B == null) {
                v1 = 0;
            }
            else if(this.B.A[0] == a.b) {
                v1 = 1;
            }
            else {
                v1 = 0;
            }

            if(this.af == 0) {
                android.support.constraint.a.a.c v1_1 = ((android.support.constraint.a.a.e)v0).a(c.c);
                v0_1 = ((android.support.constraint.a.a.e)v0).a(c.e);
                if(this.B == null) {
                    v2 = 0;
                }
                else if(this.B.A[1] != a.b) {
                    v2 = 0;
                }

                v4 = v1_1;
            }
            else {
                v2 = v1;
                v0_1 = v4;
                v4 = v5;
            }

            if(this.ac != v8) {
                v1_2 = arg11.a(this.ae);
                arg11.c(v1_2, arg11.a(v4), this.ac, v9);
                if(v2 == 0) {
                    return;
                }

                arg11.a(arg11.a(v0_1), v1_2, 0, v7);
                return;
            }

            if(this.ad != v8) {
                v1_2 = arg11.a(this.ae);
                h v0_2 = arg11.a(v0_1);
                arg11.c(v1_2, v0_2, -this.ad, v9);
                if(v2 == 0) {
                    return;
                }

                arg11.a(v1_2, arg11.a(v4), 0, v7);
                arg11.a(v0_2, v1_2, 0, v7);
                return;
            }

            if(this.ab == -1f) {
                return;
            }

            arg11.a(e.a(arg11, arg11.a(this.ae), arg11.a(v4), arg11.a(v0_1), this.ab, this.ag));
        }
    }

    public boolean a() {
        return 1;
    }

    public void b(int arg8) {
        int v1;
        float v6 = -1f;
        int v3 = -1;
        d v0 = this.j();
        if(v0 != null) {
            if(this.H() == 1) {
                this.r.a().a(1, v0.r.a(), 0);
                this.t.a().a(1, v0.r.a(), 0);
                if(this.ac != v3) {
                    this.q.a().a(1, v0.q.a(), this.ac);
                    this.s.a().a(1, v0.q.a(), this.ac);
                }
                else if(this.ad != v3) {
                    this.q.a().a(1, v0.s.a(), -this.ad);
                    this.s.a().a(1, v0.s.a(), -this.ad);
                }
                else if(this.ab != v6 && v0.F() == a.a) {
                    v1 = ((int)((((float)v0.C)) * this.ab));
                    this.q.a().a(1, v0.q.a(), v1);
                    this.s.a().a(1, v0.q.a(), v1);
                }
            }
            else {
                this.q.a().a(1, v0.q.a(), 0);
                this.s.a().a(1, v0.q.a(), 0);
                if(this.ac != v3) {
                    this.r.a().a(1, v0.r.a(), this.ac);
                    this.t.a().a(1, v0.r.a(), this.ac);
                }
                else if(this.ad != v3) {
                    this.r.a().a(1, v0.t.a(), -this.ad);
                    this.t.a().a(1, v0.t.a(), -this.ad);
                }
                else if(this.ab != v6 && v0.G() == a.a) {
                    v1 = ((int)((((float)v0.D)) * this.ab));
                    this.r.a().a(1, v0.r.a(), v1);
                    this.t.a().a(1, v0.r.a(), v1);
                }
            }
        }
    }

    public void b(e arg5) {
        if(this.j() != null) {
            int v0 = arg5.b(this.ae);
            if(this.af == 1) {
                this.f(v0);
                this.g(0);
                this.i(this.j().q());
                this.h(0);
            }
            else {
                this.f(0);
                this.g(v0);
                this.h(this.j().o());
                this.i(0);
            }
        }
    }

    public void e(float arg3) {
        int v1 = -1;
        if(arg3 > -1f) {
            this.ab = arg3;
            this.ac = v1;
            this.ad = v1;
        }
    }

    public void q(int arg3) {
        int v1 = -1;
        if(arg3 > v1) {
            this.ab = -1f;
            this.ac = arg3;
            this.ad = v1;
        }
    }

    public void r(int arg3) {
        int v1 = -1;
        if(arg3 > v1) {
            this.ab = -1f;
            this.ac = v1;
            this.ad = arg3;
        }
    }
}

