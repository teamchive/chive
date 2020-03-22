package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.v4.os.BuildCompat;

public final class PointerIconCompat {
    class Api24PointerIconCompatImpl extends BasePointerIconCompatImpl {
        Api24PointerIconCompatImpl() {
            super();
        }

        public Object create(Bitmap arg2, float arg3, float arg4) {
            return PointerIconCompatApi24.create(arg2, arg3, arg4);
        }

        public Object getSystemIcon(Context arg2, int arg3) {
            return PointerIconCompatApi24.getSystemIcon(arg2, arg3);
        }

        public Object load(Resources arg2, int arg3) {
            return PointerIconCompatApi24.load(arg2, arg3);
        }
    }

    class BasePointerIconCompatImpl implements PointerIconCompatImpl {
        BasePointerIconCompatImpl() {
            super();
        }

        public Object create(Bitmap arg2, float arg3, float arg4) {
            return null;
        }

        public Object getSystemIcon(Context arg2, int arg3) {
            return null;
        }

        public Object load(Resources arg2, int arg3) {
            return null;
        }
    }

    interface PointerIconCompatImpl {
        Object create(Bitmap arg1, float arg2, float arg3);

        Object getSystemIcon(Context arg1, int arg2);

        Object load(Resources arg1, int arg2);
    }

    static final PointerIconCompatImpl IMPL = null;
    public static final int TYPE_ALIAS = 1010;
    public static final int TYPE_ALL_SCROLL = 0x3F5;
    public static final int TYPE_ARROW = 1000;
    public static final int TYPE_CELL = 1006;
    public static final int TYPE_CONTEXT_MENU = 1001;
    public static final int TYPE_COPY = 0x3F3;
    public static final int TYPE_CROSSHAIR = 1007;
    public static final int TYPE_DEFAULT = 1000;
    public static final int TYPE_GRAB = 1020;
    public static final int TYPE_GRABBING = 0x3FD;
    public static final int TYPE_HAND = 1002;
    public static final int TYPE_HELP = 1003;
    public static final int TYPE_HORIZONTAL_DOUBLE_ARROW = 0x3F6;
    public static final int TYPE_NO_DROP = 0x3F4;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_TEXT = 0x3F0;
    public static final int TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW = 0x3F9;
    public static final int TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW = 0x3F8;
    public static final int TYPE_VERTICAL_DOUBLE_ARROW = 0x3F7;
    public static final int TYPE_VERTICAL_TEXT = 1009;
    public static final int TYPE_WAIT = 1004;
    public static final int TYPE_ZOOM_IN = 0x3FA;
    public static final int TYPE_ZOOM_OUT = 0x3FB;
    private Object mPointerIcon;

    static {
        PointerIconCompat.IMPL = BuildCompat.isAtLeastN() ? new Api24PointerIconCompatImpl() : new BasePointerIconCompatImpl();
    }

    private PointerIconCompat(Object arg1) {
        super();
        this.mPointerIcon = arg1;
    }

    public static PointerIconCompat create(Bitmap arg2, float arg3, float arg4) {
        return new PointerIconCompat(PointerIconCompat.IMPL.create(arg2, arg3, arg4));
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public Object getPointerIcon() {
        return this.mPointerIcon;
    }

    public static PointerIconCompat getSystemIcon(Context arg2, int arg3) {
        return new PointerIconCompat(PointerIconCompat.IMPL.getSystemIcon(arg2, arg3));
    }

    public static PointerIconCompat load(Resources arg2, int arg3) {
        return new PointerIconCompat(PointerIconCompat.IMPL.load(arg2, arg3));
    }
}

