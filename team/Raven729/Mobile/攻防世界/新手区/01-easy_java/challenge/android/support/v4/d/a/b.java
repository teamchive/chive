package android.support.v4.d.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.support.v4.h.c;
import android.view.MenuItem;
import android.view.View;

public interface b extends MenuItem {
    b a(c arg1);

    b a(CharSequence arg1);

    c a();

    b b(CharSequence arg1);

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    int getAlphabeticModifiers();

    CharSequence getContentDescription();

    ColorStateList getIconTintList();

    PorterDuff$Mode getIconTintMode();

    int getNumericModifiers();

    CharSequence getTooltipText();

    boolean isActionViewExpanded();

    MenuItem setActionView(int arg1);

    MenuItem setActionView(View arg1);

    MenuItem setAlphabeticShortcut(char arg1, int arg2);

    MenuItem setIconTintList(ColorStateList arg1);

    MenuItem setIconTintMode(PorterDuff$Mode arg1);

    MenuItem setNumericShortcut(char arg1, int arg2);

    MenuItem setShortcut(char arg1, char arg2, int arg3, int arg4);

    void setShowAsAction(int arg1);

    MenuItem setShowAsActionFlags(int arg1);
}

