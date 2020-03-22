package com.a.easyjava;

import java.util.ArrayList;

public class b {
    public static ArrayList a;
    static String b;
    Integer[] c;
    static Integer d;

    static {
        b.a = new ArrayList();
        b.b = "abcdefghijklmnopqrstuvwxyz";
        b.d = Integer.valueOf(0);
    }

    public b(Integer arg9) {
        super();
        this.c = new Integer[]{Integer.valueOf(8), Integer.valueOf(25), Integer.valueOf(17), Integer.valueOf(23), Integer.valueOf(7), Integer.valueOf(22), Integer.valueOf(1), Integer.valueOf(16), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(21), Integer.valueOf(0), Integer.valueOf(15), Integer.valueOf(5), Integer.valueOf(10), Integer.valueOf(18), Integer.valueOf(2), Integer.valueOf(24), Integer.valueOf(4), Integer.valueOf(11), Integer.valueOf(3), Integer.valueOf(14), Integer.valueOf(19), Integer.valueOf(12), Integer.valueOf(20), Integer.valueOf(13)};
        int v0;
        for(v0 = arg9.intValue(); v0 < this.c.length; ++v0) {
            b.a.add(this.c[v0]);
        }

        for(v0 = 0; v0 < arg9.intValue(); ++v0) {
            b.a.add(this.c[v0]);
        }
    }

    public static void a() {
        int v0 = b.a.get(0).intValue();
        b.a.remove(0);
        b.a.add(Integer.valueOf(v0));
        b.b = b.b + "" + b.b.charAt(0);
        b.b = b.b.substring(1, 27);
        b.d = Integer.valueOf(b.d.intValue() + 1);
    }

    public Integer a(String arg5) {
        int v0 = 0;
        Integer v1 = Integer.valueOf(0);
        if(b.b.contains(arg5.toLowerCase())) {
            Integer v2 = Integer.valueOf(b.b.indexOf(arg5));
            while(v0 < b.a.size() - 1) {
                if(b.a.get(v0) == v2) {
                    v1 = Integer.valueOf(v0);
                }

                ++v0;
            }
        }
        else {
            if(arg5.contains(" ")) {
                v1 = Integer.valueOf(-10);
                goto label_24;
            }

            v1 = Integer.valueOf(-1);
        }

    label_24:
        b.a();
        return v1;
    }

    public Integer b() {
        return b.d;
    }
}

