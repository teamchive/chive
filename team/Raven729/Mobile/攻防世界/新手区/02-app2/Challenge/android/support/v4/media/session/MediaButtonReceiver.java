package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    public MediaButtonReceiver() {
        super();
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context arg3, long arg4) {
        PendingIntent v0_1;
        ComponentName v0 = MediaButtonReceiver.getMediaButtonReceiverComponent(arg3);
        if(v0 == null) {
            Log.w("MediaButtonReceiver", "A unique media button receiver could not be found in the given context, so couldn\'t build a pending intent.");
            v0_1 = null;
        }
        else {
            v0_1 = MediaButtonReceiver.buildMediaButtonPendingIntent(arg3, v0, arg4);
        }

        return v0_1;
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context arg6, ComponentName arg7, long arg8) {
        PendingIntent v0 = null;
        if(arg7 == null) {
            Log.w("MediaButtonReceiver", "The component name of media button receiver should be provided.");
        }
        else {
            int v1 = PlaybackStateCompat.toKeyCode(arg8);
            if(v1 == 0) {
                Log.w("MediaButtonReceiver", "Cannot build a media button pending intent with the given action: " + arg8);
            }
            else {
                Intent v0_1 = new Intent("android.intent.action.MEDIA_BUTTON");
                v0_1.setComponent(arg7);
                v0_1.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, v1));
                v0 = PendingIntent.getBroadcast(arg6, v1, v0_1, 0);
            }
        }

        return v0;
    }

    static ComponentName getMediaButtonReceiverComponent(Context arg4) {
        ComponentName v0_3;
        Intent v0 = new Intent("android.intent.action.MEDIA_BUTTON");
        v0.setPackage(arg4.getPackageName());
        List v0_1 = arg4.getPackageManager().queryBroadcastReceivers(v0, 0);
        if(v0_1.size() == 1) {
            Object v0_2 = v0_1.get(0);
            v0_3 = new ComponentName(((ResolveInfo)v0_2).activityInfo.packageName, ((ResolveInfo)v0_2).activityInfo.name);
        }
        else {
            if(v0_1.size() > 1) {
                Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
            }

            v0_3 = null;
        }

        return v0_3;
    }

    public static KeyEvent handleIntent(MediaSessionCompat arg2, Intent arg3) {
        KeyEvent v0_1;
        if(arg2 == null || arg3 == null || !"android.intent.action.MEDIA_BUTTON".equals(arg3.getAction()) || !arg3.hasExtra("android.intent.extra.KEY_EVENT")) {
            v0_1 = null;
        }
        else {
            Parcelable v0 = arg3.getParcelableExtra("android.intent.extra.KEY_EVENT");
            arg2.getController().dispatchMediaButtonEvent(((KeyEvent)v0));
        }

        return v0_1;
    }

    public void onReceive(Context arg6, Intent arg7) {
        Intent v1 = new Intent("android.intent.action.MEDIA_BUTTON");
        v1.setPackage(arg6.getPackageName());
        PackageManager v2 = arg6.getPackageManager();
        List v0 = v2.queryIntentServices(v1, 0);
        if(v0.isEmpty()) {
            v1.setAction("android.media.browse.MediaBrowserService");
            v0 = v2.queryIntentServices(v1, 0);
        }

        if(v0.isEmpty()) {
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or a media browser service implementation");
        }

        if(v0.size() != 1) {
            throw new IllegalStateException("Expected 1 Service that handles " + v1.getAction() + ", found " + v0.size());
        }

        Object v0_1 = v0.get(0);
        arg7.setComponent(new ComponentName(((ResolveInfo)v0_1).serviceInfo.packageName, ((ResolveInfo)v0_1).serviceInfo.name));
        arg6.startService(arg7);
    }
}

