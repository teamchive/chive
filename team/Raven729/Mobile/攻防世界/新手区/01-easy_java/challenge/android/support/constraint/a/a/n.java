package android.support.constraint.a.a;

import android.support.constraint.a.c;
import java.util.ArrayList;

public class n extends d {
    protected ArrayList al;

    public n() {
        super();
        this.al = new ArrayList();
    }

    public void D() {
        super.D();
        if(this.al != null) {
            int v2 = this.al.size();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                Object v0 = this.al.get(v1);
                ((d)v0).b(this.s(), this.t());
                if(!(v0 instanceof e)) {
                    ((d)v0).D();
                }
            }
        }
    }

    public void L() {
        this.D();
        if(this.al != null) {
            int v2 = this.al.size();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                Object v0 = this.al.get(v1);
                if((v0 instanceof n)) {
                    ((n)v0).L();
                }
            }
        }
    }

    public e R() {
        d v0_1;
        d v1 = ((d)this).j();
        n v0 = null;
        if((this instanceof e)) {
            v0_1 = v1;
        }
        else {
            this = v0;
            v0_1 = v1;
        }

        while(v0_1 != null) {
            v1 = v0_1.j();
            if((v0_1 instanceof e)) {
                d v3 = v0_1;
                v0_1 = v1;
                continue;
            }

            v0_1 = v1;
        }

        return this;
    }

    public void S() {
        this.al.clear();
    }

    public void a(c arg4) {
        super.a(arg4);
        int v2 = this.al.size();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            this.al.get(v1).a(arg4);
        }
    }

    public void b(int arg6, int arg7) {
        super.b(arg6, arg7);
        int v2 = this.al.size();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            this.al.get(v1).b(this.u(), this.v());
        }
    }

    public void b(d arg2) {
        this.al.add(arg2);
        if(arg2.j() != null) {
            arg2.j().c(arg2);
        }

        arg2.a(((d)this));
    }

    public void c(d arg2) {
        this.al.remove(arg2);
        arg2.a(null);
    }

    public void f() {
        this.al.clear();
        super.f();
    }
}

