package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c {
    class android.support.constraint.c$1 {
    }

    class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public float Q;
        public float R;
        public int S;
        public int T;
        public float U;
        public boolean V;
        public float W;
        public float X;
        public float Y;
        public float Z;
        boolean a;
        public float aa;
        public float ab;
        public float ac;
        public float ad;
        public float ae;
        public float af;
        public float ag;
        public boolean ah;
        public boolean ai;
        public int aj;
        public int ak;
        public int al;
        public int am;
        public int an;
        public int ao;
        public float ap;
        public float aq;
        public int ar;
        public int as;
        public int[] at;
        public int b;
        public int c;
        int d;
        public int e;
        public int f;
        public float g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public float u;
        public float v;
        public String w;
        public int x;
        public int y;
        public float z;

        a(android.support.constraint.c$1 arg1) {
            this();
        }

        private a() {
            super();
            this.a = false;
            this.e = -1;
            this.f = -1;
            this.g = -1f;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = 0.5f;
            this.v = 0.5f;
            this.w = null;
            this.x = -1;
            this.y = 0;
            this.z = 0f;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = -1;
            this.G = -1;
            this.H = -1;
            this.I = -1;
            this.J = 0;
            this.K = -1;
            this.L = -1;
            this.M = -1;
            this.N = -1;
            this.O = -1;
            this.P = -1;
            this.Q = 0f;
            this.R = 0f;
            this.S = 0;
            this.T = 0;
            this.U = 1f;
            this.V = false;
            this.W = 0f;
            this.X = 0f;
            this.Y = 0f;
            this.Z = 0f;
            this.aa = 1f;
            this.ab = 1f;
            this.ac = NaNf;
            this.ad = NaNf;
            this.ae = 0f;
            this.af = 0f;
            this.ag = 0f;
            this.ah = false;
            this.ai = false;
            this.aj = -1;
            this.ak = -1;
            this.al = -1;
            this.am = -1;
            this.an = -1;
            this.ao = -1;
            this.ap = 1f;
            this.aq = 1f;
            this.ar = -1;
            this.as = -1;
        }

        public void a(android.support.constraint.ConstraintLayout$a arg3) {
            arg3.d = this.h;
            arg3.e = this.i;
            arg3.f = this.j;
            arg3.g = this.k;
            arg3.h = this.l;
            arg3.i = this.m;
            arg3.j = this.n;
            arg3.k = this.o;
            arg3.l = this.p;
            arg3.p = this.q;
            arg3.q = this.r;
            arg3.r = this.s;
            arg3.s = this.t;
            arg3.leftMargin = this.D;
            arg3.rightMargin = this.E;
            arg3.topMargin = this.F;
            arg3.bottomMargin = this.G;
            arg3.x = this.P;
            arg3.y = this.O;
            arg3.z = this.u;
            arg3.A = this.v;
            arg3.m = this.x;
            arg3.n = this.y;
            arg3.o = this.z;
            arg3.B = this.w;
            arg3.Q = this.A;
            arg3.R = this.B;
            arg3.F = this.Q;
            arg3.E = this.R;
            arg3.H = this.T;
            arg3.G = this.S;
            arg3.T = this.ah;
            arg3.U = this.ai;
            arg3.I = this.aj;
            arg3.J = this.ak;
            arg3.M = this.al;
            arg3.N = this.am;
            arg3.K = this.an;
            arg3.L = this.ao;
            arg3.O = this.ap;
            arg3.P = this.aq;
            arg3.S = this.C;
            arg3.c = this.g;
            arg3.a = this.e;
            arg3.b = this.f;
            arg3.width = this.b;
            arg3.height = this.c;
            if(Build$VERSION.SDK_INT >= 17) {
                arg3.setMarginStart(this.I);
                arg3.setMarginEnd(this.H);
            }

            arg3.a();
        }

        static void a(a arg0, b arg1, int arg2, android.support.constraint.d$a arg3) {
            arg0.a(arg1, arg2, arg3);
        }

        static void a(a arg0, int arg1, android.support.constraint.d$a arg2) {
            arg0.a(arg1, arg2);
        }

        private void a(int arg3, android.support.constraint.ConstraintLayout$a arg4) {
            this.d = arg3;
            this.h = arg4.d;
            this.i = arg4.e;
            this.j = arg4.f;
            this.k = arg4.g;
            this.l = arg4.h;
            this.m = arg4.i;
            this.n = arg4.j;
            this.o = arg4.k;
            this.p = arg4.l;
            this.q = arg4.p;
            this.r = arg4.q;
            this.s = arg4.r;
            this.t = arg4.s;
            this.u = arg4.z;
            this.v = arg4.A;
            this.w = arg4.B;
            this.x = arg4.m;
            this.y = arg4.n;
            this.z = arg4.o;
            this.A = arg4.Q;
            this.B = arg4.R;
            this.C = arg4.S;
            this.g = arg4.c;
            this.e = arg4.a;
            this.f = arg4.b;
            this.b = arg4.width;
            this.c = arg4.height;
            this.D = arg4.leftMargin;
            this.E = arg4.rightMargin;
            this.F = arg4.topMargin;
            this.G = arg4.bottomMargin;
            this.Q = arg4.F;
            this.R = arg4.E;
            this.T = arg4.H;
            this.S = arg4.G;
            this.ah = arg4.T;
            this.ai = arg4.U;
            this.aj = arg4.I;
            this.ak = arg4.J;
            this.ah = arg4.T;
            this.al = arg4.M;
            this.am = arg4.N;
            this.an = arg4.K;
            this.ao = arg4.L;
            this.ap = arg4.O;
            this.aq = arg4.P;
            if(Build$VERSION.SDK_INT >= 17) {
                this.H = arg4.getMarginEnd();
                this.I = arg4.getMarginStart();
            }
        }

        private void a(int arg2, android.support.constraint.d$a arg3) {
            this.a(arg2, ((android.support.constraint.ConstraintLayout$a)arg3));
            this.U = arg3.an;
            this.X = arg3.aq;
            this.Y = arg3.ar;
            this.Z = arg3.as;
            this.aa = arg3.at;
            this.ab = arg3.au;
            this.ac = arg3.av;
            this.ad = arg3.aw;
            this.ae = arg3.ax;
            this.af = arg3.ay;
            this.ag = arg3.az;
            this.W = arg3.ap;
            this.V = arg3.ao;
        }

        private void a(b arg2, int arg3, android.support.constraint.d$a arg4) {
            this.a(arg3, arg4);
            if((arg2 instanceof android.support.constraint.a)) {
                this.as = 1;
                this.ar = ((android.support.constraint.a)arg2).getType();
                this.at = ((android.support.constraint.a)arg2).getReferencedIds();
            }
        }

        public a a() {
            a v0 = new a();
            v0.a = this.a;
            v0.b = this.b;
            v0.c = this.c;
            v0.e = this.e;
            v0.f = this.f;
            v0.g = this.g;
            v0.h = this.h;
            v0.i = this.i;
            v0.j = this.j;
            v0.k = this.k;
            v0.l = this.l;
            v0.m = this.m;
            v0.n = this.n;
            v0.o = this.o;
            v0.p = this.p;
            v0.q = this.q;
            v0.r = this.r;
            v0.s = this.s;
            v0.t = this.t;
            v0.u = this.u;
            v0.v = this.v;
            v0.w = this.w;
            v0.A = this.A;
            v0.B = this.B;
            v0.u = this.u;
            v0.u = this.u;
            v0.u = this.u;
            v0.u = this.u;
            v0.u = this.u;
            v0.C = this.C;
            v0.D = this.D;
            v0.E = this.E;
            v0.F = this.F;
            v0.G = this.G;
            v0.H = this.H;
            v0.I = this.I;
            v0.J = this.J;
            v0.K = this.K;
            v0.L = this.L;
            v0.M = this.M;
            v0.N = this.N;
            v0.O = this.O;
            v0.P = this.P;
            v0.Q = this.Q;
            v0.R = this.R;
            v0.S = this.S;
            v0.T = this.T;
            v0.U = this.U;
            v0.V = this.V;
            v0.W = this.W;
            v0.X = this.X;
            v0.Y = this.Y;
            v0.Z = this.Z;
            v0.aa = this.aa;
            v0.ab = this.ab;
            v0.ac = this.ac;
            v0.ad = this.ad;
            v0.ae = this.ae;
            v0.af = this.af;
            v0.ag = this.ag;
            v0.ah = this.ah;
            v0.ai = this.ai;
            v0.aj = this.aj;
            v0.ak = this.ak;
            v0.al = this.al;
            v0.am = this.am;
            v0.an = this.an;
            v0.ao = this.ao;
            v0.ap = this.ap;
            v0.aq = this.aq;
            v0.ar = this.ar;
            v0.as = this.as;
            if(this.at != null) {
                v0.at = Arrays.copyOf(this.at, this.at.length);
            }

            v0.x = this.x;
            v0.y = this.y;
            v0.z = this.z;
            return v0;
        }

        public Object clone() {
            return this.a();
        }
    }

    private static final int[] a;
    private HashMap b;
    private static SparseIntArray c;

    static {
        c.a = new int[]{0, 4, 8};
        c.c = new SparseIntArray();
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintRight_toRightOf, 30);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintTop_toTopOf, 36);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_editor_absoluteX, 6);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_editor_absoluteY, 7);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintGuide_begin, 17);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintGuide_end, 18);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintGuide_percent, 19);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_orientation, 27);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintStart_toEndOf, 0x20);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintStart_toStartOf, 33);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_goneMarginLeft, 13);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_goneMarginTop, 16);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_goneMarginRight, 14);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_goneMarginBottom, 11);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_goneMarginStart, 15);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_goneMarginEnd, 12);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintVertical_weight, 40);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintHorizontal_weight, 39);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintHorizontal_bias, 20);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintVertical_bias, 37);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintDimensionRatio, 5);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintLeft_creator, 0x40);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintTop_creator, 0x40);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintRight_creator, 0x40);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintBottom_creator, 0x40);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintBaseline_creator, 0x40);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_layout_marginLeft, 24);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_layout_marginRight, 28);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_layout_marginStart, 0x1F);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_layout_marginEnd, 8);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_layout_marginTop, 34);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_layout_marginBottom, 2);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_layout_width, 23);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_layout_height, 21);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_visibility, 22);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_alpha, 43);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_elevation, 44);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_rotationX, 45);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_rotationY, 46);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_rotation, 60);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_scaleX, 0x2F);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_scaleY, 0x30);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_transformPivotX, 49);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_transformPivotY, 50);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_translationX, 51);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_translationY, 52);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_translationZ, 53);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintWidth_default, 54);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintHeight_default, 55);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintWidth_max, 56);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintHeight_max, 57);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintWidth_min, 58);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintHeight_min, 59);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintCircle, 61);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintCircleRadius, 62);
        c.c.append(android.support.constraint.g$b.ConstraintSet_layout_constraintCircleAngle, 0x3F);
        c.c.append(android.support.constraint.g$b.ConstraintSet_android_id, 38);
    }

    public c() {
        super();
        this.b = new HashMap();
    }

    public void a(Context arg6, int arg7) {
        XmlResourceParser v1 = arg6.getResources().getXml(arg7);
        try {
            int v0_2;
            for(v0_2 = ((XmlPullParser)v1).getEventType(); v0_2 != 1; v0_2 = ((XmlPullParser)v1).next()) {
                switch(v0_2) {
                    case 0: {
                        ((XmlPullParser)v1).getName();
                        break;
                    }
                    case 2: {
                        String v0_3 = ((XmlPullParser)v1).getName();
                        a v2 = this.a(arg6, Xml.asAttributeSet(((XmlPullParser)v1)));
                        if(v0_3.equalsIgnoreCase("Guideline")) {
                            v2.a = true;
                        }

                        this.b.put(Integer.valueOf(v2.d), v2);
                        break;
                    }
                }
            }
        }
        catch(IOException v0) {
            v0.printStackTrace();
        }
        catch(XmlPullParserException v0_1) {
            v0_1.printStackTrace();
        }
    }

    void a(ConstraintLayout arg9) {
        Object v0;
        int v7 = -1;
        int v4 = arg9.getChildCount();
        HashSet v5 = new HashSet(this.b.keySet());
        int v3;
        for(v3 = 0; v3 < v4; ++v3) {
            View v2 = arg9.getChildAt(v3);
            int v6 = v2.getId();
            if(v6 == v7) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }

            if(this.b.containsKey(Integer.valueOf(v6))) {
                v5.remove(Integer.valueOf(v6));
                v0 = this.b.get(Integer.valueOf(v6));
                if(((a)v0).as != v7) {
                    switch(((a)v0).as) {
                        case 1: {
                            v2.setId(v6);
                            v2.setReferencedIds(((a)v0).at);
                            v2.setType(((a)v0).ar);
                            ((a)v0).a(arg9.a());
                            goto label_29;
                        }
                    }
                }

            label_29:
                ViewGroup$LayoutParams v1 = v2.getLayoutParams();
                ((a)v0).a(((android.support.constraint.ConstraintLayout$a)v1));
                v2.setLayoutParams(v1);
                v2.setVisibility(((a)v0).J);
                if(Build$VERSION.SDK_INT < 17) {
                    goto label_72;
                }

                v2.setAlpha(((a)v0).U);
                v2.setRotation(((a)v0).X);
                v2.setRotationX(((a)v0).Y);
                v2.setRotationY(((a)v0).Z);
                v2.setScaleX(((a)v0).aa);
                v2.setScaleY(((a)v0).ab);
                if(!Float.isNaN(((a)v0).ac)) {
                    v2.setPivotX(((a)v0).ac);
                }

                if(!Float.isNaN(((a)v0).ad)) {
                    v2.setPivotY(((a)v0).ad);
                }

                v2.setTranslationX(((a)v0).ae);
                v2.setTranslationY(((a)v0).af);
                if(Build$VERSION.SDK_INT < 21) {
                    goto label_72;
                }

                v2.setTranslationZ(((a)v0).ag);
                if(!((a)v0).V) {
                    goto label_72;
                }

                v2.setElevation(((a)v0).W);
            }

        label_72:
        }

        Iterator v2_1 = v5.iterator();
        while(v2_1.hasNext()) {
            v0 = v2_1.next();
            Object v1_1 = this.b.get(v0);
            if(((a)v1_1).as != v7) {
                switch(((a)v1_1).as) {
                    case 1: {
                        android.support.constraint.a v3_1 = new android.support.constraint.a(arg9.getContext());
                        v3_1.setId(((Integer)v0).intValue());
                        v3_1.setReferencedIds(((a)v1_1).at);
                        v3_1.setType(((a)v1_1).ar);
                        android.support.constraint.ConstraintLayout$a v4_1 = arg9.a();
                        ((a)v1_1).a(v4_1);
                        arg9.addView(((View)v3_1), ((ViewGroup$LayoutParams)v4_1));
                        goto label_94;
                    }
                }
            }

        label_94:
            if(!((a)v1_1).a) {
                continue;
            }

            e v3_2 = new e(arg9.getContext());
            v3_2.setId(((Integer)v0).intValue());
            android.support.constraint.ConstraintLayout$a v0_1 = arg9.a();
            ((a)v1_1).a(v0_1);
            arg9.addView(((View)v3_2), ((ViewGroup$LayoutParams)v0_1));
        }
    }

    private static int a(TypedArray arg2, int arg3, int arg4) {
        int v1 = -1;
        int v0 = arg2.getResourceId(arg3, arg4);
        if(v0 == v1) {
            v0 = arg2.getInt(arg3, v1);
        }

        return v0;
    }

    private a a(Context arg3, AttributeSet arg4) {
        a v0 = new a(null);
        TypedArray v1 = arg3.obtainStyledAttributes(arg4, android.support.constraint.g$b.ConstraintSet);
        this.a(v0, v1);
        v1.recycle();
        return v0;
    }

    private void a(a arg7, TypedArray arg8) {
        int v1 = arg8.getIndexCount();
        int v0;
        for(v0 = 0; v0 < v1; ++v0) {
            int v2 = arg8.getIndex(v0);
            switch(c.c.get(v2)) {
                case 1: {
                    arg7.p = c.a(arg8, v2, arg7.p);
                    break;
                }
                case 2: {
                    arg7.G = arg8.getDimensionPixelSize(v2, arg7.G);
                    break;
                }
                case 3: {
                    arg7.o = c.a(arg8, v2, arg7.o);
                    break;
                }
                case 4: {
                    arg7.n = c.a(arg8, v2, arg7.n);
                    break;
                }
                case 5: {
                    arg7.w = arg8.getString(v2);
                    break;
                }
                case 6: {
                    arg7.A = arg8.getDimensionPixelOffset(v2, arg7.A);
                    break;
                }
                case 7: {
                    arg7.B = arg8.getDimensionPixelOffset(v2, arg7.B);
                    break;
                }
                case 8: {
                    arg7.H = arg8.getDimensionPixelSize(v2, arg7.H);
                    break;
                }
                case 9: {
                    arg7.t = c.a(arg8, v2, arg7.t);
                    break;
                }
                case 10: {
                    arg7.s = c.a(arg8, v2, arg7.s);
                    break;
                }
                case 11: {
                    arg7.N = arg8.getDimensionPixelSize(v2, arg7.N);
                    break;
                }
                case 12: {
                    arg7.O = arg8.getDimensionPixelSize(v2, arg7.O);
                    break;
                }
                case 13: {
                    arg7.K = arg8.getDimensionPixelSize(v2, arg7.K);
                    break;
                }
                case 14: {
                    arg7.M = arg8.getDimensionPixelSize(v2, arg7.M);
                    break;
                }
                case 15: {
                    arg7.P = arg8.getDimensionPixelSize(v2, arg7.P);
                    break;
                }
                case 16: {
                    arg7.L = arg8.getDimensionPixelSize(v2, arg7.L);
                    break;
                }
                case 17: {
                    arg7.e = arg8.getDimensionPixelOffset(v2, arg7.e);
                    break;
                }
                case 18: {
                    arg7.f = arg8.getDimensionPixelOffset(v2, arg7.f);
                    break;
                }
                case 19: {
                    arg7.g = arg8.getFloat(v2, arg7.g);
                    break;
                }
                case 20: {
                    arg7.u = arg8.getFloat(v2, arg7.u);
                    break;
                }
                case 21: {
                    arg7.c = arg8.getLayoutDimension(v2, arg7.c);
                    break;
                }
                case 22: {
                    arg7.J = arg8.getInt(v2, arg7.J);
                    arg7.J = c.a[arg7.J];
                    break;
                }
                case 23: {
                    arg7.b = arg8.getLayoutDimension(v2, arg7.b);
                    break;
                }
                case 24: {
                    arg7.D = arg8.getDimensionPixelSize(v2, arg7.D);
                    break;
                }
                case 25: {
                    arg7.h = c.a(arg8, v2, arg7.h);
                    break;
                }
                case 26: {
                    arg7.i = c.a(arg8, v2, arg7.i);
                    break;
                }
                case 27: {
                    arg7.C = arg8.getInt(v2, arg7.C);
                    break;
                }
                case 28: {
                    arg7.E = arg8.getDimensionPixelSize(v2, arg7.E);
                    break;
                }
                case 29: {
                    arg7.j = c.a(arg8, v2, arg7.j);
                    break;
                }
                case 30: {
                    arg7.k = c.a(arg8, v2, arg7.k);
                    break;
                }
                case 31: {
                    arg7.I = arg8.getDimensionPixelSize(v2, arg7.I);
                    break;
                }
                case 32: {
                    arg7.q = c.a(arg8, v2, arg7.q);
                    break;
                }
                case 33: {
                    arg7.r = c.a(arg8, v2, arg7.r);
                    break;
                }
                case 34: {
                    arg7.F = arg8.getDimensionPixelSize(v2, arg7.F);
                    break;
                }
                case 35: {
                    arg7.m = c.a(arg8, v2, arg7.m);
                    break;
                }
                case 36: {
                    arg7.l = c.a(arg8, v2, arg7.l);
                    break;
                }
                case 37: {
                    arg7.v = arg8.getFloat(v2, arg7.v);
                    break;
                }
                case 38: {
                    arg7.d = arg8.getResourceId(v2, arg7.d);
                    break;
                }
                case 39: {
                    arg7.R = arg8.getFloat(v2, arg7.R);
                    break;
                }
                case 40: {
                    arg7.Q = arg8.getFloat(v2, arg7.Q);
                    break;
                }
                case 41: {
                    arg7.S = arg8.getInt(v2, arg7.S);
                    break;
                }
                case 42: {
                    arg7.T = arg8.getInt(v2, arg7.T);
                    break;
                }
                case 43: {
                    arg7.U = arg8.getFloat(v2, arg7.U);
                    break;
                }
                case 44: {
                    arg7.V = true;
                    arg7.W = arg8.getDimension(v2, arg7.W);
                    break;
                }
                case 45: {
                    arg7.Y = arg8.getFloat(v2, arg7.Y);
                    break;
                }
                case 46: {
                    arg7.Z = arg8.getFloat(v2, arg7.Z);
                    break;
                }
                case 47: {
                    arg7.aa = arg8.getFloat(v2, arg7.aa);
                    break;
                }
                case 48: {
                    arg7.ab = arg8.getFloat(v2, arg7.ab);
                    break;
                }
                case 49: {
                    arg7.ac = arg8.getFloat(v2, arg7.ac);
                    break;
                }
                case 50: {
                    arg7.ad = arg8.getFloat(v2, arg7.ad);
                    break;
                }
                case 51: {
                    arg7.ae = arg8.getDimension(v2, arg7.ae);
                    break;
                }
                case 52: {
                    arg7.af = arg8.getDimension(v2, arg7.af);
                    break;
                }
                case 53: {
                    arg7.ag = arg8.getDimension(v2, arg7.ag);
                    break;
                }
                case 60: {
                    arg7.X = arg8.getFloat(v2, arg7.X);
                    break;
                }
                case 61: {
                    arg7.x = c.a(arg8, v2, arg7.x);
                    break;
                }
                case 62: {
                    arg7.y = arg8.getDimensionPixelSize(v2, arg7.y);
                    break;
                }
                case 63: {
                    arg7.z = arg8.getFloat(v2, arg7.z);
                    break;
                }
                case 64: {
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(v2) + "   " + c.c.get(v2));
                    break;
                }
                default: {
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(v2) + "   " + c.c.get(v2));
                    break;
                }
            }
        }
    }

    public void a(d arg10) {
        int v4 = arg10.getChildCount();
        this.b.clear();
        int v3;
        for(v3 = 0; v3 < v4; ++v3) {
            View v2 = arg10.getChildAt(v3);
            ViewGroup$LayoutParams v0 = v2.getLayoutParams();
            int v5 = v2.getId();
            if(v5 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }

            if(!this.b.containsKey(Integer.valueOf(v5))) {
                this.b.put(Integer.valueOf(v5), new a(null));
            }

            Object v1 = this.b.get(Integer.valueOf(v5));
            if((v2 instanceof b)) {
                a.a(((a)v1), ((b)v2), v5, ((android.support.constraint.d$a)v0));
            }

            a.a(((a)v1), v5, ((android.support.constraint.d$a)v0));
        }
    }
}

