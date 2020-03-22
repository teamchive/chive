package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.media.Rating;
import android.media.RemoteControlClient$MetadataEditor;
import android.media.RemoteControlClient$OnMetadataUpdateListener;
import android.media.RemoteControlClient;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(value=19) @RequiresApi(value=19) class MediaSessionCompatApi19 {
    interface Callback extends android.support.v4.media.session.MediaSessionCompatApi18$Callback {
        void onSetRating(Object arg1);
    }

    class OnMetadataUpdateListener implements RemoteControlClient$OnMetadataUpdateListener {
        protected final Callback mCallback;

        public OnMetadataUpdateListener(Callback arg1) {
            super();
            this.mCallback = arg1;
        }

        public void onMetadataUpdate(int arg2, Object arg3) {
            if(arg2 == 0x10000001 && ((arg3 instanceof Rating))) {
                this.mCallback.onSetRating(arg3);
            }
        }
    }

    private static final long ACTION_SET_RATING = 0x80;
    private static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    private static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    private static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";

    MediaSessionCompatApi19() {
        super();
    }

    static void addNewMetadata(Bundle arg4, RemoteControlClient$MetadataEditor arg5) {
        if(arg4 != null) {
            if(arg4.containsKey("android.media.metadata.YEAR")) {
                arg5.putLong(8, arg4.getLong("android.media.metadata.YEAR"));
            }

            if(arg4.containsKey("android.media.metadata.RATING")) {
                arg5.putObject(101, arg4.getParcelable("android.media.metadata.RATING"));
            }

            if(!arg4.containsKey("android.media.metadata.USER_RATING")) {
                return;
            }

            arg5.putObject(0x10000001, arg4.getParcelable("android.media.metadata.USER_RATING"));
        }
    }

    public static Object createMetadataUpdateListener(Callback arg1) {
        return new OnMetadataUpdateListener(arg1);
    }

    static int getRccTransportControlFlagsFromActions(long arg6) {
        int v0 = MediaSessionCompatApi18.getRccTransportControlFlagsFromActions(arg6);
        if((0x80 & arg6) != 0) {
            v0 |= 0x200;
        }

        return v0;
    }

    public static void setMetadata(Object arg6, Bundle arg7, long arg8) {
        RemoteControlClient$MetadataEditor v0 = ((RemoteControlClient)arg6).editMetadata(true);
        MediaSessionCompatApi14.buildOldMetadata(arg7, v0);
        MediaSessionCompatApi19.addNewMetadata(arg7, v0);
        if((0x80 & arg8) != 0) {
            v0.addEditableKey(0x10000001);
        }

        v0.apply();
    }

    public static void setOnMetadataUpdateListener(Object arg0, Object arg1) {
        ((RemoteControlClient)arg0).setMetadataUpdateListener(((RemoteControlClient$OnMetadataUpdateListener)arg1));
    }

    public static void setTransportControlFlags(Object arg1, long arg2) {
        ((RemoteControlClient)arg1).setTransportControlFlags(MediaSessionCompatApi19.getRccTransportControlFlagsFromActions(arg2));
    }
}

