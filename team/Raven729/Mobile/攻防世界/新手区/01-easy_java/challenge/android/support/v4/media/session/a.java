package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

public interface a extends IInterface {
    public abstract class android.support.v4.media.session.a$a extends Binder implements a {
        class android.support.v4.media.session.a$a$a implements a {
            private IBinder a;

            android.support.v4.media.session.a$a$a(IBinder arg1) {
                super();
                this.a = arg1;
            }

            public void a() {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    this.a.transact(2, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void a(int arg6) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    v1.writeInt(arg6);
                    this.a.transact(9, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void a(Bundle arg6) {
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

                    this.a.transact(7, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void a(MediaMetadataCompat arg6) {
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

                    this.a.transact(4, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void a(ParcelableVolumeInfo arg6) {
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

                    this.a.transact(8, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void a(PlaybackStateCompat arg6) {
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

                    this.a.transact(3, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void a(CharSequence arg6) {
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

                    this.a.transact(6, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void a(String arg6, Bundle arg7) {
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

                    this.a.transact(1, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void a(List arg6) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    v1.writeTypedList(arg6);
                    this.a.transact(5, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void a(boolean arg6) {
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
                    this.a.transact(10, v1, null, 1);
                }
                catch(Throwable v0_1) {
                label_16:
                    v1.recycle();
                    throw v0_1;
                }

                v1.recycle();
            }

            public IBinder asBinder() {
                return this.a;
            }

            public void b(int arg6) {
                Parcel v1 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    v1.writeInt(arg6);
                    this.a.transact(12, v1, null, 1);
                }
                catch(Throwable v0) {
                    v1.recycle();
                    throw v0;
                }

                v1.recycle();
            }

            public void b(boolean arg6) {
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
                    this.a.transact(11, v1, null, 1);
                }
                catch(Throwable v0_1) {
                label_16:
                    v1.recycle();
                    throw v0_1;
                }

                v1.recycle();
            }
        }

        public android.support.v4.media.session.a$a() {
            super();
            this.attachInterface(((IInterface)this), "android.support.v4.media.session.IMediaControllerCallback");
        }

        public static a a(IBinder arg2) {
            android.support.v4.media.session.a$a$a v0_2;
            if(arg2 == null) {
                a v0 = null;
            }
            else {
                IInterface v0_1 = arg2.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
                if(v0_1 != null && ((v0_1 instanceof a))) {
                    goto label_2;
                }

                v0_2 = new android.support.v4.media.session.a$a$a(arg2);
            }

        label_2:
            return ((a)v0_2);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int arg5, Parcel arg6, Parcel arg7, int arg8) {
            Object v0_1;
            boolean v2 = false;
            Bundle v0 = null;
            boolean v1 = true;
            switch(arg5) {
                case 1: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    String v2_1 = arg6.readString();
                    if(arg6.readInt() != 0) {
                        v0_1 = Bundle.CREATOR.createFromParcel(arg6);
                    }

                    this.a(v2_1, ((Bundle)v0_1));
                    break;
                }
                case 2: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.a();
                    break;
                }
                case 3: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6.readInt() != 0) {
                        v0_1 = PlaybackStateCompat.CREATOR.createFromParcel(arg6);
                    }

                    this.a(((PlaybackStateCompat)v0_1));
                    break;
                }
                case 4: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6.readInt() != 0) {
                        v0_1 = MediaMetadataCompat.CREATOR.createFromParcel(arg6);
                    }

                    this.a(((MediaMetadataCompat)v0_1));
                    break;
                }
                case 5: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.a(arg6.createTypedArrayList(QueueItem.CREATOR));
                    break;
                }
                case 6: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6.readInt() != 0) {
                        v0_1 = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg6);
                    }

                    this.a(((CharSequence)v0_1));
                    break;
                }
                case 7: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6.readInt() != 0) {
                        v0_1 = Bundle.CREATOR.createFromParcel(arg6);
                    }

                    this.a(((Bundle)v0_1));
                    break;
                }
                case 8: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6.readInt() != 0) {
                        v0_1 = ParcelableVolumeInfo.CREATOR.createFromParcel(arg6);
                    }

                    this.a(((ParcelableVolumeInfo)v0_1));
                    break;
                }
                case 9: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.a(arg6.readInt());
                    break;
                }
                case 10: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    boolean v0_2 = arg6.readInt() != 0 ? true : false;
                    this.a(v0_2);
                    break;
                }
                case 11: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(arg6.readInt() != 0) {
                        v2 = true;
                    }

                    this.b(v2);
                    break;
                }
                case 12: {
                    arg6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.b(arg6.readInt());
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

    void a();

    void a(int arg1);

    void a(Bundle arg1);

    void a(MediaMetadataCompat arg1);

    void a(ParcelableVolumeInfo arg1);

    void a(PlaybackStateCompat arg1);

    void a(CharSequence arg1);

    void a(String arg1, Bundle arg2);

    void a(List arg1);

    void a(boolean arg1);

    void b(int arg1);

    void b(boolean arg1);
}

