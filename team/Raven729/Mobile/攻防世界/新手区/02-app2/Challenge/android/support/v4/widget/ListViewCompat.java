package android.support.v4.widget;

import android.os.Build$VERSION;
import android.support.annotation.NonNull;
import android.widget.ListView;

public final class ListViewCompat {
    private ListViewCompat() {
        super();
    }

    public static void scrollListBy(@NonNull ListView arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 19) {
            ListViewCompatKitKat.scrollListBy(arg2, arg3);
        }
        else {
            ListViewCompatGingerbread.scrollListBy(arg2, arg3);
        }
    }
}

