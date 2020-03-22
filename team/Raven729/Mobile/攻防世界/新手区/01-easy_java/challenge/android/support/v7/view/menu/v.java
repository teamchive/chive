package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.d.a.a;
import android.support.v4.d.a.c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class v extends r implements SubMenu {
    v(Context arg1, c arg2) {
        super(arg1, ((a)arg2));
    }

    public c b() {
        return this.b;
    }

    public void clearHeader() {
        this.b().clearHeader();
    }

    public MenuItem getItem() {
        return this.a(this.b().getItem());
    }

    public SubMenu setHeaderIcon(int arg2) {
        this.b().setHeaderIcon(arg2);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable arg2) {
        this.b().setHeaderIcon(arg2);
        return this;
    }

    public SubMenu setHeaderTitle(int arg2) {
        this.b().setHeaderTitle(arg2);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence arg2) {
        this.b().setHeaderTitle(arg2);
        return this;
    }

    public SubMenu setHeaderView(View arg2) {
        this.b().setHeaderView(arg2);
        return this;
    }

    public SubMenu setIcon(int arg2) {
        this.b().setIcon(arg2);
        return this;
    }

    public SubMenu setIcon(Drawable arg2) {
        this.b().setIcon(arg2);
        return this;
    }
}

