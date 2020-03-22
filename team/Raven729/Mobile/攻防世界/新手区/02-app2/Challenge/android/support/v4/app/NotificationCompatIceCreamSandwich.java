package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification$Builder;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.widget.RemoteViews;

@TargetApi(value=14) @RequiresApi(value=14) class NotificationCompatIceCreamSandwich {
    public class Builder implements NotificationBuilderWithBuilderAccessor {
        private Notification$Builder b;

        public Builder(Context arg9, Notification arg10, CharSequence arg11, CharSequence arg12, CharSequence arg13, RemoteViews arg14, int arg15, PendingIntent arg16, PendingIntent arg17, Bitmap arg18, int arg19, int arg20, boolean arg21) {
            super();
            Notification$Builder v5 = new Notification$Builder(arg9).setWhen(arg10.when).setSmallIcon(arg10.icon, arg10.iconLevel).setContent(arg10.contentView).setTicker(arg10.tickerText, arg14).setSound(arg10.sound, arg10.audioStreamType).setVibrate(arg10.vibrate).setLights(arg10.ledARGB, arg10.ledOnMS, arg10.ledOffMS);
            boolean v4 = (arg10.flags & 2) != 0 ? true : false;
            v5 = v5.setOngoing(v4);
            v4 = (arg10.flags & 8) != 0 ? true : false;
            v5 = v5.setOnlyAlertOnce(v4);
            v4 = (arg10.flags & 16) != 0 ? true : false;
            v5 = v5.setAutoCancel(v4).setDefaults(arg10.defaults).setContentTitle(arg11).setContentText(arg12).setContentInfo(arg13).setContentIntent(arg16).setDeleteIntent(arg10.deleteIntent);
            v4 = (arg10.flags & 0x80) != 0 ? true : false;
            this.b = v5.setFullScreenIntent(arg17, v4).setLargeIcon(arg18).setNumber(arg15).setProgress(arg19, arg20, arg21);
        }

        public Notification build() {
            return this.b.getNotification();
        }

        public Notification$Builder getBuilder() {
            return this.b;
        }
    }

    NotificationCompatIceCreamSandwich() {
        super();
    }
}

