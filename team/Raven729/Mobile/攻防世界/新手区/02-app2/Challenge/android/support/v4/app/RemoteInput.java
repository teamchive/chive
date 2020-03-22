package android.support.v4.app;

import android.content.Intent;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.util.Log;

public final class RemoteInput extends android.support.v4.app.RemoteInputCompatBase$RemoteInput {
    final class android.support.v4.app.RemoteInput$1 implements Factory {
        android.support.v4.app.RemoteInput$1() {
            super();
        }

        public RemoteInput build(String arg7, CharSequence arg8, CharSequence[] arg9, boolean arg10, Bundle arg11) {
            return new RemoteInput(arg7, arg8, arg9, arg10, arg11);
        }

        public android.support.v4.app.RemoteInputCompatBase$RemoteInput build(String arg2, CharSequence arg3, CharSequence[] arg4, boolean arg5, Bundle arg6) {
            return this.build(arg2, arg3, arg4, arg5, arg6);
        }

        public RemoteInput[] newArray(int arg2) {
            return new RemoteInput[arg2];
        }

        public android.support.v4.app.RemoteInputCompatBase$RemoteInput[] newArray(int arg2) {
            return this.newArray(arg2);
        }
    }

    public final class Builder {
        private boolean mAllowFreeFormInput;
        private CharSequence[] mChoices;
        private Bundle mExtras;
        private CharSequence mLabel;
        private final String mResultKey;

        public Builder(String arg3) {
            super();
            this.mAllowFreeFormInput = true;
            this.mExtras = new Bundle();
            if(arg3 == null) {
                throw new IllegalArgumentException("Result key can\'t be null");
            }

            this.mResultKey = arg3;
        }

        public Builder addExtras(Bundle arg2) {
            if(arg2 != null) {
                this.mExtras.putAll(arg2);
            }

            return this;
        }

        public RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormInput, this.mExtras);
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public Builder setAllowFreeFormInput(boolean arg1) {
            this.mAllowFreeFormInput = arg1;
            return this;
        }

        public Builder setChoices(CharSequence[] arg1) {
            this.mChoices = arg1;
            return this;
        }

        public Builder setLabel(CharSequence arg1) {
            this.mLabel = arg1;
            return this;
        }
    }

    interface Impl {
        void addResultsToIntent(RemoteInput[] arg1, Intent arg2, Bundle arg3);

        Bundle getResultsFromIntent(Intent arg1);
    }

    class ImplApi20 implements Impl {
        ImplApi20() {
            super();
        }

        public void addResultsToIntent(RemoteInput[] arg1, Intent arg2, Bundle arg3) {
            RemoteInputCompatApi20.addResultsToIntent(((android.support.v4.app.RemoteInputCompatBase$RemoteInput[])arg1), arg2, arg3);
        }

        public Bundle getResultsFromIntent(Intent arg2) {
            return RemoteInputCompatApi20.getResultsFromIntent(arg2);
        }
    }

    class ImplBase implements Impl {
        ImplBase() {
            super();
        }

        public void addResultsToIntent(RemoteInput[] arg3, Intent arg4, Bundle arg5) {
            Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        }

        public Bundle getResultsFromIntent(Intent arg3) {
            Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
            return null;
        }
    }

    class ImplJellybean implements Impl {
        ImplJellybean() {
            super();
        }

        public void addResultsToIntent(RemoteInput[] arg1, Intent arg2, Bundle arg3) {
            RemoteInputCompatJellybean.addResultsToIntent(((android.support.v4.app.RemoteInputCompatBase$RemoteInput[])arg1), arg2, arg3);
        }

        public Bundle getResultsFromIntent(Intent arg2) {
            return RemoteInputCompatJellybean.getResultsFromIntent(arg2);
        }
    }

    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    @RestrictTo(value={Scope.LIBRARY_GROUP}) public static final Factory FACTORY = null;
    private static final Impl IMPL = null;
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    private static final String TAG = "RemoteInput";
    private final boolean mAllowFreeFormInput;
    private final CharSequence[] mChoices;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    static {
        if(Build$VERSION.SDK_INT >= 20) {
            RemoteInput.IMPL = new ImplApi20();
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            RemoteInput.IMPL = new ImplJellybean();
        }
        else {
            RemoteInput.IMPL = new ImplBase();
        }

        RemoteInput.FACTORY = new android.support.v4.app.RemoteInput$1();
    }

    RemoteInput(String arg1, CharSequence arg2, CharSequence[] arg3, boolean arg4, Bundle arg5) {
        super();
        this.mResultKey = arg1;
        this.mLabel = arg2;
        this.mChoices = arg3;
        this.mAllowFreeFormInput = arg4;
        this.mExtras = arg5;
    }

    public static void addResultsToIntent(RemoteInput[] arg1, Intent arg2, Bundle arg3) {
        RemoteInput.IMPL.addResultsToIntent(arg1, arg2, arg3);
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormInput;
    }

    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public String getResultKey() {
        return this.mResultKey;
    }

    public static Bundle getResultsFromIntent(Intent arg1) {
        return RemoteInput.IMPL.getResultsFromIntent(arg1);
    }
}

