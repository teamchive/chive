package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class j extends c {
    private int j;
    private int k;
    private LayoutInflater l;

    @Deprecated public j(Context arg2, int arg3, Cursor arg4, boolean arg5) {
        super(arg2, arg4, arg5);
        this.k = arg3;
        this.j = arg3;
        this.l = arg2.getSystemService("layout_inflater");
    }

    public View a(Context arg4, Cursor arg5, ViewGroup arg6) {
        return this.l.inflate(this.j, arg6, false);
    }

    public View b(Context arg4, Cursor arg5, ViewGroup arg6) {
        return this.l.inflate(this.k, arg6, false);
    }
}

