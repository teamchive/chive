package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class c extends BaseAdapter implements a, Filterable {
    class android.support.v4.widget.c$a extends ContentObserver {
        android.support.v4.widget.c$a(c arg2) {
            this.a = arg2;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return 1;
        }

        public void onChange(boolean arg2) {
            this.a.b();
        }
    }

    class b extends DataSetObserver {
        b(c arg1) {
            this.a = arg1;
            super();
        }

        public void onChanged() {
            this.a.a = true;
            this.a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.a.a = false;
            this.a.notifyDataSetInvalidated();
        }
    }

    protected boolean a;
    protected boolean b;
    protected Cursor c;
    protected Context d;
    protected int e;
    protected android.support.v4.widget.c$a f;
    protected DataSetObserver g;
    protected d h;
    protected FilterQueryProvider i;

    public c(Context arg2, Cursor arg3, boolean arg4) {
        super();
        int v0 = arg4 ? 1 : 2;
        this.a(arg2, arg3, v0);
    }

    void a(Context arg5, Cursor arg6, int arg7) {
        android.support.v4.widget.c$a v3 = null;
        boolean v0 = true;
        if((arg7 & 1) == 1) {
            arg7 |= 2;
            this.b = true;
        }
        else {
            this.b = false;
        }

        if(arg6 == null) {
            v0 = false;
        }

        this.c = arg6;
        this.a = v0;
        this.d = arg5;
        int v1 = v0 ? arg6.getColumnIndexOrThrow("_id") : -1;
        this.e = v1;
        if((arg7 & 2) == 2) {
            this.f = new android.support.v4.widget.c$a(this);
            this.g = new b(this);
        }
        else {
            this.f = v3;
            this.g = ((DataSetObserver)v3);
        }

        if(v0) {
            if(this.f != null) {
                arg6.registerContentObserver(this.f);
            }

            if(this.g == null) {
                return;
            }

            arg6.registerDataSetObserver(this.g);
        }
    }

    public Cursor a() {
        return this.c;
    }

    public Cursor a(CharSequence arg2) {
        Cursor v0 = this.i != null ? this.i.runQuery(arg2) : this.c;
        return v0;
    }

    public abstract View a(Context arg1, Cursor arg2, ViewGroup arg3);

    public void a(Cursor arg2) {
        Cursor v0 = this.b(arg2);
        if(v0 != null) {
            v0.close();
        }
    }

    public abstract void a(View arg1, Context arg2, Cursor arg3);

    public Cursor b(Cursor arg3) {
        Cursor v0;
        if(arg3 == this.c) {
            v0 = null;
        }
        else {
            v0 = this.c;
            if(v0 != null) {
                if(this.f != null) {
                    v0.unregisterContentObserver(this.f);
                }

                if(this.g == null) {
                    goto label_14;
                }

                v0.unregisterDataSetObserver(this.g);
            }

        label_14:
            this.c = arg3;
            if(arg3 != null) {
                if(this.f != null) {
                    arg3.registerContentObserver(this.f);
                }

                if(this.g != null) {
                    arg3.registerDataSetObserver(this.g);
                }

                this.e = arg3.getColumnIndexOrThrow("_id");
                this.a = true;
                this.notifyDataSetChanged();
                return v0;
            }

            this.e = -1;
            this.a = false;
            this.notifyDataSetInvalidated();
        }

        return v0;
    }

    public View b(Context arg2, Cursor arg3, ViewGroup arg4) {
        return this.a(arg2, arg3, arg4);
    }

    protected void b() {
        if((this.b) && this.c != null && !this.c.isClosed()) {
            this.a = this.c.requery();
        }
    }

    public CharSequence c(Cursor arg2) {
        String v0 = arg2 == null ? "" : arg2.toString();
        return ((CharSequence)v0);
    }

    public int getCount() {
        int v0 = !this.a || this.c == null ? 0 : this.c.getCount();
        return v0;
    }

    public View getDropDownView(int arg3, View arg4, ViewGroup arg5) {
        if(this.a) {
            this.c.moveToPosition(arg3);
            if(arg4 == null) {
                arg4 = this.b(this.d, this.c, arg5);
            }

            this.a(arg4, this.d, this.c);
        }
        else {
            arg4 = null;
        }

        return arg4;
    }

    public Filter getFilter() {
        if(this.h == null) {
            this.h = new d(((a)this));
        }

        return this.h;
    }

    public Object getItem(int arg2) {
        Cursor v0;
        if(!this.a || this.c == null) {
            Object v0_1 = null;
        }
        else {
            this.c.moveToPosition(arg2);
            v0 = this.c;
        }

        return v0;
    }

    public long getItemId(int arg4) {
        long v0 = 0;
        if((this.a) && this.c != null && (this.c.moveToPosition(arg4))) {
            v0 = this.c.getLong(this.e);
        }

        return v0;
    }

    public View getView(int arg4, View arg5, ViewGroup arg6) {
        if(!this.a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }

        if(!this.c.moveToPosition(arg4)) {
            throw new IllegalStateException("couldn\'t move cursor to position " + arg4);
        }

        if(arg5 == null) {
            arg5 = this.a(this.d, this.c, arg6);
        }

        this.a(arg5, this.d, this.c);
        return arg5;
    }

    public boolean hasStableIds() {
        return 1;
    }
}

