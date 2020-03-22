package android.support.v4.provider;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.util.ArrayList;

@TargetApi(value=21) @RequiresApi(value=21) class DocumentsContractApi21 {
    private static final String TAG = "DocumentFile";

    DocumentsContractApi21() {
        super();
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

    public static Uri createDirectory(Context arg1, Uri arg2, String arg3) {
        return DocumentsContractApi21.createFile(arg1, arg2, "vnd.android.document/directory", arg3);
    }

    public static Uri createFile(Context arg1, Uri arg2, String arg3, String arg4) {
        return DocumentsContract.createDocument(arg1.getContentResolver(), arg2, arg3, arg4);
    }

    public static Uri[] listFiles(Context arg8, Uri arg9) {
        AutoCloseable v1_2;
        Cursor v1_1;
        AutoCloseable v6 = null;
        ContentResolver v0 = arg8.getContentResolver();
        Uri v1 = DocumentsContract.buildChildDocumentsUriUsingTree(arg9, DocumentsContract.getDocumentId(arg9));
        ArrayList v7 = new ArrayList();
        try {
            v1_1 = v0.query(v1, new String[]{"document_id"}, null, null, null);
        }
        catch(Throwable v0_1) {
            v1_2 = v6;
            goto label_40;
        }
        catch(Exception v0_2) {
            v1_2 = v6;
            goto label_23;
        }

        try {
            while(true) {
                if(!v1_1.moveToNext()) {
                    goto label_36;
                }

                v7.add(DocumentsContract.buildDocumentUriUsingTree(arg9, v1_1.getString(0)));
            }
        }
        catch(Throwable v0_1) {
        label_43:
        }
        catch(Exception v0_2) {
            goto label_23;
        label_36:
            DocumentsContractApi21.closeQuietly(((AutoCloseable)v1_1));
            goto label_32;
            try {
            label_23:
                Log.w("DocumentFile", "Failed query: " + v0_2);
            }
            catch(Throwable v0_1) {
                goto label_43;
            }

            DocumentsContractApi21.closeQuietly(((AutoCloseable)v1_1));
        label_32:
            return v7.toArray(new Uri[v7.size()]);
        }

    label_40:
        DocumentsContractApi21.closeQuietly(((AutoCloseable)v1_1));
        throw v0_1;
    }

    public static Uri prepareTreeUri(Uri arg1) {
        return DocumentsContract.buildDocumentUriUsingTree(arg1, DocumentsContract.getTreeDocumentId(arg1));
    }

    public static Uri renameTo(Context arg1, Uri arg2, String arg3) {
        return DocumentsContract.renameDocument(arg1.getContentResolver(), arg2, arg3);
    }
}

