package android.support.constraint.a;

import java.util.Arrays;
import java.util.HashMap;

public class e {
    interface a {
        h a(e arg1, boolean[] arg2);

        void a(a arg1);

        void d(h arg1);

        void f();

        h g();
    }

    int a;
    b[] b;
    public boolean c;
    int d;
    int e;
    final c f;
    public static f g;
    private static int h;
    private HashMap i;
    private a j;
    private int k;
    private int l;
    private boolean[] m;
    private int n;
    private h[] o;
    private int p;
    private b[] q;
    private final a r;

    static {
        e.h = 1000;
    }

    public e() {
        super();
        this.a = 0;
        this.i = null;
        this.k = 0x20;
        this.l = this.k;
        this.b = null;
        this.c = false;
        this.m = new boolean[this.k];
        this.d = 1;
        this.e = 0;
        this.n = this.k;
        this.o = new h[e.h];
        this.p = 0;
        this.q = new b[this.k];
        this.b = new b[this.k];
        this.i();
        this.f = new c();
        this.j = new d(this.f);
        this.r = new b(this.f);
    }

    public h a(Object arg5) {
        h v0 = null;
        int v3 = -1;
        if(arg5 != null) {
            if(this.d + 1 >= this.l) {
                this.h();
            }

            if(!(arg5 instanceof android.support.constraint.a.a.c)) {
                return v0;
            }

            v0 = arg5.b();
            if(v0 == null) {
                arg5.a(this.f);
                v0 = ((android.support.constraint.a.a.c)arg5).b();
            }

            if(v0.a != v3 && v0.a <= this.a && this.f.c[v0.a] != null) {
                return v0;
            }

            if(v0.a != v3) {
                v0.b();
            }

            ++this.a;
            ++this.d;
            v0.a = this.a;
            v0.f = android.support.constraint.a.h$a.a;
            this.f.c[this.a] = v0;
        }

        return v0;
    }

    public static f a() {
        return e.g;
    }

    public void a(h arg4, h arg5, int arg6, int arg7) {
        b v0 = this.c();
        h v1 = this.d();
        v1.c = 0;
        v0.a(arg4, arg5, v1, arg6);
        if(arg7 != 6) {
            this.a(v0, ((int)(v0.d.b(v1) * -1f)), arg7);
        }

        this.a(v0);
    }

    public void a(h arg4, int arg5) {
        b v0_1;
        int v0 = arg4.b;
        if(arg4.b != -1) {
            v0_1 = this.b[v0];
            if(v0_1.e) {
                v0_1.b = ((float)arg5);
            }
            else if(v0_1.d.a == 0) {
                v0_1.e = true;
                v0_1.b = ((float)arg5);
            }
            else {
                v0_1 = this.c();
                v0_1.b(arg4, arg5);
                this.a(v0_1);
            }
        }
        else {
            v0_1 = this.c();
            v0_1.a(arg4, arg5);
            this.a(v0_1);
        }
    }

    public void a(b arg9) {
        int v0 = 1;
        long v6 = 1;
        if(arg9 != null) {
            if(e.g != null) {
                e.g.f += v6;
                if(arg9.e) {
                    e.g.g += v6;
                }
            }

            if(this.e + 1 >= this.n || this.d + 1 >= this.l) {
                this.h();
            }

            if(!arg9.e) {
                this.c(arg9);
                if(!arg9.e()) {
                    arg9.d();
                    if(arg9.a(this)) {
                        h v1 = this.e();
                        arg9.a = v1;
                        this.d(arg9);
                        this.r.a(((a)arg9));
                        this.a(this.r, true);
                        if(v1.b == -1) {
                            if(arg9.a == v1) {
                                v1 = arg9.b(v1);
                                if(v1 != null) {
                                    if(e.g != null) {
                                        e.g.j += v6;
                                    }

                                    arg9.c(v1);
                                }
                            }

                            if(!arg9.e) {
                                arg9.a.c(arg9);
                            }

                            --this.e;
                        }
                    }
                    else {
                        v0 = 0;
                    }

                    if(!arg9.a()) {
                        return;
                    }
                }
                else {
                    return;
                }
            }
            else {
                v0 = 0;
            }

            if(v0 != 0) {
                return;
            }

            this.d(arg9);
        }
    }

    public void a(h arg10, h arg11, int arg12, float arg13, h arg14, h arg15, int arg16, int arg17) {
        b v1 = this.c();
        v1.a(arg10, arg11, arg12, arg13, arg14, arg15, arg16);
        if(arg17 != 6) {
            v1.a(this, arg17);
        }

        this.a(v1);
    }

    public void a(h arg7, h arg8, h arg9, h arg10, float arg11, int arg12) {
        b v0 = this.c();
        v0.a(arg7, arg8, arg9, arg10, arg11);
        if(arg12 != 6) {
            v0.a(this, arg12);
        }

        this.a(v0);
    }

    public void a(android.support.constraint.a.a.d arg17, android.support.constraint.a.a.d arg18, float arg19, int arg20) {
        h v8 = this.a(arg17.a(android.support.constraint.a.a.c$c.b));
        h v3 = this.a(arg17.a(android.support.constraint.a.a.c$c.c));
        h v9 = this.a(arg17.a(android.support.constraint.a.a.c$c.d));
        h v4 = this.a(arg17.a(android.support.constraint.a.a.c$c.e));
        h v10 = this.a(arg18.a(android.support.constraint.a.a.c$c.b));
        h v5 = this.a(arg18.a(android.support.constraint.a.a.c$c.c));
        h v11 = this.a(arg18.a(android.support.constraint.a.a.c$c.d));
        h v6 = this.a(arg18.a(android.support.constraint.a.a.c$c.e));
        b v2 = this.c();
        v2.b(v3, v4, v5, v6, ((float)(Math.sin(((double)arg19)) * (((double)arg20)))));
        this.a(v2);
        v2 = this.c();
        v2.b(v8, v9, v10, v11, ((float)(Math.cos(((double)arg19)) * (((double)arg20)))));
        this.a(v2);
    }

    public void a(h arg4, h arg5, boolean arg6) {
        b v0 = this.c();
        h v1 = this.d();
        v1.c = 0;
        v0.a(arg4, arg5, v1, 0);
        if(arg6) {
            this.a(v0, ((int)(v0.d.b(v1) * -1f)), 1);
        }

        this.a(v0);
    }

    public static b a(e arg1, h arg2, h arg3, h arg4, float arg5, boolean arg6) {
        b v0 = arg1.c();
        if(arg6) {
            arg1.b(v0);
        }

        return v0.a(arg2, arg3, arg4, arg5);
    }

    public h a(int arg7, String arg8) {
        if(e.g != null) {
            ++e.g.m;
        }

        if(this.d + 1 >= this.l) {
            this.h();
        }

        h v0 = this.a(android.support.constraint.a.h$a.d, arg8);
        ++this.a;
        ++this.d;
        v0.a = this.a;
        v0.c = arg7;
        this.f.c[this.a] = v0;
        this.j.d(v0);
        return v0;
    }

    private final int a(a arg13, boolean arg14) {
        if(e.g != null) {
            ++e.g.h;
        }

        int v4 = 0;
        int v0;
        for(v0 = 0; v0 < this.d; ++v0) {
            this.m[v0] = false;
        }

        for(v0 = 0; v4 == 0; v0 = v5) {
            if(e.g != null) {
                ++e.g.i;
            }

            int v5 = v0 + 1;
            if(v5 >= this.d * 2) {
                return v5;
            }

            if(arg13.g() != null) {
                this.m[arg13.g().a] = true;
            }

            h v6 = arg13.a(this, this.m);
            if(v6 != null) {
                if(this.m[v6.a]) {
                    return v5;
                }
                else {
                    this.m[v6.a] = true;
                }
            }

            if(v6 != null) {
                float v2 = 3.402823E+38f;
                int v1 = -1;
                for(v0 = 0; v0 < this.e; ++v0) {
                    b v3 = this.b[v0];
                    if(v3.a.f != android.support.constraint.a.h$a.a && !v3.e && (v3.a(v6))) {
                        float v7 = v3.d.b(v6);
                        if(v7 < 0f) {
                            float v3_1 = -v3.b / v7;
                            if(v3_1 < v2) {
                                v1 = v0;
                                v2 = v3_1;
                            }
                        }
                    }
                }

                if(v1 > -1) {
                    b v0_1 = this.b[v1];
                    v0_1.a.b = -1;
                    if(e.g != null) {
                        ++e.g.j;
                    }

                    v0_1.c(v6);
                    v0_1.a.b = v1;
                    v0_1.a.c(v0_1);
                    v0 = v4;
                    goto label_37;
                }

                v0 = 1;
            }
            else {
                v0 = 1;
            }

        label_37:
            v4 = v0;
        }

        return v0;
    }

    private h a(android.support.constraint.a.h$a arg5, String arg6) {
        h v1;
        Object v0 = this.f.b.a();
        if(v0 == null) {
            h v0_1 = new h(arg5, arg6);
            v0_1.a(arg5, arg6);
            v1 = v0_1;
        }
        else {
            ((h)v0).b();
            ((h)v0).a(arg5, arg6);
            Object v1_1 = v0;
        }

        if(this.p >= e.h) {
            e.h *= 2;
            this.o = Arrays.copyOf(this.o, e.h);
        }

        h[] v0_2 = this.o;
        int v2 = this.p;
        this.p = v2 + 1;
        v0_2[v2] = v1;
        return v1;
    }

    void a(b arg2, int arg3, int arg4) {
        arg2.c(this.a(arg4, null), arg3);
    }

    void a(a arg7) {
        if(e.g != null) {
            ++e.g.t;
            e.g.u = Math.max(e.g.u, ((long)this.d));
            e.g.v = Math.max(e.g.v, ((long)this.e));
        }

        this.c(arg7);
        this.b(arg7);
        this.a(arg7, false);
        this.j();
    }

    public void b(h arg4, h arg5, int arg6, int arg7) {
        b v0 = this.c();
        h v1 = this.d();
        v1.c = 0;
        v0.b(arg4, arg5, v1, arg6);
        if(arg7 != 6) {
            this.a(v0, ((int)(v0.d.b(v1) * -1f)), arg7);
        }

        this.a(v0);
    }

    public int b(Object arg3) {
        h v0 = ((android.support.constraint.a.a.c)arg3).b();
        int v0_1 = v0 != null ? ((int)(v0.d + 0.5f)) : 0;
        return v0_1;
    }

    public void b(h arg4, h arg5, boolean arg6) {
        b v0 = this.c();
        h v1 = this.d();
        v1.c = 0;
        v0.b(arg4, arg5, v1, 0);
        if(arg6) {
            this.a(v0, ((int)(v0.d.b(v1) * -1f)), 1);
        }

        this.a(v0);
    }

    public void b() {
        int v0;
        for(v0 = 0; v0 < this.f.c.length; ++v0) {
            h v2 = this.f.c[v0];
            if(v2 != null) {
                v2.b();
            }
        }

        this.f.b.a(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.f.c, null);
        if(this.i != null) {
            this.i.clear();
        }

        this.a = 0;
        this.j.f();
        this.d = 1;
        for(v0 = 0; v0 < this.e; ++v0) {
            this.b[v0].c = false;
        }

        this.i();
        this.e = 0;
    }

    private void b(b arg2) {
        arg2.a(this, 0);
    }

    private int b(a arg16) {
        int v8;
        int v0;
        for(v0 = 0; v0 < this.e; ++v0) {
            if(this.b[v0].a.f != android.support.constraint.a.h$a.a && this.b[v0].b < 0f) {
                v0 = 1;
                goto label_19;
            }
        }

        v0 = 0;
    label_19:
        if(v0 != 0) {
            v8 = 0;
            v0 = 0;
            goto label_22;
        }
        else {
            return 0;
        label_22:
            while(v8 == 0) {
                if(e.g != null) {
                    ++e.g.k;
                }

                int v9 = v0 + 1;
                float v4 = 3.402823E+38f;
                int v3 = 0;
                int v2 = -1;
                int v1 = -1;
                for(v0 = 0; v0 < this.e; ++v0) {
                    b v10 = this.b[v0];
                    if(v10.a.f != android.support.constraint.a.h$a.a && !v10.e && v10.b < 0f) {
                        float v5 = v4;
                        int v4_1 = v3;
                        v3 = v2;
                        v2 = v1;
                        for(v1 = 1; v1 < this.d; ++v1) {
                            h v11 = this.f.c[v1];
                            float v12 = v10.d.b(v11);
                            if(v12 > 0f) {
                                float v7 = v5;
                                int v5_1 = 0;
                                while(v5_1 < 7) {
                                    float v6 = v11.e[v5_1] / v12;
                                    if(v6 < v7 && v5_1 == v4_1 || v5_1 > v4_1) {
                                        v2 = v1;
                                        v3 = v0;
                                        v4_1 = v5_1;
                                    }
                                    else {
                                        v6 = v7;
                                    }

                                    ++v5_1;
                                    v7 = v6;
                                }

                                v5 = v7;
                            }
                        }

                        v1 = v2;
                        v2 = v3;
                        v3 = v4_1;
                        v4 = v5;
                    }
                }

                if(v2 != -1) {
                    b v0_1 = this.b[v2];
                    v0_1.a.b = -1;
                    if(e.g != null) {
                        ++e.g.j;
                    }

                    v0_1.c(this.f.c[v1]);
                    v0_1.a.b = v2;
                    v0_1.a.c(v0_1);
                    v0 = v8;
                }
                else {
                    v0 = 1;
                }

                v8 = v0;
                v0 = v9;
            }
        }

        return v0;
    }

    public b c(h arg3, h arg4, int arg5, int arg6) {
        b v0 = this.c();
        v0.a(arg3, arg4, arg5);
        if(arg6 != 6) {
            v0.a(this, arg6);
        }

        this.a(v0);
        return v0;
    }

    public b c() {
        b v0_1;
        Object v0 = this.f.a.a();
        if(v0 == null) {
            v0_1 = new b(this.f);
        }
        else {
            ((b)v0).c();
        }

        h.a();
        return v0_1;
    }

    private final void c(b arg3) {
        if(this.e > 0) {
            arg3.d.a(arg3, this.b);
            if(arg3.d.a == 0) {
                arg3.e = true;
            }
        }
    }

    private final void d(b arg4) {
        if(this.b[this.e] != null) {
            this.f.a.a(this.b[this.e]);
        }

        this.b[this.e] = arg4;
        arg4.a.b = this.e;
        ++this.e;
        arg4.a.c(arg4);
    }

    public h d() {
        if(e.g != null) {
            ++e.g.n;
        }

        if(this.d + 1 >= this.l) {
            this.h();
        }

        h v0 = this.a(android.support.constraint.a.h$a.c, null);
        ++this.a;
        ++this.d;
        v0.a = this.a;
        this.f.c[this.a] = v0;
        return v0;
    }

    public h e() {
        if(e.g != null) {
            ++e.g.o;
        }

        if(this.d + 1 >= this.l) {
            this.h();
        }

        h v0 = this.a(android.support.constraint.a.h$a.c, null);
        ++this.a;
        ++this.d;
        v0.a = this.a;
        this.f.c[this.a] = v0;
        return v0;
    }

    public void f() {
        int v1 = 0;
        long v4 = 1;
        if(e.g != null) {
            e.g.e += v4;
        }

        if(this.c) {
            if(e.g != null) {
                e.g.r += v4;
            }

            int v0 = 0;
            while(true) {
                if(v0 >= this.e) {
                    break;
                }
                else if(this.b[v0].e) {
                    ++v0;
                    continue;
                }

                goto label_24;
            }

            v1 = 1;
        label_24:
            if(v1 == 0) {
                this.a(this.j);
                return;
            }

            if(e.g != null) {
                e.g.q += v4;
            }

            this.j();
        }
        else {
            this.a(this.j);
        }
    }

    public c g() {
        return this.f;
    }

    private void h() {
        this.k *= 2;
        this.b = Arrays.copyOf(this.b, this.k);
        this.f.c = Arrays.copyOf(this.f.c, this.k);
        this.m = new boolean[this.k];
        this.l = this.k;
        this.n = this.k;
        if(e.g != null) {
            ++e.g.d;
            e.g.p = Math.max(e.g.p, ((long)this.k));
            e.g.D = e.g.p;
        }
    }

    private void i() {
        int v0;
        for(v0 = 0; v0 < this.b.length; ++v0) {
            b v1 = this.b[v0];
            if(v1 != null) {
                this.f.a.a(v1);
            }

            this.b[v0] = null;
        }
    }

    private void j() {
        int v0;
        for(v0 = 0; v0 < this.e; ++v0) {
            this.b[v0].a.d = this.b[v0].b;
        }
    }
}

