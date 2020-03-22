package android.support.v4.internal.view;

import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.view.Menu;

@RestrictTo(value={Scope.LIBRARY_GROUP}) public interface SupportMenu extends Menu {
    public static final int CATEGORY_MASK = 0xFFFF0000;
    public static final int CATEGORY_SHIFT = 16;
    public static final int FLAG_KEEP_OPEN_ON_SUBMENU_OPENED = 4;
    public static final int USER_MASK = 0xFFFF;
    public static final int USER_SHIFT;

}

