package android.support.constraint.a.a;

import java.util.HashSet;
import java.util.Iterator;

public class l {
    HashSet h;
    int i;

    public l() {
        super();
        this.h = new HashSet(2);
        this.i = 0;
    }

    public void a() {
    }

    public void a(l arg2) {
        this.h.add(arg2);
    }

    public void b() {
        this.i = 0;
        this.h.clear();
    }

    public void e() {
        this.i = 0;
        Iterator v1 = this.h.iterator();
        while(v1.hasNext()) {
            v1.next().e();
        }
    }

    public void f() {
        this.i = 1;
        Iterator v1 = this.h.iterator();
        while(v1.hasNext()) {
            v1.next().a();
        }
    }

    public boolean g() {
        boolean v0 = true;
        if(this.i != 1) {
            v0 = false;
        }

        return v0;
    }
}

