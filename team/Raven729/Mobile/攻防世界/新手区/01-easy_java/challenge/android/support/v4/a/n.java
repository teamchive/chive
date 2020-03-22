package android.support.v4.a;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources$NotFoundException;
import android.content.res.TypedArray;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.g.i;
import android.support.v4.h.p;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater$Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation$AnimationListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class n extends m implements LayoutInflater$Factory2 {
    class android.support.v4.a.n$1 implements Runnable {
        android.support.v4.a.n$1(n arg1) {
            this.a = arg1;
            super();
        }

        public void run() {
            this.a.e();
        }
    }

    class a extends b {
        View a;

        a(View arg2, Animation$AnimationListener arg3) {
            super(arg3, null);
            this.a = arg2;
        }

        public void onAnimationEnd(Animation arg4) {
            if((p.m(this.a)) || Build$VERSION.SDK_INT >= 24) {
                this.a.post(new Runnable() {
                    public void run() {
                        this.a.a.setLayerType(0, null);
                    }
                });
            }
            else {
                this.a.setLayerType(0, null);
            }

            super.onAnimationEnd(arg4);
        }
    }

    class b implements Animation$AnimationListener {
        private final Animation$AnimationListener a;

        b(Animation$AnimationListener arg1, android.support.v4.a.n$1 arg2) {
            this(arg1);
        }

        private b(Animation$AnimationListener arg1) {
            super();
            this.a = arg1;
        }

        public void onAnimationEnd(Animation arg2) {
            if(this.a != null) {
                this.a.onAnimationEnd(arg2);
            }
        }

        public void onAnimationRepeat(Animation arg2) {
            if(this.a != null) {
                this.a.onAnimationRepeat(arg2);
            }
        }

        public void onAnimationStart(Animation arg2) {
            if(this.a != null) {
                this.a.onAnimationStart(arg2);
            }
        }
    }

    class c {
        public final Animation a;
        public final Animator b;

        c(Animation arg1, android.support.v4.a.n$1 arg2) {
            this(arg1);
        }

        c(Animator arg1, android.support.v4.a.n$1 arg2) {
            this(arg1);
        }

        private c(Animator arg3) {
            super();
            this.a = null;
            this.b = arg3;
            if(arg3 == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        private c(Animation arg3) {
            super();
            this.a = arg3;
            this.b = null;
            if(arg3 == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    class d extends AnimatorListenerAdapter {
        View a;

        d(View arg1) {
            super();
            this.a = arg1;
        }

        public void onAnimationEnd(Animator arg4) {
            this.a.setLayerType(0, null);
            arg4.removeListener(((Animator$AnimatorListener)this));
        }

        public void onAnimationStart(Animator arg4) {
            this.a.setLayerType(2, null);
        }
    }

    class e {
        public static final int[] a;

        static {
            e.a = new int[]{0x1010003, 0x10100D0, 0x10100D1};
        }
    }

    interface f {
        boolean a(ArrayList arg1, ArrayList arg2);
    }

    class g implements android.support.v4.a.h$c {
        private final boolean a;
        private final android.support.v4.a.c b;
        private int c;

        g(android.support.v4.a.c arg1, boolean arg2) {
            super();
            this.a = arg2;
            this.b = arg1;
        }

        static boolean a(g arg1) {
            return arg1.a;
        }

        public void a() {
            --this.c;
            if(this.c == 0) {
                n.a(this.b.b);
            }
        }

        static android.support.v4.a.c b(g arg1) {
            return arg1.b;
        }

        public void b() {
            ++this.c;
        }

        public boolean c() {
            boolean v0 = this.c == 0 ? true : false;
            return v0;
        }

        public void d() {
            boolean v3 = false;
            int v1 = this.c > 0 ? 1 : 0;
            n v5 = this.b.b;
            int v6 = v5.e.size();
            int v4;
            for(v4 = 0; v4 < v6; ++v4) {
                Object v0 = v5.e.get(v4);
                ((h)v0).a(null);
                if(v1 != 0 && (((h)v0).U())) {
                    ((h)v0).A();
                }
            }

            n v0_1 = this.b.b;
            android.support.v4.a.c v4_1 = this.b;
            boolean v5_1 = this.a;
            if(v1 == 0) {
                v3 = true;
            }

            n.a(v0_1, v4_1, v5_1, v3, true);
        }

        public void e() {
            n.a(this.b.b, this.b, this.a, false, false);
        }
    }

    SparseArray A;
    ArrayList B;
    o C;
    Runnable D;
    static final Interpolator E;
    static final Interpolator F;
    static final Interpolator G;
    static final Interpolator H;
    private final CopyOnWriteArrayList I;
    static boolean a;
    ArrayList b;
    boolean c;
    int d;
    final ArrayList e;
    SparseArray f;
    ArrayList g;
    ArrayList h;
    ArrayList i;
    ArrayList j;
    ArrayList k;
    int l;
    l m;
    j n;
    h o;
    h p;
    static Field q;
    boolean r;
    boolean s;
    boolean t;
    String u;
    boolean v;
    ArrayList w;
    ArrayList x;
    ArrayList y;
    Bundle z;

    static {
        n.a = false;
        n.q = null;
        n.E = new DecelerateInterpolator(2.5f);
        n.F = new DecelerateInterpolator(1.5f);
        n.G = new AccelerateInterpolator(2.5f);
        n.H = new AccelerateInterpolator(1.5f);
    }

    n() {
        super();
        this.d = 0;
        this.e = new ArrayList();
        this.I = new CopyOnWriteArrayList();
        this.l = 0;
        this.z = null;
        this.A = null;
        this.D = new android.support.v4.a.n$1(this);
    }

    private void A() {
        if(this.B != null) {
            while(!this.B.isEmpty()) {
                this.B.remove(0).d();
            }
        }
    }

    private void B() {
        int v6 = this.f == null ? 0 : this.f.size();
        int v7;
        for(v7 = 0; v7 < v6; ++v7) {
            Object v1 = this.f.valueAt(v7);
            if(v1 != null) {
                if(((h)v1).R() != null) {
                    int v2 = ((h)v1).T();
                    View v0 = ((h)v1).R();
                    ((h)v1).a(null);
                    Animation v4 = v0.getAnimation();
                    if(v4 != null) {
                        v4.cancel();
                        v0.clearAnimation();
                    }

                    this.a(((h)v1), v2, 0, 0, false);
                }
                else {
                    if(((h)v1).S() == null) {
                        goto label_23;
                    }

                    ((h)v1).S().end();
                }
            }

        label_23:
        }
    }

    private void C() {
        if(this.f != null) {
            int v0;
            for(v0 = this.f.size() - 1; v0 >= 0; --v0) {
                if(this.f.valueAt(v0) == null) {
                    this.f.delete(this.f.keyAt(v0));
                }
            }
        }
    }

    public void a(h arg6, boolean arg7) {
        if(n.a) {
            Log.v("FragmentManager", "add: " + arg6);
        }

        this.f(arg6);
        if(!arg6.A) {
            if(this.e.contains(arg6)) {
                throw new IllegalStateException("Fragment already added: " + arg6);
            }
            else {
                ArrayList v1 = this.e;
                __monitor_enter(v1);
                try {
                    this.e.add(arg6);
                    __monitor_exit(v1);
                }
                catch(Throwable v0) {
                    try {
                    label_46:
                        __monitor_exit(v1);
                    }
                    catch(Throwable v0) {
                        goto label_46;
                    }

                    throw v0;
                }

                arg6.k = true;
                arg6.l = false;
                if(arg6.H == null) {
                    arg6.Q = false;
                }

                if((arg6.D) && (arg6.E)) {
                    this.r = true;
                }

                if(!arg7) {
                    return;
                }

                this.b(arg6);
            }
        }
    }

    void a(int arg7, boolean arg8) {
        int v0_1;
        Object v0;
        if(this.m == null && arg7 != 0) {
            throw new IllegalStateException("No activity");
        }

        if((arg8) || arg7 != this.l) {
            this.l = arg7;
            if(this.f != null) {
                int v4 = this.e.size();
                int v2 = 0;
                int v1;
                for(v1 = 0; v2 < v4; v1 = v0_1) {
                    v0 = this.e.get(v2);
                    this.e(((h)v0));
                    v0_1 = ((h)v0).L != null ? ((h)v0).L.a() | v1 : v1;
                    ++v2;
                }

                v4 = this.f.size();
                v2 = 0;
                while(v2 < v4) {
                    v0 = this.f.valueAt(v2);
                    if(v0 != null) {
                        if(!((h)v0).l && !((h)v0).A) {
                            goto label_68;
                        }

                        if(((h)v0).P) {
                            goto label_68;
                        }

                        this.e(((h)v0));
                        if(((h)v0).L == null) {
                            goto label_68;
                        }

                        v0_1 = ((h)v0).L.a() | v1;
                    }
                    else {
                    label_68:
                        v0_1 = v1;
                    }

                    ++v2;
                    v1 = v0_1;
                }

                if(v1 == 0) {
                    this.d();
                }

                if(!this.r) {
                    return;
                }

                if(this.m == null) {
                    return;
                }

                if(this.l != 5) {
                    return;
                }

                this.m.c();
                this.r = false;
            }
        }
    }

    void a(android.support.v4.a.c arg2) {
        if(this.g == null) {
            this.g = new ArrayList();
        }

        this.g.add(arg2);
    }

    public void a(l arg3, j arg4, h arg5) {
        if(this.m != null) {
            throw new IllegalStateException("Already attached");
        }

        this.m = arg3;
        this.n = arg4;
        this.o = arg5;
    }

    public void a(Configuration arg3) {
        int v1;
        for(v1 = 0; v1 < this.e.size(); ++v1) {
            Object v0 = this.e.get(v1);
            if(v0 != null) {
                ((h)v0).a(arg3);
            }
        }
    }

    public void a(String arg7, FileDescriptor arg8, PrintWriter arg9, String[] arg10) {
        Object v0;
        int v4;
        int v1 = 0;
        String v3 = arg7 + "    ";
        if(this.f != null) {
            v4 = this.f.size();
            if(v4 > 0) {
                arg9.print(arg7);
                arg9.print("Active Fragments in ");
                arg9.print(Integer.toHexString(System.identityHashCode(this)));
                arg9.println(":");
                int v2;
                for(v2 = 0; v2 < v4; ++v2) {
                    v0 = this.f.valueAt(v2);
                    arg9.print(arg7);
                    arg9.print("  #");
                    arg9.print(v2);
                    arg9.print(": ");
                    arg9.println(v0);
                    if(v0 != null) {
                        ((h)v0).a(v3, arg8, arg9, arg10);
                    }
                }
            }
        }

        v4 = this.e.size();
        if(v4 > 0) {
            arg9.print(arg7);
            arg9.println("Added Fragments:");
            for(v2 = 0; v2 < v4; ++v2) {
                v0 = this.e.get(v2);
                arg9.print(arg7);
                arg9.print("  #");
                arg9.print(v2);
                arg9.print(": ");
                arg9.println(((h)v0).toString());
            }
        }

        if(this.h != null) {
            v4 = this.h.size();
            if(v4 > 0) {
                arg9.print(arg7);
                arg9.println("Fragments Created Menus:");
                for(v2 = 0; v2 < v4; ++v2) {
                    v0 = this.h.get(v2);
                    arg9.print(arg7);
                    arg9.print("  #");
                    arg9.print(v2);
                    arg9.print(": ");
                    arg9.println(((h)v0).toString());
                }
            }
        }

        if(this.g != null) {
            v4 = this.g.size();
            if(v4 > 0) {
                arg9.print(arg7);
                arg9.println("Back Stack:");
                for(v2 = 0; v2 < v4; ++v2) {
                    v0 = this.g.get(v2);
                    arg9.print(arg7);
                    arg9.print("  #");
                    arg9.print(v2);
                    arg9.print(": ");
                    arg9.println(((android.support.v4.a.c)v0).toString());
                    ((android.support.v4.a.c)v0).a(v3, arg8, arg9, arg10);
                }
            }
        }

        __monitor_enter(this);
        try {
            if(this.i != null) {
                int v3_1 = this.i.size();
                if(v3_1 > 0) {
                    arg9.print(arg7);
                    arg9.println("Back Stack Indices:");
                    for(v2 = 0; v2 < v3_1; ++v2) {
                        v0 = this.i.get(v2);
                        arg9.print(arg7);
                        arg9.print("  #");
                        arg9.print(v2);
                        arg9.print(": ");
                        arg9.println(v0);
                    }
                }
            }

            if(this.j != null && this.j.size() > 0) {
                arg9.print(arg7);
                arg9.print("mAvailBackStackIndices: ");
                arg9.println(Arrays.toString(this.j.toArray()));
            }

            __monitor_exit(this);
        }
        catch(Throwable v0_1) {
            try {
            label_162:
                __monitor_exit(this);
            }
            catch(Throwable v0_1) {
                goto label_162;
            }

            throw v0_1;
        }

        if(this.b != null) {
            v2 = this.b.size();
            if(v2 > 0) {
                arg9.print(arg7);
                arg9.println("Pending Actions:");
                while(v1 < v2) {
                    v0 = this.b.get(v1);
                    arg9.print(arg7);
                    arg9.print("  #");
                    arg9.print(v1);
                    arg9.print(": ");
                    arg9.println(v0);
                    ++v1;
                }
            }
        }

        arg9.print(arg7);
        arg9.println("FragmentManager misc state:");
        arg9.print(arg7);
        arg9.print("  mHost=");
        arg9.println(this.m);
        arg9.print(arg7);
        arg9.print("  mContainer=");
        arg9.println(this.n);
        if(this.o != null) {
            arg9.print(arg7);
            arg9.print("  mParent=");
            arg9.println(this.o);
        }

        arg9.print(arg7);
        arg9.print("  mCurState=");
        arg9.print(this.l);
        arg9.print(" mStateSaved=");
        arg9.print(this.s);
        arg9.print(" mDestroyed=");
        arg9.println(this.t);
        if(this.r) {
            arg9.print(arg7);
            arg9.print("  mNeedMenuInvalidate=");
            arg9.println(this.r);
        }

        if(this.u != null) {
            arg9.print(arg7);
            arg9.print("  mNoTransactionsBecause=");
            arg9.println(this.u);
        }
    }

    public boolean a(Menu arg7, MenuInflater arg8) {
        Object v0;
        int v4 = 0;
        ArrayList v1 = null;
        int v3 = 0;
        boolean v2;
        for(v2 = false; v3 < this.e.size(); v2 = v2) {
            v0 = this.e.get(v3);
            if(v0 != null && (((h)v0).b(arg7, arg8))) {
                v2 = true;
                if(v1 == null) {
                    v1 = new ArrayList();
                }

                v1.add(v0);
            }

            ++v3;
        }

        if(this.h != null) {
            while(v4 < this.h.size()) {
                v0 = this.h.get(v4);
                if(v1 == null || !v1.contains(v0)) {
                    ((h)v0).r();
                }

                ++v4;
            }
        }

        this.h = v1;
        return v2;
    }

    public boolean a(Menu arg4) {
        int v1 = 0;
        boolean v2 = false;
        while(v1 < this.e.size()) {
            Object v0 = this.e.get(v1);
            if(v0 != null && (((h)v0).c(arg4))) {
                v2 = true;
            }

            ++v1;
        }

        return v2;
    }

    public boolean a(MenuItem arg4) {
        boolean v2 = false;
        int v1;
        for(v1 = 0; v1 < this.e.size(); ++v1) {
            Object v0 = this.e.get(v1);
            if(v0 != null && (((h)v0).c(arg4))) {
                return true;
            }
        }

        return v2;
    }

    public void a(boolean arg3) {
        int v1;
        for(v1 = this.e.size() - 1; v1 >= 0; --v1) {
            Object v0 = this.e.get(v1);
            if(v0 != null) {
                ((h)v0).d(arg3);
            }
        }
    }

    boolean a(int arg2) {
        boolean v0 = this.l >= arg2 ? true : false;
        return v0;
    }

    void a(Parcelable arg12, o arg13) {
        o v0_1;
        List v1_1;
        Object v0;
        int v1;
        SparseArray v5 = null;
        if(arg12 != null && ((android.support.v4.a.p)arg12).a != null) {
            if(arg13 != null) {
                List v7 = arg13.a();
                List v4 = arg13.b();
                v1 = v7 != null ? v7.size() : 0;
                int v6;
                for(v6 = 0; v6 < v1; ++v6) {
                    v0 = v7.get(v6);
                    if(n.a) {
                        Log.v("FragmentManager", "restoreAllState: re-attaching retained " + v0);
                    }

                    int v3;
                    for(v3 = 0; v3 < ((android.support.v4.a.p)arg12).a.length; ++v3) {
                        if(((android.support.v4.a.p)arg12).a[v3].b == ((h)v0).e) {
                            break;
                        }
                    }

                    if(v3 == ((android.support.v4.a.p)arg12).a.length) {
                        this.a(new IllegalStateException("Could not find active fragment with index " + ((h)v0).e));
                    }

                    q v3_1 = ((android.support.v4.a.p)arg12).a[v3];
                    v3_1.l = ((h)v0);
                    ((h)v0).d = v5;
                    ((h)v0).q = 0;
                    ((h)v0).n = false;
                    ((h)v0).k = false;
                    ((h)v0).h = ((h)v5);
                    if(v3_1.k != null) {
                        v3_1.k.setClassLoader(this.m.g().getClassLoader());
                        ((h)v0).d = v3_1.k.getSparseParcelableArray("android:view_state");
                        ((h)v0).c = v3_1.k;
                    }
                }

                v1_1 = v4;
            }
            else {
                v1_1 = ((List)v5);
            }

            this.f = new SparseArray(((android.support.v4.a.p)arg12).a.length);
            for(v3 = 0; v3 < ((android.support.v4.a.p)arg12).a.length; ++v3) {
                q v4_1 = ((android.support.v4.a.p)arg12).a[v3];
                if(v4_1 != null) {
                    if(v1_1 == null || v3 >= v1_1.size()) {
                        v0_1 = ((o)v5);
                    }
                    else {
                        v0 = v1_1.get(v3);
                    }

                    h v0_2 = v4_1.a(this.m, this.n, this.o, v0_1);
                    if(n.a) {
                        Log.v("FragmentManager", "restoreAllState: active #" + v3 + ": " + v0_2);
                    }

                    this.f.put(v0_2.e, v0_2);
                    v4_1.l = ((h)v5);
                }
            }

            if(arg13 != null) {
                List v6_1 = arg13.a();
                v3 = v6_1 != null ? v6_1.size() : 0;
                int v4_2;
                for(v4_2 = 0; v4_2 < v3; ++v4_2) {
                    v0 = v6_1.get(v4_2);
                    if(((h)v0).i >= 0) {
                        ((h)v0).h = this.f.get(((h)v0).i);
                        if(((h)v0).h == null) {
                            Log.w("FragmentManager", "Re-attaching retained fragment " + v0 + " target no longer exists: " + ((h)v0).i);
                        }
                    }
                }
            }

            this.e.clear();
            if(((android.support.v4.a.p)arg12).b != null) {
                v1 = 0;
                while(true) {
                    if(v1 < ((android.support.v4.a.p)arg12).b.length) {
                        v0 = this.f.get(((android.support.v4.a.p)arg12).b[v1]);
                        if(v0 == null) {
                            this.a(new IllegalStateException("No instantiated fragment for index #" + ((android.support.v4.a.p)arg12).b[v1]));
                        }

                        ((h)v0).k = true;
                        if(n.a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + v1 + ": " + v0);
                        }

                        if(this.e.contains(v0)) {
                            throw new IllegalStateException("Already added!");
                        }

                        ArrayList v3_2 = this.e;
                        __monitor_enter(v3_2);
                        try {
                            this.e.add(v0);
                            __monitor_exit(v3_2);
                            ++v1;
                            continue;
                        label_204:
                            __monitor_exit(v3_2);
                            break;
                        }
                        catch(Throwable v0_3) {
                            goto label_204;
                        }
                    }

                    goto label_206;
                }

                throw v0_3;
            }

        label_206:
            if(((android.support.v4.a.p)arg12).c != null) {
                this.g = new ArrayList(((android.support.v4.a.p)arg12).c.length);
                int v0_4;
                for(v0_4 = 0; v0_4 < ((android.support.v4.a.p)arg12).c.length; ++v0_4) {
                    android.support.v4.a.c v1_2 = ((android.support.v4.a.p)arg12).c[v0_4].a(this);
                    if(n.a) {
                        Log.v("FragmentManager", "restoreAllState: back stack #" + v0_4 + " (index " + v1_2.n + "): " + v1_2);
                        PrintWriter v4_3 = new PrintWriter(new android.support.v4.g.e("FragmentManager"));
                        v1_2.a("  ", v4_3, false);
                        v4_3.close();
                    }

                    this.g.add(v1_2);
                    if(v1_2.n >= 0) {
                        this.a(v1_2.n, v1_2);
                    }
                }
            }
            else {
                this.g = ((ArrayList)v5);
            }

            if(((android.support.v4.a.p)arg12).d >= 0) {
                this.p = this.f.get(((android.support.v4.a.p)arg12).d);
            }

            this.d = ((android.support.v4.a.p)arg12).e;
        }
    }

    void a(h arg11, int arg12, int arg13, int arg14, boolean arg15) {
        String v1_1;
        View v0_1;
        int v9 = 4;
        int v6 = 3;
        boolean v5 = true;
        View v7 = null;
        if((!arg11.k || (arg11.A)) && arg12 > 1) {
            arg12 = 1;
        }

        if((arg11.l) && 1 > arg11.b) {
            if(arg11.b == 0 && (arg11.b())) {
                arg12 = 1;
                goto label_20;
            }

            arg12 = arg11.b;
        }

    label_20:
        if((arg11.J) && arg11.b < v9 && arg12 > v6) {
            arg12 = v6;
        }

        if(arg11.b > arg12) {
            goto label_332;
        }

        if((arg11.m) && !arg11.n) {
            return;
        }

        if(arg11.R() != null || arg11.S() != null) {
            arg11.a(v7);
            arg11.a(((Animator)v7));
            this.a(arg11, arg11.T(), 0, 0, true);
        }

        switch(arg11.b) {
            case 0: {
                goto label_69;
            }
            case 1: {
                goto label_189;
            }
            case 2: {
                goto label_286;
            }
            case 3: {
                goto label_289;
            }
            case 4: {
                goto label_302;
            }
        }

        goto label_48;
    label_69:
        if(arg12 > 0) {
            if(n.a) {
                Log.v("FragmentManager", "moveto CREATED: " + arg11);
            }

            if(arg11.c != null) {
                arg11.c.setClassLoader(this.m.g().getClassLoader());
                arg11.d = arg11.c.getSparseParcelableArray("android:view_state");
                arg11.h = this.a(arg11.c, "android:target_state");
                if(arg11.h != null) {
                    arg11.j = arg11.c.getInt("android:target_req_state", 0);
                }

                arg11.K = arg11.c.getBoolean("android:user_visible_hint", true);
                if(arg11.K) {
                    goto label_110;
                }

                arg11.J = true;
                if(arg12 <= v6) {
                    goto label_110;
                }

                arg12 = v6;
            }

        label_110:
            arg11.s = this.m;
            arg11.v = this.o;
            n v0 = this.o != null ? this.o.t : this.m.i();
            arg11.r = v0;
            if(arg11.h != null) {
                if(this.f.get(arg11.h.e) != arg11.h) {
                    throw new IllegalStateException("Fragment " + arg11 + " declared target fragment " + arg11.h + " that does not belong to this FragmentManager!");
                }
                else if(arg11.h.b < 1) {
                    this.a(arg11.h, 1, 0, 0, true);
                }
            }

            this.a(arg11, this.m.g(), false);
            arg11.F = false;
            arg11.a(this.m.g());
            if(!arg11.F) {
                throw new z("Fragment " + arg11 + " did not call through to super.onAttach()");
            }

            if(arg11.v == null) {
                this.m.b(arg11);
            }
            else {
                arg11.v.a(arg11);
            }

            this.b(arg11, this.m.g(), false);
            if(!arg11.T) {
                this.a(arg11, arg11.c, false);
                arg11.k(arg11.c);
                this.b(arg11, arg11.c, false);
            }
            else {
                arg11.g(arg11.c);
                arg11.b = 1;
            }

            arg11.C = false;
        }

    label_189:
        this.c(arg11);
        if(arg12 > 1) {
            if(n.a) {
                Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + arg11);
            }

            if(!arg11.m) {
                if(arg11.x != 0) {
                    if(arg11.x == -1) {
                        this.a(new IllegalArgumentException("Cannot create fragment " + arg11 + " for a container view with no id"));
                    }

                    v0_1 = this.n.a(arg11.x);
                    if(v0_1 != null) {
                        goto label_245;
                    }

                    if(arg11.o) {
                        goto label_245;
                    }

                    try {
                        v1_1 = arg11.e().getResourceName(arg11.x);
                    }
                    catch(Resources$NotFoundException v1) {
                        v1_1 = "unknown";
                    }

                    this.a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(arg11.x) + " (" + v1_1 + ") for fragment " + arg11));
                }
                else {
                    ViewGroup v0_2 = ((ViewGroup)v7);
                }

            label_245:
                arg11.G = ((ViewGroup)v0_1);
                arg11.H = arg11.b(arg11.d(arg11.c), ((ViewGroup)v0_1), arg11.c);
                if(arg11.H != null) {
                    arg11.I = arg11.H;
                    arg11.H.setSaveFromParentEnabled(false);
                    if(v0_1 != null) {
                        ((ViewGroup)v0_1).addView(arg11.H);
                    }

                    if(arg11.z) {
                        arg11.H.setVisibility(8);
                    }

                    arg11.a(arg11.H, arg11.c);
                    this.a(arg11, arg11.H, arg11.c, false);
                    if(arg11.H.getVisibility() != 0 || arg11.G == null) {
                        v5 = false;
                    }

                    arg11.P = v5;
                }
                else {
                    arg11.I = v7;
                }
            }

            arg11.l(arg11.c);
            this.c(arg11, arg11.c, false);
            if(arg11.H != null) {
                arg11.a(arg11.c);
            }

            arg11.c = ((Bundle)v7);
        }

    label_286:
        if(arg12 > 2) {
            arg11.b = v6;
        }

    label_289:
        if(arg12 > v6) {
            if(n.a) {
                Log.v("FragmentManager", "moveto STARTED: " + arg11);
            }

            arg11.C();
            this.b(arg11, false);
        }

    label_302:
        if(arg12 <= v9) {
            goto label_48;
        }

        if(n.a) {
            Log.v("FragmentManager", "moveto RESUMED: " + arg11);
        }

        arg11.D();
        this.c(arg11, false);
        arg11.c = ((Bundle)v7);
        arg11.d = ((SparseArray)v7);
        goto label_48;
    label_332:
        if(arg11.b <= arg12) {
            goto label_48;
        }

        switch(arg11.b) {
            case 1: {
                goto label_337;
            }
            case 2: {
                goto label_391;
            }
            case 3: {
                goto label_379;
            }
            case 4: {
                goto label_366;
            }
            case 5: {
                goto label_352;
            }
        }

        goto label_48;
    label_352:
        if(arg12 < 5) {
            if(n.a) {
                Log.v("FragmentManager", "movefrom RESUMED: " + arg11);
            }

            arg11.G();
            this.d(arg11, false);
        }

    label_366:
        if(arg12 < v9) {
            if(n.a) {
                Log.v("FragmentManager", "movefrom STARTED: " + arg11);
            }

            arg11.H();
            this.e(arg11, false);
        }

    label_379:
        if(arg12 < v6) {
            if(n.a) {
                Log.v("FragmentManager", "movefrom STOPPED: " + arg11);
            }

            arg11.I();
        }

    label_391:
        if(arg12 < 2) {
            if(n.a) {
                Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + arg11);
            }

            if(arg11.H != null && (this.m.a(arg11)) && arg11.d == null) {
                this.m(arg11);
            }

            arg11.J();
            this.f(arg11, false);
            if(arg11.H != null && arg11.G != null) {
                arg11.H.clearAnimation();
                arg11.G.endViewTransition(arg11.H);
                c v0_3 = this.l <= 0 || (this.t) || arg11.H.getVisibility() != 0 || arg11.R < 0f ? ((c)v7) : this.a(arg11, arg13, false, arg14);
                arg11.R = 0f;
                if(v0_3 != null) {
                    this.a(arg11, v0_3, arg12);
                }

                arg11.G.removeView(arg11.H);
            }

            arg11.G = ((ViewGroup)v7);
            arg11.H = v7;
            arg11.I = v7;
            arg11.n = false;
        }

    label_337:
        if(arg12 < 1) {
            if(this.t) {
                if(arg11.R() != null) {
                    v0_1 = arg11.R();
                    arg11.a(v7);
                    v0_1.clearAnimation();
                }
                else if(arg11.S() != null) {
                    Animator v0_4 = arg11.S();
                    arg11.a(((Animator)v7));
                    v0_4.cancel();
                }
            }

            if(arg11.R() == null && arg11.S() == null) {
                if(n.a) {
                    Log.v("FragmentManager", "movefrom CREATED: " + arg11);
                }

                if(!arg11.C) {
                    arg11.K();
                    this.g(arg11, false);
                }
                else {
                    arg11.b = 0;
                }

                arg11.L();
                this.h(arg11, false);
                if(arg15) {
                    goto label_48;
                }

                if(!arg11.C) {
                    this.g(arg11);
                    goto label_48;
                }

                arg11.s = ((l)v7);
                arg11.v = ((h)v7);
                arg11.r = ((n)v7);
                goto label_48;
            }

            arg11.b(arg12);
            arg12 = 1;
        }

    label_48:
        if(arg11.b != arg12) {
            Log.w("FragmentManager", "moveToState: Fragment state for " + arg11 + " not updated inline; " + "expected state " + arg12 + " found " + arg11.b);
            arg11.b = arg12;
        }
    }

    private int a(ArrayList arg8, ArrayList arg9, int arg10, int arg11, android.support.v4.g.b arg12) {
        int v0_1;
        int v4 = arg11 - 1;
        int v2;
        for(v2 = arg11; v4 >= arg10; v2 = v0_1) {
            Object v0 = arg8.get(v4);
            boolean v5 = arg9.get(v4).booleanValue();
            int v1 = !((android.support.v4.a.c)v0).c() || (((android.support.v4.a.c)v0).a(arg8, v4 + 1, arg11)) ? 0 : 1;
            if(v1 != 0) {
                if(this.B == null) {
                    this.B = new ArrayList();
                }

                g v1_1 = new g(((android.support.v4.a.c)v0), v5);
                this.B.add(v1_1);
                ((android.support.v4.a.c)v0).a(((android.support.v4.a.h$c)v1_1));
                if(v5) {
                    ((android.support.v4.a.c)v0).b();
                }
                else {
                    ((android.support.v4.a.c)v0).a(false);
                }

                v1 = v2 - 1;
                if(v4 != v1) {
                    arg8.remove(v4);
                    arg8.add(v1, v0);
                }

                this.b(arg12);
                v0_1 = v1;
            }
            else {
                v0_1 = v2;
            }

            --v4;
        }

        return v2;
    }

    static c a(Context arg4, float arg5, float arg6) {
        AlphaAnimation v0 = new AlphaAnimation(arg5, arg6);
        v0.setInterpolator(n.F);
        v0.setDuration(220);
        return new c(((Animation)v0), null);
    }

    static c a(Context arg10, float arg11, float arg12, float arg13, float arg14) {
        AnimationSet v9 = new AnimationSet(false);
        ScaleAnimation v0 = new ScaleAnimation(arg11, arg12, arg11, arg12, 1, 0.5f, 1, 0.5f);
        v0.setInterpolator(n.E);
        v0.setDuration(220);
        v9.addAnimation(((Animation)v0));
        AlphaAnimation v0_1 = new AlphaAnimation(arg13, arg14);
        v0_1.setInterpolator(n.F);
        v0_1.setDuration(220);
        v9.addAnimation(((Animation)v0_1));
        return new c(((Animation)v9), null);
    }

    private static Animation$AnimationListener a(Animation arg4) {
        Animation$AnimationListener v0_3;
        Object v0_2;
        Animation$AnimationListener v1 = null;
        try {
            if(n.q == null) {
                n.q = Animation.class.getDeclaredField("mListener");
                n.q.setAccessible(true);
            }

            v0_2 = n.q.get(arg4);
        }
        catch(NoSuchFieldException v0) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", ((Throwable)v0));
            v0_3 = v1;
        }
        catch(IllegalAccessException v0_1) {
            Log.e("FragmentManager", "Cannot access Animation\'s mListener field", ((Throwable)v0_1));
            v0_3 = v1;
        }

        return ((Animation$AnimationListener)v0_2);
    }

    private void a(android.support.v4.a.c arg8, boolean arg9, boolean arg10, boolean arg11) {
        if(arg9) {
            arg8.a(arg11);
        }
        else {
            arg8.b();
        }

        ArrayList v1 = new ArrayList(1);
        ArrayList v2 = new ArrayList(1);
        v1.add(arg8);
        v2.add(Boolean.valueOf(arg9));
        if(arg10) {
            s.a(this, v1, v2, 0, 1, true);
        }

        if(arg11) {
            this.a(this.l, true);
        }

        if(this.f != null) {
            int v2_1 = this.f.size();
            int v1_1;
            for(v1_1 = 0; v1_1 < v2_1; ++v1_1) {
                Object v0 = this.f.valueAt(v1_1);
                if(v0 != null && ((h)v0).H != null && (((h)v0).P) && (arg8.b(((h)v0).x))) {
                    if(((h)v0).R > 0f) {
                        ((h)v0).H.setAlpha(((h)v0).R);
                    }

                    if(arg11) {
                        ((h)v0).R = 0f;
                        goto label_42;
                    }

                    ((h)v0).R = -1f;
                    ((h)v0).P = false;
                }

            label_42:
            }
        }
    }

    private void a(h arg5, c arg6, int arg7) {
        View v0 = arg5.H;
        arg5.b(arg7);
        if(arg6.a != null) {
            Animation v1 = arg6.a;
            arg5.a(arg5.H);
            v1.setAnimationListener(new b(n.a(v1), arg5) {
                public void onAnimationEnd(Animation arg7) {
                    super.onAnimationEnd(arg7);
                    if(this.a.R() != null) {
                        this.a.a(null);
                        this.b.a(this.a, this.a.T(), 0, 0, false);
                    }
                }
            });
            n.b(v0, arg6);
            arg5.H.startAnimation(v1);
        }
        else {
            Animator v1_1 = arg6.b;
            arg5.a(arg6.b);
            ViewGroup v2 = arg5.G;
            if(v2 != null) {
                v2.startViewTransition(v0);
            }

            v1_1.addListener(new AnimatorListenerAdapter(v2, v0, arg5) {
                public void onAnimationEnd(Animator arg7) {
                    if(this.a != null) {
                        this.a.endViewTransition(this.b);
                    }

                    if(this.c.S() != null) {
                        this.c.a(null);
                        this.d.a(this.c, this.c.T(), 0, 0, false);
                    }
                }
            });
            v1_1.setTarget(arg5.H);
            n.b(arg5.H, arg6);
            v1_1.start();
        }
    }

    static void a(n arg0) {
        arg0.y();
    }

    static void a(n arg0, android.support.v4.a.c arg1, boolean arg2, boolean arg3, boolean arg4) {
        arg0.a(arg1, arg2, arg3, arg4);
    }

    private static void a(o arg3) {
        Iterator v1;
        if(arg3 != null) {
            List v0 = arg3.a();
            if(v0 != null) {
                v1 = v0.iterator();
                while(v1.hasNext()) {
                    v1.next().C = true;
                }
            }

            v0 = arg3.b();
            if(v0 == null) {
                return;
            }

            v1 = v0.iterator();
            while(v1.hasNext()) {
                n.a(v1.next());
            }
        }
    }

    private void a(android.support.v4.g.b arg6) {
        int v2 = arg6.size();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            Object v0 = arg6.b(v1);
            if(!((h)v0).k) {
                View v3 = ((h)v0).i();
                ((h)v0).R = v3.getAlpha();
                v3.setAlpha(0f);
            }
        }
    }

    private void a(RuntimeException arg6) {
        Log.e("FragmentManager", arg6.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter v1 = new PrintWriter(new android.support.v4.g.e("FragmentManager"));
        if(this.m != null) {
            try {
                this.m.a("  ", null, v1, new String[0]);
            }
            catch(Exception v0) {
                Log.e("FragmentManager", "Failed dumping state", ((Throwable)v0));
            }

            goto label_19;
        }

        try {
            this.a("  ", null, v1, new String[0]);
        }
        catch(Exception v0) {
            Log.e("FragmentManager", "Failed dumping state", ((Throwable)v0));
        }

    label_19:
        throw arg6;
    }

    private void a(ArrayList arg8, ArrayList arg9) {
        int v1;
        int v6 = -1;
        int v0 = this.B == null ? 0 : this.B.size();
        int v3 = 0;
        int v4;
        for(v4 = v0; v3 < v4; v4 = v1) {
            Object v0_1 = this.B.get(v3);
            if(arg8 == null || (g.a(((g)v0_1)))) {
            label_28:
                if((((g)v0_1).c()) || arg8 != null && (g.b(((g)v0_1)).a(arg8, 0, arg8.size()))) {
                    this.B.remove(v3);
                    --v3;
                    --v4;
                    if(arg8 != null && !g.a(((g)v0_1))) {
                        v1 = arg8.indexOf(g.b(((g)v0_1)));
                        if(v1 != v6 && (arg9.get(v1).booleanValue())) {
                            ((g)v0_1).e();
                            v0 = v3;
                            v1 = v4;
                            goto label_22;
                        }
                    }

                    ((g)v0_1).d();
                }

                v0 = v3;
                v1 = v4;
            }
            else {
                v1 = arg8.indexOf(g.b(((g)v0_1)));
                if(v1 == v6) {
                    goto label_28;
                }
                else if(arg9.get(v1).booleanValue()) {
                    ((g)v0_1).e();
                    v0 = v3;
                    v1 = v4;
                }
                else {
                    goto label_28;
                }
            }

        label_22:
            v3 = v0 + 1;
        }
    }

    private void a(ArrayList arg10, ArrayList arg11, int arg12, int arg13) {
        int v4;
        Object v0;
        boolean v8 = arg10.get(arg12).u;
        if(this.y == null) {
            this.y = new ArrayList();
        }
        else {
            this.y.clear();
        }

        this.y.addAll(this.e);
        int v2 = arg12;
        h v3 = this.v();
        int v7;
        for(v7 = 0; v2 < arg13; v7 = v0_1) {
            v0 = arg10.get(v2);
            h v1 = !arg11.get(v2).booleanValue() ? ((android.support.v4.a.c)v0).a(this.y, v3) : ((android.support.v4.a.c)v0).b(this.y, v3);
            int v0_1 = v7 != 0 || (((android.support.v4.a.c)v0).j) ? 1 : 0;
            ++v2;
            v3 = v1;
        }

        this.y.clear();
        if(!v8) {
            s.a(this, arg10, arg11, arg12, arg13, false);
        }

        n.b(arg10, arg11, arg12, arg13);
        if(v8) {
            android.support.v4.g.b v5 = new android.support.v4.g.b();
            this.b(v5);
            v4 = this.a(arg10, arg11, arg12, arg13, v5);
            this.a(v5);
        }
        else {
            v4 = arg13;
        }

        if(v4 != arg12 && (v8)) {
            s.a(this, arg10, arg11, arg12, v4, true);
            this.a(this.l, true);
        }

        while(arg12 < arg13) {
            v0 = arg10.get(arg12);
            if((arg11.get(arg12).booleanValue()) && ((android.support.v4.a.c)v0).n >= 0) {
                this.c(((android.support.v4.a.c)v0).n);
                ((android.support.v4.a.c)v0).n = -1;
            }

            ((android.support.v4.a.c)v0).a();
            ++arg12;
        }

        if(v7 != 0) {
            this.g();
        }
    }

    static boolean a(Animator arg6) {
        boolean v1 = false;
        if(arg6 != null) {
            if((arg6 instanceof ValueAnimator)) {
                PropertyValuesHolder[] v2 = ((ValueAnimator)arg6).getValues();
                int v0 = 0;
                while(v0 < v2.length) {
                    if("alpha".equals(v2[v0].getPropertyName())) {
                        v1 = true;
                    }
                    else {
                        ++v0;
                        continue;
                    }

                    return v1;
                }
            }
            else if((arg6 instanceof AnimatorSet)) {
                ArrayList v4 = ((AnimatorSet)arg6).getChildAnimations();
                int v2_1 = 0;
                while(v2_1 < ((List)v4).size()) {
                    if(n.a(((List)v4).get(v2_1))) {
                        v1 = true;
                    }
                    else {
                        ++v2_1;
                        continue;
                    }

                    return v1;
                }
            }
        }

        return v1;
    }

    static boolean a(c arg5) {
        boolean v1 = false;
        if((arg5.a instanceof AlphaAnimation)) {
            v1 = true;
        }
        else if((arg5.a instanceof AnimationSet)) {
            List v3 = arg5.a.getAnimations();
            int v0 = 0;
            while(v0 < v3.size()) {
                if((v3.get(v0) instanceof AlphaAnimation)) {
                    v1 = true;
                }
                else {
                    ++v0;
                    continue;
                }

                return v1;
            }
        }
        else {
            v1 = n.a(arg5.b);
        }

        return v1;
    }

    static boolean a(View arg3, c arg4) {
        boolean v0 = false;
        if(arg3 != null && arg4 != null && Build$VERSION.SDK_INT >= 19 && arg3.getLayerType() == 0 && (p.h(arg3)) && (n.a(arg4))) {
            v0 = true;
        }

        return v0;
    }

    private boolean a(String arg8, int arg9, int arg10) {
        boolean v0_1;
        this.e();
        this.c(true);
        if(this.p == null || arg9 >= 0 || arg8 != null) {
        label_14:
            v0_1 = this.a(this.w, this.x, arg8, arg9, arg10);
            if(v0_1) {
                this.c = true;
                try {
                    this.b(this.w, this.x);
                }
                catch(Throwable v0_2) {
                    this.z();
                    throw v0_2;
                }

                this.z();
            }

            this.f();
            this.C();
        }
        else {
            m v0 = this.p.h();
            if(v0 == null) {
                goto label_14;
            }
            else if(v0.a()) {
                v0_1 = true;
            }
            else {
                goto label_14;
            }
        }

        return v0_1;
    }

    boolean a(ArrayList arg6, ArrayList arg7, String arg8, int arg9, int arg10) {
        int v0_1;
        Object v0_2;
        boolean v0;
        if(this.g == null) {
            v0 = false;
        }
        else {
            if(arg8 != null || arg9 >= 0 || (arg10 & 1) != 0) {
                v0_1 = -1;
                if(arg8 != null || arg9 >= 0) {
                    int v1;
                    for(v1 = this.g.size() - 1; v1 >= 0; --v1) {
                        v0_2 = this.g.get(v1);
                        if(arg8 != null && (arg8.equals(((android.support.v4.a.c)v0_2).d()))) {
                            break;
                        }

                        if(arg9 >= 0 && arg9 == ((android.support.v4.a.c)v0_2).n) {
                            break;
                        }
                    }

                    if(v1 < 0) {
                        return false;
                    }

                    if((arg10 & 1) != 0) {
                        --v1;
                        while(v1 >= 0) {
                            v0_2 = this.g.get(v1);
                            if(arg8 == null || !arg8.equals(((android.support.v4.a.c)v0_2).d())) {
                                if(arg9 < 0) {
                                }
                                else if(arg9 == ((android.support.v4.a.c)v0_2).n) {
                                    goto label_57;
                                }

                                break;
                            }

                        label_57:
                            --v1;
                        }
                    }

                    v0_1 = v1;
                }

                if(v0_1 == this.g.size() - 1) {
                    return false;
                }

                for(v1 = this.g.size() - 1; v1 > v0_1; --v1) {
                    arg6.add(this.g.remove(v1));
                    arg7.add(Boolean.valueOf(true));
                }
            }
            else {
                v0_1 = this.g.size() - 1;
                if(v0_1 < 0) {
                    return false;
                }
                else {
                    arg6.add(this.g.remove(v0_1));
                    arg7.add(Boolean.valueOf(true));
                }
            }

            v0 = true;
        }

        return v0;
    }

    public h a(Bundle arg6, String arg7) {
        Object v0_1;
        int v1 = arg6.getInt(arg7, -1);
        if(v1 == -1) {
            h v0 = null;
        }
        else {
            v0_1 = this.f.get(v1);
            if(v0_1 == null) {
                this.a(new IllegalStateException("Fragment no longer exists for key " + arg7 + ": index " + v1));
            }
        }

        return ((h)v0_1);
    }

    public h a(String arg4) {
        Object v0;
        int v1;
        if(arg4 != null) {
            v1 = this.e.size() - 1;
            while(true) {
                if(v1 >= 0) {
                    v0 = this.e.get(v1);
                    if(v0 != null && (arg4.equals(((h)v0).y))) {
                        break;
                    }

                    --v1;
                    continue;
                }
                else {
                    goto label_16;
                }
            }
        }
        else {
        label_16:
            if(this.f != null && arg4 != null) {
                for(v1 = this.f.size() - 1; v1 >= 0; --v1) {
                    v0 = this.f.valueAt(v1);
                    if(v0 != null && (arg4.equals(((h)v0).y))) {
                        goto label_12;
                    }
                }
            }

            h v0_1 = null;
        }

    label_12:
        return ((h)v0);
    }

    c a(h arg11, int arg12, boolean arg13, int arg14) {
        int v0_3;
        c v0;
        float v9 = 0.975f;
        android.support.v4.a.n$1 v1 = null;
        float v7 = 1f;
        int v3 = arg11.M();
        Animation v2 = arg11.a(arg12, arg13, v3);
        if(v2 != null) {
            v0 = new c(v2, v1);
            return v0;
        }

        Animator v2_1 = arg11.b(arg12, arg13, v3);
        if(v2_1 != null) {
            return new c(v2_1, v1);
        }

        if(v3 != 0) {
            boolean v4 = "anim".equals(this.m.g().getResources().getResourceTypeName(v3));
            if(v4) {
                try {
                    Animation v5 = AnimationUtils.loadAnimation(this.m.g(), v3);
                    if(v5 == null) {
                        goto label_34;
                    }

                    return new c(v5, null);
                }
                catch(RuntimeException v0_1) {
                    v0_3 = 0;
                    goto label_35;
                }
                catch(Resources$NotFoundException v0_2) {
                    throw v0_2;
                }

            label_34:
                v0_3 = 1;
            }
            else {
                v0_3 = 0;
            }

        label_35:
            if(v0_3 == 0) {
                try {
                    v2_1 = AnimatorInflater.loadAnimator(this.m.g(), v3);
                    if(v2_1 == null) {
                        goto label_57;
                    }

                    v0 = new c(v2_1, null);
                }
                catch(RuntimeException v0_1) {
                    if(v4) {
                        throw v0_1;
                    }

                    v2 = AnimationUtils.loadAnimation(this.m.g(), v3);
                    if(v2 == null) {
                        goto label_57;
                    }

                    v0 = new c(v2, v1);
                }

                return v0;
            }
        }

    label_57:
        if(arg12 == 0) {
            return ((c)v1);
        }

        v0_3 = n.b(arg12, arg13);
        if(v0_3 < 0) {
            return ((c)v1);
        }

        switch(v0_3) {
            case 1: {
                goto label_74;
            }
            case 2: {
                goto label_79;
            }
            case 3: {
                goto label_83;
            }
            case 4: {
                goto label_87;
            }
            case 5: {
                goto label_92;
            }
            case 6: {
                goto label_96;
            }
        }

        if(arg14 == 0 && (this.m.d())) {
            arg14 = this.m.e();
        }

        if(arg14 == 0) {
            v0 = ((c)v1);
        }
        else {
            return ((c)v1);
        label_83:
            return n.a(this.m.g(), v9, v7, 0f, v7);
        label_87:
            return n.a(this.m.g(), v7, 1.075f, v7, 0f);
        label_74:
            return n.a(this.m.g(), 1.125f, v7, 0f, v7);
        label_92:
            return n.a(this.m.g(), 0f, v7);
        label_79:
            return n.a(this.m.g(), v7, v9, v7, 0f);
        label_96:
            v0 = n.a(this.m.g(), v7, 0f);
        }

        return v0;
    }

    public void a(int arg5, android.support.v4.a.c arg6) {
        __monitor_enter(this);
        try {
            if(this.i == null) {
                this.i = new ArrayList();
            }

            int v0_1 = this.i.size();
            if(arg5 < v0_1) {
                if(n.a) {
                    Log.v("FragmentManager", "Setting back stack index " + arg5 + " to " + arg6);
                }

                this.i.set(arg5, arg6);
            }
            else {
                while(v0_1 < arg5) {
                    this.i.add(null);
                    if(this.j == null) {
                        this.j = new ArrayList();
                    }

                    if(n.a) {
                        Log.v("FragmentManager", "Adding available back stack index " + v0_1);
                    }

                    this.j.add(Integer.valueOf(v0_1));
                    ++v0_1;
                }

                if(n.a) {
                    Log.v("FragmentManager", "Adding back stack index " + arg5 + " with " + arg6);
                }

                this.i.add(arg6);
            }

            __monitor_exit(this);
            return;
        label_67:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_67;
        }

        throw v0;
    }

    public void a(Bundle arg4, String arg5, h arg6) {
        if(arg6.e < 0) {
            this.a(new IllegalStateException("Fragment " + arg6 + " is not currently in the FragmentManager"));
        }

        arg4.putInt(arg5, arg6.e);
    }

    public void a(h arg7) {
        if(arg7.J) {
            if(this.c) {
                this.v = true;
            }
            else {
                arg7.J = false;
                this.a(arg7, this.l, 0, 0, false);
            }
        }
    }

    void a(h arg4, Context arg5, boolean arg6) {
        if(this.o != null) {
            m v0 = this.o.f();
            if((v0 instanceof n)) {
                ((n)v0).a(arg4, arg5, true);
            }
        }

        Iterator v2 = this.I.iterator();
        while(v2.hasNext()) {
            Object v0_1 = v2.next();
            if((arg6) && !((i)v0_1).b.booleanValue()) {
                continue;
            }

            ((i)v0_1).a.a(((m)this), arg4, arg5);
        }
    }

    void a(h arg4, Bundle arg5, boolean arg6) {
        if(this.o != null) {
            m v0 = this.o.f();
            if((v0 instanceof n)) {
                ((n)v0).a(arg4, arg5, true);
            }
        }

        Iterator v2 = this.I.iterator();
        while(v2.hasNext()) {
            Object v0_1 = v2.next();
            if((arg6) && !((i)v0_1).b.booleanValue()) {
                continue;
            }

            ((i)v0_1).a.a(((m)this), arg4, arg5);
        }
    }

    void a(h arg4, View arg5, Bundle arg6, boolean arg7) {
        if(this.o != null) {
            m v0 = this.o.f();
            if((v0 instanceof n)) {
                ((n)v0).a(arg4, arg5, arg6, true);
            }
        }

        Iterator v2 = this.I.iterator();
        while(v2.hasNext()) {
            Object v0_1 = v2.next();
            if((arg7) && !((i)v0_1).b.booleanValue()) {
                continue;
            }

            ((i)v0_1).a.a(((m)this), arg4, arg5, arg6);
        }
    }

    public boolean a() {
        this.x();
        return this.a(null, -1, 0);
    }

    public h b(String arg3) {
        h v0_1;
        if(this.f == null || arg3 == null) {
        label_17:
            v0_1 = null;
        }
        else {
            int v1 = this.f.size() - 1;
            while(true) {
                if(v1 >= 0) {
                    Object v0 = this.f.valueAt(v1);
                    if(v0 != null) {
                        v0_1 = ((h)v0).a(arg3);
                        if(v0_1 == null) {
                            goto label_14;
                        }

                        return v0_1;
                    }

                label_14:
                    --v1;
                    continue;
                }
                else {
                    goto label_17;
                }
            }
        }

        return v0_1;
    }

    public void b(Menu arg3) {
        int v1;
        for(v1 = 0; v1 < this.e.size(); ++v1) {
            Object v0 = this.e.get(v1);
            if(v0 != null) {
                ((h)v0).d(arg3);
            }
        }
    }

    public boolean b(MenuItem arg4) {
        boolean v2 = false;
        int v1;
        for(v1 = 0; v1 < this.e.size(); ++v1) {
            Object v0 = this.e.get(v1);
            if(v0 != null && (((h)v0).d(arg4))) {
                return true;
            }
        }

        return v2;
    }

    public void b(boolean arg3) {
        int v1;
        for(v1 = this.e.size() - 1; v1 >= 0; --v1) {
            Object v0 = this.e.get(v1);
            if(v0 != null) {
                ((h)v0).e(arg3);
            }
        }
    }

    private void b(android.support.v4.g.b arg9) {
        if(this.l >= 1) {
            int v2 = Math.min(this.l, 4);
            int v7 = this.e.size();
            int v6;
            for(v6 = 0; v6 < v7; ++v6) {
                Object v1 = this.e.get(v6);
                if(((h)v1).b < v2) {
                    this.a(((h)v1), v2, ((h)v1).M(), ((h)v1).N(), false);
                    if(((h)v1).H != null && !((h)v1).z && (((h)v1).P)) {
                        arg9.add(v1);
                    }
                }
            }
        }
    }

    private static void b(View arg3, c arg4) {
        if(arg3 != null && arg4 != null && (n.a(arg3, arg4))) {
            if(arg4.b != null) {
                arg4.b.addListener(new d(arg3));
            }
            else {
                Animation$AnimationListener v0 = n.a(arg4.a);
                arg3.setLayerType(2, null);
                arg4.a.setAnimationListener(new a(arg3, v0));
            }
        }
    }

    private static void b(ArrayList arg3, ArrayList arg4, int arg5, int arg6) {
        while(arg5 < arg6) {
            Object v0 = arg3.get(arg5);
            if(arg4.get(arg5).booleanValue()) {
                ((android.support.v4.a.c)v0).a(-1);
                boolean v1 = arg5 == arg6 - 1 ? true : false;
                ((android.support.v4.a.c)v0).a(v1);
            }
            else {
                ((android.support.v4.a.c)v0).a(1);
                ((android.support.v4.a.c)v0).b();
            }

            ++arg5;
        }
    }

    private void b(ArrayList arg6, ArrayList arg7) {
        int v0;
        int v2 = 0;
        if(arg6 != null && !arg6.isEmpty()) {
            if(arg7 != null && arg6.size() == arg7.size()) {
                this.a(arg6, arg7);
                int v3 = arg6.size();
                int v1 = 0;
                while(v2 < v3) {
                    if(!arg6.get(v2).u) {
                        if(v1 != v2) {
                            this.a(arg6, arg7, v1, v2);
                        }

                        v1 = v2 + 1;
                        if(arg7.get(v2).booleanValue()) {
                            while(v1 < v3) {
                                if(!arg7.get(v1).booleanValue()) {
                                    break;
                                }

                                if(arg6.get(v1).u) {
                                    break;
                                }

                                ++v1;
                            }
                        }

                        v0 = v1;
                        this.a(arg6, arg7, v2, v0);
                        v1 = v0;
                        --v0;
                    }
                    else {
                        v0 = v2;
                    }

                    v2 = v0 + 1;
                }

                if(v1 == v3) {
                    return;
                }

                this.a(arg6, arg7, v1, v3);
                return;
            }

            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    public static int b(int arg1, boolean arg2) {
        int v0 = -1;
        switch(arg1) {
            case 4097: {
                if(arg2) {
                    return 1;
                }

                v0 = 2;
                break;
            }
            case 4099: {
                if(arg2) {
                    return 5;
                }

                v0 = 6;
                break;
            }
            case 8194: {
                if(arg2) {
                    return 3;
                }

                v0 = 4;
                break;
            }
        }

        return v0;
    }

    void b(h arg4, Context arg5, boolean arg6) {
        if(this.o != null) {
            m v0 = this.o.f();
            if((v0 instanceof n)) {
                ((n)v0).b(arg4, arg5, true);
            }
        }

        Iterator v2 = this.I.iterator();
        while(v2.hasNext()) {
            Object v0_1 = v2.next();
            if((arg6) && !((i)v0_1).b.booleanValue()) {
                continue;
            }

            ((i)v0_1).a.b(((m)this), arg4, arg5);
        }
    }

    void b(h arg4, Bundle arg5, boolean arg6) {
        if(this.o != null) {
            m v0 = this.o.f();
            if((v0 instanceof n)) {
                ((n)v0).b(arg4, arg5, true);
            }
        }

        Iterator v2 = this.I.iterator();
        while(v2.hasNext()) {
            Object v0_1 = v2.next();
            if((arg6) && !((i)v0_1).b.booleanValue()) {
                continue;
            }

            ((i)v0_1).a.b(((m)this), arg4, arg5);
        }
    }

    void b(h arg4, boolean arg5) {
        if(this.o != null) {
            m v0 = this.o.f();
            if((v0 instanceof n)) {
                ((n)v0).b(arg4, true);
            }
        }

        Iterator v2 = this.I.iterator();
        while(v2.hasNext()) {
            Object v0_1 = v2.next();
            if((arg5) && !((i)v0_1).b.booleanValue()) {
                continue;
            }

            ((i)v0_1).a.a(((m)this), arg4);
        }
    }

    void b(h arg7) {
        this.a(arg7, this.l, 0, 0, false);
    }

    public h b(int arg4) {
        Object v0;
        int v1;
        for(v1 = this.e.size() - 1; v1 >= 0; --v1) {
            v0 = this.e.get(v1);
            if(v0 != null && ((h)v0).w == arg4) {
                goto label_10;
            }
        }

        if(this.f != null) {
            for(v1 = this.f.size() - 1; v1 >= 0; --v1) {
                v0 = this.f.valueAt(v1);
                if(v0 != null && ((h)v0).w == arg4) {
                    goto label_10;
                }
            }
        }

        h v0_1 = null;
    label_10:
        return ((h)v0);
    }

    public List b() {
        Object v0_2;
        if(this.e.isEmpty()) {
            List v0 = Collections.EMPTY_LIST;
        }
        else {
            ArrayList v1 = this.e;
            __monitor_enter(v1);
            try {
                v0_2 = this.e.clone();
                __monitor_exit(v1);
                goto label_4;
            label_12:
                __monitor_exit(v1);
            }
            catch(Throwable v0_1) {
                goto label_12;
            }

            throw v0_1;
        }

    label_4:
        return ((List)v0_2);
    }

    public boolean c() {
        return this.s;
    }

    public void c(int arg4) {
        __monitor_enter(this);
        try {
            this.i.set(arg4, null);
            if(this.j == null) {
                this.j = new ArrayList();
            }

            if(n.a) {
                Log.v("FragmentManager", "Freeing back stack index " + arg4);
            }

            this.j.add(Integer.valueOf(arg4));
            __monitor_exit(this);
            return;
        label_25:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_25;
        }

        throw v0;
    }

    private void c(boolean arg4) {
        if(this.c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }

        if(Looper.myLooper() != this.m.h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }

        if(!arg4) {
            this.x();
        }

        if(this.w == null) {
            this.w = new ArrayList();
            this.x = new ArrayList();
        }

        this.c = true;
        ArrayList v0 = null;
        ArrayList v1 = null;
        try {
            this.a(v0, v1);
        }
        catch(Throwable v0_1) {
            this.c = false;
            throw v0_1;
        }

        this.c = false;
    }

    private boolean c(ArrayList arg5, ArrayList arg6) {
        boolean v0 = false;
        __monitor_enter(this);
        try {
            if(this.b == null || this.b.size() == 0) {
                __monitor_exit(this);
            }
            else {
                int v3 = this.b.size();
                int v2 = 0;
                int v1 = 0;
                while(v2 < v3) {
                    v1 |= this.b.get(v2).a(arg5, arg6);
                    ++v2;
                }

                this.b.clear();
                this.m.h().removeCallbacks(this.D);
                __monitor_exit(this);
                int v0_2 = v1;
            }

            return v0;
        label_31:
            __monitor_exit(this);
        }
        catch(Throwable v0_1) {
            goto label_31;
        }

        throw v0_1;
    }

    void c(h arg5) {
        ViewGroup v3 = null;
        if((arg5.m) && !arg5.p) {
            arg5.H = arg5.b(arg5.d(arg5.c), v3, arg5.c);
            if(arg5.H != null) {
                arg5.I = arg5.H;
                arg5.H.setSaveFromParentEnabled(false);
                if(arg5.z) {
                    arg5.H.setVisibility(8);
                }

                arg5.a(arg5.H, arg5.c);
                this.a(arg5, arg5.H, arg5.c, false);
            }
            else {
                arg5.I = ((View)v3);
            }
        }
    }

    void c(h arg4, Bundle arg5, boolean arg6) {
        if(this.o != null) {
            m v0 = this.o.f();
            if((v0 instanceof n)) {
                ((n)v0).c(arg4, arg5, true);
            }
        }

        Iterator v2 = this.I.iterator();
        while(v2.hasNext()) {
            Object v0_1 = v2.next();
            if((arg6) && !((i)v0_1).b.booleanValue()) {
                continue;
            }

            ((i)v0_1).a.c(((m)this), arg4, arg5);
        }
    }

    void c(h arg4, boolean arg5) {
        if(this.o != null) {
            m v0 = this.o.f();
            if((v0 instanceof n)) {
                ((n)v0).c(arg4, true);
            }
        }

        Iterator v2 = this.I.iterator();
        while(v2.hasNext()) {
            Object v0_1 = v2.next();
            if((arg5) && !((i)v0_1).b.booleanValue()) {
                continue;
            }

            ((i)v0_1).a.b(((m)this), arg4);
        }
    }

    public static int d(int arg1) {
        int v0 = 0;
        switch(arg1) {
            case 4097: {
                v0 = 0x2002;
                break;
            }
            case 4099: {
                v0 = 0x1003;
                break;
            }
            case 8194: {
                v0 = 0x1001;
                break;
            }
        }

        return v0;
    }

    void d() {
        if(this.f != null) {
            int v1;
            for(v1 = 0; v1 < this.f.size(); ++v1) {
                Object v0 = this.f.valueAt(v1);
                if(v0 != null) {
                    this.a(((h)v0));
                }
            }
        }
    }

    void d(h arg4, boolean arg5) {
        if(this.o != null) {
            m v0 = this.o.f();
            if((v0 instanceof n)) {
                ((n)v0).d(arg4, true);
            }
        }

        Iterator v2 = this.I.iterator();
        while(v2.hasNext()) {
            Object v0_1 = v2.next();
            if((arg5) && !((i)v0_1).b.booleanValue()) {
                continue;
            }

            ((i)v0_1).a.c(((m)this), arg4);
        }
    }

    void d(h arg8) {
        if(arg8.H != null) {
            int v3 = arg8.N();
            boolean v0 = !arg8.z ? true : false;
            c v0_1 = this.a(arg8, v3, v0, arg8.O());
            if(v0_1 != null && v0_1.b != null) {
                v0_1.b.setTarget(arg8.H);
                if(!arg8.z) {
                    arg8.H.setVisibility(0);
                }
                else if(arg8.V()) {
                    arg8.f(false);
                }
                else {
                    ViewGroup v3_1 = arg8.G;
                    View v4 = arg8.H;
                    v3_1.startViewTransition(v4);
                    v0_1.b.addListener(new AnimatorListenerAdapter(v3_1, v4, arg8) {
                        public void onAnimationEnd(Animator arg3) {
                            this.a.endViewTransition(this.b);
                            arg3.removeListener(((Animator$AnimatorListener)this));
                            if(this.c.H != null) {
                                this.c.H.setVisibility(8);
                            }
                        }
                    });
                }

                n.b(arg8.H, v0_1);
                v0_1.b.start();
                goto label_25;
            }

            if(v0_1 != null) {
                n.b(arg8.H, v0_1);
                arg8.H.startAnimation(v0_1.a);
                v0_1.a.start();
            }

            int v0_2 = !arg8.z || (arg8.V()) ? 0 : 8;
            arg8.H.setVisibility(v0_2);
            if(!arg8.V()) {
                goto label_25;
            }

            arg8.f(false);
        }

    label_25:
        if((arg8.k) && (arg8.D) && (arg8.E)) {
            this.r = true;
        }

        arg8.Q = false;
        arg8.a(arg8.z);
    }

    void d(h arg4, Bundle arg5, boolean arg6) {
        if(this.o != null) {
            m v0 = this.o.f();
            if((v0 instanceof n)) {
                ((n)v0).d(arg4, arg5, true);
            }
        }

        Iterator v2 = this.I.iterator();
        while(v2.hasNext()) {
            Object v0_1 = v2.next();
            if((arg6) && !((i)v0_1).b.booleanValue()) {
                continue;
            }

            ((i)v0_1).a.d(((m)this), arg4, arg5);
        }
    }

    void e(h arg9) {
        if(arg9 != null) {
            int v2 = this.l;
            if(arg9.l) {
                v2 = arg9.b() ? Math.min(v2, 1) : Math.min(v2, 0);
            }

            this.a(arg9, v2, arg9.N(), arg9.O(), false);
            if(arg9.H != null) {
                h v0 = this.p(arg9);
                if(v0 != null) {
                    View v0_1 = v0.H;
                    ViewGroup v1 = arg9.G;
                    int v0_2 = v1.indexOfChild(v0_1);
                    v2 = v1.indexOfChild(arg9.H);
                    if(v2 < v0_2) {
                        v1.removeViewAt(v2);
                        v1.addView(arg9.H, v0_2);
                    }
                }

                if(!arg9.P) {
                    goto label_51;
                }

                if(arg9.G == null) {
                    goto label_51;
                }

                if(arg9.R > 0f) {
                    arg9.H.setAlpha(arg9.R);
                }

                arg9.R = 0f;
                arg9.P = false;
                c v0_3 = this.a(arg9, arg9.N(), true, arg9.O());
                if(v0_3 == null) {
                    goto label_51;
                }

                n.b(arg9.H, v0_3);
                if(v0_3.a != null) {
                    arg9.H.startAnimation(v0_3.a);
                    goto label_51;
                }

                v0_3.b.setTarget(arg9.H);
                v0_3.b.start();
            }

        label_51:
            if(!arg9.Q) {
                return;
            }

            this.d(arg9);
        }
    }

    public boolean e() {
        this.c(true);
        boolean v0;
        for(v0 = false; this.c(this.w, this.x); v0 = true) {
            this.c = true;
            try {
                this.b(this.w, this.x);
            }
            catch(Throwable v0_1) {
                this.z();
                throw v0_1;
            }

            this.z();
        }

        this.f();
        this.C();
        return v0;
    }

    private void e(int arg3) {
        try {
            this.c = true;
            this.a(arg3, false);
        }
        catch(Throwable v0) {
            this.c = false;
            throw v0;
        }

        this.c = false;
        this.e();
    }

    void e(h arg4, boolean arg5) {
        if(this.o != null) {
            m v0 = this.o.f();
            if((v0 instanceof n)) {
                ((n)v0).e(arg4, true);
            }
        }

        Iterator v2 = this.I.iterator();
        while(v2.hasNext()) {
            Object v0_1 = v2.next();
            if((arg5) && !((i)v0_1).b.booleanValue()) {
                continue;
            }

            ((i)v0_1).a.d(((m)this), arg4);
        }
    }

    void f() {
        if(this.v) {
            int v1 = 0;
            int v3 = 0;
            while(v1 < this.f.size()) {
                Object v0 = this.f.valueAt(v1);
                if(v0 != null && ((h)v0).L != null) {
                    v3 |= ((h)v0).L.a();
                }

                ++v1;
            }

            if(v3 != 0) {
                return;
            }

            this.v = false;
            this.d();
        }
    }

    void f(h arg4, boolean arg5) {
        if(this.o != null) {
            m v0 = this.o.f();
            if((v0 instanceof n)) {
                ((n)v0).f(arg4, true);
            }
        }

        Iterator v2 = this.I.iterator();
        while(v2.hasNext()) {
            Object v0_1 = v2.next();
            if((arg5) && !((i)v0_1).b.booleanValue()) {
                continue;
            }

            ((i)v0_1).a.e(((m)this), arg4);
        }
    }

    void f(h arg4) {
        if(arg4.e < 0) {
            int v0 = this.d;
            this.d = v0 + 1;
            arg4.a(v0, this.o);
            if(this.f == null) {
                this.f = new SparseArray();
            }

            this.f.put(arg4.e, arg4);
            if(!n.a) {
                return;
            }

            Log.v("FragmentManager", "Allocated fragment index " + arg4);
        }
    }

    void g() {
        if(this.k != null) {
            int v1;
            for(v1 = 0; v1 < this.k.size(); ++v1) {
                this.k.get(v1).a();
            }
        }
    }

    void g(h arg4, boolean arg5) {
        if(this.o != null) {
            m v0 = this.o.f();
            if((v0 instanceof n)) {
                ((n)v0).g(arg4, true);
            }
        }

        Iterator v2 = this.I.iterator();
        while(v2.hasNext()) {
            Object v0_1 = v2.next();
            if((arg5) && !((i)v0_1).b.booleanValue()) {
                continue;
            }

            ((i)v0_1).a.f(((m)this), arg4);
        }
    }

    void g(h arg4) {
        if(arg4.e >= 0) {
            if(n.a) {
                Log.v("FragmentManager", "Freeing fragment index " + arg4);
            }

            this.f.put(arg4.e, null);
            this.m.a(arg4.f);
            arg4.p();
        }
    }

    public void h(h arg6) {
        if(n.a) {
            Log.v("FragmentManager", "remove: " + arg6 + " nesting=" + arg6.q);
        }

        int v0 = !arg6.b() ? 1 : 0;
        if(!arg6.A || v0 != 0) {
            ArrayList v3 = this.e;
            __monitor_enter(v3);
            try {
                this.e.remove(arg6);
                __monitor_exit(v3);
            }
            catch(Throwable v0_1) {
                try {
                label_38:
                    __monitor_exit(v3);
                }
                catch(Throwable v0_1) {
                    goto label_38;
                }

                throw v0_1;
            }

            if((arg6.D) && (arg6.E)) {
                this.r = true;
            }

            arg6.k = false;
            arg6.l = true;
        }
    }

    o h() {
        n.a(this.C);
        return this.C;
    }

    void h(h arg4, boolean arg5) {
        if(this.o != null) {
            m v0 = this.o.f();
            if((v0 instanceof n)) {
                ((n)v0).h(arg4, true);
            }
        }

        Iterator v2 = this.I.iterator();
        while(v2.hasNext()) {
            Object v0_1 = v2.next();
            if((arg5) && !((i)v0_1).b.booleanValue()) {
                continue;
            }

            ((i)v0_1).a.g(((m)this), arg4);
        }
    }

    public void i(h arg5) {
        boolean v0 = true;
        if(n.a) {
            Log.v("FragmentManager", "hide: " + arg5);
        }

        if(!arg5.z) {
            arg5.z = true;
            if(arg5.Q) {
                v0 = false;
            }

            arg5.Q = v0;
        }
    }

    void i() {
        ArrayList v0_2;
        o v6_1;
        ArrayList v2;
        ArrayList v1;
        Object v5 = null;
        if(this.f != null) {
            int v3 = 0;
            v1 = ((ArrayList)v5);
            v2 = ((ArrayList)v5);
            while(v3 < this.f.size()) {
                Object v0 = this.f.valueAt(v3);
                if(v0 != null) {
                    if(((h)v0).B) {
                        if(v2 == null) {
                            v2 = new ArrayList();
                        }

                        v2.add(v0);
                        int v6 = ((h)v0).h != null ? ((h)v0).h.e : -1;
                        ((h)v0).i = v6;
                        if(!n.a) {
                            goto label_34;
                        }

                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + v0);
                    }

                label_34:
                    if(((h)v0).t != null) {
                        ((h)v0).t.i();
                        v6_1 = ((h)v0).t.C;
                    }
                    else {
                        v6_1 = ((h)v0).u;
                    }

                    if(v1 == null && v6_1 != null) {
                        v1 = new ArrayList(this.f.size());
                        int v0_1;
                        for(v0_1 = 0; v0_1 < v3; ++v0_1) {
                            v1.add(v5);
                        }
                    }

                    v0_2 = v1;
                    if(v0_2 != null) {
                        v0_2.add(v6_1);
                    }

                    v1 = v2;
                }
                else {
                    v0_2 = v1;
                    v1 = v2;
                }

                ++v3;
                v2 = v1;
                v1 = v0_2;
            }
        }
        else {
            v1 = ((ArrayList)v5);
            v2 = ((ArrayList)v5);
        }

        this.C = v2 != null || v1 != null ? new o(((List)v2), ((List)v1)) : ((o)v5);
    }

    public void j(h arg5) {
        boolean v0 = false;
        if(n.a) {
            Log.v("FragmentManager", "show: " + arg5);
        }

        if(arg5.z) {
            arg5.z = false;
            if(!arg5.Q) {
                v0 = true;
            }

            arg5.Q = v0;
        }
    }

    Parcelable j() {
        android.support.v4.a.d[] v3_1;
        int[] v1;
        int v0_1;
        o v3 = null;
        this.A();
        this.B();
        this.e();
        this.s = true;
        this.C = v3;
        if(this.f != null && this.f.size() > 0) {
            int v6 = this.f.size();
            q[] v7 = new q[v6];
            int v5 = 0;
            int v2;
            for(v2 = 0; v5 < v6; v2 = v0_1) {
                Object v0 = this.f.valueAt(v5);
                if(v0 != null) {
                    if(((h)v0).e < 0) {
                        this.a(new IllegalStateException("Failure saving state: active " + v0 + " has cleared index: " + ((h)v0).e));
                    }

                    q v2_1 = new q(((h)v0));
                    v7[v5] = v2_1;
                    if(((h)v0).b <= 0 || v2_1.k != null) {
                        v2_1.k = ((h)v0).c;
                    }
                    else {
                        v2_1.k = this.n(((h)v0));
                        if(((h)v0).h != null) {
                            if(((h)v0).h.e < 0) {
                                this.a(new IllegalStateException("Failure saving state: " + v0 + " has target not in fragment manager: " + ((h)v0).h));
                            }

                            if(v2_1.k == null) {
                                v2_1.k = new Bundle();
                            }

                            this.a(v2_1.k, "android:target_state", ((h)v0).h);
                            if(((h)v0).j == 0) {
                                goto label_80;
                            }

                            v2_1.k.putInt("android:target_req_state", ((h)v0).j);
                        }
                    }

                label_80:
                    if(n.a) {
                        Log.v("FragmentManager", "Saved state of " + v0 + ": " + v2_1.k);
                    }

                    v0_1 = 1;
                }
                else {
                    v0_1 = v2;
                }

                ++v5;
            }

            if(v2 == 0) {
                if(!n.a) {
                    goto label_13;
                }

                Log.v("FragmentManager", "saveAllState: no fragments!");
                goto label_13;
            }

            v5 = this.e.size();
            if(v5 > 0) {
                v1 = new int[v5];
                v2 = 0;
                goto label_114;
            }
            else {
                v1 = ((int[])v3);
                goto label_155;
            label_114:
                while(v2 < v5) {
                    v1[v2] = this.e.get(v2).e;
                    if(v1[v2] < 0) {
                        this.a(new IllegalStateException("Failure saving state: active " + this.e.get(v2) + " has cleared index: " + v1[v2]));
                    }

                    if(n.a) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + v2 + ": " + this.e.get(v2));
                    }

                    ++v2;
                }
            }

        label_155:
            if(this.g != null) {
                v5 = this.g.size();
                if(v5 > 0) {
                    v3_1 = new android.support.v4.a.d[v5];
                    for(v2 = 0; v2 < v5; ++v2) {
                        v3_1[v2] = new android.support.v4.a.d(this.g.get(v2));
                        if(n.a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + v2 + ": " + this.g.get(v2));
                        }
                    }
                }
            }

            android.support.v4.a.p v0_2 = new android.support.v4.a.p();
            v0_2.a = v7;
            v0_2.b = v1;
            v0_2.c = v3_1;
            if(this.p != null) {
                v0_2.d = this.p.e;
            }

            v0_2.e = this.d;
            this.i();
            android.support.v4.a.p v3_2 = v0_2;
        }

    label_13:
        return ((Parcelable)v3);
    }

    public void k(h arg5) {
        if(n.a) {
            Log.v("FragmentManager", "detach: " + arg5);
        }

        if(!arg5.A) {
            arg5.A = true;
            if(arg5.k) {
                if(n.a) {
                    Log.v("FragmentManager", "remove from detach: " + arg5);
                }

                ArrayList v1 = this.e;
                __monitor_enter(v1);
                try {
                    this.e.remove(arg5);
                    __monitor_exit(v1);
                }
                catch(Throwable v0) {
                    try {
                    label_40:
                        __monitor_exit(v1);
                    }
                    catch(Throwable v0) {
                        goto label_40;
                    }

                    throw v0;
                }

                if((arg5.D) && (arg5.E)) {
                    this.r = true;
                }

                arg5.k = false;
            }
        }
    }

    public void k() {
        this.C = null;
        this.s = false;
        int v2 = this.e.size();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            Object v0 = this.e.get(v1);
            if(v0 != null) {
                ((h)v0).E();
            }
        }
    }

    public void l(h arg5) {
        if(n.a) {
            Log.v("FragmentManager", "attach: " + arg5);
        }

        if(arg5.A) {
            arg5.A = false;
            if(!arg5.k) {
                if(this.e.contains(arg5)) {
                    throw new IllegalStateException("Fragment already added: " + arg5);
                }
                else {
                    if(n.a) {
                        Log.v("FragmentManager", "add from attach: " + arg5);
                    }

                    ArrayList v1 = this.e;
                    __monitor_enter(v1);
                    try {
                        this.e.add(arg5);
                        __monitor_exit(v1);
                    }
                    catch(Throwable v0) {
                        try {
                        label_52:
                            __monitor_exit(v1);
                        }
                        catch(Throwable v0) {
                            goto label_52;
                        }

                        throw v0;
                    }

                    arg5.k = true;
                    if(!arg5.D) {
                        return;
                    }

                    if(!arg5.E) {
                        return;
                    }

                    this.r = true;
                }
            }
        }
    }

    public void l() {
        this.s = false;
        this.e(1);
    }

    public void m() {
        this.s = false;
        this.e(2);
    }

    void m(h arg3) {
        if(arg3.I != null) {
            if(this.A == null) {
                this.A = new SparseArray();
            }
            else {
                this.A.clear();
            }

            arg3.I.saveHierarchyState(this.A);
            if(this.A.size() <= 0) {
                return;
            }

            arg3.d = this.A;
            this.A = null;
        }
    }

    public void n() {
        this.s = false;
        this.e(4);
    }

    Bundle n(h arg4) {
        Bundle v0;
        Bundle v1 = null;
        if(this.z == null) {
            this.z = new Bundle();
        }

        arg4.m(this.z);
        this.d(arg4, this.z, false);
        if(!this.z.isEmpty()) {
            v0 = this.z;
            this.z = v1;
        }
        else {
            v0 = v1;
        }

        if(arg4.H != null) {
            this.m(arg4);
        }

        if(arg4.d != null) {
            if(v0 == null) {
                v0 = new Bundle();
            }

            v0.putSparseParcelableArray("android:view_state", arg4.d);
        }

        if(!arg4.K) {
            if(v0 == null) {
                v0 = new Bundle();
            }

            v0.putBoolean("android:user_visible_hint", arg4.K);
        }

        return v0;
    }

    public void o(h arg4) {
        if(arg4 != null) {
            if(this.f.get(arg4.e) == arg4) {
                if(arg4.s == null) {
                }
                else if(arg4.f() != this) {
                    goto label_9;
                }

                goto label_21;
            }

        label_9:
            throw new IllegalArgumentException("Fragment " + arg4 + " is not an active fragment of FragmentManager " + this);
        }

    label_21:
        this.p = arg4;
    }

    public void o() {
        this.s = false;
        this.e(5);
    }

    public View onCreateView(View arg12, String arg13, Context arg14, AttributeSet arg15) {
        h v1_2;
        View v0;
        String v4 = null;
        int v5 = -1;
        if(!"fragment".equals(arg13)) {
            v0 = ((View)v4);
        }
        else {
            String v0_1 = arg15.getAttributeValue(v4, "class");
            TypedArray v1 = arg14.obtainStyledAttributes(arg15, e.a);
            String v6 = v0_1 == null ? v1.getString(0) : v0_1;
            int v7 = v1.getResourceId(1, v5);
            String v8 = v1.getString(2);
            v1.recycle();
            if(!h.a(this.m.g(), v6)) {
                return ((View)v4);
            }

            int v1_1 = arg12 != null ? arg12.getId() : 0;
            if(v1_1 == v5 && v7 == v5 && v8 == null) {
                throw new IllegalArgumentException(arg15.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + v6);
            }

            h v0_2 = v7 != v5 ? this.b(v7) : ((h)v4);
            if(v0_2 == null && v8 != null) {
                v0_2 = this.a(v8);
            }

            if(v0_2 == null && v1_1 != v5) {
                v0_2 = this.b(v1_1);
            }

            if(n.a) {
                Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(v7) + " fname=" + v6 + " existing=" + v0_2);
            }

            if(v0_2 == null) {
                h v4_1 = this.n.a(arg14, v6, ((Bundle)v4));
                v4_1.m = true;
                int v0_3 = v7 != 0 ? v7 : v1_1;
                v4_1.w = v0_3;
                v4_1.x = v1_1;
                v4_1.y = v8;
                v4_1.n = true;
                v4_1.r = this;
                v4_1.s = this.m;
                v4_1.a(this.m.g(), arg15, v4_1.c);
                this.a(v4_1, true);
                v1_2 = v4_1;
            }
            else {
                if(v0_2.n) {
                    throw new IllegalArgumentException(arg15.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(v7) + ", tag " + v8 + ", or parent id 0x" + Integer.toHexString(v1_1) + " with another fragment for " + v6);
                }

                v0_2.n = true;
                v0_2.s = this.m;
                if(!v0_2.C) {
                    v0_2.a(this.m.g(), arg15, v0_2.c);
                }

                v1_2 = v0_2;
            }

            if(this.l >= 1 || !v1_2.m) {
                this.b(v1_2);
            }
            else {
                this.a(v1_2, 1, 0, 0, false);
            }

            if(v1_2.H == null) {
                throw new IllegalStateException("Fragment " + v6 + " did not create a view.");
            }

            if(v7 != 0) {
                v1_2.H.setId(v7);
            }

            if(v1_2.H.getTag() == null) {
                v1_2.H.setTag(v8);
            }

            v0 = v1_2.H;
        }

        return v0;
    }

    public View onCreateView(String arg2, Context arg3, AttributeSet arg4) {
        return this.onCreateView(null, arg2, arg3, arg4);
    }

    public void p() {
        this.e(4);
    }

    private h p(h arg6) {
        h v0_2;
        Object v0_1;
        h v1 = null;
        ViewGroup v3 = arg6.G;
        View v0 = arg6.H;
        if(v3 == null || v0 == null) {
            v0_2 = v1;
        }
        else {
            int v2;
            for(v2 = this.e.indexOf(arg6) - 1; v2 >= 0; --v2) {
                v0_1 = this.e.get(v2);
                if(((h)v0_1).G == v3 && ((h)v0_1).H != null) {
                    goto label_6;
                }
            }

            v0_2 = v1;
        }

    label_6:
        return ((h)v0_1);
    }

    public void q() {
        this.s = true;
        this.e(3);
    }

    public void r() {
        this.e(2);
    }

    public void s() {
        this.e(1);
    }

    public void t() {
        this.t = true;
        this.e();
        this.e(0);
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x80);
        v0.append("FragmentManager{");
        v0.append(Integer.toHexString(System.identityHashCode(this)));
        v0.append(" in ");
        if(this.o != null) {
            android.support.v4.g.d.a(this.o, v0);
        }
        else {
            android.support.v4.g.d.a(this.m, v0);
        }

        v0.append("}}");
        return v0.toString();
    }

    public void u() {
        int v1;
        for(v1 = 0; v1 < this.e.size(); ++v1) {
            Object v0 = this.e.get(v1);
            if(v0 != null) {
                ((h)v0).F();
            }
        }
    }

    public h v() {
        return this.p;
    }

    LayoutInflater$Factory2 w() {
        return this;
    }

    private void x() {
        if(this.s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }

        if(this.u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.u);
        }
    }

    private void y() {
        int v0 = 1;
        __monitor_enter(this);
        try {
            int v2 = this.B == null || (this.B.isEmpty()) ? 0 : 1;
            if(this.b == null || this.b.size() != 1) {
                v0 = 0;
            }

            if(v2 != 0 || v0 != 0) {
                this.m.h().removeCallbacks(this.D);
                this.m.h().post(this.D);
            }

            __monitor_exit(this);
            return;
        label_31:
            __monitor_exit(this);
        }
        catch(Throwable v0_1) {
            goto label_31;
        }

        throw v0_1;
    }

    private void z() {
        this.c = false;
        this.x.clear();
        this.w.clear();
    }
}

