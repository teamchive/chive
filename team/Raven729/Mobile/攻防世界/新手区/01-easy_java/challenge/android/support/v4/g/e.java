package android.support.v4.g;

import android.util.Log;
import java.io.Writer;

public class e extends Writer {
    private final String a;
    private StringBuilder b;

    public e(String arg3) {
        super();
        this.b = new StringBuilder(0x80);
        this.a = arg3;
    }

    private void a() {
        if(this.b.length() > 0) {
            Log.d(this.a, this.b.toString());
            this.b.delete(0, this.b.length());
        }
    }

    public void close() {
        this.a();
    }

    public void flush() {
        this.a();
    }

    public void write(char[] arg4, int arg5, int arg6) {
        int v0;
        for(v0 = 0; v0 < arg6; ++v0) {
            char v1 = arg4[arg5 + v0];
            if(v1 == 10) {
                this.a();
            }
            else {
                this.b.append(v1);
            }
        }
    }
}

