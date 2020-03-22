package android.support.v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build$VERSION;
import android.view.KeyEvent$Callback;
import android.view.KeyEvent;
import android.view.View;
import java.util.ArrayList;

@Deprecated public class TransportMediator extends TransportController {
    class android.support.v4.media.TransportMediator$1 implements TransportMediatorCallback {
        android.support.v4.media.TransportMediator$1(TransportMediator arg1) {
            TransportMediator.this = arg1;
            super();
        }

        public long getPlaybackPosition() {
            return TransportMediator.this.mCallbacks.onGetCurrentPosition();
        }

        public void handleAudioFocusChange(int arg2) {
            TransportMediator.this.mCallbacks.onAudioFocusChange(arg2);
        }

        public void handleKey(KeyEvent arg2) {
            arg2.dispatch(TransportMediator.this.mKeyEventCallback);
        }

        public void playbackPositionUpdate(long arg2) {
            TransportMediator.this.mCallbacks.onSeekTo(arg2);
        }
    }

    class android.support.v4.media.TransportMediator$2 implements KeyEvent$Callback {
        android.support.v4.media.TransportMediator$2(TransportMediator arg1) {
            TransportMediator.this = arg1;
            super();
        }

        public boolean onKeyDown(int arg2, KeyEvent arg3) {
            boolean v0 = TransportMediator.isMediaKey(arg2) ? TransportMediator.this.mCallbacks.onMediaButtonDown(arg2, arg3) : false;
            return v0;
        }

        public boolean onKeyLongPress(int arg2, KeyEvent arg3) {
            return 0;
        }

        public boolean onKeyMultiple(int arg2, int arg3, KeyEvent arg4) {
            return 0;
        }

        public boolean onKeyUp(int arg2, KeyEvent arg3) {
            boolean v0 = TransportMediator.isMediaKey(arg2) ? TransportMediator.this.mCallbacks.onMediaButtonUp(arg2, arg3) : false;
            return v0;
        }
    }

    @Deprecated public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 0x40;
    @Deprecated public static final int FLAG_KEY_MEDIA_NEXT = 0x80;
    @Deprecated public static final int FLAG_KEY_MEDIA_PAUSE = 16;
    @Deprecated public static final int FLAG_KEY_MEDIA_PLAY = 4;
    @Deprecated public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
    @Deprecated public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
    @Deprecated public static final int FLAG_KEY_MEDIA_REWIND = 2;
    @Deprecated public static final int FLAG_KEY_MEDIA_STOP = 0x20;
    @Deprecated public static final int KEYCODE_MEDIA_PAUSE = 0x7F;
    @Deprecated public static final int KEYCODE_MEDIA_PLAY = 0x7E;
    @Deprecated public static final int KEYCODE_MEDIA_RECORD = 130;
    final AudioManager mAudioManager;
    final TransportPerformer mCallbacks;
    final Context mContext;
    final TransportMediatorJellybeanMR2 mController;
    final Object mDispatcherState;
    final KeyEvent$Callback mKeyEventCallback;
    final ArrayList mListeners;
    final TransportMediatorCallback mTransportKeyCallback;
    final View mView;

    @Deprecated public TransportMediator(Activity arg2, TransportPerformer arg3) {
        this(arg2, null, arg3);
    }

    private TransportMediator(Activity arg6, View arg7, TransportPerformer arg8) {
        Activity v0;
        super();
        this.mListeners = new ArrayList();
        this.mTransportKeyCallback = new android.support.v4.media.TransportMediator$1(this);
        this.mKeyEventCallback = new android.support.v4.media.TransportMediator$2(this);
        if(arg6 != null) {
            v0 = arg6;
        }
        else {
            Context v0_1 = arg7.getContext();
        }

        this.mContext = ((Context)v0);
        this.mCallbacks = arg8;
        this.mAudioManager = this.mContext.getSystemService("audio");
        if(arg6 != null) {
            arg7 = arg6.getWindow().getDecorView();
        }

        this.mView = arg7;
        this.mDispatcherState = this.mView.getKeyDispatcherState();
        this.mController = Build$VERSION.SDK_INT >= 18 ? new TransportMediatorJellybeanMR2(this.mContext, this.mAudioManager, this.mView, this.mTransportKeyCallback) : null;
    }

    @Deprecated public TransportMediator(View arg2, TransportPerformer arg3) {
        this(null, arg2, arg3);
    }

    @Deprecated public void destroy() {
        this.mController.destroy();
    }

    @Deprecated public boolean dispatchKeyEvent(KeyEvent arg3) {
        return arg3.dispatch(this.mKeyEventCallback, this.mDispatcherState, this);
    }

    @Deprecated public int getBufferPercentage() {
        return this.mCallbacks.onGetBufferPercentage();
    }

    @Deprecated public long getCurrentPosition() {
        return this.mCallbacks.onGetCurrentPosition();
    }

    @Deprecated public long getDuration() {
        return this.mCallbacks.onGetDuration();
    }

    private TransportStateListener[] getListeners() {
        TransportStateListener[] v0;
        if(this.mListeners.size() <= 0) {
            v0 = null;
        }
        else {
            v0 = new TransportStateListener[this.mListeners.size()];
            this.mListeners.toArray(((Object[])v0));
        }

        return v0;
    }

    @Deprecated public Object getRemoteControlClient() {
        Object v0 = this.mController != null ? this.mController.getRemoteControlClient() : null;
        return v0;
    }

    @Deprecated public int getTransportControlFlags() {
        return this.mCallbacks.onGetTransportControlFlags();
    }

    static boolean isMediaKey(int arg1) {
        boolean v0;
        switch(arg1) {
            case 79: 
            case 85: 
            case 86: 
            case 87: 
            case 88: 
            case 89: 
            case 90: 
            case 91: 
            case 126: 
            case 127: 
            case 130: {
                v0 = true;
                break;
            }
            default: {
                v0 = false;
                break;
            }
        }

        return v0;
    }

    @Deprecated public boolean isPlaying() {
        return this.mCallbacks.onIsPlaying();
    }

    @Deprecated public void pausePlaying() {
        if(this.mController != null) {
            this.mController.pausePlaying();
        }

        this.mCallbacks.onPause();
        this.pushControllerState();
        this.reportPlayingChanged();
    }

    private void pushControllerState() {
        if(this.mController != null) {
            this.mController.refreshState(this.mCallbacks.onIsPlaying(), this.mCallbacks.onGetCurrentPosition(), this.mCallbacks.onGetTransportControlFlags());
        }
    }

    @Deprecated public void refreshState() {
        this.pushControllerState();
        this.reportPlayingChanged();
        this.reportTransportControlsChanged();
    }

    @Deprecated public void registerStateListener(TransportStateListener arg2) {
        this.mListeners.add(arg2);
    }

    private void reportPlayingChanged() {
        TransportStateListener[] v1 = this.getListeners();
        if(v1 != null) {
            int v2 = v1.length;
            int v0;
            for(v0 = 0; v0 < v2; ++v0) {
                v1[v0].onPlayingChanged(((TransportController)this));
            }
        }
    }

    private void reportTransportControlsChanged() {
        TransportStateListener[] v1 = this.getListeners();
        if(v1 != null) {
            int v2 = v1.length;
            int v0;
            for(v0 = 0; v0 < v2; ++v0) {
                v1[v0].onTransportControlsChanged(((TransportController)this));
            }
        }
    }

    @Deprecated public void seekTo(long arg2) {
        this.mCallbacks.onSeekTo(arg2);
    }

    @Deprecated public void startPlaying() {
        if(this.mController != null) {
            this.mController.startPlaying();
        }

        this.mCallbacks.onStart();
        this.pushControllerState();
        this.reportPlayingChanged();
    }

    @Deprecated public void stopPlaying() {
        if(this.mController != null) {
            this.mController.stopPlaying();
        }

        this.mCallbacks.onStop();
        this.pushControllerState();
        this.reportPlayingChanged();
    }

    @Deprecated public void unregisterStateListener(TransportStateListener arg2) {
        this.mListeners.remove(arg2);
    }
}

