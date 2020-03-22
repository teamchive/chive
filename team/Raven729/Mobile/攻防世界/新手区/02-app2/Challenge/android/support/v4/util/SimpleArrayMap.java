package android.support.v4.util;

import java.util.Map;

public class SimpleArrayMap {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    Object[] mArray;
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    int[] mHashes;
    int mSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;

    public SimpleArrayMap() {
        super();
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    public SimpleArrayMap(int arg2) {
        super();
        if(arg2 == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        }
        else {
            this.allocArrays(arg2);
        }

        this.mSize = 0;
    }

    public SimpleArrayMap(SimpleArrayMap arg1) {
        this();
        if(arg1 != null) {
            this.putAll(arg1);
        }
    }

    private void allocArrays(int arg6) {
        Object[] v2;
        Class v1;
        if(arg6 == 8) {
            v1 = ArrayMap.class;
            __monitor_enter(v1);
            try {
                if(SimpleArrayMap.mTwiceBaseCache != null) {
                    v2 = SimpleArrayMap.mTwiceBaseCache;
                    this.mArray = v2;
                    SimpleArrayMap.mTwiceBaseCache = v2[0];
                    this.mHashes = v2[1];
                    v2[1] = null;
                    v2[0] = null;
                    --SimpleArrayMap.mTwiceBaseCacheSize;
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
            v1 = ArrayMap.class;
            __monitor_enter(v1);
            try {
                if(SimpleArrayMap.mBaseCache != null) {
                    v2 = SimpleArrayMap.mBaseCache;
                    this.mArray = v2;
                    SimpleArrayMap.mBaseCache = v2[0];
                    this.mHashes = v2[1];
                    v2[1] = null;
                    v2[0] = null;
                    --SimpleArrayMap.mBaseCacheSize;
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
            this.mHashes = new int[arg6];
            this.mArray = new Object[arg6 << 1];
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

    public void clear() {
        if(this.mSize != 0) {
            SimpleArrayMap.freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
        }
    }

    public boolean containsKey(Object arg2) {
        boolean v0 = this.indexOfKey(arg2) >= 0 ? true : false;
        return v0;
    }

    public boolean containsValue(Object arg2) {
        boolean v0 = this.indexOfValue(arg2) >= 0 ? true : false;
        return v0;
    }

    public void ensureCapacity(int arg6) {
        if(this.mHashes.length < arg6) {
            int[] v0 = this.mHashes;
            Object[] v1 = this.mArray;
            this.allocArrays(arg6);
            if(this.mSize > 0) {
                System.arraycopy(v0, 0, this.mHashes, 0, this.mSize);
                System.arraycopy(v1, 0, this.mArray, 0, this.mSize << 1);
            }

            SimpleArrayMap.freeArrays(v0, v1, this.mSize);
        }
    }

    public boolean equals(Object arg7) {
        Object v5;
        Object v4;
        Object v3;
        boolean v0 = true;
        if(this == (((SimpleArrayMap)arg7))) {
            return v0;
        }

        if(!(arg7 instanceof SimpleArrayMap)) {
            goto label_35;
        }

        if(this.size() != ((SimpleArrayMap)arg7).size()) {
            return false;
        }

        int v2 = 0;
        try {
            while(true) {
            label_12:
                if(v2 >= this.mSize) {
                    return v0;
                }

                v3 = this.keyAt(v2);
                v4 = this.valueAt(v2);
                v5 = ((SimpleArrayMap)arg7).get(v3);
                if(v4 == null) {
                    if(v5 == null && (((SimpleArrayMap)arg7).containsKey(v3))) {
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
                if(v2 >= this.mSize) {
                    return v0;
                }

                v3 = this.keyAt(v2);
                v4 = this.valueAt(v2);
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

    private static void freeArrays(int[] arg4, Object[] arg5, int arg6) {
        Class v1;
        int v2 = 10;
        int v3 = 2;
        if(arg4.length == 8) {
            v1 = ArrayMap.class;
            __monitor_enter(v1);
            try {
                if(SimpleArrayMap.mTwiceBaseCacheSize < v2) {
                    arg5[0] = SimpleArrayMap.mTwiceBaseCache;
                    arg5[1] = arg4;
                    int v0_1;
                    for(v0_1 = (arg6 << 1) - 1; v0_1 >= v3; --v0_1) {
                        arg5[v0_1] = null;
                    }

                    SimpleArrayMap.mTwiceBaseCache = arg5;
                    ++SimpleArrayMap.mTwiceBaseCacheSize;
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

            v1 = ArrayMap.class;
            __monitor_enter(v1);
            try {
                if(SimpleArrayMap.mBaseCacheSize < v2) {
                    arg5[0] = SimpleArrayMap.mBaseCache;
                    arg5[1] = arg4;
                    for(v0_1 = (arg6 << 1) - 1; v0_1 >= v3; --v0_1) {
                        arg5[v0_1] = null;
                    }

                    SimpleArrayMap.mBaseCache = arg5;
                    ++SimpleArrayMap.mBaseCacheSize;
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

    public Object get(Object arg3) {
        int v0 = this.indexOfKey(arg3);
        Object v0_1 = v0 >= 0 ? this.mArray[(v0 << 1) + 1] : null;
        return v0_1;
    }

    public int hashCode() {
        int[] v5 = this.mHashes;
        Object[] v6 = this.mArray;
        int v7 = this.mSize;
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

    int indexOf(Object arg6, int arg7) {
        int v0;
        int v2 = this.mSize;
        if(v2 == 0) {
            v0 = -1;
        }
        else {
            v0 = ContainerHelpers.binarySearch(this.mHashes, v2, arg7);
            if(v0 >= 0 && !arg6.equals(this.mArray[v0 << 1])) {
                int v1 = v0 + 1;
                while(v1 < v2) {
                    if(this.mHashes[v1] != arg7) {
                        break;
                    }

                    if(arg6.equals(this.mArray[v1 << 1])) {
                        return v1;
                    }
                    else {
                        ++v1;
                        continue;
                    }
                }

                --v0;
                while(v0 >= 0) {
                    if(this.mHashes[v0] != arg7) {
                        break;
                    }

                    if(!arg6.equals(this.mArray[v0 << 1])) {
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

    public int indexOfKey(Object arg2) {
        int v0 = arg2 == null ? this.indexOfNull() : this.indexOf(arg2, arg2.hashCode());
        return v0;
    }

    int indexOfNull() {
        int v0;
        int v2 = this.mSize;
        if(v2 == 0) {
            v0 = -1;
        }
        else {
            v0 = ContainerHelpers.binarySearch(this.mHashes, v2, 0);
            if(v0 >= 0 && this.mArray[v0 << 1] != null) {
                int v1 = v0 + 1;
                while(v1 < v2) {
                    if(this.mHashes[v1] != 0) {
                        break;
                    }

                    if(this.mArray[v1 << 1] == null) {
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

                    if(this.mArray[v0 << 1] != null) {
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

    int indexOfValue(Object arg5) {
        int v0 = 1;
        int v1 = this.mSize * 2;
        Object[] v2 = this.mArray;
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

    public boolean isEmpty() {
        boolean v0 = this.mSize <= 0 ? true : false;
        return v0;
    }

    public Object keyAt(int arg3) {
        return this.mArray[arg3 << 1];
    }

    public Object put(Object arg8, Object arg9) {
        Object v0_1;
        int v3;
        int v2;
        int v0 = 8;
        int v1 = 4;
        if(arg8 == null) {
            v2 = this.indexOfNull();
            v3 = 0;
        }
        else {
            v3 = arg8.hashCode();
            v2 = this.indexOf(arg8, v3);
        }

        if(v2 >= 0) {
            v1 = (v2 << 1) + 1;
            v0_1 = this.mArray[v1];
            this.mArray[v1] = arg9;
        }
        else {
            v2 ^= -1;
            if(this.mSize >= this.mHashes.length) {
                if(this.mSize >= v0) {
                    v0 = this.mSize + (this.mSize >> 1);
                }
                else if(this.mSize < v1) {
                    v0 = v1;
                }

                int[] v1_1 = this.mHashes;
                Object[] v5 = this.mArray;
                this.allocArrays(v0);
                if(this.mHashes.length > 0) {
                    System.arraycopy(v1_1, 0, this.mHashes, 0, v1_1.length);
                    System.arraycopy(v5, 0, this.mArray, 0, v5.length);
                }

                SimpleArrayMap.freeArrays(v1_1, v5, this.mSize);
            }

            if(v2 < this.mSize) {
                System.arraycopy(this.mHashes, v2, this.mHashes, v2 + 1, this.mSize - v2);
                System.arraycopy(this.mArray, v2 << 1, this.mArray, v2 + 1 << 1, this.mSize - v2 << 1);
            }

            this.mHashes[v2] = v3;
            this.mArray[v2 << 1] = arg8;
            this.mArray[(v2 << 1) + 1] = arg9;
            ++this.mSize;
            v0_1 = null;
        }

        return v0_1;
    }

    public void putAll(SimpleArrayMap arg6) {
        int v0 = 0;
        int v1 = arg6.mSize;
        this.ensureCapacity(this.mSize + v1);
        if(this.mSize != 0) {
            while(v0 < v1) {
                this.put(arg6.keyAt(v0), arg6.valueAt(v0));
                ++v0;
            }
        }
        else if(v1 > 0) {
            System.arraycopy(arg6.mHashes, 0, this.mHashes, 0, v1);
            System.arraycopy(arg6.mArray, 0, this.mArray, 0, v1 << 1);
            this.mSize = v1;
        }
    }

    public Object remove(Object arg2) {
        int v0 = this.indexOfKey(arg2);
        Object v0_1 = v0 >= 0 ? this.removeAt(v0) : null;
        return v0_1;
    }

    public Object removeAt(int arg8) {
        Object v6 = null;
        int v0 = 8;
        Object v1 = this.mArray[(arg8 << 1) + 1];
        if(this.mSize <= 1) {
            SimpleArrayMap.freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
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
                if(arg8 > 0) {
                    System.arraycopy(v2, 0, this.mHashes, 0, arg8);
                    System.arraycopy(v3, 0, this.mArray, 0, arg8 << 1);
                }

                if(arg8 >= this.mSize) {
                    return v1;
                }

                System.arraycopy(v2, arg8 + 1, this.mHashes, arg8, this.mSize - arg8);
                System.arraycopy(v3, arg8 + 1 << 1, this.mArray, arg8 << 1, this.mSize - arg8 << 1);
                return v1;
            }

            --this.mSize;
            if(arg8 < this.mSize) {
                System.arraycopy(this.mHashes, arg8 + 1, this.mHashes, arg8, this.mSize - arg8);
                System.arraycopy(this.mArray, arg8 + 1 << 1, this.mArray, arg8 << 1, this.mSize - arg8 << 1);
            }

            this.mArray[this.mSize << 1] = v6;
            this.mArray[(this.mSize << 1) + 1] = v6;
        }

        return v1;
    }

    public Object setValueAt(int arg4, Object arg5) {
        int v0 = (arg4 << 1) + 1;
        Object v1 = this.mArray[v0];
        this.mArray[v0] = arg5;
        return v1;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        String v0;
        if(this.isEmpty()) {
            v0 = "{}";
        }
        else {
            StringBuilder v1 = new StringBuilder(this.mSize * 28);
            v1.append('{');
            int v0_1;
            for(v0_1 = 0; v0_1 < this.mSize; ++v0_1) {
                if(v0_1 > 0) {
                    v1.append(", ");
                }

                Object v2 = this.keyAt(v0_1);
                if((((SimpleArrayMap)v2)) != this) {
                    v1.append(v2);
                }
                else {
                    v1.append("(this Map)");
                }

                v1.append('=');
                v2 = this.valueAt(v0_1);
                if((((SimpleArrayMap)v2)) != this) {
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

    public Object valueAt(int arg3) {
        return this.mArray[(arg3 << 1) + 1];
    }
}

