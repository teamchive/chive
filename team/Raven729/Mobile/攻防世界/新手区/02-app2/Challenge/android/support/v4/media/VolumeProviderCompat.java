package android.support.v4.media;

import android.os.Build$VERSION;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat {
    public abstract class Callback {
        public Callback() {
            super();
        }

        public abstract void onVolumeChanged(VolumeProviderCompat arg1);
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface ControlType {
    }

    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private Object mVolumeProviderObj;

    public VolumeProviderCompat(int arg1, int arg2, int arg3) {
        super();
        this.mControlType = arg1;
        this.mMaxVolume = arg2;
        this.mCurrentVolume = arg3;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public Object getVolumeProvider() {
        Object v0;
        if(this.mVolumeProviderObj != null || Build$VERSION.SDK_INT < 21) {
            v0 = this.mVolumeProviderObj;
        }
        else {
            this.mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, new Delegate() {
                public void onAdjustVolume(int arg2) {
                    VolumeProviderCompat.this.onAdjustVolume(arg2);
                }

                public void onSetVolumeTo(int arg2) {
                    VolumeProviderCompat.this.onSetVolumeTo(arg2);
                }
            });
            v0 = this.mVolumeProviderObj;
        }

        return v0;
    }

    public void onAdjustVolume(int arg1) {
    }

    public void onSetVolumeTo(int arg1) {
    }

    public void setCallback(Callback arg1) {
        this.mCallback = arg1;
    }

    public final void setCurrentVolume(int arg2) {
        this.mCurrentVolume = arg2;
        Object v0 = this.getVolumeProvider();
        if(v0 != null) {
            VolumeProviderCompatApi21.setCurrentVolume(v0, arg2);
        }

        if(this.mCallback != null) {
            this.mCallback.onVolumeChanged(this);
        }
    }
}

