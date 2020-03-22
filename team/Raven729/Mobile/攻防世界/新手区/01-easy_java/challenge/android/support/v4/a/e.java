package android.support.v4.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.util.AttributeSet;
import android.view.View;

abstract class e extends aa {
    boolean a;

    e() {
        super();
    }

    static void a(int arg2) {
        if((0xFFFF0000 & arg2) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    abstract View a(View arg1, String arg2, Context arg3, AttributeSet arg4);

    public View onCreateView(View arg2, String arg3, Context arg4, AttributeSet arg5) {
        View v0 = this.a(arg2, arg3, arg4, arg5);
        if(v0 == null) {
            v0 = super.onCreateView(arg2, arg3, arg4, arg5);
        }

        return v0;
    }

    public View onCreateView(String arg2, Context arg3, AttributeSet arg4) {
        View v0 = this.a(null, arg2, arg3, arg4);
        if(v0 == null) {
            v0 = super.onCreateView(arg2, arg3, arg4);
        }

        return v0;
    }

    public void startIntentSenderForResult(IntentSender arg2, int arg3, Intent arg4, int arg5, int arg6, int arg7) {
        if(!this.a && arg3 != -1) {
            e.a(arg3);
        }

        super.startIntentSenderForResult(arg2, arg3, arg4, arg5, arg6, arg7);
    }
}

