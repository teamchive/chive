package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.os.Build$VERSION;
import android.support.v7.a.a$i;
import android.view.LayoutInflater;

public class d extends ContextWrapper {
    private int a;
    private Resources$Theme b;
    private LayoutInflater c;
    private Configuration d;
    private Resources e;

    public d(Context arg1, int arg2) {
        super(arg1);
        this.a = arg2;
    }

    public d() {
        super(null);
    }

    public d(Context arg1, Resources$Theme arg2) {
        super(arg1);
        this.b = arg2;
    }

    public int a() {
        return this.a;
    }

    protected void a(Resources$Theme arg2, int arg3, boolean arg4) {
        arg2.applyStyle(arg3, true);
    }

    protected void attachBaseContext(Context arg1) {
        super.attachBaseContext(arg1);
    }

    private Resources b() {
        if(this.e == null) {
            if(this.d == null) {
                this.e = super.getResources();
            }
            else if(Build$VERSION.SDK_INT >= 17) {
                this.e = this.createConfigurationContext(this.d).getResources();
            }
        }

        return this.e;
    }

    private void c() {
        boolean v0 = this.b == null ? true : false;
        if(v0) {
            this.b = this.getResources().newTheme();
            Resources$Theme v1 = this.getBaseContext().getTheme();
            if(v1 != null) {
                this.b.setTo(v1);
            }
        }

        this.a(this.b, this.a, v0);
    }

    public AssetManager getAssets() {
        return this.getResources().getAssets();
    }

    public Resources getResources() {
        return this.b();
    }

    public Object getSystemService(String arg2) {
        Object v0_1;
        if("layout_inflater".equals(arg2)) {
            if(this.c == null) {
                this.c = LayoutInflater.from(this.getBaseContext()).cloneInContext(((Context)this));
            }

            LayoutInflater v0 = this.c;
        }
        else {
            v0_1 = this.getBaseContext().getSystemService(arg2);
        }

        return v0_1;
    }

    public Resources$Theme getTheme() {
        Resources$Theme v0;
        if(this.b != null) {
            v0 = this.b;
        }
        else {
            if(this.a == 0) {
                this.a = i.Theme_AppCompat_Light;
            }

            this.c();
            v0 = this.b;
        }

        return v0;
    }

    public void setTheme(int arg2) {
        if(this.a != arg2) {
            this.a = arg2;
            this.c();
        }
    }
}

