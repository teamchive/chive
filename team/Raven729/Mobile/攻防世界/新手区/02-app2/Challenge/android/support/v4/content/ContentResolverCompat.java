package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build$VERSION;
import android.support.v4.os.CancellationSignal;
import android.support.v4.os.OperationCanceledException;

public final class ContentResolverCompat {
    interface ContentResolverCompatImpl {
        Cursor query(ContentResolver arg1, Uri arg2, String[] arg3, String arg4, String[] arg5, String arg6, CancellationSignal arg7);
    }

    class ContentResolverCompatImplBase implements ContentResolverCompatImpl {
        ContentResolverCompatImplBase() {
            super();
        }

        public Cursor query(ContentResolver arg2, Uri arg3, String[] arg4, String arg5, String[] arg6, String arg7, CancellationSignal arg8) {
            if(arg8 != null) {
                arg8.throwIfCanceled();
            }

            return arg2.query(arg3, arg4, arg5, arg6, arg7);
        }
    }

    class ContentResolverCompatImplJB extends ContentResolverCompatImplBase {
        ContentResolverCompatImplJB() {
            super();
        }

        public Cursor query(ContentResolver arg8, Uri arg9, String[] arg10, String arg11, String[] arg12, String arg13, CancellationSignal arg14) {
            Object v6;
            if(arg14 != null) {
                try {
                    v6 = arg14.getCancellationSignalObject();
                }
                catch(Exception v0) {
                    goto label_14;
                }
            }
            else {
                v6 = null;
            }

            try {
                return ContentResolverCompatJellybean.query(arg8, arg9, arg10, arg11, arg12, arg13, v6);
            }
            catch(Exception v0) {
            label_14:
                if(ContentResolverCompatJellybean.isFrameworkOperationCanceledException(v0)) {
                    throw new OperationCanceledException();
                }

                throw v0;
            }
        }
    }

    private static final ContentResolverCompatImpl IMPL;

    static {
        ContentResolverCompat.IMPL = Build$VERSION.SDK_INT >= 16 ? new ContentResolverCompatImplJB() : new ContentResolverCompatImplBase();
    }

    private ContentResolverCompat() {
        super();
    }

    public static Cursor query(ContentResolver arg8, Uri arg9, String[] arg10, String arg11, String[] arg12, String arg13, CancellationSignal arg14) {
        return ContentResolverCompat.IMPL.query(arg8, arg9, arg10, arg11, arg12, arg13, arg14);
    }
}

