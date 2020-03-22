package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController$Callback;
import android.media.session.MediaController$PlaybackInfo;
import android.media.session.MediaController$TransportControls;
import android.media.session.MediaController;
import android.media.session.MediaSession$Token;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@TargetApi(value=21) @RequiresApi(value=21) class MediaControllerCompatApi21 {
    public interface Callback {
        void onAudioInfoChanged(int arg1, int arg2, int arg3, int arg4, int arg5);

        void onExtrasChanged(Bundle arg1);

        void onMetadataChanged(Object arg1);

        void onPlaybackStateChanged(Object arg1);

        void onQueueChanged(List arg1);

        void onQueueTitleChanged(CharSequence arg1);

        void onSessionDestroyed();

        void onSessionEvent(String arg1, Bundle arg2);
    }

    class CallbackProxy extends MediaController$Callback {
        protected final Callback mCallback;

        public CallbackProxy(Callback arg1) {
            super();
            this.mCallback = arg1;
        }

        public void onAudioInfoChanged(MediaController$PlaybackInfo arg7) {
            this.mCallback.onAudioInfoChanged(arg7.getPlaybackType(), PlaybackInfo.getLegacyAudioStream(arg7), arg7.getVolumeControl(), arg7.getMaxVolume(), arg7.getCurrentVolume());
        }

        public void onExtrasChanged(Bundle arg2) {
            this.mCallback.onExtrasChanged(arg2);
        }

        public void onMetadataChanged(MediaMetadata arg2) {
            this.mCallback.onMetadataChanged(arg2);
        }

        public void onPlaybackStateChanged(PlaybackState arg2) {
            this.mCallback.onPlaybackStateChanged(arg2);
        }

        public void onQueueChanged(List arg2) {
            this.mCallback.onQueueChanged(arg2);
        }

        public void onQueueTitleChanged(CharSequence arg2) {
            this.mCallback.onQueueTitleChanged(arg2);
        }

        public void onSessionDestroyed() {
            this.mCallback.onSessionDestroyed();
        }

        public void onSessionEvent(String arg2, Bundle arg3) {
            this.mCallback.onSessionEvent(arg2, arg3);
        }
    }

    public class PlaybackInfo {
        private static final int FLAG_SCO = 4;
        private static final int STREAM_BLUETOOTH_SCO = 6;
        private static final int STREAM_SYSTEM_ENFORCED = 7;

        public PlaybackInfo() {
            super();
        }

        public static AudioAttributes getAudioAttributes(Object arg1) {
            return ((MediaController$PlaybackInfo)arg1).getAudioAttributes();
        }

        public static int getCurrentVolume(Object arg1) {
            return ((MediaController$PlaybackInfo)arg1).getCurrentVolume();
        }

        public static int getLegacyAudioStream(Object arg1) {
            return PlaybackInfo.toLegacyStreamType(PlaybackInfo.getAudioAttributes(arg1));
        }

        public static int getMaxVolume(Object arg1) {
            return ((MediaController$PlaybackInfo)arg1).getMaxVolume();
        }

        public static int getPlaybackType(Object arg1) {
            return ((MediaController$PlaybackInfo)arg1).getPlaybackType();
        }

        public static int getVolumeControl(Object arg1) {
            return ((MediaController$PlaybackInfo)arg1).getVolumeControl();
        }

        private static int toLegacyStreamType(AudioAttributes arg4) {
            int v2 = 4;
            int v0 = 3;
            if((arg4.getFlags() & 1) == 1) {
                v0 = 7;
            }
            else if((arg4.getFlags() & 4) == v2) {
                v0 = 6;
            }
            else {
                switch(arg4.getUsage()) {
                    case 2: {
                        return 0;
                    }
                    case 3: {
                        return 8;
                    }
                    case 4: {
                        return v2;
                    }
                    case 6: {
                        return 2;
                    }
                    case 5: 
                    case 7: 
                    case 8: 
                    case 9: 
                    case 10: {
                        goto label_26;
                    }
                    case 13: {
                        return 1;
                    }
                }

                return v0;
            label_26:
                v0 = 5;
            }

            return v0;
        }
    }

    public class TransportControls {
        public TransportControls() {
            super();
        }

        public static void fastForward(Object arg0) {
            ((MediaController$TransportControls)arg0).fastForward();
        }

        public static void pause(Object arg0) {
            ((MediaController$TransportControls)arg0).pause();
        }

        public static void play(Object arg0) {
            ((MediaController$TransportControls)arg0).play();
        }

        public static void playFromMediaId(Object arg0, String arg1, Bundle arg2) {
            ((MediaController$TransportControls)arg0).playFromMediaId(arg1, arg2);
        }

        public static void playFromSearch(Object arg0, String arg1, Bundle arg2) {
            ((MediaController$TransportControls)arg0).playFromSearch(arg1, arg2);
        }

        public static void rewind(Object arg0) {
            ((MediaController$TransportControls)arg0).rewind();
        }

        public static void seekTo(Object arg1, long arg2) {
            ((MediaController$TransportControls)arg1).seekTo(arg2);
        }

        public static void sendCustomAction(Object arg0, String arg1, Bundle arg2) {
            ((MediaController$TransportControls)arg0).sendCustomAction(arg1, arg2);
        }

        public static void setRating(Object arg0, Object arg1) {
            ((MediaController$TransportControls)arg0).setRating(((Rating)arg1));
        }

        public static void skipToNext(Object arg0) {
            ((MediaController$TransportControls)arg0).skipToNext();
        }

        public static void skipToPrevious(Object arg0) {
            ((MediaController$TransportControls)arg0).skipToPrevious();
        }

        public static void skipToQueueItem(Object arg1, long arg2) {
            ((MediaController$TransportControls)arg1).skipToQueueItem(arg2);
        }

        public static void stop(Object arg0) {
            ((MediaController$TransportControls)arg0).stop();
        }
    }

    MediaControllerCompatApi21() {
        super();
    }

    public static void adjustVolume(Object arg0, int arg1, int arg2) {
        ((MediaController)arg0).adjustVolume(arg1, arg2);
    }

    public static Object createCallback(Callback arg1) {
        return new CallbackProxy(arg1);
    }

    public static boolean dispatchMediaButtonEvent(Object arg1, KeyEvent arg2) {
        return ((MediaController)arg1).dispatchMediaButtonEvent(arg2);
    }

    public static Object fromToken(Context arg1, Object arg2) {
        return new MediaController(arg1, ((MediaSession$Token)arg2));
    }

    public static Bundle getExtras(Object arg1) {
        return ((MediaController)arg1).getExtras();
    }

    public static long getFlags(Object arg2) {
        return ((MediaController)arg2).getFlags();
    }

    public static Object getMediaController(Activity arg1) {
        return arg1.getMediaController();
    }

    public static Object getMetadata(Object arg1) {
        return ((MediaController)arg1).getMetadata();
    }

    public static String getPackageName(Object arg1) {
        return ((MediaController)arg1).getPackageName();
    }

    public static Object getPlaybackInfo(Object arg1) {
        return ((MediaController)arg1).getPlaybackInfo();
    }

    public static Object getPlaybackState(Object arg1) {
        return ((MediaController)arg1).getPlaybackState();
    }

    public static List getQueue(Object arg2) {
        ArrayList v0_1;
        List v1 = ((MediaController)arg2).getQueue();
        if(v1 == null) {
            List v0 = null;
        }
        else {
            v0_1 = new ArrayList(((Collection)v1));
        }

        return ((List)v0_1);
    }

    public static CharSequence getQueueTitle(Object arg1) {
        return ((MediaController)arg1).getQueueTitle();
    }

    public static int getRatingType(Object arg1) {
        return ((MediaController)arg1).getRatingType();
    }

    public static PendingIntent getSessionActivity(Object arg1) {
        return ((MediaController)arg1).getSessionActivity();
    }

    public static Object getSessionToken(Object arg1) {
        return ((MediaController)arg1).getSessionToken();
    }

    public static Object getTransportControls(Object arg1) {
        return ((MediaController)arg1).getTransportControls();
    }

    public static void registerCallback(Object arg0, Object arg1, Handler arg2) {
        ((MediaController)arg0).registerCallback(((MediaController$Callback)arg1), arg2);
    }

    public static void sendCommand(Object arg0, String arg1, Bundle arg2, ResultReceiver arg3) {
        ((MediaController)arg0).sendCommand(arg1, arg2, arg3);
    }

    public static void setMediaController(Activity arg0, Object arg1) {
        arg0.setMediaController(((MediaController)arg1));
    }

    public static void setVolumeTo(Object arg0, int arg1, int arg2) {
        ((MediaController)arg0).setVolumeTo(arg1, arg2);
    }

    public static void unregisterCallback(Object arg0, Object arg1) {
        ((MediaController)arg0).unregisterCallback(((MediaController$Callback)arg1));
    }
}

