package android.support.v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

public abstract class b implements o {
    protected Context a;
    protected Context b;
    protected h c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    protected p f;
    private a g;
    private int h;
    private int i;
    private int j;

    public b(Context arg2, int arg3, int arg4) {
        super();
        this.a = arg2;
        this.d = LayoutInflater.from(arg2);
        this.h = arg3;
        this.i = arg4;
    }

    public a a() {
        return this.g;
    }

    public p a(ViewGroup arg4) {
        if(this.f == null) {
            this.f = this.d.inflate(this.h, arg4, false);
            this.f.a(this.c);
            this.b(true);
        }

        return this.f;
    }

    public View a(j arg2, View arg3, ViewGroup arg4) {
        android.support.v7.view.menu.p$a v0_1;
        if((arg3 instanceof android.support.v7.view.menu.p$a)) {
            View v0 = arg3;
        }
        else {
            v0_1 = this.b(arg4);
        }

        this.a(arg2, v0_1);
        return ((View)v0_1);
    }

    public abstract void a(j arg1, android.support.v7.view.menu.p$a arg2);

    public void a(int arg1) {
        this.j = arg1;
    }

    public void a(Context arg2, h arg3) {
        this.b = arg2;
        this.e = LayoutInflater.from(this.b);
        this.c = arg3;
    }

    public void a(h arg2, boolean arg3) {
        if(this.g != null) {
            this.g.a(arg2, arg3);
        }
    }

    public void a(a arg1) {
        this.g = arg1;
    }

    protected void a(View arg2, int arg3) {
        ViewParent v0 = arg2.getParent();
        if(v0 != null) {
            ((ViewGroup)v0).removeView(arg2);
        }

        this.f.addView(arg2, arg3);
    }

    public boolean a(int arg2, j arg3) {
        return 1;
    }

    public boolean a(h arg2, j arg3) {
        return 0;
    }

    public boolean a(u arg2) {
        boolean v0 = this.g != null ? this.g.a(((h)arg2)) : false;
        return v0;
    }

    protected boolean a(ViewGroup arg2, int arg3) {
        arg2.removeViewAt(arg3);
        return 1;
    }

    public void b(boolean arg11) {
        int v1_1;
        p v0 = this.f;
        if(v0 != null) {
            if(this.c != null) {
                this.c.j();
                ArrayList v7 = this.c.i();
                int v8 = v7.size();
                int v6 = 0;
                int v4;
                for(v4 = 0; v6 < v8; v4 = v1_1) {
                    Object v1 = v7.get(v6);
                    if(this.a(v4, ((j)v1))) {
                        View v3 = ((ViewGroup)v0).getChildAt(v4);
                        if((v3 instanceof android.support.v7.view.menu.p$a)) {
                            j v2 = v3.getItemData();
                        }
                        else {
                            Object v2_1 = null;
                        }

                        View v9 = this.a(((j)v1), v3, ((ViewGroup)v0));
                        if(v1 != v2) {
                            v9.setPressed(false);
                            v9.jumpDrawablesToCurrentState();
                        }

                        if(v9 != v3) {
                            this.a(v9, v4);
                        }

                        v1_1 = v4 + 1;
                    }
                    else {
                        v1_1 = v4;
                    }

                    ++v6;
                }
            }
            else {
                v4 = 0;
            }

            while(v4 < ((ViewGroup)v0).getChildCount()) {
                if(this.a(((ViewGroup)v0), v4)) {
                    continue;
                }

                ++v4;
            }
        }
    }

    public android.support.v7.view.menu.p$a b(ViewGroup arg4) {
        return this.d.inflate(this.i, arg4, false);
    }

    public boolean b() {
        return 0;
    }

    public boolean b(h arg2, j arg3) {
        return 0;
    }
}

