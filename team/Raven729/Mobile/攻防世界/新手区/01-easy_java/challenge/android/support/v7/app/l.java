package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.a.a$a;
import android.support.v7.view.b;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup$LayoutParams;

public class l extends Dialog implements d {
    private e a;

    public l(Context arg3, int arg4) {
        super(arg3, l.a(arg3, arg4));
        this.a().a(null);
        this.a().i();
    }

    public boolean a(int arg2) {
        return this.a().c(arg2);
    }

    private static int a(Context arg4, int arg5) {
        if(arg5 == 0) {
            TypedValue v0 = new TypedValue();
            arg4.getTheme().resolveAttribute(a.dialogTheme, v0, true);
            arg5 = v0.resourceId;
        }

        return arg5;
    }

    public e a() {
        if(this.a == null) {
            this.a = e.a(((Dialog)this), ((d)this));
        }

        return this.a;
    }

    public b a(android.support.v7.view.b$a arg2) {
        return null;
    }

    public void a(b arg1) {
    }

    public void addContentView(View arg2, ViewGroup$LayoutParams arg3) {
        this.a().b(arg2, arg3);
    }

    public void b(b arg1) {
    }

    public View findViewById(int arg2) {
        return this.a().a(arg2);
    }

    public void invalidateOptionsMenu() {
        this.a().f();
    }

    protected void onCreate(Bundle arg2) {
        this.a().h();
        super.onCreate(arg2);
        this.a().a(arg2);
    }

    protected void onStop() {
        super.onStop();
        this.a().d();
    }

    public void setContentView(int arg2) {
        this.a().b(arg2);
    }

    public void setContentView(View arg2) {
        this.a().a(arg2);
    }

    public void setContentView(View arg2, ViewGroup$LayoutParams arg3) {
        this.a().a(arg2, arg3);
    }

    public void setTitle(int arg3) {
        super.setTitle(arg3);
        this.a().a(this.getContext().getString(arg3));
    }

    public void setTitle(CharSequence arg2) {
        super.setTitle(arg2);
        this.a().a(arg2);
    }
}

