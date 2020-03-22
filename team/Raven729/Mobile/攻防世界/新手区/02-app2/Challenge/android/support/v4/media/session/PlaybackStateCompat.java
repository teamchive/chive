package android.support.v4.media.session;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    final class android.support.v4.media.session.PlaybackStateCompat$1 implements Parcelable$Creator {
        android.support.v4.media.session.PlaybackStateCompat$1() {
            super();
        }

        public PlaybackStateCompat createFromParcel(Parcel arg2) {
            return new PlaybackStateCompat(arg2);
        }

        public Object createFromParcel(Parcel arg2) {
            return this.createFromParcel(arg2);
        }

        public PlaybackStateCompat[] newArray(int arg2) {
            return new PlaybackStateCompat[arg2];
        }

        public Object[] newArray(int arg2) {
            return this.newArray(arg2);
        }
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface Actions {
    }

    public final class Builder {
        private long mActions;
        private long mActiveItemId;
        private long mBufferedPosition;
        private final List mCustomActions;
        private int mErrorCode;
        private CharSequence mErrorMessage;
        private Bundle mExtras;
        private long mPosition;
        private float mRate;
        private int mState;
        private long mUpdateTime;

        public Builder(PlaybackStateCompat arg3) {
            super();
            this.mCustomActions = new ArrayList();
            this.mActiveItemId = -1;
            this.mState = arg3.mState;
            this.mPosition = arg3.mPosition;
            this.mRate = arg3.mSpeed;
            this.mUpdateTime = arg3.mUpdateTime;
            this.mBufferedPosition = arg3.mBufferedPosition;
            this.mActions = arg3.mActions;
            this.mErrorCode = arg3.mErrorCode;
            this.mErrorMessage = arg3.mErrorMessage;
            if(arg3.mCustomActions != null) {
                this.mCustomActions.addAll(arg3.mCustomActions);
            }

            this.mActiveItemId = arg3.mActiveItemId;
            this.mExtras = arg3.mExtras;
        }

        public Builder() {
            super();
            this.mCustomActions = new ArrayList();
            this.mActiveItemId = -1;
        }

        public Builder addCustomAction(CustomAction arg3) {
            if(arg3 == null) {
                throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
            }

            this.mCustomActions.add(arg3);
            return this;
        }

        public Builder addCustomAction(String arg3, String arg4, int arg5) {
            return this.addCustomAction(new CustomAction(arg3, ((CharSequence)arg4), arg5, null));
        }

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.mState, this.mPosition, this.mBufferedPosition, this.mRate, this.mActions, this.mErrorCode, this.mErrorMessage, this.mUpdateTime, this.mCustomActions, this.mActiveItemId, this.mExtras);
        }

        public Builder setActions(long arg2) {
            this.mActions = arg2;
            return this;
        }

        public Builder setActiveQueueItemId(long arg2) {
            this.mActiveItemId = arg2;
            return this;
        }

        public Builder setBufferedPosition(long arg2) {
            this.mBufferedPosition = arg2;
            return this;
        }

        public Builder setErrorMessage(int arg1, CharSequence arg2) {
            this.mErrorCode = arg1;
            this.mErrorMessage = arg2;
            return this;
        }

        public Builder setErrorMessage(CharSequence arg1) {
            this.mErrorMessage = arg1;
            return this;
        }

        public Builder setExtras(Bundle arg1) {
            this.mExtras = arg1;
            return this;
        }

        public Builder setState(int arg1, long arg2, float arg4, long arg5) {
            this.mState = arg1;
            this.mPosition = arg2;
            this.mUpdateTime = arg5;
            this.mRate = arg4;
            return this;
        }

        public Builder setState(int arg9, long arg10, float arg12) {
            return this.setState(arg9, arg10, arg12, SystemClock.elapsedRealtime());
        }
    }

    public final class CustomAction implements Parcelable {
        final class android.support.v4.media.session.PlaybackStateCompat$CustomAction$1 implements Parcelable$Creator {
            android.support.v4.media.session.PlaybackStateCompat$CustomAction$1() {
                super();
            }

            public CustomAction createFromParcel(Parcel arg2) {
                return new CustomAction(arg2);
            }

            public Object createFromParcel(Parcel arg2) {
                return this.createFromParcel(arg2);
            }

            public CustomAction[] newArray(int arg2) {
                return new CustomAction[arg2];
            }

            public Object[] newArray(int arg2) {
                return this.newArray(arg2);
            }
        }

        public final class android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder {
            private final String mAction;
            private Bundle mExtras;
            private final int mIcon;
            private final CharSequence mName;

            public android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder(String arg3, CharSequence arg4, int arg5) {
                super();
                if(TextUtils.isEmpty(((CharSequence)arg3))) {
                    throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
                }

                if(TextUtils.isEmpty(arg4)) {
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
                }

                if(arg5 == 0) {
                    throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
                }

                this.mAction = arg3;
                this.mName = arg4;
                this.mIcon = arg5;
            }

            public CustomAction build() {
                return new CustomAction(this.mAction, this.mName, this.mIcon, this.mExtras);
            }

            public android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder setExtras(Bundle arg1) {
                this.mExtras = arg1;
                return this;
            }
        }

        public static final Parcelable$Creator CREATOR;
        private final String mAction;
        private Object mCustomActionObj;
        private final Bundle mExtras;
        private final int mIcon;
        private final CharSequence mName;

        static {
            CustomAction.CREATOR = new android.support.v4.media.session.PlaybackStateCompat$CustomAction$1();
        }

        CustomAction(String arg1, CharSequence arg2, int arg3, Bundle arg4) {
            super();
            this.mAction = arg1;
            this.mName = arg2;
            this.mIcon = arg3;
            this.mExtras = arg4;
        }

        CustomAction(Parcel arg2) {
            super();
            this.mAction = arg2.readString();
            this.mName = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg2);
            this.mIcon = arg2.readInt();
            this.mExtras = arg2.readBundle();
        }

        public int describeContents() {
            return 0;
        }

        public static CustomAction fromCustomAction(Object arg5) {
            CustomAction v0;
            if(arg5 == null || Build$VERSION.SDK_INT < 21) {
                v0 = null;
            }
            else {
                v0 = new CustomAction(android.support.v4.media.session.PlaybackStateCompatApi21$CustomAction.getAction(arg5), android.support.v4.media.session.PlaybackStateCompatApi21$CustomAction.getName(arg5), android.support.v4.media.session.PlaybackStateCompatApi21$CustomAction.getIcon(arg5), android.support.v4.media.session.PlaybackStateCompatApi21$CustomAction.getExtras(arg5));
                v0.mCustomActionObj = arg5;
            }

            return v0;
        }

        public String getAction() {
            return this.mAction;
        }

        public Object getCustomAction() {
            Object v0;
            if(this.mCustomActionObj != null || Build$VERSION.SDK_INT < 21) {
                v0 = this.mCustomActionObj;
            }
            else {
                this.mCustomActionObj = android.support.v4.media.session.PlaybackStateCompatApi21$CustomAction.newInstance(this.mAction, this.mName, this.mIcon, this.mExtras);
                v0 = this.mCustomActionObj;
            }

            return v0;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getIcon() {
            return this.mIcon;
        }

        public CharSequence getName() {
            return this.mName;
        }

        public String toString() {
            return "Action:mName=\'" + this.mName + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            arg2.writeString(this.mAction);
            TextUtils.writeToParcel(this.mName, arg2, arg3);
            arg2.writeInt(this.mIcon);
            arg2.writeBundle(this.mExtras);
        }
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface ErrorCode {
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface MediaKeyAction {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface RepeatMode {
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface State {
    }

    public static final long ACTION_FAST_FORWARD = 0x40;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 0x400;
    public static final long ACTION_PLAY_FROM_SEARCH = 0x800;
    public static final long ACTION_PLAY_FROM_URI = 0x2000;
    public static final long ACTION_PLAY_PAUSE = 0x200;
    public static final long ACTION_PREPARE = 0x4000;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 0x8000;
    public static final long ACTION_PREPARE_FROM_SEARCH = 0x10000;
    public static final long ACTION_PREPARE_FROM_URI = 0x20000;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 0x100;
    public static final long ACTION_SET_RATING = 0x80;
    public static final long ACTION_SET_REPEAT_MODE = 0x40000;
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 0x80000;
    public static final long ACTION_SKIP_TO_NEXT = 0x20;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 0x1000;
    public static final long ACTION_STOP = 1;
    public static final Parcelable$Creator CREATOR = null;
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    private static final int KEYCODE_MEDIA_PAUSE = 0x7F;
    private static final int KEYCODE_MEDIA_PLAY = 0x7E;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    final long mActions;
    final long mActiveItemId;
    final long mBufferedPosition;
    List mCustomActions;
    final int mErrorCode;
    final CharSequence mErrorMessage;
    final Bundle mExtras;
    final long mPosition;
    final float mSpeed;
    final int mState;
    private Object mStateObj;
    final long mUpdateTime;

    static {
        PlaybackStateCompat.CREATOR = new android.support.v4.media.session.PlaybackStateCompat$1();
    }

    PlaybackStateCompat(int arg5, long arg6, long arg8, float arg10, long arg11, int arg13, CharSequence arg14, long arg15, List arg17, long arg18, Bundle arg20) {
        super();
        this.mState = arg5;
        this.mPosition = arg6;
        this.mBufferedPosition = arg8;
        this.mSpeed = arg10;
        this.mActions = arg11;
        this.mErrorCode = arg13;
        this.mErrorMessage = arg14;
        this.mUpdateTime = arg15;
        this.mCustomActions = new ArrayList(arg17);
        this.mActiveItemId = arg18;
        this.mExtras = arg20;
    }

    PlaybackStateCompat(Parcel arg3) {
        super();
        this.mState = arg3.readInt();
        this.mPosition = arg3.readLong();
        this.mSpeed = arg3.readFloat();
        this.mUpdateTime = arg3.readLong();
        this.mBufferedPosition = arg3.readLong();
        this.mActions = arg3.readLong();
        this.mErrorMessage = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg3);
        this.mCustomActions = arg3.createTypedArrayList(CustomAction.CREATOR);
        this.mActiveItemId = arg3.readLong();
        this.mExtras = arg3.readBundle();
        this.mErrorCode = arg3.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public static PlaybackStateCompat fromPlaybackState(Object arg19) {
        PlaybackStateCompat v2_2;
        if(arg19 == null || Build$VERSION.SDK_INT < 21) {
            v2_2 = null;
        }
        else {
            List v2 = PlaybackStateCompatApi21.getCustomActions(arg19);
            List v15 = null;
            if(v2 != null) {
                ArrayList v15_1 = new ArrayList(v2.size());
                Iterator v2_1 = v2.iterator();
                while(v2_1.hasNext()) {
                    ((List)v15_1).add(CustomAction.fromCustomAction(v2_1.next()));
                }
            }

            Bundle v18 = Build$VERSION.SDK_INT >= 22 ? PlaybackStateCompatApi22.getExtras(arg19) : null;
            v2_2 = new PlaybackStateCompat(PlaybackStateCompatApi21.getState(arg19), PlaybackStateCompatApi21.getPosition(arg19), PlaybackStateCompatApi21.getBufferedPosition(arg19), PlaybackStateCompatApi21.getPlaybackSpeed(arg19), PlaybackStateCompatApi21.getActions(arg19), 0, PlaybackStateCompatApi21.getErrorMessage(arg19), PlaybackStateCompatApi21.getLastPositionUpdateTime(arg19), v15, PlaybackStateCompatApi21.getActiveQueueItemId(arg19), v18);
            v2_2.mStateObj = arg19;
        }

        return v2_2;
    }

    public long getActions() {
        return this.mActions;
    }

    public long getActiveQueueItemId() {
        return this.mActiveItemId;
    }

    public long getBufferedPosition() {
        return this.mBufferedPosition;
    }

    public List getCustomActions() {
        return this.mCustomActions;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    @Nullable public Bundle getExtras() {
        return this.mExtras;
    }

    public long getLastPositionUpdateTime() {
        return this.mUpdateTime;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public Object getPlaybackState() {
        Object v2;
        ArrayList v14_1;
        if(this.mStateObj != null || Build$VERSION.SDK_INT < 21) {
            v2 = this.mStateObj;
        }
        else {
            List v14 = null;
            if(this.mCustomActions != null) {
                v14_1 = new ArrayList(this.mCustomActions.size());
                Iterator v3 = this.mCustomActions.iterator();
                while(v3.hasNext()) {
                    ((List)v14_1).add(v3.next().getCustomAction());
                }
            }

            this.mStateObj = Build$VERSION.SDK_INT >= 22 ? PlaybackStateCompatApi22.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, ((List)v14_1), this.mActiveItemId, this.mExtras) : PlaybackStateCompatApi21.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, ((List)v14_1), this.mActiveItemId);
            v2 = this.mStateObj;
        }

        return v2;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public int getState() {
        return this.mState;
    }

    public static int toKeyCode(long arg2) {
        int v0;
        if(arg2 == 4) {
            v0 = 0x7E;
        }
        else if(arg2 == 2) {
            v0 = 0x7F;
        }
        else if(arg2 == 0x20) {
            v0 = 87;
        }
        else if(arg2 == 16) {
            v0 = 88;
        }
        else if(arg2 == 1) {
            v0 = 86;
        }
        else if(arg2 == 0x40) {
            v0 = 90;
        }
        else if(arg2 == 8) {
            v0 = 89;
        }
        else if(arg2 == 0x200) {
            v0 = 85;
        }
        else {
            v0 = 0;
        }

        return v0;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("PlaybackState {");
        v0.append("state=").append(this.mState);
        v0.append(", position=").append(this.mPosition);
        v0.append(", buffered position=").append(this.mBufferedPosition);
        v0.append(", speed=").append(this.mSpeed);
        v0.append(", updated=").append(this.mUpdateTime);
        v0.append(", actions=").append(this.mActions);
        v0.append(", error code=").append(this.mErrorCode);
        v0.append(", error message=").append(this.mErrorMessage);
        v0.append(", custom actions=").append(this.mCustomActions);
        v0.append(", active item id=").append(this.mActiveItemId);
        v0.append("}");
        return v0.toString();
    }

    public void writeToParcel(Parcel arg3, int arg4) {
        arg3.writeInt(this.mState);
        arg3.writeLong(this.mPosition);
        arg3.writeFloat(this.mSpeed);
        arg3.writeLong(this.mUpdateTime);
        arg3.writeLong(this.mBufferedPosition);
        arg3.writeLong(this.mActions);
        TextUtils.writeToParcel(this.mErrorMessage, arg3, arg4);
        arg3.writeTypedList(this.mCustomActions);
        arg3.writeLong(this.mActiveItemId);
        arg3.writeBundle(this.mExtras);
        arg3.writeInt(this.mErrorCode);
    }
}

