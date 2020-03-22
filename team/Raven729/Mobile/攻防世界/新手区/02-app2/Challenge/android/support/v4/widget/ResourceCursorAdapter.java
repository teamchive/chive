package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    @Deprecated public ResourceCursorAdapter(Context arg2, int arg3, Cursor arg4) {
        super(arg2, arg4);
        this.mDropDownLayout = arg3;
        this.mLayout = arg3;
        this.mInflater = arg2.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context arg2, int arg3, Cursor arg4, int arg5) {
        super(arg2, arg4, arg5);
        this.mDropDownLayout = arg3;
        this.mLayout = arg3;
        this.mInflater = arg2.getSystemService("layout_inflater");
    }

    @Deprecated public ResourceCursorAdapter(Context arg2, int arg3, Cursor arg4, boolean arg5) {
        super(arg2, arg4, arg5);
        this.mDropDownLayout = arg3;
        this.mLayout = arg3;
        this.mInflater = arg2.getSystemService("layout_inflater");
    }

    public View newDropDownView(Context arg4, Cursor arg5, ViewGroup arg6) {
        return this.mInflater.inflate(this.mDropDownLayout, arg6, false);
    }

    public View newView(Context arg4, Cursor arg5, ViewGroup arg6) {
        return this.mInflater.inflate(this.mLayout, arg6, false);
    }

    public void setDropDownViewResource(int arg1) {
        this.mDropDownLayout = arg1;
    }

    public void setViewResource(int arg1) {
        this.mLayout = arg1;
    }
}

