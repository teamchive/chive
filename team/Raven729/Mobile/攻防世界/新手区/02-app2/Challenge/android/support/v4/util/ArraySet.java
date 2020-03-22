package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet implements Collection, Set {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT = null;
    private static final Object[] OBJECT = null;
    private static final String TAG = "ArraySet";
    Object[] mArray;
    MapCollections mCollections;
    int[] mHashes;
    final boolean mIdentityHashCode;
    int mSize;
    static Object[] sBaseCache;
    static int sBaseCacheSize;
    static Object[] sTwiceBaseCache;
    static int sTwiceBaseCacheSize;

    static {
        ArraySet.INT = new int[0];
        ArraySet.OBJECT = new Object[0];
    }

    public ArraySet() {
        this(0, false);
    }

    public ArraySet(int arg2, boolean arg3) {
        super();
        this.mIdentityHashCode = arg3;
        if(arg2 == 0) {
            this.mHashes = ArraySet.INT;
            this.mArray = ArraySet.OBJECT;
        }
        else {
            this.allocArrays(arg2);
        }

        this.mSize = 0;
    }

    public ArraySet(int arg2) {
        this(arg2, false);
    }

    public ArraySet(ArraySet arg1) {
        this();
        if(arg1 != null) {
            this.addAll(arg1);
        }
    }

    public ArraySet(Collection arg1) {
        this();
        if(arg1 != null) {
            this.addAll(arg1);
        }
    }

    public boolean add(Object arg9) {
        boolean v0_1;
        int v4;
        int v0;
        int v1 = 8;
        int v2 = 4;
        if(arg9 == null) {
            v0 = this.indexOfNull();
            v4 = 0;
        }
        else {
            v0 = this.mIdentityHashCode ? System.identityHashCode(arg9) : arg9.hashCode();
            v4 = v0;
            v0 = this.indexOf(arg9, v0);
        }

        if(v0 >= 0) {
            v0_1 = false;
        }
        else {
            int v5 = v0 ^ -1;
            if(this.mSize >= this.mHashes.length) {
                if(this.mSize >= v1) {
                    v0 = this.mSize + (this.mSize >> 1);
                }
                else if(this.mSize >= v2) {
                    v0 = v1;
                }
                else {
                    v0 = v2;
                }

                int[] v1_1 = this.mHashes;
                Object[] v2_1 = this.mArray;
                this.allocArrays(v0);
                if(this.mHashes.length > 0) {
                    System.arraycopy(v1_1, 0, this.mHashes, 0, v1_1.length);
                    System.arraycopy(v2_1, 0, this.mArray, 0, v2_1.length);
                }

                ArraySet.freeArrays(v1_1, v2_1, this.mSize);
            }

            if(v5 < this.mSize) {
                System.arraycopy(this.mHashes, v5, this.mHashes, v5 + 1, this.mSize - v5);
                System.arraycopy(this.mArray, v5, this.mArray, v5 + 1, this.mSize - v5);
            }

            this.mHashes[v5] = v4;
            this.mArray[v5] = arg9;
            ++this.mSize;
            v0_1 = true;
        }

        return v0_1;
    }

    public void addAll(ArraySet arg5) {
        int v0 = 0;
        int v1 = arg5.mSize;
        this.ensureCapacity(this.mSize + v1);
        if(this.mSize != 0) {
            while(v0 < v1) {
                this.add(arg5.valueAt(v0));
                ++v0;
            }
        }
        else if(v1 > 0) {
            System.arraycopy(arg5.mHashes, 0, this.mHashes, 0, v1);
            System.arraycopy(arg5.mArray, 0, this.mArray, 0, v1);
            this.mSize = v1;
        }
    }

    public boolean addAll(Collection arg4) {
        this.ensureCapacity(this.mSize + arg4.size());
        int v0 = 0;
        Iterator v1 = arg4.iterator();
        while(v1.hasNext()) {
            v0 |= this.add(v1.next());
        }

        return ((boolean)v0);
    }

    private void allocArrays(int arg6) {
        Object[] v2;
        Class v1;
        if(arg6 == 8) {
            v1 = ArraySet.class;
            __monitor_enter(v1);
            try {
                if(ArraySet.sTwiceBaseCache != null) {
                    v2 = ArraySet.sTwiceBaseCache;
                    this.mArray = v2;
                    ArraySet.sTwiceBaseCache = v2[0];
                    this.mHashes = v2[1];
                    v2[1] = null;
                    v2[0] = null;
                    --ArraySet.sTwiceBaseCacheSize;
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
            v1 = ArraySet.class;
            __monitor_enter(v1);
            try {
                if(ArraySet.sBaseCache != null) {
                    v2 = ArraySet.sBaseCache;
                    this.mArray = v2;
                    ArraySet.sBaseCache = v2[0];
                    this.mHashes = v2[1];
                    v2[1] = null;
                    v2[0] = null;
                    --ArraySet.sBaseCacheSize;
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
            this.mHashes = new int[arg6];
            this.mArray = new Object[arg6];
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

    public void append(Object arg5) {
        int v0;
        int v1 = this.mSize;
        if(arg5 == null) {
            v0 = 0;
        }
        else if(this.mIdentityHashCode) {
            v0 = System.identityHashCode(arg5);
        }
        else {
            v0 = arg5.hashCode();
        }

        if(v1 >= this.mHashes.length) {
            throw new IllegalStateException("Array is full");
        }

        if(v1 <= 0 || this.mHashes[v1 - 1] <= v0) {
            this.mSize = v1 + 1;
            this.mHashes[v1] = v0;
            this.mArray[v1] = arg5;
        }
        else {
            this.add(arg5);
        }
    }

    public void clear() {
        if(this.mSize != 0) {
            ArraySet.freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = ArraySet.INT;
            this.mArray = ArraySet.OBJECT;
            this.mSize = 0;
        }
    }

    public boolean contains(Object arg2) {
        boolean v0 = this.indexOf(arg2) >= 0 ? true : false;
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

    public void ensureCapacity(int arg6) {
        if(this.mHashes.length < arg6) {
            int[] v0 = this.mHashes;
            Object[] v1 = this.mArray;
            this.allocArrays(arg6);
            if(this.mSize > 0) {
                System.arraycopy(v0, 0, this.mHashes, 0, this.mSize);
                System.arraycopy(v1, 0, this.mArray, 0, this.mSize);
            }

            ArraySet.freeArrays(v0, v1, this.mSize);
        }
    }

    public boolean equals(Object arg5) {
        boolean v0 = true;
        if(this == (((ArraySet)arg5))) {
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
                if(v2 >= this.mSize) {
                    return v0;
                }

                if(((Set)arg5).contains(this.valueAt(v2))) {
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

    private static void freeArrays(int[] arg4, Object[] arg5, int arg6) {
        Class v1;
        int v2 = 10;
        int v3 = 2;
        if(arg4.length == 8) {
            v1 = ArraySet.class;
            __monitor_enter(v1);
            try {
                if(ArraySet.sTwiceBaseCacheSize < v2) {
                    arg5[0] = ArraySet.sTwiceBaseCache;
                    arg5[1] = arg4;
                    int v0_1;
                    for(v0_1 = arg6 - 1; v0_1 >= v3; --v0_1) {
                        arg5[v0_1] = null;
                    }

                    ArraySet.sTwiceBaseCache = arg5;
                    ++ArraySet.sTwiceBaseCacheSize;
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

            v1 = ArraySet.class;
            __monitor_enter(v1);
            try {
                if(ArraySet.sBaseCacheSize < v2) {
                    arg5[0] = ArraySet.sBaseCache;
                    arg5[1] = arg4;
                    for(v0_1 = arg6 - 1; v0_1 >= v3; --v0_1) {
                        arg5[v0_1] = null;
                    }

                    ArraySet.sBaseCache = arg5;
                    ++ArraySet.sBaseCacheSize;
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

    private MapCollections getCollection() {
        if(this.mCollections == null) {
            this.mCollections = new MapCollections() {
                protected void colClear() {
                    ArraySet.this.clear();
                }

                protected Object colGetEntry(int arg2, int arg3) {
                    return ArraySet.this.mArray[arg2];
                }

                protected Map colGetMap() {
                    throw new UnsupportedOperationException("not a map");
                }

                protected int colGetSize() {
                    return ArraySet.this.mSize;
                }

                protected int colIndexOfKey(Object arg2) {
                    return ArraySet.this.indexOf(arg2);
                }

                protected int colIndexOfValue(Object arg2) {
                    return ArraySet.this.indexOf(arg2);
                }

                protected void colPut(Object arg2, Object arg3) {
                    ArraySet.this.add(arg2);
                }

                protected void colRemoveAt(int arg2) {
                    ArraySet.this.removeAt(arg2);
                }

                protected Object colSetValue(int arg3, Object arg4) {
                    throw new UnsupportedOperationException("not a map");
                }
            };
        }

        return this.mCollections;
    }

    public int hashCode() {
        int v0 = 0;
        int[] v2 = this.mHashes;
        int v3 = this.mSize;
        int v1 = 0;
        while(v0 < v3) {
            v1 += v2[v0];
            ++v0;
        }

        return v1;
    }

    public int indexOf(Object arg2) {
        int v0;
        if(arg2 == null) {
            v0 = this.indexOfNull();
        }
        else {
            v0 = this.mIdentityHashCode ? System.identityHashCode(arg2) : arg2.hashCode();
            v0 = this.indexOf(arg2, v0);
        }

        return v0;
    }

    private int indexOf(Object arg5, int arg6) {
        int v0;
        int v2 = this.mSize;
        if(v2 == 0) {
            v0 = -1;
        }
        else {
            v0 = ContainerHelpers.binarySearch(this.mHashes, v2, arg6);
            if(v0 >= 0 && !arg5.equals(this.mArray[v0])) {
                int v1 = v0 + 1;
                while(v1 < v2) {
                    if(this.mHashes[v1] != arg6) {
                        break;
                    }

                    if(arg5.equals(this.mArray[v1])) {
                        return v1;
                    }
                    else {
                        ++v1;
                        continue;
                    }
                }

                --v0;
                while(v0 >= 0) {
                    if(this.mHashes[v0] != arg6) {
                        break;
                    }

                    if(!arg5.equals(this.mArray[v0])) {
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

    private int indexOfNull() {
        int v0;
        int v2 = this.mSize;
        if(v2 == 0) {
            v0 = -1;
        }
        else {
            v0 = ContainerHelpers.binarySearch(this.mHashes, v2, 0);
            if(v0 >= 0 && this.mArray[v0] != null) {
                int v1 = v0 + 1;
                while(v1 < v2) {
                    if(this.mHashes[v1] != 0) {
                        break;
                    }

                    if(this.mArray[v1] == null) {
                        return v1;
                    }
                    else {
                        ++v1;
                        continue;
                    }
                }

                --v0;
                while(v0 >= 0) {
                    if(this.mHashes[v0] != 0) {
                        break;
                    }

                    if(this.mArray[v0] != null) {
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

    public boolean isEmpty() {
        boolean v0 = this.mSize <= 0 ? true : false;
        return v0;
    }

    public Iterator iterator() {
        return this.getCollection().getKeySet().iterator();
    }

    public boolean remove(Object arg2) {
        boolean v0_1;
        int v0 = this.indexOf(arg2);
        if(v0 >= 0) {
            this.removeAt(v0);
            v0_1 = true;
        }
        else {
            v0_1 = false;
        }

        return v0_1;
    }

    public boolean removeAll(ArraySet arg6) {
        boolean v0 = false;
        int v2 = arg6.mSize;
        int v3 = this.mSize;
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            this.remove(arg6.valueAt(v1));
        }

        if(v3 != this.mSize) {
            v0 = true;
        }

        return v0;
    }

    public boolean removeAll(Collection arg4) {
        int v0 = 0;
        Iterator v1 = arg4.iterator();
        while(v1.hasNext()) {
            v0 |= this.remove(v1.next());
        }

        return ((boolean)v0);
    }

    public Object removeAt(int arg7) {
        int v0 = 8;
        Object v1 = this.mArray[arg7];
        if(this.mSize <= 1) {
            ArraySet.freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = ArraySet.INT;
            this.mArray = ArraySet.OBJECT;
            this.mSize = 0;
        }
        else {
            if(this.mHashes.length > v0 && this.mSize < this.mHashes.length / 3) {
                if(this.mSize > v0) {
                    v0 = this.mSize + (this.mSize >> 1);
                }

                int[] v2 = this.mHashes;
                Object[] v3 = this.mArray;
                this.allocArrays(v0);
                --this.mSize;
                if(arg7 > 0) {
                    System.arraycopy(v2, 0, this.mHashes, 0, arg7);
                    System.arraycopy(v3, 0, this.mArray, 0, arg7);
                }

                if(arg7 >= this.mSize) {
                    return v1;
                }

                System.arraycopy(v2, arg7 + 1, this.mHashes, arg7, this.mSize - arg7);
                System.arraycopy(v3, arg7 + 1, this.mArray, arg7, this.mSize - arg7);
                return v1;
            }

            --this.mSize;
            if(arg7 < this.mSize) {
                System.arraycopy(this.mHashes, arg7 + 1, this.mHashes, arg7, this.mSize - arg7);
                System.arraycopy(this.mArray, arg7 + 1, this.mArray, arg7, this.mSize - arg7);
            }

            this.mArray[this.mSize] = null;
        }

        return v1;
    }

    public boolean retainAll(Collection arg5) {
        boolean v0 = false;
        int v1;
        for(v1 = this.mSize - 1; v1 >= 0; --v1) {
            if(!arg5.contains(this.mArray[v1])) {
                this.removeAt(v1);
                v0 = true;
            }
        }

        return v0;
    }

    public int size() {
        return this.mSize;
    }

    public Object[] toArray() {
        Object[] v0 = new Object[this.mSize];
        System.arraycopy(this.mArray, 0, v0, 0, this.mSize);
        return v0;
    }

    public Object[] toArray(Object[] arg5) {
        Object v0;
        if(arg5.length < this.mSize) {
            v0 = Array.newInstance(arg5.getClass().getComponentType(), this.mSize);
        }
        else {
            Object[] v0_1 = arg5;
        }

        System.arraycopy(this.mArray, 0, v0, 0, this.mSize);
        if(v0.length > this.mSize) {
            v0[this.mSize] = null;
        }

        return ((Object[])v0);
    }

    public String toString() {
        String v0;
        if(this.isEmpty()) {
            v0 = "{}";
        }
        else {
            StringBuilder v1 = new StringBuilder(this.mSize * 14);
            v1.append('{');
            int v0_1;
            for(v0_1 = 0; v0_1 < this.mSize; ++v0_1) {
                if(v0_1 > 0) {
                    v1.append(", ");
                }

                Object v2 = this.valueAt(v0_1);
                if((((ArraySet)v2)) != this) {
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

    public Object valueAt(int arg2) {
        return this.mArray[arg2];
    }
}

