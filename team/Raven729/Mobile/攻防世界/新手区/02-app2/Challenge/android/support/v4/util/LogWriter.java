package android.support.v4.util;

import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.io.Writer;

@RestrictTo(value={Scope.LIBRARY_GROUP}) public class LogWriter extends Writer {
    private StringBuilder mBuilder;
    private final String mTag;

    public LogWriter(String arg3) {
        super();
        this.mBuilder = new StringBuilder(0x80);
        this.mTag = arg3;
    }

    public void close() {
        this.flushBuilder();
    }

    public void flush() {
        this.flushBuilder();
    }

    private void flushBuilder() {
        if(this.mBuilder.length() > 0) {
            Log.d(this.mTag, this.mBuilder.toString());
            this.mBuilder.delete(0, this.mBuilder.length());
        }
    }

    public void write(char[] arg4, int arg5, int arg6) {
        int v0;
        for(v0 = 0; v0 < arg6; ++v0) {
            char v1 = arg4[arg5 + v0];
            if(v1 == 10) {
                this.flushBuilder();
            }
            else {
                this.mBuilder.append(v1);
            }
        }
    }
}

