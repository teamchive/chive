package android.support.v4.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.g.k;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class l extends j {
    private final Activity a;
    final Context b;
    final int c;
    final n d;
    private final Handler e;
    private k f;
    private boolean g;
    private v h;
    private boolean i;
    private boolean j;

    l(Activity arg2, Context arg3, Handler arg4, int arg5) {
        super();
        this.d = new n();
        this.a = arg2;
        this.b = arg3;
        this.e = arg4;
        this.c = arg5;
    }

    l(i arg3) {
        this(((Activity)arg3), ((Context)arg3), arg3.c, 0);
    }

    v a(String arg3, boolean arg4, boolean arg5) {
        v v0_1;
        if(this.f == null) {
            this.f = new k();
        }

        Object v0 = this.f.get(arg3);
        if(v0 == null && (arg5)) {
            v0_1 = new v(arg3, this, arg4);
            this.f.put(arg3, v0_1);
        }
        else if((arg4) && v0 != null && !((v)v0).e) {
            ((v)v0).b();
        }

        return v0_1;
    }

    public View a(int arg2) {
        return null;
    }

    void a(k arg4) {
        if(arg4 != null) {
            int v2 = arg4.size();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                arg4.c(v1).a(this);
            }
        }

        this.f = arg4;
    }

    void a(String arg3) {
        if(this.f != null) {
            Object v0 = this.f.get(arg3);
            if(v0 != null && !((v)v0).f) {
                ((v)v0).h();
                this.f.remove(arg3);
            }
        }
    }

    public void a(String arg1, FileDescriptor arg2, PrintWriter arg3, String[] arg4) {
    }

    void a(boolean arg2) {
        this.g = arg2;
        if(this.h != null && (this.j)) {
            this.j = false;
            if(arg2) {
                this.h.d();
            }
            else {
                this.h.c();
            }
        }
    }

    public boolean a() {
        return 1;
    }

    public boolean a(h arg2) {
        return 1;
    }

    public LayoutInflater b() {
        return this.b.getSystemService("layout_inflater");
    }

    void b(h arg1) {
    }

    void b(String arg4, FileDescriptor arg5, PrintWriter arg6, String[] arg7) {
        arg6.print(arg4);
        arg6.print("mLoadersStarted=");
        arg6.println(this.j);
        if(this.h != null) {
            arg6.print(arg4);
            arg6.print("Loader Manager ");
            arg6.print(Integer.toHexString(System.identityHashCode(this.h)));
            arg6.println(":");
            this.h.a(arg4 + "  ", arg5, arg6, arg7);
        }
    }

    public void c() {
    }

    public boolean d() {
        return 1;
    }

    public int e() {
        return this.c;
    }

    Activity f() {
        return this.a;
    }

    Context g() {
        return this.b;
    }

    Handler h() {
        return this.e;
    }

    n i() {
        return this.d;
    }

    boolean j() {
        return this.g;
    }

    void k() {
        if(!this.j) {
            this.j = true;
            if(this.h != null) {
                this.h.b();
            }
            else if(!this.i) {
                this.h = this.a("(root)", this.j, false);
                if(this.h != null && !this.h.e) {
                    this.h.b();
                }
            }

            this.i = true;
        }
    }

    void l() {
        if(this.h != null) {
            this.h.h();
        }
    }

    void m() {
        if(this.f != null) {
            int v2 = this.f.size();
            v[] v3 = new v[v2];
            int v1;
            for(v1 = v2 - 1; v1 >= 0; --v1) {
                v3[v1] = this.f.c(v1);
            }

            int v0;
            for(v0 = 0; v0 < v2; ++v0) {
                v v1_1 = v3[v0];
                v1_1.e();
                v1_1.g();
            }
        }
    }

    k n() {
        int v0;
        int v1 = 0;
        if(this.f != null) {
            int v3 = this.f.size();
            v[] v4 = new v[v3];
            int v2;
            for(v2 = v3 - 1; v2 >= 0; --v2) {
                v4[v2] = this.f.c(v2);
            }

            boolean v2_1 = this.j();
            v0 = 0;
            while(v1 < v3) {
                v v5 = v4[v1];
                if(!v5.f && (v2_1)) {
                    if(!v5.e) {
                        v5.b();
                    }

                    v5.d();
                }

                if(v5.f) {
                    v0 = 1;
                }
                else {
                    v5.h();
                    this.f.remove(v5.d);
                }

                ++v1;
            }
        }
        else {
            v0 = 0;
        }

        k v0_1 = v0 != 0 ? this.f : null;
        return v0_1;
    }
}

