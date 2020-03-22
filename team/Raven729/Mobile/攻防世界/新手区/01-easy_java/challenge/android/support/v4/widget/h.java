package android.support.v4.widget;

import android.os.Build$VERSION;
import android.view.View;
import android.widget.ListView;

public final class h {
    public static void a(ListView arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 19) {
            arg2.scrollListBy(arg3);
        }
        else {
            int v0 = arg2.getFirstVisiblePosition();
            if(v0 != -1) {
                View v1 = arg2.getChildAt(0);
                if(v1 != null) {
                    arg2.setSelectionFromTop(v0, v1.getTop() - arg3);
                }
            }
        }
    }
}

