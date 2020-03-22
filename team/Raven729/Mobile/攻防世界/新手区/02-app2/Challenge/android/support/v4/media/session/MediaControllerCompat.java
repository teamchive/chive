package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder$DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.SupportActivity$ExtraData;
import android.support.v4.app.SupportActivity;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class MediaControllerCompat {
    public abstract class Callback implements IBinder$DeathRecipient {
        class MessageHandler extends Handler {
            private static final int MSG_DESTROYED = 8;
            private static final int MSG_EVENT = 1;
            private static final int MSG_UPDATE_EXTRAS = 7;
            private static final int MSG_UPDATE_METADATA = 3;
            private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
            private static final int MSG_UPDATE_QUEUE = 5;
            private static final int MSG_UPDATE_QUEUE_TITLE = 6;
            private static final int MSG_UPDATE_REPEAT_MODE = 9;
            private static final int MSG_UPDATE_SHUFFLE_MODE = 10;
            private static final int MSG_UPDATE_VOLUME = 4;

            public MessageHandler(Callback arg1, Looper arg2) {
                Callback.this = arg1;
                super(arg2);
            }

            public void handleMessage(Message arg4) {
                if(Callback.this.mRegistered) {
                    switch(arg4.what) {
                        case 1: {
                            goto label_7;
                        }
                        case 2: {
                            goto label_12;
                        }
                        case 3: {
                            goto label_16;
                        }
                        case 4: {
                            goto label_42;
                        }
                        case 5: {
                            goto label_20;
                        }
                        case 6: {
                            goto label_24;
                        }
                        case 7: {
                            goto label_38;
                        }
                        case 8: {
                            goto label_46;
                        }
                        case 9: {
                            goto label_28;
                        }
                        case 10: {
                            goto label_33;
                        }
                    }

                    return;
                label_33:
                    Callback.this.onShuffleModeChanged(arg4.obj.booleanValue());
                    return;
                label_20:
                    Callback.this.onQueueChanged(arg4.obj);
                    return;
                label_38:
                    Callback.this.onExtrasChanged(arg4.obj);
                    return;
                label_7:
                    Callback.this.onSessionEvent(arg4.obj, arg4.getData());
                    return;
                label_24:
                    Callback.this.onQueueTitleChanged(arg4.obj);
                    return;
                label_42:
                    Callback.this.onAudioInfoChanged(arg4.obj);
                    return;
                label_12:
                    Callback.this.onPlaybackStateChanged(arg4.obj);
                    return;
                label_28:
                    Callback.this.onRepeatModeChanged(arg4.obj.intValue());
                    return;
                label_46:
                    Callback.this.onSessionDestroyed();
                    return;
                label_16:
                    Callback.this.onMetadataChanged(arg4.obj);
                }
            }

            public void post(int arg2, Object arg3, Bundle arg4) {
                Message v0 = this.obtainMessage(arg2, arg3);
                v0.setData(arg4);
                v0.sendToTarget();
            }
        }

        class StubApi21 implements android.support.v4.media.session.MediaControllerCompatApi21$Callback {
            StubApi21(Callback arg1) {
                Callback.this = arg1;
                super();
            }

            public void onAudioInfoChanged(int arg8, int arg9, int arg10, int arg11, int arg12) {
                Callback.this.onAudioInfoChanged(new PlaybackInfo(arg8, arg9, arg10, arg11, arg12));
            }

            public void onExtrasChanged(Bundle arg2) {
                Callback.this.onExtrasChanged(arg2);
            }

            public void onMetadataChanged(Object arg3) {
                Callback.this.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(arg3));
            }

            public void onPlaybackStateChanged(Object arg3) {
                if(!Callback.this.mHasExtraCallback) {
                    Callback.this.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(arg3));
                }
            }

            public void onQueueChanged(List arg3) {
                Callback.this.onQueueChanged(QueueItem.fromQueueItemList(arg3));
            }

            public void onQueueTitleChanged(CharSequence arg2) {
                Callback.this.onQueueTitleChanged(arg2);
            }

            public void onSessionDestroyed() {
                Callback.this.onSessionDestroyed();
            }

            public void onSessionEvent(String arg3, Bundle arg4) {
                if(!Callback.this.mHasExtraCallback || Build$VERSION.SDK_INT >= 23) {
                    Callback.this.onSessionEvent(arg3, arg4);
                }
            }
        }

        class StubCompat extends Stub {
            StubCompat(Callback arg1) {
                Callback.this = arg1;
                super();
            }

            public void onEvent(String arg3, Bundle arg4) {
                Callback.this.mHandler.post(1, arg3, arg4);
            }

            public void onExtrasChanged(Bundle arg4) {
                Callback.this.mHandler.post(7, arg4, null);
            }

            public void onMetadataChanged(MediaMetadataCompat arg4) {
                Callback.this.mHandler.post(3, arg4, null);
            }

            public void onPlaybackStateChanged(PlaybackStateCompat arg4) {
                Callback.this.mHandler.post(2, arg4, null);
            }

            public void onQueueChanged(List arg4) {
                Callback.this.mHandler.post(5, arg4, null);
            }

            public void onQueueTitleChanged(CharSequence arg4) {
                Callback.this.mHandler.post(6, arg4, null);
            }

            public void onRepeatModeChanged(int arg5) {
                Callback.this.mHandler.post(9, Integer.valueOf(arg5), null);
            }

            public void onSessionDestroyed() {
                Callback.this.mHandler.post(8, null, null);
            }

            public void onShuffleModeChanged(boolean arg5) {
                Callback.this.mHandler.post(10, Boolean.valueOf(arg5), null);
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo arg8) {
                Object v0_1;
                Bundle v6 = null;
                if(arg8 != null) {
                    PlaybackInfo v0 = new PlaybackInfo(arg8.volumeType, arg8.audioStream, arg8.controlType, arg8.maxVolume, arg8.currentVolume);
                }
                else {
                    v0_1 = v6;
                }

                Callback.this.mHandler.post(4, v0_1, v6);
            }
        }

        private final Object mCallbackObj;
        MessageHandler mHandler;
        boolean mHasExtraCallback;
        boolean mRegistered;

        public Callback() {
            super();
            this.mRegistered = false;
            this.mCallbackObj = Build$VERSION.SDK_INT >= 21 ? MediaControllerCompatApi21.createCallback(new StubApi21(this)) : new StubCompat(this);
        }

        static Object access$100(Callback arg1) {
            return arg1.mCallbackObj;
        }

        static void access$200(Callback arg0, Handler arg1) {
            arg0.setHandler(arg1);
        }

        public void binderDied() {
            this.onSessionDestroyed();
        }

        public void onAudioInfoChanged(PlaybackInfo arg1) {
        }

        public void onExtrasChanged(Bundle arg1) {
        }

        public void onMetadataChanged(MediaMetadataCompat arg1) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat arg1) {
        }

        public void onQueueChanged(List arg1) {
        }

        public void onQueueTitleChanged(CharSequence arg1) {
        }

        public void onRepeatModeChanged(int arg1) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String arg1, Bundle arg2) {
        }

        public void onShuffleModeChanged(boolean arg1) {
        }

        private void setHandler(Handler arg3) {
            this.mHandler = new MessageHandler(this, arg3.getLooper());
        }
    }

    class MediaControllerExtraData extends ExtraData {
        private final MediaControllerCompat mMediaController;

        MediaControllerExtraData(MediaControllerCompat arg1) {
            super();
            this.mMediaController = arg1;
        }

        MediaControllerCompat getMediaController() {
            return this.mMediaController;
        }
    }

    interface MediaControllerImpl {
        void addQueueItem(MediaDescriptionCompat arg1);

        void addQueueItem(MediaDescriptionCompat arg1, int arg2);

        void adjustVolume(int arg1, int arg2);

        boolean dispatchMediaButtonEvent(KeyEvent arg1);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        PendingIntent getSessionActivity();

        TransportControls getTransportControls();

        boolean isShuffleModeEnabled();

        void registerCallback(Callback arg1, Handler arg2);

        void removeQueueItem(MediaDescriptionCompat arg1);

        void removeQueueItemAt(int arg1);

        void sendCommand(String arg1, Bundle arg2, ResultReceiver arg3);

        void setVolumeTo(int arg1, int arg2);

        void unregisterCallback(Callback arg1);
    }

    class MediaControllerImplApi21 implements MediaControllerImpl {
        class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference mMediaControllerImpl;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 arg2, Handler arg3) {
                super(arg3);
                this.mMediaControllerImpl = new WeakReference(arg2);
            }

            protected void onReceiveResult(int arg3, Bundle arg4) {
                Object v0 = this.mMediaControllerImpl.get();
                if(v0 != null && arg4 != null) {
                    ((MediaControllerImplApi21)v0).mExtraBinder = android.support.v4.media.session.IMediaSession$Stub.asInterface(BundleCompat.getBinder(arg4, "android.support.v4.media.session.EXTRA_BINDER"));
                    ((MediaControllerImplApi21)v0).processPendingCallbacks();
                }
            }
        }

        class ExtraCallback extends Stub {
            private Callback mCallback;

            ExtraCallback(MediaControllerImplApi21 arg1, Callback arg2) {
                MediaControllerImplApi21.this = arg1;
                super();
                this.mCallback = arg2;
            }

            static Callback access$400(ExtraCallback arg1) {
                return arg1.mCallback;
            }

            public void onEvent(String arg3, Bundle arg4) {
                this.mCallback.mHandler.post(new Runnable(arg3, arg4) {
                    public void run() {
                        this.this$1.mCallback.onSessionEvent(this.val$event, this.val$extras);
                    }
                });
            }

            public void onExtrasChanged(Bundle arg2) {
                throw new AssertionError();
            }

            public void onMetadataChanged(MediaMetadataCompat arg2) {
                throw new AssertionError();
            }

            public void onPlaybackStateChanged(PlaybackStateCompat arg3) {
                this.mCallback.mHandler.post(new Runnable(arg3) {
                    public void run() {
                        this.this$1.mCallback.onPlaybackStateChanged(this.val$state);
                    }
                });
            }

            public void onQueueChanged(List arg2) {
                throw new AssertionError();
            }

            public void onQueueTitleChanged(CharSequence arg2) {
                throw new AssertionError();
            }

            public void onRepeatModeChanged(int arg3) {
                this.mCallback.mHandler.post(new Runnable(arg3) {
                    public void run() {
                        this.this$1.mCallback.onRepeatModeChanged(this.val$repeatMode);
                    }
                });
            }

            public void onSessionDestroyed() {
                throw new AssertionError();
            }

            public void onShuffleModeChanged(boolean arg3) {
                this.mCallback.mHandler.post(new Runnable(arg3) {
                    public void run() {
                        this.this$1.mCallback.onShuffleModeChanged(this.val$enabled);
                    }
                });
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo arg2) {
                throw new AssertionError();
            }
        }

        private HashMap mCallbackMap;
        protected final Object mControllerObj;
        private IMediaSession mExtraBinder;
        private List mPendingCallbacks;

        public MediaControllerImplApi21(Context arg2, Token arg3) {
            super();
            this.mCallbackMap = new HashMap();
            this.mPendingCallbacks = new ArrayList();
            this.mControllerObj = MediaControllerCompatApi21.fromToken(arg2, arg3.getToken());
            if(this.mControllerObj == null) {
                throw new RemoteException();
            }

            this.requestExtraBinder();
        }

        public MediaControllerImplApi21(Context arg2, MediaSessionCompat arg3) {
            super();
            this.mCallbackMap = new HashMap();
            this.mPendingCallbacks = new ArrayList();
            this.mControllerObj = MediaControllerCompatApi21.fromToken(arg2, arg3.getSessionToken().getToken());
            this.requestExtraBinder();
        }

        static IMediaSession access$000(MediaControllerImplApi21 arg1) {
            return arg1.mExtraBinder;
        }

        static IMediaSession access$002(MediaControllerImplApi21 arg0, IMediaSession arg1) {
            arg0.mExtraBinder = arg1;
            return arg1;
        }

        static void access$300(MediaControllerImplApi21 arg0) {
            arg0.processPendingCallbacks();
        }

        public void addQueueItem(MediaDescriptionCompat arg4) {
            Bundle v0 = new Bundle();
            v0.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", ((Parcelable)arg4));
            this.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM", v0, null);
        }

        public void addQueueItem(MediaDescriptionCompat arg4, int arg5) {
            Bundle v0 = new Bundle();
            v0.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", ((Parcelable)arg4));
            v0.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", arg5);
            this.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", v0, null);
        }

        public void adjustVolume(int arg2, int arg3) {
            MediaControllerCompatApi21.adjustVolume(this.mControllerObj, arg2, arg3);
        }

        public boolean dispatchMediaButtonEvent(KeyEvent arg2) {
            return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, arg2);
        }

        public Bundle getExtras() {
            return MediaControllerCompatApi21.getExtras(this.mControllerObj);
        }

        public long getFlags() {
            return MediaControllerCompatApi21.getFlags(this.mControllerObj);
        }

        public Object getMediaController() {
            return this.mControllerObj;
        }

        public MediaMetadataCompat getMetadata() {
            Object v0 = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
            MediaMetadataCompat v0_1 = v0 != null ? MediaMetadataCompat.fromMediaMetadata(v0) : null;
            return v0_1;
        }

        public String getPackageName() {
            return MediaControllerCompatApi21.getPackageName(this.mControllerObj);
        }

        public PlaybackInfo getPlaybackInfo() {
            Object v5 = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
            PlaybackInfo v0 = v5 != null ? new PlaybackInfo(android.support.v4.media.session.MediaControllerCompatApi21$PlaybackInfo.getPlaybackType(v5), android.support.v4.media.session.MediaControllerCompatApi21$PlaybackInfo.getLegacyAudioStream(v5), android.support.v4.media.session.MediaControllerCompatApi21$PlaybackInfo.getVolumeControl(v5), android.support.v4.media.session.MediaControllerCompatApi21$PlaybackInfo.getMaxVolume(v5), android.support.v4.media.session.MediaControllerCompatApi21$PlaybackInfo.getCurrentVolume(v5)) : null;
            return v0;
        }

        public PlaybackStateCompat getPlaybackState() {
            if(this.mExtraBinder != null) {
                try {
                    PlaybackStateCompat v0_1 = this.mExtraBinder.getPlaybackState();
                    return v0_1;
                }
                catch(RemoteException v0) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", ((Throwable)v0));
                }
            }

            Object v0_2 = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
            return v0_2 != null ? PlaybackStateCompat.fromPlaybackState(v0_2) : null;
        }

        public List getQueue() {
            List v0 = MediaControllerCompatApi21.getQueue(this.mControllerObj);
            return v0 != null ? QueueItem.fromQueueItemList(v0) : null;
        }

        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.getQueueTitle(this.mControllerObj);
        }

        public int getRatingType() {
            if(Build$VERSION.SDK_INT < 22 && this.mExtraBinder != null) {
                try {
                    int v0_1 = this.mExtraBinder.getRatingType();
                    return v0_1;
                }
                catch(RemoteException v0) {
                    Log.e("MediaControllerCompat", "Dead object in getRatingType.", ((Throwable)v0));
                }
            }

            return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
        }

        public int getRepeatMode() {
            if(this.mExtraBinder != null) {
                try {
                    int v0_1 = this.mExtraBinder.getRepeatMode();
                    return v0_1;
                }
                catch(RemoteException v0) {
                    Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", ((Throwable)v0));
                }
            }

            return 0;
        }

        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.getSessionActivity(this.mControllerObj);
        }

        public TransportControls getTransportControls() {
            TransportControls v0_1;
            Object v1 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if(v1 != null) {
                TransportControlsApi21 v0 = new TransportControlsApi21(v1);
            }
            else {
                v0_1 = null;
            }

            return v0_1;
        }

        public boolean isShuffleModeEnabled() {
            if(this.mExtraBinder != null) {
                try {
                    boolean v0_1 = this.mExtraBinder.isShuffleModeEnabled();
                    return v0_1;
                }
                catch(RemoteException v0) {
                    Log.e("MediaControllerCompat", "Dead object in isShuffleModeEnabled.", ((Throwable)v0));
                }
            }

            return false;
        }

        private void processPendingCallbacks() {
            List v1;
            if(this.mExtraBinder != null) {
                v1 = this.mPendingCallbacks;
                __monitor_enter(v1);
                try {
                    Iterator v2 = this.mPendingCallbacks.iterator();
                    while(true) {
                        if(!v2.hasNext()) {
                            goto label_23;
                        }

                        Object v0_1 = v2.next();
                        ExtraCallback v3 = new ExtraCallback(this, ((Callback)v0_1));
                        this.mCallbackMap.put(v0_1, v3);
                        ((Callback)v0_1).mHasExtraCallback = true;
                        try {
                            this.mExtraBinder.registerCallbackListener(((IMediaControllerCallback)v3));
                            continue;
                        }
                        catch(RemoteException v0_2) {
                            try {
                                Log.e("MediaControllerCompat", "Dead object in registerCallback.", ((Throwable)v0_2));
                            label_23:
                                this.mPendingCallbacks.clear();
                                __monitor_exit(v1);
                                return;
                            }
                            catch(Throwable v0) {
                                goto label_28;
                            }
                        }
                    }
                }
                catch(Throwable v0) {
                    goto label_28;
                }
            }

            return;
            try {
            label_28:
                __monitor_exit(v1);
            }
            catch(Throwable v0) {
                goto label_28;
            }

            throw v0;
        }

        public final void registerCallback(Callback arg4, Handler arg5) {
            MediaControllerCompatApi21.registerCallback(this.mControllerObj, arg4.mCallbackObj, arg5);
            if(this.mExtraBinder != null) {
                arg4.setHandler(arg5);
                ExtraCallback v0 = new ExtraCallback(this, arg4);
                this.mCallbackMap.put(arg4, v0);
                arg4.mHasExtraCallback = true;
                try {
                    this.mExtraBinder.registerCallbackListener(((IMediaControllerCallback)v0));
                }
                catch(RemoteException v0_1) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", ((Throwable)v0_1));
                }

                return;
            }

            arg4.setHandler(arg5);
            List v1 = this.mPendingCallbacks;
            __monitor_enter(v1);
            try {
                this.mPendingCallbacks.add(arg4);
                __monitor_exit(v1);
                return;
            label_28:
                __monitor_exit(v1);
            }
            catch(Throwable v0_2) {
                goto label_28;
            }

            throw v0_2;
        }

        public void removeQueueItem(MediaDescriptionCompat arg4) {
            Bundle v0 = new Bundle();
            v0.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", ((Parcelable)arg4));
            this.sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", v0, null);
        }

        public void removeQueueItemAt(int arg4) {
            Bundle v0 = new Bundle();
            v0.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", arg4);
            this.sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT", v0, null);
        }

        private void requestExtraBinder() {
            this.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this, new Handler()));
        }

        public void sendCommand(String arg2, Bundle arg3, ResultReceiver arg4) {
            MediaControllerCompatApi21.sendCommand(this.mControllerObj, arg2, arg3, arg4);
        }

        public void setVolumeTo(int arg2, int arg3) {
            MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, arg2, arg3);
        }

        public final void unregisterCallback(Callback arg4) {
            MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, arg4.mCallbackObj);
            if(this.mExtraBinder != null) {
                try {
                    Object v0_1 = this.mCallbackMap.remove(arg4);
                    if(v0_1 == null) {
                        return;
                    }

                    this.mExtraBinder.unregisterCallbackListener(((IMediaControllerCallback)v0_1));
                }
                catch(RemoteException v0) {
                    Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", ((Throwable)v0));
                }

                return;
            }

            List v1 = this.mPendingCallbacks;
            __monitor_enter(v1);
            try {
                this.mPendingCallbacks.remove(arg4);
                __monitor_exit(v1);
                return;
            label_23:
                __monitor_exit(v1);
            }
            catch(Throwable v0_2) {
                goto label_23;
            }

            throw v0_2;
        }
    }

    class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context arg1, Token arg2) {
            super(arg1, arg2);
        }

        public MediaControllerImplApi23(Context arg1, MediaSessionCompat arg2) {
            super(arg1, arg2);
        }

        public TransportControls getTransportControls() {
            TransportControls v0_1;
            Object v1 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if(v1 != null) {
                TransportControlsApi23 v0 = new TransportControlsApi23(v1);
            }
            else {
                v0_1 = null;
            }

            return v0_1;
        }
    }

    class MediaControllerImplApi24 extends MediaControllerImplApi23 {
        public MediaControllerImplApi24(Context arg1, Token arg2) {
            super(arg1, arg2);
        }

        public MediaControllerImplApi24(Context arg1, MediaSessionCompat arg2) {
            super(arg1, arg2);
        }

        public TransportControls getTransportControls() {
            TransportControls v0_1;
            Object v1 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if(v1 != null) {
                TransportControlsApi24 v0 = new TransportControlsApi24(v1);
            }
            else {
                v0_1 = null;
            }

            return v0_1;
        }
    }

    class MediaControllerImplBase implements MediaControllerImpl {
        private IMediaSession mBinder;
        private Token mToken;
        private TransportControls mTransportControls;

        public MediaControllerImplBase(Token arg2) {
            super();
            this.mToken = arg2;
            this.mBinder = android.support.v4.media.session.IMediaSession$Stub.asInterface(arg2.getToken());
        }

        public void addQueueItem(MediaDescriptionCompat arg5) {
            try {
                if((this.mBinder.getFlags() & 4) == 0) {
                    throw new UnsupportedOperationException("This session doesn\'t support queue management operations");
                }

                this.mBinder.addQueueItem(arg5);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in addQueueItem.", ((Throwable)v0));
            }
        }

        public void addQueueItem(MediaDescriptionCompat arg5, int arg6) {
            try {
                if((this.mBinder.getFlags() & 4) == 0) {
                    throw new UnsupportedOperationException("This session doesn\'t support queue management operations");
                }

                this.mBinder.addQueueItemAt(arg5, arg6);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in addQueueItemAt.", ((Throwable)v0));
            }
        }

        public void adjustVolume(int arg4, int arg5) {
            try {
                this.mBinder.adjustVolume(arg4, arg5, null);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in adjustVolume.", ((Throwable)v0));
            }
        }

        public boolean dispatchMediaButtonEvent(KeyEvent arg4) {
            if(arg4 == null) {
                throw new IllegalArgumentException("event may not be null.");
            }

            try {
                this.mBinder.sendMediaButton(arg4);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", ((Throwable)v0));
            }

            return 0;
        }

        public Bundle getExtras() {
            Bundle v0_1;
            try {
                v0_1 = this.mBinder.getExtras();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in getExtras.", ((Throwable)v0));
                v0_1 = null;
            }

            return v0_1;
        }

        public long getFlags() {
            long v0_1;
            try {
                v0_1 = this.mBinder.getFlags();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in getFlags.", ((Throwable)v0));
                v0_1 = 0;
            }

            return v0_1;
        }

        public Object getMediaController() {
            return null;
        }

        public MediaMetadataCompat getMetadata() {
            MediaMetadataCompat v0_1;
            try {
                v0_1 = this.mBinder.getMetadata();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in getMetadata.", ((Throwable)v0));
                v0_1 = null;
            }

            return v0_1;
        }

        public String getPackageName() {
            String v0_1;
            try {
                v0_1 = this.mBinder.getPackageName();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in getPackageName.", ((Throwable)v0));
                v0_1 = null;
            }

            return v0_1;
        }

        public PlaybackInfo getPlaybackInfo() {
            PlaybackInfo v0_1;
            try {
                ParcelableVolumeInfo v5 = this.mBinder.getVolumeAttributes();
                v0_1 = new PlaybackInfo(v5.volumeType, v5.audioStream, v5.controlType, v5.maxVolume, v5.currentVolume);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo.", ((Throwable)v0));
                v0_1 = null;
            }

            return v0_1;
        }

        public PlaybackStateCompat getPlaybackState() {
            PlaybackStateCompat v0_1;
            try {
                v0_1 = this.mBinder.getPlaybackState();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", ((Throwable)v0));
                v0_1 = null;
            }

            return v0_1;
        }

        public List getQueue() {
            List v0_1;
            try {
                v0_1 = this.mBinder.getQueue();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in getQueue.", ((Throwable)v0));
                v0_1 = null;
            }

            return v0_1;
        }

        public CharSequence getQueueTitle() {
            CharSequence v0_1;
            try {
                v0_1 = this.mBinder.getQueueTitle();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in getQueueTitle.", ((Throwable)v0));
                v0_1 = null;
            }

            return v0_1;
        }

        public int getRatingType() {
            int v0_1;
            try {
                v0_1 = this.mBinder.getRatingType();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in getRatingType.", ((Throwable)v0));
                v0_1 = 0;
            }

            return v0_1;
        }

        public int getRepeatMode() {
            int v0_1;
            try {
                v0_1 = this.mBinder.getRepeatMode();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", ((Throwable)v0));
                v0_1 = 0;
            }

            return v0_1;
        }

        public PendingIntent getSessionActivity() {
            PendingIntent v0_1;
            try {
                v0_1 = this.mBinder.getLaunchPendingIntent();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in getSessionActivity.", ((Throwable)v0));
                v0_1 = null;
            }

            return v0_1;
        }

        public TransportControls getTransportControls() {
            if(this.mTransportControls == null) {
                this.mTransportControls = new TransportControlsBase(this.mBinder);
            }

            return this.mTransportControls;
        }

        public boolean isShuffleModeEnabled() {
            boolean v0_1;
            try {
                v0_1 = this.mBinder.isShuffleModeEnabled();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in isShuffleModeEnabled.", ((Throwable)v0));
                v0_1 = false;
            }

            return v0_1;
        }

        public void registerCallback(Callback arg4, Handler arg5) {
            if(arg4 == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }

            try {
                this.mBinder.asBinder().linkToDeath(((IBinder$DeathRecipient)arg4), 0);
                this.mBinder.registerCallbackListener(arg4.mCallbackObj);
                arg4.setHandler(arg5);
                arg4.mRegistered = true;
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", ((Throwable)v0));
                arg4.onSessionDestroyed();
            }
        }

        public void removeQueueItem(MediaDescriptionCompat arg5) {
            try {
                if((this.mBinder.getFlags() & 4) == 0) {
                    throw new UnsupportedOperationException("This session doesn\'t support queue management operations");
                }

                this.mBinder.removeQueueItem(arg5);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in removeQueueItem.", ((Throwable)v0));
            }
        }

        public void removeQueueItemAt(int arg5) {
            try {
                if((this.mBinder.getFlags() & 4) == 0) {
                    throw new UnsupportedOperationException("This session doesn\'t support queue management operations");
                }

                this.mBinder.removeQueueItemAt(arg5);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in removeQueueItemAt.", ((Throwable)v0));
            }
        }

        public void sendCommand(String arg4, Bundle arg5, ResultReceiver arg6) {
            try {
                this.mBinder.sendCommand(arg4, arg5, new ResultReceiverWrapper(arg6));
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in sendCommand.", ((Throwable)v0));
            }
        }

        public void setVolumeTo(int arg4, int arg5) {
            try {
                this.mBinder.setVolumeTo(arg4, arg5, null);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in setVolumeTo.", ((Throwable)v0));
            }
        }

        public void unregisterCallback(Callback arg4) {
            if(arg4 == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }

            try {
                this.mBinder.unregisterCallbackListener(arg4.mCallbackObj);
                this.mBinder.asBinder().unlinkToDeath(((IBinder$DeathRecipient)arg4), 0);
                arg4.mRegistered = false;
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", ((Throwable)v0));
            }
        }
    }

    public final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        private final int mAudioStream;
        private final int mCurrentVolume;
        private final int mMaxVolume;
        private final int mPlaybackType;
        private final int mVolumeControl;

        PlaybackInfo(int arg1, int arg2, int arg3, int arg4, int arg5) {
            super();
            this.mPlaybackType = arg1;
            this.mAudioStream = arg2;
            this.mVolumeControl = arg3;
            this.mMaxVolume = arg4;
            this.mCurrentVolume = arg5;
        }

        public int getAudioStream() {
            return this.mAudioStream;
        }

        public int getCurrentVolume() {
            return this.mCurrentVolume;
        }

        public int getMaxVolume() {
            return this.mMaxVolume;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public int getVolumeControl() {
            return this.mVolumeControl;
        }
    }

    public abstract class TransportControls {
        TransportControls() {
            super();
        }

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String arg1, Bundle arg2);

        public abstract void playFromSearch(String arg1, Bundle arg2);

        public abstract void playFromUri(Uri arg1, Bundle arg2);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String arg1, Bundle arg2);

        public abstract void prepareFromSearch(String arg1, Bundle arg2);

        public abstract void prepareFromUri(Uri arg1, Bundle arg2);

        public abstract void rewind();

        public abstract void seekTo(long arg1);

        public abstract void sendCustomAction(CustomAction arg1, Bundle arg2);

        public abstract void sendCustomAction(String arg1, Bundle arg2);

        public abstract void setRating(RatingCompat arg1);

        public abstract void setRepeatMode(int arg1);

        public abstract void setShuffleModeEnabled(boolean arg1);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long arg1);

        public abstract void stop();
    }

    class TransportControlsApi21 extends TransportControls {
        protected final Object mControlsObj;

        public TransportControlsApi21(Object arg1) {
            super();
            this.mControlsObj = arg1;
        }

        public void fastForward() {
            android.support.v4.media.session.MediaControllerCompatApi21$TransportControls.fastForward(this.mControlsObj);
        }

        public void pause() {
            android.support.v4.media.session.MediaControllerCompatApi21$TransportControls.pause(this.mControlsObj);
        }

        public void play() {
            android.support.v4.media.session.MediaControllerCompatApi21$TransportControls.play(this.mControlsObj);
        }

        public void playFromMediaId(String arg2, Bundle arg3) {
            android.support.v4.media.session.MediaControllerCompatApi21$TransportControls.playFromMediaId(this.mControlsObj, arg2, arg3);
        }

        public void playFromSearch(String arg2, Bundle arg3) {
            android.support.v4.media.session.MediaControllerCompatApi21$TransportControls.playFromSearch(this.mControlsObj, arg2, arg3);
        }

        public void playFromUri(Uri arg3, Bundle arg4) {
            if(arg3 != null && !Uri.EMPTY.equals(arg3)) {
                Bundle v0 = new Bundle();
                v0.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", ((Parcelable)arg3));
                v0.putParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS", ((Parcelable)arg4));
                this.sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", v0);
                return;
            }

            throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
        }

        public void prepare() {
            this.sendCustomAction("android.support.v4.media.session.action.PREPARE", null);
        }

        public void prepareFromMediaId(String arg3, Bundle arg4) {
            Bundle v0 = new Bundle();
            v0.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", arg3);
            v0.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", arg4);
            this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", v0);
        }

        public void prepareFromSearch(String arg3, Bundle arg4) {
            Bundle v0 = new Bundle();
            v0.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", arg3);
            v0.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", arg4);
            this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", v0);
        }

        public void prepareFromUri(Uri arg3, Bundle arg4) {
            Bundle v0 = new Bundle();
            v0.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", ((Parcelable)arg3));
            v0.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", arg4);
            this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_URI", v0);
        }

        public void rewind() {
            android.support.v4.media.session.MediaControllerCompatApi21$TransportControls.rewind(this.mControlsObj);
        }

        public void seekTo(long arg2) {
            android.support.v4.media.session.MediaControllerCompatApi21$TransportControls.seekTo(this.mControlsObj, arg2);
        }

        public void sendCustomAction(String arg2, Bundle arg3) {
            android.support.v4.media.session.MediaControllerCompatApi21$TransportControls.sendCustomAction(this.mControlsObj, arg2, arg3);
        }

        public void sendCustomAction(CustomAction arg3, Bundle arg4) {
            android.support.v4.media.session.MediaControllerCompatApi21$TransportControls.sendCustomAction(this.mControlsObj, arg3.getAction(), arg4);
        }

        public void setRating(RatingCompat arg3) {
            Object v1 = this.mControlsObj;
            Object v0 = arg3 != null ? arg3.getRating() : null;
            android.support.v4.media.session.MediaControllerCompatApi21$TransportControls.setRating(v1, v0);
        }

        public void setRepeatMode(int arg3) {
            Bundle v0 = new Bundle();
            v0.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", arg3);
            this.sendCustomAction("android.support.v4.media.session.action.SET_REPEAT_MODE", v0);
        }

        public void setShuffleModeEnabled(boolean arg3) {
            Bundle v0 = new Bundle();
            v0.putBoolean("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE_ENABLED", arg3);
            this.sendCustomAction("android.support.v4.media.session.action.SET_SHUFFLE_MODE_ENABLED", v0);
        }

        public void skipToNext() {
            android.support.v4.media.session.MediaControllerCompatApi21$TransportControls.skipToNext(this.mControlsObj);
        }

        public void skipToPrevious() {
            android.support.v4.media.session.MediaControllerCompatApi21$TransportControls.skipToPrevious(this.mControlsObj);
        }

        public void skipToQueueItem(long arg2) {
            android.support.v4.media.session.MediaControllerCompatApi21$TransportControls.skipToQueueItem(this.mControlsObj, arg2);
        }

        public void stop() {
            android.support.v4.media.session.MediaControllerCompatApi21$TransportControls.stop(this.mControlsObj);
        }
    }

    class TransportControlsApi23 extends TransportControlsApi21 {
        public TransportControlsApi23(Object arg1) {
            super(arg1);
        }

        public void playFromUri(Uri arg2, Bundle arg3) {
            android.support.v4.media.session.MediaControllerCompatApi23$TransportControls.playFromUri(this.mControlsObj, arg2, arg3);
        }
    }

    class TransportControlsApi24 extends TransportControlsApi23 {
        public TransportControlsApi24(Object arg1) {
            super(arg1);
        }

        public void prepare() {
            android.support.v4.media.session.MediaControllerCompatApi24$TransportControls.prepare(this.mControlsObj);
        }

        public void prepareFromMediaId(String arg2, Bundle arg3) {
            android.support.v4.media.session.MediaControllerCompatApi24$TransportControls.prepareFromMediaId(this.mControlsObj, arg2, arg3);
        }

        public void prepareFromSearch(String arg2, Bundle arg3) {
            android.support.v4.media.session.MediaControllerCompatApi24$TransportControls.prepareFromSearch(this.mControlsObj, arg2, arg3);
        }

        public void prepareFromUri(Uri arg2, Bundle arg3) {
            android.support.v4.media.session.MediaControllerCompatApi24$TransportControls.prepareFromUri(this.mControlsObj, arg2, arg3);
        }
    }

    class TransportControlsBase extends TransportControls {
        private IMediaSession mBinder;

        public TransportControlsBase(IMediaSession arg1) {
            super();
            this.mBinder = arg1;
        }

        public void fastForward() {
            try {
                this.mBinder.fastForward();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in fastForward.", ((Throwable)v0));
            }
        }

        public void pause() {
            try {
                this.mBinder.pause();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in pause.", ((Throwable)v0));
            }
        }

        public void play() {
            try {
                this.mBinder.play();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in play.", ((Throwable)v0));
            }
        }

        public void playFromMediaId(String arg4, Bundle arg5) {
            try {
                this.mBinder.playFromMediaId(arg4, arg5);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in playFromMediaId.", ((Throwable)v0));
            }
        }

        public void playFromSearch(String arg4, Bundle arg5) {
            try {
                this.mBinder.playFromSearch(arg4, arg5);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in playFromSearch.", ((Throwable)v0));
            }
        }

        public void playFromUri(Uri arg4, Bundle arg5) {
            try {
                this.mBinder.playFromUri(arg4, arg5);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in playFromUri.", ((Throwable)v0));
            }
        }

        public void prepare() {
            try {
                this.mBinder.prepare();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in prepare.", ((Throwable)v0));
            }
        }

        public void prepareFromMediaId(String arg4, Bundle arg5) {
            try {
                this.mBinder.prepareFromMediaId(arg4, arg5);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromMediaId.", ((Throwable)v0));
            }
        }

        public void prepareFromSearch(String arg4, Bundle arg5) {
            try {
                this.mBinder.prepareFromSearch(arg4, arg5);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromSearch.", ((Throwable)v0));
            }
        }

        public void prepareFromUri(Uri arg4, Bundle arg5) {
            try {
                this.mBinder.prepareFromUri(arg4, arg5);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromUri.", ((Throwable)v0));
            }
        }

        public void rewind() {
            try {
                this.mBinder.rewind();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in rewind.", ((Throwable)v0));
            }
        }

        public void seekTo(long arg4) {
            try {
                this.mBinder.seekTo(arg4);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in seekTo.", ((Throwable)v0));
            }
        }

        public void sendCustomAction(CustomAction arg2, Bundle arg3) {
            this.sendCustomAction(arg2.getAction(), arg3);
        }

        public void sendCustomAction(String arg4, Bundle arg5) {
            try {
                this.mBinder.sendCustomAction(arg4, arg5);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in sendCustomAction.", ((Throwable)v0));
            }
        }

        public void setRating(RatingCompat arg4) {
            try {
                this.mBinder.rate(arg4);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in setRating.", ((Throwable)v0));
            }
        }

        public void setRepeatMode(int arg4) {
            try {
                this.mBinder.setRepeatMode(arg4);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in setRepeatMode.", ((Throwable)v0));
            }
        }

        public void setShuffleModeEnabled(boolean arg4) {
            try {
                this.mBinder.setShuffleModeEnabled(arg4);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in setShuffleModeEnabled.", ((Throwable)v0));
            }
        }

        public void skipToNext() {
            try {
                this.mBinder.next();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in skipToNext.", ((Throwable)v0));
            }
        }

        public void skipToPrevious() {
            try {
                this.mBinder.previous();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in skipToPrevious.", ((Throwable)v0));
            }
        }

        public void skipToQueueItem(long arg4) {
            try {
                this.mBinder.skipToQueueItem(arg4);
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in skipToQueueItem.", ((Throwable)v0));
            }
        }

        public void stop() {
            try {
                this.mBinder.stop();
            }
            catch(RemoteException v0) {
                Log.e("MediaControllerCompat", "Dead object in stop.", ((Throwable)v0));
            }
        }
    }

    static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    static final String TAG = "MediaControllerCompat";
    private final MediaControllerImpl mImpl;
    private final Token mToken;

    public MediaControllerCompat(Context arg3, Token arg4) {
        super();
        if(arg4 == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }

        this.mToken = arg4;
        if(Build$VERSION.SDK_INT >= 24) {
            this.mImpl = new MediaControllerImplApi24(arg3, arg4);
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaControllerImplApi23(arg3, arg4);
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerImplApi21(arg3, arg4);
        }
        else {
            this.mImpl = new MediaControllerImplBase(this.mToken);
        }
    }

    public MediaControllerCompat(Context arg3, MediaSessionCompat arg4) {
        super();
        if(arg4 == null) {
            throw new IllegalArgumentException("session must not be null");
        }

        this.mToken = arg4.getSessionToken();
        if(Build$VERSION.SDK_INT >= 24) {
            this.mImpl = new MediaControllerImplApi24(arg3, arg4);
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaControllerImplApi23(arg3, arg4);
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerImplApi21(arg3, arg4);
        }
        else {
            this.mImpl = new MediaControllerImplBase(this.mToken);
        }
    }

    public void addQueueItem(MediaDescriptionCompat arg2) {
        this.mImpl.addQueueItem(arg2);
    }

    public void addQueueItem(MediaDescriptionCompat arg2, int arg3) {
        this.mImpl.addQueueItem(arg2, arg3);
    }

    public void adjustVolume(int arg2, int arg3) {
        this.mImpl.adjustVolume(arg2, arg3);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent arg3) {
        if(arg3 == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }

        return this.mImpl.dispatchMediaButtonEvent(arg3);
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public long getFlags() {
        return this.mImpl.getFlags();
    }

    public static MediaControllerCompat getMediaController(Activity arg4) {
        MediaControllerCompat v1 = null;
        if((arg4 instanceof SupportActivity)) {
            ExtraData v0 = ((SupportActivity)arg4).getExtraData(MediaControllerExtraData.class);
            MediaControllerCompat v0_1 = v0 != null ? ((MediaControllerExtraData)v0).getMediaController() : v1;
            return v0_1;
        }

        if(Build$VERSION.SDK_INT >= 21) {
            Object v0_2 = MediaControllerCompatApi21.getMediaController(arg4);
            if(v0_2 == null) {
                return v1;
            }

            Object v2 = MediaControllerCompatApi21.getSessionToken(v0_2);
            try {
                v1 = new MediaControllerCompat(((Context)arg4), Token.fromToken(v2));
            }
            catch(RemoteException v0_3) {
                Log.e("MediaControllerCompat", "Dead object in getMediaController.", ((Throwable)v0_3));
            }
        }

        return v1;
    }

    public Object getMediaController() {
        return this.mImpl.getMediaController();
    }

    public MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public List getQueue() {
        return this.mImpl.getQueue();
    }

    public CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }

    public int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public int getRepeatMode() {
        return this.mImpl.getRepeatMode();
    }

    public PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }

    public Token getSessionToken() {
        return this.mToken;
    }

    public TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    @VisibleForTesting boolean isExtraBinderReady() {
        boolean v0;
        if(!(this.mImpl instanceof MediaControllerImplApi21)) {
            v0 = false;
        }
        else if(MediaControllerImplApi21.access$000(this.mImpl) != null) {
            v0 = true;
        }
        else {
            v0 = false;
        }

        return v0;
    }

    public boolean isShuffleModeEnabled() {
        return this.mImpl.isShuffleModeEnabled();
    }

    public void registerCallback(Callback arg2) {
        this.registerCallback(arg2, null);
    }

    public void registerCallback(Callback arg3, Handler arg4) {
        if(arg3 == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }

        if(arg4 == null) {
            arg4 = new Handler();
        }

        this.mImpl.registerCallback(arg3, arg4);
    }

    public void removeQueueItem(MediaDescriptionCompat arg2) {
        this.mImpl.removeQueueItem(arg2);
    }

    public void removeQueueItemAt(int arg2) {
        this.mImpl.removeQueueItemAt(arg2);
    }

    public void sendCommand(String arg3, Bundle arg4, ResultReceiver arg5) {
        if(TextUtils.isEmpty(((CharSequence)arg3))) {
            throw new IllegalArgumentException("command cannot be null or empty");
        }

        this.mImpl.sendCommand(arg3, arg4, arg5);
    }

    public static void setMediaController(Activity arg2, MediaControllerCompat arg3) {
        if((arg2 instanceof SupportActivity)) {
            arg2.putExtraData(new MediaControllerExtraData(arg3));
        }

        if(Build$VERSION.SDK_INT >= 21) {
            Object v0 = null;
            if(arg3 != null) {
                v0 = MediaControllerCompatApi21.fromToken(((Context)arg2), arg3.getSessionToken().getToken());
            }

            MediaControllerCompatApi21.setMediaController(arg2, v0);
        }
    }

    public void setVolumeTo(int arg2, int arg3) {
        this.mImpl.setVolumeTo(arg2, arg3);
    }

    public void unregisterCallback(Callback arg3) {
        if(arg3 == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }

        this.mImpl.unregisterCallback(arg3);
    }
}

