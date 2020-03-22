package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager {
    public interface LoaderCallbacks {
        Loader onCreateLoader(int arg1, Bundle arg2);

        void onLoadFinished(Loader arg1, Object arg2);

        void onLoaderReset(Loader arg1);
    }

    public LoaderManager() {
        super();
    }

    public abstract void destroyLoader(int arg1);

    public abstract void dump(String arg1, FileDescriptor arg2, PrintWriter arg3, String[] arg4);

    public static void enableDebugLogging(boolean arg0) {
        LoaderManagerImpl.DEBUG = arg0;
    }

    public abstract Loader getLoader(int arg1);

    public boolean hasRunningLoaders() {
        return 0;
    }

    public abstract Loader initLoader(int arg1, Bundle arg2, LoaderCallbacks arg3);

    public abstract Loader restartLoader(int arg1, Bundle arg2, LoaderCallbacks arg3);
}

