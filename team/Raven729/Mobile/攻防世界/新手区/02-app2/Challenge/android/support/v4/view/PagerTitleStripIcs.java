package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

@TargetApi(value=14) @RequiresApi(value=14) class PagerTitleStripIcs {
    class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private static final String TAG = "SingleLineAllCapsTransform";
        private Locale mLocale;

        public SingleLineAllCapsTransform(Context arg2) {
            super();
            this.mLocale = arg2.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence arg3, View arg4) {
            CharSequence v0 = super.getTransformation(arg3, arg4);
            if(v0 != null) {
                String v0_1 = v0.toString().toUpperCase(this.mLocale);
            }
            else {
                v0 = null;
            }

            return v0;
        }
    }

    PagerTitleStripIcs() {
        super();
    }

    public static void setSingleLineAllCaps(TextView arg2) {
        arg2.setTransformationMethod(new SingleLineAllCapsTransform(arg2.getContext()));
    }
}

