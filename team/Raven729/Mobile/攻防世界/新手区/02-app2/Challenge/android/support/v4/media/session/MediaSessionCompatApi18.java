package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.media.RemoteControlClient$OnPlaybackPositionUpdateListener;
import android.media.RemoteControlClient;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.util.Log;

@TargetApi(value=18) @RequiresApi(value=18) class MediaSessionCompatApi18 {
    interface Callback {
        void onSeekTo(long arg1);
    }

    class OnPlaybackPositionUpdateListener implements RemoteControlClient$OnPlaybackPositionUpdateListener {
        protected final Callback mCallback;

        public OnPlaybackPositionUpdateListener(Callback arg1) {
            super();
            this.mCallback = arg1;
        }

        public void onPlaybackPositionUpdate(long arg2) {
            this.mCallback.onSeekTo(arg2);
        }
    }

    private static final long ACTION_SEEK_TO = 0x100;
    private static final String TAG = "MediaSessionCompatApi18";
    private static boolean sIsMbrPendingIntentSupported;

    static {
        MediaSessionCompatApi18.sIsMbrPendingIntentSupported = true;
    }

    MediaSessionCompatApi18() {
        super();
    }

    public static Object createPlaybackPositionUpdateListener(Callback arg1) {
        return new OnPlaybackPositionUpdateListener(arg1);
    }

    static int getRccTransportControlFlagsFromActions(long arg6) {
        int v0 = MediaSessionCompatApi14.getRccTransportControlFlagsFromActions(arg6);
        if((0x100 & arg6) != 0) {
            v0 |= 0x100;
        }

        return v0;
    }

    public static void registerMediaButtonEventReceiver(Context arg3, PendingIntent arg4, ComponentName arg5) {
        Object v0 = arg3.getSystemService("audio");
        if(MediaSessionCompatApi18.sIsMbrPendingIntentSupported) {
            try {
                ((AudioManager)v0).registerMediaButtonEventReceiver(arg4);
            }
            catch(NullPointerException v1) {
                Log.w("MediaSessionCompatApi18", "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                MediaSessionCompatApi18.sIsMbrPendingIntentSupported = false;
            }
        }

        if(!MediaSessionCompatApi18.sIsMbrPendingIntentSupported) {
            ((AudioManager)v0).registerMediaButtonEventReceiver(arg5);
        }
    }

    public static void setOnPlaybackPositionUpdateListener(Object arg0, Object arg1) {
        ((RemoteControlClient)arg0).setPlaybackPositionUpdateListener(((RemoteControlClient$OnPlaybackPositionUpdateListener)arg1));
    }

    public static void setState(Object arg6, int arg7, long arg8, float arg10, long arg11) {
        long v0 = 0;
        long v2 = SystemClock.elapsedRealtime();
        if(arg7 == 3 && arg8 > v0) {
            if(arg11 > v0) {
                v0 = v2 - arg11;
                if(arg10 > 0f && arg10 != 1f) {
                    v0 = ((long)((((float)v0)) * arg10));
                }
            }

            arg8 += v0;
        }

        ((RemoteControlClient)arg6).setPlaybackState(MediaSessionCompatApi14.getRccStateFromState(arg7), arg8, arg10);
    }

    public static void setTransportControlFlags(Object arg1, long arg2) {
        ((RemoteControlClient)arg1).setTransportControlFlags(MediaSessionCompatApi18.getRccTransportControlFlagsFromActions(arg2));
    }

    public static void unregisterMediaButtonEventReceiver(Context arg2, PendingIntent arg3, ComponentName arg4) {
        Object v0 = arg2.getSystemService("audio");
        if(MediaSessionCompatApi18.sIsMbrPendingIntentSupported) {
            ((AudioManager)v0).unregisterMediaButtonEventReceiver(arg3);
        }
        else {
            ((AudioManager)v0).unregisterMediaButtonEventReceiver(arg4);
        }
    }
}

