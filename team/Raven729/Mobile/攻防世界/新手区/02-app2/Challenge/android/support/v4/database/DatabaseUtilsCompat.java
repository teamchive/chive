package android.support.v4.database;

import android.text.TextUtils;

public final class DatabaseUtilsCompat {
    private DatabaseUtilsCompat() {
        super();
    }

    public static String[] appendSelectionArgs(String[] arg4, String[] arg5) {
        if(arg4 != null && arg4.length != 0) {
            String[] v0 = new String[arg4.length + arg5.length];
            System.arraycopy(arg4, 0, v0, 0, arg4.length);
            System.arraycopy(arg5, 0, v0, arg4.length, arg5.length);
            arg5 = v0;
        }

        return arg5;
    }

    public static String concatenateWhere(String arg2, String arg3) {
        if(!TextUtils.isEmpty(((CharSequence)arg2))) {
            arg3 = TextUtils.isEmpty(((CharSequence)arg3)) ? arg2 : "(" + arg2 + ") AND (" + arg3 + ")";
        }

        return arg3;
    }
}

