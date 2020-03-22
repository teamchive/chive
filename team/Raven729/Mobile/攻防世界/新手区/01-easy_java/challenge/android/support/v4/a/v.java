package android.support.v4.a;

import android.os.Bundle;
import android.support.v4.b.b$b;
import android.support.v4.g.d;
import android.support.v4.g.l;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class v extends u {
    final class a implements android.support.v4.b.b$a, b {
        final int a;
        final Bundle b;
        android.support.v4.a.u$a c;
        android.support.v4.b.b d;
        boolean e;
        boolean f;
        Object g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        a n;

        public void a(String arg4, FileDescriptor arg5, PrintWriter arg6, String[] arg7) {
            arg6.print(arg4);
            arg6.print("mId=");
            arg6.print(this.a);
            arg6.print(" mArgs=");
            arg6.println(this.b);
            arg6.print(arg4);
            arg6.print("mCallbacks=");
            arg6.println(this.c);
            arg6.print(arg4);
            arg6.print("mLoader=");
            arg6.println(this.d);
            if(this.d != null) {
                this.d.a(arg4 + "  ", arg5, arg6, arg7);
            }

            if((this.e) || (this.f)) {
                arg6.print(arg4);
                arg6.print("mHaveData=");
                arg6.print(this.e);
                arg6.print("  mDeliveredData=");
                arg6.println(this.f);
                arg6.print(arg4);
                arg6.print("mData=");
                arg6.println(this.g);
            }

            arg6.print(arg4);
            arg6.print("mStarted=");
            arg6.print(this.h);
            arg6.print(" mReportNextStart=");
            arg6.print(this.k);
            arg6.print(" mDestroyed=");
            arg6.println(this.l);
            arg6.print(arg4);
            arg6.print("mRetaining=");
            arg6.print(this.i);
            arg6.print(" mRetainingStarted=");
            arg6.print(this.j);
            arg6.print(" mListenerRegistered=");
            arg6.println(this.m);
            if(this.n != null) {
                arg6.print(arg4);
                arg6.println("Pending Loader ");
                arg6.print(this.n);
                arg6.println(":");
                this.n.a(arg4 + "  ", arg5, arg6, arg7);
            }
        }

        void a() {
            if((this.i) && (this.j)) {
                this.h = true;
            }
            else if(!this.h) {
                this.h = true;
                if(v.a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }

                if(this.d == null && this.c != null) {
                    this.d = this.c.a(this.a, this.b);
                }

                if(this.d == null) {
                    return;
                }

                if((this.d.getClass().isMemberClass()) && !Modifier.isStatic(this.d.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.d);
                }

                if(!this.m) {
                    this.d.a(this.a, ((b)this));
                    this.d.a(((android.support.v4.b.b$a)this));
                    this.m = true;
                }

                this.d.a();
            }
        }

        void a(android.support.v4.b.b arg5, Object arg6) {
            String v1;
            if(this.c != null) {
                String v0 = null;
                if(this.o.g != null) {
                    v0 = this.o.g.d.u;
                    this.o.g.d.u = "onLoadFinished";
                    v1 = v0;
                }
                else {
                    v1 = v0;
                }

                try {
                    if(v.a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + arg5 + ": " + arg5.a(arg6));
                    }

                    this.c.a(arg5, arg6);
                }
                catch(Throwable v0_1) {
                    if(this.o.g != null) {
                        this.o.g.d.u = v1;
                    }

                    throw v0_1;
                }

                if(this.o.g != null) {
                    this.o.g.d.u = v1;
                }

                this.f = true;
            }
        }

        void b() {
            if(v.a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }

            this.i = true;
            this.j = this.h;
            this.h = false;
            this.c = null;
        }

        void c() {
            if(this.i) {
                if(v.a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }

                this.i = false;
                if(this.h == this.j) {
                    goto label_20;
                }

                if(this.h) {
                    goto label_20;
                }

                this.e();
            }

        label_20:
            if((this.h) && (this.e) && !this.k) {
                this.a(this.d, this.g);
            }
        }

        void d() {
            if((this.h) && (this.k)) {
                this.k = false;
                if((this.e) && !this.i) {
                    this.a(this.d, this.g);
                }
            }
        }

        void e() {
            if(v.a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }

            this.h = false;
            if(!this.i && this.d != null && (this.m)) {
                this.m = false;
                this.d.a(((b)this));
                this.d.b(((android.support.v4.b.b$a)this));
                this.d.c();
            }
        }

        void f() {
            String v1;
            android.support.v4.a.u$a v2 = null;
            if(v.a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }

            this.l = true;
            boolean v0 = this.f;
            this.f = false;
            if(this.c != null && this.d != null && (this.e) && (v0)) {
                if(v.a) {
                    Log.v("LoaderManager", "  Resetting: " + this);
                }

                if(this.o.g != null) {
                    String v0_1 = this.o.g.d.u;
                    this.o.g.d.u = "onLoaderReset";
                    v1 = v0_1;
                }
                else {
                    v1 = ((String)v2);
                }

                try {
                    this.c.a(this.d);
                }
                catch(Throwable v0_2) {
                    if(this.o.g != null) {
                        this.o.g.d.u = v1;
                    }

                    throw v0_2;
                }

                if(this.o.g == null) {
                    goto label_56;
                }

                this.o.g.d.u = v1;
            }

        label_56:
            this.c = v2;
            this.g = v2;
            this.e = false;
            if(this.d != null) {
                if(this.m) {
                    this.m = false;
                    this.d.a(((b)this));
                    this.d.b(((android.support.v4.b.b$a)this));
                }

                this.d.e();
            }

            if(this.n != null) {
                this.n.f();
            }
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder(0x40);
            v0.append("LoaderInfo{");
            v0.append(Integer.toHexString(System.identityHashCode(this)));
            v0.append(" #");
            v0.append(this.a);
            v0.append(" : ");
            d.a(this.d, v0);
            v0.append("}}");
            return v0.toString();
        }
    }

    static boolean a;
    final l b;
    final l c;
    final String d;
    boolean e;
    boolean f;
    android.support.v4.a.l g;

    static {
        v.a = false;
    }

    v(String arg2, android.support.v4.a.l arg3, boolean arg4) {
        super();
        this.b = new l();
        this.c = new l();
        this.d = arg2;
        this.g = arg3;
        this.e = arg4;
    }

    public void a(String arg6, FileDescriptor arg7, PrintWriter arg8, String[] arg9) {
        Object v0;
        int v2 = 0;
        if(this.b.b() > 0) {
            arg8.print(arg6);
            arg8.println("Active Loaders:");
            String v3 = arg6 + "    ";
            int v1;
            for(v1 = 0; v1 < this.b.b(); ++v1) {
                v0 = this.b.e(v1);
                arg8.print(arg6);
                arg8.print("  #");
                arg8.print(this.b.d(v1));
                arg8.print(": ");
                arg8.println(((a)v0).toString());
                ((a)v0).a(v3, arg7, arg8, arg9);
            }
        }

        if(this.c.b() > 0) {
            arg8.print(arg6);
            arg8.println("Inactive Loaders:");
            String v1_1 = arg6 + "    ";
            while(v2 < this.c.b()) {
                v0 = this.c.e(v2);
                arg8.print(arg6);
                arg8.print("  #");
                arg8.print(this.c.d(v2));
                arg8.print(": ");
                arg8.println(((a)v0).toString());
                ((a)v0).a(v1_1, arg7, arg8, arg9);
                ++v2;
            }
        }
    }

    void a(android.support.v4.a.l arg1) {
        this.g = arg1;
    }

    public boolean a() {
        int v4 = this.b.b();
        int v2 = 0;
        int v3 = 0;
        while(v2 < v4) {
            Object v0 = this.b.e(v2);
            int v0_1 = !((a)v0).h || (((a)v0).f) ? 0 : 1;
            v3 |= v0_1;
            ++v2;
        }

        return ((boolean)v3);
    }

    void b() {
        if(v.a) {
            Log.v("LoaderManager", "Starting in " + this);
        }

        if(this.e) {
            RuntimeException v0 = new RuntimeException("here");
            v0.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, ((Throwable)v0));
        }
        else {
            this.e = true;
            int v1;
            for(v1 = this.b.b() - 1; v1 >= 0; --v1) {
                this.b.e(v1).a();
            }
        }
    }

    void c() {
        if(v.a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }

        if(!this.e) {
            RuntimeException v0 = new RuntimeException("here");
            v0.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, ((Throwable)v0));
        }
        else {
            int v1;
            for(v1 = this.b.b() - 1; v1 >= 0; --v1) {
                this.b.e(v1).e();
            }

            this.e = false;
        }
    }

    void d() {
        if(v.a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }

        if(!this.e) {
            RuntimeException v0 = new RuntimeException("here");
            v0.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, ((Throwable)v0));
        }
        else {
            this.f = true;
            this.e = false;
            int v1;
            for(v1 = this.b.b() - 1; v1 >= 0; --v1) {
                this.b.e(v1).b();
            }
        }
    }

    void e() {
        if(this.f) {
            if(v.a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }

            this.f = false;
            int v1;
            for(v1 = this.b.b() - 1; v1 >= 0; --v1) {
                this.b.e(v1).c();
            }
        }
    }

    void f() {
        int v1;
        for(v1 = this.b.b() - 1; v1 >= 0; --v1) {
            this.b.e(v1).k = true;
        }
    }

    void g() {
        int v1;
        for(v1 = this.b.b() - 1; v1 >= 0; --v1) {
            this.b.e(v1).d();
        }
    }

    void h() {
        if(!this.f) {
            if(v.a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }

            int v1;
            for(v1 = this.b.b() - 1; v1 >= 0; --v1) {
                this.b.e(v1).f();
            }

            this.b.c();
        }

        if(v.a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }

        for(v1 = this.c.b() - 1; v1 >= 0; --v1) {
            this.c.e(v1).f();
        }

        this.c.c();
        this.g = null;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x80);
        v0.append("LoaderManager{");
        v0.append(Integer.toHexString(System.identityHashCode(this)));
        v0.append(" in ");
        d.a(this.g, v0);
        v0.append("}}");
        return v0.toString();
    }
}

