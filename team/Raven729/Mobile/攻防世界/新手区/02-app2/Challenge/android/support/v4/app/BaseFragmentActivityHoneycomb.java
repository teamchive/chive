package android.support.v4.app;

import android.content.Context;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.view.View;

abstract class BaseFragmentActivityHoneycomb extends BaseFragmentActivityGingerbread {
    BaseFragmentActivityHoneycomb() {
        super();
    }

    public View onCreateView(View arg4, String arg5, Context arg6, AttributeSet arg7) {
        View v0 = this.dispatchFragmentsOnCreateView(arg4, arg5, arg6, arg7);
        if(v0 == null && Build$VERSION.SDK_INT >= 11) {
            v0 = super.onCreateView(arg4, arg5, arg6, arg7);
        }

        return v0;
    }
}

