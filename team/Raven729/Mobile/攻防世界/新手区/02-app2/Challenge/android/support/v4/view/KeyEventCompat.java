package android.support.v4.view;

import android.os.Build$VERSION;
import android.view.KeyEvent$Callback;
import android.view.KeyEvent$DispatcherState;
import android.view.KeyEvent;
import android.view.View;

public final class KeyEventCompat {
    class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
        private static final int META_ALL_MASK = 0xF7;
        private static final int META_MODIFIER_MASK = 0xF7;

        BaseKeyEventVersionImpl() {
            super();
        }

        public boolean isCtrlPressed(KeyEvent arg2) {
            return 0;
        }

        private static int metaStateFilterDirectionalModifiers(int arg5, int arg6, int arg7, int arg8, int arg9) {
            int v0 = 1;
            int v2 = (arg6 & arg7) != 0 ? 1 : 0;
            int v3 = arg8 | arg9;
            if((arg6 & v3) == 0) {
                v0 = 0;
            }

            if(v2 != 0) {
                if(v0 != 0) {
                    throw new IllegalArgumentException("bad arguments");
                }
                else {
                    arg5 &= v3 ^ -1;
                }
            }
            else if(v0 != 0) {
                arg5 &= arg7 ^ -1;
            }

            return arg5;
        }

        public boolean metaStateHasModifiers(int arg6, int arg7) {
            boolean v0 = true;
            if(BaseKeyEventVersionImpl.metaStateFilterDirectionalModifiers(BaseKeyEventVersionImpl.metaStateFilterDirectionalModifiers(this.normalizeMetaState(arg6) & 0xF7, arg7, 1, 0x40, 0x80), arg7, 2, 16, 0x20) != arg7) {
                v0 = false;
            }

            return v0;
        }

        public boolean metaStateHasNoModifiers(int arg2) {
            boolean v0 = (this.normalizeMetaState(arg2) & 0xF7) == 0 ? true : false;
            return v0;
        }

        public int normalizeMetaState(int arg3) {
            int v0 = (arg3 & 0xC0) != 0 ? arg3 | 1 : arg3;
            if((v0 & 0x30) != 0) {
                v0 |= 2;
            }

            return v0 & 0xF7;
        }
    }

    class HoneycombKeyEventVersionImpl extends BaseKeyEventVersionImpl {
        HoneycombKeyEventVersionImpl() {
            super();
        }

        public boolean isCtrlPressed(KeyEvent arg2) {
            return KeyEventCompatHoneycomb.isCtrlPressed(arg2);
        }

        public boolean metaStateHasModifiers(int arg2, int arg3) {
            return KeyEventCompatHoneycomb.metaStateHasModifiers(arg2, arg3);
        }

        public boolean metaStateHasNoModifiers(int arg2) {
            return KeyEventCompatHoneycomb.metaStateHasNoModifiers(arg2);
        }

        public int normalizeMetaState(int arg2) {
            return KeyEventCompatHoneycomb.normalizeMetaState(arg2);
        }
    }

    interface KeyEventVersionImpl {
        boolean isCtrlPressed(KeyEvent arg1);

        boolean metaStateHasModifiers(int arg1, int arg2);

        boolean metaStateHasNoModifiers(int arg1);

        int normalizeMetaState(int arg1);
    }

    static final KeyEventVersionImpl IMPL;

    static {
        KeyEventCompat.IMPL = Build$VERSION.SDK_INT >= 11 ? new HoneycombKeyEventVersionImpl() : new BaseKeyEventVersionImpl();
    }

    private KeyEventCompat() {
        super();
    }

    @Deprecated public static boolean dispatch(KeyEvent arg1, KeyEvent$Callback arg2, Object arg3, Object arg4) {
        return arg1.dispatch(arg2, ((KeyEvent$DispatcherState)arg3), arg4);
    }

    @Deprecated public static Object getKeyDispatcherState(View arg1) {
        return arg1.getKeyDispatcherState();
    }

    public static boolean hasModifiers(KeyEvent arg2, int arg3) {
        return KeyEventCompat.IMPL.metaStateHasModifiers(arg2.getMetaState(), arg3);
    }

    public static boolean hasNoModifiers(KeyEvent arg2) {
        return KeyEventCompat.IMPL.metaStateHasNoModifiers(arg2.getMetaState());
    }

    public static boolean isCtrlPressed(KeyEvent arg1) {
        return KeyEventCompat.IMPL.isCtrlPressed(arg1);
    }

    @Deprecated public static boolean isTracking(KeyEvent arg1) {
        return arg1.isTracking();
    }

    public static boolean metaStateHasModifiers(int arg1, int arg2) {
        return KeyEventCompat.IMPL.metaStateHasModifiers(arg1, arg2);
    }

    public static boolean metaStateHasNoModifiers(int arg1) {
        return KeyEventCompat.IMPL.metaStateHasNoModifiers(arg1);
    }

    public static int normalizeMetaState(int arg1) {
        return KeyEventCompat.IMPL.normalizeMetaState(arg1);
    }

    @Deprecated public static void startTracking(KeyEvent arg0) {
        arg0.startTracking();
    }
}

