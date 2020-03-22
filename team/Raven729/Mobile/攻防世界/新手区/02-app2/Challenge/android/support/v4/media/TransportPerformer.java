package android.support.v4.media;

import android.os.SystemClock;
import android.view.KeyEvent;

@Deprecated public abstract class TransportPerformer {
    static final int AUDIOFOCUS_GAIN = 1;
    static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    static final int AUDIOFOCUS_LOSS = -1;
    static final int AUDIOFOCUS_LOSS_TRANSIENT = -2;
    static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;

    @Deprecated public TransportPerformer() {
        super();
    }

    @Deprecated public void onAudioFocusChange(int arg10) {
        int v7 = 0;
        switch(arg10) {
            case -1: {
                v7 = 0x7F;
                break;
            }
        }

        if(v7 != 0) {
            long v2 = SystemClock.uptimeMillis();
            this.onMediaButtonDown(v7, new KeyEvent(v2, v2, 0, v7, 0));
            this.onMediaButtonUp(v7, new KeyEvent(v2, v2, 1, v7, 0));
        }
    }

    @Deprecated public int onGetBufferPercentage() {
        return 100;
    }

    @Deprecated public abstract long onGetCurrentPosition();

    @Deprecated public abstract long onGetDuration();

    @Deprecated public int onGetTransportControlFlags() {
        return 60;
    }

    @Deprecated public abstract boolean onIsPlaying();

    @Deprecated public boolean onMediaButtonDown(int arg3, KeyEvent arg4) {
        switch(arg3) {
            case 79: 
            case 85: {
                if(this.onIsPlaying()) {
                    this.onPause();
                    return 1;
                }

                this.onStart();
                break;
            }
            case 86: {
                this.onStop();
                break;
            }
            case 126: {
                this.onStart();
                break;
            }
            case 127: {
                this.onPause();
                break;
            }
        }

        return 1;
    }

    @Deprecated public boolean onMediaButtonUp(int arg2, KeyEvent arg3) {
        return 1;
    }

    @Deprecated public abstract void onPause();

    @Deprecated public abstract void onSeekTo(long arg1);

    @Deprecated public abstract void onStart();

    @Deprecated public abstract void onStop();
}

