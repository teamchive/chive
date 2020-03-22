package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback extends FragmentContainer {
    private final Activity mActivity;
    private SimpleArrayMap mAllLoaderManagers;
    private boolean mCheckedForLoaderManager;
    final Context mContext;
    final FragmentManagerImpl mFragmentManager;
    private final Handler mHandler;
    private LoaderManagerImpl mLoaderManager;
    private boolean mLoadersStarted;
    private boolean mRetainLoaders;
    final int mWindowAnimations;

    FragmentHostCallback(Activity arg2, Context arg3, Handler arg4, int arg5) {
        super();
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = arg2;
        this.mContext = arg3;
        this.mHandler = arg4;
        this.mWindowAnimations = arg5;
    }

    public FragmentHostCallback(Context arg2, Handler arg3, int arg4) {
        Context v0;
        if((arg2 instanceof Activity)) {
            v0 = arg2;
        }
        else {
            Activity v0_1 = null;
        }

        this(((Activity)v0), arg2, arg3, arg4);
    }

    FragmentHostCallback(FragmentActivity arg3) {
        this(((Activity)arg3), ((Context)arg3), arg3.mHandler, 0);
    }

    void doLoaderDestroy() {
        if(this.mLoaderManager != null) {
            this.mLoaderManager.doDestroy();
        }
    }

    void doLoaderRetain() {
        if(this.mLoaderManager != null) {
            this.mLoaderManager.doRetain();
        }
    }

    void doLoaderStart() {
        if(!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if(this.mLoaderManager != null) {
                this.mLoaderManager.doStart();
            }
            else if(!this.mCheckedForLoaderManager) {
                this.mLoaderManager = this.getLoaderManager("(root)", this.mLoadersStarted, false);
                if(this.mLoaderManager != null && !this.mLoaderManager.mStarted) {
                    this.mLoaderManager.doStart();
                }
            }

            this.mCheckedForLoaderManager = true;
        }
    }

    void doLoaderStop(boolean arg2) {
        this.mRetainLoaders = arg2;
        if(this.mLoaderManager != null && (this.mLoadersStarted)) {
            this.mLoadersStarted = false;
            if(arg2) {
                this.mLoaderManager.doRetain();
            }
            else {
                this.mLoaderManager.doStop();
            }
        }
    }

    void dumpLoaders(String arg4, FileDescriptor arg5, PrintWriter arg6, String[] arg7) {
        arg6.print(arg4);
        arg6.print("mLoadersStarted=");
        arg6.println(this.mLoadersStarted);
        if(this.mLoaderManager != null) {
            arg6.print(arg4);
            arg6.print("Loader Manager ");
            arg6.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
            arg6.println(":");
            this.mLoaderManager.dump(arg4 + "  ", arg5, arg6, arg7);
        }
    }

    Activity getActivity() {
        return this.mActivity;
    }

    Context getContext() {
        return this.mContext;
    }

    FragmentManagerImpl getFragmentManagerImpl() {
        return this.mFragmentManager;
    }

    Handler getHandler() {
        return this.mHandler;
    }

    LoaderManagerImpl getLoaderManager(String arg3, boolean arg4, boolean arg5) {
        LoaderManagerImpl v0_1;
        if(this.mAllLoaderManagers == null) {
            this.mAllLoaderManagers = new SimpleArrayMap();
        }

        Object v0 = this.mAllLoaderManagers.get(arg3);
        if(v0 == null && (arg5)) {
            v0_1 = new LoaderManagerImpl(arg3, this, arg4);
            this.mAllLoaderManagers.put(arg3, v0_1);
        }
        else if((arg4) && v0 != null && !((LoaderManagerImpl)v0).mStarted) {
            ((LoaderManagerImpl)v0).doStart();
        }

        return v0_1;
    }

    LoaderManagerImpl getLoaderManagerImpl() {
        LoaderManagerImpl v0;
        if(this.mLoaderManager != null) {
            v0 = this.mLoaderManager;
        }
        else {
            this.mCheckedForLoaderManager = true;
            this.mLoaderManager = this.getLoaderManager("(root)", this.mLoadersStarted, true);
            v0 = this.mLoaderManager;
        }

        return v0;
    }

    boolean getRetainLoaders() {
        return this.mRetainLoaders;
    }

    void inactivateFragment(String arg3) {
        if(this.mAllLoaderManagers != null) {
            Object v0 = this.mAllLoaderManagers.get(arg3);
            if(v0 != null && !((LoaderManagerImpl)v0).mRetaining) {
                ((LoaderManagerImpl)v0).doDestroy();
                this.mAllLoaderManagers.remove(arg3);
            }
        }
    }

    void onAttachFragment(Fragment arg1) {
    }

    public void onDump(String arg1, FileDescriptor arg2, PrintWriter arg3, String[] arg4) {
    }

    @Nullable public View onFindViewById(int arg2) {
        return null;
    }

    @Nullable public abstract Object onGetHost();

    public LayoutInflater onGetLayoutInflater() {
        return this.mContext.getSystemService("layout_inflater");
    }

    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }

    public boolean onHasView() {
        return 1;
    }

    public boolean onHasWindowAnimations() {
        return 1;
    }

    public void onRequestPermissionsFromFragment(@NonNull Fragment arg1, @NonNull String[] arg2, int arg3) {
    }

    public boolean onShouldSaveFragmentState(Fragment arg2) {
        return 1;
    }

    public boolean onShouldShowRequestPermissionRationale(@NonNull String arg2) {
        return 0;
    }

    public void onStartActivityFromFragment(Fragment arg3, Intent arg4, int arg5, @Nullable Bundle arg6) {
        if(arg5 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }

        this.mContext.startActivity(arg4);
    }

    public void onStartActivityFromFragment(Fragment arg2, Intent arg3, int arg4) {
        this.onStartActivityFromFragment(arg2, arg3, arg4, null);
    }

    public void onStartIntentSenderFromFragment(Fragment arg9, IntentSender arg10, int arg11, @Nullable Intent arg12, int arg13, int arg14, int arg15, Bundle arg16) {
        if(arg11 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }

        ActivityCompat.startIntentSenderForResult(this.mActivity, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    void reportLoaderStart() {
        if(this.mAllLoaderManagers != null) {
            int v2 = this.mAllLoaderManagers.size();
            LoaderManagerImpl[] v3 = new LoaderManagerImpl[v2];
            int v1;
            for(v1 = v2 - 1; v1 >= 0; --v1) {
                v3[v1] = this.mAllLoaderManagers.valueAt(v1);
            }

            int v0;
            for(v0 = 0; v0 < v2; ++v0) {
                LoaderManagerImpl v1_1 = v3[v0];
                v1_1.finishRetain();
                v1_1.doReportStart();
            }
        }
    }

    void restoreLoaderNonConfig(SimpleArrayMap arg4) {
        if(arg4 != null) {
            int v2 = arg4.size();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                arg4.valueAt(v1).updateHostController(this);
            }
        }

        this.mAllLoaderManagers = arg4;
    }

    SimpleArrayMap retainLoaderNonConfig() {
        int v0;
        int v1 = 0;
        if(this.mAllLoaderManagers != null) {
            int v3 = this.mAllLoaderManagers.size();
            LoaderManagerImpl[] v4 = new LoaderManagerImpl[v3];
            int v2;
            for(v2 = v3 - 1; v2 >= 0; --v2) {
                v4[v2] = this.mAllLoaderManagers.valueAt(v2);
            }

            boolean v2_1 = this.getRetainLoaders();
            v0 = 0;
            while(v1 < v3) {
                LoaderManagerImpl v5 = v4[v1];
                if(!v5.mRetaining && (v2_1)) {
                    if(!v5.mStarted) {
                        v5.doStart();
                    }

                    v5.doRetain();
                }

                if(v5.mRetaining) {
                    v0 = 1;
                }
                else {
                    v5.doDestroy();
                    this.mAllLoaderManagers.remove(v5.mWho);
                }

                ++v1;
            }
        }
        else {
            v0 = 0;
        }

        SimpleArrayMap v0_1 = v0 != 0 ? this.mAllLoaderManagers : null;
        return v0_1;
    }
}

