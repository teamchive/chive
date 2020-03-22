package android.support.v7.widget;

import android.support.v4.h.p;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View$OnAttachStateChangeListener;
import android.view.View$OnHoverListener;
import android.view.View$OnLongClickListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

class az implements View$OnAttachStateChangeListener, View$OnHoverListener, View$OnLongClickListener {
    class android.support.v7.widget.az$1 implements Runnable {
        android.support.v7.widget.az$1(az arg1) {
            this.a = arg1;
            super();
        }

        public void run() {
            az.a(this.a, false);
        }
    }

    class android.support.v7.widget.az$2 implements Runnable {
        android.support.v7.widget.az$2(az arg1) {
            this.a = arg1;
            super();
        }

        public void run() {
            az.a(this.a);
        }
    }

    private final View a;
    private final CharSequence b;
    private final Runnable c;
    private final Runnable d;
    private int e;
    private int f;
    private ba g;
    private boolean h;
    private static az i;

    private az(View arg2, CharSequence arg3) {
        super();
        this.c = new android.support.v7.widget.az$1(this);
        this.d = new android.support.v7.widget.az$2(this);
        this.a = arg2;
        this.b = arg3;
        this.a.setOnLongClickListener(((View$OnLongClickListener)this));
        this.a.setOnHoverListener(((View$OnHoverListener)this));
    }

    public static void a(View arg2, CharSequence arg3) {
        View$OnLongClickListener v1 = null;
        if(TextUtils.isEmpty(arg3)) {
            if(az.i != null && az.i.a == arg2) {
                az.i.a();
            }

            arg2.setOnLongClickListener(v1);
            arg2.setLongClickable(false);
            arg2.setOnHoverListener(((View$OnHoverListener)v1));
        }
        else {
            new az(arg2, arg3);
        }
    }

    private void a() {
        az v1 = null;
        if(az.i == this) {
            az.i = v1;
            if(this.g != null) {
                this.g.a();
                this.g = ((ba)v1);
                this.a.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
            }
            else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }

        this.a.removeCallbacks(this.c);
        this.a.removeCallbacks(this.d);
    }

    static void a(az arg0) {
        arg0.a();
    }

    static void a(az arg0, boolean arg1) {
        arg0.a(arg1);
    }

    private void a(boolean arg7) {
        long v0;
        if(p.m(this.a)) {
            if(az.i != null) {
                az.i.a();
            }

            az.i = this;
            this.h = arg7;
            this.g = new ba(this.a.getContext());
            this.g.a(this.a, this.e, this.f, this.h, this.b);
            this.a.addOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
            if(this.h) {
                v0 = 2500;
            }
            else if((p.f(this.a) & 1) == 1) {
                v0 = 3000 - (((long)ViewConfiguration.getLongPressTimeout()));
            }
            else {
                v0 = 15000 - (((long)ViewConfiguration.getLongPressTimeout()));
            }

            this.a.removeCallbacks(this.d);
            this.a.postDelayed(this.d, v0);
        }
    }

    public boolean onHover(View arg6, MotionEvent arg7) {
        if(this.g == null || !this.h) {
            Object v0 = this.a.getContext().getSystemService("accessibility");
            if((((AccessibilityManager)v0).isEnabled()) && (((AccessibilityManager)v0).isTouchExplorationEnabled())) {
                return 0;
            }

            switch(arg7.getAction()) {
                case 7: {
                    goto label_17;
                }
                case 10: {
                    goto label_37;
                }
            }

            return 0;
        label_17:
            if(!this.a.isEnabled()) {
                return 0;
            }

            if(this.g != null) {
                return 0;
            }

            this.e = ((int)arg7.getX());
            this.f = ((int)arg7.getY());
            this.a.removeCallbacks(this.c);
            this.a.postDelayed(this.c, ((long)ViewConfiguration.getLongPressTimeout()));
            return 0;
        label_37:
            this.a();
        }

        return 0;
    }

    public boolean onLongClick(View arg3) {
        this.e = arg3.getWidth() / 2;
        this.f = arg3.getHeight() / 2;
        this.a(true);
        return 1;
    }

    public void onViewAttachedToWindow(View arg1) {
    }

    public void onViewDetachedFromWindow(View arg1) {
        this.a();
    }
}

