package android.support.constraint.a.a;

class b {
    static void a(e arg6, android.support.constraint.a.e arg7, int arg8) {
        int v2;
        d[] v0;
        int v1;
        int v3 = 0;
        if(arg8 == 0) {
            v1 = arg6.ag;
            v0 = arg6.aj;
            v2 = 0;
        }
        else {
            v2 = 2;
            v1 = arg6.ah;
            v0 = arg6.ai;
        }

        while(v3 < v1) {
            d v4 = v0[v3];
            if(!arg6.q(4)) {
                b.a(arg6, arg7, arg8, v2, v4);
            }
            else if(!h.a(arg6, arg7, arg8, v2, v4)) {
                b.a(arg6, arg7, arg8, v2, v4);
            }

            ++v3;
        }
    }

    static void a(e arg23, android.support.constraint.a.e arg24, int arg25, int arg26, d arg27) {
        c v9_2;
        c v7_3;
        android.support.constraint.a.h v3_4;
        android.support.constraint.a.h v4_4;
        c v6_3;
        d v16_1;
        d v11_1;
        int v6_2;
        float v7_2;
        android.support.constraint.a.h v5_3;
        c v3_3;
        android.support.constraint.a.h v9_1;
        android.support.constraint.a.h v8_2;
        d v15;
        float v8_1;
        d v22;
        d v6;
        float v5_2;
        int v18;
        int v17;
        int v16;
        int v5_1;
        int v4_2;
        d v12;
        d v19;
        d v4_1;
        c v4;
        int v3;
        d v13 = null;
        d v14 = null;
        int v10 = 0;
        int v9 = 0;
        d v7 = null;
        d v8 = null;
        int v11 = arg23.A[arg25] == a.b ? 1 : 0;
        if(arg25 != 0 || !arg23.K()) {
            v19 = arg27;
            v12 = arg27;
        }
        else {
            v3 = 0;
            d v5;
            for(v5 = arg27; v3 == 0; v5 = v4_1) {
                v4 = v5.y[arg26 + 1].c;
                if(v4 != null) {
                    v4_1 = v4.a;
                    if(v4_1.y[arg26].c != null && v4_1.y[arg26].c.a == v5) {
                        goto label_36;
                    }

                    v4_1 = null;
                }
                else {
                    v4_1 = null;
                }

            label_36:
                if(v4_1 == null) {
                    v3 = 1;
                    v4_1 = v5;
                }
            }

            v10 = 0;
            v19 = v5;
            v12 = arg27;
        }

        if(arg25 == 0) {
            v3 = v19.S == 0 ? 1 : 0;
            v4_2 = v19.S == 1 ? 1 : 0;
            v5_1 = v19.S == 2 ? 1 : 0;
            v16 = v5_1;
            v17 = v4_2;
            v18 = v3;
            v5_2 = 0f;
            v3 = v10;
        }
        else {
            v3 = v19.T == 0 ? 1 : 0;
            v4_2 = v19.T == 1 ? 1 : 0;
            v5_1 = v19.T == 2 ? 1 : 0;
            v16 = v5_1;
            v17 = v4_2;
            v18 = v3;
            v5_2 = 0f;
            v3 = v10;
        }

        while(v3 == 0) {
            v12.Y[arg25] = null;
            if(v12.k() != 8) {
                if(v14 != null) {
                    v14.Y[arg25] = v12;
                }

                v4_1 = v13 == null ? v12 : v13;
                v6 = v12;
                v13 = v4_1;
            }
            else {
                v6 = v14;
            }

            c v14_1 = v12.y[arg26];
            v4_2 = 1;
            v10 = v14_1.e();
            if(v14_1.c != null && v12 != arg27 && v12.k() != 8) {
                v10 += v14_1.c.e();
            }

            if(v16 != 0 && v12 != arg27 && v12 != v13) {
                v4_2 = 6;
            }

            if(v12 == v13) {
                arg24.a(v14_1.f, v14_1.c.f, v10, 5);
            }
            else {
                arg24.a(v14_1.f, v14_1.c.f, v10, 6);
            }

            arg24.c(v14_1.f, v14_1.c.f, v10, v4_2);
            v12.X[arg25] = null;
            if(v12.k() == 8 || v12.A[arg25] != a.c) {
                v22 = v8;
                v8_1 = v5_2;
                v5 = v22;
            }
            else {
                v4_2 = v9 + 1;
                v5_2 += v12.W[arg25];
                if(v7 == null) {
                    v7 = v12;
                }
                else {
                    v8.X[arg25] = v12;
                }

                if(v11 != 0) {
                    arg24.a(v12.y[arg26 + 1].f, v12.y[arg26].f, 0, 6);
                }

                v8_1 = v5_2;
                v9 = v4_2;
                v5 = v12;
            }

            if(v11 != 0) {
                arg24.a(v12.y[arg26].f, arg23.y[arg26].f, 0, 6);
            }

            v4 = v12.y[arg26 + 1].c;
            if(v4 != null) {
                v4_1 = v4.a;
                if(v4_1.y[arg26].c != null && v4_1.y[arg26].c.a == v12) {
                    goto label_180;
                }

                v4_1 = null;
            }
            else {
                v4_1 = null;
            }

        label_180:
            if(v4_1 == null) {
                v3 = 1;
                v4_1 = v12;
            }

            v14 = v6;
            v12 = v4_1;
            v22 = v5;
            v5_2 = v8_1;
            v8 = v22;
        }

        if(v14 != null && v12.y[arg26 + 1].c != null) {
            arg24.b(v14.y[arg26 + 1].f, v12.y[arg26 + 1].c.f, -v14.y[arg26 + 1].e(), 5);
        }

        if(v11 != 0) {
            arg24.a(arg23.y[arg26 + 1].f, v12.y[arg26 + 1].f, v12.y[arg26 + 1].e(), 6);
        }

        if(v9 > 0) {
            d v3_1;
            for(v3_1 = v7; v3_1 != null; v3_1 = v15) {
                v15 = v3_1.X[arg25];
                if(v15 != null) {
                    float v4_3 = v3_1.W[arg25];
                    float v6_1 = v15.W[arg25];
                    android.support.constraint.a.h v7_1 = v3_1.y[arg26].f;
                    v8_2 = v3_1.y[arg26 + 1].f;
                    v9_1 = v15.y[arg26].f;
                    android.support.constraint.a.h v10_1 = v15.y[arg26 + 1].f;
                    if(arg25 == 0) {
                        v11 = v3_1.e;
                        v3 = v15.e;
                    }
                    else {
                        v11 = v3_1.f;
                        v3 = v15.f;
                    }

                    if(v11 == 0 || v11 == 3) {
                        if(v3 != 0 && v3 != 3) {
                        label_321:
                            v3 = 0;
                            goto label_311;
                        }

                        v3 = 1;
                    }
                    else {
                        goto label_321;
                    }

                label_311:
                    if(v3 == 0) {
                        goto label_316;
                    }

                    android.support.constraint.a.b v3_2 = arg24.c();
                    v3_2.a(v4_3, v5_2, v6_1, v7_1, v8_2, v9_1, v10_1);
                    arg24.a(v3_2);
                }

            label_316:
            }
        }

        if(v13 != null) {
            if(v13 != v14 && v16 == 0) {
                goto label_422;
            }

            v4 = arg27.y[arg26];
            v3_3 = v12.y[arg26 + 1];
            v5_3 = arg27.y[arg26].c != null ? arg27.y[arg26].c.f : null;
            v8_2 = v12.y[arg26 + 1].c != null ? v12.y[arg26 + 1].c.f : null;
            if(v13 == v14) {
                v4 = v13.y[arg26];
                v3_3 = v13.y[arg26 + 1];
            }

            if(v5_3 != null && v8_2 != null) {
                v7_2 = arg25 == 0 ? v19.O : v19.P;
                v6_2 = v4.e();
                if(v14 == null) {
                    v14 = v12;
                }

                arg24.a(v4.f, v5_3, v6_2, v7_2, v8_2, v3_3.f, v14.y[arg26 + 1].e(), 5);
            }

            v3_1 = v14;
        }
        else {
        label_422:
            if(v18 != 0 && v13 != null) {
                v11_1 = v13;
                for(v15 = v13; v15 != null; v15 = v16_1) {
                    v16_1 = v15.Y[arg25];
                    if(v16_1 != null || v15 == v14) {
                        v6_3 = v15.y[arg26];
                        v4_4 = v6_3.f;
                        v5_3 = v6_3.c != null ? v6_3.c.f : null;
                        if(v11_1 != v15) {
                            v5_3 = v11_1.y[arg26 + 1].f;
                        }
                        else if(v15 == v13 && v11_1 == v15) {
                            v3_4 = arg27.y[arg26].c != null ? arg27.y[arg26].c.f : null;
                            v5_3 = v3_4;
                        }

                        v3_4 = null;
                        v6_2 = v6_3.e();
                        v10 = v15.y[arg26 + 1].e();
                        if(v16_1 != null) {
                            v7_3 = v16_1.y[arg26];
                            v8_2 = v7_3.f;
                            v3_4 = v7_3.c != null ? v7_3.c.f : null;
                            v9_1 = v3_4;
                            v3_3 = v7_3;
                        }
                        else {
                            v7_3 = v12.y[arg26 + 1].c;
                            if(v7_3 != null) {
                                v3_4 = v7_3.f;
                            }

                            v9_1 = v15.y[arg26 + 1].f;
                            v8_2 = v3_4;
                            v3_3 = v7_3;
                        }

                        if(v3_3 != null) {
                            v10 += v3_3.e();
                        }

                        if(v11_1 != null) {
                            v6_2 += v11_1.y[arg26 + 1].e();
                        }

                        if(v4_4 == null) {
                            goto label_486;
                        }

                        if(v5_3 == null) {
                            goto label_486;
                        }

                        if(v8_2 == null) {
                            goto label_486;
                        }

                        if(v9_1 == null) {
                            goto label_486;
                        }

                        if(v15 == v13) {
                            v6_2 = v13.y[arg26].e();
                        }

                        if(v15 == v14) {
                            v10 = v14.y[arg26 + 1].e();
                        }

                        arg24.a(v4_4, v5_3, v6_2, 0.5f, v8_2, v9_1, v10, 4);
                    }

                label_486:
                    v11_1 = v15;
                }

                v3_1 = v14;
                goto label_376;
            }

            if(v17 != 0 && v13 != null) {
                v11_1 = v13;
                for(v16_1 = v13; v16_1 != null; v16_1 = v15) {
                    v3_1 = v16_1.Y[arg25];
                    if(v16_1 == v13 || v16_1 == v14 || v3_1 == null) {
                        v15 = v3_1;
                    }
                    else {
                        v15 = v3_1 == v14 ? null : v3_1;
                        v6_3 = v16_1.y[arg26];
                        v4_4 = v6_3.f;
                        v5_3 = v11_1.y[arg26 + 1].f;
                        v3_4 = null;
                        v6_2 = v6_3.e();
                        v10 = v16_1.y[arg26 + 1].e();
                        if(v15 != null) {
                            v7_3 = v15.y[arg26];
                            v8_2 = v7_3.f;
                            v3_4 = v7_3.c != null ? v7_3.c.f : null;
                            v9_1 = v3_4;
                            v3_3 = v7_3;
                        }
                        else {
                            v7_3 = v16_1.y[arg26 + 1].c;
                            if(v7_3 != null) {
                                v3_4 = v7_3.f;
                            }

                            v9_1 = v16_1.y[arg26 + 1].f;
                            v8_2 = v3_4;
                            v3_3 = v7_3;
                        }

                        if(v3_3 != null) {
                            v10 += v3_3.e();
                        }

                        if(v11_1 != null) {
                            v6_2 += v11_1.y[arg26 + 1].e();
                        }

                        if(v4_4 == null) {
                            goto label_586;
                        }

                        if(v5_3 == null) {
                            goto label_586;
                        }

                        if(v8_2 == null) {
                            goto label_586;
                        }

                        if(v9_1 == null) {
                            goto label_586;
                        }

                        arg24.a(v4_4, v5_3, v6_2, 0.5f, v8_2, v9_1, v10, 4);
                    }

                label_586:
                    v11_1 = v16_1;
                }

                v3_3 = v13.y[arg26];
                c v5_4 = arg27.y[arg26].c;
                c v15_1 = v14.y[arg26 + 1];
                c v16_2 = v12.y[arg26 + 1].c;
                if(v5_4 != null) {
                    if(v13 != v14) {
                        arg24.c(v3_3.f, v5_4.f, v3_3.e(), 5);
                    }
                    else if(v16_2 != null) {
                        arg24.a(v3_3.f, v5_4.f, v3_3.e(), 0.5f, v15_1.f, v16_2.f, v15_1.e(), 5);
                    }
                }

                if(v16_2 == null) {
                    goto label_638;
                }

                if(v13 == v14) {
                    goto label_638;
                }

                arg24.c(v15_1.f, v16_2.f, -v15_1.e(), 5);
            }

        label_638:
            v3_1 = v14;
        }

    label_376:
        if((v18 != 0 || v17 != 0) && v13 != null) {
            v6_3 = v13.y[arg26];
            v4 = v3_1.y[arg26 + 1];
            v5_3 = v6_3.c != null ? v6_3.c.f : null;
            v8_2 = v4.c != null ? v4.c.f : null;
            if(v13 == v3_1) {
                v6_3 = v13.y[arg26];
                v9_2 = v13.y[arg26 + 1];
                v4 = v6_3;
            }
            else {
                v9_2 = v4;
                v4 = v6_3;
            }

            if(v5_3 == null) {
                return;
            }

            if(v8_2 == null) {
                return;
            }

            v7_2 = 0.5f;
            v6_2 = v4.e();
            if(v3_1 != null) {
                v12 = v3_1;
            }

            arg24.a(v4.f, v5_3, v6_2, v7_2, v8_2, v9_2.f, v12.y[arg26 + 1].e(), 5);
        }
    }
}

