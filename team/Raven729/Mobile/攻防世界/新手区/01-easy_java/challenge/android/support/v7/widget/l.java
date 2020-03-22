package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build$VERSION;
import android.support.b.a.i;
import android.support.v4.g.f;
import android.support.v4.g.g;
import android.support.v7.a.a$e;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class l {
    class a implements c {
        a() {
            super();
        }

        public Drawable a(Context arg4, XmlPullParser arg5, AttributeSet arg6, Resources$Theme arg7) {
            Drawable v0_2;
            try {
                android.support.b.a.c v0_1 = android.support.b.a.c.a(arg4, arg4.getResources(), arg5, arg6, arg7);
            }
            catch(Exception v0) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", ((Throwable)v0));
                v0_2 = null;
            }

            return v0_2;
        }
    }

    class b extends g {
        public b(int arg1) {
            super(arg1);
        }

        PorterDuffColorFilter a(int arg2, PorterDuff$Mode arg3) {
            return this.a(Integer.valueOf(b.b(arg2, arg3)));
        }

        PorterDuffColorFilter a(int arg2, PorterDuff$Mode arg3, PorterDuffColorFilter arg4) {
            return this.a(Integer.valueOf(b.b(arg2, arg3)), arg4);
        }

        private static int b(int arg2, PorterDuff$Mode arg3) {
            return (arg2 + 0x1F) * 0x1F + arg3.hashCode();
        }
    }

    interface c {
        Drawable a(Context arg1, XmlPullParser arg2, AttributeSet arg3, Resources$Theme arg4);
    }

    class d implements c {
        d() {
            super();
        }

        public Drawable a(Context arg4, XmlPullParser arg5, AttributeSet arg6, Resources$Theme arg7) {
            i v0_1;
            try {
                v0_1 = i.a(arg4.getResources(), arg5, arg6, arg7);
            }
            catch(Exception v0) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", ((Throwable)v0));
                Drawable v0_2 = null;
            }

            return ((Drawable)v0_1);
        }
    }

    private static final PorterDuff$Mode a;
    private static l b;
    private static final b c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final int[] g;
    private static final int[] h;
    private static final int[] i;
    private WeakHashMap j;
    private android.support.v4.g.a k;
    private android.support.v4.g.l l;
    private final Object m;
    private final WeakHashMap n;
    private TypedValue o;
    private boolean p;

    static {
        l.a = PorterDuff$Mode.SRC_IN;
        l.c = new b(6);
        l.d = new int[]{e.abc_textfield_search_default_mtrl_alpha, e.abc_textfield_default_mtrl_alpha, e.abc_ab_share_pack_mtrl_alpha};
        l.e = new int[]{e.abc_ic_commit_search_api_mtrl_alpha, e.abc_seekbar_tick_mark_material, e.abc_ic_menu_share_mtrl_alpha, e.abc_ic_menu_copy_mtrl_am_alpha, e.abc_ic_menu_cut_mtrl_alpha, e.abc_ic_menu_selectall_mtrl_alpha, e.abc_ic_menu_paste_mtrl_am_alpha};
        l.f = new int[]{e.abc_textfield_activated_mtrl_alpha, e.abc_textfield_search_activated_mtrl_alpha, e.abc_cab_background_top_mtrl_alpha, e.abc_text_cursor_material, e.abc_text_select_handle_left_mtrl_dark, e.abc_text_select_handle_middle_mtrl_dark, e.abc_text_select_handle_right_mtrl_dark, e.abc_text_select_handle_left_mtrl_light, e.abc_text_select_handle_middle_mtrl_light, e.abc_text_select_handle_right_mtrl_light};
        l.g = new int[]{e.abc_popup_background_mtrl_mult, e.abc_cab_background_internal_bg, e.abc_menu_hardkey_panel_mtrl_mult};
        l.h = new int[]{e.abc_tab_indicator_material, e.abc_textfield_search_material};
        l.i = new int[]{e.abc_btn_check_material, e.abc_btn_radio_material};
    }

    public l() {
        super();
        this.m = new Object();
        this.n = new WeakHashMap(0);
    }

    public void a(Context arg3) {
        Object v1 = this.m;
        __monitor_enter(v1);
        try {
            Object v0_1 = this.n.get(arg3);
            if(v0_1 != null) {
                ((f)v0_1).c();
            }

            __monitor_exit(v1);
            return;
        label_9:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_9;
        }

        throw v0;
    }

    public static l a() {
        if(l.b == null) {
            l.b = new l();
            l.a(l.b);
        }

        return l.b;
    }

    public Drawable a(Context arg2, int arg3) {
        return this.a(arg2, arg3, false);
    }

    static boolean a(Context arg7, int arg8, Drawable arg9) {
        int v5_1;
        PorterDuff$Mode v6;
        int v4;
        int v2 = 0x1010031;
        int v3 = -1;
        boolean v0 = true;
        PorterDuff$Mode v5 = l.a;
        if(l.a(l.d, arg8)) {
            v4 = android.support.v7.a.a$a.colorControlNormal;
            v6 = v5;
            v5_1 = 1;
            v2 = v3;
        }
        else if(l.a(l.f, arg8)) {
            v4 = android.support.v7.a.a$a.colorControlActivated;
            v6 = v5;
            v5_1 = 1;
            v2 = v3;
        }
        else if(l.a(l.g, arg8)) {
            v5_1 = 1;
            v6 = PorterDuff$Mode.MULTIPLY;
            v4 = v2;
            v2 = v3;
        }
        else if(arg8 == e.abc_list_divider_mtrl_alpha) {
            v4 = 0x1010030;
            v2 = Math.round(40.799999f);
            v6 = v5;
            v5_1 = 1;
        }
        else if(arg8 == e.abc_dialog_material_background) {
            v4 = v2;
            v6 = v5;
            v5_1 = 1;
            v2 = v3;
        }
        else {
            v2 = v3;
            v4 = 0;
            v6 = v5;
            v5_1 = 0;
        }

        if(v5_1 != 0) {
            if(ae.b(arg9)) {
                arg9 = arg9.mutate();
            }

            arg9.setColorFilter(l.a(ar.a(arg7, v4), v6));
            if(v2 == v3) {
                return v0;
            }

            arg9.setAlpha(v2);
        }
        else {
            v0 = false;
        }

        return v0;
    }

    Drawable a(Context arg2, int arg3, boolean arg4) {
        this.f(arg2);
        Drawable v0 = this.d(arg2, arg3);
        if(v0 == null) {
            v0 = this.c(arg2, arg3);
        }

        if(v0 == null) {
            v0 = android.support.v4.b.a.a(arg2, arg3);
        }

        if(v0 != null) {
            v0 = this.a(arg2, arg3, arg4, v0);
        }

        if(v0 != null) {
            ae.a(v0);
        }

        return v0;
    }

    Drawable a(Context arg3, bb arg4, int arg5) {
        Drawable v0 = this.d(arg3, arg5);
        if(v0 == null) {
            v0 = arg4.a(arg5);
        }

        return v0 != null ? this.a(arg3, arg5, false, v0) : null;
    }

    static void a(Drawable arg2, au arg3, int[] arg4) {
        if(!ae.b(arg2) || arg2.mutate() == arg2) {
            if((arg3.d) || (arg3.c)) {
                ColorStateList v0 = arg3.d ? arg3.a : null;
                PorterDuff$Mode v1 = arg3.c ? arg3.b : l.a;
                arg2.setColorFilter(l.a(v0, v1, arg4));
            }
            else {
                arg2.clearColorFilter();
            }

            if(Build$VERSION.SDK_INT > 23) {
                return;
            }

            arg2.invalidateSelf();
        }
        else {
            Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
        }
    }

    private static long a(TypedValue arg4) {
        return (((long)arg4.assetCookie)) << 0x20 | (((long)arg4.data));
    }

    static PorterDuff$Mode a(int arg2) {
        PorterDuff$Mode v0 = null;
        if(arg2 == e.abc_switch_thumb_material) {
            v0 = PorterDuff$Mode.MULTIPLY;
        }

        return v0;
    }

    public static PorterDuffColorFilter a(int arg2, PorterDuff$Mode arg3) {
        PorterDuffColorFilter v0 = l.c.a(arg2, arg3);
        if(v0 == null) {
            v0 = new PorterDuffColorFilter(arg2, arg3);
            l.c.a(arg2, arg3, v0);
        }

        return v0;
    }

    private static PorterDuffColorFilter a(ColorStateList arg1, PorterDuff$Mode arg2, int[] arg3) {
        PorterDuffColorFilter v0 = arg1 == null || arg2 == null ? null : l.a(arg1.getColorForState(arg3, 0), arg2);
        return v0;
    }

    private Drawable a(Context arg7, int arg8, boolean arg9, Drawable arg10) {
        int v5 = 0x102000F;
        int v4 = 0x102000D;
        int v1 = 0x1020000;
        ColorStateList v0 = this.b(arg7, arg8);
        if(v0 != null) {
            if(ae.b(arg10)) {
                arg10 = arg10.mutate();
            }

            arg10 = android.support.v4.c.a.a.f(arg10);
            android.support.v4.c.a.a.a(arg10, v0);
            PorterDuff$Mode v0_1 = l.a(arg8);
            if(v0_1 == null) {
                return arg10;
            }

            android.support.v4.c.a.a.a(arg10, v0_1);
        }
        else {
            if(arg8 == e.abc_seekbar_track_material) {
                l.a(arg10.findDrawableByLayerId(v1), ar.a(arg7, android.support.v7.a.a$a.colorControlNormal), l.a);
                l.a(arg10.findDrawableByLayerId(v5), ar.a(arg7, android.support.v7.a.a$a.colorControlNormal), l.a);
                l.a(arg10.findDrawableByLayerId(v4), ar.a(arg7, android.support.v7.a.a$a.colorControlActivated), l.a);
                return arg10;
            }

            if(arg8 != e.abc_ratingbar_material && arg8 != e.abc_ratingbar_indicator_material && arg8 != e.abc_ratingbar_small_material) {
                if(l.a(arg7, arg8, arg10)) {
                }
                else if(arg9) {
                    arg10 = null;
                }
                else {
                }

                return arg10;
            }

            l.a(arg10.findDrawableByLayerId(v1), ar.c(arg7, android.support.v7.a.a$a.colorControlNormal), l.a);
            l.a(arg10.findDrawableByLayerId(v5), ar.a(arg7, android.support.v7.a.a$a.colorControlActivated), l.a);
            l.a(arg10.findDrawableByLayerId(v4), ar.a(arg7, android.support.v7.a.a$a.colorControlActivated), l.a);
        }

        return arg10;
    }

    private static void a(Drawable arg1, int arg2, PorterDuff$Mode arg3) {
        if(ae.b(arg1)) {
            arg1 = arg1.mutate();
        }

        if(arg3 == null) {
            arg3 = l.a;
        }

        arg1.setColorFilter(l.a(arg2, arg3));
    }

    private Drawable a(Context arg5, long arg6) {
        Drawable v0_2;
        Drawable v2 = null;
        Object v3 = this.m;
        __monitor_enter(v3);
        try {
            Object v0_1 = this.n.get(arg5);
            if(v0_1 == null) {
                __monitor_exit(v3);
                v0_2 = v2;
            }
            else {
                Object v1 = ((f)v0_1).a(arg6);
                if(v1 != null) {
                    v1 = ((WeakReference)v1).get();
                    if(v1 != null) {
                        v0_2 = ((Drawable$ConstantState)v1).newDrawable(arg5.getResources());
                        __monitor_exit(v3);
                        return v0_2;
                    }
                    else {
                        ((f)v0_1).b(arg6);
                    }
                }

                __monitor_exit(v3);
                v0_2 = v2;
            }

            return v0_2;
        label_18:
            __monitor_exit(v3);
        }
        catch(Throwable v0) {
            goto label_18;
        }

        throw v0;
    }

    private static void a(l arg2) {
        if(Build$VERSION.SDK_INT < 24) {
            arg2.a("vector", new d());
            if(Build$VERSION.SDK_INT >= 11) {
                arg2.a("animated-vector", new a());
            }
        }
    }

    private void a(Context arg3, int arg4, ColorStateList arg5) {
        if(this.j == null) {
            this.j = new WeakHashMap();
        }

        Object v0 = this.j.get(arg3);
        if(v0 == null) {
            android.support.v4.g.l v0_1 = new android.support.v4.g.l();
            this.j.put(arg3, v0_1);
        }

        ((android.support.v4.g.l)v0).c(arg4, arg5);
    }

    private void a(String arg2, c arg3) {
        if(this.k == null) {
            this.k = new android.support.v4.g.a();
        }

        this.k.put(arg2, arg3);
    }

    private static boolean a(int[] arg4, int arg5) {
        boolean v0 = false;
        int v2 = arg4.length;
        int v1 = 0;
        while(v1 < v2) {
            if(arg4[v1] == arg5) {
                v0 = true;
            }
            else {
                ++v1;
                continue;
            }

            return v0;
        }

        return v0;
    }

    private boolean a(Context arg5, long arg6, Drawable arg8) {
        boolean v0_3;
        f v0_2;
        Object v2;
        Drawable$ConstantState v1 = arg8.getConstantState();
        if(v1 != null) {
            v2 = this.m;
            __monitor_enter(v2);
            try {
                Object v0_1 = this.n.get(arg5);
                if(v0_1 == null) {
                    v0_2 = new f();
                    this.n.put(arg5, v0_2);
                }

                v0_2.b(arg6, new WeakReference(v1));
                __monitor_exit(v2);
                v0_3 = true;
            }
            catch(Throwable v0) {
                goto label_18;
            }
        }
        else {
            v0_3 = false;
        }

        try {
            return v0_3;
        label_18:
            __monitor_exit(v2);
        }
        catch(Throwable v0) {
            goto label_18;
        }

        throw v0;
    }

    private static boolean a(Drawable arg2) {
        boolean v0 = ((arg2 instanceof i)) || ("android.graphics.drawable.VectorDrawable".equals(arg2.getClass().getName())) ? true : false;
        return v0;
    }

    ColorStateList b(Context arg3, int arg4) {
        ColorStateList v0 = this.e(arg3, arg4);
        if(v0 == null) {
            if(arg4 == e.abc_edit_text_material) {
                v0 = android.support.v7.b.a.b.a(arg3, android.support.v7.a.a$c.abc_tint_edittext);
            }
            else if(arg4 == e.abc_switch_track_mtrl_alpha) {
                v0 = android.support.v7.b.a.b.a(arg3, android.support.v7.a.a$c.abc_tint_switch_track);
            }
            else if(arg4 == e.abc_switch_thumb_material) {
                v0 = this.e(arg3);
            }
            else if(arg4 == e.abc_btn_default_mtrl_shape) {
                v0 = this.b(arg3);
            }
            else if(arg4 == e.abc_btn_borderless_material) {
                v0 = this.c(arg3);
            }
            else if(arg4 == e.abc_btn_colored_material) {
                v0 = this.d(arg3);
            }
            else {
                if(arg4 != e.abc_spinner_mtrl_am_alpha && arg4 != e.abc_spinner_textfield_background_material) {
                    if(l.a(l.e, arg4)) {
                        v0 = ar.b(arg3, android.support.v7.a.a$a.colorControlNormal);
                    }
                    else if(l.a(l.h, arg4)) {
                        v0 = android.support.v7.b.a.b.a(arg3, android.support.v7.a.a$c.abc_tint_default);
                    }
                    else if(l.a(l.i, arg4)) {
                        v0 = android.support.v7.b.a.b.a(arg3, android.support.v7.a.a$c.abc_tint_btn_checkable);
                    }
                    else if(arg4 == e.abc_seekbar_thumb_material) {
                        v0 = android.support.v7.b.a.b.a(arg3, android.support.v7.a.a$c.abc_tint_seek_thumb);
                    }
                    else {
                    }

                    goto label_6;
                }

                v0 = android.support.v7.b.a.b.a(arg3, android.support.v7.a.a$c.abc_tint_spinner);
            }

        label_6:
            if(v0 == null) {
                return v0;
            }

            this.a(arg3, arg4, v0);
        }

        return v0;
    }

    private ColorStateList b(Context arg2) {
        return this.f(arg2, ar.a(arg2, android.support.v7.a.a$a.colorButtonNormal));
    }

    private ColorStateList c(Context arg2) {
        return this.f(arg2, 0);
    }

    private Drawable c(Context arg9, int arg10) {
        LayerDrawable v0_1;
        if(this.o == null) {
            this.o = new TypedValue();
        }

        TypedValue v1 = this.o;
        arg9.getResources().getValue(arg10, v1, true);
        long v2 = l.a(v1);
        Drawable v0 = this.a(arg9, v2);
        if(v0 == null) {
            if(arg10 == e.abc_cab_background_top_material) {
                v0_1 = new LayerDrawable(new Drawable[]{this.a(arg9, e.abc_cab_background_internal_bg), this.a(arg9, e.abc_cab_background_top_mtrl_alpha)});
            }

            if((((Drawable)v0_1)) == null) {
                goto label_12;
            }

            ((Drawable)v0_1).setChangingConfigurations(v1.changingConfigurations);
            this.a(arg9, v2, ((Drawable)v0_1));
        }

    label_12:
        return ((Drawable)v0_1);
    }

    private ColorStateList d(Context arg2) {
        return this.f(arg2, ar.a(arg2, android.support.v7.a.a$a.colorAccent));
    }

    private Drawable d(Context arg10, int arg11) {
        Drawable v0_1;
        Object v0;
        Drawable v1 = null;
        int v8 = 2;
        if(this.k != null && !this.k.isEmpty()) {
            if(this.l != null) {
                v0 = this.l.a(arg11);
                if(!"appcompat_skip_skip".equals(v0)) {
                    if(v0 == null) {
                    }
                    else if(this.k.get(v0) == null) {
                        goto label_19;
                    }

                    goto label_24;
                }

            label_19:
                v0_1 = v1;
                return v0_1;
            }
            else {
                this.l = new android.support.v4.g.l();
            }

        label_24:
            if(this.o == null) {
                this.o = new TypedValue();
            }

            TypedValue v2 = this.o;
            Resources v0_2 = arg10.getResources();
            v0_2.getValue(arg11, v2, true);
            long v4 = l.a(v2);
            v1 = this.a(arg10, v4);
            if(v1 != null) {
                return v1;
            }

            if(v2.string == null) {
                goto label_58;
            }

            if(!v2.string.toString().endsWith(".xml")) {
                goto label_58;
            }

            try {
                XmlResourceParser v3 = v0_2.getXml(arg11);
                AttributeSet v6 = Xml.asAttributeSet(((XmlPullParser)v3));
                do {
                    int v0_4 = ((XmlPullParser)v3).next();
                    if(v0_4 == v8) {
                        break;
                    }
                }
                while(v0_4 != 1);

                if(v0_4 != v8) {
                    throw new XmlPullParserException("No start tag found");
                }

                String v0_5 = ((XmlPullParser)v3).getName();
                this.l.c(arg11, v0_5);
                v0 = this.k.get(v0_5);
                if(v0 != null) {
                    v1 = ((c)v0).a(arg10, ((XmlPullParser)v3), v6, arg10.getTheme());
                }

                if(v1 != null) {
                    v1.setChangingConfigurations(v2.changingConfigurations);
                    this.a(arg10, v4, v1);
                }
            }
            catch(Exception v0_3) {
                goto label_57;
            }

            v0_1 = v1;
            goto label_59;
        label_57:
            Log.e("AppCompatDrawableManager", "Exception while inflating drawable", ((Throwable)v0_3));
        label_58:
            v0_1 = v1;
        label_59:
            if(v0_1 != null) {
                return v0_1;
            }

            this.l.c(arg11, "appcompat_skip_skip");
        }
        else {
            v0_1 = v1;
        }

        return v0_1;
    }

    private ColorStateList e(Context arg8) {
        int v6 = 2;
        int[][] v0 = new int[3][];
        int[] v1 = new int[3];
        ColorStateList v2 = ar.b(arg8, android.support.v7.a.a$a.colorSwitchThumbNormal);
        if(v2 == null || !v2.isStateful()) {
            v0[0] = ar.a;
            v1[0] = ar.c(arg8, android.support.v7.a.a$a.colorSwitchThumbNormal);
            v0[1] = ar.e;
            v1[1] = ar.a(arg8, android.support.v7.a.a$a.colorControlActivated);
            v0[v6] = ar.h;
            v1[v6] = ar.a(arg8, android.support.v7.a.a$a.colorSwitchThumbNormal);
        }
        else {
            v0[0] = ar.a;
            v1[0] = v2.getColorForState(v0[0], 0);
            v0[1] = ar.e;
            v1[1] = ar.a(arg8, android.support.v7.a.a$a.colorControlActivated);
            v0[v6] = ar.h;
            v1[v6] = v2.getDefaultColor();
        }

        return new ColorStateList(v0, v1);
    }

    private ColorStateList e(Context arg3, int arg4) {
        ColorStateList v0_1;
        Object v0;
        ColorStateList v1 = null;
        if(this.j != null) {
            v0 = this.j.get(arg3);
            if(v0 != null) {
                v0 = ((android.support.v4.g.l)v0).a(arg4);
            }
            else {
                v0_1 = v1;
            }
        }
        else {
            v0_1 = v1;
        }

        return ((ColorStateList)v0);
    }

    private ColorStateList f(Context arg7, int arg8) {
        int[][] v0 = new int[4][];
        int[] v1 = new int[4];
        int v3 = ar.a(arg7, android.support.v7.a.a$a.colorControlHighlight);
        int v4 = ar.c(arg7, android.support.v7.a.a$a.colorButtonNormal);
        v0[0] = ar.a;
        v1[0] = v4;
        v0[1] = ar.d;
        v1[1] = android.support.v4.c.a.a(v3, arg8);
        v0[2] = ar.b;
        v1[2] = android.support.v4.c.a.a(v3, arg8);
        v0[3] = ar.h;
        v1[3] = arg8;
        return new ColorStateList(v0, v1);
    }

    private void f(Context arg3) {
        if(!this.p) {
            this.p = true;
            Drawable v0 = this.a(arg3, e.abc_vector_test);
            if(v0 != null && (l.a(v0))) {
                return;
            }
        }
        else {
            return;
        }

        this.p = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    }
}

