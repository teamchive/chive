package android.support.v4.widget;

import android.content.Context;
import android.os.Build$VERSION;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

public final class ScrollerCompat {
    private final boolean mIsIcsOrNewer;
    OverScroller mScroller;

    ScrollerCompat(boolean arg2, Context arg3, Interpolator arg4) {
        super();
        this.mIsIcsOrNewer = arg2;
        OverScroller v0 = arg4 != null ? new OverScroller(arg3, arg4) : new OverScroller(arg3);
        this.mScroller = v0;
    }

    public void abortAnimation() {
        this.mScroller.abortAnimation();
    }

    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    public static ScrollerCompat create(Context arg3, Interpolator arg4) {
        boolean v0 = Build$VERSION.SDK_INT >= 14 ? true : false;
        return new ScrollerCompat(v0, arg3, arg4);
    }

    public static ScrollerCompat create(Context arg1) {
        return ScrollerCompat.create(arg1, null);
    }

    public void fling(int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18, int arg19, int arg20, int arg21) {
        this.mScroller.fling(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21);
    }

    public void fling(int arg10, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17) {
        this.mScroller.fling(arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
    }

    public float getCurrVelocity() {
        float v0 = this.mIsIcsOrNewer ? ScrollerCompatIcs.getCurrVelocity(this.mScroller) : 0f;
        return v0;
    }

    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    public int getFinalX() {
        return this.mScroller.getFinalX();
    }

    public int getFinalY() {
        return this.mScroller.getFinalY();
    }

    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    public boolean isOverScrolled() {
        return this.mScroller.isOverScrolled();
    }

    public void notifyHorizontalEdgeReached(int arg2, int arg3, int arg4) {
        this.mScroller.notifyHorizontalEdgeReached(arg2, arg3, arg4);
    }

    public void notifyVerticalEdgeReached(int arg2, int arg3, int arg4) {
        this.mScroller.notifyVerticalEdgeReached(arg2, arg3, arg4);
    }

    public boolean springBack(int arg8, int arg9, int arg10, int arg11, int arg12, int arg13) {
        return this.mScroller.springBack(arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public void startScroll(int arg2, int arg3, int arg4, int arg5) {
        this.mScroller.startScroll(arg2, arg3, arg4, arg5);
    }

    public void startScroll(int arg7, int arg8, int arg9, int arg10, int arg11) {
        this.mScroller.startScroll(arg7, arg8, arg9, arg10, arg11);
    }
}

