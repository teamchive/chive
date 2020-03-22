package android.support.v4.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;

public class Space extends View {
    public Space(Context arg2) {
        this(arg2, null);
    }

    public Space(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public Space(Context arg2, AttributeSet arg3, int arg4) {
        super(arg2, arg3, arg4);
        if(this.getVisibility() == 0) {
            this.setVisibility(4);
        }
    }

    private static int a(int arg2, int arg3) {
        int v1 = View$MeasureSpec.getMode(arg3);
        int v0 = View$MeasureSpec.getSize(arg3);
        switch(v1) {
            case 1073741824: {
                arg2 = v0;
                break;
            }
            case -2147483648: {
                arg2 = Math.min(arg2, v0);
                break;
            }
        }

        return arg2;
    }

    @SuppressLint(value={"MissingSuperCall"}) public void draw(Canvas arg1) {
    }

    protected void onMeasure(int arg3, int arg4) {
        this.setMeasuredDimension(Space.a(this.getSuggestedMinimumWidth(), arg3), Space.a(this.getSuggestedMinimumHeight(), arg4));
    }
}

