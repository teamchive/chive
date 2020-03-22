package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build$VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Animation$AnimationListener;
import android.widget.ImageView;

class CircleImageView extends ImageView {
    class OvalShadow extends OvalShape {
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint;

        OvalShadow(CircleImageView arg2, int arg3) {
            CircleImageView.this = arg2;
            super();
            this.mShadowPaint = new Paint();
            arg2.mShadowRadius = arg3;
            this.updateRadialGradient(((int)this.rect().width()));
        }

        public void draw(Canvas arg7, Paint arg8) {
            int v0 = CircleImageView.this.getWidth();
            int v1 = CircleImageView.this.getHeight();
            arg7.drawCircle(((float)(v0 / 2)), ((float)(v1 / 2)), ((float)(v0 / 2)), this.mShadowPaint);
            arg7.drawCircle(((float)(v0 / 2)), ((float)(v1 / 2)), ((float)(v0 / 2 - CircleImageView.this.mShadowRadius)), arg8);
        }

        protected void onResize(float arg2, float arg3) {
            super.onResize(arg2, arg3);
            this.updateRadialGradient(((int)arg2));
        }

        private void updateRadialGradient(int arg8) {
            this.mRadialGradient = new RadialGradient(((float)(arg8 / 2)), ((float)(arg8 / 2)), ((float)CircleImageView.this.mShadowRadius), new int[]{0x3D000000, 0}, null, Shader$TileMode.CLAMP);
            this.mShadowPaint.setShader(this.mRadialGradient);
        }
    }

    private static final int FILL_SHADOW_COLOR = 0x3D000000;
    private static final int KEY_SHADOW_COLOR = 0x1E000000;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final float X_OFFSET = 0f;
    private static final float Y_OFFSET = 1.75f;
    private Animation$AnimationListener mListener;
    int mShadowRadius;

    CircleImageView(Context arg7, int arg8) {
        ShapeDrawable v0;
        super(arg7);
        float v1 = this.getContext().getResources().getDisplayMetrics().density;
        int v2 = ((int)(1.75f * v1));
        int v3 = ((int)(0f * v1));
        this.mShadowRadius = ((int)(3.5f * v1));
        if(this.elevationSupported()) {
            v0 = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(((View)this), v1 * 4f);
        }
        else {
            v0 = new ShapeDrawable(new OvalShadow(this, this.mShadowRadius));
            ViewCompat.setLayerType(((View)this), 1, v0.getPaint());
            v0.getPaint().setShadowLayer(((float)this.mShadowRadius), ((float)v3), ((float)v2), 0x1E000000);
            this.setPadding(this.mShadowRadius, this.mShadowRadius, this.mShadowRadius, this.mShadowRadius);
        }

        v0.getPaint().setColor(arg8);
        ViewCompat.setBackground(((View)this), ((Drawable)v0));
    }

    private boolean elevationSupported() {
        boolean v0 = Build$VERSION.SDK_INT >= 21 ? true : false;
        return v0;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if(this.mListener != null) {
            this.mListener.onAnimationEnd(this.getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if(this.mListener != null) {
            this.mListener.onAnimationStart(this.getAnimation());
        }
    }

    protected void onMeasure(int arg4, int arg5) {
        super.onMeasure(arg4, arg5);
        if(!this.elevationSupported()) {
            this.setMeasuredDimension(this.getMeasuredWidth() + this.mShadowRadius * 2, this.getMeasuredHeight() + this.mShadowRadius * 2);
        }
    }

    public void setAnimationListener(Animation$AnimationListener arg1) {
        this.mListener = arg1;
    }

    public void setBackgroundColor(int arg2) {
        if((this.getBackground() instanceof ShapeDrawable)) {
            this.getBackground().getPaint().setColor(arg2);
        }
    }

    public void setBackgroundColorRes(int arg2) {
        this.setBackgroundColor(ContextCompat.getColor(this.getContext(), arg2));
    }
}

