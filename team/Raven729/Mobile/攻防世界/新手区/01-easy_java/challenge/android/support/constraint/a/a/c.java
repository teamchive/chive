package android.support.constraint.a.a;

import android.support.constraint.a.h;

public class c {
    class android.support.constraint.a.a.c$1 {
        static {
            android.support.constraint.a.a.c$1.a = new int[android.support.constraint.a.a.c$c.values().length];
            try {
                android.support.constraint.a.a.c$1.a[android.support.constraint.a.a.c$c.g.ordinal()] = 1;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.c$1.a[android.support.constraint.a.a.c$c.b.ordinal()] = 2;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.c$1.a[android.support.constraint.a.a.c$c.d.ordinal()] = 3;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.c$1.a[android.support.constraint.a.a.c$c.c.ordinal()] = 4;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.c$1.a[android.support.constraint.a.a.c$c.e.ordinal()] = 5;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.c$1.a[android.support.constraint.a.a.c$c.f.ordinal()] = 6;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.c$1.a[android.support.constraint.a.a.c$c.h.ordinal()] = 7;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.c$1.a[android.support.constraint.a.a.c$c.i.ordinal()] = 8;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.support.constraint.a.a.c$1.a[android.support.constraint.a.a.c$c.a.ordinal()] = 9;
            }
            catch(NoSuchFieldError v0) {
            }
        }
    }

    public enum a {
        public static final enum a a;
        public static final enum a b;

        static {
            a.a = new a("RELAXED", 0);
            a.b = new a("STRICT", 1);
            a.c = new a[]{a.a, a.b};
        }

        private a(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static a valueOf(String arg1) {
            return Enum.valueOf(a.class, arg1);
        }

        public static a[] values() {
            return a.c.clone();
        }
    }

    public enum b {
        public static final enum b a;
        public static final enum b b;
        public static final enum b c;

        static {
            b.a = new b("NONE", 0);
            b.b = new b("STRONG", 1);
            b.c = new b("WEAK", 2);
            b.d = new b[]{b.a, b.b, b.c};
        }

        private b(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static b valueOf(String arg1) {
            return Enum.valueOf(b.class, arg1);
        }

        public static b[] values() {
            return b.d.clone();
        }
    }

    public enum android.support.constraint.a.a.c$c {
        public static final enum android.support.constraint.a.a.c$c a;
        public static final enum android.support.constraint.a.a.c$c b;
        public static final enum android.support.constraint.a.a.c$c c;
        public static final enum android.support.constraint.a.a.c$c d;
        public static final enum android.support.constraint.a.a.c$c e;
        public static final enum android.support.constraint.a.a.c$c f;
        public static final enum android.support.constraint.a.a.c$c g;
        public static final enum android.support.constraint.a.a.c$c h;
        public static final enum android.support.constraint.a.a.c$c i;

        static {
            android.support.constraint.a.a.c$c.a = new android.support.constraint.a.a.c$c("NONE", 0);
            android.support.constraint.a.a.c$c.b = new android.support.constraint.a.a.c$c("LEFT", 1);
            android.support.constraint.a.a.c$c.c = new android.support.constraint.a.a.c$c("TOP", 2);
            android.support.constraint.a.a.c$c.d = new android.support.constraint.a.a.c$c("RIGHT", 3);
            android.support.constraint.a.a.c$c.e = new android.support.constraint.a.a.c$c("BOTTOM", 4);
            android.support.constraint.a.a.c$c.f = new android.support.constraint.a.a.c$c("BASELINE", 5);
            android.support.constraint.a.a.c$c.g = new android.support.constraint.a.a.c$c("CENTER", 6);
            android.support.constraint.a.a.c$c.h = new android.support.constraint.a.a.c$c("CENTER_X", 7);
            android.support.constraint.a.a.c$c.i = new android.support.constraint.a.a.c$c("CENTER_Y", 8);
            android.support.constraint.a.a.c$c.j = new android.support.constraint.a.a.c$c[]{android.support.constraint.a.a.c$c.a, android.support.constraint.a.a.c$c.b, android.support.constraint.a.a.c$c.c, android.support.constraint.a.a.c$c.d, android.support.constraint.a.a.c$c.e, android.support.constraint.a.a.c$c.f, android.support.constraint.a.a.c$c.g, android.support.constraint.a.a.c$c.h, android.support.constraint.a.a.c$c.i};
        }

        private android.support.constraint.a.a.c$c(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static android.support.constraint.a.a.c$c valueOf(String arg1) {
            return Enum.valueOf(android.support.constraint.a.a.c$c.class, arg1);
        }

        public static android.support.constraint.a.a.c$c[] values() {
            return android.support.constraint.a.a.c$c.j.clone();
        }
    }

    final d a;
    final android.support.constraint.a.a.c$c b;
    c c;
    public int d;
    int e;
    h f;
    private j g;
    private b h;
    private a i;
    private int j;

    public c(d arg3, android.support.constraint.a.a.c$c arg4) {
        super();
        this.g = new j(this);
        this.d = 0;
        this.e = -1;
        this.h = b.a;
        this.i = a.a;
        this.j = 0;
        this.a = arg3;
        this.b = arg4;
    }

    public j a() {
        return this.g;
    }

    public boolean a(c arg4, int arg5, int arg6, b arg7, int arg8, boolean arg9) {
        boolean v0 = true;
        if(arg4 == null) {
            this.c = null;
            this.d = 0;
            this.e = -1;
            this.h = b.a;
            this.j = 2;
        }
        else {
            if(!arg9 && !this.a(arg4)) {
                return false;
            }

            this.c = arg4;
            this.d = arg5 > 0 ? arg5 : 0;
            this.e = arg6;
            this.h = arg7;
            this.j = arg8;
        }

        return v0;
    }

    public void a(android.support.constraint.a.c arg4) {
        if(this.f == null) {
            this.f = new h(android.support.constraint.a.h$a.a, null);
        }
        else {
            this.f.b();
        }
    }

    public boolean a(c arg6) {
        boolean v0 = true;
        boolean v1 = false;
        if(arg6 != null) {
            android.support.constraint.a.a.c$c v3 = arg6.d();
            if(v3 == this.b) {
                if(this.b == android.support.constraint.a.a.c$c.f) {
                    if(!arg6.c().z()) {
                    }
                    else if(this.c().z()) {
                        goto label_16;
                    }

                    return v1;
                }

            label_16:
                v1 = true;
            }
            else {
                switch(android.support.constraint.a.a.c$1.a[this.b.ordinal()]) {
                    case 1: {
                        goto label_28;
                    }
                    case 2: 
                    case 3: {
                        goto label_38;
                    }
                    case 4: 
                    case 5: {
                        goto label_53;
                    }
                    case 6: 
                    case 7: 
                    case 8: 
                    case 9: {
                        return v1;
                    }
                }

                throw new AssertionError(this.b.name());
            label_53:
                boolean v2 = v3 == android.support.constraint.a.a.c$c.c || v3 == android.support.constraint.a.a.c$c.e ? true : false;
                if(!(arg6.c() instanceof f)) {
                    return v2;
                }

                if(!v2 && v3 != android.support.constraint.a.a.c$c.i) {
                    return v1;
                }

                return true;
            label_38:
                v2 = v3 == android.support.constraint.a.a.c$c.b || v3 == android.support.constraint.a.a.c$c.d ? true : false;
                if((arg6.c() instanceof f)) {
                    if(!v2 && v3 != android.support.constraint.a.a.c$c.h) {
                        return v1;
                    }

                    return true;
                }

                return v2;
            label_28:
                if(v3 == android.support.constraint.a.a.c$c.f || v3 == android.support.constraint.a.a.c$c.h || v3 == android.support.constraint.a.a.c$c.i) {
                    v0 = false;
                }

                v1 = v0;
            }
        }

        return v1;
    }

    public boolean a(c arg8, int arg9, b arg10, int arg11) {
        return this.a(arg8, arg9, -1, arg10, arg11, false);
    }

    public h b() {
        return this.f;
    }

    public d c() {
        return this.a;
    }

    public android.support.constraint.a.a.c$c d() {
        return this.b;
    }

    public int e() {
        int v0;
        int v2 = 8;
        if(this.a.k() == v2) {
            v0 = 0;
        }
        else {
            if(this.e > -1 && this.c != null && this.c.a.k() == v2) {
                return this.e;
            }

            v0 = this.d;
        }

        return v0;
    }

    public b f() {
        return this.h;
    }

    public c g() {
        return this.c;
    }

    public int h() {
        return this.j;
    }

    public void i() {
        this.c = null;
        this.d = 0;
        this.e = -1;
        this.h = b.b;
        this.j = 0;
        this.i = a.a;
        this.g.b();
    }

    public boolean j() {
        boolean v0 = this.c != null ? true : false;
        return v0;
    }

    public String toString() {
        return this.a.l() + ":" + this.b.toString();
    }
}

