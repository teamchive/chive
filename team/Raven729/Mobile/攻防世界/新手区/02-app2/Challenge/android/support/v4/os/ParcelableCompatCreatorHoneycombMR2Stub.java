package android.support.v4.os;

import android.annotation.TargetApi;
import android.os.Parcelable$Creator;
import android.support.annotation.RequiresApi;

@TargetApi(value=13) @RequiresApi(value=13) class ParcelableCompatCreatorHoneycombMR2Stub {
    ParcelableCompatCreatorHoneycombMR2Stub() {
        super();
    }

    static Parcelable$Creator instantiate(ParcelableCompatCreatorCallbacks arg1) {
        return new ParcelableCompatCreatorHoneycombMR2(arg1);
    }
}

