package android.support.v4.util;

import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import java.io.PrintWriter;

@RestrictTo(value={Scope.LIBRARY_GROUP}) public final class TimeUtils {
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr;
    private static final Object sFormatSync;

    static {
        TimeUtils.sFormatSync = new Object();
        TimeUtils.sFormatStr = new char[24];
    }

    private TimeUtils() {
        super();
    }

    private static int accumField(int arg1, int arg2, boolean arg3, int arg4) {
        int v0;
        if(arg1 <= 99) {
            if((arg3) && arg4 >= 3) {
                goto label_5;
            }

            if(arg1 <= 9 && (!arg3 || arg4 < 2)) {
                if(!arg3 && arg1 <= 0) {
                    v0 = 0;
                    return v0;
                }

                return arg2 + 1;
            }

            v0 = arg2 + 2;
        }
        else {
        label_5:
            v0 = arg2 + 3;
        }

        return v0;
    }

    public static void formatDuration(long arg2, PrintWriter arg4) {
        TimeUtils.formatDuration(arg2, arg4, 0);
    }

    public static void formatDuration(long arg4, long arg6, PrintWriter arg8) {
        if(arg4 == 0) {
            arg8.print("--");
        }
        else {
            TimeUtils.formatDuration(arg4 - arg6, arg8, 0);
        }
    }

    public static void formatDuration(long arg6, PrintWriter arg8, int arg9) {
        Object v1 = TimeUtils.sFormatSync;
        __monitor_enter(v1);
        try {
            arg8.print(new String(TimeUtils.sFormatStr, 0, TimeUtils.formatDurationLocked(arg6, arg9)));
            __monitor_exit(v1);
            return;
        label_11:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_11;
        }

        throw v0;
    }

    public static void formatDuration(long arg4, StringBuilder arg6) {
        Object v1 = TimeUtils.sFormatSync;
        __monitor_enter(v1);
        try {
            arg6.append(TimeUtils.sFormatStr, 0, TimeUtils.formatDurationLocked(arg4, 0));
            __monitor_exit(v1);
            return;
        label_10:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_10;
        }

        throw v0;
    }

    private static int formatDurationLocked(long arg18, int arg20) {
        int v8;
        int v14;
        int v13;
        int v5;
        int v15;
        int v6;
        char v4_1;
        int v2_1;
        if(TimeUtils.sFormatStr.length < arg20) {
            TimeUtils.sFormatStr = new char[arg20];
        }

        char[] v2 = TimeUtils.sFormatStr;
        if(arg18 == 0) {
            int v4 = arg20 - 1;
            while(0 < v4) {
                v2[0] = ' ';
            }

            v2[0] = '0';
            v2_1 = 1;
        }
        else {
            if(arg18 > 0) {
                v4_1 = '+';
            }
            else {
                arg18 = -arg18;
                v4_1 = '-';
            }

            int v16 = ((int)(arg18 % 1000));
            int v7 = ((int)Math.floor(((double)(arg18 / 1000))));
            int v3 = 0;
            if(v7 > 86400) {
                v3 = v7 / 86400;
                v7 -= 86400 * v3;
            }

            if(v7 > 3600) {
                v6 = v7 / 3600;
                v15 = v6;
                v6 = v7 - v6 * 3600;
            }
            else {
                v15 = 0;
                v6 = v7;
            }

            if(v6 > 60) {
                v5 = v6 / 60;
                v13 = v5;
                v14 = v6 - v5 * 60;
            }
            else {
                v13 = 0;
                v14 = v6;
            }

            if(arg20 != 0) {
                v7 = TimeUtils.accumField(v3, 1, false, 0);
                boolean v5_1 = v7 > 0 ? true : false;
                v7 += TimeUtils.accumField(v15, 1, v5_1, 2);
                v5_1 = v7 > 0 ? true : false;
                v7 += TimeUtils.accumField(v13, 1, v5_1, 2);
                v5_1 = v7 > 0 ? true : false;
                v7 += TimeUtils.accumField(v14, 1, v5_1, 2);
                v8 = 2;
                v5 = v7 > 0 ? 3 : 0;
                int v17 = TimeUtils.accumField(v16, v8, true, v5) + 1 + v7;
                v5 = 0;
                v6 = v17;
                while(v6 < arg20) {
                    v2[v5] = ' ';
                    ++v6;
                    ++v5;
                }
            }
            else {
                v5 = 0;
            }

            v2[v5] = v4_1;
            ++v5;
            int v12 = arg20 != 0 ? 1 : 0;
            int v9 = TimeUtils.printField(v2, v3, 'd', v5, false, 0);
            char v8_1 = 'h';
            boolean v10 = v9 != v5 ? true : false;
            int v11 = v12 != 0 ? 2 : 0;
            v9 = TimeUtils.printField(v2, v15, v8_1, v9, v10, v11);
            v8_1 = 'm';
            v10 = v9 != v5 ? true : false;
            v11 = v12 != 0 ? 2 : 0;
            v9 = TimeUtils.printField(v2, v13, v8_1, v9, v10, v11);
            v8_1 = 's';
            v10 = v9 != v5 ? true : false;
            v11 = v12 != 0 ? 2 : 0;
            v8 = TimeUtils.printField(v2, v14, v8_1, v9, v10, v11);
            v4_1 = 'm';
            v7 = v12 == 0 || v8 == v5 ? 0 : 3;
            v3 = TimeUtils.printField(v2, v16, v4_1, v8, true, v7);
            v2[v3] = 's';
            v2_1 = v3 + 1;
        }

        return v2_1;
    }

    private static int printField(char[] arg4, int arg5, char arg6, int arg7, boolean arg8, int arg9) {
        int v0;
        int v1;
        if((arg8) || arg5 > 0) {
            if((arg8) && arg9 >= 3 || arg5 > 99) {
                v1 = arg5 / 100;
                arg4[arg7] = ((char)(v1 + 0x30));
                v0 = arg7 + 1;
                v1 = arg5 - v1 * 100;
            }
            else {
                v0 = arg7;
                v1 = arg5;
            }

            if((arg8) && arg9 >= 2 || (v1 > 9 || arg7 != v0)) {
                int v2 = v1 / 10;
                arg4[v0] = ((char)(v2 + 0x30));
                ++v0;
                v1 -= v2 * 10;
            }

            arg4[v0] = ((char)(v1 + 0x30));
            ++v0;
            arg4[v0] = arg6;
            arg7 = v0 + 1;
        }

        return arg7;
    }
}

