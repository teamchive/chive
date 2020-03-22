package android.support.constraint;

import android.graphics.Canvas;
import android.graphics.Paint$Align;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup$LayoutParams;

public class f extends View {
    private int a;
    private View b;
    private int c;

    public void a(ConstraintLayout arg4) {
        if(this.a == -1 && !this.isInEditMode()) {
            this.setVisibility(this.c);
        }

        this.b = arg4.findViewById(this.a);
        if(this.b != null) {
            this.b.getLayoutParams().aa = true;
            this.b.setVisibility(0);
            this.setVisibility(0);
        }
    }

    public void b(ConstraintLayout arg5) {
        if(this.b != null) {
            ViewGroup$LayoutParams v0 = this.getLayoutParams();
            ViewGroup$LayoutParams v1 = this.b.getLayoutParams();
            ((a)v1).al.e(0);
            ((a)v0).al.h(((a)v1).al.o());
            ((a)v0).al.i(((a)v1).al.q());
            ((a)v1).al.e(8);
        }
    }

    public View getContent() {
        return this.b;
    }

    public int getEmptyVisibility() {
        return this.c;
    }

    public void onDraw(Canvas arg9) {
        int v1 = 0xDF;
        int v2 = 210;
        float v6 = 2f;
        if(this.isInEditMode()) {
            arg9.drawRGB(v1, v1, v1);
            Paint v0 = new Paint();
            v0.setARGB(0xFF, v2, v2, v2);
            v0.setTextAlign(Paint$Align.CENTER);
            v0.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect v1_1 = new Rect();
            arg9.getClipBounds(v1_1);
            v0.setTextSize(((float)v1_1.height()));
            v2 = v1_1.height();
            int v3 = v1_1.width();
            v0.setTextAlign(Paint$Align.LEFT);
            v0.getTextBounds("?", 0, "?".length(), v1_1);
            arg9.drawText("?", (((float)v3)) / v6 - (((float)v1_1.width())) / v6 - (((float)v1_1.left)), (((float)v2)) / v6 + (((float)v1_1.height())) / v6 - (((float)v1_1.bottom)), v0);
        }
    }

    public void setContentId(int arg3) {
        if(this.a != arg3) {
            if(this.b != null) {
                this.b.setVisibility(0);
                this.b.getLayoutParams().aa = false;
                this.b = null;
            }

            this.a = arg3;
            if(arg3 == -1) {
                return;
            }

            View v0 = this.getParent().findViewById(arg3);
            if(v0 == null) {
                return;
            }

            v0.setVisibility(8);
        }
    }

    public void setEmptyVisibility(int arg1) {
        this.c = arg1;
    }
}

