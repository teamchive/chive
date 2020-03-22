package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.MenuItem$OnActionExpandListener;
import android.view.MenuItem;

@TargetApi(value=14) @RequiresApi(value=14) class MenuItemCompatIcs {
    class OnActionExpandListenerWrapper implements MenuItem$OnActionExpandListener {
        private SupportActionExpandProxy mWrapped;

        public OnActionExpandListenerWrapper(SupportActionExpandProxy arg1) {
            super();
            this.mWrapped = arg1;
        }

        public boolean onMenuItemActionCollapse(MenuItem arg2) {
            return this.mWrapped.onMenuItemActionCollapse(arg2);
        }

        public boolean onMenuItemActionExpand(MenuItem arg2) {
            return this.mWrapped.onMenuItemActionExpand(arg2);
        }
    }

    interface SupportActionExpandProxy {
        boolean onMenuItemActionCollapse(MenuItem arg1);

        boolean onMenuItemActionExpand(MenuItem arg1);
    }

    MenuItemCompatIcs() {
        super();
    }

    public static boolean collapseActionView(MenuItem arg1) {
        return arg1.collapseActionView();
    }

    public static boolean expandActionView(MenuItem arg1) {
        return arg1.expandActionView();
    }

    public static boolean isActionViewExpanded(MenuItem arg1) {
        return arg1.isActionViewExpanded();
    }

    public static MenuItem setOnActionExpandListener(MenuItem arg1, SupportActionExpandProxy arg2) {
        return arg1.setOnActionExpandListener(new OnActionExpandListenerWrapper(arg2));
    }
}

