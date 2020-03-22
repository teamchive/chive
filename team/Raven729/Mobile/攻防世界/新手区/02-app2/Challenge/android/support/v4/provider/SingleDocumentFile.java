package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;

class SingleDocumentFile extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    SingleDocumentFile(DocumentFile arg1, Context arg2, Uri arg3) {
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

    public DocumentFile createDirectory(String arg2) {
        throw new UnsupportedOperationException();
    }

    public DocumentFile createFile(String arg2, String arg3) {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    public boolean renameTo(String arg2) {
        throw new UnsupportedOperationException();
    }
}

