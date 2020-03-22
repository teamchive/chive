package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.Arrays;

class BundleUtil {
    BundleUtil() {
        super();
    }

    public static Bundle[] getBundleArrayFromBundle(Bundle arg3, String arg4) {
        Parcelable[] v0 = arg3.getParcelableArray(arg4);
        if(!(v0 instanceof Bundle[]) && v0 != null) {
            Object[] v0_1 = Arrays.copyOf(((Object[])v0), v0.length, Bundle[].class);
            arg3.putParcelableArray(arg4, ((Parcelable[])v0_1));
        }

        return ((Bundle[])v0);
    }
}

