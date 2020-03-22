package android.support.v4.util;

public class SparseArrayCompat implements Cloneable {
    private static final Object DELETED;
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    static {
        SparseArrayCompat.DELETED = new Object();
    }

    public SparseArrayCompat(int arg4) {
        super();
        this.mGarbage = false;
        if(arg4 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_INTS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        }
        else {
            int v0 = ContainerHelpers.idealIntArraySize(arg4);
            this.mKeys = new int[v0];
            this.mValues = new Object[v0];
        }

        this.mSize = 0;
    }

    public SparseArrayCompat() {
        this(10);
    }

    public void append(int arg7, Object arg8) {
        if(this.mSize == 0 || arg7 > this.mKeys[this.mSize - 1]) {
            if((this.mGarbage) && this.mSize >= this.mKeys.length) {
                this.gc();
            }

            int v0 = this.mSize;
            if(v0 >= this.mKeys.length) {
                int v1 = ContainerHelpers.idealIntArraySize(v0 + 1);
                int[] v2 = new int[v1];
                Object[] v1_1 = new Object[v1];
                System.arraycopy(this.mKeys, 0, v2, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, v1_1, 0, this.mValues.length);
                this.mKeys = v2;
                this.mValues = v1_1;
            }

            this.mKeys[v0] = arg7;
            this.mValues[v0] = arg8;
            this.mSize = v0 + 1;
        }
        else {
            this.put(arg7, arg8);
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

    public SparseArrayCompat clone() {
        Object v0_1;
        int[] v1 = null;
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
            int[] v0_2 = v1;
            goto label_8;
            try {
            label_3:
                ((SparseArrayCompat)v0_1).mKeys = v1.clone();
                ((SparseArrayCompat)v0_1).mValues = this.mValues.clone();
            }
            catch(CloneNotSupportedException v1_1) {
            }
        }

    label_8:
        return ((SparseArrayCompat)v0_1);
    }

    public Object clone() {
        return this.clone();
    }

    public void delete(int arg4) {
        int v0 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, arg4);
        if(v0 >= 0 && this.mValues[v0] != SparseArrayCompat.DELETED) {
            this.mValues[v0] = SparseArrayCompat.DELETED;
            this.mGarbage = true;
        }
    }

    private void gc() {
        int v3 = this.mSize;
        int[] v4 = this.mKeys;
        Object[] v5 = this.mValues;
        int v1 = 0;
        int v0 = 0;
        while(v1 < v3) {
            Object v6 = v5[v1];
            if(v6 != SparseArrayCompat.DELETED) {
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

    public Object get(int arg2) {
        return this.get(arg2, null);
    }

    public Object get(int arg4, Object arg5) {
        int v0 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, arg4);
        if(v0 >= 0 && this.mValues[v0] != SparseArrayCompat.DELETED) {
            arg5 = this.mValues[v0];
        }

        return arg5;
    }

    public int indexOfKey(int arg3) {
        if(this.mGarbage) {
            this.gc();
        }

        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, arg3);
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

    public int keyAt(int arg2) {
        if(this.mGarbage) {
            this.gc();
        }

        return this.mKeys[arg2];
    }

    public void put(int arg7, Object arg8) {
        int v0 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, arg7);
        if(v0 >= 0) {
            this.mValues[v0] = arg8;
        }
        else {
            v0 ^= -1;
            if(v0 < this.mSize && this.mValues[v0] == SparseArrayCompat.DELETED) {
                this.mKeys[v0] = arg7;
                this.mValues[v0] = arg8;
                return;
            }

            if((this.mGarbage) && this.mSize >= this.mKeys.length) {
                this.gc();
                v0 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, arg7) ^ -1;
            }

            if(this.mSize >= this.mKeys.length) {
                int v1 = ContainerHelpers.idealIntArraySize(this.mSize + 1);
                int[] v2 = new int[v1];
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

            this.mKeys[v0] = arg7;
            this.mValues[v0] = arg8;
            ++this.mSize;
        }
    }

    public void remove(int arg1) {
        this.delete(arg1);
    }

    public void removeAt(int arg3) {
        if(this.mValues[arg3] != SparseArrayCompat.DELETED) {
            this.mValues[arg3] = SparseArrayCompat.DELETED;
            this.mGarbage = true;
        }
    }

    public void removeAtRange(int arg3, int arg4) {
        int v0 = Math.min(this.mSize, arg3 + arg4);
        while(arg3 < v0) {
            this.removeAt(arg3);
            ++arg3;
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
                if((((SparseArrayCompat)v2)) != this) {
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

