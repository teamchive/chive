package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build$VERSION;
import android.support.constraint.a.a.d;
import android.support.constraint.a.a.e;
import android.support.constraint.a.a.f;
import android.support.constraint.a.a.j;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    public class a extends ViewGroup$MarginLayoutParams {
        class android.support.constraint.ConstraintLayout$a$a {
            public static final SparseIntArray a;

            static {
                android.support.constraint.ConstraintLayout$a$a.a = new SparseIntArray();
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintCircle, 2);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_android_orientation, 1);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 0x2F);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 0x30);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintWidth_default, 0x1F);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintHeight_default, 0x20);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                android.support.constraint.ConstraintLayout$a$a.a.append(b.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public float A;
        public String B;
        float C;
        int D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public float O;
        public float P;
        public int Q;
        public int R;
        public int S;
        public boolean T;
        public boolean U;
        boolean V;
        boolean W;
        boolean X;
        boolean Y;
        boolean Z;
        public int a;
        boolean aa;
        int ab;
        int ac;
        int ad;
        int ae;
        int af;
        int ag;
        float ah;
        int ai;
        int aj;
        float ak;
        d al;
        public boolean am;
        public int b;
        public float c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public float o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public float z;

        public a(int arg7, int arg8) {
            super(arg7, arg8);
            this.a = -1;
            this.b = -1;
            this.c = -1f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0f;
            this.D = 1;
            this.E = 0f;
            this.F = 0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1f;
            this.P = 1f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ab = -1;
            this.ac = -1;
            this.ad = -1;
            this.ae = -1;
            this.af = -1;
            this.ag = -1;
            this.ah = 0.5f;
            this.al = new d();
            this.am = false;
        }

        public a(Context arg13, AttributeSet arg14) {
            float v5_3;
            float v0_3;
            String v0_1;
            int v10 = -2;
            int v8 = -1;
            super(arg13, arg14);
            this.a = v8;
            this.b = v8;
            this.c = -1f;
            this.d = v8;
            this.e = v8;
            this.f = v8;
            this.g = v8;
            this.h = v8;
            this.i = v8;
            this.j = v8;
            this.k = v8;
            this.l = v8;
            this.m = v8;
            this.n = 0;
            this.o = 0f;
            this.p = v8;
            this.q = v8;
            this.r = v8;
            this.s = v8;
            this.t = v8;
            this.u = v8;
            this.v = v8;
            this.w = v8;
            this.x = v8;
            this.y = v8;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0f;
            this.D = 1;
            this.E = 0f;
            this.F = 0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1f;
            this.P = 1f;
            this.Q = v8;
            this.R = v8;
            this.S = v8;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ab = v8;
            this.ac = v8;
            this.ad = v8;
            this.ae = v8;
            this.af = v8;
            this.ag = v8;
            this.ah = 0.5f;
            this.al = new d();
            this.am = false;
            TypedArray v3 = arg13.obtainStyledAttributes(arg14, b.ConstraintLayout_Layout);
            int v4 = v3.getIndexCount();
            int v2;
            for(v2 = 0; v2 < v4; ++v2) {
                int v0 = v3.getIndex(v2);
                switch(android.support.constraint.ConstraintLayout$a$a.a.get(v0)) {
                    case 1: {
                        goto label_207;
                    }
                    case 2: {
                        goto label_161;
                    }
                    case 3: {
                        goto label_169;
                    }
                    case 4: {
                        goto label_173;
                    }
                    case 5: {
                        goto label_195;
                    }
                    case 6: {
                        goto label_199;
                    }
                    case 7: {
                        goto label_203;
                    }
                    case 8: {
                        goto label_89;
                    }
                    case 9: {
                        goto label_97;
                    }
                    case 10: {
                        goto label_105;
                    }
                    case 11: {
                        goto label_113;
                    }
                    case 12: {
                        goto label_121;
                    }
                    case 13: {
                        goto label_129;
                    }
                    case 14: {
                        goto label_137;
                    }
                    case 15: {
                        goto label_145;
                    }
                    case 16: {
                        goto label_153;
                    }
                    case 17: {
                        goto label_211;
                    }
                    case 18: {
                        goto label_219;
                    }
                    case 19: {
                        goto label_227;
                    }
                    case 20: {
                        goto label_235;
                    }
                    case 21: {
                        goto label_243;
                    }
                    case 22: {
                        goto label_247;
                    }
                    case 23: {
                        goto label_251;
                    }
                    case 24: {
                        goto label_255;
                    }
                    case 25: {
                        goto label_259;
                    }
                    case 26: {
                        goto label_263;
                    }
                    case 27: {
                        goto label_356;
                    }
                    case 28: {
                        goto label_360;
                    }
                    case 29: {
                        goto label_267;
                    }
                    case 30: {
                        goto label_271;
                    }
                    case 31: {
                        goto label_364;
                    }
                    case 32: {
                        goto label_372;
                    }
                    case 33: {
                        goto label_380;
                    }
                    case 34: {
                        goto label_390;
                    }
                    case 35: {
                        goto label_400;
                    }
                    case 36: {
                        goto label_405;
                    }
                    case 37: {
                        goto label_415;
                    }
                    case 38: {
                        goto label_425;
                    }
                    case 44: {
                        goto label_275;
                    }
                    case 45: {
                        goto label_344;
                    }
                    case 46: {
                        goto label_347;
                    }
                    case 47: {
                        goto label_350;
                    }
                    case 48: {
                        goto label_353;
                    }
                    case 49: {
                        goto label_187;
                    }
                    case 50: {
                        goto label_191;
                    }
                }

                goto label_86;
            label_161:
                this.m = v3.getResourceId(v0, this.m);
                if(this.m != v8) {
                    goto label_86;
                }

                this.m = v3.getInt(v0, v8);
                goto label_86;
            label_97:
                this.e = v3.getResourceId(v0, this.e);
                if(this.e != v8) {
                    goto label_86;
                }

                this.e = v3.getInt(v0, v8);
                goto label_86;
            label_353:
                this.H = v3.getInt(v0, 0);
                goto label_86;
            label_227:
                this.r = v3.getResourceId(v0, this.r);
                if(this.r != v8) {
                    goto label_86;
                }

                this.r = v3.getInt(v0, v8);
                goto label_86;
            label_356:
                this.T = v3.getBoolean(v0, this.T);
                goto label_86;
            label_360:
                this.U = v3.getBoolean(v0, this.U);
                goto label_86;
            label_169:
                this.n = v3.getDimensionPixelSize(v0, this.n);
                goto label_86;
            label_105:
                this.f = v3.getResourceId(v0, this.f);
                if(this.f != v8) {
                    goto label_86;
                }

                this.f = v3.getInt(v0, v8);
                goto label_86;
            label_425:
                this.P = Math.max(0f, v3.getFloat(v0, this.P));
                goto label_86;
            label_235:
                this.s = v3.getResourceId(v0, this.s);
                if(this.s != v8) {
                    goto label_86;
                }

                this.s = v3.getInt(v0, v8);
                goto label_86;
            label_364:
                this.I = v3.getInt(v0, 0);
                if(this.I != 1) {
                    goto label_86;
                }

                Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                goto label_86;
            label_173:
                this.o = v3.getFloat(v0, this.o) % 360f;
                if(this.o >= 0f) {
                    goto label_86;
                }

                this.o = (360f - this.o) % 360f;
                goto label_86;
            label_113:
                this.g = v3.getResourceId(v0, this.g);
                if(this.g != v8) {
                    goto label_86;
                }

                this.g = v3.getInt(v0, v8);
                goto label_86;
            label_243:
                this.t = v3.getDimensionPixelSize(v0, this.t);
                goto label_86;
            label_372:
                this.J = v3.getInt(v0, 0);
                if(this.J != 1) {
                    goto label_86;
                }

                Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                goto label_86;
            label_247:
                this.u = v3.getDimensionPixelSize(v0, this.u);
                goto label_86;
            label_121:
                this.h = v3.getResourceId(v0, this.h);
                if(this.h != v8) {
                    goto label_86;
                }

                this.h = v3.getInt(v0, v8);
                goto label_86;
            label_251:
                this.v = v3.getDimensionPixelSize(v0, this.v);
                goto label_86;
            label_187:
                this.Q = v3.getDimensionPixelOffset(v0, this.Q);
                goto label_86;
                try {
                label_380:
                    this.K = v3.getDimensionPixelSize(v0, this.K);
                }
                catch(Exception v5) {
                    if(v3.getInt(v0, this.K) != v10) {
                        goto label_86;
                    }

                    this.K = v10;
                }

                goto label_86;
            label_255:
                this.w = v3.getDimensionPixelSize(v0, this.w);
                goto label_86;
            label_191:
                this.R = v3.getDimensionPixelOffset(v0, this.R);
                goto label_86;
            label_129:
                this.i = v3.getResourceId(v0, this.i);
                if(this.i != v8) {
                    goto label_86;
                }

                this.i = v3.getInt(v0, v8);
                goto label_86;
            label_195:
                this.a = v3.getDimensionPixelOffset(v0, this.a);
                goto label_86;
            label_259:
                this.x = v3.getDimensionPixelSize(v0, this.x);
                goto label_86;
                try {
                label_390:
                    this.M = v3.getDimensionPixelSize(v0, this.M);
                }
                catch(Exception v5) {
                    if(v3.getInt(v0, this.M) != v10) {
                        goto label_86;
                    }

                    this.M = v10;
                }

                goto label_86;
            label_199:
                this.b = v3.getDimensionPixelOffset(v0, this.b);
                goto label_86;
            label_263:
                this.y = v3.getDimensionPixelSize(v0, this.y);
                goto label_86;
            label_137:
                this.j = v3.getResourceId(v0, this.j);
                if(this.j != v8) {
                    goto label_86;
                }

                this.j = v3.getInt(v0, v8);
                goto label_86;
            label_203:
                this.c = v3.getFloat(v0, this.c);
                goto label_86;
            label_267:
                this.z = v3.getFloat(v0, this.z);
                goto label_86;
            label_207:
                this.S = v3.getInt(v0, this.S);
                goto label_86;
            label_271:
                this.A = v3.getFloat(v0, this.A);
                goto label_86;
            label_400:
                this.O = Math.max(0f, v3.getFloat(v0, this.O));
                goto label_86;
            label_145:
                this.k = v3.getResourceId(v0, this.k);
                if(this.k != v8) {
                    goto label_86;
                }

                this.k = v3.getInt(v0, v8);
                goto label_86;
            label_211:
                this.p = v3.getResourceId(v0, this.p);
                if(this.p != v8) {
                    goto label_86;
                }

                this.p = v3.getInt(v0, v8);
                goto label_86;
            label_275:
                this.B = v3.getString(v0);
                this.C = NaNf;
                this.D = v8;
                if(this.B == null) {
                    goto label_86;
                }

                int v5_1 = this.B.length();
                v0 = this.B.indexOf(44);
                if(v0 <= 0 || v0 >= v5_1 - 1) {
                    v0 = 0;
                }
                else {
                    String v6 = this.B.substring(0, v0);
                    if(v6.equalsIgnoreCase("W")) {
                        this.D = 0;
                    }
                    else if(v6.equalsIgnoreCase("H")) {
                        this.D = 1;
                    }

                    ++v0;
                }

                int v6_1 = this.B.indexOf(58);
                if(v6_1 >= 0 && v6_1 < v5_1 - 1) {
                    v0_1 = this.B.substring(v0, v6_1);
                    String v5_2 = this.B.substring(v6_1 + 1);
                    if(v0_1.length() <= 0) {
                    }
                    else if(v5_2.length() > 0) {
                        try {
                            v0_3 = Float.parseFloat(v0_1);
                            v5_3 = Float.parseFloat(v5_2);
                            if(v0_3 <= 0f) {
                                goto label_86;
                            }
                            else if(v5_3 <= 0f) {
                                goto label_86;
                            }
                            else if(this.D == 1) {
                                this.C = Math.abs(v5_3 / v0_3);
                                goto label_86;
                            }
                            else {
                            }
                        }
                        catch(NumberFormatException v0_2) {
                            goto label_323;
                        }

                        v0_3 /= v5_3;
                        try {
                            this.C = Math.abs(v0_3);
                        }
                        catch(NumberFormatException v0_2) {
                        label_323:
                        }
                    }
                    else {
                    }

                    goto label_86;
                }

                v0_1 = this.B.substring(v0);
                if(v0_1.length() <= 0) {
                    goto label_86;
                }

                try {
                    this.C = Float.parseFloat(v0_1);
                }
                catch(NumberFormatException v0_2) {
                }

                goto label_86;
                try {
                label_405:
                    this.L = v3.getDimensionPixelSize(v0, this.L);
                }
                catch(Exception v5) {
                    if(v3.getInt(v0, this.L) != v10) {
                        goto label_86;
                    }

                    this.L = v10;
                }

                goto label_86;
            label_344:
                this.E = v3.getFloat(v0, 0f);
                goto label_86;
            label_89:
                this.d = v3.getResourceId(v0, this.d);
                if(this.d != v8) {
                    goto label_86;
                }

                this.d = v3.getInt(v0, v8);
                goto label_86;
            label_153:
                this.l = v3.getResourceId(v0, this.l);
                if(this.l != v8) {
                    goto label_86;
                }

                this.l = v3.getInt(v0, v8);
                goto label_86;
            label_219:
                this.q = v3.getResourceId(v0, this.q);
                if(this.q != v8) {
                    goto label_86;
                }

                this.q = v3.getInt(v0, v8);
                goto label_86;
            label_347:
                this.F = v3.getFloat(v0, 0f);
                goto label_86;
            label_350:
                this.G = v3.getInt(v0, 0);
                goto label_86;
                try {
                label_415:
                    this.N = v3.getDimensionPixelSize(v0, this.N);
                }
                catch(Exception v5) {
                    if(v3.getInt(v0, this.N) != v10) {
                        goto label_86;
                    }

                    this.N = v10;
                }

            label_86:
            }

            v3.recycle();
            this.a();
        }

        public a(ViewGroup$LayoutParams arg7) {
            super(arg7);
            this.a = -1;
            this.b = -1;
            this.c = -1f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0f;
            this.D = 1;
            this.E = 0f;
            this.F = 0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1f;
            this.P = 1f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ab = -1;
            this.ac = -1;
            this.ad = -1;
            this.ae = -1;
            this.af = -1;
            this.ag = -1;
            this.ah = 0.5f;
            this.al = new d();
            this.am = false;
        }

        public void a() {
            int v4 = -1;
            int v3 = -2;
            this.Y = false;
            this.V = true;
            this.W = true;
            if(this.width == v3 && (this.T)) {
                this.V = false;
                this.I = 1;
            }

            if(this.height == v3 && (this.U)) {
                this.W = false;
                this.J = 1;
            }

            if(this.width == 0 || this.width == v4) {
                this.V = false;
                if(this.width == 0 && this.I == 1) {
                    this.width = v3;
                    this.T = true;
                }
            }

            if(this.height == 0 || this.height == v4) {
                this.W = false;
                if(this.height == 0 && this.J == 1) {
                    this.height = v3;
                    this.U = true;
                }
            }

            if(this.c != -1f || this.a != v4 || this.b != v4) {
                this.Y = true;
                this.V = true;
                this.W = true;
                if(!(this.al instanceof f)) {
                    this.al = new f();
                }

                this.al.a(this.S);
            }
        }

        @TargetApi(value=17) public void resolveLayoutDirection(int arg9) {
            int v0 = 0;
            float v7 = 1f;
            float v6 = -1f;
            int v5 = -1;
            int v3 = this.leftMargin;
            int v4 = this.rightMargin;
            super.resolveLayoutDirection(arg9);
            this.ad = v5;
            this.ae = v5;
            this.ab = v5;
            this.ac = v5;
            this.af = v5;
            this.ag = v5;
            this.af = this.t;
            this.ag = this.v;
            this.ah = this.z;
            this.ai = this.a;
            this.aj = this.b;
            this.ak = this.c;
            int v2 = 1 == this.getLayoutDirection() ? 1 : 0;
            if(v2 != 0) {
                if(this.p != v5) {
                    this.ad = this.p;
                    v0 = 1;
                }
                else if(this.q != v5) {
                    this.ae = this.q;
                    v0 = 1;
                }

                if(this.r != v5) {
                    this.ac = this.r;
                    v0 = 1;
                }

                if(this.s != v5) {
                    this.ab = this.s;
                    v0 = 1;
                }

                if(this.x != v5) {
                    this.ag = this.x;
                }

                if(this.y != v5) {
                    this.af = this.y;
                }

                if(v0 != 0) {
                    this.ah = v7 - this.z;
                }

                if(!this.Y) {
                    goto label_68;
                }

                if(this.S != 1) {
                    goto label_68;
                }

                if(this.c != v6) {
                    this.ak = v7 - this.c;
                    this.ai = v5;
                    this.aj = v5;
                    goto label_68;
                }

                if(this.a != v5) {
                    this.aj = this.a;
                    this.ai = v5;
                    this.ak = v6;
                    goto label_68;
                }

                if(this.b == v5) {
                    goto label_68;
                }

                this.ai = this.b;
                this.aj = v5;
                this.ak = v6;
            }
            else {
                if(this.p != v5) {
                    this.ac = this.p;
                }

                if(this.q != v5) {
                    this.ab = this.q;
                }

                if(this.r != v5) {
                    this.ad = this.r;
                }

                if(this.s != v5) {
                    this.ae = this.s;
                }

                if(this.x != v5) {
                    this.af = this.x;
                }

                if(this.y == v5) {
                    goto label_68;
                }

                this.ag = this.y;
            }

        label_68:
            if(this.r == v5 && this.s == v5 && this.q == v5 && this.p == v5) {
                if(this.f != v5) {
                    this.ad = this.f;
                    if(this.rightMargin <= 0 && v4 > 0) {
                        this.rightMargin = v4;
                    }
                }
                else if(this.g != v5) {
                    this.ae = this.g;
                    if(this.rightMargin <= 0 && v4 > 0) {
                        this.rightMargin = v4;
                    }
                }

                if(this.d != v5) {
                    this.ab = this.d;
                    if(this.leftMargin > 0) {
                        return;
                    }

                    if(v3 <= 0) {
                        return;
                    }

                    this.leftMargin = v3;
                    return;
                }

                if(this.e == v5) {
                    return;
                }

                this.ac = this.e;
                if(this.leftMargin > 0) {
                    return;
                }

                if(v3 <= 0) {
                    return;
                }

                this.leftMargin = v3;
            }
        }
    }

    SparseArray a;
    e b;
    int c;
    int d;
    int e;
    int f;
    private ArrayList g;
    private final ArrayList h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private int n;
    private c o;
    private int p;
    private HashMap q;
    private int r;
    private int s;
    private android.support.constraint.a.f t;

    public ConstraintLayout(Context arg7) {
        super(arg7);
        this.a = new SparseArray();
        this.g = new ArrayList(4);
        this.h = new ArrayList(100);
        this.b = new e();
        this.i = 0;
        this.j = 0;
        this.k = 0x7FFFFFFF;
        this.l = 0x7FFFFFFF;
        this.m = true;
        this.n = 3;
        this.o = null;
        this.p = -1;
        this.q = new HashMap();
        this.r = -1;
        this.s = -1;
        this.c = -1;
        this.d = -1;
        this.e = 0;
        this.f = 0;
        this.b(null);
    }

    public ConstraintLayout(Context arg6, AttributeSet arg7) {
        super(arg6, arg7);
        this.a = new SparseArray();
        this.g = new ArrayList(4);
        this.h = new ArrayList(100);
        this.b = new e();
        this.i = 0;
        this.j = 0;
        this.k = 0x7FFFFFFF;
        this.l = 0x7FFFFFFF;
        this.m = true;
        this.n = 3;
        this.o = null;
        this.p = -1;
        this.q = new HashMap();
        this.r = -1;
        this.s = -1;
        this.c = -1;
        this.d = -1;
        this.e = 0;
        this.f = 0;
        this.b(arg7);
    }

    public ConstraintLayout(Context arg6, AttributeSet arg7, int arg8) {
        super(arg6, arg7, arg8);
        this.a = new SparseArray();
        this.g = new ArrayList(4);
        this.h = new ArrayList(100);
        this.b = new e();
        this.i = 0;
        this.j = 0;
        this.k = 0x7FFFFFFF;
        this.l = 0x7FFFFFFF;
        this.m = true;
        this.n = 3;
        this.o = null;
        this.p = -1;
        this.q = new HashMap();
        this.r = -1;
        this.s = -1;
        this.c = -1;
        this.d = -1;
        this.e = 0;
        this.f = 0;
        this.b(arg7);
    }

    private final d a(int arg2) {
        d v0_2;
        e v0;
        if(arg2 == 0) {
            v0 = this.b;
        }
        else {
            Object v0_1 = this.a.get(arg2);
            if((((ConstraintLayout)v0_1)) == this) {
                v0 = this.b;
            }
            else if(v0_1 == null) {
                v0_2 = null;
            }
            else {
                v0_2 = ((View)v0_1).getLayoutParams().al;
            }
        }

        return v0_2;
    }

    private void a(int arg22, int arg23) {
        int v8;
        int v5;
        int v10 = this.getPaddingTop() + this.getPaddingBottom();
        int v11 = this.getPaddingLeft() + this.getPaddingRight();
        int v12 = this.getChildCount();
        int v9;
        for(v9 = 0; v9 < v12; ++v9) {
            View v13 = this.getChildAt(v9);
            if(v13.getVisibility() != 8) {
                ViewGroup$LayoutParams v2 = v13.getLayoutParams();
                d v14 = ((a)v2).al;
                if(!((a)v2).Y && !((a)v2).Z) {
                    v14.e(v13.getVisibility());
                    int v7 = ((a)v2).width;
                    int v6 = ((a)v2).height;
                    if((((a)v2).V) || (((a)v2).W)) {
                    label_48:
                        v5 = 1;
                    }
                    else {
                        if(!((a)v2).V && ((a)v2).I == 1) {
                            goto label_48;
                        }

                        if(((a)v2).width == -1) {
                            goto label_48;
                        }

                        if(!((a)v2).W) {
                            if(((a)v2).J == 1) {
                            }
                            else if(((a)v2).height != -1) {
                                goto label_102;
                            }

                            goto label_48;
                        }

                    label_102:
                        v5 = 0;
                    }

                    int v3 = 0;
                    int v4 = 0;
                    if(v5 != 0) {
                        if(v7 == 0) {
                            v5 = 1;
                            v8 = ConstraintLayout.getChildMeasureSpec(arg22, v11, -2);
                        }
                        else if(v7 == -1) {
                            v8 = ConstraintLayout.getChildMeasureSpec(arg22, v11, -1);
                            v5 = 0;
                        }
                        else {
                            if(v7 == -2) {
                                v3 = 1;
                            }

                            v8 = ConstraintLayout.getChildMeasureSpec(arg22, v11, v7);
                            v5 = v3;
                        }

                        if(v6 == 0) {
                            v3 = ConstraintLayout.getChildMeasureSpec(arg23, v10, -2);
                            v4 = 1;
                        }
                        else if(v6 == -1) {
                            v3 = ConstraintLayout.getChildMeasureSpec(arg23, v10, -1);
                        }
                        else {
                            v3 = v6 == -2 ? 1 : 0;
                            v4 = v3;
                            v3 = ConstraintLayout.getChildMeasureSpec(arg23, v10, v6);
                        }

                        v13.measure(v8, v3);
                        if(this.t != null) {
                            ++this.t.a;
                        }

                        boolean v3_1 = v7 == -2 ? true : false;
                        v14.b(v3_1);
                        v3_1 = v6 == -2 ? true : false;
                        v14.c(v3_1);
                        v6 = v13.getMeasuredWidth();
                        int v20 = v5;
                        v5 = v13.getMeasuredHeight();
                        v3 = v20;
                    }
                    else {
                        v5 = v6;
                        v6 = v7;
                    }

                    v14.h(v6);
                    v14.i(v5);
                    if(v3 != 0) {
                        v14.l(v6);
                    }

                    if(v4 != 0) {
                        v14.m(v5);
                    }

                    if(!((a)v2).X) {
                        goto label_15;
                    }

                    int v2_1 = v13.getBaseline();
                    if(v2_1 == -1) {
                        goto label_15;
                    }

                    v14.n(v2_1);
                }
            }

        label_15:
        }
    }

    public void a(int arg3, Object arg4, Object arg5) {
        String v4;
        if(arg3 == 0 && ((arg4 instanceof String)) && ((arg5 instanceof Integer))) {
            if(this.q == null) {
                this.q = new HashMap();
            }

            int v0 = ((String)arg4).indexOf("/");
            if(v0 != -1) {
                v4 = ((String)arg4).substring(v0 + 1);
            }

            this.q.put(v4, Integer.valueOf(((Integer)arg5).intValue()));
        }
    }

    public final d a(View arg2) {
        d v0_1;
        if((((ConstraintLayout)arg2)) == this) {
            e v0 = this.b;
        }
        else if(arg2 == null) {
            v0_1 = null;
        }
        else {
            v0_1 = arg2.getLayoutParams().al;
        }

        return v0_1;
    }

    protected a a() {
        return new a(-2, -2);
    }

    public a a(AttributeSet arg3) {
        return new a(this.getContext(), arg3);
    }

    public Object a(int arg2, Object arg3) {
        Object v0 = arg2 != 0 || !(arg3 instanceof String) || this.q == null || !this.q.containsKey(arg3) ? null : this.q.get(arg3);
        return v0;
    }

    protected void a(String arg7) {
        this.b.L();
        if(this.t != null) {
            ++this.t.c;
        }
    }

    public void addView(View arg3, int arg4, ViewGroup$LayoutParams arg5) {
        super.addView(arg3, arg4, arg5);
        if(Build$VERSION.SDK_INT < 14) {
            this.onViewAdded(arg3);
        }
    }

    private void b(AttributeSet arg9) {
        c v7 = null;
        this.b.a(this);
        this.a.put(this.getId(), this);
        this.o = v7;
        if(arg9 != null) {
            TypedArray v2 = this.getContext().obtainStyledAttributes(arg9, b.ConstraintLayout_Layout);
            int v3 = v2.getIndexCount();
            int v0;
            for(v0 = 0; v0 < v3; ++v0) {
                int v4 = v2.getIndex(v0);
                if(v4 == b.ConstraintLayout_Layout_android_minWidth) {
                    this.i = v2.getDimensionPixelOffset(v4, this.i);
                    goto label_21;
                }

                if(v4 == b.ConstraintLayout_Layout_android_minHeight) {
                    this.j = v2.getDimensionPixelOffset(v4, this.j);
                    goto label_21;
                }

                if(v4 == b.ConstraintLayout_Layout_android_maxWidth) {
                    this.k = v2.getDimensionPixelOffset(v4, this.k);
                    goto label_21;
                }

                if(v4 == b.ConstraintLayout_Layout_android_maxHeight) {
                    this.l = v2.getDimensionPixelOffset(v4, this.l);
                    goto label_21;
                }

                if(v4 == b.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.n = v2.getInt(v4, this.n);
                    goto label_21;
                }

                if(v4 == b.ConstraintLayout_Layout_constraintSet) {
                    v4 = v2.getResourceId(v4, 0);
                    try {
                        this.o = new c();
                        this.o.a(this.getContext(), v4);
                    }
                    catch(Resources$NotFoundException v5) {
                        this.o = v7;
                    }

                    this.p = v4;
                }

            label_21:
            }

            v2.recycle();
        }

        this.b.a(this.n);
    }

    private void b() {
        int v0 = 0;
        int v2 = this.getChildCount();
        int v1 = 0;
        while(v1 < v2) {
            if(this.getChildAt(v1).isLayoutRequested()) {
                v0 = 1;
            }
            else {
                ++v1;
                continue;
            }

            break;
        }

        if(v0 != 0) {
            this.h.clear();
            this.c();
        }
    }

    private void b(int arg23, int arg24) {
        int v12;
        int v11_1;
        int v10;
        int v4;
        int v3;
        int v9;
        int v5;
        ViewGroup$LayoutParams v2;
        int v15 = this.getPaddingTop() + this.getPaddingBottom();
        int v16 = this.getPaddingLeft() + this.getPaddingRight();
        int v17 = this.getChildCount();
        int v6;
        for(v6 = 0; v6 < v17; ++v6) {
            View v7 = this.getChildAt(v6);
            if(v7.getVisibility() != 8) {
                v2 = v7.getLayoutParams();
                d v8 = ((a)v2).al;
                if(!((a)v2).Y && !((a)v2).Z) {
                    v8.e(v7.getVisibility());
                    v5 = ((a)v2).width;
                    v9 = ((a)v2).height;
                    if(v5 != 0 && v9 != 0) {
                        v3 = 0;
                        v4 = 0;
                        if(v5 == -2) {
                            v3 = 1;
                        }

                        v10 = ConstraintLayout.getChildMeasureSpec(arg23, v16, v5);
                        if(v9 == -2) {
                            v4 = 1;
                        }

                        v7.measure(v10, ConstraintLayout.getChildMeasureSpec(arg24, v15, v9));
                        if(this.t != null) {
                            ++this.t.a;
                        }

                        boolean v5_1 = v5 == -2 ? true : false;
                        v8.b(v5_1);
                        v5_1 = v9 == -2 ? true : false;
                        v8.c(v5_1);
                        v5 = v7.getMeasuredWidth();
                        v9 = v7.getMeasuredHeight();
                        v8.h(v5);
                        v8.i(v9);
                        if(v3 != 0) {
                            v8.l(v5);
                        }

                        if(v4 != 0) {
                            v8.m(v9);
                        }

                        if(((a)v2).X) {
                            v3 = v7.getBaseline();
                            if(v3 != -1) {
                                v8.n(v3);
                            }
                        }

                        if(!((a)v2).V) {
                            goto label_16;
                        }

                        if(!((a)v2).W) {
                            goto label_16;
                        }

                        v8.h().a(v5);
                        v8.i().a(v9);
                        goto label_16;
                    }

                    v8.h().e();
                    v8.i().e();
                }
            }

        label_16:
        }

        this.b.N();
        int v14;
        for(v14 = 0; v14 < v17; ++v14) {
            View v18 = this.getChildAt(v14);
            if(v18.getVisibility() != 8) {
                v2 = v18.getLayoutParams();
                d v19 = ((a)v2).al;
                if(!((a)v2).Y && !((a)v2).Z) {
                    v19.e(v18.getVisibility());
                    v9 = ((a)v2).width;
                    int v8_1 = ((a)v2).height;
                    if(v9 != 0 && v8_1 != 0) {
                        goto label_106;
                    }

                    j v10_1 = v19.a(android.support.constraint.a.a.c$c.b).a();
                    j v11 = v19.a(android.support.constraint.a.a.c$c.d).a();
                    v3 = v19.a(android.support.constraint.a.a.c$c.b).g() == null || v19.a(android.support.constraint.a.a.c$c.d).g() == null ? 0 : 1;
                    j v20 = v19.a(android.support.constraint.a.a.c$c.c).a();
                    j v21 = v19.a(android.support.constraint.a.a.c$c.e).a();
                    int v13 = v19.a(android.support.constraint.a.a.c$c.c).g() == null || v19.a(android.support.constraint.a.a.c$c.e).g() == null ? 0 : 1;
                    if(v9 == 0 && v8_1 == 0 && v3 != 0 && v13 != 0) {
                        goto label_106;
                    }

                    v6 = 0;
                    v4 = this.b.F() != android.support.constraint.a.a.d$a.b ? 1 : 0;
                    int v7_1 = this.b.G() != android.support.constraint.a.a.d$a.b ? 1 : 0;
                    if(v4 == 0) {
                        v19.h().e();
                    }

                    if(v7_1 == 0) {
                        v19.i().e();
                    }

                    if(v9 == 0) {
                        if(v4 != 0 && (v19.d()) && v3 != 0 && (v10_1.g()) && (v11.g())) {
                            v9 = ((int)(v11.d() - v10_1.d()));
                            v19.h().a(v9);
                            v10 = v4;
                            v11_1 = 0;
                            v12 = v9;
                            v9 = ConstraintLayout.getChildMeasureSpec(arg23, v16, v9);
                            goto label_208;
                        }

                        v10 = 0;
                        v11_1 = 1;
                        v12 = v9;
                        v9 = ConstraintLayout.getChildMeasureSpec(arg23, v16, -2);
                    }
                    else {
                        if(v9 == -1) {
                            v10 = v4;
                            v11_1 = 0;
                            v12 = v9;
                            v9 = ConstraintLayout.getChildMeasureSpec(arg23, v16, -1);
                            goto label_208;
                        }

                        v3 = v9 == -2 ? 1 : 0;
                        v10 = v4;
                        v11_1 = v3;
                        v12 = v9;
                        v9 = ConstraintLayout.getChildMeasureSpec(arg23, v16, v9);
                    }

                label_208:
                    if(v8_1 == 0) {
                        if(v7_1 != 0 && (v19.e()) && v13 != 0 && (v20.g()) && (v21.g())) {
                            v4 = ((int)(v21.d() - v20.d()));
                            v19.i().a(v4);
                            v3 = ConstraintLayout.getChildMeasureSpec(arg24, v15, v4);
                            v5 = v4;
                            v4 = v7_1;
                            goto label_227;
                        }

                        v3 = ConstraintLayout.getChildMeasureSpec(arg24, v15, -2);
                        v6 = 1;
                        v4 = 0;
                        v5 = v8_1;
                    }
                    else {
                        if(v8_1 == -1) {
                            v3 = ConstraintLayout.getChildMeasureSpec(arg24, v15, -1);
                            v4 = v7_1;
                            v5 = v8_1;
                            goto label_227;
                        }

                        v3 = v8_1 == -2 ? 1 : 0;
                        v6 = v3;
                        v5 = v8_1;
                        v3 = ConstraintLayout.getChildMeasureSpec(arg24, v15, v8_1);
                        v4 = v7_1;
                    }

                label_227:
                    v18.measure(v9, v3);
                    if(this.t != null) {
                        ++this.t.a;
                    }

                    boolean v3_1 = v12 == -2 ? true : false;
                    v19.b(v3_1);
                    v3_1 = v5 == -2 ? true : false;
                    v19.c(v3_1);
                    v3 = v18.getMeasuredWidth();
                    v5 = v18.getMeasuredHeight();
                    v19.h(v3);
                    v19.i(v5);
                    if(v11_1 != 0) {
                        v19.l(v3);
                    }

                    if(v6 != 0) {
                        v19.m(v5);
                    }

                    if(v10 != 0) {
                        v19.h().a(v3);
                    }
                    else {
                        v19.h().c();
                    }

                    if(v4 != 0) {
                        v19.i().a(v5);
                    }
                    else {
                        v19.i().c();
                    }

                    if(!((a)v2).X) {
                        goto label_106;
                    }

                    int v2_1 = v18.getBaseline();
                    if(v2_1 == -1) {
                        goto label_106;
                    }

                    v19.n(v2_1);
                }
            }

        label_106:
        }
    }

    private void c() {
        d v2_2;
        int v10;
        float v9;
        float v1_4;
        View v0_3;
        d v1_1;
        int v3;
        View v2;
        boolean v12 = this.isInEditMode();
        int v13 = this.getChildCount();
        if(v12) {
            int v1;
            for(v1 = 0; v1 < v13; ++v1) {
                v2 = this.getChildAt(v1);
                try {
                    String v0_1 = this.getResources().getResourceName(v2.getId());
                    this.a(0, v0_1, Integer.valueOf(v2.getId()));
                    v3 = v0_1.indexOf(0x2F);
                    if(v3 != -1) {
                        v0_1 = v0_1.substring(v3 + 1);
                    }

                    this.a(v2.getId()).a(v0_1);
                }
                catch(Resources$NotFoundException v0) {
                }
            }
        }

        int v0_2;
        for(v0_2 = 0; v0_2 < v13; ++v0_2) {
            v1_1 = this.a(this.getChildAt(v0_2));
            if(v1_1 != null) {
                v1_1.f();
            }
        }

        if(this.p != -1) {
            for(v1 = 0; v1 < v13; ++v1) {
                v0_3 = this.getChildAt(v1);
                if(v0_3.getId() == this.p && ((v0_3 instanceof android.support.constraint.d))) {
                    this.o = ((android.support.constraint.d)v0_3).getConstraintSet();
                }
            }
        }

        if(this.o != null) {
            this.o.a(this);
        }

        this.b.S();
        int v2_1 = this.g.size();
        if(v2_1 > 0) {
            for(v1 = 0; v1 < v2_1; ++v1) {
                this.g.get(v1).a(this);
            }
        }

        for(v1 = 0; v1 < v13; ++v1) {
            v0_3 = this.getChildAt(v1);
            if((v0_3 instanceof android.support.constraint.f)) {
                ((android.support.constraint.f)v0_3).a(this);
            }
        }

        int v11;
        for(v11 = 0; v11 < v13; ++v11) {
            v2 = this.getChildAt(v11);
            d v0_4 = this.a(v2);
            if(v0_4 != null) {
                ViewGroup$LayoutParams v8 = v2.getLayoutParams();
                ((a)v8).a();
                if(((a)v8).am) {
                    ((a)v8).am = false;
                    goto label_96;
                }

                if(v12) {
                    try {
                        String v1_3 = this.getResources().getResourceName(v2.getId());
                        this.a(0, v1_3, Integer.valueOf(v2.getId()));
                        this.a(v2.getId()).a(v1_3.substring(v1_3.indexOf("id/") + 3));
                    }
                    catch(Resources$NotFoundException v1_2) {
                    }
                }

            label_96:
                v0_4.e(v2.getVisibility());
                if(((a)v8).aa) {
                    v0_4.e(8);
                }

                v0_4.a(v2);
                this.b.b(v0_4);
                if(!((a)v8).W || !((a)v8).V) {
                    this.h.add(v0_4);
                }

                if(((a)v8).Y) {
                    v3 = ((a)v8).ai;
                    v2_1 = ((a)v8).aj;
                    v1_4 = ((a)v8).ak;
                    if(Build$VERSION.SDK_INT < 17) {
                        v3 = ((a)v8).a;
                        v2_1 = ((a)v8).b;
                        v1_4 = ((a)v8).c;
                    }

                    if(v1_4 != -1f) {
                        ((f)v0_4).e(v1_4);
                        goto label_86;
                    }

                    if(v3 != -1) {
                        ((f)v0_4).q(v3);
                        goto label_86;
                    }

                    if(v2_1 == -1) {
                        goto label_86;
                    }

                    ((f)v0_4).r(v2_1);
                    goto label_86;
                }

                if(((a)v8).d != -1 || ((a)v8).e != -1 || ((a)v8).f != -1 || ((a)v8).g != -1 || ((a)v8).q != -1 || ((a)v8).p != -1 || ((a)v8).r != -1 || ((a)v8).s != -1 || ((a)v8).h != -1 || ((a)v8).i != -1 || ((a)v8).j != -1 || ((a)v8).k != -1 || ((a)v8).l != -1 || ((a)v8).Q != -1 || ((a)v8).R != -1 || ((a)v8).m != -1 || ((a)v8).width == -1 || ((a)v8).height == -1) {
                    int v7 = ((a)v8).ab;
                    int v6 = ((a)v8).ac;
                    int v4 = ((a)v8).ad;
                    v3 = ((a)v8).ae;
                    int v5 = ((a)v8).af;
                    v2_1 = ((a)v8).ag;
                    v1_4 = ((a)v8).ah;
                    if(Build$VERSION.SDK_INT < 17) {
                        v7 = ((a)v8).d;
                        v6 = ((a)v8).e;
                        v4 = ((a)v8).f;
                        v3 = ((a)v8).g;
                        v5 = ((a)v8).t;
                        v2_1 = ((a)v8).v;
                        v1_4 = ((a)v8).z;
                        if(v7 == -1 && v6 == -1) {
                            if(((a)v8).q != -1) {
                                v7 = ((a)v8).q;
                            }
                            else if(((a)v8).p != -1) {
                                v6 = ((a)v8).p;
                            }
                        }

                        if(v4 != -1) {
                            goto label_486;
                        }

                        if(v3 != -1) {
                            goto label_486;
                        }

                        if(((a)v8).r != -1) {
                            v9 = v1_4;
                            v10 = ((a)v8).r;
                            v1 = v6;
                            v6 = v2_1;
                            v2_1 = v7;
                            v7 = v3;
                            goto label_245;
                        }

                        if(((a)v8).s == -1) {
                            goto label_486;
                        }

                        v9 = v1_4;
                        v10 = v4;
                        v1 = v6;
                        v6 = v2_1;
                        v2_1 = v7;
                        v7 = ((a)v8).s;
                    }
                    else {
                    label_486:
                        v9 = v1_4;
                        v10 = v4;
                        v1 = v6;
                        v6 = v2_1;
                        v2_1 = v7;
                        v7 = v3;
                    }

                label_245:
                    if(((a)v8).m != -1) {
                        v1_1 = this.a(((a)v8).m);
                        if(v1_1 != null) {
                            v0_4.a(v1_1, ((a)v8).o, ((a)v8).n);
                        }
                    }
                    else {
                        if(v2_1 != -1) {
                            v2_2 = this.a(v2_1);
                            if(v2_2 != null) {
                                v0_4.a(android.support.constraint.a.a.c$c.b, v2_2, android.support.constraint.a.a.c$c.b, ((a)v8).leftMargin, v5);
                            }
                        }
                        else if(v1 != -1) {
                            v2_2 = this.a(v1);
                            if(v2_2 != null) {
                                v0_4.a(android.support.constraint.a.a.c$c.b, v2_2, android.support.constraint.a.a.c$c.d, ((a)v8).leftMargin, v5);
                            }
                        }

                        if(v10 != -1) {
                            v2_2 = this.a(v10);
                            if(v2_2 != null) {
                                v0_4.a(android.support.constraint.a.a.c$c.d, v2_2, android.support.constraint.a.a.c$c.b, ((a)v8).rightMargin, v6);
                            }
                        }
                        else if(v7 != -1) {
                            v2_2 = this.a(v7);
                            if(v2_2 != null) {
                                v0_4.a(android.support.constraint.a.a.c$c.d, v2_2, android.support.constraint.a.a.c$c.d, ((a)v8).rightMargin, v6);
                            }
                        }

                        if(((a)v8).h != -1) {
                            v2_2 = this.a(((a)v8).h);
                            if(v2_2 != null) {
                                v0_4.a(android.support.constraint.a.a.c$c.c, v2_2, android.support.constraint.a.a.c$c.c, ((a)v8).topMargin, ((a)v8).u);
                            }
                        }
                        else if(((a)v8).i != -1) {
                            v2_2 = this.a(((a)v8).i);
                            if(v2_2 != null) {
                                v0_4.a(android.support.constraint.a.a.c$c.c, v2_2, android.support.constraint.a.a.c$c.e, ((a)v8).topMargin, ((a)v8).u);
                            }
                        }

                        if(((a)v8).j != -1) {
                            v2_2 = this.a(((a)v8).j);
                            if(v2_2 != null) {
                                v0_4.a(android.support.constraint.a.a.c$c.e, v2_2, android.support.constraint.a.a.c$c.c, ((a)v8).bottomMargin, ((a)v8).w);
                            }
                        }
                        else if(((a)v8).k != -1) {
                            v2_2 = this.a(((a)v8).k);
                            if(v2_2 != null) {
                                v0_4.a(android.support.constraint.a.a.c$c.e, v2_2, android.support.constraint.a.a.c$c.e, ((a)v8).bottomMargin, ((a)v8).w);
                            }
                        }

                        if(((a)v8).l != -1) {
                            Object v1_5 = this.a.get(((a)v8).l);
                            v2_2 = this.a(((a)v8).l);
                            if(v2_2 != null && v1_5 != null && ((((View)v1_5).getLayoutParams() instanceof a))) {
                                ViewGroup$LayoutParams v1_6 = ((View)v1_5).getLayoutParams();
                                ((a)v8).X = true;
                                ((a)v1_6).X = true;
                                v0_4.a(android.support.constraint.a.a.c$c.f).a(v2_2.a(android.support.constraint.a.a.c$c.f), 0, -1, android.support.constraint.a.a.c$b.b, 0, true);
                                v0_4.a(android.support.constraint.a.a.c$c.c).i();
                                v0_4.a(android.support.constraint.a.a.c$c.e).i();
                            }
                        }

                        if(v9 >= 0f && v9 != 0.5f) {
                            v0_4.a(v9);
                        }

                        if(((a)v8).A < 0f) {
                            goto label_254;
                        }

                        if(((a)v8).A == 0.5f) {
                            goto label_254;
                        }

                        v0_4.b(((a)v8).A);
                    }

                label_254:
                    if((v12) && (((a)v8).Q != -1 || ((a)v8).R != -1)) {
                        v0_4.a(((a)v8).Q, ((a)v8).R);
                    }

                    if(((a)v8).V) {
                        v0_4.a(android.support.constraint.a.a.d$a.a);
                        v0_4.h(((a)v8).width);
                    }
                    else if(((a)v8).width == -1) {
                        v0_4.a(android.support.constraint.a.a.d$a.d);
                        v0_4.a(android.support.constraint.a.a.c$c.b).d = ((a)v8).leftMargin;
                        v0_4.a(android.support.constraint.a.a.c$c.d).d = ((a)v8).rightMargin;
                    }
                    else {
                        v0_4.a(android.support.constraint.a.a.d$a.c);
                        v0_4.h(0);
                    }

                    if(((a)v8).W) {
                        v0_4.b(android.support.constraint.a.a.d$a.a);
                        v0_4.i(((a)v8).height);
                    }
                    else if(((a)v8).height == -1) {
                        v0_4.b(android.support.constraint.a.a.d$a.d);
                        v0_4.a(android.support.constraint.a.a.c$c.c).d = ((a)v8).topMargin;
                        v0_4.a(android.support.constraint.a.a.c$c.e).d = ((a)v8).bottomMargin;
                    }
                    else {
                        v0_4.b(android.support.constraint.a.a.d$a.c);
                        v0_4.i(0);
                    }

                    if(((a)v8).B != null) {
                        v0_4.b(((a)v8).B);
                    }

                    v0_4.c(((a)v8).E);
                    v0_4.d(((a)v8).F);
                    v0_4.o(((a)v8).G);
                    v0_4.p(((a)v8).H);
                    v0_4.a(((a)v8).I, ((a)v8).K, ((a)v8).M, ((a)v8).O);
                    v0_4.b(((a)v8).J, ((a)v8).L, ((a)v8).N, ((a)v8).P);
                }
            }

        label_86:
        }
    }

    private void c(int arg10, int arg11) {
        int v5 = View$MeasureSpec.getMode(arg10);
        int v3 = View$MeasureSpec.getSize(arg10);
        int v6 = View$MeasureSpec.getMode(arg11);
        int v0 = View$MeasureSpec.getSize(arg11);
        int v7 = this.getPaddingTop() + this.getPaddingBottom();
        int v8 = this.getPaddingLeft() + this.getPaddingRight();
        android.support.constraint.a.a.d$a v4 = android.support.constraint.a.a.d$a.a;
        android.support.constraint.a.a.d$a v2 = android.support.constraint.a.a.d$a.a;
        this.getLayoutParams();
        switch(v5) {
            case 1073741824: {
                v3 = Math.min(this.k, v3) - v8;
                break;
            }
            case -2147483648: {
                v4 = android.support.constraint.a.a.d$a.b;
                break;
            }
            case 0: {
                v4 = android.support.constraint.a.a.d$a.b;
                v3 = 0;
                break;
            }
            default: {
                v3 = 0;
                break;
            }
        }

        switch(v6) {
            case 0: {
                v2 = android.support.constraint.a.a.d$a.b;
                v0 = 0;
                break;
            }
            case 1073741824: {
                v0 = Math.min(this.l, v0) - v7;
                break;
            }
            case -2147483648: {
                v2 = android.support.constraint.a.a.d$a.b;
                break;
            }
            default: {
                v0 = 0;
                break;
            }
        }

        this.b.j(0);
        this.b.k(0);
        this.b.a(v4);
        this.b.h(v3);
        this.b.b(v2);
        this.b.i(v0);
        this.b.j(this.i - this.getPaddingLeft() - this.getPaddingRight());
        this.b.k(this.j - this.getPaddingTop() - this.getPaddingBottom());
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg2) {
        return arg2 instanceof a;
    }

    private void d() {
        int v1 = 0;
        int v3 = this.getChildCount();
        int v2;
        for(v2 = 0; v2 < v3; ++v2) {
            View v0 = this.getChildAt(v2);
            if((v0 instanceof android.support.constraint.f)) {
                ((android.support.constraint.f)v0).b(this);
            }
        }

        v2 = this.g.size();
        if(v2 > 0) {
            while(v1 < v2) {
                this.g.get(v1).c(this);
                ++v1;
            }
        }
    }

    public void dispatchDraw(Canvas arg18) {
        super.dispatchDraw(arg18);
        if(this.isInEditMode()) {
            int v8 = this.getChildCount();
            float v9 = ((float)this.getWidth());
            float v10 = ((float)this.getHeight());
            float v11 = 1080f;
            float v12 = 1920f;
            int v7;
            for(v7 = 0; v7 < v8; ++v7) {
                View v1 = this.getChildAt(v7);
                if(v1.getVisibility() != 8) {
                    Object v1_1 = v1.getTag();
                    if(v1_1 != null && ((v1_1 instanceof String))) {
                        String[] v1_2 = ((String)v1_1).split(",");
                        if(v1_2.length == 4) {
                            int v13 = ((int)((((float)Integer.parseInt(v1_2[0]))) / v11 * v9));
                            int v14 = ((int)((((float)Integer.parseInt(v1_2[1]))) / v12 * v10));
                            int v15 = ((int)((((float)Integer.parseInt(v1_2[2]))) / v11 * v9));
                            int v16 = ((int)((((float)Integer.parseInt(v1_2[3]))) / v12 * v10));
                            Paint v6 = new Paint();
                            v6.setColor(0xFFFF0000);
                            arg18.drawLine(((float)v13), ((float)v14), ((float)(v13 + v15)), ((float)v14), v6);
                            arg18.drawLine(((float)(v13 + v15)), ((float)v14), ((float)(v13 + v15)), ((float)(v14 + v16)), v6);
                            arg18.drawLine(((float)(v13 + v15)), ((float)(v14 + v16)), ((float)v13), ((float)(v14 + v16)), v6);
                            arg18.drawLine(((float)v13), ((float)(v14 + v16)), ((float)v13), ((float)v14), v6);
                            v6.setColor(0xFF00FF00);
                            arg18.drawLine(((float)v13), ((float)v14), ((float)(v13 + v15)), ((float)(v14 + v16)), v6);
                            arg18.drawLine(((float)v13), ((float)(v14 + v16)), ((float)(v13 + v15)), ((float)v14), v6);
                        }
                    }
                }
            }
        }
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.a();
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg2) {
        return this.a(arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg2) {
        return new a(arg2);
    }

    public int getMaxHeight() {
        return this.l;
    }

    public int getMaxWidth() {
        return this.k;
    }

    public int getMinHeight() {
        return this.j;
    }

    public int getMinWidth() {
        return this.i;
    }

    public int getOptimizationLevel() {
        return this.b.H();
    }

    protected void onLayout(boolean arg11, int arg12, int arg13, int arg14, int arg15) {
        int v4 = this.getChildCount();
        boolean v5 = this.isInEditMode();
        int v3;
        for(v3 = 0; v3 < v4; ++v3) {
            View v1 = this.getChildAt(v3);
            ViewGroup$LayoutParams v0 = v1.getLayoutParams();
            d v6 = ((a)v0).al;
            if((v1.getVisibility() != 8 || (((a)v0).Y) || (((a)v0).Z) || (v5)) && !((a)v0).aa) {
                int v7 = v6.s();
                int v8 = v6.t();
                int v9 = v7 + v6.o();
                int v6_1 = v8 + v6.q();
                v1.layout(v7, v8, v9, v6_1);
                if((v1 instanceof android.support.constraint.f)) {
                    View v0_1 = v1.getContent();
                    if(v0_1 != null) {
                        v0_1.setVisibility(0);
                        v0_1.layout(v7, v8, v9, v6_1);
                    }
                }
            }
        }

        v3 = this.g.size();
        if(v3 > 0) {
            int v1_1;
            for(v1_1 = 0; v1_1 < v3; ++v1_1) {
                this.g.get(v1_1).b(this);
            }
        }
    }

    protected void onMeasure(int arg27, int arg28) {
        int v2_2;
        Object v3_1;
        Object v2_1;
        System.currentTimeMillis();
        int v13 = 0;
        int v3 = View$MeasureSpec.getMode(arg27);
        int v4 = View$MeasureSpec.getSize(arg27);
        int v5 = View$MeasureSpec.getMode(arg28);
        int v6 = View$MeasureSpec.getSize(arg28);
        this.e = v3;
        this.f = v5;
        this.c = v4;
        this.d = v6;
        v3 = this.getPaddingLeft();
        v4 = this.getPaddingTop();
        this.b.f(v3);
        this.b.g(v4);
        this.b.c(this.k);
        this.b.d(this.l);
        if(Build$VERSION.SDK_INT >= 17) {
            e v5_1 = this.b;
            boolean v2 = this.getLayoutDirection() == 1 ? true : false;
            v5_1.a(v2);
        }

        this.c(arg27, arg28);
        int v17 = this.b.o();
        int v18 = this.b.q();
        if(this.m) {
            this.m = false;
            this.b();
        }

        int v16 = (this.n & 8) == 8 ? 1 : 0;
        if(v16 != 0) {
            this.b.M();
            this.b.e(v17, v18);
            this.b(arg27, arg28);
        }
        else {
            this.a(arg27, arg28);
        }

        this.d();
        if(this.getChildCount() > 0) {
            this.a("First pass");
        }

        int v12 = 0;
        int v19 = this.h.size();
        int v20 = v4 + this.getPaddingBottom();
        int v21 = v3 + this.getPaddingRight();
        if(v19 > 0) {
            int v10 = 0;
            v5 = this.b.F() == android.support.constraint.a.a.d$a.b ? 1 : 0;
            v6 = this.b.G() == android.support.constraint.a.a.d$a.b ? 1 : 0;
            int v9 = Math.max(this.b.o(), this.i);
            int v11 = Math.max(this.b.q(), this.j);
            int v15 = 0;
            while(v15 < v19) {
                v2_1 = this.h.get(v15);
                v3_1 = ((d)v2_1).B();
                if(v3_1 == null) {
                    v2_2 = v12;
                    v3 = v13;
                }
                else {
                    ViewGroup$LayoutParams v4_1 = ((View)v3_1).getLayoutParams();
                    if(((a)v4_1).Z) {
                        v2_2 = v12;
                        v3 = v13;
                    }
                    else if(((a)v4_1).Y) {
                        v2_2 = v12;
                        v3 = v13;
                    }
                    else if(((View)v3_1).getVisibility() == 8) {
                        v2_2 = v12;
                        v3 = v13;
                    }
                    else {
                        if(v16 != 0 && (((d)v2_1).h().g()) && (((d)v2_1).i().g())) {
                            v2_2 = v12;
                            v3 = v13;
                            goto label_176;
                        }

                        int v7 = ((a)v4_1).width != -2 || !((a)v4_1).V ? View$MeasureSpec.makeMeasureSpec(((d)v2_1).o(), 0x40000000) : ConstraintLayout.getChildMeasureSpec(arg27, v21, ((a)v4_1).width);
                        int v8 = ((a)v4_1).height != -2 || !((a)v4_1).W ? View$MeasureSpec.makeMeasureSpec(((d)v2_1).q(), 0x40000000) : ConstraintLayout.getChildMeasureSpec(arg28, v20, ((a)v4_1).height);
                        ((View)v3_1).measure(v7, v8);
                        if(this.t != null) {
                            ++this.t.b;
                        }

                        ++v13;
                        v7 = ((View)v3_1).getMeasuredWidth();
                        int v22 = ((View)v3_1).getMeasuredHeight();
                        if(v7 != ((d)v2_1).o()) {
                            ((d)v2_1).h(v7);
                            if(v16 != 0) {
                                ((d)v2_1).h().a(v7);
                            }

                            v7 = v5 == 0 || ((d)v2_1).w() <= v9 ? v9 : Math.max(v9, ((d)v2_1).w() + ((d)v2_1).a(android.support.constraint.a.a.c$c.d).e());
                            v8 = 1;
                        }
                        else {
                            v7 = v9;
                            v8 = v10;
                        }

                        if(v22 != ((d)v2_1).q()) {
                            ((d)v2_1).i(v22);
                            if(v16 != 0) {
                                ((d)v2_1).i().a(v22);
                            }

                            v8 = v6 == 0 || ((d)v2_1).x() <= v11 ? v11 : Math.max(v11, ((d)v2_1).x() + ((d)v2_1).a(android.support.constraint.a.a.c$c.e).e());
                            v9 = 1;
                        }
                        else {
                            v9 = v8;
                            v8 = v11;
                        }

                        if(((a)v4_1).X) {
                            v4 = ((View)v3_1).getBaseline();
                            if(v4 != -1 && v4 != ((d)v2_1).A()) {
                                ((d)v2_1).n(v4);
                                v9 = 1;
                            }
                        }

                        if(Build$VERSION.SDK_INT >= 11) {
                            v2_2 = ConstraintLayout.combineMeasuredStates(v12, ((View)v3_1).getMeasuredState());
                            v11 = v8;
                            v10 = v9;
                            v3 = v13;
                            v9 = v7;
                            goto label_176;
                        }

                        v11 = v8;
                        v10 = v9;
                        v2_2 = v12;
                        v3 = v13;
                        v9 = v7;
                    }
                }

            label_176:
                ++v15;
                v12 = v2_2;
                v13 = v3;
            }

            if(v10 != 0) {
                this.b.h(v17);
                this.b.i(v18);
                if(v16 != 0) {
                    this.b.N();
                }

                this.a("2nd pass");
                v2_2 = 0;
                if(this.b.o() < v9) {
                    this.b.h(v9);
                    v2_2 = 1;
                }

                if(this.b.q() < v11) {
                    this.b.i(v11);
                    v2_2 = 1;
                }

                if(v2_2 == 0) {
                    goto label_354;
                }

                this.a("3rd pass");
            }

        label_354:
            v5 = 0;
            for(v4 = 0; v5 < v19; v4 = v2_2) {
                v2_1 = this.h.get(v5);
                v3_1 = ((d)v2_1).B();
                if(v3_1 == null) {
                    v2_2 = v4;
                }
                else {
                    if(((View)v3_1).getMeasuredWidth() == ((d)v2_1).o() && ((View)v3_1).getMeasuredHeight() == ((d)v2_1).q()) {
                        v2_2 = v4;
                        goto label_365;
                    }

                    ((View)v3_1).measure(View$MeasureSpec.makeMeasureSpec(((d)v2_1).o(), 0x40000000), View$MeasureSpec.makeMeasureSpec(((d)v2_1).q(), 0x40000000));
                    if(this.t != null) {
                        ++this.t.b;
                    }

                    v2_2 = v4 + 1;
                }

            label_365:
                ++v5;
            }
        }

        v2_2 = this.b.o() + v21;
        v3 = this.b.q() + v20;
        if(Build$VERSION.SDK_INT >= 11) {
            v2_2 = ConstraintLayout.resolveSizeAndState(v2_2, arg27, v12);
            v3 = ConstraintLayout.resolveSizeAndState(v3, arg28, v12 << 16) & 0xFFFFFF;
            v2_2 = Math.min(this.k, v2_2 & 0xFFFFFF);
            v3 = Math.min(this.l, v3);
            if(this.b.I()) {
                v2_2 |= 0x1000000;
            }

            if(this.b.J()) {
                v3 |= 0x1000000;
            }

            this.setMeasuredDimension(v2_2, v3);
            this.r = v2_2;
            this.s = v3;
        }
        else {
            this.setMeasuredDimension(v2_2, v3);
            this.r = v2_2;
            this.s = v3;
        }
    }

    public void onViewAdded(View arg4) {
        if(Build$VERSION.SDK_INT >= 14) {
            super.onViewAdded(arg4);
        }

        d v0 = this.a(arg4);
        if(((arg4 instanceof android.support.constraint.e)) && !(v0 instanceof f)) {
            ViewGroup$LayoutParams v0_1 = arg4.getLayoutParams();
            ((a)v0_1).al = new f();
            ((a)v0_1).Y = true;
            ((a)v0_1).al.a(((a)v0_1).S);
        }

        if((arg4 instanceof android.support.constraint.b)) {
            View v0_2 = arg4;
            ((android.support.constraint.b)v0_2).a();
            arg4.getLayoutParams().Z = true;
            if(!this.g.contains(v0_2)) {
                this.g.add(v0_2);
            }
        }

        this.a.put(arg4.getId(), arg4);
        this.m = true;
    }

    public void onViewRemoved(View arg3) {
        if(Build$VERSION.SDK_INT >= 14) {
            super.onViewRemoved(arg3);
        }

        this.a.remove(arg3.getId());
        d v0 = this.a(arg3);
        this.b.c(v0);
        this.g.remove(arg3);
        this.h.remove(v0);
        this.m = true;
    }

    public void removeView(View arg3) {
        super.removeView(arg3);
        if(Build$VERSION.SDK_INT < 14) {
            this.onViewRemoved(arg3);
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.m = true;
        this.r = -1;
        this.s = -1;
        this.c = -1;
        this.d = -1;
        this.e = 0;
        this.f = 0;
    }

    public void setConstraintSet(c arg1) {
        this.o = arg1;
    }

    public void setId(int arg3) {
        this.a.remove(this.getId());
        super.setId(arg3);
        this.a.put(this.getId(), this);
    }

    public void setMaxHeight(int arg2) {
        if(arg2 != this.l) {
            this.l = arg2;
            this.requestLayout();
        }
    }

    public void setMaxWidth(int arg2) {
        if(arg2 != this.k) {
            this.k = arg2;
            this.requestLayout();
        }
    }

    public void setMinHeight(int arg2) {
        if(arg2 != this.j) {
            this.j = arg2;
            this.requestLayout();
        }
    }

    public void setMinWidth(int arg2) {
        if(arg2 != this.i) {
            this.i = arg2;
            this.requestLayout();
        }
    }

    public void setOptimizationLevel(int arg2) {
        this.b.a(arg2);
    }

    public boolean shouldDelayChildPressedState() {
        return 0;
    }
}

