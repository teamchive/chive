package android.support.v4.media.session;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder$DeathRecipient;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.a.g;
import android.support.v4.media.MediaMetadataCompat;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class MediaControllerCompat {
    class MediaControllerImplApi21 {
        class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference a;

            protected void onReceiveResult(int arg3, Bundle arg4) {
                Object v0 = this.a.get();
                if(v0 != null && arg4 != null) {
                    MediaControllerImplApi21.a(((MediaControllerImplApi21)v0), a.a(g.a(arg4, "android.support.v4.media.session.EXTRA_BINDER")));
                    MediaControllerImplApi21.a(((MediaControllerImplApi21)v0));
                }
            }
        }

        class android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$a extends c {
            android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$a(android.support.v4.media.session.MediaControllerCompat$a arg1) {
                super(arg1);
            }

            public void a() {
                throw new AssertionError();
            }

            public void a(Bundle arg2) {
                throw new AssertionError();
            }

            public void a(MediaMetadataCompat arg2) {
                throw new AssertionError();
            }

            public void a(ParcelableVolumeInfo arg2) {
                throw new AssertionError();
            }

            public void a(CharSequence arg2) {
                throw new AssertionError();
            }

            public void a(List arg2) {
                throw new AssertionError();
            }
        }

        private final List a;
        private b b;
        private HashMap c;

        static b a(MediaControllerImplApi21 arg0, b arg1) {
            arg0.b = arg1;
            return arg1;
        }

        private void a() {
            List v1;
            if(this.b != null) {
                v1 = this.a;
                __monitor_enter(v1);
                try {
                    Iterator v2 = this.a.iterator();
                    while(true) {
                        if(!v2.hasNext()) {
                            goto label_23;
                        }

                        Object v0_1 = v2.next();
                        android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$a v3 = new android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$a(((android.support.v4.media.session.MediaControllerCompat$a)v0_1));
                        this.c.put(v0_1, v3);
                        ((android.support.v4.media.session.MediaControllerCompat$a)v0_1).b = true;
                        try {
                            this.b.a(((android.support.v4.media.session.a)v3));
                            continue;
                        }
                        catch(RemoteException v0_2) {
                            try {
                                Log.e("MediaControllerCompat", "Dead object in registerCallback.", ((Throwable)v0_2));
                            label_23:
                                this.a.clear();
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

        static void a(MediaControllerImplApi21 arg0) {
            arg0.a();
        }
    }

    public abstract class android.support.v4.media.session.MediaControllerCompat$a implements IBinder$DeathRecipient {
        class android.support.v4.media.session.MediaControllerCompat$a$a extends Handler {
            boolean a;

            public void handleMessage(Message arg4) {
                if(this.a) {
                    switch(arg4.what) {
                        case 1: {
                            goto label_6;
                        }
                        case 2: {
                            goto label_11;
                        }
                        case 3: {
                            goto label_15;
                        }
                        case 4: {
                            goto label_51;
                        }
                        case 5: {
                            goto label_19;
                        }
                        case 6: {
                            goto label_23;
                        }
                        case 7: {
                            goto label_47;
                        }
                        case 8: {
                            goto label_55;
                        }
                        case 9: {
                            goto label_32;
                        }
                        case 10: {
                            goto label_37;
                        }
                        case 11: {
                            goto label_27;
                        }
                        case 12: {
                            goto label_42;
                        }
                    }

                    return;
                label_37:
                    this.b.b(arg4.obj.booleanValue());
                    return;
                label_6:
                    this.b.a(arg4.obj, arg4.getData());
                    return;
                label_42:
                    this.b.b(arg4.obj.intValue());
                    return;
                label_11:
                    this.b.a(arg4.obj);
                    return;
                label_15:
                    this.b.a(arg4.obj);
                    return;
                label_47:
                    this.b.a(arg4.obj);
                    return;
                label_51:
                    this.b.a(arg4.obj);
                    return;
                label_19:
                    this.b.a(arg4.obj);
                    return;
                label_23:
                    this.b.a(arg4.obj);
                    return;
                label_55:
                    this.b.a();
                    return;
                label_27:
                    this.b.a(arg4.obj.booleanValue());
                    return;
                label_32:
                    this.b.a(arg4.obj.intValue());
                }
            }
        }

        class android.support.v4.media.session.MediaControllerCompat$a$b implements android.support.v4.media.session.c$a {
            private final WeakReference a;

            android.support.v4.media.session.MediaControllerCompat$a$b(android.support.v4.media.session.MediaControllerCompat$a arg2) {
                super();
                this.a = new WeakReference(arg2);
            }

            public void a() {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a();
                }
            }

            public void a(int arg8, int arg9, int arg10, int arg11, int arg12) {
                Object v6 = this.a.get();
                if(v6 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v6).a(new android.support.v4.media.session.MediaControllerCompat$b(arg8, arg9, arg10, arg11, arg12));
                }
            }

            public void a(Bundle arg2) {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(arg2);
                }
            }

            public void a(CharSequence arg2) {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(arg2);
                }
            }

            public void a(Object arg3) {
                Object v0 = this.a.get();
                if(v0 != null && !((android.support.v4.media.session.MediaControllerCompat$a)v0).b) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(PlaybackStateCompat.a(arg3));
                }
            }

            public void a(String arg4, Bundle arg5) {
                Object v0 = this.a.get();
                if(v0 != null && (!((android.support.v4.media.session.MediaControllerCompat$a)v0).b || Build$VERSION.SDK_INT >= 23)) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(arg4, arg5);
                }
            }

            public void a(List arg3) {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(QueueItem.a(arg3));
                }
            }

            public void b(Object arg3) {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(MediaMetadataCompat.a(arg3));
                }
            }
        }

        class c extends android.support.v4.media.session.a$a {
            private final WeakReference a;

            c(android.support.v4.media.session.MediaControllerCompat$a arg2) {
                super();
                this.a = new WeakReference(arg2);
            }

            public void a() {
                Object v2 = null;
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(8, v2, ((Bundle)v2));
                }
            }

            public void a(int arg5) {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(9, Integer.valueOf(arg5), null);
                }
            }

            public void a(Bundle arg4) {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(7, arg4, null);
                }
            }

            public void a(MediaMetadataCompat arg4) {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(3, arg4, null);
                }
            }

            public void a(ParcelableVolumeInfo arg9) {
                android.support.v4.media.session.MediaControllerCompat$b v0;
                Bundle v7 = null;
                Object v6 = this.a.get();
                if(v6 != null) {
                    if(arg9 != null) {
                        v0 = new android.support.v4.media.session.MediaControllerCompat$b(arg9.a, arg9.b, arg9.c, arg9.d, arg9.e);
                    }
                    else {
                        Object v0_1 = v7;
                    }

                    ((android.support.v4.media.session.MediaControllerCompat$a)v6).a(4, v0, v7);
                }
            }

            public void a(PlaybackStateCompat arg4) {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(2, arg4, null);
                }
            }

            public void a(CharSequence arg4) {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(6, arg4, null);
                }
            }

            public void a(String arg3, Bundle arg4) {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(1, arg3, arg4);
                }
            }

            public void a(List arg4) {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(5, arg4, null);
                }
            }

            public void a(boolean arg5) {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(10, Boolean.valueOf(arg5), null);
                }
            }

            public void b(int arg5) {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(12, Integer.valueOf(arg5), null);
                }
            }

            public void b(boolean arg5) {
                Object v0 = this.a.get();
                if(v0 != null) {
                    ((android.support.v4.media.session.MediaControllerCompat$a)v0).a(11, Boolean.valueOf(arg5), null);
                }
            }
        }

        android.support.v4.media.session.MediaControllerCompat$a$a a;
        boolean b;
        private final Object c;

        public android.support.v4.media.session.MediaControllerCompat$a() {
            super();
            this.c = Build$VERSION.SDK_INT >= 21 ? android.support.v4.media.session.c.a(new android.support.v4.media.session.MediaControllerCompat$a$b(this)) : new c(this);
        }

        public void a() {
        }

        public void a(int arg1) {
        }

        void a(int arg2, Object arg3, Bundle arg4) {
            if(this.a != null) {
                Message v0 = this.a.obtainMessage(arg2, arg3);
                v0.setData(arg4);
                v0.sendToTarget();
            }
        }

        public void a(Bundle arg1) {
        }

        public void a(MediaMetadataCompat arg1) {
        }

        public void a(android.support.v4.media.session.MediaControllerCompat$b arg1) {
        }

        public void a(PlaybackStateCompat arg1) {
        }

        public void a(CharSequence arg1) {
        }

        public void a(String arg1, Bundle arg2) {
        }

        public void a(List arg1) {
        }

        public void a(boolean arg1) {
        }

        public void b(int arg1) {
        }

        @Deprecated public void b(boolean arg1) {
        }
    }

    public final class android.support.v4.media.session.MediaControllerCompat$b {
        private final int a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;

        android.support.v4.media.session.MediaControllerCompat$b(int arg1, int arg2, int arg3, int arg4, int arg5) {
            super();
            this.a = arg1;
            this.b = arg2;
            this.c = arg3;
            this.d = arg4;
            this.e = arg5;
        }
    }

}

