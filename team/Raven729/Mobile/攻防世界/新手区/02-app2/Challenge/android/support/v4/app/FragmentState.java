package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.Log;

final class FragmentState implements Parcelable {
    final class android.support.v4.app.FragmentState$1 implements Parcelable$Creator {
        android.support.v4.app.FragmentState$1() {
            super();
        }

        public FragmentState createFromParcel(Parcel arg2) {
            return new FragmentState(arg2);
        }

        public Object createFromParcel(Parcel arg2) {
            return this.createFromParcel(arg2);
        }

        public FragmentState[] newArray(int arg2) {
            return new FragmentState[arg2];
        }

        public Object[] newArray(int arg2) {
            return this.newArray(arg2);
        }
    }

    public static final Parcelable$Creator CREATOR;
    final Bundle mArguments;
    final String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final boolean mHidden;
    final int mIndex;
    Fragment mInstance;
    final boolean mRetainInstance;
    Bundle mSavedFragmentState;
    final String mTag;

    static {
        FragmentState.CREATOR = new android.support.v4.app.FragmentState$1();
    }

    public FragmentState(Fragment arg2) {
        super();
        this.mClassName = arg2.getClass().getName();
        this.mIndex = arg2.mIndex;
        this.mFromLayout = arg2.mFromLayout;
        this.mFragmentId = arg2.mFragmentId;
        this.mContainerId = arg2.mContainerId;
        this.mTag = arg2.mTag;
        this.mRetainInstance = arg2.mRetainInstance;
        this.mDetached = arg2.mDetached;
        this.mArguments = arg2.mArguments;
        this.mHidden = arg2.mHidden;
    }

    public FragmentState(Parcel arg4) {
        boolean v1 = true;
        super();
        this.mClassName = arg4.readString();
        this.mIndex = arg4.readInt();
        boolean v0 = arg4.readInt() != 0 ? true : false;
        this.mFromLayout = v0;
        this.mFragmentId = arg4.readInt();
        this.mContainerId = arg4.readInt();
        this.mTag = arg4.readString();
        v0 = arg4.readInt() != 0 ? true : false;
        this.mRetainInstance = v0;
        v0 = arg4.readInt() != 0 ? true : false;
        this.mDetached = v0;
        this.mArguments = arg4.readBundle();
        if(arg4.readInt() == 0) {
            v1 = false;
        }

        this.mHidden = v1;
        this.mSavedFragmentState = arg4.readBundle();
    }

    public int describeContents() {
        return 0;
    }

    public Fragment instantiate(FragmentHostCallback arg4, Fragment arg5, FragmentManagerNonConfig arg6) {
        if(this.mInstance == null) {
            Context v0 = arg4.getContext();
            if(this.mArguments != null) {
                this.mArguments.setClassLoader(v0.getClassLoader());
            }

            this.mInstance = Fragment.instantiate(v0, this.mClassName, this.mArguments);
            if(this.mSavedFragmentState != null) {
                this.mSavedFragmentState.setClassLoader(v0.getClassLoader());
                this.mInstance.mSavedFragmentState = this.mSavedFragmentState;
            }

            this.mInstance.setIndex(this.mIndex, arg5);
            this.mInstance.mFromLayout = this.mFromLayout;
            this.mInstance.mRestored = true;
            this.mInstance.mFragmentId = this.mFragmentId;
            this.mInstance.mContainerId = this.mContainerId;
            this.mInstance.mTag = this.mTag;
            this.mInstance.mRetainInstance = this.mRetainInstance;
            this.mInstance.mDetached = this.mDetached;
            this.mInstance.mHidden = this.mHidden;
            this.mInstance.mFragmentManager = arg4.mFragmentManager;
            if(!FragmentManagerImpl.DEBUG) {
                goto label_61;
            }

            Log.v("FragmentManager", "Instantiated fragment " + this.mInstance);
        }

    label_61:
        this.mInstance.mChildNonConfig = arg6;
        return this.mInstance;
    }

    public void writeToParcel(Parcel arg4, int arg5) {
        int v1 = 1;
        arg4.writeString(this.mClassName);
        arg4.writeInt(this.mIndex);
        int v0 = this.mFromLayout ? 1 : 0;
        arg4.writeInt(v0);
        arg4.writeInt(this.mFragmentId);
        arg4.writeInt(this.mContainerId);
        arg4.writeString(this.mTag);
        v0 = this.mRetainInstance ? 1 : 0;
        arg4.writeInt(v0);
        v0 = this.mDetached ? 1 : 0;
        arg4.writeInt(v0);
        arg4.writeBundle(this.mArguments);
        if(!this.mHidden) {
            v1 = 0;
        }

        arg4.writeInt(v1);
        arg4.writeBundle(this.mSavedFragmentState);
    }
}

