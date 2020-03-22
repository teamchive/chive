package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.v4.os.BuildCompat;
import android.widget.RemoteViews;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NotificationCompat {
    public class Action extends android.support.v4.app.NotificationCompatBase$Action {
        final class android.support.v4.app.NotificationCompat$Action$1 implements Factory {
            android.support.v4.app.NotificationCompat$Action$1() {
                super();
            }

            public android.support.v4.app.NotificationCompatBase$Action build(int arg8, CharSequence arg9, PendingIntent arg10, Bundle arg11, RemoteInput[] arg12, boolean arg13) {
                return new Action(arg8, arg9, arg10, arg11, arg12, arg13);
            }

            public Action[] newArray(int arg2) {
                return new Action[arg2];
            }

            public android.support.v4.app.NotificationCompatBase$Action[] newArray(int arg2) {
                return this.newArray(arg2);
            }
        }

        public final class Builder {
            private boolean mAllowGeneratedReplies;
            private final Bundle mExtras;
            private final int mIcon;
            private final PendingIntent mIntent;
            private ArrayList mRemoteInputs;
            private final CharSequence mTitle;

            public Builder(int arg8, CharSequence arg9, PendingIntent arg10) {
                this(arg8, arg9, arg10, new Bundle(), null, true);
            }

            private Builder(int arg3, CharSequence arg4, PendingIntent arg5, Bundle arg6, android.support.v4.app.RemoteInput[] arg7, boolean arg8) {
                super();
                this.mAllowGeneratedReplies = true;
                this.mIcon = arg3;
                this.mTitle = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg4);
                this.mIntent = arg5;
                this.mExtras = arg6;
                ArrayList v0 = arg7 == null ? null : new ArrayList(Arrays.asList(((Object[])arg7)));
                this.mRemoteInputs = v0;
                this.mAllowGeneratedReplies = arg8;
            }

            public Builder(Action arg8) {
                this(arg8.icon, arg8.title, arg8.actionIntent, new Bundle(arg8.mExtras), arg8.getRemoteInputs(), arg8.getAllowGeneratedReplies());
            }

            public Builder addExtras(Bundle arg2) {
                if(arg2 != null) {
                    this.mExtras.putAll(arg2);
                }

                return this;
            }

            public Builder addRemoteInput(android.support.v4.app.RemoteInput arg2) {
                if(this.mRemoteInputs == null) {
                    this.mRemoteInputs = new ArrayList();
                }

                this.mRemoteInputs.add(arg2);
                return this;
            }

            public Action build() {
                android.support.v4.app.RemoteInput[] v5_1;
                if(this.mRemoteInputs != null) {
                    Object[] v5 = this.mRemoteInputs.toArray(new android.support.v4.app.RemoteInput[this.mRemoteInputs.size()]);
                }
                else {
                    v5_1 = null;
                }

                return new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, v5_1, this.mAllowGeneratedReplies);
            }

            public Builder extend(Extender arg1) {
                arg1.extend(this);
                return this;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Builder setAllowGeneratedReplies(boolean arg1) {
                this.mAllowGeneratedReplies = arg1;
                return this;
            }
        }

        public interface Extender {
            Builder extend(Builder arg1);
        }

        public final class WearableExtender implements Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final int FLAG_HINT_DISPLAY_INLINE = 4;
            private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            private static final String KEY_CANCEL_LABEL = "cancelLabel";
            private static final String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final String KEY_FLAGS = "flags";
            private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private CharSequence mCancelLabel;
            private CharSequence mConfirmLabel;
            private int mFlags;
            private CharSequence mInProgressLabel;

            public WearableExtender() {
                super();
                this.mFlags = 1;
            }

            public WearableExtender(Action arg4) {
                super();
                this.mFlags = 1;
                Bundle v0 = arg4.getExtras().getBundle("android.wearable.EXTENSIONS");
                if(v0 != null) {
                    this.mFlags = v0.getInt("flags", 1);
                    this.mInProgressLabel = v0.getCharSequence("inProgressLabel");
                    this.mConfirmLabel = v0.getCharSequence("confirmLabel");
                    this.mCancelLabel = v0.getCharSequence("cancelLabel");
                }
            }

            public WearableExtender clone() {
                WearableExtender v0 = new WearableExtender();
                v0.mFlags = this.mFlags;
                v0.mInProgressLabel = this.mInProgressLabel;
                v0.mConfirmLabel = this.mConfirmLabel;
                v0.mCancelLabel = this.mCancelLabel;
                return v0;
            }

            public Object clone() {
                return this.clone();
            }

            public Builder extend(Builder arg4) {
                Bundle v0 = new Bundle();
                if(this.mFlags != 1) {
                    v0.putInt("flags", this.mFlags);
                }

                if(this.mInProgressLabel != null) {
                    v0.putCharSequence("inProgressLabel", this.mInProgressLabel);
                }

                if(this.mConfirmLabel != null) {
                    v0.putCharSequence("confirmLabel", this.mConfirmLabel);
                }

                if(this.mCancelLabel != null) {
                    v0.putCharSequence("cancelLabel", this.mCancelLabel);
                }

                arg4.getExtras().putBundle("android.wearable.EXTENSIONS", v0);
                return arg4;
            }

            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            public CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public boolean getHintDisplayActionInline() {
                boolean v0 = (this.mFlags & 4) != 0 ? true : false;
                return v0;
            }

            public boolean getHintLaunchesActivity() {
                boolean v0 = (this.mFlags & 2) != 0 ? true : false;
                return v0;
            }

            public CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            public boolean isAvailableOffline() {
                boolean v0 = (this.mFlags & 1) != 0 ? true : false;
                return v0;
            }

            public WearableExtender setAvailableOffline(boolean arg2) {
                this.setFlag(1, arg2);
                return this;
            }

            public WearableExtender setCancelLabel(CharSequence arg1) {
                this.mCancelLabel = arg1;
                return this;
            }

            public WearableExtender setConfirmLabel(CharSequence arg1) {
                this.mConfirmLabel = arg1;
                return this;
            }

            private void setFlag(int arg3, boolean arg4) {
                if(arg4) {
                    this.mFlags |= arg3;
                }
                else {
                    this.mFlags &= arg3 ^ -1;
                }
            }

            public WearableExtender setHintDisplayActionInline(boolean arg2) {
                this.setFlag(4, arg2);
                return this;
            }

            public WearableExtender setHintLaunchesActivity(boolean arg2) {
                this.setFlag(2, arg2);
                return this;
            }

            public WearableExtender setInProgressLabel(CharSequence arg1) {
                this.mInProgressLabel = arg1;
                return this;
            }
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) public static final Factory FACTORY;
        public PendingIntent actionIntent;
        public int icon;
        private boolean mAllowGeneratedReplies;
        final Bundle mExtras;
        private final android.support.v4.app.RemoteInput[] mRemoteInputs;
        public CharSequence title;

        static {
            Action.FACTORY = new android.support.v4.app.NotificationCompat$Action$1();
        }

        public Action(int arg8, CharSequence arg9, PendingIntent arg10) {
            this(arg8, arg9, arg10, new Bundle(), null, true);
        }

        Action(int arg2, CharSequence arg3, PendingIntent arg4, Bundle arg5, android.support.v4.app.RemoteInput[] arg6, boolean arg7) {
            super();
            this.icon = arg2;
            this.title = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg3);
            this.actionIntent = arg4;
            if(arg5 == null) {
                arg5 = new Bundle();
            }

            this.mExtras = arg5;
            this.mRemoteInputs = arg6;
            this.mAllowGeneratedReplies = arg7;
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getIcon() {
            return this.icon;
        }

        public android.support.v4.app.RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.getRemoteInputs();
        }

        public CharSequence getTitle() {
            return this.title;
        }
    }

    public class BigPictureStyle extends Style {
        Bitmap mBigLargeIcon;
        boolean mBigLargeIconSet;
        Bitmap mPicture;

        public BigPictureStyle() {
            super();
        }

        public BigPictureStyle(android.support.v4.app.NotificationCompat$Builder arg1) {
            super();
            this.setBuilder(arg1);
        }

        public BigPictureStyle bigLargeIcon(Bitmap arg2) {
            this.mBigLargeIcon = arg2;
            this.mBigLargeIconSet = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap arg1) {
            this.mPicture = arg1;
            return this;
        }

        public BigPictureStyle setBigContentTitle(CharSequence arg2) {
            this.mBigContentTitle = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg2);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence arg2) {
            this.mSummaryText = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg2);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public class BigTextStyle extends Style {
        CharSequence mBigText;

        public BigTextStyle() {
            super();
        }

        public BigTextStyle(android.support.v4.app.NotificationCompat$Builder arg1) {
            super();
            this.setBuilder(arg1);
        }

        public BigTextStyle bigText(CharSequence arg2) {
            this.mBigText = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg2);
            return this;
        }

        public BigTextStyle setBigContentTitle(CharSequence arg2) {
            this.mBigContentTitle = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg2);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence arg2) {
            this.mSummaryText = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg2);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public class android.support.v4.app.NotificationCompat$Builder {
        private static final int MAX_CHARSEQUENCE_LENGTH = 0x1400;
        @RestrictTo(value={Scope.LIBRARY_GROUP}) public ArrayList mActions;
        RemoteViews mBigContentView;
        String mCategory;
        int mColor;
        @RestrictTo(value={Scope.LIBRARY_GROUP}) public CharSequence mContentInfo;
        PendingIntent mContentIntent;
        @RestrictTo(value={Scope.LIBRARY_GROUP}) public CharSequence mContentText;
        @RestrictTo(value={Scope.LIBRARY_GROUP}) public CharSequence mContentTitle;
        RemoteViews mContentView;
        @RestrictTo(value={Scope.LIBRARY_GROUP}) public Context mContext;
        Bundle mExtras;
        PendingIntent mFullScreenIntent;
        String mGroupKey;
        boolean mGroupSummary;
        RemoteViews mHeadsUpContentView;
        @RestrictTo(value={Scope.LIBRARY_GROUP}) public Bitmap mLargeIcon;
        boolean mLocalOnly;
        @RestrictTo(value={Scope.LIBRARY_GROUP}) public Notification mNotification;
        @RestrictTo(value={Scope.LIBRARY_GROUP}) public int mNumber;
        public ArrayList mPeople;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Notification mPublicVersion;
        @RestrictTo(value={Scope.LIBRARY_GROUP}) public CharSequence[] mRemoteInputHistory;
        boolean mShowWhen;
        String mSortKey;
        @RestrictTo(value={Scope.LIBRARY_GROUP}) public Style mStyle;
        @RestrictTo(value={Scope.LIBRARY_GROUP}) public CharSequence mSubText;
        RemoteViews mTickerView;
        @RestrictTo(value={Scope.LIBRARY_GROUP}) public boolean mUseChronometer;
        int mVisibility;

        public android.support.v4.app.NotificationCompat$Builder(Context arg6) {
            super();
            this.mShowWhen = true;
            this.mActions = new ArrayList();
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mNotification = new Notification();
            this.mContext = arg6;
            this.mNotification.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new ArrayList();
        }

        public android.support.v4.app.NotificationCompat$Builder addAction(int arg3, CharSequence arg4, PendingIntent arg5) {
            this.mActions.add(new Action(arg3, arg4, arg5));
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder addAction(Action arg2) {
            this.mActions.add(arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder addExtras(Bundle arg2) {
            if(arg2 != null) {
                if(this.mExtras == null) {
                    this.mExtras = new Bundle(arg2);
                }
                else {
                    this.mExtras.putAll(arg2);
                }
            }

            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder addPerson(String arg2) {
            this.mPeople.add(arg2);
            return this;
        }

        public Notification build() {
            return NotificationCompat.IMPL.build(this, this.getExtender());
        }

        public android.support.v4.app.NotificationCompat$Builder extend(android.support.v4.app.NotificationCompat$Extender arg1) {
            arg1.extend(this);
            return this;
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) public RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) public int getColor() {
            return this.mColor;
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) public RemoteViews getContentView() {
            return this.mContentView;
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) protected BuilderExtender getExtender() {
            return new BuilderExtender();
        }

        public Bundle getExtras() {
            if(this.mExtras == null) {
                this.mExtras = new Bundle();
            }

            return this.mExtras;
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @Deprecated public Notification getNotification() {
            return this.build();
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) public int getPriority() {
            return this.mPriority;
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) public long getWhenIfShowing() {
            long v0 = this.mShowWhen ? this.mNotification.when : 0;
            return v0;
        }

        protected static CharSequence limitCharSequenceLength(CharSequence arg2) {
            int v1 = 0x1400;
            if(arg2 != null && arg2.length() > v1) {
                arg2 = arg2.subSequence(0, v1);
            }

            return arg2;
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) protected CharSequence resolveText() {
            return this.mContentText;
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) protected CharSequence resolveTitle() {
            return this.mContentTitle;
        }

        public android.support.v4.app.NotificationCompat$Builder setAutoCancel(boolean arg2) {
            this.setFlag(16, arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setCategory(String arg1) {
            this.mCategory = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setColor(@ColorInt int arg1) {
            this.mColor = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setContent(RemoteViews arg2) {
            this.mNotification.contentView = arg2;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setContentInfo(CharSequence arg2) {
            this.mContentInfo = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setContentIntent(PendingIntent arg1) {
            this.mContentIntent = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setContentText(CharSequence arg2) {
            this.mContentText = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setContentTitle(CharSequence arg2) {
            this.mContentTitle = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setCustomBigContentView(RemoteViews arg1) {
            this.mBigContentView = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setCustomContentView(RemoteViews arg1) {
            this.mContentView = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setCustomHeadsUpContentView(RemoteViews arg1) {
            this.mHeadsUpContentView = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setDefaults(int arg3) {
            this.mNotification.defaults = arg3;
            if((arg3 & 4) != 0) {
                this.mNotification.flags |= 1;
            }

            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setDeleteIntent(PendingIntent arg2) {
            this.mNotification.deleteIntent = arg2;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setExtras(Bundle arg1) {
            this.mExtras = arg1;
            return this;
        }

        private void setFlag(int arg4, boolean arg5) {
            if(arg5) {
                this.mNotification.flags |= arg4;
            }
            else {
                this.mNotification.flags &= arg4 ^ -1;
            }
        }

        public android.support.v4.app.NotificationCompat$Builder setFullScreenIntent(PendingIntent arg2, boolean arg3) {
            this.mFullScreenIntent = arg2;
            this.setFlag(0x80, arg3);
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setGroup(String arg1) {
            this.mGroupKey = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setGroupSummary(boolean arg1) {
            this.mGroupSummary = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setLargeIcon(Bitmap arg1) {
            this.mLargeIcon = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setLights(@ColorInt int arg6, int arg7, int arg8) {
            int v1 = 1;
            this.mNotification.ledARGB = arg6;
            this.mNotification.ledOnMS = arg7;
            this.mNotification.ledOffMS = arg8;
            int v0 = this.mNotification.ledOnMS == 0 || this.mNotification.ledOffMS == 0 ? 0 : 1;
            Notification v3 = this.mNotification;
            int v4 = this.mNotification.flags & -2;
            if(v0 == 0) {
                v1 = 0;
            }

            v3.flags = v4 | v1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setLocalOnly(boolean arg1) {
            this.mLocalOnly = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setNumber(int arg1) {
            this.mNumber = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setOngoing(boolean arg2) {
            this.setFlag(2, arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setOnlyAlertOnce(boolean arg2) {
            this.setFlag(8, arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setPriority(int arg1) {
            this.mPriority = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setProgress(int arg1, int arg2, boolean arg3) {
            this.mProgressMax = arg1;
            this.mProgress = arg2;
            this.mProgressIndeterminate = arg3;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setPublicVersion(Notification arg1) {
            this.mPublicVersion = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setRemoteInputHistory(CharSequence[] arg1) {
            this.mRemoteInputHistory = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setShowWhen(boolean arg1) {
            this.mShowWhen = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setSmallIcon(int arg2) {
            this.mNotification.icon = arg2;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setSmallIcon(int arg2, int arg3) {
            this.mNotification.icon = arg2;
            this.mNotification.iconLevel = arg3;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setSortKey(String arg1) {
            this.mSortKey = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setSound(Uri arg3) {
            this.mNotification.sound = arg3;
            this.mNotification.audioStreamType = -1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setSound(Uri arg2, int arg3) {
            this.mNotification.sound = arg2;
            this.mNotification.audioStreamType = arg3;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setStyle(Style arg2) {
            if(this.mStyle != arg2) {
                this.mStyle = arg2;
                if(this.mStyle != null) {
                    this.mStyle.setBuilder(this);
                }
            }

            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setSubText(CharSequence arg2) {
            this.mSubText = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setTicker(CharSequence arg3) {
            this.mNotification.tickerText = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg3);
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setTicker(CharSequence arg3, RemoteViews arg4) {
            this.mNotification.tickerText = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg3);
            this.mTickerView = arg4;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setUsesChronometer(boolean arg1) {
            this.mUseChronometer = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setVibrate(long[] arg2) {
            this.mNotification.vibrate = arg2;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setVisibility(int arg1) {
            this.mVisibility = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$Builder setWhen(long arg2) {
            this.mNotification.when = arg2;
            return this;
        }
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public class BuilderExtender {
        protected BuilderExtender() {
            super();
        }

        public Notification build(android.support.v4.app.NotificationCompat$Builder arg3, NotificationBuilderWithBuilderAccessor arg4) {
            Notification v0 = arg4.build();
            if(arg3.mContentView != null) {
                v0.contentView = arg3.mContentView;
            }

            return v0;
        }
    }

    public final class CarExtender implements android.support.v4.app.NotificationCompat$Extender {
        public class UnreadConversation extends android.support.v4.app.NotificationCompatBase$UnreadConversation {
            final class android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$1 implements android.support.v4.app.NotificationCompatBase$UnreadConversation$Factory {
                android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$1() {
                    super();
                }

                public UnreadConversation build(String[] arg9, RemoteInput arg10, PendingIntent arg11, PendingIntent arg12, String[] arg13, long arg14) {
                    return new UnreadConversation(arg9, arg10, arg11, arg12, arg13, arg14);
                }

                public android.support.v4.app.NotificationCompatBase$UnreadConversation build(String[] arg3, RemoteInput arg4, PendingIntent arg5, PendingIntent arg6, String[] arg7, long arg8) {
                    return this.build(arg3, arg4, arg5, arg6, arg7, arg8);
                }
            }

            public class android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$Builder {
                private long mLatestTimestamp;
                private final List mMessages;
                private final String mParticipant;
                private PendingIntent mReadPendingIntent;
                private android.support.v4.app.RemoteInput mRemoteInput;
                private PendingIntent mReplyPendingIntent;

                public android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$Builder(String arg2) {
                    super();
                    this.mMessages = new ArrayList();
                    this.mParticipant = arg2;
                }

                public android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$Builder addMessage(String arg2) {
                    this.mMessages.add(arg2);
                    return this;
                }

                public UnreadConversation build() {
                    return new UnreadConversation(this.mMessages.toArray(new String[this.mMessages.size()]), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new String[]{this.mParticipant}, this.mLatestTimestamp);
                }

                public android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$Builder setLatestTimestamp(long arg2) {
                    this.mLatestTimestamp = arg2;
                    return this;
                }

                public android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$Builder setReadPendingIntent(PendingIntent arg1) {
                    this.mReadPendingIntent = arg1;
                    return this;
                }

                public android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$Builder setReplyAction(PendingIntent arg1, android.support.v4.app.RemoteInput arg2) {
                    this.mRemoteInput = arg2;
                    this.mReplyPendingIntent = arg1;
                    return this;
                }
            }

            static final android.support.v4.app.NotificationCompatBase$UnreadConversation$Factory FACTORY;
            private final long mLatestTimestamp;
            private final String[] mMessages;
            private final String[] mParticipants;
            private final PendingIntent mReadPendingIntent;
            private final android.support.v4.app.RemoteInput mRemoteInput;
            private final PendingIntent mReplyPendingIntent;

            static {
                UnreadConversation.FACTORY = new android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$1();
            }

            UnreadConversation(String[] arg1, android.support.v4.app.RemoteInput arg2, PendingIntent arg3, PendingIntent arg4, String[] arg5, long arg6) {
                super();
                this.mMessages = arg1;
                this.mRemoteInput = arg2;
                this.mReadPendingIntent = arg4;
                this.mReplyPendingIntent = arg3;
                this.mParticipants = arg5;
                this.mLatestTimestamp = arg6;
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            public String[] getMessages() {
                return this.mMessages;
            }

            public String getParticipant() {
                String v0 = this.mParticipants.length > 0 ? this.mParticipants[0] : null;
                return v0;
            }

            public String[] getParticipants() {
                return this.mParticipants;
            }

            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            public android.support.v4.app.RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            public RemoteInput getRemoteInput() {
                return this.getRemoteInput();
            }

            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }
        }

        private static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final String EXTRA_COLOR = "app_color";
        private static final String EXTRA_CONVERSATION = "car_conversation";
        private static final String EXTRA_LARGE_ICON = "large_icon";
        private static final String TAG = "CarExtender";
        private int mColor;
        private Bitmap mLargeIcon;
        private UnreadConversation mUnreadConversation;

        public CarExtender() {
            super();
            this.mColor = 0;
        }

        public CarExtender(Notification arg5) {
            super();
            this.mColor = 0;
            if(Build$VERSION.SDK_INT >= 21) {
                Bundle v1 = NotificationCompat.getExtras(arg5) == null ? null : NotificationCompat.getExtras(arg5).getBundle("android.car.EXTENSIONS");
                if(v1 == null) {
                    return;
                }

                this.mLargeIcon = v1.getParcelable("large_icon");
                this.mColor = v1.getInt("app_color", 0);
                this.mUnreadConversation = NotificationCompat.IMPL.getUnreadConversationFromBundle(v1.getBundle("car_conversation"), UnreadConversation.FACTORY, android.support.v4.app.RemoteInput.FACTORY);
            }
        }

        public android.support.v4.app.NotificationCompat$Builder extend(android.support.v4.app.NotificationCompat$Builder arg4) {
            if(Build$VERSION.SDK_INT >= 21) {
                Bundle v0 = new Bundle();
                if(this.mLargeIcon != null) {
                    v0.putParcelable("large_icon", this.mLargeIcon);
                }

                if(this.mColor != 0) {
                    v0.putInt("app_color", this.mColor);
                }

                if(this.mUnreadConversation != null) {
                    v0.putBundle("car_conversation", NotificationCompat.IMPL.getBundleForUnreadConversation(this.mUnreadConversation));
                }

                arg4.getExtras().putBundle("android.car.EXTENSIONS", v0);
            }

            return arg4;
        }

        @ColorInt public int getColor() {
            return this.mColor;
        }

        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        public CarExtender setColor(@ColorInt int arg1) {
            this.mColor = arg1;
            return this;
        }

        public CarExtender setLargeIcon(Bitmap arg1) {
            this.mLargeIcon = arg1;
            return this;
        }

        public CarExtender setUnreadConversation(UnreadConversation arg1) {
            this.mUnreadConversation = arg1;
            return this;
        }
    }

    public interface android.support.v4.app.NotificationCompat$Extender {
        android.support.v4.app.NotificationCompat$Builder extend(android.support.v4.app.NotificationCompat$Builder arg1);
    }

    public class InboxStyle extends Style {
        ArrayList mTexts;

        public InboxStyle() {
            super();
            this.mTexts = new ArrayList();
        }

        public InboxStyle(android.support.v4.app.NotificationCompat$Builder arg2) {
            super();
            this.mTexts = new ArrayList();
            this.setBuilder(arg2);
        }

        public InboxStyle addLine(CharSequence arg3) {
            this.mTexts.add(android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg3));
            return this;
        }

        public InboxStyle setBigContentTitle(CharSequence arg2) {
            this.mBigContentTitle = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg2);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence arg2) {
            this.mSummaryText = android.support.v4.app.NotificationCompat$Builder.limitCharSequenceLength(arg2);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public class MessagingStyle extends Style {
        public final class Message {
            static final String KEY_DATA_MIME_TYPE = "type";
            static final String KEY_DATA_URI = "uri";
            static final String KEY_SENDER = "sender";
            static final String KEY_TEXT = "text";
            static final String KEY_TIMESTAMP = "time";
            private String mDataMimeType;
            private Uri mDataUri;
            private final CharSequence mSender;
            private final CharSequence mText;
            private final long mTimestamp;

            public Message(CharSequence arg1, long arg2, CharSequence arg4) {
                super();
                this.mText = arg1;
                this.mTimestamp = arg2;
                this.mSender = arg4;
            }

            static Bundle[] getBundleArrayForMessages(List arg4) {
                Bundle[] v2 = new Bundle[arg4.size()];
                int v3 = arg4.size();
                int v1;
                for(v1 = 0; v1 < v3; ++v1) {
                    v2[v1] = arg4.get(v1).toBundle();
                }

                return v2;
            }

            public String getDataMimeType() {
                return this.mDataMimeType;
            }

            public Uri getDataUri() {
                return this.mDataUri;
            }

            static Message getMessageFromBundle(Bundle arg6) {
                Message v1;
                Message v2 = null;
                try {
                    if(!arg6.containsKey("text") || !arg6.containsKey("time")) {
                        Message v0_1 = v2;
                        return v0_1;
                    }

                    v1 = new Message(arg6.getCharSequence("text"), arg6.getLong("time"), arg6.getCharSequence("sender"));
                    if((arg6.containsKey("type")) && (arg6.containsKey("uri"))) {
                        v1.setData(arg6.getString("type"), arg6.getParcelable("uri"));
                    }
                }
                catch(ClassCastException v0) {
                    return v2;
                }

                return v1;
            }

            static List getMessagesFromBundleArray(Parcelable[] arg3) {
                ArrayList v2 = new ArrayList(arg3.length);
                int v1;
                for(v1 = 0; v1 < arg3.length; ++v1) {
                    if((arg3[v1] instanceof Bundle)) {
                        Message v0 = Message.getMessageFromBundle(arg3[v1]);
                        if(v0 != null) {
                            ((List)v2).add(v0);
                        }
                    }
                }

                return ((List)v2);
            }

            public CharSequence getSender() {
                return this.mSender;
            }

            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            public Message setData(String arg1, Uri arg2) {
                this.mDataMimeType = arg1;
                this.mDataUri = arg2;
                return this;
            }

            private Bundle toBundle() {
                Bundle v0 = new Bundle();
                if(this.mText != null) {
                    v0.putCharSequence("text", this.mText);
                }

                v0.putLong("time", this.mTimestamp);
                if(this.mSender != null) {
                    v0.putCharSequence("sender", this.mSender);
                }

                if(this.mDataMimeType != null) {
                    v0.putString("type", this.mDataMimeType);
                }

                if(this.mDataUri != null) {
                    v0.putParcelable("uri", this.mDataUri);
                }

                return v0;
            }
        }

        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        CharSequence mConversationTitle;
        List mMessages;
        CharSequence mUserDisplayName;

        MessagingStyle() {
            super();
            this.mMessages = new ArrayList();
        }

        public MessagingStyle(@NonNull CharSequence arg2) {
            super();
            this.mMessages = new ArrayList();
            this.mUserDisplayName = arg2;
        }

        public void addCompatExtras(Bundle arg3) {
            super.addCompatExtras(arg3);
            if(this.mUserDisplayName != null) {
                arg3.putCharSequence("android.selfDisplayName", this.mUserDisplayName);
            }

            if(this.mConversationTitle != null) {
                arg3.putCharSequence("android.conversationTitle", this.mConversationTitle);
            }

            if(!this.mMessages.isEmpty()) {
                arg3.putParcelableArray("android.messages", Message.getBundleArrayForMessages(this.mMessages));
            }
        }

        public MessagingStyle addMessage(Message arg3) {
            this.mMessages.add(arg3);
            if(this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }

            return this;
        }

        public MessagingStyle addMessage(CharSequence arg3, long arg4, CharSequence arg6) {
            this.mMessages.add(new Message(arg3, arg4, arg6));
            if(this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }

            return this;
        }

        public static MessagingStyle extractMessagingStyleFromNotification(Notification arg3) {
            MessagingStyle v0 = null;
            Bundle v2 = NotificationCompat.IMPL.getExtras(arg3);
            if(v2 != null) {
                if(v2.containsKey("android.selfDisplayName")) {
                    goto label_8;
                }

                return v0;
            }

            try {
            label_8:
                MessagingStyle v1_1 = new MessagingStyle();
                v1_1.restoreFromCompatExtras(v2);
                v0 = v1_1;
            }
            catch(ClassCastException v1) {
            }

            return v0;
        }

        public CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        public List getMessages() {
            return this.mMessages;
        }

        public CharSequence getUserDisplayName() {
            return this.mUserDisplayName;
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) protected void restoreFromCompatExtras(Bundle arg2) {
            this.mMessages.clear();
            this.mUserDisplayName = arg2.getString("android.selfDisplayName");
            this.mConversationTitle = arg2.getString("android.conversationTitle");
            Parcelable[] v0 = arg2.getParcelableArray("android.messages");
            if(v0 != null) {
                this.mMessages = Message.getMessagesFromBundleArray(v0);
            }
        }

        public MessagingStyle setConversationTitle(CharSequence arg1) {
            this.mConversationTitle = arg1;
            return this;
        }
    }

    interface NotificationCompatImpl {
        Notification build(android.support.v4.app.NotificationCompat$Builder arg1, BuilderExtender arg2);

        Action getAction(Notification arg1, int arg2);

        int getActionCount(Notification arg1);

        Action[] getActionsFromParcelableArrayList(ArrayList arg1);

        Bundle getBundleForUnreadConversation(android.support.v4.app.NotificationCompatBase$UnreadConversation arg1);

        String getCategory(Notification arg1);

        Bundle getExtras(Notification arg1);

        String getGroup(Notification arg1);

        boolean getLocalOnly(Notification arg1);

        ArrayList getParcelableArrayListForActions(Action[] arg1);

        String getSortKey(Notification arg1);

        android.support.v4.app.NotificationCompatBase$UnreadConversation getUnreadConversationFromBundle(Bundle arg1, android.support.v4.app.NotificationCompatBase$UnreadConversation$Factory arg2, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory arg3);

        boolean isGroupSummary(Notification arg1);
    }

    class NotificationCompatImplApi20 extends NotificationCompatImplKitKat {
        NotificationCompatImplApi20() {
            super();
        }

        public Notification build(android.support.v4.app.NotificationCompat$Builder arg29, BuilderExtender arg30) {
            android.support.v4.app.NotificationCompatApi20$Builder v2 = new android.support.v4.app.NotificationCompatApi20$Builder(arg29.mContext, arg29.mNotification, arg29.resolveTitle(), arg29.resolveText(), arg29.mContentInfo, arg29.mTickerView, arg29.mNumber, arg29.mContentIntent, arg29.mFullScreenIntent, arg29.mLargeIcon, arg29.mProgressMax, arg29.mProgress, arg29.mProgressIndeterminate, arg29.mShowWhen, arg29.mUseChronometer, arg29.mPriority, arg29.mSubText, arg29.mLocalOnly, arg29.mPeople, arg29.mExtras, arg29.mGroupKey, arg29.mGroupSummary, arg29.mSortKey, arg29.mContentView, arg29.mBigContentView);
            NotificationCompat.addActionsToBuilder(((NotificationBuilderWithActions)v2), arg29.mActions);
            NotificationCompat.addStyleToBuilderJellybean(((NotificationBuilderWithBuilderAccessor)v2), arg29.mStyle);
            Notification v2_1 = arg30.build(arg29, ((NotificationBuilderWithBuilderAccessor)v2));
            if(arg29.mStyle != null) {
                arg29.mStyle.addCompatExtras(this.getExtras(v2_1));
            }

            return v2_1;
        }

        public Action getAction(Notification arg3, int arg4) {
            return NotificationCompatApi20.getAction(arg3, arg4, Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY);
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList arg3) {
            return NotificationCompatApi20.getActionsFromParcelableArrayList(arg3, Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY);
        }

        public String getGroup(Notification arg2) {
            return NotificationCompatApi20.getGroup(arg2);
        }

        public boolean getLocalOnly(Notification arg2) {
            return NotificationCompatApi20.getLocalOnly(arg2);
        }

        public ArrayList getParcelableArrayListForActions(Action[] arg2) {
            return NotificationCompatApi20.getParcelableArrayListForActions(((android.support.v4.app.NotificationCompatBase$Action[])arg2));
        }

        public String getSortKey(Notification arg2) {
            return NotificationCompatApi20.getSortKey(arg2);
        }

        public boolean isGroupSummary(Notification arg2) {
            return NotificationCompatApi20.isGroupSummary(arg2);
        }
    }

    class NotificationCompatImplApi21 extends NotificationCompatImplApi20 {
        NotificationCompatImplApi21() {
            super();
        }

        public Notification build(android.support.v4.app.NotificationCompat$Builder arg34, BuilderExtender arg35) {
            android.support.v4.app.NotificationCompatApi21$Builder v2 = new android.support.v4.app.NotificationCompatApi21$Builder(arg34.mContext, arg34.mNotification, arg34.resolveTitle(), arg34.resolveText(), arg34.mContentInfo, arg34.mTickerView, arg34.mNumber, arg34.mContentIntent, arg34.mFullScreenIntent, arg34.mLargeIcon, arg34.mProgressMax, arg34.mProgress, arg34.mProgressIndeterminate, arg34.mShowWhen, arg34.mUseChronometer, arg34.mPriority, arg34.mSubText, arg34.mLocalOnly, arg34.mCategory, arg34.mPeople, arg34.mExtras, arg34.mColor, arg34.mVisibility, arg34.mPublicVersion, arg34.mGroupKey, arg34.mGroupSummary, arg34.mSortKey, arg34.mContentView, arg34.mBigContentView, arg34.mHeadsUpContentView);
            NotificationCompat.addActionsToBuilder(((NotificationBuilderWithActions)v2), arg34.mActions);
            NotificationCompat.addStyleToBuilderJellybean(((NotificationBuilderWithBuilderAccessor)v2), arg34.mStyle);
            Notification v2_1 = arg35.build(arg34, ((NotificationBuilderWithBuilderAccessor)v2));
            if(arg34.mStyle != null) {
                arg34.mStyle.addCompatExtras(this.getExtras(v2_1));
            }

            return v2_1;
        }

        public Bundle getBundleForUnreadConversation(android.support.v4.app.NotificationCompatBase$UnreadConversation arg2) {
            return NotificationCompatApi21.getBundleForUnreadConversation(arg2);
        }

        public String getCategory(Notification arg2) {
            return NotificationCompatApi21.getCategory(arg2);
        }

        public android.support.v4.app.NotificationCompatBase$UnreadConversation getUnreadConversationFromBundle(Bundle arg2, android.support.v4.app.NotificationCompatBase$UnreadConversation$Factory arg3, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory arg4) {
            return NotificationCompatApi21.getUnreadConversationFromBundle(arg2, arg3, arg4);
        }
    }

    class NotificationCompatImplApi24 extends NotificationCompatImplApi21 {
        NotificationCompatImplApi24() {
            super();
        }

        public Notification build(android.support.v4.app.NotificationCompat$Builder arg35, BuilderExtender arg36) {
            android.support.v4.app.NotificationCompatApi24$Builder v2 = new android.support.v4.app.NotificationCompatApi24$Builder(arg35.mContext, arg35.mNotification, arg35.mContentTitle, arg35.mContentText, arg35.mContentInfo, arg35.mTickerView, arg35.mNumber, arg35.mContentIntent, arg35.mFullScreenIntent, arg35.mLargeIcon, arg35.mProgressMax, arg35.mProgress, arg35.mProgressIndeterminate, arg35.mShowWhen, arg35.mUseChronometer, arg35.mPriority, arg35.mSubText, arg35.mLocalOnly, arg35.mCategory, arg35.mPeople, arg35.mExtras, arg35.mColor, arg35.mVisibility, arg35.mPublicVersion, arg35.mGroupKey, arg35.mGroupSummary, arg35.mSortKey, arg35.mRemoteInputHistory, arg35.mContentView, arg35.mBigContentView, arg35.mHeadsUpContentView);
            NotificationCompat.addActionsToBuilder(((NotificationBuilderWithActions)v2), arg35.mActions);
            NotificationCompat.addStyleToBuilderApi24(((NotificationBuilderWithBuilderAccessor)v2), arg35.mStyle);
            Notification v2_1 = arg36.build(arg35, ((NotificationBuilderWithBuilderAccessor)v2));
            if(arg35.mStyle != null) {
                arg35.mStyle.addCompatExtras(this.getExtras(v2_1));
            }

            return v2_1;
        }
    }

    class NotificationCompatImplBase implements NotificationCompatImpl {
        NotificationCompatImplBase() {
            super();
        }

        public Notification build(android.support.v4.app.NotificationCompat$Builder arg7, BuilderExtender arg8) {
            Notification v0 = NotificationCompatBase.add(arg7.mNotification, arg7.mContext, arg7.resolveTitle(), arg7.resolveText(), arg7.mContentIntent, arg7.mFullScreenIntent);
            if(arg7.mPriority > 0) {
                v0.flags |= 0x80;
            }

            if(arg7.mContentView != null) {
                v0.contentView = arg7.mContentView;
            }

            return v0;
        }

        public Action getAction(Notification arg2, int arg3) {
            return null;
        }

        public int getActionCount(Notification arg2) {
            return 0;
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList arg2) {
            return null;
        }

        public Bundle getBundleForUnreadConversation(android.support.v4.app.NotificationCompatBase$UnreadConversation arg2) {
            return null;
        }

        public String getCategory(Notification arg2) {
            return null;
        }

        public Bundle getExtras(Notification arg2) {
            return null;
        }

        public String getGroup(Notification arg2) {
            return null;
        }

        public boolean getLocalOnly(Notification arg2) {
            return 0;
        }

        public ArrayList getParcelableArrayListForActions(Action[] arg2) {
            return null;
        }

        public String getSortKey(Notification arg2) {
            return null;
        }

        public android.support.v4.app.NotificationCompatBase$UnreadConversation getUnreadConversationFromBundle(Bundle arg2, android.support.v4.app.NotificationCompatBase$UnreadConversation$Factory arg3, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory arg4) {
            return null;
        }

        public boolean isGroupSummary(Notification arg2) {
            return 0;
        }
    }

    class NotificationCompatImplHoneycomb extends NotificationCompatImplBase {
        NotificationCompatImplHoneycomb() {
            super();
        }

        public Notification build(android.support.v4.app.NotificationCompat$Builder arg11, BuilderExtender arg12) {
            Notification v0 = NotificationCompatHoneycomb.add(arg11.mContext, arg11.mNotification, arg11.resolveTitle(), arg11.resolveText(), arg11.mContentInfo, arg11.mTickerView, arg11.mNumber, arg11.mContentIntent, arg11.mFullScreenIntent, arg11.mLargeIcon);
            if(arg11.mContentView != null) {
                v0.contentView = arg11.mContentView;
            }

            return v0;
        }
    }

    class NotificationCompatImplIceCreamSandwich extends NotificationCompatImplBase {
        NotificationCompatImplIceCreamSandwich() {
            super();
        }

        public Notification build(android.support.v4.app.NotificationCompat$Builder arg17, BuilderExtender arg18) {
            return arg18.build(arg17, new android.support.v4.app.NotificationCompatIceCreamSandwich$Builder(arg17.mContext, arg17.mNotification, arg17.resolveTitle(), arg17.resolveText(), arg17.mContentInfo, arg17.mTickerView, arg17.mNumber, arg17.mContentIntent, arg17.mFullScreenIntent, arg17.mLargeIcon, arg17.mProgressMax, arg17.mProgress, arg17.mProgressIndeterminate));
        }
    }

    class NotificationCompatImplJellybean extends NotificationCompatImplBase {
        NotificationCompatImplJellybean() {
            super();
        }

        public Notification build(android.support.v4.app.NotificationCompat$Builder arg27, BuilderExtender arg28) {
            android.support.v4.app.NotificationCompatJellybean$Builder v2 = new android.support.v4.app.NotificationCompatJellybean$Builder(arg27.mContext, arg27.mNotification, arg27.resolveTitle(), arg27.resolveText(), arg27.mContentInfo, arg27.mTickerView, arg27.mNumber, arg27.mContentIntent, arg27.mFullScreenIntent, arg27.mLargeIcon, arg27.mProgressMax, arg27.mProgress, arg27.mProgressIndeterminate, arg27.mUseChronometer, arg27.mPriority, arg27.mSubText, arg27.mLocalOnly, arg27.mExtras, arg27.mGroupKey, arg27.mGroupSummary, arg27.mSortKey, arg27.mContentView, arg27.mBigContentView);
            NotificationCompat.addActionsToBuilder(((NotificationBuilderWithActions)v2), arg27.mActions);
            NotificationCompat.addStyleToBuilderJellybean(((NotificationBuilderWithBuilderAccessor)v2), arg27.mStyle);
            Notification v2_1 = arg28.build(arg27, ((NotificationBuilderWithBuilderAccessor)v2));
            if(arg27.mStyle != null) {
                Bundle v3 = this.getExtras(v2_1);
                if(v3 != null) {
                    arg27.mStyle.addCompatExtras(v3);
                }
            }

            return v2_1;
        }

        public Action getAction(Notification arg3, int arg4) {
            return NotificationCompatJellybean.getAction(arg3, arg4, Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY);
        }

        public int getActionCount(Notification arg2) {
            return NotificationCompatJellybean.getActionCount(arg2);
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList arg3) {
            return NotificationCompatJellybean.getActionsFromParcelableArrayList(arg3, Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY);
        }

        public Bundle getExtras(Notification arg2) {
            return NotificationCompatJellybean.getExtras(arg2);
        }

        public String getGroup(Notification arg2) {
            return NotificationCompatJellybean.getGroup(arg2);
        }

        public boolean getLocalOnly(Notification arg2) {
            return NotificationCompatJellybean.getLocalOnly(arg2);
        }

        public ArrayList getParcelableArrayListForActions(Action[] arg2) {
            return NotificationCompatJellybean.getParcelableArrayListForActions(((android.support.v4.app.NotificationCompatBase$Action[])arg2));
        }

        public String getSortKey(Notification arg2) {
            return NotificationCompatJellybean.getSortKey(arg2);
        }

        public boolean isGroupSummary(Notification arg2) {
            return NotificationCompatJellybean.isGroupSummary(arg2);
        }
    }

    class NotificationCompatImplKitKat extends NotificationCompatImplJellybean {
        NotificationCompatImplKitKat() {
            super();
        }

        public Notification build(android.support.v4.app.NotificationCompat$Builder arg29, BuilderExtender arg30) {
            android.support.v4.app.NotificationCompatKitKat$Builder v2 = new android.support.v4.app.NotificationCompatKitKat$Builder(arg29.mContext, arg29.mNotification, arg29.resolveTitle(), arg29.resolveText(), arg29.mContentInfo, arg29.mTickerView, arg29.mNumber, arg29.mContentIntent, arg29.mFullScreenIntent, arg29.mLargeIcon, arg29.mProgressMax, arg29.mProgress, arg29.mProgressIndeterminate, arg29.mShowWhen, arg29.mUseChronometer, arg29.mPriority, arg29.mSubText, arg29.mLocalOnly, arg29.mPeople, arg29.mExtras, arg29.mGroupKey, arg29.mGroupSummary, arg29.mSortKey, arg29.mContentView, arg29.mBigContentView);
            NotificationCompat.addActionsToBuilder(((NotificationBuilderWithActions)v2), arg29.mActions);
            NotificationCompat.addStyleToBuilderJellybean(((NotificationBuilderWithBuilderAccessor)v2), arg29.mStyle);
            return arg30.build(arg29, ((NotificationBuilderWithBuilderAccessor)v2));
        }

        public Action getAction(Notification arg3, int arg4) {
            return NotificationCompatKitKat.getAction(arg3, arg4, Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY);
        }

        public int getActionCount(Notification arg2) {
            return NotificationCompatKitKat.getActionCount(arg2);
        }

        public Bundle getExtras(Notification arg2) {
            return NotificationCompatKitKat.getExtras(arg2);
        }

        public String getGroup(Notification arg2) {
            return NotificationCompatKitKat.getGroup(arg2);
        }

        public boolean getLocalOnly(Notification arg2) {
            return NotificationCompatKitKat.getLocalOnly(arg2);
        }

        public String getSortKey(Notification arg2) {
            return NotificationCompatKitKat.getSortKey(arg2);
        }

        public boolean isGroupSummary(Notification arg2) {
            return NotificationCompatKitKat.isGroupSummary(arg2);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface NotificationVisibility {
    }

    public abstract class Style {
        CharSequence mBigContentTitle;
        android.support.v4.app.NotificationCompat$Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet;

        public Style() {
            super();
            this.mSummaryTextSet = false;
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) public void addCompatExtras(Bundle arg1) {
        }

        public Notification build() {
            Notification v0 = null;
            if(this.mBuilder != null) {
                v0 = this.mBuilder.build();
            }

            return v0;
        }

        @RestrictTo(value={Scope.LIBRARY_GROUP}) protected void restoreFromCompatExtras(Bundle arg1) {
        }

        public void setBuilder(android.support.v4.app.NotificationCompat$Builder arg2) {
            if(this.mBuilder != arg2) {
                this.mBuilder = arg2;
                if(this.mBuilder != null) {
                    this.mBuilder.setStyle(this);
                }
            }
        }
    }

    public final class android.support.v4.app.NotificationCompat$WearableExtender implements android.support.v4.app.NotificationCompat$Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 0x800005;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_BIG_PICTURE_AMBIENT = 0x20;
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 0x40;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_BRIDGE_TAG = "bridgeTag";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISMISSAL_ID = "dismissalId";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final String KEY_PAGES = "pages";
        public static final int SCREEN_TIMEOUT_LONG = -1;
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        public static final int SIZE_DEFAULT = 0;
        public static final int SIZE_FULL_SCREEN = 5;
        public static final int SIZE_LARGE = 4;
        public static final int SIZE_MEDIUM = 3;
        public static final int SIZE_SMALL = 2;
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList mActions;
        private Bitmap mBackground;
        private String mBridgeTag;
        private int mContentActionIndex;
        private int mContentIcon;
        private int mContentIconGravity;
        private int mCustomContentHeight;
        private int mCustomSizePreset;
        private String mDismissalId;
        private PendingIntent mDisplayIntent;
        private int mFlags;
        private int mGravity;
        private int mHintScreenTimeout;
        private ArrayList mPages;

        public android.support.v4.app.NotificationCompat$WearableExtender() {
            super();
            this.mActions = new ArrayList();
            this.mFlags = 1;
            this.mPages = new ArrayList();
            this.mContentIconGravity = 0x800005;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender(Notification arg9) {
            int v7 = 0x800005;
            int v6 = 80;
            int v3 = -1;
            super();
            this.mActions = new ArrayList();
            this.mFlags = 1;
            this.mPages = new ArrayList();
            this.mContentIconGravity = v7;
            this.mContentActionIndex = v3;
            this.mCustomSizePreset = 0;
            this.mGravity = v6;
            Bundle v0 = NotificationCompat.getExtras(arg9);
            Bundle v1 = v0 != null ? v0.getBundle("android.wearable.EXTENSIONS") : null;
            if(v1 != null) {
                Action[] v0_1 = NotificationCompat.IMPL.getActionsFromParcelableArrayList(v1.getParcelableArrayList("actions"));
                if(v0_1 != null) {
                    Collections.addAll(this.mActions, ((Object[])v0_1));
                }

                this.mFlags = v1.getInt("flags", 1);
                this.mDisplayIntent = v1.getParcelable("displayIntent");
                Notification[] v0_2 = NotificationCompat.getNotificationArrayFromBundle(v1, "pages");
                if(v0_2 != null) {
                    Collections.addAll(this.mPages, ((Object[])v0_2));
                }

                this.mBackground = v1.getParcelable("background");
                this.mContentIcon = v1.getInt("contentIcon");
                this.mContentIconGravity = v1.getInt("contentIconGravity", v7);
                this.mContentActionIndex = v1.getInt("contentActionIndex", v3);
                this.mCustomSizePreset = v1.getInt("customSizePreset", 0);
                this.mCustomContentHeight = v1.getInt("customContentHeight");
                this.mGravity = v1.getInt("gravity", v6);
                this.mHintScreenTimeout = v1.getInt("hintScreenTimeout");
                this.mDismissalId = v1.getString("dismissalId");
                this.mBridgeTag = v1.getString("bridgeTag");
            }
        }

        public android.support.v4.app.NotificationCompat$WearableExtender addAction(Action arg2) {
            this.mActions.add(arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender addActions(List arg2) {
            this.mActions.addAll(((Collection)arg2));
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender addPage(Notification arg2) {
            this.mPages.add(arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender addPages(List arg2) {
            this.mPages.addAll(((Collection)arg2));
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender clone() {
            android.support.v4.app.NotificationCompat$WearableExtender v0 = new android.support.v4.app.NotificationCompat$WearableExtender();
            v0.mActions = new ArrayList(this.mActions);
            v0.mFlags = this.mFlags;
            v0.mDisplayIntent = this.mDisplayIntent;
            v0.mPages = new ArrayList(this.mPages);
            v0.mBackground = this.mBackground;
            v0.mContentIcon = this.mContentIcon;
            v0.mContentIconGravity = this.mContentIconGravity;
            v0.mContentActionIndex = this.mContentActionIndex;
            v0.mCustomSizePreset = this.mCustomSizePreset;
            v0.mCustomContentHeight = this.mCustomContentHeight;
            v0.mGravity = this.mGravity;
            v0.mHintScreenTimeout = this.mHintScreenTimeout;
            v0.mDismissalId = this.mDismissalId;
            v0.mBridgeTag = this.mBridgeTag;
            return v0;
        }

        public Object clone() {
            return this.clone();
        }

        public android.support.v4.app.NotificationCompat$Builder extend(android.support.v4.app.NotificationCompat$Builder arg6) {
            Bundle v1 = new Bundle();
            if(!this.mActions.isEmpty()) {
                v1.putParcelableArrayList("actions", NotificationCompat.IMPL.getParcelableArrayListForActions(this.mActions.toArray(new Action[this.mActions.size()])));
            }

            if(this.mFlags != 1) {
                v1.putInt("flags", this.mFlags);
            }

            if(this.mDisplayIntent != null) {
                v1.putParcelable("displayIntent", this.mDisplayIntent);
            }

            if(!this.mPages.isEmpty()) {
                v1.putParcelableArray("pages", this.mPages.toArray(new Notification[this.mPages.size()]));
            }

            if(this.mBackground != null) {
                v1.putParcelable("background", this.mBackground);
            }

            if(this.mContentIcon != 0) {
                v1.putInt("contentIcon", this.mContentIcon);
            }

            if(this.mContentIconGravity != 0x800005) {
                v1.putInt("contentIconGravity", this.mContentIconGravity);
            }

            if(this.mContentActionIndex != -1) {
                v1.putInt("contentActionIndex", this.mContentActionIndex);
            }

            if(this.mCustomSizePreset != 0) {
                v1.putInt("customSizePreset", this.mCustomSizePreset);
            }

            if(this.mCustomContentHeight != 0) {
                v1.putInt("customContentHeight", this.mCustomContentHeight);
            }

            if(this.mGravity != 80) {
                v1.putInt("gravity", this.mGravity);
            }

            if(this.mHintScreenTimeout != 0) {
                v1.putInt("hintScreenTimeout", this.mHintScreenTimeout);
            }

            if(this.mDismissalId != null) {
                v1.putString("dismissalId", this.mDismissalId);
            }

            if(this.mBridgeTag != null) {
                v1.putString("bridgeTag", this.mBridgeTag);
            }

            arg6.getExtras().putBundle("android.wearable.EXTENSIONS", v1);
            return arg6;
        }

        public List getActions() {
            return this.mActions;
        }

        public Bitmap getBackground() {
            return this.mBackground;
        }

        public String getBridgeTag() {
            return this.mBridgeTag;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        public int getContentIcon() {
            return this.mContentIcon;
        }

        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public boolean getContentIntentAvailableOffline() {
            boolean v0 = (this.mFlags & 1) != 0 ? true : false;
            return v0;
        }

        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        public String getDismissalId() {
            return this.mDismissalId;
        }

        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        public int getGravity() {
            return this.mGravity;
        }

        public boolean getHintAmbientBigPicture() {
            boolean v0 = (this.mFlags & 0x20) != 0 ? true : false;
            return v0;
        }

        public boolean getHintAvoidBackgroundClipping() {
            boolean v0 = (this.mFlags & 16) != 0 ? true : false;
            return v0;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            boolean v0 = (this.mFlags & 0x40) != 0 ? true : false;
            return v0;
        }

        public boolean getHintHideIcon() {
            boolean v0 = (this.mFlags & 2) != 0 ? true : false;
            return v0;
        }

        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        public boolean getHintShowBackgroundOnly() {
            boolean v0 = (this.mFlags & 4) != 0 ? true : false;
            return v0;
        }

        public List getPages() {
            return this.mPages;
        }

        public boolean getStartScrollBottom() {
            boolean v0 = (this.mFlags & 8) != 0 ? true : false;
            return v0;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setBackground(Bitmap arg1) {
            this.mBackground = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setBridgeTag(String arg1) {
            this.mBridgeTag = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setContentAction(int arg1) {
            this.mContentActionIndex = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setContentIcon(int arg1) {
            this.mContentIcon = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setContentIconGravity(int arg1) {
            this.mContentIconGravity = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setContentIntentAvailableOffline(boolean arg2) {
            this.setFlag(1, arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setCustomContentHeight(int arg1) {
            this.mCustomContentHeight = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setCustomSizePreset(int arg1) {
            this.mCustomSizePreset = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setDismissalId(String arg1) {
            this.mDismissalId = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setDisplayIntent(PendingIntent arg1) {
            this.mDisplayIntent = arg1;
            return this;
        }

        private void setFlag(int arg3, boolean arg4) {
            if(arg4) {
                this.mFlags |= arg3;
            }
            else {
                this.mFlags &= arg3 ^ -1;
            }
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setGravity(int arg1) {
            this.mGravity = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setHintAmbientBigPicture(boolean arg2) {
            this.setFlag(0x20, arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setHintAvoidBackgroundClipping(boolean arg2) {
            this.setFlag(16, arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setHintContentIntentLaunchesActivity(boolean arg2) {
            this.setFlag(0x40, arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setHintHideIcon(boolean arg2) {
            this.setFlag(2, arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setHintScreenTimeout(int arg1) {
            this.mHintScreenTimeout = arg1;
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setHintShowBackgroundOnly(boolean arg2) {
            this.setFlag(4, arg2);
            return this;
        }

        public android.support.v4.app.NotificationCompat$WearableExtender setStartScrollBottom(boolean arg2) {
            this.setFlag(8, arg2);
            return this;
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
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    @ColorInt public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_FOREGROUND_SERVICE = 0x40;
    public static final int FLAG_GROUP_SUMMARY = 0x200;
    @Deprecated public static final int FLAG_HIGH_PRIORITY = 0x80;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 0x100;
    public static final int FLAG_NO_CLEAR = 0x20;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    static final NotificationCompatImpl IMPL = null;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    static {
        if(BuildCompat.isAtLeastN()) {
            NotificationCompat.IMPL = new NotificationCompatImplApi24();
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            NotificationCompat.IMPL = new NotificationCompatImplApi21();
        }
        else if(Build$VERSION.SDK_INT >= 20) {
            NotificationCompat.IMPL = new NotificationCompatImplApi20();
        }
        else if(Build$VERSION.SDK_INT >= 19) {
            NotificationCompat.IMPL = new NotificationCompatImplKitKat();
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            NotificationCompat.IMPL = new NotificationCompatImplJellybean();
        }
        else if(Build$VERSION.SDK_INT >= 14) {
            NotificationCompat.IMPL = new NotificationCompatImplIceCreamSandwich();
        }
        else if(Build$VERSION.SDK_INT >= 11) {
            NotificationCompat.IMPL = new NotificationCompatImplHoneycomb();
        }
        else {
            NotificationCompat.IMPL = new NotificationCompatImplBase();
        }
    }

    public NotificationCompat() {
        super();
    }

    static void addActionsToBuilder(NotificationBuilderWithActions arg2, ArrayList arg3) {
        Iterator v1 = arg3.iterator();
        while(v1.hasNext()) {
            arg2.addAction(v1.next());
        }
    }

    static void addStyleToBuilderApi24(NotificationBuilderWithBuilderAccessor arg10, Style arg11) {
        if(arg11 != null) {
            if((arg11 instanceof MessagingStyle)) {
                ArrayList v3 = new ArrayList();
                ArrayList v4 = new ArrayList();
                ArrayList v5 = new ArrayList();
                ArrayList v6 = new ArrayList();
                ArrayList v7 = new ArrayList();
                Iterator v1 = ((MessagingStyle)arg11).mMessages.iterator();
                while(v1.hasNext()) {
                    Object v0 = v1.next();
                    ((List)v3).add(((Message)v0).getText());
                    ((List)v4).add(Long.valueOf(((Message)v0).getTimestamp()));
                    ((List)v5).add(((Message)v0).getSender());
                    ((List)v6).add(((Message)v0).getDataMimeType());
                    ((List)v7).add(((Message)v0).getDataUri());
                }

                NotificationCompatApi24.addMessagingStyle(arg10, ((MessagingStyle)arg11).mUserDisplayName, ((MessagingStyle)arg11).mConversationTitle, ((List)v3), ((List)v4), ((List)v5), ((List)v6), ((List)v7));
            }
            else {
                NotificationCompat.addStyleToBuilderJellybean(arg10, arg11);
            }
        }
    }

    static void addStyleToBuilderJellybean(NotificationBuilderWithBuilderAccessor arg7, Style arg8) {
        if(arg8 != null) {
            if((arg8 instanceof BigTextStyle)) {
                NotificationCompatJellybean.addBigTextStyle(arg7, ((BigTextStyle)arg8).mBigContentTitle, ((BigTextStyle)arg8).mSummaryTextSet, ((BigTextStyle)arg8).mSummaryText, ((BigTextStyle)arg8).mBigText);
            }
            else if((arg8 instanceof InboxStyle)) {
                NotificationCompatJellybean.addInboxStyle(arg7, ((InboxStyle)arg8).mBigContentTitle, ((InboxStyle)arg8).mSummaryTextSet, ((InboxStyle)arg8).mSummaryText, ((InboxStyle)arg8).mTexts);
            }
            else if((arg8 instanceof BigPictureStyle)) {
                NotificationCompatJellybean.addBigPictureStyle(arg7, ((BigPictureStyle)arg8).mBigContentTitle, ((BigPictureStyle)arg8).mSummaryTextSet, ((BigPictureStyle)arg8).mSummaryText, ((BigPictureStyle)arg8).mPicture, ((BigPictureStyle)arg8).mBigLargeIcon, ((BigPictureStyle)arg8).mBigLargeIconSet);
            }
        }
    }

    public static Action getAction(Notification arg1, int arg2) {
        return NotificationCompat.IMPL.getAction(arg1, arg2);
    }

    public static int getActionCount(Notification arg1) {
        return NotificationCompat.IMPL.getActionCount(arg1);
    }

    public static String getCategory(Notification arg1) {
        return NotificationCompat.IMPL.getCategory(arg1);
    }

    public static Bundle getExtras(Notification arg1) {
        return NotificationCompat.IMPL.getExtras(arg1);
    }

    public static String getGroup(Notification arg1) {
        return NotificationCompat.IMPL.getGroup(arg1);
    }

    public static boolean getLocalOnly(Notification arg1) {
        return NotificationCompat.IMPL.getLocalOnly(arg1);
    }

    static Notification[] getNotificationArrayFromBundle(Bundle arg4, String arg5) {
        Parcelable[] v0 = arg4.getParcelableArray(arg5);
        if(!(v0 instanceof Notification[]) && v0 != null) {
            Notification[] v3 = new Notification[v0.length];
            int v2;
            for(v2 = 0; v2 < v0.length; ++v2) {
                v3[v2] = v0[v2];
            }

            arg4.putParcelableArray(arg5, ((Parcelable[])v3));
            Notification[] v0_1 = v3;
        }

        return ((Notification[])v0);
    }

    public static String getSortKey(Notification arg1) {
        return NotificationCompat.IMPL.getSortKey(arg1);
    }

    public static boolean isGroupSummary(Notification arg1) {
        return NotificationCompat.IMPL.isGroupSummary(arg1);
    }
}

