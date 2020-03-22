package android.support.v4.g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class h {
    final class a implements Iterator {
        final int a;
        int b;
        int c;
        boolean d;

        a(h arg2, int arg3) {
            this.e = arg2;
            super();
            this.d = false;
            this.a = arg3;
            this.b = arg2.a();
        }

        public boolean hasNext() {
            boolean v0 = this.c < this.b ? true : false;
            return v0;
        }

        public Object next() {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }

            Object v0 = this.e.a(this.c, this.a);
            ++this.c;
            this.d = true;
            return v0;
        }

        public void remove() {
            if(!this.d) {
                throw new IllegalStateException();
            }

            --this.c;
            --this.b;
            this.d = false;
            this.e.a(this.c);
        }
    }

    final class b implements Set {
        b(h arg1) {
            this.a = arg1;
            super();
        }

        public boolean a(Map$Entry arg2) {
            throw new UnsupportedOperationException();
        }

        public boolean add(Object arg2) {
            return this.a(((Map$Entry)arg2));
        }

        public boolean addAll(Collection arg6) {
            int v1 = this.a.a();
            Iterator v2 = arg6.iterator();
            while(v2.hasNext()) {
                Object v0 = v2.next();
                this.a.a(((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue());
            }

            boolean v0_1 = v1 != this.a.a() ? true : false;
            return v0_1;
        }

        public void clear() {
            this.a.c();
        }

        public boolean contains(Object arg4) {
            boolean v0 = false;
            if((arg4 instanceof Map$Entry)) {
                int v1 = this.a.a(((Map$Entry)arg4).getKey());
                if(v1 >= 0) {
                    v0 = c.a(this.a.a(v1, 1), ((Map$Entry)arg4).getValue());
                }
            }

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

        public boolean equals(Object arg2) {
            return h.a(((Set)this), arg2);
        }

        public int hashCode() {
            int v3 = this.a.a() - 1;
            int v4;
            for(v4 = 0; v3 >= 0; v4 += v0_1 ^ v2) {
                Object v0 = this.a.a(v3, 0);
                Object v5 = this.a.a(v3, 1);
                int v2 = v0 == null ? 0 : v0.hashCode();
                int v0_1 = v5 == null ? 0 : v5.hashCode();
                --v3;
            }

            return v4;
        }

        public boolean isEmpty() {
            boolean v0 = this.a.a() == 0 ? true : false;
            return v0;
        }

        public Iterator iterator() {
            return new d(this.a);
        }

        public boolean remove(Object arg2) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection arg2) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection arg2) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.a.a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public Object[] toArray(Object[] arg2) {
            throw new UnsupportedOperationException();
        }
    }

    final class android.support.v4.g.h$c implements Set {
        android.support.v4.g.h$c(h arg1) {
            this.a = arg1;
            super();
        }

        public boolean add(Object arg2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection arg2) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.a.c();
        }

        public boolean contains(Object arg2) {
            boolean v0 = this.a.a(arg2) >= 0 ? true : false;
            return v0;
        }

        public boolean containsAll(Collection arg2) {
            return h.a(this.a.b(), arg2);
        }

        public boolean equals(Object arg2) {
            return h.a(((Set)this), arg2);
        }

        public int hashCode() {
            int v2 = this.a.a() - 1;
            int v3 = 0;
            while(v2 >= 0) {
                Object v0 = this.a.a(v2, 0);
                int v0_1 = v0 == null ? 0 : v0.hashCode();
                v3 += v0_1;
                --v2;
            }

            return v3;
        }

        public boolean isEmpty() {
            boolean v0 = this.a.a() == 0 ? true : false;
            return v0;
        }

        public Iterator iterator() {
            return new a(this.a, 0);
        }

        public boolean remove(Object arg3) {
            boolean v0_1;
            int v0 = this.a.a(arg3);
            if(v0 >= 0) {
                this.a.a(v0);
                v0_1 = true;
            }
            else {
                v0_1 = false;
            }

            return v0_1;
        }

        public boolean removeAll(Collection arg2) {
            return h.b(this.a.b(), arg2);
        }

        public boolean retainAll(Collection arg2) {
            return h.c(this.a.b(), arg2);
        }

        public int size() {
            return this.a.a();
        }

        public Object[] toArray() {
            return this.a.b(0);
        }

        public Object[] toArray(Object[] arg3) {
            return this.a.a(arg3, 0);
        }
    }

    final class d implements Iterator, Map$Entry {
        int a;
        int b;
        boolean c;

        d(h arg2) {
            this.d = arg2;
            super();
            this.c = false;
            this.a = arg2.a() - 1;
            this.b = -1;
        }

        public Map$Entry a() {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }

            ++this.b;
            this.c = true;
            return this;
        }

        public final boolean equals(Object arg6) {
            boolean v0 = true;
            boolean v1 = false;
            if(!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }

            if((arg6 instanceof Map$Entry)) {
                if(!c.a(((Map$Entry)arg6).getKey(), this.d.a(this.b, 0)) || !c.a(((Map$Entry)arg6).getValue(), this.d.a(this.b, 1))) {
                    v0 = false;
                }

                v1 = v0;
            }

            return v1;
        }

        public Object getKey() {
            if(!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }

            return this.d.a(this.b, 0);
        }

        public Object getValue() {
            if(!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }

            return this.d.a(this.b, 1);
        }

        public boolean hasNext() {
            boolean v0 = this.b < this.a ? true : false;
            return v0;
        }

        public final int hashCode() {
            int v0 = 0;
            if(!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }

            Object v1 = this.d.a(this.b, 0);
            Object v2 = this.d.a(this.b, 1);
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            if(v2 != null) {
                v0 = v2.hashCode();
            }

            return v0 ^ v1_1;
        }

        public Object next() {
            return this.a();
        }

        public void remove() {
            if(!this.c) {
                throw new IllegalStateException();
            }

            this.d.a(this.b);
            --this.b;
            --this.a;
            this.c = false;
        }

        public Object setValue(Object arg3) {
            if(!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }

            return this.d.a(this.b, arg3);
        }

        public final String toString() {
            return this.getKey() + "=" + this.getValue();
        }
    }

    final class e implements Collection {
        e(h arg1) {
            this.a = arg1;
            super();
        }

        public boolean add(Object arg2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection arg2) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.a.c();
        }

        public boolean contains(Object arg2) {
            boolean v0 = this.a.b(arg2) >= 0 ? true : false;
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

        public boolean isEmpty() {
            boolean v0 = this.a.a() == 0 ? true : false;
            return v0;
        }

        public Iterator iterator() {
            return new a(this.a, 1);
        }

        public boolean remove(Object arg3) {
            boolean v0_1;
            int v0 = this.a.b(arg3);
            if(v0 >= 0) {
                this.a.a(v0);
                v0_1 = true;
            }
            else {
                v0_1 = false;
            }

            return v0_1;
        }

        public boolean removeAll(Collection arg6) {
            int v0 = 0;
            int v3 = this.a.a();
            boolean v1 = false;
            while(v0 < v3) {
                if(arg6.contains(this.a.a(v0, 1))) {
                    this.a.a(v0);
                    --v0;
                    --v3;
                    v1 = true;
                }

                ++v0;
            }

            return v1;
        }

        public boolean retainAll(Collection arg6) {
            int v0 = 0;
            int v3 = this.a.a();
            boolean v1 = false;
            while(v0 < v3) {
                if(!arg6.contains(this.a.a(v0, 1))) {
                    this.a.a(v0);
                    --v0;
                    --v3;
                    v1 = true;
                }

                ++v0;
            }

            return v1;
        }

        public int size() {
            return this.a.a();
        }

        public Object[] toArray() {
            return this.a.b(1);
        }

        public Object[] toArray(Object[] arg3) {
            return this.a.a(arg3, 1);
        }
    }

    b b;
    android.support.v4.g.h$c c;
    e d;

    h() {
        super();
    }

    public static boolean a(Map arg2, Collection arg3) {
        Iterator v0 = arg3.iterator();
        do {
            if(v0.hasNext()) {
                if(arg2.containsKey(v0.next())) {
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

    public static boolean a(Set arg4, Object arg5) {
        boolean v0 = true;
        boolean v1 = false;
        if(arg4 == (((Set)arg5))) {
            return true;
        }

        if((arg5 instanceof Set)) {
            try {
                if(arg4.size() != ((Set)arg5).size()) {
                    goto label_14;
                }
                else if(!arg4.containsAll(((Collection)arg5))) {
                    goto label_14;
                }

                goto label_12;
            }
            catch(ClassCastException v0_1) {
                return v1;
            }
            catch(NullPointerException v0_2) {
                return v1;
            }

        label_14:
            v0 = false;
        label_12:
            v1 = v0;
        }

        return v1;
    }

    protected abstract int a();

    protected abstract int a(Object arg1);

    protected abstract Object a(int arg1, int arg2);

    protected abstract Object a(int arg1, Object arg2);

    protected abstract void a(int arg1);

    protected abstract void a(Object arg1, Object arg2);

    public Object[] a(Object[] arg5, int arg6) {
        Object v0;
        int v2 = this.a();
        if(arg5.length < v2) {
            v0 = Array.newInstance(arg5.getClass().getComponentType(), v2);
        }
        else {
            Object[] v0_1 = arg5;
        }

        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            v0[v1] = this.a(v1, arg6);
        }

        if(v0.length > v2) {
            v0[v2] = null;
        }

        return ((Object[])v0);
    }

    public static boolean b(Map arg3, Collection arg4) {
        int v0 = arg3.size();
        Iterator v1 = arg4.iterator();
        while(v1.hasNext()) {
            arg3.remove(v1.next());
        }

        boolean v0_1 = v0 != arg3.size() ? true : false;
        return v0_1;
    }

    protected abstract int b(Object arg1);

    protected abstract Map b();

    public Object[] b(int arg5) {
        int v1 = this.a();
        Object[] v2 = new Object[v1];
        int v0;
        for(v0 = 0; v0 < v1; ++v0) {
            v2[v0] = this.a(v0, arg5);
        }

        return v2;
    }

    public static boolean c(Map arg3, Collection arg4) {
        int v0 = arg3.size();
        Iterator v1 = arg3.keySet().iterator();
        while(v1.hasNext()) {
            if(arg4.contains(v1.next())) {
                continue;
            }

            v1.remove();
        }

        boolean v0_1 = v0 != arg3.size() ? true : false;
        return v0_1;
    }

    protected abstract void c();

    public Set d() {
        if(this.b == null) {
            this.b = new b(this);
        }

        return this.b;
    }

    public Set e() {
        if(this.c == null) {
            this.c = new android.support.v4.g.h$c(this);
        }

        return this.c;
    }

    public Collection f() {
        if(this.d == null) {
            this.d = new e(this);
        }

        return this.d;
    }
}

