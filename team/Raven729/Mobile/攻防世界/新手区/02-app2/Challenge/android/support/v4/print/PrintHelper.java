package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build$VERSION;

public final class PrintHelper {
    class android.support.v4.print.PrintHelper$1 {
    }

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    final class PrintHelperApi20Impl extends PrintHelperImpl {
        PrintHelperApi20Impl(Context arg2) {
            super(new PrintHelperApi20(arg2));
        }
    }

    final class PrintHelperApi23Impl extends PrintHelperImpl {
        PrintHelperApi23Impl(Context arg2) {
            super(new PrintHelperApi23(arg2));
        }
    }

    final class PrintHelperApi24Impl extends PrintHelperImpl {
        PrintHelperApi24Impl(Context arg2) {
            super(new PrintHelperApi24(arg2));
        }
    }

    class PrintHelperImpl implements PrintHelperVersionImpl {
        private final PrintHelperKitkat mPrintHelper;

        protected PrintHelperImpl(PrintHelperKitkat arg1) {
            super();
            this.mPrintHelper = arg1;
        }

        public int getColorMode() {
            return this.mPrintHelper.getColorMode();
        }

        public int getOrientation() {
            return this.mPrintHelper.getOrientation();
        }

        public int getScaleMode() {
            return this.mPrintHelper.getScaleMode();
        }

        public void printBitmap(String arg3, Bitmap arg4, OnPrintFinishCallback arg5) {
            android.support.v4.print.PrintHelperKitkat$OnPrintFinishCallback v0 = null;
            if(arg5 != null) {
                android.support.v4.print.PrintHelper$PrintHelperImpl$1 v0_1 = new android.support.v4.print.PrintHelperKitkat$OnPrintFinishCallback(arg5) {
                    public void onFinish() {
                        this.val$callback.onFinish();
                    }
                };
            }

            this.mPrintHelper.printBitmap(arg3, arg4, v0);
        }

        public void printBitmap(String arg3, Uri arg4, OnPrintFinishCallback arg5) {
            android.support.v4.print.PrintHelperKitkat$OnPrintFinishCallback v0 = null;
            if(arg5 != null) {
                android.support.v4.print.PrintHelper$PrintHelperImpl$2 v0_1 = new android.support.v4.print.PrintHelperKitkat$OnPrintFinishCallback(arg5) {
                    public void onFinish() {
                        this.val$callback.onFinish();
                    }
                };
            }

            this.mPrintHelper.printBitmap(arg3, arg4, v0);
        }

        public void setColorMode(int arg2) {
            this.mPrintHelper.setColorMode(arg2);
        }

        public void setOrientation(int arg2) {
            this.mPrintHelper.setOrientation(arg2);
        }

        public void setScaleMode(int arg2) {
            this.mPrintHelper.setScaleMode(arg2);
        }
    }

    final class PrintHelperKitkatImpl extends PrintHelperImpl {
        PrintHelperKitkatImpl(Context arg2) {
            super(new PrintHelperKitkat(arg2));
        }
    }

    final class PrintHelperStubImpl implements PrintHelperVersionImpl {
        int mColorMode;
        int mOrientation;
        int mScaleMode;

        PrintHelperStubImpl(android.support.v4.print.PrintHelper$1 arg1) {
            this();
        }

        private PrintHelperStubImpl() {
            super();
            this.mScaleMode = 2;
            this.mColorMode = 2;
            this.mOrientation = 1;
        }

        public int getColorMode() {
            return this.mColorMode;
        }

        public int getOrientation() {
            return this.mOrientation;
        }

        public int getScaleMode() {
            return this.mScaleMode;
        }

        public void printBitmap(String arg1, Bitmap arg2, OnPrintFinishCallback arg3) {
        }

        public void printBitmap(String arg1, Uri arg2, OnPrintFinishCallback arg3) {
        }

        public void setColorMode(int arg1) {
            this.mColorMode = arg1;
        }

        public void setOrientation(int arg1) {
            this.mOrientation = arg1;
        }

        public void setScaleMode(int arg1) {
            this.mScaleMode = arg1;
        }
    }

    interface PrintHelperVersionImpl {
        int getColorMode();

        int getOrientation();

        int getScaleMode();

        void printBitmap(String arg1, Bitmap arg2, OnPrintFinishCallback arg3);

        void printBitmap(String arg1, Uri arg2, OnPrintFinishCallback arg3);

        void setColorMode(int arg1);

        void setOrientation(int arg1);

        void setScaleMode(int arg1);
    }

    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    PrintHelperVersionImpl mImpl;

    public PrintHelper(Context arg3) {
        super();
        if(!PrintHelper.systemSupportsPrint()) {
            this.mImpl = new PrintHelperStubImpl(null);
        }
        else if(Build$VERSION.SDK_INT >= 24) {
            this.mImpl = new PrintHelperApi24Impl(arg3);
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            this.mImpl = new PrintHelperApi23Impl(arg3);
        }
        else if(Build$VERSION.SDK_INT >= 20) {
            this.mImpl = new PrintHelperApi20Impl(arg3);
        }
        else {
            this.mImpl = new PrintHelperKitkatImpl(arg3);
        }
    }

    public int getColorMode() {
        return this.mImpl.getColorMode();
    }

    public int getOrientation() {
        return this.mImpl.getOrientation();
    }

    public int getScaleMode() {
        return this.mImpl.getScaleMode();
    }

    public void printBitmap(String arg3, Bitmap arg4) {
        this.mImpl.printBitmap(arg3, arg4, null);
    }

    public void printBitmap(String arg2, Bitmap arg3, OnPrintFinishCallback arg4) {
        this.mImpl.printBitmap(arg2, arg3, arg4);
    }

    public void printBitmap(String arg3, Uri arg4) {
        this.mImpl.printBitmap(arg3, arg4, null);
    }

    public void printBitmap(String arg2, Uri arg3, OnPrintFinishCallback arg4) {
        this.mImpl.printBitmap(arg2, arg3, arg4);
    }

    public void setColorMode(int arg2) {
        this.mImpl.setColorMode(arg2);
    }

    public void setOrientation(int arg2) {
        this.mImpl.setOrientation(arg2);
    }

    public void setScaleMode(int arg2) {
        this.mImpl.setScaleMode(arg2);
    }

    public static boolean systemSupportsPrint() {
        boolean v0 = Build$VERSION.SDK_INT >= 19 ? true : false;
        return v0;
    }
}

