package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Pair;
import android.view.View;

public class ActivityOptionsCompat {
    @TargetApi(value=21) @RequiresApi(value=21) class ActivityOptionsImpl21 extends ActivityOptionsCompat {
        private final ActivityOptionsCompat21 mImpl;

        ActivityOptionsImpl21(ActivityOptionsCompat21 arg1) {
            super();
            this.mImpl = arg1;
        }

        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        public void update(ActivityOptionsCompat arg3) {
            if((arg3 instanceof ActivityOptionsImpl21)) {
                this.mImpl.update(((ActivityOptionsImpl21)arg3).mImpl);
            }
        }
    }

    @TargetApi(value=23) @RequiresApi(value=23) class ActivityOptionsImpl23 extends ActivityOptionsCompat {
        private final ActivityOptionsCompat23 mImpl;

        ActivityOptionsImpl23(ActivityOptionsCompat23 arg1) {
            super();
            this.mImpl = arg1;
        }

        public void requestUsageTimeReport(PendingIntent arg2) {
            this.mImpl.requestUsageTimeReport(arg2);
        }

        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        public void update(ActivityOptionsCompat arg3) {
            if((arg3 instanceof ActivityOptionsImpl23)) {
                this.mImpl.update(((ActivityOptionsImpl23)arg3).mImpl);
            }
        }
    }

    @TargetApi(value=24) @RequiresApi(value=24) class ActivityOptionsImpl24 extends ActivityOptionsCompat {
        private final ActivityOptionsCompat24 mImpl;

        ActivityOptionsImpl24(ActivityOptionsCompat24 arg1) {
            super();
            this.mImpl = arg1;
        }

        public Rect getLaunchBounds() {
            return this.mImpl.getLaunchBounds();
        }

        public void requestUsageTimeReport(PendingIntent arg2) {
            this.mImpl.requestUsageTimeReport(arg2);
        }

        public ActivityOptionsCompat setLaunchBounds(@Nullable Rect arg3) {
            return new ActivityOptionsImpl24(this.mImpl.setLaunchBounds(arg3));
        }

        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        public void update(ActivityOptionsCompat arg3) {
            if((arg3 instanceof ActivityOptionsImpl24)) {
                this.mImpl.update(((ActivityOptionsImpl24)arg3).mImpl);
            }
        }
    }

    @TargetApi(value=16) @RequiresApi(value=16) class ActivityOptionsImplJB extends ActivityOptionsCompat {
        private final ActivityOptionsCompatJB mImpl;

        ActivityOptionsImplJB(ActivityOptionsCompatJB arg1) {
            super();
            this.mImpl = arg1;
        }

        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        public void update(ActivityOptionsCompat arg3) {
            if((arg3 instanceof ActivityOptionsImplJB)) {
                this.mImpl.update(((ActivityOptionsImplJB)arg3).mImpl);
            }
        }
    }

    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    protected ActivityOptionsCompat() {
        super();
    }

    @Nullable public Rect getLaunchBounds() {
        return null;
    }

    public static ActivityOptionsCompat makeBasic() {
        ActivityOptionsCompat v0_2;
        if(Build$VERSION.SDK_INT >= 24) {
            ActivityOptionsImpl24 v0 = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeBasic());
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            ActivityOptionsImpl23 v0_1 = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeBasic());
        }
        else {
            v0_2 = new ActivityOptionsCompat();
        }

        return v0_2;
    }

    public static ActivityOptionsCompat makeClipRevealAnimation(View arg2, int arg3, int arg4, int arg5, int arg6) {
        ActivityOptionsImpl23 v0_1;
        if(Build$VERSION.SDK_INT >= 24) {
            ActivityOptionsImpl24 v0 = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeClipRevealAnimation(arg2, arg3, arg4, arg5, arg6));
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            v0_1 = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeClipRevealAnimation(arg2, arg3, arg4, arg5, arg6));
        }
        else {
            ActivityOptionsCompat v0_2 = new ActivityOptionsCompat();
        }

        return ((ActivityOptionsCompat)v0_1);
    }

    public static ActivityOptionsCompat makeCustomAnimation(Context arg2, int arg3, int arg4) {
        ActivityOptionsImpl24 v0;
        if(Build$VERSION.SDK_INT >= 24) {
            v0 = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeCustomAnimation(arg2, arg3, arg4));
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            ActivityOptionsImpl23 v0_1 = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeCustomAnimation(arg2, arg3, arg4));
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            ActivityOptionsImpl21 v0_2 = new ActivityOptionsImpl21(ActivityOptionsCompat21.makeCustomAnimation(arg2, arg3, arg4));
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            ActivityOptionsImplJB v0_3 = new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(arg2, arg3, arg4));
        }
        else {
            ActivityOptionsCompat v0_4 = new ActivityOptionsCompat();
        }

        return ((ActivityOptionsCompat)v0);
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View arg2, int arg3, int arg4, int arg5, int arg6) {
        ActivityOptionsImpl24 v0;
        if(Build$VERSION.SDK_INT >= 24) {
            v0 = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeScaleUpAnimation(arg2, arg3, arg4, arg5, arg6));
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            ActivityOptionsImpl23 v0_1 = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeScaleUpAnimation(arg2, arg3, arg4, arg5, arg6));
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            ActivityOptionsImpl21 v0_2 = new ActivityOptionsImpl21(ActivityOptionsCompat21.makeScaleUpAnimation(arg2, arg3, arg4, arg5, arg6));
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            ActivityOptionsImplJB v0_3 = new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(arg2, arg3, arg4, arg5, arg6));
        }
        else {
            ActivityOptionsCompat v0_4 = new ActivityOptionsCompat();
        }

        return ((ActivityOptionsCompat)v0);
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity arg2, View arg3, String arg4) {
        ActivityOptionsImpl21 v0_2;
        if(Build$VERSION.SDK_INT >= 24) {
            ActivityOptionsImpl24 v0 = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeSceneTransitionAnimation(arg2, arg3, arg4));
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            ActivityOptionsImpl23 v0_1 = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeSceneTransitionAnimation(arg2, arg3, arg4));
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            v0_2 = new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(arg2, arg3, arg4));
        }
        else {
            ActivityOptionsCompat v0_3 = new ActivityOptionsCompat();
        }

        return ((ActivityOptionsCompat)v0_2);
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity arg4, Pair[] arg5) {
        ActivityOptionsImpl24 v0_1;
        View[] v1_1;
        String[] v0 = null;
        if(Build$VERSION.SDK_INT >= 21) {
            if(arg5 != null) {
                View[] v3 = new View[arg5.length];
                String[] v2 = new String[arg5.length];
                int v1;
                for(v1 = 0; v1 < arg5.length; ++v1) {
                    v3[v1] = arg5[v1].first;
                    v2[v1] = arg5[v1].second;
                }

                v0 = v2;
                v1_1 = v3;
            }
            else {
                v1_1 = ((View[])v0);
            }

            if(Build$VERSION.SDK_INT >= 24) {
                v0_1 = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeSceneTransitionAnimation(arg4, v1_1, v0));
                goto label_31;
            }

            if(Build$VERSION.SDK_INT >= 23) {
                ActivityOptionsImpl23 v0_2 = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeSceneTransitionAnimation(arg4, v1_1, v0));
                goto label_31;
            }

            ActivityOptionsImpl21 v0_3 = new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(arg4, v1_1, v0));
        }
        else {
            ActivityOptionsCompat v0_4 = new ActivityOptionsCompat();
        }

    label_31:
        return ((ActivityOptionsCompat)v0_1);
    }

    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        ActivityOptionsCompat v0_3;
        if(Build$VERSION.SDK_INT >= 24) {
            ActivityOptionsImpl24 v0 = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeTaskLaunchBehind());
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            ActivityOptionsImpl23 v0_1 = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeTaskLaunchBehind());
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            ActivityOptionsImpl21 v0_2 = new ActivityOptionsImpl21(ActivityOptionsCompat21.makeTaskLaunchBehind());
        }
        else {
            v0_3 = new ActivityOptionsCompat();
        }

        return v0_3;
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View arg2, Bitmap arg3, int arg4, int arg5) {
        ActivityOptionsImpl21 v0_2;
        if(Build$VERSION.SDK_INT >= 24) {
            ActivityOptionsImpl24 v0 = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeThumbnailScaleUpAnimation(arg2, arg3, arg4, arg5));
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            ActivityOptionsImpl23 v0_1 = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeThumbnailScaleUpAnimation(arg2, arg3, arg4, arg5));
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            v0_2 = new ActivityOptionsImpl21(ActivityOptionsCompat21.makeThumbnailScaleUpAnimation(arg2, arg3, arg4, arg5));
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            ActivityOptionsImplJB v0_3 = new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(arg2, arg3, arg4, arg5));
        }
        else {
            ActivityOptionsCompat v0_4 = new ActivityOptionsCompat();
        }

        return ((ActivityOptionsCompat)v0_2);
    }

    public void requestUsageTimeReport(PendingIntent arg1) {
    }

    public ActivityOptionsCompat setLaunchBounds(@Nullable Rect arg2) {
        return null;
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat arg1) {
    }
}

