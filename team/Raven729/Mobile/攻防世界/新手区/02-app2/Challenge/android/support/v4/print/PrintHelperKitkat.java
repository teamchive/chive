package android.support.v4.print;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory$Options;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument$Page;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal$OnCancelListener;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes$Builder;
import android.print.PrintAttributes$Margins;
import android.print.PrintAttributes$MediaSize;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter$LayoutResultCallback;
import android.print.PrintDocumentAdapter$WriteResultCallback;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo$Builder;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@TargetApi(value=19) @RequiresApi(value=19) class PrintHelperKitkat {
    public interface OnPrintFinishCallback {
        void onFinish();
    }

    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    private static final String LOG_TAG = "PrintHelperKitkat";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    int mColorMode;
    final Context mContext;
    BitmapFactory$Options mDecodeOptions;
    protected boolean mIsMinMarginsHandlingCorrect;
    private final Object mLock;
    int mOrientation;
    protected boolean mPrintActivityRespectsOrientation;
    int mScaleMode;

    PrintHelperKitkat(Context arg4) {
        super();
        this.mDecodeOptions = null;
        this.mLock = new Object();
        this.mScaleMode = 2;
        this.mColorMode = 2;
        this.mPrintActivityRespectsOrientation = true;
        this.mIsMinMarginsHandlingCorrect = true;
        this.mContext = arg4;
    }

    static void access$000(PrintHelperKitkat arg0, PrintAttributes arg1, int arg2, Bitmap arg3, ParcelFileDescriptor arg4, CancellationSignal arg5, PrintDocumentAdapter$WriteResultCallback arg6) {
        arg0.writeBitmap(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    static Bitmap access$100(PrintHelperKitkat arg1, Bitmap arg2, int arg3) {
        return arg1.convertBitmapForColorMode(arg2, arg3);
    }

    static Matrix access$200(PrintHelperKitkat arg1, int arg2, int arg3, RectF arg4, int arg5) {
        return arg1.getMatrix(arg2, arg3, arg4, arg5);
    }

    static Bitmap access$400(PrintHelperKitkat arg1, Uri arg2, int arg3) {
        return arg1.loadConstrainedBitmap(arg2, arg3);
    }

    static boolean access$600(Bitmap arg1) {
        return PrintHelperKitkat.isPortrait(arg1);
    }

    static Object access$700(PrintHelperKitkat arg1) {
        return arg1.mLock;
    }

    private Bitmap convertBitmapForColorMode(Bitmap arg7, int arg8) {
        if(arg8 == 1) {
            Bitmap v0 = Bitmap.createBitmap(arg7.getWidth(), arg7.getHeight(), Bitmap$Config.ARGB_8888);
            Canvas v1 = new Canvas(v0);
            Paint v2 = new Paint();
            ColorMatrix v3 = new ColorMatrix();
            v3.setSaturation(0f);
            v2.setColorFilter(new ColorMatrixColorFilter(v3));
            v1.drawBitmap(arg7, 0f, 0f, v2);
            v1.setBitmap(null);
            arg7 = v0;
        }

        return arg7;
    }

    protected PrintAttributes$Builder copyAttributes(PrintAttributes arg3) {
        PrintAttributes$Builder v0 = new PrintAttributes$Builder().setMediaSize(arg3.getMediaSize()).setResolution(arg3.getResolution()).setMinMargins(arg3.getMinMargins());
        if(arg3.getColorMode() != 0) {
            v0.setColorMode(arg3.getColorMode());
        }

        return v0;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    private Matrix getMatrix(int arg7, int arg8, RectF arg9, int arg10) {
        float v5 = 2f;
        Matrix v1 = new Matrix();
        float v0 = arg9.width() / (((float)arg7));
        v0 = arg10 == 2 ? Math.max(v0, arg9.height() / (((float)arg8))) : Math.min(v0, arg9.height() / (((float)arg8)));
        v1.postScale(v0, v0);
        v1.postTranslate((arg9.width() - (((float)arg7)) * v0) / v5, (arg9.height() - v0 * (((float)arg8))) / v5);
        return v1;
    }

    public int getOrientation() {
        int v0 = this.mOrientation == 0 ? 1 : this.mOrientation;
        return v0;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    private static boolean isPortrait(Bitmap arg2) {
        boolean v0 = arg2.getWidth() <= arg2.getHeight() ? true : false;
        return v0;
    }

    private Bitmap loadBitmap(Uri arg5, BitmapFactory$Options arg6) {
        Bitmap v0_1;
        InputStream v1;
        if(arg5 != null && this.mContext != null) {
            try {
                v1 = this.mContext.getContentResolver().openInputStream(arg5);
                v0_1 = BitmapFactory.decodeStream(v1, null, arg6);
                if(v1 == null) {
                    return v0_1;
                }
            }
            catch(Throwable v0) {
                if(v1 != null) {
                    try {
                        v1.close();
                    }
                    catch(IOException v1_1) {
                        Log.w("PrintHelperKitkat", "close fail ", ((Throwable)v1_1));
                    }

                    goto label_24;
                }
                else {
                label_24:
                    throw v0;
                }

                goto label_4;
            }

            try {
                v1.close();
            }
            catch(IOException v1_1) {
                Log.w("PrintHelperKitkat", "close fail ", ((Throwable)v1_1));
            }

            return v0_1;
        }

    label_4:
        throw new IllegalArgumentException("bad argument to loadBitmap");
    }

    private Bitmap loadConstrainedBitmap(Uri arg6, int arg7) {
        Object v1_1;
        BitmapFactory$Options v0_2;
        int v1 = 1;
        Bitmap v0 = null;
        if(arg7 > 0 && arg6 != null && this.mContext != null) {
            BitmapFactory$Options v2 = new BitmapFactory$Options();
            v2.inJustDecodeBounds = true;
            this.loadBitmap(arg6, v2);
            int v3 = v2.outWidth;
            int v4 = v2.outHeight;
            if(v3 > 0 && v4 > 0) {
                int v2_1 = Math.max(v3, v4);
                while(v2_1 > arg7) {
                    v2_1 >>>= 1;
                    v1 <<= 1;
                }

                if(v1 > 0 && Math.min(v3, v4) / v1 > 0) {
                    Object v2_2 = this.mLock;
                    __monitor_enter(v2_2);
                    try {
                        this.mDecodeOptions = new BitmapFactory$Options();
                        this.mDecodeOptions.inMutable = true;
                        this.mDecodeOptions.inSampleSize = v1;
                        v0_2 = this.mDecodeOptions;
                        __monitor_exit(v2_2);
                    }
                    catch(Throwable v0_1) {
                        goto label_51;
                    }

                    try {
                        v0 = this.loadBitmap(arg6, v0_2);
                    }
                    catch(Throwable v0_1) {
                        v1_1 = this.mLock;
                        __monitor_enter(v1_1);
                        v2 = null;
                        try {
                            this.mDecodeOptions = v2;
                            __monitor_exit(v1_1);
                        }
                        catch(Throwable v0_1) {
                            goto label_61;
                        }

                        throw v0_1;
                    }

                    v1_1 = this.mLock;
                    __monitor_enter(v1_1);
                    v2 = null;
                    try {
                        this.mDecodeOptions = v2;
                        __monitor_exit(v1_1);
                        return v0;
                    }
                    catch(Throwable v0_1) {
                        goto label_48;
                    }

                    try {
                    label_61:
                        __monitor_exit(v1_1);
                    }
                    catch(Throwable v0_1) {
                        goto label_61;
                    }

                    throw v0_1;
                    try {
                    label_48:
                        __monitor_exit(v1_1);
                    }
                    catch(Throwable v0_1) {
                        goto label_48;
                    }

                    throw v0_1;
                    try {
                    label_51:
                        __monitor_exit(v2_2);
                    }
                    catch(Throwable v0_1) {
                        goto label_51;
                    }

                    throw v0_1;
                }
            }

            return v0;
        }

        throw new IllegalArgumentException("bad argument to getScaledBitmap");
    }

    public void printBitmap(String arg9, Bitmap arg10, OnPrintFinishCallback arg11) {
        if(arg10 != null) {
            int v3 = this.mScaleMode;
            Object v6 = this.mContext.getSystemService("print");
            PrintAttributes$MediaSize v0 = PrintHelperKitkat.isPortrait(arg10) ? PrintAttributes$MediaSize.UNKNOWN_PORTRAIT : PrintAttributes$MediaSize.UNKNOWN_LANDSCAPE;
            ((PrintManager)v6).print(arg9, new PrintDocumentAdapter(arg9, v3, arg10, arg11) {
                private PrintAttributes mAttributes;

                public void onFinish() {
                    if(this.val$callback != null) {
                        this.val$callback.onFinish();
                    }
                }

                public void onLayout(PrintAttributes arg4, PrintAttributes arg5, CancellationSignal arg6, PrintDocumentAdapter$LayoutResultCallback arg7, Bundle arg8) {
                    boolean v0 = true;
                    this.mAttributes = arg5;
                    PrintDocumentInfo v1 = new PrintDocumentInfo$Builder(this.val$jobName).setContentType(1).setPageCount(1).build();
                    if(arg5.equals(arg4)) {
                        v0 = false;
                    }

                    arg7.onLayoutFinished(v1, v0);
                }

                public void onWrite(PageRange[] arg8, ParcelFileDescriptor arg9, CancellationSignal arg10, PrintDocumentAdapter$WriteResultCallback arg11) {
                    PrintHelperKitkat.this.writeBitmap(this.mAttributes, this.val$fittingMode, this.val$bitmap, arg9, arg10, arg11);
                }
            }, new PrintAttributes$Builder().setMediaSize(v0).setColorMode(this.mColorMode).build());
        }
    }

    public void printBitmap(String arg7, Uri arg8, OnPrintFinishCallback arg9) {
        android.support.v4.print.PrintHelperKitkat$3 v0 = new PrintDocumentAdapter(arg7, arg8, arg9, this.mScaleMode) {
            private PrintAttributes mAttributes;
            Bitmap mBitmap;
            AsyncTask mLoadBitmap;

            static void access$300(android.support.v4.print.PrintHelperKitkat$3 arg0) {
                arg0.cancelLoad();
            }

            static PrintAttributes access$500(android.support.v4.print.PrintHelperKitkat$3 arg1) {
                return arg1.mAttributes;
            }

            private void cancelLoad() {
                Object v1 = PrintHelperKitkat.this.mLock;
                __monitor_enter(v1);
                try {
                    if(PrintHelperKitkat.this.mDecodeOptions != null) {
                        PrintHelperKitkat.this.mDecodeOptions.requestCancelDecode();
                        PrintHelperKitkat.this.mDecodeOptions = null;
                    }

                    __monitor_exit(v1);
                    return;
                label_15:
                    __monitor_exit(v1);
                }
                catch(Throwable v0) {
                    goto label_15;
                }

                throw v0;
            }

            public void onFinish() {
                super.onFinish();
                this.cancelLoad();
                if(this.mLoadBitmap != null) {
                    this.mLoadBitmap.cancel(true);
                }

                if(this.val$callback != null) {
                    this.val$callback.onFinish();
                }

                if(this.mBitmap != null) {
                    this.mBitmap.recycle();
                    this.mBitmap = null;
                }
            }

            public void onLayout(PrintAttributes arg8, PrintAttributes arg9, CancellationSignal arg10, PrintDocumentAdapter$LayoutResultCallback arg11, Bundle arg12) {
                boolean v0 = true;
                __monitor_enter(this);
                try {
                    this.mAttributes = arg9;
                    __monitor_exit(this);
                }
                catch(Throwable v0_1) {
                    try {
                    label_10:
                        __monitor_exit(this);
                    }
                    catch(Throwable v0_1) {
                        goto label_10;
                    }

                    throw v0_1;
                }

                if(arg10.isCanceled()) {
                    arg11.onLayoutCancelled();
                }
                else if(this.mBitmap != null) {
                    PrintDocumentInfo v1 = new PrintDocumentInfo$Builder(this.val$jobName).setContentType(1).setPageCount(1).build();
                    if(arg9.equals(arg8)) {
                        v0 = false;
                    }

                    arg11.onLayoutFinished(v1, v0);
                }
                else {
                    this.mLoadBitmap = new AsyncTask(arg10, arg9, arg8, arg11) {
                        protected Bitmap doInBackground(Uri[] arg4) {
                            Bitmap v0_1;
                            try {
                                v0_1 = this.this$1.this$0.loadConstrainedBitmap(this.this$1.val$imageFile, 3500);
                            }
                            catch(FileNotFoundException v0) {
                                v0_1 = null;
                            }

                            return v0_1;
                        }

                        protected Object doInBackground(Object[] arg2) {
                            return this.doInBackground(((Uri[])arg2));
                        }

                        protected void onCancelled(Bitmap arg3) {
                            this.val$layoutResultCallback.onLayoutCancelled();
                            this.this$1.mLoadBitmap = null;
                        }

                        protected void onCancelled(Object arg1) {
                            this.onCancelled(((Bitmap)arg1));
                        }

                        protected void onPostExecute(Bitmap arg9) {
                            AsyncTask v7 = null;
                            boolean v6 = true;
                            super.onPostExecute(arg9);
                            if(arg9 != null && (!this.this$1.this$0.mPrintActivityRespectsOrientation || this.this$1.this$0.mOrientation == 0)) {
                                __monitor_enter(this);
                                try {
                                    PrintAttributes$MediaSize v0_1 = this.this$1.mAttributes.getMediaSize();
                                    __monitor_exit(this);
                                    if(v0_1 == null) {
                                        goto label_31;
                                    }
                                }
                                catch(Throwable v0) {
                                    try {
                                    label_51:
                                        __monitor_exit(this);
                                    }
                                    catch(Throwable v0) {
                                        goto label_51;
                                    }

                                    throw v0;
                                }

                                if(v0_1.isPortrait() == PrintHelperKitkat.isPortrait(arg9)) {
                                    goto label_31;
                                }

                                Matrix v5 = new Matrix();
                                v5.postRotate(90f);
                                arg9 = Bitmap.createBitmap(arg9, 0, 0, arg9.getWidth(), arg9.getHeight(), v5, true);
                            }

                        label_31:
                            this.this$1.mBitmap = arg9;
                            if(arg9 != null) {
                                PrintDocumentInfo v0_2 = new PrintDocumentInfo$Builder(this.this$1.val$jobName).setContentType(1).setPageCount(1).build();
                                if(this.val$newPrintAttributes.equals(this.val$oldPrintAttributes)) {
                                    v6 = false;
                                }

                                this.val$layoutResultCallback.onLayoutFinished(v0_2, v6);
                            }
                            else {
                                this.val$layoutResultCallback.onLayoutFailed(((CharSequence)v7));
                            }

                            this.this$1.mLoadBitmap = v7;
                        }

                        protected void onPostExecute(Object arg1) {
                            this.onPostExecute(((Bitmap)arg1));
                        }

                        protected void onPreExecute() {
                            this.val$cancellationSignal.setOnCancelListener(new CancellationSignal$OnCancelListener() {
                                public void onCancel() {
                                    this.this$2.this$1.cancelLoad();
                                    this.this$2.cancel(false);
                                }
                            });
                        }
                    }.execute(new Uri[0]);
                }
            }

            public void onWrite(PageRange[] arg8, ParcelFileDescriptor arg9, CancellationSignal arg10, PrintDocumentAdapter$WriteResultCallback arg11) {
                PrintHelperKitkat.this.writeBitmap(this.mAttributes, this.val$fittingMode, this.mBitmap, arg9, arg10, arg11);
            }
        };
        Object v1 = this.mContext.getSystemService("print");
        PrintAttributes$Builder v2 = new PrintAttributes$Builder();
        v2.setColorMode(this.mColorMode);
        if(this.mOrientation == 1 || this.mOrientation == 0) {
            v2.setMediaSize(PrintAttributes$MediaSize.UNKNOWN_LANDSCAPE);
        }
        else if(this.mOrientation == 2) {
            v2.setMediaSize(PrintAttributes$MediaSize.UNKNOWN_PORTRAIT);
        }

        ((PrintManager)v1).print(arg7, ((PrintDocumentAdapter)v0), v2.build());
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

    private void writeBitmap(PrintAttributes arg10, int arg11, Bitmap arg12, ParcelFileDescriptor arg13, CancellationSignal arg14, PrintDocumentAdapter$WriteResultCallback arg15) {
        PrintAttributes v3 = this.mIsMinMarginsHandlingCorrect ? arg10 : this.copyAttributes(arg10).setMinMargins(new PrintAttributes$Margins(0, 0, 0, 0)).build();
        new AsyncTask(arg14, v3, arg12, arg10, arg11, arg13, arg15) {
            protected Object doInBackground(Object[] arg2) {
                return this.doInBackground(((Void[])arg2));
            }

            protected Throwable doInBackground(Void[] arg10) {
                RectF v1;
                Bitmap v3;
                PrintedPdfDocument v2;
                Throwable v0 = null;
                try {
                    if(this.val$cancellationSignal.isCanceled()) {
                        return v0;
                    }

                    v2 = new PrintedPdfDocument(PrintHelperKitkat.this.mContext, this.val$pdfAttributes);
                    v3 = PrintHelperKitkat.this.convertBitmapForColorMode(this.val$bitmap, this.val$pdfAttributes.getColorMode());
                    if(this.val$cancellationSignal.isCanceled()) {
                        return v0;
                    }
                }
                catch(Throwable v0) {
                    goto label_52;
                }

                try {
                    PdfDocument$Page v4 = v2.startPage(1);
                    if(PrintHelperKitkat.this.mIsMinMarginsHandlingCorrect) {
                        v1 = new RectF(v4.getInfo().getContentRect());
                    }
                    else {
                        PrintedPdfDocument v5 = new PrintedPdfDocument(PrintHelperKitkat.this.mContext, this.val$attributes);
                        PdfDocument$Page v6 = v5.startPage(1);
                        v1 = new RectF(v6.getInfo().getContentRect());
                        v5.finishPage(v6);
                        v5.close();
                    }

                    Matrix v5_1 = PrintHelperKitkat.this.getMatrix(v3.getWidth(), v3.getHeight(), v1, this.val$fittingMode);
                    if(!PrintHelperKitkat.this.mIsMinMarginsHandlingCorrect) {
                        v5_1.postTranslate(v1.left, v1.top);
                        v4.getCanvas().clipRect(v1);
                    }

                    v4.getCanvas().drawBitmap(v3, v5_1, null);
                    v2.finishPage(v4);
                    if(!this.val$cancellationSignal.isCanceled()) {
                        goto label_83;
                    }
                }
                catch(Throwable v0) {
                    goto label_68;
                }

                try {
                    v2.close();
                    if(this.val$fileDescriptor == null) {
                        goto label_47;
                    }

                    try {
                        this.val$fileDescriptor.close();
                        goto label_47;
                    }
                    catch(IOException v1_1) {
                        goto label_102;
                    }
                }
                catch(Throwable v0) {
                    goto label_52;
                }

                try {
                label_83:
                    v2.writeTo(new FileOutputStream(this.val$fileDescriptor.getFileDescriptor()));
                }
                catch(Throwable v0) {
                    goto label_68;
                }

                try {
                    v2.close();
                    if(this.val$fileDescriptor == null) {
                        goto label_93;
                    }

                    try {
                        this.val$fileDescriptor.close();
                    }
                    catch(IOException v1_1) {
                    }

                    goto label_93;
                }
                catch(Throwable v0) {
                    goto label_52;
                }

            label_102:
                try {
                label_47:
                    if(v3 == this.val$bitmap) {
                        return v0;
                    }

                    v3.recycle();
                    return v0;
                }
                catch(Throwable v0) {
                    goto label_52;
                }

                try {
                label_68:
                    v2.close();
                    if(this.val$fileDescriptor == null) {
                        goto label_73;
                    }

                    try {
                        this.val$fileDescriptor.close();
                        goto label_73;
                    }
                    catch(IOException v1_1) {
                        goto label_98;
                    }
                }
                catch(Throwable v0) {
                    goto label_52;
                }

                try {
                label_93:
                    if(v3 == this.val$bitmap) {
                        return v0;
                    }

                    v3.recycle();
                    return v0;
                }
                catch(Throwable v0) {
                    goto label_52;
                }

            label_98:
                try {
                label_73:
                    if(v3 != this.val$bitmap) {
                        v3.recycle();
                    }

                    throw v0;
                }
                catch(Throwable v0) {
                label_52:
                }

                return v0;
            }

            protected void onPostExecute(Object arg1) {
                this.onPostExecute(((Throwable)arg1));
            }

            protected void onPostExecute(Throwable arg5) {
                if(this.val$cancellationSignal.isCanceled()) {
                    this.val$writeResultCallback.onWriteCancelled();
                }
                else if(arg5 == null) {
                    this.val$writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                }
                else {
                    Log.e("PrintHelperKitkat", "Error writing printed content", arg5);
                    this.val$writeResultCallback.onWriteFailed(null);
                }
            }
        }.execute(new Void[0]);
    }
}

