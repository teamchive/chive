package android.support.v4.app;

import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewTreeObserver$OnPreDrawListener;
import android.view.ViewTreeObserver;

class OneShotPreDrawListener implements View$OnAttachStateChangeListener, ViewTreeObserver$OnPreDrawListener {
    private final Runnable mRunnable;
    private final View mView;
    private ViewTreeObserver mViewTreeObserver;

    private OneShotPreDrawListener(View arg2, Runnable arg3) {
        super();
        this.mView = arg2;
        this.mViewTreeObserver = arg2.getViewTreeObserver();
        this.mRunnable = arg3;
    }

    public static OneShotPreDrawListener add(View arg2, Runnable arg3) {
        OneShotPreDrawListener v0 = new OneShotPreDrawListener(arg2, arg3);
        arg2.getViewTreeObserver().addOnPreDrawListener(((ViewTreeObserver$OnPreDrawListener)v0));
        arg2.addOnAttachStateChangeListener(((View$OnAttachStateChangeListener)v0));
        return v0;
    }

    public boolean onPreDraw() {
        this.removeListener();
        this.mRunnable.run();
        return 1;
    }

    public void onViewAttachedToWindow(View arg2) {
        this.mViewTreeObserver = arg2.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View arg1) {
        this.removeListener();
    }

    public void removeListener() {
        if(this.mViewTreeObserver.isAlive()) {
            this.mViewTreeObserver.removeOnPreDrawListener(((ViewTreeObserver$OnPreDrawListener)this));
        }
        else {
            this.mView.getViewTreeObserver().removeOnPreDrawListener(((ViewTreeObserver$OnPreDrawListener)this));
        }

        this.mView.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
    }
}

