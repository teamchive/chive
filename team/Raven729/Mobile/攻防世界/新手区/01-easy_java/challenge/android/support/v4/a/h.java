package android.support.v4.a;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.c;
import android.arch.lifecycle.d;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.g.k;
import android.support.v4.h.e;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View$OnCreateContextMenuListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

public class h implements c, ComponentCallbacks, View$OnCreateContextMenuListener {
    class a {
        View a;
        Animator b;
        int c;
        int d;
        int e;
        int f;
        y g;
        y h;
        boolean i;
        android.support.v4.a.h$c j;
        boolean k;
        private Object l;
        private Object m;
        private Object n;
        private Object o;
        private Object p;
        private Object q;
        private Boolean r;
        private Boolean s;

        a() {
            super();
            this.l = null;
            this.m = h.a;
            this.n = null;
            this.o = h.a;
            this.p = null;
            this.q = h.a;
            this.g = null;
            this.h = null;
        }

        static Object a(a arg1) {
            return arg1.l;
        }

        static Object b(a arg1) {
            return arg1.m;
        }

        static Object c(a arg1) {
            return arg1.n;
        }

        static Object d(a arg1) {
            return arg1.o;
        }

        static Object e(a arg1) {
            return arg1.p;
        }

        static Object f(a arg1) {
            return arg1.q;
        }

        static Boolean g(a arg1) {
            return arg1.s;
        }

        static Boolean h(a arg1) {
            return arg1.r;
        }
    }

    public class b extends RuntimeException {
        public b(String arg1, Exception arg2) {
            super(arg1, ((Throwable)arg2));
        }
    }

    interface android.support.v4.a.h$c {
        void a();

        void b();
    }

    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    ViewGroup G;
    View H;
    View I;
    boolean J;
    boolean K;
    v L;
    boolean M;
    boolean N;
    a O;
    boolean P;
    boolean Q;
    float R;
    LayoutInflater S;
    boolean T;
    d U;
    private static final k V;
    static final Object a;
    int b;
    Bundle c;
    SparseArray d;
    int e;
    String f;
    Bundle g;
    h h;
    int i;
    int j;
    boolean k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    int q;
    n r;
    l s;
    n t;
    o u;
    h v;
    int w;
    int x;
    String y;
    boolean z;

    static {
        h.V = new k();
        h.a = new Object();
    }

    public h() {
        super();
        this.b = 0;
        this.e = -1;
        this.i = -1;
        this.E = true;
        this.K = true;
        this.U = new d(((c)this));
    }

    public void A() {
        if(this.r == null || this.r.m == null) {
            this.X().i = false;
        }
        else if(Looper.myLooper() != this.r.m.h().getLooper()) {
            this.r.m.h().postAtFrontOfQueue(new Runnable() {
                public void run() {
                    h.b(this.a);
                }
            });
        }
        else {
            this.W();
        }
    }

    void B() {
        if(this.s == null) {
            throw new IllegalStateException("Fragment has not been attached yet.");
        }

        this.t = new n();
        this.t.a(this.s, new j() {
            public h a(Context arg2, String arg3, Bundle arg4) {
                return this.a.s.a(arg2, arg3, arg4);
            }

            public View a(int arg3) {
                if(this.a.H == null) {
                    throw new IllegalStateException("Fragment does not have a view");
                }

                return this.a.H.findViewById(arg3);
            }

            public boolean a() {
                boolean v0 = this.a.H != null ? true : false;
                return v0;
            }
        }, this);
    }

    void C() {
        if(this.t != null) {
            this.t.k();
            this.t.e();
        }

        this.b = 4;
        this.F = false;
        this.j();
        if(!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onStart()");
        }

        if(this.t != null) {
            this.t.n();
        }

        if(this.L != null) {
            this.L.g();
        }

        this.U.a(android.arch.lifecycle.b$a.ON_START);
    }

    void D() {
        if(this.t != null) {
            this.t.k();
            this.t.e();
        }

        this.b = 5;
        this.F = false;
        this.k();
        if(!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onResume()");
        }

        if(this.t != null) {
            this.t.o();
            this.t.e();
        }

        this.U.a(android.arch.lifecycle.b$a.ON_RESUME);
    }

    void E() {
        if(this.t != null) {
            this.t.k();
        }
    }

    void F() {
        this.onLowMemory();
        if(this.t != null) {
            this.t.u();
        }
    }

    void G() {
        this.U.a(android.arch.lifecycle.b$a.ON_PAUSE);
        if(this.t != null) {
            this.t.p();
        }

        this.b = 4;
        this.F = false;
        this.l();
        if(!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void H() {
        this.U.a(android.arch.lifecycle.b$a.ON_STOP);
        if(this.t != null) {
            this.t.q();
        }

        this.b = 3;
        this.F = false;
        this.m();
        if(!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void I() {
        if(this.t != null) {
            this.t.r();
        }

        this.b = 2;
        if(this.M) {
            this.M = false;
            if(!this.N) {
                this.N = true;
                this.L = this.s.a(this.f, this.M, false);
            }

            if(this.L == null) {
                return;
            }

            if(this.s.j()) {
                this.L.d();
                return;
            }

            this.L.c();
        }
    }

    void J() {
        if(this.t != null) {
            this.t.s();
        }

        this.b = 1;
        this.F = false;
        this.n();
        if(!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onDestroyView()");
        }

        if(this.L != null) {
            this.L.f();
        }

        this.p = false;
    }

    void K() {
        this.U.a(android.arch.lifecycle.b$a.ON_DESTROY);
        if(this.t != null) {
            this.t.t();
        }

        this.b = 0;
        this.F = false;
        this.T = false;
        this.o();
        if(!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onDestroy()");
        }

        this.t = null;
    }

    void L() {
        LayoutInflater v1 = null;
        this.F = false;
        this.q();
        this.S = v1;
        if(!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onDetach()");
        }

        if(this.t != null) {
            if(!this.C) {
                throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
            }
            else {
                this.t.t();
                this.t = ((n)v1);
            }
        }
    }

    int M() {
        int v0 = this.O == null ? 0 : this.O.d;
        return v0;
    }

    int N() {
        int v0 = this.O == null ? 0 : this.O.e;
        return v0;
    }

    int O() {
        int v0 = this.O == null ? 0 : this.O.f;
        return v0;
    }

    y P() {
        y v0 = this.O == null ? null : this.O.g;
        return v0;
    }

    y Q() {
        y v0 = this.O == null ? null : this.O.h;
        return v0;
    }

    View R() {
        View v0 = this.O == null ? null : this.O.a;
        return v0;
    }

    Animator S() {
        Animator v0 = this.O == null ? null : this.O.b;
        return v0;
    }

    int T() {
        int v0 = this.O == null ? 0 : this.O.c;
        return v0;
    }

    boolean U() {
        boolean v0 = this.O == null ? false : this.O.i;
        return v0;
    }

    boolean V() {
        boolean v0 = this.O == null ? false : this.O.k;
        return v0;
    }

    private void W() {
        android.support.v4.a.h$c v0 = null;
        if(this.O != null) {
            this.O.i = false;
            android.support.v4.a.h$c v1 = this.O.j;
            this.O.j = v0;
            v0 = v1;
        }

        if(v0 != null) {
            v0.a();
        }
    }

    private a X() {
        if(this.O == null) {
            this.O = new a();
        }

        return this.O;
    }

    void a(android.support.v4.a.h$c arg4) {
        this.X();
        if(arg4 != this.O.j) {
            if(arg4 != null && this.O.j != null) {
                throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
            }

            if(this.O.i) {
                this.O.j = arg4;
            }

            if(arg4 == null) {
                return;
            }

            arg4.b();
        }
    }

    void a(int arg2, int arg3) {
        if(this.O != null || arg2 != 0 || arg3 != 0) {
            this.X();
            this.O.e = arg2;
            this.O.f = arg3;
        }
    }

    void a(int arg2) {
        if(this.O != null || arg2 != 0) {
            this.X().d = arg2;
        }
    }

    public static h a(Context arg4, String arg5, Bundle arg6) {
        Object v0_5;
        try {
            v0_5 = h.V.get(arg5);
            if(v0_5 == null) {
                Class v0_6 = arg4.getClassLoader().loadClass(arg5);
                h.V.put(arg5, v0_6);
            }

            v0_5 = ((Class)v0_5).getConstructor().newInstance();
            if(arg6 != null) {
                arg6.setClassLoader(v0_5.getClass().getClassLoader());
                ((h)v0_5).b(arg6);
            }
        }
        catch(InvocationTargetException v0) {
            throw new b("Unable to instantiate fragment " + arg5 + ": calling Fragment constructor caused an exception", ((Exception)v0));
        }
        catch(NoSuchMethodException v0_1) {
            throw new b("Unable to instantiate fragment " + arg5 + ": could not find Fragment constructor", ((Exception)v0_1));
        }
        catch(IllegalAccessException v0_2) {
            throw new b("Unable to instantiate fragment " + arg5 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", ((Exception)v0_2));
        }
        catch(InstantiationException v0_3) {
            throw new b("Unable to instantiate fragment " + arg5 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", ((Exception)v0_3));
        }
        catch(ClassNotFoundException v0_4) {
            throw new b("Unable to instantiate fragment " + arg5 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", ((Exception)v0_4));
        }

        return ((h)v0_5);
    }

    static boolean a(Context arg2, String arg3) {
        boolean v0_3;
        try {
            Object v0_1 = h.V.get(arg3);
            if(v0_1 == null) {
                Class v0_2 = arg2.getClassLoader().loadClass(arg3);
                h.V.put(arg3, v0_2);
            }

            v0_3 = h.class.isAssignableFrom(((Class)v0_1));
        }
        catch(ClassNotFoundException v0) {
            v0_3 = false;
        }

        return v0_3;
    }

    public android.arch.lifecycle.b a() {
        return this.U;
    }

    h a(String arg2) {
        if(!arg2.equals(this.f)) {
            this = this.t != null ? this.t.b(arg2) : null;
        }

        return this;
    }

    public View a(LayoutInflater arg2, ViewGroup arg3, Bundle arg4) {
        return null;
    }

    public Animation a(int arg2, boolean arg3, int arg4) {
        return null;
    }

    public void a(int arg1, int arg2, Intent arg3) {
    }

    final void a(int arg3, h arg4) {
        this.e = arg3;
        this.f = arg4 != null ? arg4.f + ":" + this.e : "android:fragment:" + this.e;
    }

    public void a(int arg1, String[] arg2, int[] arg3) {
    }

    void a(Animator arg2) {
        this.X().b = arg2;
    }

    @Deprecated public void a(Activity arg2) {
        this.F = true;
    }

    @Deprecated public void a(Activity arg2, AttributeSet arg3, Bundle arg4) {
        this.F = true;
    }

    public void a(Context arg3) {
        this.F = true;
        Activity v0 = this.s == null ? null : this.s.f();
        if(v0 != null) {
            this.F = false;
            this.a(v0);
        }
    }

    public void a(Context arg3, AttributeSet arg4, Bundle arg5) {
        this.F = true;
        Activity v0 = this.s == null ? null : this.s.f();
        if(v0 != null) {
            this.F = false;
            this.a(v0, arg4, arg5);
        }
    }

    void a(Configuration arg2) {
        this.onConfigurationChanged(arg2);
        if(this.t != null) {
            this.t.a(arg2);
        }
    }

    final void a(Bundle arg4) {
        if(this.d != null) {
            this.I.restoreHierarchyState(this.d);
            this.d = null;
        }

        this.F = false;
        this.i(arg4);
        if(!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void a(h arg1) {
    }

    public void a(Menu arg1) {
    }

    public void a(Menu arg1, MenuInflater arg2) {
    }

    void a(View arg2) {
        this.X().a = arg2;
    }

    public void a(View arg1, Bundle arg2) {
    }

    public void a(String arg4, FileDescriptor arg5, PrintWriter arg6, String[] arg7) {
        arg6.print(arg4);
        arg6.print("mFragmentId=#");
        arg6.print(Integer.toHexString(this.w));
        arg6.print(" mContainerId=#");
        arg6.print(Integer.toHexString(this.x));
        arg6.print(" mTag=");
        arg6.println(this.y);
        arg6.print(arg4);
        arg6.print("mState=");
        arg6.print(this.b);
        arg6.print(" mIndex=");
        arg6.print(this.e);
        arg6.print(" mWho=");
        arg6.print(this.f);
        arg6.print(" mBackStackNesting=");
        arg6.println(this.q);
        arg6.print(arg4);
        arg6.print("mAdded=");
        arg6.print(this.k);
        arg6.print(" mRemoving=");
        arg6.print(this.l);
        arg6.print(" mFromLayout=");
        arg6.print(this.m);
        arg6.print(" mInLayout=");
        arg6.println(this.n);
        arg6.print(arg4);
        arg6.print("mHidden=");
        arg6.print(this.z);
        arg6.print(" mDetached=");
        arg6.print(this.A);
        arg6.print(" mMenuVisible=");
        arg6.print(this.E);
        arg6.print(" mHasMenu=");
        arg6.println(this.D);
        arg6.print(arg4);
        arg6.print("mRetainInstance=");
        arg6.print(this.B);
        arg6.print(" mRetaining=");
        arg6.print(this.C);
        arg6.print(" mUserVisibleHint=");
        arg6.println(this.K);
        if(this.r != null) {
            arg6.print(arg4);
            arg6.print("mFragmentManager=");
            arg6.println(this.r);
        }

        if(this.s != null) {
            arg6.print(arg4);
            arg6.print("mHost=");
            arg6.println(this.s);
        }

        if(this.v != null) {
            arg6.print(arg4);
            arg6.print("mParentFragment=");
            arg6.println(this.v);
        }

        if(this.g != null) {
            arg6.print(arg4);
            arg6.print("mArguments=");
            arg6.println(this.g);
        }

        if(this.c != null) {
            arg6.print(arg4);
            arg6.print("mSavedFragmentState=");
            arg6.println(this.c);
        }

        if(this.d != null) {
            arg6.print(arg4);
            arg6.print("mSavedViewState=");
            arg6.println(this.d);
        }

        if(this.h != null) {
            arg6.print(arg4);
            arg6.print("mTarget=");
            arg6.print(this.h);
            arg6.print(" mTargetRequestCode=");
            arg6.println(this.j);
        }

        if(this.M() != 0) {
            arg6.print(arg4);
            arg6.print("mNextAnim=");
            arg6.println(this.M());
        }

        if(this.G != null) {
            arg6.print(arg4);
            arg6.print("mContainer=");
            arg6.println(this.G);
        }

        if(this.H != null) {
            arg6.print(arg4);
            arg6.print("mView=");
            arg6.println(this.H);
        }

        if(this.I != null) {
            arg6.print(arg4);
            arg6.print("mInnerView=");
            arg6.println(this.H);
        }

        if(this.R() != null) {
            arg6.print(arg4);
            arg6.print("mAnimatingAway=");
            arg6.println(this.R());
            arg6.print(arg4);
            arg6.print("mStateAfterAnimating=");
            arg6.println(this.T());
        }

        if(this.L != null) {
            arg6.print(arg4);
            arg6.println("Loader Manager:");
            this.L.a(arg4 + "  ", arg5, arg6, arg7);
        }

        if(this.t != null) {
            arg6.print(arg4);
            arg6.println("Child " + this.t + ":");
            this.t.a(arg4 + "  ", arg5, arg6, arg7);
        }
    }

    public void a(boolean arg1) {
    }

    public boolean a(MenuItem arg2) {
        return 0;
    }

    public void b(Bundle arg3) {
        if(this.e >= 0 && (this.c())) {
            throw new IllegalStateException("Fragment already active and state has been saved");
        }

        this.g = arg3;
    }

    static void b(h arg0) {
        arg0.W();
    }

    public Animator b(int arg2, boolean arg3, int arg4) {
        return null;
    }

    View b(LayoutInflater arg2, ViewGroup arg3, Bundle arg4) {
        if(this.t != null) {
            this.t.k();
        }

        this.p = true;
        return this.a(arg2, arg3, arg4);
    }

    void b(int arg2) {
        this.X().c = arg2;
    }

    public void b(Menu arg1) {
    }

    public void b(boolean arg1) {
    }

    final boolean b() {
        boolean v0 = this.q > 0 ? true : false;
        return v0;
    }

    boolean b(Menu arg3, MenuInflater arg4) {
        int v0 = 0;
        if(!this.z) {
            if((this.D) && (this.E)) {
                v0 = 1;
                this.a(arg3, arg4);
            }

            if(this.t == null) {
                goto label_14;
            }

            v0 |= this.t.a(arg3, arg4);
        }

    label_14:
        return ((boolean)v0);
    }

    public boolean b(MenuItem arg2) {
        return 0;
    }

    public final boolean c() {
        boolean v0 = this.r == null ? false : this.r.c();
        return v0;
    }

    public LayoutInflater c(Bundle arg2) {
        return this.e(arg2);
    }

    public void c(boolean arg1) {
    }

    boolean c(Menu arg3) {
        int v0 = 0;
        if(!this.z) {
            if((this.D) && (this.E)) {
                v0 = 1;
                this.a(arg3);
            }

            if(this.t == null) {
                goto label_14;
            }

            v0 |= this.t.a(arg3);
        }

    label_14:
        return ((boolean)v0);
    }

    boolean c(MenuItem arg3) {
        boolean v0 = true;
        if(!this.z) {
            if((this.D) && (this.E) && (this.a(arg3))) {
                return v0;
            }

            if(this.t == null) {
                goto label_15;
            }

            if(this.t.a(arg3)) {
                return v0;
            }

            goto label_15;
        }
        else {
        label_15:
            v0 = false;
        }

        return v0;
    }

    public final i d() {
        Activity v0_1;
        if(this.s == null) {
            i v0 = null;
        }
        else {
            v0_1 = this.s.f();
        }

        return ((i)v0_1);
    }

    LayoutInflater d(Bundle arg2) {
        this.S = this.c(arg2);
        return this.S;
    }

    void d(Menu arg2) {
        if(!this.z) {
            if((this.D) && (this.E)) {
                this.b(arg2);
            }

            if(this.t == null) {
                return;
            }

            this.t.b(arg2);
        }
    }

    void d(boolean arg2) {
        this.b(arg2);
        if(this.t != null) {
            this.t.a(arg2);
        }
    }

    boolean d(MenuItem arg3) {
        boolean v0 = true;
        if(this.z) {
        label_11:
            v0 = false;
        }
        else if(!this.b(arg3)) {
            if(this.t == null) {
                goto label_11;
            }
            else if(!this.t.b(arg3)) {
                goto label_11;
            }
        }

        return v0;
    }

    @Deprecated public LayoutInflater e(Bundle arg3) {
        if(this.s == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }

        LayoutInflater v0 = this.s.b();
        this.g();
        e.b(v0, this.t.w());
        return v0;
    }

    public final Resources e() {
        if(this.s == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }

        return this.s.g().getResources();
    }

    void e(boolean arg2) {
        this.c(arg2);
        if(this.t != null) {
            this.t.b(arg2);
        }
    }

    public final boolean equals(Object arg2) {
        return super.equals(arg2);
    }

    public final m f() {
        return this.r;
    }

    public void f(Bundle arg3) {
        this.F = true;
        this.g(arg3);
        if(this.t != null && !this.t.a(1)) {
            this.t.l();
        }
    }

    void f(boolean arg2) {
        this.X().k = arg2;
    }

    public final m g() {
        if(this.t == null) {
            this.B();
            if(this.b >= 5) {
                this.t.o();
            }
            else if(this.b >= 4) {
                this.t.n();
            }
            else if(this.b >= 2) {
                this.t.m();
            }
            else if(this.b >= 1) {
                this.t.l();
            }
        }

        return this.t;
    }

    void g(Bundle arg4) {
        if(arg4 != null) {
            Parcelable v0 = arg4.getParcelable("android:support:fragments");
            if(v0 != null) {
                if(this.t == null) {
                    this.B();
                }

                this.t.a(v0, this.u);
                this.u = null;
                this.t.l();
            }
        }
    }

    m h() {
        return this.t;
    }

    public void h(Bundle arg2) {
        this.F = true;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void i(Bundle arg2) {
        this.F = true;
    }

    public View i() {
        return this.H;
    }

    public void j() {
        this.F = true;
        if(!this.M) {
            this.M = true;
            if(!this.N) {
                this.N = true;
                this.L = this.s.a(this.f, this.M, false);
            }
            else if(this.L != null) {
                this.L.b();
            }
        }
    }

    public void j(Bundle arg1) {
    }

    public void k() {
        this.F = true;
    }

    void k(Bundle arg4) {
        if(this.t != null) {
            this.t.k();
        }

        this.b = 1;
        this.F = false;
        this.f(arg4);
        this.T = true;
        if(!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onCreate()");
        }

        this.U.a(android.arch.lifecycle.b$a.ON_CREATE);
    }

    public void l() {
        this.F = true;
    }

    void l(Bundle arg4) {
        if(this.t != null) {
            this.t.k();
        }

        this.b = 2;
        this.F = false;
        this.h(arg4);
        if(!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onActivityCreated()");
        }

        if(this.t != null) {
            this.t.m();
        }
    }

    public void m() {
        this.F = true;
    }

    void m(Bundle arg3) {
        this.j(arg3);
        if(this.t != null) {
            Parcelable v0 = this.t.j();
            if(v0 != null) {
                arg3.putParcelable("android:support:fragments", v0);
            }
        }
    }

    public void n() {
        this.F = true;
    }

    public void o() {
        this.F = true;
        if(!this.N) {
            this.N = true;
            this.L = this.s.a(this.f, this.M, false);
        }

        if(this.L != null) {
            this.L.h();
        }
    }

    public void onConfigurationChanged(Configuration arg2) {
        this.F = true;
    }

    public void onCreateContextMenu(ContextMenu arg2, View arg3, ContextMenu$ContextMenuInfo arg4) {
        this.d().onCreateContextMenu(arg2, arg3, arg4);
    }

    public void onLowMemory() {
        this.F = true;
    }

    void p() {
        this.e = -1;
        this.f = null;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.q = 0;
        this.r = null;
        this.t = null;
        this.s = null;
        this.w = 0;
        this.x = 0;
        this.y = null;
        this.z = false;
        this.A = false;
        this.C = false;
        this.L = null;
        this.M = false;
        this.N = false;
    }

    public void q() {
        this.F = true;
    }

    public void r() {
    }

    public Object s() {
        Object v0 = this.O == null ? null : a.a(this.O);
        return v0;
    }

    public Object t() {
        Object v0;
        if(this.O == null) {
            v0 = null;
        }
        else if(a.b(this.O) == h.a) {
            v0 = this.s();
        }
        else {
            v0 = a.b(this.O);
        }

        return v0;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x80);
        android.support.v4.g.d.a(this, v0);
        if(this.e >= 0) {
            v0.append(" #");
            v0.append(this.e);
        }

        if(this.w != 0) {
            v0.append(" id=0x");
            v0.append(Integer.toHexString(this.w));
        }

        if(this.y != null) {
            v0.append(" ");
            v0.append(this.y);
        }

        v0.append('}');
        return v0.toString();
    }

    public Object u() {
        Object v0 = this.O == null ? null : a.c(this.O);
        return v0;
    }

    public Object v() {
        Object v0;
        if(this.O == null) {
            v0 = null;
        }
        else if(a.d(this.O) == h.a) {
            v0 = this.u();
        }
        else {
            v0 = a.d(this.O);
        }

        return v0;
    }

    public Object w() {
        Object v0 = this.O == null ? null : a.e(this.O);
        return v0;
    }

    public Object x() {
        Object v0;
        if(this.O == null) {
            v0 = null;
        }
        else if(a.f(this.O) == h.a) {
            v0 = this.w();
        }
        else {
            v0 = a.f(this.O);
        }

        return v0;
    }

    public boolean y() {
        boolean v0 = this.O == null || a.g(this.O) == null ? true : a.g(this.O).booleanValue();
        return v0;
    }

    public boolean z() {
        boolean v0 = this.O == null || a.h(this.O) == null ? true : a.h(this.O).booleanValue();
        return v0;
    }
}

