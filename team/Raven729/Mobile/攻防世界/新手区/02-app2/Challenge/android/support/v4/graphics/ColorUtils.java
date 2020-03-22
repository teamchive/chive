package android.support.v4.graphics;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal TEMP_ARRAY = null;
    private static final double XYZ_EPSILON = 0.008856;
    private static final double XYZ_KAPPA = 903.3;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047;
    private static final double XYZ_WHITE_REFERENCE_Y = 100;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883;

    static {
        ColorUtils.TEMP_ARRAY = new ThreadLocal();
    }

    private ColorUtils() {
        super();
    }

    @ColorInt public static int HSLToColor(@NonNull float[] arg10) {
        int v3_1;
        int v2_1;
        int v0_1;
        int v8 = 0xFF;
        float v7 = 255f;
        float v0 = arg10[0];
        float v2 = arg10[1];
        float v3 = arg10[2];
        float v4 = (1f - Math.abs(2f * v3 - 1f)) * v2;
        float v5 = v3 - 0.5f * v4;
        float v6 = v4 * (1f - Math.abs(v0 / 60f % 2f - 1f));
        switch((((int)v0)) / 60) {
            case 0: {
                v3_1 = Math.round((v4 + v5) * v7);
                v2_1 = Math.round((v6 + v5) * v7);
                v0_1 = Math.round(v7 * v5);
                break;
            }
            case 1: {
                v3_1 = Math.round((v6 + v5) * v7);
                v2_1 = Math.round((v4 + v5) * v7);
                v0_1 = Math.round(v7 * v5);
                break;
            }
            case 2: {
                v3_1 = Math.round(v7 * v5);
                v2_1 = Math.round((v4 + v5) * v7);
                v0_1 = Math.round((v6 + v5) * v7);
                break;
            }
            case 3: {
                v3_1 = Math.round(v7 * v5);
                v2_1 = Math.round((v6 + v5) * v7);
                v0_1 = Math.round((v4 + v5) * v7);
                break;
            }
            case 4: {
                v3_1 = Math.round((v6 + v5) * v7);
                v2_1 = Math.round(v7 * v5);
                v0_1 = Math.round((v4 + v5) * v7);
                break;
            }
            case 5: 
            case 6: {
                v3_1 = Math.round((v4 + v5) * v7);
                v2_1 = Math.round(v7 * v5);
                v0_1 = Math.round((v6 + v5) * v7);
                break;
            }
            default: {
                v0_1 = 0;
                v2_1 = 0;
                v3_1 = 0;
                break;
            }
        }

        return Color.rgb(ColorUtils.constrain(v3_1, 0, v8), ColorUtils.constrain(v2_1, 0, v8), ColorUtils.constrain(v0_1, 0, v8));
    }

    @ColorInt public static int LABToColor(@FloatRange(from=0, to=100) double arg8, @FloatRange(from=-128, to=127) double arg10, @FloatRange(from=-128, to=127) double arg12) {
        double[] v6 = ColorUtils.getTempDouble3Array();
        ColorUtils.LABToXYZ(arg8, arg10, arg12, v6);
        return ColorUtils.XYZToColor(v6[0], v6[1], v6[2]);
    }

    public static void LABToXYZ(@FloatRange(from=0, to=100) double arg10, @FloatRange(from=-128, to=127) double arg12, @FloatRange(from=-128, to=127) double arg14, @NonNull double[] arg16) {
        double v2 = (16 + arg10) / 116;
        double v4 = arg12 / 500 + v2;
        double v6 = v2 - arg14 / 200;
        double v0 = Math.pow(v4, 3);
        v4 = v0 > 0.008856 ? v0 : (116 * v4 - 16) / 903.3;
        v0 = arg10 > 7.999625 ? Math.pow(v2, 3) : arg10 / 903.3;
        v2 = Math.pow(v6, 3);
        if(v2 <= 0.008856) {
            v2 = (116 * v6 - 16) / 903.3;
        }

        arg16[0] = v4 * 95.047;
        arg16[1] = v0 * 100;
        arg16[2] = v2 * 108.883;
    }

    public static void RGBToHSL(@IntRange(from=0, to=0xFF) int arg11, @IntRange(from=0, to=0xFF) int arg12, @IntRange(from=0, to=0xFF) int arg13, @NonNull float[] arg14) {
        float v10 = 360f;
        float v9 = 2f;
        float v8 = 1f;
        float v0 = (((float)arg11)) / 255f;
        float v1 = (((float)arg12)) / 255f;
        float v3 = (((float)arg13)) / 255f;
        float v4 = Math.max(v0, Math.max(v1, v3));
        float v5 = Math.min(v0, Math.min(v1, v3));
        float v6 = v4 - v5;
        float v7 = (v4 + v5) / v9;
        if(v4 == v5) {
            v1 = 0f;
            v0 = 0f;
        }
        else {
            if(v4 == v0) {
                v0 = (v1 - v3) / v6 % 6f;
            }
            else if(v4 == v1) {
                v0 = (v3 - v0) / v6 + v9;
            }
            else {
                v0 = (v0 - v1) / v6 + 4f;
            }

            v1 = v6 / (v8 - Math.abs(v9 * v7 - v8));
        }

        v0 = v0 * 60f % v10;
        if(v0 < 0f) {
            v0 += v10;
        }

        arg14[0] = ColorUtils.constrain(v0, 0f, v10);
        arg14[1] = ColorUtils.constrain(v1, 0f, v8);
        arg14[2] = ColorUtils.constrain(v7, 0f, v8);
    }

    public static void RGBToLAB(@IntRange(from=0, to=0xFF) int arg7, @IntRange(from=0, to=0xFF) int arg8, @IntRange(from=0, to=0xFF) int arg9, @NonNull double[] arg10) {
        ColorUtils.RGBToXYZ(arg7, arg8, arg9, arg10);
        ColorUtils.XYZToLAB(arg10[0], arg10[1], arg10[2], arg10);
    }

    public static void RGBToXYZ(@IntRange(from=0, to=0xFF) int arg16, @IntRange(from=0, to=0xFF) int arg17, @IntRange(from=0, to=0xFF) int arg18, @NonNull double[] arg19) {
        if(arg19.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }

        double v2 = (((double)arg16)) / 255;
        double v6 = v2 < 0.04045 ? v2 / 12.92 : Math.pow((v2 + 0.055) / 1.055, 2.4);
        v2 = (((double)arg17)) / 255;
        double v4 = v2 < 0.04045 ? v2 / 12.92 : Math.pow((v2 + 0.055) / 1.055, 2.4);
        v2 = (((double)arg18)) / 255;
        if(v2 < 0.04045) {
            v2 /= 12.92;
        }
        else {
            v2 = Math.pow((v2 + 0.055) / 1.055, 2.4);
        }

        arg19[0] = 100 * (0.4124 * v6 + 0.3576 * v4 + 0.1805 * v2);
        arg19[1] = 100 * (0.2126 * v6 + 0.7152 * v4 + 0.0722 * v2);
        arg19[2] = (v2 * 0.9505 + (v4 * 0.1192 + v6 * 0.0193)) * 100;
    }

    @ColorInt public static int XYZToColor(@FloatRange(from=0, to=95.047) double arg10, @FloatRange(from=0, to=100) double arg12, @FloatRange(from=0, to=108.883) double arg14) {
        double v0 = (3.2406 * arg10 + -1.5372 * arg12 + -0.4986 * arg14) / 100;
        double v2 = (-0.9689 * arg10 + 1.8758 * arg12 + 0.0415 * arg14) / 100;
        double v6 = (0.0557 * arg10 + -0.204 * arg12 + 1.057 * arg14) / 100;
        double v4 = v0 > 0.003131 ? Math.pow(v0, 0.416667) * 1.055 - 0.055 : v0 * 12.92;
        if(v2 > 0.003131) {
            v2 = 1.055 * Math.pow(v2, 0.416667) - 0.055;
        }
        else {
            v2 *= 12.92;
        }

        v0 = v6 > 0.003131 ? 1.055 * Math.pow(v6, 0.416667) - 0.055 : 12.92 * v6;
        return Color.rgb(ColorUtils.constrain(((int)Math.round(v4 * 255)), 0, 0xFF), ColorUtils.constrain(((int)Math.round(v2 * 255)), 0, 0xFF), ColorUtils.constrain(((int)Math.round(v0 * 255)), 0, 0xFF));
    }

    public static void XYZToLAB(@FloatRange(from=0, to=95.047) double arg16, @FloatRange(from=0, to=100) double arg18, @FloatRange(from=0, to=108.883) double arg20, @NonNull double[] arg22) {
        if(arg22.length != 3) {
            throw new IllegalArgumentException("outLab must have a length of 3.");
        }

        double v2 = ColorUtils.pivotXyzComponent(arg16 / 95.047);
        double v4 = ColorUtils.pivotXyzComponent(arg18 / 100);
        double v6 = ColorUtils.pivotXyzComponent(arg20 / 108.883);
        arg22[0] = Math.max(0, 116 * v4 - 16);
        arg22[1] = (v2 - v4) * 500;
        arg22[2] = (v4 - v6) * 200;
    }

    @ColorInt public static int blendARGB(@ColorInt int arg5, @ColorInt int arg6, @FloatRange(from=0, to=1) float arg7) {
        float v0 = 1f - arg7;
        return Color.argb(((int)((((float)Color.alpha(arg5))) * v0 + (((float)Color.alpha(arg6))) * arg7)), ((int)((((float)Color.red(arg5))) * v0 + (((float)Color.red(arg6))) * arg7)), ((int)((((float)Color.green(arg5))) * v0 + (((float)Color.green(arg6))) * arg7)), ((int)(v0 * (((float)Color.blue(arg5))) + (((float)Color.blue(arg6))) * arg7)));
    }

    public static void blendHSL(@NonNull float[] arg6, @NonNull float[] arg7, @FloatRange(from=0, to=1) float arg8, @NonNull float[] arg9) {
        int v5 = 2;
        if(arg9.length != 3) {
            throw new IllegalArgumentException("result must have a length of 3.");
        }

        float v0 = 1f - arg8;
        arg9[0] = ColorUtils.circularInterpolate(arg6[0], arg7[0], arg8);
        arg9[1] = arg6[1] * v0 + arg7[1] * arg8;
        arg9[v5] = v0 * arg6[v5] + arg7[v5] * arg8;
    }

    public static void blendLAB(@NonNull double[] arg10, @NonNull double[] arg11, @FloatRange(from=0, to=1) double arg12, @NonNull double[] arg14) {
        int v8 = 2;
        if(arg14.length != 3) {
            throw new IllegalArgumentException("outResult must have a length of 3.");
        }

        double v0 = 1 - arg12;
        arg14[0] = arg10[0] * v0 + arg11[0] * arg12;
        arg14[1] = arg10[1] * v0 + arg11[1] * arg12;
        arg14[v8] = v0 * arg10[v8] + arg11[v8] * arg12;
    }

    public static double calculateContrast(@ColorInt int arg6, @ColorInt int arg7) {
        int v1 = 0xFF;
        double v4 = 0.05;
        if(Color.alpha(arg7) != v1) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(arg7));
        }

        if(Color.alpha(arg6) < v1) {
            arg6 = ColorUtils.compositeColors(arg6, arg7);
        }

        double v0 = ColorUtils.calculateLuminance(arg6) + v4;
        double v2 = ColorUtils.calculateLuminance(arg7) + v4;
        return Math.max(v0, v2) / Math.min(v0, v2);
    }

    @FloatRange(from=0, to=1) public static double calculateLuminance(@ColorInt int arg4) {
        double[] v0 = ColorUtils.getTempDouble3Array();
        ColorUtils.colorToXYZ(arg4, v0);
        return v0[1] / 100;
    }

    public static int calculateMinimumAlpha(@ColorInt int arg8, @ColorInt int arg9, float arg10) {
        int v2 = 0;
        int v0 = 0xFF;
        if(Color.alpha(arg9) != v0) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(arg9));
        }

        if(ColorUtils.calculateContrast(ColorUtils.setAlphaComponent(arg8, v0), arg9) < (((double)arg10))) {
            v0 = -1;
        }
        else {
            int v3 = 0;
            while(v3 <= 10) {
                if(v0 - v2 <= 1) {
                    return v0;
                }

                int v1 = (v2 + v0) / 2;
                if(ColorUtils.calculateContrast(ColorUtils.setAlphaComponent(arg8, v1), arg9) >= (((double)arg10))) {
                    v0 = v1;
                    v1 = v2;
                }

                ++v3;
                v2 = v1;
            }
        }

        return v0;
    }

    @VisibleForTesting static float circularInterpolate(float arg3, float arg4, float arg5) {
        float v2 = 360f;
        if(Math.abs(arg4 - arg3) > 180f) {
            if(arg4 > arg3) {
                arg3 += v2;
            }
            else {
                arg4 += v2;
            }
        }

        return ((arg4 - arg3) * arg5 + arg3) % v2;
    }

    public static void colorToHSL(@ColorInt int arg3, @NonNull float[] arg4) {
        ColorUtils.RGBToHSL(Color.red(arg3), Color.green(arg3), Color.blue(arg3), arg4);
    }

    public static void colorToLAB(@ColorInt int arg3, @NonNull double[] arg4) {
        ColorUtils.RGBToLAB(Color.red(arg3), Color.green(arg3), Color.blue(arg3), arg4);
    }

    public static void colorToXYZ(@ColorInt int arg3, @NonNull double[] arg4) {
        ColorUtils.RGBToXYZ(Color.red(arg3), Color.green(arg3), Color.blue(arg3), arg4);
    }

    private static int compositeAlpha(int arg2, int arg3) {
        return 0xFF - (0xFF - arg3) * (0xFF - arg2) / 0xFF;
    }

    public static int compositeColors(@ColorInt int arg7, @ColorInt int arg8) {
        int v0 = Color.alpha(arg8);
        int v1 = Color.alpha(arg7);
        int v2 = ColorUtils.compositeAlpha(v1, v0);
        return Color.argb(v2, ColorUtils.compositeComponent(Color.red(arg7), v1, Color.red(arg8), v0, v2), ColorUtils.compositeComponent(Color.green(arg7), v1, Color.green(arg8), v0, v2), ColorUtils.compositeComponent(Color.blue(arg7), v1, Color.blue(arg8), v0, v2));
    }

    private static int compositeComponent(int arg3, int arg4, int arg5, int arg6, int arg7) {
        int v0 = arg7 == 0 ? 0 : (arg3 * 0xFF * arg4 + arg5 * arg6 * (0xFF - arg4)) / (arg7 * 0xFF);
        return v0;
    }

    private static int constrain(int arg0, int arg1, int arg2) {
        if(arg0 >= arg1) {
            arg1 = arg0 > arg2 ? arg2 : arg0;
        }

        return arg1;
    }

    private static float constrain(float arg1, float arg2, float arg3) {
        if(arg1 >= arg2) {
            arg2 = arg1 > arg3 ? arg3 : arg1;
        }

        return arg2;
    }

    public static double distanceEuclidean(@NonNull double[] arg9, @NonNull double[] arg10) {
        return Math.sqrt(Math.pow(arg9[0] - arg10[0], 2) + Math.pow(arg9[1] - arg10[1], 2) + Math.pow(arg9[2] - arg10[2], 2));
    }

    private static double[] getTempDouble3Array() {
        double[] v0_1;
        Object v0 = ColorUtils.TEMP_ARRAY.get();
        if(v0 == null) {
            v0_1 = new double[3];
            ColorUtils.TEMP_ARRAY.set(v0_1);
        }

        return v0_1;
    }

    private static double pivotXyzComponent(double arg4) {
        double v0 = arg4 > 0.008856 ? Math.pow(arg4, 0.333333) : (903.3 * arg4 + 16) / 116;
        return v0;
    }

    @ColorInt public static int setAlphaComponent(@ColorInt int arg2, @IntRange(from=0, to=0xFF) int arg3) {
        if(arg3 >= 0 && arg3 <= 0xFF) {
            return 0xFFFFFF & arg2 | arg3 << 24;
        }

        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}

