package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.SharedElementCallback$OnSharedElementsReadyListener;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.view.View;
import java.util.List;
import java.util.Map;

@TargetApi(value=23) @RequiresApi(value=23) class ActivityCompatApi23 {
    public interface OnSharedElementsReadyListenerBridge {
        void onSharedElementsReady();
    }

    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int arg1);
    }

    public abstract class SharedElementCallback23 extends SharedElementCallback21 {
        public SharedElementCallback23() {
            super();
        }

        public abstract void onSharedElementsArrived(List arg1, List arg2, OnSharedElementsReadyListenerBridge arg3);
    }

    class SharedElementCallbackImpl extends SharedElementCallback {
        private SharedElementCallback23 mCallback;

        public SharedElementCallbackImpl(SharedElementCallback23 arg1) {
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

        public void onSharedElementsArrived(List arg3, List arg4, SharedElementCallback$OnSharedElementsReadyListener arg5) {
            this.mCallback.onSharedElementsArrived(arg3, arg4, new OnSharedElementsReadyListenerBridge(arg5) {
                public void onSharedElementsReady() {
                    this.val$listener.onSharedElementsReady();
                }
            });
        }
    }

    ActivityCompatApi23() {
        super();
    }

    private static SharedElementCallback createCallback(SharedElementCallback23 arg1) {
        SharedElementCallback v0 = null;
        if(arg1 != null) {
            SharedElementCallbackImpl v0_1 = new SharedElementCallbackImpl(arg1);
        }

        return v0;
    }

    public static void requestPermissions(Activity arg1, String[] arg2, int arg3) {
        if((arg1 instanceof RequestPermissionsRequestCodeValidator)) {
            arg1.validateRequestPermissionsRequestCode(arg3);
        }

        arg1.requestPermissions(arg2, arg3);
    }

    public static void setEnterSharedElementCallback(Activity arg1, SharedElementCallback23 arg2) {
        arg1.setEnterSharedElementCallback(ActivityCompatApi23.createCallback(arg2));
    }

    public static void setExitSharedElementCallback(Activity arg1, SharedElementCallback23 arg2) {
        arg1.setExitSharedElementCallback(ActivityCompatApi23.createCallback(arg2));
    }

    public static boolean shouldShowRequestPermissionRationale(Activity arg1, String arg2) {
        return arg1.shouldShowRequestPermissionRationale(arg2);
    }
}

