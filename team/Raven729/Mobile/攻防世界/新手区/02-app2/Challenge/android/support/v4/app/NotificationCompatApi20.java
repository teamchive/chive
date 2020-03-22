package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification$Action$Builder;
import android.app.Notification$Action;
import android.app.Notification$Builder;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.RemoteViews;
import java.util.ArrayList;

@TargetApi(value=20) @RequiresApi(value=20) class NotificationCompatApi20 {
    public class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
        private Notification$Builder b;
        private RemoteViews mBigContentView;
        private RemoteViews mContentView;
        private Bundle mExtras;

        public Builder(Context arg9, Notification arg10, CharSequence arg11, CharSequence arg12, CharSequence arg13, RemoteViews arg14, int arg15, PendingIntent arg16, PendingIntent arg17, Bitmap arg18, int arg19, int arg20, boolean arg21, boolean arg22, boolean arg23, int arg24, CharSequence arg25, boolean arg26, ArrayList arg27, Bundle arg28, String arg29, boolean arg30, String arg31, RemoteViews arg32, RemoteViews arg33) {
            super();
            Notification$Builder v5 = new Notification$Builder(arg9).setWhen(arg10.when).setShowWhen(arg22).setSmallIcon(arg10.icon, arg10.iconLevel).setContent(arg10.contentView).setTicker(arg10.tickerText, arg14).setSound(arg10.sound, arg10.audioStreamType).setVibrate(arg10.vibrate).setLights(arg10.ledARGB, arg10.ledOnMS, arg10.ledOffMS);
            boolean v4 = (arg10.flags & 2) != 0 ? true : false;
            v5 = v5.setOngoing(v4);
            v4 = (arg10.flags & 8) != 0 ? true : false;
            v5 = v5.setOnlyAlertOnce(v4);
            v4 = (arg10.flags & 16) != 0 ? true : false;
            v5 = v5.setAutoCancel(v4).setDefaults(arg10.defaults).setContentTitle(arg11).setContentText(arg12).setSubText(arg25).setContentInfo(arg13).setContentIntent(arg16).setDeleteIntent(arg10.deleteIntent);
            v4 = (arg10.flags & 0x80) != 0 ? true : false;
            this.b = v5.setFullScreenIntent(arg17, v4).setLargeIcon(arg18).setNumber(arg15).setUsesChronometer(arg23).setPriority(arg24).setProgress(arg19, arg20, arg21).setLocalOnly(arg26).setGroup(arg29).setGroupSummary(arg30).setSortKey(arg31);
            this.mExtras = new Bundle();
            if(arg28 != null) {
                this.mExtras.putAll(arg28);
            }

            if(arg27 != null && !arg27.isEmpty()) {
                this.mExtras.putStringArray("android.people", arg27.toArray(new String[arg27.size()]));
            }

            this.mContentView = arg32;
            this.mBigContentView = arg33;
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

            return v0;
        }

        public Notification$Builder getBuilder() {
            return this.b;
        }
    }

    NotificationCompatApi20() {
        super();
    }

    public static void addAction(Notification$Builder arg5, Action arg6) {
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
        arg5.addAction(v1.build());
    }

    public static Action getAction(Notification arg1, int arg2, Factory arg3, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory arg4) {
        return NotificationCompatApi20.getActionCompatFromAction(arg1.actions[arg2], arg3, arg4);
    }

    private static Action getActionCompatFromAction(Notification$Action arg7, Factory arg8, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory arg9) {
        return arg8.build(arg7.icon, arg7.title, arg7.actionIntent, arg7.getExtras(), RemoteInputCompatApi20.toCompat(arg7.getRemoteInputs(), arg9), arg7.getExtras().getBoolean("android.support.allowGeneratedReplies"));
    }

    private static Notification$Action getActionFromActionCompat(Action arg5) {
        Notification$Action$Builder v1 = new Notification$Action$Builder(arg5.getIcon(), arg5.getTitle(), arg5.getActionIntent());
        Bundle v0 = arg5.getExtras() != null ? new Bundle(arg5.getExtras()) : new Bundle();
        v0.putBoolean("android.support.allowGeneratedReplies", arg5.getAllowGeneratedReplies());
        v1.addExtras(v0);
        android.support.v4.app.RemoteInputCompatBase$RemoteInput[] v0_1 = arg5.getRemoteInputs();
        if(v0_1 != null) {
            RemoteInput[] v2 = RemoteInputCompatApi20.fromCompat(v0_1);
            int v3 = v2.length;
            int v0_2;
            for(v0_2 = 0; v0_2 < v3; ++v0_2) {
                v1.addRemoteInput(v2[v0_2]);
            }
        }

        return v1.build();
    }

    public static Action[] getActionsFromParcelableArrayList(ArrayList arg3, Factory arg4, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory arg5) {
        Action[] v0;
        if(arg3 == null) {
            v0 = null;
        }
        else {
            Action[] v2 = arg4.newArray(arg3.size());
            int v1;
            for(v1 = 0; v1 < v2.length; ++v1) {
                v2[v1] = NotificationCompatApi20.getActionCompatFromAction(arg3.get(v1), arg4, arg5);
            }

            v0 = v2;
        }

        return v0;
    }

    public static String getGroup(Notification arg1) {
        return arg1.getGroup();
    }

    public static boolean getLocalOnly(Notification arg1) {
        boolean v0 = (arg1.flags & 0x100) != 0 ? true : false;
        return v0;
    }

    public static ArrayList getParcelableArrayListForActions(Action[] arg4) {
        ArrayList v0;
        if(arg4 == null) {
            v0 = null;
        }
        else {
            v0 = new ArrayList(arg4.length);
            int v2 = arg4.length;
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                v0.add(NotificationCompatApi20.getActionFromActionCompat(arg4[v1]));
            }
        }

        return v0;
    }

    public static String getSortKey(Notification arg1) {
        return arg1.getSortKey();
    }

    public static boolean isGroupSummary(Notification arg1) {
        boolean v0 = (arg1.flags & 0x200) != 0 ? true : false;
        return v0;
    }
}

