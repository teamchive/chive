package android.support.constraint.a.a;

import java.util.Arrays;

public class e extends n {
    protected android.support.constraint.a.e ab;
    int ac;
    int ad;
    int ae;
    int af;
    int ag;
    int ah;
    d[] ai;
    d[] aj;
    int ak;
    private boolean am;
    private m an;
    private int ao;
    private boolean ap;
    private boolean aq;

    public e() {
        super();
        this.am = false;
        this.ab = new android.support.constraint.a.e();
        this.ag = 0;
        this.ah = 0;
        this.ai = new d[4];
        this.aj = new d[4];
        this.ao = 3;
        this.ap = false;
        this.aq = false;
        this.ak = 0;
    }

    public int H() {
        return this.ao;
    }

    public boolean I() {
        return this.ap;
    }

    public boolean J() {
        return this.aq;
    }

    public boolean K() {
        return this.am;
    }

    public void L() {
        Object v1;
        int v8 = this.G;
        int v9 = this.H;
        int v10 = Math.max(0, this.o());
        int v11 = Math.max(0, this.q());
        this.ap = false;
        this.aq = false;
        if(this.B != null) {
            if(this.an == null) {
                this.an = new m(this);
            }

            this.an.a(this);
            this.f(this.ac);
            this.g(this.ad);
            this.E();
            this.a(this.ab.g());
        }
        else {
            this.G = 0;
            this.H = 0;
        }

        if(this.ao != 0) {
            if(!this.q(8)) {
                this.O();
            }

            this.P();
            this.ab.c = true;
        }
        else {
            this.ab.c = false;
        }

        int v3 = 0;
        a v12 = this.A[1];
        a v13 = this.A[0];
        this.T();
        int v14 = this.al.size();
        int v2;
        for(v2 = 0; v2 < v14; ++v2) {
            v1 = this.al.get(v2);
            if((v1 instanceof n)) {
                ((n)v1).L();
            }
        }

        v2 = 1;
        int v1_1;
        for(v1_1 = 0; v2 != 0; v1_1 = v7) {
            int v7 = v1_1 + 1;
            try {
                this.ab.b();
                boolean v2_1 = this.c(this.ab);
                if(!v2_1) {
                    goto label_110;
                }

                this.ab.f();
            }
            catch(Exception v1_2) {
                v1_2.printStackTrace();
                System.out.println("EXCEPTION : " + v1_2);
            }

        label_110:
            if(v2_1) {
                this.a(this.ab, h.a);
            }
            else {
                this.b(this.ab);
                for(v2 = 0; v2 < v14; ++v2) {
                    v1 = this.al.get(v2);
                    if(((d)v1).A[0] == a.c && ((d)v1).o() < ((d)v1).p()) {
                        h.a[2] = true;
                        break;
                    }

                    if(((d)v1).A[1] == a.c && ((d)v1).q() < ((d)v1).r()) {
                        h.a[2] = true;
                        break;
                    }
                }
            }

            if(v7 >= 8 || !h.a[2]) {
                v1_1 = 0;
                v2 = v3;
            }
            else {
                int v6 = 0;
                int v5 = 0;
                int v4;
                for(v4 = 0; v4 < v14; ++v4) {
                    v1 = this.al.get(v4);
                    v6 = Math.max(v6, ((d)v1).G + ((d)v1).o());
                    v5 = Math.max(v5, ((d)v1).q() + ((d)v1).H);
                }

                v1_1 = Math.max(this.L, v6);
                v4 = Math.max(this.M, v5);
                if(v13 != a.b || this.o() >= v1_1) {
                    v1_1 = 0;
                    v2 = v3;
                }
                else {
                    this.h(v1_1);
                    this.A[0] = a.b;
                    v2 = 1;
                    v1_1 = 1;
                }

                if(v12 != a.b) {
                    goto label_226;
                }

                if(this.q() >= v4) {
                    goto label_226;
                }

                this.i(v4);
                this.A[1] = a.b;
                v2 = 1;
                v1_1 = 1;
            }

        label_226:
            v3 = Math.max(this.L, this.o());
            if(v3 > this.o()) {
                this.h(v3);
                this.A[0] = a.a;
                v2 = 1;
                v1_1 = 1;
            }

            v3 = Math.max(this.M, this.q());
            if(v3 > this.q()) {
                this.i(v3);
                this.A[1] = a.a;
                v2 = 1;
                v1_1 = 1;
            }

            if(v2 == 0) {
                if(this.A[0] == a.b && v10 > 0 && this.o() > v10) {
                    this.ap = true;
                    v2 = 1;
                    this.A[0] = a.a;
                    this.h(v10);
                    v1_1 = 1;
                }

                if(this.A[1] != a.b) {
                    goto label_299;
                }

                if(v11 <= 0) {
                    goto label_299;
                }

                if(this.q() <= v11) {
                    goto label_299;
                }

                this.aq = true;
                v2 = 1;
                this.A[1] = a.a;
                this.i(v11);
                v1_1 = 1;
            }

        label_299:
            v3 = v2;
            v2 = v1_1;
        }

        if(this.B != null) {
            v1_1 = Math.max(this.L, this.o());
            v2 = Math.max(this.M, this.q());
            this.an.b(this);
            this.h(v1_1 + this.ac + this.ae);
            this.i(this.ad + v2 + this.af);
        }
        else {
            this.G = v8;
            this.H = v9;
        }

        if(v3 != 0) {
            this.A[0] = v13;
            this.A[1] = v12;
        }

        this.a(this.ab.g());
        if(this == this.R()) {
            this.D();
        }
    }

    public void M() {
        this.O();
        this.b(this.ao);
    }

    public void N() {
        j v0 = this.a(c.b).a();
        j v1 = this.a(c.c).a();
        v0.a(null, 0f);
        v1.a(null, 0f);
    }

    public void O() {
        int v2 = this.al.size();
        this.b();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            this.al.get(v1).b();
        }
    }

    public void P() {
        if(!this.q(8)) {
            this.b(this.ao);
        }

        this.N();
    }

    public boolean Q() {
        return 0;
    }

    private void T() {
        this.ag = 0;
        this.ah = 0;
    }

    public void a(int arg1) {
        this.ao = arg1;
    }

    public void a(boolean arg1) {
        this.am = arg1;
    }

    void a(d arg3, int arg4) {
        if(arg4 == 0) {
            while(arg3.q.c != null) {
                if(arg3.q.c.a.s.c == null) {
                    break;
                }

                if(arg3.q.c.a.s.c != arg3.q) {
                    break;
                }

                if(arg3.q.c.a == arg3) {
                    break;
                }

                arg3 = arg3.q.c.a;
            }

            this.d(arg3);
        }
        else {
            if(arg4 != 1) {
                return;
            }

            while(arg3.r.c != null) {
                if(arg3.r.c.a.t.c == null) {
                    break;
                }

                if(arg3.r.c.a.t.c != arg3.r) {
                    break;
                }

                if(arg3.r.c.a == arg3) {
                    break;
                }

                arg3 = arg3.r.c.a;
            }

            this.e(arg3);
        }
    }

    public void a(android.support.constraint.a.e arg9, boolean[] arg10) {
        int v7 = 2;
        arg10[v7] = false;
        this.b(arg9);
        int v3 = this.al.size();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            Object v0 = this.al.get(v1);
            ((d)v0).b(arg9);
            if(((d)v0).A[0] == a.c && ((d)v0).o() < ((d)v0).p()) {
                arg10[v7] = true;
            }

            if(((d)v0).A[1] == a.c && ((d)v0).q() < ((d)v0).r()) {
                arg10[v7] = true;
            }
        }
    }

    public void b(int arg4) {
        super.b(arg4);
        int v2 = this.al.size();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            this.al.get(v1).b(arg4);
        }
    }

    public boolean c(android.support.constraint.a.e arg9) {
        this.a(arg9);
        int v3 = this.al.size();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            Object v0 = this.al.get(v1);
            if((v0 instanceof e)) {
                a v4 = ((d)v0).A[0];
                a v5 = ((d)v0).A[1];
                if(v4 == a.b) {
                    ((d)v0).a(a.a);
                }

                if(v5 == a.b) {
                    ((d)v0).b(a.a);
                }

                ((d)v0).a(arg9);
                if(v4 == a.b) {
                    ((d)v0).a(v4);
                }

                if(v5 != a.b) {
                    goto label_30;
                }

                ((d)v0).b(v5);
            }
            else {
                h.a(this, arg9, ((d)v0));
                ((d)v0).a(arg9);
            }

        label_30:
        }

        if(this.ag > 0) {
            b.a(this, arg9, 0);
        }

        if(this.ah > 0) {
            b.a(this, arg9, 1);
        }

        return 1;
    }

    private void d(d arg3) {
        int v0 = 0;
        while(true) {
            if(v0 >= this.ag) {
                break;
            }
            else if(this.aj[v0] != arg3) {
                ++v0;
                continue;
            }

            return;
        }

        if(this.ag + 1 >= this.aj.length) {
            this.aj = Arrays.copyOf(this.aj, this.aj.length * 2);
        }

        this.aj[this.ag] = arg3;
        ++this.ag;
    }

    public void e(int arg3, int arg4) {
        if(this.A[0] != a.b && this.c != null) {
            this.c.a(arg3);
        }

        if(this.A[1] != a.b && this.d != null) {
            this.d.a(arg4);
        }
    }

    private void e(d arg3) {
        int v0 = 0;
        while(true) {
            if(v0 >= this.ah) {
                break;
            }
            else if(this.ai[v0] != arg3) {
                ++v0;
                continue;
            }

            return;
        }

        if(this.ah + 1 >= this.ai.length) {
            this.ai = Arrays.copyOf(this.ai, this.ai.length * 2);
        }

        this.ai[this.ah] = arg3;
        ++this.ah;
    }

    public void f() {
        this.ab.b();
        this.ac = 0;
        this.ae = 0;
        this.ad = 0;
        this.af = 0;
        super.f();
    }

    public boolean q(int arg2) {
        boolean v0 = (this.ao & arg2) == arg2 ? true : false;
        return v0;
    }
}

