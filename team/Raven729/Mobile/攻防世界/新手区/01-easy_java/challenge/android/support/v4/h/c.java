package android.support.v4.h;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class c {
    public interface a {
        void a(boolean arg1);
    }

    public interface b {
        void a(boolean arg1);
    }

    private final Context a;
    private a b;
    private b c;

    public c(Context arg1) {
        super();
        this.a = arg1;
    }

    public abstract View a();

    public View a(MenuItem arg2) {
        return this.a();
    }

    public void a(a arg1) {
        this.b = arg1;
    }

    public void a(b arg4) {
        if(this.c != null && arg4 != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + this.getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }

        this.c = arg4;
    }

    public void a(SubMenu arg1) {
    }

    public void a(boolean arg2) {
        if(this.b != null) {
            this.b.a(arg2);
        }
    }

    public boolean b() {
        return 0;
    }

    public boolean c() {
        return 1;
    }

    public boolean d() {
        return 0;
    }

    public boolean e() {
        return 0;
    }

    public void f() {
        this.c = null;
        this.b = null;
    }
}

