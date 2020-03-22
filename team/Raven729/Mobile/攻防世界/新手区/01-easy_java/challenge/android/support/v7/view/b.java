package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class b {
    public interface a {
        boolean a(b arg1, Menu arg2);

        void a(b arg1);

        boolean a(b arg1, MenuItem arg2);

        boolean b(b arg1, Menu arg2);
    }

    private Object a;
    private boolean b;

    public b() {
        super();
    }

    public abstract MenuInflater a();

    public abstract void a(int arg1);

    public abstract void a(View arg1);

    public abstract void a(CharSequence arg1);

    public void a(Object arg1) {
        this.a = arg1;
    }

    public void a(boolean arg1) {
        this.b = arg1;
    }

    public abstract Menu b();

    public abstract void b(int arg1);

    public abstract void b(CharSequence arg1);

    public abstract void c();

    public abstract void d();

    public abstract CharSequence f();

    public abstract CharSequence g();

    public boolean h() {
        return 0;
    }

    public abstract View i();

    public Object j() {
        return this.a;
    }

    public boolean k() {
        return this.b;
    }
}

