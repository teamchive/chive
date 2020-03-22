package android.support.v4.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.browse.MediaBrowser$MediaItem;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService$Result;
import android.service.media.MediaBrowserService;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(value=24) @RequiresApi(value=24) class MediaBrowserServiceCompatApi24 {
    class MediaBrowserServiceAdaptor extends android.support.v4.media.MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(Context arg1, ServiceCompatProxy arg2) {
            super(arg1, ((android.support.v4.media.MediaBrowserServiceCompatApi23$ServiceCompatProxy)arg2));
        }

        public void onLoadChildren(String arg3, MediaBrowserService$Result arg4, Bundle arg5) {
            this.mServiceProxy.onLoadChildren(arg3, new ResultWrapper(arg4), arg5);
        }
    }

    class ResultWrapper {
        MediaBrowserService$Result mResultObj;

        ResultWrapper(MediaBrowserService$Result arg1) {
            super();
            this.mResultObj = arg1;
        }

        public void detach() {
            this.mResultObj.detach();
        }

        List parcelListToItemList(List arg5) {
            List v0;
            if(arg5 == null) {
                v0 = null;
            }
            else {
                ArrayList v1 = new ArrayList();
                Iterator v2 = arg5.iterator();
                while(v2.hasNext()) {
                    Object v0_1 = v2.next();
                    ((Parcel)v0_1).setDataPosition(0);
                    ((List)v1).add(MediaBrowser$MediaItem.CREATOR.createFromParcel(((Parcel)v0_1)));
                    ((Parcel)v0_1).recycle();
                }

                ArrayList v0_2 = v1;
            }

            return v0;
        }

        public void sendResult(List arg3, int arg4) {
            try {
                MediaBrowserServiceCompatApi24.sResultFlags.setInt(this.mResultObj, arg4);
            }
            catch(IllegalAccessException v0) {
                Log.w("MBSCompatApi24", ((Throwable)v0));
            }

            this.mResultObj.sendResult(this.parcelListToItemList(arg3));
        }
    }

    public interface ServiceCompatProxy extends android.support.v4.media.MediaBrowserServiceCompatApi23$ServiceCompatProxy {
        void onLoadChildren(String arg1, ResultWrapper arg2, Bundle arg3);
    }

    private static final String TAG = "MBSCompatApi24";
    private static Field sResultFlags;

    static {
        try {
            MediaBrowserServiceCompatApi24.sResultFlags = MediaBrowserService$Result.class.getDeclaredField("mFlags");
            MediaBrowserServiceCompatApi24.sResultFlags.setAccessible(true);
        }
        catch(NoSuchFieldException v0) {
            Log.w("MBSCompatApi24", ((Throwable)v0));
        }
    }

    MediaBrowserServiceCompatApi24() {
        super();
    }

    static Field access$000() {
        return MediaBrowserServiceCompatApi24.sResultFlags;
    }

    public static Object createService(Context arg1, ServiceCompatProxy arg2) {
        return new MediaBrowserServiceAdaptor(arg1, arg2);
    }

    public static Bundle getBrowserRootHints(Object arg1) {
        return ((MediaBrowserService)arg1).getBrowserRootHints();
    }

    public static void notifyChildrenChanged(Object arg0, String arg1, Bundle arg2) {
        ((MediaBrowserService)arg0).notifyChildrenChanged(arg1, arg2);
    }
}

