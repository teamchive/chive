package android.support.v4.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.util.SparseArrayCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends BaseFragmentActivityJB implements OnRequestPermissionsResultCallback, RequestPermissionsRequestCodeValidator {
    class android.support.v4.app.FragmentActivity$1 extends Handler {
        android.support.v4.app.FragmentActivity$1(FragmentActivity arg1) {
            FragmentActivity.this = arg1;
            super();
        }

        public void handleMessage(Message arg3) {
            switch(arg3.what) {
                case 1: {
                    if(!FragmentActivity.this.mStopped) {
                        return;
                    }

                    FragmentActivity.this.doReallyStop(false);
                    break;
                }
                case 2: {
                    FragmentActivity.this.onResumeFragments();
                    FragmentActivity.this.mFragments.execPendingActions();
                    break;
                }
                default: {
                    super.handleMessage(arg3);
                    break;
                }
            }
        }
    }

    class HostCallbacks extends FragmentHostCallback {
        public HostCallbacks(FragmentActivity arg1) {
            FragmentActivity.this = arg1;
            super(arg1);
        }

        public void onAttachFragment(Fragment arg2) {
            FragmentActivity.this.onAttachFragment(arg2);
        }

        @SuppressLint(value={"NewApi"}) public void onDump(String arg2, FileDescriptor arg3, PrintWriter arg4, String[] arg5) {
            FragmentActivity.this.dump(arg2, arg3, arg4, arg5);
        }

        @Nullable public View onFindViewById(int arg2) {
            return FragmentActivity.this.findViewById(arg2);
        }

        public FragmentActivity onGetHost() {
            return FragmentActivity.this;
        }

        public Object onGetHost() {
            return this.onGetHost();
        }

        public LayoutInflater onGetLayoutInflater() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        public int onGetWindowAnimations() {
            Window v0 = FragmentActivity.this.getWindow();
            int v0_1 = v0 == null ? 0 : v0.getAttributes().windowAnimations;
            return v0_1;
        }

        public boolean onHasView() {
            Window v0 = FragmentActivity.this.getWindow();
            boolean v0_1 = v0 == null || v0.peekDecorView() == null ? false : true;
            return v0_1;
        }

        public boolean onHasWindowAnimations() {
            boolean v0 = FragmentActivity.this.getWindow() != null ? true : false;
            return v0;
        }

        public void onRequestPermissionsFromFragment(@NonNull Fragment arg2, @NonNull String[] arg3, int arg4) {
            FragmentActivity.this.requestPermissionsFromFragment(arg2, arg3, arg4);
        }

        public boolean onShouldSaveFragmentState(Fragment arg2) {
            boolean v0 = !FragmentActivity.this.isFinishing() ? true : false;
            return v0;
        }

        public boolean onShouldShowRequestPermissionRationale(@NonNull String arg2) {
            return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, arg2);
        }

        public void onStartActivityFromFragment(Fragment arg2, Intent arg3, int arg4) {
            FragmentActivity.this.startActivityFromFragment(arg2, arg3, arg4);
        }

        public void onStartActivityFromFragment(Fragment arg2, Intent arg3, int arg4, @Nullable Bundle arg5) {
            FragmentActivity.this.startActivityFromFragment(arg2, arg3, arg4, arg5);
        }

        public void onStartIntentSenderFromFragment(Fragment arg10, IntentSender arg11, int arg12, @Nullable Intent arg13, int arg14, int arg15, int arg16, Bundle arg17) {
            FragmentActivity.this.startIntentSenderFromFragment(arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
        }

        public void onSupportInvalidateOptionsMenu() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }
    }

    final class NonConfigurationInstances {
        Object custom;
        FragmentManagerNonConfig fragments;
        SimpleArrayMap loaders;

        NonConfigurationInstances() {
            super();
        }
    }

    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 0xFFFE;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final FragmentController mFragments;
    final Handler mHandler;
    int mNextCandidateRequestIndex;
    boolean mOptionsMenuInvalidated;
    SparseArrayCompat mPendingFragmentActivityResults;
    boolean mReallyStopped;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped;

    public FragmentActivity() {
        super();
        this.mHandler = new android.support.v4.app.FragmentActivity$1(this);
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mStopped = true;
        this.mReallyStopped = true;
    }

    private int allocateRequestIndex(Fragment arg5) {
        int v3 = 0xFFFE;
        if(this.mPendingFragmentActivityResults.size() >= v3) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }

        while(this.mPendingFragmentActivityResults.indexOfKey(this.mNextCandidateRequestIndex) >= 0) {
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % v3;
        }

        int v0 = this.mNextCandidateRequestIndex;
        this.mPendingFragmentActivityResults.put(v0, arg5.mWho);
        this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % v3;
        return v0;
    }

    final View dispatchFragmentsOnCreateView(View arg2, String arg3, Context arg4, AttributeSet arg5) {
        return this.mFragments.onCreateView(arg2, arg3, arg4, arg5);
    }

    void doReallyStop(boolean arg3) {
        if(!this.mReallyStopped) {
            this.mReallyStopped = true;
            this.mRetaining = arg3;
            this.mHandler.removeMessages(1);
            this.onReallyStop();
        }
        else if(arg3) {
            this.mFragments.doLoaderStart();
            this.mFragments.doLoaderStop(true);
        }
    }

    public void dump(String arg3, FileDescriptor arg4, PrintWriter arg5, String[] arg6) {
        arg5.print(arg3);
        arg5.print("Local FragmentActivity ");
        arg5.print(Integer.toHexString(System.identityHashCode(this)));
        arg5.println(" State:");
        String v0 = arg3 + "  ";
        arg5.print(v0);
        arg5.print("mCreated=");
        arg5.print(this.mCreated);
        arg5.print("mResumed=");
        arg5.print(this.mResumed);
        arg5.print(" mStopped=");
        arg5.print(this.mStopped);
        arg5.print(" mReallyStopped=");
        arg5.println(this.mReallyStopped);
        this.mFragments.dumpLoaders(v0, arg4, arg5, arg6);
        this.mFragments.getSupportFragmentManager().dump(arg3, arg4, arg5, arg6);
        arg5.print(arg3);
        arg5.println("View Hierarchy:");
        this.dumpViewHierarchy(arg3 + "  ", arg5, this.getWindow().getDecorView());
    }

    private void dumpViewHierarchy(String arg5, PrintWriter arg6, View arg7) {
        arg6.print(arg5);
        if(arg7 == null) {
            arg6.println("null");
        }
        else {
            arg6.println(FragmentActivity.viewToString(arg7));
            if((arg7 instanceof ViewGroup)) {
                int v1 = ((ViewGroup)arg7).getChildCount();
                if(v1 > 0) {
                    String v2 = arg5 + "  ";
                    int v0;
                    for(v0 = 0; v0 < v1; ++v0) {
                        this.dumpViewHierarchy(v2, arg6, ((ViewGroup)arg7).getChildAt(v0));
                    }
                }
            }
        }
    }

    public Object getLastCustomNonConfigurationInstance() {
        Object v0 = this.getLastNonConfigurationInstance();
        return v0 != null ? ((NonConfigurationInstances)v0).custom : null;
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    public LoaderManager getSupportLoaderManager() {
        return this.mFragments.getSupportLoaderManager();
    }

    @Deprecated public final MediaControllerCompat getSupportMediaController() {
        return MediaControllerCompat.getMediaController(((Activity)this));
    }

    protected void onActivityResult(int arg5, int arg6, Intent arg7) {
        this.mFragments.noteStateNotSaved();
        int v0 = arg5 >> 16;
        if(v0 != 0) {
            int v1 = v0 - 1;
            Object v0_1 = this.mPendingFragmentActivityResults.get(v1);
            this.mPendingFragmentActivityResults.remove(v1);
            if(v0_1 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            }
            else {
                Fragment v1_1 = this.mFragments.findFragmentByWho(((String)v0_1));
                if(v1_1 == null) {
                    Log.w("FragmentActivity", "Activity result no fragment exists for who: " + (((String)v0_1)));
                }
                else {
                    v1_1.onActivityResult(0xFFFF & arg5, arg6, arg7);
                }
            }
        }
        else {
            super.onActivityResult(arg5, arg6, arg7);
        }
    }

    public void onAttachFragment(Fragment arg1) {
    }

    public void onBackPressed() {
        if(!this.mFragments.getSupportFragmentManager().popBackStackImmediate()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration arg2) {
        super.onConfigurationChanged(arg2);
        this.mFragments.dispatchConfigurationChanged(arg2);
    }

    protected void onCreate(@Nullable Bundle arg8) {
        Fragment v1 = null;
        this.mFragments.attachHost(v1);
        super.onCreate(arg8);
        Object v0 = this.getLastNonConfigurationInstance();
        if(v0 != null) {
            this.mFragments.restoreLoaderNonConfig(((NonConfigurationInstances)v0).loaders);
        }

        if(arg8 != null) {
            Parcelable v3 = arg8.getParcelable("android:support:fragments");
            FragmentController v4 = this.mFragments;
            FragmentManagerNonConfig v0_1 = v0 != null ? ((NonConfigurationInstances)v0).fragments : ((FragmentManagerNonConfig)v1);
            v4.restoreAllState(v3, v0_1);
            if(!arg8.containsKey("android:support:next_request_index")) {
                goto label_35;
            }

            this.mNextCandidateRequestIndex = arg8.getInt("android:support:next_request_index");
            int[] v1_1 = arg8.getIntArray("android:support:request_indicies");
            String[] v3_1 = arg8.getStringArray("android:support:request_fragment_who");
            if(v1_1 != null && v3_1 != null && v1_1.length == v3_1.length) {
                this.mPendingFragmentActivityResults = new SparseArrayCompat(v1_1.length);
                int v0_2 = 0;
                while(true) {
                    if(v0_2 < v1_1.length) {
                        this.mPendingFragmentActivityResults.put(v1_1[v0_2], v3_1[v0_2]);
                        ++v0_2;
                        continue;
                    }
                    else {
                        goto label_35;
                    }
                }
            }

            Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
        }

    label_35:
        if(this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new SparseArrayCompat();
            this.mNextCandidateRequestIndex = 0;
        }

        this.mFragments.dispatchCreate();
    }

    public boolean onCreatePanelMenu(int arg4, Menu arg5) {
        boolean v0_1;
        int v0;
        if(arg4 == 0) {
            v0 = super.onCreatePanelMenu(arg4, arg5) | this.mFragments.dispatchCreateOptionsMenu(arg5, this.getMenuInflater());
            if(Build$VERSION.SDK_INT < 11) {
                v0_1 = true;
            }
        }
        else {
            v0_1 = super.onCreatePanelMenu(arg4, arg5);
        }

        return ((boolean)v0);
    }

    public View onCreateView(View arg2, String arg3, Context arg4, AttributeSet arg5) {
        return super.onCreateView(arg2, arg3, arg4, arg5);
    }

    public View onCreateView(String arg2, Context arg3, AttributeSet arg4) {
        return super.onCreateView(arg2, arg3, arg4);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.doReallyStop(false);
        this.mFragments.dispatchDestroy();
        this.mFragments.doLoaderDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.dispatchLowMemory();
    }

    public boolean onMenuItemSelected(int arg2, MenuItem arg3) {
        boolean v0;
        if(super.onMenuItemSelected(arg2, arg3)) {
            v0 = true;
        }
        else {
            switch(arg2) {
                case 0: {
                    goto label_7;
                }
                case 6: {
                    goto label_10;
                }
            }

            return false;
        label_7:
            return this.mFragments.dispatchOptionsItemSelected(arg3);
        label_10:
            v0 = this.mFragments.dispatchContextItemSelected(arg3);
        }

        return v0;
    }

    @CallSuper public void onMultiWindowModeChanged(boolean arg2) {
        this.mFragments.dispatchMultiWindowModeChanged(arg2);
    }

    protected void onNewIntent(Intent arg2) {
        super.onNewIntent(arg2);
        this.mFragments.noteStateNotSaved();
    }

    public void onPanelClosed(int arg2, Menu arg3) {
        switch(arg2) {
            case 0: {
                this.mFragments.dispatchOptionsMenuClosed(arg3);
                break;
            }
        }

        super.onPanelClosed(arg2, arg3);
    }

    protected void onPause() {
        int v1 = 2;
        super.onPause();
        this.mResumed = false;
        if(this.mHandler.hasMessages(v1)) {
            this.mHandler.removeMessages(v1);
            this.onResumeFragments();
        }

        this.mFragments.dispatchPause();
    }

    @CallSuper public void onPictureInPictureModeChanged(boolean arg2) {
        this.mFragments.dispatchPictureInPictureModeChanged(arg2);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        this.onResumeFragments();
        this.mFragments.execPendingActions();
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) protected boolean onPrepareOptionsPanel(View arg2, Menu arg3) {
        return super.onPreparePanel(0, arg2, arg3);
    }

    public boolean onPreparePanel(int arg3, View arg4, Menu arg5) {
        int v0;
        if(arg3 != 0 || arg5 == null) {
            boolean v0_1 = super.onPreparePanel(arg3, arg4, arg5);
        }
        else {
            if(this.mOptionsMenuInvalidated) {
                this.mOptionsMenuInvalidated = false;
                arg5.clear();
                this.onCreatePanelMenu(arg3, arg5);
            }

            v0 = this.onPrepareOptionsPanel(arg4, arg5) | this.mFragments.dispatchPrepareOptionsMenu(arg5);
        }

        return ((boolean)v0);
    }

    void onReallyStop() {
        this.mFragments.doLoaderStop(this.mRetaining);
        this.mFragments.dispatchReallyStop();
    }

    public void onRequestPermissionsResult(int arg5, @NonNull String[] arg6, @NonNull int[] arg7) {
        int v3 = 0xFFFF;
        int v0 = arg5 >> 16 & v3;
        if(v0 != 0) {
            int v1 = v0 - 1;
            Object v0_1 = this.mPendingFragmentActivityResults.get(v1);
            this.mPendingFragmentActivityResults.remove(v1);
            if(v0_1 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            }
            else {
                Fragment v1_1 = this.mFragments.findFragmentByWho(((String)v0_1));
                if(v1_1 == null) {
                    Log.w("FragmentActivity", "Activity result no fragment exists for who: " + (((String)v0_1)));
                }
                else {
                    v1_1.onRequestPermissionsResult(arg5 & v3, arg6, arg7);
                }
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }

    protected void onResumeFragments() {
        this.mFragments.dispatchResume();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        NonConfigurationInstances v0_1;
        if(this.mStopped) {
            this.doReallyStop(true);
        }

        Object v1 = this.onRetainCustomNonConfigurationInstance();
        FragmentManagerNonConfig v2 = this.mFragments.retainNestedNonConfig();
        SimpleArrayMap v3 = this.mFragments.retainLoaderNonConfig();
        if(v2 != null || v3 != null || v1 != null) {
            v0_1 = new NonConfigurationInstances();
            v0_1.custom = v1;
            v0_1.fragments = v2;
            v0_1.loaders = v3;
        }
        else {
            Object v0 = null;
        }

        return v0_1;
    }

    protected void onSaveInstanceState(Bundle arg5) {
        super.onSaveInstanceState(arg5);
        Parcelable v0 = this.mFragments.saveAllState();
        if(v0 != null) {
            arg5.putParcelable("android:support:fragments", v0);
        }

        if(this.mPendingFragmentActivityResults.size() > 0) {
            arg5.putInt("android:support:next_request_index", this.mNextCandidateRequestIndex);
            int[] v2 = new int[this.mPendingFragmentActivityResults.size()];
            String[] v3 = new String[this.mPendingFragmentActivityResults.size()];
            int v1;
            for(v1 = 0; v1 < this.mPendingFragmentActivityResults.size(); ++v1) {
                v2[v1] = this.mPendingFragmentActivityResults.keyAt(v1);
                v3[v1] = this.mPendingFragmentActivityResults.valueAt(v1);
            }

            arg5.putIntArray("android:support:request_indicies", v2);
            arg5.putStringArray("android:support:request_fragment_who", v3);
        }
    }

    protected void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if(!this.mCreated) {
            this.mCreated = true;
            this.mFragments.dispatchActivityCreated();
        }

        this.mFragments.noteStateNotSaved();
        this.mFragments.execPendingActions();
        this.mFragments.doLoaderStart();
        this.mFragments.dispatchStart();
        this.mFragments.reportLoaderStart();
    }

    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.dispatchStop();
    }

    void requestPermissionsFromFragment(Fragment arg4, String[] arg5, int arg6) {
        if(arg6 == -1) {
            ActivityCompat.requestPermissions(((Activity)this), arg5, arg6);
        }
        else {
            FragmentActivity.checkForValidRequestCode(arg6);
            try {
                this.mRequestedPermissionsFromFragment = true;
                ActivityCompat.requestPermissions(((Activity)this), arg5, (this.allocateRequestIndex(arg4) + 1 << 16) + (0xFFFF & arg6));
            }
            catch(Throwable v0) {
                this.mRequestedPermissionsFromFragment = false;
                throw v0;
            }

            this.mRequestedPermissionsFromFragment = false;
        }
    }

    public void setEnterSharedElementCallback(SharedElementCallback arg1) {
        ActivityCompat.setEnterSharedElementCallback(((Activity)this), arg1);
    }

    public void setExitSharedElementCallback(SharedElementCallback arg1) {
        ActivityCompat.setExitSharedElementCallback(((Activity)this), arg1);
    }

    @Deprecated public final void setSupportMediaController(MediaControllerCompat arg1) {
        MediaControllerCompat.setMediaController(((Activity)this), arg1);
    }

    public void startActivityForResult(Intent arg2, int arg3) {
        if(!this.mStartedActivityFromFragment && arg3 != -1) {
            FragmentActivity.checkForValidRequestCode(arg3);
        }

        super.startActivityForResult(arg2, arg3);
    }

    @RequiresApi(value=16) public void startActivityForResult(Intent arg1, int arg2, @Nullable Bundle arg3) {
        super.startActivityForResult(arg1, arg2, arg3);
    }

    public void startActivityFromFragment(Fragment arg2, Intent arg3, int arg4) {
        this.startActivityFromFragment(arg2, arg3, arg4, null);
    }

    public void startActivityFromFragment(Fragment arg4, Intent arg5, int arg6, @Nullable Bundle arg7) {
        this.mStartedActivityFromFragment = true;
        if(arg6 == -1) {
            int v0 = -1;
            try {
                ActivityCompat.startActivityForResult(((Activity)this), arg5, v0, arg7);
            }
            catch(Throwable v0_1) {
                goto label_20;
            }

            this.mStartedActivityFromFragment = false;
        }
        else {
            try {
                FragmentActivity.checkForValidRequestCode(arg6);
                ActivityCompat.startActivityForResult(((Activity)this), arg5, (this.allocateRequestIndex(arg4) + 1 << 16) + (0xFFFF & arg6), arg7);
            }
            catch(Throwable v0_1) {
            label_20:
                this.mStartedActivityFromFragment = false;
                throw v0_1;
            }

            this.mStartedActivityFromFragment = false;
        }
    }

    public void startIntentSenderForResult(IntentSender arg1, int arg2, @Nullable Intent arg3, int arg4, int arg5, int arg6) {
        super.startIntentSenderForResult(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    @RequiresApi(value=16) public void startIntentSenderForResult(IntentSender arg1, int arg2, @Nullable Intent arg3, int arg4, int arg5, int arg6, Bundle arg7) {
        super.startIntentSenderForResult(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public void startIntentSenderFromFragment(Fragment arg9, IntentSender arg10, int arg11, @Nullable Intent arg12, int arg13, int arg14, int arg15, Bundle arg16) {
        this.mStartedIntentSenderFromFragment = true;
        if(arg11 == -1) {
            FragmentActivity v0 = this;
            IntentSender v1 = arg10;
            int v2 = arg11;
            Intent v3 = arg12;
            int v4 = arg13;
            int v5 = arg14;
            int v6 = arg15;
            Bundle v7 = arg16;
            try {
                ActivityCompat.startIntentSenderForResult(((Activity)v0), v1, v2, v3, v4, v5, v6, v7);
            }
            catch(Throwable v0_1) {
                goto label_36;
            }

            this.mStartedIntentSenderFromFragment = false;
        }
        else {
            try {
                FragmentActivity.checkForValidRequestCode(arg11);
                ActivityCompat.startIntentSenderForResult(this, arg10, (this.allocateRequestIndex(arg9) + 1 << 16) + (0xFFFF & arg11), arg12, arg13, arg14, arg15, arg16);
            }
            catch(Throwable v0_1) {
            label_36:
                this.mStartedIntentSenderFromFragment = false;
                throw v0_1;
            }

            this.mStartedIntentSenderFromFragment = false;
        }
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(((Activity)this));
    }

    public void supportInvalidateOptionsMenu() {
        if(Build$VERSION.SDK_INT >= 11) {
            ActivityCompatHoneycomb.invalidateOptionsMenu(((Activity)this));
        }
        else {
            this.mOptionsMenuInvalidated = true;
        }
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(((Activity)this));
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(((Activity)this));
    }

    public final void validateRequestPermissionsRequestCode(int arg2) {
        if(!this.mRequestedPermissionsFromFragment && arg2 != -1) {
            FragmentActivity.checkForValidRequestCode(arg2);
        }
    }

    private static String viewToString(View arg7) {
        char v3 = 'V';
        char v1 = 'F';
        char v6 = ',';
        char v5 = ' ';
        char v2 = '.';
        StringBuilder v4 = new StringBuilder(0x80);
        v4.append(arg7.getClass().getName());
        v4.append('{');
        v4.append(Integer.toHexString(System.identityHashCode(arg7)));
        v4.append(v5);
        switch(arg7.getVisibility()) {
            case 0: {
                v4.append(v3);
                break;
            }
            case 4: {
                v4.append('I');
                break;
            }
            case 8: {
                v4.append('G');
                break;
            }
            default: {
                v4.append(v2);
                break;
            }
        }

        char v0 = arg7.isFocusable() ? v1 : v2;
        v4.append(v0);
        v0 = arg7.isEnabled() ? 'E' : v2;
        v4.append(v0);
        v0 = arg7.willNotDraw() ? v2 : 'D';
        v4.append(v0);
        v0 = arg7.isHorizontalScrollBarEnabled() ? 'H' : v2;
        v4.append(v0);
        v0 = arg7.isVerticalScrollBarEnabled() ? v3 : v2;
        v4.append(v0);
        v0 = arg7.isClickable() ? 'C' : v2;
        v4.append(v0);
        v0 = arg7.isLongClickable() ? 'L' : v2;
        v4.append(v0);
        v4.append(v5);
        if(!arg7.isFocused()) {
            v1 = v2;
        }

        v4.append(v1);
        v0 = arg7.isSelected() ? 'S' : v2;
        v4.append(v0);
        if(arg7.isPressed()) {
            v2 = 'P';
        }

        v4.append(v2);
        v4.append(v5);
        v4.append(arg7.getLeft());
        v4.append(v6);
        v4.append(arg7.getTop());
        v4.append('-');
        v4.append(arg7.getRight());
        v4.append(v6);
        v4.append(arg7.getBottom());
        int v1_1 = arg7.getId();
        if(v1_1 != -1) {
            v4.append(" #");
            v4.append(Integer.toHexString(v1_1));
            Resources v2_1 = arg7.getResources();
            if(v1_1 == 0) {
                goto label_98;
            }

            if(v2_1 == null) {
                goto label_98;
            }

            switch(0xFF000000 & v1_1) {
                case 16777216: {
                    goto label_130;
                }
                case 2130706432: {
                    goto label_128;
                }
                default: {
                    try {
                        String v0_2 = v2_1.getResourcePackageName(v1_1);
                        goto label_87;
                    label_130:
                        v0_2 = "android";
                        goto label_87;
                    label_128:
                        v0_2 = "app";
                    label_87:
                        String v3_1 = v2_1.getResourceTypeName(v1_1);
                        String v1_2 = v2_1.getResourceEntryName(v1_1);
                        v4.append(" ");
                        v4.append(v0_2);
                        v4.append(":");
                        v4.append(v3_1);
                        v4.append("/");
                        v4.append(v1_2);
                    }
                    catch(Resources$NotFoundException v0_1) {
                    }

                    goto label_98;
                }
            }
        }

    label_98:
        v4.append("}");
        return v4.toString();
    }
}

