package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.v4.e.b;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class MediaBrowserCompat {
    class CustomActionResultReceiver extends b {
        private final String d;
        private final Bundle e;
        private final a f;

        protected void a(int arg4, Bundle arg5) {
            if(this.f != null) {
                switch(arg4) {
                    case -1: {
                        goto label_32;
                    }
                    case 0: {
                        goto label_27;
                    }
                    case 1: {
                        goto label_22;
                    }
                }

                Log.w("MediaBrowserCompat", "Unknown result code: " + arg4 + " (extras=" + this.e + ", resultData=" + arg5 + ")");
                return;
            label_22:
                this.f.a(this.d, this.e, arg5);
                return;
            label_27:
                this.f.b(this.d, this.e, arg5);
                return;
            label_32:
                this.f.c(this.d, this.e, arg5);
            }
        }
    }

    class ItemReceiver extends b {
        private final String d;
        private final android.support.v4.media.MediaBrowserCompat$b e;

        protected void a(int arg3, Bundle arg4) {
            if(arg4 != null) {
                arg4.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }

            if(arg3 != 0 || arg4 == null || !arg4.containsKey("media_item")) {
                this.e.a(this.d);
            }
            else {
                Parcelable v0 = arg4.getParcelable("media_item");
                if(v0 != null && !(v0 instanceof MediaItem)) {
                    this.e.a(this.d);
                    return;
                }

                this.e.a(((MediaItem)v0));
            }
        }
    }

    public class MediaItem implements Parcelable {
        final class android.support.v4.media.MediaBrowserCompat$MediaItem$1 implements Parcelable$Creator {
            android.support.v4.media.MediaBrowserCompat$MediaItem$1() {
                super();
            }

            public MediaItem a(Parcel arg2) {
                return new MediaItem(arg2);
            }

            public MediaItem[] a(int arg2) {
                return new MediaItem[arg2];
            }

            public Object createFromParcel(Parcel arg2) {
                return this.a(arg2);
            }

            public Object[] newArray(int arg2) {
                return this.a(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR;
        private final int a;
        private final MediaDescriptionCompat b;

        static {
            MediaItem.CREATOR = new android.support.v4.media.MediaBrowserCompat$MediaItem$1();
        }

        MediaItem(Parcel arg2) {
            super();
            this.a = arg2.readInt();
            this.b = MediaDescriptionCompat.CREATOR.createFromParcel(arg2);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder("MediaItem{");
            v0.append("mFlags=").append(this.a);
            v0.append(", mDescription=").append(this.b);
            v0.append('}');
            return v0.toString();
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            arg2.writeInt(this.a);
            this.b.writeToParcel(arg2, arg3);
        }
    }

    class SearchResultReceiver extends b {
        private final String d;
        private final Bundle e;
        private final c f;

        protected void a(int arg6, Bundle arg7) {
            if(arg7 != null) {
                arg7.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }

            if(arg6 != 0 || arg7 == null || !arg7.containsKey("search_results")) {
                this.f.a(this.d, this.e);
            }
            else {
                Parcelable[] v3 = arg7.getParcelableArray("search_results");
                List v0 = null;
                if(v3 != null) {
                    ArrayList v1 = new ArrayList();
                    int v4 = v3.length;
                    int v2;
                    for(v2 = 0; v2 < v4; ++v2) {
                        ((List)v1).add(v3[v2]);
                    }

                    ArrayList v0_1 = v1;
                }

                this.f.a(this.d, this.e, v0);
            }
        }
    }

    public abstract class a {
        public void a(String arg1, Bundle arg2, Bundle arg3) {
        }

        public void b(String arg1, Bundle arg2, Bundle arg3) {
        }

        public void c(String arg1, Bundle arg2, Bundle arg3) {
        }
    }

    public abstract class android.support.v4.media.MediaBrowserCompat$b {
        public void a(String arg1) {
        }

        public void a(MediaItem arg1) {
        }
    }

    public abstract class c {
        public void a(String arg1, Bundle arg2, List arg3) {
        }

        public void a(String arg1, Bundle arg2) {
        }
    }

    static final boolean a;

    static {
        MediaBrowserCompat.a = Log.isLoggable("MediaBrowserCompat", 3);
    }
}

