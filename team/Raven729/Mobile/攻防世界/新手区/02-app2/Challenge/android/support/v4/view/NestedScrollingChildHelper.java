package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParent;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(View arg1) {
        super();
        this.mView = arg1;
    }

    public boolean dispatchNestedFling(float arg3, float arg4, boolean arg5) {
        boolean v0 = !this.isNestedScrollingEnabled() || this.mNestedScrollingParent == null ? false : ViewParentCompat.onNestedFling(this.mNestedScrollingParent, this.mView, arg3, arg4, arg5);
        return v0;
    }

    public boolean dispatchNestedPreFling(float arg3, float arg4) {
        boolean v0 = !this.isNestedScrollingEnabled() || this.mNestedScrollingParent == null ? false : ViewParentCompat.onNestedPreFling(this.mNestedScrollingParent, this.mView, arg3, arg4);
        return v0;
    }

    public boolean dispatchNestedPreScroll(int arg7, int arg8, int[] arg9, int[] arg10) {
        int v2;
        int v3;
        boolean v0 = false;
        if((this.isNestedScrollingEnabled()) && this.mNestedScrollingParent != null) {
            if(arg7 == 0 && arg8 == 0) {
                if(arg10 != null) {
                    arg10[0] = 0;
                    arg10[1] = 0;
                }
                else {
                }

                return v0;
            }

            if(arg10 != null) {
                this.mView.getLocationInWindow(arg10);
                v3 = arg10[0];
                v2 = arg10[1];
            }
            else {
                v2 = 0;
                v3 = 0;
            }

            if(arg9 == null) {
                if(this.mTempNestedScrollConsumed == null) {
                    this.mTempNestedScrollConsumed = new int[2];
                }

                arg9 = this.mTempNestedScrollConsumed;
            }

            arg9[0] = 0;
            arg9[1] = 0;
            ViewParentCompat.onNestedPreScroll(this.mNestedScrollingParent, this.mView, arg7, arg8, arg9);
            if(arg10 != null) {
                this.mView.getLocationInWindow(arg10);
                arg10[0] -= v3;
                arg10[1] -= v2;
            }

            if(arg9[0] == 0 && arg9[1] == 0) {
                return v0;
            }

            v0 = true;
        }

        return v0;
    }

    public boolean dispatchNestedScroll(int arg11, int arg12, int arg13, int arg14, int[] arg15) {
        int v8;
        int v6;
        boolean v7 = false;
        if((this.isNestedScrollingEnabled()) && this.mNestedScrollingParent != null) {
            if(arg11 == 0 && arg12 == 0 && arg13 == 0 && arg14 == 0) {
                if(arg15 != null) {
                    arg15[0] = 0;
                    arg15[1] = 0;
                }
                else {
                }

                return v7;
            }

            if(arg15 != null) {
                this.mView.getLocationInWindow(arg15);
                int v1 = arg15[0];
                v6 = arg15[1];
                v8 = v1;
            }
            else {
                v6 = 0;
                v8 = 0;
            }

            ViewParentCompat.onNestedScroll(this.mNestedScrollingParent, this.mView, arg11, arg12, arg13, arg14);
            if(arg15 != null) {
                this.mView.getLocationInWindow(arg15);
                arg15[0] -= v8;
                arg15[1] -= v6;
            }

            v7 = true;
        }

        return v7;
    }

    public boolean hasNestedScrollingParent() {
        boolean v0 = this.mNestedScrollingParent != null ? true : false;
        return v0;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(View arg2) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean arg2) {
        if(this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }

        this.mIsNestedScrollingEnabled = arg2;
    }

    public boolean startNestedScroll(int arg5) {
        boolean v0;
        if(this.hasNestedScrollingParent()) {
            v0 = true;
        }
        else {
            if(this.isNestedScrollingEnabled()) {
                ViewParent v1 = this.mView.getParent();
                View v0_1 = this.mView;
                while(v1 != null) {
                    if(ViewParentCompat.onStartNestedScroll(v1, v0_1, this.mView, arg5)) {
                        this.mNestedScrollingParent = v1;
                        ViewParentCompat.onNestedScrollAccepted(v1, v0_1, this.mView, arg5);
                        return true;
                    }
                    else {
                        if((v1 instanceof View)) {
                            ViewParent v0_2 = v1;
                        }

                        v1 = v1.getParent();
                        continue;
                    }
                }
            }

            v0 = false;
        }

        return v0;
    }

    public void stopNestedScroll() {
        if(this.mNestedScrollingParent != null) {
            ViewParentCompat.onStopNestedScroll(this.mNestedScrollingParent, this.mView);
            this.mNestedScrollingParent = null;
        }
    }
}

