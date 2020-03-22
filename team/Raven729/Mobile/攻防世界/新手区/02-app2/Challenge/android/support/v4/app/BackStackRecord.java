package android.support.v4.app;

import android.os.Build$VERSION;
import android.support.v4.util.LogWriter;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements BackStackEntry, OpGenerator {
    final class Op {
        int cmd;
        int enterAnim;
        int exitAnim;
        Fragment fragment;
        int popEnterAnim;
        int popExitAnim;

        Op() {
            super();
        }
    }

    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SHOW = 5;
    static final boolean SUPPORTS_TRANSITIONS = false;
    static final String TAG = "FragmentManager";
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    boolean mAllowOptimization;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    boolean mCommitted;
    int mEnterAnim;
    int mExitAnim;
    int mIndex;
    final FragmentManagerImpl mManager;
    String mName;
    ArrayList mOps;
    int mPopEnterAnim;
    int mPopExitAnim;
    ArrayList mSharedElementSourceNames;
    ArrayList mSharedElementTargetNames;
    int mTransition;
    int mTransitionStyle;

    static {
        boolean v0 = Build$VERSION.SDK_INT >= 21 ? true : false;
        BackStackRecord.SUPPORTS_TRANSITIONS = v0;
    }

    public BackStackRecord(FragmentManagerImpl arg2) {
        super();
        this.mOps = new ArrayList();
        this.mAllowAddToBackStack = true;
        this.mIndex = -1;
        this.mAllowOptimization = false;
        this.mManager = arg2;
    }

    public FragmentTransaction add(int arg3, Fragment arg4) {
        this.doAddOp(arg3, arg4, null, 1);
        return this;
    }

    public FragmentTransaction add(int arg2, Fragment arg3, String arg4) {
        this.doAddOp(arg2, arg3, arg4, 1);
        return this;
    }

    public FragmentTransaction add(Fragment arg3, String arg4) {
        this.doAddOp(0, arg3, arg4, 1);
        return this;
    }

    void addOp(Op arg2) {
        this.mOps.add(arg2);
        arg2.enterAnim = this.mEnterAnim;
        arg2.exitAnim = this.mExitAnim;
        arg2.popEnterAnim = this.mPopEnterAnim;
        arg2.popExitAnim = this.mPopExitAnim;
    }

    public FragmentTransaction addSharedElement(View arg5, String arg6) {
        if(BackStackRecord.SUPPORTS_TRANSITIONS) {
            String v0 = ViewCompat.getTransitionName(arg5);
            if(v0 == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            else {
                if(this.mSharedElementSourceNames == null) {
                    this.mSharedElementSourceNames = new ArrayList();
                    this.mSharedElementTargetNames = new ArrayList();
                }
                else if(this.mSharedElementTargetNames.contains(arg6)) {
                    throw new IllegalArgumentException("A shared element with the target name \'" + arg6 + "\' has already been added to the transaction.");
                }
                else if(this.mSharedElementSourceNames.contains(v0)) {
                    throw new IllegalArgumentException("A shared element with the source name \'" + v0 + " has already been added to the transaction.");
                }

                this.mSharedElementSourceNames.add(v0);
                this.mSharedElementTargetNames.add(arg6);
            }
        }

        return this;
    }

    public FragmentTransaction addToBackStack(String arg3) {
        if(!this.mAllowAddToBackStack) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }

        this.mAddToBackStack = true;
        this.mName = arg3;
        return this;
    }

    public FragmentTransaction attach(Fragment arg3) {
        Op v0 = new Op();
        v0.cmd = 7;
        v0.fragment = arg3;
        this.addOp(v0);
        return this;
    }

    void bumpBackStackNesting(int arg7) {
        if(this.mAddToBackStack) {
            if(FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + arg7);
            }

            int v2 = this.mOps.size();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                Object v0 = this.mOps.get(v1);
                if(((Op)v0).fragment != null) {
                    ((Op)v0).fragment.mBackStackNesting += arg7;
                    if(FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "Bump nesting of " + ((Op)v0).fragment + " to " + ((Op)v0).fragment.mBackStackNesting);
                    }
                }
            }
        }
    }

    public int commit() {
        return this.commitInternal(false);
    }

    public int commitAllowingStateLoss() {
        return this.commitInternal(true);
    }

    int commitInternal(boolean arg5) {
        FileDescriptor v3 = null;
        if(this.mCommitted) {
            throw new IllegalStateException("commit already called");
        }

        if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter v1 = new PrintWriter(new LogWriter("FragmentManager"));
            this.dump("  ", v3, v1, ((String[])v3));
            v1.close();
        }

        this.mCommitted = true;
        this.mIndex = this.mAddToBackStack ? this.mManager.allocBackStackIndex(this) : -1;
        this.mManager.enqueueAction(((OpGenerator)this), arg5);
        return this.mIndex;
    }

    public void commitNow() {
        this.disallowAddToBackStack();
        this.mManager.execSingleAction(((OpGenerator)this), false);
    }

    public void commitNowAllowingStateLoss() {
        this.disallowAddToBackStack();
        this.mManager.execSingleAction(((OpGenerator)this), true);
    }

    public FragmentTransaction detach(Fragment arg3) {
        Op v0 = new Op();
        v0.cmd = 6;
        v0.fragment = arg3;
        this.addOp(v0);
        return this;
    }

    public FragmentTransaction disallowAddToBackStack() {
        if(this.mAddToBackStack) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }

        this.mAllowAddToBackStack = false;
        return this;
    }

    private void doAddOp(int arg5, Fragment arg6, String arg7, int arg8) {
        Class v0 = arg6.getClass();
        int v1 = v0.getModifiers();
        if(!v0.isAnonymousClass() && (Modifier.isPublic(v1)) && (!v0.isMemberClass() || (Modifier.isStatic(v1)))) {
            arg6.mFragmentManager = this.mManager;
            if(arg7 != null) {
                if(arg6.mTag != null && !arg7.equals(arg6.mTag)) {
                    throw new IllegalStateException("Can\'t change tag of fragment " + arg6 + ": was " + arg6.mTag + " now " + arg7);
                }

                arg6.mTag = arg7;
            }

            if(arg5 != 0) {
                if(arg5 == -1) {
                    throw new IllegalArgumentException("Can\'t add fragment " + arg6 + " with tag " + arg7 + " to container view with no id");
                }
                else {
                    if(arg6.mFragmentId != 0 && arg6.mFragmentId != arg5) {
                        throw new IllegalStateException("Can\'t change container ID of fragment " + arg6 + ": was " + arg6.mFragmentId + " now " + arg5);
                    }

                    arg6.mFragmentId = arg5;
                    arg6.mContainerId = arg5;
                }
            }

            Op v0_1 = new Op();
            v0_1.cmd = arg8;
            v0_1.fragment = arg6;
            this.addOp(v0_1);
            return;
        }

        throw new IllegalStateException("Fragment " + v0.getCanonicalName() + " must be a public static class to be  properly recreated from" + " instance state.");
    }

    public void dump(String arg2, FileDescriptor arg3, PrintWriter arg4, String[] arg5) {
        this.dump(arg2, arg4, true);
    }

    public void dump(String arg6, PrintWriter arg7, boolean arg8) {
        String v1;
        if(arg8) {
            arg7.print(arg6);
            arg7.print("mName=");
            arg7.print(this.mName);
            arg7.print(" mIndex=");
            arg7.print(this.mIndex);
            arg7.print(" mCommitted=");
            arg7.println(this.mCommitted);
            if(this.mTransition != 0) {
                arg7.print(arg6);
                arg7.print("mTransition=#");
                arg7.print(Integer.toHexString(this.mTransition));
                arg7.print(" mTransitionStyle=#");
                arg7.println(Integer.toHexString(this.mTransitionStyle));
            }

            if(this.mEnterAnim != 0 || this.mExitAnim != 0) {
                arg7.print(arg6);
                arg7.print("mEnterAnim=#");
                arg7.print(Integer.toHexString(this.mEnterAnim));
                arg7.print(" mExitAnim=#");
                arg7.println(Integer.toHexString(this.mExitAnim));
            }

            if(this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                arg7.print(arg6);
                arg7.print("mPopEnterAnim=#");
                arg7.print(Integer.toHexString(this.mPopEnterAnim));
                arg7.print(" mPopExitAnim=#");
                arg7.println(Integer.toHexString(this.mPopExitAnim));
            }

            if(this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                arg7.print(arg6);
                arg7.print("mBreadCrumbTitleRes=#");
                arg7.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                arg7.print(" mBreadCrumbTitleText=");
                arg7.println(this.mBreadCrumbTitleText);
            }

            if(this.mBreadCrumbShortTitleRes == 0 && this.mBreadCrumbShortTitleText == null) {
                goto label_85;
            }

            arg7.print(arg6);
            arg7.print("mBreadCrumbShortTitleRes=#");
            arg7.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
            arg7.print(" mBreadCrumbShortTitleText=");
            arg7.println(this.mBreadCrumbShortTitleText);
        }

    label_85:
        if(!this.mOps.isEmpty()) {
            arg7.print(arg6);
            arg7.println("Operations:");
            new StringBuilder().append(arg6).append("    ").toString();
            int v3 = this.mOps.size();
            int v2;
            for(v2 = 0; v2 < v3; ++v2) {
                Object v0 = this.mOps.get(v2);
                switch(((Op)v0).cmd) {
                    case 0: {
                        v1 = "NULL";
                        break;
                    }
                    case 1: {
                        v1 = "ADD";
                        break;
                    }
                    case 2: {
                        v1 = "REPLACE";
                        break;
                    }
                    case 3: {
                        v1 = "REMOVE";
                        break;
                    }
                    case 4: {
                        v1 = "HIDE";
                        break;
                    }
                    case 5: {
                        v1 = "SHOW";
                        break;
                    }
                    case 6: {
                        v1 = "DETACH";
                        break;
                    }
                    case 7: {
                        v1 = "ATTACH";
                        break;
                    }
                    default: {
                        v1 = "cmd=" + ((Op)v0).cmd;
                        break;
                    }
                }

                arg7.print(arg6);
                arg7.print("  Op #");
                arg7.print(v2);
                arg7.print(": ");
                arg7.print(v1);
                arg7.print(" ");
                arg7.println(((Op)v0).fragment);
                if(arg8) {
                    if(((Op)v0).enterAnim != 0 || ((Op)v0).exitAnim != 0) {
                        arg7.print(arg6);
                        arg7.print("enterAnim=#");
                        arg7.print(Integer.toHexString(((Op)v0).enterAnim));
                        arg7.print(" exitAnim=#");
                        arg7.println(Integer.toHexString(((Op)v0).exitAnim));
                    }

                    if(((Op)v0).popEnterAnim == 0 && ((Op)v0).popExitAnim == 0) {
                        goto label_155;
                    }

                    arg7.print(arg6);
                    arg7.print("popEnterAnim=#");
                    arg7.print(Integer.toHexString(((Op)v0).popEnterAnim));
                    arg7.print(" popExitAnim=#");
                    arg7.println(Integer.toHexString(((Op)v0).popExitAnim));
                }

            label_155:
            }
        }
    }

    void executeOps() {
        int v3 = this.mOps.size();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            Object v0 = this.mOps.get(v1);
            Fragment v4 = ((Op)v0).fragment;
            v4.setNextTransition(this.mTransition, this.mTransitionStyle);
            switch(((Op)v0).cmd) {
                case 1: {
                    goto label_24;
                }
                case 3: {
                    goto label_37;
                }
                case 4: {
                    goto label_42;
                }
                case 5: {
                    goto label_47;
                }
                case 6: {
                    goto label_52;
                }
                case 7: {
                    goto label_57;
                }
            }

            throw new IllegalArgumentException("Unknown cmd: " + ((Op)v0).cmd);
        label_52:
            v4.setNextAnim(((Op)v0).exitAnim);
            this.mManager.detachFragment(v4);
            goto label_28;
        label_37:
            v4.setNextAnim(((Op)v0).exitAnim);
            this.mManager.removeFragment(v4);
            goto label_28;
        label_24:
            v4.setNextAnim(((Op)v0).enterAnim);
            this.mManager.addFragment(v4, false);
            goto label_28;
        label_57:
            v4.setNextAnim(((Op)v0).enterAnim);
            this.mManager.attachFragment(v4);
            goto label_28;
        label_42:
            v4.setNextAnim(((Op)v0).exitAnim);
            this.mManager.hideFragment(v4);
            goto label_28;
        label_47:
            v4.setNextAnim(((Op)v0).enterAnim);
            this.mManager.showFragment(v4);
        label_28:
            if(!this.mAllowOptimization && ((Op)v0).cmd != 1) {
                this.mManager.moveFragmentToExpectedState(v4);
            }
        }

        if(!this.mAllowOptimization) {
            this.mManager.moveToState(this.mManager.mCurState, true);
        }
    }

    void executePopOps(boolean arg6) {
        int v1;
        for(v1 = this.mOps.size() - 1; v1 >= 0; --v1) {
            Object v0 = this.mOps.get(v1);
            Fragment v2 = ((Op)v0).fragment;
            v2.setNextTransition(FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
            switch(((Op)v0).cmd) {
                case 1: {
                    goto label_24;
                }
                case 3: {
                    goto label_38;
                }
                case 4: {
                    goto label_44;
                }
                case 5: {
                    goto label_49;
                }
                case 6: {
                    goto label_54;
                }
                case 7: {
                    goto label_59;
                }
            }

            throw new IllegalArgumentException("Unknown cmd: " + ((Op)v0).cmd);
        label_49:
            v2.setNextAnim(((Op)v0).popExitAnim);
            this.mManager.hideFragment(v2);
            goto label_28;
        label_38:
            v2.setNextAnim(((Op)v0).popEnterAnim);
            this.mManager.addFragment(v2, false);
            goto label_28;
        label_54:
            v2.setNextAnim(((Op)v0).popEnterAnim);
            this.mManager.attachFragment(v2);
            goto label_28;
        label_24:
            v2.setNextAnim(((Op)v0).popExitAnim);
            this.mManager.removeFragment(v2);
            goto label_28;
        label_59:
            v2.setNextAnim(((Op)v0).popExitAnim);
            this.mManager.detachFragment(v2);
            goto label_28;
        label_44:
            v2.setNextAnim(((Op)v0).popEnterAnim);
            this.mManager.showFragment(v2);
        label_28:
            if(!this.mAllowOptimization && ((Op)v0).cmd != 3) {
                this.mManager.moveFragmentToExpectedState(v2);
            }
        }

        if(!this.mAllowOptimization && (arg6)) {
            this.mManager.moveToState(this.mManager.mCurState, true);
        }
    }

    void expandReplaceOps(ArrayList arg13) {
        int v1;
        for(v1 = 0; v1 < this.mOps.size(); ++v1) {
            Object v0 = this.mOps.get(v1);
            switch(((Op)v0).cmd) {
                case 2: {
                    Fragment v7 = ((Op)v0).fragment;
                    int v8 = v7.mContainerId;
                    int v6 = arg13.size() - 1;
                    int v5 = v1;
                    int v4;
                    for(v4 = 0; v6 >= 0; v4 = v1) {
                        Object v1_1 = arg13.get(v6);
                        if(((Fragment)v1_1).mContainerId != v8) {
                            v1 = v4;
                            v4 = v5;
                        }
                        else if((((Fragment)v1_1)) == v7) {
                            v1 = 1;
                            v4 = v5;
                        }
                        else {
                            Op v9 = new Op();
                            v9.cmd = 3;
                            v9.fragment = ((Fragment)v1_1);
                            v9.enterAnim = ((Op)v0).enterAnim;
                            v9.popEnterAnim = ((Op)v0).popEnterAnim;
                            v9.exitAnim = ((Op)v0).exitAnim;
                            v9.popExitAnim = ((Op)v0).popExitAnim;
                            this.mOps.add(v5, v9);
                            arg13.remove(v1_1);
                            int v11 = v4;
                            v4 = v5 + 1;
                            v1 = v11;
                        }

                        --v6;
                        v5 = v4;
                    }

                    if(v4 != 0) {
                        this.mOps.remove(v5);
                        v1 = v5 - 1;
                        goto label_10;
                    }

                    ((Op)v0).cmd = 1;
                    arg13.add(v7);
                    v1 = v5;
                    break;
                }
                case 3: 
                case 6: {
                    arg13.remove(((Op)v0).fragment);
                    break;
                }
                case 1: 
                case 7: {
                    arg13.add(((Op)v0).fragment);
                    break;
                }
            }

        label_10:
        }
    }

    public boolean generateOps(ArrayList arg4, ArrayList arg5) {
        if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Run: " + this);
        }

        arg4.add(this);
        arg5.add(Boolean.valueOf(false));
        if(this.mAddToBackStack) {
            this.mManager.addBackStackState(this);
        }

        return 1;
    }

    public CharSequence getBreadCrumbShortTitle() {
        CharSequence v0 = this.mBreadCrumbShortTitleRes != 0 ? this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes) : this.mBreadCrumbShortTitleText;
        return v0;
    }

    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    public CharSequence getBreadCrumbTitle() {
        CharSequence v0 = this.mBreadCrumbTitleRes != 0 ? this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes) : this.mBreadCrumbTitleText;
        return v0;
    }

    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    public int getId() {
        return this.mIndex;
    }

    public String getName() {
        return this.mName;
    }

    public int getTransition() {
        return this.mTransition;
    }

    public int getTransitionStyle() {
        return this.mTransitionStyle;
    }

    public FragmentTransaction hide(Fragment arg3) {
        Op v0 = new Op();
        v0.cmd = 4;
        v0.fragment = arg3;
        this.addOp(v0);
        return this;
    }

    boolean interactsWith(int arg5) {
        boolean v0;
        int v3 = this.mOps.size();
        int v2 = 0;
        while(true) {
            if(v2 >= v3) {
                return false;
            }
            else if(this.mOps.get(v2).fragment.mContainerId == arg5) {
                v0 = true;
            }
            else {
                ++v2;
                continue;
            }

            return v0;
        }

        return false;
    }

    boolean interactsWith(ArrayList arg10, int arg11, int arg12) {
        int v0_2;
        boolean v0;
        if(arg12 == arg11) {
            v0 = false;
        }
        else {
            int v7 = this.mOps.size();
            int v1 = -1;
            int v6 = 0;
            while(v6 < v7) {
                int v2 = this.mOps.get(v6).fragment.mContainerId;
                if(v2 == 0 || v2 == v1) {
                    v0_2 = v1;
                }
                else {
                    int v5;
                    for(v5 = arg11; v5 < arg12; ++v5) {
                        Object v0_1 = arg10.get(v5);
                        int v8 = ((BackStackRecord)v0_1).mOps.size();
                        int v4 = 0;
                        while(true) {
                            if(v4 >= v8) {
                                break;
                            }
                            else if(((BackStackRecord)v0_1).mOps.get(v4).fragment.mContainerId == v2) {
                                return true;
                            }
                            else {
                                ++v4;
                                continue;
                            }
                        }
                    }

                    v0_2 = v2;
                }

                ++v6;
                v1 = v0_2;
            }

            v0 = false;
        }

        return v0;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    private static boolean isFragmentPostponed(Op arg2) {
        Fragment v0 = arg2.fragment;
        boolean v0_1 = !v0.mAdded || v0.mView == null || (v0.mDetached) || (v0.mHidden) || !v0.isPostponed() ? false : true;
        return v0_1;
    }

    boolean isPostponed() {
        boolean v2 = false;
        int v1 = 0;
        while(v1 < this.mOps.size()) {
            if(BackStackRecord.isFragmentPostponed(this.mOps.get(v1))) {
                v2 = true;
            }
            else {
                ++v1;
                continue;
            }

            return v2;
        }

        return v2;
    }

    public FragmentTransaction remove(Fragment arg3) {
        Op v0 = new Op();
        v0.cmd = 3;
        v0.fragment = arg3;
        this.addOp(v0);
        return this;
    }

    public FragmentTransaction replace(int arg2, Fragment arg3) {
        return this.replace(arg2, arg3, null);
    }

    public FragmentTransaction replace(int arg3, Fragment arg4, String arg5) {
        if(arg3 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }

        this.doAddOp(arg3, arg4, arg5, 2);
        return this;
    }

    public FragmentTransaction setAllowOptimization(boolean arg1) {
        this.mAllowOptimization = arg1;
        return this;
    }

    public FragmentTransaction setBreadCrumbShortTitle(int arg2) {
        this.mBreadCrumbShortTitleRes = arg2;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbShortTitle(CharSequence arg2) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = arg2;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(int arg2) {
        this.mBreadCrumbTitleRes = arg2;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(CharSequence arg2) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = arg2;
        return this;
    }

    public FragmentTransaction setCustomAnimations(int arg2, int arg3) {
        return this.setCustomAnimations(arg2, arg3, 0, 0);
    }

    public FragmentTransaction setCustomAnimations(int arg1, int arg2, int arg3, int arg4) {
        this.mEnterAnim = arg1;
        this.mExitAnim = arg2;
        this.mPopEnterAnim = arg3;
        this.mPopExitAnim = arg4;
        return this;
    }

    void setOnStartPostponedListener(OnStartEnterTransitionListener arg4) {
        int v1;
        for(v1 = 0; v1 < this.mOps.size(); ++v1) {
            Object v0 = this.mOps.get(v1);
            if(BackStackRecord.isFragmentPostponed(((Op)v0))) {
                ((Op)v0).fragment.setOnStartEnterTransitionListener(arg4);
            }
        }
    }

    public FragmentTransaction setTransition(int arg1) {
        this.mTransition = arg1;
        return this;
    }

    public FragmentTransaction setTransitionStyle(int arg1) {
        this.mTransitionStyle = arg1;
        return this;
    }

    public FragmentTransaction show(Fragment arg3) {
        Op v0 = new Op();
        v0.cmd = 5;
        v0.fragment = arg3;
        this.addOp(v0);
        return this;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x80);
        v0.append("BackStackEntry{");
        v0.append(Integer.toHexString(System.identityHashCode(this)));
        if(this.mIndex >= 0) {
            v0.append(" #");
            v0.append(this.mIndex);
        }

        if(this.mName != null) {
            v0.append(" ");
            v0.append(this.mName);
        }

        v0.append("}");
        return v0.toString();
    }

    void trackAddedFragmentsInPop(ArrayList arg4) {
        int v1;
        for(v1 = 0; v1 < this.mOps.size(); ++v1) {
            Object v0 = this.mOps.get(v1);
            switch(((Op)v0).cmd) {
                case 3: 
                case 6: {
                    arg4.add(((Op)v0).fragment);
                    break;
                }
                case 1: 
                case 7: {
                    arg4.remove(((Op)v0).fragment);
                    break;
                }
            }
        }
    }
}

