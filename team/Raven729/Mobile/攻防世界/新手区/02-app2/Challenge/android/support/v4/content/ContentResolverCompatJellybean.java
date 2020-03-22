package android.support.v4.content;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.OperationCanceledException;
import android.support.annotation.RequiresApi;

@TargetApi(value=16) @RequiresApi(value=16) class ContentResolverCompatJellybean {
    ContentResolverCompatJellybean() {
        super();
    }

    static boolean isFrameworkOperationCanceledException(Exception arg1) {
        return arg1 instanceof OperationCanceledException;
    }

    public static Cursor query(ContentResolver arg7, Uri arg8, String[] arg9, String arg10, String[] arg11, String arg12, Object arg13) {
        return arg7.query(arg8, arg9, arg10, arg11, arg12, arg13);
    }
}

