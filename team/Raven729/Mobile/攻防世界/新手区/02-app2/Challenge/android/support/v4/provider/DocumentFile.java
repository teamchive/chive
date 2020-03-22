package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build$VERSION;
import java.io.File;

public abstract class DocumentFile {
    static final String TAG = "DocumentFile";
    private final DocumentFile mParent;

    DocumentFile(DocumentFile arg1) {
        super();
        this.mParent = arg1;
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String arg1);

    public abstract DocumentFile createFile(String arg1, String arg2);

    public abstract boolean delete();

    public abstract boolean exists();

    public DocumentFile findFile(String arg6) {
        DocumentFile v0;
        DocumentFile[] v2 = this.listFiles();
        int v3 = v2.length;
        int v1 = 0;
        while(true) {
            if(v1 < v3) {
                v0 = v2[v1];
                if(!arg6.equals(v0.getName())) {
                    ++v1;
                    continue;
                }
            }
            else {
                return null;
            }

            return v0;
        }

        return null;
    }

    public static DocumentFile fromFile(File arg2) {
        return new RawDocumentFile(null, arg2);
    }

    public static DocumentFile fromSingleUri(Context arg3, Uri arg4) {
        DocumentFile v0_1;
        DocumentFile v1 = null;
        if(Build$VERSION.SDK_INT >= 19) {
            SingleDocumentFile v0 = new SingleDocumentFile(v1, arg3, arg4);
        }
        else {
            v0_1 = v1;
        }

        return v0_1;
    }

    public static DocumentFile fromTreeUri(Context arg3, Uri arg4) {
        TreeDocumentFile v0;
        DocumentFile v1 = null;
        if(Build$VERSION.SDK_INT >= 21) {
            v0 = new TreeDocumentFile(v1, arg3, DocumentsContractApi21.prepareTreeUri(arg4));
        }
        else {
            DocumentFile v0_1 = v1;
        }

        return ((DocumentFile)v0);
    }

    public abstract String getName();

    public DocumentFile getParentFile() {
        return this.mParent;
    }

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public static boolean isDocumentUri(Context arg2, Uri arg3) {
        boolean v0 = Build$VERSION.SDK_INT >= 19 ? DocumentsContractApi19.isDocumentUri(arg2, arg3) : false;
        return v0;
    }

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String arg1);
}

