package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.v7.app.e;
import java.lang.ref.WeakReference;

public class bb extends Resources {
    private final WeakReference a;

    public bb(Context arg4, Resources arg5) {
        super(arg5.getAssets(), arg5.getDisplayMetrics(), arg5.getConfiguration());
        this.a = new WeakReference(arg4);
    }

    public static boolean a() {
        boolean v0 = !e.k() || Build$VERSION.SDK_INT > 20 ? false : true;
        return v0;
    }

    final Drawable a(int arg2) {
        return super.getDrawable(arg2);
    }

    public Drawable getDrawable(int arg3) {
        Object v0 = this.a.get();
        Drawable v0_1 = v0 != null ? l.a().a(((Context)v0), this, arg3) : super.getDrawable(arg3);
        return v0_1;
    }
}

