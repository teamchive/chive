package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.a.a$a;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class v extends SeekBar {
    private final w a;

    public v(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, a.seekBarStyle);
    }

    public v(Context arg2, AttributeSet arg3, int arg4) {
        super(arg2, arg3, arg4);
        this.a = new w(((SeekBar)this));
        this.a.a(arg3, arg4);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.c();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.a.b();
    }

    protected void onDraw(Canvas arg2) {
        __monitor_enter(this);
        try {
            super.onDraw(arg2);
            this.a.a(arg2);
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
    }
}

