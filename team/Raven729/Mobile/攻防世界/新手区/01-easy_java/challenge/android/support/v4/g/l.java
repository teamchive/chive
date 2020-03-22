package android.support.v4.g;

public class l implements Cloneable {
    private static final Object a;
    private boolean b;
    private int[] c;
    private Object[] d;
    private int e;

    static {
        l.a = new Object();
    }

    public l(int arg4) {
        super();
        this.b = false;
        if(arg4 == 0) {
            this.c = c.a;
            this.d = c.c;
        }
        else {
            int v0 = c.a(arg4);
            this.c = new int[v0];
            this.d = new Object[v0];
        }

        this.e = 0;
    }

    public l() {
        this(10);
    }

    public Object a(int arg2) {
        return this.a(arg2, null);
    }

    public l a() {
        int[] v0_2;
        Object v0_1;
        int[] v1 = null;
        try {
            v0_1 = super.clone();
        }
        catch(CloneNotSupportedException v0) {
            goto label_10;
        }

        try {
            v1 = this.c;
            goto label_3;
        }
        catch(CloneNotSupportedException v1_1) {
        }
        catch(CloneNotSupportedException v0) {
        label_10:
            v0_2 = v1;
            goto label_8;
            try {
            label_3:
                ((l)v0_1).c = v1.clone();
                ((l)v0_1).d = this.d.clone();
            }
            catch(CloneNotSupportedException v1_1) {
            }
        }

    label_8:
        return ((l)v0_2);
    }

    public Object a(int arg4, Object arg5) {
        int v0 = c.a(this.c, this.e, arg4);
        if(v0 >= 0 && this.d[v0] != l.a) {
            arg5 = this.d[v0];
        }

        return arg5;
    }

    public void b(int arg7, Object arg8) {
        int v0 = c.a(this.c, this.e, arg7);
        if(v0 >= 0) {
            this.d[v0] = arg8;
        }
        else {
            v0 ^= -1;
            if(v0 < this.e && this.d[v0] == l.a) {
                this.c[v0] = arg7;
                this.d[v0] = arg8;
                return;
            }

            if((this.b) && this.e >= this.c.length) {
                this.d();
                v0 = c.a(this.c, this.e, arg7) ^ -1;
            }

            if(this.e >= this.c.length) {
                int v1 = c.a(this.e + 1);
                int[] v2 = new int[v1];
                Object[] v1_1 = new Object[v1];
                System.arraycopy(this.c, 0, v2, 0, this.c.length);
                System.arraycopy(this.d, 0, v1_1, 0, this.d.length);
                this.c = v2;
                this.d = v1_1;
            }

            if(this.e - v0 != 0) {
                System.arraycopy(this.c, v0, this.c, v0 + 1, this.e - v0);
                System.arraycopy(this.d, v0, this.d, v0 + 1, this.e - v0);
            }

            this.c[v0] = arg7;
            this.d[v0] = arg8;
            ++this.e;
        }
    }

    public int b() {
        if(this.b) {
            this.d();
        }

        return this.e;
    }

    public void b(int arg4) {
        int v0 = c.a(this.c, this.e, arg4);
        if(v0 >= 0 && this.d[v0] != l.a) {
            this.d[v0] = l.a;
            this.b = true;
        }
    }

    public void c(int arg1) {
        this.b(arg1);
    }

    public void c() {
        int v2 = this.e;
        Object[] v3 = this.d;
        int v0;
        for(v0 = 0; v0 < v2; ++v0) {
            v3[v0] = null;
        }

        this.e = 0;
        this.b = false;
    }

    public void c(int arg7, Object arg8) {
        if(this.e == 0 || arg7 > this.c[this.e - 1]) {
            if((this.b) && this.e >= this.c.length) {
                this.d();
            }

            int v0 = this.e;
            if(v0 >= this.c.length) {
                int v1 = c.a(v0 + 1);
                int[] v2 = new int[v1];
                Object[] v1_1 = new Object[v1];
                System.arraycopy(this.c, 0, v2, 0, this.c.length);
                System.arraycopy(this.d, 0, v1_1, 0, this.d.length);
                this.c = v2;
                this.d = v1_1;
            }

            this.c[v0] = arg7;
            this.d[v0] = arg8;
            this.e = v0 + 1;
        }
        else {
            this.b(arg7, arg8);
        }
    }

    public Object clone() {
        return this.a();
    }

    public int d(int arg2) {
        if(this.b) {
            this.d();
        }

        return this.c[arg2];
    }

    private void d() {
        int v3 = this.e;
        int[] v4 = this.c;
        Object[] v5 = this.d;
        int v1 = 0;
        int v0 = 0;
        while(v1 < v3) {
            Object v6 = v5[v1];
            if(v6 != l.a) {
                if(v1 != v0) {
                    v4[v0] = v4[v1];
                    v5[v0] = v6;
                    v5[v1] = null;
                }

                ++v0;
            }

            ++v1;
        }

        this.b = false;
        this.e = v0;
    }

    public Object e(int arg2) {
        if(this.b) {
            this.d();
        }

        return this.d[arg2];
    }

    public String toString() {
        String v0;
        if(this.b() <= 0) {
            v0 = "{}";
        }
        else {
            StringBuilder v1 = new StringBuilder(this.e * 28);
            v1.append('{');
            int v0_1;
            for(v0_1 = 0; v0_1 < this.e; ++v0_1) {
                if(v0_1 > 0) {
                    v1.append(", ");
                }

                v1.append(this.d(v0_1));
                v1.append('=');
                Object v2 = this.e(v0_1);
                if((((l)v2)) != this) {
                    v1.append(v2);
                }
                else {
                    v1.append("(this Map)");
                }
            }

            v1.append('}');
            v0 = v1.toString();
        }

        return v0;
    }
}

