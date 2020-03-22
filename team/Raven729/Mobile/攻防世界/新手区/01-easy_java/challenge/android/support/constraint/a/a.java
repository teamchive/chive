package android.support.constraint.a;

import java.util.Arrays;

public class a {
    int a;
    private final b b;
    private final c c;
    private int d;
    private h e;
    private int[] f;
    private int[] g;
    private float[] h;
    private int i;
    private int j;
    private boolean k;

    a(b arg4, c arg5) {
        super();
        this.a = 0;
        this.d = 8;
        this.e = null;
        this.f = new int[this.d];
        this.g = new int[this.d];
        this.h = new float[this.d];
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.b = arg4;
        this.c = arg5;
    }

    private boolean a(h arg3, e arg4) {
        boolean v0 = true;
        if(arg3.i > 1) {
            v0 = false;
        }

        return v0;
    }

    public final float a(h arg9, boolean arg10) {
        float v0 = 0f;
        int v3 = -1;
        if(this.e == arg9) {
            this.e = null;
        }

        if(this.i != v3) {
            int v4 = this.i;
            int v1 = 0;
            int v2 = v3;
            while(v4 != v3) {
                if(v1 >= this.a) {
                    return v0;
                }

                if(this.f[v4] == arg9.a) {
                    if(v4 == this.i) {
                        this.i = this.g[v4];
                    }
                    else {
                        this.g[v2] = this.g[v4];
                    }

                    if(arg10) {
                        arg9.b(this.b);
                    }

                    --arg9.i;
                    --this.a;
                    this.f[v4] = v3;
                    if(this.k) {
                        this.j = v4;
                    }

                    v0 = this.h[v4];
                }
                else {
                    ++v1;
                    int v7 = v4;
                    v4 = this.g[v4];
                    v2 = v7;
                    continue;
                }

                return v0;
            }
        }

        return v0;
    }

    final h a(int arg4) {
        h v0_1;
        int v1 = this.i;
        int v0 = 0;
        while(true) {
            if(v1 == -1) {
                return null;
            }
            else if(v0 >= this.a) {
                return null;
            }
            else if(v0 == arg4) {
                v0_1 = this.c.c[this.f[v1]];
            }
            else {
                v1 = this.g[v1];
                ++v0;
                continue;
            }

            return v0_1;
        }

        return null;
    }

    h a(e arg15) {
        h v5_1;
        h v7 = null;
        boolean v0 = false;
        int v10 = 0;
        int v11 = this.i;
        float v3 = 0f;
        float v5 = 0f;
        h v8 = v7;
        boolean v2 = false;
        while(v11 != -1) {
            if(v10 >= this.a) {
                break;
            }

            float v4 = this.h[v11];
            float v12 = 0.001f;
            h v6 = this.c.c[this.f[v11]];
            if(v4 < 0f) {
                if(v4 > -v12) {
                    this.h[v11] = 0f;
                    v6.b(this.b);
                    v4 = 0f;
                }
            }
            else if(v4 < v12) {
                this.h[v11] = 0f;
                v6.b(this.b);
                v4 = 0f;
            }

            if(v4 == 0f || v7 != null || v4 >= 0f || (v0)) {
            label_93:
                v4 = v5;
                v6 = v8;
                v5_1 = v7;
            }
            else if(v6.f == android.support.constraint.a.h$a.a) {
                if(v7 == null) {
                    v2 = this.a(v6, arg15);
                    v5_1 = v6;
                    v6 = v8;
                }
                else if(v5 > v4) {
                    v2 = this.a(v6, arg15);
                    v5_1 = v6;
                    v6 = v8;
                }
                else if(v2) {
                    goto label_93;
                }
                else if(this.a(v6, arg15)) {
                    v2 = true;
                    v5_1 = v6;
                    v6 = v8;
                }
                else {
                    goto label_93;
                }
            }
            else if(v8 == null) {
                v0 = this.a(v6, arg15);
                v3 = v4;
                v4 = v5;
                v5_1 = v7;
            }
            else if(v3 > v4) {
                v0 = this.a(v6, arg15);
                v3 = v4;
                v4 = v5;
                v5_1 = v7;
            }
            else if(this.a(v6, arg15)) {
                v0 = true;
                v3 = v4;
                v4 = v5;
                v5_1 = v7;
            }
            else {
                goto label_93;
            }

            ++v10;
            v11 = this.g[v11];
            v7 = v5_1;
            v8 = v6;
            v5 = v4;
        }

        if(v7 == null) {
            v7 = v8;
        }

        return v7;
    }

    h a(boolean[] arg9, h arg10) {
        h v1_1;
        h v2 = null;
        int v5 = 0;
        int v6 = this.i;
        float v0 = 0f;
        while(v6 != -1) {
            if(v5 >= this.a) {
                return v2;
            }

            if(this.h[v6] < 0f) {
                h v3 = this.c.c[this.f[v6]];
                if(arg9 != null && (arg9[v3.a])) {
                    goto label_43;
                }

                if(v3 == arg10) {
                    goto label_43;
                }

                if(v3.f != android.support.constraint.a.h$a.c && v3.f != android.support.constraint.a.h$a.d) {
                    goto label_43;
                }

                float v1 = this.h[v6];
                if(v1 >= v0) {
                    goto label_43;
                }

                v0 = v1;
                v1_1 = v3;
            }
            else {
            label_43:
                v1_1 = v2;
            }

            ++v5;
            v6 = this.g[v6];
            v2 = v1_1;
        }

        return v2;
    }

    public final void a() {
        int v5 = -1;
        int v2 = this.i;
        int v0;
        for(v0 = 0; v2 != v5; ++v0) {
            if(v0 >= this.a) {
                break;
            }

            h v3 = this.c.c[this.f[v2]];
            if(v3 != null) {
                v3.b(this.b);
            }

            v2 = this.g[v2];
        }

        this.i = v5;
        this.j = v5;
        this.k = false;
        this.a = 0;
    }

    void a(float arg5) {
        int v1 = this.i;
        int v0;
        for(v0 = 0; v1 != -1; ++v0) {
            if(v0 >= this.a) {
                return;
            }

            this.h[v1] /= arg5;
            v1 = this.g[v1];
        }
    }

    final void a(b arg9, b arg10, boolean arg11) {
        int v3;
        a v0_1;
        float v4;
        int v7 = -1;
        int v1 = this.i;
        int v0 = 0;
    label_5:
        while(v1 != v7) {
            if(v0 >= this.a) {
                return;
            }

            if(this.f[v1] == arg10.a.a) {
                v4 = this.h[v1];
                this.a(arg10.a, arg11);
                v0_1 = arg10.d;
                v3 = v0_1.i;
                v1 = 0;
                goto label_21;
            }
            else {
                v1 = this.g[v1];
                ++v0;
                continue;
            }
        }

        return;
    label_21:
        while(v3 != v7) {
            if(v1 >= v0_1.a) {
                break;
            }

            this.a(this.c.c[v0_1.f[v3]], v0_1.h[v3] * v4, arg11);
            v3 = v0_1.g[v3];
            ++v1;
        }

        arg9.b += arg10.b * v4;
        if(arg11) {
            arg10.a.b(arg9);
        }

        v1 = this.i;
        v0 = 0;
        goto label_5;
    }

    final void a(h arg10, float arg11, boolean arg12) {
        int v4 = -1;
        if(arg11 != 0f) {
            if(this.i == v4) {
                this.i = 0;
                this.h[this.i] = arg11;
                this.f[this.i] = arg10.a;
                this.g[this.i] = v4;
                ++arg10.i;
                arg10.a(this.b);
                ++this.a;
                if(!this.k) {
                    ++this.j;
                    if(this.j >= this.f.length) {
                        this.k = true;
                        this.j = this.f.length - 1;
                    }
                }
            }
            else {
                int v1 = this.i;
                int v2 = 0;
                int v0 = v4;
                while(v1 != v4) {
                    if(v2 >= this.a) {
                        break;
                    }

                    if(this.f[v1] == arg10.a) {
                        this.h[v1] += arg11;
                        if(this.h[v1] == 0f) {
                            if(v1 == this.i) {
                                this.i = this.g[v1];
                            }
                            else {
                                this.g[v0] = this.g[v1];
                            }

                            if(arg12) {
                                arg10.b(this.b);
                            }

                            if(this.k) {
                                this.j = v1;
                            }

                            --arg10.i;
                            --this.a;
                        }
                        else {
                        }

                        return;
                    }
                    else {
                        if(this.f[v1] < arg10.a) {
                            v0 = v1;
                        }

                        ++v2;
                        v1 = this.g[v1];
                        continue;
                    }
                }

                v1 = this.j + 1;
                if(this.k) {
                    v1 = this.f[this.j] == v4 ? this.j : this.f.length;
                }

                if(v1 >= this.f.length && this.a < this.f.length) {
                    v2 = 0;
                    while(v2 < this.f.length) {
                        if(this.f[v2] == v4) {
                            v1 = v2;
                        }
                        else {
                            ++v2;
                            continue;
                        }

                        break;
                    }
                }

                if(v1 >= this.f.length) {
                    v1 = this.f.length;
                    this.d *= 2;
                    this.k = false;
                    this.j = v1 - 1;
                    this.h = Arrays.copyOf(this.h, this.d);
                    this.f = Arrays.copyOf(this.f, this.d);
                    this.g = Arrays.copyOf(this.g, this.d);
                }

                this.f[v1] = arg10.a;
                this.h[v1] = arg11;
                if(v0 != v4) {
                    this.g[v1] = this.g[v0];
                    this.g[v0] = v1;
                }
                else {
                    this.g[v1] = this.i;
                    this.i = v1;
                }

                ++arg10.i;
                arg10.a(this.b);
                ++this.a;
                if(!this.k) {
                    ++this.j;
                }

                if(this.j < this.f.length) {
                    return;
                }

                this.k = true;
                this.j = this.f.length - 1;
            }
        }
    }

    void a(b arg11, b[] arg12) {
        int v3_1;
        a v0_1;
        b v5;
        float v4;
        int v8 = -1;
        int v1 = this.i;
        int v0 = 0;
    label_6:
        while(v1 != v8) {
            if(v0 >= this.a) {
                return;
            }

            h v3 = this.c.c[this.f[v1]];
            if(v3.b != v8) {
                v4 = this.h[v1];
                this.a(v3, true);
                v5 = arg12[v3.b];
                if(!v5.e) {
                    v0_1 = v5.d;
                    v3_1 = v0_1.i;
                    v1 = 0;
                    goto label_27;
                }

                goto label_43;
            }
            else {
                v1 = this.g[v1];
                ++v0;
                continue;
            }
        }

        return;
    label_27:
        while(v3_1 != v8) {
            if(v1 >= v0_1.a) {
                break;
            }

            this.a(this.c.c[v0_1.f[v3_1]], v0_1.h[v3_1] * v4, true);
            v3_1 = v0_1.g[v3_1];
            ++v1;
        }

    label_43:
        arg11.b += v5.b * v4;
        v5.a.b(arg11);
        v1 = this.i;
        v0 = 0;
        goto label_6;
    }

    public final void a(h arg9, float arg10) {
        int v4 = -1;
        if(arg10 == 0f) {
            this.a(arg9, true);
        }
        else if(this.i == v4) {
            this.i = 0;
            this.h[this.i] = arg10;
            this.f[this.i] = arg9.a;
            this.g[this.i] = v4;
            ++arg9.i;
            arg9.a(this.b);
            ++this.a;
            if(!this.k) {
                ++this.j;
                if(this.j >= this.f.length) {
                    this.k = true;
                    this.j = this.f.length - 1;
                }
            }
        }
        else {
            int v1 = this.i;
            int v2 = 0;
            int v0 = v4;
            while(v1 != v4) {
                if(v2 >= this.a) {
                    break;
                }

                if(this.f[v1] == arg9.a) {
                    this.h[v1] = arg10;
                    return;
                }
                else {
                    if(this.f[v1] < arg9.a) {
                        v0 = v1;
                    }

                    ++v2;
                    v1 = this.g[v1];
                    continue;
                }
            }

            v1 = this.j + 1;
            if(this.k) {
                v1 = this.f[this.j] == v4 ? this.j : this.f.length;
            }

            if(v1 >= this.f.length && this.a < this.f.length) {
                v2 = 0;
                while(v2 < this.f.length) {
                    if(this.f[v2] == v4) {
                        v1 = v2;
                    }
                    else {
                        ++v2;
                        continue;
                    }

                    break;
                }
            }

            if(v1 >= this.f.length) {
                v1 = this.f.length;
                this.d *= 2;
                this.k = false;
                this.j = v1 - 1;
                this.h = Arrays.copyOf(this.h, this.d);
                this.f = Arrays.copyOf(this.f, this.d);
                this.g = Arrays.copyOf(this.g, this.d);
            }

            this.f[v1] = arg9.a;
            this.h[v1] = arg10;
            if(v0 != v4) {
                this.g[v1] = this.g[v0];
                this.g[v0] = v1;
            }
            else {
                this.g[v1] = this.i;
                this.i = v1;
            }

            ++arg9.i;
            arg9.a(this.b);
            ++this.a;
            if(!this.k) {
                ++this.j;
            }

            if(this.a >= this.f.length) {
                this.k = true;
            }

            if(this.j < this.f.length) {
                return;
            }

            this.k = true;
            this.j = this.f.length - 1;
        }
    }

    final boolean a(h arg7) {
        int v5 = -1;
        boolean v0 = false;
        if(this.i != v5) {
            int v2 = this.i;
            int v1 = 0;
            while(v2 != v5) {
                if(v1 >= this.a) {
                    return v0;
                }

                if(this.f[v2] == arg7.a) {
                    v0 = true;
                }
                else {
                    v2 = this.g[v2];
                    ++v1;
                    continue;
                }

                return v0;
            }
        }

        return v0;
    }

    final float b(int arg4) {
        float v0_1;
        int v1 = this.i;
        int v0 = 0;
        while(true) {
            if(v1 == -1) {
                return 0f;
            }
            else if(v0 >= this.a) {
                return 0f;
            }
            else if(v0 == arg4) {
                v0_1 = this.h[v1];
            }
            else {
                v1 = this.g[v1];
                ++v0;
                continue;
            }

            return v0_1;
        }

        return 0f;
    }

    public final float b(h arg5) {
        float v0_1;
        int v1 = this.i;
        int v0 = 0;
        while(true) {
            if(v1 == -1) {
                return 0f;
            }
            else if(v0 >= this.a) {
                return 0f;
            }
            else if(this.f[v1] == arg5.a) {
                v0_1 = this.h[v1];
            }
            else {
                v1 = this.g[v1];
                ++v0;
                continue;
            }

            return v0_1;
        }

        return 0f;
    }

    void b() {
        int v1 = this.i;
        int v0;
        for(v0 = 0; v1 != -1; ++v0) {
            if(v0 >= this.a) {
                return;
            }

            this.h[v1] *= -1f;
            v1 = this.g[v1];
        }
    }

    public String toString() {
        String v2 = "";
        int v1 = this.i;
        int v0;
        for(v0 = 0; v1 != -1; ++v0) {
            if(v0 >= this.a) {
                return v2;
            }

            v2 = v2 + " -> " + this.h[v1] + " : " + this.c.c[this.f[v1]];
            v1 = this.g[v1];
        }

        return v2;
    }
}

