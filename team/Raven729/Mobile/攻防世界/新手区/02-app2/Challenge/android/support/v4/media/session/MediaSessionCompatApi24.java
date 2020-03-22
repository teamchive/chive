package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

@TargetApi(value=24) @RequiresApi(value=24) class MediaSessionCompatApi24 {
    public interface Callback extends android.support.v4.media.session.MediaSessionCompatApi23$Callback {
        void onPrepare();

        void onPrepareFromMediaId(String arg1, Bundle arg2);

        void onPrepareFromSearch(String arg1, Bundle arg2);

        void onPrepareFromUri(Uri arg1, Bundle arg2);
    }

    class CallbackProxy extends android.support.v4.media.session.MediaSessionCompatApi23$CallbackProxy {
        public CallbackProxy(Callback arg1) {
            super(((android.support.v4.media.session.MediaSessionCompatApi23$Callback)arg1));
        }

        public void onPrepare() {
            this.mCallback.onPrepare();
        }

        public void onPrepareFromMediaId(String arg2, Bundle arg3) {
            this.mCallback.onPrepareFromMediaId(arg2, arg3);
        }

        public void onPrepareFromSearch(String arg2, Bundle arg3) {
            this.mCallback.onPrepareFromSearch(arg2, arg3);
        }

        public void onPrepareFromUri(Uri arg2, Bundle arg3) {
            this.mCallback.onPrepareFromUri(arg2, arg3);
        }
    }

    private static final String TAG = "MediaSessionCompatApi24";

    MediaSessionCompatApi24() {
        super();
    }

    public static Object createCallback(Callback arg1) {
        return new CallbackProxy(arg1);
    }

    public static String getCallingPackage(Object arg3) {
        Object v0_3;
        try {
            v0_3 = arg3.getClass().getMethod("getCallingPackage").invoke(arg3);
        }
        catch(IllegalAccessException v0) {
            goto label_10;
        }
        catch(NoSuchMethodException v0_1) {
            goto label_10;
        }
        catch(InvocationTargetException v0_2) {
        label_10:
            Log.e("MediaSessionCompatApi24", "Cannot execute MediaSession.getCallingPackage()", ((Throwable)v0));
            String v0_4 = null;
        }

        return ((String)v0_3);
    }
}

