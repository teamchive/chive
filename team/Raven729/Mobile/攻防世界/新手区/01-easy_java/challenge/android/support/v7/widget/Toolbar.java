package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.v4.h.f;
import android.support.v4.h.p;
import android.support.v7.view.c;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.u;
import android.text.TextUtils$TruncateAt;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    class android.support.v7.widget.Toolbar$1 implements e {
        android.support.v7.widget.Toolbar$1(Toolbar arg1) {
            this.a = arg1;
            super();
        }

        public boolean a(MenuItem arg2) {
            boolean v0 = this.a.d != null ? this.a.d.a(arg2) : false;
            return v0;
        }
    }

    class android.support.v7.widget.Toolbar$2 implements Runnable {
        android.support.v7.widget.Toolbar$2(Toolbar arg1) {
            this.a = arg1;
            super();
        }

        public void run() {
            this.a.d();
        }
    }

    class a implements o {
        h a;
        j b;

        a(Toolbar arg1) {
            this.c = arg1;
            super();
        }

        public void a(Context arg3, h arg4) {
            if(this.a != null && this.b != null) {
                this.a.d(this.b);
            }

            this.a = arg4;
        }

        public void a(h arg1, boolean arg2) {
        }

        public void a(android.support.v7.view.menu.o$a arg1) {
        }

        public boolean a(h arg5, j arg6) {
            this.c.i();
            if(this.c.a.getParent() != this.c) {
                this.c.addView(this.c.a);
            }

            this.c.b = arg6.getActionView();
            this.b = arg6;
            if(this.c.b.getParent() != this.c) {
                b v0 = this.c.j();
                v0.a = 0x800003 | this.c.c & 0x70;
                v0.b = 2;
                this.c.b.setLayoutParams(((ViewGroup$LayoutParams)v0));
                this.c.addView(this.c.b);
            }

            this.c.k();
            this.c.requestLayout();
            arg6.e(true);
            if((this.c.b instanceof c)) {
                this.c.b.a();
            }

            return 1;
        }

        public boolean a(u arg2) {
            return 0;
        }

        public void b(boolean arg6) {
            int v0 = 0;
            if(this.b != null) {
                if(this.a != null) {
                    int v2 = this.a.size();
                    int v1 = 0;
                    while(v1 < v2) {
                        if(this.a.getItem(v1) == this.b) {
                            v0 = 1;
                        }
                        else {
                            ++v1;
                            continue;
                        }

                        break;
                    }
                }

                if(v0 != 0) {
                    return;
                }

                this.b(this.a, this.b);
            }
        }

        public boolean b(h arg4, j arg5) {
            View v2 = null;
            if((this.c.b instanceof c)) {
                this.c.b.b();
            }

            this.c.removeView(this.c.b);
            this.c.removeView(this.c.a);
            this.c.b = v2;
            this.c.l();
            this.b = ((j)v2);
            this.c.requestLayout();
            arg5.e(false);
            return 1;
        }

        public boolean b() {
            return 0;
        }
    }

    public class b extends android.support.v7.app.a$a {
        int b;

        public b(Context arg2, AttributeSet arg3) {
            super(arg2, arg3);
            this.b = 0;
        }

        public b(b arg2) {
            super(((android.support.v7.app.a$a)arg2));
            this.b = 0;
            this.b = arg2.b;
        }

        public b(android.support.v7.app.a$a arg2) {
            super(arg2);
            this.b = 0;
        }

        public b(ViewGroup$MarginLayoutParams arg2) {
            super(((ViewGroup$LayoutParams)arg2));
            this.b = 0;
            this.a(arg2);
        }

        public b(ViewGroup$LayoutParams arg2) {
            super(arg2);
            this.b = 0;
        }

        public b(int arg2, int arg3) {
            super(arg2, arg3);
            this.b = 0;
            this.a = 0x800013;
        }

        void a(ViewGroup$MarginLayoutParams arg2) {
            this.leftMargin = arg2.leftMargin;
            this.topMargin = arg2.topMargin;
            this.rightMargin = arg2.rightMargin;
            this.bottomMargin = arg2.bottomMargin;
        }
    }

    public interface android.support.v7.widget.Toolbar$c {
        boolean a(MenuItem arg1);
    }

    public class d extends android.support.v4.h.a {
        final class android.support.v7.widget.Toolbar$d$1 implements Parcelable$ClassLoaderCreator {
            android.support.v7.widget.Toolbar$d$1() {
                super();
            }

            public d a(Parcel arg3) {
                return new d(arg3, null);
            }

            public d a(Parcel arg2, ClassLoader arg3) {
                return new d(arg2, arg3);
            }

            public d[] a(int arg2) {
                return new d[arg2];
            }

            public Object createFromParcel(Parcel arg2) {
                return this.a(arg2);
            }

            public Object createFromParcel(Parcel arg2, ClassLoader arg3) {
                return this.a(arg2, arg3);
            }

            public Object[] newArray(int arg2) {
                return this.a(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR;
        int b;
        boolean c;

        static {
            d.CREATOR = new android.support.v7.widget.Toolbar$d$1();
        }

        public d(Parcelable arg1) {
            super(arg1);
        }

        public d(Parcel arg2, ClassLoader arg3) {
            super(arg2, arg3);
            this.b = arg2.readInt();
            boolean v0 = arg2.readInt() != 0 ? true : false;
            this.c = v0;
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            super.writeToParcel(arg2, arg3);
            arg2.writeInt(this.b);
            int v0 = this.c ? 1 : 0;
            arg2.writeInt(v0);
        }
    }

    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private final ArrayList E;
    private final ArrayList F;
    private final int[] G;
    private final e H;
    private ax I;
    private android.support.v7.widget.d J;
    private a K;
    private android.support.v7.view.menu.o$a L;
    private android.support.v7.view.menu.h$a M;
    private boolean N;
    private final Runnable O;
    ImageButton a;
    View b;
    int c;
    android.support.v7.widget.Toolbar$c d;
    private ActionMenuView e;
    private TextView f;
    private TextView g;
    private ImageButton h;
    private ImageView i;
    private Drawable j;
    private CharSequence k;
    private Context l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private ao u;
    private int v;
    private int w;
    private int x;
    private CharSequence y;
    private CharSequence z;

    public Toolbar(Context arg2) {
        this(arg2, null);
    }

    public Toolbar(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, android.support.v7.a.a$a.toolbarStyle);
    }

    public Toolbar(Context arg10, AttributeSet arg11, int arg12) {
        int v8 = 0x80000000;
        int v6 = -1;
        super(arg10, arg11, arg12);
        this.x = 0x800013;
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new int[2];
        this.H = new android.support.v7.widget.Toolbar$1(this);
        this.O = new android.support.v7.widget.Toolbar$2(this);
        aw v1 = aw.a(this.getContext(), arg11, android.support.v7.a.a$j.Toolbar, arg12, 0);
        this.n = v1.g(android.support.v7.a.a$j.Toolbar_titleTextAppearance, 0);
        this.o = v1.g(android.support.v7.a.a$j.Toolbar_subtitleTextAppearance, 0);
        this.x = v1.c(android.support.v7.a.a$j.Toolbar_android_gravity, this.x);
        this.c = v1.c(android.support.v7.a.a$j.Toolbar_buttonGravity, 0x30);
        int v0 = v1.d(android.support.v7.a.a$j.Toolbar_titleMargin, 0);
        if(v1.g(android.support.v7.a.a$j.Toolbar_titleMargins)) {
            v0 = v1.d(android.support.v7.a.a$j.Toolbar_titleMargins, v0);
        }

        this.t = v0;
        this.s = v0;
        this.r = v0;
        this.q = v0;
        v0 = v1.d(android.support.v7.a.a$j.Toolbar_titleMarginStart, v6);
        if(v0 >= 0) {
            this.q = v0;
        }

        v0 = v1.d(android.support.v7.a.a$j.Toolbar_titleMarginEnd, v6);
        if(v0 >= 0) {
            this.r = v0;
        }

        v0 = v1.d(android.support.v7.a.a$j.Toolbar_titleMarginTop, v6);
        if(v0 >= 0) {
            this.s = v0;
        }

        v0 = v1.d(android.support.v7.a.a$j.Toolbar_titleMarginBottom, v6);
        if(v0 >= 0) {
            this.t = v0;
        }

        this.p = v1.e(android.support.v7.a.a$j.Toolbar_maxButtonHeight, v6);
        v0 = v1.d(android.support.v7.a.a$j.Toolbar_contentInsetStart, v8);
        int v2 = v1.d(android.support.v7.a.a$j.Toolbar_contentInsetEnd, v8);
        int v3 = v1.e(android.support.v7.a.a$j.Toolbar_contentInsetLeft, 0);
        int v4 = v1.e(android.support.v7.a.a$j.Toolbar_contentInsetRight, 0);
        this.s();
        this.u.b(v3, v4);
        if(v0 != v8 || v2 != v8) {
            this.u.a(v0, v2);
        }

        this.v = v1.d(android.support.v7.a.a$j.Toolbar_contentInsetStartWithNavigation, v8);
        this.w = v1.d(android.support.v7.a.a$j.Toolbar_contentInsetEndWithActions, v8);
        this.j = v1.a(android.support.v7.a.a$j.Toolbar_collapseIcon);
        this.k = v1.c(android.support.v7.a.a$j.Toolbar_collapseContentDescription);
        CharSequence v0_1 = v1.c(android.support.v7.a.a$j.Toolbar_title);
        if(!TextUtils.isEmpty(v0_1)) {
            this.setTitle(v0_1);
        }

        v0_1 = v1.c(android.support.v7.a.a$j.Toolbar_subtitle);
        if(!TextUtils.isEmpty(v0_1)) {
            this.setSubtitle(v0_1);
        }

        this.l = this.getContext();
        this.setPopupTheme(v1.g(android.support.v7.a.a$j.Toolbar_popupTheme, 0));
        Drawable v0_2 = v1.a(android.support.v7.a.a$j.Toolbar_navigationIcon);
        if(v0_2 != null) {
            this.setNavigationIcon(v0_2);
        }

        v0_1 = v1.c(android.support.v7.a.a$j.Toolbar_navigationContentDescription);
        if(!TextUtils.isEmpty(v0_1)) {
            this.setNavigationContentDescription(v0_1);
        }

        v0_2 = v1.a(android.support.v7.a.a$j.Toolbar_logo);
        if(v0_2 != null) {
            this.setLogo(v0_2);
        }

        v0_1 = v1.c(android.support.v7.a.a$j.Toolbar_logoDescription);
        if(!TextUtils.isEmpty(v0_1)) {
            this.setLogoDescription(v0_1);
        }

        if(v1.g(android.support.v7.a.a$j.Toolbar_titleTextColor)) {
            this.setTitleTextColor(v1.b(android.support.v7.a.a$j.Toolbar_titleTextColor, v6));
        }

        if(v1.g(android.support.v7.a.a$j.Toolbar_subtitleTextColor)) {
            this.setSubtitleTextColor(v1.b(android.support.v7.a.a$j.Toolbar_subtitleTextColor, v6));
        }

        v1.a();
    }

    private int a(int arg2) {
        int v0 = arg2 & 0x70;
        switch(v0) {
            case 16: 
            case 48: 
            case 80: {
                break;
            }
            default: {
                v0 = this.x & 0x70;
                break;
            }
        }

        return v0;
    }

    private int a(View arg9, int arg10) {
        int v0_1;
        ViewGroup$LayoutParams v0 = arg9.getLayoutParams();
        int v3 = arg9.getMeasuredHeight();
        int v1 = arg10 > 0 ? (v3 - arg10) / 2 : 0;
        switch(this.a(((b)v0).a)) {
            case 48: {
                v0_1 = this.getPaddingTop() - v1;
                break;
            }
            case 80: {
                v0_1 = this.getHeight() - this.getPaddingBottom() - v3 - ((b)v0).bottomMargin - v1;
                break;
            }
            default: {
                int v4 = this.getPaddingTop();
                int v5 = this.getPaddingBottom();
                int v6 = this.getHeight();
                v1 = (v6 - v4 - v5 - v3) / 2;
                if(v1 < ((b)v0).topMargin) {
                    v0_1 = ((b)v0).topMargin;
                }
                else {
                    v3 = v6 - v5 - v3 - v1 - v4;
                    v0_1 = v3 < ((b)v0).bottomMargin ? Math.max(0, v1 - (((b)v0).bottomMargin - v3)) : v1;
                }

                v0_1 += v4;
                break;
            }
        }

        return v0_1;
    }

    private int a(View arg8, int arg9, int arg10, int arg11, int arg12, int[] arg13) {
        ViewGroup$LayoutParams v0 = arg8.getLayoutParams();
        int v1 = ((ViewGroup$MarginLayoutParams)v0).leftMargin - arg13[0];
        int v2 = ((ViewGroup$MarginLayoutParams)v0).rightMargin - arg13[1];
        int v3 = Math.max(0, v1) + Math.max(0, v2);
        arg13[0] = Math.max(0, -v1);
        arg13[1] = Math.max(0, -v2);
        arg8.measure(Toolbar.getChildMeasureSpec(arg9, this.getPaddingLeft() + this.getPaddingRight() + v3 + arg10, ((ViewGroup$MarginLayoutParams)v0).width), Toolbar.getChildMeasureSpec(arg11, this.getPaddingTop() + this.getPaddingBottom() + ((ViewGroup$MarginLayoutParams)v0).topMargin + ((ViewGroup$MarginLayoutParams)v0).bottomMargin + arg12, ((ViewGroup$MarginLayoutParams)v0).height));
        return arg8.getMeasuredWidth() + v3;
    }

    private int a(View arg7, int arg8, int[] arg9, int arg10) {
        ViewGroup$LayoutParams v0 = arg7.getLayoutParams();
        int v1 = ((b)v0).leftMargin - arg9[0];
        int v2 = Math.max(0, v1) + arg8;
        arg9[0] = Math.max(0, -v1);
        v1 = this.a(arg7, arg10);
        int v3 = arg7.getMeasuredWidth();
        arg7.layout(v2, v1, v2 + v3, arg7.getMeasuredHeight() + v1);
        return ((b)v0).rightMargin + v3 + v2;
    }

    private int a(List arg11, int[] arg12) {
        int v1 = arg12[0];
        int v0 = arg12[1];
        int v7 = arg11.size();
        int v2 = 0;
        int v4 = 0;
        int v5 = v0;
        int v6 = v1;
        while(v2 < v7) {
            Object v0_1 = arg11.get(v2);
            ViewGroup$LayoutParams v1_1 = ((View)v0_1).getLayoutParams();
            v6 = ((b)v1_1).leftMargin - v6;
            v1 = ((b)v1_1).rightMargin - v5;
            int v8 = Math.max(0, v6);
            int v9 = Math.max(0, v1);
            v6 = Math.max(0, -v6);
            v5 = Math.max(0, -v1);
            ++v2;
            v4 += ((View)v0_1).getMeasuredWidth() + v8 + v9;
        }

        return v4;
    }

    private void a(View arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
        int v4 = 0x40000000;
        ViewGroup$LayoutParams v0 = arg6.getLayoutParams();
        int v1 = Toolbar.getChildMeasureSpec(arg7, this.getPaddingLeft() + this.getPaddingRight() + ((ViewGroup$MarginLayoutParams)v0).leftMargin + ((ViewGroup$MarginLayoutParams)v0).rightMargin + arg8, ((ViewGroup$MarginLayoutParams)v0).width);
        int v0_1 = Toolbar.getChildMeasureSpec(arg9, this.getPaddingTop() + this.getPaddingBottom() + ((ViewGroup$MarginLayoutParams)v0).topMargin + ((ViewGroup$MarginLayoutParams)v0).bottomMargin + arg10, ((ViewGroup$MarginLayoutParams)v0).height);
        int v2 = View$MeasureSpec.getMode(v0_1);
        if(v2 != v4 && arg11 >= 0) {
            if(v2 != 0) {
                arg11 = Math.min(View$MeasureSpec.getSize(v0_1), arg11);
            }

            v0_1 = View$MeasureSpec.makeMeasureSpec(arg11, v4);
        }

        arg6.measure(v1, v0_1);
    }

    private void a(View arg3, boolean arg4) {
        b v0_1;
        ViewGroup$LayoutParams v0 = arg3.getLayoutParams();
        if(v0 == null) {
            v0_1 = this.j();
        }
        else if(!this.checkLayoutParams(v0)) {
            v0_1 = this.a(v0);
        }

        ((b)v0).b = 1;
        if(!arg4 || this.b == null) {
            this.addView(arg3, v0);
        }
        else {
            arg3.setLayoutParams(v0);
            this.F.add(arg3);
        }
    }

    protected b a(ViewGroup$LayoutParams arg2) {
        b v0;
        if((arg2 instanceof b)) {
            v0 = new b(((b)arg2));
        }
        else if((arg2 instanceof android.support.v7.app.a$a)) {
            v0 = new b(((android.support.v7.app.a$a)arg2));
        }
        else if((arg2 instanceof ViewGroup$MarginLayoutParams)) {
            v0 = new b(((ViewGroup$MarginLayoutParams)arg2));
        }
        else {
            v0 = new b(arg2);
        }

        return v0;
    }

    private void a(List arg7, int arg8) {
        ViewGroup$LayoutParams v0_1;
        int v0 = 1;
        int v1 = 0;
        if(p.b(((View)this)) != 1) {
            v0 = 0;
        }

        int v2 = this.getChildCount();
        int v3 = android.support.v4.h.d.a(arg8, p.b(((View)this)));
        arg7.clear();
        if(v0 != 0) {
            for(v1 = v2 - 1; v1 >= 0; --v1) {
                View v2_1 = this.getChildAt(v1);
                v0_1 = v2_1.getLayoutParams();
                if(((b)v0_1).b == 0 && (this.a(v2_1)) && this.b(((b)v0_1).a) == v3) {
                    arg7.add(v2_1);
                }
            }
        }
        else {
            while(v1 < v2) {
                View v4 = this.getChildAt(v1);
                v0_1 = v4.getLayoutParams();
                if(((b)v0_1).b == 0 && (this.a(v4)) && this.b(((b)v0_1).a) == v3) {
                    arg7.add(v4);
                }

                ++v1;
            }
        }
    }

    private boolean a(View arg3) {
        boolean v0 = arg3 == null || arg3.getParent() != this || arg3.getVisibility() == 8 ? false : true;
        return v0;
    }

    public b a(AttributeSet arg3) {
        return new b(this.getContext(), arg3);
    }

    public void a(int arg2, int arg3) {
        this.s();
        this.u.a(arg2, arg3);
    }

    public void a(Context arg2, int arg3) {
        this.n = arg3;
        if(this.f != null) {
            this.f.setTextAppearance(arg2, arg3);
        }
    }

    public void a(h arg5, android.support.v7.widget.d arg6) {
        h v3 = null;
        if(arg5 != null || this.e != null) {
            this.o();
            h v0 = this.e.d();
            if(v0 != arg5) {
                if(v0 != null) {
                    v0.b(this.J);
                    v0.b(this.K);
                }

                if(this.K == null) {
                    this.K = new a(this);
                }

                arg6.d(true);
                if(arg5 != null) {
                    arg5.a(((o)arg6), this.l);
                    arg5.a(this.K, this.l);
                }
                else {
                    arg6.a(this.l, v3);
                    this.K.a(this.l, v3);
                    arg6.b(true);
                    this.K.b(true);
                }

                this.e.setPopupTheme(this.m);
                this.e.setPresenter(arg6);
                this.J = arg6;
            }
        }
    }

    public void a(android.support.v7.view.menu.o$a arg2, android.support.v7.view.menu.h$a arg3) {
        this.L = arg2;
        this.M = arg3;
        if(this.e != null) {
            this.e.a(arg2, arg3);
        }
    }

    public boolean a() {
        boolean v0 = this.getVisibility() != 0 || this.e == null || !this.e.a() ? false : true;
        return v0;
    }

    private int b(int arg3) {
        int v1 = p.b(((View)this));
        int v0 = android.support.v4.h.d.a(arg3, v1) & 7;
        switch(v0) {
            case 1: 
            case 3: 
            case 5: {
                break;
            }
            default: {
                v0 = v1 == 1 ? 5 : 3;
                break;
            }
        }

        return v0;
    }

    private int b(View arg3) {
        ViewGroup$LayoutParams v0 = arg3.getLayoutParams();
        return f.b(((ViewGroup$MarginLayoutParams)v0)) + f.a(((ViewGroup$MarginLayoutParams)v0));
    }

    private int b(View arg7, int arg8, int[] arg9, int arg10) {
        ViewGroup$LayoutParams v0 = arg7.getLayoutParams();
        int v1 = ((b)v0).rightMargin - arg9[1];
        int v2 = arg8 - Math.max(0, v1);
        arg9[1] = Math.max(0, -v1);
        v1 = this.a(arg7, arg10);
        int v3 = arg7.getMeasuredWidth();
        arg7.layout(v2 - v3, v1, v2, arg7.getMeasuredHeight() + v1);
        return v2 - (((b)v0).leftMargin + v3);
    }

    public void b(Context arg2, int arg3) {
        this.o = arg3;
        if(this.g != null) {
            this.g.setTextAppearance(arg2, arg3);
        }
    }

    public boolean b() {
        boolean v0 = this.e == null || !this.e.g() ? false : true;
        return v0;
    }

    private int c(View arg3) {
        ViewGroup$LayoutParams v0 = arg3.getLayoutParams();
        return ((ViewGroup$MarginLayoutParams)v0).bottomMargin + ((ViewGroup$MarginLayoutParams)v0).topMargin;
    }

    public boolean c() {
        boolean v0 = this.e == null || !this.e.h() ? false : true;
        return v0;
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg2) {
        boolean v0 = !super.checkLayoutParams(arg2) || !(arg2 instanceof b) ? false : true;
        return v0;
    }

    private boolean d(View arg2) {
        boolean v0 = arg2.getParent() == this || (this.F.contains(arg2)) ? true : false;
        return v0;
    }

    public boolean d() {
        boolean v0 = this.e == null || !this.e.e() ? false : true;
        return v0;
    }

    public boolean e() {
        boolean v0 = this.e == null || !this.e.f() ? false : true;
        return v0;
    }

    public void f() {
        if(this.e != null) {
            this.e.i();
        }
    }

    public boolean g() {
        boolean v0 = this.K == null || this.K.b == null ? false : true;
        return v0;
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.j();
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg2) {
        return this.a(arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg2) {
        return this.a(arg2);
    }

    public int getContentInsetEnd() {
        int v0 = this.u != null ? this.u.d() : 0;
        return v0;
    }

    public int getContentInsetEndWithActions() {
        int v0 = this.w != 0x80000000 ? this.w : this.getContentInsetEnd();
        return v0;
    }

    public int getContentInsetLeft() {
        int v0 = this.u != null ? this.u.a() : 0;
        return v0;
    }

    public int getContentInsetRight() {
        int v0 = this.u != null ? this.u.b() : 0;
        return v0;
    }

    public int getContentInsetStart() {
        int v0 = this.u != null ? this.u.c() : 0;
        return v0;
    }

    public int getContentInsetStartWithNavigation() {
        int v0 = this.v != 0x80000000 ? this.v : this.getContentInsetStart();
        return v0;
    }

    public int getCurrentContentInsetEnd() {
        int v0_1;
        if(this.e != null) {
            h v0 = this.e.d();
            if(v0 != null && (v0.hasVisibleItems())) {
                v0_1 = 1;
                goto label_9;
            }

            v0_1 = 0;
        }
        else {
            v0_1 = 0;
        }

    label_9:
        return v0_1 != 0 ? Math.max(this.getContentInsetEnd(), Math.max(this.w, 0)) : this.getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        int v0 = p.b(((View)this)) == 1 ? this.getCurrentContentInsetEnd() : this.getCurrentContentInsetStart();
        return v0;
    }

    public int getCurrentContentInsetRight() {
        int v0 = p.b(((View)this)) == 1 ? this.getCurrentContentInsetStart() : this.getCurrentContentInsetEnd();
        return v0;
    }

    public int getCurrentContentInsetStart() {
        int v0 = this.getNavigationIcon() != null ? Math.max(this.getContentInsetStart(), Math.max(this.v, 0)) : this.getContentInsetStart();
        return v0;
    }

    public Drawable getLogo() {
        Drawable v0 = this.i != null ? this.i.getDrawable() : null;
        return v0;
    }

    public CharSequence getLogoDescription() {
        CharSequence v0 = this.i != null ? this.i.getContentDescription() : null;
        return v0;
    }

    public Menu getMenu() {
        this.n();
        return this.e.getMenu();
    }

    private MenuInflater getMenuInflater() {
        return new g(this.getContext());
    }

    public CharSequence getNavigationContentDescription() {
        CharSequence v0 = this.h != null ? this.h.getContentDescription() : null;
        return v0;
    }

    public Drawable getNavigationIcon() {
        Drawable v0 = this.h != null ? this.h.getDrawable() : null;
        return v0;
    }

    android.support.v7.widget.d getOuterActionMenuPresenter() {
        return this.J;
    }

    public Drawable getOverflowIcon() {
        this.n();
        return this.e.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.l;
    }

    public int getPopupTheme() {
        return this.m;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    public ad getWrapper() {
        if(this.I == null) {
            this.I = new ax(this, true);
        }

        return this.I;
    }

    public void h() {
        j v0 = this.K == null ? null : this.K.b;
        if(v0 != null) {
            v0.collapseActionView();
        }
    }

    void i() {
        if(this.a == null) {
            this.a = new n(this.getContext(), null, android.support.v7.a.a$a.toolbarNavigationButtonStyle);
            this.a.setImageDrawable(this.j);
            this.a.setContentDescription(this.k);
            b v0 = this.j();
            v0.a = 0x800003 | this.c & 0x70;
            v0.b = 2;
            this.a.setLayoutParams(((ViewGroup$LayoutParams)v0));
            this.a.setOnClickListener(new View$OnClickListener() {
                public void onClick(View arg2) {
                    this.a.h();
                }
            });
        }
    }

    protected b j() {
        return new b(-2, -2);
    }

    void k() {
        int v1;
        for(v1 = this.getChildCount() - 1; v1 >= 0; --v1) {
            View v2 = this.getChildAt(v1);
            if(v2.getLayoutParams().b != 2 && v2 != this.e) {
                this.removeViewAt(v1);
                this.F.add(v2);
            }
        }
    }

    void l() {
        int v1;
        for(v1 = this.F.size() - 1; v1 >= 0; --v1) {
            this.addView(this.F.get(v1));
        }

        this.F.clear();
    }

    private void m() {
        if(this.i == null) {
            this.i = new android.support.v7.widget.p(this.getContext());
        }
    }

    private void n() {
        this.o();
        if(this.e.d() == null) {
            Menu v0 = this.e.getMenu();
            if(this.K == null) {
                this.K = new a(this);
            }

            this.e.setExpandedActionViewsExclusive(true);
            ((h)v0).a(this.K, this.l);
        }
    }

    private void o() {
        if(this.e == null) {
            this.e = new ActionMenuView(this.getContext());
            this.e.setPopupTheme(this.m);
            this.e.setOnMenuItemClickListener(this.H);
            this.e.a(this.L, this.M);
            b v0 = this.j();
            v0.a = 0x800005 | this.c & 0x70;
            this.e.setLayoutParams(((ViewGroup$LayoutParams)v0));
            this.a(this.e, false);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks(this.O);
    }

    public boolean onHoverEvent(MotionEvent arg6) {
        int v4 = 9;
        int v0 = arg6.getActionMasked();
        if(v0 == v4) {
            this.D = false;
        }

        if(!this.D) {
            boolean v1 = super.onHoverEvent(arg6);
            if(v0 == v4 && !v1) {
                this.D = true;
            }
        }

        if(v0 == 10 || v0 == 3) {
            this.D = false;
        }

        return 1;
    }

    protected void onLayout(boolean arg24, int arg25, int arg26, int arg27, int arg28) {
        int v10;
        int v9_1;
        int v11;
        ViewGroup$LayoutParams v2_1;
        int v4 = p.b(((View)this)) == 1 ? 1 : 0;
        int v12 = this.getWidth();
        int v13 = this.getHeight();
        int v6 = this.getPaddingLeft();
        int v14 = this.getPaddingRight();
        int v15 = this.getPaddingTop();
        int v16 = this.getPaddingBottom();
        int v3 = v12 - v14;
        int[] v17 = this.G;
        v17[1] = 0;
        v17[0] = 0;
        int v2 = p.c(((View)this));
        int v5 = v2 >= 0 ? Math.min(v2, arg28 - arg26) : 0;
        if(!this.a(this.h)) {
            v2 = v3;
            v3 = v6;
        }
        else if(v4 != 0) {
            v2 = this.b(this.h, v3, v17, v5);
            v3 = v6;
        }
        else {
            int v22 = v3;
            v3 = this.a(this.h, v6, v17, v5);
            v2 = v22;
        }

        if(this.a(this.a)) {
            if(v4 != 0) {
                v2 = this.b(this.a, v2, v17, v5);
            }
            else {
                v3 = this.a(this.a, v3, v17, v5);
            }
        }

        if(this.a(this.e)) {
            if(v4 != 0) {
                v3 = this.a(this.e, v3, v17, v5);
            }
            else {
                v2 = this.b(this.e, v2, v17, v5);
            }
        }

        int v7 = this.getCurrentContentInsetLeft();
        int v8 = this.getCurrentContentInsetRight();
        v17[0] = Math.max(0, v7 - v3);
        v17[1] = Math.max(0, v8 - (v12 - v14 - v2));
        v3 = Math.max(v3, v7);
        v2 = Math.min(v2, v12 - v14 - v8);
        if(this.a(this.b)) {
            if(v4 != 0) {
                v2 = this.b(this.b, v2, v17, v5);
            }
            else {
                v3 = this.a(this.b, v3, v17, v5);
            }
        }

        if(!this.a(this.i)) {
            v7 = v2;
            v8 = v3;
        }
        else if(v4 != 0) {
            v7 = this.b(this.i, v2, v17, v5);
            v8 = v3;
        }
        else {
            v7 = v2;
            v8 = this.a(this.i, v3, v17, v5);
        }

        boolean v18 = this.a(this.f);
        boolean v19 = this.a(this.g);
        v3 = 0;
        if(v18) {
            v2_1 = this.f.getLayoutParams();
            v3 = ((b)v2_1).bottomMargin + (((b)v2_1).topMargin + this.f.getMeasuredHeight());
        }

        if(v19) {
            v2_1 = this.g.getLayoutParams();
            v11 = ((b)v2_1).bottomMargin + (((b)v2_1).topMargin + this.g.getMeasuredHeight()) + v3;
        }
        else {
            v11 = v3;
        }

        if((v18) || (v19)) {
            TextView v9 = v18 ? this.f : this.g;
            TextView v3_1 = v19 ? this.g : this.f;
            v2_1 = ((View)v9).getLayoutParams();
            ViewGroup$LayoutParams v3_2 = ((View)v3_1).getLayoutParams();
            if(!v18 || this.f.getMeasuredWidth() <= 0) {
                if((v19) && this.g.getMeasuredWidth() > 0) {
                label_157:
                    v9_1 = 1;
                    goto label_158;
                }

                v9_1 = 0;
            }
            else {
                goto label_157;
            }

        label_158:
            switch(this.x & 0x70) {
                case 48: {
                    v10 = ((b)v2_1).topMargin + this.getPaddingTop() + this.s;
                    break;
                }
                case 80: {
                    v10 = v13 - v16 - ((b)v3_2).bottomMargin - this.t - v11;
                    break;
                }
                default: {
                    v10 = (v13 - v15 - v16 - v11) / 2;
                    if(v10 < ((b)v2_1).topMargin + this.s) {
                        v2 = ((b)v2_1).topMargin + this.s;
                    }
                    else {
                        v11 = v13 - v16 - v11 - v10 - v15;
                        v2 = v11 < ((b)v2_1).bottomMargin + this.t ? Math.max(0, v10 - (((b)v3_2).bottomMargin + this.t - v11)) : v10;
                    }

                    v10 = v15 + v2;
                    break;
                }
            }

            if(v4 != 0) {
                v2 = v9_1 != 0 ? this.q : 0;
                v2 -= v17[1];
                v3 = v7 - Math.max(0, v2);
                v17[1] = Math.max(0, -v2);
                if(v18) {
                    v2_1 = this.f.getLayoutParams();
                    v4 = v3 - this.f.getMeasuredWidth();
                    v7 = this.f.getMeasuredHeight() + v10;
                    this.f.layout(v4, v10, v3, v7);
                    v4 -= this.r;
                    v10 = v7 + ((b)v2_1).bottomMargin;
                    v7 = v4;
                }
                else {
                    v7 = v3;
                }

                if(v19) {
                    v4 = this.g.getLayoutParams().topMargin + v10;
                    this.g.layout(v3 - this.g.getMeasuredWidth(), v4, v3, this.g.getMeasuredHeight() + v4);
                    v2 = v3 - this.r;
                }
                else {
                    v2 = v3;
                }

                v2 = v9_1 != 0 ? Math.min(v7, v2) : v3;
                v7 = v2;
                goto label_241;
            }

            v2 = v9_1 != 0 ? this.q : 0;
            v2 -= v17[0];
            v8 += Math.max(0, v2);
            v17[0] = Math.max(0, -v2);
            if(v18) {
                v2_1 = this.f.getLayoutParams();
                v3 = this.f.getMeasuredWidth() + v8;
                v4 = this.f.getMeasuredHeight() + v10;
                this.f.layout(v8, v10, v3, v4);
                v3 += this.r;
                v2 = ((b)v2_1).bottomMargin + v4;
                v4 = v3;
                v3 = v2;
            }
            else {
                v4 = v8;
                v3 = v10;
            }

            if(v19) {
                v3 += this.g.getLayoutParams().topMargin;
                v10 = this.g.getMeasuredWidth() + v8;
                this.g.layout(v8, v3, v10, this.g.getMeasuredHeight() + v3);
                v2 = this.r + v10;
            }
            else {
                v2 = v8;
            }

            if(v9_1 == 0) {
                goto label_241;
            }

            v8 = Math.max(v4, v2);
        }

    label_241:
        this.a(this.E, 3);
        v9_1 = this.E.size();
        v4 = 0;
        v3 = v8;
        while(v4 < v9_1) {
            v3 = this.a(this.E.get(v4), v3, v17, v5);
            ++v4;
        }

        this.a(this.E, 5);
        v8 = this.E.size();
        for(v4 = 0; v4 < v8; ++v4) {
            v7 = this.b(this.E.get(v4), v7, v17, v5);
        }

        this.a(this.E, 1);
        v4 = this.a(this.E, v17);
        v2 = (v12 - v6 - v14) / 2 + v6 - v4 / 2;
        v4 += v2;
        if(v2 < v3) {
            v2 = v3;
        }
        else if(v4 > v7) {
            v2 -= v4 - v7;
        }

        v6 = this.E.size();
        v3 = 0;
        v4 = v2;
        while(v3 < v6) {
            v4 = this.a(this.E.get(v3), v4, v17, v5);
            ++v3;
        }

        this.E.clear();
    }

    protected void onMeasure(int arg14, int arg15) {
        int v2;
        int v8;
        int v7;
        int v11 = 0;
        int v9 = 0;
        int[] v10 = this.G;
        if(bc.a(((View)this))) {
            v7 = 0;
            v8 = 1;
        }
        else {
            v7 = 1;
            v8 = 0;
        }

        int v0 = 0;
        if(this.a(this.h)) {
            this.a(this.h, arg14, 0, arg15, 0, this.p);
            v0 = this.h.getMeasuredWidth() + this.b(this.h);
            v2 = Math.max(0, this.h.getMeasuredHeight() + this.c(this.h));
            v9 = View.combineMeasuredStates(0, this.h.getMeasuredState());
            v11 = v2;
        }

        if(this.a(this.a)) {
            this.a(this.a, arg14, 0, arg15, 0, this.p);
            v0 = this.a.getMeasuredWidth() + this.b(this.a);
            v11 = Math.max(v11, this.a.getMeasuredHeight() + this.c(this.a));
            v9 = View.combineMeasuredStates(v9, this.a.getMeasuredState());
        }

        int v1 = this.getCurrentContentInsetStart();
        int v3 = Math.max(v1, v0);
        v10[v8] = Math.max(0, v1 - v0);
        v0 = 0;
        if(this.a(this.e)) {
            this.a(this.e, arg14, v3, arg15, 0, this.p);
            v0 = this.e.getMeasuredWidth() + this.b(this.e);
            v11 = Math.max(v11, this.e.getMeasuredHeight() + this.c(this.e));
            v9 = View.combineMeasuredStates(v9, this.e.getMeasuredState());
        }

        v1 = this.getCurrentContentInsetEnd();
        v3 += Math.max(v1, v0);
        v10[v7] = Math.max(0, v1 - v0);
        if(this.a(this.b)) {
            v3 += this.a(this.b, arg14, v3, arg15, 0, v10);
            v11 = Math.max(v11, this.b.getMeasuredHeight() + this.c(this.b));
            v9 = View.combineMeasuredStates(v9, this.b.getMeasuredState());
        }

        if(this.a(this.i)) {
            v3 += this.a(this.i, arg14, v3, arg15, 0, v10);
            v11 = Math.max(v11, this.i.getMeasuredHeight() + this.c(this.i));
            v9 = View.combineMeasuredStates(v9, this.i.getMeasuredState());
        }

        v8 = this.getChildCount();
        v7 = 0;
        int v12 = v11;
        v11 = v9;
        while(v7 < v8) {
            View v1_1 = this.getChildAt(v7);
            if(v1_1.getLayoutParams().b != 0) {
                v0 = v11;
                v1 = v12;
            }
            else if(!this.a(v1_1)) {
                v0 = v11;
                v1 = v12;
            }
            else {
                v3 += this.a(v1_1, arg14, v3, arg15, 0, v10);
                v2 = Math.max(v12, v1_1.getMeasuredHeight() + this.c(v1_1));
                v0 = View.combineMeasuredStates(v11, v1_1.getMeasuredState());
                v1 = v2;
            }

            ++v7;
            v11 = v0;
            v12 = v1;
        }

        v1 = 0;
        v0 = 0;
        v9 = this.s + this.t;
        v2 = this.q + this.r;
        if(this.a(this.f)) {
            this.a(this.f, arg14, v3 + v2, arg15, v9, v10);
            v1 = this.b(this.f) + this.f.getMeasuredWidth();
            v0 = this.f.getMeasuredHeight() + this.c(this.f);
            v11 = View.combineMeasuredStates(v11, this.f.getMeasuredState());
        }

        if(this.a(this.g)) {
            v1 = Math.max(v1, this.a(this.g, arg14, v3 + v2, arg15, v9 + v0, v10));
            v0 += this.g.getMeasuredHeight() + this.c(this.g);
            v11 = View.combineMeasuredStates(v11, this.g.getMeasuredState());
        }

        v0 = Math.max(v12, v0);
        v1 = v1 + v3 + (this.getPaddingLeft() + this.getPaddingRight());
        v0 += this.getPaddingTop() + this.getPaddingBottom();
        v1 = View.resolveSizeAndState(Math.max(v1, this.getSuggestedMinimumWidth()), arg14, 0xFF000000 & v11);
        v0 = View.resolveSizeAndState(Math.max(v0, this.getSuggestedMinimumHeight()), arg15, v11 << 16);
        if(this.r()) {
            v0 = 0;
        }

        this.setMeasuredDimension(v1, v0);
    }

    protected void onRestoreInstanceState(Parcelable arg3) {
        if(!(arg3 instanceof d)) {
            super.onRestoreInstanceState(arg3);
        }
        else {
            super.onRestoreInstanceState(((d)arg3).a());
            h v0 = this.e != null ? this.e.d() : null;
            if(((d)arg3).b != 0 && this.K != null && v0 != null) {
                MenuItem v0_1 = ((Menu)v0).findItem(((d)arg3).b);
                if(v0_1 != null) {
                    v0_1.expandActionView();
                }
            }

            if(!((d)arg3).c) {
                return;
            }

            this.q();
        }
    }

    public void onRtlPropertiesChanged(int arg4) {
        boolean v0 = true;
        if(Build$VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(arg4);
        }

        this.s();
        ao v1 = this.u;
        if(arg4 != 1) {
            v0 = false;
        }

        v1.a(v0);
    }

    protected Parcelable onSaveInstanceState() {
        d v0 = new d(super.onSaveInstanceState());
        if(this.K != null && this.K.b != null) {
            v0.b = this.K.b.getItemId();
        }

        v0.c = this.b();
        return ((Parcelable)v0);
    }

    public boolean onTouchEvent(MotionEvent arg5) {
        int v0 = arg5.getActionMasked();
        if(v0 == 0) {
            this.C = false;
        }

        if(!this.C) {
            boolean v1 = super.onTouchEvent(arg5);
            if(v0 == 0 && !v1) {
                this.C = true;
            }
        }

        if(v0 == 1 || v0 == 3) {
            this.C = false;
        }

        return 1;
    }

    private void p() {
        if(this.h == null) {
            this.h = new n(this.getContext(), null, android.support.v7.a.a$a.toolbarNavigationButtonStyle);
            b v0 = this.j();
            v0.a = 0x800003 | this.c & 0x70;
            this.h.setLayoutParams(((ViewGroup$LayoutParams)v0));
        }
    }

    private void q() {
        this.removeCallbacks(this.O);
        this.post(this.O);
    }

    private boolean r() {
        boolean v0 = false;
        if(this.N) {
            int v2 = this.getChildCount();
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                View v3 = this.getChildAt(v1);
                if((this.a(v3)) && v3.getMeasuredWidth() > 0 && v3.getMeasuredHeight() > 0) {
                    return v0;
                }
            }

            v0 = true;
        }

        return v0;
    }

    private void s() {
        if(this.u == null) {
            this.u = new ao();
        }
    }

    public void setCollapsible(boolean arg1) {
        this.N = arg1;
        this.requestLayout();
    }

    public void setContentInsetEndWithActions(int arg2) {
        if(arg2 < 0) {
            arg2 = 0x80000000;
        }

        if(arg2 != this.w) {
            this.w = arg2;
            if(this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int arg2) {
        if(arg2 < 0) {
            arg2 = 0x80000000;
        }

        if(arg2 != this.v) {
            this.v = arg2;
            if(this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }

    public void setLogo(Drawable arg3) {
        if(arg3 != null) {
            this.m();
            if(!this.d(this.i)) {
                this.a(this.i, true);
            }
        }
        else if(this.i != null && (this.d(this.i))) {
            this.removeView(this.i);
            this.F.remove(this.i);
        }

        if(this.i != null) {
            this.i.setImageDrawable(arg3);
        }
    }

    public void setLogo(int arg2) {
        this.setLogo(android.support.v7.b.a.b.b(this.getContext(), arg2));
    }

    public void setLogoDescription(CharSequence arg2) {
        if(!TextUtils.isEmpty(arg2)) {
            this.m();
        }

        if(this.i != null) {
            this.i.setContentDescription(arg2);
        }
    }

    public void setLogoDescription(int arg2) {
        this.setLogoDescription(this.getContext().getText(arg2));
    }

    public void setNavigationContentDescription(CharSequence arg2) {
        if(!TextUtils.isEmpty(arg2)) {
            this.p();
        }

        if(this.h != null) {
            this.h.setContentDescription(arg2);
        }
    }

    public void setNavigationContentDescription(int arg2) {
        CharSequence v0 = arg2 != 0 ? this.getContext().getText(arg2) : null;
        this.setNavigationContentDescription(v0);
    }

    public void setNavigationIcon(Drawable arg3) {
        if(arg3 != null) {
            this.p();
            if(!this.d(this.h)) {
                this.a(this.h, true);
            }
        }
        else if(this.h != null && (this.d(this.h))) {
            this.removeView(this.h);
            this.F.remove(this.h);
        }

        if(this.h != null) {
            this.h.setImageDrawable(arg3);
        }
    }

    public void setNavigationIcon(int arg2) {
        this.setNavigationIcon(android.support.v7.b.a.b.b(this.getContext(), arg2));
    }

    public void setNavigationOnClickListener(View$OnClickListener arg2) {
        this.p();
        this.h.setOnClickListener(arg2);
    }

    public void setOnMenuItemClickListener(android.support.v7.widget.Toolbar$c arg1) {
        this.d = arg1;
    }

    public void setOverflowIcon(Drawable arg2) {
        this.n();
        this.e.setOverflowIcon(arg2);
    }

    public void setPopupTheme(int arg3) {
        if(this.m != arg3) {
            this.m = arg3;
            this.l = arg3 == 0 ? this.getContext() : new ContextThemeWrapper(this.getContext(), arg3);
        }
    }

    public void setSubtitle(CharSequence arg4) {
        if(!TextUtils.isEmpty(arg4)) {
            if(this.g == null) {
                Context v0 = this.getContext();
                this.g = new aa(v0);
                this.g.setSingleLine();
                this.g.setEllipsize(TextUtils$TruncateAt.END);
                if(this.o != 0) {
                    this.g.setTextAppearance(v0, this.o);
                }

                if(this.B == 0) {
                    goto label_23;
                }

                this.g.setTextColor(this.B);
            }

        label_23:
            if(this.d(this.g)) {
                goto label_29;
            }

            this.a(this.g, true);
        }
        else {
            if(this.g == null) {
                goto label_29;
            }

            if(!this.d(this.g)) {
                goto label_29;
            }

            this.removeView(this.g);
            this.F.remove(this.g);
        }

    label_29:
        if(this.g != null) {
            this.g.setText(arg4);
        }

        this.z = arg4;
    }

    public void setSubtitle(int arg2) {
        this.setSubtitle(this.getContext().getText(arg2));
    }

    public void setSubtitleTextColor(int arg2) {
        this.B = arg2;
        if(this.g != null) {
            this.g.setTextColor(arg2);
        }
    }

    public void setTitle(CharSequence arg4) {
        if(!TextUtils.isEmpty(arg4)) {
            if(this.f == null) {
                Context v0 = this.getContext();
                this.f = new aa(v0);
                this.f.setSingleLine();
                this.f.setEllipsize(TextUtils$TruncateAt.END);
                if(this.n != 0) {
                    this.f.setTextAppearance(v0, this.n);
                }

                if(this.A == 0) {
                    goto label_23;
                }

                this.f.setTextColor(this.A);
            }

        label_23:
            if(this.d(this.f)) {
                goto label_29;
            }

            this.a(this.f, true);
        }
        else {
            if(this.f == null) {
                goto label_29;
            }

            if(!this.d(this.f)) {
                goto label_29;
            }

            this.removeView(this.f);
            this.F.remove(this.f);
        }

    label_29:
        if(this.f != null) {
            this.f.setText(arg4);
        }

        this.y = arg4;
    }

    public void setTitle(int arg2) {
        this.setTitle(this.getContext().getText(arg2));
    }

    public void setTitleMarginBottom(int arg1) {
        this.t = arg1;
        this.requestLayout();
    }

    public void setTitleMarginEnd(int arg1) {
        this.r = arg1;
        this.requestLayout();
    }

    public void setTitleMarginStart(int arg1) {
        this.q = arg1;
        this.requestLayout();
    }

    public void setTitleMarginTop(int arg1) {
        this.s = arg1;
        this.requestLayout();
    }

    public void setTitleTextColor(int arg2) {
        this.A = arg2;
        if(this.f != null) {
            this.f.setTextColor(arg2);
        }
    }
}

