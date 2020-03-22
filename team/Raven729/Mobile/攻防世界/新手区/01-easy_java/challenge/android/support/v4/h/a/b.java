package android.support.v4.h.a;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;

public class b {
    interface a {
        Object a(b arg1);
    }

    class android.support.v4.h.a.b$b extends d {
        android.support.v4.h.a.b$b() {
            super();
        }

        public Object a(b arg2) {
            return c.a(new android.support.v4.h.a.c$a(arg2) {
                public Object a(int arg2) {
                    AccessibilityNodeInfo v0_2;
                    android.support.v4.h.a.a v0 = this.a.a(arg2);
                    if(v0 == null) {
                        Object v0_1 = null;
                    }
                    else {
                        v0_2 = v0.a();
                    }

                    return v0_2;
                }

                public List a(String arg6, int arg7) {
                    ArrayList v0_1;
                    List v3 = this.a.a(arg6, arg7);
                    if(v3 == null) {
                        List v0 = null;
                    }
                    else {
                        ArrayList v1 = new ArrayList();
                        int v4 = v3.size();
                        int v2;
                        for(v2 = 0; v2 < v4; ++v2) {
                            ((List)v1).add(v3.get(v2).a());
                        }

                        v0_1 = v1;
                    }

                    return ((List)v0_1);
                }

                public boolean a(int arg2, int arg3, Bundle arg4) {
                    return this.a.a(arg2, arg3, arg4);
                }
            });
        }
    }

    class android.support.v4.h.a.b$c extends d {
        android.support.v4.h.a.b$c() {
            super();
        }

        public Object a(b arg2) {
            return android.support.v4.h.a.d.a(new android.support.v4.h.a.d$a(arg2) {
                public Object a(int arg2) {
                    AccessibilityNodeInfo v0_2;
                    android.support.v4.h.a.a v0 = this.a.a(arg2);
                    if(v0 == null) {
                        Object v0_1 = null;
                    }
                    else {
                        v0_2 = v0.a();
                    }

                    return v0_2;
                }

                public List a(String arg6, int arg7) {
                    List v0;
                    List v3 = this.a.a(arg6, arg7);
                    if(v3 == null) {
                        v0 = null;
                    }
                    else {
                        ArrayList v1 = new ArrayList();
                        int v4 = v3.size();
                        int v2;
                        for(v2 = 0; v2 < v4; ++v2) {
                            ((List)v1).add(v3.get(v2).a());
                        }

                        ArrayList v0_1 = v1;
                    }

                    return v0;
                }

                public boolean a(int arg2, int arg3, Bundle arg4) {
                    return this.a.a(arg2, arg3, arg4);
                }

                public Object b(int arg2) {
                    Object v0_1;
                    android.support.v4.h.a.a v0 = this.a.b(arg2);
                    if(v0 == null) {
                        v0_1 = null;
                    }
                    else {
                        AccessibilityNodeInfo v0_2 = v0.a();
                    }

                    return v0_1;
                }
            });
        }
    }

    class d implements a {
        d() {
            super();
        }

        public Object a(b arg2) {
            return null;
        }
    }

    private static final a a;
    private final Object b;

    static {
        if(Build$VERSION.SDK_INT >= 19) {
            b.a = new android.support.v4.h.a.b$c();
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            b.a = new android.support.v4.h.a.b$b();
        }
        else {
            b.a = new d();
        }
    }

    public b() {
        super();
        this.b = b.a.a(this);
    }

    public b(Object arg1) {
        super();
        this.b = arg1;
    }

    public android.support.v4.h.a.a a(int arg2) {
        return null;
    }

    public Object a() {
        return this.b;
    }

    public List a(String arg2, int arg3) {
        return null;
    }

    public boolean a(int arg2, int arg3, Bundle arg4) {
        return 0;
    }

    public android.support.v4.h.a.a b(int arg2) {
        return null;
    }
}

