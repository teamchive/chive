package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff$Mode;
import android.support.v4.h.c;
import android.support.v7.a.a$j;
import android.support.v7.view.menu.k;
import android.support.v7.widget.ae;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g extends MenuInflater {
    class a implements MenuItem$OnMenuItemClickListener {
        private static final Class[] a;
        private Object b;
        private Method c;

        static {
            a.a = new Class[]{MenuItem.class};
        }

        public a(Object arg6, String arg7) {
            super();
            this.b = arg6;
            Class v1 = arg6.getClass();
            try {
                this.c = v1.getMethod(arg7, a.a);
                return;
            }
            catch(Exception v0) {
                InflateException v2 = new InflateException("Couldn\'t resolve menu item onClick handler " + arg7 + " in class " + v1.getName());
                v2.initCause(((Throwable)v0));
                throw v2;
            }
        }

        public boolean onMenuItemClick(MenuItem arg6) {
            boolean v0 = true;
            try {
                if(this.c.getReturnType() == Boolean.TYPE) {
                    v0 = this.c.invoke(this.b, arg6).booleanValue();
                }
                else {
                    this.c.invoke(this.b, arg6);
                }

                return v0;
            }
            catch(Exception v0_1) {
                throw new RuntimeException(((Throwable)v0_1));
            }
        }
    }

    class b {
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E;
        private PorterDuff$Mode F;
        c a;
        private Menu c;
        private int d;
        private int e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private int l;
        private CharSequence m;
        private CharSequence n;
        private int o;
        private char p;
        private int q;
        private char r;
        private int s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private int x;
        private int y;
        private String z;

        public b(g arg2, Menu arg3) {
            this.b = arg2;
            super();
            this.E = null;
            this.F = null;
            this.c = arg3;
            this.a();
        }

        public void a(AttributeSet arg5) {
            TypedArray v0 = this.b.e.obtainStyledAttributes(arg5, j.MenuGroup);
            this.d = v0.getResourceId(j.MenuGroup_android_id, 0);
            this.e = v0.getInt(j.MenuGroup_android_menuCategory, 0);
            this.f = v0.getInt(j.MenuGroup_android_orderInCategory, 0);
            this.g = v0.getInt(j.MenuGroup_android_checkableBehavior, 0);
            this.h = v0.getBoolean(j.MenuGroup_android_visible, true);
            this.i = v0.getBoolean(j.MenuGroup_android_enabled, true);
            v0.recycle();
        }

        public void a() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = true;
            this.i = true;
        }

        private char a(String arg2) {
            char v0 = '\u0000';
            if(arg2 != null) {
                v0 = arg2.charAt(0);
            }

            return v0;
        }

        private Object a(String arg5, Class[] arg6, Object[] arg7) {
            Object v0_2;
            try {
                Constructor v0_1 = this.b.e.getClassLoader().loadClass(arg5).getConstructor(arg6);
                v0_1.setAccessible(true);
                v0_2 = v0_1.newInstance(arg7);
            }
            catch(Exception v0) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + arg5, ((Throwable)v0));
                v0_2 = null;
            }

            return v0_2;
        }

        private void a(MenuItem arg6) {
            int v1 = 1;
            MenuItem v3 = arg6.setChecked(this.u).setVisible(this.v).setEnabled(this.w);
            boolean v0 = this.t >= 1 ? true : false;
            v3.setCheckable(v0).setTitleCondensed(this.n).setIcon(this.o);
            if(this.x >= 0) {
                arg6.setShowAsAction(this.x);
            }

            if(this.B != null) {
                if(this.b.e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                else {
                    arg6.setOnMenuItemClickListener(new a(this.b.a(), this.B));
                }
            }

            if(this.t >= 2) {
                if((arg6 instanceof android.support.v7.view.menu.j)) {
                    arg6.a(true);
                }
                else if((arg6 instanceof k)) {
                    arg6.a(true);
                }
            }

            if(this.z != null) {
                arg6.setActionView(this.a(this.z, g.a, this.b.c));
            }
            else {
                v1 = 0;
            }

            if(this.y > 0) {
                if(v1 == 0) {
                    arg6.setActionView(this.y);
                }
                else {
                    Log.w("SupportMenuInflater", "Ignoring attribute \'itemActionViewLayout\'. Action view already specified.");
                }
            }

            if(this.a != null) {
                android.support.v4.h.g.a(arg6, this.a);
            }

            android.support.v4.h.g.a(arg6, this.C);
            android.support.v4.h.g.b(arg6, this.D);
            android.support.v4.h.g.b(arg6, this.p, this.q);
            android.support.v4.h.g.a(arg6, this.r, this.s);
            if(this.F != null) {
                android.support.v4.h.g.a(arg6, this.F);
            }

            if(this.E != null) {
                android.support.v4.h.g.a(arg6, this.E);
            }
        }

        public void b(AttributeSet arg10) {
            int v1 = 1;
            int v7 = -1;
            c v6 = null;
            TypedArray v3 = this.b.e.obtainStyledAttributes(arg10, j.MenuItem);
            this.k = v3.getResourceId(j.MenuItem_android_id, 0);
            this.l = v3.getInt(j.MenuItem_android_menuCategory, this.e) & 0xFFFF0000 | v3.getInt(j.MenuItem_android_orderInCategory, this.f) & 0xFFFF;
            this.m = v3.getText(j.MenuItem_android_title);
            this.n = v3.getText(j.MenuItem_android_titleCondensed);
            this.o = v3.getResourceId(j.MenuItem_android_icon, 0);
            this.p = this.a(v3.getString(j.MenuItem_android_alphabeticShortcut));
            this.q = v3.getInt(j.MenuItem_alphabeticModifiers, 0x1000);
            this.r = this.a(v3.getString(j.MenuItem_android_numericShortcut));
            this.s = v3.getInt(j.MenuItem_numericModifiers, 0x1000);
            if(v3.hasValue(j.MenuItem_android_checkable)) {
                int v0 = v3.getBoolean(j.MenuItem_android_checkable, false) ? 1 : 0;
                this.t = v0;
            }
            else {
                this.t = this.g;
            }

            this.u = v3.getBoolean(j.MenuItem_android_checked, false);
            this.v = v3.getBoolean(j.MenuItem_android_visible, this.h);
            this.w = v3.getBoolean(j.MenuItem_android_enabled, this.i);
            this.x = v3.getInt(j.MenuItem_showAsAction, v7);
            this.B = v3.getString(j.MenuItem_android_onClick);
            this.y = v3.getResourceId(j.MenuItem_actionLayout, 0);
            this.z = v3.getString(j.MenuItem_actionViewClass);
            this.A = v3.getString(j.MenuItem_actionProviderClass);
            if(this.A == null) {
                v1 = 0;
            }

            if(v1 == 0 || this.y != 0 || this.z != null) {
                if(v1 != 0) {
                    Log.w("SupportMenuInflater", "Ignoring attribute \'actionProviderClass\'. Action view already specified.");
                }

                this.a = v6;
            }
            else {
                this.a = this.a(this.A, g.b, this.b.d);
            }

            this.C = v3.getText(j.MenuItem_contentDescription);
            this.D = v3.getText(j.MenuItem_tooltipText);
            this.F = v3.hasValue(j.MenuItem_iconTintMode) ? ae.a(v3.getInt(j.MenuItem_iconTintMode, v7), this.F) : ((PorterDuff$Mode)v6);
            this.E = v3.hasValue(j.MenuItem_iconTint) ? v3.getColorStateList(j.MenuItem_iconTint) : ((ColorStateList)v6);
            v3.recycle();
            this.j = false;
        }

        public void b() {
            this.j = true;
            this.a(this.c.add(this.d, this.k, this.l, this.m));
        }

        public SubMenu c() {
            this.j = true;
            SubMenu v0 = this.c.addSubMenu(this.d, this.k, this.l, this.m);
            this.a(v0.getItem());
            return v0;
        }

        public boolean d() {
            return this.j;
        }
    }

    static final Class[] a;
    static final Class[] b;
    final Object[] c;
    final Object[] d;
    Context e;
    private Object f;

    static {
        g.a = new Class[]{Context.class};
        g.b = g.a;
    }

    public g(Context arg3) {
        super(arg3);
        this.e = arg3;
        this.c = new Object[]{arg3};
        this.d = this.c;
    }

    private Object a(Object arg2) {
        if(!(arg2 instanceof Activity) && ((arg2 instanceof ContextWrapper))) {
            arg2 = this.a(((ContextWrapper)arg2).getBaseContext());
        }

        return arg2;
    }

    private void a(XmlPullParser arg11, AttributeSet arg12, Menu arg13) {
        String v3_1;
        Object v4 = null;
        b v7 = new b(this, arg13);
        int v0 = arg11.getEventType();
        do {
            if(v0 != 2) {
                v0 = arg11.next();
                if(v0 != 1) {
                    continue;
                }

                break;
            }
            else {
                goto label_8;
            }
        }
        while(true);

        goto label_13;
    label_8:
        String v0_1 = arg11.getName();
        if(v0_1.equals("menu")) {
            v0 = arg11.next();
        }
        else {
            goto label_25;
        }

    label_13:
        Object v2 = v4;
        int v5 = 0;
        int v3 = v0;
        v0 = 0;
        goto label_17;
    label_25:
        throw new RuntimeException("Expecting menu, got " + v0_1);
    label_17:
        while(v0 == 0) {
            switch(v3) {
                case 1: {
                    throw new RuntimeException("Unexpected end of document");
                }
                case 2: {
                    if(v5 != 0) {
                        v3 = v5;
                        goto label_20;
                    }

                    v3_1 = arg11.getName();
                    if(v3_1.equals("group")) {
                        v7.a(arg12);
                        v3 = v5;
                        goto label_20;
                    }

                    if(v3_1.equals("item")) {
                        v7.b(arg12);
                        v3 = v5;
                        goto label_20;
                    }

                    if(v3_1.equals("menu")) {
                        this.a(arg11, arg12, v7.c());
                        v3 = v5;
                        goto label_20;
                    }

                    String v2_1 = v3_1;
                    v3 = 1;
                    break;
                }
                case 3: {
                    v3_1 = arg11.getName();
                    if(v5 != 0 && (v3_1.equals(v2))) {
                        v2 = v4;
                        v3 = 0;
                        goto label_20;
                    }

                    if(v3_1.equals("group")) {
                        v7.a();
                        v3 = v5;
                        goto label_20;
                    }

                    if(v3_1.equals("item")) {
                        if(v7.d()) {
                            goto label_19;
                        }

                        if(v7.a != null && (v7.a.e())) {
                            v7.c();
                            v3 = v5;
                            goto label_20;
                        }

                        v7.b();
                        v3 = v5;
                        goto label_20;
                    }

                    if(!v3_1.equals("menu")) {
                        goto label_19;
                    }

                    v0 = 1;
                    v3 = v5;
                    break;
                }
                default: {
                label_19:
                    v3 = v5;
                    break;
                }
            }

        label_20:
            int v9 = v3;
            v3 = arg11.next();
            v5 = v9;
        }
    }

    Object a() {
        if(this.f == null) {
            this.f = this.a(this.e);
        }

        return this.f;
    }

    public void inflate(int arg5, Menu arg6) {
        XmlResourceParser v1;
        if(!(arg6 instanceof android.support.v4.d.a.a)) {
            super.inflate(arg5, arg6);
        }
        else {
            try {
                v1 = this.e.getResources().getLayout(arg5);
                this.a(((XmlPullParser)v1), Xml.asAttributeSet(((XmlPullParser)v1)), arg6);
                if(v1 == null) {
                    return;
                }
            }
            catch(Throwable v0) {
            }
            catch(IOException v0_1) {
                try {
                    throw new InflateException("Error inflating menu XML", ((Throwable)v0_1));
                }
                catch(Throwable v0) {
                label_19:
                    if(v1 != null) {
                        v1.close();
                    }

                    throw v0;
                }
            }
            catch(XmlPullParserException v0_2) {
                try {
                    throw new InflateException("Error inflating menu XML", ((Throwable)v0_2));
                }
                catch(Throwable v0) {
                    goto label_19;
                }
            }

            v1.close();
        }
    }
}

