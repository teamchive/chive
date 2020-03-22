package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources$NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.v4.os.BuildCompat;
import android.support.v4.util.ArraySet;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.util.Pair;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation$AnimationListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class FragmentManagerImpl extends FragmentManager implements LayoutInflaterFactory {
    class android.support.v4.app.FragmentManagerImpl$1 implements Runnable {
        android.support.v4.app.FragmentManagerImpl$1(FragmentManagerImpl arg1) {
            FragmentManagerImpl.this = arg1;
            super();
        }

        public void run() {
            FragmentManagerImpl.this.execPendingActions();
        }
    }

    class AnimateOnHWLayerIfNeededListener implements Animation$AnimationListener {
        private Animation$AnimationListener mOriginalListener;
        private boolean mShouldRunOnHWLayer;
        View mView;

        public AnimateOnHWLayerIfNeededListener(View arg2, Animation arg3, Animation$AnimationListener arg4) {
            super();
            if(arg2 != null && arg3 != null) {
                this.mOriginalListener = arg4;
                this.mView = arg2;
                this.mShouldRunOnHWLayer = true;
            }
        }

        public AnimateOnHWLayerIfNeededListener(View arg1, Animation arg2) {
            super();
            if(arg1 != null && arg2 != null) {
                this.mView = arg1;
            }
        }

        @CallSuper public void onAnimationEnd(Animation arg4) {
            if(this.mView != null && (this.mShouldRunOnHWLayer)) {
                if(!ViewCompat.isAttachedToWindow(this.mView) && !BuildCompat.isAtLeastN()) {
                    ViewCompat.setLayerType(this.mView, 0, null);
                    goto label_13;
                }

                this.mView.post(new Runnable() {
                    public void run() {
                        ViewCompat.setLayerType(AnimateOnHWLayerIfNeededListener.this.mView, 0, null);
                    }
                });
            }

        label_13:
            if(this.mOriginalListener != null) {
                this.mOriginalListener.onAnimationEnd(arg4);
            }
        }

        public void onAnimationRepeat(Animation arg2) {
            if(this.mOriginalListener != null) {
                this.mOriginalListener.onAnimationRepeat(arg2);
            }
        }

        @CallSuper public void onAnimationStart(Animation arg2) {
            if(this.mOriginalListener != null) {
                this.mOriginalListener.onAnimationStart(arg2);
            }
        }
    }

    class FragmentTag {
        public static final int[] Fragment = null;
        public static final int Fragment_id = 1;
        public static final int Fragment_name = 0;
        public static final int Fragment_tag = 2;

        static {
            FragmentTag.Fragment = new int[]{0x1010003, 0x10100D0, 0x10100D1};
        }

        FragmentTag() {
            super();
        }
    }

    interface OpGenerator {
        boolean generateOps(ArrayList arg1, ArrayList arg2);
    }

    class PopBackStackState implements OpGenerator {
        final int mFlags;
        final int mId;
        final String mName;

        PopBackStackState(FragmentManagerImpl arg1, String arg2, int arg3, int arg4) {
            FragmentManagerImpl.this = arg1;
            super();
            this.mName = arg2;
            this.mId = arg3;
            this.mFlags = arg4;
        }

        public boolean generateOps(ArrayList arg7, ArrayList arg8) {
            return FragmentManagerImpl.this.popBackStackState(arg7, arg8, this.mName, this.mId, this.mFlags);
        }
    }

    class StartEnterTransitionListener implements OnStartEnterTransitionListener {
        private final boolean mIsBack;
        private int mNumPostponed;
        private final BackStackRecord mRecord;

        StartEnterTransitionListener(BackStackRecord arg1, boolean arg2) {
            super();
            this.mIsBack = arg2;
            this.mRecord = arg1;
        }

        static boolean access$000(StartEnterTransitionListener arg1) {
            return arg1.mIsBack;
        }

        static BackStackRecord access$100(StartEnterTransitionListener arg1) {
            return arg1.mRecord;
        }

        public void cancelTransaction() {
            this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
        }

        public void completeTransaction() {
            boolean v3 = false;
            int v1 = this.mNumPostponed > 0 ? 1 : 0;
            FragmentManagerImpl v5 = this.mRecord.mManager;
            int v6 = v5.mAdded.size();
            int v4;
            for(v4 = 0; v4 < v6; ++v4) {
                Object v0 = v5.mAdded.get(v4);
                ((Fragment)v0).setOnStartEnterTransitionListener(null);
                if(v1 != 0 && (((Fragment)v0).isPostponed())) {
                    ((Fragment)v0).startPostponedEnterTransition();
                }
            }

            FragmentManagerImpl v0_1 = this.mRecord.mManager;
            BackStackRecord v4_1 = this.mRecord;
            boolean v5_1 = this.mIsBack;
            if(v1 == 0) {
                v3 = true;
            }

            v0_1.completeExecute(v4_1, v5_1, v3, true);
        }

        public boolean isReady() {
            boolean v0 = this.mNumPostponed == 0 ? true : false;
            return v0;
        }

        public void onStartEnterTransition() {
            --this.mNumPostponed;
            if(this.mNumPostponed == 0) {
                this.mRecord.mManager.scheduleCommit();
            }
        }

        public void startListening() {
            ++this.mNumPostponed;
        }
    }

    static final Interpolator ACCELERATE_CUBIC = null;
    static final Interpolator ACCELERATE_QUINT = null;
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = false;
    static final Interpolator DECELERATE_CUBIC = null;
    static final Interpolator DECELERATE_QUINT = null;
    static final boolean HONEYCOMB = false;
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    ArrayList mActive;
    ArrayList mAdded;
    ArrayList mAvailBackStackIndices;
    ArrayList mAvailIndices;
    ArrayList mBackStack;
    ArrayList mBackStackChangeListeners;
    ArrayList mBackStackIndices;
    FragmentContainer mContainer;
    ArrayList mCreatedMenus;
    int mCurState;
    boolean mDestroyed;
    Runnable mExecCommit;
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    FragmentHostCallback mHost;
    private CopyOnWriteArrayList mLifecycleCallbacks;
    boolean mNeedMenuInvalidate;
    String mNoTransactionsBecause;
    Fragment mParent;
    ArrayList mPendingActions;
    ArrayList mPostponedTransactions;
    SparseArray mStateArray;
    Bundle mStateBundle;
    boolean mStateSaved;
    Runnable[] mTmpActions;
    ArrayList mTmpAddedFragments;
    ArrayList mTmpIsPop;
    ArrayList mTmpRecords;
    static Field sAnimationListenerField;

    static {
        boolean v0 = false;
        float v4 = 2.5f;
        float v3 = 1.5f;
        FragmentManagerImpl.DEBUG = false;
        if(Build$VERSION.SDK_INT >= 11) {
            v0 = true;
        }

        FragmentManagerImpl.HONEYCOMB = v0;
        FragmentManagerImpl.sAnimationListenerField = null;
        FragmentManagerImpl.DECELERATE_QUINT = new DecelerateInterpolator(v4);
        FragmentManagerImpl.DECELERATE_CUBIC = new DecelerateInterpolator(v3);
        FragmentManagerImpl.ACCELERATE_QUINT = new AccelerateInterpolator(v4);
        FragmentManagerImpl.ACCELERATE_CUBIC = new AccelerateInterpolator(v3);
    }

    FragmentManagerImpl() {
        super();
        this.mCurState = 0;
        this.mStateBundle = null;
        this.mStateArray = null;
        this.mExecCommit = new android.support.v4.app.FragmentManagerImpl$1(this);
    }

    static void access$200(FragmentManagerImpl arg0) {
        arg0.scheduleCommit();
    }

    static void access$300(FragmentManagerImpl arg0, BackStackRecord arg1, boolean arg2, boolean arg3, boolean arg4) {
        arg0.completeExecute(arg1, arg2, arg3, arg4);
    }

    private void addAddedFragments(ArraySet arg9) {
        if(this.mCurState >= 1) {
            int v2 = Math.min(this.mCurState, 4);
            int v6 = this.mAdded == null ? 0 : this.mAdded.size();
            int v7;
            for(v7 = 0; v7 < v6; ++v7) {
                Object v1 = this.mAdded.get(v7);
                if(((Fragment)v1).mState < v2) {
                    this.moveToState(((Fragment)v1), v2, ((Fragment)v1).getNextAnim(), ((Fragment)v1).getNextTransition(), false);
                    if(((Fragment)v1).mView != null && !((Fragment)v1).mHidden && (((Fragment)v1).mIsNewlyAdded)) {
                        arg9.add(v1);
                    }
                }
            }
        }
    }

    void addBackStackState(BackStackRecord arg2) {
        if(this.mBackStack == null) {
            this.mBackStack = new ArrayList();
        }

        this.mBackStack.add(arg2);
        this.reportBackStackChanged();
    }

    public void addFragment(Fragment arg6, boolean arg7) {
        if(this.mAdded == null) {
            this.mAdded = new ArrayList();
        }

        if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "add: " + arg6);
        }

        this.makeActive(arg6);
        if(!arg6.mDetached) {
            if(this.mAdded.contains(arg6)) {
                throw new IllegalStateException("Fragment already added: " + arg6);
            }
            else {
                this.mAdded.add(arg6);
                arg6.mAdded = true;
                arg6.mRemoving = false;
                if(arg6.mView == null) {
                    arg6.mHiddenChanged = false;
                }

                if((arg6.mHasMenu) && (arg6.mMenuVisible)) {
                    this.mNeedMenuInvalidate = true;
                }

                if(!arg7) {
                    return;
                }

                this.moveToState(arg6);
            }
        }
    }

    public void addOnBackStackChangedListener(OnBackStackChangedListener arg2) {
        if(this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList();
        }

        this.mBackStackChangeListeners.add(arg2);
    }

    public int allocBackStackIndex(BackStackRecord arg5) {
        int v0_1;
        __monitor_enter(this);
        try {
            if(this.mAvailBackStackIndices == null || this.mAvailBackStackIndices.size() <= 0) {
                if(this.mBackStackIndices == null) {
                    this.mBackStackIndices = new ArrayList();
                }

                v0_1 = this.mBackStackIndices.size();
                if(FragmentManagerImpl.DEBUG) {
                    Log.v("FragmentManager", "Setting back stack index " + v0_1 + " to " + arg5);
                }

                this.mBackStackIndices.add(arg5);
                __monitor_exit(this);
            }
            else {
                v0_1 = this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1).intValue();
                if(FragmentManagerImpl.DEBUG) {
                    Log.v("FragmentManager", "Adding back stack index " + v0_1 + " with " + arg5);
                }

                this.mBackStackIndices.set(v0_1, arg5);
                __monitor_exit(this);
            }

            return v0_1;
        label_54:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_54;
        }

        throw v0;
    }

    public void attachController(FragmentHostCallback arg3, FragmentContainer arg4, Fragment arg5) {
        if(this.mHost != null) {
            throw new IllegalStateException("Already attached");
        }

        this.mHost = arg3;
        this.mContainer = arg4;
        this.mParent = arg5;
    }

    public void attachFragment(Fragment arg5) {
        if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "attach: " + arg5);
        }

        if(arg5.mDetached) {
            arg5.mDetached = false;
            if(!arg5.mAdded) {
                if(this.mAdded == null) {
                    this.mAdded = new ArrayList();
                }

                if(this.mAdded.contains(arg5)) {
                    throw new IllegalStateException("Fragment already added: " + arg5);
                }

                if(FragmentManagerImpl.DEBUG) {
                    Log.v("FragmentManager", "add from attach: " + arg5);
                }

                this.mAdded.add(arg5);
                arg5.mAdded = true;
                if(!arg5.mHasMenu) {
                    return;
                }

                if(!arg5.mMenuVisible) {
                    return;
                }

                this.mNeedMenuInvalidate = true;
            }
        }
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    private void checkStateLoss() {
        if(this.mStateSaved) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }

        if(this.mNoTransactionsBecause != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
        }
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    private void completeExecute(BackStackRecord arg8, boolean arg9, boolean arg10, boolean arg11) {
        ArrayList v1 = new ArrayList(1);
        ArrayList v2 = new ArrayList(1);
        v1.add(arg8);
        v2.add(Boolean.valueOf(arg9));
        FragmentManagerImpl.executeOps(v1, v2, 0, 1);
        if(arg10) {
            FragmentTransition.startTransitions(this, v1, v2, 0, 1, true);
        }

        if(arg11) {
            this.moveToState(this.mCurState, true);
        }

        if(this.mActive != null) {
            int v2_1 = this.mActive.size();
            int v1_1;
            for(v1_1 = 0; v1_1 < v2_1; ++v1_1) {
                Object v0 = this.mActive.get(v1_1);
                if(v0 != null && ((Fragment)v0).mView != null && (((Fragment)v0).mIsNewlyAdded) && (arg8.interactsWith(((Fragment)v0).mContainerId))) {
                    if(Build$VERSION.SDK_INT >= 11 && ((Fragment)v0).mPostponedAlpha > 0f) {
                        ((Fragment)v0).mView.setAlpha(((Fragment)v0).mPostponedAlpha);
                    }

                    if(arg11) {
                        ((Fragment)v0).mPostponedAlpha = 0f;
                        goto label_44;
                    }

                    ((Fragment)v0).mPostponedAlpha = -1f;
                    ((Fragment)v0).mIsNewlyAdded = false;
                }

            label_44:
            }
        }
    }

    void completeShowHideFragment(Fragment arg6) {
        if(arg6.mView != null) {
            int v3 = arg6.getNextTransition();
            boolean v0 = !arg6.mHidden ? true : false;
            Animation v0_1 = this.loadAnimation(arg6, v3, v0, arg6.getNextTransitionStyle());
            if(v0_1 != null) {
                this.setHWLayerAnimListenerIfAlpha(arg6.mView, v0_1);
                arg6.mView.startAnimation(v0_1);
                this.setHWLayerAnimListenerIfAlpha(arg6.mView, v0_1);
                v0_1.start();
            }

            int v0_2 = !arg6.mHidden || (arg6.isHideReplaced()) ? 0 : 8;
            arg6.mView.setVisibility(v0_2);
            if(!arg6.isHideReplaced()) {
                goto label_28;
            }

            arg6.setHideReplaced(false);
        }

    label_28:
        if((arg6.mAdded) && (arg6.mHasMenu) && (arg6.mMenuVisible)) {
            this.mNeedMenuInvalidate = true;
        }

        arg6.mHiddenChanged = false;
        arg6.onHiddenChanged(arg6.mHidden);
    }

    public void detachFragment(Fragment arg5) {
        if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "detach: " + arg5);
        }

        if(!arg5.mDetached) {
            arg5.mDetached = true;
            if(arg5.mAdded) {
                if(this.mAdded != null) {
                    if(FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "remove from detach: " + arg5);
                    }

                    this.mAdded.remove(arg5);
                }

                if((arg5.mHasMenu) && (arg5.mMenuVisible)) {
                    this.mNeedMenuInvalidate = true;
                }

                arg5.mAdded = false;
            }
        }
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        this.moveToState(2, false);
        this.mExecutingActions = false;
    }

    public void dispatchConfigurationChanged(Configuration arg3) {
        if(this.mAdded != null) {
            int v1;
            for(v1 = 0; v1 < this.mAdded.size(); ++v1) {
                Object v0 = this.mAdded.get(v1);
                if(v0 != null) {
                    ((Fragment)v0).performConfigurationChanged(arg3);
                }
            }
        }
    }

    public boolean dispatchContextItemSelected(MenuItem arg4) {
        boolean v2 = false;
        if(this.mAdded != null) {
            int v1;
            for(v1 = 0; v1 < this.mAdded.size(); ++v1) {
                Object v0 = this.mAdded.get(v1);
                if(v0 != null && (((Fragment)v0).performContextItemSelected(arg4))) {
                    return true;
                }
            }
        }

        return v2;
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        this.moveToState(1, false);
        this.mExecutingActions = false;
    }

    public boolean dispatchCreateOptionsMenu(Menu arg7, MenuInflater arg8) {
        Object v0;
        int v4 = 0;
        ArrayList v1 = null;
        if(this.mAdded != null) {
            int v3 = 0;
            boolean v2;
            for(v2 = false; v3 < this.mAdded.size(); v2 = v2) {
                v0 = this.mAdded.get(v3);
                if(v0 != null && (((Fragment)v0).performCreateOptionsMenu(arg7, arg8))) {
                    v2 = true;
                    if(v1 == null) {
                        v1 = new ArrayList();
                    }

                    v1.add(v0);
                }

                ++v3;
            }
        }
        else {
            v2 = false;
        }

        if(this.mCreatedMenus != null) {
            while(v4 < this.mCreatedMenus.size()) {
                v0 = this.mCreatedMenus.get(v4);
                if(v1 == null || !v1.contains(v0)) {
                    ((Fragment)v0).onDestroyOptionsMenu();
                }

                ++v4;
            }
        }

        this.mCreatedMenus = v1;
        return v2;
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        this.execPendingActions();
        this.mExecutingActions = true;
        this.moveToState(0, false);
        this.mExecutingActions = false;
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
    }

    public void dispatchDestroyView() {
        this.mExecutingActions = true;
        this.moveToState(1, false);
        this.mExecutingActions = false;
    }

    public void dispatchLowMemory() {
        if(this.mAdded != null) {
            int v1;
            for(v1 = 0; v1 < this.mAdded.size(); ++v1) {
                Object v0 = this.mAdded.get(v1);
                if(v0 != null) {
                    ((Fragment)v0).performLowMemory();
                }
            }
        }
    }

    public void dispatchMultiWindowModeChanged(boolean arg3) {
        if(this.mAdded != null) {
            int v1;
            for(v1 = this.mAdded.size() - 1; v1 >= 0; --v1) {
                Object v0 = this.mAdded.get(v1);
                if(v0 != null) {
                    ((Fragment)v0).performMultiWindowModeChanged(arg3);
                }
            }
        }
    }

    void dispatchOnFragmentActivityCreated(Fragment arg4, Bundle arg5, boolean arg6) {
        if(this.mParent != null) {
            FragmentManager v0 = this.mParent.getFragmentManager();
            if((v0 instanceof FragmentManagerImpl)) {
                ((FragmentManagerImpl)v0).dispatchOnFragmentActivityCreated(arg4, arg5, true);
            }
        }

        if(this.mLifecycleCallbacks != null) {
            Iterator v2 = this.mLifecycleCallbacks.iterator();
            while(v2.hasNext()) {
                Object v0_1 = v2.next();
                if((arg6) && !((Pair)v0_1).second.booleanValue()) {
                    continue;
                }

                ((Pair)v0_1).first.onFragmentActivityCreated(((FragmentManager)this), arg4, arg5);
            }
        }
    }

    void dispatchOnFragmentAttached(Fragment arg4, Context arg5, boolean arg6) {
        if(this.mParent != null) {
            FragmentManager v0 = this.mParent.getFragmentManager();
            if((v0 instanceof FragmentManagerImpl)) {
                ((FragmentManagerImpl)v0).dispatchOnFragmentAttached(arg4, arg5, true);
            }
        }

        if(this.mLifecycleCallbacks != null) {
            Iterator v2 = this.mLifecycleCallbacks.iterator();
            while(v2.hasNext()) {
                Object v0_1 = v2.next();
                if((arg6) && !((Pair)v0_1).second.booleanValue()) {
                    continue;
                }

                ((Pair)v0_1).first.onFragmentAttached(((FragmentManager)this), arg4, arg5);
            }
        }
    }

    void dispatchOnFragmentCreated(Fragment arg4, Bundle arg5, boolean arg6) {
        if(this.mParent != null) {
            FragmentManager v0 = this.mParent.getFragmentManager();
            if((v0 instanceof FragmentManagerImpl)) {
                ((FragmentManagerImpl)v0).dispatchOnFragmentCreated(arg4, arg5, true);
            }
        }

        if(this.mLifecycleCallbacks != null) {
            Iterator v2 = this.mLifecycleCallbacks.iterator();
            while(v2.hasNext()) {
                Object v0_1 = v2.next();
                if((arg6) && !((Pair)v0_1).second.booleanValue()) {
                    continue;
                }

                ((Pair)v0_1).first.onFragmentCreated(((FragmentManager)this), arg4, arg5);
            }
        }
    }

    void dispatchOnFragmentDestroyed(Fragment arg4, boolean arg5) {
        if(this.mParent != null) {
            FragmentManager v0 = this.mParent.getFragmentManager();
            if((v0 instanceof FragmentManagerImpl)) {
                ((FragmentManagerImpl)v0).dispatchOnFragmentDestroyed(arg4, true);
            }
        }

        if(this.mLifecycleCallbacks != null) {
            Iterator v2 = this.mLifecycleCallbacks.iterator();
            while(v2.hasNext()) {
                Object v0_1 = v2.next();
                if((arg5) && !((Pair)v0_1).second.booleanValue()) {
                    continue;
                }

                ((Pair)v0_1).first.onFragmentDestroyed(((FragmentManager)this), arg4);
            }
        }
    }

    void dispatchOnFragmentDetached(Fragment arg4, boolean arg5) {
        if(this.mParent != null) {
            FragmentManager v0 = this.mParent.getFragmentManager();
            if((v0 instanceof FragmentManagerImpl)) {
                ((FragmentManagerImpl)v0).dispatchOnFragmentDetached(arg4, true);
            }
        }

        if(this.mLifecycleCallbacks != null) {
            Iterator v2 = this.mLifecycleCallbacks.iterator();
            while(v2.hasNext()) {
                Object v0_1 = v2.next();
                if((arg5) && !((Pair)v0_1).second.booleanValue()) {
                    continue;
                }

                ((Pair)v0_1).first.onFragmentDetached(((FragmentManager)this), arg4);
            }
        }
    }

    void dispatchOnFragmentPaused(Fragment arg4, boolean arg5) {
        if(this.mParent != null) {
            FragmentManager v0 = this.mParent.getFragmentManager();
            if((v0 instanceof FragmentManagerImpl)) {
                ((FragmentManagerImpl)v0).dispatchOnFragmentPaused(arg4, true);
            }
        }

        if(this.mLifecycleCallbacks != null) {
            Iterator v2 = this.mLifecycleCallbacks.iterator();
            while(v2.hasNext()) {
                Object v0_1 = v2.next();
                if((arg5) && !((Pair)v0_1).second.booleanValue()) {
                    continue;
                }

                ((Pair)v0_1).first.onFragmentPaused(((FragmentManager)this), arg4);
            }
        }
    }

    void dispatchOnFragmentPreAttached(Fragment arg4, Context arg5, boolean arg6) {
        if(this.mParent != null) {
            FragmentManager v0 = this.mParent.getFragmentManager();
            if((v0 instanceof FragmentManagerImpl)) {
                ((FragmentManagerImpl)v0).dispatchOnFragmentPreAttached(arg4, arg5, true);
            }
        }

        if(this.mLifecycleCallbacks != null) {
            Iterator v2 = this.mLifecycleCallbacks.iterator();
            while(v2.hasNext()) {
                Object v0_1 = v2.next();
                if((arg6) && !((Pair)v0_1).second.booleanValue()) {
                    continue;
                }

                ((Pair)v0_1).first.onFragmentPreAttached(((FragmentManager)this), arg4, arg5);
            }
        }
    }

    void dispatchOnFragmentResumed(Fragment arg4, boolean arg5) {
        if(this.mParent != null) {
            FragmentManager v0 = this.mParent.getFragmentManager();
            if((v0 instanceof FragmentManagerImpl)) {
                ((FragmentManagerImpl)v0).dispatchOnFragmentResumed(arg4, true);
            }
        }

        if(this.mLifecycleCallbacks != null) {
            Iterator v2 = this.mLifecycleCallbacks.iterator();
            while(v2.hasNext()) {
                Object v0_1 = v2.next();
                if((arg5) && !((Pair)v0_1).second.booleanValue()) {
                    continue;
                }

                ((Pair)v0_1).first.onFragmentResumed(((FragmentManager)this), arg4);
            }
        }
    }

    void dispatchOnFragmentSaveInstanceState(Fragment arg4, Bundle arg5, boolean arg6) {
        if(this.mParent != null) {
            FragmentManager v0 = this.mParent.getFragmentManager();
            if((v0 instanceof FragmentManagerImpl)) {
                ((FragmentManagerImpl)v0).dispatchOnFragmentSaveInstanceState(arg4, arg5, true);
            }
        }

        if(this.mLifecycleCallbacks != null) {
            Iterator v2 = this.mLifecycleCallbacks.iterator();
            while(v2.hasNext()) {
                Object v0_1 = v2.next();
                if((arg6) && !((Pair)v0_1).second.booleanValue()) {
                    continue;
                }

                ((Pair)v0_1).first.onFragmentSaveInstanceState(((FragmentManager)this), arg4, arg5);
            }
        }
    }

    void dispatchOnFragmentStarted(Fragment arg4, boolean arg5) {
        if(this.mParent != null) {
            FragmentManager v0 = this.mParent.getFragmentManager();
            if((v0 instanceof FragmentManagerImpl)) {
                ((FragmentManagerImpl)v0).dispatchOnFragmentStarted(arg4, true);
            }
        }

        if(this.mLifecycleCallbacks != null) {
            Iterator v2 = this.mLifecycleCallbacks.iterator();
            while(v2.hasNext()) {
                Object v0_1 = v2.next();
                if((arg5) && !((Pair)v0_1).second.booleanValue()) {
                    continue;
                }

                ((Pair)v0_1).first.onFragmentStarted(((FragmentManager)this), arg4);
            }
        }
    }

    void dispatchOnFragmentStopped(Fragment arg4, boolean arg5) {
        if(this.mParent != null) {
            FragmentManager v0 = this.mParent.getFragmentManager();
            if((v0 instanceof FragmentManagerImpl)) {
                ((FragmentManagerImpl)v0).dispatchOnFragmentStopped(arg4, true);
            }
        }

        if(this.mLifecycleCallbacks != null) {
            Iterator v2 = this.mLifecycleCallbacks.iterator();
            while(v2.hasNext()) {
                Object v0_1 = v2.next();
                if((arg5) && !((Pair)v0_1).second.booleanValue()) {
                    continue;
                }

                ((Pair)v0_1).first.onFragmentStopped(((FragmentManager)this), arg4);
            }
        }
    }

    void dispatchOnFragmentViewCreated(Fragment arg4, View arg5, Bundle arg6, boolean arg7) {
        if(this.mParent != null) {
            FragmentManager v0 = this.mParent.getFragmentManager();
            if((v0 instanceof FragmentManagerImpl)) {
                ((FragmentManagerImpl)v0).dispatchOnFragmentViewCreated(arg4, arg5, arg6, true);
            }
        }

        if(this.mLifecycleCallbacks != null) {
            Iterator v2 = this.mLifecycleCallbacks.iterator();
            while(v2.hasNext()) {
                Object v0_1 = v2.next();
                if((arg7) && !((Pair)v0_1).second.booleanValue()) {
                    continue;
                }

                ((Pair)v0_1).first.onFragmentViewCreated(((FragmentManager)this), arg4, arg5, arg6);
            }
        }
    }

    void dispatchOnFragmentViewDestroyed(Fragment arg4, boolean arg5) {
        if(this.mParent != null) {
            FragmentManager v0 = this.mParent.getFragmentManager();
            if((v0 instanceof FragmentManagerImpl)) {
                ((FragmentManagerImpl)v0).dispatchOnFragmentViewDestroyed(arg4, true);
            }
        }

        if(this.mLifecycleCallbacks != null) {
            Iterator v2 = this.mLifecycleCallbacks.iterator();
            while(v2.hasNext()) {
                Object v0_1 = v2.next();
                if((arg5) && !((Pair)v0_1).second.booleanValue()) {
                    continue;
                }

                ((Pair)v0_1).first.onFragmentViewDestroyed(((FragmentManager)this), arg4);
            }
        }
    }

    public boolean dispatchOptionsItemSelected(MenuItem arg4) {
        boolean v2 = false;
        if(this.mAdded != null) {
            int v1;
            for(v1 = 0; v1 < this.mAdded.size(); ++v1) {
                Object v0 = this.mAdded.get(v1);
                if(v0 != null && (((Fragment)v0).performOptionsItemSelected(arg4))) {
                    return true;
                }
            }
        }

        return v2;
    }

    public void dispatchOptionsMenuClosed(Menu arg3) {
        if(this.mAdded != null) {
            int v1;
            for(v1 = 0; v1 < this.mAdded.size(); ++v1) {
                Object v0 = this.mAdded.get(v1);
                if(v0 != null) {
                    ((Fragment)v0).performOptionsMenuClosed(arg3);
                }
            }
        }
    }

    public void dispatchPause() {
        this.mExecutingActions = true;
        this.moveToState(4, false);
        this.mExecutingActions = false;
    }

    public void dispatchPictureInPictureModeChanged(boolean arg3) {
        if(this.mAdded != null) {
            int v1;
            for(v1 = this.mAdded.size() - 1; v1 >= 0; --v1) {
                Object v0 = this.mAdded.get(v1);
                if(v0 != null) {
                    ((Fragment)v0).performPictureInPictureModeChanged(arg3);
                }
            }
        }
    }

    public boolean dispatchPrepareOptionsMenu(Menu arg4) {
        boolean v2;
        if(this.mAdded != null) {
            int v1 = 0;
            v2 = false;
            while(v1 < this.mAdded.size()) {
                Object v0 = this.mAdded.get(v1);
                if(v0 != null && (((Fragment)v0).performPrepareOptionsMenu(arg4))) {
                    v2 = true;
                }

                ++v1;
            }
        }
        else {
            v2 = false;
        }

        return v2;
    }

    public void dispatchReallyStop() {
        this.mExecutingActions = true;
        this.moveToState(2, false);
        this.mExecutingActions = false;
    }

    public void dispatchResume() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        this.moveToState(5, false);
        this.mExecutingActions = false;
    }

    public void dispatchStart() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        this.moveToState(4, false);
        this.mExecutingActions = false;
    }

    public void dispatchStop() {
        this.mStateSaved = true;
        this.mExecutingActions = true;
        this.moveToState(3, false);
        this.mExecutingActions = false;
    }

    void doPendingDeferredStart() {
        if(this.mHavePendingDeferredStart) {
            int v1 = 0;
            int v3 = 0;
            while(v1 < this.mActive.size()) {
                Object v0 = this.mActive.get(v1);
                if(v0 != null && ((Fragment)v0).mLoaderManager != null) {
                    v3 |= ((Fragment)v0).mLoaderManager.hasRunningLoaders();
                }

                ++v1;
            }

            if(v3 != 0) {
                return;
            }

            this.mHavePendingDeferredStart = false;
            this.startPendingDeferredFragments();
        }
    }

    public void dump(String arg7, FileDescriptor arg8, PrintWriter arg9, String[] arg10) {
        Object v0;
        int v4;
        int v1 = 0;
        String v3 = arg7 + "    ";
        if(this.mActive != null) {
            v4 = this.mActive.size();
            if(v4 > 0) {
                arg9.print(arg7);
                arg9.print("Active Fragments in ");
                arg9.print(Integer.toHexString(System.identityHashCode(this)));
                arg9.println(":");
                int v2;
                for(v2 = 0; v2 < v4; ++v2) {
                    v0 = this.mActive.get(v2);
                    arg9.print(arg7);
                    arg9.print("  #");
                    arg9.print(v2);
                    arg9.print(": ");
                    arg9.println(v0);
                    if(v0 != null) {
                        ((Fragment)v0).dump(v3, arg8, arg9, arg10);
                    }
                }
            }
        }

        if(this.mAdded != null) {
            v4 = this.mAdded.size();
            if(v4 > 0) {
                arg9.print(arg7);
                arg9.println("Added Fragments:");
                for(v2 = 0; v2 < v4; ++v2) {
                    v0 = this.mAdded.get(v2);
                    arg9.print(arg7);
                    arg9.print("  #");
                    arg9.print(v2);
                    arg9.print(": ");
                    arg9.println(((Fragment)v0).toString());
                }
            }
        }

        if(this.mCreatedMenus != null) {
            v4 = this.mCreatedMenus.size();
            if(v4 > 0) {
                arg9.print(arg7);
                arg9.println("Fragments Created Menus:");
                for(v2 = 0; v2 < v4; ++v2) {
                    v0 = this.mCreatedMenus.get(v2);
                    arg9.print(arg7);
                    arg9.print("  #");
                    arg9.print(v2);
                    arg9.print(": ");
                    arg9.println(((Fragment)v0).toString());
                }
            }
        }

        if(this.mBackStack != null) {
            v4 = this.mBackStack.size();
            if(v4 > 0) {
                arg9.print(arg7);
                arg9.println("Back Stack:");
                for(v2 = 0; v2 < v4; ++v2) {
                    v0 = this.mBackStack.get(v2);
                    arg9.print(arg7);
                    arg9.print("  #");
                    arg9.print(v2);
                    arg9.print(": ");
                    arg9.println(((BackStackRecord)v0).toString());
                    ((BackStackRecord)v0).dump(v3, arg8, arg9, arg10);
                }
            }
        }

        __monitor_enter(this);
        try {
            if(this.mBackStackIndices != null) {
                int v3_1 = this.mBackStackIndices.size();
                if(v3_1 > 0) {
                    arg9.print(arg7);
                    arg9.println("Back Stack Indices:");
                    for(v2 = 0; v2 < v3_1; ++v2) {
                        v0 = this.mBackStackIndices.get(v2);
                        arg9.print(arg7);
                        arg9.print("  #");
                        arg9.print(v2);
                        arg9.print(": ");
                        arg9.println(v0);
                    }
                }
            }

            if(this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
                arg9.print(arg7);
                arg9.print("mAvailBackStackIndices: ");
                arg9.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
            }

            __monitor_exit(this);
        }
        catch(Throwable v0_1) {
            try {
            label_164:
                __monitor_exit(this);
            }
            catch(Throwable v0_1) {
                goto label_164;
            }

            throw v0_1;
        }

        if(this.mPendingActions != null) {
            v2 = this.mPendingActions.size();
            if(v2 > 0) {
                arg9.print(arg7);
                arg9.println("Pending Actions:");
                while(v1 < v2) {
                    v0 = this.mPendingActions.get(v1);
                    arg9.print(arg7);
                    arg9.print("  #");
                    arg9.print(v1);
                    arg9.print(": ");
                    arg9.println(v0);
                    ++v1;
                }
            }
        }

        arg9.print(arg7);
        arg9.println("FragmentManager misc state:");
        arg9.print(arg7);
        arg9.print("  mHost=");
        arg9.println(this.mHost);
        arg9.print(arg7);
        arg9.print("  mContainer=");
        arg9.println(this.mContainer);
        if(this.mParent != null) {
            arg9.print(arg7);
            arg9.print("  mParent=");
            arg9.println(this.mParent);
        }

        arg9.print(arg7);
        arg9.print("  mCurState=");
        arg9.print(this.mCurState);
        arg9.print(" mStateSaved=");
        arg9.print(this.mStateSaved);
        arg9.print(" mDestroyed=");
        arg9.println(this.mDestroyed);
        if(this.mNeedMenuInvalidate) {
            arg9.print(arg7);
            arg9.print("  mNeedMenuInvalidate=");
            arg9.println(this.mNeedMenuInvalidate);
        }

        if(this.mNoTransactionsBecause != null) {
            arg9.print(arg7);
            arg9.print("  mNoTransactionsBecause=");
            arg9.println(this.mNoTransactionsBecause);
        }

        if(this.mAvailIndices != null && this.mAvailIndices.size() > 0) {
            arg9.print(arg7);
            arg9.print("  mAvailIndices: ");
            arg9.println(Arrays.toString(this.mAvailIndices.toArray()));
        }
    }

    private void endAnimatingAwayFragments() {
        int v6 = this.mActive == null ? 0 : this.mActive.size();
        int v7;
        for(v7 = 0; v7 < v6; ++v7) {
            Object v1 = this.mActive.get(v7);
            if(v1 != null && ((Fragment)v1).getAnimatingAway() != null) {
                int v2 = ((Fragment)v1).getStateAfterAnimating();
                View v0 = ((Fragment)v1).getAnimatingAway();
                ((Fragment)v1).setAnimatingAway(null);
                Animation v0_1 = v0.getAnimation();
                if(v0_1 != null) {
                    v0_1.cancel();
                }

                this.moveToState(((Fragment)v1), v2, 0, 0, false);
            }
        }
    }

    public void enqueueAction(OpGenerator arg3, boolean arg4) {
        if(!arg4) {
            this.checkStateLoss();
        }

        __monitor_enter(this);
        try {
            if(!this.mDestroyed && this.mHost != null) {
                if(this.mPendingActions == null) {
                    this.mPendingActions = new ArrayList();
                }

                this.mPendingActions.add(arg3);
                this.scheduleCommit();
                __monitor_exit(this);
                return;
            }

            throw new IllegalStateException("Activity has been destroyed");
        label_12:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_12;
        }

        throw v0;
    }

    private void ensureExecReady(boolean arg4) {
        if(this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }

        if(Looper.myLooper() != this.mHost.getHandler().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }

        if(!arg4) {
            this.checkStateLoss();
        }

        if(this.mTmpRecords == null) {
            this.mTmpRecords = new ArrayList();
            this.mTmpIsPop = new ArrayList();
        }

        this.mExecutingActions = true;
        ArrayList v0 = null;
        ArrayList v1 = null;
        try {
            this.executePostponedTransaction(v0, v1);
        }
        catch(Throwable v0_1) {
            this.mExecutingActions = false;
            throw v0_1;
        }

        this.mExecutingActions = false;
    }

    public boolean execPendingActions() {
        this.ensureExecReady(true);
        boolean v0;
        for(v0 = false; this.generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop); v0 = true) {
            this.mExecutingActions = true;
            try {
                this.optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
            }
            catch(Throwable v0_1) {
                this.cleanupExec();
                throw v0_1;
            }

            this.cleanupExec();
        }

        this.doPendingDeferredStart();
        return v0;
    }

    public void execSingleAction(OpGenerator arg3, boolean arg4) {
        this.ensureExecReady(arg4);
        if(arg3.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                this.optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
            }
            catch(Throwable v0) {
                this.cleanupExec();
                throw v0;
            }

            this.cleanupExec();
        }

        this.doPendingDeferredStart();
    }

    private static void executeOps(ArrayList arg3, ArrayList arg4, int arg5, int arg6) {
        while(arg5 < arg6) {
            Object v0 = arg3.get(arg5);
            if(arg4.get(arg5).booleanValue()) {
                ((BackStackRecord)v0).bumpBackStackNesting(-1);
                boolean v1 = arg5 == arg6 - 1 ? true : false;
                ((BackStackRecord)v0).executePopOps(v1);
            }
            else {
                ((BackStackRecord)v0).bumpBackStackNesting(1);
                ((BackStackRecord)v0).executeOps();
            }

            ++arg5;
        }
    }

    private void executeOpsTogether(ArrayList arg10, ArrayList arg11, int arg12, int arg13) {
        int v4;
        Object v0;
        boolean v8 = arg10.get(arg12).mAllowOptimization;
        if(this.mTmpAddedFragments == null) {
            this.mTmpAddedFragments = new ArrayList();
        }
        else {
            this.mTmpAddedFragments.clear();
        }

        if(this.mAdded != null) {
            this.mTmpAddedFragments.addAll(this.mAdded);
        }

        int v2 = arg12;
        int v7;
        for(v7 = 0; v2 < arg13; v7 = v0_1) {
            v0 = arg10.get(v2);
            if(!arg11.get(v2).booleanValue()) {
                ((BackStackRecord)v0).expandReplaceOps(this.mTmpAddedFragments);
            }
            else {
                ((BackStackRecord)v0).trackAddedFragmentsInPop(this.mTmpAddedFragments);
            }

            int v0_1 = v7 != 0 || (((BackStackRecord)v0).mAddToBackStack) ? 1 : 0;
            ++v2;
        }

        this.mTmpAddedFragments.clear();
        if(!v8) {
            FragmentTransition.startTransitions(this, arg10, arg11, arg12, arg13, false);
        }

        FragmentManagerImpl.executeOps(arg10, arg11, arg12, arg13);
        if(v8) {
            ArraySet v5 = new ArraySet();
            this.addAddedFragments(v5);
            v4 = this.postponePostponableTransactions(arg10, arg11, arg12, arg13, v5);
            this.makeRemovedFragmentsInvisible(v5);
        }
        else {
            v4 = arg13;
        }

        if(v4 != arg12 && (v8)) {
            FragmentTransition.startTransitions(this, arg10, arg11, arg12, v4, true);
            this.moveToState(this.mCurState, true);
        }

        while(arg12 < arg13) {
            v0 = arg10.get(arg12);
            if((arg11.get(arg12).booleanValue()) && ((BackStackRecord)v0).mIndex >= 0) {
                this.freeBackStackIndex(((BackStackRecord)v0).mIndex);
                ((BackStackRecord)v0).mIndex = -1;
            }

            ++arg12;
        }

        if(v7 != 0) {
            this.reportBackStackChanged();
        }
    }

    public boolean executePendingTransactions() {
        boolean v0 = this.execPendingActions();
        this.forcePostponedTransactions();
        return v0;
    }

    private void executePostponedTransaction(ArrayList arg8, ArrayList arg9) {
        int v1;
        int v6 = -1;
        int v0 = this.mPostponedTransactions == null ? 0 : this.mPostponedTransactions.size();
        int v3 = 0;
        int v4;
        for(v4 = v0; v3 < v4; v4 = v1) {
            Object v0_1 = this.mPostponedTransactions.get(v3);
            if(arg8 == null || (StartEnterTransitionListener.access$000(((StartEnterTransitionListener)v0_1)))) {
            label_28:
                if((((StartEnterTransitionListener)v0_1).isReady()) || arg8 != null && (StartEnterTransitionListener.access$100(((StartEnterTransitionListener)v0_1)).interactsWith(arg8, 0, arg8.size()))) {
                    this.mPostponedTransactions.remove(v3);
                    --v3;
                    --v4;
                    if(arg8 != null && !StartEnterTransitionListener.access$000(((StartEnterTransitionListener)v0_1))) {
                        v1 = arg8.indexOf(StartEnterTransitionListener.access$100(((StartEnterTransitionListener)v0_1)));
                        if(v1 != v6 && (arg9.get(v1).booleanValue())) {
                            ((StartEnterTransitionListener)v0_1).cancelTransaction();
                            v0 = v3;
                            v1 = v4;
                            goto label_22;
                        }
                    }

                    ((StartEnterTransitionListener)v0_1).completeTransaction();
                }

                v0 = v3;
                v1 = v4;
            }
            else {
                v1 = arg8.indexOf(StartEnterTransitionListener.access$100(((StartEnterTransitionListener)v0_1)));
                if(v1 == v6) {
                    goto label_28;
                }
                else if(arg9.get(v1).booleanValue()) {
                    ((StartEnterTransitionListener)v0_1).cancelTransaction();
                    v0 = v3;
                    v1 = v4;
                }
                else {
                    goto label_28;
                }
            }

        label_22:
            v3 = v0 + 1;
        }
    }

    public Fragment findFragmentById(int arg4) {
        Object v0;
        int v1;
        if(this.mAdded != null) {
            v1 = this.mAdded.size() - 1;
            while(true) {
                if(v1 >= 0) {
                    v0 = this.mAdded.get(v1);
                    if(v0 != null && ((Fragment)v0).mFragmentId == arg4) {
                        break;
                    }

                    --v1;
                    continue;
                }
                else {
                    goto label_16;
                }
            }
        }
        else {
        label_16:
            if(this.mActive != null) {
                for(v1 = this.mActive.size() - 1; v1 >= 0; --v1) {
                    v0 = this.mActive.get(v1);
                    if(v0 != null && ((Fragment)v0).mFragmentId == arg4) {
                        goto label_12;
                    }
                }
            }

            Fragment v0_1 = null;
        }

    label_12:
        return ((Fragment)v0);
    }

    public Fragment findFragmentByTag(String arg4) {
        Object v0;
        int v1;
        if(this.mAdded == null || arg4 == null) {
        label_18:
            if(this.mActive != null && arg4 != null) {
                for(v1 = this.mActive.size() - 1; v1 >= 0; --v1) {
                    v0 = this.mActive.get(v1);
                    if(v0 != null && (arg4.equals(((Fragment)v0).mTag))) {
                        goto label_14;
                    }
                }
            }

            Fragment v0_1 = null;
        }
        else {
            v1 = this.mAdded.size() - 1;
            while(true) {
                if(v1 >= 0) {
                    v0 = this.mAdded.get(v1);
                    if(v0 != null && (arg4.equals(((Fragment)v0).mTag))) {
                        break;
                    }

                    --v1;
                    continue;
                }
                else {
                    goto label_18;
                }
            }
        }

    label_14:
        return ((Fragment)v0);
    }

    public Fragment findFragmentByWho(String arg3) {
        Fragment v0_1;
        if(this.mActive == null || arg3 == null) {
        label_17:
            v0_1 = null;
        }
        else {
            int v1 = this.mActive.size() - 1;
            while(true) {
                if(v1 >= 0) {
                    Object v0 = this.mActive.get(v1);
                    if(v0 != null) {
                        v0_1 = ((Fragment)v0).findFragmentByWho(arg3);
                        if(v0_1 == null) {
                            goto label_14;
                        }

                        return v0_1;
                    }

                label_14:
                    --v1;
                    continue;
                }
                else {
                    goto label_17;
                }
            }
        }

        return v0_1;
    }

    private Fragment findFragmentUnder(Fragment arg6) {
        Fragment v0_2;
        Fragment v1 = null;
        ViewGroup v3 = arg6.mContainer;
        View v0 = arg6.mView;
        if(v3 == null || v0 == null) {
            v0_2 = v1;
        }
        else {
            int v2;
            for(v2 = this.mAdded.indexOf(arg6) - 1; v2 >= 0; --v2) {
                Object v0_1 = this.mAdded.get(v2);
                if(((Fragment)v0_1).mContainer == v3 && ((Fragment)v0_1).mView != null) {
                    return v0_2;
                }
            }

            v0_2 = v1;
        }

        return v0_2;
    }

    private void forcePostponedTransactions() {
        if(this.mPostponedTransactions != null) {
            while(!this.mPostponedTransactions.isEmpty()) {
                this.mPostponedTransactions.remove(0).completeTransaction();
            }
        }
    }

    public void freeBackStackIndex(int arg4) {
        __monitor_enter(this);
        try {
            this.mBackStackIndices.set(arg4, null);
            if(this.mAvailBackStackIndices == null) {
                this.mAvailBackStackIndices = new ArrayList();
            }

            if(FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Freeing back stack index " + arg4);
            }

            this.mAvailBackStackIndices.add(Integer.valueOf(arg4));
            __monitor_exit(this);
            return;
        label_25:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_25;
        }

        throw v0;
    }

    private boolean generateOpsForPendingActions(ArrayList arg5, ArrayList arg6) {
        boolean v0_1;
        __monitor_enter(this);
        try {
            if(this.mPendingActions == null) {
                goto label_7;
            }
            else if(this.mPendingActions.size() != 0) {
                int v3 = this.mPendingActions.size();
                int v2;
                for(v2 = 0; v2 < v3; ++v2) {
                    this.mPendingActions.get(v2).generateOps(arg5, arg6);
                }

                this.mPendingActions.clear();
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                __monitor_exit(this);
                if(v3 > 0) {
                    v0_1 = true;
                }
                else {
                    return false;
                }
            }
            else {
                goto label_7;
            }

            return v0_1;
        }
        catch(Throwable v0) {
            goto label_31;
        }

        return false;
        try {
        label_7:
            __monitor_exit(this);
            return false;
        label_31:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_31;
        }

        throw v0;
    }

    public BackStackEntry getBackStackEntryAt(int arg2) {
        return this.mBackStack.get(arg2);
    }

    public int getBackStackEntryCount() {
        int v0 = this.mBackStack != null ? this.mBackStack.size() : 0;
        return v0;
    }

    public Fragment getFragment(Bundle arg6, String arg7) {
        Object v0_1;
        int v1 = arg6.getInt(arg7, -1);
        if(v1 == -1) {
            Fragment v0 = null;
        }
        else {
            if(v1 >= this.mActive.size()) {
                this.throwException(new IllegalStateException("Fragment no longer exists for key " + arg7 + ": index " + v1));
            }

            v0_1 = this.mActive.get(v1);
            if(v0_1 != null) {
                goto label_4;
            }

            this.throwException(new IllegalStateException("Fragment no longer exists for key " + arg7 + ": index " + v1));
        }

    label_4:
        return ((Fragment)v0_1);
    }

    public List getFragments() {
        return this.mActive;
    }

    LayoutInflaterFactory getLayoutInflaterFactory() {
        return this;
    }

    public void hideFragment(Fragment arg5) {
        boolean v0 = true;
        if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "hide: " + arg5);
        }

        if(!arg5.mHidden) {
            arg5.mHidden = true;
            if(arg5.mHiddenChanged) {
                v0 = false;
            }

            arg5.mHiddenChanged = v0;
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    boolean isStateAtLeast(int arg2) {
        boolean v0 = this.mCurState >= arg2 ? true : false;
        return v0;
    }

    Animation loadAnimation(Fragment arg7, int arg8, boolean arg9, int arg10) {
        float v5 = 0.975f;
        Animation v1 = null;
        float v3 = 1f;
        Animation v0 = arg7.onCreateAnimation(arg8, arg9, arg7.getNextAnim());
        if(v0 == null) {
            if(arg7.getNextAnim() != 0) {
                v0 = AnimationUtils.loadAnimation(this.mHost.getContext(), arg7.getNextAnim());
                if(v0 == null) {
                    goto label_15;
                }

                return v0;
            }

        label_15:
            if(arg8 == 0) {
                return v1;
            }

            int v0_1 = FragmentManagerImpl.transitToStyleIndex(arg8, arg9);
            if(v0_1 < 0) {
                return v1;
            }

            switch(v0_1) {
                case 1: {
                    goto label_32;
                }
                case 2: {
                    goto label_37;
                }
                case 3: {
                    goto label_41;
                }
                case 4: {
                    goto label_45;
                }
                case 5: {
                    goto label_50;
                }
                case 6: {
                    goto label_54;
                }
            }

            if(arg10 == 0 && (this.mHost.onHasWindowAnimations())) {
                arg10 = this.mHost.onGetWindowAnimations();
            }

            if(arg10 == 0) {
                return v1;
            }

            return v1;
        label_50:
            return FragmentManagerImpl.makeFadeAnimation(this.mHost.getContext(), 0f, v3);
        label_37:
            return FragmentManagerImpl.makeOpenCloseAnimation(this.mHost.getContext(), v3, v5, v3, 0f);
        label_54:
            return FragmentManagerImpl.makeFadeAnimation(this.mHost.getContext(), v3, 0f);
        label_41:
            return FragmentManagerImpl.makeOpenCloseAnimation(this.mHost.getContext(), v5, v3, 0f, v3);
        label_45:
            return FragmentManagerImpl.makeOpenCloseAnimation(this.mHost.getContext(), v3, 1.075f, v3, 0f);
        label_32:
            v0 = FragmentManagerImpl.makeOpenCloseAnimation(this.mHost.getContext(), 1.125f, v3, 0f, v3);
        }

        return v0;
    }

    void makeActive(Fragment arg4) {
        if(arg4.mIndex < 0) {
            if(this.mAvailIndices == null || this.mAvailIndices.size() <= 0) {
                if(this.mActive == null) {
                    this.mActive = new ArrayList();
                }

                arg4.setIndex(this.mActive.size(), this.mParent);
                this.mActive.add(arg4);
            }
            else {
                arg4.setIndex(this.mAvailIndices.remove(this.mAvailIndices.size() - 1).intValue(), this.mParent);
                this.mActive.set(arg4.mIndex, arg4);
            }

            if(!FragmentManagerImpl.DEBUG) {
                return;
            }

            Log.v("FragmentManager", "Allocated fragment index " + arg4);
        }
    }

    static Animation makeFadeAnimation(Context arg4, float arg5, float arg6) {
        AlphaAnimation v0 = new AlphaAnimation(arg5, arg6);
        v0.setInterpolator(FragmentManagerImpl.DECELERATE_CUBIC);
        v0.setDuration(220);
        return ((Animation)v0);
    }

    void makeInactive(Fragment arg4) {
        if(arg4.mIndex >= 0) {
            if(FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Freeing fragment index " + arg4);
            }

            this.mActive.set(arg4.mIndex, null);
            if(this.mAvailIndices == null) {
                this.mAvailIndices = new ArrayList();
            }

            this.mAvailIndices.add(Integer.valueOf(arg4.mIndex));
            this.mHost.inactivateFragment(arg4.mWho);
            arg4.initState();
        }
    }

    static Animation makeOpenCloseAnimation(Context arg10, float arg11, float arg12, float arg13, float arg14) {
        AnimationSet v9 = new AnimationSet(false);
        ScaleAnimation v0 = new ScaleAnimation(arg11, arg12, arg11, arg12, 1, 0.5f, 1, 0.5f);
        v0.setInterpolator(FragmentManagerImpl.DECELERATE_QUINT);
        v0.setDuration(220);
        v9.addAnimation(((Animation)v0));
        AlphaAnimation v0_1 = new AlphaAnimation(arg13, arg14);
        v0_1.setInterpolator(FragmentManagerImpl.DECELERATE_CUBIC);
        v0_1.setDuration(220);
        v9.addAnimation(((Animation)v0_1));
        return ((Animation)v9);
    }

    private void makeRemovedFragmentsInvisible(ArraySet arg7) {
        int v2 = arg7.size();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            Object v0 = arg7.valueAt(v1);
            if(!((Fragment)v0).mAdded) {
                View v3 = ((Fragment)v0).getView();
                if(Build$VERSION.SDK_INT < 11) {
                    ((Fragment)v0).getView().setVisibility(4);
                }
                else {
                    ((Fragment)v0).mPostponedAlpha = v3.getAlpha();
                    v3.setAlpha(0f);
                }
            }
        }
    }

    static boolean modifiesAlpha(Animation arg5) {
        boolean v1 = false;
        if((arg5 instanceof AlphaAnimation)) {
            v1 = true;
        }
        else if((arg5 instanceof AnimationSet)) {
            List v3 = ((AnimationSet)arg5).getAnimations();
            int v0 = 0;
            while(v0 < v3.size()) {
                if((v3.get(v0) instanceof AlphaAnimation)) {
                    v1 = true;
                }
                else {
                    ++v0;
                    continue;
                }

                return v1;
            }
        }

        return v1;
    }

    void moveFragmentToExpectedState(Fragment arg9) {
        if(arg9 != null) {
            int v2 = this.mCurState;
            if(arg9.mRemoving) {
                v2 = arg9.isInBackStack() ? Math.min(v2, 1) : Math.min(v2, 0);
            }

            this.moveToState(arg9, v2, arg9.getNextTransition(), arg9.getNextTransitionStyle(), false);
            if(arg9.mView != null) {
                Fragment v0 = this.findFragmentUnder(arg9);
                if(v0 != null) {
                    View v0_1 = v0.mView;
                    ViewGroup v1 = arg9.mContainer;
                    int v0_2 = v1.indexOfChild(v0_1);
                    v2 = v1.indexOfChild(arg9.mView);
                    if(v2 < v0_2) {
                        v1.removeViewAt(v2);
                        v1.addView(arg9.mView, v0_2);
                    }
                }

                if(!arg9.mIsNewlyAdded) {
                    goto label_48;
                }

                if(arg9.mContainer == null) {
                    goto label_48;
                }

                if(Build$VERSION.SDK_INT < 11) {
                    arg9.mView.setVisibility(0);
                }
                else if(arg9.mPostponedAlpha > 0f) {
                    arg9.mView.setAlpha(arg9.mPostponedAlpha);
                }

                arg9.mPostponedAlpha = 0f;
                arg9.mIsNewlyAdded = false;
                Animation v0_3 = this.loadAnimation(arg9, arg9.getNextTransition(), true, arg9.getNextTransitionStyle());
                if(v0_3 == null) {
                    goto label_48;
                }

                this.setHWLayerAnimListenerIfAlpha(arg9.mView, v0_3);
                arg9.mView.startAnimation(v0_3);
            }

        label_48:
            if(!arg9.mHiddenChanged) {
                return;
            }

            this.completeShowHideFragment(arg9);
        }
    }

    void moveToState(int arg7, boolean arg8) {
        int v0_1;
        Object v0;
        int v3;
        int v4;
        if(this.mHost == null && arg7 != 0) {
            throw new IllegalStateException("No activity");
        }

        if((arg8) || arg7 != this.mCurState) {
            this.mCurState = arg7;
            if(this.mActive != null) {
                if(this.mAdded != null) {
                    v4 = this.mAdded.size();
                    v3 = 0;
                    int v1;
                    for(v1 = 0; v3 < v4; v1 = v0_1) {
                        v0 = this.mAdded.get(v3);
                        this.moveFragmentToExpectedState(((Fragment)v0));
                        v0_1 = ((Fragment)v0).mLoaderManager != null ? ((Fragment)v0).mLoaderManager.hasRunningLoaders() | v1 : v1;
                        ++v3;
                    }
                }
                else {
                    v1 = 0;
                }

                v4 = this.mActive.size();
                v3 = 0;
                while(v3 < v4) {
                    v0 = this.mActive.get(v3);
                    if(v0 != null) {
                        if(!((Fragment)v0).mRemoving && !((Fragment)v0).mDetached) {
                            goto label_71;
                        }

                        if(((Fragment)v0).mIsNewlyAdded) {
                            goto label_71;
                        }

                        this.moveFragmentToExpectedState(((Fragment)v0));
                        if(((Fragment)v0).mLoaderManager == null) {
                            goto label_71;
                        }

                        v0_1 = ((Fragment)v0).mLoaderManager.hasRunningLoaders() | v1;
                    }
                    else {
                    label_71:
                        v0_1 = v1;
                    }

                    ++v3;
                    v1 = v0_1;
                }

                if(v1 == 0) {
                    this.startPendingDeferredFragments();
                }

                if(!this.mNeedMenuInvalidate) {
                    return;
                }

                if(this.mHost == null) {
                    return;
                }

                if(this.mCurState != 5) {
                    return;
                }

                this.mHost.onSupportInvalidateOptionsMenu();
                this.mNeedMenuInvalidate = false;
            }
        }
    }

    void moveToState(Fragment arg11, int arg12, int arg13, int arg14, boolean arg15) {
        ViewGroup v0_2;
        String v1_1;
        View v0_1;
        int v9 = 4;
        int v6 = 3;
        boolean v5 = true;
        View v7 = null;
        if((!arg11.mAdded || (arg11.mDetached)) && arg12 > 1) {
            arg12 = 1;
        }

        if((arg11.mRemoving) && 1 > arg11.mState) {
            arg12 = arg11.mState;
        }

        if((arg11.mDeferStart) && arg11.mState < v9 && arg12 > v6) {
            arg12 = v6;
        }

        if(arg11.mState >= arg12) {
            goto label_328;
        }

        if((arg11.mFromLayout) && !arg11.mInLayout) {
            return;
        }

        if(arg11.getAnimatingAway() != null) {
            arg11.setAnimatingAway(v7);
            this.moveToState(arg11, arg11.getStateAfterAnimating(), 0, 0, true);
        }

        switch(arg11.mState) {
            case 0: {
                goto label_60;
            }
            case 1: {
                goto label_173;
            }
            case 2: {
                goto label_272;
            }
            case 3: {
                goto label_275;
            }
            case 4: {
                goto label_288;
            }
        }

        goto label_39;
    label_60:
        if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "moveto CREATED: " + arg11);
        }

        if(arg11.mSavedFragmentState != null) {
            arg11.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
            arg11.mSavedViewState = arg11.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            arg11.mTarget = this.getFragment(arg11.mSavedFragmentState, "android:target_state");
            if(arg11.mTarget != null) {
                arg11.mTargetRequestCode = arg11.mSavedFragmentState.getInt("android:target_req_state", 0);
            }

            arg11.mUserVisibleHint = arg11.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            if(arg11.mUserVisibleHint) {
                goto label_100;
            }

            arg11.mDeferStart = true;
            if(arg12 <= v6) {
                goto label_100;
            }

            arg12 = v6;
        }

    label_100:
        arg11.mHost = this.mHost;
        arg11.mParentFragment = this.mParent;
        FragmentManagerImpl v0 = this.mParent != null ? this.mParent.mChildFragmentManager : this.mHost.getFragmentManagerImpl();
        arg11.mFragmentManager = v0;
        this.dispatchOnFragmentPreAttached(arg11, this.mHost.getContext(), false);
        arg11.mCalled = false;
        arg11.onAttach(this.mHost.getContext());
        if(!arg11.mCalled) {
            throw new SuperNotCalledException("Fragment " + arg11 + " did not call through to super.onAttach()");
        }

        if(arg11.mParentFragment == null) {
            this.mHost.onAttachFragment(arg11);
        }
        else {
            arg11.mParentFragment.onAttachFragment(arg11);
        }

        this.dispatchOnFragmentAttached(arg11, this.mHost.getContext(), false);
        if(!arg11.mRetaining) {
            arg11.performCreate(arg11.mSavedFragmentState);
            this.dispatchOnFragmentCreated(arg11, arg11.mSavedFragmentState, false);
        }
        else {
            arg11.restoreChildFragmentState(arg11.mSavedFragmentState);
            arg11.mState = 1;
        }

        arg11.mRetaining = false;
        if(arg11.mFromLayout) {
            arg11.mView = arg11.performCreateView(arg11.getLayoutInflater(arg11.mSavedFragmentState), ((ViewGroup)v7), arg11.mSavedFragmentState);
            if(arg11.mView != null) {
                arg11.mInnerView = arg11.mView;
                if(Build$VERSION.SDK_INT >= 11) {
                    ViewCompat.setSaveFromParentEnabled(arg11.mView, false);
                }
                else {
                    arg11.mView = NoSaveStateFrameLayout.wrap(arg11.mView);
                }

                if(arg11.mHidden) {
                    arg11.mView.setVisibility(8);
                }

                arg11.onViewCreated(arg11.mView, arg11.mSavedFragmentState);
                this.dispatchOnFragmentViewCreated(arg11, arg11.mView, arg11.mSavedFragmentState, false);
            }
            else {
                arg11.mInnerView = v7;
            }
        }

    label_173:
        if(arg12 > 1) {
            if(FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + arg11);
            }

            if(!arg11.mFromLayout) {
                if(arg11.mContainerId != 0) {
                    if(arg11.mContainerId == -1) {
                        this.throwException(new IllegalArgumentException("Cannot create fragment " + arg11 + " for a container view with no id"));
                    }

                    v0_1 = this.mContainer.onFindViewById(arg11.mContainerId);
                    if(v0_1 != null) {
                        goto label_228;
                    }

                    if(arg11.mRestored) {
                        goto label_228;
                    }

                    try {
                        v1_1 = arg11.getResources().getResourceName(arg11.mContainerId);
                    }
                    catch(Resources$NotFoundException v1) {
                        v1_1 = "unknown";
                    }

                    this.throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(arg11.mContainerId) + " (" + v1_1 + ") for fragment " + arg11));
                }
                else {
                    v0_2 = ((ViewGroup)v7);
                }

            label_228:
                arg11.mContainer = v0_2;
                arg11.mView = arg11.performCreateView(arg11.getLayoutInflater(arg11.mSavedFragmentState), v0_2, arg11.mSavedFragmentState);
                if(arg11.mView != null) {
                    arg11.mInnerView = arg11.mView;
                    if(Build$VERSION.SDK_INT >= 11) {
                        ViewCompat.setSaveFromParentEnabled(arg11.mView, false);
                    }
                    else {
                        arg11.mView = NoSaveStateFrameLayout.wrap(arg11.mView);
                    }

                    if((((View)v0_2)) != null) {
                        v0_2.addView(arg11.mView);
                    }

                    if(arg11.mHidden) {
                        arg11.mView.setVisibility(8);
                    }

                    arg11.onViewCreated(arg11.mView, arg11.mSavedFragmentState);
                    this.dispatchOnFragmentViewCreated(arg11, arg11.mView, arg11.mSavedFragmentState, false);
                    if(arg11.mView.getVisibility() != 0 || arg11.mContainer == null) {
                        v5 = false;
                    }

                    arg11.mIsNewlyAdded = v5;
                }
                else {
                    arg11.mInnerView = v7;
                }
            }

            arg11.performActivityCreated(arg11.mSavedFragmentState);
            this.dispatchOnFragmentActivityCreated(arg11, arg11.mSavedFragmentState, false);
            if(arg11.mView != null) {
                arg11.restoreViewState(arg11.mSavedFragmentState);
            }

            arg11.mSavedFragmentState = ((Bundle)v7);
        }

    label_272:
        if(arg12 > 2) {
            arg11.mState = v6;
        }

    label_275:
        if(arg12 > v6) {
            if(FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "moveto STARTED: " + arg11);
            }

            arg11.performStart();
            this.dispatchOnFragmentStarted(arg11, false);
        }

    label_288:
        if(arg12 <= v9) {
            goto label_39;
        }

        if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "moveto RESUMED: " + arg11);
        }

        arg11.performResume();
        this.dispatchOnFragmentResumed(arg11, false);
        arg11.mSavedFragmentState = ((Bundle)v7);
        arg11.mSavedViewState = ((SparseArray)v7);
        goto label_39;
    label_328:
        if(arg11.mState <= arg12) {
            goto label_39;
        }

        switch(arg11.mState) {
            case 1: {
                goto label_333;
            }
            case 2: {
                goto label_385;
            }
            case 3: {
                goto label_373;
            }
            case 4: {
                goto label_360;
            }
            case 5: {
                goto label_346;
            }
        }

        goto label_39;
    label_346:
        if(arg12 < 5) {
            if(FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "movefrom RESUMED: " + arg11);
            }

            arg11.performPause();
            this.dispatchOnFragmentPaused(arg11, false);
        }

    label_360:
        if(arg12 < v9) {
            if(FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "movefrom STARTED: " + arg11);
            }

            arg11.performStop();
            this.dispatchOnFragmentStopped(arg11, false);
        }

    label_373:
        if(arg12 < v6) {
            if(FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "movefrom STOPPED: " + arg11);
            }

            arg11.performReallyStop();
        }

    label_385:
        if(arg12 < 2) {
            if(FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + arg11);
            }

            if(arg11.mView != null && (this.mHost.onShouldSaveFragmentState(arg11)) && arg11.mSavedViewState == null) {
                this.saveFragmentViewState(arg11);
            }

            arg11.performDestroyView();
            this.dispatchOnFragmentViewDestroyed(arg11, false);
            if(arg11.mView != null && arg11.mContainer != null) {
                Animation v0_3 = this.mCurState <= 0 || (this.mDestroyed) || arg11.mView.getVisibility() != 0 || arg11.mPostponedAlpha < 0f ? ((Animation)v7) : this.loadAnimation(arg11, arg13, false, arg14);
                arg11.mPostponedAlpha = 0f;
                if(v0_3 != null) {
                    arg11.setAnimatingAway(arg11.mView);
                    arg11.setStateAfterAnimating(arg12);
                    v0_3.setAnimationListener(new AnimateOnHWLayerIfNeededListener(arg11.mView, v0_3, arg11) {
                        public void onAnimationEnd(Animation arg7) {
                            super.onAnimationEnd(arg7);
                            if(this.val$fragment.getAnimatingAway() != null) {
                                this.val$fragment.setAnimatingAway(null);
                                FragmentManagerImpl.this.moveToState(this.val$fragment, this.val$fragment.getStateAfterAnimating(), 0, 0, false);
                            }
                        }
                    });
                    arg11.mView.startAnimation(v0_3);
                }

                arg11.mContainer.removeView(arg11.mView);
            }

            arg11.mContainer = ((ViewGroup)v7);
            arg11.mView = v7;
            arg11.mInnerView = v7;
        }

    label_333:
        if(arg12 < 1) {
            if((this.mDestroyed) && arg11.getAnimatingAway() != null) {
                v0_1 = arg11.getAnimatingAway();
                arg11.setAnimatingAway(v7);
                v0_1.clearAnimation();
            }

            if(arg11.getAnimatingAway() != null) {
                arg11.setStateAfterAnimating(arg12);
                arg12 = 1;
                goto label_39;
            }

            if(FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "movefrom CREATED: " + arg11);
            }

            if(!arg11.mRetaining) {
                arg11.performDestroy();
                this.dispatchOnFragmentDestroyed(arg11, false);
            }
            else {
                arg11.mState = 0;
            }

            arg11.performDetach();
            this.dispatchOnFragmentDetached(arg11, false);
            if(arg15) {
                goto label_39;
            }

            if(!arg11.mRetaining) {
                this.makeInactive(arg11);
            }
            else {
                arg11.mHost = ((FragmentHostCallback)v7);
                arg11.mParentFragment = ((Fragment)v7);
                arg11.mFragmentManager = ((FragmentManagerImpl)v7);
            }
        }

    label_39:
        if(arg11.mState != arg12) {
            Log.w("FragmentManager", "moveToState: Fragment state for " + arg11 + " not updated inline; " + "expected state " + arg12 + " found " + arg11.mState);
            arg11.mState = arg12;
        }
    }

    void moveToState(Fragment arg7) {
        this.moveToState(arg7, this.mCurState, 0, 0, false);
    }

    public void noteStateNotSaved() {
        this.mStateSaved = false;
    }

    public View onCreateView(View arg11, String arg12, Context arg13, AttributeSet arg14) {
        Fragment v1_2;
        View v0;
        String v4 = null;
        int v5 = -1;
        if(!"fragment".equals(arg12)) {
            v0 = ((View)v4);
        }
        else {
            String v0_1 = arg14.getAttributeValue(v4, "class");
            TypedArray v1 = arg13.obtainStyledAttributes(arg14, FragmentTag.Fragment);
            String v6 = v0_1 == null ? v1.getString(0) : v0_1;
            int v7 = v1.getResourceId(1, v5);
            String v8 = v1.getString(2);
            v1.recycle();
            if(!Fragment.isSupportFragmentClass(this.mHost.getContext(), v6)) {
                return ((View)v4);
            }

            int v1_1 = arg11 != null ? arg11.getId() : 0;
            if(v1_1 == v5 && v7 == v5 && v8 == null) {
                throw new IllegalArgumentException(arg14.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + v6);
            }

            Fragment v0_2 = v7 != v5 ? this.findFragmentById(v7) : ((Fragment)v4);
            if(v0_2 == null && v8 != null) {
                v0_2 = this.findFragmentByTag(v8);
            }

            if(v0_2 == null && v1_1 != v5) {
                v0_2 = this.findFragmentById(v1_1);
            }

            if(FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(v7) + " fname=" + v6 + " existing=" + v0_2);
            }

            if(v0_2 == null) {
                Fragment v4_1 = Fragment.instantiate(arg13, v6);
                v4_1.mFromLayout = true;
                int v0_3 = v7 != 0 ? v7 : v1_1;
                v4_1.mFragmentId = v0_3;
                v4_1.mContainerId = v1_1;
                v4_1.mTag = v8;
                v4_1.mInLayout = true;
                v4_1.mFragmentManager = this;
                v4_1.mHost = this.mHost;
                v4_1.onInflate(this.mHost.getContext(), arg14, v4_1.mSavedFragmentState);
                this.addFragment(v4_1, true);
                v1_2 = v4_1;
            }
            else {
                if(v0_2.mInLayout) {
                    throw new IllegalArgumentException(arg14.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(v7) + ", tag " + v8 + ", or parent id 0x" + Integer.toHexString(v1_1) + " with another fragment for " + v6);
                }

                v0_2.mInLayout = true;
                v0_2.mHost = this.mHost;
                if(!v0_2.mRetaining) {
                    v0_2.onInflate(this.mHost.getContext(), arg14, v0_2.mSavedFragmentState);
                }

                v1_2 = v0_2;
            }

            if(this.mCurState >= 1 || !v1_2.mFromLayout) {
                this.moveToState(v1_2);
            }
            else {
                this.moveToState(v1_2, 1, 0, 0, false);
            }

            if(v1_2.mView == null) {
                throw new IllegalStateException("Fragment " + v6 + " did not create a view.");
            }

            if(v7 != 0) {
                v1_2.mView.setId(v7);
            }

            if(v1_2.mView.getTag() == null) {
                v1_2.mView.setTag(v8);
            }

            v0 = v1_2.mView;
        }

        return v0;
    }

    private void optimizeAndExecuteOps(ArrayList arg6, ArrayList arg7) {
        int v0;
        int v2 = 0;
        if(arg6 != null && !arg6.isEmpty()) {
            if(arg7 != null && arg6.size() == arg7.size()) {
                this.executePostponedTransaction(arg6, arg7);
                int v3 = arg6.size();
                int v1 = 0;
                while(v2 < v3) {
                    if(!arg6.get(v2).mAllowOptimization) {
                        if(v1 != v2) {
                            this.executeOpsTogether(arg6, arg7, v1, v2);
                        }

                        v1 = v2 + 1;
                        if(arg7.get(v2).booleanValue()) {
                            while(v1 < v3) {
                                if(!arg7.get(v1).booleanValue()) {
                                    break;
                                }

                                if(arg6.get(v1).mAllowOptimization) {
                                    break;
                                }

                                ++v1;
                            }
                        }

                        v0 = v1;
                        this.executeOpsTogether(arg6, arg7, v2, v0);
                        v1 = v0;
                        --v0;
                    }
                    else {
                        v0 = v2;
                    }

                    v2 = v0 + 1;
                }

                if(v1 == v3) {
                    return;
                }

                this.executeOpsTogether(arg6, arg7, v1, v3);
                return;
            }

            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    public void performPendingDeferredStart(Fragment arg7) {
        if(arg7.mDeferStart) {
            if(this.mExecutingActions) {
                this.mHavePendingDeferredStart = true;
            }
            else {
                arg7.mDeferStart = false;
                this.moveToState(arg7, this.mCurState, 0, 0, false);
            }
        }
    }

    public void popBackStack() {
        this.enqueueAction(new PopBackStackState(this, null, -1, 0), false);
    }

    public void popBackStack(int arg4, int arg5) {
        if(arg4 < 0) {
            throw new IllegalArgumentException("Bad id: " + arg4);
        }

        this.enqueueAction(new PopBackStackState(this, null, arg4, arg5), false);
    }

    public void popBackStack(String arg3, int arg4) {
        this.enqueueAction(new PopBackStackState(this, arg3, -1, arg4), false);
    }

    private boolean popBackStackImmediate(String arg8, int arg9, int arg10) {
        this.execPendingActions();
        this.ensureExecReady(true);
        boolean v0 = this.popBackStackState(this.mTmpRecords, this.mTmpIsPop, arg8, arg9, arg10);
        if(v0) {
            this.mExecutingActions = true;
            try {
                this.optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
            }
            catch(Throwable v0_1) {
                this.cleanupExec();
                throw v0_1;
            }

            this.cleanupExec();
        }

        this.doPendingDeferredStart();
        return v0;
    }

    public boolean popBackStackImmediate() {
        this.checkStateLoss();
        return this.popBackStackImmediate(null, -1, 0);
    }

    public boolean popBackStackImmediate(int arg4, int arg5) {
        this.checkStateLoss();
        this.execPendingActions();
        if(arg4 < 0) {
            throw new IllegalArgumentException("Bad id: " + arg4);
        }

        return this.popBackStackImmediate(null, arg4, arg5);
    }

    public boolean popBackStackImmediate(String arg2, int arg3) {
        this.checkStateLoss();
        return this.popBackStackImmediate(arg2, -1, arg3);
    }

    boolean popBackStackState(ArrayList arg6, ArrayList arg7, String arg8, int arg9, int arg10) {
        int v0_1;
        Object v0_2;
        boolean v0;
        if(this.mBackStack == null) {
            v0 = false;
        }
        else {
            if(arg8 != null || arg9 >= 0 || (arg10 & 1) != 0) {
                v0_1 = -1;
                if(arg8 != null || arg9 >= 0) {
                    int v1;
                    for(v1 = this.mBackStack.size() - 1; v1 >= 0; --v1) {
                        v0_2 = this.mBackStack.get(v1);
                        if(arg8 != null && (arg8.equals(((BackStackRecord)v0_2).getName()))) {
                            break;
                        }

                        if(arg9 >= 0 && arg9 == ((BackStackRecord)v0_2).mIndex) {
                            break;
                        }
                    }

                    if(v1 < 0) {
                        return false;
                    }

                    if((arg10 & 1) != 0) {
                        --v1;
                        while(v1 >= 0) {
                            v0_2 = this.mBackStack.get(v1);
                            if(arg8 == null || !arg8.equals(((BackStackRecord)v0_2).getName())) {
                                if(arg9 < 0) {
                                }
                                else if(arg9 == ((BackStackRecord)v0_2).mIndex) {
                                    goto label_57;
                                }

                                break;
                            }

                        label_57:
                            --v1;
                        }
                    }

                    v0_1 = v1;
                }

                if(v0_1 == this.mBackStack.size() - 1) {
                    return false;
                }

                for(v1 = this.mBackStack.size() - 1; v1 > v0_1; --v1) {
                    arg6.add(this.mBackStack.remove(v1));
                    arg7.add(Boolean.valueOf(true));
                }
            }
            else {
                v0_1 = this.mBackStack.size() - 1;
                if(v0_1 < 0) {
                    return false;
                }
                else {
                    arg6.add(this.mBackStack.remove(v0_1));
                    arg7.add(Boolean.valueOf(true));
                }
            }

            v0 = true;
        }

        return v0;
    }

    private int postponePostponableTransactions(ArrayList arg8, ArrayList arg9, int arg10, int arg11, ArraySet arg12) {
        int v0_1;
        int v4 = arg11 - 1;
        int v2;
        for(v2 = arg11; v4 >= arg10; v2 = v0_1) {
            Object v0 = arg8.get(v4);
            boolean v5 = arg9.get(v4).booleanValue();
            int v1 = !((BackStackRecord)v0).isPostponed() || (((BackStackRecord)v0).interactsWith(arg8, v4 + 1, arg11)) ? 0 : 1;
            if(v1 != 0) {
                if(this.mPostponedTransactions == null) {
                    this.mPostponedTransactions = new ArrayList();
                }

                StartEnterTransitionListener v1_1 = new StartEnterTransitionListener(((BackStackRecord)v0), v5);
                this.mPostponedTransactions.add(v1_1);
                ((BackStackRecord)v0).setOnStartPostponedListener(((OnStartEnterTransitionListener)v1_1));
                if(v5) {
                    ((BackStackRecord)v0).executeOps();
                }
                else {
                    ((BackStackRecord)v0).executePopOps(false);
                }

                v1 = v2 - 1;
                if(v4 != v1) {
                    arg8.remove(v4);
                    arg8.add(v1, v0);
                }

                this.addAddedFragments(arg12);
                v0_1 = v1;
            }
            else {
                v0_1 = v2;
            }

            --v4;
        }

        return v2;
    }

    public void putFragment(Bundle arg4, String arg5, Fragment arg6) {
        if(arg6.mIndex < 0) {
            this.throwException(new IllegalStateException("Fragment " + arg6 + " is not currently in the FragmentManager"));
        }

        arg4.putInt(arg5, arg6.mIndex);
    }

    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks arg4, boolean arg5) {
        if(this.mLifecycleCallbacks == null) {
            this.mLifecycleCallbacks = new CopyOnWriteArrayList();
        }

        this.mLifecycleCallbacks.add(new Pair(arg4, Boolean.valueOf(arg5)));
    }

    public void removeFragment(Fragment arg6) {
        if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "remove: " + arg6 + " nesting=" + arg6.mBackStackNesting);
        }

        int v0 = !arg6.isInBackStack() ? 1 : 0;
        if(!arg6.mDetached || v0 != 0) {
            if(this.mAdded != null) {
                this.mAdded.remove(arg6);
            }

            if((arg6.mHasMenu) && (arg6.mMenuVisible)) {
                this.mNeedMenuInvalidate = true;
            }

            arg6.mAdded = false;
            arg6.mRemoving = true;
        }
    }

    public void removeOnBackStackChangedListener(OnBackStackChangedListener arg2) {
        if(this.mBackStackChangeListeners != null) {
            this.mBackStackChangeListeners.remove(arg2);
        }
    }

    void reportBackStackChanged() {
        if(this.mBackStackChangeListeners != null) {
            int v1;
            for(v1 = 0; v1 < this.mBackStackChangeListeners.size(); ++v1) {
                this.mBackStackChangeListeners.get(v1).onBackStackChanged();
            }
        }
    }

    void restoreAllState(Parcelable arg11, FragmentManagerNonConfig arg12) {
        List v1_1;
        Object v0;
        int v1;
        List v6;
        SparseArray v4 = null;
        if(arg11 != null && ((FragmentManagerState)arg11).mActive != null) {
            if(arg12 != null) {
                v6 = arg12.getFragments();
                List v3 = arg12.getChildNonConfigs();
                v1 = v6 != null ? v6.size() : 0;
                int v5;
                for(v5 = 0; v5 < v1; ++v5) {
                    v0 = v6.get(v5);
                    if(FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "restoreAllState: re-attaching retained " + v0);
                    }

                    FragmentState v7 = ((FragmentManagerState)arg11).mActive[((Fragment)v0).mIndex];
                    v7.mInstance = ((Fragment)v0);
                    ((Fragment)v0).mSavedViewState = v4;
                    ((Fragment)v0).mBackStackNesting = 0;
                    ((Fragment)v0).mInLayout = false;
                    ((Fragment)v0).mAdded = false;
                    ((Fragment)v0).mTarget = ((Fragment)v4);
                    if(v7.mSavedFragmentState != null) {
                        v7.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
                        ((Fragment)v0).mSavedViewState = v7.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                        ((Fragment)v0).mSavedFragmentState = v7.mSavedFragmentState;
                    }
                }

                v1_1 = v3;
            }
            else {
                v1_1 = ((List)v4);
            }

            this.mActive = new ArrayList(((FragmentManagerState)arg11).mActive.length);
            if(this.mAvailIndices != null) {
                this.mAvailIndices.clear();
            }

            int v3_1;
            for(v3_1 = 0; v3_1 < ((FragmentManagerState)arg11).mActive.length; ++v3_1) {
                FragmentState v5_1 = ((FragmentManagerState)arg11).mActive[v3_1];
                if(v5_1 != null) {
                    if(v1_1 == null || v3_1 >= v1_1.size()) {
                        FragmentManagerNonConfig v0_1 = ((FragmentManagerNonConfig)v4);
                    }
                    else {
                        v0 = v1_1.get(v3_1);
                    }

                    Fragment v0_2 = v5_1.instantiate(this.mHost, this.mParent, ((FragmentManagerNonConfig)v0));
                    if(FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "restoreAllState: active #" + v3_1 + ": " + v0_2);
                    }

                    this.mActive.add(v0_2);
                    v5_1.mInstance = ((Fragment)v4);
                }
                else {
                    this.mActive.add(v4);
                    if(this.mAvailIndices == null) {
                        this.mAvailIndices = new ArrayList();
                    }

                    if(FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "restoreAllState: avail #" + v3_1);
                    }

                    this.mAvailIndices.add(Integer.valueOf(v3_1));
                }
            }

            if(arg12 != null) {
                v6 = arg12.getFragments();
                v3_1 = v6 != null ? v6.size() : 0;
                for(v5 = 0; v5 < v3_1; ++v5) {
                    v0 = v6.get(v5);
                    if(((Fragment)v0).mTargetIndex >= 0) {
                        if(((Fragment)v0).mTargetIndex < this.mActive.size()) {
                            ((Fragment)v0).mTarget = this.mActive.get(((Fragment)v0).mTargetIndex);
                        }
                        else {
                            Log.w("FragmentManager", "Re-attaching retained fragment " + v0 + " target no longer exists: " + ((Fragment)v0).mTargetIndex);
                            ((Fragment)v0).mTarget = ((Fragment)v4);
                        }
                    }
                }
            }

            if(((FragmentManagerState)arg11).mAdded != null) {
                this.mAdded = new ArrayList(((FragmentManagerState)arg11).mAdded.length);
                for(v1 = 0; v1 < ((FragmentManagerState)arg11).mAdded.length; ++v1) {
                    v0 = this.mActive.get(((FragmentManagerState)arg11).mAdded[v1]);
                    if(v0 == null) {
                        this.throwException(new IllegalStateException("No instantiated fragment for index #" + ((FragmentManagerState)arg11).mAdded[v1]));
                    }

                    ((Fragment)v0).mAdded = true;
                    if(FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "restoreAllState: added #" + v1 + ": " + v0);
                    }

                    if(this.mAdded.contains(v0)) {
                        throw new IllegalStateException("Already added!");
                    }

                    this.mAdded.add(v0);
                }
            }
            else {
                this.mAdded = ((ArrayList)v4);
            }

            if(((FragmentManagerState)arg11).mBackStack != null) {
                this.mBackStack = new ArrayList(((FragmentManagerState)arg11).mBackStack.length);
                int v0_3;
                for(v0_3 = 0; true; ++v0_3) {
                    if(v0_3 >= ((FragmentManagerState)arg11).mBackStack.length) {
                        return;
                    }

                    BackStackRecord v1_2 = ((FragmentManagerState)arg11).mBackStack[v0_3].instantiate(this);
                    if(FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "restoreAllState: back stack #" + v0_3 + " (index " + v1_2.mIndex + "): " + v1_2);
                        PrintWriter v4_1 = new PrintWriter(new LogWriter("FragmentManager"));
                        v1_2.dump("  ", v4_1, false);
                        v4_1.close();
                    }

                    this.mBackStack.add(v1_2);
                    if(v1_2.mIndex >= 0) {
                        this.setBackStackIndex(v1_2.mIndex, v1_2);
                    }
                }
            }

            this.mBackStack = ((ArrayList)v4);
        }
    }

    FragmentManagerNonConfig retainNonConfig() {
        int v0_2;
        ArrayList v0_1;
        ArrayList v1;
        Object v5 = null;
        if(this.mActive != null) {
            int v3 = 0;
            v1 = ((ArrayList)v5);
            ArrayList v2;
            for(v2 = ((ArrayList)v5); v3 < this.mActive.size(); v2 = v2) {
                Object v0 = this.mActive.get(v3);
                if(v0 != null) {
                    if(((Fragment)v0).mRetainInstance) {
                        if(v2 == null) {
                            v2 = new ArrayList();
                        }

                        v2.add(v0);
                        ((Fragment)v0).mRetaining = true;
                        int v6 = ((Fragment)v0).mTarget != null ? ((Fragment)v0).mTarget.mIndex : -1;
                        ((Fragment)v0).mTargetIndex = v6;
                        if(!FragmentManagerImpl.DEBUG) {
                            goto label_36;
                        }

                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + v0);
                    }

                label_36:
                    if(((Fragment)v0).mChildFragmentManager != null) {
                        FragmentManagerNonConfig v6_1 = ((Fragment)v0).mChildFragmentManager.retainNonConfig();
                        if(v6_1 != null) {
                            if(v1 == null) {
                                v0_1 = new ArrayList();
                                int v1_1;
                                for(v1_1 = 0; v1_1 < v3; ++v1_1) {
                                    v0_1.add(v5);
                                }
                            }
                            else {
                                v0_1 = v1;
                            }

                            v0_1.add(v6_1);
                            v1 = v0_1;
                            v0_2 = 1;
                        }
                        else {
                            goto label_71;
                        }
                    }
                    else {
                    label_71:
                        v0_2 = 0;
                    }

                    if(v1 == null) {
                        goto label_58;
                    }

                    if(v0_2 != 0) {
                        goto label_58;
                    }

                    v1.add(v5);
                }

            label_58:
                ++v3;
            }
        }
        else {
            v1 = ((ArrayList)v5);
            v2 = ((ArrayList)v5);
        }

        if(v2 != null || v1 != null) {
            FragmentManagerNonConfig v5_1 = new FragmentManagerNonConfig(((List)v2), ((List)v1));
        }

        return ((FragmentManagerNonConfig)v5);
    }

    public static int reverseTransit(int arg1) {
        int v0 = 0;
        switch(arg1) {
            case 4097: {
                v0 = 0x2002;
                break;
            }
            case 4099: {
                v0 = 0x1003;
                break;
            }
            case 8194: {
                v0 = 0x1001;
                break;
            }
        }

        return v0;
    }

    Parcelable saveAllState() {
        int[] v1;
        int v0_1;
        Parcelable v3 = null;
        this.forcePostponedTransactions();
        this.endAnimatingAwayFragments();
        this.execPendingActions();
        if(FragmentManagerImpl.HONEYCOMB) {
            this.mStateSaved = true;
        }

        if(this.mActive != null && this.mActive.size() > 0) {
            int v6 = this.mActive.size();
            FragmentState[] v7 = new FragmentState[v6];
            int v5 = 0;
            int v2;
            for(v2 = 0; v5 < v6; v2 = v0_1) {
                Object v0 = this.mActive.get(v5);
                if(v0 != null) {
                    if(((Fragment)v0).mIndex < 0) {
                        this.throwException(new IllegalStateException("Failure saving state: active " + v0 + " has cleared index: " + ((Fragment)v0).mIndex));
                    }

                    FragmentState v2_1 = new FragmentState(((Fragment)v0));
                    v7[v5] = v2_1;
                    if(((Fragment)v0).mState <= 0 || v2_1.mSavedFragmentState != null) {
                        v2_1.mSavedFragmentState = ((Fragment)v0).mSavedFragmentState;
                    }
                    else {
                        v2_1.mSavedFragmentState = this.saveFragmentBasicState(((Fragment)v0));
                        if(((Fragment)v0).mTarget != null) {
                            if(((Fragment)v0).mTarget.mIndex < 0) {
                                this.throwException(new IllegalStateException("Failure saving state: " + v0 + " has target not in fragment manager: " + ((Fragment)v0).mTarget));
                            }

                            if(v2_1.mSavedFragmentState == null) {
                                v2_1.mSavedFragmentState = new Bundle();
                            }

                            this.putFragment(v2_1.mSavedFragmentState, "android:target_state", ((Fragment)v0).mTarget);
                            if(((Fragment)v0).mTargetRequestCode == 0) {
                                goto label_81;
                            }

                            v2_1.mSavedFragmentState.putInt("android:target_req_state", ((Fragment)v0).mTargetRequestCode);
                        }
                    }

                label_81:
                    if(FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "Saved state of " + v0 + ": " + v2_1.mSavedFragmentState);
                    }

                    v0_1 = 1;
                }
                else {
                    v0_1 = v2;
                }

                ++v5;
            }

            if(v2 == 0) {
                if(!FragmentManagerImpl.DEBUG) {
                    return v3;
                }

                Log.v("FragmentManager", "saveAllState: no fragments!");
                return v3;
            }

            if(this.mAdded != null) {
                v5 = this.mAdded.size();
                if(v5 > 0) {
                    v1 = new int[v5];
                    v2 = 0;
                    goto label_117;
                }
                else {
                    goto label_157;
                }
            }
            else {
            label_157:
                v1 = ((int[])v3);
                goto label_158;
            label_117:
                while(v2 < v5) {
                    v1[v2] = this.mAdded.get(v2).mIndex;
                    if(v1[v2] < 0) {
                        this.throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(v2) + " has cleared index: " + v1[v2]));
                    }

                    if(FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + v2 + ": " + this.mAdded.get(v2));
                    }

                    ++v2;
                }
            }

        label_158:
            if(this.mBackStack != null) {
                v5 = this.mBackStack.size();
                if(v5 > 0) {
                    BackStackState[] v3_1 = new BackStackState[v5];
                    for(v2 = 0; v2 < v5; ++v2) {
                        v3_1[v2] = new BackStackState(this.mBackStack.get(v2));
                        if(FragmentManagerImpl.DEBUG) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + v2 + ": " + this.mBackStack.get(v2));
                        }
                    }
                }
            }

            FragmentManagerState v0_2 = new FragmentManagerState();
            v0_2.mActive = v7;
            v0_2.mAdded = v1;
            v0_2.mBackStack = ((BackStackState[])v3);
            FragmentManagerState v3_2 = v0_2;
        }

        return v3;
    }

    Bundle saveFragmentBasicState(Fragment arg4) {
        Bundle v0;
        Bundle v1 = null;
        if(this.mStateBundle == null) {
            this.mStateBundle = new Bundle();
        }

        arg4.performSaveInstanceState(this.mStateBundle);
        this.dispatchOnFragmentSaveInstanceState(arg4, this.mStateBundle, false);
        if(!this.mStateBundle.isEmpty()) {
            v0 = this.mStateBundle;
            this.mStateBundle = v1;
        }
        else {
            v0 = v1;
        }

        if(arg4.mView != null) {
            this.saveFragmentViewState(arg4);
        }

        if(arg4.mSavedViewState != null) {
            if(v0 == null) {
                v0 = new Bundle();
            }

            v0.putSparseParcelableArray("android:view_state", arg4.mSavedViewState);
        }

        if(!arg4.mUserVisibleHint) {
            if(v0 == null) {
                v0 = new Bundle();
            }

            v0.putBoolean("android:user_visible_hint", arg4.mUserVisibleHint);
        }

        return v0;
    }

    public SavedState saveFragmentInstanceState(Fragment arg5) {
        SavedState v0 = null;
        if(arg5.mIndex < 0) {
            this.throwException(new IllegalStateException("Fragment " + arg5 + " is not currently in the FragmentManager"));
        }

        if(arg5.mState > 0) {
            Bundle v1 = this.saveFragmentBasicState(arg5);
            if(v1 != null) {
                v0 = new SavedState(v1);
            }
        }

        return v0;
    }

    void saveFragmentViewState(Fragment arg3) {
        if(arg3.mInnerView != null) {
            if(this.mStateArray == null) {
                this.mStateArray = new SparseArray();
            }
            else {
                this.mStateArray.clear();
            }

            arg3.mInnerView.saveHierarchyState(this.mStateArray);
            if(this.mStateArray.size() <= 0) {
                return;
            }

            arg3.mSavedViewState = this.mStateArray;
            this.mStateArray = null;
        }
    }

    private void scheduleCommit() {
        int v0 = 1;
        __monitor_enter(this);
        try {
            int v2 = this.mPostponedTransactions == null || (this.mPostponedTransactions.isEmpty()) ? 0 : 1;
            if(this.mPendingActions == null || this.mPendingActions.size() != 1) {
                v0 = 0;
            }

            if(v2 != 0 || v0 != 0) {
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                this.mHost.getHandler().post(this.mExecCommit);
            }

            __monitor_exit(this);
            return;
        label_31:
            __monitor_exit(this);
        }
        catch(Throwable v0_1) {
            goto label_31;
        }

        throw v0_1;
    }

    public void setBackStackIndex(int arg5, BackStackRecord arg6) {
        __monitor_enter(this);
        try {
            if(this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList();
            }

            int v0_1 = this.mBackStackIndices.size();
            if(arg5 < v0_1) {
                if(FragmentManagerImpl.DEBUG) {
                    Log.v("FragmentManager", "Setting back stack index " + arg5 + " to " + arg6);
                }

                this.mBackStackIndices.set(arg5, arg6);
            }
            else {
                while(v0_1 < arg5) {
                    this.mBackStackIndices.add(null);
                    if(this.mAvailBackStackIndices == null) {
                        this.mAvailBackStackIndices = new ArrayList();
                    }

                    if(FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "Adding available back stack index " + v0_1);
                    }

                    this.mAvailBackStackIndices.add(Integer.valueOf(v0_1));
                    ++v0_1;
                }

                if(FragmentManagerImpl.DEBUG) {
                    Log.v("FragmentManager", "Adding back stack index " + arg5 + " with " + arg6);
                }

                this.mBackStackIndices.add(arg6);
            }

            __monitor_exit(this);
            return;
        label_67:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_67;
        }

        throw v0;
    }

    private void setHWLayerAnimListenerIfAlpha(View arg5, Animation arg6) {
        Animation$AnimationListener v0_3;
        Paint v1 = null;
        if(arg5 != null && (arg6 != null && (FragmentManagerImpl.shouldRunOnHWLayer(arg5, arg6)))) {
            try {
                if(FragmentManagerImpl.sAnimationListenerField == null) {
                    FragmentManagerImpl.sAnimationListenerField = Animation.class.getDeclaredField("mListener");
                    FragmentManagerImpl.sAnimationListenerField.setAccessible(true);
                }

                Object v0_2 = FragmentManagerImpl.sAnimationListenerField.get(arg6);
            }
            catch(NoSuchFieldException v0) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", ((Throwable)v0));
                v0_3 = ((Animation$AnimationListener)v1);
            }
            catch(IllegalAccessException v0_1) {
                Log.e("FragmentManager", "Cannot access Animation\'s mListener field", ((Throwable)v0_1));
                v0_3 = ((Animation$AnimationListener)v1);
            }

            int v2 = 2;
            ViewCompat.setLayerType(arg5, v2, v1);
            arg6.setAnimationListener(new AnimateOnHWLayerIfNeededListener(arg5, arg6, v0_3));
        }
    }

    static boolean shouldRunOnHWLayer(View arg2, Animation arg3) {
        boolean v0 = Build$VERSION.SDK_INT < 19 || ViewCompat.getLayerType(arg2) != 0 || !ViewCompat.hasOverlappingRendering(arg2) || !FragmentManagerImpl.modifiesAlpha(arg3) ? false : true;
        return v0;
    }

    public void showFragment(Fragment arg5) {
        boolean v0 = false;
        if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "show: " + arg5);
        }

        if(arg5.mHidden) {
            arg5.mHidden = false;
            if(!arg5.mHiddenChanged) {
                v0 = true;
            }

            arg5.mHiddenChanged = v0;
        }
    }

    void startPendingDeferredFragments() {
        if(this.mActive != null) {
            int v1;
            for(v1 = 0; v1 < this.mActive.size(); ++v1) {
                Object v0 = this.mActive.get(v1);
                if(v0 != null) {
                    this.performPendingDeferredStart(((Fragment)v0));
                }
            }
        }
    }

    private void throwException(RuntimeException arg6) {
        Log.e("FragmentManager", arg6.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter v1 = new PrintWriter(new LogWriter("FragmentManager"));
        if(this.mHost != null) {
            try {
                this.mHost.onDump("  ", null, v1, new String[0]);
            }
            catch(Exception v0) {
                Log.e("FragmentManager", "Failed dumping state", ((Throwable)v0));
            }

            goto label_19;
        }

        try {
            this.dump("  ", null, v1, new String[0]);
        }
        catch(Exception v0) {
            Log.e("FragmentManager", "Failed dumping state", ((Throwable)v0));
        }

    label_19:
        throw arg6;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x80);
        v0.append("FragmentManager{");
        v0.append(Integer.toHexString(System.identityHashCode(this)));
        v0.append(" in ");
        if(this.mParent != null) {
            DebugUtils.buildShortClassTag(this.mParent, v0);
        }
        else {
            DebugUtils.buildShortClassTag(this.mHost, v0);
        }

        v0.append("}}");
        return v0.toString();
    }

    public static int transitToStyleIndex(int arg1, boolean arg2) {
        int v0 = -1;
        switch(arg1) {
            case 4097: {
                if(arg2) {
                    return 1;
                }

                v0 = 2;
                break;
            }
            case 4099: {
                if(arg2) {
                    return 5;
                }

                v0 = 6;
                break;
            }
            case 8194: {
                if(arg2) {
                    return 3;
                }

                v0 = 4;
                break;
            }
        }

        return v0;
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks arg5) {
        int v1;
        CopyOnWriteArrayList v2;
        if(this.mLifecycleCallbacks != null) {
            v2 = this.mLifecycleCallbacks;
            __monitor_enter(v2);
            try {
                int v3 = this.mLifecycleCallbacks.size();
                v1 = 0;
                while(true) {
                label_9:
                    if(v1 < v3) {
                        if(this.mLifecycleCallbacks.get(v1).first == arg5) {
                            this.mLifecycleCallbacks.remove(v1);
                        }
                        else {
                            break;
                        }
                    }

                    goto label_16;
                }
            }
            catch(Throwable v0) {
                goto label_19;
            }

            ++v1;
            goto label_9;
            try {
            label_16:
                __monitor_exit(v2);
            }
            catch(Throwable v0) {
                goto label_19;
            }
        }

        return;
        try {
        label_19:
            __monitor_exit(v2);
        }
        catch(Throwable v0) {
            goto label_19;
        }

        throw v0;
    }
}

