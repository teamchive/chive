package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public interface IMediaSession extends IInterface {
    public abstract class Stub extends Binder implements IMediaSession {
        class Proxy implements IMediaSession {
            private IBinder mRemote;

            Proxy(IBinder arg1) {
                super();
                this.mRemote = arg1;
            }

            public void addQueueItem(MediaDescriptionCompat arg6) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(arg6 != null) {
                        v1.writeInt(1);
                        arg6.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(41, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void addQueueItemAt(MediaDescriptionCompat arg6, int arg7) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(arg6 != null) {
                        v1.writeInt(1);
                        arg6.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    v1.writeInt(arg7);
                    this.mRemote.transact(42, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void adjustVolume(int arg6, int arg7, String arg8) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeInt(arg6);
                    v1.writeInt(arg7);
                    v1.writeString(arg8);
                    this.mRemote.transact(11, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void fastForward() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(22, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public Bundle getExtras() {
                Object v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(0x1F, v1, v2, 0);
                    v2.readException();
                    if(v2.readInt() != 0) {
                        v0_1 = Bundle.CREATOR.createFromParcel(v2);
                    }
                    else {
                        goto label_16;
                    }

                    goto label_13;
                }
                catch(Throwable v0) {
                    goto label_19;
                }

            label_16:
                Bundle v0_2 = null;
                try {
                label_13:
                    v2.recycle();
                }
                catch(Throwable v0) {
                label_19:
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
                return ((Bundle)v0_1);
            }

            public long getFlags() {
                long v4;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(9, v1, v2, 0);
                    v2.readException();
                    v4 = v2.readLong();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
                return v4;
            }

            public String getInterfaceDescriptor() {
                return "android.support.v4.media.session.IMediaSession";
            }

            public PendingIntent getLaunchPendingIntent() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(8, v1, v2, 0);
                    v2.readException();
                    if(v2.readInt() != 0) {
                        Object v0_1 = PendingIntent.CREATOR.createFromParcel(v2);
                    }
                    else {
                        goto label_16;
                    }

                    goto label_13;
                }
                catch(Throwable v0) {
                    goto label_19;
                }

            label_16:
                PendingIntent v0_2 = null;
                try {
                label_13:
                    v2.recycle();
                }
                catch(Throwable v0) {
                label_19:
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
                return v0_2;
            }

            public MediaMetadataCompat getMetadata() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(27, v1, v2, 0);
                    v2.readException();
                    if(v2.readInt() != 0) {
                        Object v0_1 = MediaMetadataCompat.CREATOR.createFromParcel(v2);
                    }
                    else {
                        goto label_16;
                    }

                    goto label_13;
                }
                catch(Throwable v0) {
                    goto label_19;
                }

            label_16:
                MediaMetadataCompat v0_2 = null;
                try {
                label_13:
                    v2.recycle();
                }
                catch(Throwable v0) {
                label_19:
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
                return v0_2;
            }

            public String getPackageName() {
                String v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(6, v1, v2, 0);
                    v2.readException();
                    v0_1 = v2.readString();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
                return v0_1;
            }

            public PlaybackStateCompat getPlaybackState() {
                Object v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(28, v1, v2, 0);
                    v2.readException();
                    if(v2.readInt() != 0) {
                        v0_1 = PlaybackStateCompat.CREATOR.createFromParcel(v2);
                    }
                    else {
                        goto label_16;
                    }

                    goto label_13;
                }
                catch(Throwable v0) {
                    goto label_19;
                }

            label_16:
                PlaybackStateCompat v0_2 = null;
                try {
                label_13:
                    v2.recycle();
                }
                catch(Throwable v0) {
                label_19:
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
                return ((PlaybackStateCompat)v0_1);
            }

            public List getQueue() {
                ArrayList v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(29, v1, v2, 0);
                    v2.readException();
                    v0_1 = v2.createTypedArrayList(QueueItem.CREATOR);
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
                return ((List)v0_1);
            }

            public CharSequence getQueueTitle() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(30, v1, v2, 0);
                    v2.readException();
                    if(v2.readInt() != 0) {
                        Object v0_1 = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(v2);
                    }
                    else {
                        goto label_16;
                    }

                    goto label_13;
                }
                catch(Throwable v0) {
                    goto label_19;
                }

            label_16:
                CharSequence v0_2 = null;
                try {
                label_13:
                    v2.recycle();
                }
                catch(Throwable v0) {
                label_19:
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
                return v0_2;
            }

            public int getRatingType() {
                int v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(0x20, v1, v2, 0);
                    v2.readException();
                    v0_1 = v2.readInt();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
                return v0_1;
            }

            public int getRepeatMode() {
                int v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(37, v1, v2, 0);
                    v2.readException();
                    v0_1 = v2.readInt();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
                return v0_1;
            }

            public String getTag() {
                String v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(7, v1, v2, 0);
                    v2.readException();
                    v0_1 = v2.readString();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
                return v0_1;
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                Object v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(10, v1, v2, 0);
                    v2.readException();
                    if(v2.readInt() != 0) {
                        v0_1 = ParcelableVolumeInfo.CREATOR.createFromParcel(v2);
                    }
                    else {
                        goto label_16;
                    }

                    goto label_13;
                }
                catch(Throwable v0) {
                    goto label_19;
                }

            label_16:
                ParcelableVolumeInfo v0_2 = null;
                try {
                label_13:
                    v2.recycle();
                }
                catch(Throwable v0) {
                label_19:
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
                return ((ParcelableVolumeInfo)v0_1);
            }

            public boolean isShuffleModeEnabled() {
                boolean v0 = false;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(38, v1, v2, 0);
                    v2.readException();
                    if(v2.readInt() == 0) {
                        goto label_13;
                    }
                }
                catch(Throwable v0_1) {
                    v2.recycle();
                    v1.recycle();
                    throw v0_1;
                }

                v0 = true;
            label_13:
                v2.recycle();
                v1.recycle();
                return v0;
            }

            public boolean isTransportControlEnabled() {
                boolean v0 = false;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(5, v1, v2, 0);
                    v2.readException();
                    if(v2.readInt() == 0) {
                        goto label_13;
                    }
                }
                catch(Throwable v0_1) {
                    v2.recycle();
                    v1.recycle();
                    throw v0_1;
                }

                v0 = true;
            label_13:
                v2.recycle();
                v1.recycle();
                return v0;
            }

            public void next() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(20, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void pause() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(18, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void play() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(13, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void playFromMediaId(String arg6, Bundle arg7) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeString(arg6);
                    if(arg7 != null) {
                        v1.writeInt(1);
                        arg7.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(14, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void playFromSearch(String arg6, Bundle arg7) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeString(arg6);
                    if(arg7 != null) {
                        v1.writeInt(1);
                        arg7.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(15, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void playFromUri(Uri arg6, Bundle arg7) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(arg6 != null) {
                        v1.writeInt(1);
                        arg6.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    if(arg7 != null) {
                        v1.writeInt(1);
                        arg7.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(16, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void prepare() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(33, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void prepareFromMediaId(String arg6, Bundle arg7) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeString(arg6);
                    if(arg7 != null) {
                        v1.writeInt(1);
                        arg7.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(34, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void prepareFromSearch(String arg6, Bundle arg7) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeString(arg6);
                    if(arg7 != null) {
                        v1.writeInt(1);
                        arg7.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(35, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void prepareFromUri(Uri arg6, Bundle arg7) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(arg6 != null) {
                        v1.writeInt(1);
                        arg6.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    if(arg7 != null) {
                        v1.writeInt(1);
                        arg7.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(36, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void previous() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(21, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void rate(RatingCompat arg6) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(arg6 != null) {
                        v1.writeInt(1);
                        arg6.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(25, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void registerCallbackListener(IMediaControllerCallback arg6) {
                IBinder v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(arg6 != null) {
                        v0_1 = arg6.asBinder();
                    }
                    else {
                        goto label_15;
                    }

                    goto label_6;
                }
                catch(Throwable v0) {
                    goto label_18;
                }

            label_15:
                v0_1 = null;
                try {
                label_6:
                    v1.writeStrongBinder(v0_1);
                    this.mRemote.transact(3, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                label_18:
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void removeQueueItem(MediaDescriptionCompat arg6) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(arg6 != null) {
                        v1.writeInt(1);
                        arg6.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(43, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void removeQueueItemAt(int arg6) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeInt(arg6);
                    this.mRemote.transact(44, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void rewind() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(23, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void seekTo(long arg6) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeLong(arg6);
                    this.mRemote.transact(24, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void sendCommand(String arg6, Bundle arg7, ResultReceiverWrapper arg8) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeString(arg6);
                    if(arg7 != null) {
                        v1.writeInt(1);
                        arg7.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    if(arg8 != null) {
                        v1.writeInt(1);
                        arg8.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(1, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void sendCustomAction(String arg6, Bundle arg7) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeString(arg6);
                    if(arg7 != null) {
                        v1.writeInt(1);
                        arg7.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(26, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public boolean sendMediaButton(KeyEvent arg8) {
                boolean v0 = true;
                Parcel v2 = Parcel.obtain();
                Parcel v3 = Parcel.obtain();
                try {
                    v2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(arg8 != null) {
                        v2.writeInt(1);
                        arg8.writeToParcel(v2, 0);
                    }
                    else {
                        v2.writeInt(0);
                    }

                    this.mRemote.transact(2, v2, v3, 0);
                    v3.readException();
                    if(v3.readInt() == 0) {
                        goto label_28;
                    }

                    goto label_18;
                }
                catch(Throwable v0_1) {
                    v3.recycle();
                    v2.recycle();
                    throw v0_1;
                }

            label_28:
                v0 = false;
            label_18:
                v3.recycle();
                v2.recycle();
                return v0;
            }

            public void setRepeatMode(int arg6) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeInt(arg6);
                    this.mRemote.transact(39, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void setShuffleModeEnabled(boolean arg6) {
                int v0 = 0;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(arg6) {
                        v0 = 1;
                    }

                    v1.writeInt(v0);
                    this.mRemote.transact(40, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0_1) {
                    v2.recycle();
                    v1.recycle();
                    throw v0_1;
                }

                v2.recycle();
                v1.recycle();
            }

            public void setVolumeTo(int arg6, int arg7, String arg8) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeInt(arg6);
                    v1.writeInt(arg7);
                    v1.writeString(arg8);
                    this.mRemote.transact(12, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void skipToQueueItem(long arg6) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeLong(arg6);
                    this.mRemote.transact(17, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void stop() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(19, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }

            public void unregisterCallbackListener(IMediaControllerCallback arg6) {
                IBinder v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(arg6 != null) {
                        v0_1 = arg6.asBinder();
                    }
                    else {
                        goto label_15;
                    }

                    goto label_6;
                }
                catch(Throwable v0) {
                    goto label_18;
                }

            label_15:
                v0_1 = null;
                try {
                label_6:
                    v1.writeStrongBinder(v0_1);
                    this.mRemote.transact(4, v1, v2, 0);
                    v2.readException();
                }
                catch(Throwable v0) {
                label_18:
                    v2.recycle();
                    v1.recycle();
                    throw v0;
                }

                v2.recycle();
                v1.recycle();
            }
        }

        private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";
        static final int TRANSACTION_addQueueItem = 41;
        static final int TRANSACTION_addQueueItemAt = 42;
        static final int TRANSACTION_adjustVolume = 11;
        static final int TRANSACTION_fastForward = 22;
        static final int TRANSACTION_getExtras = 0x1F;
        static final int TRANSACTION_getFlags = 9;
        static final int TRANSACTION_getLaunchPendingIntent = 8;
        static final int TRANSACTION_getMetadata = 27;
        static final int TRANSACTION_getPackageName = 6;
        static final int TRANSACTION_getPlaybackState = 28;
        static final int TRANSACTION_getQueue = 29;
        static final int TRANSACTION_getQueueTitle = 30;
        static final int TRANSACTION_getRatingType = 0x20;
        static final int TRANSACTION_getRepeatMode = 37;
        static final int TRANSACTION_getTag = 7;
        static final int TRANSACTION_getVolumeAttributes = 10;
        static final int TRANSACTION_isShuffleModeEnabled = 38;
        static final int TRANSACTION_isTransportControlEnabled = 5;
        static final int TRANSACTION_next = 20;
        static final int TRANSACTION_pause = 18;
        static final int TRANSACTION_play = 13;
        static final int TRANSACTION_playFromMediaId = 14;
        static final int TRANSACTION_playFromSearch = 15;
        static final int TRANSACTION_playFromUri = 16;
        static final int TRANSACTION_prepare = 33;
        static final int TRANSACTION_prepareFromMediaId = 34;
        static final int TRANSACTION_prepareFromSearch = 35;
        static final int TRANSACTION_prepareFromUri = 36;
        static final int TRANSACTION_previous = 21;
        static final int TRANSACTION_rate = 25;
        static final int TRANSACTION_registerCallbackListener = 3;
        static final int TRANSACTION_removeQueueItem = 43;
        static final int TRANSACTION_removeQueueItemAt = 44;
        static final int TRANSACTION_rewind = 23;
        static final int TRANSACTION_seekTo = 24;
        static final int TRANSACTION_sendCommand = 1;
        static final int TRANSACTION_sendCustomAction = 26;
        static final int TRANSACTION_sendMediaButton = 2;
        static final int TRANSACTION_setRepeatMode = 39;
        static final int TRANSACTION_setShuffleModeEnabled = 40;
        static final int TRANSACTION_setVolumeTo = 12;
        static final int TRANSACTION_skipToQueueItem = 17;
        static final int TRANSACTION_stop = 19;
        static final int TRANSACTION_unregisterCallbackListener = 4;

        public Stub() {
            super();
            this.attachInterface(((IInterface)this), "android.support.v4.media.session.IMediaSession");
        }

        public IBinder asBinder() {
            return this;
        }

        public static IMediaSession asInterface(IBinder arg2) {
            IMediaSession v0;
            if(arg2 == null) {
                v0 = null;
            }
            else {
                IInterface v0_1 = arg2.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                if(v0_1 != null && ((v0_1 instanceof IMediaSession))) {
                    return v0;
                }

                Proxy v0_2 = new Proxy(arg2);
            }

            return v0;
        }

        public boolean onTransact(int arg6, Parcel arg7, Parcel arg8, int arg9) {
            KeyEvent v0_14;
            Bundle v0_1;
            Object v0;
            String v1_1;
            MediaDescriptionCompat v0_6;
            RatingCompat v0_3;
            boolean v1_4;
            Uri v1_3;
            Object v1_2;
            boolean v0_4;
            ResultReceiverWrapper v0_9;
            int v0_2;
            String v0_7;
            int v1 = 0;
            Bundle v2 = null;
            boolean v3 = true;
            switch(arg6) {
                case 1: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    String v4 = arg7.readString();
                    if(arg7.readInt() != 0) {
                        v1_2 = Bundle.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        Bundle v1_5 = v2;
                    }

                    if(arg7.readInt() != 0) {
                        v0 = ResultReceiverWrapper.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_9 = ((ResultReceiverWrapper)v2);
                    }

                    this.sendCommand(v4, ((Bundle)v1_2), v0_9);
                    arg8.writeNoException();
                    break;
                }
                case 2: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v0 = KeyEvent.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_14 = ((KeyEvent)v2);
                    }

                    v0_4 = this.sendMediaButton(v0_14);
                    arg8.writeNoException();
                    v0_2 = v0_4 ? 1 : 0;
                    arg8.writeInt(v0_2);
                    break;
                }
                case 3: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.registerCallbackListener(android.support.v4.media.session.IMediaControllerCallback$Stub.asInterface(arg7.readStrongBinder()));
                    arg8.writeNoException();
                    break;
                }
                case 4: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.unregisterCallbackListener(android.support.v4.media.session.IMediaControllerCallback$Stub.asInterface(arg7.readStrongBinder()));
                    arg8.writeNoException();
                    break;
                }
                case 5: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_4 = this.isTransportControlEnabled();
                    arg8.writeNoException();
                    if(v0_4) {
                        v1 = 1;
                    }

                    arg8.writeInt(v1);
                    break;
                }
                case 6: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_7 = this.getPackageName();
                    arg8.writeNoException();
                    arg8.writeString(v0_7);
                    break;
                }
                case 7: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_7 = this.getTag();
                    arg8.writeNoException();
                    arg8.writeString(v0_7);
                    break;
                }
                case 8: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    PendingIntent v0_11 = this.getLaunchPendingIntent();
                    arg8.writeNoException();
                    if(v0_11 != null) {
                        arg8.writeInt(1);
                        v0_11.writeToParcel(arg8, 1);
                        return v3;
                    }

                    arg8.writeInt(0);
                    break;
                }
                case 9: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    long v0_13 = this.getFlags();
                    arg8.writeNoException();
                    arg8.writeLong(v0_13);
                    break;
                }
                case 10: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    ParcelableVolumeInfo v0_15 = this.getVolumeAttributes();
                    arg8.writeNoException();
                    if(v0_15 != null) {
                        arg8.writeInt(1);
                        v0_15.writeToParcel(arg8, 1);
                        return v3;
                    }

                    arg8.writeInt(0);
                    break;
                }
                case 11: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.adjustVolume(arg7.readInt(), arg7.readInt(), arg7.readString());
                    arg8.writeNoException();
                    break;
                }
                case 12: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.setVolumeTo(arg7.readInt(), arg7.readInt(), arg7.readString());
                    arg8.writeNoException();
                    break;
                }
                case 13: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.play();
                    arg8.writeNoException();
                    break;
                }
                case 14: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v1_1 = arg7.readString();
                    if(arg7.readInt() != 0) {
                        v0 = Bundle.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_1 = v2;
                    }

                    this.playFromMediaId(v1_1, ((Bundle)v0));
                    arg8.writeNoException();
                    break;
                }
                case 15: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v1_1 = arg7.readString();
                    if(arg7.readInt() != 0) {
                        v0 = Bundle.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_1 = v2;
                    }

                    this.playFromSearch(v1_1, ((Bundle)v0));
                    arg8.writeNoException();
                    break;
                }
                case 16: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v1_2 = Uri.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v1_3 = ((Uri)v2);
                    }

                    if(arg7.readInt() != 0) {
                        v0 = Bundle.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_1 = v2;
                    }

                    this.playFromUri(v1_3, ((Bundle)v0));
                    arg8.writeNoException();
                    break;
                }
                case 17: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.skipToQueueItem(arg7.readLong());
                    arg8.writeNoException();
                    break;
                }
                case 18: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.pause();
                    arg8.writeNoException();
                    break;
                }
                case 19: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.stop();
                    arg8.writeNoException();
                    break;
                }
                case 20: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.next();
                    arg8.writeNoException();
                    break;
                }
                case 21: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.previous();
                    arg8.writeNoException();
                    break;
                }
                case 22: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.fastForward();
                    arg8.writeNoException();
                    break;
                }
                case 23: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.rewind();
                    arg8.writeNoException();
                    break;
                }
                case 24: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.seekTo(arg7.readLong());
                    arg8.writeNoException();
                    break;
                }
                case 25: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v0 = RatingCompat.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_3 = ((RatingCompat)v2);
                    }

                    this.rate(v0_3);
                    arg8.writeNoException();
                    break;
                }
                case 26: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v1_1 = arg7.readString();
                    if(arg7.readInt() != 0) {
                        v0 = Bundle.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_1 = v2;
                    }

                    this.sendCustomAction(v1_1, ((Bundle)v0));
                    arg8.writeNoException();
                    break;
                }
                case 27: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    MediaMetadataCompat v0_5 = this.getMetadata();
                    arg8.writeNoException();
                    if(v0_5 != null) {
                        arg8.writeInt(1);
                        v0_5.writeToParcel(arg8, 1);
                        return v3;
                    }

                    arg8.writeInt(0);
                    break;
                }
                case 28: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    PlaybackStateCompat v0_8 = this.getPlaybackState();
                    arg8.writeNoException();
                    if(v0_8 != null) {
                        arg8.writeInt(1);
                        v0_8.writeToParcel(arg8, 1);
                        return v3;
                    }

                    arg8.writeInt(0);
                    break;
                }
                case 29: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    List v0_10 = this.getQueue();
                    arg8.writeNoException();
                    arg8.writeTypedList(v0_10);
                    break;
                }
                case 30: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    CharSequence v0_12 = this.getQueueTitle();
                    arg8.writeNoException();
                    if(v0_12 != null) {
                        arg8.writeInt(1);
                        TextUtils.writeToParcel(v0_12, arg8, 1);
                        return v3;
                    }

                    arg8.writeInt(0);
                    break;
                }
                case 31: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_1 = this.getExtras();
                    arg8.writeNoException();
                    if(v0_1 != null) {
                        arg8.writeInt(1);
                        v0_1.writeToParcel(arg8, 1);
                        return v3;
                    }

                    arg8.writeInt(0);
                    break;
                }
                case 32: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_2 = this.getRatingType();
                    arg8.writeNoException();
                    arg8.writeInt(v0_2);
                    break;
                }
                case 33: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.prepare();
                    arg8.writeNoException();
                    break;
                }
                case 34: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v1_1 = arg7.readString();
                    if(arg7.readInt() != 0) {
                        v0 = Bundle.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_1 = v2;
                    }

                    this.prepareFromMediaId(v1_1, v0_1);
                    arg8.writeNoException();
                    break;
                }
                case 35: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v1_1 = arg7.readString();
                    if(arg7.readInt() != 0) {
                        v0 = Bundle.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_1 = v2;
                    }

                    this.prepareFromSearch(v1_1, ((Bundle)v0));
                    arg8.writeNoException();
                    break;
                }
                case 36: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v1_2 = Uri.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v1_3 = ((Uri)v2);
                    }

                    if(arg7.readInt() != 0) {
                        v0 = Bundle.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_1 = v2;
                    }

                    this.prepareFromUri(v1_3, ((Bundle)v0));
                    arg8.writeNoException();
                    break;
                }
                case 37: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_2 = this.getRepeatMode();
                    arg8.writeNoException();
                    arg8.writeInt(v0_2);
                    break;
                }
                case 38: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_4 = this.isShuffleModeEnabled();
                    arg8.writeNoException();
                    if(v0_4) {
                        v1 = 1;
                    }

                    arg8.writeInt(v1);
                    break;
                }
                case 39: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.setRepeatMode(arg7.readInt());
                    arg8.writeNoException();
                    break;
                }
                case 40: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v1_4 = true;
                    }

                    this.setShuffleModeEnabled(v1_4);
                    arg8.writeNoException();
                    break;
                }
                case 41: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v0 = MediaDescriptionCompat.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_6 = ((MediaDescriptionCompat)v2);
                    }

                    this.addQueueItem(v0_6);
                    arg8.writeNoException();
                    break;
                }
                case 42: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v0 = MediaDescriptionCompat.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_6 = ((MediaDescriptionCompat)v2);
                    }

                    this.addQueueItemAt(v0_6, arg7.readInt());
                    arg8.writeNoException();
                    break;
                }
                case 43: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v0 = MediaDescriptionCompat.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_6 = ((MediaDescriptionCompat)v2);
                    }

                    this.removeQueueItem(v0_6);
                    arg8.writeNoException();
                    break;
                }
                case 44: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.removeQueueItemAt(arg7.readInt());
                    arg8.writeNoException();
                    break;
                }
                case 1598968902: {
                    arg8.writeString("android.support.v4.media.session.IMediaSession");
                    break;
                }
                default: {
                    v3 = super.onTransact(arg6, arg7, arg8, arg9);
                    break;
                }
            }

            return v3;
        }
    }

    void addQueueItem(MediaDescriptionCompat arg1);

    void addQueueItemAt(MediaDescriptionCompat arg1, int arg2);

    void adjustVolume(int arg1, int arg2, String arg3);

    void fastForward();

    Bundle getExtras();

    long getFlags();

    PendingIntent getLaunchPendingIntent();

    MediaMetadataCompat getMetadata();

    String getPackageName();

    PlaybackStateCompat getPlaybackState();

    List getQueue();

    CharSequence getQueueTitle();

    int getRatingType();

    int getRepeatMode();

    String getTag();

    ParcelableVolumeInfo getVolumeAttributes();

    boolean isShuffleModeEnabled();

    boolean isTransportControlEnabled();

    void next();

    void pause();

    void play();

    void playFromMediaId(String arg1, Bundle arg2);

    void playFromSearch(String arg1, Bundle arg2);

    void playFromUri(Uri arg1, Bundle arg2);

    void prepare();

    void prepareFromMediaId(String arg1, Bundle arg2);

    void prepareFromSearch(String arg1, Bundle arg2);

    void prepareFromUri(Uri arg1, Bundle arg2);

    void previous();

    void rate(RatingCompat arg1);

    void registerCallbackListener(IMediaControllerCallback arg1);

    void removeQueueItem(MediaDescriptionCompat arg1);

    void removeQueueItemAt(int arg1);

    void rewind();

    void seekTo(long arg1);

    void sendCommand(String arg1, Bundle arg2, ResultReceiverWrapper arg3);

    void sendCustomAction(String arg1, Bundle arg2);

    boolean sendMediaButton(KeyEvent arg1);

    void setRepeatMode(int arg1);

    void setShuffleModeEnabled(boolean arg1);

    void setVolumeTo(int arg1, int arg2, String arg3);

    void skipToQueueItem(long arg1);

    void stop();

    void unregisterCallbackListener(IMediaControllerCallback arg1);
}

