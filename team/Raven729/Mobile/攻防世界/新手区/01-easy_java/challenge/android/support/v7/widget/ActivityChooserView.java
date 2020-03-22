package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.h.c;
import android.support.v7.a.a$f;
import android.support.v7.a.a$g;
import android.support.v7.a.a$h;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View$MeasureSpec;
import android.view.View$OnClickListener;
import android.view.View$OnLongClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow$OnDismissListener;

public class ActivityChooserView extends ViewGroup {
    public class InnerLayout extends ai {
        private static final int[] a;

        static {
            InnerLayout.a = new int[]{0x10100D4};
        }

        public InnerLayout(Context arg3, AttributeSet arg4) {
            super(arg3, arg4);
            aw v0 = aw.a(arg3, arg4, InnerLayout.a);
            this.setBackgroundDrawable(v0.a(0));
            v0.a();
        }
    }

    class a extends BaseAdapter {
        private e b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;

        public void a(boolean arg2) {
            if(this.f != arg2) {
                this.f = arg2;
                this.notifyDataSetChanged();
            }
        }

        public void a(int arg2) {
            if(this.c != arg2) {
                this.c = arg2;
                this.notifyDataSetChanged();
            }
        }

        public void a(boolean arg2, boolean arg3) {
            if(this.d != arg2 || this.e != arg3) {
                this.d = arg2;
                this.e = arg3;
                this.notifyDataSetChanged();
            }
        }

        public int a() {
            ViewGroup v2 = null;
            int v0 = 0;
            int v4 = this.c;
            this.c = 0x7FFFFFFF;
            int v5 = View$MeasureSpec.makeMeasureSpec(0, 0);
            int v6 = View$MeasureSpec.makeMeasureSpec(0, 0);
            int v7 = this.getCount();
            View v1 = ((View)v2);
            int v3 = 0;
            while(v0 < v7) {
                v1 = this.getView(v0, v1, v2);
                v1.measure(v5, v6);
                v3 = Math.max(v3, v1.getMeasuredWidth());
                ++v0;
            }

            this.c = v4;
            return v3;
        }

        public void a(e arg3) {
            e v0 = this.a.a.d();
            if(v0 != null && (this.a.isShown())) {
                v0.unregisterObserver(this.a.e);
            }

            this.b = arg3;
            if(arg3 != null && (this.a.isShown())) {
                arg3.registerObserver(this.a.e);
            }

            this.notifyDataSetChanged();
        }

        public ResolveInfo b() {
            return this.b.b();
        }

        public int c() {
            return this.b.a();
        }

        public e d() {
            return this.b;
        }

        public boolean e() {
            return this.d;
        }

        public int getCount() {
            int v0 = this.b.a();
            if(!this.d && this.b.b() != null) {
                --v0;
            }

            v0 = Math.min(v0, this.c);
            if(this.f) {
                ++v0;
            }

            return v0;
        }

        public Object getItem(int arg2) {
            switch(this.getItemViewType(arg2)) {
                case 0: {
                    goto label_7;
                }
                case 1: {
                    goto label_5;
                }
            }

            throw new IllegalArgumentException();
        label_5:
            Object v0 = null;
            return v0;
        label_7:
            if(!this.d && this.b.b() != null) {
                ++arg2;
            }

            ResolveInfo v0_1 = this.b.a(arg2);
            return v0;
        }

        public long getItemId(int arg3) {
            return ((long)arg3);
        }

        public int getItemViewType(int arg2) {
            int v0 = !this.f || arg2 != this.getCount() - 1 ? 0 : 1;
            return v0;
        }

        public View getView(int arg7, View arg8, ViewGroup arg9) {
            switch(this.getItemViewType(arg7)) {
                case 0: {
                    if(arg8 == null || arg8.getId() != f.list_item) {
                        arg8 = LayoutInflater.from(this.a.getContext()).inflate(g.abc_activity_chooser_view_list_item, arg9, false);
                    }

                    PackageManager v2 = this.a.getContext().getPackageManager();
                    View v0 = arg8.findViewById(f.icon);
                    Object v1 = this.getItem(arg7);
                    ((ImageView)v0).setImageDrawable(((ResolveInfo)v1).loadIcon(v2));
                    arg8.findViewById(f.title).setText(((ResolveInfo)v1).loadLabel(v2));
                    if((this.d) && arg7 == 0 && (this.e)) {
                        arg8.setActivated(true);
                        return arg8;
                    }

                    arg8.setActivated(false);
                    break;
                }
                case 1: {
                    if(arg8 != null && arg8.getId() == 1) {
                        return arg8;
                    }

                    arg8 = LayoutInflater.from(this.a.getContext()).inflate(g.abc_activity_chooser_view_list_item, arg9, false);
                    arg8.setId(1);
                    arg8.findViewById(f.title).setText(this.a.getContext().getString(h.abc_activity_chooser_view_see_all));
                    break;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }

            return arg8;
        }

        public int getViewTypeCount() {
            return 3;
        }
    }

    class b implements View$OnClickListener, View$OnLongClickListener, AdapterView$OnItemClickListener, PopupWindow$OnDismissListener {
        private void a() {
            if(this.a.f != null) {
                this.a.f.onDismiss();
            }
        }

        public void onClick(View arg3) {
            if(arg3 == this.a.c) {
                this.a.b();
                Intent v0 = this.a.a.d().b(this.a.a.d().a(this.a.a.b()));
                if(v0 != null) {
                    v0.addFlags(0x80000);
                    this.a.getContext().startActivity(v0);
                }
            }
            else if(arg3 == this.a.b) {
                this.a.g = false;
                this.a.a(this.a.h);
            }
            else {
                goto label_34;
            }

            return;
        label_34:
            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            this.a();
            if(this.a.d != null) {
                this.a.d.a(false);
            }
        }

        public void onItemClick(AdapterView arg3, View arg4, int arg5, long arg6) {
            switch(arg3.getAdapter().getItemViewType(arg5)) {
                case 0: {
                    this.a.b();
                    if(this.a.g) {
                        if(arg5 <= 0) {
                            return;
                        }

                        this.a.a.d().c(arg5);
                        return;
                    }

                    if(!this.a.a.e()) {
                        ++arg5;
                    }

                    Intent v0 = this.a.a.d().b(arg5);
                    if(v0 == null) {
                        return;
                    }

                    v0.addFlags(0x80000);
                    this.a.getContext().startActivity(v0);
                    break;
                }
                case 1: {
                    this.a.a(0x7FFFFFFF);
                    break;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
        }

        public boolean onLongClick(View arg4) {
            if(arg4 == this.a.c) {
                if(this.a.a.getCount() > 0) {
                    this.a.g = true;
                    this.a.a(this.a.h);
                }

                return 1;
            }

            throw new IllegalArgumentException();
        }
    }

    final a a;
    final FrameLayout b;
    final FrameLayout c;
    c d;
    final DataSetObserver e;
    PopupWindow$OnDismissListener f;
    boolean g;
    int h;
    private final b i;
    private final ai j;
    private final ImageView k;
    private final int l;
    private final ViewTreeObserver$OnGlobalLayoutListener m;
    private aj n;
    private boolean o;
    private int p;

    void a(int arg7) {
        if(this.a.d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }

        this.getViewTreeObserver().addOnGlobalLayoutListener(this.m);
        boolean v0 = this.c.getVisibility() == 0 ? true : false;
        int v4 = this.a.c();
        int v3 = v0 ? 1 : 0;
        if(arg7 == 0x7FFFFFFF || v4 <= v3 + arg7) {
            this.a.a(false);
            this.a.a(arg7);
        }
        else {
            this.a.a(true);
            this.a.a(arg7 - 1);
        }

        aj v3_1 = this.getListPopupWindow();
        if(!v3_1.d()) {
            if((this.g) || !v0) {
                this.a.a(true, v0);
            }
            else {
                this.a.a(false, false);
            }

            v3_1.g(Math.min(this.a.a(), this.l));
            v3_1.a();
            if(this.d != null) {
                this.d.a(true);
            }

            v3_1.e().setContentDescription(this.getContext().getString(h.abc_activitychooserview_choose_application));
            v3_1.e().setSelector(new ColorDrawable(0));
        }
    }

    public boolean a() {
        boolean v0 = false;
        if(!this.c() && (this.o)) {
            this.g = false;
            this.a(this.h);
            v0 = true;
        }

        return v0;
    }

    public boolean b() {
        if(this.c()) {
            this.getListPopupWindow().c();
            ViewTreeObserver v0 = this.getViewTreeObserver();
            if(v0.isAlive()) {
                v0.removeGlobalOnLayoutListener(this.m);
            }
        }

        return 1;
    }

    public boolean c() {
        return this.getListPopupWindow().d();
    }

    public e getDataModel() {
        return this.a.d();
    }

    aj getListPopupWindow() {
        if(this.n == null) {
            this.n = new aj(this.getContext());
            this.n.a(this.a);
            this.n.b(((View)this));
            this.n.a(true);
            this.n.a(this.i);
            this.n.a(this.i);
        }

        return this.n;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e v0 = this.a.d();
        if(v0 != null) {
            v0.registerObserver(this.e);
        }

        this.o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e v0 = this.a.d();
        if(v0 != null) {
            v0.unregisterObserver(this.e);
        }

        ViewTreeObserver v0_1 = this.getViewTreeObserver();
        if(v0_1.isAlive()) {
            v0_1.removeGlobalOnLayoutListener(this.m);
        }

        if(this.c()) {
            this.b();
        }

        this.o = false;
    }

    protected void onLayout(boolean arg5, int arg6, int arg7, int arg8, int arg9) {
        this.j.layout(0, 0, arg8 - arg6, arg9 - arg7);
        if(!this.c()) {
            this.b();
        }
    }

    protected void onMeasure(int arg4, int arg5) {
        ai v0 = this.j;
        if(this.c.getVisibility() != 0) {
            arg5 = View$MeasureSpec.makeMeasureSpec(View$MeasureSpec.getSize(arg5), 0x40000000);
        }

        this.measureChild(((View)v0), arg4, arg5);
        this.setMeasuredDimension(((View)v0).getMeasuredWidth(), ((View)v0).getMeasuredHeight());
    }

    public void setActivityChooserModel(e arg2) {
        this.a.a(arg2);
        if(this.c()) {
            this.b();
            this.a();
        }
    }

    public void setDefaultActionButtonContentDescription(int arg1) {
        this.p = arg1;
    }

    public void setExpandActivityOverflowButtonContentDescription(int arg3) {
        this.k.setContentDescription(this.getContext().getString(arg3));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable arg2) {
        this.k.setImageDrawable(arg2);
    }

    public void setInitialActivityCount(int arg1) {
        this.h = arg1;
    }

    public void setOnDismissListener(PopupWindow$OnDismissListener arg1) {
        this.f = arg1;
    }

    public void setProvider(c arg1) {
        this.d = arg1;
    }
}

