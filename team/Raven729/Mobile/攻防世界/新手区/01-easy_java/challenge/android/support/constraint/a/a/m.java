package android.support.constraint.a.a;

import java.util.ArrayList;

public class m {
    class a {
        private c a;
        private c b;
        private int c;
        private b d;
        private int e;

        public a(c arg2) {
            super();
            this.a = arg2;
            this.b = arg2.g();
            this.c = arg2.e();
            this.d = arg2.f();
            this.e = arg2.h();
        }

        public void a(d arg3) {
            this.a = arg3.a(this.a.d());
            if(this.a != null) {
                this.b = this.a.g();
                this.c = this.a.e();
                this.d = this.a.f();
                this.e = this.a.h();
            }
            else {
                this.b = null;
                this.c = 0;
                this.d = b.b;
                this.e = 0;
            }
        }

        public void b(d arg6) {
            arg6.a(this.a.d()).a(this.b, this.c, this.d, this.e);
        }
    }

    private int a;
    private int b;
    private int c;
    private int d;
    private ArrayList e;

    public m(d arg7) {
        super();
        this.e = new ArrayList();
        this.a = arg7.m();
        this.b = arg7.n();
        this.c = arg7.o();
        this.d = arg7.q();
        ArrayList v2 = arg7.C();
        int v3 = v2.size();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            this.e.add(new a(v2.get(v1)));
        }
    }

    public void a(d arg4) {
        this.a = arg4.m();
        this.b = arg4.n();
        this.c = arg4.o();
        this.d = arg4.q();
        int v2 = this.e.size();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            this.e.get(v1).a(arg4);
        }
    }

    public void b(d arg4) {
        arg4.f(this.a);
        arg4.g(this.b);
        arg4.h(this.c);
        arg4.i(this.d);
        int v2 = this.e.size();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            this.e.get(v1).b(arg4);
        }
    }
}

