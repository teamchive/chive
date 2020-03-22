package android.support.v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader {
    public final class ForceLoadContentObserver extends ContentObserver {
        public ForceLoadContentObserver(Loader arg2) {
            Loader.this = arg2;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return 1;
        }

        public void onChange(boolean arg2) {
            Loader.this.onContentChanged();
        }
    }

    public interface OnLoadCanceledListener {
        void onLoadCanceled(Loader arg1);
    }

    public interface OnLoadCompleteListener {
        void onLoadComplete(Loader arg1, Object arg2);
    }

    boolean mAbandoned;
    boolean mContentChanged;
    Context mContext;
    int mId;
    OnLoadCompleteListener mListener;
    OnLoadCanceledListener mOnLoadCanceledListener;
    boolean mProcessingChange;
    boolean mReset;
    boolean mStarted;

    public Loader(Context arg3) {
        super();
        this.mStarted = false;
        this.mAbandoned = false;
        this.mReset = true;
        this.mContentChanged = false;
        this.mProcessingChange = false;
        this.mContext = arg3.getApplicationContext();
    }

    public void abandon() {
        this.mAbandoned = true;
        this.onAbandon();
    }

    public boolean cancelLoad() {
        return this.onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public String dataToString(Object arg3) {
        StringBuilder v0 = new StringBuilder(0x40);
        DebugUtils.buildShortClassTag(arg3, v0);
        v0.append("}");
        return v0.toString();
    }

    public void deliverCancellation() {
        if(this.mOnLoadCanceledListener != null) {
            this.mOnLoadCanceledListener.onLoadCanceled(this);
        }
    }

    public void deliverResult(Object arg2) {
        if(this.mListener != null) {
            this.mListener.onLoadComplete(this, arg2);
        }
    }

    public void dump(String arg2, FileDescriptor arg3, PrintWriter arg4, String[] arg5) {
        arg4.print(arg2);
        arg4.print("mId=");
        arg4.print(this.mId);
        arg4.print(" mListener=");
        arg4.println(this.mListener);
        if((this.mStarted) || (this.mContentChanged) || (this.mProcessingChange)) {
            arg4.print(arg2);
            arg4.print("mStarted=");
            arg4.print(this.mStarted);
            arg4.print(" mContentChanged=");
            arg4.print(this.mContentChanged);
            arg4.print(" mProcessingChange=");
            arg4.println(this.mProcessingChange);
        }

        if((this.mAbandoned) || (this.mReset)) {
            arg4.print(arg2);
            arg4.print("mAbandoned=");
            arg4.print(this.mAbandoned);
            arg4.print(" mReset=");
            arg4.println(this.mReset);
        }
    }

    public void forceLoad() {
        this.onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    protected void onAbandon() {
    }

    protected boolean onCancelLoad() {
        return 0;
    }

    public void onContentChanged() {
        if(this.mStarted) {
            this.forceLoad();
        }
        else {
            this.mContentChanged = true;
        }
    }

    protected void onForceLoad() {
    }

    protected void onReset() {
    }

    protected void onStartLoading() {
    }

    protected void onStopLoading() {
    }

    public void registerListener(int arg3, OnLoadCompleteListener arg4) {
        if(this.mListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }

        this.mListener = arg4;
        this.mId = arg3;
    }

    public void registerOnLoadCanceledListener(OnLoadCanceledListener arg3) {
        if(this.mOnLoadCanceledListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }

        this.mOnLoadCanceledListener = arg3;
    }

    public void reset() {
        this.onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if(this.mProcessingChange) {
            this.onContentChanged();
        }
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        this.onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        this.onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean v0 = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= ((int)v0);
        return v0;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x40);
        DebugUtils.buildShortClassTag(this, v0);
        v0.append(" id=");
        v0.append(this.mId);
        v0.append("}");
        return v0.toString();
    }

    public void unregisterListener(OnLoadCompleteListener arg3) {
        if(this.mListener == null) {
            throw new IllegalStateException("No listener register");
        }

        if(this.mListener != arg3) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }

        this.mListener = null;
    }

    public void unregisterOnLoadCanceledListener(OnLoadCanceledListener arg3) {
        if(this.mOnLoadCanceledListener == null) {
            throw new IllegalStateException("No listener register");
        }

        if(this.mOnLoadCanceledListener != arg3) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }

        this.mOnLoadCanceledListener = null;
    }
}

