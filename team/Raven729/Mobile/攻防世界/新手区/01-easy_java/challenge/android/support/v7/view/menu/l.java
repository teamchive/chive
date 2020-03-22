package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.h.c$b;
import android.view.ActionProvider$VisibilityListener;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

class l extends k {
    class a extends android.support.v7.view.menu.k$a implements ActionProvider$VisibilityListener {
        b c;

        public a(l arg1, Context arg2, ActionProvider arg3) {
            this.d = arg1;
            super(((k)arg1), arg2, arg3);
        }

        public View a(MenuItem arg2) {
            return this.a.onCreateActionView(arg2);
        }

        public void a(b arg2) {
            ActionProvider$VisibilityListener v1;
            this.c = arg2;
            ActionProvider v0 = this.a;
            if(arg2 == null) {
                v1 = null;
            }

            v0.setVisibilityListener(v1);
        }

        public boolean b() {
            return this.a.overridesItemVisibility();
        }

        public boolean c() {
            return this.a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean arg2) {
            if(this.c != null) {
                this.c.a(arg2);
            }
        }
    }

    l(Context arg1, android.support.v4.d.a.b arg2) {
        super(arg1, arg2);
    }

    android.support.v7.view.menu.k$a a(ActionProvider arg3) {
        return new a(this, this.a, arg3);
    }
}

