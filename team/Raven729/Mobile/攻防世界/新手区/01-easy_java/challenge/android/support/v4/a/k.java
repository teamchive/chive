package android.support.v4.a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class k {
    private final l a;

    private k(l arg1) {
        super();
        this.a = arg1;
    }

    public static final k a(l arg1) {
        return new k(arg1);
    }

    public View a(View arg2, String arg3, Context arg4, AttributeSet arg5) {
        return this.a.d.onCreateView(arg2, arg3, arg4, arg5);
    }

    public void a(String arg2, FileDescriptor arg3, PrintWriter arg4, String[] arg5) {
        this.a.b(arg2, arg3, arg4, arg5);
    }

    public m a() {
        return this.a.i();
    }

    public h a(String arg2) {
        return this.a.d.b(arg2);
    }

    public void a(Configuration arg2) {
        this.a.d.a(arg2);
    }

    public void a(h arg4) {
        this.a.d.a(this.a, this.a, arg4);
    }

    public void a(android.support.v4.g.k arg2) {
        this.a.a(arg2);
    }

    public void a(Parcelable arg2, o arg3) {
        this.a.d.a(arg2, arg3);
    }

    public boolean a(Menu arg2, MenuInflater arg3) {
        return this.a.d.a(arg2, arg3);
    }

    public boolean a(MenuItem arg2) {
        return this.a.d.a(arg2);
    }

    public void a(boolean arg2) {
        this.a.d.a(arg2);
    }

    public boolean a(Menu arg2) {
        return this.a.d.a(arg2);
    }

    public void b() {
        this.a.d.k();
    }

    public boolean b(MenuItem arg2) {
        return this.a.d.b(arg2);
    }

    public void b(Menu arg2) {
        this.a.d.b(arg2);
    }

    public void b(boolean arg2) {
        this.a.d.b(arg2);
    }

    public void c(boolean arg2) {
        this.a.a(arg2);
    }

    public Parcelable c() {
        return this.a.d.j();
    }

    public o d() {
        return this.a.d.h();
    }

    public void e() {
        this.a.d.l();
    }

    public void f() {
        this.a.d.m();
    }

    public void g() {
        this.a.d.n();
    }

    public void h() {
        this.a.d.o();
    }

    public void i() {
        this.a.d.p();
    }

    public void j() {
        this.a.d.q();
    }

    public void k() {
        this.a.d.r();
    }

    public void l() {
        this.a.d.t();
    }

    public void m() {
        this.a.d.u();
    }

    public boolean n() {
        return this.a.d.e();
    }

    public void o() {
        this.a.k();
    }

    public void p() {
        this.a.l();
    }

    public void q() {
        this.a.m();
    }

    public android.support.v4.g.k r() {
        return this.a.n();
    }
}

