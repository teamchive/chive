package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

public interface IMediaControllerCallback extends IInterface {
    public abstract class Stub extends Binder implements IMediaControllerCallback {
        class Proxy implements IMediaControllerCallback {
            private IBinder mRemote;

            Proxy(IBinder arg1) {
                super();
                this.mRemote = arg1;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.support.v4.media.session.IMediaControllerCallback";
            }

            public void onEvent(String arg6, Bundle arg7) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    v1.writeString(arg6);
                    if(arg7 != null) {
                        v1.writeInt(1);
                        arg7.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(1, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void onExtrasChanged(Bundle arg6) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6 != null) {
                        v1.writeInt(1);
                        arg6.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(7, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void onMetadataChanged(MediaMetadataCompat arg6) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6 != null) {
                        v1.writeInt(1);
                        arg6.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(4, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void onPlaybackStateChanged(PlaybackStateCompat arg6) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6 != null) {
                        v1.writeInt(1);
                        arg6.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(3, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void onQueueChanged(List arg6) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    v1.writeTypedList(arg6);
                    this.mRemote.transact(5, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void onQueueTitleChanged(CharSequence arg6) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6 != null) {
                        v1.writeInt(1);
                        TextUtils.writeToParcel(arg6, v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(6, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void onRepeatModeChanged(int arg6) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    v1.writeInt(arg6);
                    this.mRemote.transact(9, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void onSessionDestroyed() {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    this.mRemote.transact(2, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void onShuffleModeChanged(boolean arg6) {
                int v0 = 1;
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if(!arg6) {
                        goto label_13;
                    }

                    goto label_5;
                }
                catch(Throwable v0_1) {
                    goto label_16;
                }

            label_13:
                v0 = 0;
                try {
                label_5:
                    v1.writeInt(v0);
                    this.mRemote.transact(10, v1, null, 1);
                }
                catch(Throwable v0_1) {
                label_16:
                    v1.recycle();
                    throw v0_1;
                }

                v1.recycle();
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo arg6) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6 != null) {
                        v1.writeInt(1);
                        arg6.writeToParcel(v1, 0);
                    }
                    else {
                        v1.writeInt(0);
                    }

                    this.mRemote.transact(8, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }
        }

        private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
        static final int TRANSACTION_onEvent = 1;
        static final int TRANSACTION_onExtrasChanged = 7;
        static final int TRANSACTION_onMetadataChanged = 4;
        static final int TRANSACTION_onPlaybackStateChanged = 3;
        static final int TRANSACTION_onQueueChanged = 5;
        static final int TRANSACTION_onQueueTitleChanged = 6;
        static final int TRANSACTION_onRepeatModeChanged = 9;
        static final int TRANSACTION_onSessionDestroyed = 2;
        static final int TRANSACTION_onShuffleModeChanged = 10;
        static final int TRANSACTION_onVolumeInfoChanged = 8;

        public Stub() {
            super();
            this.attachInterface(((IInterface)this), "android.support.v4.media.session.IMediaControllerCallback");
        }

        public IBinder asBinder() {
            return this;
        }

        public static IMediaControllerCallback asInterface(IBinder arg2) {
            IInterface v0_1;
            if(arg2 == null) {
                IMediaControllerCallback v0 = null;
            }
            else {
                v0_1 = arg2.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
                if(v0_1 != null && ((v0_1 instanceof IMediaControllerCallback))) {
                    goto label_2;
                }

                Proxy v0_2 = new Proxy(arg2);
            }

        label_2:
            return ((IMediaControllerCallback)v0_1);
        }

        public boolean onTransact(int arg5, Parcel arg6, Parcel arg7, int arg8) {
            Object v0_1;
            Bundle v0 = null;
            boolean v1 = true;
            switch(arg5) {
                case 1: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    String v2 = arg6.readString();
                    if(arg6.readInt() != 0) {
                        v0_1 = Bundle.CREATOR.createFromParcel(arg6);
                    }

                    this.onEvent(v2, v0);
                    break;
                }
                case 2: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.onSessionDestroyed();
                    break;
                }
                case 3: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6.readInt() != 0) {
                        v0_1 = PlaybackStateCompat.CREATOR.createFromParcel(arg6);
                    }

                    this.onPlaybackStateChanged(((PlaybackStateCompat)v0));
                    break;
                }
                case 4: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6.readInt() != 0) {
                        v0_1 = MediaMetadataCompat.CREATOR.createFromParcel(arg6);
                    }

                    this.onMetadataChanged(((MediaMetadataCompat)v0));
                    break;
                }
                case 5: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.onQueueChanged(arg6.createTypedArrayList(QueueItem.CREATOR));
                    break;
                }
                case 6: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6.readInt() != 0) {
                        v0_1 = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg6);
                    }

                    this.onQueueTitleChanged(((CharSequence)v0));
                    break;
                }
                case 7: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6.readInt() != 0) {
                        v0_1 = Bundle.CREATOR.createFromParcel(arg6);
                    }

                    this.onExtrasChanged(v0);
                    break;
                }
                case 8: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6.readInt() != 0) {
                        v0_1 = ParcelableVolumeInfo.CREATOR.createFromParcel(arg6);
                    }

                    this.onVolumeInfoChanged(((ParcelableVolumeInfo)v0));
                    break;
                }
                case 9: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.onRepeatModeChanged(arg6.readInt());
                    break;
                }
                case 10: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    boolean v0_2 = arg6.readInt() != 0 ? true : false;
                    this.onShuffleModeChanged(v0_2);
                    break;
                }
                case 1598968902: {
                    arg7.writeString("android.support.v4.media.session.IMediaControllerCallback");
                    break;
                }
                default: {
                    v1 = super.onTransact(arg5, arg6, arg7, arg8);
                    break;
                }
            }

            return v1;
        }
    }

    void onEvent(String arg1, Bundle arg2);

    void onExtrasChanged(Bundle arg1);

    void onMetadataChanged(MediaMetadataCompat arg1);

    void onPlaybackStateChanged(PlaybackStateCompat arg1);

    void onQueueChanged(List arg1);

    void onQueueTitleChanged(CharSequence arg1);

    void onRepeatModeChanged(int arg1);

    void onSessionDestroyed();

    void onShuffleModeChanged(boolean arg1);

    void onVolumeInfoChanged(ParcelableVolumeInfo arg1);
}

