package android.support.constraint.a.a;

import android.support.constraint.a.e;
import android.support.constraint.a.f;
import android.support.constraint.a.h;
import java.util.ArrayList;

public class a extends g {
    private int ad;
    private ArrayList ae;
    private boolean af;

    public a() {
        super();
        this.ad = 0;
        this.ae = new ArrayList(4);
        this.af = true;
    }

    public void a(int arg1) {
        this.ad = arg1;
    }

    public void a(e arg12) {
        boolean v0_1;
        int v10 = 6;
        int v9 = 5;
        int v8 = 2;
        this.y[0] = this.q;
        this.y[v8] = this.r;
        this.y[1] = this.s;
        this.y[3] = this.t;
        int v0;
        for(v0 = 0; v0 < this.y.length; ++v0) {
            this.y[v0].f = arg12.a(this.y[v0]);
        }

        if(this.ad >= 0 && this.ad < 4) {
            c v4 = this.y[this.ad];
            for(v0 = 0; v0 < this.ac; ++v0) {
                d v3 = this.ab[v0];
                if((this.af) || (v3.a())) {
                    if((this.ad == 0 || this.ad == 1) && v3.F() == android.support.constraint.a.a.d$a.c) {
                        v0_1 = true;
                        goto label_57;
                    }

                    if(this.ad != v8 && this.ad != 3) {
                        goto label_47;
                    }

                    if(v3.G() != android.support.constraint.a.a.d$a.c) {
                        goto label_47;
                    }

                    v0_1 = true;
                    goto label_57;
                }

            label_47:
            }

            v0_1 = false;
        label_57:
            if(this.ad == 0 || this.ad == 1) {
                if(this.j().F() == android.support.constraint.a.a.d$a.b) {
                    v0_1 = false;
                }
            }
            else if(this.j().G() == android.support.constraint.a.a.d$a.b) {
                v0_1 = false;
            }

            int v3_1;
            for(v3_1 = 0; v3_1 < this.ac; ++v3_1) {
                d v5 = this.ab[v3_1];
                if((this.af) || (v5.a())) {
                    h v6 = arg12.a(v5.y[this.ad]);
                    v5.y[this.ad].f = v6;
                    if(this.ad != 0 && this.ad != v8) {
                        arg12.a(v4.f, v6, v0_1);
                        goto label_75;
                    }

                    arg12.b(v4.f, v6, v0_1);
                }

            label_75:
            }

            if(this.ad == 0) {
                arg12.c(this.s.f, this.q.f, 0, v10);
                if(v0_1) {
                    return;
                }

                arg12.c(this.q.f, this.B.s.f, 0, v9);
                return;
            }

            if(this.ad == 1) {
                arg12.c(this.q.f, this.s.f, 0, v10);
                if(v0_1) {
                    return;
                }

                arg12.c(this.q.f, this.B.q.f, 0, v9);
                return;
            }

            if(this.ad == v8) {
                arg12.c(this.t.f, this.r.f, 0, v10);
                if(v0_1) {
                    return;
                }

                arg12.c(this.r.f, this.B.t.f, 0, v9);
                return;
            }

            if(this.ad != 3) {
                return;
            }

            arg12.c(this.r.f, this.t.f, 0, v10);
            if(v0_1) {
                return;
            }

            arg12.c(this.r.f, this.B.r.f, 0, v9);
        }
    }

    public void a(boolean arg1) {
        this.af = arg1;
    }

    public boolean a() {
        return 1;
    }

    public void b() {
        super.b();
        this.ae.clear();
    }

    public void b(int arg6) {
        j v2_1;
        j v3 = null;
        if(this.B != null && (this.B.q(2))) {
            switch(this.ad) {
                case 0: {
                    goto label_12;
                }
                case 1: {
                    goto label_40;
                }
                case 2: {
                    goto label_43;
                }
                case 3: {
                    goto label_46;
                }
            }

            return;
        label_40:
            j v0 = this.s.a();
            goto label_14;
        label_43:
            v0 = this.r.a();
            goto label_14;
        label_12:
            v0 = this.q.a();
            goto label_14;
        label_46:
            v0 = this.t.a();
        label_14:
            v0.b(5);
            if(this.ad == 0 || this.ad == 1) {
                this.r.a().a(v3, 0f);
                this.t.a().a(v3, 0f);
            }
            else {
                this.q.a().a(v3, 0f);
                this.s.a().a(v3, 0f);
            }

            this.ae.clear();
            int v1;
            for(v1 = 0; v1 < this.ac; ++v1) {
                d v2 = this.ab[v1];
                if((this.af) || (v2.a())) {
                    switch(this.ad) {
                        case 0: {
                            v2_1 = v2.q.a();
                            break;
                        }
                        case 1: {
                            v2_1 = v2.s.a();
                            break;
                        }
                        case 2: {
                            v2_1 = v2.r.a();
                            break;
                        }
                        case 3: {
                            v2_1 = v2.t.a();
                            break;
                        }
                        default: {
                            v2_1 = v3;
                            break;
                        }
                    }

                    if(v2_1 != null) {
                        this.ae.add(v2_1);
                        v2_1.a(((l)v0));
                    }
                }
            }
        }
    }

    public void c() {
        j v0_2;
        float v2_1;
        j v1;
        float v0 = 3.402823E+38f;
        switch(this.ad) {
            case 0: {
                v1 = this.q.a();
                goto label_7;
            }
            case 1: {
                v1 = this.s.a();
                v0 = 0f;
                goto label_7;
            }
            case 2: {
                v1 = this.r.a();
                goto label_7;
            }
            case 3: {
                v1 = this.t.a();
                v0 = 0f;
            label_7:
                int v5 = this.ae.size();
                int v4 = 0;
                j v2 = null;
                float v3 = v0;
                while(v4 < v5) {
                    Object v0_1 = this.ae.get(v4);
                    if(((j)v0_1).i != 1) {
                        return;
                    }

                    if(this.ad == 0 || this.ad == 2) {
                        if(((j)v0_1).f < v3) {
                            v2_1 = ((j)v0_1).f;
                            v0_2 = ((j)v0_1).e;
                        }
                        else {
                        label_83:
                            v0_2 = v2;
                            v2_1 = v3;
                        }
                    }
                    else if(((j)v0_1).f > v3) {
                        v2_1 = ((j)v0_1).f;
                        v0_2 = ((j)v0_1).e;
                    }
                    else {
                        goto label_83;
                    }

                    ++v4;
                    v3 = v2_1;
                    v2 = v0_2;
                }

                if(e.a() != null) {
                    f v0_3 = e.a();
                    ++v0_3.z;
                }

                v1.e = v2;
                v1.f = v3;
                v1.f();
                switch(this.ad) {
                    case 0: {
                        this.s.a().a(v2, v3);
                        return;
                    }
                    case 1: {
                        this.q.a().a(v2, v3);
                        return;
                    }
                    case 2: {
                        this.t.a().a(v2, v3);
                        return;
                    }
                    case 3: {
                        this.r.a().a(v2, v3);
                        return;
                    }
                    default: {
                        return;
                    }
                }
            }
        }
    }
}

