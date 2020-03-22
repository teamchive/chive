package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.a;
import android.support.v4.h.p;
import android.support.v7.a.a$j;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.SeekBar;

class w extends s {
    private final SeekBar a;
    private Drawable b;
    private ColorStateList c;
    private PorterDuff$Mode d;
    private boolean e;
    private boolean f;

    w(SeekBar arg3) {
        super(((ProgressBar)arg3));
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = false;
        this.a = arg3;
    }

    void a(AttributeSet arg5, int arg6) {
        super.a(arg5, arg6);
        aw v0 = aw.a(this.a.getContext(), arg5, j.AppCompatSeekBar, arg6, 0);
        Drawable v1 = v0.b(j.AppCompatSeekBar_android_thumb);
        if(v1 != null) {
            this.a.setThumb(v1);
        }

        this.a(v0.a(j.AppCompatSeekBar_tickMark));
        if(v0.g(j.AppCompatSeekBar_tickMarkTintMode)) {
            this.d = ae.a(v0.a(j.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
            this.f = true;
        }

        if(v0.g(j.AppCompatSeekBar_tickMarkTint)) {
            this.c = v0.e(j.AppCompatSeekBar_tickMarkTint);
            this.e = true;
        }

        v0.a();
        this.d();
    }

    void a(Canvas arg7) {
        int v0 = 1;
        if(this.b != null) {
            int v2 = this.a.getMax();
            if(v2 > 1) {
                int v1 = this.b.getIntrinsicWidth();
                int v3 = this.b.getIntrinsicHeight();
                if(v1 >= 0) {
                    v1 /= 2;
                }
                else {
                    v1 = 1;
                }

                if(v3 >= 0) {
                    v0 = v3 / 2;
                }

                this.b.setBounds(-v1, -v0, v1, v0);
                float v1_1 = (((float)(this.a.getWidth() - this.a.getPaddingLeft() - this.a.getPaddingRight()))) / (((float)v2));
                v3 = arg7.save();
                arg7.translate(((float)this.a.getPaddingLeft()), ((float)(this.a.getHeight() / 2)));
                for(v0 = 0; v0 <= v2; ++v0) {
                    this.b.draw(arg7);
                    arg7.translate(v1_1, 0f);
                }

                arg7.restoreToCount(v3);
            }
        }
    }

    void a(Drawable arg3) {
        if(this.b != null) {
            this.b.setCallback(null);
        }

        this.b = arg3;
        if(arg3 != null) {
            arg3.setCallback(this.a);
            a.b(arg3, p.b(this.a));
            if(arg3.isStateful()) {
                arg3.setState(this.a.getDrawableState());
            }

            this.d();
        }

        this.a.invalidate();
    }

    void b() {
        if(this.b != null) {
            this.b.jumpToCurrentState();
        }
    }

    void c() {
        Drawable v0 = this.b;
        if(v0 != null && (v0.isStateful()) && (v0.setState(this.a.getDrawableState()))) {
            this.a.invalidateDrawable(v0);
        }
    }

    private void d() {
        if(this.b != null && ((this.e) || (this.f))) {
            this.b = a.f(this.b.mutate());
            if(this.e) {
                a.a(this.b, this.c);
            }

            if(this.f) {
                a.a(this.b, this.d);
            }

            if(!this.b.isStateful()) {
                return;
            }

            this.b.setState(this.a.getDrawableState());
        }
    }
}

