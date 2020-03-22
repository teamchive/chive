package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.a.a$a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RatingBar;

public class u extends RatingBar {
    private final s a;

    public u(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, a.ratingBarStyle);
    }

    public u(Context arg2, AttributeSet arg3, int arg4) {
        super(arg2, arg3, arg4);
        this.a = new s(((ProgressBar)this));
        this.a.a(arg3, arg4);
    }

    protected void onMeasure(int arg3, int arg4) {
        __monitor_enter(this);
        try {
            super.onMeasure(arg3, arg4);
            Bitmap v0_1 = this.a.a();
            if(v0_1 != null) {
                this.setMeasuredDimension(View.resolveSizeAndState(v0_1.getWidth() * this.getNumStars(), arg3, 0), this.getMeasuredHeight());
            }
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
    }
}

