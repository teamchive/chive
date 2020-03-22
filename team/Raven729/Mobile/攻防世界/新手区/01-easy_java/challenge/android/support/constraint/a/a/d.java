package android.support.constraint.a.a;

import android.support.constraint.a.f;
import android.support.constraint.a.h;
import java.util.ArrayList;

public class d {
    class android.support.constraint.a.a.d$1 {
        static {
            android.support.constraint.a.a.d$1.b = new int[a.values().length];
            try {
                android.support.constraint.a.a.d$1.b[a.a.ordinal()] = 1;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.d$1.b[a.b.ordinal()] = 2;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.d$1.b[a.d.ordinal()] = 3;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.d$1.b[a.c.ordinal()] = 4;
            }
            catch(NoSuchFieldError v0) {
            }

            android.support.constraint.a.a.d$1.a = new int[c.values().length];
            try {
                android.support.constraint.a.a.d$1.a[c.b.ordinal()] = 1;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.d$1.a[c.c.ordinal()] = 2;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.d$1.a[c.d.ordinal()] = 3;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.d$1.a[c.e.ordinal()] = 4;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.d$1.a[c.f.ordinal()] = 5;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.d$1.a[c.g.ordinal()] = 6;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.d$1.a[c.h.ordinal()] = 7;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.d$1.a[c.i.ordinal()] = 8;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.d$1.a[c.a.ordinal()] = 9;
            }
            catch(NoSuchFieldError v0) {
            }
        }
    }

    public enum a {
        public static final enum a a;
        public static final enum a b;
        public static final enum a c;
        public static final enum a d;

        static {
            a.a = new a("FIXED", 0);
            a.b = new a("WRAP_CONTENT", 1);
            a.c = new a("MATCH_CONSTRAINT", 2);
            a.d = new a("MATCH_PARENT", 3);
            a.e = new a[]{a.a, a.b, a.c, a.d};
        }

        private a(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static a valueOf(String arg1) {
            return Enum.valueOf(a.class, arg1);
        }

        public static a[] values() {
            return a.e.clone();
        }
    }

    protected a[] A;
    d B;
    int C;
    int D;
    protected float E;
    protected int F;
    protected int G;
    protected int H;
    protected int I;
    protected int J;
    int K;
    protected int L;
    protected int M;
    public static float N;
    float O;
    float P;
    boolean Q;
    boolean R;
    int S;
    int T;
    boolean U;
    boolean V;
    float[] W;
    protected d[] X;
    protected d[] Y;
    d Z;
    public int a;
    d aa;
    private int[] ab;
    private float ac;
    private int ad;
    private int ae;
    private int af;
    private int ag;
    private int ah;
    private int ai;
    private Object aj;
    private int ak;
    private int al;
    private String am;
    private String an;
    public int b;
    k c;
    k d;
    int e;
    int f;
    int g;
    int h;
    float i;
    int j;
    int k;
    float l;
    boolean m;
    boolean n;
    int o;
    float p;
    android.support.constraint.a.a.c q;
    android.support.constraint.a.a.c r;
    android.support.constraint.a.a.c s;
    android.support.constraint.a.a.c t;
    android.support.constraint.a.a.c u;
    android.support.constraint.a.a.c v;
    android.support.constraint.a.a.c w;
    android.support.constraint.a.a.c x;
    protected android.support.constraint.a.a.c[] y;
    protected ArrayList z;

    static {
        d.N = 0.5f;
    }

    public d() {
        super();
        this.a = -1;
        this.b = -1;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 1f;
        this.j = 0;
        this.k = 0;
        this.l = 1f;
        this.o = -1;
        this.p = 1f;
        this.ab = new int[]{0x7FFFFFFF, 0x7FFFFFFF};
        this.ac = 0f;
        this.q = new android.support.constraint.a.a.c(this, c.b);
        this.r = new android.support.constraint.a.a.c(this, c.c);
        this.s = new android.support.constraint.a.a.c(this, c.d);
        this.t = new android.support.constraint.a.a.c(this, c.e);
        this.u = new android.support.constraint.a.a.c(this, c.f);
        this.v = new android.support.constraint.a.a.c(this, c.h);
        this.w = new android.support.constraint.a.a.c(this, c.i);
        this.x = new android.support.constraint.a.a.c(this, c.g);
        this.y = new android.support.constraint.a.a.c[]{this.q, this.s, this.r, this.t, this.u, this.x};
        this.z = new ArrayList();
        this.A = new a[]{a.a, a.a};
        this.B = null;
        this.C = 0;
        this.D = 0;
        this.E = 0f;
        this.F = -1;
        this.G = 0;
        this.H = 0;
        this.ad = 0;
        this.ae = 0;
        this.af = 0;
        this.ag = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.O = d.N;
        this.P = d.N;
        this.ak = 0;
        this.al = 0;
        this.am = null;
        this.an = null;
        this.S = 0;
        this.T = 0;
        this.W = new float[]{0f, 0f};
        this.X = new d[]{null, null};
        this.Y = new d[]{null, null};
        this.Z = null;
        this.aa = null;
        this.H();
    }

    public int A() {
        return this.K;
    }

    public Object B() {
        return this.aj;
    }

    public ArrayList C() {
        return this.z;
    }

    public void D() {
        int v0 = this.G;
        int v1 = this.H;
        int v2 = this.G + this.C;
        int v3 = this.H + this.D;
        this.ad = v0;
        this.ae = v1;
        this.af = v2 - v0;
        this.ag = v3 - v1;
    }

    public void E() {
        d v0 = this.j();
        if(v0 == null || !(v0 instanceof e) || !this.j().Q()) {
            int v2 = this.z.size();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                this.z.get(v1).i();
            }
        }
    }

    public a F() {
        return this.A[0];
    }

    public a G() {
        return this.A[1];
    }

    private void H() {
        this.z.add(this.q);
        this.z.add(this.r);
        this.z.add(this.s);
        this.z.add(this.t);
        this.z.add(this.v);
        this.z.add(this.w);
        this.z.add(this.x);
        this.z.add(this.u);
    }

    public android.support.constraint.a.a.c a(c arg3) {
        switch(android.support.constraint.a.a.d$1.a[arg3.ordinal()]) {
            case 1: {
                goto label_8;
            }
            case 2: {
                goto label_10;
            }
            case 3: {
                goto label_12;
            }
            case 4: {
                goto label_14;
            }
            case 5: {
                goto label_16;
            }
            case 6: {
                goto label_22;
            }
            case 7: {
                goto label_18;
            }
            case 8: {
                goto label_20;
            }
            case 9: {
                return null;
            }
        }

        throw new AssertionError(arg3.name());
    label_18:
        android.support.constraint.a.a.c v0 = this.v;
        return v0;
    label_20:
        return this.w;
    label_22:
        return this.x;
    label_8:
        return this.q;
    label_10:
        return this.r;
    label_12:
        return this.s;
    label_14:
        return this.t;
    label_16:
        return this.u;
    }

    public void a(String arg1) {
        this.am = arg1;
    }

    public void a(Object arg1) {
        this.aj = arg1;
    }

    public void a(d arg7, float arg8, int arg9) {
        this.a(c.g, arg7, c.g, arg9, 0);
        this.ac = arg8;
    }

    public void a(c arg8, d arg9, c arg10, int arg11, int arg12) {
        this.a(arg8).a(arg9.a(arg10), arg11, arg12, b.b, 0, true);
    }

    public void a(float arg1) {
        this.O = arg1;
    }

    public void a(int arg1, int arg2) {
        this.G = arg1;
        this.H = arg2;
    }

    public void a(a arg3) {
        this.A[0] = arg3;
        if(arg3 == a.b) {
            this.h(this.ah);
        }
    }

    public void a(int arg2, int arg3, int arg4, float arg5) {
        this.e = arg2;
        this.g = arg3;
        this.h = arg4;
        this.i = arg5;
        if(arg5 < 1f && this.e == 0) {
            this.e = 2;
        }
    }

    private void a(android.support.constraint.a.e arg17, boolean arg18, h arg19, h arg20, a arg21, boolean arg22, android.support.constraint.a.a.c arg23, android.support.constraint.a.a.c arg24, int arg25, int arg26, int arg27, int arg28, float arg29, boolean arg30, boolean arg31, int arg32, int arg33, int arg34, float arg35, boolean arg36) {
        f v2;
        int v14;
        h v5_1;
        h v6;
        int v8;
        h v4 = arg17.a(arg23);
        h v3 = arg17.a(arg24);
        h v15 = arg17.a(arg23.g());
        h v10 = arg17.a(arg24.g());
        if(!arg17.c || arg23.a().i != 1 || arg24.a().i != 1) {
            if(android.support.constraint.a.e.a() != null) {
                v2 = android.support.constraint.a.e.a();
                ++v2.B;
            }

            boolean v11 = arg23.j();
            boolean v12 = arg24.j();
            boolean v13 = this.x.j();
            int v2_1 = 0;
            int v5 = 0;
            if(v11) {
                v5 = 1;
            }

            if(v12) {
                ++v5;
            }

            int v9 = v13 ? v5 + 1 : v5;
            if(arg30) {
                arg32 = 3;
            }

            switch(android.support.constraint.a.a.d$1.b[arg21.ordinal()]) {
                case 1: {
                    v2_1 = 0;
                    break;
                }
                case 2: {
                    v2_1 = 0;
                    break;
                }
                case 3: {
                    v2_1 = 0;
                    break;
                }
                case 4: {
                    v2_1 = 1;
                    break;
                }
            }

            if(this.al == 8) {
                v5 = 0;
                v2_1 = 0;
            }
            else {
                v5 = arg26;
            }

            if(arg36) {
                if(!v11 && !v12 && !v13) {
                    arg17.a(v4, arg25);
                    goto label_84;
                }

                if(!v11) {
                    goto label_84;
                }

                if(v12) {
                    goto label_84;
                }

                arg17.c(v4, v15, arg23.e(), 6);
            }

        label_84:
            if(v2_1 != 0) {
                if(arg33 == -2) {
                    arg33 = v5;
                }

                if(arg34 == -2) {
                    arg34 = v5;
                }

                if(arg33 > 0) {
                    if(arg18) {
                        arg17.a(v3, v4, arg33, 6);
                    }
                    else {
                        arg17.a(v3, v4, arg33, 6);
                    }

                    v5 = Math.max(v5, arg33);
                }

                if(arg34 > 0) {
                    if(arg18) {
                        arg17.b(v3, v4, arg34, 1);
                    }
                    else {
                        arg17.b(v3, v4, arg34, 6);
                    }

                    v8 = Math.min(v5, arg34);
                }
                else {
                    v8 = v5;
                }

                if(arg32 == 1) {
                    if(arg18) {
                        arg17.c(v3, v4, v8, 6);
                    }
                    else if(arg31) {
                        arg17.c(v3, v4, v8, 4);
                    }
                    else {
                        arg17.c(v3, v4, v8, 1);
                    }
                }
                else if(arg32 == 2) {
                    if(arg23.d() == c.c || arg23.d() == c.e) {
                        v6 = arg17.a(this.B.a(c.c));
                        v5_1 = arg17.a(this.B.a(c.e));
                    }
                    else {
                        v6 = arg17.a(this.B.a(c.b));
                        v5_1 = arg17.a(this.B.a(c.d));
                    }

                    arg17.a(arg17.c().a(v3, v4, v5_1, v6, arg35));
                    v2_1 = 0;
                }

                if(v2_1 == 0) {
                    goto label_102;
                }

                if(v9 == 2) {
                    goto label_102;
                }

                if(arg30) {
                    goto label_102;
                }

                v2_1 = Math.max(arg33, v8);
                if(arg34 > 0) {
                    v2_1 = Math.min(arg34, v2_1);
                }

                arg17.c(v3, v4, v2_1, 6);
                v2_1 = 0;
            }
            else if(arg22) {
                arg17.c(v3, v4, 0, 3);
                if(arg27 > 0) {
                    arg17.a(v3, v4, arg27, 6);
                }

                if(arg28 >= 0x7FFFFFFF) {
                    goto label_102;
                }

                arg17.b(v3, v4, arg28, 6);
            }
            else {
                arg17.c(v3, v4, v5, 6);
            }

        label_102:
            if((arg36) && !arg31) {
                if((v11) || (v12) || (v13)) {
                    if((v11) && !v12) {
                        if(arg18) {
                            arg17.a(arg20, v3, 0, 5);
                        }
                        else {
                        }

                        goto label_253;
                    }

                    if(!v11 && (v12)) {
                        arg17.c(v3, v10, -arg24.e(), 6);
                        if(arg18) {
                            arg17.a(v4, arg19, 0, 5);
                        }
                        else {
                        }

                        goto label_253;
                    }

                    if(!v11) {
                        goto label_253;
                    }

                    if(!v12) {
                        goto label_253;
                    }

                    v5 = 0;
                    int v13_1 = 5;
                    if(v2_1 != 0) {
                        if((arg18) && arg27 == 0) {
                            arg17.a(v3, v4, 0, 6);
                        }

                        if(arg32 == 0) {
                            v2_1 = 6;
                            if(arg34 > 0 || arg33 > 0) {
                                v2_1 = 4;
                                v5 = 1;
                            }

                            arg17.c(v4, v15, arg23.e(), v2_1);
                            arg17.c(v3, v10, -arg24.e(), v2_1);
                            v2_1 = arg34 > 0 || arg33 > 0 ? 1 : 0;
                            v14 = v5;
                            goto label_312;
                        }

                        if(arg32 == 1) {
                            v2_1 = 1;
                            v13_1 = 6;
                            v14 = 1;
                            goto label_312;
                        }

                        if(arg32 == 3) {
                            v2_1 = 4;
                            if(!arg30) {
                                v2_1 = 6;
                            }

                            arg17.c(v4, v15, arg23.e(), v2_1);
                            arg17.c(v3, v10, -arg24.e(), v2_1);
                            v2_1 = 1;
                            v14 = 1;
                            goto label_312;
                        }

                        v2_1 = 0;
                        v14 = 0;
                    }
                    else {
                        v2_1 = 1;
                        if(arg18) {
                            arg17.a(v4, v15, arg23.e(), 5);
                            arg17.b(v3, v10, -arg24.e(), 5);
                        }

                        v14 = 0;
                    }

                label_312:
                    if(v2_1 != 0) {
                        arg17.a(v4, v15, arg23.e(), arg29, v10, v3, arg24.e(), v13_1);
                    }

                    if(v14 != 0) {
                        arg17.a(v4, v15, arg23.e(), 6);
                        arg17.b(v3, v10, -arg24.e(), 6);
                    }

                    if(!arg18) {
                        goto label_253;
                    }

                    arg17.a(v4, arg19, 0, 6);
                }
                else if(arg18) {
                    arg17.a(arg20, v3, 0, 5);
                }

            label_253:
                if(!arg18) {
                    return;
                }

                arg17.a(arg20, v3, 0, 6);
                return;
            }

            if(v9 >= 2) {
                return;
            }

            if(!arg18) {
                return;
            }

            arg17.a(v4, arg19, 0, 6);
            arg17.a(arg20, v3, 0, 6);
        }
        else {
            if(android.support.constraint.a.e.a() != null) {
                v2 = android.support.constraint.a.e.a();
                ++v2.s;
            }

            arg23.a().a(arg17);
            arg24.a().a(arg17);
            if(arg31) {
                return;
            }

            if(!arg18) {
                return;
            }

            arg17.a(arg20, v3, 0, 6);
        }
    }

    public void a(int arg6, int arg7, int arg8, int arg9) {
        int v0 = arg8 - arg6;
        int v1 = arg9 - arg7;
        this.G = arg6;
        this.H = arg7;
        if(this.al == 8) {
            this.C = 0;
            this.D = 0;
        }
        else {
            if(this.A[0] == a.a && v0 < this.C) {
                v0 = this.C;
            }

            if(this.A[1] == a.a && v1 < this.D) {
                v1 = this.D;
            }

            this.C = v0;
            this.D = v1;
            if(this.D < this.M) {
                this.D = this.M;
            }

            if(this.C >= this.L) {
                return;
            }

            this.C = this.L;
        }
    }

    public void a(d arg1) {
        this.B = arg1;
    }

    public void a(android.support.constraint.a.c arg2) {
        this.q.a(arg2);
        this.r.a(arg2);
        this.s.a(arg2);
        this.t.a(arg2);
        this.u.a(arg2);
        this.x.a(arg2);
        this.v.a(arg2);
        this.w.a(arg2);
    }

    public void a(android.support.constraint.a.e arg35) {
        h v7_1;
        h v8_1;
        boolean v18;
        int v14;
        int v28;
        int v27;
        boolean v19;
        boolean v26;
        boolean v25;
        boolean v4;
        boolean v6;
        boolean v5;
        h v29 = arg35.a(this.q);
        h v30 = arg35.a(this.s);
        h v31 = arg35.a(this.r);
        h v32 = arg35.a(this.t);
        h v33 = arg35.a(this.u);
        boolean v7 = false;
        if(this.B != null) {
            if(this.B == null) {
                v5 = false;
            }
            else if(this.B.A[0] == a.b) {
                v5 = true;
            }
            else {
                v5 = false;
            }

            if(this.B == null) {
                v6 = false;
            }
            else if(this.B.A[1] == a.b) {
                v6 = true;
            }
            else {
                v6 = false;
            }

            if(this.q.c != null && this.q.c.c == this.q || this.s.c != null && this.s.c.c == this.s) {
                this.B.a(this, 0);
                v7 = true;
            }

            if(this.r.c == null || this.r.c.c != this.r) {
                if(this.t.c != null && this.t.c.c == this.t) {
                label_102:
                    this.B.a(this, 1);
                    v4 = true;
                    goto label_109;
                }

                v4 = false;
            }
            else {
                goto label_102;
            }

        label_109:
            if((v5) && this.al != 8 && this.q.c == null && this.s.c == null) {
                arg35.a(arg35.a(this.B.s), v30, 0, 1);
            }

            if((v6) && this.al != 8 && this.r.c == null && this.t.c == null && this.u == null) {
                arg35.a(arg35.a(this.B.t), v32, 0, 1);
            }

            v25 = v6;
            v26 = v4;
            v19 = v7;
            v6 = v5;
        }
        else {
            v25 = false;
            v26 = false;
            v19 = false;
            v6 = false;
        }

        int v4_1 = this.C;
        if(v4_1 < this.L) {
            v4_1 = this.L;
        }

        int v5_1 = this.D;
        if(v5_1 < this.M) {
            v5_1 = this.M;
        }

        v7 = this.A[0] != a.c ? true : false;
        boolean v8 = this.A[1] != a.c ? true : false;
        int v9 = 0;
        this.o = this.F;
        this.p = this.E;
        if(this.E <= 0f || this.al == 8) {
        label_546:
            v27 = v9;
            v28 = v5_1;
            v14 = v4_1;
        }
        else {
            v9 = 1;
            if(this.A[0] == a.c && this.A[1] == a.c) {
                this.a(v6, v25, v7, v8);
                v27 = 1;
                v28 = v5_1;
                v14 = v4_1;
                goto label_226;
            }

            if(this.A[0] == a.c) {
                this.o = 0;
                v27 = 1;
                v28 = v5_1;
                v14 = ((int)(this.p * (((float)this.D))));
                goto label_226;
            }

            if(this.A[1] != a.c) {
                goto label_546;
            }

            this.o = 1;
            if(this.F == -1) {
                this.p = 1f / this.p;
            }

            v27 = 1;
            v28 = ((int)(this.p * (((float)this.C))));
            v14 = v4_1;
        }

    label_226:
        if(v27 != 0) {
            if(this.o != 0 && this.o != -1) {
                goto label_376;
            }

            v18 = true;
        }
        else {
        label_376:
            v18 = false;
        }

        boolean v10 = this.A[0] != a.b || !(this instanceof e) ? false : true;
        boolean v24 = true;
        if(this.x.j()) {
            v24 = false;
        }

        if(this.a != 2) {
            v8_1 = this.B != null ? arg35.a(this.B.s) : null;
            v7_1 = this.B != null ? arg35.a(this.B.q) : null;
            this.a(arg35, v6, v7_1, v8_1, this.A[0], v10, this.q, this.s, this.G, v14, this.L, this.ab[0], this.O, v18, v19, this.e, this.g, this.h, this.i, v24);
        }

        if(this.b != 2) {
            v10 = this.A[1] != a.b || !(this instanceof e) ? false : true;
            if(v27 != 0) {
                if(this.o != 1 && this.o != -1) {
                    goto label_509;
                }

                v18 = true;
            }
            else {
            label_509:
                v18 = false;
            }

            if(this.K > 0) {
                if(this.u.a().i == 1) {
                    this.u.a().a(arg35);
                }
                else {
                    arg35.c(v33, v31, this.A(), 6);
                    if(this.u.c != null) {
                        arg35.c(v33, arg35.a(this.u.c), 0, 6);
                        v24 = false;
                    }
                }
            }

            v8_1 = this.B != null ? arg35.a(this.B.t) : null;
            v7_1 = this.B != null ? arg35.a(this.B.r) : null;
            this.a(arg35, v25, v7_1, v8_1, this.A[1], v10, this.r, this.t, this.H, v28, this.M, this.ab[1], this.P, v18, v26, this.f, this.j, this.k, this.l, v24);
            if(v27 != 0) {
                int v10_1 = 6;
                if(this.o == 1) {
                    arg35.a(v32, v31, v30, v29, this.p, v10_1);
                }
                else {
                    arg35.a(v30, v29, v32, v31, this.p, v10_1);
                }
            }

            if(!this.x.j()) {
                return;
            }

            arg35.a(this, this.x.g().c(), ((float)Math.toRadians(((double)(this.ac + 90f)))), this.x.e());
        }
    }

    public void a(boolean arg7, boolean arg8, boolean arg9, boolean arg10) {
        int v5 = 3;
        int v3 = -1;
        float v2 = 1f;
        if(this.e == 0) {
            this.e = v5;
        }

        if(this.f == 0) {
            this.f = v5;
        }

        if(this.o == v3) {
            if((arg9) && !arg10) {
                this.o = 0;
                goto label_16;
            }

            if(arg9) {
                goto label_16;
            }

            if(!arg10) {
                goto label_16;
            }

            this.o = 1;
            if(this.F != v3) {
                goto label_16;
            }

            this.p = v2 / this.p;
        }

    label_16:
        if(this.o == 0) {
            if((this.r.j()) && (this.t.j())) {
                goto label_68;
            }

            this.o = 1;
        }
        else {
        label_68:
            if(this.o != 1) {
                goto label_25;
            }

            if((this.q.j()) && (this.s.j())) {
                goto label_25;
            }

            this.o = 0;
        }

    label_25:
        if(this.o == v3 && (!this.r.j() || !this.t.j() || !this.q.j() || !this.s.j())) {
            if((this.r.j()) && (this.t.j())) {
                this.o = 0;
                goto label_46;
            }

            if(!this.q.j()) {
                goto label_46;
            }

            if(!this.s.j()) {
                goto label_46;
            }

            this.p = v2 / this.p;
            this.o = 1;
        }

    label_46:
        if(this.o == v3) {
            if((arg7) && !arg8) {
                this.o = 0;
                goto label_51;
            }

            if(arg7) {
                goto label_51;
            }

            if(!arg8) {
                goto label_51;
            }

            this.p = v2 / this.p;
            this.o = 1;
        }

    label_51:
        if(this.o == v3) {
            if(this.g > 0 && this.j == 0) {
                this.o = 0;
                return;
            }

            if(this.g == 0 && this.j > 0) {
                this.p = v2 / this.p;
                this.o = 1;
                return;
            }

            this.p = v2 / this.p;
            this.o = 1;
        }
    }

    public boolean a() {
        boolean v0 = this.al != 8 ? true : false;
        return v0;
    }

    public void b(boolean arg1) {
        this.m = arg1;
    }

    public void b(float arg1) {
        this.P = arg1;
    }

    public void b(a arg3) {
        this.A[1] = arg3;
        if(arg3 == a.b) {
            this.i(this.ai);
        }
    }

    public void b(String arg10) {
        float v4_2;
        float v0_3;
        String v0_1;
        int v0 = 0;
        if(arg10 != null && arg10.length() != 0) {
            int v2 = -1;
            int v4 = arg10.length();
            int v5 = arg10.indexOf(44);
            if(v5 > 0 && v5 < v4 - 1) {
                String v6 = arg10.substring(0, v5);
                if(!v6.equalsIgnoreCase("W")) {
                    v0 = v6.equalsIgnoreCase("H") ? 1 : v2;
                }

                v2 = v0;
                v0 = v5 + 1;
            }

            v5 = arg10.indexOf(58);
            if(v5 < 0 || v5 >= v4 - 1) {
                v0_1 = arg10.substring(v0);
                if(v0_1.length() > 0) {
                    try {
                        v0_3 = Float.parseFloat(v0_1);
                    }
                    catch(NumberFormatException v0_2) {
                        v0_3 = 0f;
                    }

                    goto label_42;
                }
            }
            else {
                v0_1 = arg10.substring(v0, v5);
                String v4_1 = arg10.substring(v5 + 1);
                if(v0_1.length() > 0 && v4_1.length() > 0) {
                    try {
                        v0_3 = Float.parseFloat(v0_1);
                        v4_2 = Float.parseFloat(v4_1);
                        if(v0_3 > 0f && v4_2 > 0f) {
                            if(v2 == 1) {
                                v0_3 = Math.abs(v4_2 / v0_3);
                                goto label_42;
                            }
                            else {
                                goto label_51;
                            }
                        }

                        goto label_65;
                    }
                    catch(NumberFormatException v0_2) {
                        goto label_55;
                    }

                label_51:
                    v0_3 /= v4_2;
                    try {
                        v0_3 = Math.abs(v0_3);
                    }
                    catch(NumberFormatException v0_2) {
                    label_55:
                        v0_3 = 0f;
                    }

                    goto label_42;
                }
            }

        label_65:
            v0_3 = 0f;
        label_42:
            if(v0_3 <= 0f) {
                return;
            }

            this.E = v0_3;
            this.F = v2;
        }
        else {
            this.E = 0f;
        }
    }

    public void b(int arg2, int arg3, int arg4, float arg5) {
        this.f = arg2;
        this.j = arg3;
        this.k = arg4;
        this.l = arg5;
        if(arg5 < 1f && this.f == 0) {
            this.f = 2;
        }
    }

    public void b() {
        int v0;
        for(v0 = 0; v0 < 6; ++v0) {
            this.y[v0].a().b();
        }
    }

    public void b(int arg1) {
        android.support.constraint.a.a.h.a(arg1, this);
    }

    public void b(int arg1, int arg2) {
        this.I = arg1;
        this.J = arg2;
    }

    public void b(android.support.constraint.a.e arg5) {
        this.a(arg5.b(this.q), arg5.b(this.r), arg5.b(this.s), arg5.b(this.t));
    }

    public void c(boolean arg1) {
        this.n = arg1;
    }

    public void c(float arg3) {
        this.W[0] = arg3;
    }

    public void c() {
    }

    public void c(int arg3) {
        this.ab[0] = arg3;
    }

    public void c(int arg3, int arg4) {
        this.G = arg3;
        this.C = arg4 - arg3;
        if(this.C < this.L) {
            this.C = this.L;
        }
    }

    public boolean d() {
        boolean v0 = false;
        if(this.e == 0 && this.E == 0f && this.g == 0 && this.h == 0 && this.A[0] == a.c) {
            v0 = true;
        }

        return v0;
    }

    public void d(float arg3) {
        this.W[1] = arg3;
    }

    public void d(int arg3) {
        this.ab[1] = arg3;
    }

    public void d(int arg3, int arg4) {
        this.H = arg3;
        this.D = arg4 - arg3;
        if(this.D < this.M) {
            this.D = this.M;
        }
    }

    public void e(int arg1) {
        this.al = arg1;
    }

    public boolean e() {
        boolean v0 = true;
        if(this.f != 0 || this.E != 0f || this.j != 0 || this.k != 0 || this.A[1] != a.c) {
            v0 = false;
        }

        return v0;
    }

    public void f() {
        this.q.i();
        this.r.i();
        this.s.i();
        this.t.i();
        this.u.i();
        this.v.i();
        this.w.i();
        this.x.i();
        this.B = null;
        this.ac = 0f;
        this.C = 0;
        this.D = 0;
        this.E = 0f;
        this.F = -1;
        this.G = 0;
        this.H = 0;
        this.ad = 0;
        this.ae = 0;
        this.af = 0;
        this.ag = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.ah = 0;
        this.ai = 0;
        this.O = d.N;
        this.P = d.N;
        this.A[0] = a.a;
        this.A[1] = a.a;
        this.aj = null;
        this.ak = 0;
        this.al = 0;
        this.an = null;
        this.Q = false;
        this.R = false;
        this.S = 0;
        this.T = 0;
        this.U = false;
        this.V = false;
        this.W[0] = 0f;
        this.W[1] = 0f;
        this.a = -1;
        this.b = -1;
        this.ab[0] = 0x7FFFFFFF;
        this.ab[1] = 0x7FFFFFFF;
        this.e = 0;
        this.f = 0;
        this.i = 1f;
        this.l = 1f;
        this.h = 0x7FFFFFFF;
        this.k = 0x7FFFFFFF;
        this.g = 0;
        this.j = 0;
        this.o = -1;
        this.p = 1f;
        if(this.c != null) {
            this.c.b();
        }

        if(this.d != null) {
            this.d.b();
        }
    }

    public void f(int arg1) {
        this.G = arg1;
    }

    public void g() {
        int v0;
        for(v0 = 0; v0 < 6; ++v0) {
            this.y[v0].a().c();
        }
    }

    public void g(int arg1) {
        this.H = arg1;
    }

    public void h(int arg3) {
        this.C = arg3;
        if(this.C < this.L) {
            this.C = this.L;
        }
    }

    public k h() {
        if(this.c == null) {
            this.c = new k();
        }

        return this.c;
    }

    public void i(int arg3) {
        this.D = arg3;
        if(this.D < this.M) {
            this.D = this.M;
        }
    }

    public k i() {
        if(this.d == null) {
            this.d = new k();
        }

        return this.d;
    }

    public d j() {
        return this.B;
    }

    public void j(int arg2) {
        this.L = arg2 < 0 ? 0 : arg2;
    }

    public int k() {
        return this.al;
    }

    public void k(int arg2) {
        this.M = arg2 < 0 ? 0 : arg2;
    }

    public void l(int arg1) {
        this.ah = arg1;
    }

    public String l() {
        return this.am;
    }

    public void m(int arg1) {
        this.ai = arg1;
    }

    public int m() {
        return this.G;
    }

    public void n(int arg1) {
        this.K = arg1;
    }

    public int n() {
        return this.H;
    }

    public void o(int arg1) {
        this.S = arg1;
    }

    public int o() {
        int v0 = this.al == 8 ? 0 : this.C;
        return v0;
    }

    public void p(int arg1) {
        this.T = arg1;
    }

    public int p() {
        return this.ah;
    }

    public int q() {
        int v0 = this.al == 8 ? 0 : this.D;
        return v0;
    }

    public int r() {
        return this.ai;
    }

    public int s() {
        return this.ad + this.I;
    }

    public int t() {
        return this.ae + this.J;
    }

    public String toString() {
        StringBuilder v1 = new StringBuilder();
        String v0 = this.an != null ? "type: " + this.an + " " : "";
        v1 = v1.append(v0);
        v0 = this.am != null ? "id: " + this.am + " " : "";
        return v1.append(v0).append("(").append(this.G).append(", ").append(this.H).append(") - (").append(this.C).append(" x ").append(this.D).append(") wrap: (").append(this.ah).append(" x ").append(this.ai).append(")").toString();
    }

    protected int u() {
        return this.G + this.I;
    }

    protected int v() {
        return this.H + this.J;
    }

    public int w() {
        return this.m() + this.C;
    }

    public int x() {
        return this.n() + this.D;
    }

    public float y() {
        return this.O;
    }

    public boolean z() {
        boolean v0 = this.K > 0 ? true : false;
        return v0;
    }
}

