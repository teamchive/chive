package android.support.v4.a;

import android.graphics.Rect;
import android.os.Build$VERSION;
import android.support.v4.h.p;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class s {
    class a {
        public h a;
        public boolean b;
        public c c;
        public h d;
        public boolean e;
        public c f;

        a() {
            super();
        }
    }

    private static final int[] a;

    static {
        s.a = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
    }

    static void a(n arg7, ArrayList arg8, ArrayList arg9, int arg10, int arg11, boolean arg12) {
        Object v0;
        if(arg7.l >= 1 && Build$VERSION.SDK_INT >= 21) {
            SparseArray v3 = new SparseArray();
            int v2;
            for(v2 = arg10; v2 < arg11; ++v2) {
                v0 = arg8.get(v2);
                if(arg9.get(v2).booleanValue()) {
                    s.b(((c)v0), v3, arg12);
                }
                else {
                    s.a(((c)v0), v3, arg12);
                }
            }

            if(v3.size() == 0) {
                return;
            }

            View v2_1 = new View(arg7.m.g());
            int v4 = v3.size();
            int v1;
            for(v1 = 0; v1 < v4; ++v1) {
                int v5 = v3.keyAt(v1);
                android.support.v4.g.a v6 = s.a(v5, arg8, arg9, arg10, arg11);
                v0 = v3.valueAt(v1);
                if(arg12) {
                    s.a(arg7, v5, ((a)v0), v2_1, v6);
                }
                else {
                    s.b(arg7, v5, ((a)v0), v2_1, v6);
                }
            }
        }
    }

    private static a a(a arg0, SparseArray arg1, int arg2) {
        if(arg0 == null) {
            arg0 = new a();
            arg1.put(arg2, arg0);
        }

        return arg0;
    }

    private static android.support.v4.g.a a(int arg9, ArrayList arg10, ArrayList arg11, int arg12, int arg13) {
        ArrayList v4;
        ArrayList v3;
        android.support.v4.g.a v7 = new android.support.v4.g.a();
        int v6;
        for(v6 = arg13 - 1; v6 >= arg12; --v6) {
            Object v0 = arg10.get(v6);
            if(((c)v0).b(arg9)) {
                boolean v1 = arg11.get(v6).booleanValue();
                if(((c)v0).s != null) {
                    int v8 = ((c)v0).s.size();
                    if(v1) {
                        v3 = ((c)v0).s;
                        v4 = ((c)v0).t;
                    }
                    else {
                        ArrayList v1_1 = ((c)v0).s;
                        v3 = ((c)v0).t;
                        v4 = v1_1;
                    }

                    int v5;
                    for(v5 = 0; v5 < v8; ++v5) {
                        v0 = v4.get(v5);
                        Object v1_2 = v3.get(v5);
                        Object v2 = v7.remove(v1_2);
                        if(v2 != null) {
                            v7.put(v0, v2);
                        }
                        else {
                            v7.put(v0, v1_2);
                        }
                    }
                }
            }
        }

        return v7;
    }

    static android.support.v4.g.a a(android.support.v4.g.a arg1, Object arg2, a arg3) {
        return s.c(arg1, arg2, arg3);
    }

    static View a(android.support.v4.g.a arg1, a arg2, Object arg3, boolean arg4) {
        return s.b(arg1, arg2, arg3, arg4);
    }

    private static Object a(h arg1, h arg2, boolean arg3) {
        Object v0;
        if(arg1 == null || arg2 == null) {
            v0 = null;
        }
        else {
            v0 = arg3 ? arg2.x() : arg1.w();
            v0 = t.b(t.a(v0));
        }

        return v0;
    }

    private static Object a(h arg1, boolean arg2) {
        Object v0;
        if(arg1 == null) {
            v0 = null;
        }
        else {
            v0 = arg2 ? arg1.v() : arg1.s();
            v0 = t.a(v0);
        }

        return v0;
    }

    private static Object a(ViewGroup arg8, View arg9, android.support.v4.g.a arg10, a arg11, ArrayList arg12, ArrayList arg13, Object arg14, Object arg15) {
        View v5_1;
        Rect v6_1;
        Object v7;
        Object v5 = null;
        h v1 = arg11.a;
        h v2 = arg11.d;
        if(v1 != null) {
            v1.i().setVisibility(0);
        }

        if(v1 != null && v2 != null) {
            boolean v3 = arg11.b;
            Object v0 = arg10.isEmpty() ? v5 : s.a(v1, v2, v3);
            android.support.v4.g.a v6 = s.b(arg10, v0, arg11);
            android.support.v4.g.a v4 = s.c(arg10, v0, arg11);
            if(arg10.isEmpty()) {
                if(v6 != null) {
                    v6.clear();
                }

                if(v4 != null) {
                    v4.clear();
                    v7 = v5;
                    goto label_23;
                }

                v7 = v5;
            }
            else {
                s.a(arg12, v6, arg10.keySet());
                s.a(arg13, v4, arg10.values());
                v7 = v0;
            }

        label_23:
            if(arg14 == null && arg15 == null && v7 == null) {
                return v5;
            }

            s.b(v1, v2, v3, v6, true);
            if(v7 != null) {
                arg13.add(arg9);
                t.a(v7, arg9, arg12);
                s.a(v7, arg15, v6, arg11.e, arg11.f);
                v6_1 = new Rect();
                v5_1 = s.b(v4, arg11, arg14, v3);
                if(v5_1 != null) {
                    t.a(arg14, v6_1);
                }
            }
            else {
                v6_1 = ((Rect)v5);
            }

            x.a(((View)arg8), new Runnable(v1, v2, v3, v4, v5_1, v6_1) {
                public void run() {
                    s.a(this.a, this.b, this.c, this.d, false);
                    if(this.e != null) {
                        t.a(this.e, this.f);
                    }
                }
            });
            v5 = v7;
        }

        return v5;
    }

    private static void a(ArrayList arg3, android.support.v4.g.a arg4, Collection arg5) {
        int v1;
        for(v1 = arg4.size() - 1; v1 >= 0; --v1) {
            Object v0 = arg4.c(v1);
            if(arg5.contains(p.e(((View)v0)))) {
                arg3.add(v0);
            }
        }
    }

    private static void a(Object arg2, Object arg3, android.support.v4.g.a arg4, boolean arg5, c arg6) {
        if(arg6.s != null && !arg6.s.isEmpty()) {
            Object v0 = arg5 ? arg6.t.get(0) : arg6.s.get(0);
            v0 = arg4.get(v0);
            t.a(arg2, ((View)v0));
            if(arg3 == null) {
                return;
            }

            t.a(arg3, ((View)v0));
        }
    }

    static void a(h arg0, h arg1, boolean arg2, android.support.v4.g.a arg3, boolean arg4) {
        s.b(arg0, arg1, arg2, arg3, arg4);
    }

    private static Object a(Object arg1, Object arg2, Object arg3, h arg4, boolean arg5) {
        boolean v0 = true;
        if(arg1 != null && arg2 != null && arg4 != null) {
            v0 = arg5 ? arg4.z() : arg4.y();
        }

        Object v0_1 = v0 ? t.a(arg2, arg1, arg3) : t.b(arg2, arg1, arg3);
        return v0_1;
    }

    private static String a(android.support.v4.g.a arg3, String arg4) {
        String v0_2;
        int v1 = arg3.size();
        int v0 = 0;
        while(true) {
            if(v0 >= v1) {
                break;
            }
            else if(arg4.equals(arg3.c(v0))) {
                Object v0_1 = arg3.b(v0);
            }
            else {
                ++v0;
                continue;
            }

            return v0_2;
        }

        v0_2 = null;
        return v0_2;
    }

    static ArrayList a(Object arg1, h arg2, ArrayList arg3, View arg4) {
        return s.b(arg1, arg2, arg3, arg4);
    }

    private static void a(c arg11, android.support.v4.a.c$a arg12, SparseArray arg13, boolean arg14, boolean arg15) {
        a v0_4;
        Object v8_1;
        boolean v5;
        int v7;
        int v6;
        int v4;
        boolean v0_1;
        h v10 = null;
        h v1 = arg12.b;
        if(v1 != null) {
            int v9 = v1.x;
            if(v9 != 0) {
                int v0 = arg14 ? s.a[arg12.a] : arg12.a;
                switch(v0) {
                    case 4: {
                        if(arg15) {
                            if((v1.Q) && (v1.k) && (v1.z)) {
                                v0 = 1;
                                goto label_97;
                            }

                            v0 = 0;
                        }
                        else {
                            if((v1.k) && !v1.z) {
                                v0 = 1;
                                goto label_97;
                            }

                            v0 = 0;
                        }

                    label_97:
                        v4 = 0;
                        v6 = v0;
                        v7 = 1;
                        v5 = false;
                        break;
                    }
                    case 5: {
                        if(arg15) {
                            if((v1.Q) && !v1.z && (v1.k)) {
                                v0_1 = true;
                                goto label_65;
                            }

                            v0_1 = false;
                        }
                        else {
                            v0_1 = v1.z;
                        }

                    label_65:
                        v4 = 1;
                        v6 = 0;
                        v7 = 0;
                        v5 = v0_1;
                        break;
                    }
                    case 3: 
                    case 6: {
                        if(arg15) {
                            if(!v1.k && v1.H != null && v1.H.getVisibility() == 0 && v1.R >= 0f) {
                                v0 = 1;
                                goto label_124;
                            }

                            v0 = 0;
                        }
                        else {
                            if((v1.k) && !v1.z) {
                                v0 = 1;
                                goto label_124;
                            }

                            v0 = 0;
                        }

                    label_124:
                        v4 = 0;
                        v6 = v0;
                        v7 = 1;
                        v5 = false;
                        break;
                    }
                    case 1: 
                    case 7: {
                        if(arg15) {
                            v0_1 = v1.P;
                        }
                        else {
                            if(!v1.k && !v1.z) {
                                v0_1 = true;
                                goto label_76;
                            }

                            v0_1 = false;
                        }

                    label_76:
                        v4 = 1;
                        v6 = 0;
                        v7 = 0;
                        v5 = v0_1;
                        break;
                    }
                    default: {
                        v4 = 0;
                        v6 = 0;
                        v7 = 0;
                        v5 = false;
                        break;
                    }
                }

                Object v0_2 = arg13.get(v9);
                if(v5) {
                    a v8 = s.a(((a)v0_2), arg13, v9);
                    v8.a = v1;
                    v8.b = arg14;
                    v8.c = arg11;
                }
                else {
                    v8_1 = v0_2;
                }

                if(!arg15 && v4 != 0) {
                    if((((a)v8_1)) != null && ((a)v8_1).d == v1) {
                        ((a)v8_1).d = v10;
                    }

                    n v0_3 = arg11.b;
                    if(v1.b >= 1) {
                        goto label_40;
                    }

                    if(v0_3.l < 1) {
                        goto label_40;
                    }

                    if(arg11.u) {
                        goto label_40;
                    }

                    v0_3.f(v1);
                    v0_3.a(v1, 1, 0, 0, false);
                }

            label_40:
                if(v6 != 0) {
                    if((((a)v8_1)) != null && ((a)v8_1).d != null) {
                        goto label_139;
                    }

                    v0_4 = s.a(((a)v8_1), arg13, v9);
                    v0_4.d = v1;
                    v0_4.e = arg14;
                    v0_4.f = arg11;
                }
                else {
                label_139:
                    v0_4 = ((a)v8_1);
                }

                if(arg15) {
                    return;
                }

                if(v7 == 0) {
                    return;
                }

                if(v0_4 == null) {
                    return;
                }

                if(v0_4.a != v1) {
                    return;
                }

                v0_4.a = v10;
            }
        }
    }

    public static void a(c arg4, SparseArray arg5, boolean arg6) {
        int v3 = arg4.c.size();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            s.a(arg4, arg4.c.get(v1), arg5, false, arg6);
        }
    }

    private static void a(n arg16, int arg17, a arg18, View arg19, android.support.v4.g.a arg20) {
        View v1 = null;
        if(arg16.n.a()) {
            v1 = arg16.n.a(arg17);
        }

        if(v1 != null) {
            h v9 = arg18.a;
            h v10 = arg18.d;
            boolean v12 = arg18.b;
            boolean v2 = arg18.e;
            ArrayList v6 = new ArrayList();
            ArrayList v5 = new ArrayList();
            Object v7 = s.a(v9, v12);
            Object v8 = s.b(v10, v2);
            Object v14 = s.a(((ViewGroup)v1), arg19, arg20, arg18, v5, v6, v7, v8);
            if(v7 == null && v14 == null && v8 == null) {
                return;
            }

            ArrayList v13 = s.b(v8, v10, v5, arg19);
            ArrayList v11 = s.b(v7, v9, v6, arg19);
            s.b(v11, 4);
            Object v9_1 = s.a(v7, v8, v14, v9, v12);
            if(v9_1 == null) {
                return;
            }

            s.a(v8, v10, v13);
            ArrayList v2_1 = t.a(v6);
            t.a(v9_1, v7, v11, v8, v13, v14, v6);
            t.a(((ViewGroup)v1), v9_1);
            t.a(v1, v5, v6, v2_1, arg20);
            s.b(v11, 0);
            t.a(v14, v5, v6);
        }
    }

    private static void a(Object arg2, h arg3, ArrayList arg4) {
        if(arg3 != null && arg2 != null && (arg3.k) && (arg3.z) && (arg3.Q)) {
            arg3.f(true);
            t.b(arg2, arg3.i(), arg4);
            x.a(arg3.G, new Runnable(arg4) {
                public void run() {
                    s.a(this.a, 4);
                }
            });
        }
    }

    private static void a(android.support.v4.g.a arg2, android.support.v4.g.a arg3) {
        int v1;
        for(v1 = arg2.size() - 1; v1 >= 0; --v1) {
            if(!arg3.containsKey(arg2.c(v1))) {
                arg2.d(v1);
            }
        }
    }

    private static void a(ViewGroup arg8, h arg9, View arg10, ArrayList arg11, Object arg12, ArrayList arg13, Object arg14, ArrayList arg15) {
        x.a(((View)arg8), new Runnable(arg12, arg10, arg9, arg11, arg13, arg15, arg14) {
            public void run() {
                if(this.a != null) {
                    t.c(this.a, this.b);
                    this.e.addAll(s.a(this.a, this.c, this.d, this.b));
                }

                if(this.f != null) {
                    if(this.g != null) {
                        ArrayList v0 = new ArrayList();
                        v0.add(this.b);
                        t.b(this.g, this.f, v0);
                    }

                    this.f.clear();
                    this.f.add(this.b);
                }
            }
        });
    }

    static void a(ArrayList arg0, int arg1) {
        s.b(arg0, arg1);
    }

    private static View b(android.support.v4.g.a arg3, a arg4, Object arg5, boolean arg6) {
        View v0_2;
        c v0 = arg4.c;
        if(arg5 == null || arg3 == null || v0.s == null || (v0.s.isEmpty())) {
            v0_2 = null;
        }
        else {
            Object v0_1 = arg6 ? v0.s.get(0) : v0.t.get(0);
            v0_1 = arg3.get(v0_1);
        }

        return v0_2;
    }

    private static android.support.v4.g.a b(android.support.v4.g.a arg6, Object arg7, a arg8) {
        android.support.v4.g.a v0_3;
        y v0_1;
        ArrayList v2_1;
        y v1;
        if((arg6.isEmpty()) || arg7 == null) {
            arg6.clear();
            v0_3 = null;
        }
        else {
            h v0 = arg8.d;
            android.support.v4.g.a v3 = new android.support.v4.g.a();
            t.a(((Map)v3), v0.i());
            c v2 = arg8.f;
            if(arg8.e) {
                v1 = v0.P();
                v2_1 = v2.t;
                v0_1 = v1;
            }
            else {
                v1 = v0.Q();
                v2_1 = v2.s;
                v0_1 = v1;
            }

            v3.a(((Collection)v2_1));
            if(v0_1 != null) {
                v0_1.a(((List)v2_1), ((Map)v3));
                int v4;
                for(v4 = v2_1.size() - 1; v4 >= 0; --v4) {
                    Object v0_2 = v2_1.get(v4);
                    Object v1_1 = v3.get(v0_2);
                    if(v1_1 == null) {
                        arg6.remove(v0_2);
                    }
                    else if(!((String)v0_2).equals(p.e(((View)v1_1)))) {
                        arg6.put(p.e(((View)v1_1)), arg6.remove(v0_2));
                    }
                }
            }
            else {
                arg6.a(v3.keySet());
            }

            v0_3 = v3;
        }

        return v0_3;
    }

    private static void b(h arg7, h arg8, boolean arg9, android.support.v4.g.a arg10, boolean arg11) {
        List v6 = null;
        int v1 = 0;
        y v2 = arg9 ? arg8.P() : arg7.P();
        if(v2 != null) {
            ArrayList v3 = new ArrayList();
            ArrayList v4 = new ArrayList();
            int v0 = arg10 == null ? 0 : arg10.size();
            while(v1 < v0) {
                v4.add(arg10.b(v1));
                v3.add(arg10.c(v1));
                ++v1;
            }

            if(arg11) {
                v2.a(((List)v4), ((List)v3), v6);
                return;
            }

            v2.b(((List)v4), ((List)v3), v6);
        }
    }

    private static ArrayList b(Object arg2, h arg3, ArrayList arg4, View arg5) {
        ArrayList v0 = null;
        if(arg2 != null) {
            v0 = new ArrayList();
            View v1 = arg3.i();
            if(v1 != null) {
                t.a(v0, v1);
            }

            if(arg4 != null) {
                v0.removeAll(((Collection)arg4));
            }

            if(v0.isEmpty()) {
                return v0;
            }

            v0.add(arg5);
            t.a(arg2, v0);
        }

        return v0;
    }

    private static Object b(h arg1, boolean arg2) {
        Object v0;
        if(arg1 == null) {
            v0 = null;
        }
        else {
            v0 = arg2 ? arg1.t() : arg1.u();
            v0 = t.a(v0);
        }

        return v0;
    }

    private static void b(ArrayList arg2, int arg3) {
        if(arg2 != null) {
            int v1;
            for(v1 = arg2.size() - 1; v1 >= 0; --v1) {
                arg2.get(v1).setVisibility(arg3);
            }
        }
    }

    public static void b(c arg3, SparseArray arg4, boolean arg5) {
        if(arg3.b.n.a()) {
            int v1;
            for(v1 = arg3.c.size() - 1; v1 >= 0; --v1) {
                s.a(arg3, arg3.c.get(v1), arg4, true, arg5);
            }
        }
    }

    private static void b(n arg21, int arg22, a arg23, View arg24, android.support.v4.g.a arg25) {
        View v1 = null;
        if(arg21.n.a()) {
            v1 = arg21.n.a(arg22);
        }

        if(v1 != null) {
            h v15 = arg23.a;
            h v9 = arg23.d;
            boolean v2 = arg23.b;
            boolean v3 = arg23.e;
            Object v7 = s.a(v15, v2);
            Object v8 = s.b(v9, v3);
            ArrayList v5 = new ArrayList();
            ArrayList v6 = new ArrayList();
            Object v13 = s.b(((ViewGroup)v1), arg24, arg25, arg23, v5, v6, v7, v8);
            if(v7 == null && v13 == null && v8 == null) {
                return;
            }

            ArrayList v12 = s.b(v8, v9, v5, arg24);
            Object v11 = v12 == null || (v12.isEmpty()) ? null : v8;
            t.b(v7, arg24);
            v8 = s.a(v7, v11, v13, v15, arg23.b);
            if(v8 == null) {
                return;
            }

            ArrayList v10 = new ArrayList();
            t.a(v8, v7, v10, v11, v12, v13, v6);
            s.a(v1, v15, arg24, v6, v7, v10, v11, v12);
            t.a(v1, v6, arg25);
            t.a(((ViewGroup)v1), v8);
            t.a(((ViewGroup)v1), v6, arg25);
        }
    }

    private static Object b(ViewGroup arg13, View arg14, android.support.v4.g.a arg15, a arg16, ArrayList arg17, ArrayList arg18, Object arg19, Object arg20) {
        Rect v12;
        Object v3;
        h v7 = arg16.a;
        h v8 = arg16.d;
        if(v7 == null || v8 == null) {
            v3 = null;
        }
        else {
            boolean v9 = arg16.b;
            Object v1 = arg15.isEmpty() ? null : s.a(v7, v8, v9);
            android.support.v4.g.a v2 = s.b(arg15, v1, arg16);
            if(arg15.isEmpty()) {
                v3 = null;
            }
            else {
                arg17.addAll(v2.values());
                v3 = v1;
            }

            if(arg19 == null && arg20 == null && v3 == null) {
                return null;
            }

            s.b(v7, v8, v9, v2, true);
            if(v3 != null) {
                v12 = new Rect();
                t.a(v3, arg14, arg17);
                s.a(v3, arg20, v2, arg16.e, arg16.f);
                if(arg19 != null) {
                    t.a(arg19, v12);
                }
            }
            else {
                v12 = null;
            }

            x.a(((View)arg13), new Runnable(arg15, v3, arg16, arg18, arg14, v7, v8, v9, arg17, arg19, v12) {
                public void run() {
                    android.support.v4.g.a v0 = s.a(this.a, this.b, this.c);
                    if(v0 != null) {
                        this.d.addAll(v0.values());
                        this.d.add(this.e);
                    }

                    s.a(this.f, this.g, this.h, v0, false);
                    if(this.b != null) {
                        t.a(this.b, this.i, this.d);
                        View v0_1 = s.a(v0, this.c, this.j, this.h);
                        if(v0_1 != null) {
                            t.a(v0_1, this.k);
                        }
                    }
                }
            });
        }

        return v3;
    }

    private static android.support.v4.g.a c(android.support.v4.g.a arg6, Object arg7, a arg8) {
        android.support.v4.g.a v0_4;
        String v0_3;
        y v0_1;
        ArrayList v4;
        y v1_1;
        h v0 = arg8.a;
        View v1 = v0.i();
        if((arg6.isEmpty()) || arg7 == null || v1 == null) {
            arg6.clear();
            v0_4 = null;
        }
        else {
            android.support.v4.g.a v2 = new android.support.v4.g.a();
            t.a(((Map)v2), v1);
            c v3 = arg8.c;
            if(arg8.b) {
                v1_1 = v0.Q();
                v4 = v3.s;
                v0_1 = v1_1;
            }
            else {
                v1_1 = v0.P();
                v4 = v3.t;
                v0_1 = v1_1;
            }

            if(v4 != null) {
                v2.a(((Collection)v4));
            }

            if(v0_1 != null) {
                v0_1.a(((List)v4), ((Map)v2));
                int v3_1;
                for(v3_1 = v4.size() - 1; v3_1 >= 0; --v3_1) {
                    Object v0_2 = v4.get(v3_1);
                    Object v1_2 = v2.get(v0_2);
                    if(v1_2 == null) {
                        v0_3 = s.a(arg6, ((String)v0_2));
                        if(v0_3 != null) {
                            arg6.remove(v0_3);
                        }
                    }
                    else if(!((String)v0_2).equals(p.e(((View)v1_2)))) {
                        v0_3 = s.a(arg6, ((String)v0_2));
                        if(v0_3 != null) {
                            arg6.put(v0_3, p.e(((View)v1_2)));
                        }
                    }
                }
            }
            else {
                s.a(arg6, v2);
            }

            v0_4 = v2;
        }

        return v0_4;
    }
}

