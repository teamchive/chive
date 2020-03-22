package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.view.View;
import java.util.List;
import java.util.Map;

@TargetApi(value=21) @RequiresApi(value=21) class ActivityCompatApi21 {
    public abstract class SharedElementCallback21 {
        public SharedElementCallback21() {
            super();
        }

        public abstract Parcelable onCaptureSharedElementSnapshot(View arg1, Matrix arg2, RectF arg3);

        public abstract View onCreateSnapshotView(Context arg1, Parcelable arg2);

        public abstract void onMapSharedElements(List arg1, Map arg2);

        public abstract void onRejectSharedElements(List arg1);

        public abstract void onSharedElementEnd(List arg1, List arg2, List arg3);

        public abstract void onSharedElementStart(List arg1, List arg2, List arg3);
    }

    class SharedElementCallbackImpl extends SharedElementCallback {
        private SharedElementCallback21 mCallback;

        public SharedElementCallbackImpl(SharedElementCallback21 arg1) {
            super();
            this.mCallback = arg1;
        }

        public Parcelable onCaptureSharedElementSnapshot(View arg2, Matrix arg3, RectF arg4) {
            return this.mCallback.onCaptureSharedElementSnapshot(arg2, arg3, arg4);
        }

        public View onCreateSnapshotView(Context arg2, Parcelable arg3) {
            return this.mCallback.onCreateSnapshotView(arg2, arg3);
        }

        public void onMapSharedElements(List arg2, Map arg3) {
            this.mCallback.onMapSharedElements(arg2, arg3);
        }

        public void onRejectSharedElements(List arg2) {
            this.mCallback.onRejectSharedElements(arg2);
        }

        public void onSharedElementEnd(List arg2, List arg3, List arg4) {
            this.mCallback.onSharedElementEnd(arg2, arg3, arg4);
        }

        public void onSharedElementStart(List arg2, List arg3, List arg4) {
            this.mCallback.onSharedElementStart(arg2, arg3, arg4);
        }
    }

    ActivityCompatApi21() {
        super();
    }

    private static SharedElementCallback createCallback(SharedElementCallback21 arg1) {
        SharedElementCallback v0 = null;
        if(arg1 != null) {
            SharedElementCallbackImpl v0_1 = new SharedElementCallbackImpl(arg1);
        }

        return v0;
    }

    public static void finishAfterTransition(Activity arg0) {
        arg0.finishAfterTransition();
    }

    public static void postponeEnterTransition(Activity arg0) {
        arg0.postponeEnterTransition();
    }

    public static void setEnterSharedElementCallback(Activity arg1, SharedElementCallback21 arg2) {
        arg1.setEnterSharedElementCallback(ActivityCompatApi21.createCallback(arg2));
    }

    public static void setExitSharedElementCallback(Activity arg1, SharedElementCallback21 arg2) {
        arg1.setExitSharedElementCallback(ActivityCompatApi21.createCallback(arg2));
    }

    public static void startPostponedEnterTransition(Activity arg0) {
        arg0.startPostponedEnterTransition();
    }
}

