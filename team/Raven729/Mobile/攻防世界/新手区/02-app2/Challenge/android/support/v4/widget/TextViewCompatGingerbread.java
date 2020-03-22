package android.support.v4.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

@TargetApi(value=9) @RequiresApi(value=9) class TextViewCompatGingerbread {
    private static final int LINES = 1;
    private static final String LOG_TAG = "TextViewCompatGingerbread";
    private static Field sMaxModeField;
    private static boolean sMaxModeFieldFetched;
    private static Field sMaximumField;
    private static boolean sMaximumFieldFetched;
    private static Field sMinModeField;
    private static boolean sMinModeFieldFetched;
    private static Field sMinimumField;
    private static boolean sMinimumFieldFetched;

    TextViewCompatGingerbread() {
        super();
    }

    static Drawable[] getCompoundDrawablesRelative(@NonNull TextView arg1) {
        return arg1.getCompoundDrawables();
    }

    static int getMaxLines(TextView arg2) {
        int v0;
        if(!TextViewCompatGingerbread.sMaxModeFieldFetched) {
            TextViewCompatGingerbread.sMaxModeField = TextViewCompatGingerbread.retrieveField("mMaxMode");
            TextViewCompatGingerbread.sMaxModeFieldFetched = true;
        }

        if(TextViewCompatGingerbread.sMaxModeField == null || TextViewCompatGingerbread.retrieveIntFromField(TextViewCompatGingerbread.sMaxModeField, arg2) != 1) {
        label_23:
            v0 = -1;
        }
        else {
            if(!TextViewCompatGingerbread.sMaximumFieldFetched) {
                TextViewCompatGingerbread.sMaximumField = TextViewCompatGingerbread.retrieveField("mMaximum");
                TextViewCompatGingerbread.sMaximumFieldFetched = true;
            }

            if(TextViewCompatGingerbread.sMaximumField == null) {
                goto label_23;
            }

            v0 = TextViewCompatGingerbread.retrieveIntFromField(TextViewCompatGingerbread.sMaximumField, arg2);
        }

        return v0;
    }

    static int getMinLines(TextView arg2) {
        int v0;
        if(!TextViewCompatGingerbread.sMinModeFieldFetched) {
            TextViewCompatGingerbread.sMinModeField = TextViewCompatGingerbread.retrieveField("mMinMode");
            TextViewCompatGingerbread.sMinModeFieldFetched = true;
        }

        if(TextViewCompatGingerbread.sMinModeField == null || TextViewCompatGingerbread.retrieveIntFromField(TextViewCompatGingerbread.sMinModeField, arg2) != 1) {
        label_23:
            v0 = -1;
        }
        else {
            if(!TextViewCompatGingerbread.sMinimumFieldFetched) {
                TextViewCompatGingerbread.sMinimumField = TextViewCompatGingerbread.retrieveField("mMinimum");
                TextViewCompatGingerbread.sMinimumFieldFetched = true;
            }

            if(TextViewCompatGingerbread.sMinimumField == null) {
                goto label_23;
            }

            v0 = TextViewCompatGingerbread.retrieveIntFromField(TextViewCompatGingerbread.sMinimumField, arg2);
        }

        return v0;
    }

    private static Field retrieveField(String arg4) {
        Field v0;
        try {
            v0 = TextView.class.getDeclaredField(arg4);
            v0.setAccessible(true);
        }
        catch(NoSuchFieldException v1) {
            Log.e("TextViewCompatGingerbread", "Could not retrieve " + arg4 + " field.");
        }

        return v0;
    }

    private static int retrieveIntFromField(Field arg3, TextView arg4) {
        int v0_1;
        try {
            v0_1 = arg3.getInt(arg4);
        }
        catch(IllegalAccessException v0) {
            Log.d("TextViewCompatGingerbread", "Could not retrieve value of " + arg3.getName() + " field.");
            v0_1 = -1;
        }

        return v0_1;
    }

    static void setTextAppearance(TextView arg1, int arg2) {
        arg1.setTextAppearance(arg1.getContext(), arg2);
    }
}

