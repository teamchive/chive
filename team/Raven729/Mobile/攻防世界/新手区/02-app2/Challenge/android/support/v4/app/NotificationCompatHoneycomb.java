package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification$Builder;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.widget.RemoteViews;

@TargetApi(value=11) @RequiresApi(value=11) class NotificationCompatHoneycomb {
    NotificationCompatHoneycomb() {
        super();
    }

    static Notification add(Context arg6, Notification arg7, CharSequence arg8, CharSequence arg9, CharSequence arg10, RemoteViews arg11, int arg12, PendingIntent arg13, PendingIntent arg14, Bitmap arg15) {
        boolean v1 = true;
        Notification$Builder v3 = new Notification$Builder(arg6).setWhen(arg7.when).setSmallIcon(arg7.icon, arg7.iconLevel).setContent(arg7.contentView).setTicker(arg7.tickerText, arg11).setSound(arg7.sound, arg7.audioStreamType).setVibrate(arg7.vibrate).setLights(arg7.ledARGB, arg7.ledOnMS, arg7.ledOffMS);
        boolean v0 = (arg7.flags & 2) != 0 ? true : false;
        v3 = v3.setOngoing(v0);
        v0 = (arg7.flags & 8) != 0 ? true : false;
        v3 = v3.setOnlyAlertOnce(v0);
        v0 = (arg7.flags & 16) != 0 ? true : false;
        Notification$Builder v0_1 = v3.setAutoCancel(v0).setDefaults(arg7.defaults).setContentTitle(arg8).setContentText(arg9).setContentInfo(arg10).setContentIntent(arg13).setDeleteIntent(arg7.deleteIntent);
        if((arg7.flags & 0x80) == 0) {
            v1 = false;
        }

        return v0_1.setFullScreenIntent(arg14, v1).setLargeIcon(arg15).setNumber(arg12).getNotification();
    }
}

