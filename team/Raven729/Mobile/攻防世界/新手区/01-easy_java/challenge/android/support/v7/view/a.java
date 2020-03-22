package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build$VERSION;
import android.support.v7.a.a$b;
import android.support.v7.a.a$d;
import android.support.v7.a.a$j;
import android.view.ViewConfiguration;

public class a {
    private Context a;

    private a(Context arg1) {
        super();
        this.a = arg1;
    }

    public static a a(Context arg1) {
        return new a(arg1);
    }

    public int a() {
        int v0_1;
        int v7 = 960;
        int v6 = 720;
        int v5 = 640;
        int v4 = 600;
        int v3 = 480;
        Configuration v0 = this.a.getResources().getConfiguration();
        int v1 = v0.screenWidthDp;
        int v2 = v0.screenHeightDp;
        if(v0.smallestScreenWidthDp > v4 || v1 > v4) {
        label_17:
            v0_1 = 5;
        }
        else {
            if(v1 > v7 && v2 > v6) {
                goto label_17;
            }

            if(v1 > v6 && v2 > v7) {
                goto label_17;
            }

            if(v1 < 500 && (v1 <= v5 || v2 <= v3) && (v1 <= v3 || v2 <= v5)) {
                if(v1 >= 360) {
                    v0_1 = 3;
                    return v0_1;
                }

                return 2;
            }

            v0_1 = 4;
        }

        return v0_1;
    }

    public boolean b() {
        boolean v0 = true;
        if(Build$VERSION.SDK_INT < 19 && (ViewConfiguration.get(this.a).hasPermanentMenuKey())) {
            v0 = false;
        }

        return v0;
    }

    public int c() {
        return this.a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean d() {
        return this.a.getResources().getBoolean(b.abc_action_bar_embed_tabs);
    }

    public int e() {
        TypedArray v1 = this.a.obtainStyledAttributes(null, j.ActionBar, android.support.v7.a.a$a.actionBarStyle, 0);
        int v0 = v1.getLayoutDimension(j.ActionBar_height, 0);
        Resources v2 = this.a.getResources();
        if(!this.d()) {
            v0 = Math.min(v0, v2.getDimensionPixelSize(d.abc_action_bar_stacked_max_height));
        }

        v1.recycle();
        return v0;
    }

    public boolean f() {
        boolean v0 = this.a.getApplicationInfo().targetSdkVersion < 14 ? true : false;
        return v0;
    }

    public int g() {
        return this.a.getResources().getDimensionPixelSize(d.abc_action_bar_stacked_tab_max_width);
    }
}

