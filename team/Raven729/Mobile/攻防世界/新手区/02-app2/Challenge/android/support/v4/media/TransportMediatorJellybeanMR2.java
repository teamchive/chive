package android.support.v4.media;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager$OnAudioFocusChangeListener;
import android.media.AudioManager;
import android.media.RemoteControlClient$OnGetPlaybackPositionListener;
import android.media.RemoteControlClient$OnPlaybackPositionUpdateListener;
import android.media.RemoteControlClient;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver$OnWindowAttachListener;
import android.view.ViewTreeObserver$OnWindowFocusChangeListener;

@TargetApi(value=18) @RequiresApi(value=18) class TransportMediatorJellybeanMR2 {
    class android.support.v4.media.TransportMediatorJellybeanMR2$1 implements ViewTreeObserver$OnWindowAttachListener {
        android.support.v4.media.TransportMediatorJellybeanMR2$1(TransportMediatorJellybeanMR2 arg1) {
            TransportMediatorJellybeanMR2.this = arg1;
            super();
        }

        public void onWindowAttached() {
            TransportMediatorJellybeanMR2.this.windowAttached();
        }

        public void onWindowDetached() {
            TransportMediatorJellybeanMR2.this.windowDetached();
        }
    }

    class android.support.v4.media.TransportMediatorJellybeanMR2$2 implements ViewTreeObserver$OnWindowFocusChangeListener {
        android.support.v4.media.TransportMediatorJellybeanMR2$2(TransportMediatorJellybeanMR2 arg1) {
            TransportMediatorJellybeanMR2.this = arg1;
            super();
        }

        public void onWindowFocusChanged(boolean arg2) {
            if(arg2) {
                TransportMediatorJellybeanMR2.this.gainFocus();
            }
            else {
                TransportMediatorJellybeanMR2.this.loseFocus();
            }
        }
    }

    class android.support.v4.media.TransportMediatorJellybeanMR2$3 extends BroadcastReceiver {
        android.support.v4.media.TransportMediatorJellybeanMR2$3(TransportMediatorJellybeanMR2 arg1) {
            TransportMediatorJellybeanMR2.this = arg1;
            super();
        }

        public void onReceive(Context arg3, Intent arg4) {
            try {
                TransportMediatorJellybeanMR2.this.mTransportCallback.handleKey(arg4.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            }
            catch(ClassCastException v0) {
                Log.w("TransportController", ((Throwable)v0));
            }
        }
    }

    class android.support.v4.media.TransportMediatorJellybeanMR2$4 implements AudioManager$OnAudioFocusChangeListener {
        android.support.v4.media.TransportMediatorJellybeanMR2$4(TransportMediatorJellybeanMR2 arg1) {
            TransportMediatorJellybeanMR2.this = arg1;
            super();
        }

        public void onAudioFocusChange(int arg2) {
            TransportMediatorJellybeanMR2.this.mTransportCallback.handleAudioFocusChange(arg2);
        }
    }

    class android.support.v4.media.TransportMediatorJellybeanMR2$5 implements RemoteControlClient$OnGetPlaybackPositionListener {
        android.support.v4.media.TransportMediatorJellybeanMR2$5(TransportMediatorJellybeanMR2 arg1) {
            TransportMediatorJellybeanMR2.this = arg1;
            super();
        }

        public long onGetPlaybackPosition() {
            return TransportMediatorJellybeanMR2.this.mTransportCallback.getPlaybackPosition();
        }
    }

    class android.support.v4.media.TransportMediatorJellybeanMR2$6 implements RemoteControlClient$OnPlaybackPositionUpdateListener {
        android.support.v4.media.TransportMediatorJellybeanMR2$6(TransportMediatorJellybeanMR2 arg1) {
            TransportMediatorJellybeanMR2.this = arg1;
            super();
        }

        public void onPlaybackPositionUpdate(long arg2) {
            TransportMediatorJellybeanMR2.this.mTransportCallback.playbackPositionUpdate(arg2);
        }
    }

    AudioManager$OnAudioFocusChangeListener mAudioFocusChangeListener;
    boolean mAudioFocused;
    final AudioManager mAudioManager;
    final Context mContext;
    boolean mFocused;
    final RemoteControlClient$OnGetPlaybackPositionListener mGetPlaybackPositionListener;
    final Intent mIntent;
    final BroadcastReceiver mMediaButtonReceiver;
    PendingIntent mPendingIntent;
    int mPlayState;
    final RemoteControlClient$OnPlaybackPositionUpdateListener mPlaybackPositionUpdateListener;
    final String mReceiverAction;
    final IntentFilter mReceiverFilter;
    RemoteControlClient mRemoteControl;
    final View mTargetView;
    final TransportMediatorCallback mTransportCallback;
    final ViewTreeObserver$OnWindowAttachListener mWindowAttachListener;
    final ViewTreeObserver$OnWindowFocusChangeListener mWindowFocusListener;

    public TransportMediatorJellybeanMR2(Context arg3, AudioManager arg4, View arg5, TransportMediatorCallback arg6) {
        super();
        this.mWindowAttachListener = new android.support.v4.media.TransportMediatorJellybeanMR2$1(this);
        this.mWindowFocusListener = new android.support.v4.media.TransportMediatorJellybeanMR2$2(this);
        this.mMediaButtonReceiver = new android.support.v4.media.TransportMediatorJellybeanMR2$3(this);
        this.mAudioFocusChangeListener = new android.support.v4.media.TransportMediatorJellybeanMR2$4(this);
        this.mGetPlaybackPositionListener = new android.support.v4.media.TransportMediatorJellybeanMR2$5(this);
        this.mPlaybackPositionUpdateListener = new android.support.v4.media.TransportMediatorJellybeanMR2$6(this);
        this.mPlayState = 0;
        this.mContext = arg3;
        this.mAudioManager = arg4;
        this.mTargetView = arg5;
        this.mTransportCallback = arg6;
        this.mReceiverAction = arg3.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.mReceiverAction);
        this.mIntent.setPackage(arg3.getPackageName());
        this.mReceiverFilter = new IntentFilter();
        this.mReceiverFilter.addAction(this.mReceiverAction);
        this.mTargetView.getViewTreeObserver().addOnWindowAttachListener(this.mWindowAttachListener);
        this.mTargetView.getViewTreeObserver().addOnWindowFocusChangeListener(this.mWindowFocusListener);
    }

    public void destroy() {
        this.windowDetached();
        this.mTargetView.getViewTreeObserver().removeOnWindowAttachListener(this.mWindowAttachListener);
        this.mTargetView.getViewTreeObserver().removeOnWindowFocusChangeListener(this.mWindowFocusListener);
    }

    void dropAudioFocus() {
        if(this.mAudioFocused) {
            this.mAudioFocused = false;
            this.mAudioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
        }
    }

    void gainFocus() {
        if(!this.mFocused) {
            this.mFocused = true;
            this.mAudioManager.registerMediaButtonEventReceiver(this.mPendingIntent);
            this.mAudioManager.registerRemoteControlClient(this.mRemoteControl);
            if(this.mPlayState == 3) {
                this.takeAudioFocus();
            }
        }
    }

    public Object getRemoteControlClient() {
        return this.mRemoteControl;
    }

    void loseFocus() {
        this.dropAudioFocus();
        if(this.mFocused) {
            this.mFocused = false;
            this.mAudioManager.unregisterRemoteControlClient(this.mRemoteControl);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.mPendingIntent);
        }
    }

    public void pausePlaying() {
        int v2 = 2;
        if(this.mPlayState == 3) {
            this.mPlayState = v2;
            this.mRemoteControl.setPlaybackState(v2);
        }

        this.dropAudioFocus();
    }

    public void refreshState(boolean arg5, long arg6, int arg8) {
        if(this.mRemoteControl != null) {
            RemoteControlClient v2 = this.mRemoteControl;
            int v1 = arg5 ? 3 : 1;
            float v0 = arg5 ? 1f : 0f;
            v2.setPlaybackState(v1, arg6, v0);
            this.mRemoteControl.setTransportControlFlags(arg8);
        }
    }

    public void startPlaying() {
        int v1 = 3;
        if(this.mPlayState != v1) {
            this.mPlayState = v1;
            this.mRemoteControl.setPlaybackState(v1);
        }

        if(this.mFocused) {
            this.takeAudioFocus();
        }
    }

    public void stopPlaying() {
        if(this.mPlayState != 1) {
            this.mPlayState = 1;
            this.mRemoteControl.setPlaybackState(1);
        }

        this.dropAudioFocus();
    }

    void takeAudioFocus() {
        if(!this.mAudioFocused) {
            this.mAudioFocused = true;
            this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1);
        }
    }

    void windowAttached() {
        this.mContext.registerReceiver(this.mMediaButtonReceiver, this.mReceiverFilter);
        this.mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, this.mIntent, 0x10000000);
        this.mRemoteControl = new RemoteControlClient(this.mPendingIntent);
        this.mRemoteControl.setOnGetPlaybackPositionListener(this.mGetPlaybackPositionListener);
        this.mRemoteControl.setPlaybackPositionUpdateListener(this.mPlaybackPositionUpdateListener);
    }

    void windowDetached() {
        PendingIntent v2 = null;
        this.loseFocus();
        if(this.mPendingIntent != null) {
            this.mContext.unregisterReceiver(this.mMediaButtonReceiver);
            this.mPendingIntent.cancel();
            this.mPendingIntent = v2;
            this.mRemoteControl = ((RemoteControlClient)v2);
        }
    }
}

