package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

final class SwipeProgressBar {
    private static final int ANIMATION_DURATION_MS = 2000;
    private static final int COLOR1 = 0xB3000000;
    private static final int COLOR2 = 0x80000000;
    private static final int COLOR3 = 0x4D000000;
    private static final int COLOR4 = 0x1A000000;
    private static final int FINISH_ANIMATION_DURATION_MS = 1000;
    private static final Interpolator INTERPOLATOR;
    private Rect mBounds;
    private final RectF mClipRect;
    private int mColor1;
    private int mColor2;
    private int mColor3;
    private int mColor4;
    private long mFinishTime;
    private final Paint mPaint;
    private View mParent;
    private boolean mRunning;
    private long mStartTime;
    private float mTriggerPercentage;

    static {
        SwipeProgressBar.INTERPOLATOR = new FastOutSlowInInterpolator();
    }

    SwipeProgressBar(View arg2) {
        super();
        this.mPaint = new Paint();
        this.mClipRect = new RectF();
        this.mBounds = new Rect();
        this.mParent = arg2;
        this.mColor1 = 0xB3000000;
        this.mColor2 = 0x80000000;
        this.mColor3 = 0x4D000000;
        this.mColor4 = 0x1A000000;
    }

    void draw(Canvas arg21) {
        int v2_1;
        int v9;
        int v3 = this.mBounds.width();
        int v4 = this.mBounds.height();
        int v10 = v3 / 2;
        int v11 = v4 / 2;
        int v8 = arg21.save();
        arg21.clipRect(this.mBounds);
        if((this.mRunning) || this.mFinishTime > 0) {
            long v6 = AnimationUtils.currentAnimationTimeMillis();
            long v12 = (v6 - this.mStartTime) % 2000;
            long v14 = (v6 - this.mStartTime) / 2000;
            float v12_1 = (((float)v12)) / 20f;
            if(this.mRunning) {
                v9 = 0;
            }
            else if(v6 - this.mFinishTime >= 1000) {
                this.mFinishTime = 0;
                return;
            }
            else {
                float v2 = SwipeProgressBar.INTERPOLATOR.getInterpolation((((float)((v6 - this.mFinishTime) % 1000))) / 10f / 100f) * (((float)(v3 / 2)));
                this.mClipRect.set((((float)v10)) - v2, 0f, v2 + (((float)v10)), ((float)v4));
                arg21.saveLayerAlpha(this.mClipRect, 0, 0);
                v9 = 1;
            }

            if(v14 == 0) {
                arg21.drawColor(this.mColor1);
            }
            else {
                if(v12_1 >= 0f && v12_1 < 25f) {
                    arg21.drawColor(this.mColor4);
                    goto label_87;
                }

                if(v12_1 >= 25f && v12_1 < 50f) {
                    arg21.drawColor(this.mColor1);
                    goto label_87;
                }

                if(v12_1 >= 50f && v12_1 < 75f) {
                    arg21.drawColor(this.mColor2);
                    goto label_87;
                }

                arg21.drawColor(this.mColor3);
            }

        label_87:
            if(v12_1 >= 0f && v12_1 <= 25f) {
                this.drawCircle(arg21, ((float)v10), ((float)v11), this.mColor1, (25f + v12_1) * 2f / 100f);
            }

            if(v12_1 >= 0f && v12_1 <= 50f) {
                this.drawCircle(arg21, ((float)v10), ((float)v11), this.mColor2, 2f * v12_1 / 100f);
            }

            if(v12_1 >= 25f && v12_1 <= 75f) {
                this.drawCircle(arg21, ((float)v10), ((float)v11), this.mColor3, (v12_1 - 25f) * 2f / 100f);
            }

            if(v12_1 >= 50f && v12_1 <= 100f) {
                this.drawCircle(arg21, ((float)v10), ((float)v11), this.mColor4, (v12_1 - 50f) * 2f / 100f);
            }

            if(v12_1 >= 75f && v12_1 <= 100f) {
                this.drawCircle(arg21, ((float)v10), ((float)v11), this.mColor1, (v12_1 - 75f) * 2f / 100f);
            }

            if(this.mTriggerPercentage <= 0f || v9 == 0) {
                v2_1 = v8;
            }
            else {
                arg21.restoreToCount(v8);
                v2_1 = arg21.save();
                arg21.clipRect(this.mBounds);
                this.drawTrigger(arg21, v10, v11);
            }

            ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
            v8 = v2_1;
        label_201:
            arg21.restoreToCount(v8);
        }
        else {
            if(this.mTriggerPercentage <= 0f) {
            }
            else if((((double)this.mTriggerPercentage)) <= 1) {
                this.drawTrigger(arg21, v10, v11);
            }
            else {
            }

            goto label_201;
        }
    }

    private void drawCircle(Canvas arg3, float arg4, float arg5, int arg6, float arg7) {
        this.mPaint.setColor(arg6);
        arg3.save();
        arg3.translate(arg4, arg5);
        float v0 = SwipeProgressBar.INTERPOLATOR.getInterpolation(arg7);
        arg3.scale(v0, v0);
        arg3.drawCircle(0f, 0f, arg4, this.mPaint);
        arg3.restore();
    }

    private void drawTrigger(Canvas arg5, int arg6, int arg7) {
        this.mPaint.setColor(this.mColor1);
        arg5.drawCircle(((float)arg6), ((float)arg7), (((float)arg6)) * this.mTriggerPercentage, this.mPaint);
    }

    boolean isRunning() {
        boolean v0 = (this.mRunning) || this.mFinishTime > 0 ? true : false;
        return v0;
    }

    void setBounds(int arg2, int arg3, int arg4, int arg5) {
        this.mBounds.left = arg2;
        this.mBounds.top = arg3;
        this.mBounds.right = arg4;
        this.mBounds.bottom = arg5;
    }

    void setColorScheme(int arg1, int arg2, int arg3, int arg4) {
        this.mColor1 = arg1;
        this.mColor2 = arg2;
        this.mColor3 = arg3;
        this.mColor4 = arg4;
    }

    void setTriggerPercentage(float arg6) {
        this.mTriggerPercentage = arg6;
        this.mStartTime = 0;
        ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
    }

    void start() {
        if(!this.mRunning) {
            this.mTriggerPercentage = 0f;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = true;
            this.mParent.postInvalidate();
        }
    }

    void stop() {
        if(this.mRunning) {
            this.mTriggerPercentage = 0f;
            this.mFinishTime = AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = false;
            this.mParent.postInvalidate();
        }
    }
}

