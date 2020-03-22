package android.support.v4.c;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.f.b$b;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class d extends g {
    d() {
        super();
    }

    private File a(ParcelFileDescriptor arg4) {
        File v0_1;
        File v1 = null;
        try {
            String v2 = Os.readlink("/proc/self/fd/" + arg4.getFd());
            if(!OsConstants.S_ISREG(Os.stat(v2).st_mode)) {
                return v1;
            }

            v0_1 = new File(v2);
        }
        catch(ErrnoException v0) {
            v0_1 = v1;
        }

        return v0_1;
    }

    public Typeface a(Context arg8, CancellationSignal arg9, b[] arg10, int arg11) {
        Throwable v5;
        FileInputStream v4;
        Typeface v1_4;
        Throwable v2_1;
        ParcelFileDescriptor v3;
        Typeface v0 = null;
        if(arg10.length < 1) {
            return v0;
        }

        b v1 = this.a(arg10, arg11);
        ContentResolver v2 = arg8.getContentResolver();
        try {
            v3 = v2.openFileDescriptor(v1.a(), "r", arg9);
            v2_1 = null;
        }
        catch(IOException v1_1) {
            return v0;
        }

        try {
            File v1_3 = this.a(v3);
            if(v1_3 != null && (v1_3.canRead())) {
                v1_4 = Typeface.createFromFile(v1_3);
                if(v3 != null) {
                    goto label_67;
                }
                else {
                    return v1_4;
                }
            }

            goto label_15;
        }
        catch(Throwable v1_2) {
            goto label_32;
        }
        catch(Throwable v1_2) {
            goto label_46;
        }

    label_67:
        if(0 != 0) {
            try {
                v3.close();
                return v1_4;
            }
            catch(IOException v1_1) {
            }
            catch(Throwable v3_1) {
                try {
                    v2_1.addSuppressed(v3_1);
                    return v1_4;
                label_74:
                    v3.close();
                }
                catch(IOException v1_1) {
                    return v0;
                }

                return v1_4;
                try {
                label_15:
                    v4 = new FileInputStream(v3.getFileDescriptor());
                    v5 = null;
                }
                catch(Throwable v1_2) {
                    goto label_32;
                }
                catch(Throwable v1_2) {
                    goto label_46;
                }

                try {
                    v1_4 = super.a(arg8, ((InputStream)v4));
                    if(v4 == null) {
                        goto label_23;
                    }

                    goto label_21;
                }
                catch(Throwable v1_2) {
                    v2_1 = ((Throwable)v0);
                }
                catch(Throwable v2_1) {
                    try {
                        throw v2_1;
                    }
                    catch(Throwable v1_2) {
                    }
                }

                if(v4 == null) {
                    goto label_59;
                }

                if(v2_1 == null) {
                    goto label_63;
                }

                try {
                    v4.close();
                    goto label_59;
                }
                catch(Throwable v1_2) {
                }
                catch(Throwable v4_1) {
                    try {
                        v2_1.addSuppressed(v4_1);
                        goto label_59;
                    label_63:
                        v4.close();
                    label_59:
                        throw v1_2;
                    }
                    catch(Throwable v1_2) {
                        goto label_32;
                    }
                    catch(Throwable v1_2) {
                        goto label_46;
                    }

                label_21:
                    if(0 == 0) {
                        goto label_43;
                    }

                    try {
                        v4.close();
                        goto label_23;
                    }
                    catch(Throwable v1_2) {
                    }
                    catch(Throwable v4_1) {
                        try {
                            v5.addSuppressed(v4_1);
                            goto label_23;
                        label_43:
                            v4.close();
                            goto label_23;
                        }
                        catch(Throwable v1_2) {
                        label_46:
                            v2_1 = ((Throwable)v0);
                        }
                        catch(Throwable v1_2) {
                            try {
                            label_32:
                                throw v1_2;
                            }
                            catch(Throwable v2_1) {
                                Throwable v6 = v2_1;
                                v2_1 = v1_2;
                                v1_2 = v6;
                            }
                        }
                    }
                }

                if(v3 == null) {
                    goto label_40;
                }

                if(v2_1 == null) {
                    goto label_79;
                }

                try {
                    v3.close();
                    goto label_40;
                }
                catch(IOException v1_1) {
                }
                catch(Throwable v3_1) {
                    try {
                        v2_1.addSuppressed(v3_1);
                        goto label_40;
                    label_79:
                        v3.close();
                    label_40:
                        throw v1_2;
                    }
                    catch(IOException v1_1) {
                        return v0;
                    }

                label_23:
                    if(v3 == null) {
                        return v1_4;
                    }

                    if(0 == 0) {
                        goto label_51;
                    }

                    try {
                        v3.close();
                        return v1_4;
                    }
                    catch(IOException v1_1) {
                    }
                    catch(Throwable v3_1) {
                        try {
                            v2_1.addSuppressed(v3_1);
                            return v1_4;
                        label_51:
                            v3.close();
                            return v1_4;
                        }
                        catch(IOException v1_1) {
                            return v0;
                        }
                    }
                }
            }
        }
        else {
            goto label_74;
        }

        goto label_15;
        return v1_4;
    }
}

