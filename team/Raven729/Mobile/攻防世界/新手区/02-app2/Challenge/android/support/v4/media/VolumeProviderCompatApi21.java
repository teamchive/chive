package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.VolumeProvider;
import android.support.annotation.RequiresApi;

@TargetApi(value=21) @RequiresApi(value=21) class VolumeProviderCompatApi21 {
    public interface Delegate {
        void onAdjustVolume(int arg1);

        void onSetVolumeTo(int arg1);
    }

    VolumeProviderCompatApi21() {
        super();
    }

    public static Object createVolumeProvider(int arg1, int arg2, int arg3, Delegate arg4) {
        return new VolumeProvider(arg1, arg2, arg3, arg4) {
            public void onAdjustVolume(int arg2) {
                this.val$delegate.onAdjustVolume(arg2);
            }

            public void onSetVolumeTo(int arg2) {
                this.val$delegate.onSetVolumeTo(arg2);
            }
        };
    }

    public static void setCurrentVolume(Object arg0, int arg1) {
        ((VolumeProvider)arg0).setCurrentVolume(arg1);
    }
}

