package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

public abstract class AbsSavedState implements Parcelable {
    final class android.support.v4.view.AbsSavedState$1 extends AbsSavedState {
        android.support.v4.view.AbsSavedState$1() {
            super(null);
        }
    }

    final class android.support.v4.view.AbsSavedState$2 implements ParcelableCompatCreatorCallbacks {
        android.support.v4.view.AbsSavedState$2() {
            super();
        }

        public AbsSavedState createFromParcel(Parcel arg3, ClassLoader arg4) {
            if(arg3.readParcelable(arg4) != null) {
                throw new IllegalStateException("superState must be null");
            }

            return AbsSavedState.EMPTY_STATE;
        }

        public Object createFromParcel(Parcel arg2, ClassLoader arg3) {
            return this.createFromParcel(arg2, arg3);
        }

        public AbsSavedState[] newArray(int arg2) {
            return new AbsSavedState[arg2];
        }

        public Object[] newArray(int arg2) {
            return this.newArray(arg2);
        }
    }

    public static final Parcelable$Creator CREATOR;
    public static final AbsSavedState EMPTY_STATE;
    private final Parcelable mSuperState;

    static {
        AbsSavedState.EMPTY_STATE = new android.support.v4.view.AbsSavedState$1();
        AbsSavedState.CREATOR = ParcelableCompat.newCreator(new android.support.v4.view.AbsSavedState$2());
    }

    private AbsSavedState() {
        super();
        this.mSuperState = null;
    }

    protected AbsSavedState(Parcel arg2) {
        this(arg2, null);
    }

    protected AbsSavedState(Parcel arg2, ClassLoader arg3) {
        AbsSavedState v0_1;
        super();
        Parcelable v0 = arg2.readParcelable(arg3);
        if(v0 == null) {
            v0_1 = AbsSavedState.EMPTY_STATE;
        }

        this.mSuperState = ((Parcelable)v0_1);
    }

    protected AbsSavedState(Parcelable arg3) {
        super();
        if(arg3 == null) {
            throw new IllegalArgumentException("superState must not be null");
        }

        if(arg3 == AbsSavedState.EMPTY_STATE) {
            arg3 = null;
        }

        this.mSuperState = arg3;
    }

    AbsSavedState(android.support.v4.view.AbsSavedState$1 arg1) {
        this();
    }

    public int describeContents() {
        return 0;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        arg2.writeParcelable(this.mSuperState, arg3);
    }
}

