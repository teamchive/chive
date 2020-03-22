package android.support.v4.view;

import android.os.Build$VERSION;
import android.view.VelocityTracker;

public final class VelocityTrackerCompat {
    class BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        BaseVelocityTrackerVersionImpl() {
            super();
        }

        public float getXVelocity(VelocityTracker arg2, int arg3) {
            return arg2.getXVelocity();
        }

        public float getYVelocity(VelocityTracker arg2, int arg3) {
            return arg2.getYVelocity();
        }
    }

    class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        HoneycombVelocityTrackerVersionImpl() {
            super();
        }

        public float getXVelocity(VelocityTracker arg2, int arg3) {
            return VelocityTrackerCompatHoneycomb.getXVelocity(arg2, arg3);
        }

        public float getYVelocity(VelocityTracker arg2, int arg3) {
            return VelocityTrackerCompatHoneycomb.getYVelocity(arg2, arg3);
        }
    }

    interface VelocityTrackerVersionImpl {
        float getXVelocity(VelocityTracker arg1, int arg2);

        float getYVelocity(VelocityTracker arg1, int arg2);
    }

    static final VelocityTrackerVersionImpl IMPL;

    static {
        VelocityTrackerCompat.IMPL = Build$VERSION.SDK_INT >= 11 ? new HoneycombVelocityTrackerVersionImpl() : new BaseVelocityTrackerVersionImpl();
    }

    private VelocityTrackerCompat() {
        super();
    }

    public static float getXVelocity(VelocityTracker arg1, int arg2) {
        return VelocityTrackerCompat.IMPL.getXVelocity(arg1, arg2);
    }

    public static float getYVelocity(VelocityTracker arg1, int arg2) {
        return VelocityTrackerCompat.IMPL.getYVelocity(arg1, arg2);
    }
}

