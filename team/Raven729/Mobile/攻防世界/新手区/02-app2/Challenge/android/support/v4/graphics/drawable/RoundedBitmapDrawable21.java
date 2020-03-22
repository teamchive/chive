package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.view.Gravity;

@TargetApi(value=21) @RequiresApi(value=21) class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
    protected RoundedBitmapDrawable21(Resources arg1, Bitmap arg2) {
        super(arg1, arg2);
    }

    public void getOutline(Outline arg3) {
        this.updateDstRect();
        arg3.setRoundRect(this.mDstRect, this.getCornerRadius());
    }

    void gravityCompatApply(int arg7, int arg8, int arg9, Rect arg10, Rect arg11) {
        Gravity.apply(arg7, arg8, arg9, arg10, arg11, 0);
    }

    public boolean hasMipMap() {
        boolean v0 = this.mBitmap == null || !this.mBitmap.hasMipMap() ? false : true;
        return v0;
    }

    public void setMipMap(boolean arg2) {
        if(this.mBitmap != null) {
            this.mBitmap.setHasMipMap(arg2);
            this.invalidateSelf();
        }
    }
}

