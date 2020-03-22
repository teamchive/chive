package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.support.v4.graphics.BitmapCompat;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import java.io.InputStream;

public final class RoundedBitmapDrawableFactory {
    class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        DefaultRoundedBitmapDrawable(Resources arg1, Bitmap arg2) {
            super(arg1, arg2);
        }

        void gravityCompatApply(int arg7, int arg8, int arg9, Rect arg10, Rect arg11) {
            GravityCompat.apply(arg7, arg8, arg9, arg10, arg11, 0);
        }

        public boolean hasMipMap() {
            boolean v0 = this.mBitmap == null || !BitmapCompat.hasMipMap(this.mBitmap) ? false : true;
            return v0;
        }

        public void setMipMap(boolean arg2) {
            if(this.mBitmap != null) {
                BitmapCompat.setHasMipMap(this.mBitmap, arg2);
                this.invalidateSelf();
            }
        }
    }

    private static final String TAG = "RoundedBitmapDrawableFactory";

    private RoundedBitmapDrawableFactory() {
        super();
    }

    public static RoundedBitmapDrawable create(Resources arg2, Bitmap arg3) {
        RoundedBitmapDrawable21 v0;
        if(Build$VERSION.SDK_INT >= 21) {
            v0 = new RoundedBitmapDrawable21(arg2, arg3);
        }
        else {
            DefaultRoundedBitmapDrawable v0_1 = new DefaultRoundedBitmapDrawable(arg2, arg3);
        }

        return ((RoundedBitmapDrawable)v0);
    }

    public static RoundedBitmapDrawable create(Resources arg4, InputStream arg5) {
        RoundedBitmapDrawable v0 = RoundedBitmapDrawableFactory.create(arg4, BitmapFactory.decodeStream(arg5));
        if(v0.getBitmap() == null) {
            Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + arg5);
        }

        return v0;
    }

    public static RoundedBitmapDrawable create(Resources arg4, String arg5) {
        RoundedBitmapDrawable v0 = RoundedBitmapDrawableFactory.create(arg4, BitmapFactory.decodeFile(arg5));
        if(v0.getBitmap() == null) {
            Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + arg5);
        }

        return v0;
    }
}

