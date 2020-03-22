package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow$OnDismissListener;

abstract class m implements o, s, AdapterView$OnItemClickListener {
    private Rect a;

    m() {
        super();
    }

    protected static int a(ListAdapter arg10, ViewGroup arg11, Context arg12, int arg13) {
        FrameLayout v2_1;
        View v5 = null;
        int v7 = View$MeasureSpec.makeMeasureSpec(0, 0);
        int v8 = View$MeasureSpec.makeMeasureSpec(0, 0);
        int v9 = arg10.getCount();
        int v6 = 0;
        int v3 = 0;
        View v4 = v5;
        int v1 = 0;
        ViewGroup v0 = arg11;
        while(v6 < v9) {
            int v2 = arg10.getItemViewType(v6);
            if(v2 != v3) {
                v3 = v2;
                v4 = v5;
            }

            if(v0 == null) {
                v2_1 = new FrameLayout(arg12);
            }
            else {
                ViewGroup v2_2 = v0;
            }

            v4 = arg10.getView(v6, v4, ((ViewGroup)v2_1));
            v4.measure(v7, v8);
            int v0_1 = v4.getMeasuredWidth();
            if(v0_1 >= arg13) {
                return arg13;
            }

            if(v0_1 <= v1) {
                v0_1 = v1;
            }

            ++v6;
            v1 = v0_1;
            FrameLayout v0_2 = v2_1;
        }

        return v1;
    }

    protected static g a(ListAdapter arg1) {
        ListAdapter v0 = (arg1 instanceof HeaderViewListAdapter) ? ((HeaderViewListAdapter)arg1).getWrappedAdapter() : arg1;
        return ((g)v0);
    }

    public abstract void a(int arg1);

    public void a(Context arg1, h arg2) {
    }

    public void a(Rect arg1) {
        this.a = arg1;
    }

    public abstract void a(h arg1);

    public abstract void a(View arg1);

    public abstract void a(PopupWindow$OnDismissListener arg1);

    public abstract void a(boolean arg1);

    public boolean a(h arg2, j arg3) {
        return 0;
    }

    protected static boolean b(h arg5) {
        boolean v0 = false;
        int v2 = arg5.size();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            MenuItem v3 = arg5.getItem(v1);
            if((v3.isVisible()) && v3.getIcon() != null) {
                return true;
            }
        }

        return v0;
    }

    public abstract void b(int arg1);

    public boolean b(h arg2, j arg3) {
        return 0;
    }

    public abstract void c(int arg1);

    public abstract void c(boolean arg1);

    protected boolean f() {
        return 1;
    }

    public Rect g() {
        return this.a;
    }

    public void onItemClick(AdapterView arg4, View arg5, int arg6, long arg7) {
        Adapter v0 = arg4.getAdapter();
        h v2 = m.a(((ListAdapter)v0)).b;
        Object v0_1 = ((ListAdapter)v0).getItem(arg6);
        int v1 = this.f() ? 0 : 4;
        v2.a(((MenuItem)v0_1), ((o)this), v1);
    }
}

