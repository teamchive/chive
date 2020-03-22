package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.a.a$g;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class f implements o, AdapterView$OnItemClickListener {
    class a extends BaseAdapter {
        private int b;

        public a(f arg2) {
            this.a = arg2;
            super();
            this.b = -1;
            this.a();
        }

        public j a(int arg4) {
            ArrayList v1 = this.a.c.l();
            int v0 = this.a.e + arg4;
            if(this.b >= 0 && v0 >= this.b) {
                ++v0;
            }

            return v1.get(v0);
        }

        void a() {
            j v2 = this.a.c.r();
            if(v2 != null) {
                ArrayList v3 = this.a.c.l();
                int v4 = v3.size();
                int v1 = 0;
                while(true) {
                    if(v1 >= v4) {
                        goto label_18;
                    }
                    else if(v3.get(v1) == v2) {
                        this.b = v1;
                    }
                    else {
                        ++v1;
                        continue;
                    }

                    return;
                }
            }
            else {
            label_18:
                this.b = -1;
            }
        }

        public int getCount() {
            int v0 = this.a.c.l().size() - this.a.e;
            if(this.b >= 0) {
                --v0;
            }

            return v0;
        }

        public Object getItem(int arg2) {
            return this.a(arg2);
        }

        public long getItemId(int arg3) {
            return ((long)arg3);
        }

        public View getView(int arg5, View arg6, ViewGroup arg7) {
            View v1 = arg6 == null ? this.a.b.inflate(this.a.g, arg7, false) : arg6;
            v1.a(this.a(arg5), 0);
            return v1;
        }

        public void notifyDataSetChanged() {
            this.a();
            super.notifyDataSetChanged();
        }
    }

    Context a;
    LayoutInflater b;
    h c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    a h;
    private android.support.v7.view.menu.o$a i;

    public f(Context arg2, int arg3) {
        this(arg3, 0);
        this.a = arg2;
        this.b = LayoutInflater.from(this.a);
    }

    public f(int arg1, int arg2) {
        super();
        this.g = arg1;
        this.f = arg2;
    }

    public void a(android.support.v7.view.menu.o$a arg1) {
        this.i = arg1;
    }

    public p a(ViewGroup arg4) {
        if(this.d == null) {
            this.d = this.b.inflate(g.abc_expanded_menu_layout, arg4, false);
            if(this.h == null) {
                this.h = new a(this);
            }

            this.d.setAdapter(this.h);
            this.d.setOnItemClickListener(((AdapterView$OnItemClickListener)this));
        }

        return this.d;
    }

    public ListAdapter a() {
        if(this.h == null) {
            this.h = new a(this);
        }

        return this.h;
    }

    public void a(Context arg3, h arg4) {
        if(this.f != 0) {
            this.a = new ContextThemeWrapper(arg3, this.f);
            this.b = LayoutInflater.from(this.a);
        }
        else if(this.a != null) {
            this.a = arg3;
            if(this.b == null) {
                this.b = LayoutInflater.from(this.a);
            }
        }

        this.c = arg4;
        if(this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public void a(h arg2, boolean arg3) {
        if(this.i != null) {
            this.i.a(arg2, arg3);
        }
    }

    public boolean a(h arg2, j arg3) {
        return 0;
    }

    public boolean a(u arg3) {
        boolean v0;
        if(!arg3.hasVisibleItems()) {
            v0 = false;
        }
        else {
            new i(((h)arg3)).a(null);
            if(this.i != null) {
                this.i.a(((h)arg3));
            }

            v0 = true;
        }

        return v0;
    }

    public void b(boolean arg2) {
        if(this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public boolean b() {
        return 0;
    }

    public boolean b(h arg2, j arg3) {
        return 0;
    }

    public void onItemClick(AdapterView arg4, View arg5, int arg6, long arg7) {
        this.c.a(this.h.a(arg6), ((o)this), 0);
    }
}

