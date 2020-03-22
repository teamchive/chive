package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter$FilterResults;
import android.widget.Filter;

class d extends Filter {
    interface a {
        Cursor a(CharSequence arg1);

        Cursor a();

        void a(Cursor arg1);

        CharSequence c(Cursor arg1);
    }

    a a;

    d(a arg1) {
        super();
        this.a = arg1;
    }

    public CharSequence convertResultToString(Object arg2) {
        return this.a.c(((Cursor)arg2));
    }

    protected Filter$FilterResults performFiltering(CharSequence arg4) {
        Cursor v0 = this.a.a(arg4);
        Filter$FilterResults v1 = new Filter$FilterResults();
        if(v0 != null) {
            v1.count = v0.getCount();
            v1.values = v0;
        }
        else {
            v1.count = 0;
            v1.values = null;
        }

        return v1;
    }

    protected void publishResults(CharSequence arg3, Filter$FilterResults arg4) {
        Cursor v0 = this.a.a();
        if(arg4.values != null && arg4.values != v0) {
            this.a.a(arg4.values);
        }
    }
}

