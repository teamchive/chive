package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path$FillType;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.Animation$AnimationListener;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

class MaterialProgressDrawable extends Drawable implements Animatable {
    class android.support.v4.widget.MaterialProgressDrawable$3 implements Drawable$Callback {
        android.support.v4.widget.MaterialProgressDrawable$3(MaterialProgressDrawable arg1) {
            MaterialProgressDrawable.this = arg1;
            super();
        }

        public void invalidateDrawable(Drawable arg2) {
            MaterialProgressDrawable.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable arg2, Runnable arg3, long arg4) {
            MaterialProgressDrawable.this.scheduleSelf(arg3, arg4);
        }

        public void unscheduleDrawable(Drawable arg2, Runnable arg3) {
            MaterialProgressDrawable.this.unscheduleSelf(arg3);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ProgressDrawableSize {
    }

    class Ring {
        private int mAlpha;
        private Path mArrow;
        private int mArrowHeight;
        private final Paint mArrowPaint;
        private float mArrowScale;
        private int mArrowWidth;
        private int mBackgroundColor;
        private final Drawable$Callback mCallback;
        private final Paint mCirclePaint;
        private int mColorIndex;
        private int[] mColors;
        private int mCurrentColor;
        private float mEndTrim;
        private final Paint mPaint;
        private double mRingCenterRadius;
        private float mRotation;
        private boolean mShowArrow;
        private float mStartTrim;
        private float mStartingEndTrim;
        private float mStartingRotation;
        private float mStartingStartTrim;
        private float mStrokeInset;
        private float mStrokeWidth;
        private final RectF mTempBounds;

        Ring(Drawable$Callback arg4) {
            super();
            this.mTempBounds = new RectF();
            this.mPaint = new Paint();
            this.mArrowPaint = new Paint();
            this.mStartTrim = 0f;
            this.mEndTrim = 0f;
            this.mRotation = 0f;
            this.mStrokeWidth = 5f;
            this.mStrokeInset = 2.5f;
            this.mCirclePaint = new Paint(1);
            this.mCallback = arg4;
            this.mPaint.setStrokeCap(Paint$Cap.SQUARE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint$Style.STROKE);
            this.mArrowPaint.setStyle(Paint$Style.FILL);
            this.mArrowPaint.setAntiAlias(true);
        }

        public void draw(Canvas arg7, Rect arg8) {
            RectF v1 = this.mTempBounds;
            v1.set(arg8);
            v1.inset(this.mStrokeInset, this.mStrokeInset);
            float v2 = (this.mStartTrim + this.mRotation) * 360f;
            float v3 = (this.mEndTrim + this.mRotation) * 360f - v2;
            this.mPaint.setColor(this.mCurrentColor);
            arg7.drawArc(v1, v2, v3, false, this.mPaint);
            this.drawTriangle(arg7, v2, v3, arg8);
            if(this.mAlpha < 0xFF) {
                this.mCirclePaint.setColor(this.mBackgroundColor);
                this.mCirclePaint.setAlpha(0xFF - this.mAlpha);
                arg7.drawCircle(arg8.exactCenterX(), arg8.exactCenterY(), ((float)(arg8.width() / 2)), this.mCirclePaint);
            }
        }

        private void drawTriangle(Canvas arg11, float arg12, float arg13, Rect arg14) {
            double v8 = 0;
            if(this.mShowArrow) {
                if(this.mArrow == null) {
                    this.mArrow = new Path();
                    this.mArrow.setFillType(Path$FillType.EVEN_ODD);
                }
                else {
                    this.mArrow.reset();
                }

                float v0 = (((float)((((int)this.mStrokeInset)) / 2))) * this.mArrowScale;
                float v1 = ((float)(this.mRingCenterRadius * Math.cos(v8) + (((double)arg14.exactCenterX()))));
                float v2 = ((float)(this.mRingCenterRadius * Math.sin(v8) + (((double)arg14.exactCenterY()))));
                this.mArrow.moveTo(0f, 0f);
                this.mArrow.lineTo((((float)this.mArrowWidth)) * this.mArrowScale, 0f);
                this.mArrow.lineTo((((float)this.mArrowWidth)) * this.mArrowScale / 2f, (((float)this.mArrowHeight)) * this.mArrowScale);
                this.mArrow.offset(v1 - v0, v2);
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mCurrentColor);
                arg11.rotate(arg12 + arg13 - 5f, arg14.exactCenterX(), arg14.exactCenterY());
                arg11.drawPath(this.mArrow, this.mArrowPaint);
            }
        }

        public int getAlpha() {
            return this.mAlpha;
        }

        public double getCenterRadius() {
            return this.mRingCenterRadius;
        }

        public float getEndTrim() {
            return this.mEndTrim;
        }

        public float getInsets() {
            return this.mStrokeInset;
        }

        public int getNextColor() {
            return this.mColors[this.getNextColorIndex()];
        }

        private int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        public float getRotation() {
            return this.mRotation;
        }

        public float getStartTrim() {
            return this.mStartTrim;
        }

        public int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        public float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        public float getStartingRotation() {
            return this.mStartingRotation;
        }

        public float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public void goToNextColor() {
            this.setColorIndex(this.getNextColorIndex());
        }

        private void invalidateSelf() {
            this.mCallback.invalidateDrawable(null);
        }

        public void resetOriginals() {
            this.mStartingStartTrim = 0f;
            this.mStartingEndTrim = 0f;
            this.mStartingRotation = 0f;
            this.setStartTrim(0f);
            this.setEndTrim(0f);
            this.setRotation(0f);
        }

        public void setAlpha(int arg1) {
            this.mAlpha = arg1;
        }

        public void setArrowDimensions(float arg2, float arg3) {
            this.mArrowWidth = ((int)arg2);
            this.mArrowHeight = ((int)arg3);
        }

        public void setArrowScale(float arg2) {
            if(arg2 != this.mArrowScale) {
                this.mArrowScale = arg2;
                this.invalidateSelf();
            }
        }

        public void setBackgroundColor(int arg1) {
            this.mBackgroundColor = arg1;
        }

        public void setCenterRadius(double arg2) {
            this.mRingCenterRadius = arg2;
        }

        public void setColor(int arg1) {
            this.mCurrentColor = arg1;
        }

        public void setColorFilter(ColorFilter arg2) {
            this.mPaint.setColorFilter(arg2);
            this.invalidateSelf();
        }

        public void setColorIndex(int arg3) {
            this.mColorIndex = arg3;
            this.mCurrentColor = this.mColors[this.mColorIndex];
        }

        public void setColors(@NonNull int[] arg2) {
            this.mColors = arg2;
            this.setColorIndex(0);
        }

        public void setEndTrim(float arg1) {
            this.mEndTrim = arg1;
            this.invalidateSelf();
        }

        public void setInsets(int arg8, int arg9) {
            float v6 = 2f;
            float v0 = ((float)Math.min(arg8, arg9));
            v0 = this.mRingCenterRadius <= 0 || v0 < 0f ? ((float)Math.ceil(((double)(this.mStrokeWidth / v6)))) : ((float)((((double)(v0 / v6))) - this.mRingCenterRadius));
            this.mStrokeInset = v0;
        }

        public void setRotation(float arg1) {
            this.mRotation = arg1;
            this.invalidateSelf();
        }

        public void setShowArrow(boolean arg2) {
            if(this.mShowArrow != arg2) {
                this.mShowArrow = arg2;
                this.invalidateSelf();
            }
        }

        public void setStartTrim(float arg1) {
            this.mStartTrim = arg1;
            this.invalidateSelf();
        }

        public void setStrokeWidth(float arg2) {
            this.mStrokeWidth = arg2;
            this.mPaint.setStrokeWidth(arg2);
            this.invalidateSelf();
        }

        public void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }
    }

    private static final int ANIMATION_DURATION = 0x534;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final float ARROW_OFFSET_ANGLE = 5f;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 8.75f;
    private static final float CENTER_RADIUS_LARGE = 12.5f;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final int[] COLORS = null;
    private static final float COLOR_START_DELAY_OFFSET = 0.75f;
    static final int DEFAULT = 1;
    private static final float END_TRIM_START_DELAY_OFFSET = 0.5f;
    private static final float FULL_ROTATION = 1080f;
    static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR = null;
    static final Interpolator MATERIAL_INTERPOLATOR = null;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float NUM_POINTS = 5f;
    private static final float START_TRIM_DURATION_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3f;
    private Animation mAnimation;
    private final ArrayList mAnimators;
    private final Drawable$Callback mCallback;
    boolean mFinishing;
    private double mHeight;
    private View mParent;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    float mRotationCount;
    private double mWidth;

    static {
        MaterialProgressDrawable.LINEAR_INTERPOLATOR = new LinearInterpolator();
        MaterialProgressDrawable.MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
        MaterialProgressDrawable.COLORS = new int[]{0xFF000000};
    }

    MaterialProgressDrawable(Context arg3, View arg4) {
        super();
        this.mAnimators = new ArrayList();
        this.mCallback = new android.support.v4.widget.MaterialProgressDrawable$3(this);
        this.mParent = arg4;
        this.mResources = arg3.getResources();
        this.mRing = new Ring(this.mCallback);
        this.mRing.setColors(MaterialProgressDrawable.COLORS);
        this.updateSizes(1);
        this.setupAnimators();
    }

    void applyFinishTranslation(float arg5, Ring arg6) {
        this.updateRingColor(arg5, arg6);
        float v0 = ((float)(Math.floor(((double)(arg6.getStartingRotation() / 0.8f))) + 1));
        arg6.setStartTrim((arg6.getStartingEndTrim() - this.getMinProgressArc(arg6) - arg6.getStartingStartTrim()) * arg5 + arg6.getStartingStartTrim());
        arg6.setEndTrim(arg6.getStartingEndTrim());
        arg6.setRotation((v0 - arg6.getStartingRotation()) * arg5 + arg6.getStartingRotation());
    }

    public void draw(Canvas arg6) {
        Rect v0 = this.getBounds();
        int v1 = arg6.save();
        arg6.rotate(this.mRotation, v0.exactCenterX(), v0.exactCenterY());
        this.mRing.draw(arg6, v0);
        arg6.restoreToCount(v1);
    }

    private int evaluateColorChange(float arg9, int arg10, int arg11) {
        int v0 = Integer.valueOf(arg10).intValue();
        int v1 = v0 >> 24 & 0xFF;
        int v2 = v0 >> 16 & 0xFF;
        int v3 = v0 >> 8 & 0xFF;
        v0 &= 0xFF;
        int v4 = Integer.valueOf(arg11).intValue();
        return v0 + (((int)((((float)((v4 & 0xFF) - v0))) * arg9))) | (v1 + (((int)((((float)((v4 >> 24 & 0xFF) - v1))) * arg9))) << 24 | v2 + (((int)((((float)((v4 >> 16 & 0xFF) - v2))) * arg9))) << 16 | (((int)((((float)((v4 >> 8 & 0xFF) - v3))) * arg9))) + v3 << 8);
    }

    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    public int getIntrinsicHeight() {
        return ((int)this.mHeight);
    }

    public int getIntrinsicWidth() {
        return ((int)this.mWidth);
    }

    float getMinProgressArc(Ring arg7) {
        return ((float)Math.toRadians((((double)arg7.getStrokeWidth())) / (6.283185 * arg7.getCenterRadius())));
    }

    public int getOpacity() {
        return -3;
    }

    private float getRotation() {
        return this.mRotation;
    }

    public boolean isRunning() {
        ArrayList v3 = this.mAnimators;
        int v4 = v3.size();
        int v2;
        for(v2 = 0; v2 < v4; ++v2) {
            Object v0 = v3.get(v2);
            if((((Animation)v0).hasStarted()) && !((Animation)v0).hasEnded()) {
                boolean v0_1 = true;
                return v0_1;
            }
        }

        return false;
    }

    public void setAlpha(int arg2) {
        this.mRing.setAlpha(arg2);
    }

    public void setArrowScale(float arg2) {
        this.mRing.setArrowScale(arg2);
    }

    public void setBackgroundColor(int arg2) {
        this.mRing.setBackgroundColor(arg2);
    }

    public void setColorFilter(ColorFilter arg2) {
        this.mRing.setColorFilter(arg2);
    }

    public void setColorSchemeColors(int[] arg3) {
        this.mRing.setColors(arg3);
        this.mRing.setColorIndex(0);
    }

    public void setProgressRotation(float arg2) {
        this.mRing.setRotation(arg2);
    }

    void setRotation(float arg1) {
        this.mRotation = arg1;
        this.invalidateSelf();
    }

    private void setSizeParameters(double arg6, double arg8, double arg10, double arg12, float arg14, float arg15) {
        Ring v0 = this.mRing;
        float v1 = this.mResources.getDisplayMetrics().density;
        this.mWidth = (((double)v1)) * arg6;
        this.mHeight = (((double)v1)) * arg8;
        v0.setStrokeWidth((((float)arg12)) * v1);
        v0.setCenterRadius((((double)v1)) * arg10);
        v0.setColorIndex(0);
        v0.setArrowDimensions(arg14 * v1, v1 * arg15);
        v0.setInsets(((int)this.mWidth), ((int)this.mHeight));
    }

    public void setStartEndTrim(float arg2, float arg3) {
        this.mRing.setStartTrim(arg2);
        this.mRing.setEndTrim(arg3);
    }

    private void setupAnimators() {
        Ring v0 = this.mRing;
        android.support.v4.widget.MaterialProgressDrawable$1 v1 = new Animation(v0) {
            public void applyTransformation(float arg10, Transformation arg11) {
                float v8 = 0.8f;
                float v7 = 0.5f;
                if(MaterialProgressDrawable.this.mFinishing) {
                    MaterialProgressDrawable.this.applyFinishTranslation(arg10, this.val$ring);
                }
                else {
                    float v0 = MaterialProgressDrawable.this.getMinProgressArc(this.val$ring);
                    float v1 = this.val$ring.getStartingEndTrim();
                    float v2 = this.val$ring.getStartingStartTrim();
                    float v3 = this.val$ring.getStartingRotation();
                    MaterialProgressDrawable.this.updateRingColor(arg10, this.val$ring);
                    if(arg10 <= v7) {
                        this.val$ring.setStartTrim(v2 + MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation(arg10 / v7) * (v8 - v0));
                    }

                    if(arg10 > v7) {
                        this.val$ring.setEndTrim((v8 - v0) * MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation((arg10 - v7) / v7) + v1);
                    }

                    this.val$ring.setRotation(0.25f * arg10 + v3);
                    MaterialProgressDrawable.this.setRotation(216f * arg10 + 1080f * (MaterialProgressDrawable.this.mRotationCount / 5f));
                }
            }
        };
        ((Animation)v1).setRepeatCount(-1);
        ((Animation)v1).setRepeatMode(1);
        ((Animation)v1).setInterpolator(MaterialProgressDrawable.LINEAR_INTERPOLATOR);
        ((Animation)v1).setAnimationListener(new Animation$AnimationListener(v0) {
            public void onAnimationEnd(Animation arg1) {
            }

            public void onAnimationRepeat(Animation arg4) {
                this.val$ring.storeOriginals();
                this.val$ring.goToNextColor();
                this.val$ring.setStartTrim(this.val$ring.getEndTrim());
                if(MaterialProgressDrawable.this.mFinishing) {
                    MaterialProgressDrawable.this.mFinishing = false;
                    arg4.setDuration(0x534);
                    this.val$ring.setShowArrow(false);
                }
                else {
                    MaterialProgressDrawable.this.mRotationCount = (MaterialProgressDrawable.this.mRotationCount + 1f) % 5f;
                }
            }

            public void onAnimationStart(Animation arg3) {
                MaterialProgressDrawable.this.mRotationCount = 0f;
            }
        });
        this.mAnimation = ((Animation)v1);
    }

    public void showArrow(boolean arg2) {
        this.mRing.setShowArrow(arg2);
    }

    public void start() {
        this.mAnimation.reset();
        this.mRing.storeOriginals();
        if(this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
            this.mFinishing = true;
            this.mAnimation.setDuration(666);
            this.mParent.startAnimation(this.mAnimation);
        }
        else {
            this.mRing.setColorIndex(0);
            this.mRing.resetOriginals();
            this.mAnimation.setDuration(0x534);
            this.mParent.startAnimation(this.mAnimation);
        }
    }

    public void stop() {
        this.mParent.clearAnimation();
        this.setRotation(0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
    }

    void updateRingColor(float arg4, Ring arg5) {
        float v1 = 0.75f;
        if(arg4 > v1) {
            arg5.setColor(this.evaluateColorChange((arg4 - v1) / 0.25f, arg5.getStartingColor(), arg5.getNextColor()));
        }
    }

    public void updateSizes(int arg15) {
        double v2 = 56;
        double v12 = 40;
        if(arg15 == 0) {
            this.setSizeParameters(v2, v2, 12.5, 3, 12f, 6f);
        }
        else {
            this.setSizeParameters(v12, v12, 8.75, 2.5, 10f, 5f);
        }
    }
}

