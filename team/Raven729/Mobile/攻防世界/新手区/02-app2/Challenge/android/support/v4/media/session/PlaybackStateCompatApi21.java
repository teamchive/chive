package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.media.session.PlaybackState$Builder;
import android.media.session.PlaybackState$CustomAction$Builder;
import android.media.session.PlaybackState$CustomAction;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import java.util.Iterator;
import java.util.List;

@TargetApi(value=21) @RequiresApi(value=21) class PlaybackStateCompatApi21 {
    final class CustomAction {
        CustomAction() {
            super();
        }

        public static String getAction(Object arg1) {
            return ((PlaybackState$CustomAction)arg1).getAction();
        }

        public static Bundle getExtras(Object arg1) {
            return ((PlaybackState$CustomAction)arg1).getExtras();
        }

        public static int getIcon(Object arg1) {
            return ((PlaybackState$CustomAction)arg1).getIcon();
        }

        public static CharSequence getName(Object arg1) {
            return ((PlaybackState$CustomAction)arg1).getName();
        }

        public static Object newInstance(String arg1, CharSequence arg2, int arg3, Bundle arg4) {
            PlaybackState$CustomAction$Builder v0 = new PlaybackState$CustomAction$Builder(arg1, arg2, arg3);
            v0.setExtras(arg4);
            return v0.build();
        }
    }

    PlaybackStateCompatApi21() {
        super();
    }

    public static long getActions(Object arg2) {
        return ((PlaybackState)arg2).getActions();
    }

    public static long getActiveQueueItemId(Object arg2) {
        return ((PlaybackState)arg2).getActiveQueueItemId();
    }

    public static long getBufferedPosition(Object arg2) {
        return ((PlaybackState)arg2).getBufferedPosition();
    }

    public static List getCustomActions(Object arg1) {
        return ((PlaybackState)arg1).getCustomActions();
    }

    public static CharSequence getErrorMessage(Object arg1) {
        return ((PlaybackState)arg1).getErrorMessage();
    }

    public static long getLastPositionUpdateTime(Object arg2) {
        return ((PlaybackState)arg2).getLastPositionUpdateTime();
    }

    public static float getPlaybackSpeed(Object arg1) {
        return ((PlaybackState)arg1).getPlaybackSpeed();
    }

    public static long getPosition(Object arg2) {
        return ((PlaybackState)arg2).getPosition();
    }

    public static int getState(Object arg1) {
        return ((PlaybackState)arg1).getState();
    }

    public static Object newInstance(int arg9, long arg10, long arg12, float arg14, long arg15, CharSequence arg17, long arg18, List arg20, long arg21) {
        PlaybackState$Builder v2 = new PlaybackState$Builder();
        v2.setState(arg9, arg10, arg14, arg18);
        v2.setBufferedPosition(arg12);
        v2.setActions(arg15);
        v2.setErrorMessage(arg17);
        Iterator v4 = arg20.iterator();
        while(v4.hasNext()) {
            v2.addCustomAction(v4.next());
        }

        v2.setActiveQueueItemId(arg21);
        return v2.build();
    }
}

