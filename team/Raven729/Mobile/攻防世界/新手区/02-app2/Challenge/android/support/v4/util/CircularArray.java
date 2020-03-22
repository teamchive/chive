package android.support.v4.util;

public final class CircularArray {
    private int mCapacityBitmask;
    private Object[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    public CircularArray(int arg3) {
        super();
        if(arg3 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }

        if(arg3 > 0x40000000) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }

        if(Integer.bitCount(arg3) != 1) {
            arg3 = Integer.highestOneBit(arg3 - 1) << 1;
        }

        this.mCapacityBitmask = arg3 - 1;
        this.mElements = new Object[arg3];
    }

    public void addFirst(Object arg3) {
        this.mHead = this.mHead - 1 & this.mCapacityBitmask;
        this.mElements[this.mHead] = arg3;
        if(this.mHead == this.mTail) {
            this.doubleCapacity();
        }
    }

    public void addLast(Object arg3) {
        this.mElements[this.mTail] = arg3;
        this.mTail = this.mTail + 1 & this.mCapacityBitmask;
        if(this.mTail == this.mHead) {
            this.doubleCapacity();
        }
    }

    public void clear() {
        this.removeFromStart(this.size());
    }

    private void doubleCapacity() {
        int v1 = this.mElements.length;
        int v2 = v1 - this.mHead;
        int v3 = v1 << 1;
        if(v3 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }

        Object[] v0 = new Object[v3];
        System.arraycopy(this.mElements, this.mHead, v0, 0, v2);
        System.arraycopy(this.mElements, 0, v0, v2, this.mHead);
        this.mElements = v0;
        this.mHead = 0;
        this.mTail = v1;
        this.mCapacityBitmask = v3 - 1;
    }

    public Object get(int arg4) {
        if(arg4 >= 0 && arg4 < this.size()) {
            return this.mElements[this.mHead + arg4 & this.mCapacityBitmask];
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public Object getFirst() {
        if(this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return this.mElements[this.mHead];
    }

    public Object getLast() {
        if(this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return this.mElements[this.mTail - 1 & this.mCapacityBitmask];
    }

    public boolean isEmpty() {
        boolean v0 = this.mHead == this.mTail ? true : false;
        return v0;
    }

    public Object popFirst() {
        if(this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Object v0 = this.mElements[this.mHead];
        this.mElements[this.mHead] = null;
        this.mHead = this.mHead + 1 & this.mCapacityBitmask;
        return v0;
    }

    public Object popLast() {
        if(this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int v0 = this.mTail - 1 & this.mCapacityBitmask;
        Object v1 = this.mElements[v0];
        this.mElements[v0] = null;
        this.mTail = v0;
        return v1;
    }

    public void removeFromEnd(int arg5) {
        Object v3 = null;
        if(arg5 > 0) {
            if(arg5 > this.size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            else {
                int v0 = 0;
                if(arg5 < this.mTail) {
                    v0 = this.mTail - arg5;
                }

                int v1;
                for(v1 = v0; v1 < this.mTail; ++v1) {
                    this.mElements[v1] = v3;
                }

                v0 = this.mTail - v0;
                v1 = arg5 - v0;
                this.mTail -= v0;
                if(v1 <= 0) {
                    return;
                }

                this.mTail = this.mElements.length;
                v1 = this.mTail - v1;
                for(v0 = v1; v0 < this.mTail; ++v0) {
                    this.mElements[v0] = v3;
                }

                this.mTail = v1;
            }
        }
    }

    public void removeFromStart(int arg5) {
        Object v3 = null;
        if(arg5 > 0) {
            if(arg5 > this.size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            else {
                int v0 = this.mElements.length;
                if(arg5 < v0 - this.mHead) {
                    v0 = this.mHead + arg5;
                }

                int v1;
                for(v1 = this.mHead; v1 < v0; ++v1) {
                    this.mElements[v1] = v3;
                }

                v0 -= this.mHead;
                v1 = arg5 - v0;
                this.mHead = v0 + this.mHead & this.mCapacityBitmask;
                if(v1 <= 0) {
                    return;
                }

                for(v0 = 0; v0 < v1; ++v0) {
                    this.mElements[v0] = v3;
                }

                this.mHead = v1;
            }
        }
    }

    public int size() {
        return this.mTail - this.mHead & this.mCapacityBitmask;
    }
}

