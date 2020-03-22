package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.annotation.StringRes;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View$OnCreateContextMenuListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment implements ComponentCallbacks, View$OnCreateContextMenuListener {
    class AnimationInfo {
        private Boolean mAllowEnterTransitionOverlap;
        private Boolean mAllowReturnTransitionOverlap;
        View mAnimatingAway;
        private Object mEnterTransition;
        SharedElementCallback mEnterTransitionCallback;
        boolean mEnterTransitionPostponed;
        private Object mExitTransition;
        SharedElementCallback mExitTransitionCallback;
        boolean mIsHideReplaced;
        int mNextAnim;
        int mNextTransition;
        int mNextTransitionStyle;
        private Object mReenterTransition;
        private Object mReturnTransition;
        private Object mSharedElementEnterTransition;
        private Object mSharedElementReturnTransition;
        OnStartEnterTransitionListener mStartEnterTransitionListener;
        int mStateAfterAnimating;

        AnimationInfo() {
            super();
            this.mEnterTransition = null;
            this.mReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
            this.mExitTransition = null;
            this.mReenterTransition = Fragment.USE_DEFAULT_TRANSITION;
            this.mSharedElementEnterTransition = null;
            this.mSharedElementReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
            this.mEnterTransitionCallback = null;
            this.mExitTransitionCallback = null;
        }

        static Object access$000(AnimationInfo arg1) {
            return arg1.mEnterTransition;
        }

        static Object access$002(AnimationInfo arg0, Object arg1) {
            arg0.mEnterTransition = arg1;
            return arg1;
        }

        static Object access$100(AnimationInfo arg1) {
            return arg1.mReturnTransition;
        }

        static Object access$102(AnimationInfo arg0, Object arg1) {
            arg0.mReturnTransition = arg1;
            return arg1;
        }

        static Object access$200(AnimationInfo arg1) {
            return arg1.mExitTransition;
        }

        static Object access$202(AnimationInfo arg0, Object arg1) {
            arg0.mExitTransition = arg1;
            return arg1;
        }

        static Object access$300(AnimationInfo arg1) {
            return arg1.mReenterTransition;
        }

        static Object access$302(AnimationInfo arg0, Object arg1) {
            arg0.mReenterTransition = arg1;
            return arg1;
        }

        static Object access$400(AnimationInfo arg1) {
            return arg1.mSharedElementEnterTransition;
        }

        static Object access$402(AnimationInfo arg0, Object arg1) {
            arg0.mSharedElementEnterTransition = arg1;
            return arg1;
        }

        static Object access$500(AnimationInfo arg1) {
            return arg1.mSharedElementReturnTransition;
        }

        static Object access$502(AnimationInfo arg0, Object arg1) {
            arg0.mSharedElementReturnTransition = arg1;
            return arg1;
        }

        static Boolean access$600(AnimationInfo arg1) {
            return arg1.mAllowEnterTransitionOverlap;
        }

        static Boolean access$602(AnimationInfo arg0, Boolean arg1) {
            arg0.mAllowEnterTransitionOverlap = arg1;
            return arg1;
        }

        static Boolean access$700(AnimationInfo arg1) {
            return arg1.mAllowReturnTransitionOverlap;
        }

        static Boolean access$702(AnimationInfo arg0, Boolean arg1) {
            arg0.mAllowReturnTransitionOverlap = arg1;
            return arg1;
        }
    }

    public class InstantiationException extends RuntimeException {
        public InstantiationException(String arg1, Exception arg2) {
            super(arg1, ((Throwable)arg2));
        }
    }

    interface OnStartEnterTransitionListener {
        void onStartEnterTransition();

        void startListening();
    }

    public class SavedState implements Parcelable {
        final class android.support.v4.app.Fragment$SavedState$1 implements Parcelable$Creator {
            android.support.v4.app.Fragment$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg3) {
                return new SavedState(arg3, null);
            }

            public Object createFromParcel(Parcel arg2) {
                return this.createFromParcel(arg2);
            }

            public SavedState[] newArray(int arg2) {
                return new SavedState[arg2];
            }

            public Object[] newArray(int arg2) {
                return this.newArray(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR;
        final Bundle mState;

        static {
            SavedState.CREATOR = new android.support.v4.app.Fragment$SavedState$1();
        }

        SavedState(Bundle arg1) {
            super();
            this.mState = arg1;
        }

        SavedState(Parcel arg2, ClassLoader arg3) {
            super();
            this.mState = arg2.readBundle();
            if(arg3 != null && this.mState != null) {
                this.mState.setClassLoader(arg3);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            arg2.writeBundle(this.mState);
        }
    }

    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 5;
    static final int STARTED = 4;
    static final int STOPPED = 3;
    static final Object USE_DEFAULT_TRANSITION;
    boolean mAdded;
    AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    boolean mCheckedForLoaderManager;
    FragmentManagerImpl mChildFragmentManager;
    FragmentManagerNonConfig mChildNonConfig;
    ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManagerImpl mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback mHost;
    boolean mInLayout;
    int mIndex;
    View mInnerView;
    boolean mIsNewlyAdded;
    LoaderManagerImpl mLoaderManager;
    boolean mLoadersStarted;
    boolean mMenuVisible;
    Fragment mParentFragment;
    float mPostponedAlpha;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetaining;
    Bundle mSavedFragmentState;
    SparseArray mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetIndex;
    int mTargetRequestCode;
    boolean mUserVisibleHint;
    View mView;
    String mWho;
    private static final SimpleArrayMap sClassMap;

    static {
        Fragment.sClassMap = new SimpleArrayMap();
        Fragment.USE_DEFAULT_TRANSITION = new Object();
    }

    public Fragment() {
        super();
        this.mState = 0;
        this.mIndex = -1;
        this.mTargetIndex = -1;
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
    }

    static void access$800(Fragment arg0) {
        arg0.callStartTransitionListener();
    }

    private void callStartTransitionListener() {
        OnStartEnterTransitionListener v0 = null;
        if(this.mAnimationInfo != null) {
            this.mAnimationInfo.mEnterTransitionPostponed = false;
            OnStartEnterTransitionListener v1 = this.mAnimationInfo.mStartEnterTransitionListener;
            this.mAnimationInfo.mStartEnterTransitionListener = v0;
            v0 = v1;
        }

        if(v0 != null) {
            v0.onStartEnterTransition();
        }
    }

    public void dump(String arg4, FileDescriptor arg5, PrintWriter arg6, String[] arg7) {
        arg6.print(arg4);
        arg6.print("mFragmentId=#");
        arg6.print(Integer.toHexString(this.mFragmentId));
        arg6.print(" mContainerId=#");
        arg6.print(Integer.toHexString(this.mContainerId));
        arg6.print(" mTag=");
        arg6.println(this.mTag);
        arg6.print(arg4);
        arg6.print("mState=");
        arg6.print(this.mState);
        arg6.print(" mIndex=");
        arg6.print(this.mIndex);
        arg6.print(" mWho=");
        arg6.print(this.mWho);
        arg6.print(" mBackStackNesting=");
        arg6.println(this.mBackStackNesting);
        arg6.print(arg4);
        arg6.print("mAdded=");
        arg6.print(this.mAdded);
        arg6.print(" mRemoving=");
        arg6.print(this.mRemoving);
        arg6.print(" mFromLayout=");
        arg6.print(this.mFromLayout);
        arg6.print(" mInLayout=");
        arg6.println(this.mInLayout);
        arg6.print(arg4);
        arg6.print("mHidden=");
        arg6.print(this.mHidden);
        arg6.print(" mDetached=");
        arg6.print(this.mDetached);
        arg6.print(" mMenuVisible=");
        arg6.print(this.mMenuVisible);
        arg6.print(" mHasMenu=");
        arg6.println(this.mHasMenu);
        arg6.print(arg4);
        arg6.print("mRetainInstance=");
        arg6.print(this.mRetainInstance);
        arg6.print(" mRetaining=");
        arg6.print(this.mRetaining);
        arg6.print(" mUserVisibleHint=");
        arg6.println(this.mUserVisibleHint);
        if(this.mFragmentManager != null) {
            arg6.print(arg4);
            arg6.print("mFragmentManager=");
            arg6.println(this.mFragmentManager);
        }

        if(this.mHost != null) {
            arg6.print(arg4);
            arg6.print("mHost=");
            arg6.println(this.mHost);
        }

        if(this.mParentFragment != null) {
            arg6.print(arg4);
            arg6.print("mParentFragment=");
            arg6.println(this.mParentFragment);
        }

        if(this.mArguments != null) {
            arg6.print(arg4);
            arg6.print("mArguments=");
            arg6.println(this.mArguments);
        }

        if(this.mSavedFragmentState != null) {
            arg6.print(arg4);
            arg6.print("mSavedFragmentState=");
            arg6.println(this.mSavedFragmentState);
        }

        if(this.mSavedViewState != null) {
            arg6.print(arg4);
            arg6.print("mSavedViewState=");
            arg6.println(this.mSavedViewState);
        }

        if(this.mTarget != null) {
            arg6.print(arg4);
            arg6.print("mTarget=");
            arg6.print(this.mTarget);
            arg6.print(" mTargetRequestCode=");
            arg6.println(this.mTargetRequestCode);
        }

        if(this.getNextAnim() != 0) {
            arg6.print(arg4);
            arg6.print("mNextAnim=");
            arg6.println(this.getNextAnim());
        }

        if(this.mContainer != null) {
            arg6.print(arg4);
            arg6.print("mContainer=");
            arg6.println(this.mContainer);
        }

        if(this.mView != null) {
            arg6.print(arg4);
            arg6.print("mView=");
            arg6.println(this.mView);
        }

        if(this.mInnerView != null) {
            arg6.print(arg4);
            arg6.print("mInnerView=");
            arg6.println(this.mView);
        }

        if(this.getAnimatingAway() != null) {
            arg6.print(arg4);
            arg6.print("mAnimatingAway=");
            arg6.println(this.getAnimatingAway());
            arg6.print(arg4);
            arg6.print("mStateAfterAnimating=");
            arg6.println(this.getStateAfterAnimating());
        }

        if(this.mLoaderManager != null) {
            arg6.print(arg4);
            arg6.println("Loader Manager:");
            this.mLoaderManager.dump(arg4 + "  ", arg5, arg6, arg7);
        }

        if(this.mChildFragmentManager != null) {
            arg6.print(arg4);
            arg6.println("Child " + this.mChildFragmentManager + ":");
            this.mChildFragmentManager.dump(arg4 + "  ", arg5, arg6, arg7);
        }
    }

    private AnimationInfo ensureAnimationInfo() {
        if(this.mAnimationInfo == null) {
            this.mAnimationInfo = new AnimationInfo();
        }

        return this.mAnimationInfo;
    }

    public final boolean equals(Object arg2) {
        return super.equals(arg2);
    }

    Fragment findFragmentByWho(String arg2) {
        if(!arg2.equals(this.mWho)) {
            this = this.mChildFragmentManager != null ? this.mChildFragmentManager.findFragmentByWho(arg2) : null;
        }

        return this;
    }

    public final FragmentActivity getActivity() {
        FragmentActivity v0;
        if(this.mHost == null) {
            v0 = null;
        }
        else {
            Activity v0_1 = this.mHost.getActivity();
        }

        return v0;
    }

    public boolean getAllowEnterTransitionOverlap() {
        boolean v0 = this.mAnimationInfo == null || AnimationInfo.access$600(this.mAnimationInfo) == null ? true : AnimationInfo.access$600(this.mAnimationInfo).booleanValue();
        return v0;
    }

    public boolean getAllowReturnTransitionOverlap() {
        boolean v0 = this.mAnimationInfo == null || AnimationInfo.access$700(this.mAnimationInfo) == null ? true : AnimationInfo.access$700(this.mAnimationInfo).booleanValue();
        return v0;
    }

    View getAnimatingAway() {
        View v0 = this.mAnimationInfo == null ? null : this.mAnimationInfo.mAnimatingAway;
        return v0;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getChildFragmentManager() {
        if(this.mChildFragmentManager == null) {
            this.instantiateChildFragmentManager();
            if(this.mState >= 5) {
                this.mChildFragmentManager.dispatchResume();
            }
            else if(this.mState >= 4) {
                this.mChildFragmentManager.dispatchStart();
            }
            else if(this.mState >= 2) {
                this.mChildFragmentManager.dispatchActivityCreated();
            }
            else if(this.mState >= 1) {
                this.mChildFragmentManager.dispatchCreate();
            }
        }

        return this.mChildFragmentManager;
    }

    public Context getContext() {
        Context v0 = this.mHost == null ? null : this.mHost.getContext();
        return v0;
    }

    public Object getEnterTransition() {
        Object v0 = this.mAnimationInfo == null ? null : AnimationInfo.access$000(this.mAnimationInfo);
        return v0;
    }

    SharedElementCallback getEnterTransitionCallback() {
        SharedElementCallback v0 = this.mAnimationInfo == null ? null : this.mAnimationInfo.mEnterTransitionCallback;
        return v0;
    }

    public Object getExitTransition() {
        Object v0 = this.mAnimationInfo == null ? null : AnimationInfo.access$200(this.mAnimationInfo);
        return v0;
    }

    SharedElementCallback getExitTransitionCallback() {
        SharedElementCallback v0 = this.mAnimationInfo == null ? null : this.mAnimationInfo.mExitTransitionCallback;
        return v0;
    }

    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        Object v0 = this.mHost == null ? null : this.mHost.onGetHost();
        return v0;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public LayoutInflater getLayoutInflater(Bundle arg3) {
        LayoutInflater v0 = this.mHost.onGetLayoutInflater();
        this.getChildFragmentManager();
        LayoutInflaterCompat.setFactory(v0, this.mChildFragmentManager.getLayoutInflaterFactory());
        return v0;
    }

    public LoaderManager getLoaderManager() {
        LoaderManagerImpl v0;
        if(this.mLoaderManager != null) {
            v0 = this.mLoaderManager;
        }
        else if(this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        else {
            this.mCheckedForLoaderManager = true;
            this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, true);
            v0 = this.mLoaderManager;
        }

        return ((LoaderManager)v0);
    }

    int getNextAnim() {
        int v0 = this.mAnimationInfo == null ? 0 : this.mAnimationInfo.mNextAnim;
        return v0;
    }

    int getNextTransition() {
        int v0 = this.mAnimationInfo == null ? 0 : this.mAnimationInfo.mNextTransition;
        return v0;
    }

    int getNextTransitionStyle() {
        int v0 = this.mAnimationInfo == null ? 0 : this.mAnimationInfo.mNextTransitionStyle;
        return v0;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public Object getReenterTransition() {
        Object v0;
        if(this.mAnimationInfo == null) {
            v0 = null;
        }
        else if(AnimationInfo.access$300(this.mAnimationInfo) == Fragment.USE_DEFAULT_TRANSITION) {
            v0 = this.getExitTransition();
        }
        else {
            v0 = AnimationInfo.access$300(this.mAnimationInfo);
        }

        return v0;
    }

    public final Resources getResources() {
        if(this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }

        return this.mHost.getContext().getResources();
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        Object v0;
        if(this.mAnimationInfo == null) {
            v0 = null;
        }
        else if(AnimationInfo.access$100(this.mAnimationInfo) == Fragment.USE_DEFAULT_TRANSITION) {
            v0 = this.getEnterTransition();
        }
        else {
            v0 = AnimationInfo.access$100(this.mAnimationInfo);
        }

        return v0;
    }

    public Object getSharedElementEnterTransition() {
        Object v0 = this.mAnimationInfo == null ? null : AnimationInfo.access$400(this.mAnimationInfo);
        return v0;
    }

    public Object getSharedElementReturnTransition() {
        Object v0;
        if(this.mAnimationInfo == null) {
            v0 = null;
        }
        else if(AnimationInfo.access$500(this.mAnimationInfo) == Fragment.USE_DEFAULT_TRANSITION) {
            v0 = this.getSharedElementEnterTransition();
        }
        else {
            v0 = AnimationInfo.access$500(this.mAnimationInfo);
        }

        return v0;
    }

    int getStateAfterAnimating() {
        int v0 = this.mAnimationInfo == null ? 0 : this.mAnimationInfo.mStateAfterAnimating;
        return v0;
    }

    public final String getString(@StringRes int arg2) {
        return this.getResources().getString(arg2);
    }

    public final String getString(@StringRes int arg2, Object[] arg3) {
        return this.getResources().getString(arg2, arg3);
    }

    public final String getTag() {
        return this.mTag;
    }

    public final Fragment getTargetFragment() {
        return this.mTarget;
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(@StringRes int arg2) {
        return this.getResources().getText(arg2);
    }

    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @Nullable public View getView() {
        return this.mView;
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
        this.mIndex = -1;
        this.mWho = null;
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = null;
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
        this.mRetaining = false;
        this.mLoaderManager = null;
        this.mLoadersStarted = false;
        this.mCheckedForLoaderManager = false;
    }

    public static Fragment instantiate(Context arg1, String arg2) {
        return Fragment.instantiate(arg1, arg2, null);
    }

    public static Fragment instantiate(Context arg4, String arg5, @Nullable Bundle arg6) {
        Class v0_4;
        Object v0_3;
        try {
            v0_3 = Fragment.sClassMap.get(arg5);
            if(v0_3 == null) {
                v0_4 = arg4.getClassLoader().loadClass(arg5);
                Fragment.sClassMap.put(arg5, v0_4);
            }

            v0_3 = v0_4.newInstance();
            if(arg6 != null) {
                arg6.setClassLoader(v0_3.getClass().getClassLoader());
                ((Fragment)v0_3).mArguments = arg6;
            }
        }
        catch(IllegalAccessException v0) {
            throw new InstantiationException("Unable to instantiate fragment " + arg5 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", ((Exception)v0));
        }
        catch(java.lang.InstantiationException v0_1) {
            throw new InstantiationException("Unable to instantiate fragment " + arg5 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", ((Exception)v0_1));
        }
        catch(ClassNotFoundException v0_2) {
            throw new InstantiationException("Unable to instantiate fragment " + arg5 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", ((Exception)v0_2));
        }

        return ((Fragment)v0_3);
    }

    void instantiateChildFragmentManager() {
        if(this.mHost == null) {
            throw new IllegalStateException("Fragment has not been attached yet.");
        }

        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mChildFragmentManager.attachController(this.mHost, new FragmentContainer() {
            @Nullable public View onFindViewById(int arg3) {
                if(Fragment.this.mView == null) {
                    throw new IllegalStateException("Fragment does not have a view");
                }

                return Fragment.this.mView.findViewById(arg3);
            }

            public boolean onHasView() {
                boolean v0 = Fragment.this.mView != null ? true : false;
                return v0;
            }
        }, this);
    }

    public final boolean isAdded() {
        boolean v0 = this.mHost == null || !this.mAdded ? false : true;
        return v0;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    boolean isHideReplaced() {
        boolean v0 = this.mAnimationInfo == null ? false : this.mAnimationInfo.mIsHideReplaced;
        return v0;
    }

    final boolean isInBackStack() {
        boolean v0 = this.mBackStackNesting > 0 ? true : false;
        return v0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    boolean isPostponed() {
        boolean v0 = this.mAnimationInfo == null ? false : this.mAnimationInfo.mEnterTransitionPostponed;
        return v0;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        boolean v0 = this.mState >= 5 ? true : false;
        return v0;
    }

    static boolean isSupportFragmentClass(Context arg2, String arg3) {
        boolean v0_3;
        Class v0_2;
        try {
            Object v0_1 = Fragment.sClassMap.get(arg3);
            if(v0_1 == null) {
                v0_2 = arg2.getClassLoader().loadClass(arg3);
                Fragment.sClassMap.put(arg3, v0_2);
            }

            v0_3 = Fragment.class.isAssignableFrom(v0_2);
        }
        catch(ClassNotFoundException v0) {
            v0_3 = false;
        }

        return v0_3;
    }

    public final boolean isVisible() {
        boolean v0 = !this.isAdded() || (this.isHidden()) || this.mView == null || this.mView.getWindowToken() == null || this.mView.getVisibility() != 0 ? false : true;
        return v0;
    }

    @CallSuper public void onActivityCreated(@Nullable Bundle arg2) {
        this.mCalled = true;
    }

    public void onActivityResult(int arg1, int arg2, Intent arg3) {
    }

    @CallSuper @Deprecated public void onAttach(Activity arg2) {
        this.mCalled = true;
    }

    @CallSuper public void onAttach(Context arg3) {
        this.mCalled = true;
        Activity v0 = this.mHost == null ? null : this.mHost.getActivity();
        if(v0 != null) {
            this.mCalled = false;
            this.onAttach(v0);
        }
    }

    public void onAttachFragment(Fragment arg1) {
    }

    @CallSuper public void onConfigurationChanged(Configuration arg2) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem arg2) {
        return 0;
    }

    @CallSuper public void onCreate(@Nullable Bundle arg3) {
        this.mCalled = true;
        this.restoreChildFragmentState(arg3);
        if(this.mChildFragmentManager != null && !this.mChildFragmentManager.isStateAtLeast(1)) {
            this.mChildFragmentManager.dispatchCreate();
        }
    }

    public Animation onCreateAnimation(int arg2, boolean arg3, int arg4) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu arg2, View arg3, ContextMenu$ContextMenuInfo arg4) {
        this.getActivity().onCreateContextMenu(arg2, arg3, arg4);
    }

    public void onCreateOptionsMenu(Menu arg1, MenuInflater arg2) {
    }

    @Nullable public View onCreateView(LayoutInflater arg2, @Nullable ViewGroup arg3, @Nullable Bundle arg4) {
        return null;
    }

    @CallSuper public void onDestroy() {
        this.mCalled = true;
        if(!this.mCheckedForLoaderManager) {
            this.mCheckedForLoaderManager = true;
            this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
        }

        if(this.mLoaderManager != null) {
            this.mLoaderManager.doDestroy();
        }
    }

    public void onDestroyOptionsMenu() {
    }

    @CallSuper public void onDestroyView() {
        this.mCalled = true;
    }

    @CallSuper public void onDetach() {
        this.mCalled = true;
    }

    public void onHiddenChanged(boolean arg1) {
    }

    @CallSuper @Deprecated public void onInflate(Activity arg2, AttributeSet arg3, Bundle arg4) {
        this.mCalled = true;
    }

    @CallSuper public void onInflate(Context arg3, AttributeSet arg4, Bundle arg5) {
        this.mCalled = true;
        Activity v0 = this.mHost == null ? null : this.mHost.getActivity();
        if(v0 != null) {
            this.mCalled = false;
            this.onInflate(v0, arg4, arg5);
        }
    }

    @CallSuper public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean arg1) {
    }

    public boolean onOptionsItemSelected(MenuItem arg2) {
        return 0;
    }

    public void onOptionsMenuClosed(Menu arg1) {
    }

    @CallSuper public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean arg1) {
    }

    public void onPrepareOptionsMenu(Menu arg1) {
    }

    public void onRequestPermissionsResult(int arg1, @NonNull String[] arg2, @NonNull int[] arg3) {
    }

    @CallSuper public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle arg1) {
    }

    @CallSuper public void onStart() {
        this.mCalled = true;
        if(!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if(!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = true;
                this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
            }

            if(this.mLoaderManager == null) {
                return;
            }

            this.mLoaderManager.doStart();
        }
    }

    @CallSuper public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View arg1, @Nullable Bundle arg2) {
    }

    @CallSuper public void onViewStateRestored(@Nullable Bundle arg2) {
        this.mCalled = true;
    }

    FragmentManager peekChildFragmentManager() {
        return this.mChildFragmentManager;
    }

    void performActivityCreated(Bundle arg4) {
        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }

        this.mState = 2;
        this.mCalled = false;
        this.onActivityCreated(arg4);
        if(!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }

        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchActivityCreated();
        }
    }

    void performConfigurationChanged(Configuration arg2) {
        this.onConfigurationChanged(arg2);
        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchConfigurationChanged(arg2);
        }
    }

    boolean performContextItemSelected(MenuItem arg3) {
        boolean v0 = true;
        if(this.mHidden) {
        label_11:
            v0 = false;
        }
        else if(!this.onContextItemSelected(arg3)) {
            if(this.mChildFragmentManager == null) {
                goto label_11;
            }
            else if(!this.mChildFragmentManager.dispatchContextItemSelected(arg3)) {
                goto label_11;
            }
        }

        return v0;
    }

    void performCreate(Bundle arg4) {
        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }

        this.mState = 1;
        this.mCalled = false;
        this.onCreate(arg4);
        if(!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
        }
    }

    boolean performCreateOptionsMenu(Menu arg3, MenuInflater arg4) {
        int v0 = 0;
        if(!this.mHidden) {
            if((this.mHasMenu) && (this.mMenuVisible)) {
                v0 = 1;
                this.onCreateOptionsMenu(arg3, arg4);
            }

            if(this.mChildFragmentManager == null) {
                goto label_14;
            }

            v0 |= this.mChildFragmentManager.dispatchCreateOptionsMenu(arg3, arg4);
        }

    label_14:
        return ((boolean)v0);
    }

    View performCreateView(LayoutInflater arg2, ViewGroup arg3, Bundle arg4) {
        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }

        return this.onCreateView(arg2, arg3, arg4);
    }

    void performDestroy() {
        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchDestroy();
        }

        this.mState = 0;
        this.mCalled = false;
        this.onDestroy();
        if(!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }

        this.mChildFragmentManager = null;
    }

    void performDestroyView() {
        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchDestroyView();
        }

        this.mState = 1;
        this.mCalled = false;
        this.onDestroyView();
        if(!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }

        if(this.mLoaderManager != null) {
            this.mLoaderManager.doReportNextStart();
        }
    }

    void performDetach() {
        this.mCalled = false;
        this.onDetach();
        if(!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
        }

        if(this.mChildFragmentManager != null) {
            if(!this.mRetaining) {
                throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
            }
            else {
                this.mChildFragmentManager.dispatchDestroy();
                this.mChildFragmentManager = null;
            }
        }
    }

    void performLowMemory() {
        this.onLowMemory();
        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchLowMemory();
        }
    }

    void performMultiWindowModeChanged(boolean arg2) {
        this.onMultiWindowModeChanged(arg2);
        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchMultiWindowModeChanged(arg2);
        }
    }

    boolean performOptionsItemSelected(MenuItem arg3) {
        boolean v0 = true;
        if(!this.mHidden) {
            if((this.mHasMenu) && (this.mMenuVisible) && (this.onOptionsItemSelected(arg3))) {
                return v0;
            }

            if(this.mChildFragmentManager == null) {
                goto label_15;
            }

            if(this.mChildFragmentManager.dispatchOptionsItemSelected(arg3)) {
                return v0;
            }

            goto label_15;
        }
        else {
        label_15:
            v0 = false;
        }

        return v0;
    }

    void performOptionsMenuClosed(Menu arg2) {
        if(!this.mHidden) {
            if((this.mHasMenu) && (this.mMenuVisible)) {
                this.onOptionsMenuClosed(arg2);
            }

            if(this.mChildFragmentManager == null) {
                return;
            }

            this.mChildFragmentManager.dispatchOptionsMenuClosed(arg2);
        }
    }

    void performPause() {
        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchPause();
        }

        this.mState = 4;
        this.mCalled = false;
        this.onPause();
        if(!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void performPictureInPictureModeChanged(boolean arg2) {
        this.onPictureInPictureModeChanged(arg2);
        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchPictureInPictureModeChanged(arg2);
        }
    }

    boolean performPrepareOptionsMenu(Menu arg3) {
        int v0 = 0;
        if(!this.mHidden) {
            if((this.mHasMenu) && (this.mMenuVisible)) {
                v0 = 1;
                this.onPrepareOptionsMenu(arg3);
            }

            if(this.mChildFragmentManager == null) {
                goto label_14;
            }

            v0 |= this.mChildFragmentManager.dispatchPrepareOptionsMenu(arg3);
        }

    label_14:
        return ((boolean)v0);
    }

    void performReallyStop() {
        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchReallyStop();
        }

        this.mState = 2;
        if(this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if(!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = true;
                this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
            }

            if(this.mLoaderManager == null) {
                return;
            }

            if(this.mHost.getRetainLoaders()) {
                this.mLoaderManager.doRetain();
                return;
            }

            this.mLoaderManager.doStop();
        }
    }

    void performResume() {
        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
            this.mChildFragmentManager.execPendingActions();
        }

        this.mState = 5;
        this.mCalled = false;
        this.onResume();
        if(!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }

        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchResume();
            this.mChildFragmentManager.execPendingActions();
        }
    }

    void performSaveInstanceState(Bundle arg3) {
        this.onSaveInstanceState(arg3);
        if(this.mChildFragmentManager != null) {
            Parcelable v0 = this.mChildFragmentManager.saveAllState();
            if(v0 != null) {
                arg3.putParcelable("android:support:fragments", v0);
            }
        }
    }

    void performStart() {
        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
            this.mChildFragmentManager.execPendingActions();
        }

        this.mState = 4;
        this.mCalled = false;
        this.onStart();
        if(!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }

        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchStart();
        }

        if(this.mLoaderManager != null) {
            this.mLoaderManager.doReportStart();
        }
    }

    void performStop() {
        if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchStop();
        }

        this.mState = 3;
        this.mCalled = false;
        this.onStop();
        if(!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public void postponeEnterTransition() {
        this.ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    public void registerForContextMenu(View arg1) {
        arg1.setOnCreateContextMenuListener(((View$OnCreateContextMenuListener)this));
    }

    public final void requestPermissions(@NonNull String[] arg4, int arg5) {
        if(this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }

        this.mHost.onRequestPermissionsFromFragment(this, arg4, arg5);
    }

    void restoreChildFragmentState(@Nullable Bundle arg4) {
        if(arg4 != null) {
            Parcelable v0 = arg4.getParcelable("android:support:fragments");
            if(v0 != null) {
                if(this.mChildFragmentManager == null) {
                    this.instantiateChildFragmentManager();
                }

                this.mChildFragmentManager.restoreAllState(v0, this.mChildNonConfig);
                this.mChildNonConfig = null;
                this.mChildFragmentManager.dispatchCreate();
            }
        }
    }

    final void restoreViewState(Bundle arg4) {
        if(this.mSavedViewState != null) {
            this.mInnerView.restoreHierarchyState(this.mSavedViewState);
            this.mSavedViewState = null;
        }

        this.mCalled = false;
        this.onViewStateRestored(arg4);
        if(!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void setAllowEnterTransitionOverlap(boolean arg3) {
        AnimationInfo.access$602(this.ensureAnimationInfo(), Boolean.valueOf(arg3));
    }

    public void setAllowReturnTransitionOverlap(boolean arg3) {
        AnimationInfo.access$702(this.ensureAnimationInfo(), Boolean.valueOf(arg3));
    }

    void setAnimatingAway(View arg2) {
        this.ensureAnimationInfo().mAnimatingAway = arg2;
    }

    public void setArguments(Bundle arg3) {
        if(this.mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }

        this.mArguments = arg3;
    }

    public void setEnterSharedElementCallback(SharedElementCallback arg2) {
        this.ensureAnimationInfo().mEnterTransitionCallback = arg2;
    }

    public void setEnterTransition(Object arg2) {
        AnimationInfo.access$002(this.ensureAnimationInfo(), arg2);
    }

    public void setExitSharedElementCallback(SharedElementCallback arg2) {
        this.ensureAnimationInfo().mExitTransitionCallback = arg2;
    }

    public void setExitTransition(Object arg2) {
        AnimationInfo.access$202(this.ensureAnimationInfo(), arg2);
    }

    public void setHasOptionsMenu(boolean arg2) {
        if(this.mHasMenu != arg2) {
            this.mHasMenu = arg2;
            if((this.isAdded()) && !this.isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    void setHideReplaced(boolean arg2) {
        this.ensureAnimationInfo().mIsHideReplaced = arg2;
    }

    final void setIndex(int arg3, Fragment arg4) {
        this.mIndex = arg3;
        this.mWho = arg4 != null ? arg4.mWho + ":" + this.mIndex : "android:fragment:" + this.mIndex;
    }

    public void setInitialSavedState(SavedState arg3) {
        if(this.mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }

        Bundle v0 = arg3 == null || arg3.mState == null ? null : arg3.mState;
        this.mSavedFragmentState = v0;
    }

    public void setMenuVisibility(boolean arg2) {
        if(this.mMenuVisible != arg2) {
            this.mMenuVisible = arg2;
            if((this.mHasMenu) && (this.isAdded()) && !this.isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    void setNextAnim(int arg2) {
        if(this.mAnimationInfo != null || arg2 != 0) {
            this.ensureAnimationInfo().mNextAnim = arg2;
        }
    }

    void setNextTransition(int arg2, int arg3) {
        if(this.mAnimationInfo != null || arg2 != 0 || arg3 != 0) {
            this.ensureAnimationInfo();
            this.mAnimationInfo.mNextTransition = arg2;
            this.mAnimationInfo.mNextTransitionStyle = arg3;
        }
    }

    void setOnStartEnterTransitionListener(OnStartEnterTransitionListener arg4) {
        this.ensureAnimationInfo();
        if(arg4 != this.mAnimationInfo.mStartEnterTransitionListener) {
            if(arg4 != null && this.mAnimationInfo.mStartEnterTransitionListener != null) {
                throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
            }

            if(this.mAnimationInfo.mEnterTransitionPostponed) {
                this.mAnimationInfo.mStartEnterTransitionListener = arg4;
            }

            if(arg4 == null) {
                return;
            }

            arg4.startListening();
        }
    }

    public void setReenterTransition(Object arg2) {
        AnimationInfo.access$302(this.ensureAnimationInfo(), arg2);
    }

    public void setRetainInstance(boolean arg1) {
        this.mRetainInstance = arg1;
    }

    public void setReturnTransition(Object arg2) {
        AnimationInfo.access$102(this.ensureAnimationInfo(), arg2);
    }

    public void setSharedElementEnterTransition(Object arg2) {
        AnimationInfo.access$402(this.ensureAnimationInfo(), arg2);
    }

    public void setSharedElementReturnTransition(Object arg2) {
        AnimationInfo.access$502(this.ensureAnimationInfo(), arg2);
    }

    void setStateAfterAnimating(int arg2) {
        this.ensureAnimationInfo().mStateAfterAnimating = arg2;
    }

    public void setTargetFragment(Fragment arg1, int arg2) {
        this.mTarget = arg1;
        this.mTargetRequestCode = arg2;
    }

    public void setUserVisibleHint(boolean arg3) {
        int v1 = 4;
        if(!this.mUserVisibleHint && (arg3) && this.mState < v1 && this.mFragmentManager != null && (this.isAdded())) {
            this.mFragmentManager.performPendingDeferredStart(this);
        }

        this.mUserVisibleHint = arg3;
        boolean v0 = this.mState >= v1 || (arg3) ? false : true;
        this.mDeferStart = v0;
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String arg2) {
        boolean v0 = this.mHost != null ? this.mHost.onShouldShowRequestPermissionRationale(arg2) : false;
        return v0;
    }

    public void startActivity(Intent arg2) {
        this.startActivity(arg2, null);
    }

    public void startActivity(Intent arg4, @Nullable Bundle arg5) {
        if(this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }

        this.mHost.onStartActivityFromFragment(this, arg4, -1, arg5);
    }

    public void startActivityForResult(Intent arg2, int arg3) {
        this.startActivityForResult(arg2, arg3, null);
    }

    public void startActivityForResult(Intent arg4, int arg5, @Nullable Bundle arg6) {
        if(this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }

        this.mHost.onStartActivityFromFragment(this, arg4, arg5, arg6);
    }

    public void startIntentSenderForResult(IntentSender arg10, int arg11, @Nullable Intent arg12, int arg13, int arg14, int arg15, Bundle arg16) {
        if(this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }

        this.mHost.onStartIntentSenderFromFragment(this, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
    }

    public void startPostponedEnterTransition() {
        if(this.mFragmentManager == null || this.mFragmentManager.mHost == null) {
            this.ensureAnimationInfo().mEnterTransitionPostponed = false;
        }
        else if(Looper.myLooper() != this.mFragmentManager.mHost.getHandler().getLooper()) {
            this.mFragmentManager.mHost.getHandler().postAtFrontOfQueue(new Runnable() {
                public void run() {
                    Fragment.this.callStartTransitionListener();
                }
            });
        }
        else {
            this.callStartTransitionListener();
        }
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x80);
        DebugUtils.buildShortClassTag(this, v0);
        if(this.mIndex >= 0) {
            v0.append(" #");
            v0.append(this.mIndex);
        }

        if(this.mFragmentId != 0) {
            v0.append(" id=0x");
            v0.append(Integer.toHexString(this.mFragmentId));
        }

        if(this.mTag != null) {
            v0.append(" ");
            v0.append(this.mTag);
        }

        v0.append('}');
        return v0.toString();
    }

    public void unregisterForContextMenu(View arg2) {
        arg2.setOnCreateContextMenuListener(null);
    }
}

