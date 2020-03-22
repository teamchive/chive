package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode$Callback;
import android.view.ActionMode;
import android.view.Window$Callback;
import android.view.Window;

class j extends i {
    class a extends android.support.v7.app.i$a {
        a(j arg1, Window$Callback arg2) {
            this.d = arg1;
            super(((i)arg1), arg2);
        }

        public ActionMode onWindowStartingActionMode(ActionMode$Callback arg2) {
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode$Callback arg2, int arg3) {
            ActionMode v0;
            if(this.d.o()) {
                switch(arg3) {
                    case 0: {
                        v0 = this.a(arg2);
                        return v0;
                    }
                    default: {
                    label_4:
                        return super.onWindowStartingActionMode(arg2, arg3);
                    }
                }
            }
            else {
                goto label_4;
            }

            return v0;
        }
    }

    private final UiModeManager t;

    j(Context arg2, Window arg3, d arg4) {
        super(arg2, arg3, arg4);
        this.t = arg2.getSystemService("uimode");
    }

    Window$Callback a(Window$Callback arg2) {
        return new a(this, arg2);
    }

    int d(int arg2) {
        int v0 = arg2 != 0 || this.t.getNightMode() != 0 ? super.d(arg2) : -1;
        return v0;
    }
}

