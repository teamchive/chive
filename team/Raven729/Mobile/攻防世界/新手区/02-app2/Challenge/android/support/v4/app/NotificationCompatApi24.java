package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification$Action$Builder;
import android.app.Notification$Builder;
import android.app.Notification$MessagingStyle$Message;
import android.app.Notification$MessagingStyle;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(value=24) @RequiresApi(value=24) class NotificationCompatApi24 {
    public class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
        private Notification$Builder b;

        public Builder(Context arg9, Notification arg10, CharSequence arg11, CharSequence arg12, CharSequence arg13, RemoteViews arg14, int arg15, PendingIntent arg16, PendingIntent arg17, Bitmap arg18, int arg19, int arg20, boolean arg21, boolean arg22, boolean arg23, int arg24, CharSequence arg25, boolean arg26, String arg27, ArrayList arg28, Bundle arg29, int arg30, int arg31, Notification arg32, String arg33, boolean arg34, String arg35, CharSequence[] arg36, RemoteViews arg37, RemoteViews arg38, RemoteViews arg39) {
            super();
            Notification$Builder v5 = new Notification$Builder(arg9).setWhen(arg10.when).setShowWhen(arg22).setSmallIcon(arg10.icon, arg10.iconLevel).setContent(arg10.contentView).setTicker(arg10.tickerText, arg14).setSound(arg10.sound, arg10.audioStreamType).setVibrate(arg10.vibrate).setLights(arg10.ledARGB, arg10.ledOnMS, arg10.ledOffMS);
            boolean v4 = (arg10.flags & 2) != 0 ? true : false;
            v5 = v5.setOngoing(v4);
            v4 = (arg10.flags & 8) != 0 ? true : false;
            v5 = v5.setOnlyAlertOnce(v4);
            v4 = (arg10.flags & 16) != 0 ? true : false;
            v5 = v5.setAutoCancel(v4).setDefaults(arg10.defaults).setContentTitle(arg11).setContentText(arg12).setSubText(arg25).setContentInfo(arg13).setContentIntent(arg16).setDeleteIntent(arg10.deleteIntent);
            v4 = (arg10.flags & 0x80) != 0 ? true : false;
            this.b = v5.setFullScreenIntent(arg17, v4).setLargeIcon(arg18).setNumber(arg15).setUsesChronometer(arg23).setPriority(arg24).setProgress(arg19, arg20, arg21).setLocalOnly(arg26).setExtras(arg29).setGroup(arg33).setGroupSummary(arg34).setSortKey(arg35).setCategory(arg27).setColor(arg30).setVisibility(arg31).setPublicVersion(arg32).setRemoteInputHistory(arg36);
            if(arg37 != null) {
                this.b.setCustomContentView(arg37);
            }

            if(arg38 != null) {
                this.b.setCustomBigContentView(arg38);
            }

            if(arg39 != null) {
                this.b.setCustomHeadsUpContentView(arg39);
            }

            Iterator v5_1 = arg28.iterator();
            while(v5_1.hasNext()) {
                this.b.addPerson(v5_1.next());
            }
        }

        public void addAction(Action arg6) {
            Notification$Action$Builder v1 = new Notification$Action$Builder(arg6.getIcon(), arg6.getTitle(), arg6.getActionIntent());
            if(arg6.getRemoteInputs() != null) {
                RemoteInput[] v2 = RemoteInputCompatApi20.fromCompat(arg6.getRemoteInputs());
                int v3 = v2.length;
                int v0;
                for(v0 = 0; v0 < v3; ++v0) {
                    v1.addRemoteInput(v2[v0]);
                }
            }

            Bundle v0_1 = arg6.getExtras() != null ? new Bundle(arg6.getExtras()) : new Bundle();
            v0_1.putBoolean("android.support.allowGeneratedReplies", arg6.getAllowGeneratedReplies());
            v1.addExtras(v0_1);
            v1.setAllowGeneratedReplies(arg6.getAllowGeneratedReplies());
            this.b.addAction(v1.build());
        }

        public Notification build() {
            return this.b.build();
        }

        public Notification$Builder getBuilder() {
            return this.b;
        }
    }

    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";

    NotificationCompatApi24() {
        super();
    }

    public static void addMessagingStyle(NotificationBuilderWithBuilderAccessor arg8, CharSequence arg9, CharSequence arg10, List arg11, List arg12, List arg13, List arg14, List arg15) {
        Notification$MessagingStyle v3 = new Notification$MessagingStyle(arg9).setConversationTitle(arg10);
        int v2;
        for(v2 = 0; v2 < arg11.size(); ++v2) {
            Notification$MessagingStyle$Message v4 = new Notification$MessagingStyle$Message(arg11.get(v2), arg12.get(v2).longValue(), arg13.get(v2));
            if(arg14.get(v2) != null) {
                v4.setData(arg14.get(v2), arg15.get(v2));
            }

            v3.addMessage(v4);
        }

        v3.setBuilder(arg8.getBuilder());
    }
}

