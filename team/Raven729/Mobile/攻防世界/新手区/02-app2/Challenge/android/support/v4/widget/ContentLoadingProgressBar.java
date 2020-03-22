package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    class android.support.v4.widget.ContentLoadingProgressBar$1 implements Runnable {
        android.support.v4.widget.ContentLoadingProgressBar$1(ContentLoadingProgressBar arg1) {
            ContentLoadingProgressBar.this = arg1;
            super();
        }

        public void run() {
            ContentLoadingProgressBar.this.mPostedHide = false;
            ContentLoadingProgressBar.this.mStartTime = -1;
            ContentLoadingProgressBar.this.setVisibility(8);
        }
    }

    class android.support.v4.widget.ContentLoadingProgressBar$2 implements Runnable {
        android.support.v4.widget.ContentLoadingProgressBar$2(ContentLoadingProgressBar arg1) {
            ContentLoadingProgressBar.this = arg1;
            super();
        }

        public void run() {
            ContentLoadingProgressBar.this.mPostedShow = false;
            if(!ContentLoadingProgressBar.this.mDismissed) {
                ContentLoadingProgressBar.this.mStartTime = System.currentTimeMillis();
                ContentLoadingProgressBar.this.setVisibility(0);
            }
        }
    }

    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    boolean mDismissed;
    boolean mPostedHide;
    boolean mPostedShow;
    long mStartTime;

    public ContentLoadingProgressBar(Context arg2) {
        this(arg2, null);
    }

    public ContentLoadingProgressBar(Context arg4, AttributeSet arg5) {
        super(arg4, arg5, 0);
        this.mStartTime = -1;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.mDelayedHide = new android.support.v4.widget.ContentLoadingProgressBar$1(this);
        this.mDelayedShow = new android.support.v4.widget.ContentLoadingProgressBar$2(this);
    }

    public void hide() {
        long v8 = 500;
        this.mDismissed = true;
        this.removeCallbacks(this.mDelayedShow);
        long v0 = System.currentTimeMillis() - this.mStartTime;
        if(v0 >= v8 || this.mStartTime == -1) {
            this.setVisibility(8);
        }
        else if(!this.mPostedHide) {
            this.postDelayed(this.mDelayedHide, v8 - v0);
            this.mPostedHide = true;
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.removeCallbacks();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks();
    }

    private void removeCallbacks() {
        this.removeCallbacks(this.mDelayedHide);
        this.removeCallbacks(this.mDelayedShow);
    }

    public void show() {
        this.mStartTime = -1;
        this.mDismissed = false;
        this.removeCallbacks(this.mDelayedHide);
        if(!this.mPostedShow) {
            this.postDelayed(this.mDelayedShow, 500);
            this.mPostedShow = true;
        }
    }
}

