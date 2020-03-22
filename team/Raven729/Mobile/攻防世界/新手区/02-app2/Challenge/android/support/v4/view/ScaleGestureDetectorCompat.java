package android.support.v4.view;

import android.os.Build$VERSION;

public final class ScaleGestureDetectorCompat {
    class BaseScaleGestureDetectorImpl implements ScaleGestureDetectorImpl {
        BaseScaleGestureDetectorImpl() {
            super();
        }

        public boolean isQuickScaleEnabled(Object arg2) {
            return 0;
        }

        public void setQuickScaleEnabled(Object arg1, boolean arg2) {
        }
    }

    class ScaleGestureDetectorCompatKitKatImpl implements ScaleGestureDetectorImpl {
        ScaleGestureDetectorCompatKitKatImpl() {
            super();
        }

        public boolean isQuickScaleEnabled(Object arg2) {
            return ScaleGestureDetectorCompatKitKat.isQuickScaleEnabled(arg2);
        }

        public void setQuickScaleEnabled(Object arg1, boolean arg2) {
            ScaleGestureDetectorCompatKitKat.setQuickScaleEnabled(arg1, arg2);
        }
    }

    interface ScaleGestureDetectorImpl {
        boolean isQuickScaleEnabled(Object arg1);

        void setQuickScaleEnabled(Object arg1, boolean arg2);
    }

    static final ScaleGestureDetectorImpl IMPL;

    static {
        ScaleGestureDetectorCompat.IMPL = Build$VERSION.SDK_INT >= 19 ? new ScaleGestureDetectorCompatKitKatImpl() : new BaseScaleGestureDetectorImpl();
    }

    private ScaleGestureDetectorCompat() {
        super();
    }

    public static boolean isQuickScaleEnabled(Object arg1) {
        return ScaleGestureDetectorCompat.IMPL.isQuickScaleEnabled(arg1);
    }

    public static void setQuickScaleEnabled(Object arg1, boolean arg2) {
        ScaleGestureDetectorCompat.IMPL.setQuickScaleEnabled(arg1, arg2);
    }
}

