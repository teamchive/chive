package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build$VERSION;
import android.view.Gravity;

public final class GravityCompat {
    interface GravityCompatImpl {
        void apply(int arg1, int arg2, int arg3, Rect arg4, int arg5, int arg6, Rect arg7, int arg8);

        void apply(int arg1, int arg2, int arg3, Rect arg4, Rect arg5, int arg6);

        void applyDisplay(int arg1, Rect arg2, Rect arg3, int arg4);

        int getAbsoluteGravity(int arg1, int arg2);
    }

    class GravityCompatImplBase implements GravityCompatImpl {
        GravityCompatImplBase() {
            super();
        }

        public void apply(int arg1, int arg2, int arg3, Rect arg4, int arg5, int arg6, Rect arg7, int arg8) {
            Gravity.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

        public void apply(int arg1, int arg2, int arg3, Rect arg4, Rect arg5, int arg6) {
            Gravity.apply(arg1, arg2, arg3, arg4, arg5);
        }

        public void applyDisplay(int arg1, Rect arg2, Rect arg3, int arg4) {
            Gravity.applyDisplay(arg1, arg2, arg3);
        }

        public int getAbsoluteGravity(int arg2, int arg3) {
            return 0xFF7FFFFF & arg2;
        }
    }

    class GravityCompatImplJellybeanMr1 implements GravityCompatImpl {
        GravityCompatImplJellybeanMr1() {
            super();
        }

        public void apply(int arg1, int arg2, int arg3, Rect arg4, int arg5, int arg6, Rect arg7, int arg8) {
            GravityCompatJellybeanMr1.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
        }

        public void apply(int arg1, int arg2, int arg3, Rect arg4, Rect arg5, int arg6) {
            GravityCompatJellybeanMr1.apply(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        public void applyDisplay(int arg1, Rect arg2, Rect arg3, int arg4) {
            GravityCompatJellybeanMr1.applyDisplay(arg1, arg2, arg3, arg4);
        }

        public int getAbsoluteGravity(int arg2, int arg3) {
            return GravityCompatJellybeanMr1.getAbsoluteGravity(arg2, arg3);
        }
    }

    public static final int END = 0x800005;
    static final GravityCompatImpl IMPL = null;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 0x800007;
    public static final int RELATIVE_LAYOUT_DIRECTION = 0x800000;
    public static final int START = 0x800003;

    static {
        GravityCompat.IMPL = Build$VERSION.SDK_INT >= 17 ? new GravityCompatImplJellybeanMr1() : new GravityCompatImplBase();
    }

    private GravityCompat() {
        super();
    }

    public static void apply(int arg7, int arg8, int arg9, Rect arg10, Rect arg11, int arg12) {
        GravityCompat.IMPL.apply(arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public static void apply(int arg9, int arg10, int arg11, Rect arg12, int arg13, int arg14, Rect arg15, int arg16) {
        GravityCompat.IMPL.apply(arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
    }

    public static void applyDisplay(int arg1, Rect arg2, Rect arg3, int arg4) {
        GravityCompat.IMPL.applyDisplay(arg1, arg2, arg3, arg4);
    }

    public static int getAbsoluteGravity(int arg1, int arg2) {
        return GravityCompat.IMPL.getAbsoluteGravity(arg1, arg2);
    }
}

