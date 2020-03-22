package android.support.v4.c;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public class b {
    class a {
        int a;
        boolean b;

        a() {
            super();
        }
    }

    public class android.support.v4.c.b$b {
        public char a;
        public float[] b;

        android.support.v4.c.b$b(char arg1, float[] arg2) {
            super();
            this.a = arg1;
            this.b = arg2;
        }

        android.support.v4.c.b$b(android.support.v4.c.b$b arg4) {
            super();
            this.a = arg4.a;
            this.b = b.a(arg4.b, 0, arg4.b.length);
        }

        public void a(android.support.v4.c.b$b arg5, android.support.v4.c.b$b arg6, float arg7) {
            int v0;
            for(v0 = 0; v0 < arg5.b.length; ++v0) {
                this.b[v0] = arg5.b[v0] * (1f - arg7) + arg6.b[v0] * arg7;
            }
        }

        public static void a(android.support.v4.c.b$b[] arg5, Path arg6) {
            float[] v2 = new float[6];
            char v1 = 'm';
            int v0;
            for(v0 = 0; v0 < arg5.length; ++v0) {
                android.support.v4.c.b$b.a(arg6, v2, v1, arg5[v0].a, arg5[v0].b);
                v1 = arg5[v0].a;
            }
        }

        private static void a(Path arg35, double arg36, double arg38, double arg40, double arg42, double arg44, double arg46, double arg48, double arg50, double arg52) {
            int v20 = ((int)Math.ceil(Math.abs(4 * arg52 / 3.141593)));
            double v22 = Math.cos(arg48);
            double v24 = Math.sin(arg48);
            double v2 = Math.cos(arg50);
            double v4 = Math.sin(arg50);
            double v6 = -arg40 * v22 * v4 - arg42 * v24 * v2;
            double v26 = arg52 / (((double)v20));
            int v9 = 0;
            v2 = v4 * (-arg40 * v24) + v2 * (arg42 * v22);
            v4 = v6;
            while(v9 < v20) {
                double v14 = arg50 + v26;
                v6 = Math.sin(v14);
                double v10 = Math.cos(v14);
                double v18 = arg40 * v22 * v10 + arg36 - arg42 * v24 * v6;
                double v16 = arg42 * v22 * v6 + (arg40 * v24 * v10 + arg38);
                double v12 = -arg40 * v22 * v6 - arg42 * v24 * v10;
                v10 = v10 * (arg42 * v22) + v6 * (-arg40 * v24);
                v6 = Math.tan((v14 - arg50) / 2);
                v6 = (Math.sqrt(v6 * (3 * v6) + 4) - 1) * Math.sin(v14 - arg50) / 3;
                arg35.rLineTo(0f, 0f);
                arg35.cubicTo(((float)(v4 * v6 + arg44)), ((float)(arg46 + v2 * v6)), ((float)(v18 - v6 * v12)), ((float)(v16 - v6 * v10)), ((float)v18), ((float)v16));
                ++v9;
                v4 = v12;
                arg50 = v14;
                arg46 = v16;
                arg44 = v18;
                v2 = v10;
            }
        }

        private static void a(Path arg30, float arg31, float arg32, float arg33, float arg34, float arg35, float arg36, float arg37, boolean arg38, boolean arg39) {
            double v16 = Math.toRadians(((double)arg37));
            double v8 = Math.cos(v16);
            double v10 = Math.sin(v16);
            double v6 = ((((double)arg31)) * v8 + (((double)arg32)) * v10) / (((double)arg35));
            double v12 = ((((double)(-arg31))) * v10 + (((double)arg32)) * v8) / (((double)arg36));
            double v14 = ((((double)arg33)) * v8 + (((double)arg34)) * v10) / (((double)arg35));
            double v20 = ((((double)(-arg33))) * v10 + (((double)arg34)) * v8) / (((double)arg36));
            double v2 = v6 - v14;
            double v4 = v12 - v20;
            double v18 = (v6 + v14) / 2;
            double v22 = (v12 + v20) / 2;
            double v24 = v2 * v2 + v4 * v4;
            if(v24 == 0) {
                Log.w("PathParser", " Points are coincident");
            }
            else {
                double v26 = 1 / v24 - 0.25;
                if(v26 < 0) {
                    Log.w("PathParser", "Points are too far apart " + v24);
                    float v2_1 = ((float)(Math.sqrt(v24) / 1.99999));
                    android.support.v4.c.b$b.a(arg30, arg31, arg32, arg33, arg34, arg35 * v2_1, arg36 * v2_1, arg37, arg38, arg39);
                }
                else {
                    v24 = Math.sqrt(v26);
                    v2 *= v24;
                    v4 *= v24;
                    if(arg38 == arg39) {
                        v4 = v18 - v4;
                        v2 += v22;
                    }
                    else {
                        v4 += v18;
                        v2 = v22 - v2;
                    }

                    v18 = Math.atan2(v12 - v2, v6 - v4);
                    v20 = Math.atan2(v20 - v2, v14 - v4) - v18;
                    boolean v6_1 = v20 >= 0 ? true : false;
                    if(arg39 != v6_1) {
                        if(v20 > 0) {
                            v20 -= 6.283185;
                        }
                        else {
                            v20 += 6.283185;
                        }
                    }

                    v6 = (((double)arg35)) * v4;
                    v2 *= ((double)arg36);
                    android.support.v4.c.b$b.a(arg30, v6 * v8 - v2 * v10, v6 * v10 + v2 * v8, ((double)arg35), ((double)arg36), ((double)arg31), ((double)arg32), v16, v18, v20);
                }
            }
        }

        private static void a(Path arg19, float[] arg20, char arg21, char arg22, float[] arg23) {
            float v9_1;
            boolean v12;
            boolean v11;
            float v10;
            int v13;
            int v9 = 2;
            float v8 = arg20[0];
            float v7 = arg20[1];
            float v5 = arg20[2];
            float v3 = arg20[3];
            float v6 = arg20[4];
            float v4 = arg20[5];
            switch(arg22) {
                case 65: 
                case 97: {
                    v13 = 7;
                    break;
                }
                case 67: 
                case 99: {
                    v13 = 6;
                    break;
                }
                case 81: 
                case 83: 
                case 113: 
                case 115: {
                    v13 = 4;
                    break;
                }
                case 76: 
                case 77: 
                case 84: 
                case 108: 
                case 109: 
                case 116: {
                    v13 = 2;
                    break;
                }
                case 72: 
                case 86: 
                case 104: 
                case 118: {
                    v13 = 1;
                    break;
                }
                case 90: 
                case 122: {
                    arg19.close();
                    arg19.moveTo(v6, v4);
                    v3 = v4;
                    v5 = v6;
                    v7 = v4;
                    v8 = v6;
                    v13 = v9;
                    break;
                }
                default: {
                    v13 = v9;
                    break;
                }
            }

            int v14 = 0;
            float v15 = v4;
            float v16 = v6;
            float v17 = v7;
            float v18 = v8;
            while(v14 < arg23.length) {
                switch(arg22) {
                    case 65: {
                        v6 = arg23[v14 + 5];
                        v7 = arg23[v14 + 6];
                        v8 = arg23[v14];
                        v9_1 = arg23[v14 + 1];
                        v10 = arg23[v14 + 2];
                        v11 = arg23[v14 + 3] != 0f ? true : false;
                        v12 = arg23[v14 + 4] != 0f ? true : false;
                        android.support.v4.c.b$b.a(arg19, v18, v17, v6, v7, v8, v9_1, v10, v11, v12);
                        v5 = arg23[v14 + 5];
                        v4 = v15;
                        v6 = v16;
                        v7 = v5;
                        v8 = arg23[v14 + 6];
                        v9_1 = v5;
                        v5 = arg23[v14 + 6];
                        break;
                    }
                    case 67: {
                        arg19.cubicTo(arg23[v14], arg23[v14 + 1], arg23[v14 + 2], arg23[v14 + 3], arg23[v14 + 4], arg23[v14 + 5]);
                        v6 = arg23[v14 + 4];
                        v4 = arg23[v14 + 5];
                        v7 = arg23[v14 + 2];
                        v8 = v4;
                        v9_1 = v6;
                        v4 = v15;
                        v6 = v16;
                        v5 = arg23[v14 + 3];
                        break;
                    }
                    case 72: {
                        arg19.lineTo(arg23[v14], v17);
                        v4 = v15;
                        v7 = v5;
                        v8 = v17;
                        v9_1 = arg23[v14];
                        v5 = v3;
                        v6 = v16;
                        break;
                    }
                    case 76: {
                        arg19.lineTo(arg23[v14], arg23[v14 + 1]);
                        v6 = arg23[v14];
                        v7 = v5;
                        v8 = arg23[v14 + 1];
                        v9_1 = v6;
                        v4 = v15;
                        v6 = v16;
                        v5 = v3;
                        break;
                    }
                    case 77: {
                        v6 = arg23[v14];
                        v4 = arg23[v14 + 1];
                        if(v14 > 0) {
                            arg19.lineTo(arg23[v14], arg23[v14 + 1]);
                            v7 = v5;
                            v8 = v4;
                            v9_1 = v6;
                            v4 = v15;
                            v6 = v16;
                            v5 = v3;
                            goto label_31;
                        }

                        arg19.moveTo(arg23[v14], arg23[v14 + 1]);
                        v7 = v5;
                        v8 = v4;
                        v9_1 = v6;
                        v5 = v3;
                        break;
                    }
                    case 81: {
                        arg19.quadTo(arg23[v14], arg23[v14 + 1], arg23[v14 + 2], arg23[v14 + 3]);
                        v5 = arg23[v14];
                        v3 = arg23[v14 + 1];
                        v6 = arg23[v14 + 2];
                        v7 = v5;
                        v8 = arg23[v14 + 3];
                        v9_1 = v6;
                        v4 = v15;
                        v6 = v16;
                        v5 = v3;
                        break;
                    }
                    case 83: {
                        if(arg21 == 99 || arg21 == 0x73 || arg21 == 67 || arg21 == 83) {
                            v4 = 2f * v18 - v5;
                            v5 = 2f * v17 - v3;
                        }
                        else {
                            v5 = v17;
                            v4 = v18;
                        }

                        arg19.cubicTo(v4, v5, arg23[v14], arg23[v14 + 1], arg23[v14 + 2], arg23[v14 + 3]);
                        v5 = arg23[v14];
                        v3 = arg23[v14 + 1];
                        v6 = arg23[v14 + 2];
                        v7 = v5;
                        v8 = arg23[v14 + 3];
                        v9_1 = v6;
                        v4 = v15;
                        v6 = v16;
                        v5 = v3;
                        break;
                    }
                    case 84: {
                        if(arg21 == 0x71 || arg21 == 0x74 || arg21 == 81 || arg21 == 84) {
                            v18 = 2f * v18 - v5;
                            v17 = 2f * v17 - v3;
                        }

                        arg19.quadTo(v18, v17, arg23[v14], arg23[v14 + 1]);
                        v6 = arg23[v14];
                        v5 = v17;
                        v7 = v18;
                        v8 = arg23[v14 + 1];
                        v9_1 = v6;
                        v4 = v15;
                        v6 = v16;
                        break;
                    }
                    case 86: {
                        arg19.lineTo(v18, arg23[v14]);
                        v6 = v16;
                        v7 = v5;
                        v8 = arg23[v14];
                        v9_1 = v18;
                        v5 = v3;
                        v4 = v15;
                        break;
                    }
                    case 97: {
                        v6 = arg23[v14 + 5] + v18;
                        v7 = arg23[v14 + 6] + v17;
                        v8 = arg23[v14];
                        v9_1 = arg23[v14 + 1];
                        v10 = arg23[v14 + 2];
                        v11 = arg23[v14 + 3] != 0f ? true : false;
                        v12 = arg23[v14 + 4] != 0f ? true : false;
                        android.support.v4.c.b$b.a(arg19, v18, v17, v6, v7, v8, v9_1, v10, v11, v12);
                        v5 = v18 + arg23[v14 + 5];
                        v3 = arg23[v14 + 6] + v17;
                        v4 = v15;
                        v6 = v16;
                        v7 = v5;
                        v8 = v3;
                        v9_1 = v5;
                        v5 = v3;
                        break;
                    }
                    case 99: {
                        arg19.rCubicTo(arg23[v14], arg23[v14 + 1], arg23[v14 + 2], arg23[v14 + 3], arg23[v14 + 4], arg23[v14 + 5]);
                        v5 = v18 + arg23[v14 + 2];
                        v3 = arg23[v14 + 3] + v17;
                        v6 = v18 + arg23[v14 + 4];
                        v7 = v5;
                        v8 = arg23[v14 + 5] + v17;
                        v9_1 = v6;
                        v4 = v15;
                        v6 = v16;
                        v5 = v3;
                        break;
                    }
                    case 104: {
                        arg19.rLineTo(arg23[v14], 0f);
                        v4 = v15;
                        v7 = v5;
                        v8 = v17;
                        v9_1 = v18 + arg23[v14];
                        v5 = v3;
                        v6 = v16;
                        break;
                    }
                    case 108: {
                        arg19.rLineTo(arg23[v14], arg23[v14 + 1]);
                        v6 = v18 + arg23[v14];
                        v7 = v5;
                        v8 = arg23[v14 + 1] + v17;
                        v9_1 = v6;
                        v4 = v15;
                        v6 = v16;
                        v5 = v3;
                        break;
                    }
                    case 109: {
                        v6 = v18 + arg23[v14];
                        v4 = arg23[v14 + 1] + v17;
                        if(v14 > 0) {
                            arg19.rLineTo(arg23[v14], arg23[v14 + 1]);
                            v7 = v5;
                            v8 = v4;
                            v9_1 = v6;
                            v4 = v15;
                            v6 = v16;
                            v5 = v3;
                            goto label_31;
                        }

                        arg19.rMoveTo(arg23[v14], arg23[v14 + 1]);
                        v7 = v5;
                        v8 = v4;
                        v9_1 = v6;
                        v5 = v3;
                        break;
                    }
                    case 113: {
                        arg19.rQuadTo(arg23[v14], arg23[v14 + 1], arg23[v14 + 2], arg23[v14 + 3]);
                        v5 = v18 + arg23[v14];
                        v3 = arg23[v14 + 1] + v17;
                        v6 = v18 + arg23[v14 + 2];
                        v7 = v5;
                        v8 = arg23[v14 + 3] + v17;
                        v9_1 = v6;
                        v4 = v15;
                        v6 = v16;
                        v5 = v3;
                        break;
                    }
                    case 115: {
                        if(arg21 == 99 || arg21 == 0x73 || arg21 == 67 || arg21 == 83) {
                            v4 = v18 - v5;
                            v5 = v17 - v3;
                        }
                        else {
                            v5 = 0f;
                            v4 = 0f;
                        }

                        arg19.rCubicTo(v4, v5, arg23[v14], arg23[v14 + 1], arg23[v14 + 2], arg23[v14 + 3]);
                        v5 = v18 + arg23[v14];
                        v3 = arg23[v14 + 1] + v17;
                        v6 = v18 + arg23[v14 + 2];
                        v7 = v5;
                        v8 = arg23[v14 + 3] + v17;
                        v9_1 = v6;
                        v4 = v15;
                        v6 = v16;
                        v5 = v3;
                        break;
                    }
                    case 116: {
                        if(arg21 == 0x71 || arg21 == 0x74 || arg21 == 81 || arg21 == 84) {
                            v4 = v18 - v5;
                            v3 = v17 - v3;
                        }
                        else {
                            v3 = 0f;
                            v4 = 0f;
                        }

                        arg19.rQuadTo(v4, v3, arg23[v14], arg23[v14 + 1]);
                        v6 = v18 + arg23[v14];
                        v7 = v18 + v4;
                        v8 = arg23[v14 + 1] + v17;
                        v9_1 = v6;
                        v4 = v15;
                        v6 = v16;
                        v5 = v3 + v17;
                        break;
                    }
                    case 118: {
                        arg19.rLineTo(0f, arg23[v14]);
                        v6 = v16;
                        v7 = v5;
                        v8 = arg23[v14] + v17;
                        v9_1 = v18;
                        v5 = v3;
                        v4 = v15;
                        break;
                    }
                    default: {
                        v4 = v15;
                        v6 = v16;
                        v7 = v5;
                        v8 = v17;
                        v9_1 = v18;
                        v5 = v3;
                        break;
                    }
                }

            label_31:
                v14 += v13;
                v15 = v4;
                v16 = v6;
                v17 = v8;
                v18 = v9_1;
                int v21 = arg22;
                v3 = v5;
                v5 = v7;
            }

            arg20[0] = v18;
            arg20[1] = v17;
            arg20[2] = v5;
            arg20[3] = v3;
            arg20[4] = v16;
            arg20[5] = v15;
        }
    }

    public static boolean a(android.support.v4.c.b$b[] arg4, android.support.v4.c.b$b[] arg5) {
        boolean v1 = false;
        if(arg4 != null && arg5 != null && arg4.length == arg5.length) {
            int v0 = 0;
            while(true) {
                if(v0 >= arg4.length) {
                    break;
                }
                else if(arg4[v0].a == arg5[v0].a && arg4[v0].b.length == arg5[v0].b.length) {
                    ++v0;
                    continue;
                }

                return v1;
            }

            v1 = true;
        }

        return v1;
    }

    public static Path a(String arg4) {
        Path v0 = new Path();
        android.support.v4.c.b$b[] v1 = b.b(arg4);
        if(v1 != null) {
            try {
                android.support.v4.c.b$b.a(v1, v0);
            }
            catch(RuntimeException v0_1) {
                throw new RuntimeException("Error in parsing " + arg4, ((Throwable)v0_1));
            }
        }
        else {
            v0 = null;
        }

        return v0;
    }

    public static android.support.v4.c.b$b[] a(android.support.v4.c.b$b[] arg4) {
        android.support.v4.c.b$b[] v0;
        if(arg4 == null) {
            v0 = null;
        }
        else {
            android.support.v4.c.b$b[] v1 = new android.support.v4.c.b$b[arg4.length];
            int v0_1;
            for(v0_1 = 0; v0_1 < arg4.length; ++v0_1) {
                v1[v0_1] = new android.support.v4.c.b$b(arg4[v0_1]);
            }

            v0 = v1;
        }

        return v0;
    }

    private static int a(String arg3, int arg4) {
        while(arg4 < arg3.length()) {
            int v0 = arg3.charAt(arg4);
            if(((v0 - 65) * (v0 - 90) <= 0 || (v0 - 97) * (v0 - 0x7A) <= 0) && v0 != 101 && v0 != 69) {
                return arg4;
            }

            ++arg4;
        }

        return arg4;
    }

    private static void a(String arg7, int arg8, a arg9) {
        arg9.b = false;
        int v0 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4;
        for(v4 = arg8; v4 < arg7.length(); ++v4) {
            switch(arg7.charAt(v4)) {
                case 32: 
                case 44: {
                    v0 = 0;
                    v3 = 1;
                    break;
                }
                case 45: {
                    if(v4 == arg8) {
                        goto label_11;
                    }
                    else if(v0 == 0) {
                        arg9.b = true;
                        v0 = 0;
                        v3 = 1;
                        goto label_12;
                    }
                    else {
                        goto label_11;
                    }
                }
                case 46: {
                    if(v2 == 0) {
                        v0 = 0;
                        v2 = 1;
                    }
                    else {
                        arg9.b = true;
                        v0 = 0;
                        v3 = 1;
                    }

                    break;
                }
                case 69: 
                case 101: {
                    v0 = 1;
                    break;
                }
                default: {
                label_11:
                    v0 = 0;
                    break;
                }
            }

        label_12:
            if(v3 != 0) {
                break;
            }
        }

        arg9.a = v4;
    }

    private static void a(ArrayList arg1, char arg2, float[] arg3) {
        arg1.add(new android.support.v4.c.b$b(arg2, arg3));
    }

    static float[] a(float[] arg3, int arg4, int arg5) {
        if(arg4 > arg5) {
            throw new IllegalArgumentException();
        }

        int v0 = arg3.length;
        if(arg4 >= 0 && arg4 <= v0) {
            int v1 = arg5 - arg4;
            v0 = Math.min(v1, v0 - arg4);
            float[] v1_1 = new float[v1];
            System.arraycopy(arg3, arg4, v1_1, 0, v0);
            return v1_1;
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public static android.support.v4.c.b$b[] b(String arg6) {
        Object[] v0_3;
        if(arg6 == null) {
            android.support.v4.c.b$b[] v0 = null;
        }
        else {
            ArrayList v5 = new ArrayList();
            int v0_1 = 1;
            int v2;
            for(v2 = 0; v0_1 < arg6.length(); v2 = v4) {
                int v4 = b.a(arg6, v0_1);
                String v0_2 = arg6.substring(v2, v4).trim();
                if(v0_2.length() > 0) {
                    b.a(v5, v0_2.charAt(0), b.c(v0_2));
                }

                v0_1 = v4 + 1;
            }

            if(v0_1 - v2 == 1 && v2 < arg6.length()) {
                b.a(v5, arg6.charAt(v2), new float[0]);
            }

            v0_3 = v5.toArray(new android.support.v4.c.b$b[v5.size()]);
        }

        return ((android.support.v4.c.b$b[])v0_3);
    }

    public static void b(android.support.v4.c.b$b[] arg5, android.support.v4.c.b$b[] arg6) {
        int v0;
        for(v0 = 0; v0 < arg6.length; ++v0) {
            arg5[v0].a = arg6[v0].a;
            int v2;
            for(v2 = 0; v2 < arg6[v0].b.length; ++v2) {
                arg5[v0].b[v2] = arg6[v0].b[v2];
            }
        }
    }

    private static float[] c(String arg7) {
        float[] v0_2;
        int v0_1;
        int v3;
        int v2;
        float[] v4;
        int v1 = 0;
        if(arg7.charAt(0) == 0x7A || arg7.charAt(0) == 90) {
            v0_2 = new float[0];
        }
        else {
            try {
                v4 = new float[arg7.length()];
                a v5 = new a();
                int v6 = arg7.length();
                v2 = 1;
                while(true) {
                label_16:
                    if(v2 < v6) {
                        b.a(arg7, v2, v5);
                        v3 = v5.a;
                        if(v2 < v3) {
                            v0_1 = v1 + 1;
                            v4[v1] = Float.parseFloat(arg7.substring(v2, v3));
                        }
                        else {
                            break;
                        }

                        goto label_24;
                    }
                    else {
                        goto label_33;
                    }
                }
            }
            catch(NumberFormatException v0) {
                goto label_47;
            }

            v0_1 = v1;
            try {
            label_24:
                if(v5.b) {
                    v2 = v3;
                    v1 = v0_1;
                    goto label_16;
                }

                v2 = v3 + 1;
                v1 = v0_1;
                goto label_16;
            label_33:
                v0_2 = b.a(v4, 0, v1);
            }
            catch(NumberFormatException v0) {
            label_47:
                throw new RuntimeException("error in parsing \"" + arg7 + "\"", ((Throwable)v0));
            }
        }

        return v0_2;
    }
}

