package android.support.v4.provider;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;

@TargetApi(value=19) @RequiresApi(value=19) class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 0x200;
    private static final String TAG = "DocumentFile";

    DocumentsContractApi19() {
        super();
    }

    public static boolean canRead(Context arg3, Uri arg4) {
        boolean v0 = false;
        if(arg3.checkCallingOrSelfUriPermission(arg4, 1) == 0 && !TextUtils.isEmpty(DocumentsContractApi19.getRawType(arg3, arg4))) {
            v0 = true;
        }

        return v0;
    }

    public static boolean canWrite(Context arg5, Uri arg6) {
        boolean v0 = false;
        if(arg5.checkCallingOrSelfUriPermission(arg6, 2) == 0) {
            String v2 = DocumentsContractApi19.getRawType(arg5, arg6);
            int v3 = DocumentsContractApi19.queryForInt(arg5, arg6, "flags", 0);
            if(!TextUtils.isEmpty(((CharSequence)v2))) {
                if((v3 & 4) != 0) {
                    v0 = true;
                }
                else {
                    if(("vnd.android.document/directory".equals(v2)) && (v3 & 8) != 0) {
                        return true;
                    }

                    if(TextUtils.isEmpty(((CharSequence)v2))) {
                        return v0;
                    }

                    if((v3 & 2) == 0) {
                        return v0;
                    }

                    v0 = true;
                }
            }
        }

        return v0;
    }

    private static void closeQuietly(AutoCloseable arg1) {
        if(arg1 != null) {
            try {
                arg1.close();
            }
            catch(Exception v0) {
            }
            catch(RuntimeException v0_1) {
                throw v0_1;
            }
        }
    }

    public static boolean delete(Context arg1, Uri arg2) {
        return DocumentsContract.deleteDocument(arg1.getContentResolver(), arg2);
    }

    public static boolean exists(Context arg9, Uri arg10) {
        boolean v0_3;
        AutoCloseable v1_1;
        Cursor v1;
        AutoCloseable v8 = null;
        ContentResolver v0 = arg9.getContentResolver();
        try {
            v1 = v0.query(arg10, new String[]{"document_id"}, null, null, null);
        }
        catch(Throwable v0_1) {
            v1_1 = v8;
            goto label_36;
        }
        catch(Exception v0_2) {
            v1_1 = v8;
            goto label_23;
        }

        try {
            if(v1.getCount() <= 0) {
                goto label_19;
            }

            goto label_16;
        }
        catch(Throwable v0_1) {
        label_39:
        }
        catch(Exception v0_2) {
            try {
            label_23:
                Log.w("DocumentFile", "Failed query: " + v0_2);
            }
            catch(Throwable v0_1) {
                goto label_39;
            }

            DocumentsContractApi19.closeQuietly(v1_1);
            v0_3 = false;
            return v0_3;
        }

    label_36:
        DocumentsContractApi19.closeQuietly(v1_1);
        throw v0_1;
    label_16:
        v0_3 = true;
        goto label_17;
    label_19:
        v0_3 = false;
    label_17:
        DocumentsContractApi19.closeQuietly(((AutoCloseable)v1));
        return v0_3;
    }

    public static long getFlags(Context arg4, Uri arg5) {
        return DocumentsContractApi19.queryForLong(arg4, arg5, "flags", 0);
    }

    public static String getName(Context arg2, Uri arg3) {
        return DocumentsContractApi19.queryForString(arg2, arg3, "_display_name", null);
    }

    private static String getRawType(Context arg2, Uri arg3) {
        return DocumentsContractApi19.queryForString(arg2, arg3, "mime_type", null);
    }

    public static String getType(Context arg2, Uri arg3) {
        String v0 = DocumentsContractApi19.getRawType(arg2, arg3);
        if("vnd.android.document/directory".equals(v0)) {
            v0 = null;
        }

        return v0;
    }

    public static boolean isDirectory(Context arg2, Uri arg3) {
        return "vnd.android.document/directory".equals(DocumentsContractApi19.getRawType(arg2, arg3));
    }

    public static boolean isDocumentUri(Context arg1, Uri arg2) {
        return DocumentsContract.isDocumentUri(arg1, arg2);
    }

    public static boolean isFile(Context arg2, Uri arg3) {
        String v0 = DocumentsContractApi19.getRawType(arg2, arg3);
        boolean v0_1 = ("vnd.android.document/directory".equals(v0)) || (TextUtils.isEmpty(((CharSequence)v0))) ? false : true;
        return v0_1;
    }

    public static boolean isVirtual(Context arg6, Uri arg7) {
        boolean v0 = false;
        if((DocumentsContractApi19.isDocumentUri(arg6, arg7)) && (DocumentsContractApi19.getFlags(arg6, arg7) & 0x200) != 0) {
            v0 = true;
        }

        return v0;
    }

    public static long lastModified(Context arg4, Uri arg5) {
        return DocumentsContractApi19.queryForLong(arg4, arg5, "last_modified", 0);
    }

    public static long length(Context arg4, Uri arg5) {
        return DocumentsContractApi19.queryForLong(arg4, arg5, "_size", 0);
    }

    private static int queryForInt(Context arg2, Uri arg3, String arg4, int arg5) {
        return ((int)DocumentsContractApi19.queryForLong(arg2, arg3, arg4, ((long)arg5)));
    }

    private static long queryForLong(Context arg7, Uri arg8, String arg9, long arg10) {
        AutoCloseable v1_1;
        Cursor v1;
        AutoCloseable v6 = null;
        ContentResolver v0 = arg7.getContentResolver();
        try {
            v1 = v0.query(arg8, new String[]{arg9}, null, null, null);
        }
        catch(Throwable v0_1) {
            v1_1 = v6;
            goto label_36;
        }
        catch(Exception v0_2) {
            v1_1 = v6;
            goto label_24;
        }

        try {
            if((v1.moveToFirst()) && !v1.isNull(0)) {
                arg10 = v1.getLong(0);
                goto label_18;
            }

            goto label_20;
        }
        catch(Throwable v0_1) {
        label_39:
        }
        catch(Exception v0_2) {
            try {
            label_24:
                Log.w("DocumentFile", "Failed query: " + v0_2);
            }
            catch(Throwable v0_1) {
                goto label_39;
            }

            DocumentsContractApi19.closeQuietly(((AutoCloseable)v1));
            return arg10;
        }

    label_36:
        DocumentsContractApi19.closeQuietly(((AutoCloseable)v1));
        throw v0_1;
    label_18:
        DocumentsContractApi19.closeQuietly(((AutoCloseable)v1));
        return arg10;
    label_20:
        DocumentsContractApi19.closeQuietly(((AutoCloseable)v1));
        return arg10;
    }

    private static String queryForString(Context arg7, Uri arg8, String arg9, String arg10) {
        AutoCloseable v1_1;
        Cursor v1;
        AutoCloseable v6 = null;
        ContentResolver v0 = arg7.getContentResolver();
        try {
            v1 = v0.query(arg8, new String[]{arg9}, null, null, null);
        }
        catch(Throwable v0_1) {
            v1_1 = v6;
            goto label_36;
        }
        catch(Exception v0_2) {
            v1_1 = v6;
            goto label_24;
        }

        try {
            if((v1.moveToFirst()) && !v1.isNull(0)) {
                arg10 = v1.getString(0);
                goto label_18;
            }

            goto label_20;
        }
        catch(Throwable v0_1) {
        label_39:
        }
        catch(Exception v0_2) {
            try {
            label_24:
                Log.w("DocumentFile", "Failed query: " + v0_2);
            }
            catch(Throwable v0_1) {
                goto label_39;
            }

            DocumentsContractApi19.closeQuietly(((AutoCloseable)v1));
            return arg10;
        }

    label_36:
        DocumentsContractApi19.closeQuietly(((AutoCloseable)v1));
        throw v0_1;
    label_18:
        DocumentsContractApi19.closeQuietly(((AutoCloseable)v1));
        return arg10;
    label_20:
        DocumentsContractApi19.closeQuietly(((AutoCloseable)v1));
        return arg10;
    }
}

