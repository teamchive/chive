package com.a.easyjava;

import java.util.ArrayList;

public class a {
    public static ArrayList a;
    static String b;
    Integer[] c;
    static Integer d;

    static {
        a.a = new ArrayList();
        a.b = "abcdefghijklmnopqrstuvwxyz";
        a.d = Integer.valueOf(0);
    }

    public a(Integer arg8) {
        super();
        this.c = new Integer[]{Integer.valueOf(7), Integer.valueOf(14), Integer.valueOf(16), Integer.valueOf(21), Integer.valueOf(4), Integer.valueOf(24), Integer.valueOf(25), Integer.valueOf(20), Integer.valueOf(5), Integer.valueOf(15), Integer.valueOf(9), Integer.valueOf(17), Integer.valueOf(6), Integer.valueOf(13), Integer.valueOf(3), Integer.valueOf(18), Integer.valueOf(12), Integer.valueOf(10), Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(22), Integer.valueOf(2), Integer.valueOf(11), Integer.valueOf(23), Integer.valueOf(1), Integer.valueOf(8)};
        int v0;
        for(v0 = arg8.intValue(); v0 < this.c.length; ++v0) {
            a.a.add(this.c[v0]);
        }

        for(v0 = 0; v0 < arg8.intValue(); ++v0) {
            a.a.add(this.c[v0]);
        }
    }

    public static void a() {
        a.d = Integer.valueOf(a.d.intValue() + 1);
        if(a.d.intValue() == 25) {
            int v0 = a.a.get(0).intValue();
            a.a.remove(0);
            a.a.add(Integer.valueOf(v0));
            a.d = Integer.valueOf(0);
        }
    }

    public char a(Integer arg5) {
        char v0_1;
        int v0 = 0;
        Integer v1 = Integer.valueOf(0);
        if(arg5.intValue() == -10) {
            a.a();
            v0_1 = " ".charAt(0);
        }
        else {
            while(v0 < a.a.size() - 1) {
                if(a.a.get(v0) == arg5) {
                    v1 = Integer.valueOf(v0);
                }

                ++v0;
            }

            a.a();
            v0_1 = a.b.charAt(v1.intValue());
        }

        return v0_1;
    }
}

