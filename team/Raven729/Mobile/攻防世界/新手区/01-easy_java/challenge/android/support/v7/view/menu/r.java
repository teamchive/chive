package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.d.a.a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

class r extends c implements Menu {
    r(Context arg1, a arg2) {
        super(arg1, arg2);
    }

    public MenuItem add(int arg2) {
        return this.a(this.b.add(arg2));
    }

    public MenuItem add(int arg2, int arg3, int arg4, int arg5) {
        return this.a(this.b.add(arg2, arg3, arg4, arg5));
    }

    public MenuItem add(int arg2, int arg3, int arg4, CharSequence arg5) {
        return this.a(this.b.add(arg2, arg3, arg4, arg5));
    }

    public MenuItem add(CharSequence arg2) {
        return this.a(this.b.add(arg2));
    }

    public int addIntentOptions(int arg11, int arg12, int arg13, ComponentName arg14, Intent[] arg15, Intent arg16, int arg17, MenuItem[] arg18) {
        MenuItem[] v9 = null;
        if(arg18 != null) {
            v9 = new MenuItem[arg18.length];
        }

        int v2 = this.b.addIntentOptions(arg11, arg12, arg13, arg14, arg15, arg16, arg17, v9);
        if(v9 != null) {
            int v1 = 0;
            int v3 = v9.length;
            while(v1 < v3) {
                arg18[v1] = this.a(v9[v1]);
                ++v1;
            }
        }

        return v2;
    }

    public SubMenu addSubMenu(int arg2) {
        return this.a(this.b.addSubMenu(arg2));
    }

    public SubMenu addSubMenu(int arg2, int arg3, int arg4, int arg5) {
        return this.a(this.b.addSubMenu(arg2, arg3, arg4, arg5));
    }

    public SubMenu addSubMenu(int arg2, int arg3, int arg4, CharSequence arg5) {
        return this.a(this.b.addSubMenu(arg2, arg3, arg4, arg5));
    }

    public SubMenu addSubMenu(CharSequence arg2) {
        return this.a(this.b.addSubMenu(arg2));
    }

    public void clear() {
        this.a();
        this.b.clear();
    }

    public void close() {
        this.b.close();
    }

    public MenuItem findItem(int arg2) {
        return this.a(this.b.findItem(arg2));
    }

    public MenuItem getItem(int arg2) {
        return this.a(this.b.getItem(arg2));
    }

    public boolean hasVisibleItems() {
        return this.b.hasVisibleItems();
    }

    public boolean isShortcutKey(int arg2, KeyEvent arg3) {
        return this.b.isShortcutKey(arg2, arg3);
    }

    public boolean performIdentifierAction(int arg2, int arg3) {
        return this.b.performIdentifierAction(arg2, arg3);
    }

    public boolean performShortcut(int arg2, KeyEvent arg3, int arg4) {
        return this.b.performShortcut(arg2, arg3, arg4);
    }

    public void removeGroup(int arg2) {
        this.a(arg2);
        this.b.removeGroup(arg2);
    }

    public void removeItem(int arg2) {
        this.b(arg2);
        this.b.removeItem(arg2);
    }

    public void setGroupCheckable(int arg2, boolean arg3, boolean arg4) {
        this.b.setGroupCheckable(arg2, arg3, arg4);
    }

    public void setGroupEnabled(int arg2, boolean arg3) {
        this.b.setGroupEnabled(arg2, arg3);
    }

    public void setGroupVisible(int arg2, boolean arg3) {
        this.b.setGroupVisible(arg2, arg3);
    }

    public void setQwertyMode(boolean arg2) {
        this.b.setQwertyMode(arg2);
    }

    public int size() {
        return this.b.size();
    }
}

