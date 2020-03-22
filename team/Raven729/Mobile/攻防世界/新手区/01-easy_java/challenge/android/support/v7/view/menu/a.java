package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.d.a.b;
import android.support.v4.h.c;
import android.view.ActionProvider;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem$OnActionExpandListener;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class a implements b {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;
    private char h;
    private int i;
    private char j;
    private int k;
    private Drawable l;
    private int m;
    private Context n;
    private MenuItem$OnMenuItemClickListener o;
    private CharSequence p;
    private CharSequence q;
    private ColorStateList r;
    private PorterDuff$Mode s;
    private boolean t;
    private boolean u;
    private int v;

    public a(Context arg4, int arg5, int arg6, int arg7, int arg8, CharSequence arg9) {
        super();
        this.i = 0x1000;
        this.k = 0x1000;
        this.m = 0;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = false;
        this.v = 16;
        this.n = arg4;
        this.a = arg6;
        this.b = arg5;
        this.c = arg7;
        this.d = arg8;
        this.e = arg9;
    }

    public b a(int arg2) {
        throw new UnsupportedOperationException();
    }

    public b a(c arg2) {
        throw new UnsupportedOperationException();
    }

    public b a(View arg2) {
        throw new UnsupportedOperationException();
    }

    public b a(CharSequence arg1) {
        this.p = arg1;
        return this;
    }

    public c a() {
        return null;
    }

    private void b() {
        if(this.l != null && ((this.t) || (this.u))) {
            this.l = android.support.v4.c.a.a.f(this.l);
            this.l = this.l.mutate();
            if(this.t) {
                android.support.v4.c.a.a.a(this.l, this.r);
            }

            if(!this.u) {
                return;
            }

            android.support.v4.c.a.a.a(this.l, this.s);
        }
    }

    public b b(int arg1) {
        this.setShowAsAction(arg1);
        return this;
    }

    public b b(CharSequence arg1) {
        this.q = arg1;
        return this;
    }

    public boolean collapseActionView() {
        return 0;
    }

    public boolean expandActionView() {
        return 0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.k;
    }

    public char getAlphabeticShortcut() {
        return this.j;
    }

    public CharSequence getContentDescription() {
        return this.p;
    }

    public int getGroupId() {
        return this.b;
    }

    public Drawable getIcon() {
        return this.l;
    }

    public ColorStateList getIconTintList() {
        return this.r;
    }

    public PorterDuff$Mode getIconTintMode() {
        return this.s;
    }

    public Intent getIntent() {
        return this.g;
    }

    public int getItemId() {
        return this.a;
    }

    public ContextMenu$ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.i;
    }

    public char getNumericShortcut() {
        return this.h;
    }

    public int getOrder() {
        return this.d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence v0 = this.f != null ? this.f : this.e;
        return v0;
    }

    public CharSequence getTooltipText() {
        return this.q;
    }

    public boolean hasSubMenu() {
        return 0;
    }

    public boolean isActionViewExpanded() {
        return 0;
    }

    public boolean isCheckable() {
        boolean v0 = (this.v & 1) != 0 ? true : false;
        return v0;
    }

    public boolean isChecked() {
        boolean v0 = (this.v & 2) != 0 ? true : false;
        return v0;
    }

    public boolean isEnabled() {
        boolean v0 = (this.v & 16) != 0 ? true : false;
        return v0;
    }

    public boolean isVisible() {
        boolean v0 = (this.v & 8) == 0 ? true : false;
        return v0;
    }

    public MenuItem setActionProvider(ActionProvider arg2) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setActionView(int arg2) {
        return this.a(arg2);
    }

    public MenuItem setActionView(View arg2) {
        return this.a(arg2);
    }

    public MenuItem setAlphabeticShortcut(char arg2) {
        this.j = Character.toLowerCase(arg2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char arg2, int arg3) {
        this.j = Character.toLowerCase(arg2);
        this.k = KeyEvent.normalizeMetaState(arg3);
        return this;
    }

    public MenuItem setCheckable(boolean arg3) {
        int v1 = this.v & -2;
        int v0 = arg3 ? 1 : 0;
        this.v = v0 | v1;
        return this;
    }

    public MenuItem setChecked(boolean arg3) {
        int v1 = this.v & -3;
        int v0 = arg3 ? 2 : 0;
        this.v = v0 | v1;
        return this;
    }

    public MenuItem setContentDescription(CharSequence arg2) {
        return this.a(arg2);
    }

    public MenuItem setEnabled(boolean arg3) {
        int v1 = this.v & -17;
        int v0 = arg3 ? 16 : 0;
        this.v = v0 | v1;
        return this;
    }

    public MenuItem setIcon(int arg2) {
        this.m = arg2;
        this.l = android.support.v4.b.a.a(this.n, arg2);
        this.b();
        return this;
    }

    public MenuItem setIcon(Drawable arg2) {
        this.l = arg2;
        this.m = 0;
        this.b();
        return this;
    }

    public MenuItem setIconTintList(ColorStateList arg2) {
        this.r = arg2;
        this.t = true;
        this.b();
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff$Mode arg2) {
        this.s = arg2;
        this.u = true;
        this.b();
        return this;
    }

    public MenuItem setIntent(Intent arg1) {
        this.g = arg1;
        return this;
    }

    public MenuItem setNumericShortcut(char arg1) {
        this.h = arg1;
        return this;
    }

    public MenuItem setNumericShortcut(char arg2, int arg3) {
        this.h = arg2;
        this.i = KeyEvent.normalizeMetaState(arg3);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem$OnActionExpandListener arg2) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem$OnMenuItemClickListener arg1) {
        this.o = arg1;
        return this;
    }

    public MenuItem setShortcut(char arg2, char arg3) {
        this.h = arg2;
        this.j = Character.toLowerCase(arg3);
        return this;
    }

    public MenuItem setShortcut(char arg2, char arg3, int arg4, int arg5) {
        this.h = arg2;
        this.i = KeyEvent.normalizeMetaState(arg4);
        this.j = Character.toLowerCase(arg3);
        this.k = KeyEvent.normalizeMetaState(arg5);
        return this;
    }

    public void setShowAsAction(int arg1) {
    }

    public MenuItem setShowAsActionFlags(int arg2) {
        return this.b(arg2);
    }

    public MenuItem setTitle(int arg2) {
        this.e = this.n.getResources().getString(arg2);
        return this;
    }

    public MenuItem setTitle(CharSequence arg1) {
        this.e = arg1;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence arg1) {
        this.f = arg1;
        return this;
    }

    public MenuItem setTooltipText(CharSequence arg2) {
        return this.b(arg2);
    }

    public MenuItem setVisible(boolean arg3) {
        int v1 = this.v & 8;
        int v0 = arg3 ? 0 : 8;
        this.v = v0 | v1;
        return this;
    }
}

