package android.support.v4.view;

public final class InputDeviceCompat {
    public static final int SOURCE_ANY = 0xFFFFFF00;
    public static final int SOURCE_CLASS_BUTTON = 1;
    public static final int SOURCE_CLASS_JOYSTICK = 16;
    public static final int SOURCE_CLASS_MASK = 0xFF;
    public static final int SOURCE_CLASS_NONE = 0;
    public static final int SOURCE_CLASS_POINTER = 2;
    public static final int SOURCE_CLASS_POSITION = 8;
    public static final int SOURCE_CLASS_TRACKBALL = 4;
    public static final int SOURCE_DPAD = 0x201;
    public static final int SOURCE_GAMEPAD = 0x401;
    public static final int SOURCE_HDMI = 0x2000001;
    public static final int SOURCE_JOYSTICK = 0x1000010;
    public static final int SOURCE_KEYBOARD = 0x101;
    public static final int SOURCE_MOUSE = 0x2002;
    public static final int SOURCE_STYLUS = 0x4002;
    public static final int SOURCE_TOUCHPAD = 0x100008;
    public static final int SOURCE_TOUCHSCREEN = 0x1002;
    public static final int SOURCE_TOUCH_NAVIGATION = 0x200000;
    public static final int SOURCE_TRACKBALL = 0x10004;
    public static final int SOURCE_UNKNOWN;

    private InputDeviceCompat() {
        super();
    }
}

