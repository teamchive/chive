package android.support.v4.util;

public class LongSparseArray implements Cloneable {
    private static final Object DELETED;
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    static {
        LongSparseArray.DELETED = new Object();
    }

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int arg4) {
        super();
        this.mGarbage = false;
        if(arg4 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_LONGS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        }
        else {
            int v0 = ContainerHelpers.idealLongArraySize(arg4);
            this.mKeys = new long[v0];
            this.mValues = new Object[v0];
        }

        this.mSize = 0;
    }

    public void append(long arg8, Object arg10) {
        if(this.mSize == 0 || arg8 > this.mKeys[this.mSize - 1]) {
            if((this.mGarbage) && this.mSize >= this.mKeys.length) {
                this.gc();
            }

            int v0 = this.mSize;
            if(v0 >= this.mKeys.length) {
                int v1 = ContainerHelpers.idealLongArraySize(v0 + 1);
                long[] v2 = new long[v1];
                Object[] v1_1 = new Object[v1];
                System.arraycopy(this.mKeys, 0, v2, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, v1_1, 0, this.mValues.length);
                this.mKeys = v2;
                this.mValues = v1_1;
            }

            this.mKeys[v0] = arg8;
            this.mValues[v0] = arg10;
            this.mSize = v0 + 1;
        }
        else {
            this.put(arg8, arg10);
        }
    }

    public void clear() {
        int v2 = this.mSize;
        Object[] v3 = this.mValues;
        int v0;
        for(v0 = 0; v0 < v2; ++v0) {
            v3[v0] = null;
        }

        this.mSize = 0;
        this.mGarbage = false;
    }

    public LongSparseArray clone() {
        Object v0_1;
        long[] v1 = null;
        try {
            v0_1 = super.clone();
        }
        catch(CloneNotSupportedException v0) {
            goto label_10;
        }

        try {
            v1 = this.mKeys;
            goto label_3;
        }
        catch(CloneNotSupportedException v1_1) {
        }
        catch(CloneNotSupportedException v0) {
        label_10:
            long[] v0_2 = v1;
            goto label_8;
            try {
            label_3:
                ((LongSparseArray)v0_1).mKeys = v1.clone();
                ((LongSparseArray)v0_1).mValues = this.mValues.clone();
            }
            catch(CloneNotSupportedException v1_1) {
            }
        }

    label_8:
        return ((LongSparseArray)v0_1);
    }

    public Object clone() {
        return this.clone();
    }

    public void delete(long arg4) {
        int v0 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, arg4);
        if(v0 >= 0 && this.mValues[v0] != LongSparseArray.DELETED) {
            this.mValues[v0] = LongSparseArray.DELETED;
            this.mGarbage = true;
        }
    }

    private void gc() {
        int v3 = this.mSize;
        long[] v4 = this.mKeys;
        Object[] v5 = this.mValues;
        int v1 = 0;
        int v0 = 0;
        while(v1 < v3) {
            Object v6 = v5[v1];
            if(v6 != LongSparseArray.DELETED) {
                if(v1 != v0) {
                    v4[v0] = v4[v1];
                    v5[v0] = v6;
                    v5[v1] = null;
                }

                ++v0;
            }

            ++v1;
        }

        this.mGarbage = false;
        this.mSize = v0;
    }

    public Object get(long arg2) {
        return this.get(arg2, null);
    }

    public Object get(long arg4, Object arg6) {
        int v0 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, arg4);
        if(v0 >= 0 && this.mValues[v0] != LongSparseArray.DELETED) {
            arg6 = this.mValues[v0];
        }

        return arg6;
    }

    public int indexOfKey(long arg4) {
        if(this.mGarbage) {
            this.gc();
        }

        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, arg4);
    }

    public int indexOfValue(Object arg3) {
        if(this.mGarbage) {
            this.gc();
        }

        int v0 = 0;
        while(true) {
            if(v0 >= this.mSize) {
                return -1;
            }
            else if(this.mValues[v0] != arg3) {
                ++v0;
                continue;
            }

            return v0;
        }

        return -1;
    }

    public long keyAt(int arg3) {
        if(this.mGarbage) {
            this.gc();
        }

        return this.mKeys[arg3];
    }

    public void put(long arg8, Object arg10) {
        int v0 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, arg8);
        if(v0 >= 0) {
            this.mValues[v0] = arg10;
        }
        else {
            v0 ^= -1;
            if(v0 < this.mSize && this.mValues[v0] == LongSparseArray.DELETED) {
                this.mKeys[v0] = arg8;
                this.mValues[v0] = arg10;
                return;
            }

            if((this.mGarbage) && this.mSize >= this.mKeys.length) {
                this.gc();
                v0 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, arg8) ^ -1;
            }

            if(this.mSize >= this.mKeys.length) {
                int v1 = ContainerHelpers.idealLongArraySize(this.mSize + 1);
                long[] v2 = new long[v1];
                Object[] v1_1 = new Object[v1];
                System.arraycopy(this.mKeys, 0, v2, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, v1_1, 0, this.mValues.length);
                this.mKeys = v2;
                this.mValues = v1_1;
            }

            if(this.mSize - v0 != 0) {
                System.arraycopy(this.mKeys, v0, this.mKeys, v0 + 1, this.mSize - v0);
                System.arraycopy(this.mValues, v0, this.mValues, v0 + 1, this.mSize - v0);
            }

            this.mKeys[v0] = arg8;
            this.mValues[v0] = arg10;
            ++this.mSize;
        }
    }

    public void remove(long arg2) {
        this.delete(arg2);
    }

    public void removeAt(int arg3) {
        if(this.mValues[arg3] != LongSparseArray.DELETED) {
            this.mValues[arg3] = LongSparseArray.DELETED;
            this.mGarbage = true;
        }
    }

    public void setValueAt(int arg2, Object arg3) {
        if(this.mGarbage) {
            this.gc();
        }

        this.mValues[arg2] = arg3;
    }

    public int size() {
        if(this.mGarbage) {
            this.gc();
        }

        return this.mSize;
    }

    public String toString() {
        String v0;
        if(this.size() <= 0) {
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

                v1.append(this.keyAt(v0_1));
                v1.append('=');
                Object v2 = this.valueAt(v0_1);
                if((((LongSparseArray)v2)) != this) {
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

    public Object valueAt(int arg2) {
        if(this.mGarbage) {
            this.gc();
        }

        return this.mValues[arg2];
    }
}

