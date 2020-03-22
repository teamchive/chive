package android.support.v4.os;

import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class ParcelableCompat {
    class CompatCreator implements Parcelable$Creator {
        final ParcelableCompatCreatorCallbacks mCallbacks;

        public CompatCreator(ParcelableCompatCreatorCallbacks arg1) {
            super();
            this.mCallbacks = arg1;
        }

        public Object createFromParcel(Parcel arg3) {
            return this.mCallbacks.createFromParcel(arg3, null);
        }

        public Object[] newArray(int arg2) {
            return this.mCallbacks.newArray(arg2);
        }
    }

    private ParcelableCompat() {
        super();
    }

    public static Parcelable$Creator newCreator(ParcelableCompatCreatorCallbacks arg2) {
        Parcelable$Creator v0;
        if(Build$VERSION.SDK_INT >= 13) {
            v0 = ParcelableCompatCreatorHoneycombMR2Stub.instantiate(arg2);
        }
        else {
            CompatCreator v0_1 = new CompatCreator(arg2);
        }

        return v0;
    }
}

