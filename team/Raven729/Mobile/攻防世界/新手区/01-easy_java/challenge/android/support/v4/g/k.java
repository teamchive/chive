package android.support.v4.g;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class k {
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f;
    Object[] g;
    int h;

    public k() {
        super();
        this.f = c.a;
        this.g = c.c;
        this.h = 0;
    }

    public k(int arg2) {
        super();
        if(arg2 == 0) {
            this.f = c.a;
            this.g = c.c;
        }
        else {
            this.e(arg2);
        }

        this.h = 0;
    }

    private static int a(int[] arg1, int arg2, int arg3) {
        try {
            return c.a(arg1, arg2, arg3);
        }
        catch(ArrayIndexOutOfBoundsException v0) {
            throw new ConcurrentModificationException();
        }
    }

    private static void a(int[] arg4, Object[] arg5, int arg6) {
        Class v1;
        int v2 = 10;
        int v3 = 2;
        if(arg4.length == 8) {
            v1 = a.class;
            __monitor_enter(v1);
            try {
                if(k.e < v2) {
                    arg5[0] = k.d;
                    arg5[1] = arg4;
                    int v0_1;
                    for(v0_1 = (arg6 << 1) - 1; v0_1 >= v3; --v0_1) {
                        arg5[v0_1] = null;
                    }

                    k.d = arg5;
                    ++k.e;
                }

                __monitor_exit(v1);
            }
            catch(Throwable v0) {
                goto label_28;
            }
        }
        else {
            v1 = null;
            if(arg4.length != (((int)v1))) {
                return;
            }

            v1 = a.class;
            __monitor_enter(v1);
            try {
                if(k.c < v2) {
                    arg5[0] = k.b;
                    arg5[1] = arg4;
                    for(v0_1 = (arg6 << 1) - 1; v0_1 >= v3; --v0_1) {
                        arg5[v0_1] = null;
                    }

                    k.b = arg5;
                    ++k.c;
                }

                __monitor_exit(v1);
                return;
            label_56:
                __monitor_exit(v1);
            }
            catch(Throwable v0) {
                goto label_56;
            }

            throw v0;
        }

        try {
            return;
        label_28:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_28;
        }

        throw v0;
    }

    int a() {
        int v0;
        int v2 = this.h;
        if(v2 == 0) {
            v0 = -1;
        }
        else {
            v0 = k.a(this.f, v2, 0);
            if(v0 >= 0 && this.g[v0 << 1] != null) {
                int v1 = v0 + 1;
                while(v1 < v2) {
                    if(this.f[v1] != 0) {
                        break;
                    }

                    if(this.g[v1 << 1] == null) {
                        return v1;
                    }
                    else {
                        ++v1;
                        continue;
                    }
                }

                --v0;
                while(v0 >= 0) {
                    if(this.f[v0] != 0) {
                        break;
                    }

                    if(this.g[v0 << 1] != null) {
                        --v0;
                        continue;
                    }
                    else {
                        return v0;
                    }
                }

                v0 = v1 ^ -1;
            }
        }

        return v0;
    }

    public int a(Object arg2) {
        int v0 = arg2 == null ? this.a() : this.a(arg2, arg2.hashCode());
        return v0;
    }

    int a(Object arg6, int arg7) {
        int v0;
        int v2 = this.h;
        if(v2 == 0) {
            v0 = -1;
        }
        else {
            v0 = k.a(this.f, v2, arg7);
            if(v0 >= 0 && !arg6.equals(this.g[v0 << 1])) {
                int v1 = v0 + 1;
                while(v1 < v2) {
                    if(this.f[v1] != arg7) {
                        break;
                    }

                    if(arg6.equals(this.g[v1 << 1])) {
                        return v1;
                    }
                    else {
                        ++v1;
                        continue;
                    }
                }

                --v0;
                while(v0 >= 0) {
                    if(this.f[v0] != arg7) {
                        break;
                    }

                    if(!arg6.equals(this.g[v0 << 1])) {
                        --v0;
                        continue;
                    }
                    else {
                        return v0;
                    }
                }

                v0 = v1 ^ -1;
            }
        }

        return v0;
    }

    public Object a(int arg4, Object arg5) {
        int v0 = (arg4 << 1) + 1;
        Object v1 = this.g[v0];
        this.g[v0] = arg5;
        return v1;
    }

    public void a(int arg7) {
        int v0 = this.h;
        if(this.f.length < arg7) {
            int[] v1 = this.f;
            Object[] v2 = this.g;
            this.e(arg7);
            if(this.h > 0) {
                System.arraycopy(v1, 0, this.f, 0, v0);
                System.arraycopy(v2, 0, this.g, 0, v0 << 1);
            }

            k.a(v1, v2, v0);
        }

        if(this.h != v0) {
            throw new ConcurrentModificationException();
        }
    }

    int b(Object arg5) {
        int v0 = 1;
        int v1 = this.h * 2;
        Object[] v2 = this.g;
        if(arg5 == null) {
            while(true) {
                if(v0 >= v1) {
                    goto label_19;
                }
                else if(v2[v0] == null) {
                    v0 >>= 1;
                }
                else {
                    v0 += 2;
                    continue;
                }

                return v0;
            }
        }
        else {
            while(true) {
                if(v0 >= v1) {
                    break;
                }
                else if(arg5.equals(v2[v0])) {
                    v0 >>= 1;
                }
                else {
                    v0 += 2;
                    continue;
                }

                return v0;
            }

        label_19:
            v0 = -1;
        }

        return v0;
    }

    public Object b(int arg3) {
        return this.g[arg3 << 1];
    }

    public Object c(int arg3) {
        return this.g[(arg3 << 1) + 1];
    }

    public void clear() {
        if(this.h > 0) {
            int[] v0 = this.f;
            Object[] v1 = this.g;
            int v2 = this.h;
            this.f = c.a;
            this.g = c.c;
            this.h = 0;
            k.a(v0, v1, v2);
        }

        if(this.h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object arg2) {
        boolean v0 = this.a(arg2) >= 0 ? true : false;
        return v0;
    }

    public boolean containsValue(Object arg2) {
        boolean v0 = this.b(arg2) >= 0 ? true : false;
        return v0;
    }

    public Object d(int arg10) {
        Object v8 = null;
        int v0 = 8;
        Object v3 = this.g[(arg10 << 1) + 1];
        int v4 = this.h;
        if(v4 <= 1) {
            k.a(this.f, this.g, v4);
            this.f = c.a;
            this.g = c.c;
            v0 = 0;
        }
        else {
            int v2 = v4 - 1;
            if(this.f.length > v0 && this.h < this.f.length / 3) {
                if(v4 > v0) {
                    v0 = (v4 >> 1) + v4;
                }

                int[] v5 = this.f;
                Object[] v6 = this.g;
                this.e(v0);
                if(v4 != this.h) {
                    throw new ConcurrentModificationException();
                }

                if(arg10 > 0) {
                    System.arraycopy(v5, 0, this.f, 0, arg10);
                    System.arraycopy(v6, 0, this.g, 0, arg10 << 1);
                }

                if(arg10 < v2) {
                    System.arraycopy(v5, arg10 + 1, this.f, arg10, v2 - arg10);
                    System.arraycopy(v6, arg10 + 1 << 1, this.g, arg10 << 1, v2 - arg10 << 1);
                }

                v0 = v2;
                goto label_18;
            }

            if(arg10 < v2) {
                System.arraycopy(this.f, arg10 + 1, this.f, arg10, v2 - arg10);
                System.arraycopy(this.g, arg10 + 1 << 1, this.g, arg10 << 1, v2 - arg10 << 1);
            }

            this.g[v2 << 1] = v8;
            this.g[(v2 << 1) + 1] = v8;
            v0 = v2;
        }

    label_18:
        if(v4 != this.h) {
            throw new ConcurrentModificationException();
        }

        this.h = v0;
        return v3;
    }

    private void e(int arg6) {
        Object[] v2;
        Class v1;
        if(arg6 == 8) {
            v1 = a.class;
            __monitor_enter(v1);
            try {
                if(k.d != null) {
                    v2 = k.d;
                    this.g = v2;
                    k.d = v2[0];
                    this.f = v2[1];
                    v2[1] = null;
                    v2[0] = null;
                    --k.e;
                    __monitor_exit(v1);
                }
                else {
                    __monitor_exit(v1);
                    goto label_25;
                }
            }
            catch(Throwable v0) {
                goto label_32;
            }
        }
        else if(arg6 == 4) {
            v1 = a.class;
            __monitor_enter(v1);
            try {
                if(k.b != null) {
                    v2 = k.b;
                    this.g = v2;
                    k.b = v2[0];
                    this.f = v2[1];
                    v2[1] = null;
                    v2[0] = null;
                    --k.c;
                    __monitor_exit(v1);
                }
                else {
                    __monitor_exit(v1);
                    goto label_25;
                label_59:
                    __monitor_exit(v1);
                    goto label_60;
                }

                return;
            }
            catch(Throwable v0) {
                goto label_59;
            }

        label_60:
            throw v0;
        }
        else {
        label_25:
            this.f = new int[arg6];
            this.g = new Object[arg6 << 1];
        }

        return;
        try {
        label_32:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_32;
        }

        throw v0;
    }

    public boolean equals(Object arg7) {
        Object v5;
        Object v4;
        Object v3;
        boolean v0 = true;
        if(this == (((k)arg7))) {
            return v0;
        }

        if(!(arg7 instanceof k)) {
            goto label_35;
        }

        if(this.size() != ((k)arg7).size()) {
            return false;
        }

        int v2 = 0;
        try {
            while(true) {
            label_12:
                if(v2 >= this.h) {
                    return v0;
                }

                v3 = this.b(v2);
                v4 = this.c(v2);
                v5 = ((k)arg7).get(v3);
                if(v4 == null) {
                    if(v5 == null && (((k)arg7).containsKey(v3))) {
                        goto label_27;
                    }

                    return false;
                }
                else {
                    if(v4.equals(v5)) {
                        goto label_27;
                    }

                    return false;
                }
            }
        }
        catch(ClassCastException v0_1) {
            return false;
        }
        catch(NullPointerException v0_2) {
            return false;
        }

        return false;
    label_27:
        ++v2;
        goto label_12;
    label_35:
        if(!(arg7 instanceof Map)) {
            return false;
        }

        if(this.size() != ((Map)arg7).size()) {
            return false;
        }

        v2 = 0;
        try {
            while(true) {
            label_43:
                if(v2 >= this.h) {
                    return v0;
                }

                v3 = this.b(v2);
                v4 = this.c(v2);
                v5 = ((Map)arg7).get(v3);
                if(v4 == null) {
                    if(v5 == null && (((Map)arg7).containsKey(v3))) {
                        goto label_58;
                    }

                    return false;
                }
                else {
                    if(v4.equals(v5)) {
                        goto label_58;
                    }

                    return false;
                }
            }
        }
        catch(ClassCastException v0_1) {
            return false;
        }
        catch(NullPointerException v0_2) {
            return false;
        }

        return false;
    label_58:
        ++v2;
        goto label_43;
        return false;
    }

    public Object get(Object arg3) {
        int v0 = this.a(arg3);
        Object v0_1 = v0 >= 0 ? this.g[(v0 << 1) + 1] : null;
        return v0_1;
    }

    public int hashCode() {
        int[] v5 = this.f;
        Object[] v6 = this.g;
        int v7 = this.h;
        int v2 = 1;
        int v3 = 0;
        int v4 = 0;
        while(v3 < v7) {
            Object v0 = v6[v2];
            int v8 = v5[v3];
            int v0_1 = v0 == null ? 0 : v0.hashCode();
            v4 += v0_1 ^ v8;
            ++v3;
            v2 += 2;
        }

        return v4;
    }

    public boolean isEmpty() {
        boolean v0 = this.h <= 0 ? true : false;
        return v0;
    }

    public Object put(Object arg9, Object arg10) {
        Object v0_1;
        int v3;
        int v2;
        int v0 = 8;
        int v1 = 4;
        int v5 = this.h;
        if(arg9 == null) {
            v2 = this.a();
            v3 = 0;
        }
        else {
            v3 = arg9.hashCode();
            v2 = this.a(arg9, v3);
        }

        if(v2 >= 0) {
            v1 = (v2 << 1) + 1;
            v0_1 = this.g[v1];
            this.g[v1] = arg10;
        }
        else {
            v2 ^= -1;
            if(v5 >= this.f.length) {
                if(v5 >= v0) {
                    v0 = (v5 >> 1) + v5;
                }
                else if(v5 < v1) {
                    v0 = v1;
                }

                int[] v1_1 = this.f;
                Object[] v6 = this.g;
                this.e(v0);
                if(v5 != this.h) {
                    throw new ConcurrentModificationException();
                }

                if(this.f.length > 0) {
                    System.arraycopy(v1_1, 0, this.f, 0, v1_1.length);
                    System.arraycopy(v6, 0, this.g, 0, v6.length);
                }

                k.a(v1_1, v6, v5);
            }

            if(v2 < v5) {
                System.arraycopy(this.f, v2, this.f, v2 + 1, v5 - v2);
                System.arraycopy(this.g, v2 << 1, this.g, v2 + 1 << 1, this.h - v2 << 1);
            }

            if(v5 == this.h && v2 < this.f.length) {
                this.f[v2] = v3;
                this.g[v2 << 1] = arg9;
                this.g[(v2 << 1) + 1] = arg10;
                ++this.h;
                return null;
            }

            goto label_66;
        }

        return v0_1;
    label_66:
        throw new ConcurrentModificationException();
    }

    public Object remove(Object arg2) {
        int v0 = this.a(arg2);
        Object v0_1 = v0 >= 0 ? this.d(v0) : null;
        return v0_1;
    }

    public int size() {
        return this.h;
    }

    public String toString() {
        String v0;
        if(this.isEmpty()) {
            v0 = "{}";
        }
        else {
            StringBuilder v1 = new StringBuilder(this.h * 28);
            v1.append('{');
            int v0_1;
            for(v0_1 = 0; v0_1 < this.h; ++v0_1) {
                if(v0_1 > 0) {
                    v1.append(", ");
                }

                Object v2 = this.b(v0_1);
                if((((k)v2)) != this) {
                    v1.append(v2);
                }
                else {
                    v1.append("(this Map)");
                }

                v1.append('=');
                v2 = this.c(v0_1);
                if((((k)v2)) != this) {
                    v1.append(v2);
                }
                else {
                    v1.append("(this Map)");
                }
            }

            v1.append('}');
            v0 = v1.toString();
        }

        return v0;
    }
}

