package android.support.constraint.a;

final class g {
    interface a {
        Object a();

        boolean a(Object arg1);

        void a(Object[] arg1, int arg2);
    }

    class b implements a {
        private final Object[] a;
        private int b;

        b(int arg3) {
            super();
            if(arg3 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }

            this.a = new Object[arg3];
        }

        public Object a() {
            Object v0;
            Object v1 = null;
            if(this.b > 0) {
                int v2 = this.b - 1;
                v0 = this.a[v2];
                this.a[v2] = v1;
                --this.b;
            }
            else {
                v0 = v1;
            }

            return v0;
        }

        public void a(Object[] arg5, int arg6) {
            if(arg6 > arg5.length) {
                arg6 = arg5.length;
            }

            int v0;
            for(v0 = 0; v0 < arg6; ++v0) {
                Object v1 = arg5[v0];
                if(this.b < this.a.length) {
                    this.a[this.b] = v1;
                    ++this.b;
                }
            }
        }

        public boolean a(Object arg3) {
            boolean v0;
            if(this.b < this.a.length) {
                this.a[this.b] = arg3;
                ++this.b;
                v0 = true;
            }
            else {
                v0 = false;
            }

            return v0;
        }
    }

}

