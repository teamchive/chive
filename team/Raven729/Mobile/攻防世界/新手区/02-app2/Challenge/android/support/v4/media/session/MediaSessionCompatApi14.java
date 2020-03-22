package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.media.RemoteControlClient$MetadataEditor;
import android.media.RemoteControlClient;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(value=14) @RequiresApi(value=14) class MediaSessionCompatApi14 {
    private static final long ACTION_FAST_FORWARD = 0x40;
    private static final long ACTION_PAUSE = 2;
    private static final long ACTION_PLAY = 4;
    private static final long ACTION_PLAY_PAUSE = 0x200;
    private static final long ACTION_REWIND = 8;
    private static final long ACTION_SKIP_TO_NEXT = 0x20;
    private static final long ACTION_SKIP_TO_PREVIOUS = 16;
    private static final long ACTION_STOP = 1;
    private static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    private static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    private static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    private static final String METADATA_KEY_ART = "android.media.metadata.ART";
    private static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    private static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    private static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    private static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    private static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    private static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    private static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    private static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    private static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    private static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    private static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    static final int RCC_PLAYSTATE_NONE = 0;
    static final int STATE_BUFFERING = 6;
    static final int STATE_CONNECTING = 8;
    static final int STATE_ERROR = 7;
    static final int STATE_FAST_FORWARDING = 4;
    static final int STATE_NONE = 0;
    static final int STATE_PAUSED = 2;
    static final int STATE_PLAYING = 3;
    static final int STATE_REWINDING = 5;
    static final int STATE_SKIPPING_TO_NEXT = 10;
    static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    static final int STATE_STOPPED = 1;

    MediaSessionCompatApi14() {
        super();
    }

    static void buildOldMetadata(Bundle arg4, RemoteControlClient$MetadataEditor arg5) {
        int v1 = 100;
        if(arg4 != null) {
            if(arg4.containsKey("android.media.metadata.ART")) {
                arg5.putBitmap(v1, arg4.getParcelable("android.media.metadata.ART"));
            }
            else if(arg4.containsKey("android.media.metadata.ALBUM_ART")) {
                arg5.putBitmap(v1, arg4.getParcelable("android.media.metadata.ALBUM_ART"));
            }

            if(arg4.containsKey("android.media.metadata.ALBUM")) {
                arg5.putString(1, arg4.getString("android.media.metadata.ALBUM"));
            }

            if(arg4.containsKey("android.media.metadata.ALBUM_ARTIST")) {
                arg5.putString(13, arg4.getString("android.media.metadata.ALBUM_ARTIST"));
            }

            if(arg4.containsKey("android.media.metadata.ARTIST")) {
                arg5.putString(2, arg4.getString("android.media.metadata.ARTIST"));
            }

            if(arg4.containsKey("android.media.metadata.AUTHOR")) {
                arg5.putString(3, arg4.getString("android.media.metadata.AUTHOR"));
            }

            if(arg4.containsKey("android.media.metadata.COMPILATION")) {
                arg5.putString(15, arg4.getString("android.media.metadata.COMPILATION"));
            }

            if(arg4.containsKey("android.media.metadata.COMPOSER")) {
                arg5.putString(4, arg4.getString("android.media.metadata.COMPOSER"));
            }

            if(arg4.containsKey("android.media.metadata.DATE")) {
                arg5.putString(5, arg4.getString("android.media.metadata.DATE"));
            }

            if(arg4.containsKey("android.media.metadata.DISC_NUMBER")) {
                arg5.putLong(14, arg4.getLong("android.media.metadata.DISC_NUMBER"));
            }

            if(arg4.containsKey("android.media.metadata.DURATION")) {
                arg5.putLong(9, arg4.getLong("android.media.metadata.DURATION"));
            }

            if(arg4.containsKey("android.media.metadata.GENRE")) {
                arg5.putString(6, arg4.getString("android.media.metadata.GENRE"));
            }

            if(arg4.containsKey("android.media.metadata.TITLE")) {
                arg5.putString(7, arg4.getString("android.media.metadata.TITLE"));
            }

            if(arg4.containsKey("android.media.metadata.TRACK_NUMBER")) {
                arg5.putLong(0, arg4.getLong("android.media.metadata.TRACK_NUMBER"));
            }

            if(!arg4.containsKey("android.media.metadata.WRITER")) {
                return;
            }

            arg5.putString(11, arg4.getString("android.media.metadata.WRITER"));
        }
    }

    public static Object createRemoteControlClient(PendingIntent arg1) {
        return new RemoteControlClient(arg1);
    }

    static int getRccStateFromState(int arg1) {
        int v0;
        switch(arg1) {
            case 0: {
                v0 = 0;
                break;
            }
            case 1: {
                v0 = 1;
                break;
            }
            case 2: {
                v0 = 2;
                break;
            }
            case 3: {
                v0 = 3;
                break;
            }
            case 4: {
                v0 = 4;
                break;
            }
            case 5: {
                v0 = 5;
                break;
            }
            case 7: {
                v0 = 9;
                break;
            }
            case 6: 
            case 8: {
                v0 = 8;
                break;
            }
            case 9: {
                v0 = 7;
                break;
            }
            case 10: 
            case 11: {
                v0 = 6;
                break;
            }
            default: {
                v0 = -1;
                break;
            }
        }

        return v0;
    }

    static int getRccTransportControlFlagsFromActions(long arg6) {
        long v4 = 0;
        int v0 = 0;
        if((1 & arg6) != v4) {
            v0 = 0x20;
        }

        if((2 & arg6) != v4) {
            v0 |= 16;
        }

        if((4 & arg6) != v4) {
            v0 |= 4;
        }

        if((8 & arg6) != v4) {
            v0 |= 2;
        }

        if((16 & arg6) != v4) {
            v0 |= 1;
        }

        if((0x20 & arg6) != v4) {
            v0 |= 0x80;
        }

        if((0x40 & arg6) != v4) {
            v0 |= 0x40;
        }

        if((0x200 & arg6) != v4) {
            v0 |= 8;
        }

        return v0;
    }

    public static void registerRemoteControlClient(Context arg1, Object arg2) {
        arg1.getSystemService("audio").registerRemoteControlClient(((RemoteControlClient)arg2));
    }

    public static void setMetadata(Object arg1, Bundle arg2) {
        RemoteControlClient$MetadataEditor v0 = ((RemoteControlClient)arg1).editMetadata(true);
        MediaSessionCompatApi14.buildOldMetadata(arg2, v0);
        v0.apply();
    }

    public static void setState(Object arg1, int arg2) {
        ((RemoteControlClient)arg1).setPlaybackState(MediaSessionCompatApi14.getRccStateFromState(arg2));
    }

    public static void setTransportControlFlags(Object arg1, long arg2) {
        ((RemoteControlClient)arg1).setTransportControlFlags(MediaSessionCompatApi14.getRccTransportControlFlagsFromActions(arg2));
    }

    public static void unregisterRemoteControlClient(Context arg1, Object arg2) {
        arg1.getSystemService("audio").unregisterRemoteControlClient(((RemoteControlClient)arg2));
    }
}

