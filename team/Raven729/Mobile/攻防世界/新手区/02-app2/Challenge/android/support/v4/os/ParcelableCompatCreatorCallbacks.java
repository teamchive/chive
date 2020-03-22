package android.support.v4.os;

import android.os.Parcel;

public interface ParcelableCompatCreatorCallbacks {
    Object createFromParcel(Parcel arg1, ClassLoader arg2);

    Object[] newArray(int arg1);
}

