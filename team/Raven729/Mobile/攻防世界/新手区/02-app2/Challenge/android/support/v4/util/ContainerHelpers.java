package android.support.v4.util;

class ContainerHelpers {
    static final int[] EMPTY_INTS;
    static final long[] EMPTY_LONGS;
    static final Object[] EMPTY_OBJECTS;

    static {
        ContainerHelpers.EMPTY_INTS = new int[0];
        ContainerHelpers.EMPTY_LONGS = new long[0];
        ContainerHelpers.EMPTY_OBJECTS = new Object[0];
    }

    ContainerHelpers() {
        super();
    }

    static int binarySearch(int[] arg4, int arg5, int arg6) {
        int v2;
        int v1 = 0;
        int v0 = arg5 - 1;
        while(true) {
            if(v1 <= v0) {
                v2 = v1 + v0 >>> 1;
                int v3 = arg4[v2];
                if(v3 < arg6) {
                    v1 = v2 + 1;
                    continue;
                }
                else if(v3 > arg6) {
                    v0 = v2 - 1;
                    continue;
                }
                else {
                    return v2;
                }
            }
            else {
                goto label_14;
            }

            return v0;
        }

        return v2;
    label_14:
        return v1 ^ -1;
    }

    static int binarySearch(long[] arg6, int arg7, long arg8) {
        int v2;
        int v1 = 0;
        int v0 = arg7 - 1;
        while(true) {
            if(v1 <= v0) {
                v2 = v1 + v0 >>> 1;
                long v4 = arg6[v2];
                if(v4 < arg8) {
                    v1 = v2 + 1;
                    continue;
                }
                else if(v4 > arg8) {
                    v0 = v2 - 1;
                    continue;
                }
                else {
                    return v2;
                }
            }
            else {
                goto label_14;
            }

            return v0;
        }

        return v2;
    label_14:
        return v1 ^ -1;
    }

    public static boolean equal(Object arg1, Object arg2) {
        boolean v0;
        if(arg1 != arg2) {
            if(arg1 != null && (arg1.equals(arg2))) {
                goto label_4;
            }

            v0 = false;
        }
        else {
        label_4:
            v0 = true;
        }

        return v0;
    }

    public static int idealByteArraySize(int arg3) {
        int v0 = 4;
        while(v0 < 0x20) {
            if(arg3 <= (1 << v0) - 12) {
                arg3 = (1 << v0) - 12;
            }
            else {
                ++v0;
                continue;
            }

            return arg3;
        }

        return arg3;
    }

    public static int idealIntArraySize(int arg1) {
        return ContainerHelpers.idealByteArraySize(arg1 * 4) / 4;
    }

    public static int idealLongArraySize(int arg1) {
        return ContainerHelpers.idealByteArraySize(arg1 * 8) / 8;
    }
}

