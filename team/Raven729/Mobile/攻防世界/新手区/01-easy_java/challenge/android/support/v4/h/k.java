package android.support.v4.h;

import android.view.View;

public interface k {
    boolean onNestedFling(View arg1, float arg2, float arg3, boolean arg4);

    boolean onNestedPreFling(View arg1, float arg2, float arg3);

    void onNestedPreScroll(View arg1, int arg2, int arg3, int[] arg4);

    void onNestedScroll(View arg1, int arg2, int arg3, int arg4, int arg5);

    void onNestedScrollAccepted(View arg1, View arg2, int arg3);

    boolean onStartNestedScroll(View arg1, View arg2, int arg3);

    void onStopNestedScroll(View arg1);
}

