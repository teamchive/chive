package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.widget.aw;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements b, p, AdapterView$OnItemClickListener {
    private static final int[] a;
    private h b;
    private int c;

    static {
        ExpandedMenuView.a = new int[]{0x10100D4, 0x1010129};
    }

    public ExpandedMenuView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0x1010074);
    }

    public ExpandedMenuView(Context arg5, AttributeSet arg6, int arg7) {
        super(arg5, arg6);
        this.setOnItemClickListener(((AdapterView$OnItemClickListener)this));
        aw v0 = aw.a(arg5, arg6, ExpandedMenuView.a, arg7, 0);
        if(v0.g(0)) {
            this.setBackgroundDrawable(v0.a(0));
        }

        if(v0.g(1)) {
            this.setDivider(v0.a(1));
        }

        v0.a();
    }

    public void a(h arg1) {
        this.b = arg1;
    }

    public boolean a(j arg3) {
        return this.b.a(((MenuItem)arg3), 0);
    }

    public int getWindowAnimations() {
        return this.c;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView arg2, View arg3, int arg4, long arg5) {
        this.a(this.getAdapter().getItem(arg4));
    }
}

