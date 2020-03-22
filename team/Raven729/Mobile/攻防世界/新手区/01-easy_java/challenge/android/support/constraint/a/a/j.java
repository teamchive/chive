package android.support.constraint.a.a;

import android.support.constraint.a.e;
import android.support.constraint.a.f;
import android.support.constraint.a.h;

public class j extends l {
    c a;
    float b;
    j c;
    float d;
    j e;
    float f;
    int g;
    private j j;
    private float k;
    private k l;
    private int m;
    private k n;
    private int o;

    public j(c arg4) {
        super();
        this.g = 0;
        this.l = null;
        this.m = 1;
        this.n = null;
        this.o = 1;
        this.a = arg4;
    }

    void a(e arg5) {
        h v0 = this.a.b();
        if(this.e == null) {
            arg5.a(v0, ((int)this.f));
        }
        else {
            arg5.c(v0, arg5.a(this.e.a), ((int)this.f), 6);
        }
    }

    public void a(j arg3, float arg4) {
        if(this.i == 0 || this.e != arg3 && this.f != arg4) {
            this.e = arg3;
            this.f = arg4;
            if(this.i == 1) {
                this.e();
            }

            this.f();
        }
    }

    public void a(int arg2, j arg3, int arg4) {
        this.g = arg2;
        this.c = arg3;
        this.d = ((float)arg4);
        this.c.a(((l)this));
    }

    public void a(j arg2, int arg3, k arg4) {
        this.c = arg2;
        this.c.a(((l)this));
        this.l = arg4;
        this.m = arg3;
        this.l.a(((l)this));
    }

    public void a(j arg2, int arg3) {
        this.c = arg2;
        this.d = ((float)arg3);
        this.c.a(((l)this));
    }

    String a(int arg2) {
        String v0;
        if(arg2 == 1) {
            v0 = "DIRECT";
        }
        else if(arg2 == 2) {
            v0 = "CENTER";
        }
        else if(arg2 == 3) {
            v0 = "MATCH";
        }
        else if(arg2 == 4) {
            v0 = "CHAIN";
        }
        else if(arg2 == 5) {
            v0 = "BARRIER";
        }
        else {
            v0 = "UNCONNECTED";
        }

        return v0;
    }

    public void a() {
        int v0_2;
        float v3_1;
        float v1;
        f v0;
        long v10 = 1;
        int v2 = 0;
        float v8 = 1f;
        if(this.i != 1 && this.g != 4) {
            if(this.l != null) {
                if(this.l.i == 1) {
                    this.d = (((float)this.m)) * this.l.a;
                }
                else {
                    return;
                }
            }

            if(this.n != null) {
                if(this.n.i == 1) {
                    this.k = (((float)this.o)) * this.n.a;
                }
                else {
                    return;
                }
            }

            if(this.g == 1 && (this.c == null || this.c.i == 1)) {
                if(this.c == null) {
                    this.e = this;
                    this.f = this.d;
                }
                else {
                    this.e = this.c.e;
                    this.f = this.c.f + this.d;
                }

                this.f();
                return;
            }

            if(this.g == 2 && this.c != null && this.c.i == 1 && this.j != null && this.j.c != null && this.j.c.i == 1) {
                if(e.a() != null) {
                    v0 = e.a();
                    v0.w += v10;
                }

                this.e = this.c.e;
                this.j.e = this.j.c.e;
                float v0_1 = this.k > 0f ? this.c.f - this.j.c.f : this.j.c.f - this.c.f;
                if(this.a.b == android.support.constraint.a.a.c$c.b || this.a.b == android.support.constraint.a.a.c$c.d) {
                    v1 = v0_1 - (((float)this.a.a.o()));
                    v0_1 = this.a.a.O;
                }
                else {
                    v1 = v0_1 - (((float)this.a.a.q()));
                    v0_1 = this.a.a.P;
                }

                int v4 = this.a.e();
                int v3 = this.j.a.e();
                if(this.a.g() == this.j.a.g()) {
                    v3_1 = 0.5f;
                    v0_2 = 0;
                }
                else {
                    v2 = v4;
                    int v12 = v3;
                    v3_1 = v0_1;
                    v0_2 = v12;
                }

                v1 = v1 - (((float)v2)) - (((float)v0_2));
                if(this.k > 0f) {
                    this.j.f = (((float)v0_2)) + this.j.c.f + v1 * v3_1;
                    this.f = this.c.f - (((float)v2)) - v1 * (v8 - v3_1);
                }
                else {
                    this.f = (((float)v2)) + this.c.f + v1 * v3_1;
                    this.j.f = this.j.c.f - (((float)v0_2)) - v1 * (v8 - v3_1);
                }

                this.f();
                this.j.f();
                return;
            }

            if(this.g == 3 && this.c != null && this.c.i == 1 && this.j != null && this.j.c != null && this.j.c.i == 1) {
                if(e.a() != null) {
                    v0 = e.a();
                    v0.x += v10;
                }

                this.e = this.c.e;
                this.j.e = this.j.c.e;
                this.f = this.c.f + this.d;
                this.j.f = this.j.c.f + this.j.d;
                this.f();
                this.j.f();
                return;
            }

            if(this.g != 5) {
                return;
            }

            this.a.a.c();
        }
    }

    public void b() {
        super.b();
        this.c = null;
        this.d = 0f;
        this.l = null;
        this.m = 1;
        this.n = null;
        this.o = 1;
        this.e = null;
        this.f = 0f;
        this.b = 0f;
        this.j = null;
        this.k = 0f;
        this.g = 0;
    }

    public void b(int arg1) {
        this.g = arg1;
    }

    public void b(j arg1, int arg2, k arg3) {
        this.j = arg1;
        this.n = arg3;
        this.o = arg2;
    }

    public void b(j arg1, float arg2) {
        this.j = arg1;
        this.k = arg2;
    }

    public void c() {
        int v3 = 4;
        c v1 = this.a.g();
        if(v1 != null) {
            if(v1.g() == this.a) {
                this.g = v3;
                v1.a().g = v3;
            }

            int v0 = this.a.e();
            if(this.a.b == android.support.constraint.a.a.c$c.d || this.a.b == android.support.constraint.a.a.c$c.e) {
                v0 = -v0;
            }

            this.a(v1.a(), v0);
        }
    }

    public float d() {
        return this.f;
    }

    public String toString() {
        String v0;
        if(this.i != 1) {
            v0 = "{ " + this.a + " UNRESOLVED} type: " + this.a(this.g);
        }
        else if(this.e == this) {
            v0 = "[" + this.a + ", RESOLVED: " + this.f + "]  type: " + this.a(this.g);
        }
        else {
            v0 = "[" + this.a + ", RESOLVED: " + this.e + ":" + this.f + "] type: " + this.a(this.g);
        }

        return v0;
    }
}

