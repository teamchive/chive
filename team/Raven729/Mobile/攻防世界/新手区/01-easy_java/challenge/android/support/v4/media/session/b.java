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

public interface b extends IInterface {
    public abstract class a extends Binder implements b {
        class android.support.v4.media.session.b$a$a implements b {
            private IBinder a;

            android.support.v4.media.session.b$a$a(IBinder arg1) {
                super();
                this.a = arg1;
            }

            public void a(int arg6) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeInt(arg6);
                    this.a.transact(44, v1, v2, 0);
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

            public void a(int arg6, int arg7, String arg8) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeInt(arg6);
                    v1.writeInt(arg7);
                    v1.writeString(arg8);
                    this.a.transact(11, v1, v2, 0);
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

            public void a(long arg6) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeLong(arg6);
                    this.a.transact(17, v1, v2, 0);
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

            public void a(Uri arg6, Bundle arg7) {
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

                    this.a.transact(36, v1, v2, 0);
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

            public void a(MediaDescriptionCompat arg6) {
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

                    this.a.transact(41, v1, v2, 0);
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

            public void a(MediaDescriptionCompat arg6, int arg7) {
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
                    this.a.transact(42, v1, v2, 0);
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

            public void a(RatingCompat arg6) {
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

                    this.a.transact(25, v1, v2, 0);
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

            public void a(RatingCompat arg6, Bundle arg7) {
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

                    this.a.transact(51, v1, v2, 0);
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

            public void a(android.support.v4.media.session.a arg6) {
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
                    this.a.transact(3, v1, v2, 0);
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

            public void a(String arg6, Bundle arg7) {
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

                    this.a.transact(34, v1, v2, 0);
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

            public void a(String arg6, Bundle arg7, ResultReceiverWrapper arg8) {
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

                    this.a.transact(1, v1, v2, 0);
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

            public void a(boolean arg6) {
                int v0 = 0;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(arg6) {
                        v0 = 1;
                    }

                    v1.writeInt(v0);
                    this.a.transact(46, v1, v2, 0);
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

            public boolean a() {
                boolean v0 = false;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(5, v1, v2, 0);
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

            public boolean a(KeyEvent arg8) {
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

                    this.a.transact(2, v2, v3, 0);
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

            public IBinder asBinder() {
                return this.a;
            }

            public String b() {
                String v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(6, v1, v2, 0);
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

            public void b(int arg6) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeInt(arg6);
                    this.a.transact(39, v1, v2, 0);
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

            public void b(int arg6, int arg7, String arg8) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeInt(arg6);
                    v1.writeInt(arg7);
                    v1.writeString(arg8);
                    this.a.transact(12, v1, v2, 0);
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

            public void b(long arg6) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeLong(arg6);
                    this.a.transact(24, v1, v2, 0);
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

            public void b(Uri arg6, Bundle arg7) {
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

                    this.a.transact(16, v1, v2, 0);
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

            public void b(MediaDescriptionCompat arg6) {
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

                    this.a.transact(43, v1, v2, 0);
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

            public void b(android.support.v4.media.session.a arg6) {
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
                    this.a.transact(4, v1, v2, 0);
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

            public void b(String arg6, Bundle arg7) {
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

                    this.a.transact(35, v1, v2, 0);
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

            public void b(boolean arg6) {
                int v0 = 0;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(arg6) {
                        v0 = 1;
                    }

                    v1.writeInt(v0);
                    this.a.transact(40, v1, v2, 0);
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

            public String c() {
                String v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(7, v1, v2, 0);
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

            public void c(int arg6) {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    v1.writeInt(arg6);
                    this.a.transact(0x30, v1, v2, 0);
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

            public void c(String arg6, Bundle arg7) {
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

                    this.a.transact(14, v1, v2, 0);
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

            public PendingIntent d() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(8, v1, v2, 0);
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

            public void d(String arg6, Bundle arg7) {
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

                    this.a.transact(15, v1, v2, 0);
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

            public long e() {
                long v4;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(9, v1, v2, 0);
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

            public void e(String arg6, Bundle arg7) {
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

                    this.a.transact(26, v1, v2, 0);
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

            public ParcelableVolumeInfo f() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(10, v1, v2, 0);
                    v2.readException();
                    if(v2.readInt() != 0) {
                        Object v0_1 = ParcelableVolumeInfo.CREATOR.createFromParcel(v2);
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
                return v0_2;
            }

            public MediaMetadataCompat g() {
                Object v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(27, v1, v2, 0);
                    v2.readException();
                    if(v2.readInt() != 0) {
                        v0_1 = MediaMetadataCompat.CREATOR.createFromParcel(v2);
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
                return ((MediaMetadataCompat)v0_1);
            }

            public PlaybackStateCompat h() {
                Object v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(28, v1, v2, 0);
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

            public List i() {
                ArrayList v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(29, v1, v2, 0);
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

            public CharSequence j() {
                Object v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(30, v1, v2, 0);
                    v2.readException();
                    if(v2.readInt() != 0) {
                        v0_1 = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(v2);
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
                return ((CharSequence)v0_1);
            }

            public Bundle k() {
                Object v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(0x1F, v1, v2, 0);
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

            public int l() {
                int v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(0x20, v1, v2, 0);
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

            public boolean m() {
                boolean v0 = false;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(45, v1, v2, 0);
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

            public int n() {
                int v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(37, v1, v2, 0);
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

            public boolean o() {
                boolean v0 = false;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(38, v1, v2, 0);
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

            public int p() {
                int v0_1;
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(0x2F, v1, v2, 0);
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

            public void q() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(33, v1, v2, 0);
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

            public void r() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(13, v1, v2, 0);
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

            public void s() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(18, v1, v2, 0);
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

            public void t() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(19, v1, v2, 0);
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

            public void u() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(20, v1, v2, 0);
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

            public void v() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(21, v1, v2, 0);
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

            public void w() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(22, v1, v2, 0);
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

            public void x() {
                Parcel v1 = Parcel.obtain();
                Parcel v2 = Parcel.obtain();
                try {
                    v1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.a.transact(23, v1, v2, 0);
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
        }

        public static b a(IBinder arg2) {
            IInterface v0_1;
            if(arg2 == null) {
                b v0 = null;
            }
            else {
                v0_1 = arg2.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                if(v0_1 != null && ((v0_1 instanceof b))) {
                    goto label_2;
                }

                android.support.v4.media.session.b$a$a v0_2 = new android.support.v4.media.session.b$a$a(arg2);
            }

        label_2:
            return ((b)v0_1);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int arg6, Parcel arg7, Parcel arg8, int arg9) {
            int v0_10;
            boolean v0_9;
            boolean v1_6;
            String v0_11;
            Uri v1_5;
            Bundle v0_1;
            Object v0;
            String v1_1;
            Object v1_2;
            MediaDescriptionCompat v0_12;
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
                        Bundle v1_4 = v2;
                    }

                    if(arg7.readInt() != 0) {
                        v0 = ResultReceiverWrapper.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        ResultReceiverWrapper v0_5 = ((ResultReceiverWrapper)v2);
                    }

                    this.a(v4, ((Bundle)v1_2), ((ResultReceiverWrapper)v0));
                    arg8.writeNoException();
                    break;
                }
                case 2: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v0 = KeyEvent.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        KeyEvent v0_8 = ((KeyEvent)v2);
                    }

                    v0_9 = this.a(((KeyEvent)v0));
                    arg8.writeNoException();
                    v0_10 = v0_9 ? 1 : 0;
                    arg8.writeInt(v0_10);
                    break;
                }
                case 3: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.a(android.support.v4.media.session.a$a.a(arg7.readStrongBinder()));
                    arg8.writeNoException();
                    break;
                }
                case 4: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.b(android.support.v4.media.session.a$a.a(arg7.readStrongBinder()));
                    arg8.writeNoException();
                    break;
                }
                case 5: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_9 = this.a();
                    arg8.writeNoException();
                    if(v0_9) {
                        v1 = 1;
                    }

                    arg8.writeInt(v1);
                    break;
                }
                case 6: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_11 = this.b();
                    arg8.writeNoException();
                    arg8.writeString(v0_11);
                    break;
                }
                case 7: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_11 = this.c();
                    arg8.writeNoException();
                    arg8.writeString(v0_11);
                    break;
                }
                case 8: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    PendingIntent v0_13 = this.d();
                    arg8.writeNoException();
                    if(v0_13 != null) {
                        arg8.writeInt(1);
                        v0_13.writeToParcel(arg8, 1);
                        return v3;
                    }

                    arg8.writeInt(0);
                    break;
                }
                case 9: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    long v0_14 = this.e();
                    arg8.writeNoException();
                    arg8.writeLong(v0_14);
                    break;
                }
                case 10: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    ParcelableVolumeInfo v0_15 = this.f();
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
                    this.a(arg7.readInt(), arg7.readInt(), arg7.readString());
                    arg8.writeNoException();
                    break;
                }
                case 12: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.b(arg7.readInt(), arg7.readInt(), arg7.readString());
                    arg8.writeNoException();
                    break;
                }
                case 13: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.r();
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

                    this.c(v1_1, ((Bundle)v0));
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

                    this.d(v1_1, ((Bundle)v0));
                    arg8.writeNoException();
                    break;
                }
                case 16: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v1_2 = Uri.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v1_5 = ((Uri)v2);
                    }

                    if(arg7.readInt() != 0) {
                        v0 = Bundle.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_1 = v2;
                    }

                    this.b(((Uri)v1_2), ((Bundle)v0));
                    arg8.writeNoException();
                    break;
                }
                case 17: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.a(arg7.readLong());
                    arg8.writeNoException();
                    break;
                }
                case 18: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.s();
                    arg8.writeNoException();
                    break;
                }
                case 19: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.t();
                    arg8.writeNoException();
                    break;
                }
                case 20: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.u();
                    arg8.writeNoException();
                    break;
                }
                case 21: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.v();
                    arg8.writeNoException();
                    break;
                }
                case 22: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.w();
                    arg8.writeNoException();
                    break;
                }
                case 23: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.x();
                    arg8.writeNoException();
                    break;
                }
                case 24: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.b(arg7.readLong());
                    arg8.writeNoException();
                    break;
                }
                case 25: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v0 = RatingCompat.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        RatingCompat v0_2 = ((RatingCompat)v2);
                    }

                    this.a(((RatingCompat)v0));
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

                    this.e(v1_1, ((Bundle)v0));
                    arg8.writeNoException();
                    break;
                }
                case 27: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    MediaMetadataCompat v0_3 = this.g();
                    arg8.writeNoException();
                    if(v0_3 != null) {
                        arg8.writeInt(1);
                        v0_3.writeToParcel(arg8, 1);
                        return v3;
                    }

                    arg8.writeInt(0);
                    break;
                }
                case 28: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    PlaybackStateCompat v0_4 = this.h();
                    arg8.writeNoException();
                    if(v0_4 != null) {
                        arg8.writeInt(1);
                        v0_4.writeToParcel(arg8, 1);
                        return v3;
                    }

                    arg8.writeInt(0);
                    break;
                }
                case 29: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    List v0_6 = this.i();
                    arg8.writeNoException();
                    arg8.writeTypedList(v0_6);
                    break;
                }
                case 30: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    CharSequence v0_7 = this.j();
                    arg8.writeNoException();
                    if(v0_7 != null) {
                        arg8.writeInt(1);
                        TextUtils.writeToParcel(v0_7, arg8, 1);
                        return v3;
                    }

                    arg8.writeInt(0);
                    break;
                }
                case 31: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_1 = this.k();
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
                    v0_10 = this.l();
                    arg8.writeNoException();
                    arg8.writeInt(v0_10);
                    break;
                }
                case 33: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.q();
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

                    this.a(v1_1, ((Bundle)v0));
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

                    this.b(v1_1, ((Bundle)v0));
                    arg8.writeNoException();
                    break;
                }
                case 36: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v1_2 = Uri.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v1_5 = ((Uri)v2);
                    }

                    if(arg7.readInt() != 0) {
                        v0 = Bundle.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_1 = v2;
                    }

                    this.a(((Uri)v1_2), ((Bundle)v0));
                    arg8.writeNoException();
                    break;
                }
                case 37: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_10 = this.n();
                    arg8.writeNoException();
                    arg8.writeInt(v0_10);
                    break;
                }
                case 38: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_9 = this.o();
                    arg8.writeNoException();
                    if(v0_9) {
                        v1 = 1;
                    }

                    arg8.writeInt(v1);
                    break;
                }
                case 39: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.b(arg7.readInt());
                    arg8.writeNoException();
                    break;
                }
                case 40: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v1_6 = true;
                    }

                    this.b(v1_6);
                    arg8.writeNoException();
                    break;
                }
                case 41: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v0 = MediaDescriptionCompat.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_12 = ((MediaDescriptionCompat)v2);
                    }

                    this.a(v0_12);
                    arg8.writeNoException();
                    break;
                }
                case 42: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v0 = MediaDescriptionCompat.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_12 = ((MediaDescriptionCompat)v2);
                    }

                    this.a(v0_12, arg7.readInt());
                    arg8.writeNoException();
                    break;
                }
                case 43: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v0 = MediaDescriptionCompat.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_12 = ((MediaDescriptionCompat)v2);
                    }

                    this.b(v0_12);
                    arg8.writeNoException();
                    break;
                }
                case 44: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.a(arg7.readInt());
                    arg8.writeNoException();
                    break;
                }
                case 45: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_9 = this.m();
                    arg8.writeNoException();
                    if(v0_9) {
                        v1 = 1;
                    }

                    arg8.writeInt(v1);
                    break;
                }
                case 46: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v1_6 = true;
                    }

                    this.a(v1_6);
                    arg8.writeNoException();
                    break;
                }
                case 47: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    v0_10 = this.p();
                    arg8.writeNoException();
                    arg8.writeInt(v0_10);
                    break;
                }
                case 48: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.c(arg7.readInt());
                    arg8.writeNoException();
                    break;
                }
                case 51: {
                    arg7.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if(arg7.readInt() != 0) {
                        v1_2 = RatingCompat.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        RatingCompat v1_3 = ((RatingCompat)v2);
                    }

                    if(arg7.readInt() != 0) {
                        v0 = Bundle.CREATOR.createFromParcel(arg7);
                    }
                    else {
                        v0_1 = v2;
                    }

                    this.a(((RatingCompat)v1_2), ((Bundle)v0));
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

    void a(android.support.v4.media.session.a arg1);

    void a(int arg1);

    void a(int arg1, int arg2, String arg3);

    void a(long arg1);

    void a(Uri arg1, Bundle arg2);

    void a(MediaDescriptionCompat arg1);

    void a(MediaDescriptionCompat arg1, int arg2);

    void a(RatingCompat arg1);

    void a(RatingCompat arg1, Bundle arg2);

    void a(String arg1, Bundle arg2);

    void a(String arg1, Bundle arg2, ResultReceiverWrapper arg3);

    void a(boolean arg1);

    boolean a();

    boolean a(KeyEvent arg1);

    String b();

    void b(int arg1);

    void b(int arg1, int arg2, String arg3);

    void b(long arg1);

    void b(Uri arg1, Bundle arg2);

    void b(MediaDescriptionCompat arg1);

    void b(android.support.v4.media.session.a arg1);

    void b(String arg1, Bundle arg2);

    void b(boolean arg1);

    String c();

    void c(int arg1);

    void c(String arg1, Bundle arg2);

    PendingIntent d();

    void d(String arg1, Bundle arg2);

    long e();

    void e(String arg1, Bundle arg2);

    ParcelableVolumeInfo f();

    MediaMetadataCompat g();

    PlaybackStateCompat h();

    List i();

    CharSequence j();

    Bundle k();

    int l();

    boolean m();

    int n();

    boolean o();

    int p();

    void q();

    void r();

    void s();

    void t();

    void u();

    void v();

    void w();

    void x();
}

