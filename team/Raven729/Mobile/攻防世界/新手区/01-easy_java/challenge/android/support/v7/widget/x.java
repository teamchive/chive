package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.v4.h.o;
import android.support.v4.h.p;
import android.support.v7.a.a$j;
import android.support.v7.view.d;
import android.support.v7.view.menu.s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class x extends Spinner implements o {
    class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter a;
        private ListAdapter b;

        public a(SpinnerAdapter arg3, Resources$Theme arg4) {
            super();
            this.a = arg3;
            if((arg3 instanceof ListAdapter)) {
                this.b = arg3;
            }

            if(arg4 != null) {
                if(Build$VERSION.SDK_INT >= 23 && ((arg3 instanceof ThemedSpinnerAdapter))) {
                    if(((ThemedSpinnerAdapter)arg3).getDropDownViewTheme() != arg4) {
                        ((ThemedSpinnerAdapter)arg3).setDropDownViewTheme(arg4);
                    }
                    else {
                    }

                    return;
                }

                if(!(arg3 instanceof as)) {
                    return;
                }

                if(((as)arg3).a() != null) {
                    return;
                }

                ((as)arg3).a(arg4);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter v0 = this.b;
            boolean v0_1 = v0 != null ? v0.areAllItemsEnabled() : true;
            return v0_1;
        }

        public int getCount() {
            int v0 = this.a == null ? 0 : this.a.getCount();
            return v0;
        }

        public View getDropDownView(int arg2, View arg3, ViewGroup arg4) {
            View v0 = this.a == null ? null : this.a.getDropDownView(arg2, arg3, arg4);
            return v0;
        }

        public Object getItem(int arg2) {
            Object v0 = this.a == null ? null : this.a.getItem(arg2);
            return v0;
        }

        public long getItemId(int arg3) {
            long v0 = this.a == null ? -1 : this.a.getItemId(arg3);
            return v0;
        }

        public int getItemViewType(int arg2) {
            return 0;
        }

        public View getView(int arg2, View arg3, ViewGroup arg4) {
            return this.getDropDownView(arg2, arg3, arg4);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            boolean v0 = this.a == null || !this.a.hasStableIds() ? false : true;
            return v0;
        }

        public boolean isEmpty() {
            boolean v0 = this.getCount() == 0 ? true : false;
            return v0;
        }

        public boolean isEnabled(int arg2) {
            ListAdapter v0 = this.b;
            boolean v0_1 = v0 != null ? v0.isEnabled(arg2) : true;
            return v0_1;
        }

        public void registerDataSetObserver(DataSetObserver arg2) {
            if(this.a != null) {
                this.a.registerDataSetObserver(arg2);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver arg2) {
            if(this.a != null) {
                this.a.unregisterDataSetObserver(arg2);
            }
        }
    }

    class b extends aj {
        ListAdapter a;
        private CharSequence h;
        private final Rect i;

        public b(x arg2, Context arg3, AttributeSet arg4, int arg5) {
            this.b = arg2;
            super(arg3, arg4, arg5);
            this.i = new Rect();
            this.b(((View)arg2));
            this.a(true);
            this.a(0);
            this.a(new AdapterView$OnItemClickListener(arg2) {
                public void onItemClick(AdapterView arg5, View arg6, int arg7, long arg8) {
                    this.b.b.setSelection(arg7);
                    if(this.b.b.getOnItemClickListener() != null) {
                        this.b.b.performItemClick(arg6, arg7, this.b.a.getItemId(arg7));
                    }

                    this.b.c();
                }
            });
        }

        public void a(CharSequence arg1) {
            this.h = arg1;
        }

        public void a() {
            boolean v0 = this.d();
            this.f();
            this.h(2);
            super.a();
            this.e().setChoiceMode(1);
            this.i(this.b.getSelectedItemPosition());
            if(!v0) {
                ViewTreeObserver v0_1 = this.b.getViewTreeObserver();
                if(v0_1 != null) {
                    android.support.v7.widget.x$b$2 v1 = new ViewTreeObserver$OnGlobalLayoutListener() {
                        public void onGlobalLayout() {
                            if(!this.a.a(this.a.b)) {
                                this.a.c();
                            }
                            else {
                                this.a.f();
                                b.a(this.a);
                            }
                        }
                    };
                    v0_1.addOnGlobalLayoutListener(((ViewTreeObserver$OnGlobalLayoutListener)v1));
                    this.a(new PopupWindow$OnDismissListener(((ViewTreeObserver$OnGlobalLayoutListener)v1)) {
                        public void onDismiss() {
                            ViewTreeObserver v0 = this.b.b.getViewTreeObserver();
                            if(v0 != null) {
                                v0.removeGlobalOnLayoutListener(this.a);
                            }
                        }
                    });
                }
            }
        }

        public void a(ListAdapter arg1) {
            super.a(arg1);
            this.a = arg1;
        }

        static void a(b arg0) {
            super.a();
        }

        boolean a(View arg2) {
            boolean v0 = !p.m(arg2) || !arg2.getGlobalVisibleRect(this.i) ? false : true;
            return v0;
        }

        public CharSequence b() {
            return this.h;
        }

        void f() {
            int v1_1;
            int v0;
            Drawable v1 = this.h();
            if(v1 != null) {
                v1.getPadding(x.b(this.b));
                v0 = bc.a(this.b) ? x.b(this.b).right : -x.b(this.b).left;
                v1_1 = v0;
            }
            else {
                Rect v1_2 = x.b(this.b);
                x.b(this.b).right = 0;
                v1_2.left = 0;
                v1_1 = 0;
            }

            int v3 = this.b.getPaddingLeft();
            int v4 = this.b.getPaddingRight();
            int v5 = this.b.getWidth();
            if(x.c(this.b) == -2) {
                int v2 = this.b.a(this.a, this.h());
                v0 = this.b.getContext().getResources().getDisplayMetrics().widthPixels - x.b(this.b).left - x.b(this.b).right;
                if(v2 <= v0) {
                    v0 = v2;
                }

                this.g(Math.max(v0, v5 - v3 - v4));
            }
            else {
                if(x.c(this.b) == -1) {
                    this.g(v5 - v3 - v4);
                    goto label_45;
                }

                this.g(x.c(this.b));
            }

        label_45:
            v0 = bc.a(this.b) ? v5 - v4 - this.l() + v1_1 : v1_1 + v3;
            this.c(v0);
        }
    }

    private static final int[] a;
    private final g b;
    private final Context c;
    private ah d;
    private SpinnerAdapter e;
    private final boolean f;
    private b g;
    private int h;
    private final Rect i;

    static {
        x.a = new int[]{0x10102F1};
    }

    public x(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, android.support.v7.a.a$a.spinnerStyle);
    }

    public x(Context arg2, AttributeSet arg3, int arg4) {
        this(arg2, arg3, arg4, -1);
    }

    public x(Context arg7, AttributeSet arg8, int arg9, int arg10) {
        this(arg7, arg8, arg9, arg10, null);
    }

    public x(Context arg9, AttributeSet arg10, int arg11, int arg12, Resources$Theme arg13) {
        TypedArray v2;
        SpinnerAdapter v1 = null;
        super(arg9, arg10, arg11);
        this.i = new Rect();
        aw v4 = aw.a(arg9, arg10, j.Spinner, arg11, 0);
        this.b = new g(((View)this));
        if(arg13 != null) {
            this.c = new d(arg9, arg13);
        }
        else {
            int v0 = v4.g(j.Spinner_popupTheme, 0);
            if(v0 != 0) {
                this.c = new d(arg9, v0);
            }
            else {
                Context v0_1 = Build$VERSION.SDK_INT < 23 ? arg9 : ((Context)v1);
                this.c = v0_1;
            }
        }

        if(this.c == null) {
            goto label_56;
        }

        if(arg12 != -1) {
            goto label_34;
        }

        if(Build$VERSION.SDK_INT < 11) {
            goto label_103;
        }

        try {
            v2 = arg9.obtainStyledAttributes(arg10, x.a, arg11, 0);
        }
        catch(Throwable v0_2) {
            v2 = ((TypedArray)v1);
            goto label_100;
        }
        catch(Exception v0_3) {
            v2 = ((TypedArray)v1);
            goto label_92;
        }

        try {
            if(v2.hasValue(0)) {
                arg12 = v2.getInt(0, 0);
            }

            goto label_32;
        }
        catch(Throwable v0_2) {
        label_106:
        }
        catch(Exception v0_3) {
            try {
            label_92:
                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", ((Throwable)v0_3));
                if(v2 != null) {
                }
                else {
                    goto label_34;
                }
            }
            catch(Throwable v0_2) {
                goto label_106;
            }

            v2.recycle();
            goto label_34;
        }

    label_100:
        if(v2 != null) {
            v2.recycle();
        }

        throw v0_2;
    label_32:
        if(v2 == null) {
        }
        else {
            v2.recycle();
            goto label_34;
        label_103:
            arg12 = 1;
        }

    label_34:
        if(arg12 == 1) {
            b v0_4 = new b(this, this.c, arg10, arg11);
            aw v2_1 = aw.a(this.c, arg10, j.Spinner, arg11, 0);
            this.h = v2_1.f(j.Spinner_android_dropDownWidth, -2);
            v0_4.a(v2_1.a(j.Spinner_android_popupBackground));
            v0_4.a(v4.d(j.Spinner_android_prompt));
            v2_1.a();
            this.g = v0_4;
            this.d = new ah(((View)this), v0_4) {
                public s a() {
                    return this.a;
                }

                public boolean b() {
                    if(!x.a(this.b).d()) {
                        x.a(this.b).a();
                    }

                    return 1;
                }
            };
        }

    label_56:
        CharSequence[] v0_5 = v4.f(j.Spinner_android_entries);
        if(v0_5 != null) {
            ArrayAdapter v2_2 = new ArrayAdapter(arg9, 0x1090008, ((Object[])v0_5));
            v2_2.setDropDownViewResource(android.support.v7.a.a$g.support_simple_spinner_dropdown_item);
            this.setAdapter(((SpinnerAdapter)v2_2));
        }

        v4.a();
        this.f = true;
        if(this.e != null) {
            this.setAdapter(this.e);
            this.e = v1;
        }

        this.b.a(arg10, arg11);
    }

    static b a(x arg1) {
        return arg1.g;
    }

    int a(SpinnerAdapter arg11, Drawable arg12) {
        View v1_1;
        View v2 = null;
        int v9 = -2;
        int v0 = 0;
        if(arg11 != null) {
            int v6 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0);
            int v7 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0);
            int v1 = Math.max(0, this.getSelectedItemPosition());
            int v8 = Math.min(arg11.getCount(), v1 + 15);
            int v5 = Math.max(0, v1 - (15 - (v8 - v1)));
            View v3 = v2;
            int v4 = 0;
            for(v1 = 0; v5 < v8; v1 = v0) {
                v0 = arg11.getItemViewType(v5);
                if(v0 != v1) {
                    v1_1 = v2;
                }
                else {
                    v0 = v1;
                    v1_1 = v3;
                }

                v3 = arg11.getView(v5, v1_1, ((ViewGroup)this));
                if(v3.getLayoutParams() == null) {
                    v3.setLayoutParams(new ViewGroup$LayoutParams(v9, v9));
                }

                v3.measure(v6, v7);
                v4 = Math.max(v4, v3.getMeasuredWidth());
                ++v5;
            }

            if(arg12 != null) {
                arg12.getPadding(this.i);
                return this.i.left + this.i.right + v4;
            }

            v0 = v4;
        }

        return v0;
    }

    static Rect b(x arg1) {
        return arg1.i;
    }

    static int c(x arg1) {
        return arg1.h;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(this.b != null) {
            this.b.c();
        }
    }

    public int getDropDownHorizontalOffset() {
        int v0;
        if(this.g != null) {
            v0 = this.g.j();
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            v0 = super.getDropDownHorizontalOffset();
        }
        else {
            v0 = 0;
        }

        return v0;
    }

    public int getDropDownVerticalOffset() {
        int v0;
        if(this.g != null) {
            v0 = this.g.k();
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            v0 = super.getDropDownVerticalOffset();
        }
        else {
            v0 = 0;
        }

        return v0;
    }

    public int getDropDownWidth() {
        int v0;
        if(this.g != null) {
            v0 = this.h;
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            v0 = super.getDropDownWidth();
        }
        else {
            v0 = 0;
        }

        return v0;
    }

    public Drawable getPopupBackground() {
        Drawable v0;
        if(this.g != null) {
            v0 = this.g.h();
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            v0 = super.getPopupBackground();
        }
        else {
            v0 = null;
        }

        return v0;
    }

    public Context getPopupContext() {
        Context v0;
        if(this.g != null) {
            v0 = this.c;
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            v0 = super.getPopupContext();
        }
        else {
            v0 = null;
        }

        return v0;
    }

    public CharSequence getPrompt() {
        CharSequence v0 = this.g != null ? this.g.b() : super.getPrompt();
        return v0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        ColorStateList v0 = this.b != null ? this.b.a() : null;
        return v0;
    }

    public PorterDuff$Mode getSupportBackgroundTintMode() {
        PorterDuff$Mode v0 = this.b != null ? this.b.b() : null;
        return v0;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(this.g != null && (this.g.d())) {
            this.g.c();
        }
    }

    protected void onMeasure(int arg4, int arg5) {
        super.onMeasure(arg4, arg5);
        if(this.g != null && View$MeasureSpec.getMode(arg4) == 0x80000000) {
            this.setMeasuredDimension(Math.min(Math.max(this.getMeasuredWidth(), this.a(this.getAdapter(), this.getBackground())), View$MeasureSpec.getSize(arg4)), this.getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent arg2) {
        boolean v0 = this.d == null || !this.d.onTouch(((View)this), arg2) ? super.onTouchEvent(arg2) : true;
        return v0;
    }

    public boolean performClick() {
        boolean v0;
        if(this.g != null) {
            if(!this.g.d()) {
                this.g.a();
            }

            v0 = true;
        }
        else {
            v0 = super.performClick();
        }

        return v0;
    }

    public void setAdapter(SpinnerAdapter arg4) {
        if(!this.f) {
            this.e = arg4;
        }
        else {
            super.setAdapter(arg4);
            if(this.g != null) {
                Context v0 = this.c == null ? this.getContext() : this.c;
                this.g.a(new a(arg4, v0.getTheme()));
            }
        }
    }

    public void setAdapter(Adapter arg1) {
        this.setAdapter(((SpinnerAdapter)arg1));
    }

    public void setBackgroundDrawable(Drawable arg2) {
        super.setBackgroundDrawable(arg2);
        if(this.b != null) {
            this.b.a(arg2);
        }
    }

    public void setBackgroundResource(int arg2) {
        super.setBackgroundResource(arg2);
        if(this.b != null) {
            this.b.a(arg2);
        }
    }

    public void setDropDownHorizontalOffset(int arg3) {
        if(this.g != null) {
            this.g.c(arg3);
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(arg3);
        }
    }

    public void setDropDownVerticalOffset(int arg3) {
        if(this.g != null) {
            this.g.d(arg3);
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(arg3);
        }
    }

    public void setDropDownWidth(int arg3) {
        if(this.g != null) {
            this.h = arg3;
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(arg3);
        }
    }

    public void setPopupBackgroundDrawable(Drawable arg3) {
        if(this.g != null) {
            this.g.a(arg3);
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(arg3);
        }
    }

    public void setPopupBackgroundResource(int arg2) {
        this.setPopupBackgroundDrawable(android.support.v7.b.a.b.b(this.getPopupContext(), arg2));
    }

    public void setPrompt(CharSequence arg2) {
        if(this.g != null) {
            this.g.a(arg2);
        }
        else {
            super.setPrompt(arg2);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList arg2) {
        if(this.b != null) {
            this.b.a(arg2);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff$Mode arg2) {
        if(this.b != null) {
            this.b.a(arg2);
        }
    }
}

