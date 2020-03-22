package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController$Callback;
import android.media.session.MediaController$PlaybackInfo;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

class c {
    public interface a {
        void a();

        void a(int arg1, int arg2, int arg3, int arg4, int arg5);

        void a(Bundle arg1);

        void a(CharSequence arg1);

        void a(Object arg1);

        void a(String arg1, Bundle arg2);

        void a(List arg1);

        void b(Object arg1);
    }

    class b extends MediaController$Callback {
        protected final a a;

        public b(a arg1) {
            super();
            this.a = arg1;
        }

        public void onAudioInfoChanged(MediaController$PlaybackInfo arg7) {
            this.a.a(arg7.getPlaybackType(), android.support.v4.media.session.c$c.b(arg7), arg7.getVolumeControl(), arg7.getMaxVolume(), arg7.getCurrentVolume());
        }

        public void onExtrasChanged(Bundle arg2) {
            this.a.a(arg2);
        }

        public void onMetadataChanged(MediaMetadata arg2) {
            this.a.b(arg2);
        }

        public void onPlaybackStateChanged(PlaybackState arg2) {
            this.a.a(arg2);
        }

        public void onQueueChanged(List arg2) {
            this.a.a(arg2);
        }

        public void onQueueTitleChanged(CharSequence arg2) {
            this.a.a(arg2);
        }

        public void onSessionDestroyed() {
            this.a.a();
        }

        public void onSessionEvent(String arg2, Bundle arg3) {
            this.a.a(arg2, arg3);
        }
    }

    public class android.support.v4.media.session.c$c {
        private static int a(AudioAttributes arg4) {
            int v2 = 4;
            int v0 = 3;
            if((arg4.getFlags() & 1) == 1) {
                v0 = 7;
            }
            else if((arg4.getFlags() & 4) == v2) {
                v0 = 6;
            }
            else {
                switch(arg4.getUsage()) {
                    case 2: {
                        return 0;
                    }
                    case 3: {
                        return 8;
                    }
                    case 4: {
                        return v2;
                    }
                    case 6: {
                        return 2;
                    }
                    case 5: 
                    case 7: 
                    case 8: 
                    case 9: 
                    case 10: {
                        goto label_26;
                    }
                    case 13: {
                        return 1;
                    }
                }

                return v0;
            label_26:
                v0 = 5;
            }

            return v0;
        }

        public static AudioAttributes a(Object arg1) {
            return ((MediaController$PlaybackInfo)arg1).getAudioAttributes();
        }

        public static int b(Object arg1) {
            return android.support.v4.media.session.c$c.a(android.support.v4.media.session.c$c.a(arg1));
        }
    }

    public static Object a(a arg1) {
        return new b(arg1);
    }
}

