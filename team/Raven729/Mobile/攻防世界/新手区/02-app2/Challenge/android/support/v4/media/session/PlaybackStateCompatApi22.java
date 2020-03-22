package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.media.session.PlaybackState$Builder;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import java.util.Iterator;
import java.util.List;

@TargetApi(value=22) @RequiresApi(value=22) class PlaybackStateCompatApi22 {
    PlaybackStateCompatApi22() {
        super();
    }

    public static Bundle getExtras(Object arg1) {
        return ((PlaybackState)arg1).getExtras();
    }

    public static Object newInstance(int arg9, long arg10, long arg12, float arg14, long arg15, CharSequence arg17, long arg18, List arg20, long arg21, Bundle arg23) {
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
        v2.setExtras(arg23);
        return v2.build();
    }
}

