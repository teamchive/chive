package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class CursorAdapter extends BaseAdapter implements CursorFilterClient, Filterable {
    class ChangeObserver extends ContentObserver {
        ChangeObserver(CursorAdapter arg2) {
            CursorAdapter.this = arg2;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return 1;
        }

        public void onChange(boolean arg2) {
            CursorAdapter.this.onContentChanged();
        }
    }

    class MyDataSetObserver extends DataSetObserver {
        MyDataSetObserver(CursorAdapter arg1) {
            CursorAdapter.this = arg1;
            super();
        }

        public void onChanged() {
            CursorAdapter.this.mDataValid = true;
            CursorAdapter.this.notifyDataSetChanged();
        }

        public void onInvalidated() {
            CursorAdapter.this.mDataValid = false;
            CursorAdapter.this.notifyDataSetInvalidated();
        }
    }

    @Deprecated public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    @RestrictTo(value={Scope.LIBRARY_GROUP}) protected boolean mAutoRequery;
    @RestrictTo(value={Scope.LIBRARY_GROUP}) protected ChangeObserver mChangeObserver;
    @RestrictTo(value={Scope.LIBRARY_GROUP}) protected Context mContext;
    @RestrictTo(value={Scope.LIBRARY_GROUP}) protected Cursor mCursor;
    @RestrictTo(value={Scope.LIBRARY_GROUP}) protected CursorFilter mCursorFilter;
    @RestrictTo(value={Scope.LIBRARY_GROUP}) protected DataSetObserver mDataSetObserver;
    @RestrictTo(value={Scope.LIBRARY_GROUP}) protected boolean mDataValid;
    @RestrictTo(value={Scope.LIBRARY_GROUP}) protected FilterQueryProvider mFilterQueryProvider;
    @RestrictTo(value={Scope.LIBRARY_GROUP}) protected int mRowIDColumn;

    @Deprecated public CursorAdapter(Context arg2, Cursor arg3) {
        super();
        this.init(arg2, arg3, 1);
    }

    public CursorAdapter(Context arg1, Cursor arg2, int arg3) {
        super();
        this.init(arg1, arg2, arg3);
    }

    public CursorAdapter(Context arg2, Cursor arg3, boolean arg4) {
        super();
        int v0 = arg4 ? 1 : 2;
        this.init(arg2, arg3, v0);
    }

    public abstract void bindView(View arg1, Context arg2, Cursor arg3);

    public void changeCursor(Cursor arg2) {
        Cursor v0 = this.swapCursor(arg2);
        if(v0 != null) {
            v0.close();
        }
    }

    public CharSequence convertToString(Cursor arg2) {
        String v0 = arg2 == null ? "" : arg2.toString();
        return ((CharSequence)v0);
    }

    public int getCount() {
        int v0 = !this.mDataValid || this.mCursor == null ? 0 : this.mCursor.getCount();
        return v0;
    }

    public Cursor getCursor() {
        return this.mCursor;
    }

    public View getDropDownView(int arg3, View arg4, ViewGroup arg5) {
        if(this.mDataValid) {
            this.mCursor.moveToPosition(arg3);
            if(arg4 == null) {
                arg4 = this.newDropDownView(this.mContext, this.mCursor, arg5);
            }

            this.bindView(arg4, this.mContext, this.mCursor);
        }
        else {
            arg4 = null;
        }

        return arg4;
    }

    public Filter getFilter() {
        if(this.mCursorFilter == null) {
            this.mCursorFilter = new CursorFilter(((CursorFilterClient)this));
        }

        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    public Object getItem(int arg2) {
        Cursor v0;
        if(!this.mDataValid || this.mCursor == null) {
            Object v0_1 = null;
        }
        else {
            this.mCursor.moveToPosition(arg2);
            v0 = this.mCursor;
        }

        return v0;
    }

    public long getItemId(int arg4) {
        long v0 = 0;
        if((this.mDataValid) && this.mCursor != null && (this.mCursor.moveToPosition(arg4))) {
            v0 = this.mCursor.getLong(this.mRowIDColumn);
        }

        return v0;
    }

    public View getView(int arg4, View arg5, ViewGroup arg6) {
        if(!this.mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }

        if(!this.mCursor.moveToPosition(arg4)) {
            throw new IllegalStateException("couldn\'t move cursor to position " + arg4);
        }

        if(arg5 == null) {
            arg5 = this.newView(this.mContext, this.mCursor, arg6);
        }

        this.bindView(arg5, this.mContext, this.mCursor);
        return arg5;
    }

    public boolean hasStableIds() {
        return 1;
    }

    void init(Context arg5, Cursor arg6, int arg7) {
        ChangeObserver v3 = null;
        boolean v0 = true;
        if((arg7 & 1) == 1) {
            arg7 |= 2;
            this.mAutoRequery = true;
        }
        else {
            this.mAutoRequery = false;
        }

        if(arg6 == null) {
            v0 = false;
        }

        this.mCursor = arg6;
        this.mDataValid = v0;
        this.mContext = arg5;
        int v1 = v0 ? arg6.getColumnIndexOrThrow("_id") : -1;
        this.mRowIDColumn = v1;
        if((arg7 & 2) == 2) {
            this.mChangeObserver = new ChangeObserver(this);
            this.mDataSetObserver = new MyDataSetObserver(this);
        }
        else {
            this.mChangeObserver = v3;
            this.mDataSetObserver = ((DataSetObserver)v3);
        }

        if(v0) {
            if(this.mChangeObserver != null) {
                arg6.registerContentObserver(this.mChangeObserver);
            }

            if(this.mDataSetObserver == null) {
                return;
            }

            arg6.registerDataSetObserver(this.mDataSetObserver);
        }
    }

    @Deprecated protected void init(Context arg2, Cursor arg3, boolean arg4) {
        int v0 = arg4 ? 1 : 2;
        this.init(arg2, arg3, v0);
    }

    public View newDropDownView(Context arg2, Cursor arg3, ViewGroup arg4) {
        return this.newView(arg2, arg3, arg4);
    }

    public abstract View newView(Context arg1, Cursor arg2, ViewGroup arg3);

    protected void onContentChanged() {
        if((this.mAutoRequery) && this.mCursor != null && !this.mCursor.isClosed()) {
            this.mDataValid = this.mCursor.requery();
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence arg2) {
        Cursor v0 = this.mFilterQueryProvider != null ? this.mFilterQueryProvider.runQuery(arg2) : this.mCursor;
        return v0;
    }

    public void setFilterQueryProvider(FilterQueryProvider arg1) {
        this.mFilterQueryProvider = arg1;
    }

    public Cursor swapCursor(Cursor arg3) {
        Cursor v0;
        if(arg3 == this.mCursor) {
            v0 = null;
        }
        else {
            v0 = this.mCursor;
            if(v0 != null) {
                if(this.mChangeObserver != null) {
                    v0.unregisterContentObserver(this.mChangeObserver);
                }

                if(this.mDataSetObserver == null) {
                    goto label_14;
                }

                v0.unregisterDataSetObserver(this.mDataSetObserver);
            }

        label_14:
            this.mCursor = arg3;
            if(arg3 != null) {
                if(this.mChangeObserver != null) {
                    arg3.registerContentObserver(this.mChangeObserver);
                }

                if(this.mDataSetObserver != null) {
                    arg3.registerDataSetObserver(this.mDataSetObserver);
                }

                this.mRowIDColumn = arg3.getColumnIndexOrThrow("_id");
                this.mDataValid = true;
                this.notifyDataSetChanged();
                return v0;
            }

            this.mRowIDColumn = -1;
            this.mDataValid = false;
            this.notifyDataSetInvalidated();
        }

        return v0;
    }
}

