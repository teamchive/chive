package android.support.v7.widget;

import android.graphics.Outline;

class c extends b {
    public c(ActionBarContainer arg1) {
        super(arg1);
    }

    public void getOutline(Outline arg2) {
        if(this.a.d) {
            if(this.a.c != null) {
                this.a.c.getOutline(arg2);
            }
        }
        else if(this.a.a != null) {
            this.a.a.getOutline(arg2);
        }
    }
}

