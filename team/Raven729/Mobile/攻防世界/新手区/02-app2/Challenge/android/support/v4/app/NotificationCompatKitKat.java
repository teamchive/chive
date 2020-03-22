package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification$Action;
import android.app.Notification$Builder;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

@TargetApi(value=19) @RequiresApi(value=19) class NotificationCompatKitKat {
    public class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
        private Notification$Builder b;
        private List mActionExtrasList;
        private RemoteViews mBigContentView;
        private RemoteViews mContentView;
        private Bundle mExtras;

        public Builder(Context arg9, Notification arg10, CharSequence arg11, CharSequence arg12, CharSequence arg13, RemoteViews arg14, int arg15, PendingIntent arg16, PendingIntent arg17, Bitmap arg18, int arg19, int arg20, boolean arg21, boolean arg22, boolean arg23, int arg24, CharSequence arg25, boolean arg26, ArrayList arg27, Bundle arg28, String arg29, boolean arg30, String arg31, RemoteViews arg32, RemoteViews arg33) {
            super();
            this.mActionExtrasList = new ArrayList();
            Notification$Builder v5 = new Notification$Builder(arg9).setWhen(arg10.when).setShowWhen(arg22).setSmallIcon(arg10.icon, arg10.iconLevel).setContent(arg10.contentView).setTicker(arg10.tickerText, arg14).setSound(arg10.sound, arg10.audioStreamType).setVibrate(arg10.vibrate).setLights(arg10.ledARGB, arg10.ledOnMS, arg10.ledOffMS);
            boolean v4 = (arg10.flags & 2) != 0 ? true : false;
            v5 = v5.setOngoing(v4);
            v4 = (arg10.flags & 8) != 0 ? true : false;
            v5 = v5.setOnlyAlertOnce(v4);
            v4 = (arg10.flags & 16) != 0 ? true : false;
            v5 = v5.setAutoCancel(v4).setDefaults(arg10.defaults).setContentTitle(arg11).setContentText(arg12).setSubText(arg25).setContentInfo(arg13).setContentIntent(arg16).setDeleteIntent(arg10.deleteIntent);
            v4 = (arg10.flags & 0x80) != 0 ? true : false;
            this.b = v5.setFullScreenIntent(arg17, v4).setLargeIcon(arg18).setNumber(arg15).setUsesChronometer(arg23).setPriority(arg24).setProgress(arg19, arg20, arg21);
            this.mExtras = new Bundle();
            if(arg28 != null) {
                this.mExtras.putAll(arg28);
            }

            if(arg27 != null && !arg27.isEmpty()) {
                this.mExtras.putStringArray("android.people", arg27.toArray(new String[arg27.size()]));
            }

            if(arg26) {
                this.mExtras.putBoolean("android.support.localOnly", true);
            }

            if(arg29 != null) {
                this.mExtras.putString("android.support.groupKey", arg29);
                if(arg30) {
                    this.mExtras.putBoolean("android.support.isGroupSummary", true);
                }
                else {
                    this.mExtras.putBoolean("android.support.useSideChannel", true);
                }
            }

            if(arg31 != null) {
                this.mExtras.putString("android.support.sortKey", arg31);
            }

            this.mContentView = arg32;
            this.mBigContentView = arg33;
        }

        public void addAction(Action arg3) {
            this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.b, arg3));
        }

        public Notification build() {
            SparseArray v0 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
            if(v0 != null) {
                this.mExtras.putSparseParcelableArray("android.support.actionExtras", v0);
            }

            this.b.setExtras(this.mExtras);
            Notification v0_1 = this.b.build();
            if(this.mContentView != null) {
                v0_1.contentView = this.mContentView;
            }

            if(this.mBigContentView != null) {
                v0_1.bigContentView = this.mBigContentView;
            }

            return v0_1;
        }

        public Notification$Builder getBuilder() {
            return this.b;
        }
    }

    NotificationCompatKitKat() {
        super();
    }

    public static Action getAction(Notification arg6, int arg7, Factory arg8, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory arg9) {
        Object v5_1;
        Notification$Action v1 = arg6.actions[arg7];
        Bundle v5 = null;
        SparseArray v0 = arg6.extras.getSparseParcelableArray("android.support.actionExtras");
        if(v0 != null) {
            v5_1 = v0.get(arg7);
        }

        return NotificationCompatJellybean.readAction(arg8, arg9, v1.icon, v1.title, v1.actionIntent, ((Bundle)v5_1));
    }

    public static int getActionCount(Notification arg1) {
        int v0 = arg1.actions != null ? arg1.actions.length : 0;
        return v0;
    }

    public static Bundle getExtras(Notification arg1) {
        return arg1.extras;
    }

    public static String getGroup(Notification arg2) {
        return arg2.extras.getString("android.support.groupKey");
    }

    public static boolean getLocalOnly(Notification arg2) {
        return arg2.extras.getBoolean("android.support.localOnly");
    }

    public static String getSortKey(Notification arg2) {
        return arg2.extras.getString("android.support.sortKey");
    }

    public static boolean isGroupSummary(Notification arg2) {
        return arg2.extras.getBoolean("android.support.isGroupSummary");
    }
}

