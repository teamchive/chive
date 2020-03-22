package android.support.v4.g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b implements Collection, Set {
    static Object[] a;
    static int b;
    static Object[] c;
    static int d;
    final boolean e;
    int[] f;
    Object[] g;
    int h;
    h i;
    private static final int[] j;
    private static final Object[] k;

    static {
        b.j = new int[0];
        b.k = new Object[0];
    }

    public b() {
        this(0, false);
    }

    public b(int arg2, boolean arg3) {
        super();
        this.e = arg3;
        if(arg2 == 0) {
            this.f = b.j;
            this.g = b.k;
        }
        else {
            this.d(arg2);
        }

        this.h = 0;
    }

    private int a() {
        int v0;
        int v2 = this.h;
        if(v2 == 0) {
            v0 = -1;
        }
        else {
            v0 = c.a(this.f, v2, 0);
            if(v0 >= 0 && this.g[v0] != null) {
                int v1 = v0 + 1;
                while(v1 < v2) {
                    if(this.f[v1] != 0) {
                        break;
                    }

                    if(this.g[v1] == null) {
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

                    if(this.g[v0] != null) {
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

    private int a(Object arg5, int arg6) {
        int v0;
        int v2 = this.h;
        if(v2 == 0) {
            v0 = -1;
        }
        else {
            v0 = c.a(this.f, v2, arg6);
            if(v0 >= 0 && !arg5.equals(this.g[v0])) {
                int v1 = v0 + 1;
                while(v1 < v2) {
                    if(this.f[v1] != arg6) {
                        break;
                    }

                    if(arg5.equals(this.g[v1])) {
                        return v1;
                    }
                    else {
                        ++v1;
                        continue;
                    }
                }

                --v0;
                while(v0 >= 0) {
                    if(this.f[v0] != arg6) {
                        break;
                    }

                    if(!arg5.equals(this.g[v0])) {
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

    private static void a(int[] arg4, Object[] arg5, int arg6) {
        Class v1;
        int v2 = 10;
        int v3 = 2;
        if(arg4.length == 8) {
            v1 = b.class;
            __monitor_enter(v1);
            try {
                if(b.d < v2) {
                    arg5[0] = b.c;
                    arg5[1] = arg4;
                    int v0_1;
                    for(v0_1 = arg6 - 1; v0_1 >= v3; --v0_1) {
                        arg5[v0_1] = null;
                    }

                    b.c = arg5;
                    ++b.d;
                }

                __monitor_exit(v1);
            }
            catch(Throwable v0) {
                goto label_27;
            }
        }
        else {
            v1 = null;
            if(arg4.length != (((int)v1))) {
                return;
            }

            v1 = b.class;
            __monitor_enter(v1);
            try {
                if(b.b < v2) {
                    arg5[0] = b.a;
                    arg5[1] = arg4;
                    for(v0_1 = arg6 - 1; v0_1 >= v3; --v0_1) {
                        arg5[v0_1] = null;
                    }

                    b.a = arg5;
                    ++b.b;
                }

                __monitor_exit(v1);
                return;
            label_54:
                __monitor_exit(v1);
            }
            catch(Throwable v0) {
                goto label_54;
            }

            throw v0;
        }

        try {
            return;
        label_27:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_27;
        }

        throw v0;
    }

    public int a(Object arg2) {
        int v0;
        if(arg2 == null) {
            v0 = this.a();
        }
        else {
            v0 = this.e ? System.identityHashCode(arg2) : arg2.hashCode();
            v0 = this.a(arg2, v0);
        }

        return v0;
    }

    public void a(int arg6) {
        if(this.f.length < arg6) {
            int[] v0 = this.f;
            Object[] v1 = this.g;
            this.d(arg6);
            if(this.h > 0) {
                System.arraycopy(v0, 0, this.f, 0, this.h);
                System.arraycopy(v1, 0, this.g, 0, this.h);
            }

            b.a(v0, v1, this.h);
        }
    }

    public boolean add(Object arg9) {
        boolean v0_1;
        int v4;
        int v0;
        int v1 = 8;
        int v2 = 4;
        if(arg9 == null) {
            v0 = this.a();
            v4 = 0;
        }
        else {
            v0 = this.e ? System.identityHashCode(arg9) : arg9.hashCode();
            v4 = v0;
            v0 = this.a(arg9, v0);
        }

        if(v0 >= 0) {
            v0_1 = false;
        }
        else {
            int v5 = v0 ^ -1;
            if(this.h >= this.f.length) {
                if(this.h >= v1) {
                    v0 = this.h + (this.h >> 1);
                }
                else if(this.h >= v2) {
                    v0 = v1;
                }
                else {
                    v0 = v2;
                }

                int[] v1_1 = this.f;
                Object[] v2_1 = this.g;
                this.d(v0);
                if(this.f.length > 0) {
                    System.arraycopy(v1_1, 0, this.f, 0, v1_1.length);
                    System.arraycopy(v2_1, 0, this.g, 0, v2_1.length);
                }

                b.a(v1_1, v2_1, this.h);
            }

            if(v5 < this.h) {
                System.arraycopy(this.f, v5, this.f, v5 + 1, this.h - v5);
                System.arraycopy(this.g, v5, this.g, v5 + 1, this.h - v5);
            }

            this.f[v5] = v4;
            this.g[v5] = arg9;
            ++this.h;
            v0_1 = true;
        }

        return v0_1;
    }

    public boolean addAll(Collection arg4) {
        this.a(this.h + arg4.size());
        int v0 = 0;
        Iterator v1 = arg4.iterator();
        while(v1.hasNext()) {
            v0 |= this.add(v1.next());
        }

        return ((boolean)v0);
    }

    public Object b(int arg2) {
        return this.g[arg2];
    }

    private h b() {
        if(this.i == null) {
            this.i = new h() {
                protected int a() {
                    return this.a.h;
                }

                protected int a(Object arg2) {
                    return this.a.a(arg2);
                }

                protected Object a(int arg2, int arg3) {
                    return this.a.g[arg2];
                }

                protected Object a(int arg3, Object arg4) {
                    throw new UnsupportedOperationException("not a map");
                }

                protected void a(int arg2) {
                    this.a.c(arg2);
                }

                protected void a(Object arg2, Object arg3) {
                    this.a.add(arg2);
                }

                protected int b(Object arg2) {
                    return this.a.a(arg2);
                }

                protected Map b() {
                    throw new UnsupportedOperationException("not a map");
                }

                protected void c() {
                    this.a.clear();
                }
            };
        }

        return this.i;
    }

    public Object c(int arg7) {
        int v0 = 8;
        Object v1 = this.g[arg7];
        if(this.h <= 1) {
            b.a(this.f, this.g, this.h);
            this.f = b.j;
            this.g = b.k;
            this.h = 0;
        }
        else {
            if(this.f.length > v0 && this.h < this.f.length / 3) {
                if(this.h > v0) {
                    v0 = this.h + (this.h >> 1);
                }

                int[] v2 = this.f;
                Object[] v3 = this.g;
                this.d(v0);
                --this.h;
                if(arg7 > 0) {
                    System.arraycopy(v2, 0, this.f, 0, arg7);
                    System.arraycopy(v3, 0, this.g, 0, arg7);
                }

                if(arg7 >= this.h) {
                    return v1;
                }

                System.arraycopy(v2, arg7 + 1, this.f, arg7, this.h - arg7);
                System.arraycopy(v3, arg7 + 1, this.g, arg7, this.h - arg7);
                return v1;
            }

            --this.h;
            if(arg7 < this.h) {
                System.arraycopy(this.f, arg7 + 1, this.f, arg7, this.h - arg7);
                System.arraycopy(this.g, arg7 + 1, this.g, arg7, this.h - arg7);
            }

            this.g[this.h] = null;
        }

        return v1;
    }

    public void clear() {
        if(this.h != 0) {
            b.a(this.f, this.g, this.h);
            this.f = b.j;
            this.g = b.k;
            this.h = 0;
        }
    }

    public boolean contains(Object arg2) {
        boolean v0 = this.a(arg2) >= 0 ? true : false;
        return v0;
    }

    public boolean containsAll(Collection arg3) {
        Iterator v0 = arg3.iterator();
        do {
            if(v0.hasNext()) {
                if(this.contains(v0.next())) {
                    continue;
                }

                break;
            }
            else {
                return true;
            }
        }
        while(true);

        boolean v0_1 = false;
        return v0_1;
    }

    private void d(int arg6) {
        Object[] v2;
        Class v1;
        if(arg6 == 8) {
            v1 = b.class;
            __monitor_enter(v1);
            try {
                if(b.c != null) {
                    v2 = b.c;
                    this.g = v2;
                    b.c = v2[0];
                    this.f = v2[1];
                    v2[1] = null;
                    v2[0] = null;
                    --b.d;
                    __monitor_exit(v1);
                }
                else {
                    __monitor_exit(v1);
                    goto label_25;
                }
            }
            catch(Throwable v0) {
                goto label_31;
            }
        }
        else if(arg6 == 4) {
            v1 = b.class;
            __monitor_enter(v1);
            try {
                if(b.a != null) {
                    v2 = b.a;
                    this.g = v2;
                    b.a = v2[0];
                    this.f = v2[1];
                    v2[1] = null;
                    v2[0] = null;
                    --b.b;
                    __monitor_exit(v1);
                }
                else {
                    __monitor_exit(v1);
                    goto label_25;
                label_58:
                    __monitor_exit(v1);
                    goto label_59;
                }

                return;
            }
            catch(Throwable v0) {
                goto label_58;
            }

        label_59:
            throw v0;
        }
        else {
        label_25:
            this.f = new int[arg6];
            this.g = new Object[arg6];
        }

        return;
        try {
        label_31:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_31;
        }

        throw v0;
    }

    public boolean equals(Object arg5) {
        boolean v0 = true;
        if(this == (((b)arg5))) {
            return v0;
        }

        if(!(arg5 instanceof Set)) {
            return false;
        }

        if(this.size() != ((Set)arg5).size()) {
            return false;
        }

        int v2 = 0;
        try {
            while(true) {
            label_12:
                if(v2 >= this.h) {
                    return v0;
                }

                if(((Set)arg5).contains(this.b(v2))) {
                    goto label_19;
                }

                return false;
            }
        }
        catch(ClassCastException v0_1) {
            return false;
        }
        catch(NullPointerException v0_2) {
            return false;
        }

        return false;
    label_19:
        ++v2;
        goto label_12;
        return false;
    }

    public int hashCode() {
        int v0 = 0;
        int[] v2 = this.f;
        int v3 = this.h;
        int v1 = 0;
        while(v0 < v3) {
            v1 += v2[v0];
            ++v0;
        }

        return v1;
    }

    public boolean isEmpty() {
        boolean v0 = this.h <= 0 ? true : false;
        return v0;
    }

    public Iterator iterator() {
        return this.b().e().iterator();
    }

    public boolean remove(Object arg2) {
        boolean v0_1;
        int v0 = this.a(arg2);
        if(v0 >= 0) {
            this.c(v0);
            v0_1 = true;
        }
        else {
            v0_1 = false;
        }

        return v0_1;
    }

    public boolean removeAll(Collection arg4) {
        int v0 = 0;
        Iterator v1 = arg4.iterator();
        while(v1.hasNext()) {
            v0 |= this.remove(v1.next());
        }

        return ((boolean)v0);
    }

    public boolean retainAll(Collection arg5) {
        boolean v0 = false;
        int v1;
        for(v1 = this.h - 1; v1 >= 0; --v1) {
            if(!arg5.contains(this.g[v1])) {
                this.c(v1);
                v0 = true;
            }
        }

        return v0;
    }

    public int size() {
        return this.h;
    }

    public Object[] toArray() {
        Object[] v0 = new Object[this.h];
        System.arraycopy(this.g, 0, v0, 0, this.h);
        return v0;
    }

    public Object[] toArray(Object[] arg5) {
        Object[] v0_1;
        if(arg5.length < this.h) {
            Object v0 = Array.newInstance(arg5.getClass().getComponentType(), this.h);
        }
        else {
            v0_1 = arg5;
        }

        System.arraycopy(this.g, 0, v0_1, 0, this.h);
        if(v0_1.length > this.h) {
            v0_1[this.h] = null;
        }

        return v0_1;
    }

    public String toString() {
        String v0;
        if(this.isEmpty()) {
            v0 = "{}";
        }
        else {
            StringBuilder v1 = new StringBuilder(this.h * 14);
            v1.append('{');
            int v0_1;
            for(v0_1 = 0; v0_1 < this.h; ++v0_1) {
                if(v0_1 > 0) {
                    v1.append(", ");
                }

                Object v2 = this.b(v0_1);
                if((((b)v2)) != this) {
                    v1.append(v2);
                }
                else {
                    v1.append("(this Set)");
                }
            }

            v1.append('}');
            v0 = v1.toString();
        }

        return v0;
    }
}

