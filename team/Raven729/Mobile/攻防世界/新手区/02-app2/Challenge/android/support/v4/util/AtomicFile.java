package android.support.v4.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile {
    private final File mBackupName;
    private final File mBaseName;

    public AtomicFile(File arg4) {
        super();
        this.mBaseName = arg4;
        this.mBackupName = new File(arg4.getPath() + ".bak");
    }

    public void delete() {
        this.mBaseName.delete();
        this.mBackupName.delete();
    }

    public void failWrite(FileOutputStream arg4) {
        if(arg4 != null) {
            AtomicFile.sync(arg4);
            try {
                arg4.close();
                this.mBaseName.delete();
                this.mBackupName.renameTo(this.mBaseName);
            }
            catch(IOException v0) {
                Log.w("AtomicFile", "failWrite: Got exception:", ((Throwable)v0));
            }
        }
    }

    public void finishWrite(FileOutputStream arg4) {
        if(arg4 != null) {
            AtomicFile.sync(arg4);
            try {
                arg4.close();
                this.mBackupName.delete();
            }
            catch(IOException v0) {
                Log.w("AtomicFile", "finishWrite: Got exception:", ((Throwable)v0));
            }
        }
    }

    public File getBaseFile() {
        return this.mBaseName;
    }

    public FileInputStream openRead() {
        if(this.mBackupName.exists()) {
            this.mBaseName.delete();
            this.mBackupName.renameTo(this.mBaseName);
        }

        return new FileInputStream(this.mBaseName);
    }

    public byte[] readFully() {
        byte[] v0_2;
        int v2;
        byte[] v1;
        int v0 = 0;
        FileInputStream v3 = this.openRead();
        try {
            v1 = new byte[v3.available()];
            while(true) {
            label_4:
                v2 = v3.read(v1, v0, v1.length - v0);
                if(v2 > 0) {
                    break;
                }

                goto label_8;
            }
        }
        catch(Throwable v0_1) {
            goto label_24;
        }

        v2 += v0;
        try {
            v0 = v3.available();
            if(v0 > v1.length - v2) {
                v0_2 = new byte[v0 + v2];
                System.arraycopy(v1, 0, v0_2, 0, v2);
            }
            else {
                goto label_26;
            }

            goto label_20;
        }
        catch(Throwable v0_1) {
            goto label_24;
        }

    label_26:
        v0_2 = v1;
    label_20:
        v1 = v0_2;
        v0 = v2;
        goto label_4;
    label_8:
        v3.close();
        return v1;
    label_24:
        v3.close();
        throw v0_1;
    }

    public FileOutputStream startWrite() {
        FileOutputStream v0_1;
        if(this.mBaseName.exists()) {
            if(this.mBackupName.exists()) {
                this.mBaseName.delete();
            }
            else if(!this.mBaseName.renameTo(this.mBackupName)) {
                Log.w("AtomicFile", "Couldn\'t rename file " + this.mBaseName + " to backup file " + this.mBackupName);
            }
        }

        try {
            v0_1 = new FileOutputStream(this.mBaseName);
        }
        catch(FileNotFoundException v0) {
            if(!this.mBaseName.getParentFile().mkdirs()) {
                throw new IOException("Couldn\'t create directory " + this.mBaseName);
            }

            try {
                v0_1 = new FileOutputStream(this.mBaseName);
            }
            catch(FileNotFoundException v0) {
                throw new IOException("Couldn\'t create " + this.mBaseName);
            }
        }

        return v0_1;
    }

    static boolean sync(FileOutputStream arg1) {
        if(arg1 != null) {
            try {
                arg1.getFD().sync();
            }
            catch(IOException v0) {
                boolean v0_1 = false;
                return v0_1;
            }
        }

        return true;
    }
}

