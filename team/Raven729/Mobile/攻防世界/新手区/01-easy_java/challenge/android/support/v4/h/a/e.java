package android.support.v4.h.a;

import android.os.Build$VERSION;
import android.view.accessibility.AccessibilityRecord;

public class e {
    class a extends c {
        a() {
            super();
        }

        public void a(AccessibilityRecord arg1, int arg2) {
            arg1.setMaxScrollX(arg2);
        }

        public void b(AccessibilityRecord arg1, int arg2) {
            arg1.setMaxScrollY(arg2);
        }
    }

    class b extends a {
        b() {
            super();
        }
    }

    class c {
        c() {
            super();
        }

        public void a(AccessibilityRecord arg1, int arg2) {
        }

        public void b(AccessibilityRecord arg1, int arg2) {
        }
    }

    private static final c a;
    private final AccessibilityRecord b;

    static {
        if(Build$VERSION.SDK_INT >= 16) {
            e.a = new b();
        }
        else if(Build$VERSION.SDK_INT >= 15) {
            e.a = new a();
        }
        else {
            e.a = new c();
        }
    }

    public static void a(AccessibilityRecord arg1, int arg2) {
        e.a.a(arg1, arg2);
    }

    public static void b(AccessibilityRecord arg1, int arg2) {
        e.a.b(arg1, arg2);
    }

    @Deprecated public boolean equals(Object arg5) {
        boolean v0 = true;
        if(this != (((e)arg5))) {
            if(arg5 == null) {
                v0 = false;
            }
            else if(this.getClass() != arg5.getClass()) {
                v0 = false;
            }
            else if(this.b == null) {
                if(((e)arg5).b != null) {
                    v0 = false;
                }
            }
            else if(!this.b.equals(((e)arg5).b)) {
                v0 = false;
            }
        }

        return v0;
    }

    @Deprecated public int hashCode() {
        int v0 = this.b == null ? 0 : this.b.hashCode();
        return v0;
    }
}

