package android.support.constraint.a;

public class b implements a {
    h a;
    float b;
    boolean c;
    public final android.support.constraint.a.a d;
    boolean e;

    public b(c arg3) {
        super();
        this.a = null;
        this.b = 0f;
        this.c = false;
        this.e = false;
        this.d = new android.support.constraint.a.a(this, arg3);
    }

    public b a(h arg3, h arg4, h arg5, h arg6, float arg7) {
        this.d.a(arg3, -1f);
        this.d.a(arg4, 1f);
        this.d.a(arg5, arg7);
        this.d.a(arg6, -arg7);
        return this;
    }

    public b a(float arg6, float arg7, float arg8, h arg9, h arg10, h arg11, h arg12) {
        float v4 = 1f;
        float v2 = -1f;
        if(arg7 == 0f || arg6 == arg8) {
            this.b = 0f;
            this.d.a(arg9, v4);
            this.d.a(arg10, v2);
            this.d.a(arg12, v4);
            this.d.a(arg11, v2);
        }
        else {
            float v0 = arg6 / arg7 / (arg8 / arg7);
            this.b = 0f;
            this.d.a(arg9, v4);
            this.d.a(arg10, v2);
            this.d.a(arg12, v0);
            this.d.a(arg11, -v0);
        }

        return this;
    }

    public b a(e arg4, int arg5) {
        this.d.a(arg4.a(arg5, "ep"), 1f);
        this.d.a(arg4.a(arg5, "em"), -1f);
        return this;
    }

    b a(h arg2, int arg3) {
        this.a = arg2;
        arg2.d = ((float)arg3);
        this.b = ((float)arg3);
        this.e = true;
        return this;
    }

    public b a(h arg5, h arg6, int arg7) {
        float v3 = 1f;
        float v2 = -1f;
        int v0 = 0;
        if(arg7 != 0) {
            if(arg7 < 0) {
                arg7 *= -1;
                v0 = 1;
            }

            this.b = ((float)arg7);
        }

        if(v0 == 0) {
            this.d.a(arg5, v2);
            this.d.a(arg6, v3);
        }
        else {
            this.d.a(arg5, v3);
            this.d.a(arg6, v2);
        }

        return this;
    }

    b a(h arg5, h arg6, int arg7, float arg8, h arg9, h arg10, int arg11) {
        float v3 = -1f;
        float v2 = 1f;
        if(arg6 == arg9) {
            this.d.a(arg5, v2);
            this.d.a(arg10, v2);
            this.d.a(arg6, -2f);
        }
        else if(arg8 == 0.5f) {
            this.d.a(arg5, v2);
            this.d.a(arg6, v3);
            this.d.a(arg9, v3);
            this.d.a(arg10, v2);
            if(arg7 <= 0 && arg11 <= 0) {
                return this;
            }

            this.b = ((float)(-arg7 + arg11));
        }
        else {
            if(arg8 <= 0f) {
                this.d.a(arg5, v3);
                this.d.a(arg6, v2);
                this.b = ((float)arg7);
                return this;
            }

            if(arg8 >= v2) {
                this.d.a(arg9, v3);
                this.d.a(arg10, v2);
                this.b = ((float)arg11);
                return this;
            }

            this.d.a(arg5, (v2 - arg8) * v2);
            this.d.a(arg6, (v2 - arg8) * v3);
            this.d.a(arg9, v3 * arg8);
            this.d.a(arg10, v2 * arg8);
            if(arg7 <= 0 && arg11 <= 0) {
                return this;
            }

            this.b = (((float)(-arg7))) * (v2 - arg8) + (((float)arg11)) * arg8;
        }

        return this;
    }

    b a(h arg3, h arg4, h arg5, float arg6) {
        this.d.a(arg3, -1f);
        this.d.a(arg4, 1f - arg6);
        this.d.a(arg5, arg6);
        return this;
    }

    public b a(h arg5, h arg6, h arg7, int arg8) {
        float v3 = 1f;
        float v2 = -1f;
        int v0 = 0;
        if(arg8 != 0) {
            if(arg8 < 0) {
                arg8 *= -1;
                v0 = 1;
            }

            this.b = ((float)arg8);
        }

        if(v0 == 0) {
            this.d.a(arg5, v2);
            this.d.a(arg6, v3);
            this.d.a(arg7, v3);
        }
        else {
            this.d.a(arg5, v3);
            this.d.a(arg6, v2);
            this.d.a(arg7, v2);
        }

        return this;
    }

    public h a(e arg3, boolean[] arg4) {
        return this.d.a(arg4, null);
    }

    public void a(a arg6) {
        if((arg6 instanceof b)) {
            this.a = null;
            this.d.a();
            int v0;
            for(v0 = 0; v0 < ((b)arg6).d.a; ++v0) {
                this.d.a(((b)arg6).d.a(v0), ((b)arg6).d.b(v0), true);
            }
        }
    }

    boolean a() {
        boolean v0;
        if(this.a != null) {
            if(this.a.f != android.support.constraint.a.h$a.a && this.b < 0f) {
                goto label_11;
            }

            v0 = true;
        }
        else {
        label_11:
            v0 = false;
        }

        return v0;
    }

    boolean a(e arg4) {
        boolean v0 = false;
        h v2 = this.d.a(arg4);
        if(v2 == null) {
            v0 = true;
        }
        else {
            this.c(v2);
        }

        if(this.d.a == 0) {
            this.e = true;
        }

        return v0;
    }

    boolean a(h arg2) {
        return this.d.a(arg2);
    }

    public b b(h arg3, int arg4) {
        if(arg4 < 0) {
            this.b = ((float)(arg4 * -1));
            this.d.a(arg3, 1f);
        }
        else {
            this.b = ((float)arg4);
            this.d.a(arg3, -1f);
        }

        return this;
    }

    public b b(h arg5, h arg6, h arg7, int arg8) {
        float v3 = 1f;
        float v2 = -1f;
        int v0 = 0;
        if(arg8 != 0) {
            if(arg8 < 0) {
                arg8 *= -1;
                v0 = 1;
            }

            this.b = ((float)arg8);
        }

        if(v0 == 0) {
            this.d.a(arg5, v2);
            this.d.a(arg6, v3);
            this.d.a(arg7, v2);
        }
        else {
            this.d.a(arg5, v3);
            this.d.a(arg6, v2);
            this.d.a(arg7, v3);
        }

        return this;
    }

    public b b(h arg4, h arg5, h arg6, h arg7, float arg8) {
        this.d.a(arg6, 0.5f);
        this.d.a(arg7, 0.5f);
        this.d.a(arg4, -0.5f);
        this.d.a(arg5, -0.5f);
        this.b = -arg8;
        return this;
    }

    h b(h arg3) {
        return this.d.a(null, arg3);
    }

    String b() {
        float v0_2;
        int v0_1;
        String v3;
        float v9 = -1f;
        String v0 = "";
        v0 = this.a == null ? v0 + "0" : v0 + this.a;
        v0 = v0 + " = ";
        if(this.b != 0f) {
            v3 = v0 + this.b;
            v0_1 = 1;
        }
        else {
            v3 = v0;
            v0_1 = 0;
        }

        int v5 = this.d.a;
        int v4 = 0;
        String v2 = v3;
        while(v4 < v5) {
            h v6 = this.d.a(v4);
            if(v6 != null) {
                float v3_1 = this.d.b(v4);
                if(v3_1 != 0f) {
                    String v6_1 = v6.toString();
                    if(v0_1 == 0) {
                        if(v3_1 < 0f) {
                            v2 = v2 + "- ";
                            v0_2 = v3_1 * v9;
                        }
                        else {
                            v0_2 = v3_1;
                        }
                    }
                    else if(v3_1 > 0f) {
                        v2 = v2 + " + ";
                        v0_2 = v3_1;
                    }
                    else {
                        v2 = v2 + " - ";
                        v0_2 = v3_1 * v9;
                    }

                    v0 = v0_2 == 1f ? v2 + v6_1 : v2 + v0_2 + " " + v6_1;
                    v2 = v0;
                    v0_1 = 1;
                }
            }

            ++v4;
        }

        if(v0_1 == 0) {
            v2 = v2 + "0.0";
        }

        return v2;
    }

    void c(h arg4) {
        float v2 = -1f;
        if(this.a != null) {
            this.d.a(this.a, v2);
            this.a = null;
        }

        float v0 = this.d.a(arg4, true) * v2;
        this.a = arg4;
        if(v0 != 1f) {
            this.b /= v0;
            this.d.a(v0);
        }
    }

    b c(h arg3, int arg4) {
        this.d.a(arg3, ((float)arg4));
        return this;
    }

    public void c() {
        this.a = null;
        this.d.a();
        this.b = 0f;
        this.e = false;
    }

    void d() {
        if(this.b < 0f) {
            this.b *= -1f;
            this.d.b();
        }
    }

    public void d(h arg4) {
        float v0 = 1f;
        if(arg4.c != 1) {
            if(arg4.c == 2) {
                v0 = 1000f;
            }
            else if(arg4.c == 3) {
                v0 = 1000000f;
            }
            else if(arg4.c == 4) {
                v0 = 1000000000f;
            }
            else if(arg4.c == 5) {
                v0 = 999999995904f;
            }
        }

        this.d.a(arg4, v0);
    }

    public boolean e() {
        boolean v0 = this.a != null || this.b != 0f || this.d.a != 0 ? false : true;
        return v0;
    }

    public void f() {
        this.d.a();
        this.a = null;
        this.b = 0f;
    }

    public h g() {
        return this.a;
    }

    public String toString() {
        return this.b();
    }
}

