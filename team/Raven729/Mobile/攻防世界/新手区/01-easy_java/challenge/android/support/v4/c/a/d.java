package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class d extends c {
    class a extends android.support.v4.c.a.c$a {
        a(android.support.v4.c.a.c$a arg1, Resources arg2) {
            super(arg1, arg2);
        }

        public Drawable newDrawable(Resources arg2) {
            return new d(((android.support.v4.c.a.c$a)this), arg2);
        }
    }

    d(Drawable arg1) {
        super(arg1);
    }

    d(android.support.v4.c.a.c$a arg1, Resources arg2) {
        super(arg1, arg2);
    }

    android.support.v4.c.a.c$a b() {
        return new a(this.b, null);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    public void setAutoMirrored(boolean arg2) {
        this.c.setAutoMirrored(arg2);
    }
}

