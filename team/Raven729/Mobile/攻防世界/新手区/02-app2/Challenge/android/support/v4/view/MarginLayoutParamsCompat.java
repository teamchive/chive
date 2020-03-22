package android.support.v4.view;

import android.os.Build$VERSION;
import android.view.ViewGroup$MarginLayoutParams;

public final class MarginLayoutParamsCompat {
    interface MarginLayoutParamsCompatImpl {
        int getLayoutDirection(ViewGroup$MarginLayoutParams arg1);

        int getMarginEnd(ViewGroup$MarginLayoutParams arg1);

        int getMarginStart(ViewGroup$MarginLayoutParams arg1);

        boolean isMarginRelative(ViewGroup$MarginLayoutParams arg1);

        void resolveLayoutDirection(ViewGroup$MarginLayoutParams arg1, int arg2);

        void setLayoutDirection(ViewGroup$MarginLayoutParams arg1, int arg2);

        void setMarginEnd(ViewGroup$MarginLayoutParams arg1, int arg2);

        void setMarginStart(ViewGroup$MarginLayoutParams arg1, int arg2);
    }

    class MarginLayoutParamsCompatImplBase implements MarginLayoutParamsCompatImpl {
        MarginLayoutParamsCompatImplBase() {
            super();
        }

        public int getLayoutDirection(ViewGroup$MarginLayoutParams arg2) {
            return 0;
        }

        public int getMarginEnd(ViewGroup$MarginLayoutParams arg2) {
            return arg2.rightMargin;
        }

        public int getMarginStart(ViewGroup$MarginLayoutParams arg2) {
            return arg2.leftMargin;
        }

        public boolean isMarginRelative(ViewGroup$MarginLayoutParams arg2) {
            return 0;
        }

        public void resolveLayoutDirection(ViewGroup$MarginLayoutParams arg1, int arg2) {
        }

        public void setLayoutDirection(ViewGroup$MarginLayoutParams arg1, int arg2) {
        }

        public void setMarginEnd(ViewGroup$MarginLayoutParams arg1, int arg2) {
            arg1.rightMargin = arg2;
        }

        public void setMarginStart(ViewGroup$MarginLayoutParams arg1, int arg2) {
            arg1.leftMargin = arg2;
        }
    }

    class MarginLayoutParamsCompatImplJbMr1 implements MarginLayoutParamsCompatImpl {
        MarginLayoutParamsCompatImplJbMr1() {
            super();
        }

        public int getLayoutDirection(ViewGroup$MarginLayoutParams arg2) {
            return MarginLayoutParamsCompatJellybeanMr1.getLayoutDirection(arg2);
        }

        public int getMarginEnd(ViewGroup$MarginLayoutParams arg2) {
            return MarginLayoutParamsCompatJellybeanMr1.getMarginEnd(arg2);
        }

        public int getMarginStart(ViewGroup$MarginLayoutParams arg2) {
            return MarginLayoutParamsCompatJellybeanMr1.getMarginStart(arg2);
        }

        public boolean isMarginRelative(ViewGroup$MarginLayoutParams arg2) {
            return MarginLayoutParamsCompatJellybeanMr1.isMarginRelative(arg2);
        }

        public void resolveLayoutDirection(ViewGroup$MarginLayoutParams arg1, int arg2) {
            MarginLayoutParamsCompatJellybeanMr1.resolveLayoutDirection(arg1, arg2);
        }

        public void setLayoutDirection(ViewGroup$MarginLayoutParams arg1, int arg2) {
            MarginLayoutParamsCompatJellybeanMr1.setLayoutDirection(arg1, arg2);
        }

        public void setMarginEnd(ViewGroup$MarginLayoutParams arg1, int arg2) {
            MarginLayoutParamsCompatJellybeanMr1.setMarginEnd(arg1, arg2);
        }

        public void setMarginStart(ViewGroup$MarginLayoutParams arg1, int arg2) {
            MarginLayoutParamsCompatJellybeanMr1.setMarginStart(arg1, arg2);
        }
    }

    static final MarginLayoutParamsCompatImpl IMPL;

    static {
        MarginLayoutParamsCompat.IMPL = Build$VERSION.SDK_INT >= 17 ? new MarginLayoutParamsCompatImplJbMr1() : new MarginLayoutParamsCompatImplBase();
    }

    private MarginLayoutParamsCompat() {
        super();
    }

    public static int getLayoutDirection(ViewGroup$MarginLayoutParams arg2) {
        int v0 = MarginLayoutParamsCompat.IMPL.getLayoutDirection(arg2);
        if(v0 != 0 && v0 != 1) {
            v0 = 0;
        }

        return v0;
    }

    public static int getMarginEnd(ViewGroup$MarginLayoutParams arg1) {
        return MarginLayoutParamsCompat.IMPL.getMarginEnd(arg1);
    }

    public static int getMarginStart(ViewGroup$MarginLayoutParams arg1) {
        return MarginLayoutParamsCompat.IMPL.getMarginStart(arg1);
    }

    public static boolean isMarginRelative(ViewGroup$MarginLayoutParams arg1) {
        return MarginLayoutParamsCompat.IMPL.isMarginRelative(arg1);
    }

    public static void resolveLayoutDirection(ViewGroup$MarginLayoutParams arg1, int arg2) {
        MarginLayoutParamsCompat.IMPL.resolveLayoutDirection(arg1, arg2);
    }

    public static void setLayoutDirection(ViewGroup$MarginLayoutParams arg1, int arg2) {
        MarginLayoutParamsCompat.IMPL.setLayoutDirection(arg1, arg2);
    }

    public static void setMarginEnd(ViewGroup$MarginLayoutParams arg1, int arg2) {
        MarginLayoutParamsCompat.IMPL.setMarginEnd(arg1, arg2);
    }

    public static void setMarginStart(ViewGroup$MarginLayoutParams arg1, int arg2) {
        MarginLayoutParamsCompat.IMPL.setMarginStart(arg1, arg2);
    }
}

