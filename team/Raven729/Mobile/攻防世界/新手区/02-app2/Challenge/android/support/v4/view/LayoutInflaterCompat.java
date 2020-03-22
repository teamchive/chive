package android.support.v4.view;

import android.os.Build$VERSION;
import android.view.LayoutInflater;

public final class LayoutInflaterCompat {
    interface LayoutInflaterCompatImpl {
        LayoutInflaterFactory getFactory(LayoutInflater arg1);

        void setFactory(LayoutInflater arg1, LayoutInflaterFactory arg2);
    }

    class LayoutInflaterCompatImplBase implements LayoutInflaterCompatImpl {
        LayoutInflaterCompatImplBase() {
            super();
        }

        public LayoutInflaterFactory getFactory(LayoutInflater arg2) {
            return LayoutInflaterCompatBase.getFactory(arg2);
        }

        public void setFactory(LayoutInflater arg1, LayoutInflaterFactory arg2) {
            LayoutInflaterCompatBase.setFactory(arg1, arg2);
        }
    }

    class LayoutInflaterCompatImplV11 extends LayoutInflaterCompatImplBase {
        LayoutInflaterCompatImplV11() {
            super();
        }

        public void setFactory(LayoutInflater arg1, LayoutInflaterFactory arg2) {
            LayoutInflaterCompatHC.setFactory(arg1, arg2);
        }
    }

    class LayoutInflaterCompatImplV21 extends LayoutInflaterCompatImplV11 {
        LayoutInflaterCompatImplV21() {
            super();
        }

        public void setFactory(LayoutInflater arg1, LayoutInflaterFactory arg2) {
            LayoutInflaterCompatLollipop.setFactory(arg1, arg2);
        }
    }

    static final LayoutInflaterCompatImpl IMPL;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 21) {
            LayoutInflaterCompat.IMPL = new LayoutInflaterCompatImplV21();
        }
        else if(v0 >= 11) {
            LayoutInflaterCompat.IMPL = new LayoutInflaterCompatImplV11();
        }
        else {
            LayoutInflaterCompat.IMPL = new LayoutInflaterCompatImplBase();
        }
    }

    private LayoutInflaterCompat() {
        super();
    }

    public static LayoutInflaterFactory getFactory(LayoutInflater arg1) {
        return LayoutInflaterCompat.IMPL.getFactory(arg1);
    }

    public static void setFactory(LayoutInflater arg1, LayoutInflaterFactory arg2) {
        LayoutInflaterCompat.IMPL.setFactory(arg1, arg2);
    }
}

