package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(value=16) @RequiresApi(value=16) class ActivityOptionsCompatJB {
    private final ActivityOptions mActivityOptions;

    private ActivityOptionsCompatJB(ActivityOptions arg1) {
        super();
        this.mActivityOptions = arg1;
    }

    public static ActivityOptionsCompatJB makeCustomAnimation(Context arg2, int arg3, int arg4) {
        return new ActivityOptionsCompatJB(ActivityOptions.makeCustomAnimation(arg2, arg3, arg4));
    }

    public static ActivityOptionsCompatJB makeScaleUpAnimation(View arg2, int arg3, int arg4, int arg5, int arg6) {
        return new ActivityOptionsCompatJB(ActivityOptions.makeScaleUpAnimation(arg2, arg3, arg4, arg5, arg6));
    }

    public static ActivityOptionsCompatJB makeThumbnailScaleUpAnimation(View arg2, Bitmap arg3, int arg4, int arg5) {
        return new ActivityOptionsCompatJB(ActivityOptions.makeThumbnailScaleUpAnimation(arg2, arg3, arg4, arg5));
    }

    public Bundle toBundle() {
        return this.mActivityOptions.toBundle();
    }

    public void update(ActivityOptionsCompatJB arg3) {
        this.mActivityOptions.update(arg3.mActivityOptions);
    }
}

