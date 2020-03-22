package android.support.v4.g;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;

public class a extends k implements Map {
    h a;

    public a() {
        super();
    }

    public a(int arg1) {
        super(arg1);
    }

    public boolean a(Collection arg2) {
        return h.c(((Map)this), arg2);
    }

    private h b() {
        if(this.a == null) {
            this.a = new h() {
                protected int a() {
                    return this.a.h;
                }

                protected int a(Object arg2) {
                    return this.a.a(arg2);
                }

                protected Object a(int arg3, int arg4) {
                    return this.a.g[(arg3 << 1) + arg4];
                }

                protected Object a(int arg2, Object arg3) {
                    return this.a.a(arg2, arg3);
                }

                protected void a(int arg2) {
                    this.a.d(arg2);
                }

                protected void a(Object arg2, Object arg3) {
                    this.a.put(arg2, arg3);
                }

                protected int b(Object arg2) {
                    return this.a.b(arg2);
                }

                protected Map b() {
                    return this.a;
                }

                protected void c() {
                    this.a.clear();
                }
            };
        }

        return this.a;
    }

    public Set entrySet() {
        return this.b().d();
    }

    public Set keySet() {
        return this.b().e();
    }

    public void putAll(Map arg4) {
        this.a(this.h + arg4.size());
        Iterator v1 = arg4.entrySet().iterator();
        while(v1.hasNext()) {
            Object v0 = v1.next();
            this.put(((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue());
        }
    }

    public Collection values() {
        return this.b().f();
    }
}

