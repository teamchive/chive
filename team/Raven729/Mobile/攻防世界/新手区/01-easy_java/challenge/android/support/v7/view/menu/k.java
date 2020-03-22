package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.MenuItem$OnActionExpandListener;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class k extends c implements MenuItem {
    class a extends android.support.v4.h.c {
        final ActionProvider a;

        public a(k arg1, Context arg2, ActionProvider arg3) {
            this.b = arg1;
            super(arg2);
            this.a = arg3;
        }

        public View a() {
            return this.a.onCreateActionView();
        }

        public void a(SubMenu arg3) {
            this.a.onPrepareSubMenu(this.b.a(arg3));
        }

        public boolean d() {
            return this.a.onPerformDefaultAction();
        }

        public boolean e() {
            return this.a.hasSubMenu();
        }
    }

    class b extends FrameLayout implements android.support.v7.view.c {
        final CollapsibleActionView a;

        b(View arg2) {
            super(arg2.getContext());
            this.a = arg2;
            this.addView(arg2);
        }

        public void a() {
            this.a.onActionViewExpanded();
        }

        public void b() {
            this.a.onActionViewCollapsed();
        }

        View c() {
            return this.a;
        }
    }

    class android.support.v7.view.menu.k$c extends d implements MenuItem$OnActionExpandListener {
        android.support.v7.view.menu.k$c(k arg1, MenuItem$OnActionExpandListener arg2) {
            this.a = arg1;
            super(arg2);
        }

        public boolean onMenuItemActionCollapse(MenuItem arg3) {
            return this.b.onMenuItemActionCollapse(this.a.a(arg3));
        }

        public boolean onMenuItemActionExpand(MenuItem arg3) {
            return this.b.onMenuItemActionExpand(this.a.a(arg3));
        }
    }

    class android.support.v7.view.menu.k$d extends d implements MenuItem$OnMenuItemClickListener {
        android.support.v7.view.menu.k$d(k arg1, MenuItem$OnMenuItemClickListener arg2) {
            this.a = arg1;
            super(arg2);
        }

        public boolean onMenuItemClick(MenuItem arg3) {
            return this.b.onMenuItemClick(this.a.a(arg3));
        }
    }

    private Method c;

    k(Context arg1, android.support.v4.d.a.b arg2) {
        super(arg1, arg2);
    }

    public void a(boolean arg6) {
        try {
            if(this.c == null) {
                this.c = this.b.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }

            this.c.invoke(this.b, Boolean.valueOf(arg6));
        }
        catch(Exception v0) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", ((Throwable)v0));
        }
    }

    a a(ActionProvider arg3) {
        return new a(this, this.a, arg3);
    }

    public boolean collapseActionView() {
        return this.b.collapseActionView();
    }

    public boolean expandActionView() {
        return this.b.expandActionView();
    }

    public ActionProvider getActionProvider() {
        android.support.v4.h.c v0 = this.b.a();
        ActionProvider v0_1 = (v0 instanceof a) ? ((a)v0).a : null;
        return v0_1;
    }

    public View getActionView() {
        View v0 = this.b.getActionView();
        if((v0 instanceof b)) {
            v0 = ((b)v0).c();
        }

        return v0;
    }

    public int getAlphabeticModifiers() {
        return this.b.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.b.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.b.getContentDescription();
    }

    public int getGroupId() {
        return this.b.getGroupId();
    }

    public Drawable getIcon() {
        return this.b.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.b.getIconTintList();
    }

    public PorterDuff$Mode getIconTintMode() {
        return this.b.getIconTintMode();
    }

    public Intent getIntent() {
        return this.b.getIntent();
    }

    public int getItemId() {
        return this.b.getItemId();
    }

    public ContextMenu$ContextMenuInfo getMenuInfo() {
        return this.b.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.b.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.b.getNumericShortcut();
    }

    public int getOrder() {
        return this.b.getOrder();
    }

    public SubMenu getSubMenu() {
        return this.a(this.b.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.b.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.b.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.b.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.b.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.b.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.b.isCheckable();
    }

    public boolean isChecked() {
        return this.b.isChecked();
    }

    public boolean isEnabled() {
        return this.b.isEnabled();
    }

    public boolean isVisible() {
        return this.b.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider arg3) {
        android.support.v4.h.c v1_1;
        Object v0 = this.b;
        if(arg3 != null) {
            a v1 = this.a(arg3);
        }
        else {
            v1_1 = null;
        }

        ((android.support.v4.d.a.b)v0).a(v1_1);
        return this;
    }

    public MenuItem setActionView(int arg4) {
        this.b.setActionView(arg4);
        View v1 = this.b.getActionView();
        if((v1 instanceof CollapsibleActionView)) {
            this.b.setActionView(new b(v1));
        }

        return this;
    }

    public MenuItem setActionView(View arg2) {
        b v2;
        if((arg2 instanceof CollapsibleActionView)) {
            v2 = new b(arg2);
        }

        this.b.setActionView(((View)v2));
        return this;
    }

    public MenuItem setAlphabeticShortcut(char arg2) {
        this.b.setAlphabeticShortcut(arg2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char arg2, int arg3) {
        this.b.setAlphabeticShortcut(arg2, arg3);
        return this;
    }

    public MenuItem setCheckable(boolean arg2) {
        this.b.setCheckable(arg2);
        return this;
    }

    public MenuItem setChecked(boolean arg2) {
        this.b.setChecked(arg2);
        return this;
    }

    public MenuItem setContentDescription(CharSequence arg2) {
        this.b.a(arg2);
        return this;
    }

    public MenuItem setEnabled(boolean arg2) {
        this.b.setEnabled(arg2);
        return this;
    }

    public MenuItem setIcon(int arg2) {
        this.b.setIcon(arg2);
        return this;
    }

    public MenuItem setIcon(Drawable arg2) {
        this.b.setIcon(arg2);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList arg2) {
        this.b.setIconTintList(arg2);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff$Mode arg2) {
        this.b.setIconTintMode(arg2);
        return this;
    }

    public MenuItem setIntent(Intent arg2) {
        this.b.setIntent(arg2);
        return this;
    }

    public MenuItem setNumericShortcut(char arg2) {
        this.b.setNumericShortcut(arg2);
        return this;
    }

    public MenuItem setNumericShortcut(char arg2, int arg3) {
        this.b.setNumericShortcut(arg2, arg3);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem$OnActionExpandListener arg3) {
        MenuItem$OnActionExpandListener v1_1;
        Object v0 = this.b;
        if(arg3 != null) {
            android.support.v7.view.menu.k$c v1 = new android.support.v7.view.menu.k$c(this, arg3);
        }
        else {
            v1_1 = null;
        }

        ((android.support.v4.d.a.b)v0).setOnActionExpandListener(v1_1);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem$OnMenuItemClickListener arg3) {
        android.support.v7.view.menu.k$d v1;
        Object v0 = this.b;
        if(arg3 != null) {
            v1 = new android.support.v7.view.menu.k$d(this, arg3);
        }
        else {
            MenuItem$OnMenuItemClickListener v1_1 = null;
        }

        ((android.support.v4.d.a.b)v0).setOnMenuItemClickListener(((MenuItem$OnMenuItemClickListener)v1));
        return this;
    }

    public MenuItem setShortcut(char arg2, char arg3) {
        this.b.setShortcut(arg2, arg3);
        return this;
    }

    public MenuItem setShortcut(char arg2, char arg3, int arg4, int arg5) {
        this.b.setShortcut(arg2, arg3, arg4, arg5);
        return this;
    }

    public void setShowAsAction(int arg2) {
        this.b.setShowAsAction(arg2);
    }

    public MenuItem setShowAsActionFlags(int arg2) {
        this.b.setShowAsActionFlags(arg2);
        return this;
    }

    public MenuItem setTitle(int arg2) {
        this.b.setTitle(arg2);
        return this;
    }

    public MenuItem setTitle(CharSequence arg2) {
        this.b.setTitle(arg2);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence arg2) {
        this.b.setTitleCondensed(arg2);
        return this;
    }

    public MenuItem setTooltipText(CharSequence arg2) {
        this.b.b(arg2);
        return this;
    }

    public MenuItem setVisible(boolean arg2) {
        return this.b.setVisible(arg2);
    }
}

