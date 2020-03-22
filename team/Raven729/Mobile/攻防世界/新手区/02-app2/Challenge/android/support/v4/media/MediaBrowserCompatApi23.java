package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.browse.MediaBrowser$ItemCallback;
import android.media.browse.MediaBrowser$MediaItem;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

@TargetApi(value=23) @RequiresApi(value=23) class MediaBrowserCompatApi23 {
    interface ItemCallback {
        void onError(@NonNull String arg1);

        void onItemLoaded(Parcel arg1);
    }

    class ItemCallbackProxy extends MediaBrowser$ItemCallback {
        protected final ItemCallback mItemCallback;

        public ItemCallbackProxy(ItemCallback arg1) {
            super();
            this.mItemCallback = arg1;
        }

        public void onError(@NonNull String arg2) {
            this.mItemCallback.onError(arg2);
        }

        public void onItemLoaded(MediaBrowser$MediaItem arg3) {
            if(arg3 == null) {
                this.mItemCallback.onItemLoaded(null);
            }
            else {
                Parcel v0 = Parcel.obtain();
                arg3.writeToParcel(v0, 0);
                this.mItemCallback.onItemLoaded(v0);
            }
        }
    }

    MediaBrowserCompatApi23() {
        super();
    }

    public static Object createItemCallback(ItemCallback arg1) {
        return new ItemCallbackProxy(arg1);
    }

    public static void getItem(Object arg0, String arg1, Object arg2) {
        ((MediaBrowser)arg0).getItem(arg1, ((MediaBrowser$ItemCallback)arg2));
    }
}

