package android.support.v4.os;

import android.annotation.TargetApi;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.support.annotation.RequiresApi;

@TargetApi(value=13) @RequiresApi(value=13) class ParcelableCompatCreatorHoneycombMR2 implements Parcelable$ClassLoaderCreator {
    private final ParcelableCompatCreatorCallbacks mCallbacks;

    public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks arg1) {
        super();
        this.mCallbacks = arg1;
    }

    public Object createFromParcel(Parcel arg3) {
        return this.mCallbacks.createFromParcel(arg3, null);
    }

    public Object createFromParcel(Parcel arg2, ClassLoader arg3) {
        return this.mCallbacks.createFromParcel(arg2, arg3);
    }

    public Object[] newArray(int arg2) {
        return this.mCallbacks.newArray(arg2);
    }
}

