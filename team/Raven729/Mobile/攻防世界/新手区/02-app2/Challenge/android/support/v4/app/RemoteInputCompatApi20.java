package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.RemoteInput$Builder;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(value=20) @RequiresApi(value=20) class RemoteInputCompatApi20 {
    RemoteInputCompatApi20() {
        super();
    }

    static void addResultsToIntent(RemoteInput[] arg1, Intent arg2, Bundle arg3) {
        android.app.RemoteInput.addResultsToIntent(RemoteInputCompatApi20.fromCompat(arg1), arg2, arg3);
    }

    static android.app.RemoteInput[] fromCompat(RemoteInput[] arg5) {
        android.app.RemoteInput[] v0;
        if(arg5 == null) {
            v0 = null;
        }
        else {
            android.app.RemoteInput[] v1 = new android.app.RemoteInput[arg5.length];
            int v0_1;
            for(v0_1 = 0; v0_1 < arg5.length; ++v0_1) {
                v1[v0_1] = new RemoteInput$Builder(arg5[v0_1].getResultKey()).setLabel(arg5[v0_1].getLabel()).setChoices(arg5[v0_1].getChoices()).setAllowFreeFormInput(arg5[v0_1].getAllowFreeFormInput()).addExtras(arg5[v0_1].getExtras()).build();
            }

            v0 = v1;
        }

        return v0;
    }

    static Bundle getResultsFromIntent(Intent arg1) {
        return android.app.RemoteInput.getResultsFromIntent(arg1);
    }

    static RemoteInput[] toCompat(android.app.RemoteInput[] arg8, Factory arg9) {
        RemoteInput[] v0;
        if(arg8 == null) {
            v0 = null;
        }
        else {
            RemoteInput[] v7 = arg9.newArray(arg8.length);
            int v6;
            for(v6 = 0; v6 < arg8.length; ++v6) {
                v7[v6] = arg9.build(arg8[v6].getResultKey(), arg8[v6].getLabel(), arg8[v6].getChoices(), arg8[v6].getAllowFreeFormInput(), arg8[v6].getExtras());
            }

            v0 = v7;
        }

        return v0;
    }
}

