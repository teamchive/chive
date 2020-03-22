package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.a.a$d;
import android.support.v7.a.a$f;
import android.support.v7.a.a$g;
import android.support.v7.a.a$i;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.WindowManager$LayoutParams;
import android.widget.TextView;

class ba {
    private final Context a;
    private final View b;
    private final TextView c;
    private final WindowManager$LayoutParams d;
    private final Rect e;
    private final int[] f;
    private final int[] g;

    ba(Context arg5) {
        super();
        this.d = new WindowManager$LayoutParams();
        this.e = new Rect();
        this.f = new int[2];
        this.g = new int[2];
        this.a = arg5;
        this.b = LayoutInflater.from(this.a).inflate(g.tooltip, null);
        this.c = this.b.findViewById(f.message);
        this.d.setTitle(this.getClass().getSimpleName());
        this.d.packageName = this.a.getPackageName();
        this.d.type = 1002;
        this.d.width = -2;
        this.d.height = -2;
        this.d.format = -3;
        this.d.windowAnimations = i.Animation_AppCompat_Tooltip;
        this.d.flags = 24;
    }

    void a() {
        if(this.b()) {
            this.a.getSystemService("window").removeView(this.b);
        }
    }

    void a(View arg7, int arg8, int arg9, boolean arg10, CharSequence arg11) {
        if(this.b()) {
            this.a();
        }

        this.c.setText(arg11);
        this.a(arg7, arg8, arg9, arg10, this.d);
        this.a.getSystemService("window").addView(this.b, this.d);
    }

    private static View a(View arg2) {
        View v0_1;
        Context v0 = arg2.getContext();
        while(true) {
            if(!(v0 instanceof ContextWrapper)) {
                break;
            }
            else if((v0 instanceof Activity)) {
                v0_1 = ((Activity)v0).getWindow().getDecorView();
            }
            else {
                v0 = ((ContextWrapper)v0).getBaseContext();
                continue;
            }

            return v0_1;
        }

        return arg2.getRootView();
    }

    private void a(View arg11, int arg12, int arg13, boolean arg14, WindowManager$LayoutParams arg15) {
        int v2;
        int v0 = this.a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_threshold);
        if(arg11.getWidth() < v0) {
            arg12 = arg11.getWidth() / 2;
        }

        if(arg11.getHeight() >= v0) {
            v0 = this.a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_extra_offset);
            v2 = arg13 + v0;
            v0 = arg13 - v0;
        }
        else {
            v2 = arg11.getHeight();
            v0 = 0;
        }

        arg15.gravity = 49;
        Resources v4 = this.a.getResources();
        int v3 = arg14 ? d.tooltip_y_offset_touch : d.tooltip_y_offset_non_touch;
        int v4_1 = v4.getDimensionPixelOffset(v3);
        View v5 = ba.a(arg11);
        if(v5 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
        }
        else {
            v5.getWindowVisibleDisplayFrame(this.e);
            if(this.e.left < 0 && this.e.top < 0) {
                Resources v6 = this.a.getResources();
                v3 = v6.getIdentifier("status_bar_height", "dimen", "android");
                v3 = v3 != 0 ? v6.getDimensionPixelSize(v3) : 0;
                DisplayMetrics v6_1 = v6.getDisplayMetrics();
                this.e.set(0, v3, v6_1.widthPixels, v6_1.heightPixels);
            }

            v5.getLocationOnScreen(this.g);
            arg11.getLocationOnScreen(this.f);
            this.f[0] -= this.g[0];
            this.f[1] -= this.g[1];
            arg15.x = this.f[0] + arg12 - this.e.width() / 2;
            int v1 = View$MeasureSpec.makeMeasureSpec(0, 0);
            this.b.measure(v1, v1);
            v1 = this.b.getMeasuredHeight();
            v0 = v0 + this.f[1] - v4_1 - v1;
            v2 = v2 + this.f[1] + v4_1;
            if(arg14) {
                if(v0 >= 0) {
                    arg15.y = v0;
                    return;
                }

                arg15.y = v2;
                return;
            }

            if(v1 + v2 <= this.e.height()) {
                arg15.y = v2;
                return;
            }

            arg15.y = v0;
        }
    }

    boolean b() {
        boolean v0 = this.b.getParent() != null ? true : false;
        return v0;
    }
}

