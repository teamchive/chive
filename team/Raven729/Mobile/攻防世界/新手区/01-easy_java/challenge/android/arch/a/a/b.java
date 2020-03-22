package android.arch.a.a;

import java.util.Iterator;
import java.util.Map$Entry;
import java.util.WeakHashMap;

public class b implements Iterable {
    class android.arch.a.a.b$1 {
    }

    class a extends e {
        a(c arg1, c arg2) {
            super(arg1, arg2);
        }

        c a(c arg2) {
            return arg2.c;
        }
    }

    class android.arch.a.a.b$b extends e {
        android.arch.a.a.b$b(c arg1, c arg2) {
            super(arg1, arg2);
        }

        c a(c arg2) {
            return arg2.d;
        }
    }

    class c implements Map$Entry {
        final Object a;
        final Object b;
        c c;
        c d;

        public boolean equals(Object arg5) {
            boolean v0 = true;
            if((((c)arg5)) != this) {
                if(!(arg5 instanceof c)) {
                    v0 = false;
                }
                else {
                    if((this.a.equals(((c)arg5).a)) && (this.b.equals(((c)arg5).b))) {
                        return v0;
                    }

                    v0 = false;
                }
            }

            return v0;
        }

        public Object getKey() {
            return this.a;
        }

        public Object getValue() {
            return this.b;
        }

        public Object setValue(Object arg3) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.a + "=" + this.b;
        }
    }

    class d implements Iterator {
        private c b;
        private boolean c;

        d(b arg1, android.arch.a.a.b$1 arg2) {
            this(arg1);
        }

        private d(b arg2) {
            this.a = arg2;
            super();
            this.c = true;
        }

        public Map$Entry a() {
            if(this.c) {
                this.c = false;
                this.b = b.a(this.a);
            }
            else {
                c v0 = this.b != null ? this.b.c : null;
                this.b = v0;
            }

            return this.b;
        }

        public boolean hasNext() {
            boolean v0 = true;
            if(!this.c) {
                if(this.b != null && this.b.c != null) {
                    return v0;
                }

                v0 = false;
            }
            else if(b.a(this.a) == null) {
                v0 = false;
            }

            return v0;
        }

        public Object next() {
            return this.a();
        }
    }

    abstract class e implements Iterator {
        c a;
        c b;

        e(c arg1, c arg2) {
            super();
            this.a = arg2;
            this.b = arg1;
        }

        abstract c a(c arg1);

        public Map$Entry a() {
            c v0 = this.b;
            this.b = this.b();
            return ((Map$Entry)v0);
        }

        private c b() {
            c v0 = this.b == this.a || this.a == null ? null : this.a(this.b);
            return v0;
        }

        public boolean hasNext() {
            boolean v0 = this.b != null ? true : false;
            return v0;
        }

        public Object next() {
            return this.a();
        }
    }

    private c a;
    private c b;
    private WeakHashMap c;
    private int d;

    public b() {
        super();
        this.c = new WeakHashMap();
        this.d = 0;
    }

    static c a(b arg1) {
        return arg1.a;
    }

    public int a() {
        return this.d;
    }

    public Iterator b() {
        android.arch.a.a.b$b v0 = new android.arch.a.a.b$b(this.b, this.a);
        this.c.put(v0, Boolean.valueOf(false));
        return ((Iterator)v0);
    }

    public d c() {
        d v0 = new d(this, null);
        this.c.put(v0, Boolean.valueOf(false));
        return v0;
    }

    public Map$Entry d() {
        return this.a;
    }

    public Map$Entry e() {
        return this.b;
    }

    public boolean equals(Object arg7) {
        boolean v2 = false;
        if((((b)arg7)) == this) {
            v2 = true;
        }
        else if(((arg7 instanceof b)) && this.a() == ((b)arg7).a()) {
            Iterator v3 = this.iterator();
            Iterator v4 = ((b)arg7).iterator();
            do {
                if((v3.hasNext()) && (v4.hasNext())) {
                    Object v0 = v3.next();
                    Object v5 = v4.next();
                    if(v0 == null && v5 != null) {
                        return v2;
                    }

                    if(v0 == null) {
                        continue;
                    }

                    if(((Map$Entry)v0).equals(v5)) {
                        continue;
                    }

                    return v2;
                }

                goto label_24;
            }
            while(true);

            return v2;
        label_24:
            boolean v0_1 = (v3.hasNext()) || (v4.hasNext()) ? false : true;
            v2 = v0_1;
        }

        return v2;
    }

    public Iterator iterator() {
        a v0 = new a(this.a, this.b);
        this.c.put(v0, Boolean.valueOf(false));
        return ((Iterator)v0);
    }

    public String toString() {
        StringBuilder v1 = new StringBuilder();
        v1.append("[");
        Iterator v2 = this.iterator();
        while(v2.hasNext()) {
            v1.append(v2.next().toString());
            if(!v2.hasNext()) {
                continue;
            }

            v1.append(", ");
        }

        v1.append("]");
        return v1.toString();
    }
}

