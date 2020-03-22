package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes$Builder;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession$Callback;
import android.media.session.MediaSession$QueueItem;
import android.media.session.MediaSession$Token;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(value=21) @RequiresApi(value=21) class MediaSessionCompatApi21 {
    interface Callback extends android.support.v4.media.session.MediaSessionCompatApi19$Callback {
        void onCommand(String arg1, Bundle arg2, ResultReceiver arg3);

        void onCustomAction(String arg1, Bundle arg2);

        void onFastForward();

        boolean onMediaButtonEvent(Intent arg1);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(String arg1, Bundle arg2);

        void onPlayFromSearch(String arg1, Bundle arg2);

        void onRewind();

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long arg1);

        void onStop();
    }

    class CallbackProxy extends MediaSession$Callback {
        protected final Callback mCallback;

        public CallbackProxy(Callback arg1) {
            super();
            this.mCallback = arg1;
        }

        public void onCommand(String arg2, Bundle arg3, ResultReceiver arg4) {
            this.mCallback.onCommand(arg2, arg3, arg4);
        }

        public void onCustomAction(String arg2, Bundle arg3) {
            this.mCallback.onCustomAction(arg2, arg3);
        }

        public void onFastForward() {
            this.mCallback.onFastForward();
        }

        public boolean onMediaButtonEvent(Intent arg2) {
            boolean v0 = (this.mCallback.onMediaButtonEvent(arg2)) || (super.onMediaButtonEvent(arg2)) ? true : false;
            return v0;
        }

        public void onPause() {
            this.mCallback.onPause();
        }

        public void onPlay() {
            this.mCallback.onPlay();
        }

        public void onPlayFromMediaId(String arg2, Bundle arg3) {
            this.mCallback.onPlayFromMediaId(arg2, arg3);
        }

        public void onPlayFromSearch(String arg2, Bundle arg3) {
            this.mCallback.onPlayFromSearch(arg2, arg3);
        }

        public void onRewind() {
            this.mCallback.onRewind();
        }

        public void onSeekTo(long arg2) {
            this.mCallback.onSeekTo(arg2);
        }

        public void onSetRating(Rating arg2) {
            this.mCallback.onSetRating(arg2);
        }

        public void onSkipToNext() {
            this.mCallback.onSkipToNext();
        }

        public void onSkipToPrevious() {
            this.mCallback.onSkipToPrevious();
        }

        public void onSkipToQueueItem(long arg2) {
            this.mCallback.onSkipToQueueItem(arg2);
        }

        public void onStop() {
            this.mCallback.onStop();
        }
    }

    class QueueItem {
        QueueItem() {
            super();
        }

        public static Object createItem(Object arg1, long arg2) {
            return new MediaSession$QueueItem(((MediaDescription)arg1), arg2);
        }

        public static Object getDescription(Object arg1) {
            return ((MediaSession$QueueItem)arg1).getDescription();
        }

        public static long getQueueId(Object arg2) {
            return ((MediaSession$QueueItem)arg2).getQueueId();
        }
    }

    MediaSessionCompatApi21() {
        super();
    }

    public static Object createCallback(Callback arg1) {
        return new CallbackProxy(arg1);
    }

    public static Object createSession(Context arg1, String arg2) {
        return new MediaSession(arg1, arg2);
    }

    public static Parcelable getSessionToken(Object arg1) {
        return ((MediaSession)arg1).getSessionToken();
    }

    public static boolean isActive(Object arg1) {
        return ((MediaSession)arg1).isActive();
    }

    public static void release(Object arg0) {
        ((MediaSession)arg0).release();
    }

    public static void sendSessionEvent(Object arg0, String arg1, Bundle arg2) {
        ((MediaSession)arg0).sendSessionEvent(arg1, arg2);
    }

    public static void setActive(Object arg0, boolean arg1) {
        ((MediaSession)arg0).setActive(arg1);
    }

    public static void setCallback(Object arg0, Object arg1, Handler arg2) {
        ((MediaSession)arg0).setCallback(((MediaSession$Callback)arg1), arg2);
    }

    public static void setExtras(Object arg0, Bundle arg1) {
        ((MediaSession)arg0).setExtras(arg1);
    }

    public static void setFlags(Object arg0, int arg1) {
        ((MediaSession)arg0).setFlags(arg1);
    }

    public static void setMediaButtonReceiver(Object arg0, PendingIntent arg1) {
        ((MediaSession)arg0).setMediaButtonReceiver(arg1);
    }

    public static void setMetadata(Object arg0, Object arg1) {
        ((MediaSession)arg0).setMetadata(((MediaMetadata)arg1));
    }

    public static void setPlaybackState(Object arg0, Object arg1) {
        ((MediaSession)arg0).setPlaybackState(((PlaybackState)arg1));
    }

    public static void setPlaybackToLocal(Object arg1, int arg2) {
        AudioAttributes$Builder v0 = new AudioAttributes$Builder();
        v0.setLegacyStreamType(arg2);
        ((MediaSession)arg1).setPlaybackToLocal(v0.build());
    }

    public static void setPlaybackToRemote(Object arg0, Object arg1) {
        ((MediaSession)arg0).setPlaybackToRemote(((VolumeProvider)arg1));
    }

    public static void setQueue(Object arg3, List arg4) {
        if(arg4 == null) {
            ((MediaSession)arg3).setQueue(null);
        }
        else {
            ArrayList v1 = new ArrayList();
            Iterator v2 = arg4.iterator();
            while(v2.hasNext()) {
                v1.add(v2.next());
            }

            ((MediaSession)arg3).setQueue(((List)v1));
        }
    }

    public static void setQueueTitle(Object arg0, CharSequence arg1) {
        ((MediaSession)arg0).setQueueTitle(arg1);
    }

    public static void setSessionActivity(Object arg0, PendingIntent arg1) {
        ((MediaSession)arg0).setSessionActivity(arg1);
    }

    public static Object verifySession(Object arg2) {
        if((arg2 instanceof MediaSession)) {
            return arg2;
        }

        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }

    public static Object verifyToken(Object arg2) {
        if((arg2 instanceof MediaSession$Token)) {
            return arg2;
        }

        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}

