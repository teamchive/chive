package android.support.v4.a;

import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewTreeObserver$OnPreDrawListener;
import android.view.ViewTreeObserver;

class x implements View$OnAttachStateChangeListener, ViewTreeObserver$OnPreDrawListener {
    private final View a;
    private ViewTreeObserver b;
    private final Runnable c;

    private x(View arg2, Runnable arg3) {
        super();
        this.a = arg2;
        this.b = arg2.getViewTreeObserver();
        this.c = arg3;
    }

    public static x a(View arg2, Runnable arg3) {
        x v0 = new x(arg2, arg3);
        arg2.getViewTreeObserver().addOnPreDrawListener(((ViewTreeObserver$OnPreDrawListener)v0));
        arg2.addOnAttachStateChangeListener(((View$OnAttachStateChangeListener)v0));
        return v0;
    }

    public void a() {
        if(this.b.isAlive()) {
            this.b.removeOnPreDrawListener(((ViewTreeObserver$OnPreDrawListener)this));
        }
        else {
            this.a.getViewTreeObserver().removeOnPreDrawListener(((ViewTreeObserver$OnPreDrawListener)this));
        }

        this.a.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
    }

    public boolean onPreDraw() {
        this.a();
        this.c.run();
        return 1;
    }

    public void onViewAttachedToWindow(View arg2) {
        this.b = arg2.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View arg1) {
        this.a();
    }
}

