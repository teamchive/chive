package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;

class TreeDocumentFile extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    TreeDocumentFile(DocumentFile arg1, Context arg2, Uri arg3) {
        super(arg1);
        this.mContext = arg2;
        this.mUri = arg3;
    }

    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.mContext, this.mUri);
    }

    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
    }

    public DocumentFile createDirectory(String arg4) {
        TreeDocumentFile v0;
        Uri v1 = DocumentsContractApi21.createDirectory(this.mContext, this.mUri, arg4);
        if(v1 != null) {
            v0 = new TreeDocumentFile(((DocumentFile)this), this.mContext, v1);
        }
        else {
            DocumentFile v0_1 = null;
        }

        return ((DocumentFile)v0);
    }

    public DocumentFile createFile(String arg4, String arg5) {
        DocumentFile v0_1;
        Uri v1 = DocumentsContractApi21.createFile(this.mContext, this.mUri, arg4, arg5);
        if(v1 != null) {
            TreeDocumentFile v0 = new TreeDocumentFile(((DocumentFile)this), this.mContext, v1);
        }
        else {
            v0_1 = null;
        }

        return v0_1;
    }

    public boolean delete() {
        return DocumentsContractApi19.delete(this.mContext, this.mUri);
    }

    public boolean exists() {
        return DocumentsContractApi19.exists(this.mContext, this.mUri);
    }

    public String getName() {
        return DocumentsContractApi19.getName(this.mContext, this.mUri);
    }

    public String getType() {
        return DocumentsContractApi19.getType(this.mContext, this.mUri);
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
    }

    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.mContext, this.mUri);
    }

    public boolean isVirtual() {
        return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
    }

    public long lastModified() {
        return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
    }

    public long length() {
        return DocumentsContractApi19.length(this.mContext, this.mUri);
    }

    public DocumentFile[] listFiles() {
        Uri[] v1 = DocumentsContractApi21.listFiles(this.mContext, this.mUri);
        DocumentFile[] v2 = new DocumentFile[v1.length];
        int v0;
        for(v0 = 0; v0 < v1.length; ++v0) {
            v2[v0] = new TreeDocumentFile(((DocumentFile)this), this.mContext, v1[v0]);
        }

        return v2;
    }

    public boolean renameTo(String arg3) {
        boolean v0_1;
        Uri v0 = DocumentsContractApi21.renameTo(this.mContext, this.mUri, arg3);
        if(v0 != null) {
            this.mUri = v0;
            v0_1 = true;
        }
        else {
            v0_1 = false;
        }

        return v0_1;
    }
}

