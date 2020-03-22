package android.support.v7.view;

import android.support.v4.h.r;
import android.support.v4.h.s;
import android.support.v4.h.t;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class h {
    class android.support.v7.view.h$1 extends t {
        private boolean b;
        private int c;

        android.support.v7.view.h$1(h arg2) {
            this.a = arg2;
            super();
            this.b = false;
            this.c = 0;
        }

        void a() {
            this.c = 0;
            this.b = false;
            this.a.b();
        }

        public void a(View arg3) {
            if(!this.b) {
                this.b = true;
                if(this.a.b != null) {
                    this.a.b.a(null);
                }
            }
        }

        public void b(View arg3) {
            int v0 = this.c + 1;
            this.c = v0;
            if(v0 == this.a.a.size()) {
                if(this.a.b != null) {
                    this.a.b.b(null);
                }

                this.a();
            }
        }
    }

    final ArrayList a;
    s b;
    private long c;
    private Interpolator d;
    private boolean e;
    private final t f;

    public h() {
        super();
        this.c = -1;
        this.f = new android.support.v7.view.h$1(this);
        this.a = new ArrayList();
    }

    public h a(r arg2) {
        if(!this.e) {
            this.a.add(arg2);
        }

        return this;
    }

    public h a(Interpolator arg2) {
        if(!this.e) {
            this.d = arg2;
        }

        return this;
    }

    public h a(long arg2) {
        if(!this.e) {
            this.c = arg2;
        }

        return this;
    }

    public h a(s arg2) {
        if(!this.e) {
            this.b = arg2;
        }

        return this;
    }

    public void a() {
        if(!this.e) {
            Iterator v1 = this.a.iterator();
            while(v1.hasNext()) {
                Object v0 = v1.next();
                if(this.c >= 0) {
                    ((r)v0).a(this.c);
                }

                if(this.d != null) {
                    ((r)v0).a(this.d);
                }

                if(this.b != null) {
                    ((r)v0).a(this.f);
                }

                ((r)v0).c();
            }

            this.e = true;
        }
    }

    public h a(r arg3, r arg4) {
        this.a.add(arg3);
        arg4.b(arg3.a());
        this.a.add(arg4);
        return this;
    }

    void b() {
        this.e = false;
    }

    public void c() {
        if(this.e) {
            Iterator v1 = this.a.iterator();
            while(v1.hasNext()) {
                v1.next().b();
            }

            this.e = false;
        }
    }
}

