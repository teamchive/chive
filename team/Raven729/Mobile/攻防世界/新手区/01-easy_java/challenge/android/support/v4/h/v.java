package android.support.v4.h;

import android.os.Build$VERSION;

public class v {
    private final Object a;

    private v(Object arg1) {
        super();
        this.a = arg1;
    }

    static Object a(v arg1) {
        Object v0 = arg1 == null ? null : arg1.a;
        return v0;
    }

    static v a(Object arg1) {
        v v0 = arg1 == null ? null : new v(arg1);
        return v0;
    }

    public int a() {
        int v0 = Build$VERSION.SDK_INT >= 20 ? this.a.getSystemWindowInsetLeft() : 0;
        return v0;
    }

    public v a(int arg3, int arg4, int arg5, int arg6) {
        v v0 = Build$VERSION.SDK_INT >= 20 ? new v(this.a.replaceSystemWindowInsets(arg3, arg4, arg5, arg6)) : null;
        return v0;
    }

    public int b() {
        int v0 = Build$VERSION.SDK_INT >= 20 ? this.a.getSystemWindowInsetTop() : 0;
        return v0;
    }

    public int c() {
        int v0 = Build$VERSION.SDK_INT >= 20 ? this.a.getSystemWindowInsetRight() : 0;
        return v0;
    }

    public int d() {
        int v0 = Build$VERSION.SDK_INT >= 20 ? this.a.getSystemWindowInsetBottom() : 0;
        return v0;
    }

    public boolean equals(Object arg5) {
        boolean v0 = true;
        if(this != (((v)arg5))) {
            if(arg5 != null && this.getClass() == arg5.getClass()) {
                if(this.a != null) {
                    v0 = this.a.equals(((v)arg5).a);
                }
                else if(((v)arg5).a != null) {
                    v0 = false;
                }
                else {
                }

                return v0;
            }

            v0 = false;
        }

        return v0;
    }

    public int hashCode() {
        int v0 = this.a == null ? 0 : this.a.hashCode();
        return v0;
    }
}

