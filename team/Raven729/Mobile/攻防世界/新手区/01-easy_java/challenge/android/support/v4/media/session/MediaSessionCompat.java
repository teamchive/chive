package android.support.v4.media.session;

import android.os.Build$VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaSessionCompat {
    public final class QueueItem implements Parcelable {
        final class android.support.v4.media.session.MediaSessionCompat$QueueItem$1 implements Parcelable$Creator {
            android.support.v4.media.session.MediaSessionCompat$QueueItem$1() {
                super();
            }

            public QueueItem a(Parcel arg2) {
                return new QueueItem(arg2);
            }

            public QueueItem[] a(int arg2) {
                return new QueueItem[arg2];
            }

            public Object createFromParcel(Parcel arg2) {
                return this.a(arg2);
            }

            public Object[] newArray(int arg2) {
                return this.a(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR;
        private final MediaDescriptionCompat a;
        private final long b;
        private Object c;

        static {
            QueueItem.CREATOR = new android.support.v4.media.session.MediaSessionCompat$QueueItem$1();
        }

        QueueItem(Parcel arg3) {
            super();
            this.a = MediaDescriptionCompat.CREATOR.createFromParcel(arg3);
            this.b = arg3.readLong();
        }

        private QueueItem(Object arg4, MediaDescriptionCompat arg5, long arg6) {
            super();
            if(arg5 == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            }

            if(arg6 == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }

            this.a = arg5;
            this.b = arg6;
            this.c = arg4;
        }

        public static List a(List arg3) {
            ArrayList v0;
            if(arg3 == null || Build$VERSION.SDK_INT < 21) {
                List v0_1 = null;
            }
            else {
                v0 = new ArrayList();
                Iterator v1 = arg3.iterator();
                while(v1.hasNext()) {
                    ((List)v0).add(QueueItem.a(v1.next()));
                }
            }

            return ((List)v0);
        }

        public static QueueItem a(Object arg4) {
            QueueItem v0 = arg4 == null || Build$VERSION.SDK_INT < 21 ? null : new QueueItem(arg4, MediaDescriptionCompat.a(a.a(arg4)), a.b(arg4));
            return v0;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.a + ", Id=" + this.b + " }";
        }

        public void writeToParcel(Parcel arg3, int arg4) {
            this.a.writeToParcel(arg3, arg4);
            arg3.writeLong(this.b);
        }
    }

    final class ResultReceiverWrapper implements Parcelable {
        final class android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$1 implements Parcelable$Creator {
            android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$1() {
                super();
            }

            public ResultReceiverWrapper a(Parcel arg2) {
                return new ResultReceiverWrapper(arg2);
            }

            public ResultReceiverWrapper[] a(int arg2) {
                return new ResultReceiverWrapper[arg2];
            }

            public Object createFromParcel(Parcel arg2) {
                return this.a(arg2);
            }

            public Object[] newArray(int arg2) {
                return this.a(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR;
        private ResultReceiver a;

        static {
            ResultReceiverWrapper.CREATOR = new android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$1();
        }

        ResultReceiverWrapper(Parcel arg2) {
            super();
            this.a = ResultReceiver.CREATOR.createFromParcel(arg2);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            this.a.writeToParcel(arg2, arg3);
        }
    }

    public final class Token implements Parcelable {
        final class android.support.v4.media.session.MediaSessionCompat$Token$1 implements Parcelable$Creator {
            android.support.v4.media.session.MediaSessionCompat$Token$1() {
                super();
            }

            public Token a(Parcel arg3) {
                IBinder v0_1;
                if(Build$VERSION.SDK_INT >= 21) {
                    Parcelable v0 = arg3.readParcelable(null);
                }
                else {
                    v0_1 = arg3.readStrongBinder();
                }

                return new Token(v0_1);
            }

            public Token[] a(int arg2) {
                return new Token[arg2];
            }

            public Object createFromParcel(Parcel arg2) {
                return this.a(arg2);
            }

            public Object[] newArray(int arg2) {
                return this.a(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR;
        private final Object a;
        private final b b;

        static {
            Token.CREATOR = new android.support.v4.media.session.MediaSessionCompat$Token$1();
        }

        Token(Object arg2) {
            this(arg2, null);
        }

        Token(Object arg1, b arg2) {
            super();
            this.a = arg1;
            this.b = arg2;
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
                else if(this.a == null) {
                    if(((Token)arg4).a != null) {
                        v0 = false;
                    }
                }
                else if(((Token)arg4).a == null) {
                    v0 = false;
                }
                else {
                    v0 = this.a.equals(((Token)arg4).a);
                }
            }

            return v0;
        }

        public int hashCode() {
            int v0 = this.a == null ? 0 : this.a.hashCode();
            return v0;
        }

        public void writeToParcel(Parcel arg3, int arg4) {
            if(Build$VERSION.SDK_INT >= 21) {
                arg3.writeParcelable(this.a, arg4);
            }
            else {
                arg3.writeStrongBinder(this.a);
            }
        }
    }

}

