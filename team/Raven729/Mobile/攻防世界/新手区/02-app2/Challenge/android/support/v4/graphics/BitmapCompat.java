package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build$VERSION;

public final class BitmapCompat {
    class BaseBitmapImpl implements BitmapImpl {
        BaseBitmapImpl() {
            super();
        }

        public int getAllocationByteCount(Bitmap arg3) {
            return arg3.getRowBytes() * arg3.getHeight();
        }

        public boolean hasMipMap(Bitmap arg2) {
            return 0;
        }

        public void setHasMipMap(Bitmap arg1, boolean arg2) {
        }
    }

    interface BitmapImpl {
        int getAllocationByteCount(Bitmap arg1);

        boolean hasMipMap(Bitmap arg1);

        void setHasMipMap(Bitmap arg1, boolean arg2);
    }

    class HcMr1BitmapCompatImpl extends BaseBitmapImpl {
        HcMr1BitmapCompatImpl() {
            super();
        }

        public int getAllocationByteCount(Bitmap arg2) {
            return BitmapCompatHoneycombMr1.getAllocationByteCount(arg2);
        }
    }

    class JbMr2BitmapCompatImpl extends HcMr1BitmapCompatImpl {
        JbMr2BitmapCompatImpl() {
            super();
        }

        public boolean hasMipMap(Bitmap arg2) {
            return BitmapCompatJellybeanMR2.hasMipMap(arg2);
        }

        public void setHasMipMap(Bitmap arg1, boolean arg2) {
            BitmapCompatJellybeanMR2.setHasMipMap(arg1, arg2);
        }
    }

    class KitKatBitmapCompatImpl extends JbMr2BitmapCompatImpl {
        KitKatBitmapCompatImpl() {
            super();
        }

        public int getAllocationByteCount(Bitmap arg2) {
            return BitmapCompatKitKat.getAllocationByteCount(arg2);
        }
    }

    static final BitmapImpl IMPL;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 19) {
            BitmapCompat.IMPL = new KitKatBitmapCompatImpl();
        }
        else if(v0 >= 18) {
            BitmapCompat.IMPL = new JbMr2BitmapCompatImpl();
        }
        else if(v0 >= 12) {
            BitmapCompat.IMPL = new HcMr1BitmapCompatImpl();
        }
        else {
            BitmapCompat.IMPL = new BaseBitmapImpl();
        }
    }

    private BitmapCompat() {
        super();
    }

    public static int getAllocationByteCount(Bitmap arg1) {
        return BitmapCompat.IMPL.getAllocationByteCount(arg1);
    }

    public static boolean hasMipMap(Bitmap arg1) {
        return BitmapCompat.IMPL.hasMipMap(arg1);
    }

    public static void setHasMipMap(Bitmap arg1, boolean arg2) {
        BitmapCompat.IMPL.setHasMipMap(arg1, arg2);
    }
}

