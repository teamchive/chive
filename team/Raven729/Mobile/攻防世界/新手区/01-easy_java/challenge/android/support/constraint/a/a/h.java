package android.support.constraint.a.a;

public class h {
    static boolean[] a;

    static {
        h.a = new boolean[3];
    }

    static void a(int arg12, d arg13) {
        int v2;
        int v11 = -1;
        int v9 = 2;
        arg13.g();
        j v3 = arg13.q.a();
        j v4 = arg13.r.a();
        j v5 = arg13.s.a();
        j v6 = arg13.t.a();
        int v0 = (arg12 & 8) == 8 ? 1 : 0;
        if(v3.g != 4 && v5.g != 4) {
            if(arg13.A[0] == a.a) {
                if(arg13.q.c == null && arg13.s.c == null) {
                    v3.b(1);
                    v5.b(1);
                    if(v0 != 0) {
                        v5.a(v3, 1, arg13.h());
                    }
                    else {
                        v5.a(v3, arg13.o());
                    }

                    goto label_39;
                }

                if(arg13.q.c != null && arg13.s.c == null) {
                    v3.b(1);
                    v5.b(1);
                    if(v0 != 0) {
                        v5.a(v3, 1, arg13.h());
                    }
                    else {
                        v5.a(v3, arg13.o());
                    }

                    goto label_39;
                }

                if(arg13.q.c == null && arg13.s.c != null) {
                    v3.b(1);
                    v5.b(1);
                    v3.a(v5, -arg13.o());
                    if(v0 != 0) {
                        v3.a(v5, v11, arg13.h());
                    }
                    else {
                        v3.a(v5, -arg13.o());
                    }

                    goto label_39;
                }

                if(arg13.q.c == null) {
                    goto label_39;
                }

                if(arg13.s.c == null) {
                    goto label_39;
                }

                v3.b(v9);
                v5.b(v9);
                if(v0 != 0) {
                    arg13.h().a(((l)v3));
                    arg13.h().a(((l)v5));
                    v3.b(v5, v11, arg13.h());
                    v5.b(v3, 1, arg13.h());
                    goto label_39;
                }

                v3.b(v5, ((float)(-arg13.o())));
                v5.b(v3, ((float)arg13.o()));
            }
            else {
                if(arg13.A[0] != a.c) {
                    goto label_39;
                }

                if(!h.a(arg13, 0)) {
                    goto label_39;
                }

                v2 = arg13.o();
                v3.b(1);
                v5.b(1);
                if(arg13.q.c == null && arg13.s.c == null) {
                    if(v0 != 0) {
                        v5.a(v3, 1, arg13.h());
                    }
                    else {
                        v5.a(v3, v2);
                    }

                    goto label_39;
                }

                if(arg13.q.c != null && arg13.s.c == null) {
                    if(v0 != 0) {
                        v5.a(v3, 1, arg13.h());
                    }
                    else {
                        v5.a(v3, v2);
                    }

                    goto label_39;
                }

                if(arg13.q.c == null && arg13.s.c != null) {
                    if(v0 != 0) {
                        v3.a(v5, v11, arg13.h());
                    }
                    else {
                        v3.a(v5, -v2);
                    }

                    goto label_39;
                }

                if(arg13.q.c == null) {
                    goto label_39;
                }

                if(arg13.s.c == null) {
                    goto label_39;
                }

                if(v0 != 0) {
                    arg13.h().a(((l)v3));
                    arg13.h().a(((l)v5));
                }

                if(arg13.E == 0f) {
                    v3.b(3);
                    v5.b(3);
                    v3.b(v5, 0f);
                    v5.b(v3, 0f);
                    goto label_39;
                }

                v3.b(v9);
                v5.b(v9);
                v3.b(v5, ((float)(-v2)));
                v5.b(v3, ((float)v2));
                arg13.h(v2);
            }
        }

    label_39:
        if(v4.g != 4 && v6.g != 4) {
            if(arg13.A[1] == a.a) {
                if(arg13.r.c == null && arg13.t.c == null) {
                    v4.b(1);
                    v6.b(1);
                    if(v0 != 0) {
                        v6.a(v4, 1, arg13.i());
                    }
                    else {
                        v6.a(v4, arg13.q());
                    }

                    if(arg13.u.c == null) {
                        return;
                    }

                    arg13.u.a().b(1);
                    v4.a(1, arg13.u.a(), -arg13.K);
                    return;
                }

                if(arg13.r.c != null && arg13.t.c == null) {
                    v4.b(1);
                    v6.b(1);
                    if(v0 != 0) {
                        v6.a(v4, 1, arg13.i());
                    }
                    else {
                        v6.a(v4, arg13.q());
                    }

                    if(arg13.K <= 0) {
                        return;
                    }

                    arg13.u.a().a(1, v4, arg13.K);
                    return;
                }

                if(arg13.r.c == null && arg13.t.c != null) {
                    v4.b(1);
                    v6.b(1);
                    if(v0 != 0) {
                        v4.a(v6, v11, arg13.i());
                    }
                    else {
                        v4.a(v6, -arg13.q());
                    }

                    if(arg13.K <= 0) {
                        return;
                    }

                    arg13.u.a().a(1, v4, arg13.K);
                    return;
                }

                if(arg13.r.c == null) {
                    return;
                }

                if(arg13.t.c == null) {
                    return;
                }

                v4.b(v9);
                v6.b(v9);
                if(v0 != 0) {
                    v4.b(v6, v11, arg13.i());
                    v6.b(v4, 1, arg13.i());
                    arg13.i().a(((l)v4));
                    arg13.h().a(((l)v6));
                }
                else {
                    v4.b(v6, ((float)(-arg13.q())));
                    v6.b(v4, ((float)arg13.q()));
                }

                if(arg13.K <= 0) {
                    return;
                }

                arg13.u.a().a(1, v4, arg13.K);
            }
            else {
                if(arg13.A[1] != a.c) {
                    return;
                }

                if(!h.a(arg13, 1)) {
                    return;
                }

                v2 = arg13.q();
                v4.b(1);
                v6.b(1);
                if(arg13.r.c == null && arg13.t.c == null) {
                    if(v0 != 0) {
                        v6.a(v4, 1, arg13.i());
                    }
                    else {
                        v6.a(v4, v2);
                    }

                    return;
                }

                if(arg13.r.c != null && arg13.t.c == null) {
                    if(v0 != 0) {
                        v6.a(v4, 1, arg13.i());
                    }
                    else {
                        v6.a(v4, v2);
                    }

                    return;
                }

                if(arg13.r.c == null && arg13.t.c != null) {
                    if(v0 != 0) {
                        v4.a(v6, v11, arg13.i());
                    }
                    else {
                        v4.a(v6, -v2);
                    }

                    return;
                }

                if(arg13.r.c == null) {
                    return;
                }

                if(arg13.t.c == null) {
                    return;
                }

                if(v0 != 0) {
                    arg13.i().a(((l)v4));
                    arg13.h().a(((l)v6));
                }

                if(arg13.E == 0f) {
                    v4.b(3);
                    v6.b(3);
                    v4.b(v6, 0f);
                    v6.b(v4, 0f);
                    return;
                }

                v4.b(v9);
                v6.b(v9);
                v4.b(v6, ((float)(-v2)));
                v6.b(v4, ((float)v2));
                arg13.i(v2);
                if(arg13.K <= 0) {
                    return;
                }

                arg13.u.a().a(1, v4, arg13.K);
            }
        }
    }

    static boolean a(e arg19, android.support.constraint.a.e arg20, int arg21, int arg22, d arg23) {
        float v2_3;
        float v3_3;
        float v5_1;
        d v6_2;
        boolean v2_1;
        d v18;
        d v12;
        int v8_1;
        int v4_1;
        int v3_2;
        d v7;
        d v3_1;
        int v2;
        d v11 = null;
        d v8 = null;
        int v5 = 0;
        int v16 = 0;
        float v15 = 0f;
        d v13 = null;
        d v14 = null;
        if(arg21 != 0 || !arg19.K()) {
            v4 = arg23;
            v7 = arg23;
        }
        else {
            v2 = 0;
            d v4;
            for(v4 = arg23; v2 == 0; v4 = v3_1) {
                c v3 = v4.y[arg22 + 1].c;
                if(v3 != null) {
                    v3_1 = v3.a;
                    if(v3_1.y[arg22].c != null && v3_1.y[arg22].c.a == v4) {
                        goto label_33;
                    }

                    v3_1 = null;
                }
                else {
                    v3_1 = null;
                }

            label_33:
                if(v3_1 == null) {
                    v2 = 1;
                    v3_1 = v4;
                }
            }

            v5 = 0;
            v7 = arg23;
        }

        if(arg21 == 0) {
            v2 = v4.S == 0 ? 1 : 0;
            v3_2 = v4.S == 1 ? 1 : 0;
            if(v4.S == 2) {
                v4_1 = 1;
                goto label_55;
            }

            v4_1 = 0;
        }
        else {
            v2 = v4.T == 0 ? 1 : 0;
            v3_2 = v4.T == 1 ? 1 : 0;
            if(v4.T == 2) {
                v4_1 = 1;
                goto label_55;
            }

            v4_1 = 0;
        }

    label_55:
        float v10 = 0f;
        float v9 = 0f;
        int v6 = 0;
        while(v5 == 0) {
            v7.Y[arg21] = null;
            if(v7.k() != 8) {
                if(v8 != null) {
                    v8.Y[arg21] = v7;
                }

                if(v11 == null) {
                    v11 = v7;
                }

                v8_1 = v6 + 1;
                float v6_1 = arg21 == 0 ? (((float)v7.o())) + v10 : (((float)v7.q())) + v10;
                if(v7 != v11) {
                    v6_1 += ((float)v7.y[arg22].e());
                }

                v9 = v9 + (((float)v7.y[arg22].e())) + (((float)v7.y[arg22 + 1].e()));
                v10 = v6_1;
                v12 = v11;
                v11 = v7;
            }
            else {
                v12 = v11;
                v11 = v8;
                v8_1 = v6;
            }

            v7.X[arg21] = null;
            if(v7.k() == 8 || v7.A[arg21] != a.c) {
                v18 = v14;
                v14 = v13;
                v13 = v18;
            }
            else {
                ++v16;
                if(arg21 == 0) {
                    if(v7.e != 0) {
                        v2_1 = false;
                    }
                    else {
                        if(v7.g == 0 && v7.h == 0) {
                            goto label_160;
                        }

                        v2_1 = false;
                    }

                    return v2_1;
                }
                else {
                    if(v7.f != 0) {
                        return false;
                    }

                    if(v7.j == 0 && v7.k == 0) {
                        goto label_160;
                    }

                    return false;
                }

            label_160:
                v15 += v7.W[arg21];
                if(v13 == null) {
                    v6_2 = v7;
                }
                else {
                    v14.X[arg21] = v7;
                    v6_2 = v13;
                }

                v13 = v7;
                v14 = v6_2;
                goto label_167;
                return false;
            }

        label_167:
            c v6_3 = v7.y[arg22 + 1].c;
            if(v6_3 != null) {
                v6_2 = v6_3.a;
                if(v6_2.y[arg22].c != null && v6_2.y[arg22].c.a == v7) {
                    goto label_192;
                }

                v6_2 = null;
            }
            else {
                v6_2 = null;
            }

        label_192:
            if(v6_2 == null) {
                v5 = 1;
                v6_2 = v7;
            }

            v7 = v6_2;
            v6 = v8_1;
            v8 = v11;
            v11 = v12;
            v18 = v14;
            v14 = v13;
            v13 = v18;
        }

        j v14_1 = arg23.y[arg22].a();
        j v12_1 = v7.y[arg22 + 1].a();
        if(v14_1.c != null && v12_1.c != null) {
            if(v14_1.c.i != 1 && v12_1.c.i != 1) {
                return false;
            }

            if(v16 > 0 && v16 != v6) {
                return false;
            }

            v5_1 = 0f;
            if(v4_1 != 0 || v2 != 0 || v3_2 != 0) {
                if(v11 != null) {
                    v5_1 = ((float)v11.y[arg22].e());
                }

                if(v8 == null) {
                    goto label_255;
                }

                v5_1 += ((float)v8.y[arg22 + 1].e());
            }

        label_255:
            float v13_1 = v14_1.c.f;
            float v12_2 = v12_1.c.f;
            v12_2 = v13_1 < v12_2 ? v12_2 - v13_1 - v10 : v13_1 - v12_2 - v10;
            if(v16 > 0 && v16 == v6) {
                if(v7.j() != null && v7.j().A[arg21] == a.b) {
                    return false;
                }

                v3_3 = v12_2 + v10 - v9;
                v5_1 = v2 != 0 ? v3_3 - (v9 - v5_1) : v3_3;
                if(v2 != 0) {
                    v3_3 = v13_1 + (((float)v11.y[arg22 + 1].e()));
                    d v2_2 = v11.Y[arg21];
                    if(v2_2 != null) {
                        v3_3 += ((float)v2_2.y[arg22].e());
                    }
                }
                else {
                    v3_3 = v13_1;
                }

                goto label_298;
            }

            if(v12_2 < v10) {
                return false;
            }

            if(v4_1 != 0) {
                v3_3 = v13_1 + (v12_2 - v5_1) * arg23.y();
                goto label_377;
            }
            else {
                if(v2 == 0 && v3_2 == 0) {
                    return true;
                }

                if(v2 != 0) {
                    v5_1 = v12_2 - v5_1;
                }
                else if(v3_2 != 0) {
                    v5_1 = v12_2 - v5_1;
                }
                else {
                    v5_1 = v12_2;
                }

                float v4_2 = v5_1 / (((float)(v6 + 1)));
                if(v3_2 == 0) {
                    v5_1 = v4_2;
                }
                else if(v6 > 1) {
                    v5_1 /= ((float)(v6 - 1));
                }
                else {
                    v5_1 /= 2f;
                }

                v4_2 = v13_1 + v5_1;
                v3_3 = v3_2 == 0 || v6 <= 1 ? v4_2 : (((float)v11.y[arg22].e())) + v13_1;
                if(v2 != 0 && v11 != null) {
                    v3_3 += ((float)v11.y[arg22].e());
                }

                goto label_474;
            }
        }

        return false;
        while(true) {
        label_474:
            if(v11 == null) {
                return true;
            }

            if(android.support.constraint.a.e.g != null) {
                --android.support.constraint.a.e.g.B;
                ++android.support.constraint.a.e.g.s;
                ++android.support.constraint.a.e.g.y;
            }

            v4 = v11.Y[arg21];
            if(v4 != null || v11 == v8) {
                v2_3 = arg21 == 0 ? ((float)v11.o()) : ((float)v11.q());
                v11.y[arg22].a().a(v14_1.e, v3_3);
                v11.y[arg22 + 1].a().a(v14_1.e, v3_3 + v2_3);
                v11.y[arg22].a().a(arg20);
                v11.y[arg22 + 1].a().a(arg20);
                v2_3 = v2_3 + v5_1 + v3_3;
            }
            else {
                v2_3 = v3_3;
            }

            v3_3 = v2_3;
            v11 = v4;
        }

    label_298:
        while(v11 != null) {
            if(android.support.constraint.a.e.g != null) {
                --android.support.constraint.a.e.g.B;
                ++android.support.constraint.a.e.g.s;
                ++android.support.constraint.a.e.g.y;
            }

            v4 = v11.Y[arg21];
            if(v4 != null || v11 == v8) {
                v2_3 = v5_1 / (((float)v16));
                if(v15 > 0f) {
                    v2_3 = v11.W[arg21] * v5_1 / v15;
                }

                v3_3 += ((float)v11.y[arg22].e());
                v11.y[arg22].a().a(v14_1.e, v3_3);
                v11.y[arg22 + 1].a().a(v14_1.e, v3_3 + v2_3);
                v11.y[arg22].a().a(arg20);
                v11.y[arg22 + 1].a().a(arg20);
                v2_3 = v2_3 + v3_3 + (((float)v11.y[arg22 + 1].e()));
            }
            else {
                v2_3 = v3_3;
            }

            v3_3 = v2_3;
            v11 = v4;
        }

        return true;
    label_377:
        while(v11 != null) {
            if(android.support.constraint.a.e.g != null) {
                --android.support.constraint.a.e.g.B;
                ++android.support.constraint.a.e.g.s;
                ++android.support.constraint.a.e.g.y;
            }

            v4 = v11.Y[arg21];
            if(v4 != null || v11 == v8) {
                v2_3 = arg21 == 0 ? ((float)v11.o()) : ((float)v11.q());
                v3_3 += ((float)v11.y[arg22].e());
                v11.y[arg22].a().a(v14_1.e, v3_3);
                v11.y[arg22 + 1].a().a(v14_1.e, v3_3 + v2_3);
                v11.y[arg22].a().a(arg20);
                v11.y[arg22 + 1].a().a(arg20);
                v2_3 = v2_3 + v3_3 + (((float)v11.y[arg22 + 1].e()));
            }
            else {
                v2_3 = v3_3;
            }

            v3_3 = v2_3;
            v11 = v4;
        }

        return true;
    }

    static void a(e arg6, android.support.constraint.a.e arg7, d arg8) {
        int v1;
        int v0;
        int v5 = 2;
        if(arg6.A[0] != a.b && arg8.A[0] == a.d) {
            v0 = arg8.q.d;
            v1 = arg6.o() - arg8.s.d;
            arg8.q.f = arg7.a(arg8.q);
            arg8.s.f = arg7.a(arg8.s);
            arg7.a(arg8.q.f, v0);
            arg7.a(arg8.s.f, v1);
            arg8.a = v5;
            arg8.c(v0, v1);
        }

        if(arg6.A[1] != a.b && arg8.A[1] == a.d) {
            v0 = arg8.r.d;
            v1 = arg6.q() - arg8.t.d;
            arg8.r.f = arg7.a(arg8.r);
            arg8.t.f = arg7.a(arg8.t);
            arg7.a(arg8.r.f, v0);
            arg7.a(arg8.t.f, v1);
            if(arg8.K > 0 || arg8.k() == 8) {
                arg8.u.f = arg7.a(arg8.u);
                arg7.a(arg8.u.f, arg8.K + v0);
            }

            arg8.b = v5;
            arg8.d(v0, v1);
        }
    }

    private static boolean a(d arg4, int arg5) {
        boolean v1 = false;
        if(arg4.A[arg5] == a.c) {
            if(arg4.E != 0f) {
            }
            else {
                if(arg5 == 0) {
                    if(arg4.e != 0) {
                        return v1;
                    }
                    else if(arg4.g != 0) {
                        return v1;
                    }
                    else if(arg4.h != 0) {
                        return v1;
                    }
                }
                else if(arg4.f != 0) {
                    return v1;
                }
                else if(arg4.j != 0) {
                    return v1;
                }
                else if(arg4.k != 0) {
                    return v1;
                }

                v1 = true;
            }
        }

        return v1;
    }
}

