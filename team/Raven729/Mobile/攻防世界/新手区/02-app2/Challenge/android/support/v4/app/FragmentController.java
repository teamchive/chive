package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FragmentController {
    private final FragmentHostCallback mHost;

    private FragmentController(FragmentHostCallback arg1) {
        super();
        this.mHost = arg1;
    }

    public void attachHost(Fragment arg4) {
        this.mHost.mFragmentManager.attachController(this.mHost, this.mHost, arg4);
    }

    public static final FragmentController createController(FragmentHostCallback arg1) {
        return new FragmentController(arg1);
    }

    public void dispatchActivityCreated() {
        this.mHost.mFragmentManager.dispatchActivityCreated();
    }

    public void dispatchConfigurationChanged(Configuration arg2) {
        this.mHost.mFragmentManager.dispatchConfigurationChanged(arg2);
    }

    public boolean dispatchContextItemSelected(MenuItem arg2) {
        return this.mHost.mFragmentManager.dispatchContextItemSelected(arg2);
    }

    public void dispatchCreate() {
        this.mHost.mFragmentManager.dispatchCreate();
    }

    public boolean dispatchCreateOptionsMenu(Menu arg2, MenuInflater arg3) {
        return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(arg2, arg3);
    }

    public void dispatchDestroy() {
        this.mHost.mFragmentManager.dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.mHost.mFragmentManager.dispatchDestroyView();
    }

    public void dispatchLowMemory() {
        this.mHost.mFragmentManager.dispatchLowMemory();
    }

    public void dispatchMultiWindowModeChanged(boolean arg2) {
        this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(arg2);
    }

    public boolean dispatchOptionsItemSelected(MenuItem arg2) {
        return this.mHost.mFragmentManager.dispatchOptionsItemSelected(arg2);
    }

    public void dispatchOptionsMenuClosed(Menu arg2) {
        this.mHost.mFragmentManager.dispatchOptionsMenuClosed(arg2);
    }

    public void dispatchPause() {
        this.mHost.mFragmentManager.dispatchPause();
    }

    public void dispatchPictureInPictureModeChanged(boolean arg2) {
        this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(arg2);
    }

    public boolean dispatchPrepareOptionsMenu(Menu arg2) {
        return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(arg2);
    }

    public void dispatchReallyStop() {
        this.mHost.mFragmentManager.dispatchReallyStop();
    }

    public void dispatchResume() {
        this.mHost.mFragmentManager.dispatchResume();
    }

    public void dispatchStart() {
        this.mHost.mFragmentManager.dispatchStart();
    }

    public void dispatchStop() {
        this.mHost.mFragmentManager.dispatchStop();
    }

    public void doLoaderDestroy() {
        this.mHost.doLoaderDestroy();
    }

    public void doLoaderRetain() {
        this.mHost.doLoaderRetain();
    }

    public void doLoaderStart() {
        this.mHost.doLoaderStart();
    }

    public void doLoaderStop(boolean arg2) {
        this.mHost.doLoaderStop(arg2);
    }

    public void dumpLoaders(String arg2, FileDescriptor arg3, PrintWriter arg4, String[] arg5) {
        this.mHost.dumpLoaders(arg2, arg3, arg4, arg5);
    }

    public boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions();
    }

    @Nullable public Fragment findFragmentByWho(String arg2) {
        return this.mHost.mFragmentManager.findFragmentByWho(arg2);
    }

    public List getActiveFragments(List arg2) {
        ArrayList v2;
        if(this.mHost.mFragmentManager.mActive == null) {
            arg2 = null;
        }
        else {
            if(arg2 == null) {
                v2 = new ArrayList(this.getActiveFragmentsCount());
            }

            ((List)v2).addAll(this.mHost.mFragmentManager.mActive);
        }

        return arg2;
    }

    public int getActiveFragmentsCount() {
        ArrayList v0 = this.mHost.mFragmentManager.mActive;
        int v0_1 = v0 == null ? 0 : ((List)v0).size();
        return v0_1;
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mHost.getFragmentManagerImpl();
    }

    public LoaderManager getSupportLoaderManager() {
        return this.mHost.getLoaderManagerImpl();
    }

    public void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }

    public View onCreateView(View arg2, String arg3, Context arg4, AttributeSet arg5) {
        return this.mHost.mFragmentManager.onCreateView(arg2, arg3, arg4, arg5);
    }

    public void reportLoaderStart() {
        this.mHost.reportLoaderStart();
    }

    public void restoreAllState(Parcelable arg2, FragmentManagerNonConfig arg3) {
        this.mHost.mFragmentManager.restoreAllState(arg2, arg3);
    }

    @Deprecated public void restoreAllState(Parcelable arg4, List arg5) {
        this.mHost.mFragmentManager.restoreAllState(arg4, new FragmentManagerNonConfig(arg5, null));
    }

    public void restoreLoaderNonConfig(SimpleArrayMap arg2) {
        this.mHost.restoreLoaderNonConfig(arg2);
    }

    public SimpleArrayMap retainLoaderNonConfig() {
        return this.mHost.retainLoaderNonConfig();
    }

    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.mHost.mFragmentManager.retainNonConfig();
    }

    @Deprecated public List retainNonConfig() {
        FragmentManagerNonConfig v0 = this.mHost.mFragmentManager.retainNonConfig();
        List v0_1 = v0 != null ? v0.getFragments() : null;
        return v0_1;
    }

    public Parcelable saveAllState() {
        return this.mHost.mFragmentManager.saveAllState();
    }
}

