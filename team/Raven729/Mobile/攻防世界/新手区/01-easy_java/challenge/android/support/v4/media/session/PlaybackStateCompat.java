package android.support.v4.media.session;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    final class android.support.v4.media.session.PlaybackStateCompat$1 implements Parcelable$Creator {
        android.support.v4.media.session.PlaybackStateCompat$1() {
            super();
        }

        public PlaybackStateCompat a(Parcel arg2) {
            return new PlaybackStateCompat(arg2);
        }

        public PlaybackStateCompat[] a(int arg2) {
            return new PlaybackStateCompat[arg2];
        }

        public Object createFromParcel(Parcel arg2) {
            return this.a(arg2);
        }

        public Object[] newArray(int arg2) {
            return this.a(arg2);
        }
    }

    public final class CustomAction implements Parcelable {
        final class android.support.v4.media.session.PlaybackStateCompat$CustomAction$1 implements Parcelable$Creator {
            android.support.v4.media.session.PlaybackStateCompat$CustomAction$1() {
                super();
            }

            public CustomAction a(Parcel arg2) {
                return new CustomAction(arg2);
            }

            public CustomAction[] a(int arg2) {
                return new CustomAction[arg2];
            }

            public Object createFromParcel(Parcel arg2) {
                return this.a(arg2);
            }

            public Object[] newArray(int arg2) {
                return this.a(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR;
        private final String a;
        private final CharSequence b;
        private final int c;
        private final Bundle d;
        private Object e;

        static {
            CustomAction.CREATOR = new android.support.v4.media.session.PlaybackStateCompat$CustomAction$1();
        }

        CustomAction(Parcel arg2) {
            super();
            this.a = arg2.readString();
            this.b = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg2);
            this.c = arg2.readInt();
            this.d = arg2.readBundle();
        }

        CustomAction(String arg1, CharSequence arg2, int arg3, Bundle arg4) {
            super();
            this.a = arg1;
            this.b = arg2;
            this.c = arg3;
            this.d = arg4;
        }

        public static CustomAction a(Object arg5) {
            CustomAction v0;
            if(arg5 == null || Build$VERSION.SDK_INT < 21) {
                v0 = null;
            }
            else {
                v0 = new CustomAction(a.a(arg5), a.b(arg5), a.c(arg5), a.d(arg5));
                v0.e = arg5;
            }

            return v0;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName=\'" + this.b + ", mIcon=" + this.c + ", mExtras=" + this.d;
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            arg2.writeString(this.a);
            TextUtils.writeToParcel(this.b, arg2, arg3);
            arg2.writeInt(this.c);
            arg2.writeBundle(this.d);
        }
    }

    public static final Parcelable$Creator CREATOR;
    final int a;
    final long b;
    final long c;
    final float d;
    final long e;
    final int f;
    final CharSequence g;
    final long h;
    List i;
    final long j;
    final Bundle k;
    private Object l;

    static {
        PlaybackStateCompat.CREATOR = new android.support.v4.media.session.PlaybackStateCompat$1();
    }

    PlaybackStateCompat(int arg5, long arg6, long arg8, float arg10, long arg11, int arg13, CharSequence arg14, long arg15, List arg17, long arg18, Bundle arg20) {
        super();
        this.a = arg5;
        this.b = arg6;
        this.c = arg8;
        this.d = arg10;
        this.e = arg11;
        this.f = arg13;
        this.g = arg14;
        this.h = arg15;
        this.i = new ArrayList(arg17);
        this.j = arg18;
        this.k = arg20;
    }

    PlaybackStateCompat(Parcel arg3) {
        super();
        this.a = arg3.readInt();
        this.b = arg3.readLong();
        this.d = arg3.readFloat();
        this.h = arg3.readLong();
        this.c = arg3.readLong();
        this.e = arg3.readLong();
        this.g = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg3);
        this.i = arg3.createTypedArrayList(CustomAction.CREATOR);
        this.j = arg3.readLong();
        this.k = arg3.readBundle();
        this.f = arg3.readInt();
    }

    public static PlaybackStateCompat a(Object arg19) {
        PlaybackStateCompat v2_2;
        if(arg19 == null || Build$VERSION.SDK_INT < 21) {
            v2_2 = null;
        }
        else {
            List v2 = e.h(arg19);
            List v15 = null;
            if(v2 != null) {
                ArrayList v15_1 = new ArrayList(v2.size());
                Iterator v2_1 = v2.iterator();
                while(v2_1.hasNext()) {
                    ((List)v15_1).add(CustomAction.a(v2_1.next()));
                }
            }

            Bundle v18 = Build$VERSION.SDK_INT >= 22 ? f.a(arg19) : null;
            v2_2 = new PlaybackStateCompat(e.a(arg19), e.b(arg19), e.c(arg19), e.d(arg19), e.e(arg19), 0, e.f(arg19), e.g(arg19), v15, e.i(arg19), v18);
            v2_2.l = arg19;
        }

        return v2_2;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("PlaybackState {");
        v0.append("state=").append(this.a);
        v0.append(", position=").append(this.b);
        v0.append(", buffered position=").append(this.c);
        v0.append(", speed=").append(this.d);
        v0.append(", updated=").append(this.h);
        v0.append(", actions=").append(this.e);
        v0.append(", error code=").append(this.f);
        v0.append(", error message=").append(this.g);
        v0.append(", custom actions=").append(this.i);
        v0.append(", active item id=").append(this.j);
        v0.append("}");
        return v0.toString();
    }

    public void writeToParcel(Parcel arg3, int arg4) {
        arg3.writeInt(this.a);
        arg3.writeLong(this.b);
        arg3.writeFloat(this.d);
        arg3.writeLong(this.h);
        arg3.writeLong(this.c);
        arg3.writeLong(this.e);
        TextUtils.writeToParcel(this.g, arg3, arg4);
        arg3.writeTypedList(this.i);
        arg3.writeLong(this.j);
        arg3.writeBundle(this.k);
        arg3.writeInt(this.f);
    }
}

