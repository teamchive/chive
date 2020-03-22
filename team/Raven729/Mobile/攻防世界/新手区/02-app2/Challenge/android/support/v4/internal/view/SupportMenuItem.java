package android.support.v4.internal.view;

import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat$OnActionExpandListener;
import android.view.MenuItem;
import android.view.View;

@RestrictTo(value={Scope.LIBRARY_GROUP}) public interface SupportMenuItem extends MenuItem {
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    ActionProvider getSupportActionProvider();

    boolean isActionViewExpanded();

    MenuItem setActionView(int arg1);

    MenuItem setActionView(View arg1);

    void setShowAsAction(int arg1);

    MenuItem setShowAsActionFlags(int arg1);

    SupportMenuItem setSupportActionProvider(ActionProvider arg1);

    SupportMenuItem setSupportOnActionExpandListener(OnActionExpandListener arg1);
}

