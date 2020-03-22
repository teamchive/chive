package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.support.v4.a.ab$a;
import android.support.v4.a.ab;
import android.support.v4.a.i;
import android.support.v4.a.w;
import android.support.v7.view.b;
import android.support.v7.widget.bb;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.Window;

public class c extends i implements a, d {
    private e l;
    private int m;
    private Resources n;

    public c() {
        super();
        this.m = 0;
    }

    private boolean a(int arg3, KeyEvent arg4) {
        boolean v0_1;
        if(Build$VERSION.SDK_INT >= 26 || (arg4.isCtrlPressed()) || (KeyEvent.metaStateHasNoModifiers(arg4.getMetaState())) || arg4.getRepeatCount() != 0 || (KeyEvent.isModifierKey(arg4.getKeyCode()))) {
        label_22:
            v0_1 = false;
        }
        else {
            Window v0 = this.getWindow();
            if(v0 == null) {
                goto label_22;
            }
            else if(v0.getDecorView() == null) {
                goto label_22;
            }
            else if(v0.getDecorView().dispatchKeyShortcutEvent(arg4)) {
                v0_1 = true;
            }
            else {
                goto label_22;
            }
        }

        return v0_1;
    }

    public b a(android.support.v7.view.b$a arg2) {
        return null;
    }

    public void a(ab arg1) {
        arg1.a(((Activity)this));
    }

    public void a(b arg1) {
    }

    public boolean a(Intent arg2) {
        return w.a(((Activity)this), arg2);
    }

    public Intent a_() {
        return w.a(((Activity)this));
    }

    public void addContentView(View arg2, ViewGroup$LayoutParams arg3) {
        this.j().b(arg2, arg3);
    }

    public void b(Intent arg1) {
        w.b(((Activity)this), arg1);
    }

    public void b(ab arg1) {
    }

    public void b(b arg1) {
    }

    public void closeOptionsMenu() {
        android.support.v7.app.a v0 = this.g();
        if((this.getWindow().hasFeature(0)) && (v0 == null || !v0.d())) {
            super.closeOptionsMenu();
        }
    }

    public void d() {
        this.j().f();
    }

    public boolean dispatchKeyEvent(KeyEvent arg4) {
        int v0 = arg4.getKeyCode();
        android.support.v7.app.a v1 = this.g();
        boolean v0_1 = v0 != 82 || v1 == null || !v1.a(arg4) ? super.dispatchKeyEvent(arg4) : true;
        return v0_1;
    }

    public View findViewById(int arg2) {
        return this.j().a(arg2);
    }

    public android.support.v7.app.a g() {
        return this.j().a();
    }

    public MenuInflater getMenuInflater() {
        return this.j().b();
    }

    public Resources getResources() {
        if(this.n == null && (bb.a())) {
            this.n = new bb(((Context)this), super.getResources());
        }

        Resources v0 = this.n == null ? super.getResources() : this.n;
        return v0;
    }

    public boolean h() {
        boolean v0_3;
        Intent v0 = this.a_();
        if(v0 != null) {
            if(this.a(v0)) {
                ab v0_1 = ab.a(((Context)this));
                this.a(v0_1);
                this.b(v0_1);
                v0_1.a();
                try {
                    android.support.v4.a.a.a(((Activity)this));
                }
                catch(IllegalStateException v0_2) {
                    this.finish();
                }
            }
            else {
                this.b(v0);
            }

            v0_3 = true;
        }
        else {
            v0_3 = false;
        }

        return v0_3;
    }

    @Deprecated public void i() {
    }

    public void invalidateOptionsMenu() {
        this.j().f();
    }

    public e j() {
        if(this.l == null) {
            this.l = e.a(((Activity)this), ((d)this));
        }

        return this.l;
    }

    public void onConfigurationChanged(Configuration arg3) {
        super.onConfigurationChanged(arg3);
        this.j().a(arg3);
        if(this.n != null) {
            this.n.updateConfiguration(arg3, super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        this.i();
    }

    protected void onCreate(Bundle arg4) {
        e v0 = this.j();
        v0.h();
        v0.a(arg4);
        if((v0.i()) && this.m != 0) {
            if(Build$VERSION.SDK_INT >= 23) {
                this.onApplyThemeResource(this.getTheme(), this.m, false);
            }
            else {
                this.setTheme(this.m);
            }
        }

        super.onCreate(arg4);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.j().g();
    }

    public boolean onKeyDown(int arg2, KeyEvent arg3) {
        boolean v0 = this.a(arg2, arg3) ? true : super.onKeyDown(arg2, arg3);
        return v0;
    }

    public final boolean onMenuItemSelected(int arg4, MenuItem arg5) {
        boolean v0;
        if(super.onMenuItemSelected(arg4, arg5)) {
            v0 = true;
        }
        else {
            android.support.v7.app.a v0_1 = this.g();
            if(arg5.getItemId() == 0x102002C && v0_1 != null && (v0_1.a() & 4) != 0) {
                return this.h();
            }

            v0 = false;
        }

        return v0;
    }

    public boolean onMenuOpened(int arg2, Menu arg3) {
        return super.onMenuOpened(arg2, arg3);
    }

    public void onPanelClosed(int arg1, Menu arg2) {
        super.onPanelClosed(arg1, arg2);
    }

    protected void onPostCreate(Bundle arg2) {
        super.onPostCreate(arg2);
        this.j().b(arg2);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.j().e();
    }

    protected void onSaveInstanceState(Bundle arg2) {
        super.onSaveInstanceState(arg2);
        this.j().c(arg2);
    }

    protected void onStart() {
        super.onStart();
        this.j().c();
    }

    protected void onStop() {
        super.onStop();
        this.j().d();
    }

    protected void onTitleChanged(CharSequence arg2, int arg3) {
        super.onTitleChanged(arg2, arg3);
        this.j().a(arg2);
    }

    public void openOptionsMenu() {
        android.support.v7.app.a v0 = this.g();
        if((this.getWindow().hasFeature(0)) && (v0 == null || !v0.c())) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int arg2) {
        this.j().b(arg2);
    }

    public void setContentView(View arg2) {
        this.j().a(arg2);
    }

    public void setContentView(View arg2, ViewGroup$LayoutParams arg3) {
        this.j().a(arg2, arg3);
    }

    public void setTheme(int arg1) {
        super.setTheme(arg1);
        this.m = arg1;
    }
}

