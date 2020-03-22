package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build$VERSION;
import android.support.v4.d.a.a;
import android.support.v4.d.a.b;
import android.support.v4.d.a.c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class q {
    public static Menu a(Context arg1, a arg2) {
        return new r(arg1, arg2);
    }

    public static MenuItem a(Context arg2, b arg3) {
        k v0_1;
        if(Build$VERSION.SDK_INT >= 16) {
            l v0 = new l(arg2, arg3);
        }
        else {
            v0_1 = new k(arg2, arg3);
        }

        return ((MenuItem)v0_1);
    }

    public static SubMenu a(Context arg1, c arg2) {
        return new v(arg1, arg2);
    }
}

