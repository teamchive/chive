package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.annotation.StringRes;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class FragmentManager {
    public interface BackStackEntry {
        CharSequence getBreadCrumbShortTitle();

        @StringRes int getBreadCrumbShortTitleRes();

        CharSequence getBreadCrumbTitle();

        @StringRes int getBreadCrumbTitleRes();

        int getId();

        String getName();
    }

    public abstract class FragmentLifecycleCallbacks {
        public FragmentLifecycleCallbacks() {
            super();
        }

        public void onFragmentActivityCreated(FragmentManager arg1, Fragment arg2, Bundle arg3) {
        }

        public void onFragmentAttached(FragmentManager arg1, Fragment arg2, Context arg3) {
        }

        public void onFragmentCreated(FragmentManager arg1, Fragment arg2, Bundle arg3) {
        }

        public void onFragmentDestroyed(FragmentManager arg1, Fragment arg2) {
        }

        public void onFragmentDetached(FragmentManager arg1, Fragment arg2) {
        }

        public void onFragmentPaused(FragmentManager arg1, Fragment arg2) {
        }

        public void onFragmentPreAttached(FragmentManager arg1, Fragment arg2, Context arg3) {
        }

        public void onFragmentResumed(FragmentManager arg1, Fragment arg2) {
        }

        public void onFragmentSaveInstanceState(FragmentManager arg1, Fragment arg2, Bundle arg3) {
        }

        public void onFragmentStarted(FragmentManager arg1, Fragment arg2) {
        }

        public void onFragmentStopped(FragmentManager arg1, Fragment arg2) {
        }

        public void onFragmentViewCreated(FragmentManager arg1, Fragment arg2, View arg3, Bundle arg4) {
        }

        public void onFragmentViewDestroyed(FragmentManager arg1, Fragment arg2) {
        }
    }

    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    public FragmentManager() {
        super();
    }

    public abstract void addOnBackStackChangedListener(OnBackStackChangedListener arg1);

    public abstract FragmentTransaction beginTransaction();

    public abstract void dump(String arg1, FileDescriptor arg2, PrintWriter arg3, String[] arg4);

    public static void enableDebugLogging(boolean arg0) {
        FragmentManagerImpl.DEBUG = arg0;
    }

    public abstract boolean executePendingTransactions();

    public abstract Fragment findFragmentById(@IdRes int arg1);

    public abstract Fragment findFragmentByTag(String arg1);

    public abstract BackStackEntry getBackStackEntryAt(int arg1);

    public abstract int getBackStackEntryCount();

    public abstract Fragment getFragment(Bundle arg1, String arg2);

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public abstract List getFragments();

    public abstract boolean isDestroyed();

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Deprecated public FragmentTransaction openTransaction() {
        return this.beginTransaction();
    }

    public abstract void popBackStack(int arg1, int arg2);

    public abstract void popBackStack();

    public abstract void popBackStack(String arg1, int arg2);

    public abstract boolean popBackStackImmediate();

    public abstract boolean popBackStackImmediate(int arg1, int arg2);

    public abstract boolean popBackStackImmediate(String arg1, int arg2);

    public abstract void putFragment(Bundle arg1, String arg2, Fragment arg3);

    public abstract void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks arg1, boolean arg2);

    public abstract void removeOnBackStackChangedListener(OnBackStackChangedListener arg1);

    public abstract SavedState saveFragmentInstanceState(Fragment arg1);

    public abstract void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks arg1);
}

