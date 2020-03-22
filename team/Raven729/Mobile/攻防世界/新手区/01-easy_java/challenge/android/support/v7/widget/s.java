package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.c.a.b;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class s {
    private static final int[] a;
    private final ProgressBar b;
    private Bitmap c;

    static {
        s.a = new int[]{0x101013B, 0x101013C};
    }

    s(ProgressBar arg1) {
        super();
        this.b = arg1;
    }

    private Drawable a(Drawable arg7) {
        AnimationDrawable v7;
        int v5 = 10000;
        if((arg7 instanceof AnimationDrawable)) {
            int v2 = ((AnimationDrawable)arg7).getNumberOfFrames();
            AnimationDrawable v0 = new AnimationDrawable();
            v0.setOneShot(((AnimationDrawable)arg7).isOneShot());
            int v1;
            for(v1 = 0; v1 < v2; ++v1) {
                Drawable v3 = this.a(((AnimationDrawable)arg7).getFrame(v1), true);
                v3.setLevel(v5);
                v0.addFrame(v3, ((AnimationDrawable)arg7).getDuration(v1));
            }

            v0.setLevel(v5);
            v7 = v0;
        }

        return ((Drawable)v7);
    }

    private Drawable a(Drawable arg9, boolean arg10) {
        Drawable v0;
        int v1 = 0;
        if((arg9 instanceof b)) {
            v0 = arg9.a();
            if(v0 != null) {
                arg9.a(this.a(v0, arg10));
            }
            else {
            }

            goto label_10;
        }
        else if((arg9 instanceof LayerDrawable)) {
            int v4 = ((LayerDrawable)arg9).getNumberOfLayers();
            Drawable[] v5 = new Drawable[v4];
            int v3;
            for(v3 = 0; v3 < v4; ++v3) {
                int v0_1 = ((LayerDrawable)arg9).getId(v3);
                Drawable v6 = ((LayerDrawable)arg9).getDrawable(v3);
                boolean v0_2 = v0_1 == 0x102000D || v0_1 == 0x102000F ? true : false;
                v5[v3] = this.a(v6, v0_2);
            }

            LayerDrawable v0_3 = new LayerDrawable(v5);
            while(v1 < v4) {
                v0_3.setId(v1, ((LayerDrawable)arg9).getId(v1));
                ++v1;
            }
        }
        else {
            if((arg9 instanceof BitmapDrawable)) {
                Bitmap v0_4 = ((BitmapDrawable)arg9).getBitmap();
                if(this.c == null) {
                    this.c = v0_4;
                }

                ShapeDrawable v1_1 = new ShapeDrawable(this.b());
                v1_1.getPaint().setShader(new BitmapShader(v0_4, Shader$TileMode.REPEAT, Shader$TileMode.CLAMP));
                v1_1.getPaint().setColorFilter(((BitmapDrawable)arg9).getPaint().getColorFilter());
                if(arg10) {
                    ClipDrawable v0_5 = new ClipDrawable(((Drawable)v1_1), 3, 1);
                    return v0;
                }

                ShapeDrawable v0_6 = v1_1;
                return v0;
            }

        label_10:
            v0 = arg9;
        }

        return v0;
    }

    Bitmap a() {
        return this.c;
    }

    void a(AttributeSet arg5, int arg6) {
        aw v0 = aw.a(this.b.getContext(), arg5, s.a, arg6, 0);
        Drawable v1 = v0.b(0);
        if(v1 != null) {
            this.b.setIndeterminateDrawable(this.a(v1));
        }

        v1 = v0.b(1);
        if(v1 != null) {
            this.b.setProgressDrawable(this.a(v1, false));
        }

        v0.a();
    }

    private Shape b() {
        return new RoundRectShape(new float[]{5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f}, null, null);
    }
}

