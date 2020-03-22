package android.support.v4.media;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;

@TargetApi(value=18) @RequiresApi(value=18) interface TransportMediatorCallback {
    long getPlaybackPosition();

    void handleAudioFocusChange(int arg1);

    void handleKey(KeyEvent arg1);

    void playbackPositionUpdate(long arg1);
}

