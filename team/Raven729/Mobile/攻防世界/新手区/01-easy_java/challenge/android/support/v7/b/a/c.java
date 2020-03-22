package android.support.v7.b.a;

import java.lang.reflect.Array;

final class c {
    static {
        boolean v0 = !c.class.desiredAssertionStatus() ? true : false;
        c.a = v0;
    }

    private c() {
        super();
    }

    public static int[] a(int[] arg3, int arg4, int arg5) {
        if(!c.a && arg4 > arg3.length) {
            throw new AssertionError();
        }

        if(arg4 + 1 > arg3.length) {
            int[] v0 = new int[c.a(arg4)];
            System.arraycopy(arg3, 0, v0, 0, arg4);
            arg3 = v0;
        }

        arg3[arg4] = arg5;
        return arg3;
    }

    public static Object[] a(Object[] arg3, int arg4, Object arg5) {
        Object[] v0_1;
        if(!c.a && arg4 > arg3.length) {
            throw new AssertionError();
        }

        if(arg4 + 1 > arg3.length) {
            Object v0 = Array.newInstance(arg3.getClass().getComponentType(), c.a(arg4));
            System.arraycopy(arg3, 0, v0, 0, arg4);
        }
        else {
            v0_1 = arg3;
        }

        v0_1[arg4] = arg5;
        return v0_1;
    }

    public static int a(int arg1) {
        int v0 = arg1 <= 4 ? 8 : arg1 * 2;
        return v0;
    }
}

