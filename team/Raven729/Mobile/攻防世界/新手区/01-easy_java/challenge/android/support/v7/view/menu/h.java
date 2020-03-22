package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.d.a.a;
import android.support.v4.h.c;
import android.util.SparseArray;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.KeyCharacterMap$KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h implements a {
    public interface android.support.v7.view.menu.h$a {
        boolean a(h arg1, MenuItem arg2);

        void a(h arg1);
    }

    public interface b {
        boolean a(j arg1);
    }

    CharSequence a;
    Drawable b;
    View c;
    private static final int[] d;
    private final Context e;
    private final Resources f;
    private boolean g;
    private boolean h;
    private android.support.v7.view.menu.h$a i;
    private ArrayList j;
    private ArrayList k;
    private boolean l;
    private ArrayList m;
    private ArrayList n;
    private boolean o;
    private int p;
    private ContextMenu$ContextMenuInfo q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private ArrayList w;
    private CopyOnWriteArrayList x;
    private j y;
    private boolean z;

    static {
        h.d = new int[]{1, 4, 5, 3, 2, 0};
    }

    public h(Context arg3) {
        super();
        this.p = 0;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = new ArrayList();
        this.x = new CopyOnWriteArrayList();
        this.e = arg3;
        this.f = arg3.getResources();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = true;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = true;
        this.e(true);
    }

    public void a(android.support.v7.view.menu.h$a arg1) {
        this.i = arg1;
    }

    public void a(Bundle arg8) {
        int v3 = this.size();
        int v2 = 0;
        SparseArray v0;
        for(v0 = null; v2 < v3; v0 = v1_1) {
            MenuItem v4 = this.getItem(v2);
            View v1 = v4.getActionView();
            if(v1 != null && v1.getId() != -1) {
                if(v0 == null) {
                    v0 = new SparseArray();
                }

                v1.saveHierarchyState(v0);
                if(!v4.isActionViewExpanded()) {
                    goto label_21;
                }

                arg8.putInt("android:menu:expandedactionview", v4.getItemId());
            }

        label_21:
            SparseArray v1_1 = v0;
            if(v4.hasSubMenu()) {
                v4.getSubMenu().a(arg8);
            }

            ++v2;
        }

        if(v0 != null) {
            arg8.putSparseParcelableArray(this.a(), v0);
        }
    }

    public void a(o arg2) {
        this.a(arg2, this.e);
    }

    public h a(int arg1) {
        this.p = arg1;
        return this;
    }

    public boolean a(MenuItem arg2, int arg3) {
        return this.a(arg2, null, arg3);
    }

    public boolean a(MenuItem arg7, o arg8, int arg9) {
        int v0_1;
        boolean v0 = false;
        if(arg7 != null && (((j)arg7).isEnabled())) {
            boolean v3 = ((j)arg7).b();
            c v4 = ((j)arg7).a();
            int v1 = v4 == null || !v4.e() ? 0 : 1;
            if(((j)arg7).n()) {
                v0_1 = ((j)arg7).expandActionView() | (((int)v3));
                if(v0_1 == 0) {
                    return v0;
                }

                this.a(true);
                return v0;
            }

            if(!((j)arg7).hasSubMenu() && v1 == 0) {
                if((arg9 & 1) == 0) {
                    this.a(true);
                }

                return v3;
            }

            if((arg9 & 4) == 0) {
                this.a(false);
            }

            if(!((j)arg7).hasSubMenu()) {
                ((j)arg7).a(new u(this.e(), this, ((j)arg7)));
            }

            SubMenu v0_2 = ((j)arg7).getSubMenu();
            if(v1 != 0) {
                v4.a(v0_2);
            }

            v0_1 = this.a(((u)v0_2), arg8) | (((int)v3));
            if(v0_1 != 0) {
                return v0;
            }

            this.a(true);
        }

        return v0;
    }

    public void a(o arg3, Context arg4) {
        this.x.add(new WeakReference(arg3));
        arg3.a(arg4, this);
        this.o = true;
    }

    public final void a(boolean arg4) {
        if(!this.v) {
            this.v = true;
            Iterator v2 = this.x.iterator();
            while(v2.hasNext()) {
                Object v0 = v2.next();
                Object v1 = ((WeakReference)v0).get();
                if(v1 == null) {
                    this.x.remove(v0);
                }
                else {
                    ((o)v1).a(this, arg4);
                }
            }

            this.v = false;
        }
    }

    private static int a(ArrayList arg2, int arg3) {
        int v0;
        int v1 = arg2.size() - 1;
        while(true) {
            if(v1 < 0) {
                return 0;
            }
            else if(arg2.get(v1).c() <= arg3) {
                v0 = v1 + 1;
            }
            else {
                --v1;
                continue;
            }

            return v0;
        }

        return 0;
    }

    private j a(int arg9, int arg10, int arg11, int arg12, CharSequence arg13, int arg14) {
        return new j(this, arg9, arg10, arg11, arg12, arg13, arg14);
    }

    private void a(int arg3, CharSequence arg4, int arg5, Drawable arg6, View arg7) {
        CharSequence v1 = null;
        Resources v0 = this.d();
        if(arg7 != null) {
            this.c = arg7;
            this.a = v1;
            this.b = ((Drawable)v1);
        }
        else {
            if(arg3 > 0) {
                this.a = v0.getText(arg3);
            }
            else if(arg4 != null) {
                this.a = arg4;
            }

            if(arg5 > 0) {
                this.b = android.support.v4.b.a.a(this.e(), arg5);
            }
            else if(arg6 != null) {
                this.b = arg6;
            }

            this.c = ((View)v1);
        }

        this.b(false);
    }

    private void a(int arg2, boolean arg3) {
        if(arg2 >= 0 && arg2 < this.j.size()) {
            this.j.remove(arg2);
            if(arg3) {
                this.b(true);
            }
        }
    }

    private boolean a(u arg5, o arg6) {
        boolean v0 = false;
        if(!this.x.isEmpty()) {
            if(arg6 != null) {
                v0 = arg6.a(arg5);
            }

            Iterator v3 = this.x.iterator();
            boolean v2;
            for(v2 = v0; v3.hasNext(); v2 = v0) {
                Object v0_1 = v3.next();
                Object v1 = ((WeakReference)v0_1).get();
                if(v1 == null) {
                    this.x.remove(v0_1);
                    v0 = v2;
                }
                else if(!v2) {
                    v0 = ((o)v1).a(arg5);
                }
                else {
                    v0 = v2;
                }
            }

            v0 = v2;
        }

        return v0;
    }

    public int a(int arg4, int arg5) {
        int v0;
        int v2 = this.size();
        int v1 = 0;
        while(true) {
            if(v1 >= v2) {
                return -1;
            }
            else if(this.j.get(v1).getGroupId() == arg4) {
                v0 = v1;
            }
            else {
                ++v1;
                continue;
            }

            return v0;
        }

        return -1;
    }

    protected h a(Drawable arg7) {
        this.a(0, null, 0, arg7, null);
        return this;
    }

    protected h a(View arg7) {
        this.a(0, null, 0, null, arg7);
        return this;
    }

    protected h a(CharSequence arg7) {
        this.a(0, arg7, 0, null, null);
        return this;
    }

    j a(int arg13, KeyEvent arg14) {
        Object v0_1;
        j v0;
        j v2 = null;
        ArrayList v5 = this.w;
        v5.clear();
        this.a(((List)v5), arg13, arg14);
        if(v5.isEmpty()) {
            v0 = v2;
        }
        else {
            int v6 = arg14.getMetaState();
            KeyCharacterMap$KeyData v7 = new KeyCharacterMap$KeyData();
            arg14.getKeyData(v7);
            int v8 = v5.size();
            if(v8 == 1) {
                v0_1 = v5.get(0);
            }
            else {
                boolean v9 = this.b();
                int v3;
                for(v3 = 0; v3 < v8; ++v3) {
                    v0_1 = v5.get(v3);
                    int v1 = v9 ? ((j)v0_1).getAlphabeticShortcut() : ((j)v0_1).getNumericShortcut();
                    if(v1 == v7.meta[0] && (v6 & 2) == 0) {
                        goto label_8;
                    }

                    if(v1 == v7.meta[2] && (v6 & 2) != 0) {
                        goto label_8;
                    }

                    if((v9) && v1 == 8 && arg13 == 67) {
                        goto label_8;
                    }
                }

                v0 = v2;
            }
        }

    label_8:
        return ((j)v0_1);
    }

    void a(List arg13, int arg14, KeyEvent arg15) {
        int v11 = 0x1100F;
        int v10 = 67;
        boolean v5 = this.b();
        int v6 = arg15.getModifiers();
        KeyCharacterMap$KeyData v7 = new KeyCharacterMap$KeyData();
        if((arg15.getKeyData(v7)) || arg14 == v10) {
            int v8 = this.j.size();
            int v4;
            for(v4 = 0; v4 < v8; ++v4) {
                Object v0 = this.j.get(v4);
                if(((j)v0).hasSubMenu()) {
                    ((j)v0).getSubMenu().a(arg13, arg14, arg15);
                }

                int v3 = v5 ? ((j)v0).getAlphabeticShortcut() : ((j)v0).getNumericShortcut();
                int v1 = v5 ? ((j)v0).getAlphabeticModifiers() : ((j)v0).getNumericModifiers();
                v1 = (v6 & v11) == (v1 & v11) ? 1 : 0;
                if(v1 != 0 && v3 != 0) {
                    if(v3 != v7.meta[0] && v3 != v7.meta[2]) {
                        if(!v5) {
                        }
                        else if(v3 != 8) {
                        }
                        else if(arg14 == v10) {
                            goto label_43;
                        }

                        goto label_46;
                    }

                label_43:
                    if(!((j)v0).isEnabled()) {
                        goto label_46;
                    }

                    arg13.add(v0);
                }

            label_46:
            }
        }
    }

    protected MenuItem a(int arg8, int arg9, int arg10, CharSequence arg11) {
        int v4 = h.f(arg10);
        j v0 = this.a(arg8, arg9, arg10, v4, arg11, this.p);
        if(this.q != null) {
            v0.a(this.q);
        }

        this.j.add(h.a(this.j, v4), v0);
        this.b(true);
        return ((MenuItem)v0);
    }

    protected String a() {
        return "android:menu:actionviewstates";
    }

    void a(j arg2) {
        this.l = true;
        this.b(true);
    }

    void a(MenuItem arg7) {
        int v4 = arg7.getGroupId();
        int v5 = this.j.size();
        this.g();
        int v3;
        for(v3 = 0; v3 < v5; ++v3) {
            Object v0 = this.j.get(v3);
            if(((j)v0).getGroupId() == v4 && (((j)v0).g()) && (((j)v0).isCheckable())) {
                boolean v1 = (((MenuItem)v0)) == arg7 ? true : false;
                ((j)v0).b(v1);
            }
        }

        this.h();
    }

    boolean a(h arg2, MenuItem arg3) {
        boolean v0 = this.i == null || !this.i.a(arg2, arg3) ? false : true;
        return v0;
    }

    public MenuItem add(int arg3) {
        return this.a(0, 0, 0, this.f.getString(arg3));
    }

    public MenuItem add(int arg2, int arg3, int arg4, int arg5) {
        return this.a(arg2, arg3, arg4, this.f.getString(arg5));
    }

    public MenuItem add(int arg2, int arg3, int arg4, CharSequence arg5) {
        return this.a(arg2, arg3, arg4, arg5);
    }

    public MenuItem add(CharSequence arg2) {
        return this.a(0, 0, 0, arg2);
    }

    public int addIntentOptions(int arg10, int arg11, int arg12, ComponentName arg13, Intent[] arg14, Intent arg15, int arg16, MenuItem[] arg17) {
        PackageManager v4 = this.e.getPackageManager();
        List v5 = v4.queryIntentActivityOptions(arg13, arg14, arg15, 0);
        int v3 = v5 != null ? v5.size() : 0;
        if((arg16 & 1) == 0) {
            this.removeGroup(arg10);
        }

        int v2;
        for(v2 = 0; v2 < v3; ++v2) {
            Object v0 = v5.get(v2);
            Intent v1 = ((ResolveInfo)v0).specificIndex < 0 ? arg15 : arg14[((ResolveInfo)v0).specificIndex];
            Intent v6 = new Intent(v1);
            v6.setComponent(new ComponentName(((ResolveInfo)v0).activityInfo.applicationInfo.packageName, ((ResolveInfo)v0).activityInfo.name));
            MenuItem v1_1 = this.add(arg10, arg11, arg12, ((ResolveInfo)v0).loadLabel(v4)).setIcon(((ResolveInfo)v0).loadIcon(v4)).setIntent(v6);
            if(arg17 != null && ((ResolveInfo)v0).specificIndex >= 0) {
                arg17[((ResolveInfo)v0).specificIndex] = v1_1;
            }
        }

        return v3;
    }

    public SubMenu addSubMenu(int arg3) {
        return this.addSubMenu(0, 0, 0, this.f.getString(arg3));
    }

    public SubMenu addSubMenu(int arg4, int arg5, int arg6, CharSequence arg7) {
        MenuItem v0 = this.a(arg4, arg5, arg6, arg7);
        u v1 = new u(this.e, this, ((j)v0));
        ((j)v0).a(v1);
        return ((SubMenu)v1);
    }

    public SubMenu addSubMenu(int arg2, int arg3, int arg4, int arg5) {
        return this.addSubMenu(arg2, arg3, arg4, this.f.getString(arg5));
    }

    public SubMenu addSubMenu(CharSequence arg2) {
        return this.addSubMenu(0, 0, 0, arg2);
    }

    public void b(Bundle arg8) {
        MenuItem v0;
        if(arg8 != null) {
            SparseArray v2 = arg8.getSparseParcelableArray(this.a());
            int v3 = this.size();
            int v1;
            for(v1 = 0; v1 < v3; ++v1) {
                v0 = this.getItem(v1);
                View v4 = v0.getActionView();
                if(v4 != null && v4.getId() != -1) {
                    v4.restoreHierarchyState(v2);
                }

                if(v0.hasSubMenu()) {
                    v0.getSubMenu().b(arg8);
                }
            }

            int v0_1 = arg8.getInt("android:menu:expandedactionview");
            if(v0_1 <= 0) {
                return;
            }

            v0 = this.findItem(v0_1);
            if(v0 == null) {
                return;
            }

            v0.expandActionView();
        }
    }

    public void b(o arg4) {
        Iterator v2 = this.x.iterator();
        while(v2.hasNext()) {
            Object v0 = v2.next();
            Object v1 = ((WeakReference)v0).get();
            if(v1 != null && (((o)v1)) != arg4) {
                continue;
            }

            this.x.remove(v0);
        }
    }

    public void b(boolean arg3) {
        if(!this.r) {
            if(arg3) {
                this.l = true;
                this.o = true;
            }

            this.d(arg3);
        }
        else {
            this.s = true;
            if(!arg3) {
                return;
            }

            this.t = true;
        }
    }

    boolean b() {
        return this.g;
    }

    public int b(int arg4) {
        int v0;
        int v2 = this.size();
        int v1 = 0;
        while(true) {
            if(v1 >= v2) {
                return -1;
            }
            else if(this.j.get(v1).getItemId() == arg4) {
                v0 = v1;
            }
            else {
                ++v1;
                continue;
            }

            return v0;
        }

        return -1;
    }

    void b(j arg2) {
        this.o = true;
        this.b(true);
    }

    public void c(boolean arg1) {
        this.z = arg1;
    }

    public int c(int arg2) {
        return this.a(arg2, 0);
    }

    public boolean c() {
        return this.h;
    }

    public boolean c(j arg5) {
        boolean v0 = false;
        if(!this.x.isEmpty()) {
            this.g();
            Iterator v3 = this.x.iterator();
            boolean v2;
            for(v2 = false; v3.hasNext(); v2 = v0) {
                Object v0_1 = v3.next();
                Object v1 = ((WeakReference)v0_1).get();
                if(v1 == null) {
                    this.x.remove(v0_1);
                    v0 = v2;
                }
                else {
                    v0 = ((o)v1).a(this, arg5);
                    if(!v0) {
                        goto label_17;
                    }

                    goto label_21;
                }

            label_17:
            }

            v0 = v2;
        label_21:
            this.h();
            if(!v0) {
                return v0;
            }

            this.y = arg5;
        }

        return v0;
    }

    public void clear() {
        if(this.y != null) {
            this.d(this.y);
        }

        this.j.clear();
        this.b(true);
    }

    public void clearHeader() {
        this.b = null;
        this.a = null;
        this.c = null;
        this.b(false);
    }

    public void close() {
        this.a(true);
    }

    Resources d() {
        return this.f;
    }

    private void d(boolean arg4) {
        if(!this.x.isEmpty()) {
            this.g();
            Iterator v2 = this.x.iterator();
            while(v2.hasNext()) {
                Object v0 = v2.next();
                Object v1 = ((WeakReference)v0).get();
                if(v1 == null) {
                    this.x.remove(v0);
                }
                else {
                    ((o)v1).b(arg4);
                }
            }

            this.h();
        }
    }

    public boolean d(j arg5) {
        boolean v0 = false;
        if(!this.x.isEmpty() && this.y == arg5) {
            this.g();
            Iterator v3 = this.x.iterator();
            boolean v2;
            for(v2 = false; v3.hasNext(); v2 = v0) {
                Object v0_1 = v3.next();
                Object v1 = ((WeakReference)v0_1).get();
                if(v1 == null) {
                    this.x.remove(v0_1);
                    v0 = v2;
                }
                else {
                    v0 = ((o)v1).b(this, arg5);
                    if(!v0) {
                        goto label_19;
                    }

                    goto label_23;
                }

            label_19:
            }

            v0 = v2;
        label_23:
            this.h();
            if(!v0) {
                return v0;
            }

            this.y = null;
        }

        return v0;
    }

    protected h d(int arg7) {
        this.a(arg7, null, 0, null, null);
        return this;
    }

    private void e(boolean arg4) {
        boolean v0 = true;
        if(!arg4 || this.f.getConfiguration().keyboard == 1 || !this.f.getBoolean(android.support.v7.a.a$b.abc_config_showMenuShortcutsWhenKeyboardPresent)) {
            v0 = false;
        }

        this.h = v0;
    }

    public Context e() {
        return this.e;
    }

    protected h e(int arg7) {
        this.a(0, null, arg7, null, null);
        return this;
    }

    private static int f(int arg2) {
        int v0 = (0xFFFF0000 & arg2) >> 16;
        if(v0 >= 0 && v0 < h.d.length) {
            return h.d[v0] << 16 | 0xFFFF & arg2;
        }

        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public void f() {
        if(this.i != null) {
            this.i.a(this);
        }
    }

    public MenuItem findItem(int arg5) {
        MenuItem v0_1;
        Object v0;
        int v2 = this.size();
        int v1 = 0;
        while(true) {
            if(v1 < v2) {
                v0 = this.j.get(v1);
                if(((j)v0).getItemId() != arg5) {
                    if(((j)v0).hasSubMenu()) {
                        v0_1 = ((j)v0).getSubMenu().findItem(arg5);
                        if(v0_1 == null) {
                            goto label_14;
                        }

                        goto label_8;
                    }

                label_14:
                    ++v1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_8;
        }

        v0_1 = null;
    label_8:
        return ((MenuItem)v0);
    }

    public void g() {
        if(!this.r) {
            this.r = true;
            this.s = false;
            this.t = false;
        }
    }

    public MenuItem getItem(int arg2) {
        return this.j.get(arg2);
    }

    public void h() {
        this.r = false;
        if(this.s) {
            this.s = false;
            this.b(this.t);
        }
    }

    public boolean hasVisibleItems() {
        boolean v0;
        if(this.z) {
            v0 = true;
        }
        else {
            int v4 = this.size();
            int v3 = 0;
            while(true) {
                if(v3 >= v4) {
                    break;
                }
                else if(this.j.get(v3).isVisible()) {
                    v0 = true;
                }
                else {
                    ++v3;
                    continue;
                }

                return v0;
            }

            v0 = false;
        }

        return v0;
    }

    public ArrayList i() {
        ArrayList v0;
        if(!this.l) {
            v0 = this.k;
        }
        else {
            this.k.clear();
            int v3 = this.j.size();
            int v1;
            for(v1 = 0; v1 < v3; ++v1) {
                Object v0_1 = this.j.get(v1);
                if(((j)v0_1).isVisible()) {
                    this.k.add(v0_1);
                }
            }

            this.l = false;
            this.o = true;
            v0 = this.k;
        }

        return v0;
    }

    public boolean isShortcutKey(int arg2, KeyEvent arg3) {
        boolean v0 = this.a(arg2, arg3) != null ? true : false;
        return v0;
    }

    public void j() {
        int v1_1;
        int v0_1;
        Object v0;
        ArrayList v4 = this.i();
        if(this.o) {
            Iterator v5 = this.x.iterator();
            int v2;
            for(v2 = 0; v5.hasNext(); v2 = v0_1) {
                v0 = v5.next();
                Object v1 = ((WeakReference)v0).get();
                if(v1 == null) {
                    this.x.remove(v0);
                    v0_1 = v2;
                }
                else {
                    v0_1 = ((o)v1).b() | v2;
                }
            }

            if(v2 != 0) {
                this.m.clear();
                this.n.clear();
                v2 = v4.size();
                v1_1 = 0;
                goto label_28;
            }
            else {
                this.m.clear();
                this.n.clear();
                this.n.addAll(this.i());
                goto label_47;
            label_28:
                while(v1_1 < v2) {
                    v0 = v4.get(v1_1);
                    if(((j)v0).j()) {
                        this.m.add(v0);
                    }
                    else {
                        this.n.add(v0);
                    }

                    ++v1_1;
                }
            }

        label_47:
            this.o = false;
        }
    }

    public ArrayList k() {
        this.j();
        return this.m;
    }

    public ArrayList l() {
        this.j();
        return this.n;
    }

    public CharSequence m() {
        return this.a;
    }

    public Drawable n() {
        return this.b;
    }

    public View o() {
        return this.c;
    }

    public h p() {
        return this;
    }

    public boolean performIdentifierAction(int arg2, int arg3) {
        return this.a(this.findItem(arg2), arg3);
    }

    public boolean performShortcut(int arg3, KeyEvent arg4, int arg5) {
        j v1 = this.a(arg3, arg4);
        boolean v0 = false;
        if(v1 != null) {
            v0 = this.a(((MenuItem)v1), arg5);
        }

        if((arg5 & 2) != 0) {
            this.a(true);
        }

        return v0;
    }

    boolean q() {
        return this.u;
    }

    public j r() {
        return this.y;
    }

    public void removeGroup(int arg6) {
        int v3 = this.c(arg6);
        if(v3 >= 0) {
            int v4 = this.j.size() - v3;
            int v0 = 0;
            while(true) {
                int v2 = v0 + 1;
                if(v0 < v4 && this.j.get(v3).getGroupId() == arg6) {
                    this.a(v3, false);
                    v0 = v2;
                    continue;
                }

                break;
            }

            this.b(true);
        }
    }

    public void removeItem(int arg3) {
        this.a(this.b(arg3), true);
    }

    public void setGroupCheckable(int arg5, boolean arg6, boolean arg7) {
        int v2 = this.j.size();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            Object v0 = this.j.get(v1);
            if(((j)v0).getGroupId() == arg5) {
                ((j)v0).a(arg7);
                ((j)v0).setCheckable(arg6);
            }
        }
    }

    public void setGroupEnabled(int arg5, boolean arg6) {
        int v2 = this.j.size();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            Object v0 = this.j.get(v1);
            if(((j)v0).getGroupId() == arg5) {
                ((j)v0).setEnabled(arg6);
            }
        }
    }

    public void setGroupVisible(int arg7, boolean arg8) {
        int v4 = this.j.size();
        int v3 = 0;
        int v2;
        for(v2 = 0; v3 < v4; v2 = v0_1) {
            Object v0 = this.j.get(v3);
            int v0_1 = ((j)v0).getGroupId() != arg7 || !((j)v0).c(arg8) ? v2 : 1;
            ++v3;
        }

        if(v2 != 0) {
            this.b(true);
        }
    }

    public void setQwertyMode(boolean arg2) {
        this.g = arg2;
        this.b(false);
    }

    public int size() {
        return this.j.size();
    }
}

