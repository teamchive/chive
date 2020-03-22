package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    final class android.support.v4.app.BackStackState$1 implements Parcelable$Creator {
        android.support.v4.app.BackStackState$1() {
            super();
        }

        public BackStackState createFromParcel(Parcel arg2) {
            return new BackStackState(arg2);
        }

        public Object createFromParcel(Parcel arg2) {
            return this.createFromParcel(arg2);
        }

        public BackStackState[] newArray(int arg2) {
            return new BackStackState[arg2];
        }

        public Object[] newArray(int arg2) {
            return this.newArray(arg2);
        }
    }

    public static final Parcelable$Creator CREATOR;
    final boolean mAllowOptimization;
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int mIndex;
    final String mName;
    final int[] mOps;
    final ArrayList mSharedElementSourceNames;
    final ArrayList mSharedElementTargetNames;
    final int mTransition;
    final int mTransitionStyle;

    static {
        BackStackState.CREATOR = new android.support.v4.app.BackStackState$1();
    }

    public BackStackState(Parcel arg2) {
        super();
        this.mOps = arg2.createIntArray();
        this.mTransition = arg2.readInt();
        this.mTransitionStyle = arg2.readInt();
        this.mName = arg2.readString();
        this.mIndex = arg2.readInt();
        this.mBreadCrumbTitleRes = arg2.readInt();
        this.mBreadCrumbTitleText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg2);
        this.mBreadCrumbShortTitleRes = arg2.readInt();
        this.mBreadCrumbShortTitleText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg2);
        this.mSharedElementSourceNames = arg2.createStringArrayList();
        this.mSharedElementTargetNames = arg2.createStringArrayList();
        boolean v0 = arg2.readInt() != 0 ? true : false;
        this.mAllowOptimization = v0;
    }

    public BackStackState(BackStackRecord arg8) {
        super();
        int v3 = arg8.mOps.size();
        this.mOps = new int[v3 * 6];
        if(!arg8.mAddToBackStack) {
            throw new IllegalStateException("Not on back stack");
        }

        int v2 = 0;
        int v1 = 0;
        while(v2 < v3) {
            Object v0 = arg8.mOps.get(v2);
            int v5 = v1 + 1;
            this.mOps[v1] = ((Op)v0).cmd;
            int[] v4 = this.mOps;
            int v6 = v5 + 1;
            v1 = ((Op)v0).fragment != null ? ((Op)v0).fragment.mIndex : -1;
            v4[v5] = v1;
            int v4_1 = v6 + 1;
            this.mOps[v6] = ((Op)v0).enterAnim;
            v5 = v4_1 + 1;
            this.mOps[v4_1] = ((Op)v0).exitAnim;
            v4_1 = v5 + 1;
            this.mOps[v5] = ((Op)v0).popEnterAnim;
            v1 = v4_1 + 1;
            this.mOps[v4_1] = ((Op)v0).popExitAnim;
            ++v2;
        }

        this.mTransition = arg8.mTransition;
        this.mTransitionStyle = arg8.mTransitionStyle;
        this.mName = arg8.mName;
        this.mIndex = arg8.mIndex;
        this.mBreadCrumbTitleRes = arg8.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = arg8.mBreadCrumbTitleText;
        this.mBreadCrumbShortTitleRes = arg8.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = arg8.mBreadCrumbShortTitleText;
        this.mSharedElementSourceNames = arg8.mSharedElementSourceNames;
        this.mSharedElementTargetNames = arg8.mSharedElementTargetNames;
        this.mAllowOptimization = arg8.mAllowOptimization;
    }

    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManagerImpl arg9) {
        int v0 = 0;
        BackStackRecord v3 = new BackStackRecord(arg9);
        int v1 = 0;
        while(v0 < this.mOps.length) {
            Op v4 = new Op();
            int v5 = v0 + 1;
            v4.cmd = this.mOps[v0];
            if(FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Instantiate " + v3 + " op #" + v1 + " base fragment #" + this.mOps[v5]);
            }

            int v2 = v5 + 1;
            v0 = this.mOps[v5];
            v4.fragment = v0 >= 0 ? arg9.mActive.get(v0) : null;
            v5 = v2 + 1;
            v4.enterAnim = this.mOps[v2];
            v2 = v5 + 1;
            v4.exitAnim = this.mOps[v5];
            v5 = v2 + 1;
            v4.popEnterAnim = this.mOps[v2];
            v4.popExitAnim = this.mOps[v5];
            v3.mEnterAnim = v4.enterAnim;
            v3.mExitAnim = v4.exitAnim;
            v3.mPopEnterAnim = v4.popEnterAnim;
            v3.mPopExitAnim = v4.popExitAnim;
            v3.addOp(v4);
            ++v1;
            v0 = v5 + 1;
        }

        v3.mTransition = this.mTransition;
        v3.mTransitionStyle = this.mTransitionStyle;
        v3.mName = this.mName;
        v3.mIndex = this.mIndex;
        v3.mAddToBackStack = true;
        v3.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        v3.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        v3.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        v3.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        v3.mSharedElementSourceNames = this.mSharedElementSourceNames;
        v3.mSharedElementTargetNames = this.mSharedElementTargetNames;
        v3.mAllowOptimization = this.mAllowOptimization;
        v3.bumpBackStackNesting(1);
        return v3;
    }

    public void writeToParcel(Parcel arg3, int arg4) {
        int v0 = 0;
        arg3.writeIntArray(this.mOps);
        arg3.writeInt(this.mTransition);
        arg3.writeInt(this.mTransitionStyle);
        arg3.writeString(this.mName);
        arg3.writeInt(this.mIndex);
        arg3.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, arg3, 0);
        arg3.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, arg3, 0);
        arg3.writeStringList(this.mSharedElementSourceNames);
        arg3.writeStringList(this.mSharedElementTargetNames);
        if(this.mAllowOptimization) {
            v0 = 1;
        }

        arg3.writeInt(v0);
    }
}

