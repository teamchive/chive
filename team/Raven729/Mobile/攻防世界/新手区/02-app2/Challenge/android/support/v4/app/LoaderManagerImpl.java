package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader$OnLoadCanceledListener;
import android.support.v4.content.Loader$OnLoadCompleteListener;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager {
    final class LoaderInfo implements OnLoadCanceledListener, OnLoadCompleteListener {
        final Bundle mArgs;
        LoaderCallbacks mCallbacks;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        boolean mHaveData;
        final int mId;
        boolean mListenerRegistered;
        Loader mLoader;
        LoaderInfo mPendingLoader;
        boolean mReportNextStart;
        boolean mRetaining;
        boolean mRetainingStarted;
        boolean mStarted;

        public LoaderInfo(LoaderManagerImpl arg1, int arg2, Bundle arg3, LoaderCallbacks arg4) {
            LoaderManagerImpl.this = arg1;
            super();
            this.mId = arg2;
            this.mArgs = arg3;
            this.mCallbacks = arg4;
        }

        void callOnLoadFinished(Loader arg5, Object arg6) {
            String v1;
            if(this.mCallbacks != null) {
                String v0 = null;
                if(LoaderManagerImpl.this.mHost != null) {
                    v0 = LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause;
                    LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = "onLoadFinished";
                    v1 = v0;
                }
                else {
                    v1 = v0;
                }

                try {
                    if(LoaderManagerImpl.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + arg5 + ": " + arg5.dataToString(arg6));
                    }

                    this.mCallbacks.onLoadFinished(arg5, arg6);
                }
                catch(Throwable v0_1) {
                    if(LoaderManagerImpl.this.mHost != null) {
                        LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = v1;
                    }

                    throw v0_1;
                }

                if(LoaderManagerImpl.this.mHost != null) {
                    LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = v1;
                }

                this.mDeliveredData = true;
            }
        }

        boolean cancel() {
            boolean v0;
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Canceling: " + this);
            }

            if(!this.mStarted || this.mLoader == null || !this.mListenerRegistered) {
                v0 = false;
            }
            else {
                v0 = this.mLoader.cancelLoad();
                if(!v0) {
                    this.onLoadCanceled(this.mLoader);
                }
            }

            return v0;
        }

        void destroy() {
            String v1;
            LoaderCallbacks v2 = null;
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }

            this.mDestroyed = true;
            boolean v0 = this.mDeliveredData;
            this.mDeliveredData = false;
            if(this.mCallbacks != null && this.mLoader != null && (this.mHaveData) && (v0)) {
                if(LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Resetting: " + this);
                }

                if(LoaderManagerImpl.this.mHost != null) {
                    String v0_1 = LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause;
                    LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = "onLoaderReset";
                    v1 = v0_1;
                }
                else {
                    v1 = ((String)v2);
                }

                try {
                    this.mCallbacks.onLoaderReset(this.mLoader);
                }
                catch(Throwable v0_2) {
                    if(LoaderManagerImpl.this.mHost != null) {
                        LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = v1;
                    }

                    throw v0_2;
                }

                if(LoaderManagerImpl.this.mHost == null) {
                    goto label_56;
                }

                LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = v1;
            }

        label_56:
            this.mCallbacks = v2;
            this.mData = v2;
            this.mHaveData = false;
            if(this.mLoader != null) {
                if(this.mListenerRegistered) {
                    this.mListenerRegistered = false;
                    this.mLoader.unregisterListener(((OnLoadCompleteListener)this));
                    this.mLoader.unregisterOnLoadCanceledListener(((OnLoadCanceledListener)this));
                }

                this.mLoader.reset();
            }

            if(this.mPendingLoader != null) {
                this.mPendingLoader.destroy();
            }
        }

        public void dump(String arg4, FileDescriptor arg5, PrintWriter arg6, String[] arg7) {
            arg6.print(arg4);
            arg6.print("mId=");
            arg6.print(this.mId);
            arg6.print(" mArgs=");
            arg6.println(this.mArgs);
            arg6.print(arg4);
            arg6.print("mCallbacks=");
            arg6.println(this.mCallbacks);
            arg6.print(arg4);
            arg6.print("mLoader=");
            arg6.println(this.mLoader);
            if(this.mLoader != null) {
                this.mLoader.dump(arg4 + "  ", arg5, arg6, arg7);
            }

            if((this.mHaveData) || (this.mDeliveredData)) {
                arg6.print(arg4);
                arg6.print("mHaveData=");
                arg6.print(this.mHaveData);
                arg6.print("  mDeliveredData=");
                arg6.println(this.mDeliveredData);
                arg6.print(arg4);
                arg6.print("mData=");
                arg6.println(this.mData);
            }

            arg6.print(arg4);
            arg6.print("mStarted=");
            arg6.print(this.mStarted);
            arg6.print(" mReportNextStart=");
            arg6.print(this.mReportNextStart);
            arg6.print(" mDestroyed=");
            arg6.println(this.mDestroyed);
            arg6.print(arg4);
            arg6.print("mRetaining=");
            arg6.print(this.mRetaining);
            arg6.print(" mRetainingStarted=");
            arg6.print(this.mRetainingStarted);
            arg6.print(" mListenerRegistered=");
            arg6.println(this.mListenerRegistered);
            if(this.mPendingLoader != null) {
                arg6.print(arg4);
                arg6.println("Pending Loader ");
                arg6.print(this.mPendingLoader);
                arg6.println(":");
                this.mPendingLoader.dump(arg4 + "  ", arg5, arg6, arg7);
            }
        }

        void finishRetain() {
            if(this.mRetaining) {
                if(LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }

                this.mRetaining = false;
                if(this.mStarted == this.mRetainingStarted) {
                    goto label_20;
                }

                if(this.mStarted) {
                    goto label_20;
                }

                this.stop();
            }

        label_20:
            if((this.mStarted) && (this.mHaveData) && !this.mReportNextStart) {
                this.callOnLoadFinished(this.mLoader, this.mData);
            }
        }

        public void onLoadCanceled(Loader arg6) {
            LoaderInfo v4 = null;
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "onLoadCanceled: " + this);
            }

            if(this.mDestroyed) {
                if(LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
                }
            }
            else if(LoaderManagerImpl.this.mLoaders.get(this.mId) == this) {
                LoaderInfo v0 = this.mPendingLoader;
                if(v0 != null) {
                    if(LoaderManagerImpl.DEBUG) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + v0);
                    }

                    this.mPendingLoader = v4;
                    LoaderManagerImpl.this.mLoaders.put(this.mId, v4);
                    this.destroy();
                    LoaderManagerImpl.this.installLoader(v0);
                }
            }
            else if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Ignoring load canceled -- not active");
            }
        }

        public void onLoadComplete(Loader arg6, Object arg7) {
            LoaderInfo v4 = null;
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }

            if(this.mDestroyed) {
                if(LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
                }
            }
            else if(LoaderManagerImpl.this.mLoaders.get(this.mId) == this) {
                LoaderInfo v0 = this.mPendingLoader;
                if(v0 != null) {
                    if(LoaderManagerImpl.DEBUG) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + v0);
                    }

                    this.mPendingLoader = v4;
                    LoaderManagerImpl.this.mLoaders.put(this.mId, v4);
                    this.destroy();
                    LoaderManagerImpl.this.installLoader(v0);
                }
                else {
                    if(this.mData != arg7 || !this.mHaveData) {
                        this.mData = arg7;
                        this.mHaveData = true;
                        if(this.mStarted) {
                            this.callOnLoadFinished(arg6, arg7);
                        }
                    }

                    Object v0_1 = LoaderManagerImpl.this.mInactiveLoaders.get(this.mId);
                    if(v0_1 != null && (((LoaderInfo)v0_1)) != this) {
                        ((LoaderInfo)v0_1).mDeliveredData = false;
                        ((LoaderInfo)v0_1).destroy();
                        LoaderManagerImpl.this.mInactiveLoaders.remove(this.mId);
                    }

                    if(LoaderManagerImpl.this.mHost == null) {
                        return;
                    }

                    if(LoaderManagerImpl.this.hasRunningLoaders()) {
                        return;
                    }

                    LoaderManagerImpl.this.mHost.mFragmentManager.startPendingDeferredFragments();
                }
            }
            else if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
        }

        void reportStart() {
            if((this.mStarted) && (this.mReportNextStart)) {
                this.mReportNextStart = false;
                if((this.mHaveData) && !this.mRetaining) {
                    this.callOnLoadFinished(this.mLoader, this.mData);
                }
            }
        }

        void retain() {
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }

            this.mRetaining = true;
            this.mRetainingStarted = this.mStarted;
            this.mStarted = false;
            this.mCallbacks = null;
        }

        void start() {
            if((this.mRetaining) && (this.mRetainingStarted)) {
                this.mStarted = true;
            }
            else if(!this.mStarted) {
                this.mStarted = true;
                if(LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }

                if(this.mLoader == null && this.mCallbacks != null) {
                    this.mLoader = this.mCallbacks.onCreateLoader(this.mId, this.mArgs);
                }

                if(this.mLoader == null) {
                    return;
                }

                if((this.mLoader.getClass().isMemberClass()) && !Modifier.isStatic(this.mLoader.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.mLoader);
                }

                if(!this.mListenerRegistered) {
                    this.mLoader.registerListener(this.mId, ((OnLoadCompleteListener)this));
                    this.mLoader.registerOnLoadCanceledListener(((OnLoadCanceledListener)this));
                    this.mListenerRegistered = true;
                }

                this.mLoader.startLoading();
            }
        }

        void stop() {
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }

            this.mStarted = false;
            if(!this.mRetaining && this.mLoader != null && (this.mListenerRegistered)) {
                this.mListenerRegistered = false;
                this.mLoader.unregisterListener(((OnLoadCompleteListener)this));
                this.mLoader.unregisterOnLoadCanceledListener(((OnLoadCanceledListener)this));
                this.mLoader.stopLoading();
            }
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder(0x40);
            v0.append("LoaderInfo{");
            v0.append(Integer.toHexString(System.identityHashCode(this)));
            v0.append(" #");
            v0.append(this.mId);
            v0.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, v0);
            v0.append("}}");
            return v0.toString();
        }
    }

    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    boolean mCreatingLoader;
    FragmentHostCallback mHost;
    final SparseArrayCompat mInactiveLoaders;
    final SparseArrayCompat mLoaders;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final String mWho;

    static {
        LoaderManagerImpl.DEBUG = false;
    }

    LoaderManagerImpl(String arg2, FragmentHostCallback arg3, boolean arg4) {
        super();
        this.mLoaders = new SparseArrayCompat();
        this.mInactiveLoaders = new SparseArrayCompat();
        this.mWho = arg2;
        this.mHost = arg3;
        this.mStarted = arg4;
    }

    private LoaderInfo createAndInstallLoader(int arg3, Bundle arg4, LoaderCallbacks arg5) {
        LoaderInfo v0_1;
        try {
            this.mCreatingLoader = true;
            v0_1 = this.createLoader(arg3, arg4, arg5);
            this.installLoader(v0_1);
        }
        catch(Throwable v0) {
            this.mCreatingLoader = false;
            throw v0;
        }

        this.mCreatingLoader = false;
        return v0_1;
    }

    private LoaderInfo createLoader(int arg3, Bundle arg4, LoaderCallbacks arg5) {
        LoaderInfo v0 = new LoaderInfo(this, arg3, arg4, arg5);
        v0.mLoader = arg5.onCreateLoader(arg3, arg4);
        return v0;
    }

    public void destroyLoader(int arg4) {
        Object v0;
        if(this.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }

        if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "destroyLoader in " + this + " of " + arg4);
        }

        int v1 = this.mLoaders.indexOfKey(arg4);
        if(v1 >= 0) {
            v0 = this.mLoaders.valueAt(v1);
            this.mLoaders.removeAt(v1);
            ((LoaderInfo)v0).destroy();
        }

        v1 = this.mInactiveLoaders.indexOfKey(arg4);
        if(v1 >= 0) {
            v0 = this.mInactiveLoaders.valueAt(v1);
            this.mInactiveLoaders.removeAt(v1);
            ((LoaderInfo)v0).destroy();
        }

        if(this.mHost != null && !this.hasRunningLoaders()) {
            this.mHost.mFragmentManager.startPendingDeferredFragments();
        }
    }

    void doDestroy() {
        if(!this.mRetaining) {
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }

            int v1;
            for(v1 = this.mLoaders.size() - 1; v1 >= 0; --v1) {
                this.mLoaders.valueAt(v1).destroy();
            }

            this.mLoaders.clear();
        }

        if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }

        for(v1 = this.mInactiveLoaders.size() - 1; v1 >= 0; --v1) {
            this.mInactiveLoaders.valueAt(v1).destroy();
        }

        this.mInactiveLoaders.clear();
        this.mHost = null;
    }

    void doReportNextStart() {
        int v1;
        for(v1 = this.mLoaders.size() - 1; v1 >= 0; --v1) {
            this.mLoaders.valueAt(v1).mReportNextStart = true;
        }
    }

    void doReportStart() {
        int v1;
        for(v1 = this.mLoaders.size() - 1; v1 >= 0; --v1) {
            this.mLoaders.valueAt(v1).reportStart();
        }
    }

    void doRetain() {
        if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "Retaining in " + this);
        }

        if(!this.mStarted) {
            RuntimeException v0 = new RuntimeException("here");
            v0.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, ((Throwable)v0));
        }
        else {
            this.mRetaining = true;
            this.mStarted = false;
            int v1;
            for(v1 = this.mLoaders.size() - 1; v1 >= 0; --v1) {
                this.mLoaders.valueAt(v1).retain();
            }
        }
    }

    void doStart() {
        if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "Starting in " + this);
        }

        if(this.mStarted) {
            RuntimeException v0 = new RuntimeException("here");
            v0.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, ((Throwable)v0));
        }
        else {
            this.mStarted = true;
            int v1;
            for(v1 = this.mLoaders.size() - 1; v1 >= 0; --v1) {
                this.mLoaders.valueAt(v1).start();
            }
        }
    }

    void doStop() {
        if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "Stopping in " + this);
        }

        if(!this.mStarted) {
            RuntimeException v0 = new RuntimeException("here");
            v0.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, ((Throwable)v0));
        }
        else {
            int v1;
            for(v1 = this.mLoaders.size() - 1; v1 >= 0; --v1) {
                this.mLoaders.valueAt(v1).stop();
            }

            this.mStarted = false;
        }
    }

    public void dump(String arg6, FileDescriptor arg7, PrintWriter arg8, String[] arg9) {
        Object v0;
        int v2 = 0;
        if(this.mLoaders.size() > 0) {
            arg8.print(arg6);
            arg8.println("Active Loaders:");
            String v3 = arg6 + "    ";
            int v1;
            for(v1 = 0; v1 < this.mLoaders.size(); ++v1) {
                v0 = this.mLoaders.valueAt(v1);
                arg8.print(arg6);
                arg8.print("  #");
                arg8.print(this.mLoaders.keyAt(v1));
                arg8.print(": ");
                arg8.println(((LoaderInfo)v0).toString());
                ((LoaderInfo)v0).dump(v3, arg7, arg8, arg9);
            }
        }

        if(this.mInactiveLoaders.size() > 0) {
            arg8.print(arg6);
            arg8.println("Inactive Loaders:");
            String v1_1 = arg6 + "    ";
            while(v2 < this.mInactiveLoaders.size()) {
                v0 = this.mInactiveLoaders.valueAt(v2);
                arg8.print(arg6);
                arg8.print("  #");
                arg8.print(this.mInactiveLoaders.keyAt(v2));
                arg8.print(": ");
                arg8.println(((LoaderInfo)v0).toString());
                ((LoaderInfo)v0).dump(v1_1, arg7, arg8, arg9);
                ++v2;
            }
        }
    }

    void finishRetain() {
        if(this.mRetaining) {
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }

            this.mRetaining = false;
            int v1;
            for(v1 = this.mLoaders.size() - 1; v1 >= 0; --v1) {
                this.mLoaders.valueAt(v1).finishRetain();
            }
        }
    }

    public Loader getLoader(int arg3) {
        Loader v0_1;
        if(this.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }

        Object v0 = this.mLoaders.get(arg3);
        if(v0 == null) {
            v0_1 = null;
        }
        else if(((LoaderInfo)v0).mPendingLoader != null) {
            v0_1 = ((LoaderInfo)v0).mPendingLoader.mLoader;
        }
        else {
            v0_1 = ((LoaderInfo)v0).mLoader;
        }

        return v0_1;
    }

    public boolean hasRunningLoaders() {
        int v4 = this.mLoaders.size();
        int v2 = 0;
        int v3 = 0;
        while(v2 < v4) {
            Object v0 = this.mLoaders.valueAt(v2);
            int v0_1 = !((LoaderInfo)v0).mStarted || (((LoaderInfo)v0).mDeliveredData) ? 0 : 1;
            v3 |= v0_1;
            ++v2;
        }

        return ((boolean)v3);
    }

    public Loader initLoader(int arg5, Bundle arg6, LoaderCallbacks arg7) {
        if(this.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }

        Object v0 = this.mLoaders.get(arg5);
        if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + arg6);
        }

        if(v0 == null) {
            LoaderInfo v0_1 = this.createAndInstallLoader(arg5, arg6, arg7);
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Created new loader " + v0_1);
            }
        }
        else {
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Re-using existing loader " + v0);
            }

            ((LoaderInfo)v0).mCallbacks = arg7;
        }

        if((((LoaderInfo)v0).mHaveData) && (this.mStarted)) {
            ((LoaderInfo)v0).callOnLoadFinished(((LoaderInfo)v0).mLoader, ((LoaderInfo)v0).mData);
        }

        return ((LoaderInfo)v0).mLoader;
    }

    void installLoader(LoaderInfo arg3) {
        this.mLoaders.put(arg3.mId, arg3);
        if(this.mStarted) {
            arg3.start();
        }
    }

    public Loader restartLoader(int arg6, Bundle arg7, LoaderCallbacks arg8) {
        Loader v0_1;
        Object v4 = null;
        if(this.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }

        Object v0 = this.mLoaders.get(arg6);
        if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "restartLoader in " + this + ": args=" + arg7);
        }

        if(v0 != null) {
            Object v1 = this.mInactiveLoaders.get(arg6);
            if(v1 == null) {
                if(LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Making last loader inactive: " + v0);
                }

                ((LoaderInfo)v0).mLoader.abandon();
                this.mInactiveLoaders.put(arg6, v0);
                goto label_45;
            }
            else if(((LoaderInfo)v0).mHaveData) {
                if(LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Removing last inactive loader: " + v0);
                }

                ((LoaderInfo)v1).mDeliveredData = false;
                ((LoaderInfo)v1).destroy();
                ((LoaderInfo)v0).mLoader.abandon();
                this.mInactiveLoaders.put(arg6, v0);
                goto label_45;
            }
            else {
                if(!((LoaderInfo)v0).cancel()) {
                    if(LoaderManagerImpl.DEBUG) {
                        Log.v("LoaderManager", "  Current loader is stopped; replacing");
                    }

                    this.mLoaders.put(arg6, v4);
                    ((LoaderInfo)v0).destroy();
                    goto label_45;
                }

                if(LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Current loader is running; configuring pending loader");
                }

                if(((LoaderInfo)v0).mPendingLoader != null) {
                    if(LoaderManagerImpl.DEBUG) {
                        Log.v("LoaderManager", "  Removing pending loader: " + ((LoaderInfo)v0).mPendingLoader);
                    }

                    ((LoaderInfo)v0).mPendingLoader.destroy();
                    ((LoaderInfo)v0).mPendingLoader = ((LoaderInfo)v4);
                }

                if(LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Enqueuing as new pending loader");
                }

                ((LoaderInfo)v0).mPendingLoader = this.createLoader(arg6, arg7, arg8);
                v0_1 = ((LoaderInfo)v0).mPendingLoader.mLoader;
            }
        }
        else {
        label_45:
            v0_1 = this.createAndInstallLoader(arg6, arg7, arg8).mLoader;
        }

        return v0_1;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x80);
        v0.append("LoaderManager{");
        v0.append(Integer.toHexString(System.identityHashCode(this)));
        v0.append(" in ");
        DebugUtils.buildShortClassTag(this.mHost, v0);
        v0.append("}}");
        return v0.toString();
    }

    void updateHostController(FragmentHostCallback arg1) {
        this.mHost = arg1;
    }
}

