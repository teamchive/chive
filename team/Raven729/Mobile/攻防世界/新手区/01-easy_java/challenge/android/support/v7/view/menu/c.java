package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.d.a.b;
import android.support.v4.g.a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class c extends d {
    final Context a;
    private Map c;
    private Map d;

    c(Context arg1, Object arg2) {
        super(arg2);
        this.a = arg1;
    }

    final MenuItem a(MenuItem arg4) {
        MenuItem v1_1;
        Object v1;
        if((arg4 instanceof b)) {
            MenuItem v0 = arg4;
            if(this.c == null) {
                this.c = new a();
            }

            v1 = this.c.get(arg4);
            if(v1 != null) {
                goto label_15;
            }

            v1_1 = q.a(this.a, ((b)v0));
            this.c.put(v0, v1_1);
        }
        else {
            v1_1 = arg4;
        }

    label_15:
        return ((MenuItem)v1);
    }

    final SubMenu a(SubMenu arg3) {
        SubMenu v0_1;
        Object v0;
        if((arg3 instanceof android.support.v4.d.a.c)) {
            if(this.d == null) {
                this.d = new a();
            }

            v0 = this.d.get(arg3);
            if(v0 != null) {
                goto label_14;
            }

            v0_1 = q.a(this.a, ((android.support.v4.d.a.c)arg3));
            this.d.put(arg3, v0_1);
        }
        else {
            v0_1 = arg3;
        }

    label_14:
        return ((SubMenu)v0);
    }

    final void a() {
        if(this.c != null) {
            this.c.clear();
        }

        if(this.d != null) {
            this.d.clear();
        }
    }

    final void a(int arg3) {
        if(this.c != null) {
            Iterator v1 = this.c.keySet().iterator();
            while(v1.hasNext()) {
                if(arg3 != v1.next().getGroupId()) {
                    continue;
                }

                v1.remove();
            }
        }
    }

    final void b(int arg3) {
        if(this.c != null) {
            Iterator v1 = this.c.keySet().iterator();
            do {
                if(v1.hasNext()) {
                    if(arg3 != v1.next().getItemId()) {
                        continue;
                    }

                    break;
                }

                return;
            }
            while(true);

            v1.remove();
        }
    }
}

