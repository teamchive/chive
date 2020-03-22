package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification$BigPictureStyle;
import android.app.Notification$BigTextStyle;
import android.app.Notification$Builder;
import android.app.Notification$InboxStyle;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(value=16) @RequiresApi(value=16) class NotificationCompatJellybean {
    public class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
        private Notification$Builder b;
        private List mActionExtrasList;
        private RemoteViews mBigContentView;
        private RemoteViews mContentView;
        private final Bundle mExtras;

        public Builder(Context arg9, Notification arg10, CharSequence arg11, CharSequence arg12, CharSequence arg13, RemoteViews arg14, int arg15, PendingIntent arg16, PendingIntent arg17, Bitmap arg18, int arg19, int arg20, boolean arg21, boolean arg22, int arg23, CharSequence arg24, boolean arg25, Bundle arg26, String arg27, boolean arg28, String arg29, RemoteViews arg30, RemoteViews arg31) {
            super();
            this.mActionExtrasList = new ArrayList();
            Notification$Builder v5 = new Notification$Builder(arg9).setWhen(arg10.when).setSmallIcon(arg10.icon, arg10.iconLevel).setContent(arg10.contentView).setTicker(arg10.tickerText, arg14).setSound(arg10.sound, arg10.audioStreamType).setVibrate(arg10.vibrate).setLights(arg10.ledARGB, arg10.ledOnMS, arg10.ledOffMS);
            boolean v4 = (arg10.flags & 2) != 0 ? true : false;
            v5 = v5.setOngoing(v4);
            v4 = (arg10.flags & 8) != 0 ? true : false;
            v5 = v5.setOnlyAlertOnce(v4);
            v4 = (arg10.flags & 16) != 0 ? true : false;
            v5 = v5.setAutoCancel(v4).setDefaults(arg10.defaults).setContentTitle(arg11).setContentText(arg12).setSubText(arg24).setContentInfo(arg13).setContentIntent(arg16).setDeleteIntent(arg10.deleteIntent);
            v4 = (arg10.flags & 0x80) != 0 ? true : false;
            this.b = v5.setFullScreenIntent(arg17, v4).setLargeIcon(arg18).setNumber(arg15).setUsesChronometer(arg22).setPriority(arg23).setProgress(arg19, arg20, arg21);
            this.mExtras = new Bundle();
            if(arg26 != null) {
                this.mExtras.putAll(arg26);
            }

            if(arg25) {
                this.mExtras.putBoolean("android.support.localOnly", true);
            }

            if(arg27 != null) {
                this.mExtras.putString("android.support.groupKey", arg27);
                if(arg28) {
                    this.mExtras.putBoolean("android.support.isGroupSummary", true);
                }
                else {
                    this.mExtras.putBoolean("android.support.useSideChannel", true);
                }
            }

            if(arg29 != null) {
                this.mExtras.putString("android.support.sortKey", arg29);
            }

            this.mContentView = arg30;
            this.mBigContentView = arg31;
        }

        public void addAction(Action arg3) {
            this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.b, arg3));
        }

        public Notification build() {
            Notification v1 = this.b.build();
            Bundle v2 = NotificationCompatJellybean.getExtras(v1);
            Bundle v3 = new Bundle(this.mExtras);
            Iterator v4 = this.mExtras.keySet().iterator();
            while(v4.hasNext()) {
                Object v0 = v4.next();
                if(!v2.containsKey(((String)v0))) {
                    continue;
                }

                v3.remove(((String)v0));
            }

            v2.putAll(v3);
            SparseArray v0_1 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
            if(v0_1 != null) {
                NotificationCompatJellybean.getExtras(v1).putSparseParcelableArray("android.support.actionExtras", v0_1);
            }

            if(this.mContentView != null) {
                v1.contentView = this.mContentView;
            }

            if(this.mBigContentView != null) {
                v1.bigContentView = this.mBigContentView;
            }

            return v1;
        }

        public Notification$Builder getBuilder() {
            return this.b;
        }
    }

    static final String EXTRA_ACTION_EXTRAS = "android.support.actionExtras";
    static final String EXTRA_ALLOW_GENERATED_REPLIES = "android.support.allowGeneratedReplies";
    static final String EXTRA_GROUP_KEY = "android.support.groupKey";
    static final String EXTRA_GROUP_SUMMARY = "android.support.isGroupSummary";
    static final String EXTRA_LOCAL_ONLY = "android.support.localOnly";
    static final String EXTRA_REMOTE_INPUTS = "android.support.remoteInputs";
    static final String EXTRA_SORT_KEY = "android.support.sortKey";
    static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_ALLOW_GENERATED_REPLIES = "allowGeneratedReplies";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    private static Class sActionClass;
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static final Object sActionsLock;
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock;

    static {
        NotificationCompatJellybean.sExtrasLock = new Object();
        NotificationCompatJellybean.sActionsLock = new Object();
    }

    NotificationCompatJellybean() {
        super();
    }

    public static void addBigPictureStyle(NotificationBuilderWithBuilderAccessor arg2, CharSequence arg3, boolean arg4, CharSequence arg5, Bitmap arg6, Bitmap arg7, boolean arg8) {
        Notification$BigPictureStyle v0 = new Notification$BigPictureStyle(arg2.getBuilder()).setBigContentTitle(arg3).bigPicture(arg6);
        if(arg8) {
            v0.bigLargeIcon(arg7);
        }

        if(arg4) {
            v0.setSummaryText(arg5);
        }
    }

    public static void addBigTextStyle(NotificationBuilderWithBuilderAccessor arg2, CharSequence arg3, boolean arg4, CharSequence arg5, CharSequence arg6) {
        Notification$BigTextStyle v0 = new Notification$BigTextStyle(arg2.getBuilder()).setBigContentTitle(arg3).bigText(arg6);
        if(arg4) {
            v0.setSummaryText(arg5);
        }
    }

    public static void addInboxStyle(NotificationBuilderWithBuilderAccessor arg3, CharSequence arg4, boolean arg5, CharSequence arg6, ArrayList arg7) {
        Notification$InboxStyle v1 = new Notification$InboxStyle(arg3.getBuilder()).setBigContentTitle(arg4);
        if(arg5) {
            v1.setSummaryText(arg6);
        }

        Iterator v2 = arg7.iterator();
        while(v2.hasNext()) {
            v1.addLine(v2.next());
        }
    }

    public static SparseArray buildActionExtrasMap(List arg4) {
        SparseArray v1 = null;
        int v3 = arg4.size();
        int v2;
        for(v2 = 0; v2 < v3; ++v2) {
            Object v0 = arg4.get(v2);
            if(v0 != null) {
                if(v1 == null) {
                    v1 = new SparseArray();
                }

                v1.put(v2, v0);
            }
        }

        return v1;
    }

    private static boolean ensureActionReflectionReadyLocked() {
        boolean v1 = false;
        boolean v0 = true;
        if(!NotificationCompatJellybean.sActionsAccessFailed) {
            try {
                if(NotificationCompatJellybean.sActionsField != null) {
                    goto label_29;
                }

                NotificationCompatJellybean.sActionClass = Class.forName("android.app.Notification$Action");
                NotificationCompatJellybean.sActionIconField = NotificationCompatJellybean.sActionClass.getDeclaredField("icon");
                NotificationCompatJellybean.sActionTitleField = NotificationCompatJellybean.sActionClass.getDeclaredField("title");
                NotificationCompatJellybean.sActionIntentField = NotificationCompatJellybean.sActionClass.getDeclaredField("actionIntent");
                NotificationCompatJellybean.sActionsField = Notification.class.getDeclaredField("actions");
                NotificationCompatJellybean.sActionsField.setAccessible(true);
            }
            catch(NoSuchFieldException v2) {
                Log.e("NotificationCompat", "Unable to access notification actions", ((Throwable)v2));
                NotificationCompatJellybean.sActionsAccessFailed = true;
            }
            catch(ClassNotFoundException v2_1) {
                Log.e("NotificationCompat", "Unable to access notification actions", ((Throwable)v2_1));
                NotificationCompatJellybean.sActionsAccessFailed = true;
            }

        label_29:
            if(NotificationCompatJellybean.sActionsAccessFailed) {
                v0 = false;
            }

            v1 = v0;
        }

        return v1;
    }

    public static Action getAction(Notification arg8, int arg9, Factory arg10, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory arg11) {
        Action v0_4;
        Object v5;
        Object v1;
        Action v6 = null;
        Object v7 = NotificationCompatJellybean.sActionsLock;
        __monitor_enter(v7);
        try {
            Object[] v0_1 = NotificationCompatJellybean.getActionObjectsLocked(arg8);
            if(v0_1 == null) {
                goto label_30;
            }

            v1 = v0_1[arg9];
            Bundle v0_2 = NotificationCompatJellybean.getExtras(arg8);
            if(v0_2 != null) {
                SparseArray v0_3 = v0_2.getSparseParcelableArray("android.support.actionExtras");
                if(v0_3 != null) {
                    v5 = v0_3.get(arg9);
                }
                else {
                    goto label_36;
                }
            }
            else {
                goto label_36;
            }

            goto label_13;
        }
        catch(IllegalAccessException v0) {
            goto label_27;
        }

    label_36:
        Bundle v5_1 = ((Bundle)v6);
        try {
        label_13:
            v0_4 = NotificationCompatJellybean.readAction(arg10, arg11, NotificationCompatJellybean.sActionIconField.getInt(v1), NotificationCompatJellybean.sActionTitleField.get(v1), NotificationCompatJellybean.sActionIntentField.get(v1), ((Bundle)v5));
        }
        catch(IllegalAccessException v0) {
        label_27:
            Log.e("NotificationCompat", "Unable to access notification actions", ((Throwable)v0));
            NotificationCompatJellybean.sActionsAccessFailed = true;
            goto label_30;
        }

        __monitor_exit(v7);
        return v0_4;
    label_30:
        __monitor_exit(v7);
        return v6;
        __monitor_exit(v7);
        throw v0_5;
    }

    public static int getActionCount(Notification arg2) {
        Object v1 = NotificationCompatJellybean.sActionsLock;
        __monitor_enter(v1);
        try {
            Object[] v0_1 = NotificationCompatJellybean.getActionObjectsLocked(arg2);
            int v0_2 = v0_1 != null ? v0_1.length : 0;
            __monitor_exit(v1);
            return v0_2;
        label_10:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_10;
        }

        throw v0;
    }

    private static Action getActionFromBundle(Bundle arg7, Factory arg8, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory arg9) {
        boolean v6 = false;
        Bundle v0 = arg7.getBundle("extras");
        if(v0 != null) {
            v6 = v0.getBoolean("android.support.allowGeneratedReplies", false);
        }

        return arg8.build(arg7.getInt("icon"), arg7.getCharSequence("title"), arg7.getParcelable("actionIntent"), arg7.getBundle("extras"), RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(arg7, "remoteInputs"), arg9), v6);
    }

    private static Object[] getActionObjectsLocked(Notification arg5) {
        Object[] v0_1;
        Object[] v1 = null;
        Object v2 = NotificationCompatJellybean.sActionsLock;
        __monitor_enter(v2);
        try {
            if(NotificationCompatJellybean.ensureActionReflectionReadyLocked()) {
                goto label_8;
            }

            __monitor_exit(v2);
            v0_1 = v1;
            return v0_1;
        }
        catch(Throwable v0) {
            goto label_13;
        }

        try {
        label_8:
            Object v0_3 = NotificationCompatJellybean.sActionsField.get(arg5);
            __monitor_exit(v2);
            return v0_1;
        }
        catch(IllegalAccessException v0_2) {
            try {
                Log.e("NotificationCompat", "Unable to access notification actions", ((Throwable)v0_2));
                NotificationCompatJellybean.sActionsAccessFailed = true;
                __monitor_exit(v2);
                return v1;
            label_13:
                __monitor_exit(v2);
            }
            catch(Throwable v0) {
                goto label_13;
            }
        }

        throw v0;
        return v0_1;
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
                v2[v1] = NotificationCompatJellybean.getActionFromBundle(arg3.get(v1), arg4, arg5);
            }

            v0 = v2;
        }

        return v0;
    }

    private static Bundle getBundleForAction(Action arg4) {
        Bundle v1 = new Bundle();
        v1.putInt("icon", arg4.getIcon());
        v1.putCharSequence("title", arg4.getTitle());
        v1.putParcelable("actionIntent", arg4.getActionIntent());
        Bundle v0 = arg4.getExtras() != null ? new Bundle(arg4.getExtras()) : new Bundle();
        v0.putBoolean("android.support.allowGeneratedReplies", arg4.getAllowGeneratedReplies());
        v1.putBundle("extras", v0);
        v1.putParcelableArray("remoteInputs", RemoteInputCompatJellybean.toBundleArray(arg4.getRemoteInputs()));
        return v1;
    }

    public static Bundle getExtras(Notification arg5) {
        Field v0_4;
        Bundle v0_1;
        Bundle v1 = null;
        Object v2 = NotificationCompatJellybean.sExtrasLock;
        __monitor_enter(v2);
        try {
            if(!NotificationCompatJellybean.sExtrasFieldAccessFailed) {
                goto label_8;
            }

            __monitor_exit(v2);
            v0_1 = v1;
            return v0_1;
        }
        catch(Throwable v0) {
            goto label_38;
        }

        try {
        label_8:
            if(NotificationCompatJellybean.sExtrasField == null) {
                v0_4 = Notification.class.getDeclaredField("extras");
                if(!Bundle.class.isAssignableFrom(v0_4.getType())) {
                    Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                    NotificationCompatJellybean.sExtrasFieldAccessFailed = true;
                    goto label_22;
                }
                else {
                    goto label_26;
                }
            }

            goto label_28;
        }
        catch(IllegalAccessException v0_2) {
            goto label_41;
        }
        catch(NoSuchFieldException v0_3) {
            goto label_52;
        }
        catch(Throwable v0) {
            goto label_38;
        }

        try {
        label_22:
            __monitor_exit(v2);
            return v1;
        }
        catch(Throwable v0) {
            goto label_38;
        }

        try {
        label_26:
            v0_4.setAccessible(true);
            NotificationCompatJellybean.sExtrasField = v0_4;
        label_28:
            Object v0_5 = NotificationCompatJellybean.sExtrasField.get(arg5);
            if(v0_5 == null) {
                v0_1 = new Bundle();
                NotificationCompatJellybean.sExtrasField.set(arg5, v0_1);
            }

            goto label_35;
        }
        catch(Throwable v0) {
        label_39:
            throw v0;
        }
        catch(NoSuchFieldException v0_3) {
        }
        catch(IllegalAccessException v0_2) {
            try {
            label_41:
                Log.e("NotificationCompat", "Unable to access notification extras", ((Throwable)v0_2));
                goto label_44;
            label_52:
                Log.e("NotificationCompat", "Unable to access notification extras", ((Throwable)v0_3));
            label_44:
                NotificationCompatJellybean.sExtrasFieldAccessFailed = true;
                __monitor_exit(v2);
                return v1;
            label_35:
                __monitor_exit(v2);
                return v0_1;
            label_38:
                __monitor_exit(v2);
                goto label_39;
            }
            catch(Throwable v0) {
                goto label_38;
            }
        }

        return v0_1;
    }

    public static String getGroup(Notification arg2) {
        return NotificationCompatJellybean.getExtras(arg2).getString("android.support.groupKey");
    }

    public static boolean getLocalOnly(Notification arg2) {
        return NotificationCompatJellybean.getExtras(arg2).getBoolean("android.support.localOnly");
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
                v0.add(NotificationCompatJellybean.getBundleForAction(arg4[v1]));
            }
        }

        return v0;
    }

    public static String getSortKey(Notification arg2) {
        return NotificationCompatJellybean.getExtras(arg2).getString("android.support.sortKey");
    }

    public static boolean isGroupSummary(Notification arg2) {
        return NotificationCompatJellybean.getExtras(arg2).getBoolean("android.support.isGroupSummary");
    }

    public static Action readAction(Factory arg7, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory arg8, int arg9, CharSequence arg10, PendingIntent arg11, Bundle arg12) {
        RemoteInput[] v5 = null;
        boolean v6 = false;
        if(arg12 != null) {
            v5 = RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(arg12, "android.support.remoteInputs"), arg8);
            v6 = arg12.getBoolean("android.support.allowGeneratedReplies");
        }

        return arg7.build(arg9, arg10, arg11, arg12, v5, v6);
    }

    public static Bundle writeActionAndGetExtras(Notification$Builder arg3, Action arg4) {
        arg3.addAction(arg4.getIcon(), arg4.getTitle(), arg4.getActionIntent());
        Bundle v0 = new Bundle(arg4.getExtras());
        if(arg4.getRemoteInputs() != null) {
            v0.putParcelableArray("android.support.remoteInputs", RemoteInputCompatJellybean.toBundleArray(arg4.getRemoteInputs()));
        }

        v0.putBoolean("android.support.allowGeneratedReplies", arg4.getAllowGeneratedReplies());
        return v0;
    }
}

