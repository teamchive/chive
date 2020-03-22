package android.support.v4.b;

import android.support.v4.g.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class b {
    public interface a {
    }

    public interface android.support.v4.b.b$b {
    }

    int a;
    android.support.v4.b.b$b b;
    a c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;

    public void a(int arg3, android.support.v4.b.b$b arg4) {
        if(this.b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }

        this.b = arg4;
        this.a = arg3;
    }

    public void a(a arg3) {
        if(this.c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }

        this.c = arg3;
    }

    public final void a() {
        this.d = true;
        this.f = false;
        this.e = false;
        this.b();
    }

    public String a(Object arg3) {
        StringBuilder v0 = new StringBuilder(0x40);
        d.a(arg3, v0);
        v0.append("}");
        return v0.toString();
    }

    public void a(String arg2, FileDescriptor arg3, PrintWriter arg4, String[] arg5) {
        arg4.print(arg2);
        arg4.print("mId=");
        arg4.print(this.a);
        arg4.print(" mListener=");
        arg4.println(this.b);
        if((this.d) || (this.g) || (this.h)) {
            arg4.print(arg2);
            arg4.print("mStarted=");
            arg4.print(this.d);
            arg4.print(" mContentChanged=");
            arg4.print(this.g);
            arg4.print(" mProcessingChange=");
            arg4.println(this.h);
        }

        if((this.e) || (this.f)) {
            arg4.print(arg2);
            arg4.print("mAbandoned=");
            arg4.print(this.e);
            arg4.print(" mReset=");
            arg4.println(this.f);
        }
    }

    public void a(android.support.v4.b.b$b arg3) {
        if(this.b == null) {
            throw new IllegalStateException("No listener register");
        }

        if(this.b != arg3) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }

        this.b = null;
    }

    public void b(a arg3) {
        if(this.c == null) {
            throw new IllegalStateException("No listener register");
        }

        if(this.c != arg3) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }

        this.c = null;
    }

    protected void b() {
    }

    public void c() {
        this.d = false;
        this.d();
    }

    protected void d() {
    }

    public void e() {
        this.f();
        this.f = true;
        this.d = false;
        this.e = false;
        this.g = false;
        this.h = false;
    }

    protected void f() {
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x40);
        d.a(this, v0);
        v0.append(" id=");
        v0.append(this.a);
        v0.append("}");
        return v0.toString();
    }
}

