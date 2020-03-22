package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.v4.d.a.b;
import android.support.v4.h.c;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem$OnActionExpandListener;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug$CapturedViewProperty;
import android.widget.LinearLayout;

public final class j implements b {
    private View A;
    private c B;
    private MenuItem$OnActionExpandListener C;
    private boolean D;
    private ContextMenu$ContextMenuInfo E;
    private static String F;
    private static String G;
    private static String H;
    private static String I;
    h a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private CharSequence f;
    private CharSequence g;
    private Intent h;
    private char i;
    private int j;
    private char k;
    private int l;
    private Drawable m;
    private int n;
    private u o;
    private Runnable p;
    private MenuItem$OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private ColorStateList t;
    private PorterDuff$Mode u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private int z;

    j(h arg4, int arg5, int arg6, int arg7, int arg8, CharSequence arg9, int arg10) {
        super();
        this.j = 0x1000;
        this.l = 0x1000;
        this.n = 0;
        this.t = null;
        this.u = null;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = 16;
        this.z = 0;
        this.D = false;
        this.a = arg4;
        this.b = arg6;
        this.c = arg5;
        this.d = arg7;
        this.e = arg8;
        this.f = arg9;
        this.z = arg10;
    }

    public void a(boolean arg3) {
        int v1 = this.y & -5;
        int v0 = arg3 ? 4 : 0;
        this.y = v0 | v1;
    }

    CharSequence a(a arg2) {
        CharSequence v0 = arg2 == null || !arg2.a() ? this.getTitle() : this.getTitleCondensed();
        return v0;
    }

    void a(ContextMenu$ContextMenuInfo arg1) {
        this.E = arg1;
    }

    public c a() {
        return this.B;
    }

    public void a(u arg2) {
        this.o = arg2;
        arg2.setHeaderTitle(this.getTitle());
    }

    private Drawable a(Drawable arg2) {
        if(arg2 != null && (this.x) && ((this.v) || (this.w))) {
            arg2 = android.support.v4.c.a.a.f(arg2).mutate();
            if(this.v) {
                android.support.v4.c.a.a.a(arg2, this.t);
            }

            if(this.w) {
                android.support.v4.c.a.a.a(arg2, this.u);
            }

            this.x = false;
        }

        return arg2;
    }

    public b a(int arg4) {
        Context v0 = this.a.e();
        this.a(LayoutInflater.from(v0).inflate(arg4, new LinearLayout(v0), false));
        return this;
    }

    public b a(View arg3) {
        this.A = arg3;
        this.B = null;
        if(arg3 != null && arg3.getId() == -1 && this.b > 0) {
            arg3.setId(this.b);
        }

        this.a.b(this);
        return this;
    }

    public b a(c arg3) {
        if(this.B != null) {
            this.B.f();
        }

        this.A = null;
        this.B = arg3;
        this.a.b(true);
        if(this.B != null) {
            this.B.a(new android.support.v4.h.c$b() {
                public void a(boolean arg3) {
                    this.a.a.a(this.a);
                }
            });
        }

        return this;
    }

    public b a(CharSequence arg3) {
        this.r = arg3;
        this.a.b(false);
        return this;
    }

    void b(boolean arg5) {
        int v2 = this.y;
        int v3 = this.y & -3;
        int v0 = arg5 ? 2 : 0;
        this.y = v0 | v3;
        if(v2 != this.y) {
            this.a.b(false);
        }
    }

    public boolean b() {
        boolean v0 = true;
        if((this.q == null || !this.q.onMenuItemClick(((MenuItem)this))) && !this.a.a(this.a, ((MenuItem)this))) {
            if(this.p != null) {
                this.p.run();
                return v0;
            }

            if(this.h != null) {
                try {
                    this.a.e().startActivity(this.h);
                    return v0;
                }
                catch(ActivityNotFoundException v1) {
                    Log.e("MenuItemImpl", "Can\'t find activity to handle intent; ignoring", ((Throwable)v1));
                }
            }

            if(this.B == null || !this.B.d()) {
                v0 = false;
            }
        }

        return v0;
    }

    public b b(int arg1) {
        this.setShowAsAction(arg1);
        return this;
    }

    public b b(CharSequence arg3) {
        this.s = arg3;
        this.a.b(false);
        return this;
    }

    public int c() {
        return this.e;
    }

    boolean c(boolean arg5) {
        boolean v1 = false;
        int v2 = this.y;
        int v3 = this.y & -9;
        int v0 = arg5 ? 0 : 8;
        this.y = v0 | v3;
        if(v2 != this.y) {
            v1 = true;
        }

        return v1;
    }

    public boolean collapseActionView() {
        boolean v0 = false;
        if((this.z & 8) != 0) {
            if(this.A == null) {
                v0 = true;
            }
            else {
                if(this.C != null && !this.C.onMenuItemActionCollapse(((MenuItem)this))) {
                    return v0;
                }

                v0 = this.a.d(this);
            }
        }

        return v0;
    }

    char d() {
        char v0 = this.a.b() ? this.k : this.i;
        return v0;
    }

    public void d(boolean arg2) {
        if(arg2) {
            this.y |= 0x20;
        }
        else {
            this.y &= -33;
        }
    }

    String e() {
        String v0_1;
        char v0 = this.d();
        if(v0 == 0) {
            v0_1 = "";
        }
        else {
            StringBuilder v1 = new StringBuilder(j.F);
            switch(v0) {
                case 8: {
                    v1.append(j.H);
                    break;
                }
                case 10: {
                    v1.append(j.G);
                    break;
                }
                case 32: {
                    v1.append(j.I);
                    break;
                }
                default: {
                    v1.append(v0);
                    break;
                }
            }

            v0_1 = v1.toString();
        }

        return v0_1;
    }

    public void e(boolean arg3) {
        this.D = arg3;
        this.a.b(false);
    }

    public boolean expandActionView() {
        boolean v0 = false;
        if((this.n()) && (this.C == null || (this.C.onMenuItemActionExpand(((MenuItem)this))))) {
            v0 = this.a.c(this);
        }

        return v0;
    }

    boolean f() {
        boolean v0 = !this.a.c() || this.d() == 0 ? false : true;
        return v0;
    }

    public boolean g() {
        boolean v0 = (this.y & 4) != 0 ? true : false;
        return v0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View v0;
        if(this.A != null) {
            v0 = this.A;
        }
        else if(this.B != null) {
            this.A = this.B.a(((MenuItem)this));
            v0 = this.A;
        }
        else {
            v0 = null;
        }

        return v0;
    }

    public int getAlphabeticModifiers() {
        return this.l;
    }

    public char getAlphabeticShortcut() {
        return this.k;
    }

    public CharSequence getContentDescription() {
        return this.r;
    }

    public int getGroupId() {
        return this.c;
    }

    public Drawable getIcon() {
        Drawable v0;
        if(this.m != null) {
            v0 = this.a(this.m);
        }
        else if(this.n != 0) {
            v0 = android.support.v7.b.a.b.b(this.a.e(), this.n);
            this.n = 0;
            this.m = v0;
            v0 = this.a(v0);
        }
        else {
            v0 = null;
        }

        return v0;
    }

    public ColorStateList getIconTintList() {
        return this.t;
    }

    public PorterDuff$Mode getIconTintMode() {
        return this.u;
    }

    public Intent getIntent() {
        return this.h;
    }

    @ViewDebug$CapturedViewProperty public int getItemId() {
        return this.b;
    }

    public ContextMenu$ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public int getNumericModifiers() {
        return this.j;
    }

    public char getNumericShortcut() {
        return this.i;
    }

    public int getOrder() {
        return this.d;
    }

    public SubMenu getSubMenu() {
        return this.o;
    }

    @ViewDebug$CapturedViewProperty public CharSequence getTitle() {
        return this.f;
    }

    public CharSequence getTitleCondensed() {
        String v0_1;
        CharSequence v0 = this.g != null ? this.g : this.f;
        if(Build$VERSION.SDK_INT < 18 && v0 != null && !(v0 instanceof String)) {
            v0_1 = v0.toString();
        }

        return ((CharSequence)v0_1);
    }

    public CharSequence getTooltipText() {
        return this.s;
    }

    public void h() {
        this.a.b(this);
    }

    public boolean hasSubMenu() {
        boolean v0 = this.o != null ? true : false;
        return v0;
    }

    public boolean i() {
        return this.a.q();
    }

    public boolean isActionViewExpanded() {
        return this.D;
    }

    public boolean isCheckable() {
        boolean v0 = true;
        if((this.y & 1) != 1) {
            v0 = false;
        }

        return v0;
    }

    public boolean isChecked() {
        boolean v0 = (this.y & 2) == 2 ? true : false;
        return v0;
    }

    public boolean isEnabled() {
        boolean v0 = (this.y & 16) != 0 ? true : false;
        return v0;
    }

    public boolean isVisible() {
        boolean v0 = true;
        if(this.B == null || !this.B.b()) {
            if((this.y & 8) == 0) {
                return v0;
            }

            v0 = false;
        }
        else {
            if((this.y & 8) == 0 && (this.B.c())) {
                return v0;
            }

            v0 = false;
        }

        return v0;
    }

    public boolean j() {
        boolean v0 = (this.y & 0x20) == 0x20 ? true : false;
        return v0;
    }

    public boolean k() {
        boolean v0 = true;
        if((this.z & 1) != 1) {
            v0 = false;
        }

        return v0;
    }

    public boolean l() {
        boolean v0 = (this.z & 2) == 2 ? true : false;
        return v0;
    }

    public boolean m() {
        boolean v0 = (this.z & 4) == 4 ? true : false;
        return v0;
    }

    public boolean n() {
        boolean v0 = false;
        if((this.z & 8) != 0) {
            if(this.A == null && this.B != null) {
                this.A = this.B.a(((MenuItem)this));
            }

            if(this.A == null) {
                return v0;
            }

            v0 = true;
        }

        return v0;
    }

    public MenuItem setActionProvider(ActionProvider arg3) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setActionView(int arg2) {
        return this.a(arg2);
    }

    public MenuItem setActionView(View arg2) {
        return this.a(arg2);
    }

    public MenuItem setAlphabeticShortcut(char arg3) {
        if(this.k != arg3) {
            this.k = Character.toLowerCase(arg3);
            this.a.b(false);
        }

        return this;
    }

    public MenuItem setAlphabeticShortcut(char arg3, int arg4) {
        if(this.k != arg3 || this.l != arg4) {
            this.k = Character.toLowerCase(arg3);
            this.l = KeyEvent.normalizeMetaState(arg4);
            this.a.b(false);
        }

        return this;
    }

    public MenuItem setCheckable(boolean arg5) {
        int v2 = this.y;
        int v3 = this.y & -2;
        int v0 = arg5 ? 1 : 0;
        this.y = v0 | v3;
        if(v2 != this.y) {
            this.a.b(false);
        }

        return this;
    }

    public MenuItem setChecked(boolean arg2) {
        if((this.y & 4) != 0) {
            this.a.a(((MenuItem)this));
        }
        else {
            this.b(arg2);
        }

        return this;
    }

    public MenuItem setContentDescription(CharSequence arg2) {
        return this.a(arg2);
    }

    public MenuItem setEnabled(boolean arg3) {
        if(arg3) {
            this.y |= 16;
        }
        else {
            this.y &= -17;
        }

        this.a.b(false);
        return this;
    }

    public MenuItem setIcon(int arg3) {
        this.m = null;
        this.n = arg3;
        this.x = true;
        this.a.b(false);
        return this;
    }

    public MenuItem setIcon(Drawable arg3) {
        this.n = 0;
        this.m = arg3;
        this.x = true;
        this.a.b(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList arg3) {
        this.t = arg3;
        this.v = true;
        this.x = true;
        this.a.b(false);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff$Mode arg3) {
        this.u = arg3;
        this.w = true;
        this.x = true;
        this.a.b(false);
        return this;
    }

    public MenuItem setIntent(Intent arg1) {
        this.h = arg1;
        return this;
    }

    public MenuItem setNumericShortcut(char arg3) {
        if(this.i != arg3) {
            this.i = arg3;
            this.a.b(false);
        }

        return this;
    }

    public MenuItem setNumericShortcut(char arg3, int arg4) {
        if(this.i != arg3 || this.j != arg4) {
            this.i = arg3;
            this.j = KeyEvent.normalizeMetaState(arg4);
            this.a.b(false);
        }

        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem$OnActionExpandListener arg1) {
        this.C = arg1;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem$OnMenuItemClickListener arg1) {
        this.q = arg1;
        return this;
    }

    public MenuItem setShortcut(char arg3, char arg4) {
        this.i = arg3;
        this.k = Character.toLowerCase(arg4);
        this.a.b(false);
        return this;
    }

    public MenuItem setShortcut(char arg3, char arg4, int arg5, int arg6) {
        this.i = arg3;
        this.j = KeyEvent.normalizeMetaState(arg5);
        this.k = Character.toLowerCase(arg4);
        this.l = KeyEvent.normalizeMetaState(arg6);
        this.a.b(false);
        return this;
    }

    public void setShowAsAction(int arg3) {
        switch(arg3 & 3) {
            case 0: 
            case 1: 
            case 2: {
                goto label_6;
            }
        }

        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    label_6:
        this.z = arg3;
        this.a.b(this);
    }

    public MenuItem setShowAsActionFlags(int arg2) {
        return this.b(arg2);
    }

    public MenuItem setTitle(int arg2) {
        return this.setTitle(this.a.e().getString(arg2));
    }

    public MenuItem setTitle(CharSequence arg3) {
        this.f = arg3;
        this.a.b(false);
        if(this.o != null) {
            this.o.setHeaderTitle(arg3);
        }

        return this;
    }

    public MenuItem setTitleCondensed(CharSequence arg3) {
        this.g = arg3;
        this.a.b(false);
        return this;
    }

    public MenuItem setTooltipText(CharSequence arg2) {
        return this.b(arg2);
    }

    public MenuItem setVisible(boolean arg2) {
        if(this.c(arg2)) {
            this.a.a(this);
        }

        return this;
    }

    public String toString() {
        String v0 = this.f != null ? this.f.toString() : null;
        return v0;
    }
}

