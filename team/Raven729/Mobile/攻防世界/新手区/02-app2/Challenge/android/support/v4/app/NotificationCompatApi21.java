package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification$Builder;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput$Builder;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(value=21) @RequiresApi(value=21) class NotificationCompatApi21 {
    public class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
        private Notification$Builder b;
        private RemoteViews mBigContentView;
        private RemoteViews mContentView;
        private Bundle mExtras;
        private RemoteViews mHeadsUpContentView;

        public Builder(Context arg9, Notification arg10, CharSequence arg11, CharSequence arg12, CharSequence arg13, RemoteViews arg14, int arg15, PendingIntent arg16, PendingIntent arg17, Bitmap arg18, int arg19, int arg20, boolean arg21, boolean arg22, boolean arg23, int arg24, CharSequence arg25, boolean arg26, String arg27, ArrayList arg28, Bundle arg29, int arg30, int arg31, Notification arg32, String arg33, boolean arg34, String arg35, RemoteViews arg36, RemoteViews arg37, RemoteViews arg38) {
            super();
            Notification$Builder v5 = new Notification$Builder(arg9).setWhen(arg10.when).setShowWhen(arg22).setSmallIcon(arg10.icon, arg10.iconLevel).setContent(arg10.contentView).setTicker(arg10.tickerText, arg14).setSound(arg10.sound, arg10.audioStreamType).setVibrate(arg10.vibrate).setLights(arg10.ledARGB, arg10.ledOnMS, arg10.ledOffMS);
            boolean v4 = (arg10.flags & 2) != 0 ? true : false;
            v5 = v5.setOngoing(v4);
            v4 = (arg10.flags & 8) != 0 ? true : false;
            v5 = v5.setOnlyAlertOnce(v4);
            v4 = (arg10.flags & 16) != 0 ? true : false;
            v5 = v5.setAutoCancel(v4).setDefaults(arg10.defaults).setContentTitle(arg11).setContentText(arg12).setSubText(arg25).setContentInfo(arg13).setContentIntent(arg16).setDeleteIntent(arg10.deleteIntent);
            v4 = (arg10.flags & 0x80) != 0 ? true : false;
            this.b = v5.setFullScreenIntent(arg17, v4).setLargeIcon(arg18).setNumber(arg15).setUsesChronometer(arg23).setPriority(arg24).setProgress(arg19, arg20, arg21).setLocalOnly(arg26).setGroup(arg33).setGroupSummary(arg34).setSortKey(arg35).setCategory(arg27).setColor(arg30).setVisibility(arg31).setPublicVersion(arg32);
            this.mExtras = new Bundle();
            if(arg29 != null) {
                this.mExtras.putAll(arg29);
            }

            Iterator v5_1 = arg28.iterator();
            while(v5_1.hasNext()) {
                this.b.addPerson(v5_1.next());
            }

            this.mContentView = arg36;
            this.mBigContentView = arg37;
            this.mHeadsUpContentView = arg38;
        }

        public void addAction(Action arg2) {
            NotificationCompatApi20.addAction(this.b, arg2);
        }

        public Notification build() {
            this.b.setExtras(this.mExtras);
            Notification v0 = this.b.build();
            if(this.mContentView != null) {
                v0.contentView = this.mContentView;
            }

            if(this.mBigContentView != null) {
                v0.bigContentView = this.mBigContentView;
            }

            if(this.mHeadsUpContentView != null) {
                v0.headsUpContentView = this.mHeadsUpContentView;
            }

            return v0;
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
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_MESSAGES = "messages";
    private static final String KEY_ON_READ = "on_read";
    private static final String KEY_ON_REPLY = "on_reply";
    private static final String KEY_PARTICIPANTS = "participants";
    private static final String KEY_REMOTE_INPUT = "remote_input";
    private static final String KEY_TEXT = "text";
    private static final String KEY_TIMESTAMP = "timestamp";

    NotificationCompatApi21() {
        super();
    }

    private static RemoteInput fromCompatRemoteInput(android.support.v4.app.RemoteInputCompatBase$RemoteInput arg2) {
        return new RemoteInput$Builder(arg2.getResultKey()).setLabel(arg2.getLabel()).setChoices(arg2.getChoices()).setAllowFreeFormInput(arg2.getAllowFreeFormInput()).addExtras(arg2.getExtras()).build();
    }

    static Bundle getBundleForUnreadConversation(UnreadConversation arg7) {
        String v0_1;
        Bundle v0 = null;
        int v1 = 0;
        if(arg7 != null) {
            Bundle v2 = new Bundle();
            if(arg7.getParticipants() != null && arg7.getParticipants().length > 1) {
                v0_1 = arg7.getParticipants()[0];
            }

            Parcelable[] v3 = new Parcelable[arg7.getMessages().length];
            while(v1 < v3.length) {
                Bundle v4 = new Bundle();
                v4.putString("text", arg7.getMessages()[v1]);
                v4.putString("author", v0_1);
                v3[v1] = ((Parcelable)v4);
                ++v1;
            }

            v2.putParcelableArray("messages", v3);
            android.support.v4.app.RemoteInputCompatBase$RemoteInput v0_2 = arg7.getRemoteInput();
            if(v0_2 != null) {
                v2.putParcelable("remote_input", NotificationCompatApi21.fromCompatRemoteInput(v0_2));
            }

            v2.putParcelable("on_reply", arg7.getReplyPendingIntent());
            v2.putParcelable("on_read", arg7.getReadPendingIntent());
            v2.putStringArray("participants", arg7.getParticipants());
            v2.putLong("timestamp", arg7.getLatestTimestamp());
            v0 = v2;
        }

        return v0;
    }

    public static String getCategory(Notification arg1) {
        return arg1.category;
    }

    static UnreadConversation getUnreadConversationFromBundle(Bundle arg8, Factory arg9, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory arg10) {
        String[] v1_1;
        int v2 = 0;
        UnreadConversation v6 = null;
        if(arg8 != null) {
            Parcelable[] v4 = arg8.getParcelableArray("messages");
            if(v4 != null) {
                String[] v3 = new String[v4.length];
                int v1 = 0;
                while(true) {
                    if(v1 >= v3.length) {
                        break;
                    }
                    else if((v4[v1] instanceof Bundle)) {
                        v3[v1] = v4[v1].getString("text");
                        if(v3[v1] != null) {
                            ++v1;
                            continue;
                        }
                    }

                    goto label_16;
                }

                v2 = 1;
            label_16:
                if(v2 == 0) {
                    return v6;
                }

                v1_1 = v3;
            }
            else {
                v1_1 = ((String[])v6);
            }

            Parcelable v4_1 = arg8.getParcelable("on_read");
            Parcelable v3_1 = arg8.getParcelable("on_reply");
            Parcelable v0 = arg8.getParcelable("remote_input");
            String[] v5 = arg8.getStringArray("participants");
            if(v5 == null) {
                return v6;
            }

            if(v5.length != 1) {
                return v6;
            }

            android.support.v4.app.RemoteInputCompatBase$RemoteInput v2_1 = v0 != null ? NotificationCompatApi21.toCompatRemoteInput(((RemoteInput)v0), arg10) : ((android.support.v4.app.RemoteInputCompatBase$RemoteInput)v6);
            v6 = arg9.build(v1_1, v2_1, ((PendingIntent)v3_1), ((PendingIntent)v4_1), v5, arg8.getLong("timestamp"));
        }

        return v6;
    }

    private static android.support.v4.app.RemoteInputCompatBase$RemoteInput toCompatRemoteInput(RemoteInput arg6, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory arg7) {
        return arg7.build(arg6.getResultKey(), arg6.getLabel(), arg6.getChoices(), arg6.getAllowFreeFormInput(), arg6.getExtras());
    }
}

