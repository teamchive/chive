package android.support.v4.media.session;

import android.media.session.PlaybackState$CustomAction;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

class e {
    final class a {
        public static String a(Object arg1) {
            return ((PlaybackState$CustomAction)arg1).getAction();
        }

        public static CharSequence b(Object arg1) {
            return ((PlaybackState$CustomAction)arg1).getName();
        }

        public static int c(Object arg1) {
            return ((PlaybackState$CustomAction)arg1).getIcon();
        }

        public static Bundle d(Object arg1) {
            return ((PlaybackState$CustomAction)arg1).getExtras();
        }
    }

    public static int a(Object arg1) {
        return ((PlaybackState)arg1).getState();
    }

    public static long b(Object arg2) {
        return ((PlaybackState)arg2).getPosition();
    }

    public static long c(Object arg2) {
        return ((PlaybackState)arg2).getBufferedPosition();
    }

    public static float d(Object arg1) {
        return ((PlaybackState)arg1).getPlaybackSpeed();
    }

    public static long e(Object arg2) {
        return ((PlaybackState)arg2).getActions();
    }

    public static CharSequence f(Object arg1) {
        return ((PlaybackState)arg1).getErrorMessage();
    }

    public static long g(Object arg2) {
        return ((PlaybackState)arg2).getLastPositionUpdateTime();
    }

    public static List h(Object arg1) {
        return ((PlaybackState)arg1).getCustomActions();
    }

    public static long i(Object arg2) {
        return ((PlaybackState)arg2).getActiveQueueItemId();
    }
}

