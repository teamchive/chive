package android.support.v4.app;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;

@TargetApi(value=16) @RequiresApi(value=16) class RemoteInputCompatJellybean {
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    private static final String KEY_CHOICES = "choices";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_LABEL = "label";
    private static final String KEY_RESULT_KEY = "resultKey";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";

    RemoteInputCompatJellybean() {
        super();
    }

    static void addResultsToIntent(RemoteInput[] arg6, Intent arg7, Bundle arg8) {
        Bundle v2 = new Bundle();
        int v3 = arg6.length;
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            RemoteInput v4 = arg6[v1];
            Object v0 = arg8.get(v4.getResultKey());
            if((v0 instanceof CharSequence)) {
                v2.putCharSequence(v4.getResultKey(), ((CharSequence)v0));
            }
        }

        Intent v0_1 = new Intent();
        v0_1.putExtra("android.remoteinput.resultsData", v2);
        arg7.setClipData(ClipData.newIntent("android.remoteinput.results", v0_1));
    }

    static RemoteInput fromBundle(Bundle arg6, Factory arg7) {
        return arg7.build(arg6.getString("resultKey"), arg6.getCharSequence("label"), arg6.getCharSequenceArray("choices"), arg6.getBoolean("allowFreeFormInput"), arg6.getBundle("extras"));
    }

    static RemoteInput[] fromBundleArray(Bundle[] arg3, Factory arg4) {
        RemoteInput[] v0;
        if(arg3 == null) {
            v0 = null;
        }
        else {
            RemoteInput[] v1 = arg4.newArray(arg3.length);
            int v0_1;
            for(v0_1 = 0; v0_1 < arg3.length; ++v0_1) {
                v1[v0_1] = RemoteInputCompatJellybean.fromBundle(arg3[v0_1], arg4);
            }

            v0 = v1;
        }

        return v0;
    }

    static Bundle getResultsFromIntent(Intent arg4) {
        Bundle v0 = null;
        ClipData v1 = arg4.getClipData();
        if(v1 != null) {
            ClipDescription v2 = v1.getDescription();
            if((v2.hasMimeType("text/vnd.android.intent")) && (v2.getLabel().equals("android.remoteinput.results"))) {
                Parcelable v0_1 = v1.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData");
            }
        }

        return v0;
    }

    static Bundle toBundle(RemoteInput arg3) {
        Bundle v0 = new Bundle();
        v0.putString("resultKey", arg3.getResultKey());
        v0.putCharSequence("label", arg3.getLabel());
        v0.putCharSequenceArray("choices", arg3.getChoices());
        v0.putBoolean("allowFreeFormInput", arg3.getAllowFreeFormInput());
        v0.putBundle("extras", arg3.getExtras());
        return v0;
    }

    static Bundle[] toBundleArray(RemoteInput[] arg3) {
        Bundle[] v0;
        if(arg3 == null) {
            v0 = null;
        }
        else {
            Bundle[] v1 = new Bundle[arg3.length];
            int v0_1;
            for(v0_1 = 0; v0_1 < arg3.length; ++v0_1) {
                v1[v0_1] = RemoteInputCompatJellybean.toBundle(arg3[v0_1]);
            }

            v0 = v1;
        }

        return v0;
    }
}

