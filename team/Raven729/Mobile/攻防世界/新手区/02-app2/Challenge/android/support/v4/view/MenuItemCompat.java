package android.support.v4.view;

import android.os.Build$VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class MenuItemCompat {
    class BaseMenuVersionImpl implements MenuVersionImpl {
        BaseMenuVersionImpl() {
            super();
        }

        public boolean collapseActionView(MenuItem arg2) {
            return 0;
        }

        public boolean expandActionView(MenuItem arg2) {
            return 0;
        }

        public View getActionView(MenuItem arg2) {
            return null;
        }

        public boolean isActionViewExpanded(MenuItem arg2) {
            return 0;
        }

        public MenuItem setActionView(MenuItem arg1, int arg2) {
            return arg1;
        }

        public MenuItem setActionView(MenuItem arg1, View arg2) {
            return arg1;
        }

        public MenuItem setOnActionExpandListener(MenuItem arg1, OnActionExpandListener arg2) {
            return arg1;
        }

        public void setShowAsAction(MenuItem arg1, int arg2) {
        }
    }

    class HoneycombMenuVersionImpl implements MenuVersionImpl {
        HoneycombMenuVersionImpl() {
            super();
        }

        public boolean collapseActionView(MenuItem arg2) {
            return 0;
        }

        public boolean expandActionView(MenuItem arg2) {
            return 0;
        }

        public View getActionView(MenuItem arg2) {
            return MenuItemCompatHoneycomb.getActionView(arg2);
        }

        public boolean isActionViewExpanded(MenuItem arg2) {
            return 0;
        }

        public MenuItem setActionView(MenuItem arg2, int arg3) {
            return MenuItemCompatHoneycomb.setActionView(arg2, arg3);
        }

        public MenuItem setActionView(MenuItem arg2, View arg3) {
            return MenuItemCompatHoneycomb.setActionView(arg2, arg3);
        }

        public MenuItem setOnActionExpandListener(MenuItem arg1, OnActionExpandListener arg2) {
            return arg1;
        }

        public void setShowAsAction(MenuItem arg1, int arg2) {
            MenuItemCompatHoneycomb.setShowAsAction(arg1, arg2);
        }
    }

    class IcsMenuVersionImpl extends HoneycombMenuVersionImpl {
        IcsMenuVersionImpl() {
            super();
        }

        public boolean collapseActionView(MenuItem arg2) {
            return MenuItemCompatIcs.collapseActionView(arg2);
        }

        public boolean expandActionView(MenuItem arg2) {
            return MenuItemCompatIcs.expandActionView(arg2);
        }

        public boolean isActionViewExpanded(MenuItem arg2) {
            return MenuItemCompatIcs.isActionViewExpanded(arg2);
        }

        public MenuItem setOnActionExpandListener(MenuItem arg2, OnActionExpandListener arg3) {
            MenuItem v0 = arg3 == null ? MenuItemCompatIcs.setOnActionExpandListener(arg2, null) : MenuItemCompatIcs.setOnActionExpandListener(arg2, new SupportActionExpandProxy(arg3) {
                public boolean onMenuItemActionCollapse(MenuItem arg2) {
                    return this.val$listener.onMenuItemActionCollapse(arg2);
                }

                public boolean onMenuItemActionExpand(MenuItem arg2) {
                    return this.val$listener.onMenuItemActionExpand(arg2);
                }
            });
            return v0;
        }
    }

    interface MenuVersionImpl {
        boolean collapseActionView(MenuItem arg1);

        boolean expandActionView(MenuItem arg1);

        View getActionView(MenuItem arg1);

        boolean isActionViewExpanded(MenuItem arg1);

        MenuItem setActionView(MenuItem arg1, int arg2);

        MenuItem setActionView(MenuItem arg1, View arg2);

        MenuItem setOnActionExpandListener(MenuItem arg1, OnActionExpandListener arg2);

        void setShowAsAction(MenuItem arg1, int arg2);
    }

    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem arg1);

        boolean onMenuItemActionExpand(MenuItem arg1);
    }

    static final MenuVersionImpl IMPL = null;
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    static {
        if(Build$VERSION.SDK_INT >= 14) {
            MenuItemCompat.IMPL = new IcsMenuVersionImpl();
        }
        else if(Build$VERSION.SDK_INT >= 11) {
            MenuItemCompat.IMPL = new HoneycombMenuVersionImpl();
        }
        else {
            MenuItemCompat.IMPL = new BaseMenuVersionImpl();
        }
    }

    private MenuItemCompat() {
        super();
    }

    public static boolean collapseActionView(MenuItem arg1) {
        boolean v0 = (arg1 instanceof SupportMenuItem) ? ((SupportMenuItem)arg1).collapseActionView() : MenuItemCompat.IMPL.collapseActionView(arg1);
        return v0;
    }

    public static boolean expandActionView(MenuItem arg1) {
        boolean v0 = (arg1 instanceof SupportMenuItem) ? ((SupportMenuItem)arg1).expandActionView() : MenuItemCompat.IMPL.expandActionView(arg1);
        return v0;
    }

    public static ActionProvider getActionProvider(MenuItem arg2) {
        ActionProvider v0;
        if((arg2 instanceof SupportMenuItem)) {
            v0 = ((SupportMenuItem)arg2).getSupportActionProvider();
        }
        else {
            Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
            v0 = null;
        }

        return v0;
    }

    public static View getActionView(MenuItem arg1) {
        View v0 = (arg1 instanceof SupportMenuItem) ? ((SupportMenuItem)arg1).getActionView() : MenuItemCompat.IMPL.getActionView(arg1);
        return v0;
    }

    public static boolean isActionViewExpanded(MenuItem arg1) {
        boolean v0 = (arg1 instanceof SupportMenuItem) ? ((SupportMenuItem)arg1).isActionViewExpanded() : MenuItemCompat.IMPL.isActionViewExpanded(arg1);
        return v0;
    }

    public static MenuItem setActionProvider(MenuItem arg2, ActionProvider arg3) {
        SupportMenuItem v2;
        if((arg2 instanceof SupportMenuItem)) {
            v2 = ((SupportMenuItem)arg2).setSupportActionProvider(arg3);
        }
        else {
            Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        }

        return ((MenuItem)v2);
    }

    public static MenuItem setActionView(MenuItem arg1, int arg2) {
        MenuItem v0 = (arg1 instanceof SupportMenuItem) ? ((SupportMenuItem)arg1).setActionView(arg2) : MenuItemCompat.IMPL.setActionView(arg1, arg2);
        return v0;
    }

    public static MenuItem setActionView(MenuItem arg1, View arg2) {
        MenuItem v0 = (arg1 instanceof SupportMenuItem) ? ((SupportMenuItem)arg1).setActionView(arg2) : MenuItemCompat.IMPL.setActionView(arg1, arg2);
        return v0;
    }

    public static MenuItem setOnActionExpandListener(MenuItem arg1, OnActionExpandListener arg2) {
        MenuItem v0_1;
        if((arg1 instanceof SupportMenuItem)) {
            SupportMenuItem v0 = ((SupportMenuItem)arg1).setSupportOnActionExpandListener(arg2);
        }
        else {
            v0_1 = MenuItemCompat.IMPL.setOnActionExpandListener(arg1, arg2);
        }

        return v0_1;
    }

    public static void setShowAsAction(MenuItem arg1, int arg2) {
        if((arg1 instanceof SupportMenuItem)) {
            ((SupportMenuItem)arg1).setShowAsAction(arg2);
        }
        else {
            MenuItemCompat.IMPL.setShowAsAction(arg1, arg2);
        }
    }
}

