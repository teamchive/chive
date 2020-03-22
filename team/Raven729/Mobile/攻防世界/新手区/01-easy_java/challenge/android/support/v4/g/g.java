package android.support.v4.g;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map$Entry;

public class g {
    private final LinkedHashMap a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public g(int arg5) {
        super();
        if(arg5 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }

        this.c = arg5;
        this.a = new LinkedHashMap(0, 0.75f, true);
    }

    public final Object a(Object arg4, Object arg5) {
        Object v0_1;
        if(arg4 != null && arg5 != null) {
            __monitor_enter(this);
            try {
                ++this.d;
                this.b += this.c(arg4, arg5);
                v0_1 = this.a.put(arg4, arg5);
                if(v0_1 != null) {
                    this.b -= this.c(arg4, v0_1);
                }

                __monitor_exit(this);
                if(v0_1 == null) {
                    goto label_25;
                }
            }
            catch(Throwable v0) {
                try {
                label_29:
                    __monitor_exit(this);
                }
                catch(Throwable v0) {
                    goto label_29;
                }

                throw v0;
            }

            this.a(false, arg4, v0_1, arg5);
        label_25:
            this.a(this.c);
            return v0_1;
        }

        throw new NullPointerException("key == null || value == null");
    }

    public final Object a(Object arg5) {
        Object v0_1;
        if(arg5 == null) {
            throw new NullPointerException("key == null");
        }

        __monitor_enter(this);
        try {
            v0_1 = this.a.get(arg5);
            if(v0_1 != null) {
                ++this.g;
                __monitor_exit(this);
            }
            else {
                ++this.h;
                __monitor_exit(this);
                goto label_18;
            }

            return v0_1;
        }
        catch(Throwable v0) {
            goto label_23;
        }

    label_18:
        Object v1 = this.b(arg5);
        if(v1 == null) {
            v0_1 = null;
        }
        else {
            __monitor_enter(this);
            try {
                ++this.e;
                v0_1 = this.a.put(arg5, v1);
                if(v0_1 != null) {
                    this.a.put(arg5, v0_1);
                }
                else {
                    this.b += this.c(arg5, v1);
                }

                __monitor_exit(this);
                if(v0_1 == null) {
                    goto label_47;
                }

                goto label_36;
            label_45:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_45;
            }

            throw v0;
        label_36:
            this.a(false, arg5, v1, v0_1);
            return v0_1;
        label_47:
            this.a(this.c);
            v0_1 = v1;
        }

        return v0_1;
        try {
        label_23:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_23;
        }

        throw v0;
    }

    protected void a(boolean arg1, Object arg2, Object arg3, Object arg4) {
    }

    public void a(int arg5) {
        Object v1;
        Object v0_1;
        while(true) {
            __monitor_enter(this);
            try {
                if(this.b >= 0) {
                    if((this.a.isEmpty()) && this.b != 0) {
                        goto label_8;
                    }

                    if(this.b > arg5 && !this.a.isEmpty()) {
                        v0_1 = this.a.entrySet().iterator().next();
                        v1 = ((Map$Entry)v0_1).getKey();
                        v0_1 = ((Map$Entry)v0_1).getValue();
                        this.a.remove(v1);
                        this.b -= this.c(v1, v0_1);
                        ++this.f;
                        __monitor_exit(this);
                        goto label_45;
                    }

                    break;
                }

                goto label_8;
            }
            catch(Throwable v0) {
                goto label_20;
            }

        label_45:
            this.a(true, v1, v0_1, null);
        }

        try {
            __monitor_exit(this);
            return;
        label_8:
            throw new IllegalStateException(this.getClass().getName() + ".sizeOf() is reporting inconsistent results!");
        label_20:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_20;
        }

        throw v0;
    }

    protected int b(Object arg2, Object arg3) {
        return 1;
    }

    protected Object b(Object arg2) {
        return null;
    }

    private int c(Object arg4, Object arg5) {
        int v0 = this.b(arg4, arg5);
        if(v0 < 0) {
            throw new IllegalStateException("Negative size: " + arg4 + "=" + arg5);
        }

        return v0;
    }

    public final String toString() {
        String v0_2;
        int v0 = 0;
        __monitor_enter(this);
        try {
            int v1 = this.g + this.h;
            if(v1 != 0) {
                v0 = this.g * 100 / v1;
            }

            v0_2 = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(v0));
        }
        catch(Throwable v0_1) {
            __monitor_exit(this);
            throw v0_1;
        }

        __monitor_exit(this);
        return v0_2;
    }
}

