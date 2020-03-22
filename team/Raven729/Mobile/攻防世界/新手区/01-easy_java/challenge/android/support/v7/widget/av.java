package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class av extends an {
    private final WeakReference a;

    public av(Context arg2, Resources arg3) {
        super(arg3);
        this.a = new WeakReference(arg2);
    }

    public Drawable getDrawable(int arg3) {
        Drawable v1 = super.getDrawable(arg3);
        Object v0 = this.a.get();
        if(v1 != null && v0 != null) {
            l.a();
            l.a(((Context)v0), arg3, v1);
        }

        return v1;
    }
}

