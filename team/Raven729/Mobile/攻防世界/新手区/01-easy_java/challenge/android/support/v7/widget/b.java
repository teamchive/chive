package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class b extends Drawable {
    final ActionBarContainer a;

    public b(ActionBarContainer arg1) {
        super();
        this.a = arg1;
    }

    public void draw(Canvas arg2) {
        if(!this.a.d) {
            if(this.a.a != null) {
                this.a.a.draw(arg2);
            }

            if(this.a.b == null) {
                return;
            }

            if(!this.a.e) {
                return;
            }

            this.a.b.draw(arg2);
        }
        else if(this.a.c != null) {
            this.a.c.draw(arg2);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int arg1) {
    }

    public void setColorFilter(ColorFilter arg1) {
    }
}

