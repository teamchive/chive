package android.support.v4.app;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(value=9) @RequiresApi(value=9) class RemoteInputCompatBase {
    public abstract class RemoteInput {
        public interface Factory {
            RemoteInput build(String arg1, CharSequence arg2, CharSequence[] arg3, boolean arg4, Bundle arg5);

            RemoteInput[] newArray(int arg1);
        }

        public RemoteInput() {
            super();
        }

        protected abstract boolean getAllowFreeFormInput();

        protected abstract CharSequence[] getChoices();

        protected abstract Bundle getExtras();

        protected abstract CharSequence getLabel();

        protected abstract String getResultKey();
    }

    RemoteInputCompatBase() {
        super();
    }
}

