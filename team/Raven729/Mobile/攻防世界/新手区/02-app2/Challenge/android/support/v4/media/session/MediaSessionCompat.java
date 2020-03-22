package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaSessionCompat {
    public abstract class Callback {
        class StubApi21 implements android.support.v4.media.session.MediaSessionCompatApi21$Callback {
            StubApi21(Callback arg1) {
                Callback.this = arg1;
                super();
            }

            public void onCommand(String arg4, Bundle arg5, ResultReceiver arg6) {
                if(arg4.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                    Object v0 = Callback.this.mSessionImpl.get();
                    if(v0 != null) {
                        Bundle v1 = new Bundle();
                        BundleCompat.putBinder(v1, "android.support.v4.media.session.EXTRA_BINDER", ((MediaSessionImplApi21)v0).getExtraSessionBinder());
                        arg6.send(0, v1);
                    }
                }
                else if(arg4.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                    arg5.setClassLoader(MediaDescriptionCompat.class.getClassLoader());
                    Callback.this.onAddQueueItem(arg5.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                }
                else if(arg4.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                    arg5.setClassLoader(MediaDescriptionCompat.class.getClassLoader());
                    Callback.this.onAddQueueItem(arg5.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), arg5.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                }
                else if(arg4.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                    arg5.setClassLoader(MediaDescriptionCompat.class.getClassLoader());
                    Callback.this.onRemoveQueueItem(arg5.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                }
                else if(arg4.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                    Callback.this.onRemoveQueueItemAt(arg5.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                }
                else {
                    Callback.this.onCommand(arg4, arg5, arg6);
                }
            }

            public void onCustomAction(String arg4, Bundle arg5) {
                if(arg4.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                    Callback.this.onPlayFromUri(arg5.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), arg5.getParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                }
                else if(arg4.equals("android.support.v4.media.session.action.PREPARE")) {
                    Callback.this.onPrepare();
                }
                else if(arg4.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                    Callback.this.onPrepareFromMediaId(arg5.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID"), arg5.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                }
                else if(arg4.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                    Callback.this.onPrepareFromSearch(arg5.getString("android.support.v4.media.session.action.ARGUMENT_QUERY"), arg5.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                }
                else if(arg4.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                    Callback.this.onPrepareFromUri(arg5.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), arg5.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                }
                else if(arg4.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                    Callback.this.onSetRepeatMode(arg5.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                }
                else if(arg4.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE_ENABLED")) {
                    Callback.this.onSetShuffleModeEnabled(arg5.getBoolean("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE_ENABLED"));
                }
                else {
                    Callback.this.onCustomAction(arg4, arg5);
                }
            }

            public void onFastForward() {
                Callback.this.onFastForward();
            }

            public boolean onMediaButtonEvent(Intent arg2) {
                return Callback.this.onMediaButtonEvent(arg2);
            }

            public void onPause() {
                Callback.this.onPause();
            }

            public void onPlay() {
                Callback.this.onPlay();
            }

            public void onPlayFromMediaId(String arg2, Bundle arg3) {
                Callback.this.onPlayFromMediaId(arg2, arg3);
            }

            public void onPlayFromSearch(String arg2, Bundle arg3) {
                Callback.this.onPlayFromSearch(arg2, arg3);
            }

            public void onRewind() {
                Callback.this.onRewind();
            }

            public void onSeekTo(long arg2) {
                Callback.this.onSeekTo(arg2);
            }

            public void onSetRating(Object arg3) {
                Callback.this.onSetRating(RatingCompat.fromRating(arg3));
            }

            public void onSkipToNext() {
                Callback.this.onSkipToNext();
            }

            public void onSkipToPrevious() {
                Callback.this.onSkipToPrevious();
            }

            public void onSkipToQueueItem(long arg2) {
                Callback.this.onSkipToQueueItem(arg2);
            }

            public void onStop() {
                Callback.this.onStop();
            }
        }

        class StubApi23 extends StubApi21 implements android.support.v4.media.session.MediaSessionCompatApi23$Callback {
            StubApi23(Callback arg1) {
                Callback.this = arg1;
                super(arg1);
            }

            public void onPlayFromUri(Uri arg2, Bundle arg3) {
                Callback.this.onPlayFromUri(arg2, arg3);
            }
        }

        class StubApi24 extends StubApi23 implements android.support.v4.media.session.MediaSessionCompatApi24$Callback {
            StubApi24(Callback arg1) {
                Callback.this = arg1;
                super(arg1);
            }

            public void onPrepare() {
                Callback.this.onPrepare();
            }

            public void onPrepareFromMediaId(String arg2, Bundle arg3) {
                Callback.this.onPrepareFromMediaId(arg2, arg3);
            }

            public void onPrepareFromSearch(String arg2, Bundle arg3) {
                Callback.this.onPrepareFromSearch(arg2, arg3);
            }

            public void onPrepareFromUri(Uri arg2, Bundle arg3) {
                Callback.this.onPrepareFromUri(arg2, arg3);
            }
        }

        final Object mCallbackObj;
        WeakReference mSessionImpl;

        public Callback() {
            super();
            if(Build$VERSION.SDK_INT >= 24) {
                this.mCallbackObj = MediaSessionCompatApi24.createCallback(new StubApi24(this));
            }
            else if(Build$VERSION.SDK_INT >= 23) {
                this.mCallbackObj = MediaSessionCompatApi23.createCallback(new StubApi23(this));
            }
            else if(Build$VERSION.SDK_INT >= 21) {
                this.mCallbackObj = MediaSessionCompatApi21.createCallback(new StubApi21(this));
            }
            else {
                this.mCallbackObj = null;
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat arg1) {
        }

        public void onAddQueueItem(MediaDescriptionCompat arg1, int arg2) {
        }

        public void onCommand(String arg1, Bundle arg2, ResultReceiver arg3) {
        }

        public void onCustomAction(String arg1, Bundle arg2) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent arg2) {
            return 0;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String arg1, Bundle arg2) {
        }

        public void onPlayFromSearch(String arg1, Bundle arg2) {
        }

        public void onPlayFromUri(Uri arg1, Bundle arg2) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String arg1, Bundle arg2) {
        }

        public void onPrepareFromSearch(String arg1, Bundle arg2) {
        }

        public void onPrepareFromUri(Uri arg1, Bundle arg2) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat arg1) {
        }

        public void onRemoveQueueItemAt(int arg1) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long arg1) {
        }

        public void onSetRating(RatingCompat arg1) {
        }

        public void onSetRepeatMode(int arg1) {
        }

        public void onSetShuffleModeEnabled(boolean arg1) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long arg1) {
        }

        public void onStop() {
        }
    }

    interface MediaSessionImpl {
        String getCallingPackage();

        Object getMediaSession();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String arg1, Bundle arg2);

        void setActive(boolean arg1);

        void setCallback(Callback arg1, Handler arg2);

        void setExtras(Bundle arg1);

        void setFlags(int arg1);

        void setMediaButtonReceiver(PendingIntent arg1);

        void setMetadata(MediaMetadataCompat arg1);

        void setPlaybackState(PlaybackStateCompat arg1);

        void setPlaybackToLocal(int arg1);

        void setPlaybackToRemote(VolumeProviderCompat arg1);

        void setQueue(List arg1);

        void setQueueTitle(CharSequence arg1);

        void setRatingType(int arg1);

        void setRepeatMode(int arg1);

        void setSessionActivity(PendingIntent arg1);

        void setShuffleModeEnabled(boolean arg1);
    }

    class MediaSessionImplApi21 implements MediaSessionImpl {
        class ExtraSession extends Stub {
            ExtraSession(MediaSessionImplApi21 arg1) {
                MediaSessionImplApi21.this = arg1;
                super();
            }

            public void addQueueItem(MediaDescriptionCompat arg2) {
                throw new AssertionError();
            }

            public void addQueueItemAt(MediaDescriptionCompat arg2, int arg3) {
                throw new AssertionError();
            }

            public void adjustVolume(int arg2, int arg3, String arg4) {
                throw new AssertionError();
            }

            public void fastForward() {
                throw new AssertionError();
            }

            public Bundle getExtras() {
                throw new AssertionError();
            }

            public long getFlags() {
                throw new AssertionError();
            }

            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            public String getPackageName() {
                throw new AssertionError();
            }

            public PlaybackStateCompat getPlaybackState() {
                return MediaSessionImplApi21.this.mPlaybackState;
            }

            public List getQueue() {
                return null;
            }

            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            public int getRatingType() {
                return MediaSessionImplApi21.this.mRatingType;
            }

            public int getRepeatMode() {
                return MediaSessionImplApi21.this.mRepeatMode;
            }

            public String getTag() {
                throw new AssertionError();
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            public boolean isShuffleModeEnabled() {
                return MediaSessionImplApi21.this.mShuffleModeEnabled;
            }

            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }

            public void next() {
                throw new AssertionError();
            }

            public void pause() {
                throw new AssertionError();
            }

            public void play() {
                throw new AssertionError();
            }

            public void playFromMediaId(String arg2, Bundle arg3) {
                throw new AssertionError();
            }

            public void playFromSearch(String arg2, Bundle arg3) {
                throw new AssertionError();
            }

            public void playFromUri(Uri arg2, Bundle arg3) {
                throw new AssertionError();
            }

            public void prepare() {
                throw new AssertionError();
            }

            public void prepareFromMediaId(String arg2, Bundle arg3) {
                throw new AssertionError();
            }

            public void prepareFromSearch(String arg2, Bundle arg3) {
                throw new AssertionError();
            }

            public void prepareFromUri(Uri arg2, Bundle arg3) {
                throw new AssertionError();
            }

            public void previous() {
                throw new AssertionError();
            }

            public void rate(RatingCompat arg2) {
                throw new AssertionError();
            }

            public void registerCallbackListener(IMediaControllerCallback arg2) {
                if(!MediaSessionImplApi21.this.mDestroyed) {
                    MediaSessionImplApi21.this.mExtraControllerCallbacks.register(((IInterface)arg2));
                }
            }

            public void removeQueueItem(MediaDescriptionCompat arg2) {
                throw new AssertionError();
            }

            public void removeQueueItemAt(int arg2) {
                throw new AssertionError();
            }

            public void rewind() {
                throw new AssertionError();
            }

            public void seekTo(long arg2) {
                throw new AssertionError();
            }

            public void sendCommand(String arg2, Bundle arg3, ResultReceiverWrapper arg4) {
                throw new AssertionError();
            }

            public void sendCustomAction(String arg2, Bundle arg3) {
                throw new AssertionError();
            }

            public boolean sendMediaButton(KeyEvent arg2) {
                throw new AssertionError();
            }

            public void setRepeatMode(int arg2) {
                throw new AssertionError();
            }

            public void setShuffleModeEnabled(boolean arg2) {
                throw new AssertionError();
            }

            public void setVolumeTo(int arg2, int arg3, String arg4) {
                throw new AssertionError();
            }

            public void skipToQueueItem(long arg2) {
                throw new AssertionError();
            }

            public void stop() {
                throw new AssertionError();
            }

            public void unregisterCallbackListener(IMediaControllerCallback arg2) {
                MediaSessionImplApi21.this.mExtraControllerCallbacks.unregister(((IInterface)arg2));
            }
        }

        private boolean mDestroyed;
        private final RemoteCallbackList mExtraControllerCallbacks;
        private ExtraSession mExtraSessionBinder;
        private PlaybackStateCompat mPlaybackState;
        int mRatingType;
        int mRepeatMode;
        private final Object mSessionObj;
        boolean mShuffleModeEnabled;
        private final Token mToken;

        public MediaSessionImplApi21(Context arg3, String arg4) {
            super();
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            this.mSessionObj = MediaSessionCompatApi21.createSession(arg3, arg4);
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj));
        }

        public MediaSessionImplApi21(Object arg3) {
            super();
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            this.mSessionObj = MediaSessionCompatApi21.verifySession(arg3);
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj));
        }

        static boolean access$100(MediaSessionImplApi21 arg1) {
            return arg1.mDestroyed;
        }

        static RemoteCallbackList access$200(MediaSessionImplApi21 arg1) {
            return arg1.mExtraControllerCallbacks;
        }

        static PlaybackStateCompat access$300(MediaSessionImplApi21 arg1) {
            return arg1.mPlaybackState;
        }

        public String getCallingPackage() {
            String v0 = Build$VERSION.SDK_INT < 24 ? null : MediaSessionCompatApi24.getCallingPackage(this.mSessionObj);
            return v0;
        }

        ExtraSession getExtraSessionBinder() {
            if(this.mExtraSessionBinder == null) {
                this.mExtraSessionBinder = new ExtraSession(this);
            }

            return this.mExtraSessionBinder;
        }

        public Object getMediaSession() {
            return this.mSessionObj;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return MediaSessionCompatApi21.isActive(this.mSessionObj);
        }

        public void release() {
            this.mDestroyed = true;
            MediaSessionCompatApi21.release(this.mSessionObj);
        }

        public void sendSessionEvent(String arg3, Bundle arg4) {
            if(Build$VERSION.SDK_INT < 23) {
                int v1;
                for(v1 = this.mExtraControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IInterface v0 = this.mExtraControllerCallbacks.getBroadcastItem(v1);
                    try {
                        ((IMediaControllerCallback)v0).onEvent(arg3, arg4);
                    }
                    catch(RemoteException v0_1) {
                    }
                }

                this.mExtraControllerCallbacks.finishBroadcast();
            }

            MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, arg3, arg4);
        }

        public void setActive(boolean arg2) {
            MediaSessionCompatApi21.setActive(this.mSessionObj, arg2);
        }

        public void setCallback(Callback arg3, Handler arg4) {
            Object v1 = this.mSessionObj;
            Object v0 = arg3 == null ? null : arg3.mCallbackObj;
            MediaSessionCompatApi21.setCallback(v1, v0, arg4);
            if(arg3 != null) {
                arg3.mSessionImpl = new WeakReference(this);
            }
        }

        public void setExtras(Bundle arg2) {
            MediaSessionCompatApi21.setExtras(this.mSessionObj, arg2);
        }

        public void setFlags(int arg2) {
            MediaSessionCompatApi21.setFlags(this.mSessionObj, arg2);
        }

        public void setMediaButtonReceiver(PendingIntent arg2) {
            MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, arg2);
        }

        public void setMetadata(MediaMetadataCompat arg3) {
            Object v1 = this.mSessionObj;
            Object v0 = arg3 == null ? null : arg3.getMediaMetadata();
            MediaSessionCompatApi21.setMetadata(v1, v0);
        }

        public void setPlaybackState(PlaybackStateCompat arg3) {
            this.mPlaybackState = arg3;
            int v1;
            for(v1 = this.mExtraControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                IInterface v0 = this.mExtraControllerCallbacks.getBroadcastItem(v1);
                try {
                    ((IMediaControllerCallback)v0).onPlaybackStateChanged(arg3);
                }
                catch(RemoteException v0_1) {
                }
            }

            this.mExtraControllerCallbacks.finishBroadcast();
            Object v1_1 = this.mSessionObj;
            Object v0_2 = arg3 == null ? null : arg3.getPlaybackState();
            MediaSessionCompatApi21.setPlaybackState(v1_1, v0_2);
        }

        public void setPlaybackToLocal(int arg2) {
            MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, arg2);
        }

        public void setPlaybackToRemote(VolumeProviderCompat arg3) {
            MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, arg3.getVolumeProvider());
        }

        public void setQueue(List arg4) {
            List v0 = null;
            if(arg4 != null) {
                ArrayList v1 = new ArrayList();
                Iterator v2 = arg4.iterator();
                while(v2.hasNext()) {
                    ((List)v1).add(v2.next().getQueueItem());
                }

                ArrayList v0_1 = v1;
            }

            MediaSessionCompatApi21.setQueue(this.mSessionObj, v0);
        }

        public void setQueueTitle(CharSequence arg2) {
            MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, arg2);
        }

        public void setRatingType(int arg3) {
            if(Build$VERSION.SDK_INT < 22) {
                this.mRatingType = arg3;
            }
            else {
                MediaSessionCompatApi22.setRatingType(this.mSessionObj, arg3);
            }
        }

        public void setRepeatMode(int arg3) {
            if(this.mRepeatMode != arg3) {
                this.mRepeatMode = arg3;
                int v1;
                for(v1 = this.mExtraControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IInterface v0 = this.mExtraControllerCallbacks.getBroadcastItem(v1);
                    try {
                        ((IMediaControllerCallback)v0).onRepeatModeChanged(arg3);
                    }
                    catch(RemoteException v0_1) {
                    }
                }

                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }

        public void setSessionActivity(PendingIntent arg2) {
            MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, arg2);
        }

        public void setShuffleModeEnabled(boolean arg3) {
            if(this.mShuffleModeEnabled != arg3) {
                this.mShuffleModeEnabled = arg3;
                int v1;
                for(v1 = this.mExtraControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IInterface v0 = this.mExtraControllerCallbacks.getBroadcastItem(v1);
                    try {
                        ((IMediaControllerCallback)v0).onShuffleModeChanged(arg3);
                    }
                    catch(RemoteException v0_1) {
                    }
                }

                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }
    }

    class MediaSessionImplBase implements MediaSessionImpl {
        class android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$1 extends android.support.v4.media.VolumeProviderCompat$Callback {
            android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$1(MediaSessionImplBase arg1) {
                MediaSessionImplBase.this = arg1;
                super();
            }

            public void onVolumeChanged(VolumeProviderCompat arg7) {
                if(MediaSessionImplBase.this.mVolumeProvider == arg7) {
                    MediaSessionImplBase.this.sendVolumeInfoChanged(new ParcelableVolumeInfo(MediaSessionImplBase.this.mVolumeType, MediaSessionImplBase.this.mLocalStream, arg7.getVolumeControl(), arg7.getMaxVolume(), arg7.getCurrentVolume()));
                }
            }
        }

        final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String arg1, Bundle arg2, ResultReceiver arg3) {
                super();
                this.command = arg1;
                this.extras = arg2;
                this.stub = arg3;
            }
        }

        class MediaSessionStub extends Stub {
            MediaSessionStub(MediaSessionImplBase arg1) {
                MediaSessionImplBase.this = arg1;
                super();
            }

            public void addQueueItem(MediaDescriptionCompat arg3) {
                MediaSessionImplBase.this.postToHandler(25, arg3);
            }

            public void addQueueItemAt(MediaDescriptionCompat arg3, int arg4) {
                MediaSessionImplBase.this.postToHandler(26, arg3, arg4);
            }

            public void adjustVolume(int arg2, int arg3, String arg4) {
                MediaSessionImplBase.this.adjustVolume(arg2, arg3);
            }

            public void fastForward() {
                MediaSessionImplBase.this.postToHandler(16);
            }

            public Bundle getExtras() {
                Object v1 = MediaSessionImplBase.this.mLock;
                __monitor_enter(v1);
                try {
                    __monitor_exit(v1);
                    return MediaSessionImplBase.this.mExtras;
                label_8:
                    __monitor_exit(v1);
                }
                catch(Throwable v0) {
                    goto label_8;
                }

                throw v0;
            }

            public long getFlags() {
                Object v1 = MediaSessionImplBase.this.mLock;
                __monitor_enter(v1);
                try {
                    __monitor_exit(v1);
                    return ((long)MediaSessionImplBase.this.mFlags);
                label_9:
                    __monitor_exit(v1);
                }
                catch(Throwable v0) {
                    goto label_9;
                }

                throw v0;
            }

            public PendingIntent getLaunchPendingIntent() {
                Object v1 = MediaSessionImplBase.this.mLock;
                __monitor_enter(v1);
                try {
                    __monitor_exit(v1);
                    return MediaSessionImplBase.this.mSessionActivity;
                label_8:
                    __monitor_exit(v1);
                }
                catch(Throwable v0) {
                    goto label_8;
                }

                throw v0;
            }

            public MediaMetadataCompat getMetadata() {
                return MediaSessionImplBase.this.mMetadata;
            }

            public String getPackageName() {
                return MediaSessionImplBase.this.mPackageName;
            }

            public PlaybackStateCompat getPlaybackState() {
                return MediaSessionImplBase.this.getStateWithUpdatedPosition();
            }

            public List getQueue() {
                Object v1 = MediaSessionImplBase.this.mLock;
                __monitor_enter(v1);
                try {
                    __monitor_exit(v1);
                    return MediaSessionImplBase.this.mQueue;
                label_8:
                    __monitor_exit(v1);
                }
                catch(Throwable v0) {
                    goto label_8;
                }

                throw v0;
            }

            public CharSequence getQueueTitle() {
                return MediaSessionImplBase.this.mQueueTitle;
            }

            public int getRatingType() {
                return MediaSessionImplBase.this.mRatingType;
            }

            public int getRepeatMode() {
                return MediaSessionImplBase.this.mRepeatMode;
            }

            public String getTag() {
                return MediaSessionImplBase.this.mTag;
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                int v5;
                int v4;
                int v2;
                int v1;
                int v3 = 2;
                Object v6 = MediaSessionImplBase.this.mLock;
                __monitor_enter(v6);
                try {
                    v1 = MediaSessionImplBase.this.mVolumeType;
                    v2 = MediaSessionImplBase.this.mLocalStream;
                    VolumeProviderCompat v0_1 = MediaSessionImplBase.this.mVolumeProvider;
                    if(v1 == v3) {
                        v3 = v0_1.getVolumeControl();
                        v4 = v0_1.getMaxVolume();
                        v5 = v0_1.getCurrentVolume();
                    }
                    else {
                        v4 = MediaSessionImplBase.this.mAudioManager.getStreamMaxVolume(v2);
                        v5 = MediaSessionImplBase.this.mAudioManager.getStreamVolume(v2);
                    }

                    __monitor_exit(v6);
                    goto label_15;
                label_26:
                    __monitor_exit(v6);
                }
                catch(Throwable v0) {
                    goto label_26;
                }

                throw v0;
            label_15:
                return new ParcelableVolumeInfo(v1, v2, v3, v4, v5);
            }

            public boolean isShuffleModeEnabled() {
                return MediaSessionImplBase.this.mShuffleModeEnabled;
            }

            public boolean isTransportControlEnabled() {
                boolean v0 = (MediaSessionImplBase.this.mFlags & 2) != 0 ? true : false;
                return v0;
            }

            public void next() {
                MediaSessionImplBase.this.postToHandler(14);
            }

            public void pause() {
                MediaSessionImplBase.this.postToHandler(12);
            }

            public void play() {
                MediaSessionImplBase.this.postToHandler(7);
            }

            public void playFromMediaId(String arg3, Bundle arg4) {
                MediaSessionImplBase.this.postToHandler(8, arg3, arg4);
            }

            public void playFromSearch(String arg3, Bundle arg4) {
                MediaSessionImplBase.this.postToHandler(9, arg3, arg4);
            }

            public void playFromUri(Uri arg3, Bundle arg4) {
                MediaSessionImplBase.this.postToHandler(10, arg3, arg4);
            }

            public void prepare() {
                MediaSessionImplBase.this.postToHandler(3);
            }

            public void prepareFromMediaId(String arg3, Bundle arg4) {
                MediaSessionImplBase.this.postToHandler(4, arg3, arg4);
            }

            public void prepareFromSearch(String arg3, Bundle arg4) {
                MediaSessionImplBase.this.postToHandler(5, arg3, arg4);
            }

            public void prepareFromUri(Uri arg3, Bundle arg4) {
                MediaSessionImplBase.this.postToHandler(6, arg3, arg4);
            }

            public void previous() {
                MediaSessionImplBase.this.postToHandler(15);
            }

            public void rate(RatingCompat arg3) {
                MediaSessionImplBase.this.postToHandler(19, arg3);
            }

            public void registerCallbackListener(IMediaControllerCallback arg2) {
                if(MediaSessionImplBase.this.mDestroyed) {
                    try {
                        arg2.onSessionDestroyed();
                    }
                    catch(Exception v0) {
                    }
                }
                else {
                    MediaSessionImplBase.this.mControllerCallbacks.register(((IInterface)arg2));
                }
            }

            public void removeQueueItem(MediaDescriptionCompat arg3) {
                MediaSessionImplBase.this.postToHandler(27, arg3);
            }

            public void removeQueueItemAt(int arg3) {
                MediaSessionImplBase.this.postToHandler(28, arg3);
            }

            public void rewind() {
                MediaSessionImplBase.this.postToHandler(17);
            }

            public void seekTo(long arg4) {
                MediaSessionImplBase.this.postToHandler(18, Long.valueOf(arg4));
            }

            public void sendCommand(String arg5, Bundle arg6, ResultReceiverWrapper arg7) {
                MediaSessionImplBase.this.postToHandler(1, new Command(arg5, arg6, ResultReceiverWrapper.access$000(arg7)));
            }

            public void sendCustomAction(String arg3, Bundle arg4) {
                MediaSessionImplBase.this.postToHandler(20, arg3, arg4);
            }

            public boolean sendMediaButton(KeyEvent arg4) {
                boolean v0 = (MediaSessionImplBase.this.mFlags & 1) != 0 ? true : false;
                if(v0) {
                    MediaSessionImplBase.this.postToHandler(21, arg4);
                }

                return v0;
            }

            public void setRepeatMode(int arg3) {
                MediaSessionImplBase.this.postToHandler(23, arg3);
            }

            public void setShuffleModeEnabled(boolean arg4) {
                MediaSessionImplBase.this.postToHandler(24, Boolean.valueOf(arg4));
            }

            public void setVolumeTo(int arg2, int arg3, String arg4) {
                MediaSessionImplBase.this.setVolumeTo(arg2, arg3);
            }

            public void skipToQueueItem(long arg4) {
                MediaSessionImplBase.this.postToHandler(11, Long.valueOf(arg4));
            }

            public void stop() {
                MediaSessionImplBase.this.postToHandler(13);
            }

            public void unregisterCallbackListener(IMediaControllerCallback arg2) {
                MediaSessionImplBase.this.mControllerCallbacks.unregister(((IInterface)arg2));
            }
        }

        class MessageHandler extends Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 0x7F;
            private static final int KEYCODE_MEDIA_PLAY = 0x7E;
            private static final int MSG_ADD_QUEUE_ITEM = 25;
            private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            private static final int MSG_ADJUST_VOLUME = 2;
            private static final int MSG_COMMAND = 1;
            private static final int MSG_CUSTOM_ACTION = 20;
            private static final int MSG_FAST_FORWARD = 16;
            private static final int MSG_MEDIA_BUTTON = 21;
            private static final int MSG_NEXT = 14;
            private static final int MSG_PAUSE = 12;
            private static final int MSG_PLAY = 7;
            private static final int MSG_PLAY_MEDIA_ID = 8;
            private static final int MSG_PLAY_SEARCH = 9;
            private static final int MSG_PLAY_URI = 10;
            private static final int MSG_PREPARE = 3;
            private static final int MSG_PREPARE_MEDIA_ID = 4;
            private static final int MSG_PREPARE_SEARCH = 5;
            private static final int MSG_PREPARE_URI = 6;
            private static final int MSG_PREVIOUS = 15;
            private static final int MSG_RATE = 19;
            private static final int MSG_REMOVE_QUEUE_ITEM = 27;
            private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            private static final int MSG_REWIND = 17;
            private static final int MSG_SEEK_TO = 18;
            private static final int MSG_SET_REPEAT_MODE = 23;
            private static final int MSG_SET_SHUFFLE_MODE_ENABLED = 24;
            private static final int MSG_SET_VOLUME = 22;
            private static final int MSG_SKIP_TO_ITEM = 11;
            private static final int MSG_STOP = 13;

            public MessageHandler(MediaSessionImplBase arg1, Looper arg2) {
                MediaSessionImplBase.this = arg1;
                super(arg2);
            }

            public void handleMessage(Message arg5) {
                Callback v1 = MediaSessionImplBase.this.mCallback;
                if(v1 != null) {
                    switch(arg5.what) {
                        case 1: {
                            goto label_8;
                        }
                        case 2: {
                            goto label_92;
                        }
                        case 3: {
                            goto label_24;
                        }
                        case 4: {
                            goto label_26;
                        }
                        case 5: {
                            goto label_30;
                        }
                        case 6: {
                            goto label_34;
                        }
                        case 7: {
                            goto label_38;
                        }
                        case 8: {
                            goto label_40;
                        }
                        case 9: {
                            goto label_44;
                        }
                        case 10: {
                            goto label_48;
                        }
                        case 11: {
                            goto label_52;
                        }
                        case 12: {
                            goto label_56;
                        }
                        case 13: {
                            goto label_58;
                        }
                        case 14: {
                            goto label_60;
                        }
                        case 15: {
                            goto label_62;
                        }
                        case 16: {
                            goto label_64;
                        }
                        case 17: {
                            goto label_66;
                        }
                        case 18: {
                            goto label_68;
                        }
                        case 19: {
                            goto label_72;
                        }
                        case 20: {
                            goto label_75;
                        }
                        case 21: {
                            goto label_14;
                        }
                        case 22: {
                            goto label_96;
                        }
                        case 23: {
                            goto label_100;
                        }
                        case 24: {
                            goto label_103;
                        }
                        case 25: {
                            goto label_79;
                        }
                        case 26: {
                            goto label_82;
                        }
                        case 27: {
                            goto label_86;
                        }
                        case 28: {
                            goto label_89;
                        }
                    }

                    return;
                label_34:
                    v1.onPrepareFromUri(arg5.obj, arg5.getData());
                    return;
                label_100:
                    v1.onSetRepeatMode(arg5.arg1);
                    return;
                label_38:
                    v1.onPlay();
                    return;
                label_103:
                    v1.onSetShuffleModeEnabled(arg5.obj.booleanValue());
                    return;
                label_40:
                    v1.onPlayFromMediaId(arg5.obj, arg5.getData());
                    return;
                label_44:
                    v1.onPlayFromSearch(arg5.obj, arg5.getData());
                    return;
                label_48:
                    v1.onPlayFromUri(arg5.obj, arg5.getData());
                    return;
                label_52:
                    v1.onSkipToQueueItem(arg5.obj.longValue());
                    return;
                label_56:
                    v1.onPause();
                    return;
                label_58:
                    v1.onStop();
                    return;
                label_60:
                    v1.onSkipToNext();
                    return;
                label_62:
                    v1.onSkipToPrevious();
                    return;
                label_64:
                    v1.onFastForward();
                    return;
                label_66:
                    v1.onRewind();
                    return;
                label_68:
                    v1.onSeekTo(arg5.obj.longValue());
                    return;
                label_8:
                    v1.onCommand(arg5.obj.command, arg5.obj.extras, arg5.obj.stub);
                    return;
                label_72:
                    v1.onSetRating(arg5.obj);
                    return;
                label_75:
                    v1.onCustomAction(arg5.obj, arg5.getData());
                    return;
                label_14:
                    Object v0 = arg5.obj;
                    Intent v2 = new Intent("android.intent.action.MEDIA_BUTTON");
                    v2.putExtra("android.intent.extra.KEY_EVENT", ((Parcelable)v0));
                    if(!v1.onMediaButtonEvent(v2)) {
                        this.onMediaButtonEvent(((KeyEvent)v0), v1);
                        return;
                    label_79:
                        v1.onAddQueueItem(arg5.obj);
                        return;
                    label_82:
                        v1.onAddQueueItem(arg5.obj, arg5.arg1);
                        return;
                    label_86:
                        v1.onRemoveQueueItem(arg5.obj);
                        return;
                    label_24:
                        v1.onPrepare();
                        return;
                    label_89:
                        v1.onRemoveQueueItemAt(arg5.arg1);
                        return;
                    label_26:
                        v1.onPrepareFromMediaId(arg5.obj, arg5.getData());
                        return;
                    label_92:
                        MediaSessionImplBase.this.adjustVolume(arg5.arg1, 0);
                        return;
                    label_30:
                        v1.onPrepareFromSearch(arg5.obj, arg5.getData());
                        return;
                    label_96:
                        MediaSessionImplBase.this.setVolumeTo(arg5.arg1, 0);
                    }
                }
            }

            private void onMediaButtonEvent(KeyEvent arg11, Callback arg12) {
                long v2 = 0;
                if(arg11 != null && arg11.getAction() == 0) {
                    long v0 = MediaSessionImplBase.this.mState == null ? v2 : MediaSessionImplBase.this.mState.getActions();
                    switch(arg11.getKeyCode()) {
                        case 79: 
                        case 85: {
                            goto label_14;
                        }
                        case 86: {
                            goto label_59;
                        }
                        case 87: {
                            goto label_49;
                        }
                        case 88: {
                            goto label_54;
                        }
                        case 89: {
                            goto label_69;
                        }
                        case 90: {
                            goto label_64;
                        }
                        case 126: {
                            goto label_39;
                        }
                        case 127: {
                            goto label_44;
                        }
                    }

                    return;
                label_49:
                    if((v0 & 0x20) == v2) {
                        return;
                    }

                    arg12.onSkipToNext();
                    return;
                label_69:
                    if((v0 & 8) == v2) {
                        return;
                    }

                    arg12.onRewind();
                    return;
                label_54:
                    if((v0 & 16) == v2) {
                        return;
                    }

                    arg12.onSkipToPrevious();
                    return;
                label_39:
                    if((v0 & 4) == v2) {
                        return;
                    }

                    arg12.onPlay();
                    return;
                label_59:
                    if((v0 & 1) == v2) {
                        return;
                    }

                    arg12.onStop();
                    return;
                label_44:
                    if((v0 & 2) == v2) {
                        return;
                    }

                    arg12.onPause();
                    return;
                label_14:
                    int v7 = MediaSessionImplBase.this.mState == null || MediaSessionImplBase.this.mState.getState() != 3 ? 0 : 1;
                    int v6 = (0x204 & v0) != v2 ? 1 : 0;
                    int v0_1 = (v0 & 0x202) != v2 ? 1 : 0;
                    if(v7 != 0 && v0_1 != 0) {
                        arg12.onPause();
                        return;
                    }

                    if(v7 != 0) {
                        return;
                    }

                    if(v6 == 0) {
                        return;
                    }

                    arg12.onPlay();
                    return;
                label_64:
                    if((v0 & 0x40) == v2) {
                        return;
                    }

                    arg12.onFastForward();
                }
            }

            public void post(int arg2, Object arg3, int arg4) {
                this.obtainMessage(arg2, arg4, 0, arg3).sendToTarget();
            }

            public void post(int arg2, Object arg3, Bundle arg4) {
                Message v0 = this.obtainMessage(arg2, arg3);
                v0.setData(arg4);
                v0.sendToTarget();
            }

            public void post(int arg2) {
                this.post(arg2, null);
            }

            public void post(int arg2, Object arg3) {
                this.obtainMessage(arg2, arg3).sendToTarget();
            }
        }

        final AudioManager mAudioManager;
        volatile Callback mCallback;
        private final Context mContext;
        final RemoteCallbackList mControllerCallbacks;
        boolean mDestroyed;
        Bundle mExtras;
        int mFlags;
        private MessageHandler mHandler;
        private boolean mIsActive;
        private boolean mIsMbrRegistered;
        private boolean mIsRccRegistered;
        int mLocalStream;
        final Object mLock;
        private final ComponentName mMediaButtonReceiverComponentName;
        private final PendingIntent mMediaButtonReceiverIntent;
        MediaMetadataCompat mMetadata;
        final String mPackageName;
        List mQueue;
        CharSequence mQueueTitle;
        int mRatingType;
        private final Object mRccObj;
        int mRepeatMode;
        PendingIntent mSessionActivity;
        boolean mShuffleModeEnabled;
        PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        final String mTag;
        private final Token mToken;
        private android.support.v4.media.VolumeProviderCompat$Callback mVolumeCallback;
        VolumeProviderCompat mVolumeProvider;
        int mVolumeType;

        public MediaSessionImplBase(Context arg4, String arg5, ComponentName arg6, PendingIntent arg7) {
            super();
            this.mLock = new Object();
            this.mControllerCallbacks = new RemoteCallbackList();
            this.mDestroyed = false;
            this.mIsActive = false;
            this.mIsRccRegistered = false;
            this.mIsMbrRegistered = false;
            this.mVolumeCallback = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$1(this);
            if(arg6 == null) {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
            }

            this.mContext = arg4;
            this.mPackageName = arg4.getPackageName();
            this.mAudioManager = arg4.getSystemService("audio");
            this.mTag = arg5;
            this.mMediaButtonReceiverComponentName = arg6;
            this.mMediaButtonReceiverIntent = arg7;
            this.mStub = new MediaSessionStub(this);
            this.mToken = new Token(this.mStub);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            this.mRccObj = Build$VERSION.SDK_INT >= 14 ? MediaSessionCompatApi14.createRemoteControlClient(arg7) : null;
        }

        void adjustVolume(int arg3, int arg4) {
            if(this.mVolumeType != 2) {
                this.mAudioManager.adjustStreamVolume(this.mLocalStream, arg3, arg4);
            }
            else if(this.mVolumeProvider != null) {
                this.mVolumeProvider.onAdjustVolume(arg3);
            }
        }

        public String getCallingPackage() {
            return null;
        }

        public Object getMediaSession() {
            return null;
        }

        public Object getRemoteControlClient() {
            return this.mRccObj;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        PlaybackStateCompat getStateWithUpdatedPosition() {
            PlaybackStateCompat v0_3;
            PlaybackStateCompat v7;
            long v0 = 0;
            long v2 = -1;
            Object v4 = this.mLock;
            __monitor_enter(v4);
            try {
                v7 = this.mState;
                if(this.mMetadata != null && (this.mMetadata.containsKey("android.media.metadata.DURATION"))) {
                    v2 = this.mMetadata.getLong("android.media.metadata.DURATION");
                }

                __monitor_exit(v4);
                v4 = null;
                if(v7 == null) {
                    goto label_55;
                }
            }
            catch(Throwable v0_1) {
                try {
                label_48:
                    __monitor_exit(v4);
                }
                catch(Throwable v0_1) {
                    goto label_48;
                }

                throw v0_1;
            }

            if(v7.getState() != 3 && v7.getState() != 4 && v7.getState() != 5) {
                goto label_55;
            }

            long v8 = v7.getLastPositionUpdateTime();
            long v5 = SystemClock.elapsedRealtime();
            if(v8 > v0) {
                v8 = (((long)(v7.getPlaybackSpeed() * (((float)(v5 - v8)))))) + v7.getPosition();
                if(v2 < v0 || v8 <= v2) {
                    v2 = v8 < v0 ? v0 : v8;
                }

                Builder v0_2 = new Builder(v7);
                v0_2.setState(v7.getState(), v2, v7.getPlaybackSpeed(), v5);
                v0_3 = v0_2.build();
            }
            else {
            label_55:
                v0_3 = ((PlaybackStateCompat)v4);
            }

            if(v0_3 == null) {
                v0_3 = v7;
            }

            return v0_3;
        }

        public boolean isActive() {
            return this.mIsActive;
        }

        void postToHandler(int arg2) {
            this.postToHandler(arg2, null);
        }

        void postToHandler(int arg2, Object arg3) {
            this.postToHandler(arg2, arg3, null);
        }

        void postToHandler(int arg2, int arg3) {
            this.postToHandler(arg2, null, arg3);
        }

        void postToHandler(int arg3, Object arg4, int arg5) {
            Object v1 = this.mLock;
            __monitor_enter(v1);
            try {
                if(this.mHandler != null) {
                    this.mHandler.post(arg3, arg4, arg5);
                }

                __monitor_exit(v1);
                return;
            label_9:
                __monitor_exit(v1);
            }
            catch(Throwable v0) {
                goto label_9;
            }

            throw v0;
        }

        void postToHandler(int arg3, Object arg4, Bundle arg5) {
            Object v1 = this.mLock;
            __monitor_enter(v1);
            try {
                if(this.mHandler != null) {
                    this.mHandler.post(arg3, arg4, arg5);
                }

                __monitor_exit(v1);
                return;
            label_9:
                __monitor_exit(v1);
            }
            catch(Throwable v0) {
                goto label_9;
            }

            throw v0;
        }

        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            this.update();
            this.sendSessionDestroyed();
        }

        private void sendEvent(String arg3, Bundle arg4) {
            int v1;
            for(v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                IInterface v0 = this.mControllerCallbacks.getBroadcastItem(v1);
                try {
                    ((IMediaControllerCallback)v0).onEvent(arg3, arg4);
                }
                catch(RemoteException v0_1) {
                }
            }

            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendExtras(Bundle arg3) {
            int v1;
            for(v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                IInterface v0 = this.mControllerCallbacks.getBroadcastItem(v1);
                try {
                    ((IMediaControllerCallback)v0).onExtrasChanged(arg3);
                }
                catch(RemoteException v0_1) {
                }
            }

            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(MediaMetadataCompat arg3) {
            int v1;
            for(v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                IInterface v0 = this.mControllerCallbacks.getBroadcastItem(v1);
                try {
                    ((IMediaControllerCallback)v0).onMetadataChanged(arg3);
                }
                catch(RemoteException v0_1) {
                }
            }

            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(List arg3) {
            int v1;
            for(v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                IInterface v0 = this.mControllerCallbacks.getBroadcastItem(v1);
                try {
                    ((IMediaControllerCallback)v0).onQueueChanged(arg3);
                }
                catch(RemoteException v0_1) {
                }
            }

            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(CharSequence arg3) {
            int v1;
            for(v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                IInterface v0 = this.mControllerCallbacks.getBroadcastItem(v1);
                try {
                    ((IMediaControllerCallback)v0).onQueueTitleChanged(arg3);
                }
                catch(RemoteException v0_1) {
                }
            }

            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendRepeatMode(int arg3) {
            int v1;
            for(v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                IInterface v0 = this.mControllerCallbacks.getBroadcastItem(v1);
                try {
                    ((IMediaControllerCallback)v0).onRepeatModeChanged(arg3);
                }
                catch(RemoteException v0_1) {
                }
            }

            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendSessionDestroyed() {
            int v1;
            for(v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                IInterface v0 = this.mControllerCallbacks.getBroadcastItem(v1);
                try {
                    ((IMediaControllerCallback)v0).onSessionDestroyed();
                }
                catch(RemoteException v0_1) {
                }
            }

            this.mControllerCallbacks.finishBroadcast();
            this.mControllerCallbacks.kill();
        }

        public void sendSessionEvent(String arg1, Bundle arg2) {
            this.sendEvent(arg1, arg2);
        }

        private void sendShuffleModeEnabled(boolean arg3) {
            int v1;
            for(v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                IInterface v0 = this.mControllerCallbacks.getBroadcastItem(v1);
                try {
                    ((IMediaControllerCallback)v0).onShuffleModeChanged(arg3);
                }
                catch(RemoteException v0_1) {
                }
            }

            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendState(PlaybackStateCompat arg3) {
            int v1;
            for(v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                IInterface v0 = this.mControllerCallbacks.getBroadcastItem(v1);
                try {
                    ((IMediaControllerCallback)v0).onPlaybackStateChanged(arg3);
                }
                catch(RemoteException v0_1) {
                }
            }

            this.mControllerCallbacks.finishBroadcast();
        }

        void sendVolumeInfoChanged(ParcelableVolumeInfo arg3) {
            int v1;
            for(v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                IInterface v0 = this.mControllerCallbacks.getBroadcastItem(v1);
                try {
                    ((IMediaControllerCallback)v0).onVolumeInfoChanged(arg3);
                }
                catch(RemoteException v0_1) {
                }
            }

            this.mControllerCallbacks.finishBroadcast();
        }

        public void setActive(boolean arg2) {
            if(arg2 != this.mIsActive) {
                this.mIsActive = arg2;
                if(this.update()) {
                    this.setMetadata(this.mMetadata);
                    this.setPlaybackState(this.mState);
                }
            }
        }

        public void setCallback(Callback arg6, Handler arg7) {
            Object v1 = null;
            int v4 = 19;
            int v3 = 18;
            this.mCallback = arg6;
            if(arg6 == null) {
                if(Build$VERSION.SDK_INT >= v3) {
                    MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.mRccObj, v1);
                }

                if(Build$VERSION.SDK_INT < v4) {
                    return;
                }

                MediaSessionCompatApi19.setOnMetadataUpdateListener(this.mRccObj, v1);
            }
            else {
                if(arg7 == null) {
                    arg7 = new Handler();
                }

                v1 = this.mLock;
                __monitor_enter(v1);
                try {
                    this.mHandler = new MessageHandler(this, arg7.getLooper());
                    __monitor_exit(v1);
                }
                catch(Throwable v0) {
                    try {
                    label_38:
                        __monitor_exit(v1);
                    }
                    catch(Throwable v0) {
                        goto label_38;
                    }

                    throw v0;
                }

                android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$2 v0_1 = new android.support.v4.media.session.MediaSessionCompatApi19$Callback() {
                    public void onSeekTo(long arg4) {
                        MediaSessionImplBase.this.postToHandler(18, Long.valueOf(arg4));
                    }

                    public void onSetRating(Object arg4) {
                        MediaSessionImplBase.this.postToHandler(19, RatingCompat.fromRating(arg4));
                    }
                };
                if(Build$VERSION.SDK_INT >= v3) {
                    MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.mRccObj, MediaSessionCompatApi18.createPlaybackPositionUpdateListener(((android.support.v4.media.session.MediaSessionCompatApi18$Callback)v0_1)));
                }

                if(Build$VERSION.SDK_INT < v4) {
                    return;
                }

                MediaSessionCompatApi19.setOnMetadataUpdateListener(this.mRccObj, MediaSessionCompatApi19.createMetadataUpdateListener(((android.support.v4.media.session.MediaSessionCompatApi19$Callback)v0_1)));
            }
        }

        public void setExtras(Bundle arg1) {
            this.mExtras = arg1;
            this.sendExtras(arg1);
        }

        public void setFlags(int arg3) {
            Object v1 = this.mLock;
            __monitor_enter(v1);
            try {
                this.mFlags = arg3;
                __monitor_exit(v1);
            }
            catch(Throwable v0) {
                try {
                label_7:
                    __monitor_exit(v1);
                }
                catch(Throwable v0) {
                    goto label_7;
                }

                throw v0;
            }

            this.update();
        }

        public void setMediaButtonReceiver(PendingIntent arg1) {
        }

        public void setMetadata(MediaMetadataCompat arg5) {
            Bundle v0 = null;
            if(arg5 != null) {
                arg5 = new android.support.v4.media.MediaMetadataCompat$Builder(arg5, MediaSessionCompat.sMaxBitmapSize).build();
            }

            Object v1 = this.mLock;
            __monitor_enter(v1);
            try {
                this.mMetadata = arg5;
                __monitor_exit(v1);
            }
            catch(Throwable v0_1) {
                try {
                label_15:
                    __monitor_exit(v1);
                }
                catch(Throwable v0_1) {
                    goto label_15;
                }

                throw v0_1;
            }

            this.sendMetadata(arg5);
            if(this.mIsActive) {
                if(Build$VERSION.SDK_INT >= 19) {
                    v1 = this.mRccObj;
                    if(arg5 != null) {
                        v0 = arg5.getBundle();
                    }

                    long v2 = this.mState == null ? 0 : this.mState.getActions();
                    MediaSessionCompatApi19.setMetadata(v1, v0, v2);
                }
                else {
                    if(Build$VERSION.SDK_INT < 14) {
                        return;
                    }

                    v1 = this.mRccObj;
                    if(arg5 != null) {
                        v0 = arg5.getBundle();
                    }

                    MediaSessionCompatApi14.setMetadata(v1, v0);
                }
            }
        }

        public void setPlaybackState(PlaybackStateCompat arg10) {
            int v8 = 18;
            int v7 = 14;
            Object v1 = this.mLock;
            __monitor_enter(v1);
            try {
                this.mState = arg10;
                __monitor_exit(v1);
            }
            catch(Throwable v0) {
                try {
                label_11:
                    __monitor_exit(v1);
                }
                catch(Throwable v0) {
                    goto label_11;
                }

                throw v0;
            }

            this.sendState(arg10);
            if(this.mIsActive) {
                if(arg10 != null) {
                    if(Build$VERSION.SDK_INT >= v8) {
                        MediaSessionCompatApi18.setState(this.mRccObj, arg10.getState(), arg10.getPosition(), arg10.getPlaybackSpeed(), arg10.getLastPositionUpdateTime());
                    }
                    else if(Build$VERSION.SDK_INT >= v7) {
                        MediaSessionCompatApi14.setState(this.mRccObj, arg10.getState());
                    }

                    if(Build$VERSION.SDK_INT >= 19) {
                        MediaSessionCompatApi19.setTransportControlFlags(this.mRccObj, arg10.getActions());
                        return;
                    }

                    if(Build$VERSION.SDK_INT >= v8) {
                        MediaSessionCompatApi18.setTransportControlFlags(this.mRccObj, arg10.getActions());
                        return;
                    }

                    if(Build$VERSION.SDK_INT < v7) {
                        return;
                    }

                    MediaSessionCompatApi14.setTransportControlFlags(this.mRccObj, arg10.getActions());
                }
                else if(Build$VERSION.SDK_INT >= v7) {
                    MediaSessionCompatApi14.setState(this.mRccObj, 0);
                    MediaSessionCompatApi14.setTransportControlFlags(this.mRccObj, 0);
                }
            }
        }

        public void setPlaybackToLocal(int arg8) {
            if(this.mVolumeProvider != null) {
                this.mVolumeProvider.setCallback(null);
            }

            this.mVolumeType = 1;
            this.sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, 2, this.mAudioManager.getStreamMaxVolume(this.mLocalStream), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        public void setPlaybackToRemote(VolumeProviderCompat arg7) {
            if(arg7 == null) {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }

            if(this.mVolumeProvider != null) {
                this.mVolumeProvider.setCallback(null);
            }

            this.mVolumeType = 2;
            this.mVolumeProvider = arg7;
            this.sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
            arg7.setCallback(this.mVolumeCallback);
        }

        public void setQueue(List arg1) {
            this.mQueue = arg1;
            this.sendQueue(arg1);
        }

        public void setQueueTitle(CharSequence arg1) {
            this.mQueueTitle = arg1;
            this.sendQueueTitle(arg1);
        }

        public void setRatingType(int arg1) {
            this.mRatingType = arg1;
        }

        public void setRepeatMode(int arg2) {
            if(this.mRepeatMode != arg2) {
                this.mRepeatMode = arg2;
                this.sendRepeatMode(arg2);
            }
        }

        public void setSessionActivity(PendingIntent arg3) {
            Object v1 = this.mLock;
            __monitor_enter(v1);
            try {
                this.mSessionActivity = arg3;
                __monitor_exit(v1);
                return;
            label_6:
                __monitor_exit(v1);
            }
            catch(Throwable v0) {
                goto label_6;
            }

            throw v0;
        }

        public void setShuffleModeEnabled(boolean arg2) {
            if(this.mShuffleModeEnabled != arg2) {
                this.mShuffleModeEnabled = arg2;
                this.sendShuffleModeEnabled(arg2);
            }
        }

        void setVolumeTo(int arg3, int arg4) {
            if(this.mVolumeType != 2) {
                this.mAudioManager.setStreamVolume(this.mLocalStream, arg3, arg4);
            }
            else if(this.mVolumeProvider != null) {
                this.mVolumeProvider.onSetVolumeTo(arg3);
            }
        }

        private boolean update() {
            boolean v0;
            int v3 = 18;
            if(this.mIsActive) {
                if((this.mIsMbrRegistered) || (this.mFlags & 1) == 0) {
                    if(!this.mIsMbrRegistered) {
                        goto label_17;
                    }

                    if((this.mFlags & 1) != 0) {
                        goto label_17;
                    }

                    if(Build$VERSION.SDK_INT >= v3) {
                        MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    }
                    else {
                        this.mContext.getSystemService("audio").unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverComponentName);
                    }

                    this.mIsMbrRegistered = false;
                }
                else {
                    if(Build$VERSION.SDK_INT >= v3) {
                        MediaSessionCompatApi18.registerMediaButtonEventReceiver(this.mContext, this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    }
                    else {
                        this.mContext.getSystemService("audio").registerMediaButtonEventReceiver(this.mMediaButtonReceiverComponentName);
                    }

                    this.mIsMbrRegistered = true;
                }

            label_17:
                if(Build$VERSION.SDK_INT < 14) {
                    goto label_86;
                }

                if(!this.mIsRccRegistered && (this.mFlags & 2) != 0) {
                    MediaSessionCompatApi14.registerRemoteControlClient(this.mContext, this.mRccObj);
                    this.mIsRccRegistered = true;
                    v0 = true;
                    return v0;
                }

                if(!this.mIsRccRegistered) {
                    goto label_86;
                }

                if((this.mFlags & 2) != 0) {
                    goto label_86;
                }

                MediaSessionCompatApi14.setState(this.mRccObj, 0);
                MediaSessionCompatApi14.unregisterRemoteControlClient(this.mContext, this.mRccObj);
                this.mIsRccRegistered = false;
                v0 = false;
            }
            else {
                if(this.mIsMbrRegistered) {
                    if(Build$VERSION.SDK_INT >= v3) {
                        MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    }
                    else {
                        this.mContext.getSystemService("audio").unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverComponentName);
                    }

                    this.mIsMbrRegistered = false;
                }

                if(this.mIsRccRegistered) {
                    MediaSessionCompatApi14.setState(this.mRccObj, 0);
                    MediaSessionCompatApi14.unregisterRemoteControlClient(this.mContext, this.mRccObj);
                    this.mIsRccRegistered = false;
                }

            label_86:
                v0 = false;
            }

            return v0;
        }
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    public final class QueueItem implements Parcelable {
        final class android.support.v4.media.session.MediaSessionCompat$QueueItem$1 implements Parcelable$Creator {
            android.support.v4.media.session.MediaSessionCompat$QueueItem$1() {
                super();
            }

            public QueueItem createFromParcel(Parcel arg2) {
                return new QueueItem(arg2);
            }

            public Object createFromParcel(Parcel arg2) {
                return this.createFromParcel(arg2);
            }

            public QueueItem[] newArray(int arg2) {
                return new QueueItem[arg2];
            }

            public Object[] newArray(int arg2) {
                return this.newArray(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR = null;
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private Object mItem;

        static {
            QueueItem.CREATOR = new android.support.v4.media.session.MediaSessionCompat$QueueItem$1();
        }

        QueueItem(Parcel arg3) {
            super();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(arg3);
            this.mId = arg3.readLong();
        }

        public QueueItem(MediaDescriptionCompat arg3, long arg4) {
            this(null, arg3, arg4);
        }

        private QueueItem(Object arg4, MediaDescriptionCompat arg5, long arg6) {
            super();
            if(arg5 == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            }

            if(arg6 == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }

            this.mDescription = arg5;
            this.mId = arg6;
            this.mItem = arg4;
        }

        public int describeContents() {
            return 0;
        }

        public static QueueItem fromQueueItem(Object arg4) {
            QueueItem v0 = arg4 == null || Build$VERSION.SDK_INT < 21 ? null : new QueueItem(arg4, MediaDescriptionCompat.fromMediaDescription(android.support.v4.media.session.MediaSessionCompatApi21$QueueItem.getDescription(arg4)), android.support.v4.media.session.MediaSessionCompatApi21$QueueItem.getQueueId(arg4));
            return v0;
        }

        public static List fromQueueItemList(List arg3) {
            ArrayList v0;
            if(arg3 == null || Build$VERSION.SDK_INT < 21) {
                List v0_1 = null;
            }
            else {
                v0 = new ArrayList();
                Iterator v1 = arg3.iterator();
                while(v1.hasNext()) {
                    ((List)v0).add(QueueItem.fromQueueItem(v1.next()));
                }
            }

            return ((List)v0);
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public Object getQueueItem() {
            Object v0;
            if(this.mItem != null || Build$VERSION.SDK_INT < 21) {
                v0 = this.mItem;
            }
            else {
                this.mItem = android.support.v4.media.session.MediaSessionCompatApi21$QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
                v0 = this.mItem;
            }

            return v0;
        }

        @Deprecated public static QueueItem obtain(Object arg1) {
            return QueueItem.fromQueueItem(arg1);
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        public void writeToParcel(Parcel arg3, int arg4) {
            this.mDescription.writeToParcel(arg3, arg4);
            arg3.writeLong(this.mId);
        }
    }

    final class ResultReceiverWrapper implements Parcelable {
        final class android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$1 implements Parcelable$Creator {
            android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$1() {
                super();
            }

            public ResultReceiverWrapper createFromParcel(Parcel arg2) {
                return new ResultReceiverWrapper(arg2);
            }

            public Object createFromParcel(Parcel arg2) {
                return this.createFromParcel(arg2);
            }

            public ResultReceiverWrapper[] newArray(int arg2) {
                return new ResultReceiverWrapper[arg2];
            }

            public Object[] newArray(int arg2) {
                return this.newArray(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR;
        private ResultReceiver mResultReceiver;

        static {
            ResultReceiverWrapper.CREATOR = new android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$1();
        }

        public ResultReceiverWrapper(ResultReceiver arg1) {
            super();
            this.mResultReceiver = arg1;
        }

        ResultReceiverWrapper(Parcel arg2) {
            super();
            this.mResultReceiver = ResultReceiver.CREATOR.createFromParcel(arg2);
        }

        static ResultReceiver access$000(ResultReceiverWrapper arg1) {
            return arg1.mResultReceiver;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            this.mResultReceiver.writeToParcel(arg2, arg3);
        }
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface SessionFlags {
    }

    public final class Token implements Parcelable {
        final class android.support.v4.media.session.MediaSessionCompat$Token$1 implements Parcelable$Creator {
            android.support.v4.media.session.MediaSessionCompat$Token$1() {
                super();
            }

            public Token createFromParcel(Parcel arg3) {
                Parcelable v0;
                if(Build$VERSION.SDK_INT >= 21) {
                    v0 = arg3.readParcelable(null);
                }
                else {
                    IBinder v0_1 = arg3.readStrongBinder();
                }

                return new Token(v0);
            }

            public Object createFromParcel(Parcel arg2) {
                return this.createFromParcel(arg2);
            }

            public Token[] newArray(int arg2) {
                return new Token[arg2];
            }

            public Object[] newArray(int arg2) {
                return this.newArray(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR;
        private final Object mInner;

        static {
            Token.CREATOR = new android.support.v4.media.session.MediaSessionCompat$Token$1();
        }

        Token(Object arg1) {
            super();
            this.mInner = arg1;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object arg4) {
            boolean v0 = true;
            if(this != (((Token)arg4))) {
                if(!(arg4 instanceof Token)) {
                    v0 = false;
                }
                else if(this.mInner == null) {
                    if(((Token)arg4).mInner != null) {
                        v0 = false;
                    }
                }
                else if(((Token)arg4).mInner == null) {
                    v0 = false;
                }
                else {
                    v0 = this.mInner.equals(((Token)arg4).mInner);
                }
            }

            return v0;
        }

        public static Token fromToken(Object arg2) {
            Token v0 = arg2 == null || Build$VERSION.SDK_INT < 21 ? null : new Token(MediaSessionCompatApi21.verifyToken(arg2));
            return v0;
        }

        public Object getToken() {
            return this.mInner;
        }

        public int hashCode() {
            int v0 = this.mInner == null ? 0 : this.mInner.hashCode();
            return v0;
        }

        public void writeToParcel(Parcel arg3, int arg4) {
            if(Build$VERSION.SDK_INT >= 21) {
                arg3.writeParcelable(this.mInner, arg4);
            }
            else {
                arg3.writeStrongBinder(this.mInner);
            }
        }
    }

    static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    static final String ACTION_ARGUMENT_SHUFFLE_MODE_ENABLED = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE_ENABLED";
    static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    static final String ACTION_SET_SHUFFLE_MODE_ENABLED = "android.support.v4.media.session.action.SET_SHUFFLE_MODE_ENABLED";
    static final String EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    static final String TAG = "MediaSessionCompat";
    private final ArrayList mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;
    static int sMaxBitmapSize;

    private MediaSessionCompat(Context arg3, MediaSessionImpl arg4) {
        super();
        this.mActiveListeners = new ArrayList();
        this.mImpl = arg4;
        if(Build$VERSION.SDK_INT >= 21) {
            this.setCallback(new Callback() {
            });
        }

        this.mController = new MediaControllerCompat(arg3, this);
    }

    public MediaSessionCompat(Context arg2, String arg3) {
        this(arg2, arg3, null, null);
    }

    public MediaSessionCompat(Context arg4, String arg5, ComponentName arg6, PendingIntent arg7) {
        super();
        this.mActiveListeners = new ArrayList();
        if(arg4 == null) {
            throw new IllegalArgumentException("context must not be null");
        }

        if(TextUtils.isEmpty(((CharSequence)arg5))) {
            throw new IllegalArgumentException("tag must not be null or empty");
        }

        if(arg6 == null) {
            arg6 = MediaButtonReceiver.getMediaButtonReceiverComponent(arg4);
            if(arg6 == null) {
                Log.w("MediaSessionCompat", "Couldn\'t find a unique registered media button receiver in the given context.");
            }
        }

        if(arg6 != null && arg7 == null) {
            Intent v0 = new Intent("android.intent.action.MEDIA_BUTTON");
            v0.setComponent(arg6);
            arg7 = PendingIntent.getBroadcast(arg4, 0, v0, 0);
        }

        if(Build$VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaSessionImplApi21(arg4, arg5);
            this.mImpl.setMediaButtonReceiver(arg7);
            this.setCallback(new Callback() {
            });
        }
        else {
            this.mImpl = new MediaSessionImplBase(arg4, arg5, arg6, arg7);
        }

        this.mController = new MediaControllerCompat(arg4, this);
        if(MediaSessionCompat.sMaxBitmapSize == 0) {
            MediaSessionCompat.sMaxBitmapSize = ((int)TypedValue.applyDimension(1, 320f, arg4.getResources().getDisplayMetrics()));
        }
    }

    public void addOnActiveChangeListener(OnActiveChangeListener arg3) {
        if(arg3 == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }

        this.mActiveListeners.add(arg3);
    }

    public static MediaSessionCompat fromMediaSession(Context arg2, Object arg3) {
        MediaSessionCompat v0 = arg2 == null || arg3 == null || Build$VERSION.SDK_INT < 21 ? null : new MediaSessionCompat(arg2, new MediaSessionImplApi21(arg3));
        return v0;
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    @Deprecated public static MediaSessionCompat obtain(Context arg1, Object arg2) {
        return MediaSessionCompat.fromMediaSession(arg1, arg2);
    }

    public void release() {
        this.mImpl.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener arg3) {
        if(arg3 == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }

        this.mActiveListeners.remove(arg3);
    }

    public void sendSessionEvent(String arg3, Bundle arg4) {
        if(TextUtils.isEmpty(((CharSequence)arg3))) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }

        this.mImpl.sendSessionEvent(arg3, arg4);
    }

    public void setActive(boolean arg3) {
        this.mImpl.setActive(arg3);
        Iterator v1 = this.mActiveListeners.iterator();
        while(v1.hasNext()) {
            v1.next().onActiveChanged();
        }
    }

    public void setCallback(Callback arg2) {
        this.setCallback(arg2, null);
    }

    public void setCallback(Callback arg2, Handler arg3) {
        MediaSessionImpl v0 = this.mImpl;
        if(arg3 == null) {
            arg3 = new Handler();
        }

        v0.setCallback(arg2, arg3);
    }

    public void setExtras(Bundle arg2) {
        this.mImpl.setExtras(arg2);
    }

    public void setFlags(int arg2) {
        this.mImpl.setFlags(arg2);
    }

    public void setMediaButtonReceiver(PendingIntent arg2) {
        this.mImpl.setMediaButtonReceiver(arg2);
    }

    public void setMetadata(MediaMetadataCompat arg2) {
        this.mImpl.setMetadata(arg2);
    }

    public void setPlaybackState(PlaybackStateCompat arg2) {
        this.mImpl.setPlaybackState(arg2);
    }

    public void setPlaybackToLocal(int arg2) {
        this.mImpl.setPlaybackToLocal(arg2);
    }

    public void setPlaybackToRemote(VolumeProviderCompat arg3) {
        if(arg3 == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }

        this.mImpl.setPlaybackToRemote(arg3);
    }

    public void setQueue(List arg2) {
        this.mImpl.setQueue(arg2);
    }

    public void setQueueTitle(CharSequence arg2) {
        this.mImpl.setQueueTitle(arg2);
    }

    public void setRatingType(int arg2) {
        this.mImpl.setRatingType(arg2);
    }

    public void setRepeatMode(int arg2) {
        this.mImpl.setRepeatMode(arg2);
    }

    public void setSessionActivity(PendingIntent arg2) {
        this.mImpl.setSessionActivity(arg2);
    }

    public void setShuffleModeEnabled(boolean arg2) {
        this.mImpl.setShuffleModeEnabled(arg2);
    }
}

