package android.support.v4.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.os.Build$VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class r {
    class a implements s {
        r a;
        boolean b;

        a(r arg1) {
            super();
            this.a = arg1;
        }

        public void a(View arg4) {
            Paint v1 = null;
            this.b = false;
            if(this.a.c > -1) {
                arg4.setLayerType(2, v1);
            }

            if(this.a.a != null) {
                Runnable v0 = this.a.a;
                this.a.a = ((Runnable)v1);
                v0.run();
            }

            Object v0_1 = arg4.getTag(0x7E000000);
            if(!(v0_1 instanceof s)) {
                v0_1 = v1;
            }

            if(v0_1 != null) {
                ((s)v0_1).a(arg4);
            }
        }

        public void b(View arg4) {
            int v2 = -1;
            Paint v1 = null;
            if(this.a.c > v2) {
                arg4.setLayerType(this.a.c, v1);
                this.a.c = v2;
            }

            if(Build$VERSION.SDK_INT >= 16 || !this.b) {
                if(this.a.b != null) {
                    Runnable v0 = this.a.b;
                    this.a.b = ((Runnable)v1);
                    v0.run();
                }

                Object v0_1 = arg4.getTag(0x7E000000);
                if(!(v0_1 instanceof s)) {
                    v0_1 = v1;
                }

                if(v0_1 != null) {
                    ((s)v0_1).b(arg4);
                }

                this.b = true;
            }
        }

        public void c(View arg4) {
            Object v0 = arg4.getTag(0x7E000000);
            Object v1 = null;
            if(!(v0 instanceof s)) {
                v0 = v1;
            }

            if(v0 != null) {
                ((s)v0).c(arg4);
            }
        }
    }

    Runnable a;
    Runnable b;
    int c;
    private WeakReference d;

    r(View arg2) {
        super();
        this.a = null;
        this.b = null;
        this.c = -1;
        this.d = new WeakReference(arg2);
    }

    private void a(View arg3, s arg4) {
        if(arg4 != null) {
            arg3.animate().setListener(new AnimatorListenerAdapter(arg4, arg3) {
                public void onAnimationCancel(Animator arg3) {
                    this.a.c(this.b);
                }

                public void onAnimationEnd(Animator arg3) {
                    this.a.b(this.b);
                }

                public void onAnimationStart(Animator arg3) {
                    this.a.a(this.b);
                }
            });
        }
        else {
            arg3.animate().setListener(null);
        }
    }

    public long a() {
        Object v0 = this.d.get();
        long v0_1 = v0 != null ? ((View)v0).animate().getDuration() : 0;
        return v0_1;
    }

    public r a(float arg2) {
        Object v0 = this.d.get();
        if(v0 != null) {
            ((View)v0).animate().alpha(arg2);
        }

        return this;
    }

    public r a(long arg2) {
        Object v0 = this.d.get();
        if(v0 != null) {
            ((View)v0).animate().setDuration(arg2);
        }

        return this;
    }

    public r a(s arg4) {
        Object v0 = this.d.get();
        if(v0 != null) {
            if(Build$VERSION.SDK_INT >= 16) {
                this.a(((View)v0), arg4);
            }
            else {
                ((View)v0).setTag(0x7E000000, arg4);
                this.a(((View)v0), new a(this));
            }
        }

        return this;
    }

    public r a(u arg4) {
        Object v0 = this.d.get();
        if(v0 != null && Build$VERSION.SDK_INT >= 19) {
            ValueAnimator$AnimatorUpdateListener v1 = null;
            if(arg4 != null) {
                android.support.v4.h.r$2 v1_1 = new ValueAnimator$AnimatorUpdateListener(arg4, ((View)v0)) {
                    public void onAnimationUpdate(ValueAnimator arg3) {
                        this.a.a(this.b);
                    }
                };
            }

            ((View)v0).animate().setUpdateListener(v1);
        }

        return this;
    }

    public r a(Interpolator arg2) {
        Object v0 = this.d.get();
        if(v0 != null) {
            ((View)v0).animate().setInterpolator(((TimeInterpolator)arg2));
        }

        return this;
    }

    public r b(float arg2) {
        Object v0 = this.d.get();
        if(v0 != null) {
            ((View)v0).animate().translationY(arg2);
        }

        return this;
    }

    public r b(long arg2) {
        Object v0 = this.d.get();
        if(v0 != null) {
            ((View)v0).animate().setStartDelay(arg2);
        }

        return this;
    }

    public void b() {
        Object v0 = this.d.get();
        if(v0 != null) {
            ((View)v0).animate().cancel();
        }
    }

    public void c() {
        Object v0 = this.d.get();
        if(v0 != null) {
            ((View)v0).animate().start();
        }
    }
}

