package android.support.v4.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.service.media.MediaBrowserService$Result;
import android.support.annotation.RequiresApi;

@TargetApi(value=23) @RequiresApi(value=23) class MediaBrowserServiceCompatApi23 {
    class MediaBrowserServiceAdaptor extends android.support.v4.media.MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(Context arg1, ServiceCompatProxy arg2) {
            super(arg1, ((android.support.v4.media.MediaBrowserServiceCompatApi21$ServiceCompatProxy)arg2));
        }

        public void onLoadItem(String arg3, MediaBrowserService$Result arg4) {
            this.mServiceProxy.onLoadItem(arg3, new ResultWrapper(arg4));
        }
    }

    public interface ServiceCompatProxy extends android.support.v4.media.MediaBrowserServiceCompatApi21$ServiceCompatProxy {
        void onLoadItem(String arg1, ResultWrapper arg2);
    }

    MediaBrowserServiceCompatApi23() {
        super();
    }

    public static Object createService(Context arg1, ServiceCompatProxy arg2) {
        return new MediaBrowserServiceAdaptor(arg1, arg2);
    }
}

