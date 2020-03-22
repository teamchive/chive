package android.support.v7.widget;

class ao {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;

    ao() {
        super();
        this.a = 0;
        this.b = 0;
        this.c = 0x80000000;
        this.d = 0x80000000;
        this.e = 0;
        this.f = 0;
        this.g = false;
        this.h = false;
    }

    public void a(int arg3, int arg4) {
        int v1 = 0x80000000;
        this.c = arg3;
        this.d = arg4;
        this.h = true;
        if(this.g) {
            if(arg4 != v1) {
                this.a = arg4;
            }

            if(arg3 == v1) {
                return;
            }

            this.b = arg3;
        }
        else {
            if(arg3 != v1) {
                this.a = arg3;
            }

            if(arg4 == v1) {
                return;
            }

            this.b = arg4;
        }
    }

    public int a() {
        return this.a;
    }

    public void a(boolean arg3) {
        int v0;
        int v1 = 0x80000000;
        if(arg3 != this.g) {
            this.g = arg3;
            if(!this.h) {
                this.a = this.e;
                this.b = this.f;
            }
            else if(arg3) {
                v0 = this.d != v1 ? this.d : this.e;
                this.a = v0;
                v0 = this.c != v1 ? this.c : this.f;
                this.b = v0;
            }
            else {
                v0 = this.c != v1 ? this.c : this.e;
                this.a = v0;
                v0 = this.d != v1 ? this.d : this.f;
                this.b = v0;
            }
        }
    }

    public void b(int arg3, int arg4) {
        int v1 = 0x80000000;
        this.h = false;
        if(arg3 != v1) {
            this.e = arg3;
            this.a = arg3;
        }

        if(arg4 != v1) {
            this.f = arg4;
            this.b = arg4;
        }
    }

    public int b() {
        return this.b;
    }

    public int c() {
        int v0 = this.g ? this.b : this.a;
        return v0;
    }

    public int d() {
        int v0 = this.g ? this.a : this.b;
        return v0;
    }
}

