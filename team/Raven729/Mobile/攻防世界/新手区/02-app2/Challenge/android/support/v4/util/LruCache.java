package android.support.v4.util;

import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;

public class LruCache {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int arg5) {
        super();
        if(arg5 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }

        this.maxSize = arg5;
        this.map = new LinkedHashMap(0, 0.75f, true);
    }

    protected Object create(Object arg2) {
        return null;
    }

    public final int createCount() {
        int v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.createCount;
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    protected void entryRemoved(boolean arg1, Object arg2, Object arg3, Object arg4) {
    }

    public final void evictAll() {
        this.trimToSize(-1);
    }

    public final int evictionCount() {
        int v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.evictionCount;
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public final Object get(Object arg5) {
        Object v0_1;
        if(arg5 == null) {
            throw new NullPointerException("key == null");
        }

        __monitor_enter(this);
        try {
            v0_1 = this.map.get(arg5);
            if(v0_1 != null) {
                ++this.hitCount;
                __monitor_exit(this);
            }
            else {
                ++this.missCount;
                __monitor_exit(this);
                goto label_18;
            }

            return v0_1;
        }
        catch(Throwable v0) {
            goto label_23;
        }

    label_18:
        Object v1 = this.create(arg5);
        if(v1 == null) {
            v0_1 = null;
        }
        else {
            __monitor_enter(this);
            try {
                ++this.createCount;
                v0_1 = this.map.put(arg5, v1);
                if(v0_1 != null) {
                    this.map.put(arg5, v0_1);
                }
                else {
                    this.size += this.safeSizeOf(arg5, v1);
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
            this.entryRemoved(false, arg5, v1, v0_1);
            return v0_1;
        label_47:
            this.trimToSize(this.maxSize);
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

    public final int hitCount() {
        int v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.hitCount;
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public final int maxSize() {
        int v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.maxSize;
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public final int missCount() {
        int v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.missCount;
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public final Object put(Object arg4, Object arg5) {
        Object v0_1;
        if(arg4 != null && arg5 != null) {
            __monitor_enter(this);
            try {
                ++this.putCount;
                this.size += this.safeSizeOf(arg4, arg5);
                v0_1 = this.map.put(arg4, arg5);
                if(v0_1 != null) {
                    this.size -= this.safeSizeOf(arg4, v0_1);
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

            this.entryRemoved(false, arg4, v0_1, arg5);
        label_25:
            this.trimToSize(this.maxSize);
            return v0_1;
        }

        throw new NullPointerException("key == null || value == null");
    }

    public final int putCount() {
        int v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.putCount;
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public final Object remove(Object arg4) {
        Object v0_1;
        if(arg4 == null) {
            throw new NullPointerException("key == null");
        }

        __monitor_enter(this);
        try {
            v0_1 = this.map.remove(arg4);
            if(v0_1 != null) {
                this.size -= this.safeSizeOf(arg4, v0_1);
            }

            __monitor_exit(this);
            if(v0_1 == null) {
                return v0_1;
            }
        }
        catch(Throwable v0) {
            try {
            label_20:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_20;
            }

            throw v0;
        }

        this.entryRemoved(false, arg4, v0_1, null);
        return v0_1;
    }

    public void resize(int arg3) {
        if(arg3 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }

        __monitor_enter(this);
        try {
            this.maxSize = arg3;
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            try {
            label_11:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_11;
            }

            throw v0;
        }

        this.trimToSize(arg3);
    }

    private int safeSizeOf(Object arg4, Object arg5) {
        int v0 = this.sizeOf(arg4, arg5);
        if(v0 < 0) {
            throw new IllegalStateException("Negative size: " + arg4 + "=" + arg5);
        }

        return v0;
    }

    public final int size() {
        int v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.size;
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    protected int sizeOf(Object arg2, Object arg3) {
        return 1;
    }

    public final Map snapshot() {
        LinkedHashMap v0_1;
        __monitor_enter(this);
        try {
            v0_1 = new LinkedHashMap(this.map);
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
        return ((Map)v0_1);
    }

    public final String toString() {
        String v0_2;
        int v0 = 0;
        __monitor_enter(this);
        try {
            int v1 = this.hitCount + this.missCount;
            if(v1 != 0) {
                v0 = this.hitCount * 100 / v1;
            }

            v0_2 = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(v0));
        }
        catch(Throwable v0_1) {
            __monitor_exit(this);
            throw v0_1;
        }

        __monitor_exit(this);
        return v0_2;
    }

    public void trimToSize(int arg5) {
        Object v1;
        Object v0_1;
        while(true) {
            __monitor_enter(this);
            try {
                if(this.size >= 0) {
                    if((this.map.isEmpty()) && this.size != 0) {
                        goto label_8;
                    }

                    if(this.size > arg5 && !this.map.isEmpty()) {
                        v0_1 = this.map.entrySet().iterator().next();
                        v1 = ((Map$Entry)v0_1).getKey();
                        v0_1 = ((Map$Entry)v0_1).getValue();
                        this.map.remove(v1);
                        this.size -= this.safeSizeOf(v1, v0_1);
                        ++this.evictionCount;
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
            this.entryRemoved(true, v1, v0_1, null);
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
}

