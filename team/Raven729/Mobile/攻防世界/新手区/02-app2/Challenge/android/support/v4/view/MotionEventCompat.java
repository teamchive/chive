package android.support.v4.view;

import android.os.Build$VERSION;
import android.view.MotionEvent;

public final class MotionEventCompat {
    class BaseMotionEventVersionImpl implements MotionEventVersionImpl {
        BaseMotionEventVersionImpl() {
            super();
        }

        public float getAxisValue(MotionEvent arg2, int arg3) {
            return 0;
        }

        public float getAxisValue(MotionEvent arg2, int arg3, int arg4) {
            return 0;
        }

        public int getButtonState(MotionEvent arg2) {
            return 0;
        }
    }

    class HoneycombMr1MotionEventVersionImpl extends BaseMotionEventVersionImpl {
        HoneycombMr1MotionEventVersionImpl() {
            super();
        }

        public float getAxisValue(MotionEvent arg2, int arg3) {
            return MotionEventCompatHoneycombMr1.getAxisValue(arg2, arg3);
        }

        public float getAxisValue(MotionEvent arg2, int arg3, int arg4) {
            return MotionEventCompatHoneycombMr1.getAxisValue(arg2, arg3, arg4);
        }
    }

    class ICSMotionEventVersionImpl extends HoneycombMr1MotionEventVersionImpl {
        ICSMotionEventVersionImpl() {
            super();
        }

        public int getButtonState(MotionEvent arg2) {
            return MotionEventCompatICS.getButtonState(arg2);
        }
    }

    interface MotionEventVersionImpl {
        float getAxisValue(MotionEvent arg1, int arg2);

        float getAxisValue(MotionEvent arg1, int arg2, int arg3);

        int getButtonState(MotionEvent arg1);
    }

    public static final int ACTION_HOVER_ENTER = 9;
    public static final int ACTION_HOVER_EXIT = 10;
    public static final int ACTION_HOVER_MOVE = 7;
    public static final int ACTION_MASK = 0xFF;
    public static final int ACTION_POINTER_DOWN = 5;
    public static final int ACTION_POINTER_INDEX_MASK = 0xFF00;
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    public static final int ACTION_POINTER_UP = 6;
    public static final int ACTION_SCROLL = 8;
    public static final int AXIS_BRAKE = 23;
    public static final int AXIS_DISTANCE = 24;
    public static final int AXIS_GAS = 22;
    public static final int AXIS_GENERIC_1 = 0x20;
    public static final int AXIS_GENERIC_10 = 41;
    public static final int AXIS_GENERIC_11 = 42;
    public static final int AXIS_GENERIC_12 = 43;
    public static final int AXIS_GENERIC_13 = 44;
    public static final int AXIS_GENERIC_14 = 45;
    public static final int AXIS_GENERIC_15 = 46;
    public static final int AXIS_GENERIC_16 = 0x2F;
    public static final int AXIS_GENERIC_2 = 33;
    public static final int AXIS_GENERIC_3 = 34;
    public static final int AXIS_GENERIC_4 = 35;
    public static final int AXIS_GENERIC_5 = 36;
    public static final int AXIS_GENERIC_6 = 37;
    public static final int AXIS_GENERIC_7 = 38;
    public static final int AXIS_GENERIC_8 = 39;
    public static final int AXIS_GENERIC_9 = 40;
    public static final int AXIS_HAT_X = 15;
    public static final int AXIS_HAT_Y = 16;
    public static final int AXIS_HSCROLL = 10;
    public static final int AXIS_LTRIGGER = 17;
    public static final int AXIS_ORIENTATION = 8;
    public static final int AXIS_PRESSURE = 2;
    public static final int AXIS_RELATIVE_X = 27;
    public static final int AXIS_RELATIVE_Y = 28;
    public static final int AXIS_RTRIGGER = 18;
    public static final int AXIS_RUDDER = 20;
    public static final int AXIS_RX = 12;
    public static final int AXIS_RY = 13;
    public static final int AXIS_RZ = 14;
    public static final int AXIS_SIZE = 3;
    public static final int AXIS_THROTTLE = 19;
    public static final int AXIS_TILT = 25;
    public static final int AXIS_TOOL_MAJOR = 6;
    public static final int AXIS_TOOL_MINOR = 7;
    public static final int AXIS_TOUCH_MAJOR = 4;
    public static final int AXIS_TOUCH_MINOR = 5;
    public static final int AXIS_VSCROLL = 9;
    public static final int AXIS_WHEEL = 21;
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 11;
    public static final int BUTTON_PRIMARY = 1;
    static final MotionEventVersionImpl IMPL;

    static {
        if(Build$VERSION.SDK_INT >= 14) {
            MotionEventCompat.IMPL = new ICSMotionEventVersionImpl();
        }
        else if(Build$VERSION.SDK_INT >= 12) {
            MotionEventCompat.IMPL = new HoneycombMr1MotionEventVersionImpl();
        }
        else {
            MotionEventCompat.IMPL = new BaseMotionEventVersionImpl();
        }
    }

    private MotionEventCompat() {
        super();
    }

    @Deprecated public static int findPointerIndex(MotionEvent arg1, int arg2) {
        return arg1.findPointerIndex(arg2);
    }

    public static int getActionIndex(MotionEvent arg2) {
        return (arg2.getAction() & 0xFF00) >> 8;
    }

    public static int getActionMasked(MotionEvent arg1) {
        return arg1.getAction() & 0xFF;
    }

    public static float getAxisValue(MotionEvent arg1, int arg2) {
        return MotionEventCompat.IMPL.getAxisValue(arg1, arg2);
    }

    public static float getAxisValue(MotionEvent arg1, int arg2, int arg3) {
        return MotionEventCompat.IMPL.getAxisValue(arg1, arg2, arg3);
    }

    public static int getButtonState(MotionEvent arg1) {
        return MotionEventCompat.IMPL.getButtonState(arg1);
    }

    @Deprecated public static int getPointerCount(MotionEvent arg1) {
        return arg1.getPointerCount();
    }

    @Deprecated public static int getPointerId(MotionEvent arg1, int arg2) {
        return arg1.getPointerId(arg2);
    }

    @Deprecated public static int getSource(MotionEvent arg1) {
        return arg1.getSource();
    }

    @Deprecated public static float getX(MotionEvent arg1, int arg2) {
        return arg1.getX(arg2);
    }

    @Deprecated public static float getY(MotionEvent arg1, int arg2) {
        return arg1.getY(arg2);
    }

    public static boolean isFromSource(MotionEvent arg1, int arg2) {
        boolean v0 = (arg1.getSource() & arg2) == arg2 ? true : false;
        return v0;
    }
}

