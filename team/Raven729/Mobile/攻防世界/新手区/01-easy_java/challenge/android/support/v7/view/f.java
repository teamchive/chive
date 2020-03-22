package android.support.v7.view;

import android.content.Context;
import android.support.v4.g.k;
import android.support.v7.view.menu.q;
import android.view.ActionMode$Callback;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public class f extends ActionMode {
    public class a implements android.support.v7.view.b$a {
        final ActionMode$Callback a;
        final Context b;
        final ArrayList c;
        final k d;

        public a(Context arg2, ActionMode$Callback arg3) {
            super();
            this.b = arg2;
            this.a = arg3;
            this.c = new ArrayList();
            this.d = new k();
        }

        private Menu a(Menu arg3) {
            Object v0 = this.d.get(arg3);
            if(v0 == null) {
                Menu v0_1 = q.a(this.b, arg3);
                this.d.put(arg3, v0_1);
            }

            return ((Menu)v0);
        }

        public void a(b arg3) {
            this.a.onDestroyActionMode(this.b(arg3));
        }

        public boolean a(b arg4, Menu arg5) {
            return this.a.onCreateActionMode(this.b(arg4), this.a(arg5));
        }

        public boolean a(b arg4, MenuItem arg5) {
            return this.a.onActionItemClicked(this.b(arg4), q.a(this.b, ((android.support.v4.d.a.b)arg5)));
        }

        public ActionMode b(b arg5) {
            Object v0;
            int v2 = this.c.size();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                v0 = this.c.get(v1);
                if(v0 != null && ((f)v0).b == arg5) {
                    goto label_10;
                }
            }

            f v0_1 = new f(this.b, arg5);
            this.c.add(v0_1);
        label_10:
            return ((ActionMode)v0);
        }

        public boolean b(b arg4, Menu arg5) {
            return this.a.onPrepareActionMode(this.b(arg4), this.a(arg5));
        }
    }

    final Context a;
    final b b;

    public f(Context arg1, b arg2) {
        super();
        this.a = arg1;
        this.b = arg2;
    }

    public void finish() {
        this.b.c();
    }

    public View getCustomView() {
        return this.b.i();
    }

    public Menu getMenu() {
        return q.a(this.a, this.b.b());
    }

    public MenuInflater getMenuInflater() {
        return this.b.a();
    }

    public CharSequence getSubtitle() {
        return this.b.g();
    }

    public Object getTag() {
        return this.b.j();
    }

    public CharSequence getTitle() {
        return this.b.f();
    }

    public boolean getTitleOptionalHint() {
        return this.b.k();
    }

    public void invalidate() {
        this.b.d();
    }

    public boolean isTitleOptional() {
        return this.b.h();
    }

    public void setCustomView(View arg2) {
        this.b.a(arg2);
    }

    public void setSubtitle(int arg2) {
        this.b.b(arg2);
    }

    public void setSubtitle(CharSequence arg2) {
        this.b.a(arg2);
    }

    public void setTag(Object arg2) {
        this.b.a(arg2);
    }

    public void setTitle(int arg2) {
        this.b.a(arg2);
    }

    public void setTitle(CharSequence arg2) {
        this.b.b(arg2);
    }

    public void setTitleOptionalHint(boolean arg2) {
        this.b.a(arg2);
    }
}

