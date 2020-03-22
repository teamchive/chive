package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;

abstract class MapCollections {
    final class ArrayIterator implements Iterator {
        boolean mCanRemove;
        int mIndex;
        final int mOffset;
        int mSize;

        ArrayIterator(MapCollections arg2, int arg3) {
            MapCollections.this = arg2;
            super();
            this.mCanRemove = false;
            this.mOffset = arg3;
            this.mSize = arg2.colGetSize();
        }

        public boolean hasNext() {
            boolean v0 = this.mIndex < this.mSize ? true : false;
            return v0;
        }

        public Object next() {
            Object v0 = MapCollections.this.colGetEntry(this.mIndex, this.mOffset);
            ++this.mIndex;
            this.mCanRemove = true;
            return v0;
        }

        public void remove() {
            if(!this.mCanRemove) {
                throw new IllegalStateException();
            }

            --this.mIndex;
            --this.mSize;
            this.mCanRemove = false;
            MapCollections.this.colRemoveAt(this.mIndex);
        }
    }

    final class EntrySet implements Set {
        EntrySet(MapCollections arg1) {
            MapCollections.this = arg1;
            super();
        }

        public boolean add(Object arg2) {
            return this.add(((Map$Entry)arg2));
        }

        public boolean add(Map$Entry arg2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection arg6) {
            int v1 = MapCollections.this.colGetSize();
            Iterator v2 = arg6.iterator();
            while(v2.hasNext()) {
                Object v0 = v2.next();
                MapCollections.this.colPut(((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue());
            }

            boolean v0_1 = v1 != MapCollections.this.colGetSize() ? true : false;
            return v0_1;
        }

        public void clear() {
            MapCollections.this.colClear();
        }

        public boolean contains(Object arg4) {
            boolean v0 = false;
            if((arg4 instanceof Map$Entry)) {
                int v1 = MapCollections.this.colIndexOfKey(((Map$Entry)arg4).getKey());
                if(v1 >= 0) {
                    v0 = ContainerHelpers.equal(MapCollections.this.colGetEntry(v1, 1), ((Map$Entry)arg4).getValue());
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
            return MapCollections.equalsSetHelper(((Set)this), arg2);
        }

        public int hashCode() {
            int v3 = MapCollections.this.colGetSize() - 1;
            int v4;
            for(v4 = 0; v3 >= 0; v4 += v0_1 ^ v2) {
                Object v0 = MapCollections.this.colGetEntry(v3, 0);
                Object v5 = MapCollections.this.colGetEntry(v3, 1);
                int v2 = v0 == null ? 0 : v0.hashCode();
                int v0_1 = v5 == null ? 0 : v5.hashCode();
                --v3;
            }

            return v4;
        }

        public boolean isEmpty() {
            boolean v0 = MapCollections.this.colGetSize() == 0 ? true : false;
            return v0;
        }

        public Iterator iterator() {
            return new MapIterator(MapCollections.this);
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
            return MapCollections.this.colGetSize();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public Object[] toArray(Object[] arg2) {
            throw new UnsupportedOperationException();
        }
    }

    final class KeySet implements Set {
        KeySet(MapCollections arg1) {
            MapCollections.this = arg1;
            super();
        }

        public boolean add(Object arg2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection arg2) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            MapCollections.this.colClear();
        }

        public boolean contains(Object arg2) {
            boolean v0 = MapCollections.this.colIndexOfKey(arg2) >= 0 ? true : false;
            return v0;
        }

        public boolean containsAll(Collection arg2) {
            return MapCollections.containsAllHelper(MapCollections.this.colGetMap(), arg2);
        }

        public boolean equals(Object arg2) {
            return MapCollections.equalsSetHelper(((Set)this), arg2);
        }

        public int hashCode() {
            int v2 = MapCollections.this.colGetSize() - 1;
            int v3 = 0;
            while(v2 >= 0) {
                Object v0 = MapCollections.this.colGetEntry(v2, 0);
                int v0_1 = v0 == null ? 0 : v0.hashCode();
                v3 += v0_1;
                --v2;
            }

            return v3;
        }

        public boolean isEmpty() {
            boolean v0 = MapCollections.this.colGetSize() == 0 ? true : false;
            return v0;
        }

        public Iterator iterator() {
            return new ArrayIterator(MapCollections.this, 0);
        }

        public boolean remove(Object arg3) {
            boolean v0_1;
            int v0 = MapCollections.this.colIndexOfKey(arg3);
            if(v0 >= 0) {
                MapCollections.this.colRemoveAt(v0);
                v0_1 = true;
            }
            else {
                v0_1 = false;
            }

            return v0_1;
        }

        public boolean removeAll(Collection arg2) {
            return MapCollections.removeAllHelper(MapCollections.this.colGetMap(), arg2);
        }

        public boolean retainAll(Collection arg2) {
            return MapCollections.retainAllHelper(MapCollections.this.colGetMap(), arg2);
        }

        public int size() {
            return MapCollections.this.colGetSize();
        }

        public Object[] toArray() {
            return MapCollections.this.toArrayHelper(0);
        }

        public Object[] toArray(Object[] arg3) {
            return MapCollections.this.toArrayHelper(arg3, 0);
        }
    }

    final class MapIterator implements Iterator, Map$Entry {
        int mEnd;
        boolean mEntryValid;
        int mIndex;

        MapIterator(MapCollections arg2) {
            MapCollections.this = arg2;
            super();
            this.mEntryValid = false;
            this.mEnd = arg2.colGetSize() - 1;
            this.mIndex = -1;
        }

        public final boolean equals(Object arg6) {
            boolean v0 = true;
            boolean v1 = false;
            if(!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }

            if((arg6 instanceof Map$Entry)) {
                if(!ContainerHelpers.equal(((Map$Entry)arg6).getKey(), MapCollections.this.colGetEntry(this.mIndex, 0)) || !ContainerHelpers.equal(((Map$Entry)arg6).getValue(), MapCollections.this.colGetEntry(this.mIndex, 1))) {
                    v0 = false;
                }

                v1 = v0;
            }

            return v1;
        }

        public Object getKey() {
            if(!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }

            return MapCollections.this.colGetEntry(this.mIndex, 0);
        }

        public Object getValue() {
            if(!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }

            return MapCollections.this.colGetEntry(this.mIndex, 1);
        }

        public boolean hasNext() {
            boolean v0 = this.mIndex < this.mEnd ? true : false;
            return v0;
        }

        public final int hashCode() {
            int v0 = 0;
            if(!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }

            Object v1 = MapCollections.this.colGetEntry(this.mIndex, 0);
            Object v2 = MapCollections.this.colGetEntry(this.mIndex, 1);
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            if(v2 != null) {
                v0 = v2.hashCode();
            }

            return v0 ^ v1_1;
        }

        public Object next() {
            return this.next();
        }

        public Map$Entry next() {
            ++this.mIndex;
            this.mEntryValid = true;
            return this;
        }

        public void remove() {
            if(!this.mEntryValid) {
                throw new IllegalStateException();
            }

            MapCollections.this.colRemoveAt(this.mIndex);
            --this.mIndex;
            --this.mEnd;
            this.mEntryValid = false;
        }

        public Object setValue(Object arg3) {
            if(!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }

            return MapCollections.this.colSetValue(this.mIndex, arg3);
        }

        public final String toString() {
            return this.getKey() + "=" + this.getValue();
        }
    }

    final class ValuesCollection implements Collection {
        ValuesCollection(MapCollections arg1) {
            MapCollections.this = arg1;
            super();
        }

        public boolean add(Object arg2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection arg2) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            MapCollections.this.colClear();
        }

        public boolean contains(Object arg2) {
            boolean v0 = MapCollections.this.colIndexOfValue(arg2) >= 0 ? true : false;
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
            boolean v0 = MapCollections.this.colGetSize() == 0 ? true : false;
            return v0;
        }

        public Iterator iterator() {
            return new ArrayIterator(MapCollections.this, 1);
        }

        public boolean remove(Object arg3) {
            boolean v0_1;
            int v0 = MapCollections.this.colIndexOfValue(arg3);
            if(v0 >= 0) {
                MapCollections.this.colRemoveAt(v0);
                v0_1 = true;
            }
            else {
                v0_1 = false;
            }

            return v0_1;
        }

        public boolean removeAll(Collection arg6) {
            int v0 = 0;
            int v3 = MapCollections.this.colGetSize();
            boolean v1 = false;
            while(v0 < v3) {
                if(arg6.contains(MapCollections.this.colGetEntry(v0, 1))) {
                    MapCollections.this.colRemoveAt(v0);
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
            int v3 = MapCollections.this.colGetSize();
            boolean v1 = false;
            while(v0 < v3) {
                if(!arg6.contains(MapCollections.this.colGetEntry(v0, 1))) {
                    MapCollections.this.colRemoveAt(v0);
                    --v0;
                    --v3;
                    v1 = true;
                }

                ++v0;
            }

            return v1;
        }

        public int size() {
            return MapCollections.this.colGetSize();
        }

        public Object[] toArray() {
            return MapCollections.this.toArrayHelper(1);
        }

        public Object[] toArray(Object[] arg3) {
            return MapCollections.this.toArrayHelper(arg3, 1);
        }
    }

    EntrySet mEntrySet;
    KeySet mKeySet;
    ValuesCollection mValues;

    MapCollections() {
        super();
    }

    protected abstract void colClear();

    protected abstract Object colGetEntry(int arg1, int arg2);

    protected abstract Map colGetMap();

    protected abstract int colGetSize();

    protected abstract int colIndexOfKey(Object arg1);

    protected abstract int colIndexOfValue(Object arg1);

    protected abstract void colPut(Object arg1, Object arg2);

    protected abstract void colRemoveAt(int arg1);

    protected abstract Object colSetValue(int arg1, Object arg2);

    public static boolean containsAllHelper(Map arg2, Collection arg3) {
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

    public static boolean equalsSetHelper(Set arg4, Object arg5) {
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

    public Set getEntrySet() {
        if(this.mEntrySet == null) {
            this.mEntrySet = new EntrySet(this);
        }

        return this.mEntrySet;
    }

    public Set getKeySet() {
        if(this.mKeySet == null) {
            this.mKeySet = new KeySet(this);
        }

        return this.mKeySet;
    }

    public Collection getValues() {
        if(this.mValues == null) {
            this.mValues = new ValuesCollection(this);
        }

        return this.mValues;
    }

    public static boolean removeAllHelper(Map arg3, Collection arg4) {
        int v0 = arg3.size();
        Iterator v1 = arg4.iterator();
        while(v1.hasNext()) {
            arg3.remove(v1.next());
        }

        boolean v0_1 = v0 != arg3.size() ? true : false;
        return v0_1;
    }

    public static boolean retainAllHelper(Map arg3, Collection arg4) {
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

    public Object[] toArrayHelper(int arg5) {
        int v1 = this.colGetSize();
        Object[] v2 = new Object[v1];
        int v0;
        for(v0 = 0; v0 < v1; ++v0) {
            v2[v0] = this.colGetEntry(v0, arg5);
        }

        return v2;
    }

    public Object[] toArrayHelper(Object[] arg5, int arg6) {
        Object[] v0_1;
        int v2 = this.colGetSize();
        if(arg5.length < v2) {
            Object v0 = Array.newInstance(arg5.getClass().getComponentType(), v2);
        }
        else {
            v0_1 = arg5;
        }

        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            v0_1[v1] = this.colGetEntry(v1, arg6);
        }

        if(v0_1.length > v2) {
            v0_1[v2] = null;
        }

        return v0_1;
    }
}

