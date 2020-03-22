package android.support.v4.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser$MediaItem;
import android.media.session.MediaSession$Token;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService$BrowserRoot;
import android.service.media.MediaBrowserService$Result;
import android.service.media.MediaBrowserService;
import android.support.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(value=21) @RequiresApi(value=21) class MediaBrowserServiceCompatApi21 {
    class BrowserRoot {
        final Bundle mExtras;
        final String mRootId;

        BrowserRoot(String arg1, Bundle arg2) {
            super();
            this.mRootId = arg1;
            this.mExtras = arg2;
        }
    }

    class MediaBrowserServiceAdaptor extends MediaBrowserService {
        final ServiceCompatProxy mServiceProxy;

        MediaBrowserServiceAdaptor(Context arg1, ServiceCompatProxy arg2) {
            super();
            this.attachBaseContext(arg1);
            this.mServiceProxy = arg2;
        }

        public MediaBrowserService$BrowserRoot onGetRoot(String arg4, int arg5, Bundle arg6) {
            BrowserRoot v1 = this.mServiceProxy.onGetRoot(arg4, arg5, arg6);
            MediaBrowserService$BrowserRoot v0 = v1 == null ? null : new MediaBrowserService$BrowserRoot(v1.mRootId, v1.mExtras);
            return v0;
        }

        public void onLoadChildren(String arg3, MediaBrowserService$Result arg4) {
            this.mServiceProxy.onLoadChildren(arg3, new ResultWrapper(arg4));
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

        public void sendResult(Object arg3) {
            if((arg3 instanceof List)) {
                this.mResultObj.sendResult(this.parcelListToItemList(((List)arg3)));
            }
            else if((arg3 instanceof Parcel)) {
                ((Parcel)arg3).setDataPosition(0);
                this.mResultObj.sendResult(MediaBrowser$MediaItem.CREATOR.createFromParcel(((Parcel)arg3)));
                ((Parcel)arg3).recycle();
            }
            else {
                this.mResultObj.sendResult(null);
            }
        }
    }

    public interface ServiceCompatProxy {
        BrowserRoot onGetRoot(String arg1, int arg2, Bundle arg3);

        void onLoadChildren(String arg1, ResultWrapper arg2);
    }

    MediaBrowserServiceCompatApi21() {
        super();
    }

    public static Object createService(Context arg1, ServiceCompatProxy arg2) {
        return new MediaBrowserServiceAdaptor(arg1, arg2);
    }

    public static void notifyChildrenChanged(Object arg0, String arg1) {
        ((MediaBrowserService)arg0).notifyChildrenChanged(arg1);
    }

    public static IBinder onBind(Object arg1, Intent arg2) {
        return ((MediaBrowserService)arg1).onBind(arg2);
    }

    public static void onCreate(Object arg0) {
        ((MediaBrowserService)arg0).onCreate();
    }

    public static void setSessionToken(Object arg0, Object arg1) {
        ((MediaBrowserService)arg0).setSessionToken(((MediaSession$Token)arg1));
    }
}

