package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build$VERSION;

public class WindowInsetsCompat {
    class WindowInsetsCompatApi20Impl extends WindowInsetsCompatBaseImpl {
        WindowInsetsCompatApi20Impl() {
            super();
        }

        public WindowInsetsCompat consumeSystemWindowInsets(Object arg3) {
            return new WindowInsetsCompat(WindowInsetsCompatApi20.consumeSystemWindowInsets(arg3));
        }

        public Object getSourceWindowInsets(Object arg2) {
            return WindowInsetsCompatApi20.getSourceWindowInsets(arg2);
        }

        public int getSystemWindowInsetBottom(Object arg2) {
            return WindowInsetsCompatApi20.getSystemWindowInsetBottom(arg2);
        }

        public int getSystemWindowInsetLeft(Object arg2) {
            return WindowInsetsCompatApi20.getSystemWindowInsetLeft(arg2);
        }

        public int getSystemWindowInsetRight(Object arg2) {
            return WindowInsetsCompatApi20.getSystemWindowInsetRight(arg2);
        }

        public int getSystemWindowInsetTop(Object arg2) {
            return WindowInsetsCompatApi20.getSystemWindowInsetTop(arg2);
        }

        public boolean hasInsets(Object arg2) {
            return WindowInsetsCompatApi20.hasInsets(arg2);
        }

        public boolean hasSystemWindowInsets(Object arg2) {
            return WindowInsetsCompatApi20.hasSystemWindowInsets(arg2);
        }

        public boolean isRound(Object arg2) {
            return WindowInsetsCompatApi20.isRound(arg2);
        }

        public WindowInsetsCompat replaceSystemWindowInsets(Object arg3, int arg4, int arg5, int arg6, int arg7) {
            return new WindowInsetsCompat(WindowInsetsCompatApi20.replaceSystemWindowInsets(arg3, arg4, arg5, arg6, arg7));
        }
    }

    class WindowInsetsCompatApi21Impl extends WindowInsetsCompatApi20Impl {
        WindowInsetsCompatApi21Impl() {
            super();
        }

        public WindowInsetsCompat consumeStableInsets(Object arg3) {
            return new WindowInsetsCompat(WindowInsetsCompatApi21.consumeStableInsets(arg3));
        }

        public int getStableInsetBottom(Object arg2) {
            return WindowInsetsCompatApi21.getStableInsetBottom(arg2);
        }

        public int getStableInsetLeft(Object arg2) {
            return WindowInsetsCompatApi21.getStableInsetLeft(arg2);
        }

        public int getStableInsetRight(Object arg2) {
            return WindowInsetsCompatApi21.getStableInsetRight(arg2);
        }

        public int getStableInsetTop(Object arg2) {
            return WindowInsetsCompatApi21.getStableInsetTop(arg2);
        }

        public boolean hasStableInsets(Object arg2) {
            return WindowInsetsCompatApi21.hasStableInsets(arg2);
        }

        public boolean isConsumed(Object arg2) {
            return WindowInsetsCompatApi21.isConsumed(arg2);
        }

        public WindowInsetsCompat replaceSystemWindowInsets(Object arg3, Rect arg4) {
            return new WindowInsetsCompat(WindowInsetsCompatApi21.replaceSystemWindowInsets(arg3, arg4));
        }
    }

    class WindowInsetsCompatBaseImpl implements WindowInsetsCompatImpl {
        WindowInsetsCompatBaseImpl() {
            super();
        }

        public WindowInsetsCompat consumeStableInsets(Object arg2) {
            return null;
        }

        public WindowInsetsCompat consumeSystemWindowInsets(Object arg2) {
            return null;
        }

        public Object getSourceWindowInsets(Object arg2) {
            return null;
        }

        public int getStableInsetBottom(Object arg2) {
            return 0;
        }

        public int getStableInsetLeft(Object arg2) {
            return 0;
        }

        public int getStableInsetRight(Object arg2) {
            return 0;
        }

        public int getStableInsetTop(Object arg2) {
            return 0;
        }

        public int getSystemWindowInsetBottom(Object arg2) {
            return 0;
        }

        public int getSystemWindowInsetLeft(Object arg2) {
            return 0;
        }

        public int getSystemWindowInsetRight(Object arg2) {
            return 0;
        }

        public int getSystemWindowInsetTop(Object arg2) {
            return 0;
        }

        public boolean hasInsets(Object arg2) {
            return 0;
        }

        public boolean hasStableInsets(Object arg2) {
            return 0;
        }

        public boolean hasSystemWindowInsets(Object arg2) {
            return 0;
        }

        public boolean isConsumed(Object arg2) {
            return 0;
        }

        public boolean isRound(Object arg2) {
            return 0;
        }

        public WindowInsetsCompat replaceSystemWindowInsets(Object arg2, int arg3, int arg4, int arg5, int arg6) {
            return null;
        }

        public WindowInsetsCompat replaceSystemWindowInsets(Object arg2, Rect arg3) {
            return null;
        }
    }

    interface WindowInsetsCompatImpl {
        WindowInsetsCompat consumeStableInsets(Object arg1);

        WindowInsetsCompat consumeSystemWindowInsets(Object arg1);

        Object getSourceWindowInsets(Object arg1);

        int getStableInsetBottom(Object arg1);

        int getStableInsetLeft(Object arg1);

        int getStableInsetRight(Object arg1);

        int getStableInsetTop(Object arg1);

        int getSystemWindowInsetBottom(Object arg1);

        int getSystemWindowInsetLeft(Object arg1);

        int getSystemWindowInsetRight(Object arg1);

        int getSystemWindowInsetTop(Object arg1);

        boolean hasInsets(Object arg1);

        boolean hasStableInsets(Object arg1);

        boolean hasSystemWindowInsets(Object arg1);

        boolean isConsumed(Object arg1);

        boolean isRound(Object arg1);

        WindowInsetsCompat replaceSystemWindowInsets(Object arg1, int arg2, int arg3, int arg4, int arg5);

        WindowInsetsCompat replaceSystemWindowInsets(Object arg1, Rect arg2);
    }

    private static final WindowInsetsCompatImpl IMPL;
    private final Object mInsets;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 21) {
            WindowInsetsCompat.IMPL = new WindowInsetsCompatApi21Impl();
        }
        else if(v0 >= 20) {
            WindowInsetsCompat.IMPL = new WindowInsetsCompatApi20Impl();
        }
        else {
            WindowInsetsCompat.IMPL = new WindowInsetsCompatBaseImpl();
        }
    }

    public WindowInsetsCompat(WindowInsetsCompat arg3) {
        super();
        Object v0 = arg3 == null ? null : WindowInsetsCompat.IMPL.getSourceWindowInsets(arg3.mInsets);
        this.mInsets = v0;
    }

    WindowInsetsCompat(Object arg1) {
        super();
        this.mInsets = arg1;
    }

    public WindowInsetsCompat consumeStableInsets() {
        return WindowInsetsCompat.IMPL.consumeStableInsets(this.mInsets);
    }

    public WindowInsetsCompat consumeSystemWindowInsets() {
        return WindowInsetsCompat.IMPL.consumeSystemWindowInsets(this.mInsets);
    }

    public boolean equals(Object arg5) {
        boolean v0 = true;
        if(this != (((WindowInsetsCompat)arg5))) {
            if(arg5 != null && this.getClass() == arg5.getClass()) {
                if(this.mInsets != null) {
                    v0 = this.mInsets.equals(((WindowInsetsCompat)arg5).mInsets);
                }
                else if(((WindowInsetsCompat)arg5).mInsets != null) {
                    v0 = false;
                }
                else {
                }

                return v0;
            }

            v0 = false;
        }

        return v0;
    }

    public int getStableInsetBottom() {
        return WindowInsetsCompat.IMPL.getStableInsetBottom(this.mInsets);
    }

    public int getStableInsetLeft() {
        return WindowInsetsCompat.IMPL.getStableInsetLeft(this.mInsets);
    }

    public int getStableInsetRight() {
        return WindowInsetsCompat.IMPL.getStableInsetRight(this.mInsets);
    }

    public int getStableInsetTop() {
        return WindowInsetsCompat.IMPL.getStableInsetTop(this.mInsets);
    }

    public int getSystemWindowInsetBottom() {
        return WindowInsetsCompat.IMPL.getSystemWindowInsetBottom(this.mInsets);
    }

    public int getSystemWindowInsetLeft() {
        return WindowInsetsCompat.IMPL.getSystemWindowInsetLeft(this.mInsets);
    }

    public int getSystemWindowInsetRight() {
        return WindowInsetsCompat.IMPL.getSystemWindowInsetRight(this.mInsets);
    }

    public int getSystemWindowInsetTop() {
        return WindowInsetsCompat.IMPL.getSystemWindowInsetTop(this.mInsets);
    }

    public boolean hasInsets() {
        return WindowInsetsCompat.IMPL.hasInsets(this.mInsets);
    }

    public boolean hasStableInsets() {
        return WindowInsetsCompat.IMPL.hasStableInsets(this.mInsets);
    }

    public boolean hasSystemWindowInsets() {
        return WindowInsetsCompat.IMPL.hasSystemWindowInsets(this.mInsets);
    }

    public int hashCode() {
        int v0 = this.mInsets == null ? 0 : this.mInsets.hashCode();
        return v0;
    }

    public boolean isConsumed() {
        return WindowInsetsCompat.IMPL.isConsumed(this.mInsets);
    }

    public boolean isRound() {
        return WindowInsetsCompat.IMPL.isRound(this.mInsets);
    }

    public WindowInsetsCompat replaceSystemWindowInsets(int arg7, int arg8, int arg9, int arg10) {
        return WindowInsetsCompat.IMPL.replaceSystemWindowInsets(this.mInsets, arg7, arg8, arg9, arg10);
    }

    public WindowInsetsCompat replaceSystemWindowInsets(Rect arg3) {
        return WindowInsetsCompat.IMPL.replaceSystemWindowInsets(this.mInsets, arg3);
    }

    static Object unwrap(WindowInsetsCompat arg1) {
        Object v0 = arg1 == null ? null : arg1.mInsets;
        return v0;
    }

    static WindowInsetsCompat wrap(Object arg1) {
        WindowInsetsCompat v0 = arg1 == null ? null : new WindowInsetsCompat(arg1);
        return v0;
    }
}

