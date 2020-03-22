package android.support.v7.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class g extends BaseAdapter {
    static final int a;
    h b;
    private int c;
    private boolean d;
    private final boolean e;
    private final LayoutInflater f;

    static {
        g.a = android.support.v7.a.a$g.abc_popup_menu_item_layout;
    }

    public g(h arg2, LayoutInflater arg3, boolean arg4) {
        super();
        this.c = -1;
        this.e = arg4;
        this.f = arg3;
        this.b = arg2;
        this.b();
    }

    public j a(int arg3) {
        ArrayList v0 = this.e ? this.b.l() : this.b.i();
        if(this.c >= 0 && arg3 >= this.c) {
            ++arg3;
        }

        return v0.get(arg3);
    }

    public void a(boolean arg1) {
        this.d = arg1;
    }

    public h a() {
        return this.b;
    }

    void b() {
        j v2 = this.b.r();
        if(v2 != null) {
            ArrayList v3 = this.b.l();
            int v4 = v3.size();
            int v1 = 0;
            while(true) {
                if(v1 >= v4) {
                    goto label_16;
                }
                else if(v3.get(v1) == v2) {
                    this.c = v1;
                }
                else {
                    ++v1;
                    continue;
                }

                return;
            }
        }
        else {
        label_16:
            this.c = -1;
        }
    }

    public int getCount() {
        ArrayList v0 = this.e ? this.b.l() : this.b.i();
        int v0_1 = this.c < 0 ? v0.size() : v0.size() - 1;
        return v0_1;
    }

    public Object getItem(int arg2) {
        return this.a(arg2);
    }

    public long getItemId(int arg3) {
        return ((long)arg3);
    }

    public View getView(int arg6, View arg7, ViewGroup arg8) {
        View v1 = arg7 == null ? this.f.inflate(g.a, arg8, false) : arg7;
        View v0 = v1;
        if(this.d) {
            v1.setForceShowIcon(true);
        }

        ((a)v0).a(this.a(arg6), 0);
        return v1;
    }

    public void notifyDataSetChanged() {
        this.b();
        super.notifyDataSetChanged();
    }
}

