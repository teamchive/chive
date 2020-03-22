package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Pair;
import android.view.View;

@TargetApi(value=21) @RequiresApi(value=21) class ActivityOptionsCompat21 {
    private final ActivityOptions mActivityOptions;

    private ActivityOptionsCompat21(ActivityOptions arg1) {
        super();
        this.mActivityOptions = arg1;
    }

    public static ActivityOptionsCompat21 makeCustomAnimation(Context arg2, int arg3, int arg4) {
        return new ActivityOptionsCompat21(ActivityOptions.makeCustomAnimation(arg2, arg3, arg4));
    }

    public static ActivityOptionsCompat21 makeScaleUpAnimation(View arg2, int arg3, int arg4, int arg5, int arg6) {
        return new ActivityOptionsCompat21(ActivityOptions.makeScaleUpAnimation(arg2, arg3, arg4, arg5, arg6));
    }

    public static ActivityOptionsCompat21 makeSceneTransitionAnimation(Activity arg2, View arg3, String arg4) {
        return new ActivityOptionsCompat21(ActivityOptions.makeSceneTransitionAnimation(arg2, arg3, arg4));
    }

    public static ActivityOptionsCompat21 makeSceneTransitionAnimation(Activity arg4, View[] arg5, String[] arg6) {
        Pair[] v0 = null;
        if(arg5 != null) {
            Pair[] v1 = new Pair[arg5.length];
            int v0_1;
            for(v0_1 = 0; v0_1 < v1.length; ++v0_1) {
                v1[v0_1] = Pair.create(arg5[v0_1], arg6[v0_1]);
            }

            v0 = v1;
        }

        return new ActivityOptionsCompat21(ActivityOptions.makeSceneTransitionAnimation(arg4, v0));
    }

    public static ActivityOptionsCompat21 makeTaskLaunchBehind() {
        return new ActivityOptionsCompat21(ActivityOptions.makeTaskLaunchBehind());
    }

    public static ActivityOptionsCompat21 makeThumbnailScaleUpAnimation(View arg2, Bitmap arg3, int arg4, int arg5) {
        return new ActivityOptionsCompat21(ActivityOptions.makeThumbnailScaleUpAnimation(arg2, arg3, arg4, arg5));
    }

    public Bundle toBundle() {
        return this.mActivityOptions.toBundle();
    }

    public void update(ActivityOptionsCompat21 arg3) {
        this.mActivityOptions.update(arg3.mActivityOptions);
    }
}

