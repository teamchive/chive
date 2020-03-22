package android.support.v4.a;

import android.os.Build$VERSION;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class c extends r implements f {
    final class a {
        int a;
        h b;
        int c;
        int d;
        int e;
        int f;

        a(int arg1, h arg2) {
            super();
            this.a = arg1;
            this.b = arg2;
        }

        a() {
            super();
        }
    }

    static final boolean a;
    final n b;
    ArrayList c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    boolean j;
    boolean k;
    String l;
    boolean m;
    int n;
    int o;
    CharSequence p;
    int q;
    CharSequence r;
    ArrayList s;
    ArrayList t;
    boolean u;
    ArrayList v;

    static {
        boolean v0 = Build$VERSION.SDK_INT >= 21 ? true : false;
        c.a = v0;
    }

    public c(n arg2) {
        super();
        this.c = new ArrayList();
        this.k = true;
        this.n = -1;
        this.u = false;
        this.b = arg2;
    }

    h a(ArrayList arg11, h arg12) {
        int v1;
        for(v1 = 0; v1 < this.c.size(); ++v1) {
            Object v0 = this.c.get(v1);
            switch(((a)v0).a) {
                case 2: {
                    h v6 = ((a)v0).b;
                    int v7 = v6.x;
                    int v4 = 0;
                    int v5 = arg11.size() - 1;
                    h v3 = arg12;
                    int v2 = v1;
                    while(v5 >= 0) {
                        Object v1_1 = arg11.get(v5);
                        if(((h)v1_1).x != v7) {
                            v1 = v4;
                        }
                        else if((((h)v1_1)) == v6) {
                            v1 = 1;
                        }
                        else {
                            if((((h)v1_1)) == v3) {
                                this.c.add(v2, new a(9, ((h)v1_1)));
                                ++v2;
                                v3 = null;
                            }

                            a v8 = new a(3, ((h)v1_1));
                            v8.c = ((a)v0).c;
                            v8.e = ((a)v0).e;
                            v8.d = ((a)v0).d;
                            v8.f = ((a)v0).f;
                            this.c.add(v2, v8);
                            arg11.remove(v1_1);
                            ++v2;
                            v1 = v4;
                        }

                        --v5;
                        v4 = v1;
                    }

                    if(v4 != 0) {
                        this.c.remove(v2);
                        --v2;
                    }
                    else {
                        ((a)v0).a = 1;
                        arg11.add(v6);
                    }

                    v1 = v2;
                    arg12 = v3;
                    break;
                }
                case 3: 
                case 6: {
                    arg11.remove(((a)v0).b);
                    if(((a)v0).b != arg12) {
                        goto label_9;
                    }

                    this.c.add(v1, new a(9, ((a)v0).b));
                    ++v1;
                    arg12 = null;
                    break;
                }
                case 1: 
                case 7: {
                    arg11.add(((a)v0).b);
                    break;
                }
                case 8: {
                    this.c.add(v1, new a(9, arg12));
                    ++v1;
                    arg12 = ((a)v0).b;
                    break;
                }
            }

        label_9:
        }

        return arg12;
    }

    public void a() {
        if(this.v != null) {
            int v2 = this.v.size();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                this.v.get(v1).run();
            }

            this.v = null;
        }
    }

    void a(int arg7) {
        if(this.j) {
            if(n.a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + arg7);
            }

            int v2 = this.c.size();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                Object v0 = this.c.get(v1);
                if(((a)v0).b != null) {
                    ((a)v0).b.q += arg7;
                    if(n.a) {
                        Log.v("FragmentManager", "Bump nesting of " + ((a)v0).b + " to " + ((a)v0).b.q);
                    }
                }
            }
        }
    }

    void a(a arg2) {
        this.c.add(arg2);
        arg2.c = this.d;
        arg2.d = this.e;
        arg2.e = this.f;
        arg2.f = this.g;
    }

    void a(android.support.v4.a.h$c arg4) {
        int v1;
        for(v1 = 0; v1 < this.c.size(); ++v1) {
            Object v0 = this.c.get(v1);
            if(c.b(((a)v0))) {
                ((a)v0).b.a(arg4);
            }
        }
    }

    public void a(String arg2, FileDescriptor arg3, PrintWriter arg4, String[] arg5) {
        this.a(arg2, arg4, true);
    }

    public void a(String arg6, PrintWriter arg7, boolean arg8) {
        String v1;
        if(arg8) {
            arg7.print(arg6);
            arg7.print("mName=");
            arg7.print(this.l);
            arg7.print(" mIndex=");
            arg7.print(this.n);
            arg7.print(" mCommitted=");
            arg7.println(this.m);
            if(this.h != 0) {
                arg7.print(arg6);
                arg7.print("mTransition=#");
                arg7.print(Integer.toHexString(this.h));
                arg7.print(" mTransitionStyle=#");
                arg7.println(Integer.toHexString(this.i));
            }

            if(this.d != 0 || this.e != 0) {
                arg7.print(arg6);
                arg7.print("mEnterAnim=#");
                arg7.print(Integer.toHexString(this.d));
                arg7.print(" mExitAnim=#");
                arg7.println(Integer.toHexString(this.e));
            }

            if(this.f != 0 || this.g != 0) {
                arg7.print(arg6);
                arg7.print("mPopEnterAnim=#");
                arg7.print(Integer.toHexString(this.f));
                arg7.print(" mPopExitAnim=#");
                arg7.println(Integer.toHexString(this.g));
            }

            if(this.o != 0 || this.p != null) {
                arg7.print(arg6);
                arg7.print("mBreadCrumbTitleRes=#");
                arg7.print(Integer.toHexString(this.o));
                arg7.print(" mBreadCrumbTitleText=");
                arg7.println(this.p);
            }

            if(this.q == 0 && this.r == null) {
                goto label_85;
            }

            arg7.print(arg6);
            arg7.print("mBreadCrumbShortTitleRes=#");
            arg7.print(Integer.toHexString(this.q));
            arg7.print(" mBreadCrumbShortTitleText=");
            arg7.println(this.r);
        }

    label_85:
        if(!this.c.isEmpty()) {
            arg7.print(arg6);
            arg7.println("Operations:");
            new StringBuilder().append(arg6).append("    ").toString();
            int v3 = this.c.size();
            int v2;
            for(v2 = 0; v2 < v3; ++v2) {
                Object v0 = this.c.get(v2);
                switch(((a)v0).a) {
                    case 0: {
                        v1 = "NULL";
                        break;
                    }
                    case 1: {
                        v1 = "ADD";
                        break;
                    }
                    case 2: {
                        v1 = "REPLACE";
                        break;
                    }
                    case 3: {
                        v1 = "REMOVE";
                        break;
                    }
                    case 4: {
                        v1 = "HIDE";
                        break;
                    }
                    case 5: {
                        v1 = "SHOW";
                        break;
                    }
                    case 6: {
                        v1 = "DETACH";
                        break;
                    }
                    case 7: {
                        v1 = "ATTACH";
                        break;
                    }
                    case 8: {
                        v1 = "SET_PRIMARY_NAV";
                        break;
                    }
                    case 9: {
                        v1 = "UNSET_PRIMARY_NAV";
                        break;
                    }
                    default: {
                        v1 = "cmd=" + ((a)v0).a;
                        break;
                    }
                }

                arg7.print(arg6);
                arg7.print("  Op #");
                arg7.print(v2);
                arg7.print(": ");
                arg7.print(v1);
                arg7.print(" ");
                arg7.println(((a)v0).b);
                if(arg8) {
                    if(((a)v0).c != 0 || ((a)v0).d != 0) {
                        arg7.print(arg6);
                        arg7.print("enterAnim=#");
                        arg7.print(Integer.toHexString(((a)v0).c));
                        arg7.print(" exitAnim=#");
                        arg7.println(Integer.toHexString(((a)v0).d));
                    }

                    if(((a)v0).e == 0 && ((a)v0).f == 0) {
                        goto label_155;
                    }

                    arg7.print(arg6);
                    arg7.print("popEnterAnim=#");
                    arg7.print(Integer.toHexString(((a)v0).e));
                    arg7.print(" popExitAnim=#");
                    arg7.println(Integer.toHexString(((a)v0).f));
                }

            label_155:
            }
        }
    }

    void a(boolean arg6) {
        int v1;
        for(v1 = this.c.size() - 1; v1 >= 0; --v1) {
            Object v0 = this.c.get(v1);
            h v2 = ((a)v0).b;
            if(v2 != null) {
                v2.a(n.d(this.h), this.i);
            }

            switch(((a)v0).a) {
                case 1: {
                    goto label_25;
                }
                case 3: {
                    goto label_40;
                }
                case 4: {
                    goto label_46;
                }
                case 5: {
                    goto label_51;
                }
                case 6: {
                    goto label_56;
                }
                case 7: {
                    goto label_61;
                }
                case 8: {
                    goto label_66;
                }
                case 9: {
                    goto label_70;
                }
            }

            throw new IllegalArgumentException("Unknown cmd: " + ((a)v0).a);
        label_66:
            this.b.o(null);
            goto label_29;
        label_51:
            v2.a(((a)v0).f);
            this.b.i(v2);
            goto label_29;
        label_70:
            this.b.o(v2);
            goto label_29;
        label_40:
            v2.a(((a)v0).e);
            this.b.a(v2, false);
            goto label_29;
        label_56:
            v2.a(((a)v0).e);
            this.b.l(v2);
            goto label_29;
        label_25:
            v2.a(((a)v0).f);
            this.b.h(v2);
            goto label_29;
        label_61:
            v2.a(((a)v0).f);
            this.b.k(v2);
            goto label_29;
        label_46:
            v2.a(((a)v0).e);
            this.b.j(v2);
        label_29:
            if(!this.u && ((a)v0).a != 3 && v2 != null) {
                this.b.e(v2);
            }
        }

        if(!this.u && (arg6)) {
            this.b.a(this.b.l, true);
        }
    }

    boolean a(ArrayList arg11, int arg12, int arg13) {
        int v0_2;
        boolean v0;
        if(arg13 == arg12) {
            v0 = false;
        }
        else {
            int v7 = this.c.size();
            int v1 = -1;
            int v6 = 0;
            while(v6 < v7) {
                Object v0_1 = this.c.get(v6);
                int v2 = ((a)v0_1).b != null ? ((a)v0_1).b.x : 0;
                if(v2 == 0 || v2 == v1) {
                    v0_2 = v1;
                }
                else {
                    int v5;
                    for(v5 = arg12; v5 < arg13; ++v5) {
                        v0_1 = arg11.get(v5);
                        int v8 = ((c)v0_1).c.size();
                        int v4;
                        for(v4 = 0; v4 < v8; ++v4) {
                            Object v1_1 = ((c)v0_1).c.get(v4);
                            v1 = ((a)v1_1).b != null ? ((a)v1_1).b.x : 0;
                            if(v1 == v2) {
                                return true;
                            }
                        }
                    }

                    v0_2 = v2;
                }

                ++v6;
                v1 = v0_2;
            }

            v0 = false;
        }

        return v0;
    }

    public boolean a(ArrayList arg4, ArrayList arg5) {
        if(n.a) {
            Log.v("FragmentManager", "Run: " + this);
        }

        arg4.add(this);
        arg5.add(Boolean.valueOf(false));
        if(this.j) {
            this.b.a(this);
        }

        return 1;
    }

    private static boolean b(a arg2) {
        h v0 = arg2.b;
        boolean v0_1 = v0 == null || !v0.k || v0.H == null || (v0.A) || (v0.z) || !v0.U() ? false : true;
        return v0_1;
    }

    h b(ArrayList arg4, h arg5) {
        int v1;
        for(v1 = 0; v1 < this.c.size(); ++v1) {
            Object v0 = this.c.get(v1);
            switch(((a)v0).a) {
                case 3: 
                case 6: {
                    arg4.add(((a)v0).b);
                    break;
                }
                case 1: 
                case 7: {
                    arg4.remove(((a)v0).b);
                    break;
                }
                case 8: {
                    arg5 = null;
                    break;
                }
                case 9: {
                    arg5 = ((a)v0).b;
                    break;
                }
            }
        }

        return arg5;
    }

    void b() {
        int v3 = this.c.size();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            Object v0 = this.c.get(v1);
            h v4 = ((a)v0).b;
            if(v4 != null) {
                v4.a(this.h, this.i);
            }

            switch(((a)v0).a) {
                case 1: {
                    goto label_25;
                }
                case 3: {
                    goto label_39;
                }
                case 4: {
                    goto label_44;
                }
                case 5: {
                    goto label_49;
                }
                case 6: {
                    goto label_54;
                }
                case 7: {
                    goto label_59;
                }
                case 8: {
                    goto label_64;
                }
                case 9: {
                    goto label_67;
                }
            }

            throw new IllegalArgumentException("Unknown cmd: " + ((a)v0).a);
        label_49:
            v4.a(((a)v0).c);
            this.b.j(v4);
            goto label_29;
        label_67:
            this.b.o(null);
            goto label_29;
        label_54:
            v4.a(((a)v0).d);
            this.b.k(v4);
            goto label_29;
        label_39:
            v4.a(((a)v0).d);
            this.b.h(v4);
            goto label_29;
        label_25:
            v4.a(((a)v0).c);
            this.b.a(v4, false);
            goto label_29;
        label_59:
            v4.a(((a)v0).c);
            this.b.l(v4);
            goto label_29;
        label_44:
            v4.a(((a)v0).d);
            this.b.i(v4);
            goto label_29;
        label_64:
            this.b.o(v4);
        label_29:
            if(!this.u && ((a)v0).a != 1 && v4 != null) {
                this.b.e(v4);
            }
        }

        if(!this.u) {
            this.b.a(this.b.l, true);
        }
    }

    boolean b(int arg6) {
        int v3 = this.c.size();
        int v2;
        for(v2 = 0; v2 < v3; ++v2) {
            Object v0 = this.c.get(v2);
            int v0_1 = ((a)v0).b != null ? ((a)v0).b.x : 0;
            if(v0_1 != 0 && v0_1 == arg6) {
                boolean v0_2 = true;
                return v0_2;
            }
        }

        return false;
    }

    boolean c() {
        boolean v2 = false;
        int v1 = 0;
        while(v1 < this.c.size()) {
            if(c.b(this.c.get(v1))) {
                v2 = true;
            }
            else {
                ++v1;
                continue;
            }

            return v2;
        }

        return v2;
    }

    public String d() {
        return this.l;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x80);
        v0.append("BackStackEntry{");
        v0.append(Integer.toHexString(System.identityHashCode(this)));
        if(this.n >= 0) {
            v0.append(" #");
            v0.append(this.n);
        }

        if(this.l != null) {
            v0.append(" ");
            v0.append(this.l);
        }

        v0.append("}");
        return v0.toString();
    }
}

