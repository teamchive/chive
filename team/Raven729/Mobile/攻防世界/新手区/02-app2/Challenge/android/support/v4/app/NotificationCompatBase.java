package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(value=9) @RequiresApi(value=9) @RestrictTo(value={Scope.LIBRARY_GROUP}) public class NotificationCompatBase {
    public abstract class Action {
        public interface Factory {
            Action build(int arg1, CharSequence arg2, PendingIntent arg3, Bundle arg4, RemoteInput[] arg5, boolean arg6);

            Action[] newArray(int arg1);
        }

        public Action() {
            super();
        }

        public abstract PendingIntent getActionIntent();

        public abstract boolean getAllowGeneratedReplies();

        public abstract Bundle getExtras();

        public abstract int getIcon();

        public abstract RemoteInput[] getRemoteInputs();

        public abstract CharSequence getTitle();
    }

    public abstract class UnreadConversation {
        public interface android.support.v4.app.NotificationCompatBase$UnreadConversation$Factory {
            UnreadConversation build(String[] arg1, RemoteInput arg2, PendingIntent arg3, PendingIntent arg4, String[] arg5, long arg6);
        }

        public UnreadConversation() {
            super();
        }

        abstract long getLatestTimestamp();

        abstract String[] getMessages();

        abstract String getParticipant();

        abstract String[] getParticipants();

        abstract PendingIntent getReadPendingIntent();

        abstract RemoteInput getRemoteInput();

        abstract PendingIntent getReplyPendingIntent();
    }

    private static Method sSetLatestEventInfo;

    public NotificationCompatBase() {
        super();
    }

    public static Notification add(Notification arg5, Context arg6, CharSequence arg7, CharSequence arg8, PendingIntent arg9, PendingIntent arg10) {
        if(NotificationCompatBase.sSetLatestEventInfo == null) {
            try {
                NotificationCompatBase.sSetLatestEventInfo = Notification.class.getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class);
            }
            catch(NoSuchMethodException v0) {
                throw new RuntimeException(((Throwable)v0));
            }
        }

        try {
            NotificationCompatBase.sSetLatestEventInfo.invoke(arg5, arg6, arg7, arg8, arg9);
            goto label_32;
        }
        catch(InvocationTargetException v0_1) {
        }
        catch(IllegalAccessException v0_2) {
        }

        throw new RuntimeException(((Throwable)v0_1));
    label_32:
        arg5.fullScreenIntent = arg10;
        return arg5;
    }
}

