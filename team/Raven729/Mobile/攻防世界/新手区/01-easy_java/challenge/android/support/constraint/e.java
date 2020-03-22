package android.support.constraint;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup$LayoutParams;

public class e extends View {
    public e(Context arg2) {
        super(arg2);
        super.setVisibility(8);
    }

    public void draw(Canvas arg1) {
    }

    protected void onMeasure(int arg2, int arg3) {
        this.setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int arg2) {
        ViewGroup$LayoutParams v0 = this.getLayoutParams();
        ((a)v0).a = arg2;
        this.setLayoutParams(v0);
    }

    public void setGuidelineEnd(int arg2) {
        ViewGroup$LayoutParams v0 = this.getLayoutParams();
        ((a)v0).b = arg2;
        this.setLayoutParams(v0);
    }

    public void setGuidelinePercent(float arg2) {
        ViewGroup$LayoutParams v0 = this.getLayoutParams();
        ((a)v0).c = arg2;
        this.setLayoutParams(v0);
    }

    public void setVisibility(int arg1) {
    }
}

