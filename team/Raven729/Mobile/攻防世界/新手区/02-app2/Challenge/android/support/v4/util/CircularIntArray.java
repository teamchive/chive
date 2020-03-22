package android.support.v4.util;

public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    public CircularIntArray() {
        this(8);
    }

    public CircularIntArray(int arg3) {
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
        this.mElements = new int[arg3];
    }

    public void addFirst(int arg3) {
        this.mHead = this.mHead - 1 & this.mCapacityBitmask;
        this.mElements[this.mHead] = arg3;
        if(this.mHead == this.mTail) {
            this.doubleCapacity();
        }
    }

    public void addLast(int arg3) {
        this.mElements[this.mTail] = arg3;
        this.mTail = this.mTail + 1 & this.mCapacityBitmask;
        if(this.mTail == this.mHead) {
            this.doubleCapacity();
        }
    }

    public void clear() {
        this.mTail = this.mHead;
    }

    private void doubleCapacity() {
        int v0 = this.mElements.length;
        int v1 = v0 - this.mHead;
        int v2 = v0 << 1;
        if(v2 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }

        int[] v3 = new int[v2];
        System.arraycopy(this.mElements, this.mHead, v3, 0, v1);
        System.arraycopy(this.mElements, 0, v3, v1, this.mHead);
        this.mElements = v3;
        this.mHead = 0;
        this.mTail = v0;
        this.mCapacityBitmask = v2 - 1;
    }

    public int get(int arg4) {
        if(arg4 >= 0 && arg4 < this.size()) {
            return this.mElements[this.mHead + arg4 & this.mCapacityBitmask];
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public int getFirst() {
        if(this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return this.mElements[this.mHead];
    }

    public int getLast() {
        if(this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return this.mElements[this.mTail - 1 & this.mCapacityBitmask];
    }

    public boolean isEmpty() {
        boolean v0 = this.mHead == this.mTail ? true : false;
        return v0;
    }

    public int popFirst() {
        if(this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int v0 = this.mElements[this.mHead];
        this.mHead = this.mHead + 1 & this.mCapacityBitmask;
        return v0;
    }

    public int popLast() {
        if(this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int v0 = this.mTail - 1 & this.mCapacityBitmask;
        int v1 = this.mElements[v0];
        this.mTail = v0;
        return v1;
    }

    public void removeFromEnd(int arg3) {
        if(arg3 > 0) {
            if(arg3 > this.size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            else {
                this.mTail = this.mTail - arg3 & this.mCapacityBitmask;
            }
        }
    }

    public void removeFromStart(int arg3) {
        if(arg3 > 0) {
            if(arg3 > this.size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            else {
                this.mHead = this.mHead + arg3 & this.mCapacityBitmask;
            }
        }
    }

    public int size() {
        return this.mTail - this.mHead & this.mCapacityBitmask;
    }
}

