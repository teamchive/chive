package android.support.v4.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class RawDocumentFile extends DocumentFile {
    private File mFile;

    RawDocumentFile(DocumentFile arg1, File arg2) {
        super(arg1);
        this.mFile = arg2;
    }

    public boolean canRead() {
        return this.mFile.canRead();
    }

    public boolean canWrite() {
        return this.mFile.canWrite();
    }

    public DocumentFile createDirectory(String arg3) {
        RawDocumentFile v0_1;
        File v1 = new File(this.mFile, arg3);
        if((v1.isDirectory()) || (v1.mkdir())) {
            v0_1 = new RawDocumentFile(((DocumentFile)this), v1);
        }
        else {
            DocumentFile v0 = null;
        }

        return ((DocumentFile)v0_1);
    }

    public DocumentFile createFile(String arg5, String arg6) {
        RawDocumentFile v0_2;
        String v0 = MimeTypeMap.getSingleton().getExtensionFromMimeType(arg5);
        if(v0 != null) {
            arg6 = arg6 + "." + v0;
        }

        File v1 = new File(this.mFile, arg6);
        try {
            v1.createNewFile();
            v0_2 = new RawDocumentFile(((DocumentFile)this), v1);
        }
        catch(IOException v0_1) {
            Log.w("DocumentFile", "Failed to createFile: " + v0_1);
            DocumentFile v0_3 = null;
        }

        return ((DocumentFile)v0_2);
    }

    public boolean delete() {
        RawDocumentFile.deleteContents(this.mFile);
        return this.mFile.delete();
    }

    private static boolean deleteContents(File arg8) {
        File[] v3 = arg8.listFiles();
        int v0 = 1;
        if(v3 != null) {
            int v4 = v3.length;
            int v2;
            for(v2 = 0; v2 < v4; ++v2) {
                File v5 = v3[v2];
                if(v5.isDirectory()) {
                    v0 &= RawDocumentFile.deleteContents(v5);
                }

                if(!v5.delete()) {
                    Log.w("DocumentFile", "Failed to delete " + v5);
                    v0 = 0;
                }
            }
        }

        return ((boolean)v0);
    }

    public boolean exists() {
        return this.mFile.exists();
    }

    public String getName() {
        return this.mFile.getName();
    }

    public String getType() {
        String v0 = this.mFile.isDirectory() ? null : RawDocumentFile.getTypeForName(this.mFile.getName());
        return v0;
    }

    private static String getTypeForName(String arg2) {
        String v0_1;
        int v0 = arg2.lastIndexOf(46);
        if(v0 >= 0) {
            v0_1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(arg2.substring(v0 + 1).toLowerCase());
            if(v0_1 == null) {
                goto label_10;
            }
        }
        else {
        label_10:
            v0_1 = "application/octet-stream";
        }

        return v0_1;
    }

    public Uri getUri() {
        return Uri.fromFile(this.mFile);
    }

    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    public boolean isFile() {
        return this.mFile.isFile();
    }

    public boolean isVirtual() {
        return 0;
    }

    public long lastModified() {
        return this.mFile.lastModified();
    }

    public long length() {
        return this.mFile.length();
    }

    public DocumentFile[] listFiles() {
        ArrayList v1 = new ArrayList();
        File[] v2 = this.mFile.listFiles();
        if(v2 != null) {
            int v3 = v2.length;
            int v0;
            for(v0 = 0; v0 < v3; ++v0) {
                v1.add(new RawDocumentFile(((DocumentFile)this), v2[v0]));
            }
        }

        return v1.toArray(new DocumentFile[v1.size()]);
    }

    public boolean renameTo(String arg3) {
        boolean v0_1;
        File v0 = new File(this.mFile.getParentFile(), arg3);
        if(this.mFile.renameTo(v0)) {
            this.mFile = v0;
            v0_1 = true;
        }
        else {
            v0_1 = false;
        }

        return v0_1;
    }
}

