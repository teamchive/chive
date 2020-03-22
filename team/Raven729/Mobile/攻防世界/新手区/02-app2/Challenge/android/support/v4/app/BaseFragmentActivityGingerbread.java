package android.support.v4.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater$Factory;
import android.view.View;

@TargetApi(value=9) @RequiresApi(value=9) abstract class BaseFragmentActivityGingerbread extends SupportActivity {
    boolean mStartedIntentSenderFromFragment;

    BaseFragmentActivityGingerbread() {
        super();
    }

    static void checkForValidRequestCode(int arg2) {
        if((0xFFFF0000 & arg2) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    abstract View dispatchFragmentsOnCreateView(View arg1, String arg2, Context arg3, AttributeSet arg4);

    protected void onCreate(Bundle arg3) {
        if(Build$VERSION.SDK_INT < 11 && this.getLayoutInflater().getFactory() == null) {
            this.getLayoutInflater().setFactory(((LayoutInflater$Factory)this));
        }

        super.onCreate(arg3);
    }

    public View onCreateView(String arg2, Context arg3, AttributeSet arg4) {
        View v0 = this.dispatchFragmentsOnCreateView(null, arg2, arg3, arg4);
        if(v0 == null) {
            v0 = super.onCreateView(arg2, arg3, arg4);
        }

        return v0;
    }

    public void startIntentSenderForResult(IntentSender arg2, int arg3, @Nullable Intent arg4, int arg5, int arg6, int arg7) {
        if(!this.mStartedIntentSenderFromFragment && arg3 != -1) {
            BaseFragmentActivityGingerbread.checkForValidRequestCode(arg3);
        }

        super.startIntentSenderForResult(arg2, arg3, arg4, arg5, arg6, arg7);
    }
}

