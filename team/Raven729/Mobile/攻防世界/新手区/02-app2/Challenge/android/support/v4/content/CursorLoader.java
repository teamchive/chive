package android.support.v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.os.CancellationSignal;
import android.support.v4.os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader {
    CancellationSignal mCancellationSignal;
    Cursor mCursor;
    final ForceLoadContentObserver mObserver;
    String[] mProjection;
    String mSelection;
    String[] mSelectionArgs;
    String mSortOrder;
    Uri mUri;

    public CursorLoader(Context arg2) {
        super(arg2);
        this.mObserver = new ForceLoadContentObserver(((Loader)this));
    }

    public CursorLoader(Context arg2, Uri arg3, String[] arg4, String arg5, String[] arg6, String arg7) {
        super(arg2);
        this.mObserver = new ForceLoadContentObserver(((Loader)this));
        this.mUri = arg3;
        this.mProjection = arg4;
        this.mSelection = arg5;
        this.mSelectionArgs = arg6;
        this.mSortOrder = arg7;
    }

    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        __monitor_enter(this);
        try {
            if(this.mCancellationSignal != null) {
                this.mCancellationSignal.cancel();
            }

            __monitor_exit(this);
            return;
        label_9:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_9;
        }

        throw v0;
    }

    public void deliverResult(Cursor arg3) {
        if(!this.isReset()) {
            Cursor v0 = this.mCursor;
            this.mCursor = arg3;
            if(this.isStarted()) {
                super.deliverResult(arg3);
            }

            if(v0 == null) {
                return;
            }

            if(v0 == arg3) {
                return;
            }

            if(v0.isClosed()) {
                return;
            }

            v0.close();
        }
        else if(arg3 != null) {
            arg3.close();
        }
    }

    public void deliverResult(Object arg1) {
        this.deliverResult(((Cursor)arg1));
    }

    public void dump(String arg2, FileDescriptor arg3, PrintWriter arg4, String[] arg5) {
        super.dump(arg2, arg3, arg4, arg5);
        arg4.print(arg2);
        arg4.print("mUri=");
        arg4.println(this.mUri);
        arg4.print(arg2);
        arg4.print("mProjection=");
        arg4.println(Arrays.toString(this.mProjection));
        arg4.print(arg2);
        arg4.print("mSelection=");
        arg4.println(this.mSelection);
        arg4.print(arg2);
        arg4.print("mSelectionArgs=");
        arg4.println(Arrays.toString(this.mSelectionArgs));
        arg4.print(arg2);
        arg4.print("mSortOrder=");
        arg4.println(this.mSortOrder);
        arg4.print(arg2);
        arg4.print("mCursor=");
        arg4.println(this.mCursor);
        arg4.print(arg2);
        arg4.print("mContentChanged=");
        arg4.println(this.mContentChanged);
    }

    public String[] getProjection() {
        return this.mProjection;
    }

    public String getSelection() {
        return this.mSelection;
    }

    public String[] getSelectionArgs() {
        return this.mSelectionArgs;
    }

    public String getSortOrder() {
        return this.mSortOrder;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public Cursor loadInBackground() {
        Cursor v1;
        __monitor_enter(this);
        try {
            if(this.isLoadInBackgroundCanceled()) {
                throw new OperationCanceledException();
            }

            this.mCancellationSignal = new CancellationSignal();
            __monitor_exit(this);
            goto label_13;
        label_7:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_7;
        }

        throw v0;
        try {
        label_13:
            v1 = ContentResolverCompat.query(this.getContext().getContentResolver(), this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder, this.mCancellationSignal);
            if(v1 != null) {
                try {
                    v1.getCount();
                    v1.registerContentObserver(this.mObserver);
                }
                catch(RuntimeException v0_1) {
                    try {
                        v1.close();
                        throw v0_1;
                    }
                    catch(Throwable v0) {
                    label_35:
                        __monitor_enter(this);
                        CancellationSignal v1_1 = null;
                        try {
                            this.mCancellationSignal = v1_1;
                            __monitor_exit(this);
                        }
                        catch(Throwable v0) {
                            try {
                            label_44:
                                __monitor_exit(this);
                            }
                            catch(Throwable v0) {
                                goto label_44;
                            }

                            throw v0;
                        }

                        throw v0;
                    }
                }
            }
        }
        catch(Throwable v0) {
            goto label_35;
        }

        __monitor_enter(this);
        CancellationSignal v0_2 = null;
        try {
            this.mCancellationSignal = v0_2;
            __monitor_exit(this);
            return v1;
        }
        catch(Throwable v0) {
            try {
            label_41:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_41;
            }

            throw v0;
        }
    }

    public Object loadInBackground() {
        return this.loadInBackground();
    }

    public void onCanceled(Cursor arg2) {
        if(arg2 != null && !arg2.isClosed()) {
            arg2.close();
        }
    }

    public void onCanceled(Object arg1) {
        this.onCanceled(((Cursor)arg1));
    }

    protected void onReset() {
        super.onReset();
        this.onStopLoading();
        if(this.mCursor != null && !this.mCursor.isClosed()) {
            this.mCursor.close();
        }

        this.mCursor = null;
    }

    protected void onStartLoading() {
        if(this.mCursor != null) {
            this.deliverResult(this.mCursor);
        }

        if((this.takeContentChanged()) || this.mCursor == null) {
            this.forceLoad();
        }
    }

    protected void onStopLoading() {
        this.cancelLoad();
    }

    public void setProjection(String[] arg1) {
        this.mProjection = arg1;
    }

    public void setSelection(String arg1) {
        this.mSelection = arg1;
    }

    public void setSelectionArgs(String[] arg1) {
        this.mSelectionArgs = arg1;
    }

    public void setSortOrder(String arg1) {
        this.mSortOrder = arg1;
    }

    public void setUri(Uri arg1) {
        this.mUri = arg1;
    }
}

