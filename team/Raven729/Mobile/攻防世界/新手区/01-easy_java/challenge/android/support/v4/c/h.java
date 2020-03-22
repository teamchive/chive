package android.support.v4.c;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel$MapMode;
import java.nio.channels.FileChannel;

public class h {
    public static File a(Context arg5) {
        String v2 = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        int v1;
        for(v1 = 0; v1 < 100; ++v1) {
            File v0 = new File(arg5.getCacheDir(), v2 + v1);
            try {
                if(!v0.createNewFile()) {
                    goto label_29;
                }

                return v0;
            }
            catch(IOException v0_1) {
            }

        label_29:
        }

        return null;
    }

    public static boolean a(File arg2, Resources arg3, int arg4) {
        boolean v0_1;
        InputStream v1;
        try {
            v1 = arg3.openRawResource(arg4);
            v0_1 = h.a(arg2, v1);
        }
        catch(Throwable v0) {
            h.a(((Closeable)v1));
            throw v0;
        }

        h.a(((Closeable)v1));
        return v0_1;
    }

    public static void a(Closeable arg1) {
        if(arg1 != null) {
            try {
                arg1.close();
            }
            catch(IOException v0) {
            }
        }
    }

    public static boolean a(File arg6, InputStream arg7) {
        Closeable v2_1;
        int v1_1;
        FileOutputStream v2;
        boolean v0 = false;
        Closeable v3 = null;
        try {
            v2 = new FileOutputStream(arg6, false);
            v1_1 = 0x400;
        }
        catch(Throwable v0_1) {
            v2_1 = v3;
            goto label_30;
        }
        catch(IOException v1) {
            v2_1 = v3;
            goto label_14;
        }

        try {
            byte[] v1_2 = new byte[v1_1];
            while(true) {
                int v3_1 = arg7.read(v1_2);
                if(v3_1 == -1) {
                    break;
                }

                v2.write(v1_2, 0, v3_1);
            }
        }
        catch(Throwable v0_1) {
            goto label_30;
        }
        catch(IOException v1) {
            goto label_14;
        }

        v0 = true;
        h.a(((Closeable)v2));
        return v0;
        try {
        label_14:
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + v1.getMessage());
        }
        catch(Throwable v0_1) {
            goto label_30;
        }

        h.a(v2_1);
        return v0;
    label_30:
        h.a(v2_1);
        throw v0_1;
    }

    public static ByteBuffer a(Context arg12, CancellationSignal arg13, Uri arg14) {
        ByteBuffer v0_5;
        Throwable v11;
        Throwable v10;
        FileInputStream v9;
        Throwable v8;
        ParcelFileDescriptor v7;
        ByteBuffer v6 = null;
        ContentResolver v0 = arg12.getContentResolver();
        try {
            v7 = v0.openFileDescriptor(arg14, "r", arg13);
            v8 = null;
        }
        catch(IOException v0_1) {
            goto label_35;
        }

        try {
            v9 = new FileInputStream(v7.getFileDescriptor());
            v10 = null;
        }
        catch(Throwable v0_2) {
            goto label_40;
        }
        catch(Throwable v0_2) {
            goto label_25;
        }

        try {
            FileChannel v0_3 = v9.getChannel();
            MappedByteBuffer v0_4 = v0_3.map(FileChannel$MapMode.READ_ONLY, 0, v0_3.size());
            if(v9 == null) {
                goto label_17;
            }

            goto label_15;
        }
        catch(Throwable v0_2) {
            v1 = ((Throwable)v6);
        }
        catch(Throwable v0_2) {
            try {
                throw v0_2;
            }
            catch(Throwable v1) {
                v11 = v1;
                v1 = v0_2;
                v0_2 = v11;
            }
        }

        if(v9 == null) {
            goto label_56;
        }

        if(v1 == null) {
            goto label_60;
        }

        try {
            v9.close();
            goto label_56;
        }
        catch(Throwable v2) {
            try {
                v1.addSuppressed(v2);
                goto label_56;
            label_60:
                v9.close();
            label_56:
                throw v0_2;
            }
            catch(Throwable v0_2) {
                goto label_25;
            }
        }

    label_15:
        if(0 == 0) {
            goto label_37;
        }

        try {
            v9.close();
            goto label_17;
        }
        catch(Throwable v0_2) {
        }
        catch(Throwable v1) {
            try {
                v10.addSuppressed(v1);
                goto label_17;
            label_37:
                v9.close();
                goto label_17;
            }
            catch(Throwable v0_2) {
            label_40:
                v1 = ((Throwable)v6);
            }
            catch(Throwable v0_2) {
                try {
                label_25:
                    throw v0_2;
                }
                catch(Throwable v1) {
                    v11 = v1;
                    v1 = v0_2;
                    v0_2 = v11;
                }
            }
        }

        if(v7 == null) {
            goto label_33;
        }

        if(v1 == null) {
            goto label_65;
        }

        try {
            v7.close();
            goto label_33;
        }
        catch(Throwable v2) {
            try {
                v1.addSuppressed(v2);
                goto label_33;
            label_65:
                v7.close();
            label_33:
                throw v0_2;
            }
            catch(IOException v0_1) {
                goto label_35;
            }
        }

    label_17:
        if(v7 != null) {
            if(0 == 0) {
                goto label_45;
            }

            try {
                v7.close();
            }
            catch(IOException v0_1) {
            }
            catch(Throwable v1) {
                try {
                    v8.addSuppressed(v1);
                    return v0_5;
                label_45:
                    v7.close();
                }
                catch(IOException v0_1) {
                label_35:
                    v0_5 = v6;
                }
            }
        }

        return v0_5;
    }

    public static ByteBuffer a(Context arg3, Resources arg4, int arg5) {
        ByteBuffer v0 = null;
        File v1 = h.a(arg3);
        if(v1 != null) {
            try {
                if(!h.a(v1, arg4, arg5)) {
                }
                else {
                    goto label_8;
                }
            }
            catch(Throwable v0_1) {
                goto label_12;
            }

            v1.delete();
            return v0;
            try {
            label_8:
                v0 = h.a(v1);
            }
            catch(Throwable v0_1) {
            label_12:
                v1.delete();
                throw v0_1;
            }

            v1.delete();
        }

        return v0;
    }

    private static ByteBuffer a(File arg10) {
        ByteBuffer v0_4;
        Throwable v8;
        FileInputStream v7;
        ByteBuffer v6 = null;
        try {
            v7 = new FileInputStream(arg10);
            v8 = null;
        }
        catch(IOException v0) {
            goto label_17;
        }

        try {
            FileChannel v0_2 = v7.getChannel();
            MappedByteBuffer v0_3 = v0_2.map(FileChannel$MapMode.READ_ONLY, 0, v0_2.size());
            if(v7 == null) {
                return v0_4;
            }

            goto label_10;
        }
        catch(Throwable v0_1) {
            v1 = ((Throwable)v6);
        }
        catch(Throwable v0_1) {
            try {
                throw v0_1;
            }
            catch(Throwable v1) {
                Throwable v9 = v1;
                v1 = v0_1;
                v0_1 = v9;
            }
        }

        if(v7 != null) {
            if(v1 != null) {
                try {
                    v7.close();
                }
                catch(Throwable v2) {
                    v1.addSuppressed(v2);
                }
            }
            else {
                v7.close();
            }
        }

        throw v0_1;
    label_10:
        if(0 == 0) {
            goto label_19;
        }

        try {
            v7.close();
        }
        catch(IOException v0) {
        }
        catch(Throwable v1) {
            try {
                v8.addSuppressed(v1);
                return v0_4;
            label_19:
                v7.close();
                return v0_4;
            label_17:
                v0_4 = v6;
            }
            catch(IOException v0) {
                goto label_17;
            }
        }

        return v0_4;
    }
}

