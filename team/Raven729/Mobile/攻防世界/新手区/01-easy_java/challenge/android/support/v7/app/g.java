package android.support.v7.app;

import android.content.Context;
import android.view.Menu;
import android.view.Window$Callback;
import android.view.Window;
import java.util.List;

class g extends j {
    class a extends android.support.v7.app.j$a {
        a(g arg1, Window$Callback arg2) {
            this.b = arg1;
            super(((j)arg1), arg2);
        }

        public void onProvideKeyboardShortcuts(List arg4, Menu arg5, int arg6) {
            d v0 = this.b.a(0, true);
            if(v0 == null || v0.j == null) {
                super.onProvideKeyboardShortcuts(arg4, arg5, arg6);
            }
            else {
                super.onProvideKeyboardShortcuts(arg4, v0.j, arg6);
            }
        }
    }

    g(Context arg1, Window arg2, android.support.v7.app.d arg3) {
        super(arg1, arg2, arg3);
    }

    Window$Callback a(Window$Callback arg2) {
        return new a(this, arg2);
    }
}

