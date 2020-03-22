package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.s;
import android.view.MotionEvent;
import android.view.View$OnAttachStateChangeListener;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ListView;

public abstract class ah implements View$OnAttachStateChangeListener, View$OnTouchListener {
    class a implements Runnable {
        a(ah arg1) {
            this.a = arg1;
            super();
        }

        public void run() {
            ViewParent v0 = this.a.c.getParent();
            if(v0 != null) {
                v0.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    class b implements Runnable {
        b(ah arg1) {
            this.a = arg1;
            super();
        }

        public void run() {
            this.a.d();
        }
    }

    private final float a;
    private final int b;
    final View c;
    private final int d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private int h;
    private final int[] i;

    public ah(View arg3) {
        super();
        this.i = new int[2];
        this.c = arg3;
        arg3.setLongClickable(true);
        arg3.addOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
        this.a = ((float)ViewConfiguration.get(arg3.getContext()).getScaledTouchSlop());
        this.b = ViewConfiguration.getTapTimeout();
        this.d = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean a(MotionEvent arg7) {
        boolean v0 = false;
        View v2 = this.c;
        if(v2.isEnabled()) {
            switch(arg7.getActionMasked()) {
                case 0: {
                    goto label_9;
                }
                case 2: {
                    goto label_30;
                }
                case 1: 
                case 3: {
                    goto label_43;
                }
            }

            return v0;
        label_9:
            this.h = arg7.getPointerId(0);
            if(this.e == null) {
                this.e = new a(this);
            }

            v2.postDelayed(this.e, ((long)this.b));
            if(this.f == null) {
                this.f = new b(this);
            }

            v2.postDelayed(this.f, ((long)this.d));
            return v0;
        label_43:
            this.e();
            return v0;
        label_30:
            int v3 = arg7.findPointerIndex(this.h);
            if(v3 < 0) {
                return v0;
            }

            if(ah.a(v2, arg7.getX(v3), arg7.getY(v3), this.a)) {
                return v0;
            }

            this.e();
            v2.getParent().requestDisallowInterceptTouchEvent(true);
            v0 = true;
        }

        return v0;
    }

    private static boolean a(View arg2, float arg3, float arg4, float arg5) {
        boolean v0 = arg3 < -arg5 || arg4 < -arg5 || arg3 >= (((float)(arg2.getRight() - arg2.getLeft()))) + arg5 || arg4 >= (((float)(arg2.getBottom() - arg2.getTop()))) + arg5 ? false : true;
        return v0;
    }

    private boolean a(View arg4, MotionEvent arg5) {
        int[] v0 = this.i;
        arg4.getLocationOnScreen(v0);
        arg5.offsetLocation(((float)(-v0[0])), ((float)(-v0[1])));
        return 1;
    }

    public abstract s a();

    private boolean b(MotionEvent arg6) {
        boolean v2 = false;
        View v3 = this.c;
        s v0 = this.a();
        if(v0 != null && (v0.d())) {
            ListView v0_1 = v0.e();
            if(v0_1 != null && (((af)v0_1).isShown())) {
                MotionEvent v4 = MotionEvent.obtainNoHistory(arg6);
                this.b(v3, v4);
                this.a(((View)v0_1), v4);
                boolean v3_1 = ((af)v0_1).a(v4, this.h);
                v4.recycle();
                int v0_2 = arg6.getActionMasked();
                v0_2 = v0_2 == 1 || v0_2 == 3 ? 0 : 1;
                boolean v0_3 = !v3_1 || v0_2 == 0 ? false : true;
                v2 = v0_3;
            }
        }

        return v2;
    }

    private boolean b(View arg4, MotionEvent arg5) {
        int[] v0 = this.i;
        arg4.getLocationOnScreen(v0);
        arg5.offsetLocation(((float)v0[0]), ((float)v0[1]));
        return 1;
    }

    protected boolean b() {
        s v0 = this.a();
        if(v0 != null && !v0.d()) {
            v0.a();
        }

        return 1;
    }

    protected boolean c() {
        s v0 = this.a();
        if(v0 != null && (v0.d())) {
            v0.c();
        }

        return 1;
    }

    void d() {
        this.e();
        View v8 = this.c;
        if((v8.isEnabled()) && !v8.isLongClickable() && (this.b())) {
            v8.getParent().requestDisallowInterceptTouchEvent(true);
            long v0 = SystemClock.uptimeMillis();
            MotionEvent v0_1 = MotionEvent.obtain(v0, v0, 3, 0f, 0f, 0);
            v8.onTouchEvent(v0_1);
            v0_1.recycle();
            this.g = true;
        }
    }

    private void e() {
        if(this.f != null) {
            this.c.removeCallbacks(this.f);
        }

        if(this.e != null) {
            this.c.removeCallbacks(this.e);
        }
    }

    public boolean onTouch(View arg12, MotionEvent arg13) {
        boolean v0;
        boolean v7 = false;
        boolean v10 = this.g;
        if(v10) {
            if(!this.b(arg13) && (this.c())) {
                v0 = false;
                goto label_10;
            }

            v0 = true;
        }
        else {
            boolean v9 = !this.a(arg13) || !this.b() ? false : true;
            if(v9) {
                long v0_1 = SystemClock.uptimeMillis();
                MotionEvent v0_2 = MotionEvent.obtain(v0_1, v0_1, 3, 0f, 0f, 0);
                this.c.onTouchEvent(v0_2);
                v0_2.recycle();
            }

            v0 = v9;
        }

    label_10:
        this.g = v0;
        if((v0) || (v10)) {
            v7 = true;
        }

        return v7;
    }

    public void onViewAttachedToWindow(View arg1) {
    }

    public void onViewDetachedFromWindow(View arg3) {
        this.g = false;
        this.h = -1;
        if(this.e != null) {
            this.c.removeCallbacks(this.e);
        }
    }
}

