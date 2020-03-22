package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import java.util.List;
import java.util.Map;

public class ActivityCompat extends ContextCompat {
    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int arg1, @NonNull String[] arg2, @NonNull int[] arg3);
    }

    class SharedElementCallback21Impl extends SharedElementCallback21 {
        private SharedElementCallback mCallback;

        public SharedElementCallback21Impl(SharedElementCallback arg1) {
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

    class SharedElementCallback23Impl extends SharedElementCallback23 {
        private SharedElementCallback mCallback;

        public SharedElementCallback23Impl(SharedElementCallback arg1) {
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

        public void onSharedElementsArrived(List arg3, List arg4, OnSharedElementsReadyListenerBridge arg5) {
            this.mCallback.onSharedElementsArrived(arg3, arg4, new OnSharedElementsReadyListener(arg5) {
                public void onSharedElementsReady() {
                    this.val$listener.onSharedElementsReady();
                }
            });
        }
    }

    protected ActivityCompat() {
        super();
    }

    private static SharedElementCallback21 createCallback(SharedElementCallback arg1) {
        SharedElementCallback21 v0 = null;
        if(arg1 != null) {
            SharedElementCallback21Impl v0_1 = new SharedElementCallback21Impl(arg1);
        }

        return v0;
    }

    private static SharedElementCallback23 createCallback23(SharedElementCallback arg1) {
        SharedElementCallback23Impl v0_1;
        SharedElementCallback23 v0 = null;
        if(arg1 != null) {
            v0_1 = new SharedElementCallback23Impl(arg1);
        }

        return ((SharedElementCallback23)v0_1);
    }

    public static void finishAffinity(Activity arg2) {
        if(Build$VERSION.SDK_INT >= 16) {
            ActivityCompatJB.finishAffinity(arg2);
        }
        else {
            arg2.finish();
        }
    }

    public static void finishAfterTransition(Activity arg2) {
        if(Build$VERSION.SDK_INT >= 21) {
            ActivityCompatApi21.finishAfterTransition(arg2);
        }
        else {
            arg2.finish();
        }
    }

    @Nullable public static Uri getReferrer(Activity arg2) {
        Parcelable v0_1;
        Uri v0;
        if(Build$VERSION.SDK_INT >= 22) {
            v0 = ActivityCompatApi22.getReferrer(arg2);
        }
        else {
            Intent v1 = arg2.getIntent();
            v0_1 = v1.getParcelableExtra("android.intent.extra.REFERRER");
            if(v0_1 == null) {
                String v0_2 = v1.getStringExtra("android.intent.extra.REFERRER_NAME");
                v0 = v0_2 != null ? Uri.parse(v0_2) : null;
            }
        }

        return ((Uri)v0_1);
    }

    public static boolean invalidateOptionsMenu(Activity arg2) {
        boolean v0;
        if(Build$VERSION.SDK_INT >= 11) {
            ActivityCompatHoneycomb.invalidateOptionsMenu(arg2);
            v0 = true;
        }
        else {
            v0 = false;
        }

        return v0;
    }

    public static void postponeEnterTransition(Activity arg2) {
        if(Build$VERSION.SDK_INT >= 21) {
            ActivityCompatApi21.postponeEnterTransition(arg2);
        }
    }

    public static void requestPermissions(@NonNull Activity arg2, @NonNull String[] arg3, @IntRange(from=0) int arg4) {
        if(Build$VERSION.SDK_INT >= 23) {
            ActivityCompatApi23.requestPermissions(arg2, arg3, arg4);
        }
        else if((arg2 instanceof OnRequestPermissionsResultCallback)) {
            new Handler(Looper.getMainLooper()).post(new Runnable(arg3, arg2, arg4) {
                public void run() {
                    int[] v1 = new int[this.val$permissions.length];
                    PackageManager v2 = this.val$activity.getPackageManager();
                    String v3 = this.val$activity.getPackageName();
                    int v4 = this.val$permissions.length;
                    int v0;
                    for(v0 = 0; v0 < v4; ++v0) {
                        v1[v0] = v2.checkPermission(this.val$permissions[v0], v3);
                    }

                    this.val$activity.onRequestPermissionsResult(this.val$requestCode, this.val$permissions, v1);
                }
            });
        }
    }

    public static void setEnterSharedElementCallback(Activity arg2, SharedElementCallback arg3) {
        if(Build$VERSION.SDK_INT >= 23) {
            ActivityCompatApi23.setEnterSharedElementCallback(arg2, ActivityCompat.createCallback23(arg3));
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            ActivityCompatApi21.setEnterSharedElementCallback(arg2, ActivityCompat.createCallback(arg3));
        }
    }

    public static void setExitSharedElementCallback(Activity arg2, SharedElementCallback arg3) {
        if(Build$VERSION.SDK_INT >= 23) {
            ActivityCompatApi23.setExitSharedElementCallback(arg2, ActivityCompat.createCallback23(arg3));
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            ActivityCompatApi21.setExitSharedElementCallback(arg2, ActivityCompat.createCallback(arg3));
        }
    }

    public static boolean shouldShowRequestPermissionRationale(@NonNull Activity arg2, @NonNull String arg3) {
        boolean v0 = Build$VERSION.SDK_INT >= 23 ? ActivityCompatApi23.shouldShowRequestPermissionRationale(arg2, arg3) : false;
        return v0;
    }

    public static void startActivityForResult(Activity arg2, Intent arg3, int arg4, @Nullable Bundle arg5) {
        if(Build$VERSION.SDK_INT >= 16) {
            ActivityCompatJB.startActivityForResult(arg2, arg3, arg4, arg5);
        }
        else {
            arg2.startActivityForResult(arg3, arg4);
        }
    }

    public static void startIntentSenderForResult(Activity arg2, IntentSender arg3, int arg4, Intent arg5, int arg6, int arg7, int arg8, @Nullable Bundle arg9) {
        if(Build$VERSION.SDK_INT >= 16) {
            ActivityCompatJB.startIntentSenderForResult(arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
        }
        else {
            arg2.startIntentSenderForResult(arg3, arg4, arg5, arg6, arg7, arg8);
        }
    }

    public static void startPostponedEnterTransition(Activity arg2) {
        if(Build$VERSION.SDK_INT >= 21) {
            ActivityCompatApi21.startPostponedEnterTransition(arg2);
        }
    }
}

