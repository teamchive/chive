package android.support.v4.a;

import android.app.Activity;
import android.arch.lifecycle.b;
import android.arch.lifecycle.c;
import android.arch.lifecycle.d;
import android.arch.lifecycle.g;
import android.os.Bundle;
import android.support.v4.g.k;

public class aa extends Activity implements c {
    private k a;
    private d b;

    public aa() {
        super();
        this.a = new k();
        this.b = new d(((c)this));
    }

    public b a() {
        return this.b;
    }

    protected void onCreate(Bundle arg1) {
        super.onCreate(arg1);
        g.a(((Activity)this));
    }

    protected void onSaveInstanceState(Bundle arg3) {
        this.b.a(android.arch.lifecycle.b$b.c);
        super.onSaveInstanceState(arg3);
    }
}

