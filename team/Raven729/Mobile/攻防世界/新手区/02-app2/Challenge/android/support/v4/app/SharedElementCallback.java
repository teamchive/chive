package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView$ScaleType;
import android.widget.ImageView;
import java.util.List;
import java.util.Map;

public abstract class SharedElementCallback {
    public interface OnSharedElementsReadyListener {
        void onSharedElementsReady();
    }

    private static final String BUNDLE_SNAPSHOT_BITMAP = "sharedElement:snapshot:bitmap";
    private static final String BUNDLE_SNAPSHOT_IMAGE_MATRIX = "sharedElement:snapshot:imageMatrix";
    private static final String BUNDLE_SNAPSHOT_IMAGE_SCALETYPE = "sharedElement:snapshot:imageScaleType";
    private static int MAX_IMAGE_SIZE;
    private Matrix mTempMatrix;

    static {
        SharedElementCallback.MAX_IMAGE_SIZE = 0x100000;
    }

    public SharedElementCallback() {
        super();
    }

    private static Bitmap createDrawableBitmap(Drawable arg9) {
        Bitmap v0_1;
        float v4 = 1f;
        int v0 = arg9.getIntrinsicWidth();
        int v1 = arg9.getIntrinsicHeight();
        if(v0 <= 0 || v1 <= 0) {
            v0_1 = null;
        }
        else {
            float v2 = Math.min(v4, (((float)SharedElementCallback.MAX_IMAGE_SIZE)) / (((float)(v0 * v1))));
            if(((arg9 instanceof BitmapDrawable)) && v2 == v4) {
                v0_1 = ((BitmapDrawable)arg9).getBitmap();
                return v0_1;
            }

            int v3 = ((int)((((float)v0)) * v2));
            v1 = ((int)((((float)v1)) * v2));
            v0_1 = Bitmap.createBitmap(v3, v1, Bitmap$Config.ARGB_8888);
            Canvas v2_1 = new Canvas(v0_1);
            Rect v4_1 = arg9.getBounds();
            int v5 = v4_1.left;
            int v6 = v4_1.top;
            int v7 = v4_1.right;
            int v4_2 = v4_1.bottom;
            arg9.setBounds(0, 0, v3, v1);
            arg9.draw(v2_1);
            arg9.setBounds(v5, v6, v7, v4_2);
        }

        return v0_1;
    }

    public Parcelable onCaptureSharedElementSnapshot(View arg7, Matrix arg8, RectF arg9) {
        Bundle v0_2;
        if((arg7 instanceof ImageView)) {
            View v0 = arg7;
            Drawable v1 = ((ImageView)v0).getDrawable();
            Drawable v2 = ((ImageView)v0).getBackground();
            if(v1 == null) {
                goto label_28;
            }
            else if(v2 == null) {
                Bitmap v2_1 = SharedElementCallback.createDrawableBitmap(v1);
                if(v2_1 != null) {
                    Bundle v1_1 = new Bundle();
                    v1_1.putParcelable("sharedElement:snapshot:bitmap", ((Parcelable)v2_1));
                    v1_1.putString("sharedElement:snapshot:imageScaleType", ((ImageView)v0).getScaleType().toString());
                    if(((ImageView)v0).getScaleType() == ImageView$ScaleType.MATRIX) {
                        Matrix v0_1 = ((ImageView)v0).getImageMatrix();
                        float[] v2_2 = new float[9];
                        v0_1.getValues(v2_2);
                        v1_1.putFloatArray("sharedElement:snapshot:imageMatrix", v2_2);
                    }

                    v0_2 = v1_1;
                }
                else {
                    goto label_28;
                }
            }
            else {
                goto label_28;
            }
        }
        else {
        label_28:
            int v1_2 = Math.round(arg9.width());
            int v2_3 = Math.round(arg9.height());
            Parcelable v0_3 = null;
            if(v1_2 <= 0) {
                goto label_27;
            }

            if(v2_3 <= 0) {
                goto label_27;
            }

            float v0_4 = Math.min(1f, (((float)SharedElementCallback.MAX_IMAGE_SIZE)) / (((float)(v1_2 * v2_3))));
            v1_2 = ((int)((((float)v1_2)) * v0_4));
            v2_3 = ((int)((((float)v2_3)) * v0_4));
            if(this.mTempMatrix == null) {
                this.mTempMatrix = new Matrix();
            }

            this.mTempMatrix.set(arg8);
            this.mTempMatrix.postTranslate(-arg9.left, -arg9.top);
            this.mTempMatrix.postScale(v0_4, v0_4);
            Bitmap v0_5 = Bitmap.createBitmap(v1_2, v2_3, Bitmap$Config.ARGB_8888);
            Canvas v1_3 = new Canvas(v0_5);
            v1_3.concat(this.mTempMatrix);
            arg7.draw(v1_3);
        }

    label_27:
        return ((Parcelable)v0_2);
    }

    public View onCreateSnapshotView(Context arg4, Parcelable arg5) {
        ImageView v0_2;
        ImageView v1_1;
        View v1 = null;
        if((arg5 instanceof Bundle)) {
            Parcelable v0 = ((Bundle)arg5).getParcelable("sharedElement:snapshot:bitmap");
            if(v0 != null) {
                v1_1 = new ImageView(arg4);
                v1_1.setImageBitmap(((Bitmap)v0));
                v1_1.setScaleType(ImageView$ScaleType.valueOf(((Bundle)arg5).getString("sharedElement:snapshot:imageScaleType")));
                if(v1_1.getScaleType() == ImageView$ScaleType.MATRIX) {
                    float[] v0_1 = ((Bundle)arg5).getFloatArray("sharedElement:snapshot:imageMatrix");
                    Matrix v2 = new Matrix();
                    v2.setValues(v0_1);
                    v1_1.setImageMatrix(v2);
                }

                v0_2 = v1_1;
                goto label_24;
            }
        }
        else {
            if((arg5 instanceof Bitmap)) {
                v0_2 = new ImageView(arg4);
                v0_2.setImageBitmap(((Bitmap)arg5));
            }
            else {
                v0_2 = ((ImageView)v1);
            }

        label_24:
            v1_1 = v0_2;
        }

        return ((View)v1_1);
    }

    public void onMapSharedElements(List arg1, Map arg2) {
    }

    public void onRejectSharedElements(List arg1) {
    }

    public void onSharedElementEnd(List arg1, List arg2, List arg3) {
    }

    public void onSharedElementStart(List arg1, List arg2, List arg3) {
    }

    public void onSharedElementsArrived(List arg1, List arg2, OnSharedElementsReadyListener arg3) {
        arg3.onSharedElementsReady();
    }
}

