package android.support.constraint.a;

import java.util.Arrays;

public class h {
    public enum a {
        public static final enum a a;
        public static final enum a b;
        public static final enum a c;
        public static final enum a d;
        public static final enum a e;

        static {
            a.a = new a("UNRESTRICTED", 0);
            a.b = new a("CONSTANT", 1);
            a.c = new a("SLACK", 2);
            a.d = new a("ERROR", 3);
            a.e = new a("UNKNOWN", 4);
            a.f = new a[]{a.a, a.b, a.c, a.d, a.e};
        }

        private a(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static a valueOf(String arg1) {
            return Enum.valueOf(a.class, arg1);
        }

        public static a[] values() {
            return a.f.clone();
        }
    }

    public int a;
    int b;
    public int c;
    public float d;
    float[] e;
    a f;
    b[] g;
    int h;
    public int i;
    private static int j;
    private static int k;
    private static int l;
    private static int m;
    private static int n;
    private String o;

    static {
        h.j = 1;
        h.k = 1;
        h.l = 1;
        h.m = 1;
        h.n = 1;
    }

    public h(a arg3, String arg4) {
        super();
        this.a = -1;
        this.b = -1;
        this.c = 0;
        this.e = new float[7];
        this.g = new b[8];
        this.h = 0;
        this.i = 0;
        this.f = arg3;
    }

    public final void a(b arg3) {
        int v0 = 0;
        while(true) {
            if(v0 >= this.h) {
                break;
            }
            else if(this.g[v0] != arg3) {
                ++v0;
                continue;
            }

            return;
        }

        if(this.h >= this.g.length) {
            this.g = Arrays.copyOf(this.g, this.g.length * 2);
        }

        this.g[this.h] = arg3;
        ++this.h;
    }

    public void a(a arg1, String arg2) {
        this.f = arg1;
    }

    static void a() {
        ++h.k;
    }

    public void b() {
        this.o = null;
        this.f = a.e;
        this.c = 0;
        this.a = -1;
        this.b = -1;
        this.d = 0f;
        this.h = 0;
        this.i = 0;
    }

    public final void b(b arg8) {
        int v0 = 0;
        int v2 = this.h;
        int v1 = 0;
        while(true) {
            if(v1 < v2) {
                if(this.g[v1] != arg8) {
                    ++v1;
                    continue;
                }

                break;
            }

            return;
        }

        while(v0 < v2 - v1 - 1) {
            this.g[v1 + v0] = this.g[v1 + v0 + 1];
            ++v0;
        }

        --this.h;
    }

    public final void c(b arg6) {
        int v2 = this.h;
        int v0;
        for(v0 = 0; v0 < v2; ++v0) {
            this.g[v0].d.a(this.g[v0], arg6, false);
        }

        this.h = 0;
    }

    public String toString() {
        return "" + this.o;
    }
}

