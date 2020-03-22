package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class FragmentManagerState implements Parcelable {
    final class android.support.v4.app.FragmentManagerState$1 implements Parcelable$Creator {
        android.support.v4.app.FragmentManagerState$1() {
            super();
        }

        public FragmentManagerState createFromParcel(Parcel arg2) {
            return new FragmentManagerState(arg2);
        }

        public Object createFromParcel(Parcel arg2) {
            return this.createFromParcel(arg2);
        }

        public FragmentManagerState[] newArray(int arg2) {
            return new FragmentManagerState[arg2];
        }

        public Object[] newArray(int arg2) {
            return this.newArray(arg2);
        }
    }

    public static final Parcelable$Creator CREATOR;
    FragmentState[] mActive;
    int[] mAdded;
    BackStackState[] mBackStack;

    static {
        FragmentManagerState.CREATOR = new android.support.v4.app.FragmentManagerState$1();
    }

    public FragmentManagerState() {
        super();
    }

    public FragmentManagerState(Parcel arg2) {
        super();
        this.mActive = arg2.createTypedArray(FragmentState.CREATOR);
        this.mAdded = arg2.createIntArray();
        this.mBackStack = arg2.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        arg2.writeTypedArray(this.mActive, arg3);
        arg2.writeIntArray(this.mAdded);
        arg2.writeTypedArray(this.mBackStack, arg3);
    }
}

