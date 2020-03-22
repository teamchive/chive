package android.arch.lifecycle;

public abstract class b {
    public enum a {
        public static final enum a ON_ANY;
        public static final enum a ON_CREATE;
        public static final enum a ON_DESTROY;
        public static final enum a ON_PAUSE;
        public static final enum a ON_RESUME;
        public static final enum a ON_START;
        public static final enum a ON_STOP;

        static {
            a.ON_CREATE = new a("ON_CREATE", 0);
            a.ON_START = new a("ON_START", 1);
            a.ON_RESUME = new a("ON_RESUME", 2);
            a.ON_PAUSE = new a("ON_PAUSE", 3);
            a.ON_STOP = new a("ON_STOP", 4);
            a.ON_DESTROY = new a("ON_DESTROY", 5);
            a.ON_ANY = new a("ON_ANY", 6);
            a.$VALUES = new a[]{a.ON_CREATE, a.ON_START, a.ON_RESUME, a.ON_PAUSE, a.ON_STOP, a.ON_DESTROY, a.ON_ANY};
        }

        private a(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static a valueOf(String arg1) {
            return Enum.valueOf(a.class, arg1);
        }

        public static a[] values() {
            return a.$VALUES.clone();
        }
    }

    public enum android.arch.lifecycle.b$b {
        public static final enum android.arch.lifecycle.b$b a;
        public static final enum android.arch.lifecycle.b$b b;
        public static final enum android.arch.lifecycle.b$b c;
        public static final enum android.arch.lifecycle.b$b d;
        public static final enum android.arch.lifecycle.b$b e;

        static {
            android.arch.lifecycle.b$b.a = new android.arch.lifecycle.b$b("DESTROYED", 0);
            android.arch.lifecycle.b$b.b = new android.arch.lifecycle.b$b("INITIALIZED", 1);
            android.arch.lifecycle.b$b.c = new android.arch.lifecycle.b$b("CREATED", 2);
            android.arch.lifecycle.b$b.d = new android.arch.lifecycle.b$b("STARTED", 3);
            android.arch.lifecycle.b$b.e = new android.arch.lifecycle.b$b("RESUMED", 4);
            android.arch.lifecycle.b$b.f = new android.arch.lifecycle.b$b[]{android.arch.lifecycle.b$b.a, android.arch.lifecycle.b$b.b, android.arch.lifecycle.b$b.c, android.arch.lifecycle.b$b.d, android.arch.lifecycle.b$b.e};
        }

        private android.arch.lifecycle.b$b(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static android.arch.lifecycle.b$b valueOf(String arg1) {
            return Enum.valueOf(android.arch.lifecycle.b$b.class, arg1);
        }

        public static android.arch.lifecycle.b$b[] values() {
            return android.arch.lifecycle.b$b.f.clone();
        }
    }

    public b() {
        super();
    }
}

