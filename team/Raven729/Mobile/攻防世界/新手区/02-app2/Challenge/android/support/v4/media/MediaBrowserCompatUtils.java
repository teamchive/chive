package android.support.v4.media;

import android.os.Bundle;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;

@RestrictTo(value={Scope.LIBRARY_GROUP}) public class MediaBrowserCompatUtils {
    public MediaBrowserCompatUtils() {
        super();
    }

    public static boolean areSameOptions(Bundle arg5, Bundle arg6) {
        boolean v0 = true;
        int v4 = -1;
        if(arg5 != arg6) {
            if(arg5 == null) {
                if(arg6.getInt("android.media.browse.extra.PAGE", v4) == v4 && arg6.getInt("android.media.browse.extra.PAGE_SIZE", v4) == v4) {
                    return v0;
                }

                v0 = false;
            }
            else {
                if(arg6 == null) {
                    if(arg5.getInt("android.media.browse.extra.PAGE", v4) == v4 && arg5.getInt("android.media.browse.extra.PAGE_SIZE", v4) == v4) {
                        return v0;
                    }

                    return false;
                }

                if(arg5.getInt("android.media.browse.extra.PAGE", v4) == arg6.getInt("android.media.browse.extra.PAGE", v4) && arg5.getInt("android.media.browse.extra.PAGE_SIZE", v4) == arg6.getInt("android.media.browse.extra.PAGE_SIZE", v4)) {
                    return v0;
                }

                v0 = false;
            }
        }

        return v0;
    }

    public static boolean hasDuplicatedItems(Bundle arg9, Bundle arg10) {
        int v3;
        int v2 = 0x7FFFFFFF;
        boolean v0 = true;
        int v7 = -1;
        int v4 = arg9 == null ? v7 : arg9.getInt("android.media.browse.extra.PAGE", v7);
        int v8 = arg10 == null ? v7 : arg10.getInt("android.media.browse.extra.PAGE", v7);
        int v5 = arg9 == null ? v7 : arg9.getInt("android.media.browse.extra.PAGE_SIZE", v7);
        int v6 = arg10 == null ? v7 : arg10.getInt("android.media.browse.extra.PAGE_SIZE", v7);
        if(v4 == v7 || v5 == v7) {
            v4 = v2;
            v5 = 0;
        }
        else {
            v4 *= v5;
            v3 = v4 + v5 - 1;
            v5 = v4;
            v4 = v3;
        }

        if(v8 == v7 || v6 == v7) {
            v3 = 0;
        }
        else {
            v3 = v6 * v8;
            v2 = v3 + v6 - 1;
        }

        if((v5 > v3 || v3 > v4) && (v5 > v2 || v2 > v4)) {
            v0 = false;
        }

        return v0;
    }
}

